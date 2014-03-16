package com.spring4.training.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring4.training.aop.TestApplication;

public class Spring4AOPTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");*/
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("D:\\Karthick\\InstalledApps\\GitHub\\Sprin4WebApp\\Spring4WebApp\\src\\main\\java\\beans.xml");
		TestApplication testApplication = (TestApplication) context.getBean("testApp");
		testApplication.testMethod1();
		testApplication.testMethod("");
		
		((AbstractApplicationContext)context).close();
		
		System.out.println(sha2("345"));
	}

	static String sha2(String input) throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = messageDigest.digest(input.getBytes());
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i=0; i < result.length; i++){
			stringBuilder.append(Integer.toString((result[i] & 0xff)+0x100, 16).substring(1));
		}
		
		return stringBuilder.toString();
	}
}
