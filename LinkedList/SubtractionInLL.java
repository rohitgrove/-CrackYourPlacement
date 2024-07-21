public class SubtractionInLL {
    public static Node reverse(Node head) {
        Node p = null, ptr = null, curr = head;
        while (curr != null) {
            p = ptr;
            ptr = curr;
            curr = curr.next;
            ptr.next = p;
        }
        return ptr;
    }

    public static int count(Node head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    public static Node subLinkedList(Node head1, Node head2) {
        while (head1 != null && head1.data == 0) head1 = head1.next;
        while (head2 != null && head2.data == 0) head2 = head2.next;
        if (head1 == null && head2 == null) return new Node(0);
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node p1, p2;
        if (count(head1) > count(head2)) {
            p1 = head1;
            p2 = head2;
        } else if (count(head1) < count(head2)) {
            p1 = head2;
            p2 = head1;
        } else {
            while (head1 != null && head1.data == head2.data) {
                head1 = head1.next;
                head2 = head2.next;
            }
            if (head1 == null) return new Node(0);

            if (head1.data > head2.data) {
                p1 = head1;
                p2 = head2;
            } else {
                p1 = head2;
                p2 = head1;
            }
        }

        p1 = reverse(p1);
        p2 = reverse(p2);

        int carry = 0;
        Node head = new Node(-1);
        Node tail = head;
        while (p2 != null) {
            int temp = p1.data - p2.data - carry;
            carry = 0;
            if (temp < 0) {
                carry = 1;
                temp += 10;
            }
            Node node = new Node(temp);
            tail.next = node;
            tail = node;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (carry != 0) {
            int temp = p1.data - carry;
            carry = 0;
            if (temp < 0) {
                carry = 1;
                temp += 10;
            }
            Node node = new Node(temp);
            tail.next = node;
            tail = node;
            p1 = p1.next;
        }

        tail.next = p1;

        Node ans = head.next;
        head.next = null;

        ans = reverse(ans);
        while (ans != null && ans.data == 0) ans = ans.next;
        if (ans == null) return new Node(0);
        return ans;
    }

    public static void main(String[] args) {
        // Example usage:
        Node head1 = new Node(1);
        head1.next = new Node(0);
        head1.next.next = new Node(0);
        head1.next.next.next = new Node(0);

        Node head2 = new Node(9);
        head2.next = new Node(9);

        Node result = subLinkedList(head1, head2);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
