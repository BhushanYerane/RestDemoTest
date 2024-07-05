package coreJavaz.oopz;

public class car {
	String make, model;
	int year;
	double price;
	
	public car(String make,String model,int year,double price)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public void displayDetails()
	{
		System.out.println("Make: "+make);
		System.out.println("Model: "+model);
		System.out.println("Year: "+year);
		System.out.println("Price: "+price);
	}
	
	public String toString()
	{
		return make+" "+model+" "+year+" "+price+" ";
	}
	
	public int calculateAge(int yrs)
	{
		int CurrentYear = 2024;
		int carAge = CurrentYear - yrs;
		return carAge;
		
	}

}
