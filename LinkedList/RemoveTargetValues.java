public class RemoveTargetValues {
    public static Node removeElements(Node head, int val) {
        if (head == null) {
            return head;
        }

        while (head != null && head.data == val) {
            head = head.next;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.data == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(6);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.printLL();
        ll.printLL(removeElements(ll.head, 6));
    }
}