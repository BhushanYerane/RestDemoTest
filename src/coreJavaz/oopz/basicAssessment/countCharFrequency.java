package coreJavaz.oopz.basicAssessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

		// find frequency of given char
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
		
		System.out.println("-------------------------");
		
		// find number of occurrence of char in given string	
		System.out.println("Entered string: \"" + str1 + "\"");
		
		 Map<Character, Integer> charFrequency = new HashMap<>();

	        // Iterate through each character in the string
	        for (char c : str1.toCharArray()) 
	        {
	         // Update the frequency of the character
	         charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
	        }
	        // Print the frequency of each character
	        System.out.println("Character frequencies:");
	        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) 
	        {
	            System.out.println("Character: '" + entry.getKey() + "', Frequency: " + entry.getValue());
	        }

	        System.out.println("-------------------------");
	        
	        // remove duplicate char from String
	        // Print the entered string
	        System.out.println("Entered string: \"" + str1 + "\"");

	        // Remove duplicate characters
	        String result = removeDuplicates(str1);

	        // Print the string without duplicates
	        System.out.println("String without duplicates: \"" + result + "\"");
		//
		scan.close();
	}
	
	public static String removeDuplicates(String str) {
        HashSet<Character> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        // Iterate through each character in the string
        for (char c : str.toCharArray()) {
            // If the character has not been encountered before, add it to the result
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
