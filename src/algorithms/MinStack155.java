package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack155 {
	
	Stack<Integer> stack;
	List<Integer> list;
	
	/** initialize your data structure here. */
    public MinStack155() {
        stack = new Stack<Integer>();
        list = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (list.isEmpty() || x > list.get(0)) list.add(x);
        else list.add(0, x);
    }
    
    public void pop() {
        int num = stack.pop();
        if (num == list.get(0)) list.remove(0);
        else list.remove(list.size() - 1);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return list.get(0);
    }

	public static void main(String[] args) {

	}

}
