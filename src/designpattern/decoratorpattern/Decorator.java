package designpattern.decoratorpattern;

public abstract class Decorator extends Component {
	Component component;
	
	public Decorator (Component component) {
		this.component = component;
	}
	
	@Override
	public void operate() {
		this.component.operate();
	}
}
