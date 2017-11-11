package org.goldcafe.cafe.bill.generation.offer;
import org.goldcafe.cafe.bill.generation.util.Constant;

public class BaseDiscount {
	
	public int calculateDiscount(int total){
		int discountAmt = 0;
		if(total > Constant.BASE_DISCOUNT_AMT && total < Constant.EXTENDED_DISCOUNT_AMT){
			discountAmt = total*Constant.BASE_DISCOUNT_AMT/100;
			return discountAmt;
		}
		return discountAmt;
	}

}
