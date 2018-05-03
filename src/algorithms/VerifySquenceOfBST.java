package algorithms;

/**
 * author:oldmanw
 * create at:2018-04-26 18:53
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] nums, int start, int root) {
        if (start >= root) return true;
        int i = root;
        while (i > start && nums[i - 1] > nums[root]) i--;
        for (int j = start; j < i; j++) {
            if (nums[j] > nums[root]) return false;
        }
        return helper(nums, start, i - 1) && helper(nums, i, root - 1);
    }

    public static void main(String[] args) {
        int[] nums = {4,8,6,12,16,14,10};
        System.out.println(new VerifySquenceOfBST().verifySquenceOfBST(nums));
    }

}
