package designpattern.prototypepattern;

/**
 * author:oldmanw
 * create at:2018-04-26 11:10
 */
public class Client {

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setAge(10);
        prototype.setName("XiaoMing");
        Prototype prototype1 = prototype.clone();
        System.out.println(prototype1.getAge());
        System.out.println(prototype1.getName());
    }

}
