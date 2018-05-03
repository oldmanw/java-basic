package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * author:oldmanw
 * create at:2018-04-21 14:10
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class MaxInWindow {

    public ArrayList<Integer> max(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0 || nums == null || nums.length == 0) return res;
        Deque<Integer> deque = new LinkedList<>();
        return res;
    }

    public static void main(String[] args) {
        MaxInWindow maxInWindow = new MaxInWindow();

    }

}
