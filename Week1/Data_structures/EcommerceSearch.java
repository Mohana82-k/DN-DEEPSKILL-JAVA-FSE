/*
 * Exercise 2 : E-Commerce Platform Search Function
 * Author : Mohana Priya K
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Product class
class Product {

    String productId;
    String productName;
    String category;

    Product(String productId,
            String productName,
            String category) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("\nProduct ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products,
                                       String targetId) {

        for (Product p : products) {

            if (p.productId.equalsIgnoreCase(targetId)) {
                return p;
            }
        }

        return null;
    }

    //Binary Search
    public static Product binarySearch(Product[] products,
                                       String targetId) {

        int l = 0, r = products.length - 1;

        while (l <= r) {

            int mid = (l + r) / 2;

            int comparison =
                    products[mid].productId.compareToIgnoreCase(targetId);

            if (comparison == 0) {
                return products[mid];
            }
            else if (comparison < 0) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Product " + (i + 1) + " Details");

            System.out.print("Product ID: ");
            String id = sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] =
                    new Product(id, name, category);
        }

       
        Product[] sortedProducts = products.clone();

        Arrays.sort(sortedProducts,
                Comparator.comparing(p -> p.productId));

        System.out.print(
                "\nEnter Product ID to Search: ");
        String targetId = sc.nextLine();

        System.out.println("\n LINEAR SEARCH");

        Product result1 =
                linearSearch(products, targetId);

        if (result1 != null) {
            result1.display();
        }
        else {
            System.out.println("Product Not Found");
        }
        System.out.println("\nBINARY SEARCH ");

        Product result2 =
                binarySearch(sortedProducts, targetId);

        if (result2 != null) {
            result2.display();
        }
        else {
            System.out.println("Product Not Found");
        }

        sc.close();
    }
}