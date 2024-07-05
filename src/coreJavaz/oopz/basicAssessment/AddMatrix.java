package coreJavaz.oopz.basicAssessment;

public class AddMatrix {

	public static void main(String[] args) {
		int rows=3, cols=3;
		int[][] matrix1 = {{1,3,5},{3,5,7},{5,7,9}};
		int[][] matrix2 = {{2,4,6},{4,6,8},{6,8,10}};
		
		 //Addition
		int[][] sum = new int[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				sum[i][j] =matrix1[i][j] + matrix2[i][j];
			}
		}
		 
		System.out.println("Sum of two matrices is: ");
        for(int[] row : sum) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
        
        //Multiplication
        int[][] product = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                   // product[i][j]  = product[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        System.out.println("Multiplication of two matrices is: ");
        for(int[] row : product) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }

	}
}
