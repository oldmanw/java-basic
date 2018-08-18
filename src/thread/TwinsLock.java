package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 允许最多两个线程同时访问的同步器，来自《Java并发编程的艺术》
 *
 * @author Wang Rui (wangrui31@baidu.com)
 * @since 2018-08-12 1.0
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {

        Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count must be larger than 0!");
            }
            setState(count);
        }

        public int tryAcquireShared(int reduceCount) {
            for (; ; ) {
                int currentCount = getState();
                int newCount = currentCount - reduceCount;
                if (newCount < 0 || compareAndSetState(currentCount, newCount)) {
                    return newCount;
                }
            }
        }

        public boolean tryReleaseShared(int returnCount) {
            for (; ; ) {
                int currentCount = getState();
                int newCount = currentCount + returnCount;
                if (compareAndSetState(currentCount, newCount)) {
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
