package org.wyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wyc.model.ScoreLog;

@Mapper
public interface ScoreLogMapper {
	
	/**
	 * 获取积分日志
	 */
	List<ScoreLog> getScoreLogList(@Param ("userId") Integer userId);
}
