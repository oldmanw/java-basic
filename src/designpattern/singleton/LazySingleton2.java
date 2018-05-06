package designpattern.singleton;

/**
 * author:oldmanw
 * create at:2018-05-06 9:54
 * 使用静态内部类的单例模式
 */
public class LazySingleton2 {

    private LazySingleton2() {}

    static class SingletonHolder {
        private static LazySingleton2 instance = new LazySingleton2();
    }

    public static LazySingleton2 getInstance() {
        return SingletonHolder.instance;
    }

}
