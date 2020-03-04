package org.wyc.service;

import java.util.List;

import org.wyc.model.File;

public interface DownAndLoadFileService {

	/**
	 * 上传文件
	 */
	String loadFile(File file);
	
	/**
	 * 查看列表
	 */
	List<File> getFileList(Integer userId);
	
}
