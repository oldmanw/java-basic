package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author:oldmanw
 * create at:2018-04-22 20:40
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 1; i <= 15; i++) {
//            executor.execute(new MyThread(i));
            executor.execute(new Thread(new MyThread(i)));
            System.out.println("Number of threads in thread pool now is " + executor.getCorePoolSize() +
                                ", number of threads in queue is " + executor.getQueue().size() +
                                ", number of threads completed is " + executor.getCompletedTaskCount() + ".");
        }
        executor.shutdown();
    }

}

class MyThread implements Runnable {

    private int index;

    public MyThread(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Thread " + index + " is executing.");
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + index + " is done.");
    }
}
