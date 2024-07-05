package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

//TODO Char to String and String to Char

public class charToString {

	public static void main(String[] args) {
		
	        // String to Char
	        String str1 = "I am Good Man";
	        char[] char1 = str1.toCharArray();
	        for (char c1 : char1) {
	            System.out.print(c1 +"\t");
	        }

	        char ch1 = 'A';
	        String str2 = Character.toString(ch1);
	        System.out.print("\n" + str2);
	        str2 = String.valueOf(ch1);
	        System.out.print("\n" + str2);

	        // char to String
	        String str3 = String.valueOf(char1);
	        System.out.print("\n" + str3);

	        str3 = new String(char1);
	        System.out.print("\n" + str3);

	        //
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a string: ");
	        String inputString = scanner.nextLine();

	        if (inputString == null || inputString.isEmpty()) {
	            System.out.println("Input string is empty.");
	            return;
	        }

	        // Step 2: Convert string to char array
	        char[] charArray = inputString.toCharArray();

	        // Step 3: Remove spaces from char array
	        StringBuilder noSpacesStringBuilder = new StringBuilder();
	        for (char c : charArray) {
	            if (c != ' ') {
	                noSpacesStringBuilder.append(c);
	            }
	        }

	        // Convert StringBuilder to String without spaces
	        String noSpacesString = noSpacesStringBuilder.toString();

	        // Step 4: Add spaces between the words in the modified string
	        // Assuming words are separated by capital letters as in camel case
	        StringBuilder finalStringBuilder = new StringBuilder();
	        for (int i = 0; i < noSpacesString.length(); i++) {
	            char currentChar = noSpacesString.charAt(i);
	            if (i != 0 && Character.isUpperCase(currentChar)) {
	                finalStringBuilder.append(' ');
	            }
	            finalStringBuilder.append(currentChar);
	        }

	        // Convert StringBuilder to final String with spaces
	        String finalString = finalStringBuilder.toString();

	        // Print the final string
	        System.out.println("Final string with spaces: " + finalString);

	        scanner.close();
	}
}
