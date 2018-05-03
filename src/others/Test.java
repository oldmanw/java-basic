package others;

import java.util.UUID;

public class Test {
    
    public static void main(String[] args) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(id);
        System.out.println(id.length());
    }

}

