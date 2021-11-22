package mkyong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class T15_Consumer {
	public static void main(String[] args) {
		consumerDemo();
	}
	
	public static void consumerDemo() {
		List<String> list = Arrays.asList("a", "ab", "abc");
		forEach(list, (String x) -> System.out.println(x.length()));
	}
	static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}

}

