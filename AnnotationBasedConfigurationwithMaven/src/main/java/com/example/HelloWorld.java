package com.example;

import org.springframework.stereotype.Component;

@Component  // This tells Spring that this is a Bean Object
public class HelloWorld {
    public void sayHello() 
    {
        System.out.println("Hello, Spring with Annotation-Based Configuration in Maven!");
    }
}
