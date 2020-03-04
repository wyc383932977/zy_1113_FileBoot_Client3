package org.wyc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.model.File;
import org.wyc.service.MyFileService;
import org.wyc.service.QueryFileService;

@Controller
public class MyFileController {
	
	@Autowired
	private MyFileService myFileService;
	
	@RequestMapping("queryMyFileShow.html")
	public ModelAndView queryMyFile(String fileName,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Integer userId=(Integer)session.getAttribute("uId");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("myFileShow");
		List<File> fileList = myFileService.getMyFileList(fileName,userId);
		mv.addObject("list", fileList);
		mv.addObject("fileName", fileName);
		System.out.println("ppp2");
		return mv;

	}
}
