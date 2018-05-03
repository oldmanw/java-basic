package algorithms;

/**
 * author:oldmanw
 * create at:2018-04-22 10:27
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class FindFirstCommonNode {

    public ListNode firstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;
        ListNode cur1 = head1, cur2 = head2;
        while (cur1 != null || cur2 != null) {
            if (cur1 == cur2) return cur1;
            if (cur1 != null) {cur1 = cur1.next;}
            else cur1 = head2;
            if (cur2 != null){ cur2 = cur2.next;}
            else cur2 = head1;
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode head1 = new ListNode(0);
//        head1.next = new ListNode(1);
//        head1.next.next = new ListNode(2);
//        ListNode head2 = new ListNode(3);
//        head2.next = new ListNode(4);
//        head2.next.next = head1.next;
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        ListNode head2 = head1;
        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        System.out.println(findFirstCommonNode.firstCommonNode(head1, head2).val);
    }

}
