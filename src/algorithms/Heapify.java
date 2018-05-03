package algorithms;

public class Heapify {
	
	//wrong answer
	public void heapify(int[] nums) {
		if (nums == null || nums.length < 2) return;
		int length = nums.length;
		int i = length - 1;
		while ((i - 1) / 2 >= 0) {
			if (nums[i] < nums[(i - 1) / 2]) swap(nums, i, (i - 1) / 2);
			i--;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {45, 39, 32, 11};
		new Heapify().heapify(nums);
		for (int num : nums) System.out.print(num + " ");
	}

}
