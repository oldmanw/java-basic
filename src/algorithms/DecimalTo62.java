package algorithms;

/**
 * author:oldmanw
 * create at:2018-04-25 21:39
 * 实现10进制非负整数到62进制的转换
 */
public class DecimalTo62 {

    private static final char[] elements = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                                            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                                            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                                            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                                            'Y', 'Z'};

    private String decimalTo62(long num) {
        if (num < 0) throw new IllegalArgumentException("Input must be non-negative!");

        StringBuilder sb = new StringBuilder();
        if (num == 0) sb.append(elements[0]);
        long temp = num;
        while (temp > 0) {
            long remainder = temp % 62;
            sb.insert(0, elements[(int) remainder]);
            temp /= 62;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DecimalTo62 test = new DecimalTo62();
        long num = 1234567890000L;
        System.out.println(test.decimalTo62(num));
    }

}
