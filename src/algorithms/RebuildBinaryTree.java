package algorithms;

public class RebuildBinaryTree {

    public TreeNode rebuild(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) return null;
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode helper(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        TreeNode node = new TreeNode(pre[pStart]);
        int index = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (in[i] == node.val) index = i;
        }
        node.left = helper(pre, pStart + 1, pStart + index - iStart, in, iStart, index - 1);
        node.right = helper(pre, pStart + index - iStart + 1, pEnd, in, index + 1, iEnd);
        return node;
    }

    public static void main(String[] args) {
        RebuildBinaryTree rebuildBinaryTree = new RebuildBinaryTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(rebuildBinaryTree.rebuild(pre, in));
    }

}
