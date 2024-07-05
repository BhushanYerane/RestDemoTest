package coreJavaz.oopz;

public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance); // calling super class method
		this.interestRate = interestRate;

	}

	public double getInterestRate() {
		return interestRate;
	}
	
	// adding interest rate to saving account method
	public void addInterest() {
		balance = balance + (balance * interestRate) / 100;
	}

	public String toString() {
		return super.toString() + ", Interest Rate: " + interestRate;

	}

	// implementation of abstract method declare in base class
	@Override
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance = balance - amount;
		} else {
			System.out.println("You have Enter more amount to Withdraw than BALANCE ");
		}
	}
}