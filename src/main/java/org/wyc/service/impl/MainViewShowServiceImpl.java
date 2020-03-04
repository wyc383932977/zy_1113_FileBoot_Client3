package org.wyc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.MainViewShowMapper;
import org.wyc.model.AdminUser;
import org.wyc.model.Menu;
import org.wyc.service.MainViewShowService;
import org.wyc.utils.MyBatisUtil;

@Service
public class MainViewShowServiceImpl implements MainViewShowService{

	@Autowired
	private MainViewShowMapper mainViewShowMapper;
	
	@Override
	public AdminUser getAdminUserById(Integer auId) {
		AdminUser adminUser=mainViewShowMapper.getAdminUserById(auId);
		return adminUser;
	}
	@Override
	public List<Menu> getMenuList(Integer id) {
		List<Menu> list=mainViewShowMapper.getMenuList(id);
		return list;
	}

}
