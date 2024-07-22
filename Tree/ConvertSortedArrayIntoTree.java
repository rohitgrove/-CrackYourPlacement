public class ConvertSortedArrayIntoTree {
    public static TreeNode solve(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, i, mid - 1);
        root.right = solve(nums, mid + 1, j);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        printTree(root); // Helper function to print the tree
    }

    // Helper function to print the tree (In-Order Traversal)
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}