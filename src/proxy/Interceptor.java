package proxy;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    public void before();

    public void after();

    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    public boolean useAround();

    public void afterReturning();

    public void afterThrowing();

}
