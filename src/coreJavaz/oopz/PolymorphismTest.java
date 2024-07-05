package coreJavaz.oopz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolymorphismTest {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<BankAccount> account = new ArrayList<>();
		
		// Input for SavingsAccount
		System.out.println("Create Saving Account:");
		System.out.println("Enter Account Number: ");
		String savingAccountNumber = scan.nextLine();
		System.out.println("Enter Intitial Balance: ");
		double savingAccountBalance = scan.nextDouble();
		System.out.println("Enter Interest Rate: ");
		double interestRate = scan.nextDouble();
		scan.nextLine();
		
		SavingsAccount savingAcc = new SavingsAccount(savingAccountNumber, savingAccountBalance, interestRate);
		account.add(savingAcc);
		
		// Input for CheckingAccount
		System.out.println("\nCreate Checking Account:");
        System.out.print("Enter account number: ");
        String checkingAccountNumber = scan.nextLine();
        System.out.print("Enter initial balance: ");
        double checkingBalance = scan.nextDouble();
        System.out.print("Enter overdraft limit: ");
        double checkingOverdraftLimit = scan.nextDouble();
        scan.nextLine(); // consume the newline
		
        CheckingAccount checkAccount = new CheckingAccount(checkingAccountNumber, checkingBalance, checkingOverdraftLimit);
        account.add(checkAccount);
        
        // Input for CurrentAccount need to create class
//        System.out.println("\nCreate Current Account:");
//        System.out.print("Enter account number: ");
//        String currentAccountNumber = scan.nextLine();
//        System.out.print("Enter initial balance: ");
//        double currentBalance = scan.nextDouble();
//        System.out.print("Enter overdraft limit: ");
//        double currentOverdraftLimit = scan.nextDouble();
//        scan.nextLine(); // consume the newline
//
//        CurrentAccount currentAccount = new CurrentAccount(currentAccountNumber, currentBalance, currentOverdraftLimit);
//        accounts.add(currentAccount);
        
        // Display all accounts
        System.out.println("\n All Accounts");
        for(BankAccount acc:account)
        {
        	System.out.println(acc);
        }
        
        // Perform operations on accounts
        	System.out.println("\n Perforning Operations on account");
        	for(BankAccount acc : account)
        	{
        		System.out.println("\n"+acc.getAccountNumber()+":");
        		acc.deposit(5000);
        		System.out.println("After depositing $5000: " + acc.getBalance());
        		acc.withdraw(1000);
        		System.out.println("After Withdrawing $5000: " + acc.getBalance());
        		if (account instanceof SavingsAccount) {
                    ((SavingsAccount) account).addInterest();
                    System.out.println("After adding interest: " + acc.getBalance());
                }
        	}
        	
        scan.close();
	}
}
