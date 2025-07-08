public class InventoryItem {
    private Product product;
    private String id;
    private int quantity;

    public InventoryItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.id = product.getId();
    }

    public Product getProduct() {
        return product;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Product unavailable in requested quantity. Available: " + quantity + ", Requested: " + amount);
        }
        quantity -= amount;
        return true;
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }
}
