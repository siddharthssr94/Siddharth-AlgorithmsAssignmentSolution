package com.stockers.services;

public class SearchStock {

    //binary search Implementation to search a stock
    public int search(double[] array, double value) {
        //variable initialization
        int left, right, mid;
        left = 0;
        right = array.length - 1;
        mid = left + (right - left) / 2;

        while (left <= right) {
            if (value < array[mid]) {
                right = mid - 1;
            } else if (value > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
