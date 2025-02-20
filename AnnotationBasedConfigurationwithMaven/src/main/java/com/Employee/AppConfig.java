package com.Employee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Indicates this is a configuration class
@ComponentScan(basePackages = "com.Employee") // Scans specified package for beans
public class AppConfig {
}