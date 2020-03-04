package org.wyc.dao;
//客户管理业务

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.wyc.model.AdminUser;
import org.wyc.model.ClientUser;
@Mapper
public interface UserManageMapper {
	/**
	 * 获取客户列表
	 * @param account
	 * @return
	 */
	List<ClientUser> getUserList(@Param("account") String account,RowBounds rb);
	/**
	 * 列表信息总条数
	 */
	Integer getCount(@Param("account") String account);
	
	/**
	 * 修改用户状态
	 * @param id
	 * @return
	 */
	Integer changeUserState(@Param("state") Integer state,@Param ("id") Integer id);
	
	/**
	 * 根据客户id获取客户信息
	 * @param id
	 * @return
	 */
	ClientUser getClientUserById(@Param("id") Integer id);
	
	/**
	 * 根据用户id查询用户信息
	 */
	AdminUser getUserById(@Param("id") Integer id);
}
