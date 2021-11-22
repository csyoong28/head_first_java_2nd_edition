package mkyong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class T12_UnaryOperator {
	public static void main(String[] args) {
//		unaryOperatorAsArgument();
		unaryOperatorForReplaceAll();
	}

	public static void unaryOperatorAsArgument() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> result = math(list, x -> x * 2);
		System.out.println(result); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
	}

	public static <T> List<T> math(List<T> list, UnaryOperator<T> uo) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(uo.apply(t));
		}
		return result;
	}
	
	public static void unaryOperatorForReplaceAll() {
	    List<String> names = Arrays.asList("bob", "josh", "megan");
	    names.replaceAll(name -> name.toUpperCase());
	    System.out.println(names);
	}
}
