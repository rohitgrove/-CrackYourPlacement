public class DiameterOfBinaryTree {
    public static class Pair {
        int diameter;
        int height;
        Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Pair diameterFast(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair leftNode = diameterFast(root.left);
        Pair rightNode = diameterFast(root.right);

        int op1 = leftNode.diameter;
        int op2 = rightNode.diameter;
        int op3 = leftNode.height + rightNode.height;

        Pair ans = new Pair(Math.max(op1, Math.max(op2, op3)), Math.max(leftNode.height, rightNode.height) + 1);
        return ans;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return diameterFast(root).diameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree is: " + diameter);
    }
}
