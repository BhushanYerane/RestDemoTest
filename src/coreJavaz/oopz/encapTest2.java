package coreJavaz.oopz;

import java.util.Scanner;

public class encapTest2 {

	public static void main(String[] args) {
		
		book fictionBook = new fictions("1984", "George Orwell", "123456789", "Dystopian");
        book nonFictionBook = new nonFictions("Sapiens", "Yuval Noah Harari", "987654321", "History");

        // Displaying book information
        fictionBook.displayInfo();
        System.out.println();
        nonFictionBook.displayInfo();

        // Demonstrating encapsulation with user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUpdate Fiction Book Information:");
        System.out.print("Enter new title: ");
        fictionBook.setTitle(scanner.nextLine());

        System.out.print("Enter new author: ");
        fictionBook.setAuthor(scanner.nextLine());

        System.out.print("Enter new ISBN: ");
        fictionBook.setIsbn(scanner.nextLine());

        ((fictions) fictionBook).setGenre("Science Fiction");

        System.out.println("\nUpdated Fiction Book Information:");
        fictionBook.displayInfo();
	}
}
