package soonyoong.headfirst.java;

public class java12aThreadTest {
	public static void main(String[] args) {
		Runnable threadJob = new java12Runnable();
		Thread myThread = new Thread(threadJob);
		myThread.start();
		System.out.println("back in main");
	}
}
