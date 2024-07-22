class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BSTContainsDeadEnd {
    public static boolean solve(Node root, int l, int h) {
        if (root == null)
            return false;

        if (Math.abs(root.data - l) == 1 && (h - root.data == 1))
            return true;
        boolean x = solve(root.left, l, root.data);
        boolean y = solve(root.right, root.data, h);
        return x || y;
    }

    public static boolean isDeadEnd(Node root) {
        return solve(root, 0, 1000000000);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.left = new Node(1);
        root.right.left = new Node(10);
        root.right.right = new Node(12);

        System.out.println(isDeadEnd(root)); // Output: false (or true depending on the tree structure)
    }
}
