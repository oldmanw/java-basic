package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(4);
		list1.add(2);
		List<Integer> list2 = new ArrayList<>(list1);
		Collections.sort(list1, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		});
		Collections.sort(list2, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		System.out.println(list1);
		System.out.println(list2);
	}

}
