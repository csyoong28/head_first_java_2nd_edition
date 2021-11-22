package mkyong.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class T07_Stream {
	public static void main(String[] args) throws IOException {
		//streamFilter();
//	    matchingStream();
//	    createStreamWithGenerate();
//	    createStreamWithIterate();
//	    createPrimitiveStream();
//	    createStringStream();
//	    createFileStream();
	    skipElementInStream();
//		streamFilterAnObject();
//		streamFilterAnObjectMultipleCondition();
//		streamFilterThenMap();
	}
	
	public static void createStream() {
	    String[] arr = new String[]{"a", "b", "c"};
	    Stream<String> stream = Arrays.stream(arr);
	    Stream<String> stream2 = Stream.of(arr);
	    Stream<String> stream3 = Stream.of("a", "b", "c");	 
	    Stream<String> streamEmpty = Stream.empty();
	    
	    List<String> list = new ArrayList<>();
	    Stream<String> stream4 = list.stream();
	}
	
	public static void createStreamWithBuilder() {
	    Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
	    Stream<Object> builderWithoutSpecifyType = Stream.builder().add("a").add("b").add("c").build();
	}
	
	public static void createStreamWithGenerate() {
	    Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
	    streamGenerated.forEach(System.out::println);
	}
	
	public static void createStreamWithIterate() {
	    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
	    streamIterated.forEach(System.out::println);
	}
	
	public static void createPrimitiveStream() {
	    IntStream intStream = IntStream.range(1, 3);   //1,2
	    LongStream longStream = LongStream.rangeClosed(1, 3);  //1,2,3
	    
	    intStream.forEach(System.out::println);
	    longStream.forEach(System.out::println);
	    
	    //random class generate stream
	    Random random = new Random();
	    DoubleStream doubleStream = random.doubles(3);
	    doubleStream.forEach(System.out::println);
	}
	
	public static void createStringStream() {
	    Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("axe, b, c");
	    streamOfString.forEach(System.out::println);
	}
	
	public static void createFileStream() throws IOException {
	    Path path = Paths.get("C:\\Users\\soonyoong.chia\\github\\head_first_java_2nd_edition\\study\\src\\main\\java\\com\\baeldung\\java_8_features\\file.txt");
	    Stream<String> streamOfStrings = Files.lines(path);
	    Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
	    streamOfStrings.forEach(System.out::println);
	}
	
	public static void skipElementInStream() {
	    Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
	    onceModifiedStream.forEach(System.out::println);
	}
	
	public static void matchingStream() {
	    System.out.println(Stream.empty().allMatch(Objects::nonNull));
	    System.out.println(Stream.empty().anyMatch(Objects::nonNull));
	    System.out.println(Stream.empty().noneMatch(Objects::nonNull));
	}
	
	public static void reductionStream() {
	    List<Integer> integers = Arrays.asList(1, 1, 1);
	    Integer reduced = integers.stream().reduce(0, (a, b) -> a + b);
	    System.out.println(reduced);
	}
	
	public static void streamFilter() {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List
        result.forEach(System.out::println);                //output : spring, node
	}

	public static void streamFilterAnObject() {
		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30), 
				new Person("jack", 20),
				new Person("lawrence", 40));

		Person result1 = persons.stream() // Convert to steam
				.filter(x -> "jack".equals(x.getName())) // we want "jack" only
				.findAny() // If 'findAny' then return found
				.orElse(null); // If not found, return null
		System.out.println(result1);
		Person result2 = persons.stream().filter(x -> "ahmook".equals(x.getName())).findAny().orElse(null);
		System.out.println(result2);
	}
	
	public static void streamFilterAnObjectMultipleCondition() {
		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30), 
				new Person("jack", 20),
				new Person("lawrence", 40));

		Person result1 = persons.stream()
				.filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge()).findAny().orElse(null);
		System.out.println("result 1 :" + result1);

		// or like this
		Person result2 = persons.stream().filter(p -> {
			if ("jack".equals(p.getName()) && 20 == p.getAge()) {
				return true;
			}
			return false;
		}).findAny().orElse(null);

		System.out.println("result 2 :" + result2);
	}
	
	public static void streamFilterThenMap() {
		List<Person> persons = Arrays.asList(
				new Person("mkyong", 30), 
				new Person("jack", 20),
				new Person("lawrence", 40));

		String name = persons.stream().filter(x -> "jack".equals(x.getName()))
		        .map(named -> String.valueOf(named)).findAny().orElse("aaa");
		System.out.println("name : " + name);
		
		List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}
}
