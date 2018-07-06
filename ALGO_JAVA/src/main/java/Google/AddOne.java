package Google;

public class AddOne {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public static Node buildLinkedList(int[] array) {
        Node dummy = new Node(-1);
        Node pre = dummy;
        for (int val : array)
            pre = pre.next = new Node(val);
        return dummy.next;
    }

    public static void print(Node head) {
        while (head != null) {
            if (head.next == null)
                System.out.println(head.val);
            else
                System.out.print(head.val + "->");
            head = head.next;
        }
    }

    // T = O(n)
    // S = O(1)
    public static Node addOne(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;
        Node cur = head;
        while (cur != null) {
            if (cur.val != 9) pre = cur;
            cur = cur.next;
        }
        while (pre != null) {
            pre.val = (pre.val + 1)  % 10;
            pre = pre.next;
        }
        return dummy.val != 0 ? dummy : dummy.next;
    }


    public static void main(String[] args) {
        int [] array = {9,9,9,9,9};
        Node head = buildLinkedList(array);
        print(head);
        Node result = addOne(head);
        print(result);
    }
}
