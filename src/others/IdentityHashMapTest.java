package others;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 测试IdentityHashMap的特性
 *
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-08-18 1.0
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new IdentityHashMap<>();
        map.put(1, "first 1");
        // 由于Integer的特性，在-128到127之间的数使用同一个对象，第二个1会覆盖掉第一个1
        map.put(1, "second 1");
        map.put(-129, "first -129");
        map.put(-129, "second -129");
        System.out.println("Size of the map is " + map.size());
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value: " + entry.getValue());
        }
    }

}
