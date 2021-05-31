package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.function.Consumer;

public class java17bLambdaTypeInference {
	public static void main(String[] args) {
		//the input parameter no need to tell type, can infer from interface 
		StringLengthLambda myLambda = (s) -> s.length();
		System.out.println(myLambda.getLength("Hello lambda"));
	}
	
	@FunctionalInterface
	interface StringLengthLambda {
		int getLength(String s);
	}
}
