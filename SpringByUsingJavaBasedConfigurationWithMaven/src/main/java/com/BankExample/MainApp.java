package com.BankExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp 
{
    public static void main(String[] args) 
    {
        // Load Spring Context using Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve the BankAccount Bean
        BankAccount bankAccount = context.getBean(BankAccount.class);
        
        // Display Initial Account Info
        bankAccount.displayAccountInfo();

        // Perform Transactions
        bankAccount.deposit(500);
        bankAccount.withdraw(200);
        bankAccount.withdraw(2000);  // This should show insufficient funds
        
        // Close context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
