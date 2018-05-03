package others;

public class DiffBetween_equals_and_equal_sign {
	static String str1=new String("abc");
	static String str2=new String("abc");
	static String str3="def";
	static String str4="def";
	
	public static class SubClass {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(Integer.toHexString(System.identityHashCode(str1)));
		System.out.println(Integer.toHexString(System.identityHashCode(str2)));
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));
		System.out.println(Integer.toHexString(System.identityHashCode(str3)));
		System.out.println(Integer.toHexString(System.identityHashCode(str4)));
		SubClass sc1=new SubClass();
		SubClass sc2=new SubClass();
		System.out.println(sc1==sc2);
		System.out.println(sc1.equals(sc2));
		System.out.println(Integer.toHexString(System.identityHashCode(sc1)));
		System.out.println(Integer.toHexString(System.identityHashCode(sc2)));
	}
}
