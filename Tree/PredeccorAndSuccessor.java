class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class PredeccorAndSuccessor {
    static Node pre, suc;

    // Function to find predecessor and successor
    public static void findPreSuc(Node root, Node pre, Node suc, int key) {
        // Base case
        if (root == null) {
            return;
        }

        // If key is smaller than root's key, go to left subtree
        if (key < root.key) {
            suc = root;
            findPreSuc(root.left, pre, suc, key);
        }
        // If key is greater than root's key, go to right subtree
        else if (key > root.key) {
            pre = root;
            findPreSuc(root.right, pre, suc, key);
        }
        // If key is same as root's key
        else {
            // Go to left subtree to find predecessor
            findPreSuc(root.left, pre, suc, key);
            // Go to right subtree to find successor
            findPreSuc(root.right, pre, suc, key);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        int key = 65;
        findPreSuc(root, pre, suc, key);

        if (pre != null) {
            System.out.println("Predecessor is " + pre.key);
        } else {
            System.out.println("No Predecessor");
        }

        if (suc != null) {
            System.out.println("Successor is " + suc.key);
        } else {
            System.out.println("No Successor");
        }
    }
}
