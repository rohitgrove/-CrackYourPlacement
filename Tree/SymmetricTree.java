public class SymmetricTree {
    public static boolean solve(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean leftNode = solve(root1.left, root2.right);
        boolean rightNode = solve(root1.right, root2.left);

        return leftNode && rightNode;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return solve(root.left, root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);
        System.out.println("Is Symmetric: " + result); // Expected Output: true
    }    
}
