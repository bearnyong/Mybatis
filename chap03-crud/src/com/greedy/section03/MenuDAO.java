package com.greedy.section03;


import java.util.List;

public interface MenuDAO {
	
	List<MenuDTO> selectAllMenu();
	
	MenuDTO selectMenuByCode(int code);
	
	int insertMenu(MenuDTO menu);

	int modifyMenu(ModifyMenuDTO menuDTO);

	int removeMenu(int code);
	
	
}