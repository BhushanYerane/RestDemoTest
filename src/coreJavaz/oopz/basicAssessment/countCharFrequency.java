package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class countCharFrequency {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the String: ");
		String str1 = scan.nextLine();
		
		System.out.print("Enter the character to find Frequency: ");
		String ch1 = scan.next();
//		char ch2 = scan.next().charAt(0);
		
		if (ch1.length() != 1) {
            System.out.println("Please enter a single character.");
            return;
        }

		
		str1 = str1.toLowerCase();
		char ch = ch1.toLowerCase().charAt(0);
		int str1len = str1.length();
		int freqChar = 0;
		
		for(int i=0;i<str1len;i++)
		{
			if(str1.charAt(i)==ch)
			{
				freqChar++;
			} 
		}
		System.out.println("The frequncy of "+ ch1 +" is:"+freqChar);
		
		scan.close();
	}
}
