package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author:oldmanw
 * create at:2018-05-06 20:40
 */
public class TreeLevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null) return res;

        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> temp=new LinkedList<>();
            for (int i=0; i<levelSize; i++){
                if (queue.peek().left!=null) queue.offer(queue.peek().left);
                if (queue.peek().right!=null) queue.offer(queue.peek().right);
                temp.add(queue.poll().val);
            }
            res.add(temp);
        }
        return res;
    }

}
