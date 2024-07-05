package coreJavaz.oopz.basicAssessment.basics;

import java.util.Scanner;

public class factorial {
	
	public static void main(String[] args) 
	{
		int factorial = 1;
		Scanner scan = new Scanner(System.in);
		System.out.print("enter number for factorial: ");
		int num = scan.nextInt();
		
		if(num==0)
		{
			System.out.println("Enter valid Number:"+num);
		}else {
			System.out.println("enter number is "+num);
			for (int i=1;i<=num;i++)
			{
			factorial = factorial * i;
			}
		}	
		System.out.println(factorial);
	}
}
