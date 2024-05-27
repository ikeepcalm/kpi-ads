package dev.ikeepcalm.analysis;

import dev.ikeepcalm.analysis.graphs.BaseGraph;
import dev.ikeepcalm.solution.impls.HashAlgorithm;
import org.jfree.data.xy.XYSeries;

public class AlgorithmAnalyzer {

    public <T extends BaseGraph> void analyze(int maxSize, int stepSize, T graph) {
        XYSeries series = new XYSeries("HashTable " + graph.getClass().getSimpleName());
        for (int inputSize = 1; inputSize <= maxSize; inputSize += stepSize) {
            String[][] values = generateRandomStrings(inputSize);
            HashAlgorithm hashAlgorithm = new HashAlgorithm();
            hashAlgorithm.overHash(values);
            double iterationsData = switch (graph.getClass().getSimpleName()) {
                case "ProbesGraph" -> hashAlgorithm.getProbes();
                case "CompsGraph" -> hashAlgorithm.getComparisons();
                case "TimeGraph" -> hashAlgorithm.getSearchTime();
                default -> throw new IllegalStateException("Unexpected value: " + graph.getClass().getSimpleName());
            };
            System.out.println("Input size: " + inputSize + " Value: " + iterationsData);
            series.add(inputSize, iterationsData);
        }

        graph.addData("PJW HashTable", series);
        graph.displayChart();
    }

    private String[][] generateRandomStrings(int size) {
        String[][] strings = new String[size][2];
        for (int i = 0; i < size; i++) {
            strings[i][0] = generateRandomString(20);
            strings[i][1] = generateRandomString(200);
        }
        return strings;
    }

    private String generateRandomString(int length) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

}
