package thread;

/**
 * author:oldmanw
 * create at:2018-05-06 18:05
 */
public class JoinWithTimeTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "t1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            double d = 1.2d;
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread t1 is done, it's time for t2 to execute!");
            }
        });

        t2.start();

    }

}
