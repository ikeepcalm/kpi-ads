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
        int columns = scanner.nextInt();
        int[][] userDataBase = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            scanner.nextInt();
            for (int j = 0; j < columns; j++) {
                userDataBase[i][j] = scanner.nextInt();
            }
        }
        taskSolver.solve(userDataBase, Integer.parseInt(args[1]));
    }
}
