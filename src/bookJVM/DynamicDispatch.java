package bookJVM;

public class DynamicDispatch {
	static class Human {
		public void sayHello() {
			System.out.println("guy say hello!");
		}
	}
	
	static class  Man extends Human {
		@Override
		public void sayHello() {
			System.out.println("man say hello!");
		}
	}
	
	static class  Woman extends Human {
		@Override
		public void sayHello() {
			System.out.println("woman say hello!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human guy = new Human();
		Human man = new Man();
		Human woman = new Woman();
		guy.sayHello();
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
	}

}
