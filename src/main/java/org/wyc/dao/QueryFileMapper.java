package org.wyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wyc.model.ClientUser;
import org.wyc.model.File;
import org.wyc.model.ScoreLog;
@Mapper
public interface QueryFileMapper {

	/**
	 * 查看列表
	 */
	List<File> getFileList(@Param("fileName") String fileName);
	
	/**
	 * 查看用户信息
	 */
	ClientUser getUserInfoById(@Param ("id") Integer userId);
	/**
	 * 用户积分变更
	 */
	Integer userScoreChange(@Param ("score") Integer score,@Param ("userId") Integer userId);

	/**
	 *插入积分日志表
	 */
	Integer insertScoreLog(ScoreLog scoreLog);
	
}
