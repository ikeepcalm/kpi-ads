package dev.ikeepcalm.algorithms.impls;

import dev.ikeepcalm.algorithms.Algorithm;

public class BubbleSort implements Algorithm {

    private double swaps;
    private double comparisons;
    private double time;

    public int[] sort(int[] arr) {
        double amountOfComparisons = 0;
        double amountOfSwaps = 0;
        int n = arr.length;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    amountOfSwaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } amountOfComparisons++;
            }
        }
        long endTime = System.currentTimeMillis();
        time = (endTime - startTime);
        comparisons = amountOfComparisons;
        swaps = amountOfSwaps;
        return arr;
    }

    @Override
    public double getSwaps() {
        return swaps;
    }

    @Override
    public double getComparisons() {
        return comparisons;
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public double getMaxComplexity(double n) {
        return (n * n) / 600_000;
    }

    @Override
    public double getMinComplexity(double n) {
        return n / 500;
    }

}
