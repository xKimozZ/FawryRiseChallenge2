public class Payment {
    private Inventory inventory;
    private ShippingService shippingService = new ShippingService();
    private MailService mailService = new MailService();

    public Payment(Inventory inventory) {
        this.inventory = inventory;
    }

    // assuming we can buy just a single book
    public double buyBook(String isbn, String email, String address) {
        try {
            InventoryItem item =null;

            for (int i = 0; i < inventory.getCapacity(); i++) {
                InventoryItem current = inventory.getItemAtIndex(i);
                if (current != null && current.getProduct() instanceof Book book) {
                    if (book.getIsbn().equals(isbn)) {
                        item = current;
                        break;
                    }
                }
            }

            if (item == null) {
                System.out.println("No payment occurred, couldnt find isbn: " + isbn);
                return -1;
            }

            Product product = item.getProduct();
            if (!(product instanceof Book)) {
                System.out.println("Product is not a book. No payment occurred.");
                return -1;
            }

            Book book = (Book) product;

            if (book instanceof DemoBook || product.getDeliveryMethod() == DeliveryMethod.NONE) {
                System.out.println("This book is not for sale . No payment occurred.");
                return -1;
            }

            if (product.getDeliveryMethod() == DeliveryMethod.SHIP) {
                item.reduceQuantity(1);

                System.out.println("Book bought: " + book.getTitle() + ", You paid: " + product.getPrice());
                shippingService.send(product, address);
                return product.getPrice();
            }

            if (product.getDeliveryMethod() == DeliveryMethod.EMAIL) {
                System.out.println("Book bought: " + book.getTitle() + ", You paid: " + product.getPrice());
                mailService.send(product, email);
                return product.getPrice();
            }

            return -1;
        } catch (Exception e) {
            System.out.println("Unexpected error caught: " + e.getMessage());
            return -1;
        }
    }
}
