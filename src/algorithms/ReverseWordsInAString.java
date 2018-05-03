package algorithms;

public class ReverseWordsInAString {
	
	public static String reverse(String str) {
		if (str == null || str.length() == 0) return str;
		if (str.trim().length() == 0) return "";
		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i > 0; i--) {
			if (words[i].length() != 0) sb.append(words[i] + " ");
		}
		sb.append(words[0]);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("  a b  23131    c  "));
	}

}
