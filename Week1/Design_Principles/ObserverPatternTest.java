/*
 * Exercise 7 : Observer Pattern
 * Author : Mohana Priya K
 */

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

class MobileApp implements Observer {

    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name +
                " received stock update: ₹" + price);
    }
}

class WebApp implements Observer {

    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name +
                " received stock update: ₹" + price);
    }
}

public class ObserverPatternTest {

    public static void main(String[] args) {

        StockMarket stockMarket =
                new StockMarket();

        Observer mobile =
                new MobileApp("Mobile App");

        Observer web =
                new WebApp("Web App");

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        stockMarket.setStockPrice(1500);

        stockMarket.deregisterObserver(web);

        stockMarket.setStockPrice(1800);
    }
}