package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树和为某一值的路径
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-08-19 1.0
 */
public class FindPathOfBST {

    private static List<List<Integer>> findPath(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        recursion(res, new ArrayList<>(), root, target, 0);
        return res;
    }

    private static void recursion(List<List<Integer>> res, List<Integer> list, TreeNode node, int target, int sum) {
        list.add(node.val);
        sum += node.val;
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        if (node.left != null) {
            recursion(res, list, node.left, target, sum);
        }
        if (node.right != null) {
            recursion(res, list, node.right, target, sum);
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(12);

        List<List<Integer>> res = findPath(root, 22);
        if (!res.isEmpty()) {
            for (List<Integer> list : res) {
                System.out.println(list);
            }
        }
    }

}
