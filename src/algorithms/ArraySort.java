package algorithms;

/**
 * author:oldmanw
 * create at:2018-05-01 10:36
 * 对任何实现了Comparable接口的数组进行排序
 */
public class ArraySort {

    /**
     * 公共方法,判断两个值的大小
     * @param a 值a
     * @param b 值b
     * @return a是否小于b,小于返回true,大于等于返回false
     */
    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    /**
     * 公共方法,判断两个值的大小
     * @param a 值a
     * @param b 值b
     * @return a是否大于b,大于返回true,小于等于返回false
     */
    private static boolean more(Comparable a, Comparable b) {
        return (a.compareTo(b) > 0);
    }

    /**
     * 公共方法,交换两个值
     * @param nums 数组
     * @param i 第一个值的下标
     * @param j 第二个值的下标
     */
    private static void swap(Comparable[] nums, int i, int j) {
        Comparable temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 选择排序
     * @param nums 数组
     */
    public static void selectionSort(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (less(nums[j], nums[min])) min = j;
            }
            swap(nums, i, min);
        }
    }

    /**
     * 冒泡排序
     * @param nums 数组
     */
    public static void bubbleSort(Comparable[] nums) {
        for (int length = nums.length; length > 1; length--) {
            for (int i = 0; i < length - 1; i++) {
                if (more(nums[i], nums[i + 1])) swap(nums, i, i + 1);
            }
        }
    }

    /**
     * 插入排序
     * @param nums 数组
     */
    public static void insertionSort(Comparable[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(nums[j], nums[j - 1])) swap(nums, j, j - 1);
            }
        }
    }

    /**
     * 希尔排序
     * @param nums 数组
     */
    public static void shellSort(Comparable[] nums) {
        int h = 1;
        while (h < nums.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(nums[j], nums[j - h])) swap(nums, j, j - h);
                }
            }
        }
    }

    /**
     * 归并排序需要的辅助数组
     */
    private static Comparable[] mergeArray;

    /**
     * 归并排序
     * @param nums 数组
     */
    public static void mergeSort(Comparable[] nums) {
        mergeArray = new Comparable[nums.length];
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序的递归
     * @param nums 数组
     * @param start 开始下标
     * @param end 结束下标
     */
    private static void mergeSortHelper(Comparable[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSortHelper(nums, start, mid);
        mergeSortHelper(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    /**
     * 归并排序的归并
     * @param nums 数组
     * @param start 开始下标
     * @param mid 中间下标
     * @param end 结束下标
     */
    private static void merge(Comparable[] nums, int start, int mid, int end) {
        int i = start, j = mid + 1;
        //复制数组
        for (int k = start; k <= end; k++) mergeArray[k] = nums[k];
//        System.arraycopy(nums, start, mergeArray, start, end - start + 1);
        for (int k = start; k <= end; k++) {
            if      (i > mid)                nums[k] = mergeArray[j++];
            else if (j > end)                nums[k] = mergeArray[i++];
            else if (less(nums[i], nums[j])) nums[k] = mergeArray[i++];
            else                             nums[k] = mergeArray[j++];
        }
    }

    /**
     * 堆排序
     * @param nums 数组
     */
    public static void heapSort(Comparable[] nums) {
        int length = nums.length - 1;
        //构造大顶堆
        for (int k = (length - 1) / 2; k >= 0; k--) exchange(nums, k, length);
        while (length > 0) {
            swap(nums, 0, length--);
            exchange(nums, 0, length);
        }
    }

    private static void exchange(Comparable[] nums, int k, int length) {
        while (2 * k + 1 <= length) {
            int j = 2 * k + 1;
            //找到三个数中最大的数
            if (j < length && less(nums[j], nums[j + 1])) j++;
            if (!less(nums[k], nums[j])) break;
            swap(nums, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {6,5,7,3,2,1,4,9,12,2};
        ArraySort.heapSort(nums);
        for (int num : nums) System.out.print(num + " ");
    }

}
