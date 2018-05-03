package algorithms;

public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode Next = head.next;
            head.next = prev;
            prev = head;
            head = Next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseLinkedList().reverse(head).val);
    }

}
