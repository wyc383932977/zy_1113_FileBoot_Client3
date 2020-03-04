package org.wyc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.model.AdminUser;
import org.wyc.model.Menu;
import org.wyc.service.MainViewShowService;

@Controller
public class MainViewShowController{

	@Autowired
	private MainViewShowService mainViewShowService;
	
	@RequestMapping("mainViewShow.html")
	public ModelAndView mainViewShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Integer uId=(Integer)session.getAttribute("uId");
		if(uId==null) {
			System.out.println("uId不存在");
			session.setAttribute("uId", 2);//测试
			uId=2;
		}
		System.out.println("uId="+uId);

		//获取后台用户拥有的角色
//		AdminRoleServiceImpl impl2=(AdminRoleServiceImpl)MyFactory.getF().getObject("AdminRoleServiceImpl");
//		List<AdminRole> roles=impl2.getOneRoleList(auId);
//		req.setAttribute("roles", roles);
//		System.out.println("roles="+roles);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("mainView");
		//调用service,根据用户ID查询菜单列表,并放入request中
		List<Menu> list=mainViewShowService.getMenuList(uId);
		mv.addObject("adminMenu", list);
		System.out.println("list="+list);
		//获取后台用户的名字
		AdminUser adminUser=mainViewShowService.getAdminUserById(uId);
		System.out.println("adminuser="+adminUser.getAccount());
		mv.addObject("adminUserName", adminUser.getAccount()); 
		return mv;
	}
}
