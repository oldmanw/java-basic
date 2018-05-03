package designpattern.decoratorpattern;

public class ConcretDecorator1 extends Decorator {
	public ConcretDecorator1(Component component) {
		super(component);
	}
	
	private void method1() {
		System.out.println("method1");
	}
	
	@Override
	public void operate() {
		this.method1();
		super.operate();
	}
}
