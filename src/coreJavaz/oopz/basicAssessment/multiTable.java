package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class multiTable {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter value for multiplication table: ");
		int num1 = scan.nextInt();
		
		System.out.println("Table:");
		for(int i=1;i<=10;i++)
		{
			System.out.println(num1*i);
		}
		
		System.out.println("\nPowers Table:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num1 + " ^ " + i + " = " + (int) Math.pow(num1, i));
        }
        
		scan.close();
	}
}
