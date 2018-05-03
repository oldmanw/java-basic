package designpattern.proxypattern;

public class StaticProxy implements Eat {
	private Eat person;
	
	public StaticProxy(Eat eatImpl) {
		this.person = eatImpl;
	}

	@Override
	public void eat() {
		System.out.println("����ΪС������˷���");
		person.eat();
		System.out.println("С���Ա��ˣ�");
	}
}
