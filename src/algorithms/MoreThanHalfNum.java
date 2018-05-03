package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * author:oldmanw
 * create at:2018-04-22 14:07
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class MoreThanHalfNum {

    private int more(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                if (map.get(num) > nums.length / 2) return num;
            } else {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > nums.length / 2) return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,2,5,4,2};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
        System.out.println(moreThanHalfNum.more(nums));
    }

}
