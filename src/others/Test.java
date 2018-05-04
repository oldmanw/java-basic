package others;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Test {
    
    public static void main(String[] args) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(id);
        System.out.println(id.length());

//        List<Integer> list = Arrays.asList(3,2,4,5,1);
        int[] nums = {3,2,4,5,1,1,2,3};
        //数组转换成list
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        //去重并过滤小于3的数,再把每个数乘2,再降序排序
        list = list.stream().distinct().filter(num -> num > 2).map(num -> num * 2)
                .sorted((Integer a, Integer b) -> b - a).collect(Collectors.toList());
        //降序排序
//        Collections.sort(list, (Integer a, Integer b) -> b - a);
        System.out.println(list);
    }

}

