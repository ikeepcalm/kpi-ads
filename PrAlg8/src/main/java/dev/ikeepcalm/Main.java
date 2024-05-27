package dev.ikeepcalm;

import dev.ikeepcalm.visualizer.Converter;
import dev.ikeepcalm.visualizer.source.City;

public class Main {

    public static void main(String[] args) {
        int[][] graphInput = {
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        printMatrix(graphInput);
        checkSymmetry(graphInput);

        Graph graph = new Graph(graphInput.length);
        for (int i = 0; i < graphInput.length; i++) {
            for (int j = 0; j < graphInput[i].length; j++) {
                if (graphInput[i][j] == 1 && i != j) {
                    graph.addEdge(i, j);
                    System.out.println("Adding edge between " + City.decode(i) + " and " + City.decode(j));
                }
            }
        }
        System.out.println("Approximate vertex cover:");
        Converter.visualizeGraph(graph, graph.getApproxVertexCover(), "approx.png");
        System.out.println("\nGreedy vertex cover:");
        Converter.visualizeGraph(graph, graph.getGreedyVertexCover(), "greedy.png");
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void checkSymmetry(int[][] matrix) {
        boolean isSymmetric = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    int column = i + 1;
                    int row = j + 1;
                    System.out.println("Column " + column + " and row " + row + " are not equal!");
                    isSymmetric = false;
                    break;
                }
            }
            if (!isSymmetric) {
                break;
            }
        }

        if (!isSymmetric) {
            System.out.println("The graph is not symmetric!");
            return;
        }
    }


}
