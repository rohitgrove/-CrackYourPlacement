public class SegretOddEven {
    public static void segregateEvenOdd(Node head) {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while (end.next != null)
            end = end.next;

        Node new_end = end;

        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if (curr.data % 2 == 0) {
            head = curr;

            // now curr points to first even node
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    /*
                     * Break the link between prev and
                     * curr
                     */
                    prev.next = curr.next;

                    /* Make next of curr as null */
                    curr.next = null;

                    /* Move curr to end */
                    new_end.next = curr;

                    /* Make curr as new end of list */
                    new_end = curr;

                    /* Update curr pointer */
                    curr = prev.next;
                }
            }
        }

        else
            prev = curr;

        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }
}