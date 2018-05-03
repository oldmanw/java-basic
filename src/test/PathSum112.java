package test;

import java.util.Stack;

public class PathSum112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root.left==null&&root.right==null&&sum==0) return true;
        if (root.left==null&&root.right==null&&sum!=0) return false;
        int temp=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (node!=null||!stack.empty()) {
            while (node!=null) {
                stack.push(node);
                temp+=node.val;
                node=node.left;
            }
            if (temp==sum) return true;
            node=stack.pop();
            temp-=node.val;
            node=node.right;
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(2);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.right.right.right=new TreeNode(1);
		PathSum112 res=new PathSum112();
		System.out.println(res.hasPathSum(root, 26));
	}

}
