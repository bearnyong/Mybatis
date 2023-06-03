package com.greedy.section02.javaconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.greedy.section02.javaconfig.MenuDAO;
import com.greedy.section02.javaconfig.MenuDTO;
import com.greedy.section02.javaconfig.ModifyMenuDTO;

import static com.greedy.section02.javaconfig.Template.getSession;

/* <서비스 계층>
 * 데이터 베이스 커넥션을 한다.
 * 도메인 로직에 집중을 한다.*/
public class MenuService {
	
	public List<MenuDTO> findAllMenus() {
		SqlSession sqlSession = getSession();
		System.out.println(sqlSession);
		
		MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);
		List<MenuDTO> menus = menuDAO.selectAllMenu();
		sqlSession.close();
		
		return menus;
	}

	public MenuDTO findMenuByMenuCode(int code) {
		SqlSession sqlSession = getSession();
		MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);
		
		MenuDTO menu = menuDAO.selectMenuByCode(code);
		sqlSession.close();
		
		return menu;
	}
	
	public boolean registNewMenu(MenuDTO menu) {
		SqlSession sqlSession = getSession();
		
		MenuDAO menuDao = sqlSession.getMapper(MenuDAO.class);
		int result = menuDao.insertMenu(menu);
		
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
		
		MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);
		int result = menuDAO.modifyMenu(menuDTO);
		
		
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
		
		MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);
		
		int result = menuDAO.removeMenu(code);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

}
