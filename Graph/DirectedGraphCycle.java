import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphCycle {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    public DirectedGraphCycle(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public boolean isCyclic() {
        int[] inDegree = new int[V]; 
        Queue<Integer> q = new LinkedList<>(); 
        int visited = 0;


        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        for (int u = 0; u < V; u++) {
            if (inDegree[u] == 0) {
                q.add(u);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;


            for (int v : adj.get(u)) {
                inDegree[v]--;

                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return visited != V; 
    }
}

class Main {
    public static void main(String[] args) {
        DirectedGraphCycle g = new DirectedGraphCycle(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        if (g.isCyclic()) {
            System.out.println("Graph contains cycle.");
        } else {
            System.out.println(
                    "Graph does not contain cycle.");
        }
    }
}
