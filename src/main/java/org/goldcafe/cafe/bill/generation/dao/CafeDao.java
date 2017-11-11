package org.goldcafe.cafe.bill.generation.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.goldcafe.cafe.bill.generation.entity.Item;

public class CafeDao {
	private static List<Item> itemList;
	private static Map<String,Integer> itemPriceMap;
	static{
		itemPriceMap = new HashMap<>();
		itemList = new ArrayList<>();
		Item t1 = new Item("TM","Tea - Masala",10);
		Item t2 = new Item("TI","Tea - Ice",15);
		Item t3 = new Item("TL","Tea - Lemon",15);
		
		Item c1 = new Item("CC","Coffee - Cold",15);
		Item c2 = new Item("CL","Coffee - Latte",30);
		Item c3 = new Item("CM","Coffee - Mocha",40);
		
		Item cd1 = new Item("CDC","Cold Drinks - Coke",20);
		Item cd2 = new Item("CDP","Cold Drinks - Pepsi",20);
		Item cd3 = new Item("CDS","Cold Drinks - Sprite",15);
		
		itemList.add(t1); itemList.add(t2); itemList.add(t3);
		itemList.add(c1); itemList.add(c2); itemList.add(c3);
		itemList.add(cd1); itemList.add(cd2); itemList.add(cd3);
		
	}
	
	public List<Item> getCafeMenu(){
		return itemList;
	}
	
	public static Map<String,Integer> getItemPriceMap(){
		for(Item item : itemList){
			itemPriceMap.put(item.getCode(), item.getPrice());
		}
		return itemPriceMap;
	}
}
