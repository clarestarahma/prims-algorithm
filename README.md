# Prim's Algorithm - Minimum Spanning Tree (MST) Implementation

This project implements **Prim's Algorithm** to find the Minimum Spanning Tree (MST) of a connected, weighted graph. The implementation is written in Java and optimized for performance using a Priority Queue.

## 🚀 Overview
A Minimum Spanning Tree (MST) is a subset of edges in a weighted graph that connects all vertices without any cycles and with the minimum possible total edge weight. This is a fundamental concept in Network Design, Cluster Analysis, and Circuit Layout.

## 🛠️ Implementation Details
- **Data Structure**: Uses an Adjacency List for graph representation.
- **Priority Queue Optimization**: Achieves a time complexity of $O(E \log V)$ by utilizing Java's `PriorityQueue` for greedy edge selection.
- **Node Classification**: Implements a custom `Node` class with the `Comparable` interface to ensure the Priority Queue always yields the minimum weight edge.

## 📖 Core Logic (The Relaxation Step)
The heart of this implementation lies in the update logic within the Prim's runner:

```java
// Check if neighbor 'v' is not in MST and found a cheaper edge 'w'
if (!visited[v] && w < weight[v]) {
    weight[v] = w;              // Update the minimum weight to reach node v
    parent[v] = u;              // Track the parent node for path reconstruction
    pq.add(new Node(v, weight[v])); // Push updated node into the Priority Queue
}