package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class Fibonacci_Series {
	
	public static void main(String[] args) 
	{
		Scanner scan =new Scanner(System.in);
		
		int a=0, b=1, num;
		System.out.println("Enter number upto which Fibonacci Series :");
		num=scan.nextInt();
		for(int i=2;i<num;i++) 
		{
			num=a+b;
			System.out.println(num);
			a=b;
			b=num;
		}
		int j = 0;
		while (j<num) {
		      System.out.print(a + ", ");

		      int nextTerm = a + b;
		      a = b;
		      b = nextTerm;
		      j++;
		    }
		scan.close();
	}
}
