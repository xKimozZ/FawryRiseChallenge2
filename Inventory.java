public class Inventory {
    private InventoryItem[] items;
    private int capacity;

    public Inventory(int capacity) {
        items = new InventoryItem[capacity];
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public InventoryItem getItemAtIndex(int index) {
        return items[index];
    }

    public void addProduct(Product product, int quantity) {
        // Try to find an existing entry
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(product.getId())) {
                items[i].increaseQuantity(quantity);
                return;
            }
        }

        // Otherwise add new
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = new InventoryItem(product, quantity);
                return;
            }
        }
    }

    public InventoryItem getItem(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                return items[i];
            }
        }
        return null;
    }

    // books only for now!
    public Book[] removeOutdated(int currentYear, int maxAge) {
        Book[] removedBooks = new Book[items.length];
        int removedIndex = 0; // which index will the removed book reside?

        for (int i = 0; i < items.length; i++) {
            InventoryItem item = items[i];
            if (item != null) {
                Product product = item.getProduct();
                if (product instanceof Book) {
                    Book book = (Book) product;
                    if ((currentYear - book.getYearPublished()) > maxAge) {
                        removedBooks[removedIndex++] = book;
                        items[i] = null;
                        System.out.println("Removing outdated book: " + book.getTitle() + ". Year Published: " + book.getYearPublished()
                        + ", Current Year: " + currentYear + ", Max Age: " + maxAge);
                    }
                }
            }
        }

        return removedBooks;
    }

}
