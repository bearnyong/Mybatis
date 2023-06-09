package com.greedy.mapper;

import java.util.List;
import java.util.Map;

import com.greedy.dto.MenuDTO;
import com.greedy.dto.SearchCriteria;

public interface DynamicSqlMapper {

	List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

	List<MenuDTO> searchMenu(SearchCriteria searchDTO);

	List<MenuDTO> searchMenuBySubCategory(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuByRandomMenuCode(/*Map<String, List<Integer>> criteria*/);

	List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuBynameOrCategory(Map<String, Object> searchMap);

	int modifyMenuuu(Map<String, Object> valueMap);
	

}
