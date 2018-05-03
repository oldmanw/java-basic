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
		System.out.println("助手为小明买好了饭！");
		Object result = method.invoke(target, args);
		System.out.println("小明吃饱了！");
		return result;
	}
	
}
