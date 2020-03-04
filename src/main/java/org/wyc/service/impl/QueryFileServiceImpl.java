package org.wyc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.QueryFileMapper;
import org.wyc.model.ClientUser;
import org.wyc.model.File;
import org.wyc.model.ScoreLog;
import org.wyc.service.QueryFileService;
@Service
public class QueryFileServiceImpl implements QueryFileService {

	@Autowired
	private QueryFileMapper queryFileMapper;
	
	@Override
	public List<File> getFileList(String fileName) {
		List<File> fileList = queryFileMapper.getFileList(fileName);
		return fileList;
	}

	@Override
	public ClientUser getUserInfoById(Integer userId) {
		ClientUser clientUser = queryFileMapper.getUserInfoById(userId);
		return clientUser;
	}

	@Override
	public Integer scoreChange(Integer nowScore, Integer userId) {
		//用户积分变更
		Integer ScoreResult=queryFileMapper.userScoreChange(nowScore, userId);
		return ScoreResult;
	}
	
	@Override
	public Integer insertScoreLog(ScoreLog scoreLog) {
		Integer insertScoreLogResult= queryFileMapper.insertScoreLog(scoreLog);
		return insertScoreLogResult;
	}
	
	
}
