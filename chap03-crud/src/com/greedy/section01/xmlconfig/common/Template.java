package com.greedy.section01.xmlconfig.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	private static SqlSessionFactory sessionFactory;
	
	public static SqlSession getSession() {
		if(sessionFactory == null) {
			String resource = "com/greedy/section01/config/mybatis-config.xml";
			
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sessionFactory.openSession(false);
	}

}
