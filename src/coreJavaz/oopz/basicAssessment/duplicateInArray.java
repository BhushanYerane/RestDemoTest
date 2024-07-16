package coreJavaz.oopz.basicAssessment;

import java.util.HashSet;
import java.util.Set;

public class duplicateInArray {

	public static void main(String[] args) {

		int[] array1 = {1, 2, 5, 6, 3, 1, 6};
        int array1len = array1.length;

        // Print the original array
        System.out.print("Original Array: ");
        for (int i = 0; i < array1len; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("\n--------");

        // Find and print duplicate elements
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int i = 0; i < array1len; i++) {
            if (!seen.add(array1[i])) {
                duplicates.add(array1[i]);
            }
        }

        System.out.print("Duplicate Elements: ");
        for (int element : duplicates) {
            System.out.print(element + " ");
        }
        System.out.println();

	}

}
