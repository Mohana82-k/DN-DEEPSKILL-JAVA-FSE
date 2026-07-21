/*
 * Exercise 1 : Singleton Pattern Example
 * Author : Mohana Priya K
 */

class Logger {

    //Create a private static instance
    private static Logger instance;

    //Private constructor
    private Logger() {
        System.out.println("Logger Instance Created");
    }

    //Public method to get single instance
    public static Logger getInstance() {

        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}