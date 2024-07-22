import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, Integer.toString(root.val)));
        
        while (!stack.isEmpty()) {
            Pair<TreeNode, String> current = stack.pop();
            TreeNode node = current.getKey();
            String path = current.getValue();
            
            // Check if it's a leaf node
            if (node.left == null && node.right == null) {
                paths.add(path);
            }
            // Push right child to stack if it exists
            if (node.right != null) {
                stack.push(new Pair<>(node.right, path + "->" + node.right.val));
            }
            // Push left child to stack if it exists
            if (node.left != null) {
                stack.push(new Pair<>(node.left, path + "->" + node.left.val));
            }
        }
        
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);

        for (String path : result) {
            System.out.println(path);
        }
    }
}

// Helper Pair class to store tree nodes and paths
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
}
