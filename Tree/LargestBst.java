class Node {
    int data;
    Node left, right;

    public Node(final int d) {
        data = d;
    }
}

public class LargestBst {
    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static class nodeInfo {
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        boolean isBST; // If subtree is BST

        nodeInfo() {
        }

        nodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    static nodeInfo largestBST(Node root) {

        if (root == null) {
            return new nodeInfo(0, Integer.MIN_VALUE,
                    Integer.MAX_VALUE, true);
        }

        nodeInfo left = largestBST(root.left);
        nodeInfo right = largestBST(root.right);

        nodeInfo returnInfo = new nodeInfo();

        returnInfo.min = Math.min(left.min, root.data);
        returnInfo.max = Math.max(right.max, root.data);
        returnInfo.isBST = left.isBST && right.isBST
                && root.data > left.max
                && root.data < right.min;

        if (returnInfo.isBST)

            returnInfo.size = left.size + right.size + 1;
        else
            returnInfo.size = Math.max(left.size, right.size);

        return returnInfo;
    }

    static int largestBst(Node root) {
        return largestBST(root).size;
    }

    public static void main(String[] args) {

        final Node node1 = new Node(60);
        node1.left = new Node(65);
        node1.right = new Node(70);
        node1.left.left = new Node(50);

        System.out.print("Size of the largest BST is "
                + LargestBst.largestBst(node1)
                + "\n");
    }
}