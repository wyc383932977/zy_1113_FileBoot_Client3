package org.wyc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wyc.model.ClientUser;
import org.wyc.model.File;
import org.wyc.model.ScoreLog;

public interface QueryFileService {
	/**
	 * 查看列表
	 */
	List<File> getFileList(String fileName);
	/**
	 * 查看用户信息
	 */
	ClientUser getUserInfoById(@Param ("id") Integer userId);
	/**
	 * 客户积分变更
	 */
	Integer scoreChange(Integer nowScore,Integer userId);
	
	Integer insertScoreLog(ScoreLog scoreLog);
}
