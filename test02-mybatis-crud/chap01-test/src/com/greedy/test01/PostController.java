package com.greedy.test01;

import java.util.List;
import java.util.Map;

public class PostController {
	
	/* Controller의 역할...
	 * 1. 사용자 요청 처리
	   2. 사용자 입력 값의 유효성 체크*/
	
	private final PostService postService;
	/*결과 값을 출력해주는 클래스 PrintResult 호출*/
	private final PrintResult printResult;
	
	
	/*PostService와 PrintResult 사용을 위한 기본생성자 생성*/
	public PostController() {
		this.postService = new PostService();
		this.printResult = new PrintResult();
	}

	
	/*case1*/
	public void findAllPost() {
		List<PostDTO> serviceAllList = postService.serviceAllPost();
		
		/*Service에서 값을 받아온 후...*/
		if(serviceAllList != null) {
			printResult.case1Print(serviceAllList);
			printResult.printSuccess("case1PrintSuccess");
		} else {
			printResult.printError("case1PrintError");
		}
		
	}
	
	
	
	/*case2*/
	/*Application -> inputPostCode() 매개변수 값 받아옴...*/
	public void findPostByPostCode(Map<String, String> inputPostCode) {
		/*inputPostCode()에서 String으로 받은 code 값 int로 바꿔주기*/
		int code = Integer.parseInt(inputPostCode.get("postNum"));
		
		/*PostService의 findPostCode에 codr(매개변수)값을 넣어 postCode에 저장하기*/
		PostDTO dto = PostService.findPostCode(code);
		
		/*Service에서 값을 받아온 후...*/
		if(dto != null) {
			printResult.case2Print(dto);
			printResult.printSuccess("case2PrintSuccess");
		} else {
			printResult.printError("case2PrintError");
		}
	}


	
	/*case3*/
	public void registNewPost(Map<String, String> addPost) {
		/**/
		PostDTO dto = new PostDTO();
		dto.setBlogNum(addPost.get("blogNum"));
		dto.setFileNum(addPost.get("fileNum"));
		dto.setPostTitle(addPost.get("postTitle"));
		dto.setPostCon(addPost.get("postCon"));
		dto.setCateNum(addPost.get("cateNum"));
		
		if(postService.serviceNewPost(dto)) {
			printResult.printSuccess("case3PrintSuccess");
		} else {
			printResult.printError("case3PrintError");
		}
		
		
	}


	/*case4*/
	public void modifyPost(Map<String,String> updatePost) {
		/*inputPostCode()에서 String으로 받은 code 값 int로 바꿔주기*/
		int code = Integer.parseInt(updatePost.get("postNum"));
		
		PostDTO dto = new PostDTO();
		dto.setPostNum(code);
		dto.setPostTitle(updatePost.get("postTitle"));
		dto.setCateNum(updatePost.get("cateNum"));
		
		if(postService.serviceUpdatePost(dto)) {
			printResult.printSuccess("case4PrintSuccess");
		} else {
			printResult.printError("case4PrintError");
		}
		
	}

	
	
	/*case5*/
	public void removePost(Map<String, String> inputPostCode) {
		/*inputPostCode()에서 String으로 받은 code 값 int로 바꿔주기*/
		int code = Integer.parseInt(inputPostCode.get("postNum"));

		PostDTO dto = new PostDTO();
		dto.setPostNum(code);
		
		/*Service에서 값을 받아온 후...*/
		if(postService.serviceDeletePost(dto)) {
			printResult.printSuccess("case5PrintSuccess");
		} else {
			printResult.printError("case5PrintError");
		}
		
	}

	
}
