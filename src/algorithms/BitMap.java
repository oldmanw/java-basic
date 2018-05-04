package algorithms;

/**
 * author:oldmanw
 * create at:2018-05-03 22:11
 * 实现bitmap算法，用于判断海量整数中是否含有某一个整数(int类型)
 */
public class BitMap {

    private static final int _1MB = 1024 * 1024;

    private static byte[] flags = new byte[512 * _1MB];

    private static void setFlag(int num) {
        flags[num >>> 3] |= 0x01 << (num & 0x07);
    }

    private static boolean getFlag(int num) {
        return (flags[num >>> 3] >> (num & 0x07) & 0x01) == 1;
    }

    public static void main(String[] args) {

        //放入bitmap的整数
        int[] nums = {1,233,99999,2147483647,-100000,-2147483648};

        for (int num : nums) {
            setFlag(num);
        }

        System.out.println(getFlag(0));   //false
        System.out.println(getFlag(233));   //true
        System.out.println(getFlag(Integer.MAX_VALUE));   //true
        System.out.println(getFlag(Integer.MIN_VALUE));   //true
        System.out.println(getFlag(999));   //false

    }

}
