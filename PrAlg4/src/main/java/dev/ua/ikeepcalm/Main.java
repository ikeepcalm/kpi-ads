package dev.ua.ikeepcalm;

import dev.ua.ikeepcalm.solution.Edge;
import dev.ua.ikeepcalm.solution.Graph;
import dev.ua.ikeepcalm.solution.Solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

//    public static void main(String[] args) {
//        int Node = 4;
//        int E = 4;
//        Graph graph = new Graph(Node, E);
//
//        graph.edge[0] = new Edge(0, 1, 2);
//        graph.edge[1] = new Edge(1, 2, 6);
//        graph.edge[2] = new Edge(2, 3, 4);
//        graph.edge[3] = new Edge(3, 1, 8);
//
//        Solver solver = new Solver();
//        solver.kruskalMST(graph);
//    }

    public static void main(String[] args) {
        int nodeAmount = 9;
        int edgeAmount = 11;

//        int[][] weightMatrix = {
//                {0, 2, 0, 0},
//                {2, 0, 6, 8},
//                {0, 6, 0, 4},
//                {0, 8, 4, 0}
//        };

//        int[][] weightMatrix = {
//           {0, 7, 8, 0, 0, 0},
//           {7, 0, 3, 6, 5, 0},
//           {8, 3, 0, 4, 3, 0},
//           {0, 6, 4, 0, 2, 5},
//           {0, 5, 3, 2, 0, 2},
//           {0, 0, 0, 5, 2, 0}
//        };

        int[][] weightMatrix = {

            {0, 2, 3, 0, 2, 0, 0, 0, 0},
            {2, 0, 0, 4, 0, 0, 0, 0, 0},
            {3, 0, 0, 0, 5, 0, 0, 1, 0},
            {0, 4, 0, 0, 0, 6, 0, 0, 0},
            {2, 0, 5, 0, 0, 0, 7, 0, 0},
            {0, 0, 0, 6, 0, 0, 0, 8, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 9},
            {0, 0, 1, 0, 0, 8, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 9, 2, 0}


        };

        List<Edge> edges = new ArrayList<>();
        int V = weightMatrix.length;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (weightMatrix[i][j] != 0) {
                    edges.add(new Edge(i, j, weightMatrix[i][j]));
                }
            }
        }



        Graph graph = new Graph(nodeAmount, edgeAmount);
        for (int i = 0; i < edges.size(); i++) {
            graph.edge[i] = edges.get(i);
        }

        System.out.println(Arrays.toString(graph.edge));

        System.out.println("Calculating using Kruskal's Algorithm");
        System.out.println("Kirchhoff's Matrix looks like this:");
        for (int[] matrix : weightMatrix) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[j] + " ");
            }
            System.out.println();
        }

        Solver solver = new Solver();
        solver.applyKruskal(graph);
    }

}
