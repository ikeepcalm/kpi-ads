package dev.ikeepcalm.analysis.graphs;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class BaseGraph {

    private final XYSeriesCollection dataset;
    Color[] myColors = {Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.MAGENTA};


    public BaseGraph() {
        dataset = new XYSeriesCollection();
    }

    public void addData(String algorithmName, XYSeries data) {
        dataset.addSeries(data);
    }

    public void displayChart() {
        JFreeChart chart = createChart(dataset);
        try {
            chart.setBackgroundPaint(Color.WHITE);
            chart.getPlot().setBackgroundPaint(Color.WHITE);
            chart.getPlot().setOutlinePaint(Color.GRAY);
            chart.getXYPlot().getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(2, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(3, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(4, new BasicStroke(2.0f));
            ChartUtils.saveChartAsPNG(new File("src/main/resources/chart.png"), chart, 1000, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        display(chart);
        try {
            ChartUtils.saveChartAsPNG(new File("chart.png"), chart, 1000, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void display(JFreeChart chart) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(chart.getTitle().getText());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(600, 600));
            chart.setBackgroundPaint(Color.WHITE);
            chart.getPlot().setBackgroundPaint(Color.WHITE);
            chart.getPlot().setOutlinePaint(Color.GRAY);
            chart.getXYPlot().getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(2, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(3, new BasicStroke(2.0f));
            chart.getXYPlot().getRenderer().setSeriesStroke(4, new BasicStroke(2.0f));
            frame.add(chartPanel, BorderLayout.CENTER);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    protected abstract JFreeChart createChart(XYSeriesCollection dataset);
}


