package coreJavaz.oopz;

import java.util.Scanner;

public class ShoppingCartDemo 
{
	public static void main(String[] args) 
	{
		
		ShoppingCart cart = new ShoppingCart();
		Scanner scanner = new Scanner(System.in);

		// Adding electronics to the cart
		System.out.print("Enter electronics name: ");
		String electronicsName = scanner.nextLine();
		System.out.print("Enter electronics price: ");
		double electronicsPrice = scanner.nextDouble();
		scanner.nextLine(); // Consume the newline
		System.out.print("Enter electronics brand: ");
		String electronicsBrand = scanner.nextLine();

		Electronics electronics = new Electronics(electronicsName, electronicsPrice, electronicsBrand);
		cart.addProduct(electronics);

		// Adding clothing to the cart
		System.out.print("Enter clothing name: ");
		String clothingName = scanner.nextLine();
		System.out.print("Enter clothing price: ");
		double clothingPrice = scanner.nextDouble();
		scanner.nextLine(); // Consume the newline
		System.out.print("Enter clothing size: ");
		String clothingSize = scanner.nextLine();

		Clothing clothing = new Clothing(clothingName, clothingPrice, clothingSize);
		cart.addProduct(clothing);

		// Display cart contents
		System.out.println("\nCart Contents:");
		cart.displayCart();

		scanner.close();
	}
}
