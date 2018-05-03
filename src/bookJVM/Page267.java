package bookJVM;

public class Page267 {
	class GrandFather {
		void thinking() {
			System.out.println("i am grandfather");
		}
	}
	
	class Father extends GrandFather {
		void thinking() {
			System.out.println("i am father");
		}
	}
	
	class Son extends Father {
		void thinking() {
			//super.super.thinking();   //cannot access the method in superclass of superclass
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
