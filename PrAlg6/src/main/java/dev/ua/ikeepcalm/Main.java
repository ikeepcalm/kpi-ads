package dev.ua.ikeepcalm;

import dev.ua.ikeepcalm.solution.Solver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        Solver solver = new Solver();
        int rows = scanner.nextInt();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            solver.addNum(scanner.nextInt());
            result.add(solver.findMedian());
        }

        File file = new File(args[0].replace("input", "output"));
        if (!file.exists()) {
            boolean wasCreated = file.createNewFile();
            if (!wasCreated) {
                throw new IOException("Failed to create file");
            }
        }

        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
        result.forEach(arr -> {
            try {
                for (int medians : arr) {
                    writer.write(String.valueOf(medians));
                    writer.write(" ");
                }
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.close();
    }
}