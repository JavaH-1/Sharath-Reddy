package com.BankExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this class as a Spring Configuration
public class AppConfig {

	@Bean  // Defines a BankAccount bean
	public BankAccount bankAccount() 
	{
		return new BankAccount("Sharath Chandra", 1000.00);
	}
}

