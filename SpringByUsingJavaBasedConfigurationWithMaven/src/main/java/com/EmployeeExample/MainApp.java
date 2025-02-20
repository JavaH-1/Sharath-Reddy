package com.EmployeeExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring Context using Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve the Employee Bean
        Employee employee = context.getBean(Employee.class);
        
        // Call Method to Display Employee Info
        employee.displayEmployeeInfo();
        
        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}