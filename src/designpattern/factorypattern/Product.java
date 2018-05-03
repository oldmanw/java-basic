package designpattern.factorypattern;

/**
 * author:oldmanw
 * create at:2018-04-26 9:21
 */
public class Product implements Iproduct {

    @Override
    public void say() {
        System.out.println("Hello");
    }
}
