package com.greedy.section01;

import java.util.List;
import java.util.Scanner;

import com.greedy.dto.MenuDTO;
import com.greedy.dto.SearchCriteria;

public class Application01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			 System.out.println("=====마이바티스 동적 sql (조건문) =======");
	         System.out.println("1.if 조건 확인하기");
	         int no = sc.nextInt();
	         switch (no) {
	            case 1: ifSubMenu();      
	               break;
	            case 2:
	               break;
	            default:
	               break;
	         }

		} while(true);

	}

	private static void ifSubMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();

		do {
			System.out.println("========= if 서브 메뉴 =========");
			System.out.println("1.원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
			System.out.println("2.메뉴 이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
			System.out.println("9.이전 메뉴로");
			System.out.print("메뉴 번호를 입력해 주세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : 
					/* <기능>
					 * 원하는 금액대에 적합한 추천 메뉴 목록 보여주기
					 * 1.메뉴 - 데이터베이스에 존재함 (쿼리로 수행)
					 * 2.금액 - 입력 받아야함*/
					/*금액 입력받기 -> 메뉴 목록을 보여줌*/
					System.out.println("금액을 입력하세요");
					int price = sc.nextInt();
					
					List<MenuDTO> menuList = menuService.selectMenuByPrice(/*금액*/price); 
					for(MenuDTO menu : menuList) {
		                  System.out.println(menu);
		               }
					break;
					
				case 2 : 
					/* <기능>
					 * 메뉴 이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기 */
					/* 메뉴명 또는 카테고리 명을 입력 받는다...? 어떻게요? DTO로 입력 받는다..*/
					SearchCriteria searchDTO =  SearchCriteria();
					
					/* 카테고리명 혹은 이름을 기반으로 조회하는 service 메소드를 호출한다.
					 * 조회 결과를 반환 받는다. */
					menuService.selectMenuBySubCategory(searchDTO);
					
					/* 메뉴 목록을 보여준다. */
					
					
					break;
			}
		} while(true);
	}

	
	private static SearchCriteria SearchCriteria() {
		SearchCriteria searchDTO = new SearchCriteria();
		Scanner sc = new Scanner(System.in);
		
		name :
		while(true) {
			System.out.print("검색 기준을 입력해 주세요(name or category) : ");
			
			/*사용자가 입력을 잘못한 경우 null인데 어떻게 처리를 할까?*/
			String condition = sc.nextLine();
			if(condition.equals("name") || condition.equals("category")) {
				searchDTO.setCondition(condition);
				break name;
			}
		}
		
		System.out.print("검색어를 입력해 주세요(메뉴이름 또는 카테고리 명) : ");
		searchDTO.setValue(sc.nextLine());
		
		return searchDTO;
	}

}
