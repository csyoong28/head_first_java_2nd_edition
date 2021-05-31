package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class java17hLambdaMethodRef {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> printMessage());
		thread.run();
		Thread thread2 = new Thread(java17hLambdaMethodRef::printMessage);	//this is method reference, is an alternate syntax
		thread2.run();
		
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		System.out.println("perform conditionally");
		performConditionally(people, (p) -> p.getLastName().startsWith("C"), (p) -> System.out.println(p.getFirstName()));
		System.out.println("perform conditionally by method reference");
		performConditionally(people, (p) -> p.getLastName().startsWith("C"), System.out::println); //to show method reference, out is an instance
	}

	private static void printMessage() {
		System.out.println("hello");		
	}	
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p: people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
		
	}
	
}
