package org.wyc.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.LoginMapper;
import org.wyc.model.ClientUser;
import org.wyc.service.LoginService;
import org.wyc.utils.MyBatisUtil;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public ClientUser login(String account, String password) {
		ClientUser user = loginMapper.login(account, password);
//		System.out.println(user.toString());
		return user;
	}
	
	public Integer judgeUserIsBan(String account) {
		Integer result = loginMapper.judgeUserisBan(account);
		return result;
	}

	@Override
	public String register(ClientUser user) {
		String isSucc="";
		SqlSession session=MyBatisUtil.getSession();
		Integer addUserResult = loginMapper.register(user);
		if(addUserResult>0) {
			session.commit();
			isSucc="succeed";
		}else {
			session.rollback();
			isSucc="fail";
		}
		session.close();//断开连接,将连接放回连接池
		return isSucc;
	}
	
}
