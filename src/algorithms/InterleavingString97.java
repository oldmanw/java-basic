package algorithms;

public class InterleavingString97 {
	
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        return DFS(s1, s2, s3, 0, 0, 0);
    }
    
    private boolean DFS(String s1, String s2, String s3, int i1, int i2, int i3) {
    	if (i3 == s3.length()) return true;
    	if (i1 == s1.length()) {
    		return s3.charAt(i3) == s2.charAt(i2) ? DFS(s1, s2, s3, i1, i2 + 1, i3 + 1) : false;
    	}
    	if (i2 == s2.length()) {
    		return s3.charAt(i3) == s1.charAt(i1) ? DFS(s1, s2, s3, i1 + 1, i2, i3 + 1) : false;
    	}
        if (s3.charAt(i3) != s1.charAt(i1) && s3.charAt(i3) != s2.charAt(i2)) return false;
        else if (s3.charAt(i3) == s1.charAt(i1) && s3.charAt(i3) != s2.charAt(i2)) {
        	return DFS(s1, s2, s3, i1 + 1, i2, i3 + 1);
        }
        else if (s3.charAt(i3) == s2.charAt(i2) && s3.charAt(i3) != s1.charAt(i1)) {
        	return DFS(s1, s2, s3, i1, i2 + 1, i3 + 1);
        } else {
            return DFS(s1, s2, s3, i1 + 1, i2, i3 + 1) || DFS(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(new InterleavingString97().isInterleave(s1, s2, s3));
	}

}
