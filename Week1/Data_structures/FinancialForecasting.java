/*
 * Exercise 7 : Financial Forecasting
 * Author : Mohana Priya K
 */

import java.util.Scanner;

public class FinancialForecasting {

    //Recursive method to calculate future value
    public static double calculateFutureValue(
            double currentValue,
            double growthRate,
            int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "===== FINANCIAL FORECASTING SYSTEM =====");

        //Dynamic Input

        System.out.print(
                "Enter Present Value (₹): ");
        double presentValue = sc.nextDouble();

        System.out.print(
                "Enter Annual Growth Rate (%) : ");
        double growthRate = sc.nextDouble();

        System.out.print(
                "Enter Number of Years : ");
        int years = sc.nextInt();
        growthRate = growthRate / 100;

        //Calculate Future Value
        double futureValue =
                calculateFutureValue(
                        presentValue,
                        growthRate,
                        years);
        System.out.println("\n===== FORECAST RESULT =====");

        System.out.printf(
                "Future Value after %d years = ₹%.2f",
                years,
                futureValue);

        sc.close();
    }
}