package org.goldcafe.cafe.bill.generation.vo;

public class Order {
	private String itemCode;
	private int count;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String itemCode, int count) {
		super();
		this.itemCode = itemCode;
		this.count = count;
	}

	public String getItemCode() {
		return itemCode;
	}

	public int getCount() {
		return count;
	}

}
