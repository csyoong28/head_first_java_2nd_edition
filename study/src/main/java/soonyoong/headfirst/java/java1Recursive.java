
package soonyoong.headfirst.java;
/*
 * test for javadoc by chia
 */
public class java1Recursive {

	public static void main(String[] args) {
		java1Recursive java1Assert1 = new java1Recursive();
		int result = sum(10);
	    System.out.println(result);

	}
	
	  public static int sum(int k) {
	      if (k > 0) {
	        return k + sum(k + 1);
	      } else {
	        return 0;
	      }
	    }


}
