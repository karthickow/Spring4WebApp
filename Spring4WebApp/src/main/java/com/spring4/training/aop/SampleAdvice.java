package com.spring4.training.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAdvice {
	@Before("execution(public * testMethod*())")
	public void insertBefore(){
		System.out.println("Insterted before method");
	}
	
	@After("execution(public * testMethod(..))")
	public void insertAfter(){
		System.out.println("Insterted after method");	
	}
}
