package designpattern.factorypattern;

/**
 * author:oldmanw
 * create at:2018-04-26 9:22
 */
public abstract class Afactory {

    public abstract <T extends Iproduct> T create (Class<T> c);

}
