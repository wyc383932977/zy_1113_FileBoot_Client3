package org.wyc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{
	
	public EncodeFilter() {//必须用public
		System.out.println("过滤器创建");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//销毁
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//执行
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
//		System.out.println("一级过滤:编码请求");
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		//初始化
	}

}
