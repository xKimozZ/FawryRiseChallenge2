public class EBook extends Book {
    public EBook(String id, double price, String isbn, String title, int yearPublished, String authorName) {
        super(id, price, isbn, title, yearPublished, authorName, DeliveryMethod.EMAIL);
    }
}
