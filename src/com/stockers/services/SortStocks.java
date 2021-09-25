package com.stockers.services;

//Merge Sort Implementation to sort the stocks
public class SortStocks {

    public void sortArray(double[] inputArray) {
        sortArray(inputArray, 0, inputArray.length - 1);
    }

    private void sortArray(double[] array, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;

            //sort left part
            sortArray(array, left, m);

            //sort right part
            sortArray(array, m + 1, right);

            //merge both sides
            mergeArray(array, left, m, right);
        }
    }

    private void mergeArray(double[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        double[] Left = new double[n1];
        double[] Right = new double[n2];
        System.arraycopy(array, low, Left, 0, n1);
        for (int j = 0; j < n2; ++j) {
            Right[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                array[k] = Left[i];
                i++;
            } else {
                array[k] = Right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = Left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = Right[j];
            j++;
            k++;
        }
    }
}
