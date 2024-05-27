package dev.ua.ikeepcalm.solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solver {

    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public void applyKruskal(Graph graph) {
        int Node = graph.Node;
        Edge[] result = new Edge[Node];
        int e = 0;
        int i = 0;

        Arrays.sort(graph.edge, Comparator.comparingInt(o -> o.weight));

        Subset[] subsets = new Subset[Node];
        for (int v = 0; v < Node; ++v)
            subsets[v] = new Subset(v, 0);

        while (e < Node - 1 && i < graph.E) {
            Edge nextEdge = graph.edge[i++];
            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges of the Minimum Spanning Tree: ");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].source + " -- " + result[i].destination + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Spanning weight: " + minimumCost);
    }

}
