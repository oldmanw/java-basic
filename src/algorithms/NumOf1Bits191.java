package algorithms;

public class NumOf1Bits191 {
	
	public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) ++res;
            n = n >>> 1;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumOf1Bits191().hammingWeight(11));
	}

}
