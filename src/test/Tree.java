package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *ģ��leetcode�����Ĳ�����������
 *�����ַ������鹹�������
 *Ŀǰ������ֻ֧��������null����ÿ��Ԫ�ض�Ҫ��˫����
 *��������{"1", "2", "3", "null", "4", "5", "6"}�����������µ�����
 *        1
 *       / \
 *      2   3
 *       \ / \
 *       4 5  6
 * @author oldmanw
 * @param elements
 * @throws MyException
 */

public class Tree {
	public TreeNode root = null;
	
	public Tree(String[] elements) throws MyException {
		if (elements.length > 0) {
			if (elements[0] == "null") throw new MyException("Root of Tree cannot be null");
			this.root = this.construct(elements, null);
		}
	}
	
	public TreeNode construct(String[] strArr, TreeNode root) {
		root = new TreeNode(Integer.valueOf(strArr[0]));
		if (strArr.length > 1) {
			int index = 1;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				if (index < strArr.length) {
					if (strArr[index] == "null") {
						queue.peek().left = null;
						index++;
					}
					else{
						queue.peek().left = new TreeNode(Integer.valueOf(strArr[index++]));
						queue.offer(queue.peek().left);
					}
				}
				if (index < strArr.length) {
					if (strArr[index] == "null") {
						queue.peek().right = null;
						index++;
					}
					else{
						queue.peek().right = new TreeNode(Integer.valueOf(strArr[index++]));
						queue.offer(queue.peek().right);
					}
				}
				queue.poll();
			}
		}
		return root;
	}
	
	//ǰ�����
	public List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		recursionForPreOrder(res, root);
		return res;
	}
	
	private void recursionForPreOrder(List<Integer> list, TreeNode node) {
		list.add(node.val);
		if (node.left != null) recursionForPreOrder(list, node.left);
		if (node.right != null) recursionForPreOrder(list, node.right);
	}
	
	//�������
	public List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		recursionForInOrder(res, root);
		return res;
	}
	
	private void recursionForInOrder(List<Integer> list, TreeNode node) {
		if (node.left != null) recursionForInOrder(list, node.left);
		list.add(node.val);
		if (node.right != null) recursionForInOrder(list, node.right);
	}
	
	//�������
	public List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		recursionForPostOrder(res, root);
		return res;
	}
	
	private void recursionForPostOrder(List<Integer> list, TreeNode node) {
		if (node.left != null) recursionForPostOrder(list, node.left);
		if (node.right != null) recursionForPostOrder(list, node.right);
		list.add(node.val);
	}
}
