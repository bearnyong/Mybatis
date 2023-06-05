package com.greedy.section03;

import java.util.List;
import java.util.Map;

/* 사용자의 요청을 매핑하는 역할을 수행한다.
 * 사용자 입력 값을 유효성을 체크한다.
 * */
public class MenuController {

	private final MenuService menuService;
	private final PrintResult printResult;

	public MenuController() {
		this.menuService = new MenuService();
		this.printResult = new PrintResult();
	}

	public void findAllMenus() {
		List<MenuDTO> menuList = menuService.findAllMenus();
		if (menuList != null) {
			printResult.printMenuList(menuList);
		} else {
			printResult.printErrorMessage("findAllMenus");
		}
	}
	

	
	/*case2*/
	public void findMenuByMenuCode(Map<String, String> inputMenuCode) {
		int code = Integer.parseInt(inputMenuCode.get("code"));

		MenuDTO menu = menuService.findMenuByMenuCode(code);
		if (menu == null) {
			printResult.printErrorMessage("findMenuByMenuCode");
		} else {
			printResult.printMenu(menu);
		}

	}

	
	/*case3*/
	public void registNewMenu(Map<String, String> inputMenu) {
		String name = inputMenu.get("name");
		int price = Integer.parseInt(inputMenu.get("price"));
		int categoryCode = Integer.parseInt(inputMenu.get("categoryCode"));

		MenuDTO menu = new MenuDTO();
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);

		if (menuService.registNewMenu(menu)) {
			printResult.printSuccessMessage("registNewMenu");
		} else {
			printResult.printErrorMessage("registNewMenu");
		}
	}

	
	/*case4*/
	public void modifyMenu(Map<String, String> inputModifyMenu) {
		ModifyMenuDTO menuDTO = new ModifyMenuDTO();

		menuDTO.setCode(inputModifyMenu.get("code"));
		menuDTO.setName(inputModifyMenu.get("name"));
		menuDTO.setPrice(inputModifyMenu.get("price"));
		menuDTO.setCategoryCode(inputModifyMenu.get("categoryCode"));
		int result = menuService.modifyMenu(menuDTO);

		if (result > 0) {
			printResult.printSuccessMessage("modifyMenu");
		} else {
			printResult.printErrorMessage("notModify");
		}
	}

	
	
	/*case5*/
	public void removeMenu(Map<String, String> inputMenuCode) {
		int code = Integer.parseInt(inputMenuCode.get("code"));

		int result = menuService.removeMenu(code);

		if(result > 0 ) {
			printResult.printSuccessMessage("removeMenu");
		}else {
			printResult.printErrorMessage("notremove");
		}
	}

}