package org.wyc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wyc.model.AdminUser;
import org.wyc.model.Menu;
@Mapper
public interface MainViewShowMapper {
	/**
	 * 获取用户byId
	 * @param id
	 * @return
	 */
	AdminUser getAdminUserById(@Param ("id") Integer id);
	/**
	 * 根据ID获取用户菜单列表
	 * @return
	 */
	List<Menu> getMenuList(@Param ("id") Integer id);
}
