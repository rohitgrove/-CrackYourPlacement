public class RangeSum {
    public static int ans = 0;

    public static void inorder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inorder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }
        inorder(root.right, low, high);
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root.val < low) {
            inorder(root.right, low, high);
        } else if (root.val > high) {
            inorder(root.left, low, high);
        } else {
            inorder(root, low, high);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        int result = rangeSumBST(root, low, high);
        System.out.println("Range Sum: " + result); // Expected Output: 32
    }
}
