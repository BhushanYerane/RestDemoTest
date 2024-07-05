package coreJavaz.oopz;

public class fictions extends book {
    private String genre;

    // Constructor
    public fictions(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Overriding displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}
