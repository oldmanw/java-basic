package designpattern.proxypattern;

public class Client {

	public static void main(String[] args) {
		//static proxy pattern
		Eat xiaoming = new XiaoMing();
		StaticProxy proxy = new StaticProxy(xiaoming);

		proxy.eat();
		
		//dynamic proxy pattern
//		DynamicProxy dynamicProxy = new DynamicProxy();
//		Eat xiaoming = (Eat) dynamicProxy.bind(new XiaoMing());
//
//		xiaoming.eat();
	}

}
