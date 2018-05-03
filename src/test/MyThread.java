package test;

public class MyThread extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t=new MyThread();
        MyThread s=new MyThread();
        t.start();
        System.out.println("one.");
        s.start();
        System.out.println("two.");
	}
	public void run() {
        System.out.println("Thread");
    }
}
