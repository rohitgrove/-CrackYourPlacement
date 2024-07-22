import java.util.*;

public class MazePathFinder {
    public static int N = 9;
    public static int[] row = { -1, 1, 0, 0 };
    public static int[] col = { 0, 0, -1, 1 };

    public static int[] _row = { 0, 0, N - 1, N - 1 };
    public static int[] _col = { 0, N - 1, 0, N - 1 };

    public static boolean isValid(ArrayList<int[]> visited, int[] pt) {
        return (pt[0] >= 0) && (pt[0] < N) && (pt[1] >= 0) && (pt[1] < N) && (!visited.stream().anyMatch(item -> item[0] == pt[0] && item[1] == pt[1]));
    }

    public static void printPath(ArrayList<int[]> path) {
        String pathStr = "";
        for (int[] i : path) {
            pathStr += "(" + i[0] + ", " + i[1] + ") -> ";
        }
        pathStr += "MID";
        System.out.println(pathStr);
        System.out.println();
    }

    public static void findPathInMazeUtil(int[][] maze, ArrayList<int[]> path, ArrayList<int[]> visited, int[] curr) {
        if (curr[0] == (N / 2) && curr[1] == (N / 2)) {
            printPath(path);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int n = maze[curr[0]][curr[1]];

            int x = curr[0] + row[i] * n;
            int y = curr[1] + col[i] * n;
            int[] next = { x, y };
        
            if (isValid(visited, next)) {
            
                visited.add(next);
                
                path.add(next);
                
                findPathInMazeUtil(maze, path, visited, next);
 
                path.remove(path.size() - 1);
                visited.removeIf(item -> item[0] == next[0] && item[1] == next[1]);
            }
        }
    }

    public static void findPathInMaze(int[][] maze) {

        ArrayList<int[]> path = new ArrayList<>();
    
        ArrayList<int[]> visited = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int x = _row[i];
            int y = _col[i];
            int[] pt = { x, y };
            
            visited.add(pt);
    
            path.add(pt);
            findPathInMazeUtil(maze, path, visited, pt);
            path.remove(path.size() - 1);
            visited.removeIf(item -> item[0] == pt[0] && item[1] == pt[1]);
        }
    }

    public static void main(String[] args) {
        int[][] maze = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
                { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
                { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
                { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
                { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
                { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
                { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
                { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
                { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };

        findPathInMaze(maze);
    }
}
