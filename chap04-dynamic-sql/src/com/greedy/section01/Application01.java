package com.greedy.section01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import com.greedy.dto.MenuDTO;
import com.greedy.dto.SearchCriteria;

public class Application01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		bye:
		do {
			 System.out.println("=====마이바티스 동적 sql (조건문) =======");
	         System.out.println("1.if 조건 확인하기");
	         System.out.println("2.choose(wen,otherwise) 확인하기");
	         System.out.println("3.foreach 확인하기");
	         System.out.println("4.trim(where, set)확인하기");
	         System.out.println("9.프로그램 종료");
	         int no = sc.nextInt();
	         switch (no) {
	            case 1 : ifSubMenu();      
	               break;
	            case 2 : chooseSubMenu();
	               break;
	            case 3 : foreahSubMenu();
	            	break;
	            case 4 : trimSubMenu();
	            	break;
	            case 9 : System.out.println("프로그램을 종료 합니다.");
	            	break bye;
	         }

		} while(true);
	}
	

	/*서비스 로직*/
	private static void ifSubMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();

		do {
			System.out.println("========= if 서브 메뉴 =========");
			System.out.println("1.원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
			System.out.println("2.메뉴 이름 혹은 카테고리명(식사, 음료, 디저트)으로 검색하여 메뉴 목록 보여주기");
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
					List<MenuDTO> searchList = menuService.searchMenu(searchDTO);
					
					/* 메뉴 목록을 보여준다. */
					if(Objects.isNull(searchList)) {
						System.out.println("SearchMenu의 검색 결과가 없습니다.");
					} else {
						for(MenuDTO menuDTO : searchList) {
							System.out.println(menuDTO);
						}
					}
					break;
				case 9 :
					return;
			}
		} while(true);
	}

	
	
	
	
	public static void chooseSubMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		
		do {
			System.out.println("========= choose 서브 메뉴 =========");
			System.out.println("1.카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
			System.out.println("9.이전 메뉴로");
			System.out.print("메뉴 번호를 입력해 주세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : /*카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)*/
					/*상위카테고리 입력 받기*/
					SearchCriteria searchCriteria = SearchCriteria();
					/*서비스 호출하기, 반환 받기*/
					List<MenuDTO> menuList = menuService.searchMenuBySubCategory(searchCriteria);
					
					/*목록을 보여준다.*/
					for(MenuDTO menuDTO : menuList) {
						System.out.println(menuDTO);
					}
					break;
					
				case 9 : /*이전 메뉴로 돌아가기*/
					return;
			}
		} while(true);
	}
	
	
	private static void foreahSubMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		
		do {
			System.out.println("========== foreah 서브 메뉴  ==========");
			System.out.println("1.랜덤한 메뉴 5개 추출해서 조회하기");
			System.out.println("9.이전 메뉴로 돌아가기");
			System.out.println("메뉴 번호를 입력해 주세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : /*랜덤한 메뉴 5개 추출해서 조회하기*/
					/*배열 또는 list에 랜덤 값 받기*/
					List<Integer> list = createRandomMenuCodeList();
					
					/*서비스 호출 -> 인자로 랜덤 값 넘김 -> 목록 받기*/
					List<MenuDTO> menuList = menuService.searchMenuByRandomMenuCode(list);
					
					/*목록 보여주기*/
					if(Objects.isNull(menuList)) {
						System.out.println("메뉴가 존재하지 않습니다.");
					} else {
						for(MenuDTO menuDTO : menuList) {
							System.out.println(menuDTO);
						}
					}
					
				case 9 : /*이전 메뉴로 돌아가기*/
					return;
			}
		} while(true);
	}
	
	
	private static void trimSubMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		
		do {
			System.out.println("================= trim 서브 메뉴 =================");
			System.out.println("1.조건이 있는 경우 메뉴코드로 조회, 단 없으면 전체 조회");
			System.out.println("2.메뉴 혹은 카테고리코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색하며, 검색 조건이 없을 경우 전체 검색");
			System.out.println("3.원하는 메뉴 정보만 수정하기");
			System.out.println("9.이전 메뉴로");
			System.out.print("메뉴 번호를 입력해 주세요 : ");
			int no = sc.nextInt();
			
			switch(no ) {
				case 1 : /*조건이 있는 경우 메뉴코드로 조회, 단 없으면 전체 조회*/
					/*메뉴코드 조건을 추가한다. 단 없으면 전체를 조회한다.*/
					SearchCriteria searchCriteria = inputAllOrOne();

					/*서비스 호출 -> 조회 결과를 반환 받음*/
					List<MenuDTO> menuList = menuService.searchMenuByCodeOrSearchAll(searchCriteria);
					
					/*목록을 보여줌*/
					if(Objects.isNull(menuList)) {
						System.out.println("검색 결과가 존재하지 않습니다...");
					} else {
						for(MenuDTO menuDTO : menuList) {
							System.out.println(menuDTO);
						}
					}
					break;
					
				case 2 : /*메뉴 혹은 카테고리코드로 검색, 단 메뉴와 카테고리 둘 다 일치하는 경우도 검색하며, 검색 조건이 없을 경우 전체 검색*/
					/*1.사용자에게 입력받는다.(메뉴,카테고리,둘 다,없음)*/
					Map<String, Object> searchMap = inputSearchCriteriaMap();
					/*2.서비스를 호출 -> 결과 반환*/
					List<MenuDTO> menuValue = menuService.searchMenuBynameOrCategory(searchMap);
					/*3.목록 보여주기*/
					if(Objects.isNull(menuValue)) {
						System.out.println("검색 결과가 존재하지 않습니다.");
					} else {
						for(MenuDTO menuDTO : menuValue) {
							System.out.println(menuDTO);
						}
					}
					break;
					
				case 3 : /*원하는 메뉴 정보만 수정하기*/
					/*입력받기*/
					Map<String, Object> valueMap = updateInput();
					/*서비스 호출해서 입력 넘기기*/
					int result = menuService.modifyMenu(valueMap);
					/*결과 받기 -> 성공 여부 확인*/
					if(result > 0) {
						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("수정이 실패되었습니다... rollback...");
					}
					break;
					
				case 9 : 
					return;
			}
		} while(true);
	}
	

	/*사용자 입력 함수*/
	private static SearchCriteria SearchCriteria() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.메뉴이름 또는 카테고리명(식사, 음료, 디저트) 입력");
			System.out.println("2.카테고리 상위 분류 입력");
			int no = sc.nextInt();
			
			switch(no) {
				case 1 : /*1.메뉴이름 또는 카테고리명(식사, 음료, 디저트) 입력*/
					sc.nextLine();
					while(true) {
						System.out.print("검색 기준을 입력해 주세요(name or category) : ");
						String condition = sc.nextLine();
						/*사용자가 입력을 잘못한 경우 null인데 어떻게 처리를 할까?*/
						if(condition.equals("name"/*메뉴이름*/) || condition.equals("category"/*카테고리명*/)) {
							System.out.print("검색명을 입력해 주세요 : ");
							String menuName = sc.nextLine();
							return new SearchCriteria(condition, menuName);
						}
					}
					
					
				case 2 : /*2.카테고리 상위 분류 입력*/
					sc.nextLine();
					System.out.print("카테고리 상위 분류 입력 : ");
					String value = sc.nextLine();
					return new SearchCriteria("category", value);
			}
		} while(true);
	}
	
	
	public static List<Integer> createRandomMenuCodeList(){
		Set<Integer> set = new HashSet<>();
		while(set.size() < 5) {
			/*1~21번까지만 난수를 발생한다.*/
			int temp = ((int)(Math.random()*21))+1;
			set.add(temp);
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list); /*리스트에 있는 값들 정렬해주기*/

		System.out.println(list.toString());
		
		return list; /**/
	}
	
	
	private static SearchCriteria inputAllOrOne() {
		Scanner sc = new Scanner(System.in);
		SearchCriteria searchCriteria = new SearchCriteria();
		
		while(true) {
			System.out.print("검색 조건을 입력하시겠습니까? (예 OR 아니오) : ");
			String value = sc.nextLine();
			
			if(value.contentEquals("예")) {
				System.out.print("검색할 메뉴 코드를 입력해 주세요 : ");
				String code = sc.nextLine();
				searchCriteria.setCondition("menuCode");
				searchCriteria.setValue(code);
				return searchCriteria;
			} else if(value.contentEquals("아니오")) {
				return searchCriteria;
			}
		}
		
	}
	
	

	private static Map<String, Object> inputSearchCriteriaMap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 조건을 입력해 주세요 (category or name or both or null) : ");
		String condition = sc.nextLine();
		
		Map<String, Object> criteria = new HashMap<>();
		if(condition.equals("category")) {
			System.out.print("카테고리 코드를 입력해 주세요 : ");
			int categoryValue = sc.nextInt();
			criteria.put("categoryValue", categoryValue);
		} else if(condition.contentEquals("name")) {
			System.out.print("이름을 입력해 주세요 : ");
			String nameValue = sc.nextLine();
			criteria.put("nameValue", nameValue);
		} else if(condition.contentEquals("both")) {
			System.out.print("이름을 입력해 주세요 : ");
			String nameValue = sc.nextLine();
			System.out.print("카테고리 코드를 입력해 주세요 : ");
			int categoryValue = sc.nextInt();
			criteria.put("nameValue", nameValue);
			criteria.put("categoryValue", categoryValue);
		} 
		
		return criteria;
	}
	
	
	private static Map<String, Object> updateInput(){
		Scanner sc = new Scanner(System.in);
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.print("수정 조건을 입력해 주세요(all, category, name) : ");
		String condition = sc.nextLine();
		System.out.print("메뉴 코드를 입력해 주세요 : ");
		int code = Integer.parseInt(sc.nextLine());
		
		if(condition.equals("all")) {
			System.out.print("이름을 입력해 주세요 : ");
			String nameValue = sc.nextLine();
			System.out.print("카테고리 코드를 입력해 주세요 : ");
			int categoryValue = Integer.parseInt(sc.nextLine());
			System.out.print("가격을 입력해 주세요 : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("판매여부를 입력해 주세요 : ");
			String status = sc.nextLine();
			
			map.put("nameValue", nameValue);
			map.put("categoryValue", categoryValue);
			map.put("price", price);
			map.put("status", status);
		} else if(condition.equals("category")) {
			System.out.println("카테고리 코드를 입력해 주세요 : ");
			int categoryValue = Integer.parseInt(sc.nextLine());
			map.put("categoryValue", categoryValue);
		} else if(condition.equals("name")) {
			System.out.println("이름을 입력해 주세요 : ");
			String nameValue = sc.nextLine();
			map.put("nameValue", nameValue);
		}
		
		map.put("code", code);
		return map;
	}
	
}
