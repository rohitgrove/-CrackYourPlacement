import java.util.PriorityQueue;
import java.util.Comparator;

public class MereKSortedList {
    static class Compare implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            return node1.data - node2.data;
        }
    }

    public static Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        for (Node node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        Node dummy = new Node(-1);
        Node result = dummy;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            dummy.next = current;
            dummy = dummy.next;

            if (current.next != null) {
                pq.add(current.next);
            }

            current.next = null; // This line is optional in Java
        }

        return result.next;
    }

    // Helper method to convert an array to a linked list
    public static Node arrayToList(int[] arr) {
        Node head = new Node();
        Node current = head;
        for (int val : arr) {
            current.next = new Node(val);
            current = current.next;
        }
        return head.next;
    }

    // Helper method to print the linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] arrayLists = { {1, 4, 5}, {1, 3, 4}, {2, 6} };
        Node[] lists = new Node[arrayLists.length];

        for (int i = 0; i < arrayLists.length; i++) {
            lists[i] = arrayToList(arrayLists[i]);
        }

        Node result = mergeKLists(lists);
        printList(result); // Expected output: 1 1 2 3 4 4 5 6
    }
}