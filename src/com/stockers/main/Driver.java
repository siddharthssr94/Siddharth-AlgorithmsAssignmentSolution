package com.stockers.main;

import java.util.Scanner;

public class Driver {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    
        //User input for no of companies
        System.out.println("Enter the no of companies");
        int numOfCompanies = sc.nextInt();

        double[] stockPrices = new double[numOfCompanies];
        boolean[] stockStatus = new boolean[numOfCompanies];

        for (int i = 0; i < numOfCompanies; i++) {
            //User input for stock price for each company
            System.out.println("Enter current stock price of the company " + (i + 1));
            stockPrices[i] = sc.nextDouble();

            //User input for status of stock price compared to yesterday's
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            stockStatus[i] = sc.nextBoolean();
        }

        int choice ;
        System.out.println();
        do{
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

            //Get user's Choice
            choice = sc.nextInt();

            //initializing StockTrackHelper
            StocksImplementation stockTracker = new StocksImplementation(stockPrices, stockStatus);
            switch (choice) {
                case 0 :
                        //Case to exit
                        break;
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
        }while(choice != 0);
        System.out.println("Exited successfully");
    }
}
