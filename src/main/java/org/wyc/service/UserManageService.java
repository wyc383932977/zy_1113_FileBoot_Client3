package org.wyc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wyc.model.AdminUser;
import org.wyc.model.ClientUser;
import org.wyc.utils.PageBean;

public interface UserManageService {
	/**
	 * 获取用户列表
	 * @param account
	 * @return
	 */
	List<ClientUser> getUserList(String account,Integer currPage);
	
	/**
	 * 列表信息总条数
	 */
	PageBean getCount(String account,Integer currPage);
	
	/**
	 * 修改用户状态
	 * @param state
	 * @param id
	 * @return
	 */
	String changeUserState(Integer state,Integer id);
	
	/**
	 * 根据客户id查询用户信息
	 */
	ClientUser getClientUserById( Integer id);
}
