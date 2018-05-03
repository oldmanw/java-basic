package algorithms;

public class NthUglyNumber264 {
	
	public int nthUglyNumber(int n) {
        if (n < 1) throw new IllegalArgumentException("Invalid input!");        
        int t2 = 0, t3 = 0, t5 = 0;
        int[] DP = new int[n];
        DP[0] = 1;
        
        for (int i = 1; i < n; i++) {
        	DP[i] = Math.min(DP[t2] * 2, Math.min(DP[t3] * 3, DP[t5] * 5));
        	if (DP[i] == DP[t2] * 2) t2++;
        	if (DP[i] == DP[t3] * 3) t3++;
        	if (DP[i] == DP[t5] * 5) t5++;
        }
        
        return DP[n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NthUglyNumber264().nthUglyNumber(11));
	}

}
