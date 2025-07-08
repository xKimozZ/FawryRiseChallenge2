public class DemoBook extends Book {
    public DemoBook(String id, double price, String isbn, String title, int yearPublished, String authorName) {
        super(id, price, isbn, title, yearPublished, authorName, DeliveryMethod.NONE);
    }
}
