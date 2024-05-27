package dev.ikeepcalm;

import dev.ikeepcalm.visualizer.source.City;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    public int verticesAmount;
    public LinkedList<Integer>[] adjacencyList;

    public Graph(int verticesAmount) {
        this.verticesAmount = verticesAmount;
        adjacencyList = new LinkedList[verticesAmount];
        for (int i = 0; i < verticesAmount; ++i)
            adjacencyList[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    int[] getApproxVertexCover() {
        boolean[] visited = new boolean[verticesAmount];
        for (int i = 0; i < verticesAmount; i++)
            visited[i] = false;

        Iterator<Integer> i;

        for (int u = 0; u < verticesAmount; u++) {
            if (!visited[u]) {
                i = adjacencyList[u].iterator();
                while (i.hasNext()) {
                    int v = i.next();
                    if (!visited[v]) {
                        visited[v] = true;
                        visited[u] = true;
                        break;
                    }
                }
            }
        }
        int[] vertexCover = new int[verticesAmount];
        int counter = 0;
        for (int j = 0; j < verticesAmount; j++)
            if (visited[j]) {
                System.out.print(City.decode(j) + " -> ");
                vertexCover[counter++] = j;
            }
        return vertexCover;
    }

    public int[] getGreedyVertexCover() {
        boolean[] visited = new boolean[verticesAmount];
        LinkedList<Integer> vertexCoverList = new LinkedList<>();

        while (true) {
            int maxDegree = 0;
            int vertex = -1;

            for (int i = 0; i < verticesAmount; i++) {
                if (!visited[i]) {
                    int degree = adjacencyList[i].size();
                    if (degree > maxDegree) {
                        maxDegree = degree;
                        vertex = i;
                    }
                }
            }

            if (vertex == -1)
                break;

            visited[vertex] = true;
            vertexCoverList.add(vertex);

            for (int neighbor : adjacencyList[vertex]) {
                visited[neighbor] = true;
            }
        }

        int[] vertexCover = new int[vertexCoverList.size()];
        int index = 0;
        for (int v : vertexCoverList) {
            vertexCover[index++] = v;
            System.out.print(City.decode(v) + " -> ");
        }
        return vertexCover;
    }

}