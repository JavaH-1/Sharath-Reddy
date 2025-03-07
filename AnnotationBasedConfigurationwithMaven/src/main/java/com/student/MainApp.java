package com.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Get the Student Bean
        Student student = context.getBean(Student.class);
        
        // Call method
        student.displayStudentInfo();
        
        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}