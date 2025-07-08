public class Testbench {

    public static void test1(int currentYear, int maxAge) {
        try {
            System.out.println("*************\nTest 1: Add & Remove Outdated Books");
            Inventory inventory = new Inventory(10);

            PaperBook oldBook = new PaperBook("B001", 100.0, "ISBN-001", "Book 1paper", 2010, "auth1");
            EBook newEBook = new EBook("B002", 80.0, "ISBN-002", "Book 2ebook", 2022, "auth2");

            inventory.addProduct(oldBook, 2);
            inventory.addProduct(newEBook, 1);

            // Print inventory
            System.out.println("Initial inventory:");
            for (int i = 0; i < inventory.getCapacity(); i++) {
                InventoryItem item = inventory.getItemAtIndex(i);
                if (item != null) {
                    Product p = item.getProduct();
                    if (p instanceof Book b) {
                        System.out.println(b.getTitle() + " | Quantity: " + item.getQuantity());
                    }
                }
            }

            // Remove
            Book[] removed = inventory.removeOutdated(currentYear, maxAge);
            System.out.println("Removed books:");
            for (Book b : removed) {
                if (b != null) {
                    System.out.println("- " + b.getTitle());
                }
            }

        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }
    }

    public static void test2() {
        try {
            System.out.println("\n*************\nTest 2: Purchase PaperBook & EBook");
            Inventory inventory = new Inventory(10);

            PaperBook paper = new PaperBook("B003", 120.0, "ISBN-003", "kpaperimo", 2018, "lolo1");
            EBook ebook = new EBook("B004", 60.0, "ISBN-004", "Book2ebook", 2021, "nononn");

            inventory.addProduct(paper, 2);
            inventory.addProduct(ebook, 1);

            Payment payment = new Payment(inventory);

            payment.buyBook("ISBN-003", "cpp@lol.com", "123 Cairo St");
            payment.buyBook("ISBN-004", "ai@haha.com", "Nowhere Rd.");

        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }
    }

    public static void test3() {
        try {
            System.out.println("\n*************\nTest 3: Buy Demo and Invalid ISBN");
            Inventory inventory = new Inventory(10);

            DemoBook demo = new DemoBook("B005", 0.0, "ISBN-005", "HelloWorldDemo", 2017, "DemoAuth");
            inventory.addProduct(demo, 1);

            Payment payment = new Payment(inventory);

            payment.buyBook("ISBN-005", "demo@demo.com", "DemoAddress");
            payment.buyBook("ISBN-999", "unshi@unshi.com", "unshippableAddr");

        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }
    }
}
