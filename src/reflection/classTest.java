package reflection;

import annotations.Idiot;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author:oldmanw
 * create at:2018-05-03 10:57
 */
public class classTest {

    static String className = "reflection.PojoClass";

    public static void main(String[] args) {
        try {
            //使用反射获得类的属性和方法
            Class c = Class.forName(className);
            Field[] publicFields = c.getFields();
            Field[] fields = c.getDeclaredFields();
            for (Field field : publicFields) System.out.print(field.getName() + " ");
            System.out.print('\n');
            for (Field field : fields) System.out.print(field.getName() + " ");
            System.out.print('\n');
            Method[] publicMethods = c.getMethods();
            Method[] methods = c.getDeclaredMethods();
            for (Method method : publicMethods) System.out.print(method.getName() + " ");
            System.out.print('\n');
            for (Method method : methods) System.out.print(method.getName() + " ");
            System.out.print('\n');

            //通过反射为属性赋值
            PojoClass pojoClass = (PojoClass) c.newInstance();
            Field sexField = c.getDeclaredField("sex");
            sexField.setAccessible(true);
            String sex = (String) sexField.get(pojoClass);
            System.out.println("current sex is " + sex);
            sexField.set(pojoClass, "female");
            sex = (String) sexField.get(pojoClass);
            System.out.println("new sex is " + sex);

            //通过反射获得注解
            Annotation[] annotations = c.getAnnotations();
            for (Annotation annotation : annotations) System.out.print(annotation.toString());
            System.out.print('\n');
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
