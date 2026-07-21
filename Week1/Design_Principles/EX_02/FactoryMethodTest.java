
import java.util.Scanner;

public class FactoryMethodTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DocumentFactory factory;

        System.out.println(
                "===== DOCUMENT MANAGEMENT SYSTEM =====");

        System.out.println("1. Word Document");
        System.out.println("2. PDF Document");
        System.out.println("3. Excel Document");

        System.out.print(
                "Choose Document Type: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                factory =
                        new WordDocumentFactory();

                break;

            case 2:

                factory =
                        new PdfDocumentFactory();

                break;

            case 3:

                factory =
                        new ExcelDocumentFactory();

                break;

            default:

                System.out.println(
                        "Invalid Choice");

                sc.close();
                return;
        }

        factory.openDocument();

        sc.close();
    }
}