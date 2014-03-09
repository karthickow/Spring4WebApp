package com.spring4.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BeanPostProcessorDemo implements BeanPostProcessor, Ordered{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(this.getClass().getName() + " Called before any bean initialization callbacks. "+ beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(this.getClass().getName() + " Called after any bean initialization callbacks. "+ beanName);
		return bean;
	}

	public int getOrder() {
		return 1;
	}

}
