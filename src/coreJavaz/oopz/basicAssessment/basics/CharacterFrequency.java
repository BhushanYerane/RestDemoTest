package coreJavaz.oopz.basicAssessment.basics;

import java.util.Scanner;

public class CharacterFrequency 
{
	public static void main(String[] args) 
	{
		 Scanner scan = new Scanner(System.in);
	    
	     System.out.print("Enter a string: ");
	     String str = scan.nextLine();
	     
	     System.out.print("Enter a character to find its frequency: ");
	     char targetChar = scan.next().charAt(0);
	     
	     int strlen = str.length();
	     int count=0;
	     targetChar = Character.toLowerCase(targetChar);
	     for(int i=0; i<strlen ;i++)
	     {
	    	 char currentChar = Character.toLowerCase(str.charAt(i));
	    	 //if(str.charAt(i)==targetChar)
	    	 if(currentChar==targetChar)
	    	 {
	    		 count++;
	    	 }
	     }
	     System.out.println(count);
	     
	     scan.close();
	}
}
