package algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfStream {

    private int count = 0;

    //小根堆存放大数部分
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //大根堆存放小数部分
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private void insert(int num) {
        if ((count & 1) == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    private double getMedian() {
        if ((count & 1) == 0) return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        else return (double) minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MedianOfStream medianOfStream = new MedianOfStream();
        while (in.hasNextInt()) {
            medianOfStream.insert(in.nextInt());
        }
        in.close();
        System.out.println(medianOfStream.getMedian());
    }

}
