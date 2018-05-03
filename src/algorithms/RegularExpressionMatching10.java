package algorithms;

public class RegularExpressionMatching10 {
	
	public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //initialize the first row
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') dp[0][i + 1] = dp[0][i - 1];
        }
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') dp[i + 1][j + 1] = dp[i][j];
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "", pattern = "aa*";
		System.out.println(new RegularExpressionMatching10().isMatch(str, pattern));
	}

}
