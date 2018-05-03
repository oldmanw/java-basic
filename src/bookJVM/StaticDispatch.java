package bookJVM;


public class StaticDispatch {
	static abstract class Human {
		
	}
	
	static class Man extends Human {
		
	}
	
	static class Woman extends Human {
		
	}
	
	public void sayHello(Human guy) {
		System.out.println("hello, guy!");
	}
	
	public void sayHello(Man guy) {
		System.out.println("hello, gentleman!");
	}
	
	public void sayHello(Woman guy) {
		System.out.println("hello, lady!");
	}
	
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch sd = new StaticDispatch();
		sd.sayHello(man);
		sd.sayHello(woman);
		sd.sayHello((Man) man);
		sd.sayHello((Woman) woman);
	}
}
