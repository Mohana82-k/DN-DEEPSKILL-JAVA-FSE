/*
 * Testing Singleton Pattern
 * Author : Mohana Priya K
 */

public class SingletonTest {

    public static void main(String[] args) {

        //Get Logger instance
        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");
        Logger logger2 = Logger.getInstance();
        logger2.log("User Logged In");
        System.out.println("\nChecking Objects:");
        if (logger1 == logger2) {

            System.out.println(
                "Only One Logger Instance Exists");
        }
        else {

            System.out.println(
                "Multiple Instances Created");
        }
        System.out.println(
                "\nLogger1 HashCode : "
                + logger1.hashCode());

        System.out.println(
                "Logger2 HashCode : "
                + logger2.hashCode());
    }
}