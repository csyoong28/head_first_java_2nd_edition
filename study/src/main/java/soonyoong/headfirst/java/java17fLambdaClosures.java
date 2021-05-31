package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.function.Consumer;

public class java17fLambdaClosures {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;		//this b is the closures. it will freeze the value 
		doProcess(a, (i) ->System.out.println(i + b));
	}

	private static void doProcess(int a, Process p) {
		p.process(a);		
	}
	
	
}

interface Process {
	void process(int i);
}
