public abstract class DummyService {
    public void send(Product product, String dest) {
        System.out.println("DummyService: Send " + product.getId() + " to " + dest);
    }
}
