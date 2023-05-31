package com.greedy.section01.javaconfig;

/*mybatis-3.4.6와 ojdbc6-11.2.0.4에 있는 라이브러리들... 마이바티스와 JDBC 같이 써야됨.. => 의존관계...*/
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application01 {
	
	/*static으로 가장 먼저 실행... 그리고 final로 변경하지 못하게...*/
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER = "C##EMPLOYEE";	
	private final static String PASSWORD = "EMPLOYEE";	

	public static void main(String[] args) {

		/* DB 접속에 관한 환경 설정
		 * --------------------
		 * jdbcTranscationFactiory : 수동 커밋
		 * ManagedTransactionFactory : 자동 커밋
		 * --------------------
		 * PooledDataSource : ConnectionPool 사용
		 * UnpooledDataSource : ConnectionPool 미사용
		 * -------------------- */
		
		Environment environment =  //환경에 대한 정보 저장
				new Environment("dev", //환경 정보 이름 'dev'에 환경 정보가 들어감
						new JdbcTransactionFactory(), //트랜젝션 매니저 종류 결정(JDBCC OR MANAGED) - 수동 커밋
						new PooledDataSource(DRIVER, URL, USER, PASSWORD));  //CONNECTIONPOOL 사용 유무 (POOLED OR UNPOOLED)
		
		/*생성한 환경 설정 정보를 가지고 마이바티스 설정 객체 생성*/
		Configuration configuration = new Configuration(environment);
		//마이바티스가 가지고 있는 Configuration로 마이바티스 객체 생성
		
		/*설정 객체에 매퍼 등록*/
		configuration.addMapper(Mapper.class); 	//인터페이스를 넣어준다..
		
		// 여기까지 환경 정보 설정해준거임... ---------------------------------------------------------------------
		
		
		/*SqlSessionFactory : sqlSession 객체를 생성하기 위한 팩토리의 역할을 ㅎ수행하는 인터페이스
		 * sqlSessionFacgoryBuilder : SqlSessionFactory 인터페이스 타입의 하위구현 객체를 생성하기 위한 빌드 역할 수행
		 * builder() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된 스트림을 매개변수로 전달하면
		 * sqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		//설정 정보를 가지고 SQl어쩌구를 생성한다.
	
		/* openSession : SqlSession인터페이스 탕비의 객체를 반환하는 메소드 boolean 타입을 인자로 전달
		 * false : Connection 인터페이스 타입 객체로 dml 수행 후 auto Commit 에 대한 옵션을 false로 지정(권장)
		 * true : Connection 인터페이스 타입 객체로 dml 수행 후 auto Commit 에 대한 옵션을 true로 지정*/
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		//getMapper() : configuration에 등록된 매퍼를 동일 타입에 대한 반환하는 메소드
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		
		//mapper 인터페이스에 작성된 메서드를 호출하여 쿼리 실행
		java.util.Date date = mapper.selectSysdate();
		//익명함수지만 실행이된다...
		
		System.out.println(date);
		
		//close : sqlSession 객체 반납
		sqlSession.close(); 
		
		
	}

}
