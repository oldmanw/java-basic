package designpattern.singleton;

/**
 * author:oldmanw
 * create at:2018-05-06 9:38
 * 饿汉式单例模式
 */
public class HungrySingleton {

    private static volatile HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }

}
