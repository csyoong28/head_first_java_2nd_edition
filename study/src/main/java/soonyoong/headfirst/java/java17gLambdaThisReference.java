package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.function.Consumer;

public class java17gLambdaThisReference {
	public static void main(String[] args) {
		java17gLambdaThisReference thisObject = new java17gLambdaThisReference();
		thisObject.doProcess(10,  new Process() {
			@Override
			public void process(int i) {
				System.out.println("value of i is " + i);
				System.out.println(this.getClass() + "," + this);			//is print out inner class	
			}
			
		});
		System.out.println(thisObject.getClass() + "," + thisObject);	//is print out the enclosing class
		
		//when in lambda
		thisObject.doProcess(10, (i) -> {
			System.out.println("value of i is " + i);
		//	System.out.println(this.getClass() + "," + this);		//this reference, is same as it is outside the lambda, thus in this
			//example is incorrect because is in the main method
		});
	}

	private void doProcess(int i, Process p) {
		p.process(i);		
	}	
	
}
