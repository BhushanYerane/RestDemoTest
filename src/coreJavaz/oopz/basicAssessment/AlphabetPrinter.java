package coreJavaz.oopz.basicAssessment;

public class AlphabetPrinter {

	public static void main(String[] args) {

		System.out.println("All Alphabet from A to Z is as:");
		for(char ch='A';ch<='Z';ch++)
		{
			System.out.print(ch + " ");
		}
		System.out.println("\n ----");
		for(char ch='a';ch<='z';ch++)
		{
			System.out.print(ch + " ");
		}
		System.out.println("\n ----");
		
		// ASCII values
		for (int i = 65; i <= 90; i++) {  
            System.out.print((char) i + " "); // Main converting thing using ASCII
        }
		System.out.println("\n ----");
		for (int i = 97; i <= 122; i++) {  
            System.out.print((char) i + " ");
        }
		
		System.out.println("\n ----");
		for (int i = 01; i <= 127; i++) {  
            System.out.print((char) i + " ");
        }
		
		

	}
}
