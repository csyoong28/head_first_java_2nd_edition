package soonyoong.headfirst.java;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java19Streams {
	public static void main(String args[]) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		//to loop through, usually is using for loop, for-in loop (the enhanced for loop), and a new way
		people.forEach((p) -> System.out.println(p));
		//if using stream, all collection now have stream. Imagine it as conveyor belt
		people.stream().filter((p) -> p.getLastName().startsWith("C")).forEach(p -> System.out.println(p));
		long count = people.stream().filter((p) -> p.getLastName().startsWith("C")).count();
		System.out.println(count);
		long countParallel = people.parallelStream().filter((p) -> p.getLastName().startsWith("C")).count();
		System.out.println(countParallel);
	}
}
