package algorithms;

public class HouseRobber198 {
	
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return helper(nums, 0);
    }
    
    private int helper(int[] nums, int start) {
        if (start == nums.length) return 0;
        if (start == nums.length - 1) return nums[nums.length - 1];
        if (start == nums.length - 2) return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        return Math.max(nums[start] + helper(nums, start + 2), nums[start + 1] + helper(nums, start + 3));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 10, 3};
		System.out.println(new HouseRobber198().rob(nums));
	}

}
