package designpattern.factorypattern;

/**
 * author:oldmanw
 * create at:2018-04-26 9:25
 */
public class Factory extends Afactory {

    @Override
    public <T extends Iproduct> T create(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
