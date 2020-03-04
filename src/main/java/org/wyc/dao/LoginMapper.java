package org.wyc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wyc.model.AdminUser;
import org.wyc.model.ClientUser;
import org.wyc.model.Log;

@Mapper
public interface LoginMapper {

	/**
	 * 注册客户
	 */
	Integer register(ClientUser user);
	
	/**
	 * 客户登录
	 */			
	ClientUser login(@Param("account") String account,@Param("password") String password);
	
	/**
	 * 判断用户是否被禁用
	 */
	Integer judgeUserisBan(@Param("account") String account);
	
	/**
	 * 注册日志操作
	 */
	Integer registerLog(Log log);

}
