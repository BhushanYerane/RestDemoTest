package coreJavaz.oopz;

public class vehicles {
    // Properties
    protected String brand;
    protected int year;

    // Constructor
    public vehicles(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
    
    @Override
    public String toString() {
    	return "Brand: "+brand+" "+", Year: "+year;
    }
    
}
