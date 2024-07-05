package coreJavaz.oopz;

public class methodOverloading {
	
	public double calculateReturn(double principal)
	{
		double interestRate = 0.5;
		return principal * interestRate;
	}
	
	public double calculateReturn(double principal,double interestRate)
	{
		double finalAmount = principal * interestRate;
		return finalAmount;
	}
	
	public double calculateReturn(double principal,double interestRate, int year)
	{
		double simpleInterest = principal * interestRate * year;
		return simpleInterest;
	}
	
	public double[] calculateReturn(double[] investment)
	{
		double interestRate = 0.5;
		double[] returns = new double[investment.length];
	        for (int i = 0; i < investment.length; i++) 
	        {
	            returns[i] = investment[i] * interestRate;
	        }
		return returns;
	}
	
	public double[] calculateReturn(double[] investment, double[] interestRate) {
        if (investment.length != interestRate.length) {
            throw new IllegalArgumentException("Investments and interest rates arrays must be of the same length");
        }
        double[] returns = new double[investment.length];
        for (int i = 0; i < investment.length; i++) {
            returns[i] = investment[i] * interestRate[i];
        }
        return returns;
    }

	public static void main(String[] args) {
		
		methodOverloading calInvest = new methodOverloading();
		
		double principal = 1000;
        double interestRate = 0.7;
        int years = 7;
        double[] investments = {1000, 2000, 3000};
        double[] interestRates = {0.05, 0.06, 0.07};
		
        System.out.println("Return for single investment with fixed rate: " + calInvest.calculateReturn(principal));
        System.out.println("Return for single investment with specified rate: " + calInvest.calculateReturn(principal, interestRate));
        System.out.println("Return for single investment over years: " + calInvest.calculateReturn(principal, interestRate, years));
       
        double[] returns1 = calInvest.calculateReturn(investments);
        System.out.print("Returns for array of investments with fixed rate: ");
        for (double r : returns1) {
            System.out.print(r + " ");
        }
        System.out.println();
        
        double[] returns2 = calInvest.calculateReturn(investments, interestRates);
        System.out.print("Returns for array of investments with specified rates: ");
        for (double r : returns2) {
            System.out.print(r + " ");
        }
      //
	}
}
