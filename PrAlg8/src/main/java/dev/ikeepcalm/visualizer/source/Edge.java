package dev.ikeepcalm.visualizer.source;

import org.jgrapht.graph.DefaultEdge;

public class Edge extends DefaultEdge {

    private final String label;

    public Edge() {
        this.label = "";
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "";
    }
}