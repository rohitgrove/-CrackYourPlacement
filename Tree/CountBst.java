class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class CountBst {
    void solve(Node root, int l, int h, int[] cnt) {
        if (root == null)
            return;
        solve(root.left, l, h, cnt);
        if (root.data >= l && root.data <= h) {
            cnt[0]++;
        }
        solve(root.right, l, h, cnt);
    }

    int getCount(Node root, int l, int h) {
        int[] cnt = {0};
        solve(root, l, h, cnt);
        return cnt[0];
    }
}