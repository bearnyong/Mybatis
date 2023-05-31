package com.greedy.section01.xmlconfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/* SqlseectionFactory는 애플리케이션을 실행하는 동안 존재해야 한다. (리소스 낭비에 관한 부분)
	 * 애플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory를 다시 빌드하지 않는 것이 가장 좋은 형태이다.
	 * 애플리케이션 스코프로 관리하기 위한 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다.*/

	private static SqlSessionFactory sqlSessionFactory; /*싱글톤패턴*/
	
	public static SqlSession getSqlSession() {
		/*SqlSessionFactoryBuilder는 sqlSession을 생성한 후 유지할 필요는 없다. (최종적인 결과물만 커밋..)
		 * 따라서 메소드 스코프로 만든다. 여러 개의 sqlSessionFactory를 빌드하기 위해 재사용할 수도 있지만 유지하지 않는 것이가장 좋다.
		 * (에러가 날 수 있는 환경 최소화...)*/
		
		if(sqlSessionFactory == null) {
			String resource = "com/greedy/section01/xmlconfig/mybatis-config.xml";
			
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/* SqlSession은 요청시마다 생성해야 한다.
		 * SqlSession은 쓰레드에 안전하지 않고 공유되지 않아야 한다.
		 * 요청 시 생성하고 요청이 완료되면 close하는 http 요청과 유사한 스코프에 두는 것이 가장 올바른 방법이다.*/
		SqlSession sqlSession = sqlSessionFactory.openSession(false); /*받아와서 실행시켜줘...(?)*/
		//커밋이나 트랜잭션 관리 가능
		
		System.out.println("sqlSessionFactory의 hashcode : " + sqlSessionFactory.hashCode());
		//sqlSessionFactory.hashCode() JDBC에서 계속 드라이버를 꺼내와야하기 떄문에 ...? 성능 개선 늒임..?
		System.out.println("sqlSession의 hashcode : " + sqlSession.hashCode());
		
		return sqlSession;
		
	}
	
	
}