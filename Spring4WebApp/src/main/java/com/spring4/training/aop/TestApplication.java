package com.spring4.training.aop;

public class TestApplication {
	public void testMethod(String s){
		System.out.println("This testMethod is used for advice weaving before and after");
	}
	
	public void testMethod1(){
		System.out.println("This testMethod1 is used for advice weaving before and after");
	}
}
