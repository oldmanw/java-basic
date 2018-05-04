package algorithms;

import java.util.LinkedList;

/**
 * author:oldmanw
 * create at:2018-05-01 10:36
 * 对任何实现了Comparable接口的数组进行排序
 */
public class ArraySort {

    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    private static boolean more(Comparable a, Comparable b) {
        return (a.compareTo(b) > 0);
    }

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
     * 目前有一些奇怪的问题。。。
     * @param nums 数组
     */
    @Deprecated
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
            if      (i > mid)                 nums[k] = mergeArray[j++];
            else if (j > end)                 nums[k] = mergeArray[i++];
            else if (!more(nums[i], nums[j])) nums[k] = mergeArray[i++];
            else                              nums[k] = mergeArray[j++];
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

    /**
     * 快速排序的递归版本
     * @param nums
     */
    public static void quickSort(Comparable[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortHelper(Comparable[] nums, int start, int end) {
        if (start >= end) return;
        int index = partition(nums, start, end);
        quickSortHelper(nums, start, index - 1);
        quickSortHelper(nums, index + 1, end);
    }

    private static int partition(Comparable[] nums, int start, int end) {
        int i = start, j = end;
        while (true) {
            while (i < end && !more(nums[i], nums[start])) i++;
            while (j > start && !less(nums[j], nums[start])) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    /**
     * 快速排序的非递归版本,当recursive为false时执行
     * @param nums 数组
     */
    public static void nonRecQuikSort(Comparable[] nums) {
            quickSortNonRecursiveHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortNonRecursiveHelper(Comparable[] nums, int start, int end) {
        LinkedList<Integer> stack = new LinkedList<>();
        //先压入右侧边界，再压入左侧边界
        stack.push(end);
        stack.push(start);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            int index = partition(nums, left, right);
            if (left < index - 1) {
                stack.push(index - 1);
                stack.push(left);
            }
            if (right > index + 1) {
                stack.push(right);
                stack.push(index + 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {6,5,7,3,2,1,4,9,12,2};
        ArraySort.nonRecQuikSort(nums);
        for (int num : nums) System.out.print(num + " ");
    }

}
