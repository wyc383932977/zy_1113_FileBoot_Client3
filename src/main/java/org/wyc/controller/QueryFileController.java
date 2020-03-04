package org.wyc.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.model.ClientUser;
import org.wyc.model.File;
import org.wyc.model.ScoreLog;
import org.wyc.service.QueryFileService;
import org.wyc.utils.MyBatisUtil;

@Controller
public class QueryFileController {
	
	@Autowired
	private QueryFileService queryFileService;
	
	@RequestMapping("queryFileShow.html")
	public ModelAndView queryFile(String fileName) {
		System.out.println("ppp");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("queryFile");
		List<File> fileList = queryFileService.getFileList(fileName);
		mv.addObject("list", fileList);
		mv.addObject("fileName", fileName);
		System.out.println("ppp2");
		return mv;

	}
	@RequestMapping("/downloadFile.html")
	public ResponseEntity<byte[]> downLoadFile(String url,String fileScore,HttpServletRequest request) {
		SqlSession sqlSession=MyBatisUtil.getSession();
		//获取文件下载地址
		java.io.File file=new java.io.File(url);
		byte[] body=null;
		ResponseEntity<byte[]> entity=null;
		try {
			InputStream is=new FileInputStream(file);
			body=new byte[is.available()];
			is.read(body);
			HttpHeaders headers=new HttpHeaders();
			headers.add("Content-Disposition", "attchement;filename="+file.getName());
			HttpStatus statusCode=HttpStatus.OK;
			entity=new ResponseEntity<byte[]>(body,headers,statusCode);
			//获取客户分值
			HttpSession session=request.getSession();
			Integer userId=(Integer)session.getAttribute("uId");
			ClientUser clientUser = queryFileService.getUserInfoById(userId);
			Integer score=clientUser.getScore();
			//计算扣除下载分后的分数
			Integer fileScoreInt=Integer.parseInt(fileScore);
			Integer nowScore=score-fileScoreInt;
			//修改用户分值
			Integer scoreChangeResult = queryFileService.scoreChange(nowScore, userId);
			//插入分值日志
			ScoreLog scoreLog=new ScoreLog();
			scoreLog.setUserId(userId);
			scoreLog.setFileId(null);
			scoreLog.setIncident("下载文件");
			scoreLog.setScore(-fileScoreInt);
			Integer insertScoreLogResult = queryFileService.insertScoreLog(scoreLog);
			//执行或回滚
			if(scoreChangeResult>0 &&insertScoreLogResult>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}
}
