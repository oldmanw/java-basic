package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:oldmanw
 * create at:2018-04-22 21:50
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Thread(() -> {
                System.out.println("hehe");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
