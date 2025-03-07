package com.EmployeeWithOutJson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        // Load ApplicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Employee Bean
        Employee employee = (Employee) context.getBean("employeeBeanNoJson");

        // Print Employee Details
        System.out.println("Employee Details:\n" + employee);

        // Close Context
        ((ClassPathXmlApplicationContext) context).close();
    }
}