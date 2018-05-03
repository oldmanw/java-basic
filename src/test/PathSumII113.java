package test;

import java.util.ArrayList;

import java.util.List;

public class PathSumII113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        List<Integer> list=new ArrayList<>();
        backtrack(res, list, root, sum);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> list, TreeNode node, int num) {
        if (node.left==null&&node.right==null&&num!=node.val) return;
        if (node.left==null&&node.right==null&&num==node.val) {
            list.add(node.val);
            res.add(new ArrayList<>(list));
        }
        if (node.left!=null||node.right!=null) list.add(node.val);
        if (node.left!=null) backtrack(res, list, node.left, num-node.val);
        if (node.right!=null) backtrack(res,list, node.right, num-node.val);
        list.remove(list.size()-1);
        /*if (node==null&&num!=0) return;
        if (node==null&&num==0) res.add(new ArrayList<>(list));
        if (node!=null) {
            list.add(node.val);
            backtrack(res, list, node.left, num-node.val);
            backtrack(res,list, node.right, num-node.val);
        }
        if (list.size()>0) list.remove(list.size()-1);*/
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
		root.right.right.left=new TreeNode(5);
		root.right.right.right=new TreeNode(1);
		PathSumII113 test=new PathSumII113();
		System.out.println(test.pathSum(root, 22));
	}

}
