package com.spring4.training.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring4.training.aop.TestApplication;

public class Spring4AOPTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		TestApplication testApplication = (TestApplication) context.getBean("testApp");
		testApplication.testMethod1();
		testApplication.testMethod("");
		
		((AbstractApplicationContext)context).close();
	}

}
