/*
 * Inventory Management System
 * Author : Mohana Priya K
 */

import java.util.HashMap;
import java.util.Scanner;

// Product class
class Product {

    String productId;
    String productName;
    int quantity;
    double price;

    Product(String productId, String productName,
            int quantity, double price) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("\nProduct ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : ₹" + price);
    }
}

public class InventoryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Product> inventory = new HashMap<>();

        int choice;

        do {

            System.out.println("\n===== INVENTORY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                //Add Product
                case 1:

                    System.out.print("Enter Product ID (Alphanumeric): ");
                    String id = sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    Product product =
                            new Product(id, name, qty, price);

                    inventory.put(id, product);

                    System.out.println("Product Added Successfully.");
                    break;

                // Update Product
                case 2:

                    System.out.print("Enter Product ID to Update: ");
                    String updateId = sc.nextLine();

                    if (inventory.containsKey(updateId)) {

                        Product p = inventory.get(updateId);

                        System.out.print("Enter New Product Name: ");
                        p.productName = sc.nextLine();

                        System.out.print("Enter New Quantity: ");
                        p.quantity = sc.nextInt();

                        System.out.print("Enter New Price: ");
                        p.price = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Product Updated Successfully.");
                    }
                    else {
                        System.out.println("Product Not Found.");
                    }

                    break;

                //Delete Product
                case 3:

                    System.out.print("Enter Product ID to Delete: ");
                    String deleteId = sc.nextLine();

                    if (inventory.containsKey(deleteId)) {

                        inventory.remove(deleteId);

                        System.out.println("Product Deleted Successfully.");
                    }
                    else {
                        System.out.println("Product Not Found.");
                    }

                    break;

                //Display Products
                case 4:

                    if (inventory.isEmpty()) {

                        System.out.println("Inventory is Empty.");
                    }
                    else {

                        System.out.println("\nInventory Details");

                        for (Product p : inventory.values()) {
                            p.display();
                        }
                    }

                    break;

                case 5:

                    System.out.println("Exiting System...");
                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 5);

        sc.close();
    }
}