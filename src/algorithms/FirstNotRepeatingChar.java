package algorithms;

import java.util.HashMap;

/**
 * author:oldmanw
 * create at:2018-04-22 10:56
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class FirstNotRepeatingChar {

    private int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "abcacdes";
        FirstNotRepeatingChar notRepeatingChar = new FirstNotRepeatingChar();
        System.out.println(notRepeatingChar.firstNotRepeatingChar(str));
    }

}
