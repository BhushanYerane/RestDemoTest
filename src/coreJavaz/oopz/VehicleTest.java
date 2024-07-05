package coreJavaz.oopz;

import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {
        // Create a Car object (Single Inheritance)
        CarInheri car = new CarInheri("Toyota", 2020, 4);
        System.out.println("Car Details:");
        car.displayDetails();
        System.out.println("##--Using toString Method--#");
        System.out.println(car);
        
        // Create a Bike object (Hierarchical Inheritance)
        bikez bike = new bikez("Yamaha", 2018, true);
        System.out.println("\nBike Details:");
        bike.displayDetails();
        System.out.println("##--Using toString Method--#");
        System.out.println(bike);
        
        // Create an ElectricCar object (Multilevel Inheritance)
        ElectricCar electricCar = new ElectricCar("Tesla", 2021, 4, 24);
        System.out.println("\nElectric Car Details:");
        electricCar.displayDetails();
        System.out.println("##--Using toString Method--#");
        System.out.println(electricCar);
        
        ElectricCar electricCar1 = new ElectricCar("Rivian", 2020, 4, 50);
        System.out.println("\nAnother Electric Car Details:");
        System.out.println(electricCar1);
        
        System.out.println("Bellow program for User INPUTS");
        
     // Input for Car object
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter details for Car:");
        System.out.print("Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Year: ");
        int carYear = scanner.nextInt();
        System.out.print("Number of Doors: ");
        int carDoors = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        CarInheri car01 = new CarInheri(carBrand, carYear, carDoors);
        System.out.println("\nCar Details:");
        System.out.println(car01);

        // Input for Bike object
        System.out.println("\nEnter details for Bike:");
        System.out.print("Brand: ");
        String bikeBrand = scanner.nextLine();
        System.out.print("Year: ");
        int bikeYear = scanner.nextInt();
        System.out.print("Has Carrier (true/false): ");
        boolean hasCarrier = scanner.nextBoolean();
        scanner.nextLine();  // Consume newline

        bikez bike01 = new bikez(bikeBrand, bikeYear, hasCarrier);
        System.out.println("\nBike Details:");
        System.out.println(bike01);

        // Input for ElectricCar object
        System.out.println("\nEnter details for Electric Car:");
        System.out.print("Brand: ");
        String electricCarBrand = scanner.nextLine();
        System.out.print("Year: ");
        int electricCarYear = scanner.nextInt();
        System.out.print("Number of Doors: ");
        int electricCarDoors = scanner.nextInt();
        System.out.print("Battery Life (hours): ");
        int batteryLife = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        ElectricCar electricCar01 = new ElectricCar(electricCarBrand, electricCarYear, electricCarDoors, batteryLife);
        System.out.println("\nElectric Car Details:");
        System.out.println(electricCar01);

        scanner.close();
    }
}
