package org.wyc.utils;

import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory sf;//相当于Connection
	
	/**
	 * 初始化工厂
	 */
	static {//静态块只在改类被调用时执行一次
		String conf="SqlMapConfig.xml";
		try {
			Reader reader=Resources.getResourceAsReader(conf);//读取配置文件
			SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();//new Session创建者
			sf=sfb.build(reader);//创建session会话连接(连接),让oracle数据库和myBatis连接(连接池)
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		System.out.println("www");
	}
	
	/**
	 * 获取连接
	 * @return 连接Session
	 */
	public static SqlSession getSession() {
		return sf.openSession();//开启连接(将连接交给后端使用),就算close,也只是将连接归还给session会话
	}
	
	/**
	 * Main测试
	 */
//	public static void main(String[] args) {
//		SqlSession session =MyBatisUtil.getSession();
//		System.out.println(session);
//		session.close();
//	}
}
