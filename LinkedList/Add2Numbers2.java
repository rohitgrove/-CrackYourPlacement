public class Add2Numbers2 {
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        Node curr1 = l1;
        Node curr2 = l2;

        Node dummy = new Node(-1);
        Node res = dummy;

        int carry = 0;
        while (curr1 != null || curr2 != null) {
            int num1 = 0, num2 = 0;
            if (curr1 != null) {
                num1 = curr1.data;
                curr1 = curr1.next;
            }

            if (curr2 != null) {
                num2 = curr2.data;
                curr2 = curr2.next;
            }

            int num = num1 + num2 + carry;
            Node newNode = new Node(num % 10);
            dummy.next = newNode;
            dummy = dummy.next;
            carry = num / 10;
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            dummy.next = newNode;
            dummy = dummy.next;
        }

        return reverseList(res.next);
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(3);
        ll1.insertAtHead(4);
        ll1.insertAtHead(2);
        ll1.insertAtHead(7);
        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(4);
        ll2.insertAtHead(6);
        ll2.insertAtHead(5);

        LinkedList ll3 = new LinkedList();
        ll3.head = addTwoNumbers(ll1.head, ll2.head);
        ll3.printLL();
    }
}
