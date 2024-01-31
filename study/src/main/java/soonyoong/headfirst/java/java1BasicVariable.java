
package soonyoong.headfirst.java;
/*
 * test for javadoc by chia
 */
public class java1BasicVariable {

	private double height = 15.2;
	private String breed; // instance variable can be decalred without initialize, will have default value

	public static void main(String[] args) {
		int x = 24;
	//	byte b = x; // can't put larger primitive into smaller primitive
		byte b1 = (byte) x; // but if cast, then ok

		byte c = 24;
		int y = c; // can put smaller primitive to larger primitive.

		// for array
		String[] wordListOne = { "24/7", "multi-Tier", "30,000 foot" };
		int[] nums = new int[7]; // length of array is 7
		nums[0] = 1;
		nums[1] = 5;
		
	//	int x =  0;
		int z = ++x; //end up x=1, z=1
		

	//	int x =  0;
	//	int z = x++; //end up x=1, z=0
		

	}

	public void go() {
		int x = 0;
		int z = x + 3;		//local variable cannot just declare, must initialize it.
	}
}
