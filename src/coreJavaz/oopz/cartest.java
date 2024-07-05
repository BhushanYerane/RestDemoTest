package coreJavaz.oopz;

import java.util.Scanner;

public class cartest {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		car mycar = new car("Tata","Nexon",2020,1200000); // as car is constructor we are passing details
		//int carage = mycar.calculateAge(2020);// we are send car yr hard code
		System.out.print("Enter current year");
		int currYear = scan.nextInt();
		
		System.out.print("Enter the Car year:");
		int carage1 = scan.nextInt();
	
		if(carage1<currYear)
		{
			int carage = mycar.calculateAge(carage1);
			System.out.println("Age of car: "+carage+"yrs Old");
		} else
		{
			System.out.println("car year is greater than current year");
		}
		
		mycar.displayDetails();
		System.out.println("---------------");
		
		// by using toString method we need to send object of class.
		System.out.println(mycar);
		
		scan.close();
		
	}

}
