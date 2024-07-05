package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class CheckdataType
{
	public static void main(String[] args) 
	{
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter the input: ");
		 String input = scanner.nextLine();
		 
		 char c = 'A';
		 if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
	            System.out.println(c + " is an alphabet.");
	        else
	            System.out.println(c + " is not an alphabet.");
		 
		 if (input.length() == 1 ) 
		  {
			 char c1=input.charAt(0);
			 if(Character.isLetter(c1)) {
				 System.out.println("The input is a character and an alphabet.");
			 }else if(Character.isDigit(c1)) {
				 System.out.println("The input is a character and a digit.");
			 } else {
				 System.out.println("The input is a character but not an alphabet or digit.");
			 	}	            
	       } else if (input.matches("[0-9]+")) {
	            System.out.println("The input is an integer.");
	        }else {
	            System.out.println("The input is a string.");
	        }
		 
		 scanner.close();
	}
}
