import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class MinimumDistanceBetwwenNodes {
    private void solve(Node root, int a, int b, Map<Node, Node> parent, Node[] p, Node[] q) {
        if (root == null) return;

        if (root.data == a) p[0] = root;
        if (root.data == b) q[0] = root;

        if (root.left != null) {
            parent.put(root.left, root);
            solve(root.left, a, b, parent, p, q);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            solve(root.right, a, b, parent, p, q);
        }
    }

    public int findDist(Node root, int a, int b) {
        Map<Node, Node> parent = new HashMap<>();
        Node[] p = new Node[1];
        Node[] q = new Node[1];
        solve(root, a, b, parent, p, q);

        if (p[0] == null || q[0] == null) return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(p[0]);

        Map<Node, Boolean> visited = new HashMap<>();
        visited.put(p[0], true);

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (node == q[0]) return distance;

                if (node.left != null && !visited.getOrDefault(node.left, false)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && !visited.getOrDefault(node.right, false)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                if (parent.containsKey(node) && !visited.getOrDefault(parent.get(node), false)) {
                    queue.offer(parent.get(node));
                    visited.put(parent.get(node), true);
                }
            }
            distance++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumDistanceBetwwenNodes sol = new MinimumDistanceBetwwenNodes();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(sol.findDist(root, 4, 7));  // Example usage
    }
}
