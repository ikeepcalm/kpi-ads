package dev.ua.ikeepcalm.solution;

import java.util.Arrays;

public class TaskSolver {

    private final DefaultQuickSort defaultQuickSort;
    private final MedianQuickSort medianQuickSort;

    public TaskSolver() {
        defaultQuickSort = new DefaultQuickSort();
        medianQuickSort = new MedianQuickSort();
    }

    public void solve(int[] array) {
        System.out.println(defaultQuickSort.sort(array.clone()));
        System.out.println(medianQuickSort.sort(array.clone()));
    }

}
