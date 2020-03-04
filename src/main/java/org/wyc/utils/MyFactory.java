package org.wyc.utils;

import java.util.HashMap;
import java.util.Map;

import org.wyc.service.impl.LoginServiceImpl;
import org.wyc.service.impl.MainViewShowServiceImpl;
import org.wyc.service.impl.UserManageServiceImpl;



public class MyFactory {
	private static MyFactory f;

	public static Map<String, Object> map=new HashMap<String, Object>();
	
	static {
	}
	
	public static MyFactory getF() {
		if (f == null) {
			f = new MyFactory();
		}
		return f;
	}
	
	public Object getObject(String className) {
		Object obj=map.get(className);
		if(obj==null) {
			if("LoginServiceImpl".equals(className)) {
				obj=new LoginServiceImpl();
				map.put(className, obj);
				return obj;
			}if("MainViewShowServiceImpl".equals(className)) {
				obj=new MainViewShowServiceImpl();
				map.put(className, obj);
				return obj;
			}if("UserManageServiceImpl".equals(className)) {
				obj=new UserManageServiceImpl();
				map.put(className, obj);
				return obj;
			}

		}
		return obj;
	}
	
	private MyFactory() {
		
	}
}
