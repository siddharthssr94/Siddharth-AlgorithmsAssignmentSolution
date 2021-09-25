package com.stockers.main;

import com.stockers.services.SearchStock;
import com.stockers.services.SortStocks;

//Helper class to keep track of the company’s share price w.r.t yesterday
public class StocksImplementation {

    //private variable declaration
    private final double[] sortedStockPrices;
    private int numCompanyStockRose = 0;
    private int numCompanyStockDeclined = 0;

    //Constructor to initialize private variable of the class
    public StocksImplementation(double[] stockPrices, boolean[] stockStatus) {
        SortStocks sort = new SortStocks();
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
        SearchStock bs = new SearchStock();
        var valueIndex = bs.search(sortedStockPrices, searchValue);

        if (valueIndex == -1) {
            System.out.println("Value not found");
        } else {
            System.out.println("Stock of value " + searchValue + " is present");
        }
    }
}
