package hero.vired.javasessions;
import java.util.ArrayList;
import java.util.Scanner;


public class InventoryMGMSystem {
    private ArrayList<Product> products;

    public InventoryMGMSystem() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void viewProductList() {
        if (products.isEmpty()) {
            System.out.println("No products available in the inventory.");
        } else {
            System.out.println("Product List:");
            for (Product product : products) {
                System.out.println(product.getName());
            }
        }
    }

    public void viewProductCount(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println("Product Count for " + productName + ": " + product.getCount());
                return;
            }
        }
        System.out.println("Product not found in the inventory.");
    }

    public void viewProductDetails(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println("Product Details for " + productName + ":\n" + product);
                return;
            }
        }
        System.out.println("Product not found in the inventory.");
    }

    public void editProduct(String productName, String newSpecification, double newCost) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setSpecification(newSpecification);
                product.setCost(newCost);
                System.out.println("Product details updated successfully.");
                return;
            }
        }
        System.out.println("Product not found in the inventory.");
    }

    public void updateInventory(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                int newCount = product.getCount() + quantity;
                product.setCount(newCount);
                System.out.println("Inventory updated successfully.");
                return;
            }
        }
        System.out.println("Product not found in the inventory.");
    }

    public static void main(String[] args) {
        InventoryMGMSystem ims = new InventoryMGMSystem();

        // Sample data
        Product p1 = new Product("Laptop", "Intel i5, 8GB RAM, 256GB SSD", 899.99, 5);
        Product p2 = new Product("Smartphone", "6.4\" Display, 128GB Storage", 699.99, 10);
        Product p3 = new Product("Headphones", "Wireless, Noise Cancelling", 149.99, 20);

        ims.addProduct(p1);
        ims.addProduct(p2);
        ims.addProduct(p3);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- Inventory Management System Menu -----");
            System.out.println("1. View Product List");
            System.out.println("2. View Product Count");
            System.out.println("3. View Product Details");
            System.out.println("4. Edit Product");
            System.out.println("5. Update Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ims.viewProductList();
                    break;
                case 2:
                    System.out.print("Enter the product name: ");
                    scanner.nextLine(); // Consume newline character
                    String countProductName = scanner.nextLine();
                    ims.viewProductCount(countProductName);
                    break;
                case 3:
                    System.out.print("Enter the product name: ");
                    scanner.nextLine(); // Consume newline character
                    String detailsProductName = scanner.nextLine();
                    ims.viewProductDetails(detailsProductName);
                    break;
                case 4:
                    System.out.print("Enter the product name: ");
                    scanner.nextLine(); // Consume newline character
                    String editProductName = scanner.nextLine();
                    System.out.print("Enter the new specification: ");
                    String newSpecification = scanner.nextLine();
                    System.out.print("Enter the new cost: ");
                    double newCost = scanner.nextDouble();
                    ims.editProduct(editProductName, newSpecification, newCost);
                    break;
                case 5:
                    System.out.print("Enter the product name: ");
                    scanner.nextLine(); // Consume newline character
                    String updateProductName = scanner.nextLine();
                    System.out.print("Enter the quantity to add/delete (-ve to delete): ");
                    int quantity = scanner.nextInt();
                    ims.updateInventory(updateProductName, quantity);
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
