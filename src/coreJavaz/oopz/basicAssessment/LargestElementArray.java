package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class LargestElementArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the size of the single-dimensional array: ");
		int size = scan.nextInt();

		int[] array1 = new int[size];
		System.out.println("Enter the elements of the array:");
		for (int i = 0; i < size; i++) 
		{
			array1[i] = scan.nextInt();
		}

		int largest =0, temp=0;
		for(int i=0;i<size;i++)
		{
			if(largest < array1[i])
			{
				largest = array1[i];
				temp = largest;
				array1[i] = temp;
			}
		}
		
		System.out.println(largest);
		
		for (int num: array1) 
		{
            if(largest < num)
                largest = num;
        }
		System.out.println(largest);
		
		//
		// Input the dimensions of the 2D array
        System.out.print("Enter the number of rows in the 2D array: ");
        int rows = scan.nextInt();
        System.out.print("Enter the number of columns in the 2D array: ");
        int columns = scan.nextInt();
        
     // Initialize the 2D array
        int[][] array2 = new int[rows][columns];
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array2[i][j] = scan.nextInt();
            }
        }
        
     // Display the 2D array
        System.out.println("The 2D array elements are:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
        
     // Find the largest element in the 2D array
        int largest1 = array2[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (array2[i][j] > largest1) {
                    largest1 = array2[i][j];
                }
            }
        }
        
        // Display the largest element
        System.out.println("The largest element in the 2D array is: " + largest1);
        scan.close();
	}
}
