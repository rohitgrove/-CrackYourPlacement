public class DeleteNodes {
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head = reverse(head);
        Node prev = head;
        Node temp = head.next;
        while (temp != null) {
            if (prev.data > temp.data) {
                if (temp.next != null) {
                    Node next_next = temp.next;
                    temp.next = null;
                    temp = next_next;
                    prev.next = temp;
                } else {
                    prev.next = null;
                    break;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        head = reverse(head);
        return head;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(12);
        ll.insertAtTail(15);
        ll.insertAtTail(10);
        ll.insertAtTail(11);
        ll.insertAtTail(5);
        ll.insertAtTail(6);
        ll.insertAtTail(2);
        ll.insertAtTail(3);

        System.out.println("Original List: ");
        ll.printLL(ll.head);

        ll.head = compute(ll.head);

        System.out.println("\nModified List: ");
        ll.printLL(ll.head);
    }
}
