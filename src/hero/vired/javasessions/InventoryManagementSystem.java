package hero.vired.javasessions;

import java.util.Scanner;

public class InventoryManagementSystem {
    private static final int MAX_PRODUCTS = 10;
    private static final String[] productNames = {"Mobile", "Laptop", "Tablet", "Portable HDD", "Bluetooth Headphone",
            "Smart-watch", "Digital Camera", "Portable Power bank", "Printer", "Wireless Router"};
    private static final String[] productSpecifications = {"", "", "", "", "", "Compatibility - ios and Android | Water Resistance | Battery Life - 2days | GPS, fitness tracking, sleep monitoring, step counting, and more", "", "", "", ""};
    private static final double[] productCosts = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    private static int[] productQuantities = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------------");
        System.out.println("Welcome to the SmartPoint Electronics Store");
        System.out.println("--------------------------------------------------------");

        String choice;
        do {
            displayMainMenu();
            System.out.print("Please choose an option from the above menu: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayProductList();
                    break;
                case 2:
                    checkProductCount(scanner);
                    break;
                case 3:
                    viewProductDetails(scanner);
                    break;
                case 4:
                    editProduct(scanner);
                    break;
                case 5:
                    updateInventory(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for visiting SmartPoint!");
                    return;
                default:
                    System.out.println("Invalid option! Please choose a valid option.");
            }

            System.out.println("--------------------------------------------------------");
            System.out.print("Enter 'Y' to return to the main menu or 'N' to Exit: ");
            choice = scanner.next();
            System.out.println("--------------------------------------------------------");
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Thank you for visiting SmartPoint!");
    }

    private static void displayMainMenu() {
        System.out.println("View the complete list of our products");
        System.out.println("Check the available count for a specific product");
        System.out.println("View the specifications and details of a specific product");
        System.out.println("Modify the details of a specific product");
        System.out.println("Update the inventory for a specific product");
        System.out.println("Exit");
    }

    private static void displayProductList() {
        System.out.println("--------------------------------------------------------");
        System.out.println("List of all Products");
        System.out.println("--------------------------------------------------------");
        System.out.println("Product ID\tProduct Name\n");
        for (int i = 0; i < MAX_PRODUCTS; i++) {
            System.out.printf("\t%d\t\t%s\n", (i + 101), productNames[i]);
        }
    }

    private static void checkProductCount(Scanner scanner) {
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();
        int index = productId - 101;

        if (index >= 0 && index < MAX_PRODUCTS) {
            System.out.println("--------------------------------------------------------");
            System.out.printf("%d%s\n", productId, productNames[index]);
            System.out.printf("Total available count: %d\n", productQuantities[index]);
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    private static void viewProductDetails(Scanner scanner) {
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();
        int index = productId - 101;

        if (index >= 0 && index < MAX_PRODUCTS) {
            System.out.println("--------------------------------------------------------");
            System.out.printf("%d%s\n", productId, productNames[index]);
            System.out.printf("Total available count: %d\n", productQuantities[index]);
            System.out.println(productSpecifications[index]);
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    private static void editProduct(Scanner scanner) {
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();
        int index = productId - 101;

        if (index >= 0 && index < MAX_PRODUCTS) {
            System.out.println("--------------------------------------------------------");
            System.out.printf("%d%s\n", productId, productNames[index]);
            System.out.printf("Total available count: %d\n", productQuantities[index]);
            System.out.println(productSpecifications[index]);
            System.out.println("--------------------------------------------------------");

            System.out.println("What details would you like to modify?");
            System.out.println("1. Specifications");
            System.out.println("2. Cost");
            System.out.println("3. Quantity");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the new specifications: ");
                    scanner.nextLine();
                    String specifications = scanner.nextLine();
                    productSpecifications[index] = specifications;
                    System.out.println("Specifications updated successfully!");
                    break;
                case 2:
                    System.out.print("Enter the new cost: ");
                    double cost = scanner.nextDouble();
                    productCosts[index] = cost;
                    System.out.println("Cost updated successfully!");
                    break;
                case 3:
                    System.out.print("Enter the new quantity: ");
                    int quantity = scanner.nextInt();
                    productQuantities[index] = quantity;
                    System.out.println("Quantity updated successfully!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    private static void updateInventory(Scanner scanner) {
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();
        int index = productId - 101;

        if (index >= 0 && index < MAX_PRODUCTS) {
            System.out.println("--------------------------------------------------------");
            System.out.printf("%d%s\n", productId, productNames[index]);
            System.out.printf("Current available inventory: %d\n", productQuantities[index]);
            System.out.println("--------------------------------------------------------");

            System.out.println("Update inventory options:");
            System.out.println("1. Add inventory");
            System.out.println("2. Subtract inventory");
            System.out.print("Please choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Please enter the count to be added: ");
                    int addCount = scanner.nextInt();
                    productQuantities[index] += addCount;
                    System.out.println("Inventory updated successfully!");
                    break;
                case 2:
                    System.out.print("Please enter the count to be subtracted: ");
                    int subtractCount = scanner.nextInt();
                    if (productQuantities[index] >= subtractCount) {
                        productQuantities[index] -= subtractCount;
                        System.out.println("Inventory updated successfully!");
                    } else {
                        System.out.println("Insufficient inventory to subtract!");
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } else {
            System.out.println("Invalid Product ID!");
        }
    }
    
}
