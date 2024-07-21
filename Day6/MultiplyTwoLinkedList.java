public class MultiplyTwoLinkedList {
    public static long multiplyTwoLists(Node first, Node second) {
        long mod = 1000000007L;
        long sum1 = 0;
        long sum2 = 0;
        Node curr1 = first;
        Node curr2 = second;

        while (curr1 != null) {
            sum1 = (sum1 * 10) % mod + curr1.data % mod;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            sum2 = (sum2 * 10) % mod + curr2.data % mod;
            curr2 = curr2.next;
        }

        long ans = (sum1 * sum2) % mod;

        return ans;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(3);   
        ll.insertAtTail(2);
        ll.printLL();   

        LinkedList l = new LinkedList();
        l.insertAtTail(2);
        l.printLL();   
        System.out.println(multiplyTwoLists(ll.head, l.head));
    }
}