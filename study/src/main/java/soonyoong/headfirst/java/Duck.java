package soonyoong.headfirst.java;

public class Duck extends Animal {
	int size;
	
	//learn constructor
	public Duck(int newSize) {
		super(); // the compiler automatically put this super() in if you don't. is always the no-arg onstructor
		size = newSize;
		//super(); // if put here then can't even compile
	}
}
