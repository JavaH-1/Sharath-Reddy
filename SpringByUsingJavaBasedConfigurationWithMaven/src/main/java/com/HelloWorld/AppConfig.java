package com.HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this class as a Spring Configuration
public class AppConfig 
{

	@Bean  // Defines a Spring Bean
	public HelloWorld helloWorld() 
	{
		return new HelloWorld();
	}
}