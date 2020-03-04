package org.wyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wyc.model.ClientUser;
import org.wyc.model.File;
import org.wyc.model.Log;

@Mapper
public interface DownAndLoadMapper {
	
	/**
	 * 文档列表
	 */
	List<File> getFileList(@Param("id") Integer id);
	
	/**
	 * 上传文件数据保存到数据库
	 */
	Integer loadFile(File file);
	/**
	 * 上传日志操作
	 */
	Integer loadFileLog(Log log);

	/**
	 * 查看用户信息
	 */
	ClientUser getUserInfoById(@Param ("id") Integer userId);

}
