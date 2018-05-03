package algorithms;

public class ConvertSortedListToBST {
	
	private ListNode list;
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid-1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid+1, end);
        return parent;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        list = head;
        return sortedListToBST(0, n - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		new ConvertSortedListToBST().sortedListToBST(head);
	}

}
