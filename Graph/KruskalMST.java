import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge(0, 0, 0);
        }
    }
}

class Subset {
    int parent, rank;
}

class UnionFind {
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
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
}

public class KruskalMST {
    public static void main(String[] args) {
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Graph graph = new Graph(V, E);

        // Add edges (src, dest, weight)
        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        KruskalMST kruskal = new KruskalMST();
        kruskal.KruskalMST(graph);
    }

    void KruskalMST(Graph graph) {
        Edge[] result = new Edge[graph.V];
        int e = 0; // Index used to store the result
        int i = 0; // Index used to sort the edges

        Arrays.sort(graph.edges);

        Subset[] subsets = new Subset[graph.V];
        for (i = 0; i < graph.V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while (e < graph.V - 1) {
            Edge nextEdge = graph.edges[i++];

            int x = new UnionFind().find(subsets, nextEdge.src);
            int y = new UnionFind().find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                new UnionFind().union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST:");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
    }
}
