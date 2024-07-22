public class PreOrderToPostOrder {
    
    // Function to build tree from given preorder traversal
    public static TreeNode buildTreeFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[start]);
        
        int i;
        for (i = start + 1; i <= end; i++) {
            if (preorder[i] > node.val) {
                break;
            }
        }
        
        node.left = buildTreeFromPreorder(preorder, start + 1, i - 1);
        node.right = buildTreeFromPreorder(preorder, i, end);
        
        return node;
    }

    // Function to print postorder traversal of the tree
    public static void printPostorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.val + " ");
    }
    
    public static void main(String[] args) {
        int[] preorder = {10, 5, 1, 7, 40, 50};
        int n = preorder.length;
        
        TreeNode root = buildTreeFromPreorder(preorder, 0, n - 1);
        
        System.out.print("Postorder traversal: ");
        printPostorder(root);
    }
}
