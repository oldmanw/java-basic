package designpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * author:oldmanw
 * create at:2018-05-06 9:57
 */
public class Client {

    public static void main(String[] args) {
        //通过反射破坏LazySingleton2的单例特性
        LazySingleton2 instance1 = LazySingleton2.getInstance();

        LazySingleton2 instance2 = null;
        Class<LazySingleton2> clazz = LazySingleton2.class;
        try {
            Constructor<LazySingleton2> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1: " + instance1.hashCode());
        System.out.println("instance2: " + instance2.hashCode());

        //通过序列化和反序列化破坏LazySingleton3的单例特性
        LazySingleton3 instance3 = LazySingleton3.getInstance();
        try {
            //序列化
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("D:\\singletonSerialize.txt"));
            output.writeObject(instance3);
            output.close();

            //反序列化
            ObjectInput input = new ObjectInputStream(new FileInputStream("D:\\singletonSerialize.txt"));
            LazySingleton3 instance4 = (LazySingleton3) input.readObject();
            input.close();

            System.out.println("instance3: " + instance3.hashCode());
            System.out.println("instance4: " + instance4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //测试枚举单例
        EnumSingleton instance5 = EnumSingleton.INSTANCE;
        EnumSingleton instance6 = EnumSingleton.INSTANCE;
        System.out.println("instance5: " + instance5.hashCode());
        System.out.println("instance6: " + instance6.hashCode());
        //序列化反序列化枚举单例
        try {
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("D:\\EnumSingletonSerialize.txt"));
            output.writeObject(instance5);
            output.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("D:\\EnumSingletonSerialize.txt"));
            EnumSingleton instance7 = (EnumSingleton) input.readObject();
            input.close();

//            System.out.println("instance5: " + instance5.hashCode());
            System.out.println("instance7: " + instance7.hashCode());
            instance7.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
