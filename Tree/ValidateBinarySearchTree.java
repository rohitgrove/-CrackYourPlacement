public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        boolean output = isValidBSTAux(root, -1*Double.MAX_VALUE, Double.MAX_VALUE);
        return output;
    }
    public boolean isValidBSTAux(TreeNode root, double leftMax, double rightMin) {
        if (root == null) {
            return true;
        }
        boolean chkLeft = true;
        boolean chkRight = true;

        if (!(root.left == null) && (root.left.val >= root.val || root.left.val <= leftMax)) {
            chkLeft = false;
        }
        if (!(root.right == null) && (root.right.val <= root.val || root.right.val >= rightMin)) {
            chkRight = false;
        }
        return chkLeft && chkRight && isValidBSTAux(root.left, leftMax, root.val) && isValidBSTAux(root.right, root.val, rightMin);
    }
}