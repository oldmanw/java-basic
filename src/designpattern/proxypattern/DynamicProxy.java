package designpattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	Object target;
	
	public Object bind (Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		System.out.println("����ΪС������˷���");
		Object result = method.invoke(target, args);
		System.out.println("С���Ա��ˣ�");
		return result;
	}
	
}
