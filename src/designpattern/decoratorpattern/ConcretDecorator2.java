package designpattern.decoratorpattern;

public class ConcretDecorator2 extends Decorator {
	public ConcretDecorator2(Component component) {
		super(component);
	}
	
	private void method2() {
		System.out.println("method2");
	}
	
	@Override
	public void operate() {
		super.operate();
		this.method2();
	}
}
