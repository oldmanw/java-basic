package proxy;

public class ProxyClient {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new InterceptorImpl());
        proxy.sayHello("oldmanw");
        System.out.println("\nif name is null:\n");
        proxy.sayHello(null);
    }

}
