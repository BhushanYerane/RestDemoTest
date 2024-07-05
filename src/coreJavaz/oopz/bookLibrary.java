package coreJavaz.oopz;

import java.util.ArrayList;
import java.util.List;

// Book class
class Book1 {
    private String title;
    private String author;

    // Constructor
    public Book1(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

// Library class
class Library {
    private String name;
    private List<Book1> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book1 book) {
        books.add(book);
    }

    // Method to display the library's books
    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book1 book : books) {
            System.out.println(book);
        }
    }
}

// Main class
public class bookLibrary {
    public static void main(String[] args) {
        // Create some books
    	Book1 book1 = new Book1("1984", "George Orwell");
        Book1 book2 = new Book1("To Kill a Mockingbird", "Harper Lee");
        Book1 book3 = new Book1("The Great Gatsby", "F. Scott Fitzgerald");

        // Create a library and add books to it
        Library library = new Library("City Library");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display the library's books
        library.displayBooks();
    }
}
