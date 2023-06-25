package com.greedy.section01.xmlconfig.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.greedy.section01.xmlconfig.dto.MenuDTO;
import com.greedy.section01.xmlconfig.dto.ModifyMenuDTO;

/* <DAO 계층>
 * 데이터 베이스와 매핑되어 쿼리를 수행한다.*/

@Repository("MenuDAO")
public class MenuDAO {

	public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
		
		return sqlSession.selectList("MenuMapper.selectAllMenu");
	}

	public static MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
		
		return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
	}

	public static int insertMenu(SqlSession sqlSession, MenuDTO menu) {
		
		return sqlSession.insert("MenuMapper.insertMenu", menu);
	}

	public static int modifyMenu(SqlSession sqlSession, ModifyMenuDTO menuDTO) {
		return sqlSession.update("MenuMapper.modifyMenu", menuDTO);
	}

	public static int removeMenu(SqlSession sqlSession, int code) {
		return sqlSession.delete("MenuMapper.removeMenu", code);
	}
	
	
}
