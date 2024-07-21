public class PartitionList {
    public static Node partition(Node head, int x) {
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        Node less = dummy1;
        Node greater = dummy2;

        Node curr = head;
        while (curr != null) {
            if (curr.data < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        
        greater.next = null;
        less.next = dummy2.next;
        
        Node newHead = dummy1.next;
        
        return newHead;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(2);
        ll1.insertAtHead(5);
        ll1.insertAtHead(2);
        ll1.insertAtHead(3);
        ll1.insertAtHead(4);
        ll1.insertAtHead(1);
    }
}
