package dev.ikeepcalm;

import dev.ikeepcalm.analysis.AlgorithmAnalyzer;
import dev.ikeepcalm.analysis.graphs.CompsGraph;
import dev.ikeepcalm.analysis.graphs.ProbesGraph;
import dev.ikeepcalm.analysis.graphs.TimeGraph;

public class AnalyzerStarter {

    public static void main(String[] args) {
        AlgorithmAnalyzer analyzer = new AlgorithmAnalyzer();
        analyzer.analyze(20000, 100, new TimeGraph());
    }

}