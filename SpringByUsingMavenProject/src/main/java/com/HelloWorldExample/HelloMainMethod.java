package com.HelloWorldExample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringXMLBasedConfiguration.Employee;

public class HelloMainMethod {

	public static void main(String[] args) {

		// loading the Bean and XML definitions from the given XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieving a bean of type HelloMainMethod with the ID "helloWorldService"-
		//-from the Spring container
		
		HelloWorldService obj =(HelloWorldService) context.getBean("helloWorldService");
		
		
		obj.hello();
		context.close();
	}
}


