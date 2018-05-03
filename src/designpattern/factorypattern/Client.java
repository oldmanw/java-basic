package designpattern.factorypattern;

/**
 * author:oldmanw
 * create at:2018-04-26 9:29
 */
public class Client {

    public static void main(String[] args) {
        Afactory factory = new Factory();
        Iproduct product = factory.create(Product.class);
        product.say();
    }

}
