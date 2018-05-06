package designpattern.singleton;

/**
 * author:oldmanw
 * create at:2018-05-06 10:26
 * 在序列化和反序列化之后仍然保持单例
 */
public class LazySingleton4 {

    private static boolean initialized = false;

    private LazySingleton4() {
        synchronized (LazySingleton3.class) {
            if (initialized == false) {
                initialized = true;
            } else {
                throw new RuntimeException("Singleton is corrupted!");
            }
        }
    }

    static class SingletonHolder {
        private static LazySingleton4 instance = new LazySingleton4();
    }

    public static LazySingleton4 getInstance() {
        return LazySingleton4.SingletonHolder.instance;
    }

    //增加
    private Object readResolve() {
        return getInstance();
    }

}
