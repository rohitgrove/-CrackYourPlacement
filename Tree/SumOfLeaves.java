public class SumOfLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
                // if leaf node.
            } else {
                // recursive call for left if not leaf node.
                sum += sumOfLeftLeaves(root.left);
            }
        }
        // also have to call function for right.
        sum += sumOfLeftLeaves(root.right);
        return sum;

    }
}