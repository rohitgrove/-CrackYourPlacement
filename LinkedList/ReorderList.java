public class ReorderList {
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node forward = null;

        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public static void reorderList(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node revList = reverse(slow.next);
        slow.next = null;

        Node curr = head;
        Node forward1 = null;
        Node forward2 = null;

        while (revList != null && curr != null) {
            forward1 = curr.next;
            forward2 = revList.next;

            curr.next = revList;
            revList.next = forward1;

            curr = forward1;
            revList = forward2;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.printLL();
        reorderList(ll.head);
        ll.printLL(ll.head);        
    }
}
