package algorithms;

import java.util.List;
import java.util.ArrayList;

public class PathOfTree {
	
	public List<List<Integer>> path(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if (root == null) return res;
		pathHelper(res, temp, root);
		return res;
	}
	
	private void pathHelper(List<List<Integer>> list, List<Integer> temp, TreeNode node) {
		temp.add(node.val);
		if (node.left == null && node.right == null) list.add(new ArrayList<Integer>(temp));
		if (node.left != null) pathHelper(list, temp, node.left);
		if (node.right != null) pathHelper(list, temp, node.right);
		temp.remove(temp.size() - 1);
	}

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
		String[] ele = {"1", "2", "3", "4", "null", "5", "6", "null", "null", "7"};
		Tree tree = new Tree(ele);
		List<List<Integer>> result = new PathOfTree().path(tree.root);
		for (List<Integer> list : result) System.out.println(list);
	}

}
