package dev.ikeepcalm.analysis;

import dev.ikeepcalm.algorithms.Algorithm;
import dev.ikeepcalm.analysis.graphs.BaseGraph;
import dev.ikeepcalm.analysis.graphs.SwapsGraph;
import dev.ikeepcalm.analysis.graphs.TimeGraph;
import org.jfree.data.xy.XYSeries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AlgorithmComparator {

    private final List<Algorithm> algorithms;

    public AlgorithmComparator(List<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public <T extends BaseGraph> void compare(int minInputSize, int maxInputSize, int stepSize, T graph) {
        for (Algorithm algorithm : algorithms) {
            HashMap<String, XYSeries> seriesMap = new HashMap<>();
            for (int inputSize = minInputSize; inputSize <= maxInputSize; inputSize += stepSize) {
                int[] arrayToSort = ArrayGenerator.generateRandomScenario(inputSize);
//                printArray("Array to sort with " + algorithm.getClass().getSimpleName() + " algorithm: ", arrayToSort);
                int[] sortedArray = algorithm.sort(arrayToSort.clone());

                double iterationsData = switch (graph.getClass().getSimpleName()) {
                    case "TimeGraph" -> algorithm.getTime();
                    case "CompsGraph" -> algorithm.getComparisons();
                    case "SwapsGraph" -> algorithm.getSwaps();
                    default -> throw new IllegalStateException("Unexpected value: " + graph.getClass().getSimpleName());
                };

                XYSeries series = seriesMap.computeIfAbsent(algorithm.getClass().getSimpleName(), k -> {
                    String suffix = "";
                    if (graph instanceof SwapsGraph) {
                        suffix = " Swaps";
                    } else if (graph instanceof TimeGraph) {
                        suffix = " Time";
                    } else {
                        suffix = " Comparisons";
                    }
                    return new XYSeries(k + suffix);
                });
                series.add(inputSize, iterationsData);
//                printArray("Array sorted with " + algorithm.getClass().getSimpleName() + " algorithm: ", sortedArray);
            }

            for (XYSeries series : seriesMap.values()) {
                graph.addData(series.getKey().toString(), series);
            }
        }
        graph.displayChart();
    }

    private void printArray(String label, int[] array) {
        System.out.println(label + Arrays.toString(array));
    }
}
