package mkyong.java8;

import java.math.BigDecimal;
import java.time.LocalDate;
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

public class T17_supplier {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		//supplierDemo();
		factoryMethodDemo();
	}

	public static void supplierDemo() {
		Supplier<LocalDateTime> s = () -> LocalDateTime.now();
		LocalDateTime time = s.get();
		System.out.println(time);

		Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
		String time2 = s1.get();
		System.out.println(time2);
	}
	
	
	public static void factoryMethodDemo() {
		Developer obj = factory(Developer::new);
		System.out.println(obj);

		Developer obj2 = factory(() -> new Developer("mkyong"));
		System.out.println(obj2);
	}

	public static Developer factory(Supplier<? extends Developer> s) {
		Developer developer = s.get();
		if (developer.getName() == null || "".equals(developer.getName())) {
			developer.setName("default");
		}
		developer.setSalary(BigDecimal.ONE);
		return developer;
	}
	

}
