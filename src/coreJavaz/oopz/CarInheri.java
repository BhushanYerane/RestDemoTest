package coreJavaz.oopz;

public class CarInheri extends vehicles {
    // Additional property
    private int numberOfDoors;
    
    // Constructor
    public CarInheri(String brand, int year, int numberOfDoors) {
        super(brand, year); // Call the constructor of the base class
        this.numberOfDoors = numberOfDoors;
    }

    // Method to display car details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the base class method
        System.out.println("Number of Doors: " + numberOfDoors);
    }
    
    public String toString()
    {
    	return super.toString() + ", Number of Doors: " + numberOfDoors;
    }
}
