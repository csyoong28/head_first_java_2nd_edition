
package soonyoong.headfirst.java;
/*
 * test for javadoc by chia
 */
public class java1Array {

	private int height = -15;

	public static void main(String[] args) {
		java1Array java1Assert1 = new java1Array();
		java1Assert1.usingBuiltInArray();
	}
	
	public void usingBuiltInArray() {
	    int[] nums = {1,2,3,4};
	    nums[4] = 5;   //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
	    System.out.println(nums);	            
	}

}
