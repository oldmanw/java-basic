package algorithms;

public class StringToInt {
    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int i = 0, n = str.length(), sign = 1;
        while (i < n && Character.isWhitespace(str.charAt(i))) i++;
        if (i >= n) return 0;
        else if (str.charAt(i) == '+') i++;
        else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (!Character.isDigit(str.charAt(i))) return 0;

        int res = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (sign == 1) {
                if (res > maxDiv10 || (res == maxDiv10 && digit >= 8)) return 0;
            } else {
                if (res > maxDiv10 || (res == maxDiv10 && digit > 8)) return 0;
            }
            res = res * 10 + digit;
            i++;
        }
        return i == n ? sign * res : 0;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInt().strToInt("2147483647"));
    }
}
