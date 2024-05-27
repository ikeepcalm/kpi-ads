package dev.ua.ikeepcalm.solution;

public class DefaultQuickSort {
    private int[] data;
    private int comparisons;

    public int sort(int[] array) {
        comparisons = 0;
        data = array;
        quickSort(0, array.length - 1);
        return comparisons;
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

}