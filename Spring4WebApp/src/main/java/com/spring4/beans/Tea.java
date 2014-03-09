package com.spring4.beans;

import com.spring4.intf.IHotDrink;

public class Tea implements IHotDrink{

	public void prepareHotDrink() {
		System.out.println("Dear Customer, we are preparing Tea for you!!");
	}
}
