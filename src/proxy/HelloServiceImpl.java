package proxy;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("name is null!");
        }
        System.out.println("hello, " + name + "!");
    }

}
