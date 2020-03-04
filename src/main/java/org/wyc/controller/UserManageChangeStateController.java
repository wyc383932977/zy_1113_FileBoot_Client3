package org.wyc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wyc.model.ClientUser;
import org.wyc.service.impl.UserManageServiceImpl;
import org.wyc.utils.MyFactory;

public class UserManageChangeStateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr=req.getParameter("id");
		Integer id=Integer.parseInt(idStr);
		UserManageServiceImpl service=(UserManageServiceImpl)MyFactory.getF().getObject("UserManageServiceImpl");
		ClientUser user=service.getClientUserById(id);
		Integer state=user.getState();
		if(state==1) {
			state=2;
		}else if(state==2){
			state=1;
		}
		String msg=service.changeUserState(state, id);
		PrintWriter out=resp.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
}
