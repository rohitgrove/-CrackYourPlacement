public class RemoveDuplicatesInLL2 {
    public static Node deleteDuplicates(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (head != null) {
            if (head.next != null && head.data == head.next.data) {
                while (head.next != null && head.data == head.next.data) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(1);
        ll.insertAtTail(2);
        ll.insertAtTail(3);
        ll.insertAtTail(3);
        ll.insertAtTail(4);
        ll.insertAtTail(4);
        ll.insertAtTail(5);
        ll.head = deleteDuplicates(ll.head);
        ll.printLL();
    }
}
