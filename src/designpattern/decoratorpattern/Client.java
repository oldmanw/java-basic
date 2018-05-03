package designpattern.decoratorpattern;

public class Client {

	public static void main(String[] args) {
		Component component = new ConcretComponent();
		component = new ConcretDecorator1(component);
		component = new ConcretDecorator2(component);
		component.operate();
	}

}
