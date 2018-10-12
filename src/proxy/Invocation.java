package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    /**
     * 通过反射调用target的方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object invoke() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }

}
