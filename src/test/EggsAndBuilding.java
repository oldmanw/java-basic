package test;

public class EggsAndBuilding {
	
	public static int eggsAndBuilding(int eggs, int floors) {
		if (eggs <= 0 || floors <= 0) throw new IllegalArgumentException("Number of eggs and floors must be positive!");
		int[][] dp = new int[eggs][floors];
		for (int i = 0; i < eggs; i++) dp[i][0] = 1;
		for (int j = 0; j < floors; j++) dp[0][j] = j + 1;
		
		for (int i = 1; i < eggs; i++) {
			for (int j = 1; j < floors; j++) {
				int k = 1;
				dp[i][j] = Math.max(dp[i - 1][k - 1] + 1, dp[i][j - k] + 1);
				for (; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k - 1] + 1, dp[i][j - k] + 1));
				}
			}
		}
		return dp[eggs - 1][floors - 1] - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eggsAndBuilding(25, 900));
	}

}
