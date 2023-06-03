package com.greedy.section01.xmlconfig.dto;

public class ModifyMenuDTO {
	
	private String code;
	private String name;
	private String price;
	private String categoryCode;
	
	public ModifyMenuDTO() {
		super();
	}
	
	public ModifyMenuDTO(String code, String name, String price, String categoryCode) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.categoryCode = categoryCode;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	@Override
	public String toString() {
		return "ModifyMenuDTO [code=" + code + ", name=" + name + ", price=" + price + ", categoryCode=" + categoryCode
				+ "]";
	}

}
