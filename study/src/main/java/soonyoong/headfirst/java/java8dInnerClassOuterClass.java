package soonyoong.headfirst.java;

class java8dInnerClassOuterClass {
	private int x;
	MyInner inner = new MyInner();

	public void doStuff() {
		inner.go();
	}

	class MyInner {
		void go() {
			x = 42;
		}
	} // close inner class
}