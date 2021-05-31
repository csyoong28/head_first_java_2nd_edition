package soonyoong.headfirst.java;

import static java.lang.System.out;
import static java.lang.Math.*;

public class java5FormatNumber {
	public static void main(String[] args) {

		String s = String.format("%, d", 1000000000); // format decimal integer, insert comma
		System.out.println(s);
		String s2 = String.format("I have %.2f bugs to ﬁx.", 476578.09876);
		System.out.println(s2);
		
		
		out.println("sqrt " + sqrt(2.0));
	    out.println("tan " + tan(60));
	}
}
