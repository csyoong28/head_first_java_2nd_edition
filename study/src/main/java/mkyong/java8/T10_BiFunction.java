package mkyong.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class T10_BiFunction {
	public static void main(String[] args) {
		//bifunctionDemo();
		bifunctionChainFunction();
	}

	public static void bifunctionDemo() {
		// takes two Integers and return an Integer
		BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
		Integer result = func.apply(2, 3);
		System.out.println(result); // 5

		// take two Integers and return an Double
		BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);
		Double result2 = func2.apply(2, 4);
		System.out.println(result2); // 16.0

		// take two Integers and return a List<Integer>
		BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);
		List<Integer> result3 = func3.apply(2, 3);
		System.out.println(result3);
	}
	
	
	public static void bifunctionChainFunction() {
        String result = powToString(2, 4,
                (a1, a2) -> Math.pow(a1, a2),
                (r) -> "Result : " + String.valueOf(r));
        System.out.println(result); // Result : 16.0
	}
	public static <R> R powToString(Integer a1, Integer a2, BiFunction<Integer, Integer, Double> func,
			Function<Double, R> func2) {
		return func.andThen(func2).apply(a1, a2);
	}
	
	
	
	public static void bifunctionGenericWay() {
		// Take two Integers, pow it into a Double, convert Double into a String.
		String result = convert(2, 4, (a1, a2) -> Math.pow(a1, a2), (r) -> "Pow : " + String.valueOf(r));
		System.out.println(result); // Pow : 16.0

		// Take two Integers, multiply into an Integer, convert Integer into a String.
		String result2 = convert(2, 4, (a1, a2) -> a1 * a1, (r) -> "Multiply : " + String.valueOf(r));
		System.out.println(result2); // Multiply : 4

		// Take two Strings, join both, join "cde"
		String result3 = convert("a", "b", (a1, a2) -> a1 + a2, (r) -> r + "cde"); // abcde
		System.out.println(result3);

		// Take two Strings, join both, convert it into an Integer
		Integer result4 = convert("100", "200", (a1, a2) -> a1 + a2, (r) -> Integer.valueOf(r));
		System.out.println(result4); // 100200
	}
	public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> func, Function<R1, R2> func2) {
		return func.andThen(func2).apply(a1, a2);
	}
	
	public static void useBiFunction() {
	    Map<String, Integer> salaries = new HashMap<>();
	    salaries.put("John", 40000);
	    salaries.put("Freddy", 30000);
	    salaries.put("Samuel", 50000);

	    salaries.replaceAll((name, oldValue) -> 
	      name.equals("Freddy") ? oldValue : oldValue + 10000);
	}
	
	
}
