package com.greedy.section01.xmlconfig.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.greedy.section01.xmlconfig.dto.MenuDTO;

@Repository("PrintResult")
public class PrintResult {
	
	public void printMenuList(List<MenuDTO> menuList) {
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
	}

	public void printErrorMessage(String string) {
		if(string.contentEquals("findAllMenus")) {
			System.out.println("메뉴 조회에 실패하였습니다...");
		} else if(string.contentEquals("findMenuByMenuCode")) {
			System.out.println("해당 코드는 존재하는 메뉴가 없습니다...");
		} else if(string.contentEquals("registNewMenu")) {
			System.out.println("메뉴 등록에 실패하였습니다...");
		} else if(string.contentEquals("notModify")) {
			System.out.println("메뉴 수정에 실패하였습니다...");
		} else if(string.contentEquals("removeMenu")) {
			System.out.println("메뉴 삭제에 실패하였습니다...");
		}
	}

	public void printMenuList(MenuDTO menu) {
		System.out.println(menu);  //tostring 자동으로 나옴...
	}

	public void printSuccessMessage(String string) {
		switch(string) {
			case "registNewMenu" :
				System.out.println("등록에 성공하였습니다...");
				break;
			
			case "modifyMenu" :
				System.out.println("메뉴 수정에 성공하였습니다...");
				break;
				
			case "removeMenu" :
				System.out.println("메뉴 삭제 성공");
				break;
		
 			default:
				break;
		}
	}

}
