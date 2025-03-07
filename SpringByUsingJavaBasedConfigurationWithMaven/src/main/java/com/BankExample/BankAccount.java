package com.BankExample;

public class BankAccount 
{
	private String accountHolder;
	private double balance;

	public BankAccount(String accountHolder, double balance) 
	{
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public void deposit(double amount) 
	{
		balance += amount;
		System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
	}

	public void withdraw(double amount)
	{
		if (amount > balance) 
		{
			System.out.println("Insufficient funds! Current Balance: $" + balance);
		} 
		else 
		{
			balance -= amount;
			System.out.println("Withdrawn: $" + amount + " | New Balance: $" + balance);
		}
	}

	public void displayAccountInfo() 
	{
		System.out.println("Account Holder: " + accountHolder);
		System.out.println("Current Balance: $" + balance);
	}
}
