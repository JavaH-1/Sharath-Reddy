package com.EmployeeExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this class as a Spring Configuration
public class AppConfig {

	@Bean  // Defines an Employee bean
	public Employee employee() 
	{
		return new Employee("Sharath Chandra", "Java Developer", 75000.00);
	}
}
