package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.function.Consumer;

public class java17Lambda {
	public static void main(String[] args) {
		java17Lambda java17Lambda1 = new java17Lambda();
		//java17Lambda1.useCase3();
		
		MyLambda myLambdaFunction = () -> System.out.println("Hello World");
		MyDivide safeDivideFunction = (int a, int b) -> {
		    if (b==0) return 0;
		    return a/b;
		};
		myLambdaFunction.greet();
		
	}

	public void useCase1() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		numbers.forEach((n) -> {System.out.println(n);});
	}
	
	public void useCase2() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    Consumer<Integer> method = (n) -> { 
	    	System.out.println(n); 
	    	};
	    numbers.forEach( method );
	}
	
	public void useCase3() {
		StringFunction exclaim = (s) -> s + "!";
	    StringFunction ask = (s) -> s + "?";
	    printFormatted("Hello", exclaim);
	    printFormatted("Hello", ask);
	}
	
	public static void printFormatted(String str, StringFunction format) {
	    String result = format.run(str);
	    System.out.println(result);
	}
	interface StringFunction {
		  String run(String str);
	}
	
}

interface MyLambda {
	//declare a metod that has same signature with lambda expression
	//in this case is () -> System.out.println("Hello World");
	void greet();
}

interface MyDivide {
	int divideMethod(int a, int b);
}