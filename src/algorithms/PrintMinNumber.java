package algorithms;

import java.util.ArrayList;
import java.util.Collections;

/**
 * author:oldmanw
 * create at:2018-04-22 14:59
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class PrintMinNumber {

    private String print(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        Collections.sort(list, (Integer i1, Integer i2) ->
                (String.valueOf(i1) + String.valueOf(i2)).compareTo(String.valueOf(i2) + String.valueOf(i1)));
        for (int num : list) res.append(String.valueOf(num));
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        PrintMinNumber printMinNumber = new PrintMinNumber();
        System.out.println(printMinNumber.print(nums));
    }

}
