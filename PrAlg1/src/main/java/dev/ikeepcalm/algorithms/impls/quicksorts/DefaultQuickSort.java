package dev.ikeepcalm.algorithms.impls.quicksorts;

import dev.ikeepcalm.algorithms.Algorithm;

public class DefaultQuickSort implements Algorithm {

    private int[] data;
    private double comparisons;

    @Override
    public int[] sort(int[] array) {
        comparisons = 0;
        data = array;
        quickSort(0, array.length - 1);
        return data;
    }

    private void quickSort(int first, int last) {
        if (first < last) {
            int pivotIndex = partition(first, last);
            quickSort(first, pivotIndex - 1);
            quickSort(pivotIndex + 1, last);
        }
    }


    private int partition(int first, int last) {
        int pivot = data[last];
        int i = (first - 1);

        for (int j = first; j <= last - 1; j++) {
            comparisons++;
            if (data[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, last);
        return (i + 1);
    }

    public void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public double getSwaps() {
        return 0;
    }

    @Override
    public double getComparisons() {
        return comparisons;
    }

    @Override
    public double getTime() {
        return 0;
    }

    @Override
    public double getMaxComplexity(double n) {
        return (n * n) / 1_500_000;
    }

    @Override
    public double getMinComplexity(double n) {
        return n * Math.log(n) / 4500;
    }

}
