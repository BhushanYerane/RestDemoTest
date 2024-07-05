package coreJavaz.oopz;

public class nonFictions extends book {
    private String subject;

    // Constructor
    public nonFictions(String title, String author, String isbn, String subject) {
        super(title, author, isbn);
        this.subject = subject;
    }

    // Getter and Setter for subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Overriding displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}
