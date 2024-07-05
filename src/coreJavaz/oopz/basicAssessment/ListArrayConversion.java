package coreJavaz.oopz.basicAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayConversion {

	public static void main(String[] args) {
		 // Convert ArrayList to Array for Integer
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
		System.out.println(intList);
		
		Integer[] intArray1 = convertListToArray(intList);
		Integer[] intArray = new Integer[intList.size()];
	    intArray = intList.toArray(intArray);
		System.out.println("Integer Array: "+Arrays.toString(intArray1));
		System.out.println("Array: "+Arrays.toString(intArray));
		
		// Convert Array to ArrayList for Integer
		Integer[] intArray2 = {9,8,7,6,5,4,0};
		for(int i=0;i<intArray2.length;i++)
		{
			System.out.println("Array of Integer :"+intArray2[i]);
		}
		
		List<Integer> intList2 = convertArrayToList(intArray2);
		List<Integer> intList2a = new ArrayList<Integer>(Arrays.asList(intArray2));
		System.out.println("Integer List :"+intList2.toString());
		System.out.println("List :"+intList2a.toString());
		
		//Convert ArrayList to Array for String
		ArrayList<String> strlist1 = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
		System.out.println(strlist1);
		String[] strArray1 = convertListToStringArray(strlist1);
		System.out.println("Array of String after list to array: "+Arrays.toString(strArray1));
		
		// Convert Array to ArrayList for String
		String[] strArray2 = {"six", "seven", "eight", "nine", "ten"};
		for(int i=0;i<strArray2.length;i++)
		System.out.println("Array of String before array to list:"+strArray2[i].toString());
		
        List<String> strList2 = convertArrayToList(strArray2);
        System.out.println("String List: " + strList2.toString());
        
        System.out.println("----------------");
        String str1="A String Convert to String Array then convert to char array";
        int lenstr1 = str1.length();
        System.out.println("String Length :"+lenstr1);
        
        String[] strArray = str1.split(" ");
        System.out.print("String array : [ ");       
        for (int i = 0; i < strArray.length; i++) 
        { 
            System.out.print(strArray[i]);
            if (i < strArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
        
        System.out.println("\nConverting each element of the string array to a char array:");
        for(String str :strArray) 
        {
        	char[] srtToChar = str.toCharArray();
        	System.out.println("String: " + str + " -> Char array: " + Arrays.toString(srtToChar));
        }
	}

	// Method Declare
	// List to Array
	private static Integer[] convertListToArray(ArrayList<Integer> list) 
	{
		Integer[] array = new Integer[list.size()];
		return list.toArray(array);
	}
	
	private static String[] convertListToStringArray(ArrayList<String> strlist1) {
		 String[] arraystr = new String[strlist1.size()];
	        return strlist1.toArray(arraystr);
	}
	
	// Array to list
	private static List<Integer> convertArrayToList(Integer[] intArray2) {
		List<Integer> intlist1= new ArrayList<Integer>(Arrays.asList(intArray2));
		return intlist1;
	}
	
	private static List<String> convertArrayToList(String[] strArray2) {
		List<String> strlist1= new ArrayList<String>(Arrays.asList(strArray2));
		return strlist1;
	}

}
