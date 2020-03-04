package org.wyc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wyc.model.AdminUser;
import org.wyc.model.Menu;

public interface MainViewShowService {
	/**
	 * 根据id获取后台用户信息
	 */
	AdminUser getAdminUserById(Integer uId);
	
	/**
	 * 根据用户ID获取用户拥有的菜单
	 * @param id
	 * @return
	 */
	List<Menu> getMenuList(@Param ("id") Integer id);
}
