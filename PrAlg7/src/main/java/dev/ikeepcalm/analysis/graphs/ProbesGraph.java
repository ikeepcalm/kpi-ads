package dev.ikeepcalm.analysis.graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;

public class ProbesGraph extends BaseGraph {

    @Override
    public JFreeChart createChart(XYSeriesCollection dataset) {
        return ChartFactory.createXYLineChart(
                "Hash Algorithm " + "Collisions",
                "Container Size",
                "Collisions",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

}
