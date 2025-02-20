package com.student;

import org.springframework.stereotype.Component;

@Component  // This tells Spring that this is a Bean
public class Student {
    private String name = "Sharath Chandra";
    private int age = 22;

    public void displayStudentInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}