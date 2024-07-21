class ListNode {
    int val;
    ListNode prev;
    ListNode next;
    ListNode child;

    ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

public class FlatternAMutilevel {
    public ListNode flatten(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            if (curr.child != null) {
                ListNode forward = curr.next;
                ListNode temp = curr.child;
                curr.child = null;
                curr.next = temp;
                temp.prev = curr;

                while (temp.next != null) {
                    temp = temp.next;
                }

                if (forward != null) {
                    temp.next = forward;
                    forward.prev = temp;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
