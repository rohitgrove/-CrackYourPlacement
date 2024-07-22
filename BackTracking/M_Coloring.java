public class M_Coloring {    
    public static boolean isSafe(int node, int[] color, boolean[][] graph, int n, int col) {
        for (int k = 0; k < n; k++) {
            if (k != node && graph[k][node] && color[k] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int node, int[] color, int m, int n, boolean[][] graph) {
        if (node == n) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (isSafe(node, color, graph, n, i)) {
                color[node] = i;
                if (solve(node + 1, color, m, n, graph)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        if (solve(0, color, m, n, graph)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4; // number of nodes
        int m = 3; // number of colors
        boolean[][] graph = new boolean[n][n];

        // Example graph initialization
        graph[0][1] = true;
        graph[1][0] = true;
        graph[0][2] = true;
        graph[2][0] = true;
        graph[1][2] = true;
        graph[2][1] = true;
        graph[2][3] = true;
        graph[3][2] = true;

        if (graphColoring(graph, m, n)) {
            System.out.println("Graph can be colored with " + m + " colors");
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors");
        }
    }
}
