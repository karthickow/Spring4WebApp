package com.spring4.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.spring4.intf.IHotDrink;

//public class Restaurant implements InitializingBean, DisposableBean {
public class Restaurant {
	
	private IHotDrink hotDrink;
	private List<String> restaurantWaitersList;
	private Set<String> restaurantWaitersSet;
	private Map<Integer, String> restaurantWaitersMap;
	private Properties pros;
	private String welcomeNote;
	private int id;
	private String name;

	public Restaurant() {
	}
	
	public Restaurant(int id, String name, IHotDrink hotDrink) {
		this.id = id;
		this.name = name;
		this.hotDrink = hotDrink;
	}
	
	public void setRestaurantWaitersList(List<String> restaurantWaitersList) {
		this.restaurantWaitersList = restaurantWaitersList;
	}
	
	public void setRestaurantWaitersSet(Set<String> restaurantWaitersSet) {
		this.restaurantWaitersSet = restaurantWaitersSet;
	}

	public void setRestaurantWaitersMap(Map<Integer, String> restaurantWaitersMap) {
		this.restaurantWaitersMap = restaurantWaitersMap;
	}

	public void setPros(Properties pros) {
		this.pros = pros;
	}

	public void displayWaitersNames(){
		System.out.println("All waiters working in Restaurant List : "+restaurantWaitersList);
		System.out.println("All waiters working in Restaurant Set : "+restaurantWaitersSet);
		System.out.println("All waiters working in Restaurant Map : "+restaurantWaitersMap);
		System.out.println("All waiters working in Restaurant Properties : "+pros);
	}
	
	public void setHotDrink(IHotDrink hotDrink){
		this.hotDrink = hotDrink;
	}
	
	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}
	
	public void greetCustomer(){
		System.out.println(welcomeNote);
	}
	
	public void prepareHotDrink(){
		hotDrink.prepareHotDrink();
	}
		
	public void init(){
		System.out.println("Restaurant Bean is going though init.");
	}
	
	@PostConstruct
	public void afterPropertiesSet(){
		System.out.println("Restaurant Bean is going though init.");		
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Bean will destroy now.");
	}
	
	@Override
	public String toString() {
		return "Restaurant [welcomeNote=" + welcomeNote + ", id=" + id
				+ ", name=" + name + "]";
	}
}
