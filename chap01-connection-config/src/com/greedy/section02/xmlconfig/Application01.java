package com.greedy.section02.xmlconfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Application01 {

	public static void main(String[] args) {

		String resource = "com/greedy/section02/xmlconfig/mybatis-config.xml"; //xml 파일 불러와서 resource(스트림)에 루트 저장
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource); //mapper 불러와서 읽어주기...
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  //자바에서 환경설정을 기반으로 세션을 만들어라...
			
			SqlSession session = sqlSessionFactory.openSession(false); //최종적으로 세션 넘기기...
			
			java.util.Date date = session.selectOne("mapper123.selectSysdate");
			System.out.println(date);
			
			session.close(); //session을 try 구문 안에서 작성해줬기 때문에 닫아주는 것도 try문 안에서 닫아줘야함
			
			// try -> 오류 -> catch -> finally
			// try -> 실행 완료 -> finally...
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
