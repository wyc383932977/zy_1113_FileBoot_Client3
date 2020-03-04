package org.wyc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.service.DownAndLoadFileService;

import com.alibaba.fastjson.JSONObject;

@Controller
public class DownAndLoadFileController {

	@Autowired
	private DownAndLoadFileService downAndLoadFileService;

	@RequestMapping("downAndLoadFileShow.html")
	public ModelAndView downAndLoadFileShow(HttpServletRequest req, HttpServletResponse resp) {

		ModelAndView mv = new ModelAndView();
		HttpSession session=req.getSession();
		Integer userId=(Integer)session.getAttribute("uId");
		System.out.println("userId="+userId);
		List<org.wyc.model.File> list=downAndLoadFileService.getFileList(userId);
		mv.addObject("list", list);
		mv.setViewName("downAndLoadFile");
		return mv;
	}

	@RequestMapping("uploadFile.ajax")
	@ResponseBody
	public JSONObject uploadFile(String fileScore,MultipartFile oneFile, HttpServletRequest req) {
		String isSucc = "";
		HttpSession session=req.getSession();
		Integer userId=(Integer)session.getAttribute("uId");
		JSONObject jsonObject = new JSONObject();
		if (oneFile.isEmpty()) {
			System.out.println("文件为空");
		} else {
			String name = oneFile.getOriginalFilename();
			// 动态获取保存地址
			String rootPath = req.getSession().getServletContext().getRealPath("\\") + "file\\";
			File file2 = new File(rootPath + name);
			if (!file2.exists()) {
				file2.mkdirs();
				System.out.println(rootPath);
			}
			try {
				oneFile.transferTo(file2);
				org.wyc.model.File file3 = new org.wyc.model.File();
				file3.setName(name);
				file3.setUrl(rootPath+name);
				file3.setUserId(userId);
				file3.setDate(new Date());
				file3.setState(1);
				Integer fileScoreInt=Integer.parseInt(fileScore);
				file3.setFileScore(fileScoreInt);
				System.out.println("file3="+file3.toString());
				isSucc = downAndLoadFileService.loadFile(file3);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				isSucc = "fail";
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isSucc = "fail";
			}
			System.out.println("isSucc="+isSucc);
			jsonObject.put("msg", isSucc);
		}
		return jsonObject;
	}
	
}
