package algorithms;

public class PathSum112 {
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null && sum == root.val) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
		String[] ele = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "null", "1"};
		Tree tree = new Tree(ele);
		System.out.println(new PathSum112().hasPathSum(tree.root, 22));
	}

}
