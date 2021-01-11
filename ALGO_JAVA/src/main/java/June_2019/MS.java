package June_2019;

public class MS {
    class ListNode {
        int val;
        ListNode pre;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public void sortListNodeOnlyHasZeroAndOne(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        int countZero = 0;

        // count
        while (cur != null) {
            if (cur.val == 0) {
                ++ countZero;
            }
            cur = cur.next;
        }

        // set value
        cur = head;
        while (cur != null) {
            if (countZero != 0) {
                cur.val = 0;
                -- countZero;
            } else {
                cur.val = 1;
            }

            cur = cur.next;
        }
    }



}
