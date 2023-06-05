package com.greedy.dto;

public class MenuDTO {
	/* <menuDTO>
	 * 필드 = 컬럼(사용자에게 제공하려고 하는 것에 맞춤)
	 * 
	 * SQL Developer에서 필요한 값(컬럼명) 가져오기*/
	
	/*외부에서 DTO 객체의 직접적인 조작을 제한하기 위해 private 설정*/
	private int menuCode;
	private String menuName;
	private int menuPrice;
	private int categoryCode;
	private String status;
	
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String status) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.categoryCode = categoryCode;
		this.status = status;
	}
	public int getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "MenuDTO [menuCode=" + menuCode + ", menuName=" + menuName + ", menuPrice=" + menuPrice
				+ ", categoryCode=" + categoryCode + ", status=" + status + "]";
	}
	
	
}
