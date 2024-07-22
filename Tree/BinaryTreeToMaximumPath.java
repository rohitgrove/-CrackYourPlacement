public class BinaryTreeToMaximumPath {
    int sum;

    public int maxPathSum(TreeNode root) {

        sum = root.val;
        sum(root);

        return sum;
    }
    public int sum(TreeNode root){
        
        if(root == null){
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        int max = Math.max(left, right);

        //sum -> result

        sum = Math.max(root.val,Math.max(max + root.val,  Math.max(sum, left + right + root.val)));

        //at each node we have three options to return,
        // current node.val or max(left, right) + node.val


        return Math.max(root.val, max + root.val);
    }
}