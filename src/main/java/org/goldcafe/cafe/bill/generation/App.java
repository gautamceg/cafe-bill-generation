package org.goldcafe.cafe.bill.generation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.goldcafe.cafe.bill.generation.service.CafeService;
import org.goldcafe.cafe.bill.generation.vo.Order;

/**
 * GOLD CAFE BILL GENERATION
 *
 */
public class App 
{
	private static CafeService cafeService;
	static{
		cafeService = new CafeService();
	}
    public static void main( String[] args )
    {
        System.out.println( "******** GOLD CAFE BILL GENERATION *********" );
        Order order1 = new Order("TM", 10);
        Order order2 = new Order("CC", 10);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        
        
        cafeService.displayCafeMenu();
        System.out.println(placeOrder(orderList));
        
    }
    
    public static String placeOrder(List<Order> orderList){
    	return cafeService.placeOrder(orderList);
    }
}
