package org.wyc.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;


public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpReq=(HttpServletRequest)req;
		HttpServletResponse httpResp=(HttpServletResponse)resp;
		//判断是否为ajax请求,默认不是
		boolean isAjaxRequest=false;
		if (httpReq.getHeader("x-requested-with")!=null &&httpReq.getHeader("x-requested-with").equals("XMLHttpRequest")) {
			isAjaxRequest=true;
		}
		HttpSession session=httpReq.getSession();
		System.out.println("id检查是否存在,id="+session.getAttribute("auId"));
		if (session.getAttribute("auId")==null) {//id为空
			if (!isAjaxRequest) {//id为空,且执行页面跳转
				System.out.println("id丢失,页面跳转");
				session.setAttribute("IdLost", "用户ID丢失");
				String contextPath=httpReq.getContextPath();
				httpResp.sendRedirect(contextPath+"/IdLost.jsp");
			}else {//id为空,且执行ajax回复
				System.out.println("ajax回复");
				 httpResp.setHeader("noAuthentication","true");//可加可不加,标识是未保护的信息
				 //在上传文件后，会返回response，header中的content-type为*/*
				 //这样设置，通常会导致客户端（浏览器）不能识别内容编码，
				 //如果客户端(浏览器)采用非UTF-8方式(比如gbk)解码，客户端就会产生乱码问题。
				 httpResp.setContentType("application/json;charser=UTF-8");//必须加
				 
				 JSONObject jsonObj=new JSONObject();
				 jsonObj.put("msg", "timeout");
				 jsonObj.put("info", "登录已失效,请刷新页面或重新登录!");
				 
				 PrintWriter out=httpResp.getWriter();
				 out.print(jsonObj.toString());
				 out.flush();
				 out.close();
				 httpResp.flushBuffer();
			}
		}else {//id存在,放行
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
