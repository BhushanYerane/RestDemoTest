package coreJavaz.oopz.basicAssessment;

//Program to count vowels, consonants, digits, and spaces

public class countVowels {

	public static void main(String[] args) {
		
		String str = "The GitHub Copilot is next GenAI solution";
		str = str.toLowerCase();
		int strlen = str.length();
		char[] charArray = str.toCharArray();
		int sizeArray = charArray.length;
		int count=0, spaces1=0;
		
		for(int i=0;i<sizeArray;i++)
		{
			System.out.print(charArray[i]+" ");
		}
		System.out.println("");
		for(int i=0;i<sizeArray;i++)
		{
			if(charArray[i]=='a'||charArray[i]=='e'||charArray[i]=='i'||charArray[i]=='o'||charArray[i]=='u')
			{
				count++;
				System.out.print(charArray[i]+" ");
			} else if (charArray[i] == ' ') {
		        ++spaces1;
			}
		}
		System.out.println("\nTotal Vowels in String is: "+count);
		System.out.println("White spaces: " + spaces1);
		
		//
		
		String line = "This website is aw3som3.";
	    int vowels = 0, consonants = 0, digits = 0, spaces = 0;

	    line = line.toLowerCase();
	    for (int i = 0; i < line.length(); ++i) {
	      char ch = line.charAt(i);

	      // check if character is any of a, e, i, o, u
	      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	        ++vowels;
	      }

	      // check if character is in between a to z
	      else if ((ch >= 'a' && ch <= 'z')) {
	        ++consonants;
	      }
	      
	      // check if character is in between 0 to 9
	      else if (ch >= '0' && ch <= '9') {
	        ++digits;
	      }
	      
	      // check if character is a white space
	      else if (ch == ' ') {
	        ++spaces;
	      }
	    }

	    System.out.println("Vowels: " + vowels);
	    System.out.println("Consonants: " + consonants);
	    System.out.println("Digits: " + digits);
	    System.out.println("White spaces: " + spaces);
	}
}
