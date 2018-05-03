package designpattern.proxypattern;

public class StaticProxy implements Eat {
	private Eat person;
	
	public StaticProxy(Eat eatImpl) {
		this.person = eatImpl;
	}

	@Override
	public void eat() {
		System.out.println("助手为小明买好了饭！");
		person.eat();
		System.out.println("小明吃饱了！");
	}
}
