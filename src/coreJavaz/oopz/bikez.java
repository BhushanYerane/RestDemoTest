package coreJavaz.oopz;

public class bikez extends vehicles {
    // Additional property
    private boolean hasCarrier;
    
    // Constructor
    public bikez(String brand, int year, boolean hasCarrier) {
        super(brand, year); // Call the constructor of the base class
        this.hasCarrier = hasCarrier;
    }

    // Method to display bike details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the base class method
        System.out.println("Has Carrier: " + hasCarrier);
    }
    
    public String toString()
    {
    	return super.toString() + ", Has Carrier: " + hasCarrier;    	
    }
}

