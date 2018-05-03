package test;

public class SingletonTest {
	private static final SingletonTest singletonTest = new SingletonTest();
	private int num = 1;
	
	private SingletonTest() {
		
	}
	
	public static SingletonTest getInstance() {
		return singletonTest;
	}
	
	public int getNum() {
		return num++;
	}
}
