package com.stockers.main;

import com.stockers.stocks.StockTracker;

import java.util.Scanner;

public class Driver {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    
        //Take input for no of companies
        System.out.println("Enter the no of companies");
        int numOfCompanies = sc.nextInt();

        double[] stockPrices = new double[numOfCompanies];
        boolean[] stockPriceStatus = new boolean[numOfCompanies];

        for (int i = 0; i < numOfCompanies; i++) {
            //Take input of stock price for each company
            System.out.println("Enter current stock price of the company " + (i + 1));
            stockPrices[i] = sc.nextDouble();

            //Take input of status of stock price compare to yesterday's
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            stockPriceStatus[i] = sc.nextBoolean();
        }

        while (true) {
            //Show Operation list
            System.out.println("-----------------------------------------------");
            System.out.println("Enter the operation that you want to perform");
            System.out.println("1. Display the companies stock prices in ascending order");
            System.out.println("2. Display the companies stock prices in descending order");
            System.out.println("3. Display the total no of companies for which stock prices rose today");
            System.out.println("4. Display the total no of companies for which stock prices declined today");
            System.out.println("5. Search a specific stock price");
            System.out.println("6. press 0 to exit");
            System.out.println("-----------------------------------------------");


            int choice = sc.nextInt();

            if (choice == 0) {
                //exit application
                break;
            }

            //initializing StockTrackHelper
            StockTracker stockTracker = new StockTracker(stockPrices, stockPriceStatus);
            switch (choice) {
                case 1 :
                        //call display stock price asc
                        stockTracker.showStocks(true);
                        break;
                case 2 :
                        //call display stock price desc
                        stockTracker.showStocks(false);
                        break;
                case 3 :
                        //call display count of stock rose today
                        stockTracker.showNoOfCompaniesStockRose();
                        break;
                case 4 :
                        //call display count of stock declined today
                        stockTracker.showNoOfCompaniesStockDeclined();
                        break;
                case 5 :
                        //call Search operation
                        System.out.println("enter the key value");
                        var searchValue = sc.nextDouble();
                        stockTracker.searchStockPrice(searchValue);
                        break;

                default : System.out.println("Invalid operation input");
            }
        }
        System.out.println("Exited successfully");
    }
}
