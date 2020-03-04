package org.wyc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.DownAndLoadMapper;
import org.wyc.model.File;
import org.wyc.service.DownAndLoadFileService;

@Service
public class DownLoadFileServiceImpl implements DownAndLoadFileService{

	@Autowired
	private DownAndLoadMapper downAndLoadMapper;
	
	@Override
	public String loadFile(File file) {
		// TODO Auto-generated method stub
		String isSucc="";
		Integer FileResult=downAndLoadMapper.loadFile(file);
		if(FileResult>0 ) {
			isSucc="succeed";
		}else {
			isSucc="fail";
		}
		return isSucc;
		
	}

	@Override
	public List<File> getFileList(Integer userId) {
		List<File> list=downAndLoadMapper.getFileList(userId);
		return list;
	}



}
