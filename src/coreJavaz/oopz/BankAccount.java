package coreJavaz.oopz;

public abstract class BankAccount {
	protected String accountNumber;
	protected double balance;
	
	public BankAccount(String accountNum, double bal)
	{
		this.accountNumber=accountNum;
		this.balance=bal;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// adding amout to account method 
	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	
	public abstract void withdraw(double amount); // abstract method declear 
	
	@Override // display the details
	public String toString()
	{
		return "Account Number: " + accountNumber + ", Balance: " + balance;
	}
	
}
