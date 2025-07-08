public class ShippingService extends DummyService {
    public void send(Product product, String dest) {
        if (!(product instanceof PaperBook)) {
            throw new IllegalArgumentException("Product must be PaperBook");
        }

        PaperBook paperbook = (PaperBook) product;
        System.out.println("ShippingService: Send paper book id: '" + product.getId() +
        "', booktitle: " + paperbook.getTitle() + " to physical address: " + dest);
    }
}
