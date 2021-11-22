package mkyong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class T13_Predicate {
	public static void main(String[] args) {
		//predicateDemo();
//		predicateAndDemo();
//		predicateNegateDemo();
//		predicateAsArgDemo();
		predicateChaining();
	}
	
	public static void predicateDemo() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        System.out.println(collect); // [6, 7, 8, 9, 10]
        
        Predicate<Integer> noGreaterThan5 =  x -> x > 5;
        List<Integer> collect2 = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());
        System.out.println(collect2); // [6, 7, 8, 9, 10]
	}
	
	public static void predicateAndDemo() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// multiple filters
		List<Integer> collect = list.stream().filter(x -> x > 5 && x < 8).collect(Collectors.toList());
		System.out.println(collect);

		Predicate<Integer> noGreaterThan5 = x -> x > 5;
		Predicate<Integer> noLessThan8 = x -> x < 8;
		List<Integer> collect2 = list.stream().filter(noGreaterThan5.and(noLessThan8))
				.collect(Collectors.toList());
		System.out.println(collect2);
	}
	
	public static void predicateNegateDemo() {
		Predicate<String> startWithA = x -> x.startsWith("A");
		List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
		List<String> collect = list.stream().filter(startWithA.negate()).collect(Collectors.toList());
		System.out.println(collect);
	}
	
	public static void predicateAsArgDemo() {
		List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
		System.out.println(StringProcessor.filter(list, x -> x.startsWith("A"))); // [A, AA, AAA]
		System.out.println(StringProcessor.filter(list, x -> x.startsWith("A") && x.length() == 3)); // [AAA]
	}
	
	public static void predicateChaining() {
        Predicate<String> startWithA = x -> x.startsWith("a");
        // start with "a" or "m"
        boolean result = startWithA.or(x -> x.startsWith("m")).test("mkyong");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);    // false
	}
}

class StringProcessor {
	static List<String> filter(List<String> list, Predicate<String> predicate) {
		return list.stream().filter(predicate::test).collect(Collectors.toList());
	}
}
