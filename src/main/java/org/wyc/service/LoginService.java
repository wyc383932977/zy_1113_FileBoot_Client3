package org.wyc.service;

import org.wyc.model.ClientUser;

public interface LoginService {
	/**
	 * 登录业务
	 * @param account
	 * @param password
	 * @return
	 */
	ClientUser login(String account,String password);
	
	/**
	 * 注册业务
	 * @param user
	 * @return
	 */
	String register(ClientUser user);
	
	/**
	 * 判断用户是否被禁用
	 */
	Integer judgeUserIsBan(String account);
}
