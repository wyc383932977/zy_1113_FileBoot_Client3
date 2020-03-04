package org.wyc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wyc.model.AdminUser;
import org.wyc.model.ClientUser;
import org.wyc.service.impl.LoginServiceImpl;
import org.wyc.utils.MyFactory;


public class LoginRegisterController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account=req.getParameter("account");
		String password=req.getParameter("password");
		
		AdminUser user=new AdminUser();
		user.setAccount(account);
		user.setName(account);
		user.setPassword(password);
		user.setState(1);
		user.setCreateTime(new Date());
		
		LoginServiceImpl userService = (LoginServiceImpl) MyFactory.getF().getObject("LoginServiceImpl");
//		String msg=userService.register(user);
		
//		PrintWriter out=resp.getWriter();
//		out.print();
//		out.flush();
//		out.close();
		
	}
}
