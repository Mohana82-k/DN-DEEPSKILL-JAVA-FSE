/*
 * Exercise 4 : Employee Management System
 * Author : Mohana Priya K
 */

import java.util.Scanner;

// Employee class
class Employee {

    String employeeId;
    String name;
    String position;
    double salary;

    Employee(String employeeId,
             String name,
             String position,
             double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {

        System.out.println("--------------------------------");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Position    : " + position);
        System.out.println("Salary      : ₹" + salary);
    }
}

public class EmployeeManagementSystem {
    static Employee[] employees = new Employee[100];
    static int count = 0;

    //Add Employee
    public static void addEmployee(Employee emp) {

        if (count < employees.length) {

            employees[count] = emp;
            count++;

            System.out.println("Employee Added Successfully.");
        }
        else {

            System.out.println("Employee Storage Full.");
        }
    }

    //Search Employee
    public static Employee searchEmployee(String id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId.equalsIgnoreCase(id)) {

                return employees[i];
            }
        }

        return null;
    }

    // Display Employees
    public static void displayEmployees() {

        if (count == 0) {

            System.out.println("No Employee Records Found.");
            return;
        }

        for (int i = 0; i < count; i++) {

            employees[i].display();
        }
    }

    // Delete Employee
    public static void deleteEmployee(String id) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId.equalsIgnoreCase(id)) {

                index = i;
                break;
            }
        }

        if (index == -1) {

            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {

            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted Successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee emp =
                            new Employee(id,
                                    name,
                                    position,
                                    salary);

                    addEmployee(emp);
                    break;

                case 2:

                    System.out.print(
                            "Enter Employee ID to Search: ");

                    String searchId = sc.nextLine();

                    Employee found =
                            searchEmployee(searchId);

                    if (found != null) {

                        found.display();
                    }
                    else {

                        System.out.println(
                                "Employee Not Found.");
                    }

                    break;

                case 3:

                    displayEmployees();
                    break;

                case 4:

                    System.out.print(
                            "Enter Employee ID to Delete: ");

                    String deleteId = sc.nextLine();

                    deleteEmployee(deleteId);
                    break;

                case 5:

                    System.out.println(
                            "Exiting System...");
                    break;

                default:

                    System.out.println(
                            "Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}