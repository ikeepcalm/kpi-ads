package dev.ua.ikeepcalm.solution;

public class Graph {
    int Node, E;
    public Edge[] edge;

    public Graph(int Node, int E) {
        this.Node = Node;
        this.E = E;
        edge = new Edge[E];
    }
}