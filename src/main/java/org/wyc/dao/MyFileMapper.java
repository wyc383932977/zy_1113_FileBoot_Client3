package org.wyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wyc.model.File;

@Mapper
public interface MyFileMapper {

	/**
	 * 查看列表
	 */
	List<File> getMyFileList(@Param("fileName") String fileName,@Param("id") Integer id);
}
