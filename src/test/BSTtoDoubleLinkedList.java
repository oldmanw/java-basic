package test;

import java.util.ArrayList;

public class BSTtoDoubleLinkedList {
	
	public TreeNode BSTtoDLL(TreeNode root) {
		if (root == null) return root;
		ArrayList<TreeNode> list = new ArrayList<>();
		recursion(list, root);
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).right = list.get(i + 1);
		}
		for (int i = list.size() - 1; i > 0; i--) {
			list.get(i).left = list.get(i - 1);
		}
		return list.get(0);
	}
	
	private void recursion(ArrayList<TreeNode> list, TreeNode node) {
		if (node.left != null) recursion(list, node.left);
		list.add(node);
		if (node.right != null) recursion(list, node.right);
	}
}
