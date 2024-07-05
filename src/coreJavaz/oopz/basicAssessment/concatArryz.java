package coreJavaz.oopz.basicAssessment;

import java.util.Arrays;
import java.util.stream.Stream;

public class concatArryz {

	public static void main(String[] args) {

		int[] array1 = { 1, 3, 5 };
		int[] array2 = { 2, 4, 6, 8 };

		//
		int arr1len = array1.length;
		int arr2len = array2.length;
		int[] array3 = new int[arr1len + arr2len];

		System.arraycopy(array1, 0, array3, 0, arr1len);
		System.arraycopy(array2, 0, array3, arr1len, arr2len);

		System.out.println(Arrays.toString(array3));

		System.out.println("----------------------");

		//
		int arrayLength = array1.length + array2.length;
		int[] resultArray = new int[arrayLength];
		int pos = 0;

		for (int element : array2) {
			resultArray[pos] = element;
			pos++;
		}
		for (int element : array1) {
			resultArray[pos] = element;
			pos++;
		}

		System.out.println(Arrays.toString(resultArray));
		Arrays.sort(resultArray);
		for (int num : resultArray) {
			System.out.print(num + "\t");
		}
		System.out.println("---------");
		System.out.println(Arrays.toString(resultArray));

		System.out.println("-----------------------");

		// multidimensional array-1
		int[][] arr1 = { { 1, 3, 5 }, { 3, 5, 7 }, { 5, 7, 9 } };
		int[][] arr2 = { { 7, 8, 9 }, { 10, 11, 12 } };

		int totalRows = arr1.length + arr2.length;
		int cols = arr1[0].length;

		int[][] joinedArray = new int[totalRows][cols];

		int currentRow = 0;
		for (int i = 0; i < arr1.length; i++, currentRow++) {
			for (int j = 0; j < arr1[i].length; j++) {
				joinedArray[currentRow][j] = arr1[i][j];
			}
		}
		for (int i = 0; i < arr2.length; i++, currentRow++) {
			for (int j = 0; j < arr2[i].length; j++) {
				joinedArray[currentRow][j] = arr2[i][j];
			}
		}

		for (int i = 0; i < joinedArray.length; i++) {
			for (int j = 0; j < joinedArray[i].length; j++) {
				System.out.print(joinedArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		// multidimensional array-2
		
		int[][] arr3 = {{1, 3, 5}, {3, 5, 7}, {5, 7, 9}};
        int[][] arr4 = {{2, 4, 6, 8}, {4, 6, 8, 10}};
        
        int totalRows1 = arr3.length + arr4.length;
        int maxCols = 0;
        for (int[] row : arr3) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }
        System.out.println(maxCols);
        
        for (int[] row : arr4) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }
        System.out.println(maxCols);
        
        int[][] result = new int[totalRows1][];
        
        for (int i = 0; i < arr3.length; i++) {
            result[i] = Arrays.copyOf(arr3[i], arr3[i].length);
        }
        
        for (int i = 0; i < arr4.length; i++) {
            result[arr3.length + i] = Arrays.copyOf(arr4[i], arr4[i].length);
        }
        
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

	}
}
