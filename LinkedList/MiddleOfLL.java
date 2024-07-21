public class MiddleOfLL {
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(5);
        ll1.insertAtHead(4);
        ll1.insertAtHead(3);
        ll1.insertAtHead(2);
        ll1.insertAtHead(1);
        System.out.println(middleNode(ll1.head).data);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(6);
        ll2.insertAtHead(5);
        ll2.insertAtHead(4);
        ll2.insertAtHead(3);
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        System.out.println(middleNode(ll2.head).data);
    }
}
