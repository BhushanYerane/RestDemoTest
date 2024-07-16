package coreJavaz.oopz.basicAssessment;

import java.util.Arrays;
import java.util.Collections;

public class SortTheArray {

	public static void main(String[] args) 
	{
		 int[] array1 = {1, 2, 5, 6, 3, 1, 6};
	        int array1len = array1.length;

	        // Print original array
	        for (int i = 0; i < array1len; i++) {
	            System.out.print(array1[i] + " ");
	        }
	        System.out.println("\n--------");

	        // Sort array in ascending order
	        Arrays.sort(array1);
	        System.out.print("Sorted in Ascending Order: ");
	        for (int i = 0; i < array1len; i++) {
	            System.out.print(array1[i] + " ");
	        }
	        System.out.println("\n--------");

	        // Convert int[] to Integer[]
	        Integer[] array2 = Arrays.stream(array1).boxed().toArray(Integer[]::new);

	        // Sort array in descending order
	        Arrays.sort(array2, Collections.reverseOrder());
	        System.out.print("Sorted in Descending Order: ");
	        for (int i = 0; i < array1len; i++) {
	            System.out.print(array2[i] + " ");
	        }
	        System.out.println("\n--------");
	}
}
