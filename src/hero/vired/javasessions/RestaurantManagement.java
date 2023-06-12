package hero.vired.javasessions;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RestaurantManagement {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static String file = "RestaurantFile.csv";
    static boolean isFileEmpty = true; // Add this variable to track if the file is empty or not

    // Method to write order data to CSV file
    public static void writeOrderData(String[] orderData) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
            if (isFileEmpty) {
                wr.write("WaiterName,CustomerName,ItemName,OrderMode,SalesAmount,Date,TipAmount");
                wr.newLine();
                isFileEmpty = false; // Update the variable to indicate that the file is not empty anymore
            }
            String waiterName = orderData[0];
            String customerName = orderData[1];
            String itemName = orderData[2];
            String orderMode = orderData[3];
            String salesAmount = orderData[4];
            String date = orderData[5];
            String tipAmount = orderData[6];

            wr.write("WaiterName,CustomerName,ItemName,OrderMode,SalesAmount,Date,TipAmount");
            wr.newLine();
            wr.write(waiterName);
            wr.write(",");
            wr.write(customerName);
            wr.write(",");
            wr.write(itemName);
            wr.write(",");
            wr.write(orderMode);
            wr.write(",");
            wr.write(salesAmount);
            wr.write(",");
            wr.write(date);
            wr.write(",");
            wr.write(tipAmount);
            wr.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to read order data from CSV file
    public static List<String[]> readOrderData() {
        List<String[]> orderDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // Skip the first line (column headers)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String waiterName = data[0];
                String customerName = data[1];
                String itemName = data[2];
                String orderMode = data[3];
                String salesAmount = data[4];
                String tipAmount = data[5];

                System.out.println("Name of the customer = " + customerName + " Wait name = " + waiterName
                        + " itemName = " + itemName + " salesAmount = " + salesAmount + " tipAmount = " + tipAmount
                        + " orderMode = " + orderMode);

                orderDataList.add(data);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return orderDataList;
    }

    // Method to calculate total sales
    public static double calculateTotalSales(List<String[]> orderDataList) {
        double totalSalesAmount = 0.0;
        for (String[] data : orderDataList) {
            String salesAmountStr = data[4];
            double salesAmount = 0.0;
            try {
                salesAmount = Double.parseDouble(salesAmountStr);
            } catch (NumberFormatException e) {
                System.err.println("Invalid sales amount: " + salesAmountStr);
                continue; // Skip this entry and move to the next one
            }
            totalSalesAmount += salesAmount;
        }
        return totalSalesAmount;
    }

    // Method to search for orders by customer name
    public static void searchOrdersByCustomerName(List<String[]> orderDataList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the customer:");
        String enteredCustName = sc.nextLine();

        for (String[] data : orderDataList) {
            String custName = data[1];
            if (enteredCustName.equalsIgnoreCase(custName)) {
                System.out.println("Waiter name: " + data[0]);
                System.out.println("Item name: " + data[2]);
                System.out.println("Tip Amount: " + data[6]);
            }
        }
    }

    // Method to find online orders on a particular date
    public static void findOnlineOrdersByDate(List<String[]> orderDataList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of the order:");
        String orderType = sc.nextLine();

        for (String[] data : orderDataList) {
            String searchedOrderType = data[3];
            if (orderType.equalsIgnoreCase(searchedOrderType)) {
                System.out.println("Customer name: " + data[1]);
                System.out.println("Waiter name: " + data[0]);
                System.out.println("Item name: " + data[2]);
                System.out.println("Tip Amount: " + data[6]);
            }
        }
    }
// Method to find the waiter who handled the maximum number of customers
public static String findMaxCustomerWaiter(List<String[]> orderDataList) {
    HashMap<String, Integer> map = new HashMap<>();
    boolean isFirstRow = true; // Flag to skip the first row

    for (String[] data : orderDataList) {
        if (isFirstRow) {
            isFirstRow = false;
            continue; // Skip the first row
        }

        String waiterName = data[0];
        System.out.println(waiterName);
        map.put(waiterName, map.getOrDefault(waiterName, 1) + 1);
    }

    int maxCount = 0;
    String maxCustomerWaiter = null;

    for (String waiter : map.keySet()) {
        int count = map.get(waiter);
        if (count > maxCount) {
            maxCount = count;
            maxCustomerWaiter = waiter;
        }
    }

    return maxCustomerWaiter;
}

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------- Restaurant System Menu -----------");
            System.out.println("1. Place an Order");
            System.out.println("2. Calculate Total Sales for the Day");
            System.out.println("3. Search Orders by Customer Name");
            System.out.println("4. Find Online Orders on a Date");
            System.out.println("5. Find Waiter Handling Maximum Customers");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            List<String[]> orderDataList = readOrderData();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter waiter name: ");
                    String waiterName = scanner.nextLine();

                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter sales amount: ");
                    double salesAmount = scanner.nextDouble();

                    System.out.print("Enter order mode (online/offline): ");
                    String orderMode = scanner.next();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter tip amount: ");
                    double tipAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    String[] orderData = {
                            waiterName,
                            customerName,
                            itemName,
                            orderMode,
                            String.valueOf(salesAmount),
                            LocalDate.now().format(DATE_FORMATTER),
                            String.valueOf(tipAmount)
                    };
                    writeOrderData(orderData);
                    break;

                case 2:
                    double totalSales = calculateTotalSales(orderDataList);
                    System.out.println("Total sales for the day: $" + totalSales);
                    break;

                case 3:
                    searchOrdersByCustomerName(orderDataList);
                    break;

                case 4:
                    findOnlineOrdersByDate(orderDataList);
                    break;

                case 5:
                    String maxCustomerWaiter = findMaxCustomerWaiter(orderDataList);
                    System.out.println("Waiter who handled the maximum number of customers: " + maxCustomerWaiter);
                    break;

                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}
