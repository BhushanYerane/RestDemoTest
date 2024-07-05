package coreJavaz.oopz;

class Investment  // base class
{
	protected double principal;
	protected double interestRate;
	
	public Investment(double principal, double interestRate)
	{
		this.interestRate = interestRate;
		this.principal = principal;
	}
	
	public double calculateReturns() 
	{
        return principal * interestRate;
    }
	
	public void displayReturns() 
	{
        System.out.println("Investment return: " + calculateReturns());
    }
}
	
class StockInvestment extends Investment
{
	private double riskPremium;
	
	public StockInvestment(double principal, double interestRate, double riskPremium) 
	{
		super(principal, interestRate);
		this.riskPremium = riskPremium;		
	}
	
	@Override
    public double calculateReturns() 
	{
        return principal * (interestRate + riskPremium);
    }
	
	@Override
    public void displayReturns() {
        System.out.println("Stock investment return: " + calculateReturns());
    }
}

class BondInvestment extends Investment {
    private int yearsToMaturity;

    public BondInvestment(double principal, double interestRate, int yearsToMaturity) {
        super(principal, interestRate);
        this.yearsToMaturity = yearsToMaturity;
    }

    @Override
    public double calculateReturns() {
        return principal * interestRate * yearsToMaturity;
    }

    @Override
    public void displayReturns() {
        System.out.println("Bond investment return: " + calculateReturns());
    }
}

public class methodOverriding 
{
    public static void main(String[] args) 
    {
    	Investment genericInvestment = new Investment(1000, 0.05);
        StockInvestment stockInvestment = new StockInvestment(1000, 0.07, 0.03);
        BondInvestment bondInvestment = new BondInvestment(1000, 0.04, 10);

        // Display returns for each investment type
        genericInvestment.displayReturns();
        stockInvestment.displayReturns();
        bondInvestment.displayReturns();    	
    }
}


