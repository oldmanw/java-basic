package algorithms;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static final int[] nums = {1,2,3};

    public static void main(String[] args) {
        nums[0] = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}  
