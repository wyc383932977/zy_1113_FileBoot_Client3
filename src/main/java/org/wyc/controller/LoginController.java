package org.wyc.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wyc.model.ClientUser;
import org.wyc.service.LoginService;
import org.wyc.utils.GraphicHelper;

import com.alibaba.fastjson.JSONObject;
@Controller
public class LoginController{
	//验证码
	private static final long serialVersionUID = 3398560501558431737L;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("login.ajax")
	@ResponseBody
	public JSONObject login(HttpServletRequest req,String account,String password,String qverifyCode) {
		// 编码转换
		JSONObject jsonObject=new JSONObject();
		
		HttpSession session=req.getSession();
		String verifyCode = (String) session.getAttribute("uri");
		if (verifyCode.equals(qverifyCode)) {
			if (account != null && !"".equals(account) && password != null && !"".equals(password)) {
				//判断用户是否被禁用
				Integer judgeUserIsBanResult = loginService.judgeUserIsBan(account);
				if(judgeUserIsBanResult>0) {
					ClientUser user = loginService.login(account, password);
					// 判断用户是否登录成功
					if (user != null) {
						System.out.println("登录成功,id为:" + user.getId());
						// 将ID放入session中
						session.setAttribute("auId", user.getId());
						// 标识登录成功
						jsonObject.put("ISLOGIN", "SUCCEED");
					} else {
						System.out.println("登录失败");
						jsonObject.put("ISLOGIN", "INPUTERROR");
					}
				}else {
					System.out.println("用户被禁用");
					jsonObject.put("ISLOGIN", "USERSTOP");
				}
			} else {
				System.out.println("登录失败");
				jsonObject.put("ISLOGIN", "UNFILLED");
			}
		} else {
			System.out.println("验证码错误");
			jsonObject.put("ISLOGIN", "verifyCodeError");
		}

		return jsonObject;
	}
	
	@RequestMapping("verifyCode.ajax")
	@ResponseBody
	public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("获取新的验证码");
		// 获得 当前请求 对应的 会话对象
		HttpSession session = request.getSession();

		// 从请求中获得 URI ( 统一资源标识符 )
		String uri = request.getRequestURI();
		System.out.println("hello : " + uri);

		final int width = 180; // 图片宽度
		final int height = 40; // 图片高度
		final String imgType = "jpeg"; // 指定图片格式 (不是指MIME类型)
		final OutputStream output = response.getOutputStream(); // 获得可以向客户端返回图片的输出流
		// (字节流)
		// 创建验证码图片并返回图片上的字符串
		String code = GraphicHelper.create(width, height, imgType, output);
		System.out.println("验证码内容: " + code);

		// 建立 uri 和 相应的 验证码 的关联 ( 存储到当前会话对象的属性中 )
		session.setAttribute("uri", code);

		System.out.println(session.getAttribute("uri"));

	}



}
