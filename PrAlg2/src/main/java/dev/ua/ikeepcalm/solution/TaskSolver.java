package dev.ua.ikeepcalm.solution;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class TaskSolver {

    private int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        int left = low;
        int right = mid + 1;
        int count = 0;
        int k = low;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= high) {
            temp[k++] = arr[right++];
        }

        System.arraycopy(temp, low, arr, low, high - low + 1);

        return count;
    }

    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    public void solve(int[][] userDatabase, int criteria) {
        InversionResult[] results = new InversionResult[userDatabase.length - 1];
        int count = 0;
        for (int i = 0; i < userDatabase.length; i++) {
            if (i == criteria - 1) {
                continue;
            }
            int[] arrangedArr = new int[userDatabase[criteria - 1].length];
            for (int j = 0; j < userDatabase[criteria - 1].length; j++) {
                arrangedArr[userDatabase[criteria - 1][j] - 1] = userDatabase[i][j];
            }
            System.out.println(i + 1 + " arrangedArr = " + Arrays.toString(arrangedArr));
            int inversions = mergeSort(arrangedArr, 0, arrangedArr.length - 1);
            results[count++] = new InversionResult(inversions, i + 1);
        }

        InversionResult.mergeSortResults(results, 0, count - 1);

        try (FileWriter fileWriter = new FileWriter("output.txt");) {
            fileWriter.write(criteria + "\n");
            for (InversionResult result : results) {
                fileWriter.write(result.index() + " " + result.inversions() + "\n");
            }
            Desktop.getDesktop().open(new File("output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
