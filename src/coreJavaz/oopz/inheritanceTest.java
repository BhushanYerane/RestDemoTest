package coreJavaz.oopz;

import java.util.Scanner;

public class inheritanceTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Prompt the user for User object details
		System.out.println("Create User Account");
		System.out.print("Enter Username for User");
		String userUserName = scan.nextLine();
		
		System.out.print("Enter Passowrd for User");
		String userPassword = scan.nextLine();
		
		users user1 = new users(userUserName,userPassword);  // creating user object and sending to constuctor
		
		// User login
		System.out.println("User Login");
		System.out.print("Enter Username: ");
		String loginUsername = scan.nextLine();
		System.out.println("Enter Passowrd: ");
		String loginPassword = scan.nextLine();
		
		if(user1.login(loginUsername, loginPassword)) { // sending method 
			System.out.println("User login Successful");
		} else {
			System.out.println("User failed to login");
		}
		
		// Prompt the user for Admin object details
		System.out.println("Create Admin Account");
		System.out.print("Enter Username for Admin");
		String adminUserName = scan.nextLine();
		System.out.print("Enter Passowrd for Admin");
		String adminPassword = scan.nextLine();
		System.out.println("Enter Admin code");
		String adminCde = scan.nextLine();
		
		adminz admin = new adminz(adminUserName, adminPassword, adminCde); // creating admin object
		
		System.out.println("Admin user Login");
		System.out.print("Enter admin username");
		String adminloginusername = scan.nextLine();
		System.out.println("Enter admin password");
		String adminloginpassword = scan.nextLine();
		System.out.println("Enter admin code for login");
		String adminlogincode = scan.nextLine();
		
		if(admin.adminlogin(adminloginusername, adminloginpassword, adminlogincode)) {   // sending to method
			System.out.println("Admin login successful"); 
		} else {
			System.out.println("Admin login Failed");
		}
		
		scan.close();
	}
}
