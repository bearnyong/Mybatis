package com.greedy.test01;

/*Template에 있는 getSession()을 사용하기 위한 import*/
import static com.greedy.test01.Template.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
/**/
import oracle.jdbc.proxy.annotation.Post;

public class PostService {
	
	/*자바 config 설정으로 정의된 sqlSession을 불러옴*/
	/* 트랜잭션을 한번에 관리해야 하기 떄문에
	 * 세션이 계속 열려 있으면 안됨... 엉켜....  세션에서 어떤 매퍼 불러와야 되는지 모르자나요... 매퍼 여러개 쓰면 비효율적이된다....
	 * 로그인이 되었을 때 데이터베이스 세션이 오픈된다.. */
	// 이렇게 밖에다가 빼놓으니까 반복 실행이 안되네요... 왜요>!>!
//	public static SqlSession sqlSession = getSession();
//	public static PostDAO postDAO = sqlSession.getMapper(PostDAO.class);
	
	/*case1*/
	public List<PostDTO> serviceAllPost() {
		/*자바 config 설정으로 정의된 sqlSession을 불러옴*/
		SqlSession sqlSession = getSession();
		PostDAO postDAO = sqlSession.getMapper(PostDAO.class);
		
		List<PostDTO> allPost = postDAO.selectAllPost();
		sqlSession.close();
		
		return allPost;
	}
	
	/*case2*/
	public static PostDTO findPostCode(int code) {
		/*자바 config 설정으로 정의된 sqlSession을 불러옴*/
		SqlSession sqlSession = getSession();
		PostDAO postDAO = sqlSession.getMapper(PostDAO.class);
		
		PostDTO dto = postDAO.daoPostCode(code);
		sqlSession.close();
		
		return dto;
	}


	
	/*case3*/
	public boolean serviceNewPost(PostDTO dto) {
		/*자바 config 설정으로 정의된 sqlSession을 불러옴*/
		SqlSession sqlSession = getSession();
		PostDAO postDAO = sqlSession.getMapper(PostDAO.class);
		
		int result = postDAO.addPostPost(dto);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result > 0 ? true:false;
	}
	
	
	
	/*case4*/
	public boolean serviceUpdatePost(PostDTO dto) {
		/*자바 config 설정으로 정의된 sqlSession을 불러옴*/
		SqlSession sqlSession = getSession();
		PostDAO postDAO = sqlSession.getMapper(PostDAO.class);
		
		int result = postDAO.updatePostPost(dto);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result > 0 ? true:false;
	}



	/*case5*/
	public boolean serviceDeletePost(PostDTO dto) {
		/*자바 config 설정으로 정의된 sqlSession을 불러옴*/
		SqlSession sqlSession = getSession();
		PostDAO postDAO = sqlSession.getMapper(PostDAO.class);
		
		int result = postDAO.deletePostPost(dto);
		
		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result > 0 ? true:false;
	}

	

}
