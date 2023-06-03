package com.greedy.section02.javaconfig;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.greedy.section02.javaconfig.MenuDTO;

/* <DAO 계층>
 * 데이터 베이스와 매핑되어 쿼리를 수행한다.*/
public interface MenuDAO {
	
	@Results(id="menuResultMap", value = {
			@Result(id=true, property="code", column="MENU_CODE"),
			@Result(property="name", column="MENU_CODE"),
			@Result(property="price", column="MENU_RRICE"),
			@Result(property="categoryCode", column="CATEGORY_CODE"),
			@Result(property="orderableSatus", column="ORDERABLE_STATUS")
			
	})

	@Select("SELECT\r\n" + 
			"			   *\r\n" + 
			"		  FROM TBL_MENU\r\n" + 
			"		 WHERE ORDERABLE_STATUS = 'Y' \r\n" + 
			"		 ORDER BY MENU_CODE ")
	List<MenuDTO> selectAllMenu();

	/*재사용을 위한 코드*/
	@Select("SELECT * FROM TBL_MENU WHERE MENU_CODE = #{code}")
	@ResultMap("menuResultMap")
	MenuDTO selectMenuByCode(@Param("code") int code);
	
	
	@Insert("INSERT\r\n" + 
			"			INTO TBL_MENU\r\n" + 
			"			(\r\n" + 
			"				MENU_CODE,\r\n" + 
			"				MENU_NAME,\r\n" + 
			"				MENU_PRICE,\r\n" + 
			"				CATEGORY_CODE,\r\n" + 
			"				ORDERABLE_STATUS\r\n" + 
			"			)\r\n" + 
			"			VALUES\r\n" + 
			"			(\r\n" + 
			"				SEQ_MENU_CODE.NEXTVAL,\r\n" + 
			"				#{ name },\r\n" + 
			"				#{ price },\r\n" + 
			"				#{ categoryCode },\r\n" + 
			"				'Y'\r\n" + 
			"			)")
	int insertMenu(MenuDTO menu);

	
	
	@Update("UPDATE TBL_MENU\r\n" + 
			"			SET MENU_NAME = #{name},\r\n" + 
			"			    MENU_PRICE = #{price},\r\n" + 
			"			    CATEGORY_CODE = #{categoryCode}\r\n" + 
			"		 WHERE MENU_CODE = #{code}")
	int modifyMenu(ModifyMenuDTO menuDTO);

	
	@Update("UPDATE TBL_MENU\r\n" + 
			"SET ORDERABLE_STATUS = 'N'" +
			"		WHERE MENU_CODE = #{code}")
	int removeMenu(int code);
	
	
}
