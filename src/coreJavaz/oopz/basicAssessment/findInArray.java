package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

//TODO find element in array 

public class findInArray {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the size of the single-dimensional array: ");
        int size = scan.nextInt();
        
        int[] array1 = new int[size];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<size;i++)
        {
        	array1[i] = scan.nextInt();
        }
        
        System.out.println("The single-dimensional array elements are:");
        for (int i : array1) {
            System.out.print(i + " ");
        }
         
        System.out.println("\nEnter element to find in array:");
        int num = scan.nextInt();
        
        for(int i=0;i<size;i++)
        {
        	if(array1[i]==num)
        	{
        		System.out.println("Number Found");
        	}
        }
        
        // multidimensional 
        	System.out.print("Enter the number of rows in the 2D array: ");
        	int rows = scan.nextInt();
        	System.out.print("Enter the number of columns in the 2D array: ");
        	int columns = scan.nextInt();
        	
        	int[][] array2 = new int[rows][columns];
        	System.out.println("Enter the elements of the 2D array:");
            for (int i = 0; i < rows; i++) 
            {
                for (int j = 0; j < columns; j++) 
                {
                    array2[i][j] = scan.nextInt();
                }
            }
            
            System.out.println("The 2D array elements are:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(array2[i][j] + " ");
                }
                System.out.println();
            }
            
            System.out.println("\nEnter element to find in array:");
            int num1 = scan.nextInt();
            int count = 0;
            for(int i=0;i<rows;i++)
            {
            	for(int j=0;j<columns;j++)
            	{
            		if(array2[i][j]==num1)
            		{
            			count++;
            		}
            	}
            }
            
            if (count > 0) {
                System.out.println("Number " + num1 + " found " + count + " times.");
            } else {
                System.out.println("Number " + num1 + " not found in the array.");
            }
      //
	}
}
