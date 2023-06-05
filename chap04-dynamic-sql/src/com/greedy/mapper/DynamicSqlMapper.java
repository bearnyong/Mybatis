package com.greedy.mapper;

import java.util.List;
import java.util.Map;

import com.greedy.dto.MenuDTO;

public interface DynamicSqlMapper {

	List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);
	

}
