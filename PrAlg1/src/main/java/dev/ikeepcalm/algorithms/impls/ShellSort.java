package dev.ikeepcalm.algorithms.impls;

import dev.ikeepcalm.algorithms.Algorithm;

public class ShellSort implements Algorithm {

    private double swaps;
    private double comparisons;
    private double time;

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        double amountOfSwaps = 0;
        double amountOfComparisons = 0;
        long startTime = System.currentTimeMillis();

        int gap = 1;
        while (gap < n / 2) {
            gap = 3 * gap + 1;
        }

        while (gap >= 1) {

            for (int i = gap; i < n     ; i++) {

                for (int j = i; j >= gap; j -= gap) {
                    amountOfComparisons++;
                    if (arr[j] < arr[j - gap]){
                        int temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                        amountOfSwaps++;
                    }
                }

            }

            gap /= 3;

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
        return (n * n) / 1_000_000;
    }

    @Override
    public double getMinComplexity(double n) {
        return n * Math.log(n) / 1500;
    }
}
