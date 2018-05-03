package algorithms;

public class NthSuperUglyNumber313 {
	
	public int nthSuperUglyNumber(int n, int[] primes) {
        if (n < 1) throw new IllegalArgumentException("Invalid input!");
        int[] DP = new int[n];
        int[] flags = new int[primes.length];
        DP[0] = 1;
        for (int i = 1; i < n; i++) {
            DP[i] = small(DP, flags, primes);
            for (int j = 0; j < flags.length; j++) {
                if (DP[i] == DP[flags[j]] * primes[j]) flags[j]++;
            }
        }
        return DP[n - 1];
    }
    
    private int small(int[] DP, int[] flags, int[] primes) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < flags.length; i++) res = Math.min(res, DP[flags[i]] * primes[i]);
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] primes = {2,3,5};
		System.out.println(new NthSuperUglyNumber313().nthSuperUglyNumber(11, primes));
	}

}
