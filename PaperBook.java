public class PaperBook extends Book {
    public PaperBook(String id, double price, String isbn, String title, int yearPublished, String authorName) {
        super(id, price, isbn, title, yearPublished, authorName, DeliveryMethod.SHIP);
    }
}
