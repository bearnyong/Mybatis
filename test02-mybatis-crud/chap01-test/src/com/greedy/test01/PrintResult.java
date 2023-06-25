package com.greedy.test01;

import java.util.List;

public class PrintResult {
	
	/*case1*/
	public void case1Print(List<PostDTO> serviceAllList) {
		for(PostDTO all : serviceAllList) {
			System.out.println(all);
		}
	}
	
	
	/*case2*/
	public void case2Print(PostDTO dto) {
		/*Service에서 받은 return값 dto*/
		System.out.println(dto);
	}

	
	/*Success 메세지 출력*/
	public void printSuccess(String string) {
		
		switch(string) {
			
			/*case1*/
			case "case1PrintSuccess" :
				System.out.println("\n전체 게시글 조회 완료\n"); break;
		
			/*case2*/
			case "case2PrintSuccess" :
				System.out.println("\n게시글 조회 완료\n"); break;
				
			/*case3*/
			case "case3PrintSuccess" :
				System.out.println("\n게시글 등록 완료\n"); break;
				
			/*case4*/
			case "case4PrintSuccess" :
				System.out.println("\n게시글 수정 완료\n"); break;
				
			/*case5*/
			case "case5PrintSuccess" :
				System.out.println("\n게시글 비활성화 완료\n"); break;
				
		}
		
		
	}
	
	
	/*Error 메세지 출력*/
	public void printError(String string) {
		if(string.equals(/*case1*/"case1PrintError")) {
			System.out.println("\n전체 조회에 실패하였습니다....\n");
		} else if(string.equals(/*case2*/"case2PrintError")) {
			System.out.println("\n해당 게시글이 존재하지 않습니다....\n");
		} else if(string.equals(/*case3*/"case3PrintError")) {
			System.out.println("\n게시글 등록에 실패하였습니다....\n");
		} else if(string.equals(/*case4*/"case4PrintError")) {
			System.out.println("\n게시글 수정에 실패하였습니다....\n");
		} else if(string.equals(/*case5*/"case5PrintError")) {
			System.out.println("\n게시글 삭제에 실패하였습니다....\n");
		}
		
	}


	

}
