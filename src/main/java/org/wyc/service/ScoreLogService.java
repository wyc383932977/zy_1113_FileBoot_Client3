package org.wyc.service;

import java.util.List;

import org.wyc.model.ScoreLog;

public interface ScoreLogService {

	/**
	 * 获取积分日志列表
	 * @param userId
	 * @return
	 */
	List<ScoreLog> getScoreLogList(Integer userId);
}
