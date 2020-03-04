package org.wyc.main;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.wyc.dao.LoginMapper;
import org.wyc.dao.MainViewShowMapper;
import org.wyc.dao.UserManageMapper;
import org.wyc.model.AdminUser;
import org.wyc.model.ClientUser;
import org.wyc.model.Menu;
import org.wyc.service.LoginService;
import org.wyc.service.impl.LoginServiceImpl;
import org.wyc.utils.MyBatisUtil;

public class Test {
	public static void main(String[] args) {
//		addUser();
		
//		getUserById();
//		getList();
//		getUserById();
//		getMenuList();
		LoginService service=new LoginServiceImpl();
	}
	
	//注册
	public static void addUser() {
		SqlSession session=MyBatisUtil.getSession();
		LoginMapper mapper=session.getMapper(LoginMapper.class);
//		AdminUser user=new AdminUser(null, "w", "1", "wyc", 1,new Date(), null, null, null);
//		Integer addUserResult = mapper.register(user);
//		if(addUserResult>0) {
//			session.commit();
//		}else {
//			session.rollback();
//		}
//		session.close();
	}
	
	
	public static void getList() {
//		SqlSession session = MyBatisUtil.getSession();
//		UserManageMapper mapper=session.getMapper(UserManageMapper.class);
//		List<ClientUser> list=mapper.getUserList("w");
//		System.out.println(list.toString());
//		session.close();
	}
	public static void getMenuList() {
		SqlSession session = MyBatisUtil.getSession();
		MainViewShowMapper mapper=session.getMapper(MainViewShowMapper.class);
		List<Menu> list=mapper.getMenuList(2);
		System.out.println(list.toString());
		session.close();
	}
}
