package com.greedy.section01;

import static com.greedy.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.greedy.dto.MenuDTO;
import com.greedy.dto.SearchCriteria;
import com.greedy.mapper.DynamicSqlMapper;

public class MenuService {
	
	/*초기화 시점...*/
	private DynamicSqlMapper mapper;

	public List<MenuDTO> selectMenuByPrice(int price) {
		/* <서비스의 역할>
		 * 1.데이터베이스 커넥션
		 * 1.1.사용할 매퍼 가져오기
		 * 2.도메인 로직 수행
		 * 2.1.쿼리 수행
		 * 2.2.커넥션 닫기
		 * 2.3.결과 반환 */
		
		/*1.데이터베이스 커넥션*/
		SqlSession sqlSession = getSqlSession();
		
		/*1.1.사용할 매퍼 가져오기*/
//		System.out.println("생성 전 : " + mapper); /*매퍼 생성 전 후 확인하기*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
//		System.out.println("생성 후 : " + mapper);
		
		/*map에 값 담아 주기*/
		Map<String, Integer> map = new HashMap<>();
		map.put("price", price);
		
		/*2.1.쿼리 수행 (:결과가 있다)*/
		/*selectMenuByPrice()의 interface ID와 쿼리문의 ID명 같게...*/
		List<MenuDTO> menuList = /*쿼리불러오기*/mapper.selectMenuByPrice(map);
		
		/*sqlSession 닫기*/
		sqlSession.close();
		
		/*반환하기*/
		return menuList;
	}

	public void selectMenuBySubCategory(SearchCriteria searchDTO) {
		/*1.sqlConnection*/
		SqlSession sqlSession = getSqlSession();
		
		/*2.매퍼 호출*/
		
		/*3.도메인 로직 수행*/
		/*3.1.쿼리 수행하기*/
		/*4.커넥션 닫기*/
		/*5.반환하기*/
		
	}

}
