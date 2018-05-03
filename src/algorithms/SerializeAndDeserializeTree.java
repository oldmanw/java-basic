package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeTree {
	
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode nullNode = new TreeNode(0);
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == nullNode) sb.append("#,");
			else sb.append(node.val + ",");
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node != nullNode) {
				queue.offer(nullNode);
			}
			if (node.right != null) {
				queue.offer(node.right);
			} else if (node != nullNode) {
				queue.offer(nullNode);
			}
		}
		int length = sb.length();
		while (sb.charAt(length - 1) == '#' || sb.charAt(length - 1) == ',') {
			sb.deleteCharAt(length - 1);
			length--;
		}
		return sb.toString();
	}
	
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) return null;
		String[] ele = data.split(",");
		TreeNode root = new TreeNode(Integer.valueOf(ele[0]));
		if (ele.length > 1) {
			int index = 1;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				if (index < ele.length) {
					if (ele[index].equals("#")) {
						queue.peek().left = null;
						index++;
					}
					else{
						queue.peek().left = new TreeNode(Integer.valueOf(ele[index++]));
						queue.offer(queue.peek().left);
					}
				}
				if (index < ele.length) {
					if (ele[index].equals("#")) {
						queue.peek().right = null;
						index++;
					}
					else{
						queue.peek().right = new TreeNode(Integer.valueOf(ele[index++]));
						queue.offer(queue.peek().right);
					}
				}
				queue.poll();
			}
		}
		return root;
	}

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
//		String[] ele = {"3", "9", "20", "null", "null", "15", "7"};
//		Tree tree = new Tree(ele);
//		String data = new SerializeAndDeserializeTree().serialize(tree.root);
//		System.out.println(data);
		String data = "";
		String[] ele = data.split(",");
		System.out.println(ele.length);
		//new SerializeAndDeserializeTree().deserialize(data);
	}

}
