package mkyong.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class T04_methodReference {
	public static void main(String[] args) {
//		methodReference();
//		staticMethodMethodReference();
		staticMethodMethodReference2();
	}

	public static void methodReference() {
		List<String> list = Arrays.asList("node", "java", "python", "ruby");
		list.forEach(str -> System.out.println(str)); // lambda
		list.forEach(System.out::println); // method references
	}

	public static void staticMethodMethodReference() {
		List<String> list = Arrays.asList("A", "B", "C");
		// lambda expression
		list.forEach(x -> SimplePrinter.print(x));
		// method reference
		list.forEach(SimplePrinter::print);
	}

	public static void staticMethodMethodReference2() {
		List<String> list = Arrays.asList("1", "2", "3");
		// lambda expression
		List<Integer> collect2 = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		// method reference
		List<Integer> collect3 = list.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

	public static void staticMethodMethodReference3() {
		// anonymous class
		String result1 = playTwoArgument(1, 2, new BiFunction<Integer, Integer, String>() {
			@Override
			public String apply(Integer a, Integer b) {
				return IntegerUtils.join(a, b);
			}
		}); // 3
		// lambda
		String result1Lambda = playTwoArgument(1, 2, (a, b) -> IntegerUtils.join(a, b)); // 3
		// method reference
		String result2 = playTwoArgument(1, 2, IntegerUtils::join); // 3
	}
	//a normal method, but it accept method and run it
	private static <R> R playTwoArgument(Integer i1, Integer i2, BiFunction<Integer, Integer, R> func) {
		return func.apply(i1, i2);
	}
}

class SimplePrinter {
	public static void print(String str) {
		System.out.println(str);
	}
}

class IntegerUtils {
	public static String join(Integer a, Integer b) {
		return String.valueOf(a + b);
	}
}