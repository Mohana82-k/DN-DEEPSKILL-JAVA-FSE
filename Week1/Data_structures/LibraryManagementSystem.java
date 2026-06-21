/*
 * Exercise 6 : Library Management System
 * Author : Mohana Priya K
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Book class
class Book {

    String bookId;
    String title;
    String author;

    Book(String bookId,
         String title,
         String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {

        System.out.println("--------------------------------");
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
    }
}

public class LibraryManagementSystem {

    //Linear Search
    public static Book linearSearch(
            Book[] books,
            String targetTitle) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(targetTitle)) {

                return book;
            }
        }

        return null;
    }

    //Binary Search
    public static Book binarySearch(
            Book[] books,
            String targetTitle) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare =
                    books[mid].title.compareToIgnoreCase(
                            targetTitle);

            if (compare == 0) {

                return books[mid];
            }

            else if (compare < 0) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return null;
    }

    public static void displayBooks(Book[] books) {

        for (Book book : books) {

            book.display();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
                "Enter Number of Books: ");

        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {

            System.out.println(
                    "\nEnter Book " + (i + 1) + " Details");

            System.out.print("Book ID: ");
            String id = sc.nextLine();

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            books[i] = new Book(
                    id,
                    title,
                    author);
        }

        System.out.println(
                "\n===== BOOK DETAILS =====");

        displayBooks(books);
        System.out.print(
                "\nEnter Book Title for Linear Search: ");

        String searchTitle =
                sc.nextLine();

        Book linearResult =
                linearSearch(books, searchTitle);

        System.out.println(
                "\n===== LINEAR SEARCH RESULT =====");

        if (linearResult != null) {

            linearResult.display();
        }

        else {

            System.out.println(
                    "Book Not Found.");
        }

        // Binary Search requires sorted array
        Book[] sortedBooks = books.clone();

        Arrays.sort(
                sortedBooks,
                Comparator.comparing(
                        b -> b.title.toLowerCase()));

        System.out.print(
                "\nEnter Book Title for Binary Search: ");

        String binaryTitle =
                sc.nextLine();

        Book binaryResult =
                binarySearch(
                        sortedBooks,
                        binaryTitle);

        System.out.println(
                "\n===== BINARY SEARCH RESULT =====");

        if (binaryResult != null) {

            binaryResult.display();
        }

        else {

            System.out.println(
                    "Book Not Found.");
        }

        sc.close();
    }
}