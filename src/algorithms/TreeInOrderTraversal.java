package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * author:oldmanw
 * create at:2018-05-06 17:28
 */
public class TreeInOrderTraversal {

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (!stack.isEmpty()) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

}
