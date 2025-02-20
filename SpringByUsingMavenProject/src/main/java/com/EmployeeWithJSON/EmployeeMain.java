package com.EmployeeWithJSON;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeMain 
{
    public static void main(String[] args) 
    {
        // Load ApplicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Employee Bean
        Employee employee = (Employee) context.getBean("employeeBeanJson");

        // Print Employee Details
        System.out.println("Employee Details:\n" + employee);

        // Convert Employee Object to JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            System.out.println("\nEmployee JSON:\n" + jsonOutput);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // Close Context
        ((ClassPathXmlApplicationContext) context).close();
    }
}