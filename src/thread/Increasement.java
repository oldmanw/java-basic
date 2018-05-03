package thread;

public class Increasement {
	
	static int num = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int j = 0; j < 10; j++) {
//			new Thread(new Runnable() {
//				public void run() {
//					System.out.println(Thread.currentThread().getName() + " started!");
//					try {
//						for (int i = 0; i < 100; i++) {
//							num++;
//							Thread.sleep(1);
//						}
//					} catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}).start();

			//lambda expression
			new Thread( () -> {
				System.out.println(Thread.currentThread().getName() + " started!");
					try {
						for (int i = 0; i < 100; i++) {
							num++;
							Thread.sleep(1);
						}
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
			}).start();
		}
		
		try {
			Thread.sleep(1000);
			System.out.println(num);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
