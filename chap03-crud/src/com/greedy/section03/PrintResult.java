package com.greedy.section03;

import java.util.List;

public class PrintResult {
	
	public void printMenuList(List<MenuDTO> menuList) {
		
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
		
	}

	public void printErrorMessage(String string) {
		if(string.equals("findAllMenus")) {
			System.out.println("메뉴 조회에 실패 하였습니다.");
			
		}else if(string.equals("findMenuByMenuCode")) {
			System.out.println("해당 코드에 존재하는 메뉴가 없습니다.");
			
		}else if(string.equals("registNewMenu")) {
			System.out.println("메뉴 등록에 실패하였습니다.");
			
		}else if(string.equals("notModify")) {
			System.out.println("메뉴 수정에 실패하였습니다.");
			
		}else if(string.equals("notremove")) {
			System.out.println("메뉴 삭제에 실패하였습니다.");
		}
	}

	public void printMenu(MenuDTO menu) {
		
		System.out.println(menu);
	}

	public void printSuccessMessage(String string) {
		
		switch (string) {
			case "registNewMenu": 
						System.out.println("등록에 성공하였습니다.");
						break;
			case "modifyMenu" : 
						System.out.println("메뉴 수정에 성공하였습니다.");
						break;
			case "removeMenu" :
						System.out.println("메뉴 삭제 성공");
						break;
			default:
				break;
		}
	}
}