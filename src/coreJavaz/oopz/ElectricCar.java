package coreJavaz.oopz;

public class ElectricCar extends CarInheri {
    // Additional property
    private int batteryLife;
    
    // Constructor
    public ElectricCar(String brand, int year, int numberOfDoors, int batteryLife) {
        super(brand, year, numberOfDoors); // Call the constructor of the Car class
        this.batteryLife = batteryLife;
    }

    // Method to display electric car details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the Car class method
        System.out.println("Battery Life: " + batteryLife + " hours");
    }
    
    public String toString()
    {
    	return super.toString() + ", Battery Life: " + batteryLife + " hours";
    }
}
