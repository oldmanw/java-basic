package others.Polymorphism;

/**
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-08-18 1.0
 */
public interface PersonFunction {

    default void basicMessage() {
        System.out.println("This is a person.");
    }

    void eat(Food food);

    String speak(String word);

    void run();

}
