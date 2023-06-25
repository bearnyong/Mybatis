package com.greedy.test01;

import java.util.List;

public interface PostDAO {

	
	/*case1*/
	/*<select id="selectAllPost" 이기 때문에 selectAllPost()*/
	List<PostDTO> selectAllPost();
	
	
	/*case2*/
	/*<select id="daoPostCode" 이기 때문에 daoPostCode()*/
	PostDTO daoPostCode(int code);

	
	/*case3*/
	int addPostPost(PostDTO dto);
	
	
	/*case4*/
	int updatePostPost(PostDTO dto);
	
	
	/*case5*/
	int deletePostPost(PostDTO dto);
	   
}
