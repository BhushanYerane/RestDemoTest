package coreJavaz.oopz.basicAssessment;

import java.util.Scanner;

public class SmallestElementArray {

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

		int smallest =0, temp=0;
		for(int i=0;i<size;i++)
		{
			if(smallest > array1[i])
			{
				smallest = array1[i];
				temp = smallest;
				array1[i] = temp;
			}
		}
		
		System.out.println(smallest);
		
		for (int num: array1) 
		{
            if(smallest > num)
            	smallest = num;
        }
		System.out.println(smallest);
		
        scan.close();
	}
}
