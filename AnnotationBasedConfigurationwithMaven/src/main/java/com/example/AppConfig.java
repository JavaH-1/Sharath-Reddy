package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this class as a configuration class
@ComponentScan(basePackages = "com.example")  // Tells Spring where to scan for components
public class AppConfig {
}
