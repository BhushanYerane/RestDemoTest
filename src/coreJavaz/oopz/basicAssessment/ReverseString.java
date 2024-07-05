package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the string to reverse: ");
		String str1 = scan.nextLine();
		
		// by charAt method
		int lenstr1 = str1.length();
		String str2 ="";
		for(int i=lenstr1-1;i>=0;i--)
		{
			str2 = str2+str1.charAt(i);
		}
		System.out.println(str2);
		
		// using String Buffer
		StringBuffer strbuff = new StringBuffer();
		strbuff.append(str1);
		strbuff.reverse();
		
		System.out.println(strbuff);
		
		// using String Builder
		StringBuilder strBuild = new StringBuilder(str1);
		strBuild.reverse();
		String revstr = strBuild.toString();
		System.out.println(revstr);
		
		//char Array
		char[] str3 = str1.toCharArray();
		int firstchar = 0;
		int lastchar = str3.length-1;
		while(firstchar<lastchar)
		{
			 char temp = str3[firstchar];
			 str3[firstchar] = str3[lastchar];
			 str3[lastchar] = temp;
			 firstchar ++;
			 lastchar --;
		}
		
		System.out.println(str3);
		
		scan.close();
	}
}
