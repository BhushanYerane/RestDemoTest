package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class Palindrome_String {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("Enter the string to check for palindrome: ");
		String str = scan.nextLine();
		int strLength = str.length();
		String reverseSTR = "";
		/*
		for(int i=(strLength-1);i>=0;i--)
		{
			reverseSTR = reverseSTR + str.charAt(i);
		}
		System.out.println(reverseSTR);
		if(str.toLowerCase().equals(reverseSTR.toLowerCase())) {
			System.out.println("Palindrome");
		}else {
			System.out.println("not palindrome");
		}
		System.out.println(str+" "+"\n"+strLength);
		*/
		
		StringBuilder strBuild = new StringBuilder(str);
		strBuild.reverse();
		String str1 = strBuild.toString();
				
		if(strBuild.equals(str1))
		{
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}
		
		System.out.println(strBuild);
		scan.close();
	}

}
