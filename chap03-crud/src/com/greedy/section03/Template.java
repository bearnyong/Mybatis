package com.greedy.section03;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

	private static SqlSessionFactory sessionFactory;
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "C##EMPLOYEE";
	private static final String PASSWORD = "EMPLOYEE";
	
	/* ÀÚ¹Ù config ¹æ½ÄÀ» »ç¿ëÇÔ*/
	public static SqlSession getSession() {
		
		if(sessionFactory == null) {
			Environment environment = new Environment("dev",
					new JdbcTransactionFactory(),
					new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			
			Configuration configuration = new Configuration(environment);
			
			configuration.addMapper(MenuDAO.class);
			
			sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}
		
		return sessionFactory.openSession(false);
	}
}