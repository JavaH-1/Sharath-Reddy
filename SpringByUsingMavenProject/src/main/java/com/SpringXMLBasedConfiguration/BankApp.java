package com.SpringXMLBasedConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * BankApp - This is the main application class that demonstrates 
 * Spring XML-based configuration for Dependency Injection.
 */

public class BankApp {

	
	public static void main(String[] args) {

		// Initializing Spring ApplicationContext with the XML configuration file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieving a bean of type Employee with the ID "manager" from the Spring container
		Employee e = (Employee) context.getBean("manager");
		
		// Calling the doWork() method to execute employee tasks
		e.doWork();
	}

}