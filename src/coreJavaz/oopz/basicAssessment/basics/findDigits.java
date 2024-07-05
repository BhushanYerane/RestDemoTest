package coreJavaz.oopz.basicAssessment.basics;

import java.util.Scanner;

public class findDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the String ");
		String str1 = scan.nextLine();
		
		 StringBuilder numbers = new StringBuilder();
		 char[] str2 = str1.toCharArray();
		 for(char c1:str2)
		 {
			 if(Character.isDigit(c1))
			 {
				 numbers.append(c1);
			 }
		 }
		 System.out.println("Numbers extracted from the string: " + numbers);
		
		scan.close();
	}
}
