public class MailService extends DummyService {
    public void send(Product product, String dest) {
        if (!(product instanceof EBook)) {
            throw new IllegalArgumentException("Product must be an EBook");
        }

        EBook ebook = (EBook) product;
        System.out.println("MailService: Send ebook id: '" + product.getId() +
        "', booktitle: " + ebook.getTitle() + " to email address: " + dest);
    }
}
