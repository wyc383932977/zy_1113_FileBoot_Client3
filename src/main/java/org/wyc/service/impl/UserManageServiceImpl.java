package org.wyc.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyc.dao.UserManageMapper;
import org.wyc.model.ClientUser;
import org.wyc.service.UserManageService;
import org.wyc.utils.MyBatisUtil;
import org.wyc.utils.PageBean;
import org.wyc.utils.PageUtils;
@Service
public class UserManageServiceImpl implements UserManageService{

	@Autowired
	private UserManageMapper userManageMapper;
	
	@Override
	public List<ClientUser> getUserList(String account,Integer currPage) {
		int[] result=PageUtils.getBeginEndNumByCurrPage(currPage);
		RowBounds rb=new RowBounds(result[0],result[1]);
		List<ClientUser> list=userManageMapper.getUserList(account,rb);
		return list;
	}
	
	@Override
	public PageBean getCount(String account, Integer currPage) {
		int allCount=userManageMapper.getCount(account);
		Integer allPage=PageUtils.getAllPage(allCount);
		PageBean pageBean=new PageBean(currPage, allPage, allCount);
		return pageBean;
	}
	
	@Override
	public String changeUserState(Integer state, Integer id) {
		SqlSession session = MyBatisUtil.getSession();
		Integer result=userManageMapper.changeUserState(state, id);
		String msg="";
		if(result>0) {
			session.commit();
			msg="succ";
		}else{
			session.rollback();
			msg="fail";
		}
		return msg;
	}

	@Override
	public ClientUser getClientUserById(Integer id) {
		ClientUser user=userManageMapper.getClientUserById(id);
		return user;
	}





}
