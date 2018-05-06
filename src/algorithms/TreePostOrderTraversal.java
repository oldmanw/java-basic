package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * author:oldmanw
 * create at:2018-05-06 17:44
 */
public class TreePostOrderTraversal {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

}
