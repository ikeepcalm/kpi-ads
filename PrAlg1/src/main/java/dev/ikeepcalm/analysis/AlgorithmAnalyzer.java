package dev.ikeepcalm.analysis;

import dev.ikeepcalm.algorithms.Algorithm;
import dev.ikeepcalm.analysis.graphs.BaseGraph;
import dev.ikeepcalm.analysis.graphs.SwapsGraph;
import dev.ikeepcalm.analysis.graphs.TimeGraph;
import org.jfree.data.xy.XYSeries;

import java.util.HashMap;

public class AlgorithmAnalyzer {

    private final Algorithm algorithm;

    public AlgorithmAnalyzer(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public <T extends BaseGraph> void analyze(int minInputSize, int maxInputSize, int stepSize, T graph) {
        HashMap<String, XYSeries> seriesMap = new HashMap<>();
        XYSeries maxComplexity = new XYSeries("Max Complexity");
        XYSeries minComplexity = new XYSeries("Min Complexity");
        for (int inputSize = minInputSize; inputSize <= maxInputSize; inputSize += stepSize) {
            int[] randomArray = ArrayGenerator.generateRandomScenario(inputSize);
            int[] sortedArray = ArrayGenerator.generateBestScenario(inputSize);
            int[] reversedArray = ArrayGenerator.generateWorstScenario(inputSize);
            double maxComplexityValue = algorithm.getMaxComplexity(inputSize);
            double minComplexityValue = algorithm.getMinComplexity(inputSize);
            maxComplexity.add(inputSize, maxComplexityValue);
            minComplexity.add(inputSize, minComplexityValue);
            for (int[] arrayToSort : new int[][]{randomArray, sortedArray, reversedArray}) {

                int[] sorted = algorithm.sort(arrayToSort.clone());

                double iterationsData = switch (graph.getClass().getSimpleName()) {
                    case "TimeGraph" -> algorithm.getTime();
                    case "CompsGraph" -> algorithm.getComparisons();
                    case "SwapsGraph" -> algorithm.getSwaps();
                    default -> throw new IllegalStateException("Unexpected value: " + graph.getClass().getSimpleName());
                };

                String scenarioName = getScenarioName(arrayToSort);
                XYSeries series = seriesMap.computeIfAbsent(scenarioName, k -> {
                    String suffix;
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
            }
        }

        for (XYSeries series : seriesMap.values()) {
            graph.addData(series.getKey().toString(), series);
        }

        if (graph instanceof TimeGraph) {
            graph.addData("Max Complexity", maxComplexity);
            graph.addData("Min Complexity", minComplexity);
        }

        graph.displayChart();
    }

    private String getScenarioName(int[] array) {
        if (isSorted(array)) {
            return "Sorted Array";
        } else if (isReverseSorted(array)) {
            return "Reversed Array";
        } else {
            return "Random Array";
        }
    }

    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isReverseSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
