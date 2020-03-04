package org.wyc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wyc.model.ScoreLog;
import org.wyc.service.ScoreLogService;

@Controller
public class ScoreLogController {
	
	@Autowired
	private ScoreLogService scoreLogService;
	
	@RequestMapping("scoreLogShow.html")
	public ModelAndView ScoreLogShow(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer userId=(Integer)session.getAttribute("uId");
		
		System.out.println("userId2="+userId);
		ModelAndView mv=new ModelAndView();
		//获取积分日志列表
		List<ScoreLog> scoreLogList = scoreLogService.getScoreLogList(userId);
		mv.setViewName("scoreLog");
		mv.addObject("list", scoreLogList);
		return mv;
	}
}
