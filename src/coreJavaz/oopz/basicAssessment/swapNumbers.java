package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class swapNumbers {

	public static void main(String[] args) {
		 int a = 10;
	        int b = 11;
	        int num = a + b; // num = 10 + 11 = 21

	        a = num - a; // a = 21 - 10 = 11
	        b = num - a; // b = 21 - 11 = 10

	        // After swapping
	        System.out.println("After swapping:");
	        System.out.println("a = " + a); // a = 11
	        System.out.println("b = " + b); // b = 10
	        
	        //
	        int first = 10;
	        int second = 5;

	        // Swapping logic
	        first = first - second; // first = 10 - 5 = 5
	        second = first + second; // second = 5 + 5 = 10
	        first = second - first; // first = 10 - 5 = 5

	        // After swapping
	        System.out.println("After swapping:");
	        System.out.println("first = " + first); // first = 5
	        System.out.println("second = " + second); // second = 10
	        // 
	        
	        try (Scanner scanner = new Scanner(System.in)) {
				
				System.out.print("Enter the value of a: ");
				int c = scanner.nextInt();

				System.out.print("Enter the value of b: ");
				int d = scanner.nextInt();

				// Display original values
				System.out.println("Original values:");
				System.out.println("c = " + c);
				System.out.println("d = " + d);

				// Swapping logic
				int num1 = c + d;

				c = num1 - c; 
				d = num1 - c; 

				// Display swapped values
				System.out.println("After swapping:");
				System.out.println("c = " + c);
				System.out.println("d = " + d);
			}
	}
}
