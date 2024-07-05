package coreJavaz.oopz;

public class CheckingAccount extends BankAccount {
	private double overdraftlimit;

	public CheckingAccount(String accountNum, double bal, double overdraft) {
		super(accountNum, bal);
		this.overdraftlimit = overdraft;	
	}
	
	public double getOverdraftlimite() {
		return overdraftlimit;
	}
	
	// implementation of abstract method declare in base class 
	@Override
	public void withdraw(double amount) {
		if(balance+overdraftlimit >=amount) {
			balance = balance - amount;
		}else {
			System.out.println("Overdraft limit exceeded!");
		}	
	}
	
	public String toString() {
		return super.toString() + ", Overdraft Limit: " + overdraftlimit;
	}

}
