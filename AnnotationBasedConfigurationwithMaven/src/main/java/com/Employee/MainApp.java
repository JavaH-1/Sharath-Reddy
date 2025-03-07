package com.Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Initialize Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Employee Bean
        Employee employee = context.getBean(Employee.class);

        // Display Employee Information
        employee.displayEmployeeInfo();

        // Close the Context
        ((AnnotationConfigApplicationContext) context).close();
    }
}

