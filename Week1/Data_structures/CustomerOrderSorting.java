/*
 * Exercise 3 : Sorting Customer Orders
 * Author : Mohana Priya K
 */

import java.util.Scanner;

class Order {

    String orderId;
    String customerName;
    double totalPrice;
    Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    void display() {
        System.out.println("--------------------------------");
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Total Price   : Rs" + totalPrice);
    }
}
public class CustomerOrderSorting {
    public static void displayOrders(Order[] orders) {

        for (Order order : orders) {
            order.display();
        }
    }

    //Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
    public static int partition(Order[] orders,
                                int low,
                                int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    //Quick Sort 
    public static void quickSort(Order[] orders,
                                 int low,
                                 int high) {

        if (low < high) {

            int pivotIndex =
                    partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }
    public static Order[] copyOrders(Order[] original) {

        Order[] copy = new Order[original.length];

        for (int i = 0; i < original.length; i++) {

            copy[i] = new Order(
                    original[i].orderId,
                    original[i].customerName,
                    original[i].totalPrice
            );
        }

        return copy;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Orders: ");
        int n = sc.nextInt();
        sc.nextLine();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details for Order "
                    + (i + 1));

            System.out.print("Order ID (Alphanumeric): ");
            String orderId = sc.nextLine();

            System.out.print("Customer Name: ");
            String customerName = sc.nextLine();

            System.out.print("Total Price: ");
            double totalPrice = sc.nextDouble();
            sc.nextLine();

            orders[i] = new Order(
                    orderId,
                    customerName,
                    totalPrice
            );
        }

        Order[] bubbleOrders = copyOrders(orders);
        Order[] quickOrders = copyOrders(orders);
        System.out.println("\nORIGINAL ORDERS");
        displayOrders(orders);
        bubbleSort(bubbleOrders);

        System.out.println("\nBUBBLE SORT RESULT");
        displayOrders(bubbleOrders);
        quickSort(quickOrders,0,quickOrders.length - 1);
        System.out.println("\nQUICK SORT RESULT");
        displayOrders(quickOrders);

    }
}