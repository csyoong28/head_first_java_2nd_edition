package soonyoong.headfirst.java;

public class java4static {
	final static int x;
	
	//static initializer below will init wen class is loaded
	static {
		x = 42;
	}
	
	public static void main(String[] args) {
		System.out.println(x);
	}
}
