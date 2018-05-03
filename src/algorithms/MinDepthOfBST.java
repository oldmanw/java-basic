package algorithms;

import test.TreeNode;
import test.MyException;
import test.Tree;

public class MinDepthOfBST {
	
	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
		String[] ele = {"1", "2", "null", "3", "null", "4"};
		Tree tree = new Tree(ele);
		System.out.println(minDepth(tree.root));
	}

}
