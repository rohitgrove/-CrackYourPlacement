import java.util.*;

public class MinimumAbsolute {
    public static int getMinimumDifference(TreeNode root) {
        List<Integer> v = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        if (root != null) {
            inorderTraversal(root, v);
        }

        int size = v.size();
        for (int i = 1; i < size; ++i) {
            int diff = v.get(i) - v.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void inorderTraversal(TreeNode node, List<Integer> v) {
        if (node.left != null) {
            inorderTraversal(node.left, v);
        }
        v.add(node.val);
        if (node.right != null) {
            inorderTraversal(node.right, v);
        }
    }
}