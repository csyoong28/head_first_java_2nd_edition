package soonyoong.headfirst.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class java17cLambdaRunnableInterface {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		//step1: sort list by last name
		//java 7 is using Collections.sort and pass in comparator
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {				
				return o1.getLastName().compareTo(o2.getLastName());
			}			
		});
		//using lambda way
		Collections.sort(people, (p1, p2) ->p1.getLastName().compareTo(p2.getLastName()));
		
		//step2: create a method that prints all elements in the list
		printAll(people);
		//step3: create a method that prints all people that have last name beginning with C
		//java 7 is using interface way to be flexible
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("D");
			}			
		});
		
		//using java lambda way
		printConditionally(people, (p) -> p.getLastName().startsWith("C"));
		System.out.println("print using predicate");
		printConditionallyByPredicate(people, (p) -> p.getLastName().startsWith("C"));
		
		//additionally, to make the code even more flexible, 3rd argument is to control the action performed
		System.out.println("perform conditionally");
		performConditionally(people, (p) -> p.getLastName().startsWith("C"), (p) -> System.out.println(p.getFirstName()));
	}
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p: people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
		
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	private static void printConditionallyByPredicate(List<Person> people, Predicate<Person> predicate) {
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}

	private static void printAll(List<Person> people) {
		for (Person p: people) {
			System.out.println(p);
		}
	}
	
	

}

interface Condition {
	boolean test(Person p);
}
