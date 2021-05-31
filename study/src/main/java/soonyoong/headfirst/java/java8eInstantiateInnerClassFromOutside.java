package soonyoong.headfirst.java;

public class java8eInstantiateInnerClassFromOutside {
	public static void main (String[] args) {
		java8dInnerClassOuterClass outerObj = new java8dInnerClassOuterClass();
		java8dInnerClassOuterClass.MyInner innerObj = outerObj.new MyInner();
     }
}
