package com.Employee;

import org.springframework.stereotype.Component;

@Component // Marks this class as a Spring Bean
public class Employee {
    private String name = "Sharath Chandra";
    private String position = "Java Developer";
    private double salary = 85000.00;

    public void displayEmployeeInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
    }
}
