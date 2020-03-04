package org.wyc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.model.ClientUser;
import org.wyc.service.UserManageService;

@Controller
public class UserInfoController {
	
	@Autowired
	private UserManageService userManageService;
	
	@RequestMapping("infoShow.html")
	public ModelAndView getScore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Integer id=(Integer)session.getAttribute("uId");
		ClientUser clientUser = userManageService.getClientUserById(id);
		Integer score=clientUser.getScore();
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Info");
		mv.addObject("score", score);
		
		return mv;
	}
}
