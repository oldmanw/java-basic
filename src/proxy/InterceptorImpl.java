package proxy;

import java.lang.reflect.InvocationTargetException;

public class InterceptorImpl implements Interceptor {

    @Override
    public void before() {
        System.out.println("before...");
    }

    @Override
    public void after() {
        System.out.println("after...");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("before around...");
        Object object = invocation.invoke();
        System.out.println("after around...");
        return object;
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public void afterReturning() {
        System.out.println("after returning...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throwing...");
    }
}
