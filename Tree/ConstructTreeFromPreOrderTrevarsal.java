public class ConstructTreeFromPreOrderTrevarsal {
    public TreeNode insertIntoBST(TreeNode root,int val){
        if(root==null) return new TreeNode(val);
        else if(root.val>val) root.left=insertIntoBST(root.left,val);
        else root.right=insertIntoBST(root.right,val);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            root = insertIntoBST(root,preorder[i]);
        }
        return root;
    }
}