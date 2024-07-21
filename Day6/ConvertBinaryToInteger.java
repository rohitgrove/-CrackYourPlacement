public class ConvertBinaryToInteger {
    public static int getDecimalValue(Node head) {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.next;
        }
        int decimal = Integer.parseInt(sb.toString(), 2);
        return decimal;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(0);
        ll1.insertAtTail(1);
        System.out.println(getDecimalValue(ll1.head));
    }
}
