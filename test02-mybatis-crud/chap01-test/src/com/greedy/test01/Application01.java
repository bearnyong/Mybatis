package com.greedy.test01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application01 {

	/*Application01 -> controller -> service -> DAO -> DTO*/
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PostController postController = new PostController();
		
		bye:
		do {
			System.out.println("===== BLOG 게시글 관리 =====");
			System.out.println("1.게시글 전체 조회");
			System.out.println("2.게시글 번호로 조회");
			System.out.println("3.게시글 추가");
			System.out.println("4.게시글 제목 수정");
			System.out.println("5.게시글 삭제");
			System.out.println("0.종료");
			System.out.print("옵션을 선택해 주세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			
				/*게시글 조회 (전체)*/
				// 입력 값이 없이 바로 전체 조회를 하기 때문에 바로 Controller로 이동...
				case 1 : postController.findAllPost(); break;
				
				/*게시글 조회 (번호)*/
				case 2 : postController.findPostByPostCode(inputPostCode()); break;
				
				/*게시글 추가*/
				case 3 : postController.registNewPost(addPost()); break;
				
				/*게시글 제목 수정*/
				case 4 : postController.modifyPost(updatePost()); break;
				
				/*게시글 삭제*/
				case 5 : postController.removePost(inputPostCode()); break;
					
				/*종료*/	
				case 0 : System.out.println("\n프로그램이 종료되었습니다..."); break bye;
					
				/*다른 값 입력*/
				default : System.out.println("잘못된 입력 값 입니다... 다시 입력해 주세요..."); break;
			}
		} while(true); /*무한 루프*/
	}


	
	/*case2, case5*/
	private static Map<String,String> inputPostCode() {
		
		/*case2 실행 시 게시글 조회를 위한 번호 입력받기(String으로 입력 후 int로 바꿔준다)*/
		Scanner sc = new Scanner(System.in);
		System.out.print("게시글 번호를 입력해 주세요 : ");
		String postNum = sc.nextLine();
		
		/*HashMap생성, 매개변수 parameter */
		Map<String, String> parameter = new HashMap<String, String>();
		/*저장한 데이터 꺼내오기 parameter.put("mapper에 작성한 이름", 입력받은 값);*/
		parameter.put("postNum", postNum);
		
		return parameter;
	}
	
	
	
	/*case3*/
	private static Map<String,String> addPost() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("블로그 번호(B00)를 입력해 주세요 : ");
		String blogNum = sc.nextLine();
		
		System.out.print("파일 번호(F00)를 입력해 주세요 : ");
		String fileNum = sc.nextLine();
		
		System.out.print("게시글 제목을 입력해 주세요 : ");
		String postTitle = sc.nextLine();
		
		System.out.print("내용을 입력해 주세요 : ");
		String postCon = sc.nextLine();
		
		System.out.print("카테고리 번호(C00)를 입력해 주세요 : ");
		String cateNum = sc.nextLine();
		
		/*HashMap생성, 매개변수 parameter */
		Map<String,String> parameter = new HashMap<>();
		/*저장한 데이터 꺼내오기 parameter.put("mapper에 작성한 이름", 입력받은 값);*/
		parameter.put("blogNum", blogNum);
		parameter.put("fileNum", fileNum);
		parameter.put("postTitle", postTitle);
		parameter.put("postCon", postCon);
		parameter.put("cateNum", cateNum);
		
		return parameter;
	}

	
	
	/*case4*/
	private static Map<String,String> updatePost() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 게시글 번호를 입력해 주세요 : ");
		String postNum = sc.nextLine();
		
		System.out.print("게시글 제목 수정 : ");
		String postTitle = sc.nextLine();
		
		System.out.print("카테고리(C00) 수정 : ");
		String cateNum = sc.nextLine();
		
		/*HashMap생성, 매개변수 parameter */
		Map<String,String> parameter = new HashMap<>();
		/*저장한 데이터 꺼내오기 parameter.put("mapper에 작성한 이름", 입력받은 값);*/
		parameter.put("postNum", postNum);
		parameter.put("postTitle", postTitle);
		parameter.put("cateNum", cateNum);
		
		return parameter;
	}


	

}
