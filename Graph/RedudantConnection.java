import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class RedudantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges to the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            
            // Check for cycle
            if (isCycle(V, adj)) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    // Function to detect cycle in an undirected graph using BFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];  // V + 1 to handle 1-based index nodes
        boolean res = false;
        for (int i = 1; i <= V; i++) {  // Start from 1 to V
            if (!vis[i]) {
                res = bfs(adj, vis, i);
                if (res) return true;
            }
        }
        return res;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        vis[node] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node, -1));
        
        while (!q.isEmpty()) {
            Pair t = q.poll();
            int n = t.node;
            int parent = t.parent;
            
            for (Integer it : adj.get(n)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(new Pair(it, n));
                } else if (it != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    class Pair {
        int node;
        int parent;
        
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}