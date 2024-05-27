package dev.ikeepcalm;

import dev.ikeepcalm.solution.Backpack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));

        int w = scanner.nextInt();
        int n = scanner.nextInt();

        Backpack backpack = new Backpack(n, w);

        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            int weight = scanner.nextInt();
            backpack.addItem(i, weight, price);
        }

        long start = System.currentTimeMillis();
        int result = backpack.calculateDynamically();
        long end = System.currentTimeMillis();
        System.out.println("\nTime: " + (end - start) + "ms");
        System.out.println("Result price: " + result);

        File file = new File(args[0].replace("input", "output"));
        if (!file.exists()) {
            boolean wasCreated = file.createNewFile();
            if (!wasCreated) {
                throw new IOException("Failed to create file");
            }
        }

        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file));
        try {
            writer.write(String.valueOf(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.close();
    }
}
