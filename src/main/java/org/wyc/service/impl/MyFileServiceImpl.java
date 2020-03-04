package org.wyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.MyFileMapper;
import org.wyc.model.File;
import org.wyc.service.MyFileService;

@Service
public class MyFileServiceImpl implements MyFileService{

	@Autowired
	private MyFileMapper myFileMapper;
	
	@Override
	public List<File> getMyFileList(String fileName,Integer id) {
		List<File> fileList = myFileMapper.getMyFileList(fileName,id);
		return fileList;
	}
}
