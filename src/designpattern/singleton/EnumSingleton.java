package designpattern.singleton;

/**
 * author:oldmanw
 * create at:2018-05-06 10:56
 */
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("do it!");
    }
}
