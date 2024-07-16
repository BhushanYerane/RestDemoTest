package coreJavaz.oopz.basicAssessment;

public class FirstCharInString {

	public static void main(String[] args) {

		String str = "The Thing IS I Am Too Old For Too Start Now!";
		int strlen = str.length();
		String result = "";

		// Traverse the string.
		boolean v = true;
		for (int i = 0; i <strlen; i++) 
		{
			// If it is space, set v as true.
			if (str.charAt(i) == ' ') 
			{
				v = true;
			}

			// Else check if v is true or not.
			// If true, copy character in output
			// string and set v as false.
			else if (str.charAt(i) != ' ' && v == true) 
			{
				result = result + (str.charAt(i))+" ";
				v = false;
			}
		}
		result = result.trim();
		System.out.println(result);
		
		System.out.println("------------");
		
		//
		  StringBuilder result1 = new StringBuilder();
		  for (int i = 0; i < strlen; i++) {
	            // If the current character is a space and the previous character is not a space,
	            // it means the previous character is the end of a word.
	            if (str.charAt(i) == ' ' && i > 0 && str.charAt(i - 1) != ' ') {
	                result1.append(str.charAt(i - 1)).append(' ');
	            }
	            // If it's the last character in the string and it's not a space, it's the end of a word.
	            if (i == strlen - 1 && str.charAt(i) != ' ') {
	                result1.append(str.charAt(i)).append(' ');
	            }
	        }

	        // Trim the result to remove any trailing space.
	        System.out.println(result1.toString().trim());
	        
	        System.out.println("------------");
	        
	        //
	        String[] words = str.split(" ");
	        String result2 = "";
	        
	        for (String word : words) {
	            // Get the last character of the word and add a space after it
	            if (!word.isEmpty()) {
	            	result2 =result2 + word.charAt(word.length() - 1) + " ";
	            }
	        }

	        // Trim the result to remove the trailing space
	        result2 = result2.trim();

	        System.out.println(result2);
	}
}
