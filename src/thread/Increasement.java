package thread;

public class Increasement {

    private int i;

    public void increase() {
        i++;
    }

    public int getI() {
        return i;
    }

    public static void test(int threadNum, int loopTimes) {
        Increasement increasement = new Increasement();

        Thread[] threads = new Thread[threadNum];

        for (int i = 0; i < threads.length; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < loopTimes; i++) {
                        increasement.increase();
                    }
                }
            });
            threads[i] = t;
            t.start();
        }

        //main线程等待其他线程都执行完成
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(threadNum + " threads, result of " + loopTimes + " loops is " + increasement.getI());
    }

    public static void main(String[] args) {
        test(20, 1);
        test(20, 10);
        test(20, 100);
        test(20, 1000);
        test(20, 10000);
        test(20, 100000);
    }

}
