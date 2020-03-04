package org.wyc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.model.ClientUser;
import org.wyc.service.UserManageService;
import org.wyc.utils.PageBean;
@Controller
public class UserManageController{
	
	@Autowired
	private UserManageService userManageService;
	
	@RequestMapping("userManageShow.html")
	public ModelAndView userManageViewShow(String account,String newCurrPage,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("account="+account);
		if(newCurrPage == null || "".equals(newCurrPage)) {
			newCurrPage="1";
		}
		System.out.println("bbb");
		List<ClientUser> list=userManageService.getUserList(account,Integer.parseInt(newCurrPage));
		System.out.println("list="+list);
		PageBean pageBean=userManageService.getCount(account, Integer.parseInt(newCurrPage));
		System.out.println("pageBean="+pageBean);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userManage");
		mv.addObject("pageBean", pageBean);
		mv.addObject("list", list);
		mv.addObject("account", account);
		return mv;
	}
}
