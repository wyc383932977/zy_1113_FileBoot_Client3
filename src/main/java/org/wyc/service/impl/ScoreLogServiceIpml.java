package org.wyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.ScoreLogMapper;
import org.wyc.model.ScoreLog;
import org.wyc.service.ScoreLogService;

@Service
public class ScoreLogServiceIpml implements ScoreLogService {

	@Autowired
	private ScoreLogMapper scoreLogMapper;
	
	public List<ScoreLog> getScoreLogList(Integer userId){
		List<ScoreLog> scoreLogList = scoreLogMapper.getScoreLogList(userId);
		return scoreLogList;
	}
}
