package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:oldmanw
 * create at:2018-05-03 17:25
 * 线程按照t1,t2,t3的顺序执行
 * 1.使用join，在t3中调用t2的join，在t2中调用t1的join
 * 2.使用newSingleThreadExecutor
 */
public class ExecuteOrder {

    private Thread t1 = new Thread(() ->
            System.out.println("t1 is running!")
    );

    private Thread t2 = new Thread(() ->
            System.out.println("t2 is running!")
    );

    private Thread t3 = new Thread(() ->
            System.out.println("t3 is running!")
    );

//    private Thread t2 = new Thread(() ->{
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("t2 is running!");
//    });
//
//    private Thread t3 = new Thread(() ->{
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("t3 is running!");
//    });

    public static void main(String[] args) {
        ExecuteOrder executeOrder = new ExecuteOrder();
        //使用join
//        executeOrder.t2.start();
//        executeOrder.t3.start();
//        executeOrder.t1.start();
        //使用newSingleThreadExecutor
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(executeOrder.t1);
        service.execute(executeOrder.t2);
        service.execute(executeOrder.t3);
    }

}
