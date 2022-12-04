package de.uni.koeln.sse.se;

import java.util.ArrayList;

public class ShoppingBasket {
	public static Items item_list=new Items();
	private static Integer totalPrice=0;
	

	ArrayList<String> MyItems=new ArrayList<String>();

	public ShoppingBasket() {

	}
	
	public void addTobasket(String item) {
		

		setTotalPrice(getTotalPrice()+ item_list.getPrice(item));
			
		
	}
	
public Integer getBill() {
	int a = getTotalPrice();
	ShoppingBasket.totalPrice=0;
	return a;
		
		
	}

public  Integer getTotalPrice() {
	return totalPrice;
}

public  void setTotalPrice(Integer totalPrice) {
	ShoppingBasket.totalPrice = totalPrice;
}

}
