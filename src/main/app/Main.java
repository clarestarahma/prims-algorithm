package main.app;

import main.graph.Graph;
import main.graph.PrimMST;

public class Main {
  public static void main(String[] args){
    Graph graph = new Graph(7);

    graph.addEdge(1, 2, 10);
    graph.addEdge(1, 4, 30);
    graph.addEdge(1, 5, 45);
    graph.addEdge(2, 3, 50);
    graph.addEdge(2, 5, 40);
    graph.addEdge(2, 6, 25);
    graph.addEdge(3, 5, 35);
    graph.addEdge(3, 6, 15);
    graph.addEdge(4, 6, 20);
    graph.addEdge(5, 6, 55);

    PrimMST.run(graph, 1);
  }
}