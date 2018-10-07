package others.ComparableAndComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-08-19 1.0
 */
public class ComparableExample implements Comparable<ComparableExample> {

    private Integer num;

    public ComparableExample(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public int compareTo(ComparableExample example) {
        // 升序
//        return this.num - example.getNum();
        // 降序
        return example.getNum() - this.num;
    }

    public static void main(String[] args) {
        ComparableExample example1 = new ComparableExample(1);
        ComparableExample example2 = new ComparableExample(2);
        ComparableExample example3 = new ComparableExample(3);
        List<ComparableExample> list = Arrays.asList(example2, example3, example1);
        Collections.sort(list);
        for (ComparableExample example : list) {
            System.out.println(example.getNum());
        }
    }
}
