package dev.ikeepcalm.visualizer;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import dev.ikeepcalm.Graph;
import dev.ikeepcalm.visualizer.source.City;
import dev.ikeepcalm.visualizer.source.Edge;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.SimpleGraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Converter {

    private static SimpleGraph<String, Edge> convert(Graph graph, int[] vertexCover) {
        SimpleGraph<String, Edge> jgraph = new SimpleGraph<>(Edge.class);
        for (int i = 0; i < graph.verticesAmount; i++) {
            int finalI = i;
            if (Arrays.stream(vertexCover).anyMatch(x -> x == finalI)) {
                jgraph.addVertex("  | REQ |  \n" + City.decode(i).toString());
            } else {
                jgraph.addVertex(City.decode(i).toString());
            }
        }

        for (int source = 0; source < graph.verticesAmount; source++) {
            for (int neighbor : graph.adjacencyList[source]) {
                if (source == neighbor) {
                    continue;
                }
                String sourceVertex;
                String neighborVertex;
                int finalSource = source;
                if (Arrays.stream(vertexCover).anyMatch(x -> x == finalSource)) {
                    sourceVertex = "  | REQ |  \n" + City.decode(source).toString();
                } else {
                    sourceVertex = City.decode(source).toString();
                }
                if (Arrays.stream(vertexCover).anyMatch(x -> x == neighbor)) {
                    neighborVertex = "  | REQ |  \n" + City.decode(neighbor).toString();
                } else {
                    neighborVertex = City.decode(neighbor).toString();
                }
                jgraph.addEdge(sourceVertex, neighborVertex, new Edge());
            }
        }

        return jgraph;
    }

    public static void visualizeGraph(Graph gr, int[] vertexCover, String filename) {
        JGraphXAdapter<String, Edge> adapter = new JGraphXAdapter<>(convert(gr, vertexCover));
        mxIGraphLayout layout = new mxCircleLayout(adapter);
        layout.execute(adapter.getDefaultParent());

        BufferedImage image = mxCellRenderer.createBufferedImage(adapter, null, 4, Color.WHITE, true, null);
        File imgFile = new File(filename);
        try {
            ImageIO.write(image, "PNG", imgFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
