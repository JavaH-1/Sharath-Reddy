package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Get the HelloWorld Bean
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        
        // Call method
        helloWorld.sayHello();
        
        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
