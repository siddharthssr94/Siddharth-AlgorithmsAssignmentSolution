package com.stockers.services;

//Merge Sort Implementation for double
public class MergeSort {

    public void sortArray(double[] inputArray) {
        sortArray(inputArray, 0, inputArray.length - 1);
    }

    private void sortArray(double[] array, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            //sort left part
            sortArray(array, l, m);

            //sort right part
            sortArray(array, m + 1, r);

            //merge both sides
            mergeArray(array, l, m, r);
        }
    }

    private void mergeArray(double[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        double[] Left = new double[n1];
        double[] Right = new double[n2];
        System.arraycopy(array, l, Left, 0, n1);
        for (int j = 0; j < n2; ++j) {
            Right[j] = array[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
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
