package algorithms;

public class GetNumberOfTraget {
    public int getNumberOfK(int [] array , int target) {
        if (array == null || array.length == 0 || target < array[0] || target > array[array.length - 1]) return 0;
        int i = 0, j = array.length - 1, res = 0;
        while (i <= j) {
            int k = i + (j - i) / 2;
            if (array[k] == target) {
                res++;
                int start = k - 1, end = k + 1;
                while (start >= 0 && array[start] == target) {
                    res++;
                    start--;
                }
                while (end < array.length && array[end] == target) {
                    res++;
                    end++;
                }
                break;
            }
            else if (array[k] > target) j = k - 1;
            else i = k + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,7,7,8};
        System.out.println(new GetNumberOfTraget().getNumberOfK(nums, 7));
    }
}
