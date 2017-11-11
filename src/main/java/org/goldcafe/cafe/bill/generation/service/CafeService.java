package org.goldcafe.cafe.bill.generation.service;

import java.util.List;
import java.util.Map;

import org.goldcafe.cafe.bill.generation.dao.CafeDao;
import org.goldcafe.cafe.bill.generation.entity.Item;
import org.goldcafe.cafe.bill.generation.vo.Order;

public class CafeService {
	private CafeDao cafeDao;
	public CafeService() {
		cafeDao = new CafeDao();
	}
	
	public String placeOrder(List<Order> orderList){
		try{
			printBill(orderList);
			return "SUCCESS";
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "FAILED TO PLACE ORDER";
	}
	
	public void printBill(List<Order> orderList){
		int total = calculateTotal(orderList);
		int discountValue = calculateDiscount(total);
		int finalAmount = total - discountValue;
		System.out.println("\n==============   BILL   ==============");
		System.out.println("Item Name\tCount\tPrice(INR)");
		List<Item> itemList = cafeDao.getCafeMenu();
		for(Order order : orderList){
			for(Item item : itemList){
				if(item.getCode().equalsIgnoreCase(order.getItemCode()))
					System.out.println(item.getName() + "\t" + order.getCount() + "\t" + order.getCount() * item.getPrice());
			}
		}
		System.out.println("Total\t\t" + total);
		System.out.println("Discount\t\t" + discountValue);
		System.out.println("Final Amount\t\t" + finalAmount);
	}
	
	public int calculateTotal(List<Order> orderList){
		Map<String, Integer> itemPriceMap = CafeDao.getItemPriceMap();
		int totalBill = 0;
		for(Order order : orderList){
			int unitPrice = itemPriceMap.get(order.getItemCode());
			totalBill = totalBill + (unitPrice * order.getCount());
		}
		return totalBill;
	}
	
	public int calculateDiscount(int orderAmt){
		int discountAmt = 0;
		if(orderAmt > 100 && orderAmt < 200){
			discountAmt = orderAmt*10/100;
			return discountAmt;
		}
		if(orderAmt > 200){
			int firstDiscount = 100*10/100;
			int restDiscount = (orderAmt - 100)*20/100;
			discountAmt = firstDiscount + restDiscount;
		}
		return discountAmt;
	}
	
	public void displayCafeMenu(){
		fomatedMenuCard(cafeDao.getCafeMenu());
	}
	
	private void fomatedMenuCard(List<Item> itemList){
		System.out.println("============== MENU CARD ==============");
		System.out.println("Item-Name\tPrice");
		for(Item item : itemList){
			System.out.println(item.getName()+ "\t" + item.getPrice());
			
		}
	}

}
