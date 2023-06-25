package com.greedy.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.xmlconfig.controller.MenuController;;

public class Application01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		/*1*/ApplicationContext context = new AnnotationConfigApplicationContext("com.greedy.section01");
		/*3*/MenuController menuController = context.getBean(MenuController.class);
		
		do {
			System.out.println("========메뉴관리========");
			System.out.println("1.메뉴 전체 조회");
			System.out.println("2.메뉴 코드로 조회");
			System.out.println("3.신규 메뉴 추가");
			System.out.println("4.메뉴 수정");
			System.out.println("5.메뉴 삭제");
			System.out.print("메뉴 관리 번호를 입력해 주세요 : ");
			int no = sc.nextInt();
			
			switch (no) {
				case 1: menuController.findAllMenus();
						//메뉴컨트롤러로 요청이 간다요... 그 안에서 findAllMenus 매서드 호출
						break;
						
				case 2: menuController.findMenuByMenuCode(inputMenuCode());
						break;
				
				case 3: menuController.registNewMenu(inputMenu());
						break;
				
				case 4: menuController.modifyMenu(inputModifyMenu());
						break;
				
				case 5: menuController.removeMenu(inputMenuCode());
						break;
				
				default: System.out.println("잘못된 메뉴를 선택하였습니다.");
						break;
			}
		} while(true);
		
	}
	
	
	private static Map<String, String> inputMenuCode() {  //Map은 키와 값을 가지고 있다... 키는 중복이 ...
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 코드를 입력해 주세요 : ");
		String code = sc.nextLine();
		
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("code", code);
		
		return parameter;
	}
	
	
	private static Map<String, String> inputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴의 이름을 입력해 주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("메뉴의 가격을 입력해 주세요 : ");
		String price = sc.nextLine();
		
		System.out.print("메뉴의 코드를 입력해 주세요 : ");
		String categoryCode = sc.nextLine();
		
		Map<String, String> parmeter = new HashMap<>();
		parmeter.put("name", name);
		parmeter.put("price", price);
		parmeter.put("categoryCode", categoryCode);
		
		return parmeter;
	}
	
	
	private static Map<String, String> inputModifyMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 메뉴 코드를 입력해 주세요 : ");
		String code = sc.nextLine();
		
		System.out.print("수정할 메뉴 이름을 입력해 주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("수정할 메뉴 가격을 입력해 주세요 : ");
		String price = sc.nextLine();
		
		System.out.print("수정할 카테고리 코드를 입력해 주세요 : ");
		String categoryCode = sc.nextLine();
		
		Map<String, String> parmeter = new HashMap<>();
		parmeter.put("code", code);
		parmeter.put("name", name);
		parmeter.put("price", price);
		parmeter.put("categoryCode", categoryCode);
		
		return parmeter;
	}

}
