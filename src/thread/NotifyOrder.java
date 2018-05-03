package thread;

public class NotifyOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new notifyThread()).start();
		for (int i = 0; i < 10; i++) new Thread(new TestThread()).start();
	}
	
	private static class TestThread implements Runnable {
		@Override
		public void run() {
			System.out.println("Thread " + Thread.currentThread().getName() + " starts!");
			synchronized (NotifyOrder.class) {
				if (Thread.holdsLock(NotifyOrder.class)) {
					System.out.println("Thread " + Thread.currentThread().getName() + " holds the lock!");
					try {
						Thread.sleep(100);
						NotifyOrder.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//else System.out.println("Thread " + Thread.currentThread().getName() + " doesn't hold the lock!");
			}
			System.out.println("Thread " + Thread.currentThread().getName() + " ends!");
		}
	}
	
	private static class notifyThread implements Runnable {
		@Override
		public void run() {
			System.out.println("The notify thread starts!");
			synchronized (NotifyOrder.class) {
				if (Thread.holdsLock(NotifyOrder.class)) {
					System.out.println("The notify thread holds the lock and waiting for other threads!");
				}

//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}

				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(500);
						NotifyOrder.class.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
