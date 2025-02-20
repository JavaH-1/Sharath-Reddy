package com.HelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring Context using Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve Bean from Spring Container
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        
        // Call Method
        helloWorld.sayHello();
        
        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}