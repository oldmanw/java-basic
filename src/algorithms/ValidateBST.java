package algorithms;

import test.TreeNode;
import test.MyException;
import test.Tree;

public class ValidateBST {
	//it's not correct!
	
	public static boolean validateBST(TreeNode node) {
		if (node == null) return true;
		if ((node.left != null && node.val < node.left.val) || (node.right != null && node.val > node.right.val)) 
			return false;
		return validateBST(node.left) && validateBST(node.right);
	}
	/*
	private static boolean recursion(TreeNode node) {
		if (node == null) return true;
		if ((node.left != null && node.val < node.left.val) || (node.right != null && node.val > node.right.val)) 
			return false;
		return recursion(node.left) && recursion(node.right);
	}
	*/
	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
		String[] elements = {"2", "1", "3"};
		Tree tree = new Tree(elements);
		System.out.println(validateBST(tree.root));
	}

}
