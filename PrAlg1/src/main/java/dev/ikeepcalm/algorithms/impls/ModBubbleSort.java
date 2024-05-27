package dev.ikeepcalm.algorithms.impls;

import dev.ikeepcalm.algorithms.Algorithm;

public class ModBubbleSort implements Algorithm {
    private double swaps;
    private double comparisons;
    private double time;

    public int[] sort(int[] arr) {
        long startTime = System.currentTimeMillis();
        double amountOfComparisons = 0;
        double amountOfSwaps = 0;
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    amountOfSwaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                } amountOfComparisons++;
            } if (!swapped) {
                break;
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
        return 0;
    }

}
