public abstract class Book extends Product {
    private String isbn;
    private String title;
    private int yearPublished;
    private String authorName;

    public Book(String id, double price, String isbn, String title, int yearPublished, String authorName, DeliveryMethod deliveryMethod) {
        super(id, price, deliveryMethod);
        this.isbn = isbn;
        this.title = title;
        this.yearPublished = yearPublished;
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getAuthorName() {
        return authorName;
    }

}
