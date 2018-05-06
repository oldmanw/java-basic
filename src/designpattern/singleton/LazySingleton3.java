package designpattern.singleton;

import java.io.Serializable;

/**
 * author:oldmanw
 * create at:2018-05-06 10:20
 * 避免反射破坏单例性，但不能避免在序列化和反序列化破坏单例性
 */
public class LazySingleton3 implements Serializable {

    private static boolean initialized = false;

    private LazySingleton3() {
        synchronized (LazySingleton3.class) {
            if (initialized == false) {
                initialized = true;
            } else {
                throw new RuntimeException("Singleton is corrupted!");
            }
        }
    }

    static class SingletonHolder {
        private static LazySingleton3 instance = new LazySingleton3();
    }

    public static LazySingleton3 getInstance() {
        return SingletonHolder.instance;
    }

}
