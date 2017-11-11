package org.goldcafe.cafe.bill.generation.entity;

public class Item{
	private String code;
	private String name;
	private int price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String code, String name, int price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return "Item [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
}
