
package soonyoong.headfirst.java;
/*
 * test for javadoc by chia
 */
public class java1Assert {

	private int height = -15;

	public static void main(String[] args) {
		java1Assert java1Assert1 = new java1Assert();
		assert(java1Assert1.height > 0): "height = " + java1Assert1.height;
		System.out.println("the height is " + java1Assert1.height); 

	}

}
