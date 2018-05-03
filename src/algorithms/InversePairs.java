package algorithms;

/**
 * author:oldmanw
 * create at:2018-04-22 11:53
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class InversePairs {

    private int res;
    private int[] temp;

    private int inversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return res % 1000000007;
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int k = start; k <= end; k++) temp[k] = nums[k];
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) nums[k] = temp[j++];
            else if (j > end) nums[k] = temp[i++];
            else if (temp[i] <= temp[j]) nums[k] = temp[i++];
            else {
                res += mid - i + 1;
                if (res >= 1000000007) {res %= 1000000007;}
                nums[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,0};
        InversePairs pairs = new InversePairs();
        System.out.println(pairs.inversePairs(nums));
    }

}
