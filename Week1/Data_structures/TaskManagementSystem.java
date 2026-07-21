/*
 * Exercise 5 : Task Management System
 * Author : Mohana Priya K
 */

import java.util.Scanner;

//Task class
class Task {

    String taskId;
    String taskName;
    String status;

    Task(String taskId,
         String taskName,
         String status) {

        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    void display() {

        System.out.println("--------------------------------");
        System.out.println("Task ID   : " + taskId);
        System.out.println("Task Name : " + taskName);
        System.out.println("Status    : " + status);
    }
}

//Node class for Linked List
class Node {

    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {

    Node head = null;

    //Add Task
    public void addTask(Task task) {

        Node newNode = new Node(task);

        if (head == null) {

            head = newNode;
        } else {

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Task Added Successfully.");
    }

    //Search Task
    public Task searchTask(String taskId) {

        Node temp = head;

        while (temp != null) {

            if (temp.task.taskId.equalsIgnoreCase(taskId)) {
                return temp.task;
            }

            temp = temp.next;
        }

        return null;
    }

    //Display Tasks
    public void displayTasks() {

        if (head == null) {

            System.out.println("No Tasks Available.");
            return;
        }

        Node temp = head;

        while (temp != null) {

            temp.task.display();
            temp = temp.next;
        }
    }

    //Delete Task
    public void deleteTask(String taskId) {

        if (head == null) {

            System.out.println("Task List Empty.");
            return;
        }

        // Delete first node
        if (head.task.taskId.equalsIgnoreCase(taskId)) {

            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null &&
                !current.task.taskId.equalsIgnoreCase(taskId)) {

            previous = current;
            current = current.next;
        }

        if (current == null) {

            System.out.println("Task Not Found.");
            return;
        }

        previous.next = current.next;

        System.out.println("Task Deleted Successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskManagementSystem taskList =
                new TaskManagementSystem();

        int choice;

        do {

            System.out.println(
                    "\n===== TASK MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Task ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();

                    Task task =
                            new Task(id, name, status);

                    taskList.addTask(task);

                    break;

                case 2:

                    System.out.print(
                            "Enter Task ID to Search: ");

                    String searchId =
                            sc.nextLine();

                    Task found =
                            taskList.searchTask(searchId);

                    if (found != null) {

                        found.display();
                    } else {

                        System.out.println(
                                "Task Not Found.");
                    }

                    break;

                case 3:

                    taskList.displayTasks();

                    break;

                case 4:

                    System.out.print(
                            "Enter Task ID to Delete: ");

                    String deleteId =
                            sc.nextLine();

                    taskList.deleteTask(deleteId);

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