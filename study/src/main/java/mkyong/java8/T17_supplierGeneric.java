package mkyong.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class T17_supplierGeneric<T> {
	public static void main(String[] args) {
		T17_supplierGeneric<String> t17_supplierGeneric = new T17_supplierGeneric();
		List<String> list = t17_supplierGeneric.supplier().get();
	}

	public Supplier<List<T>> supplier() {
		// lambda
		// return () -> new ArrayList<>();
		// constructor reference
		return ArrayList::new;
	}
}
