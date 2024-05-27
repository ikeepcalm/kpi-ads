package dev.ikeepcalm.algorithms.impls;

import dev.ikeepcalm.algorithms.Algorithm;

public class HashTable implements Algorithm {

    private double calls;
    private double comparisons;
    private double time;

    public int[] sort(int[] arr) {

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
