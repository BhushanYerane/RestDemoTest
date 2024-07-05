package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class AverageUsing_Arrays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int arr1[]= {1,3,5,7,9};
		int arr2=0;
		int lenarr = arr1.length;
		for(int i=0;i<lenarr;i++)
		{
			arr2=arr2 + arr1[i];	
		}
		System.out.println(arr2);
		int avg = arr2/lenarr; 
		System.out.println(avg);
		
		// 2d array
			System.out.print("Enter the number of rows: ");
	        int rows = scanner.nextInt();
	        System.out.print("Enter the number of columns: ");
	        int cols = scanner.nextInt();
	        int[][] array = new int[rows][cols];
	        
	        System.out.println("Enter the elements of the array:");
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                System.out.print("Element [" + i + "][" + j + "]: ");
	                array[i][j] = scanner.nextInt();
	            }
	        }
	        
	        int sum = 0;
	        int count = 0;
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                sum = sum + array[i][j];
	                count++;
	            }
	        }
	        double average = (double) sum / count;

	        // Display the sum and average
	        System.out.println("Sum of all elements: " + sum);
	        System.out.println("Average of all elements: " + average);

	        scanner.close();
	}
}
