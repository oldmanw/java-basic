package designpattern.singleton;

/**
 * author:oldmanw
 * create at:2018-05-06 9:40
 * 懒汉式单例模式，分为基本型，synchronized型和DCL双重检查型
 */
public class LazySingleton1 {

    private static volatile LazySingleton1 instance;

    private LazySingleton1() {}


//    //基本型
//    public static LazySingleton1 getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton1();
//        }
//        return instance;
//    }


//    //synchronized型
//    public static synchronized LazySingleton1 getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton1();
//        }
//        return instance;
//    }

    //DCL型
    public static LazySingleton1 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton1.class) {
                if (instance == null) {
                    instance = new LazySingleton1();
                }
            }
        }
        return instance;
    }

}
