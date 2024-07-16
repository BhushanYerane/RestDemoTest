package coreJavaz.oopz.basicAssessment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		int array1len = array1.length;

		for (int i = 0; i < array1len; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println("\n--------");

		for (int i = array1len - 1; i >= 0; i--) {
			System.out.print(array1[i] + " ");
		}

		System.out.println("\n--------");
		//------
		Integer[] arr = { 10, 20, 30, 40, 50 };
		reverse(arr);

		System.out.println("\n--------");
		//---
		int[][] matrix1 = {{1,3,5},{3,5,7},{5,7,9}};
		int rows=3, cols=3;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.println(matrix1[i][j]);
			}
		}
		
		for(int i=rows-1;i>=0;i--)
		{
			for(int j=cols-1;j>=0;j--)
			{
				System.out.println(matrix1[i][j]);
			}
		}
	}

	static void reverse(Integer a[]) {
		Collections.reverse(Arrays.asList(a));
		System.out.println(Arrays.asList(a));
	}
}
