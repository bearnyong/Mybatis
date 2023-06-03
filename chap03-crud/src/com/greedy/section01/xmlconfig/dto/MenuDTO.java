package com.greedy.section01.xmlconfig.dto;

public class MenuDTO {
	
	private int code;
	private String name;
	private int price;
	private int categoryCode;
	private String orderableSatus;
	
	public MenuDTO() {
		
	}

	public MenuDTO(int code, String name, int price, int categoryCode, String orderableSatus) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.categoryCode = categoryCode;
		this.orderableSatus = orderableSatus;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getOrderableSatus() {
		return orderableSatus;
	}

	public void setOrderableSatus(String orderableSatus) {
		this.orderableSatus = orderableSatus;
	}

	@Override
	public String toString() {
		return "MenuDTO [code=" + code + ", name=" + name + ", price=" + price + ", categoryCode=" + categoryCode
				+ ", orderableSatus=" + orderableSatus + "]";
	}
	
}
