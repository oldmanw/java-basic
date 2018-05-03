package algorithms;

public class QuickSort {
	public void quickSort(int[] nums) {
		if (nums == null || nums.length == 0) {return;}
		sort(nums, 0 , nums.length - 1);
	}

	private void sort(int[] nums, int low, int high) {
		if (low >= high) {return;}
		int index = partition(nums, low, high);
		sort(nums, low, index - 1);
		sort(nums, index + 1, high);
	}

	private int partition(int[] nums, int low, int high) {
		int i = low, j = high;
		while (true) {
			while (i < high && nums[i] <= nums[low]) {i++;}
			while (j > low && nums[j] >= nums[low]) {j--;}
			if (i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, low, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,4,3,66,2,1};
		new QuickSort().quickSort(nums);
//		new QuickSort().quickSort(nums, 0, nums.length);
		for (int num : nums) {System.out.print(num + " ");}
		System.out.print('\n');
	}

}
