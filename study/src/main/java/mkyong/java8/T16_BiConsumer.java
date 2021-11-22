package mkyong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class T16_BiConsumer {
	public static void main(String[] args) {
		biconsumerDemo();
	}

	public static void biconsumerDemo() {
		addTwo(1, 2, (x, y) -> System.out.println(x + y)); // 3
		addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js
	}

	static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
		c.accept(a1, a2);
	}
	
	//
	public static void biconsumerWithMapForEachDemo() {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "Java");
		map.put(2, "C++");
		map.put(3, "Rust");
		map.put(4, "JavaScript");
		map.put(5, "Go");
		map.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
