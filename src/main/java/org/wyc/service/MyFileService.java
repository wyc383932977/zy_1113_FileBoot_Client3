package org.wyc.service;

import java.util.List;

import org.wyc.model.File;

public interface MyFileService {

	/**
	 * 查看列表
	 */
	List<File> getMyFileList(String fileName,Integer id);
}
