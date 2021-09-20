package com.stockers.stocks;

import com.stockers.services.BinarySearch;
import com.stockers.services.MergeSort;

//Helper class to keep track of the company’s share price compared to yesterday
public class StockTracker {
    //private variable declaration
    private final double[] sortedStockPrices;
    private int numCompanyStockRose = 0;
    private int numCompanyStockDeclined = 0;

    //Constructor to initialize private variable of the class
    public StockTracker(double[] stockPrices, boolean[] stockStatus) {
        MergeSort sort = new MergeSort();
        sort.sortArray(stockPrices);

        sortedStockPrices = stockPrices;

        for (boolean status : stockStatus) {
            if (status) {
                numCompanyStockRose++;
            } else {
                numCompanyStockDeclined++;
            }
        }
    }

    //display stocks
    public void showStocks(boolean isAscOrder) {
        if (isAscOrder) {
            System.out.println("Stock prices in ascending order are :");
            for (double sortedStockPrice : sortedStockPrices) {
                System.out.print(sortedStockPrice + " ");
            }
        } else {
            System.out.println("Stock prices in descending order are :");
            for (int i = (sortedStockPrices.length - 1); i >= 0; i--) {
                System.out.print(sortedStockPrices[i] + " ");
            }
        }
        System.out.println("");
    }

    //display count of companies for which stock rose
    public void showNoOfCompaniesStockRose() {
        System.out.println("Total no of companies whose stock price rose today : " + numCompanyStockRose);
    }

    //display count of companies for which stock rose
    public void showNoOfCompaniesStockDeclined() {
        System.out.println("Total no of companies whose stock price declined today : " + numCompanyStockDeclined);
    }

    //display whether the stock price is present or not.
    public void searchStockPrice(double searchValue) {
        BinarySearch bs = new BinarySearch();
        var valueIndex = bs.searchValue(sortedStockPrices, searchValue);

        if (valueIndex == -1) {
            System.out.println("Value not found");
        } else {
            System.out.println("Stock of value " + searchValue + " is present");
        }
    }
}
