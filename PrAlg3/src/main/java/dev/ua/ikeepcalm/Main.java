package dev.ua.ikeepcalm;

import dev.ua.ikeepcalm.solution.TaskSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        TaskSolver taskSolver = new TaskSolver();
        int rows = scanner.nextInt();
        int[] array = new int[rows];
        for (int i = 0; i < rows; i++) {
            array[i] = scanner.nextInt();
        }
        taskSolver.solve(array);
    }

}