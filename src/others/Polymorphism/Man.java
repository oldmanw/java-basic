package others.Polymorphism;

/**
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-08-18 1.0
 */
public class Man extends Person implements PersonFunction {

    @Override
    public String sex() {
        return "Male";
    }

    @Override
    public Integer age() {
        return null;
    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public String speak(String word) {
        return word;
    }

    @Override
    public void run() {

    }
}
