import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class InvertTree {
    public static void bfs(TreeNode root, Map<TreeNode, Boolean> visited) {
        if (root == null) {
            return;
        }
        if (visited.getOrDefault(root, false)) {
            return;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (visited.getOrDefault(current, false)) {
                continue;
            }
            visited.put(current, true);

            // Swap the left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Enqueue non-null children
            if (current.left != null) {
                q.offer(current.left);
            }
            if (current.right != null) {
                q.offer(current.right);
            }
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        Map<TreeNode, Boolean> visited = new HashMap<>();
        bfs(root, visited);
        return root;
    }

    public static void main(String[] args) {
        // Example: root = [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = invertTree(root);

        // Output the inverted tree structure (for verification purposes)
        System.out.println("Inverted tree structure (level-order):");
        printTree(invertedRoot);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                q.offer(current.left);
            }
            if (current.right != null) {
                q.offer(current.right);
            }
        }
    }
}
