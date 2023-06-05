package com.greedy.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*데이터 베이스 연결을 위한 설정 정보를 기반으로 인스턴스를 생산하기 위한 클래스*/
	private static SqlSessionFactory sqlSessionFactory;
	
	/* 싱글톤 패턴으로 구현함
	 * 이유 : 프로그램에서 io(하드디스크의 존재하는 파일을 읽고, 쓰고, 삭제, 생성) 행위는 많은
	 * 		 리소스를 요구하며 이로인해 성능이 저하된다.
	 * 		 그렇기 떄문에 static으로 생성을 한 뒤 해당 최초 1회 읽어온 뒤 계속 이어서 사용하여
	 * 		 프로그래밍의 성능을 개선한 것이다.*/
	public static SqlSession/*SqlSession은 데이터 베이스와 연결된 인스턴스*/ getSqlSession() {
		
		if(sqlSessionFactory == null) { /*null인 경우 최초 실행인 것이다*/
			String resource = "mybatis-config.xml"; //절대경로를 입력하지 않는 이유,,? : config 안에 설정을 해주었기 떄문에..(?)
			
			try {
				/*resource에 입력된 정보를 Stream으로 읽어오는 것이다.*/
				InputStream inputStream = Resources.getResourceAsStream(resource);
				/*mybatis-config에 있는 설정 정보를 기반으로 sqlSessionFactory를 빌드하고 넣어준다.*/
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*sql connection 객체를 반환한다.*/
		return sqlSessionFactory.openSession(false);
	}

}
