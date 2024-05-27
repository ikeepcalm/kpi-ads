package dev.ikeepcalm.algorithms;

public interface Algorithm {
    int[] sort(int[] arr);
    double getSwaps();
    double getComparisons();
    double getTime();
    double getMaxComplexity(double n);
    double getMinComplexity(double n);
}
