package main.graph;

import java.util.*;

public class PrimMST {
  static class Node implements Comparable<Node> {
    int vertex;
    int weight;

    Node(int v, int w) {
      vertex = v;
      weight = w;
    }

    @Override
    public int compareTo(Node o) {
      /*
      Sort by lowest weight (Ascending Order).
      If the return is <0 (negative), then 'this' will be at the front of the list (higher priority).
      */
      return Integer.compare(this.weight, o.weight);
    }
  }

  public static void run(Graph graph, int start){
    int V = graph.V; // initialize the number of nodes 

    int[] weight = new int[V];
    int[] parent = new int[V];
    boolean[] visited = new boolean[V];

    Arrays.fill(weight, Integer.MAX_VALUE); // initialize weight as infinity (no edge chosen yet)
    Arrays.fill(parent, -1);

    weight[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    while(!pq.isEmpty()) {
      Node n = pq.poll(); // get the first element head and delete from queue
      int u = n.vertex;

      if(visited[u]) continue; // skip if node os already in queue
      visited[u] = true; // marking read nodes

      for (Edge e: graph.adj.get(u)) {
        int v = e.to;
        int w = e.weight;

        /*
        Check if the neighbor node 'v' is not yet in the MST and if the current edge weight 'w' is cheaper than the previously recorded weight for that node.
        */
        if(!visited[v] && w < weight[v]) {
          weight[v] = w;                  // Update the best (minimum) weight to reach node v
          parent[v] = u;                  // Store the path: node v is best reached from node u
          pq.add(new Node(v, weight[v])); // Add node v to the priority queue with its new lower cost
        }
      }
    }

    // output Minimum Spanning Tree
      System.out.println("Minimum Spanning Tree Result");
      int total = 0;
      for (int i = 0; i < V; i++){
        if (parent[i] != -1) {
          System.out.println(parent[i] + " - " + i + " : " + weight[i]);
          total += weight[i];
        }
      }
      System.out.println("Total weight: " + total);
  }
}