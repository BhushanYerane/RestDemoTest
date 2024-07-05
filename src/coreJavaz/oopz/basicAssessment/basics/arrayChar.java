package coreJavaz.oopz.basicAssessment.basics;

import java.util.Arrays;
import java.util.Scanner;

public class arrayChar {

	public static void main(String[] args) {
		
		char charArray1[] = new char[5];
		char charArray2[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		
		charArray1[0] = 'z';  
		charArray1[1] = 'y';  
		charArray1[2] = 'x';  
		charArray1[3] = 'w';  
		charArray1[4] = 'v';  
		
		for(char ca2:charArray2)
		{
			System.out.print("\n "+ca2);
		}
		
		for(int i=0;i<charArray1.length;i++)
		{
			System.out.print("\n "+charArray1[i]);
		}
		
	//----------------------------
		char charArray3[] = {'s','a','p','c','v','j','j'};
		Arrays.sort(charArray3);
		System.out.println("\n"+Arrays.toString(charArray3));
		int arrLen1 = charArray3.length;
		System.out.println(arrLen1);
		
	//----------------------------
		String str1 = "Drishti Judiciary";
		String str2 = "Judiciary Foundation Course";
		
		char [] charArray4 = str1.toCharArray();
		int arrLen2 = charArray4.length;
		
		for(char ca4:charArray4)
		{
			System.out.print("\t"+ca4);
		}
		
		System.out.println("\n"+charArray4[10]);
		
		
	//---------------------------------
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        char[] charArray5 = userInput.toCharArray();
        System.out.println("The characters in the array are:");
        for (char ca5 : charArray5) {
            System.out.print(ca5 + " ");
        }
		
	}
}
