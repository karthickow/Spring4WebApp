package com.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.beans.Restaurant;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Restaurant restaurant  = (Restaurant)context.getBean("restaurant");
		//restaurant.greetCustomer();
		//restaurant.prepareHotDrink();
		//restaurant.displayWaitersNames();
		//System.out.println(restaurant);
		//restaurant.setWelcomeNote("Object1 is setting welcome note property");
		restaurant.greetCustomer();
		
		/*Restaurant restaurant1  = (Restaurant)context.getBean("restaurant");
		restaurant1.greetCustomer();*/
		
		((AbstractApplicationContext)context).close();
	}
}
