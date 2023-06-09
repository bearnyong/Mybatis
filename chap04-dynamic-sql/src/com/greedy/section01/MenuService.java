package com.greedy.section01;

import static com.greedy.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

	public List<MenuDTO> searchMenu(SearchCriteria searchDTO) {
		/*1.sqlConnection*/
		SqlSession sqlSession = getSqlSession();
		
		/*2.매퍼 호출*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		/*3.도메인 로직 수행(카테고리 또는 이름을 입력 받아 조회하기)*/
		/*3.1.쿼리 수행하기(결과가 N개가 될 수 있음)*/
		List<MenuDTO> menuList = mapper.searchMenu(searchDTO);
		
		/*4.커넥션 닫기*/
		sqlSession.close();

		/*if : 카테고리에 해당하는 메뉴가 없는 경우*/
		/*5.반환하기*/
		if(Objects.isNull(menuList)) {
			return null;
		} else {
			return menuList;
		}
		
	}

	public List<MenuDTO> searchMenuBySubCategory(SearchCriteria searchCriteria) {
		/*sqlSession 생성하기*/
		SqlSession sqlSession = getSqlSession();
		
		/*매퍼 꺼내오기*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		/*도메인 로직 -> 쿼리실행 -> 결과 확인*/
		List<MenuDTO> menuList = mapper.searchMenuBySubCategory(searchCriteria);
		
		/*커넥션 닫기*/
		sqlSession.close();
		
		/*반환하기*/
		return menuList;
	}

	public List<MenuDTO> searchMenuByRandomMenuCode(List<Integer> list) {
		/*sqlSession을 생성한다.*/
		SqlSession sqlSession = getSqlSession();
		
		/*매퍼를 호출한다.*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		/*도메인 로직 -> 쿼리 -> 결과확인*/
		Map<String, List<Integer>> criteria = new HashMap<>();
		criteria.put("randomMenuCodeList", list);
		
		List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(/*criteria*/);
		
		/*Session(커넥션) 닫기*/
		sqlSession.close();
		
		/*반환하기*/
		if(menuList.size() == 0) {
			return null;
		} else {
			return menuList;
		}
		
	}

	public List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
		/*sqlSession을 생성한다.*/
		SqlSession sqlSession = getSqlSession();
		
		/*매퍼를 호출한다.*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		/*도메인 로직 -> 쿼리 -> 결과확인*/
		List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
		
		/*Session(커넥션) 닫기*/
		sqlSession.close();
		
		/*반환하기*/
		if(menuList.size() == 0) {
			return null;
		} else {
			return menuList;
		}
	}

	public List<MenuDTO> searchMenuBynameOrCategory(Map<String, Object> searchMap) {
		/*sqlSession을 생성한다.*/
		SqlSession sqlSession = getSqlSession();
		
		/*매퍼를 호출한다.*/
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		/*도메인 로직 -> 쿼리 -> 결과확인*/
		List<MenuDTO> menuList = mapper.searchMenuBynameOrCategory(searchMap);
		
		/*Session(커넥션) 닫기*/
		sqlSession.close();
		
		/*반환하기*/
		if(menuList.size() == 0) {
			return null;
		} else {
			return menuList;
		}
		
	}

	public int modifyMenu(Map<String, Object> valueMap) {
		/*sqlSession을 생성한다.*/
		SqlSession session = getSqlSession();
		
		/*매퍼를 호출한다.*/
		mapper = session.getMapper(DynamicSqlMapper.class);
		
		/*도메인 로직 -> (생략)유효성 체크([controller] price가 양수값인지, menucode 참조키 이런거 다 신경써야됨...)
		 * -> 쿼리 -> 결과확인*/
		int result = mapper.modifyMenuuu(valueMap);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		/*Session(커넥션) 닫기*/
		session.close();
		
		/*반환하기*/
		return result;
	}


}
