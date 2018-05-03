package thread;

public class WaitNotifyTest {
	
	private static class Thread1 implements Runnable {
		@Override
		public void run() {
			synchronized (WaitNotifyTest.class) {
				System.out.println("thread1 starts");
				System.out.println("thread1 is waiting...");
				try {
					Thread.sleep(1000);
					WaitNotifyTest.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("thread1 is going on");
				System.out.println("thread1 is over");
			}
		}
	}
	
	private static class Thread2 implements Runnable {
		@Override
		public void run() {
			synchronized (WaitNotifyTest.class) {
				System.out.println("thread2 starts");
				System.out.println("thread2 is blocked...");
				WaitNotifyTest.class.notify();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread2 is going on");
				System.out.println("thread2 is over");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Thread1()).start();
		try {  
            Thread.sleep(10);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
		new Thread(new Thread2()).start();
	}

}
