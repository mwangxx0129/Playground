package May21_2018;

public class RemoveNthNodeFromEndOfList {
    static class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }

    public static void main(String [] args) {
        int [] A = {1,2,3,4,5};

        System.out.print("Old list:\t");
        Node head = buildLinkedList(A);
        print(head);

        System.out.print("\nNew list:\t");
        Node newHead = removeNthNodeFromEndOfList(head, 2);
        print(newHead);
    }

    public static Node removeNthNodeFromEndOfList(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node pre = dummy, fast = dummy;
        while (n -- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    private static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            if (cur.next == null) {
                System.out.print(cur.val);
                break;
            }
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }

    private static Node buildLinkedList(int[] A) {
        Node dummy = new Node(-1);
        Node pre = dummy;
        for (int e : A) {
            pre.next = new Node(e);
            pre = pre.next;
        }
        return dummy.next;
    }
}
