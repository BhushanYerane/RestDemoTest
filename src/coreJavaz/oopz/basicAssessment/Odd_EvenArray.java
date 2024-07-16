package coreJavaz.oopz.basicAssessment;

public class Odd_EvenArray {

	public static void main(String[] args) {

		int[] array1 = {1, 2, 5, 6, 3, 1, 6};
        int array1len = array1.length;

        // Print the original array
        System.out.print("Original Array: ");
        for (int i = 0; i < array1len; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println("\n--------");
        
        for (int i = 0; i < array1len; i++) 
        {
        	if(array1[i]%2==0)
        	{
        		System.out.println("Number is even- "+array1[i]);
        	}else {
        		System.out.println("Number is odd- "+array1[i]);
        	}
        }

	}

}
