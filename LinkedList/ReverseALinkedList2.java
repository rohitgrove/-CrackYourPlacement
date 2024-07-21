public class ReverseALinkedList2 {
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static Node reverseBetween(Node head, int left, int right) {
        if (head == null || left == right) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        Node start = prev.next;
        Node then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(50);
        ll.insertAtHead(40);
        ll.insertAtHead(30);
        ll.insertAtHead(20);
        ll.insertAtHead(10);
        ll.printLL();
        ll.printLL(reverseBetween(ll.head, 2, 4));
    }
}
