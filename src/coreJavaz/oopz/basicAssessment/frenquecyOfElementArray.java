package coreJavaz.oopz.basicAssessment;

import java.util.HashMap;

public class frenquecyOfElementArray {

	public static void main(String[] args) {
		
		int[] array1 = { 1, 2, 3, 1, 5, 6, 6 };
		int array1len = array1.length;
		
		for (int i = 0; i < array1len; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println("\n--------");
		
		 HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		
		 for (int i = 0; i < array1len; i++) {
	            int element = array1[i];
	            if (frequencyMap.containsKey(element)) 
	            {
	                frequencyMap.put(element, frequencyMap.get(element) + 1);
	            } else {
	                frequencyMap.put(element, 1);
	            }
	        }
			
		 for (int i = 0; i < array1len; i++) 
		 {
	            int element = array1[i];
	            System.out.println("Frequency of element " + element + " is: " + frequencyMap.get(element));
	     }
	}
}
