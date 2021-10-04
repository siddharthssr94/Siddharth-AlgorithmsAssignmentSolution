package com.greatlearning.dsa.assignment.main;

import java.util.Scanner;

import com.greatlearning.dsa.assignment.service.AdditionalServices;
import com.greatlearning.dsa.assignment.service.BinarySearchImplementation;
import com.greatlearning.dsa.assignment.service.LinearSearch;
import com.greatlearning.dsa.assignment.service.MergeSortImplementation;

public class Main {

	public static void main(String[] args) {

		int noOfCompanies;
		int option;
		System.out.println("enter the no of companies");
		Scanner sc = new Scanner(System.in);
		noOfCompanies = sc.nextInt();
		double priceArray[] = new double[noOfCompanies];
		boolean profitArray[] = new boolean[noOfCompanies];

		for (int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter current stock price of the company " + (i + 1));
			priceArray[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			profitArray[i] = sc.nextBoolean();
		}

		MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();
		mergeSortImplementation.sort(priceArray, 0, priceArray.length - 1);

		AdditionalServices additionalServices = new AdditionalServices();
		LinearSearch linearSearch = new LinearSearch();

		BinarySearchImplementation binearySearchImplementation = new BinarySearchImplementation();

		do {

			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total  no of companies  for which stock prices rose today");
			System.out.println("4. Display the total  no of companies  for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			option = sc.nextInt();
			switch (option) {

			case 0:
				option = 0;
				break;
			case 1: {
				additionalServices.displayPricesAscendingOrder(priceArray);

			}
				break;
			case 2: {
				additionalServices.displayPricesDescendingOrder(priceArray);

			}
				break;
			case 3: {
				System.out.println("Total no of companies whose stock price rose today : "
						+ linearSearch.countCompaniesInProfit(profitArray));

			}
				break;
			case 4: {
				System.out.println("Total no of companies whose stock price declined today : "
						+ (noOfCompanies - linearSearch.countCompaniesInProfit(profitArray)));

			}
				break;
			case 5: {
				double key;
				System.out.println("enter the key value");
				key = sc.nextDouble();
				binearySearchImplementation.searchValue(priceArray, key);

			}

				break;
			default:
				System.out.println("enter valid option");
			}

		} while (option != 0);
		System.out.println("Exited successfully");
		sc.close();
	}

}
