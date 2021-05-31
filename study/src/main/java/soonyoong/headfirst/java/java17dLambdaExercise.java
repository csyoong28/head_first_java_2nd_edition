package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.function.Consumer;

public class java17dLambdaExercise {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("printed inside runnable");
			}
		});
		thread.run();
		
		Thread myLambdaThread = new Thread(() -> System.out.println("printed inside Lambda runnable"));
		myLambdaThread.run();	
	}

}
