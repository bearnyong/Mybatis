package com.greedy.section03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MenuController menuController = new MenuController();

		do {
			System.out.println("======= 메뉴 관리 ========");
			System.out.println("1. 메뉴 전체 조회");
			System.out.println("2. 메뉴 코드로 조회");
			System.out.println("3. 신규 메뉴 추가");
			System.out.println("4. 메뉴 수정");
			System.out.println("5. 메뉴 삭제");
			System.out.println(" 메뉴 관리 번호를 입력해주세요 :");
			int no = sc.nextInt();

			switch (no) {
			case 1:
				menuController.findAllMenus();
				break;
			case 2:
				menuController.findMenuByMenuCode(inputMenuCode());
				break;
			case 3:
				menuController.registNewMenu(inputMenu());
				break;
			case 4:
				menuController.modifyMenu(inputModifyMenu());
				break;
			case 5:
				menuController.removeMenu(inputMenuCode());
				break;

			default:
				System.out.println("잘못된 메뉴를 선택하였습니다.");
				break;
			}
		} while (true);

	}

	
	/*case2*/
	private static Map<String, String> inputMenuCode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 코드를 입력해주세요 : ");
		String code = sc.nextLine();

		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("code", code);

		return parameter;
	}

	
	/*case3*/
	private static Map<String, String> inputMenu() {

		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴의 이름을 입력해주세요 : ");
		String name = sc.nextLine();

		System.out.println("메뉴의  가격을 입력해주세요 : ");
		String price = sc.nextLine();

		System.out.println("카테고리 코드를 입력해주세요 : ");
		String categoryCode = sc.nextLine();

		Map<String, String> parmeter = new HashMap<>();
		parmeter.put("name", name);
		parmeter.put("price", price);
		parmeter.put("categoryCode", categoryCode);

		return parmeter;
	}
	
	

	/*case4*/
	private static Map<String, String> inputModifyMenu() {

		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 메뉴 코드를 입력해주세요 : ");
		String code = sc.nextLine();

		System.out.println("수정할 메뉴 이름을 입력해주세요 : ");
		String name = sc.nextLine();

		System.out.println("수정할 메뉴 가격을 입력해주세요 : ");
		String price = sc.nextLine();

		System.out.println("수정할 카테고리 코드를 입력해주세요 : ");
		String categoryCode = sc.nextLine();

		Map<String, String> parmeter = new HashMap<>();
		parmeter.put("code", code);
		parmeter.put("name", name);
		parmeter.put("price", price);
		parmeter.put("categoryCode", categoryCode);

		return parmeter;
	}

}