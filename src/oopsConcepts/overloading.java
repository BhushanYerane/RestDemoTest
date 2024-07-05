/**
 * 
 */
package oopsConcepts;

/**
 * @author byerane
 * polymorphism- overloading 
 *
 */
class Helper
{
	static int multiply(int a, int b)
	{
		return a*b;
	}
	double multiply(double a, double b)
	{
		return a*b;
	}
	
	static double multiply(int a, float b, double c)
	{
		return a+c*b;
	}
}

public class overloading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Helper mul = new Helper();
		System.out.println(mul.multiply(32.3, 33.2));
		System.out.println(Helper.multiply(9, 12));
		
		System.out.println(mul.multiply(5, 2.5f, 3.9d));
	}
}
