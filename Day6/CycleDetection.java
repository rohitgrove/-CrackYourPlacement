public class CycleDetection {
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();

        ll1.insertAtTail(3);
        ll1.insertAtTail(2);
        ll1.insertAtTail(0);
        ll1.insertAtTail(-4);
        // ll1.tail.next = ll1.head.next;
        System.out.println(hasCycle(ll1.head));
    }
}
