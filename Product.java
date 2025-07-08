enum DeliveryMethod {
    SHIP,
    EMAIL,
    NONE,
};

public abstract class Product {
    private String id;
    private double price;
    private DeliveryMethod deliveryMethod;

    public Product(String id, double price, DeliveryMethod deliveryMethod) {
        this.id = id;
        this.price = price;
        this.deliveryMethod = deliveryMethod;    
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setId(String id) {
        this.id = id;
    }

}