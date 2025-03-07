package dev.ikeepcalm.algorithms.impls.quicksorts;

import dev.ikeepcalm.algorithms.Algorithm;

public class MedianQuickSort implements Algorithm {

    private int[] data;
    private double comparisons;
    private double time;


    public int[] sort(int[] array) {
        data = array;
        comparisons = 0;
        long startTime = System.currentTimeMillis();
        quickSort(0, array.length - 1);
        long endTime = System.currentTimeMillis();
        time = (endTime - startTime);
        return data;
    }

    public void quickSort(int first, int last) {
        int size = last - first + 1;
        if (size >= 3) {
            long median = getMedianOfThree(first, last);
            int partition = partition(first, last, median);
            quickSort(first, partition - 1);
            quickSort(partition + 1, last);
        }
        else {
            simpleSort(first, last);
        }
    }

    public long getMedianOfThree(int left, int right) {
        int center = (left + right) / 2;
        if (data[left] > data[center])
            swap(left, center);
        if (data[left] > data[right])
            swap(left, right);
        if (data[center] > data[right])
            swap(center, right);
        swap(center, right - 1);
        return data[right - 1];
    }

    public int partition(int left, int right, long pivot) {
        int leftIndex = left;
        int rightIndex = right - 1;

        while (true) {
            comparisons++;
            while (data[++leftIndex] < pivot) {
                comparisons++;
            }
            comparisons++;
            while (data[--rightIndex] > pivot) {
                comparisons++;
            }

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }

        swap(leftIndex, right - 1);
        return leftIndex;
    }

    public void simpleSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            comparisons++;
            if (data[left] > data[right])
                swap(left, right);
        } else {
            comparisons+=3;
            if (data[left] > data[right - 1])
                swap(left, right - 1);
            if (data[left] > data[right])
                swap(left, right);
            if (data[right - 1] > data[right])
                swap(right - 1, right);
        }
    }

    public void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
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
        return time;
    }

    @Override
    public double getMaxComplexity(double n) {
        return (n * Math.log(n)) / 600_000;
    }

    @Override
    public double getMinComplexity(double n) {
        return n * Math.log(n) / 1500;
    }

}