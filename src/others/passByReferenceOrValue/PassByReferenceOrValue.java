package others.passByReferenceOrValue;

/**
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-09-12 1.0
 */
public class PassByReferenceOrValue {

    public static void main(String[] args) {
        Dog dog = new Dog("a");
        System.out.println("The first dog is: " + dog.toString());
        func(dog);
        System.out.println("Dog after func is: " + dog.toString());
        System.out.println(dog.getName());
    }

    private static void func(Dog dog) {
//        System.out.println("In func, the origin dog is: " + dog.toString());
//        dog = new Dog("b");
//        System.out.println("In func, the new dog is : " + dog.toString());
//        System.out.println(dog.getName());
        dog.setName("b");
    }

}
