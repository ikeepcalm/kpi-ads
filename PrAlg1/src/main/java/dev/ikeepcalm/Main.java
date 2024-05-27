package dev.ikeepcalm;

import dev.ikeepcalm.algorithms.Algorithm;
import dev.ikeepcalm.algorithms.impls.BubbleSort;
import dev.ikeepcalm.algorithms.impls.ModBubbleSort;
import dev.ikeepcalm.algorithms.impls.ShellSort;
import dev.ikeepcalm.algorithms.impls.quicksorts.DefaultQuickSort;
import dev.ikeepcalm.algorithms.impls.quicksorts.MedianQuickSort;
import dev.ikeepcalm.analysis.AlgorithmAnalyzer;
import dev.ikeepcalm.analysis.AlgorithmComparator;
import dev.ikeepcalm.analysis.ArrayGenerator;
import dev.ikeepcalm.analysis.graphs.CompsGraph;
import dev.ikeepcalm.analysis.graphs.SwapsGraph;
import dev.ikeepcalm.analysis.graphs.TimeGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        AlgorithmAnalyzer analyzer = new AlgorithmAnalyzer(new DefaultQuickSort());
//        analyzer.analyze(0, 10000, 100, new CompsGraph());
//    }

//    public static void main(String[] args) {
//        List<Algorithm> algorithms = List.of(new DefaultQuickSort(), new MedianQuickSort());
//        AlgorithmComparator analyzer = new AlgorithmComparator(algorithms);
//        analyzer.compare(10, 50000, 1000, new CompsGraph());
//    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Algorithm> algorithms = List.of(new DefaultQuickSort(), new MedianQuickSort());

        Scanner scanner = new Scanner(new File("input_01_10.txt"));
        int rows = scanner.nextInt();
        int[] array = new int[rows];
        for (int i = 0; i < rows; i++) {
            array[i] = scanner.nextInt();
        }

        int[][] scenarios = {array};

        for (Algorithm algorithm : algorithms) {
            System.out.println("\n\n" + algorithm.getClass().getSimpleName());
            for (int[] scenario : scenarios) {
                System.out.println("____________________");
                System.out.println(Arrays.toString(scenario));
                int[] sorted = algorithm.sort(scenario.clone());
                System.out.println("Comparisons: " + algorithm.getComparisons());
                System.out.println(Arrays.toString(sorted));
                File file = new File("output.txt");
                System.out.println(file.getAbsolutePath());
            }
        }


    }

}