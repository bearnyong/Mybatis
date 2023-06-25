package com.greedy.section01.xmlconfig.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.section01.xmlconfig.dao.MenuDAO;
import com.greedy.section01.xmlconfig.dto.MenuDTO;
import com.greedy.section01.xmlconfig.dto.ModifyMenuDTO;

import static com.greedy.section01.xmlconfig.common.Template.getSession;

/* <서비스 계층>
 * 데이터 베이스 커넥션을 한다.
 * 도메인 로직에 집중을 한다.*/

/*2*/@Service
public class MenuService {
	
	private final MenuDAO menuDAO;
	
	/*2*/@Autowired
	public MenuService() {
		menuDAO = new MenuDAO();
	}

	public List<MenuDTO> findAllMenus() {
		SqlSession sqlSession = getSession();
		List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
		sqlSession.close();
		
		return menuList;
	}

	public MenuDTO findMenuByMenuCode(int code) {
		SqlSession sqlSession = getSession();
		MenuDTO menu = MenuDAO.selectMenuByCode(sqlSession, code);
		sqlSession.close();
		
		return menu;
	}
	
	public boolean registNewMenu(MenuDTO menu) {
		SqlSession sqlSession = getSession();
		
		int result = MenuDAO.insertMenu(sqlSession, menu);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result > 0 ? true:false;
	}

	public int modifyMenu(ModifyMenuDTO menuDTO) {
		SqlSession sqlSession = getSession();
		
		int result = MenuDAO.modifyMenu(sqlSession, menuDTO);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

	public int removeMenu(int code) {
		SqlSession sqlSession = getSession();
		int result = MenuDAO.removeMenu(sqlSession, code);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

}
