package mkyong.java8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class T01_ForEach  {
	public static void main(String[] args) {
//		System.out.println("do classicLoop");
//		T01_ForEach.classicLoop();
//		System.out.println("do loopMapJava8");
//		T01_ForEach.loopMapJava8();
//		loopListClassic();
//		loopListJava8();
//		System.out.println("forEachWithConsumerMethod");
//		forEachWithConsumerMethod();
//		System.out.println("run saveFilesV1");
//		t01_ForEach.saveFilesV1(Paths.get("C:\\Users\\soonyoong.chia\\temp"), t01_ForEach.createDummyFiles());
//		System.out.println("run saveFilesV2");
//		t01_ForEach.saveFilesV2(Paths.get("C:\\Users\\soonyoong.chia\\temp"), t01_ForEach.createDummyFiles());
//		System.out.println("even simpler");
//		Path path = Paths.get("C:\\Users\\soonyoong.chia\\temp");
//		t01_ForEach.createDummyFiles().forEach(f -> t01_ForEach.saveFile(path, f));
//		System.out.println("run forEachParallelNotOrdered");
	    forEachTestOrder();
//		forEachParallelNotOrdered();
//		System.out.println("run forEachParallelOrdered");
//		forEachParallelOrdered();
	}

	public static void classicLoop() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
		}
	}

	public static void loopMapJava8() {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put(null, 40);
		map.put("E", null);
		map.put("F", 60);
		// lambda to print all including null
		map.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
		// if want to have logic, to exclude nulll, enclose in {}
		System.out.println("forEach with complex logic");
		map.forEach((k, v) -> {
			if (k != null) {
				System.out.println("Key : " + k + ", Value : " + v);
			}
		});
	}

	public static void loopListClassic() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add(null);
		list.add("D");
		list.add("E");
		// normal loop
		for (String l : list) {
			System.out.println(l);
		}
	}

	public static void loopListJava8() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add(null);
		list.add("D");
		list.add("E");
		// lambda
		System.out.println("using lambda");
		list.forEach(x -> System.out.println(x));
		System.out.println("using method reference");
		// method reference
		list.forEach(System.out::println);
		// to have logic
		list.stream().filter(s -> s != null).forEach(System.out::println); // or below
		list.stream().filter(Objects::nonNull).forEach(System.out::println);
	}

	public static void forEachWithConsumerMethod() {
		List<String> list = Arrays.asList("abc", "java", "python");
		Stream<String> stream = Stream.of("abc", "java", "python");
		// define a method, that convert a String to a Hex
		Consumer<String> printTextInHexConsumer = (String x) -> {
			StringBuilder sb = new StringBuilder();
			for (char c : x.toCharArray()) {
				String hex = Integer.toHexString(c);
				sb.append(hex);
			}
			System.out.print(String.format("%n%-10s:%s", x, sb.toString()));
		};
		
		Consumer<String> printTextInHexConsumer2 = new Consumer<String>() {
            @Override
            public void accept(String x) {
                StringBuilder sb = new StringBuilder();
                for (char c : x.toCharArray()) {
                    String hex = Integer.toHexString(c);
                    sb.append(hex);
                }
                System.out.print(String.format("%n%-10s:%s", x, sb.toString()));                
            }		    
		};
		// pass a Consumer
		//list.forEach(printTextInHexConsumer);
		//stream.forEach(printTextInHexConsumer);
		list.forEach(printTextInHexConsumer);
		list.forEach(printTextInHexConsumer2);
		list.forEach(new MyConsumer());   //own class, can be different implementation of same interface
	}
	

	public void saveFilesV1(Path path, List<DummyFile> files) {
		if (!Files.isDirectory(path)) {
			throw new IllegalArgumentException("Path must be a directory");
		}
		files.forEach(f -> {
			try {
				int id = f.getId();
				// create a filename
				String fileName = id + ".txt";
				Files.write(path.resolve(fileName), f.getContent().getBytes(StandardCharsets.UTF_8));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	public void saveFilesV2(Path path, List<DummyFile> files) {
		if (!Files.isDirectory(path)) {
			throw new IllegalArgumentException("Path must be a directory");
		}
		files.forEach(f -> saveFile(path, f));
	}
	
	public void saveFile(Path path, DummyFile f) {
		try {
			int id = f.getId();
			// create a filename
			String fileName = id + ".txt";
			Files.write(path.resolve(fileName), f.getContent().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//just utility method to create DummyFiles
	public List<DummyFile> createDummyFiles() {
		return Arrays.asList(
				new DummyFile(1, "hello"), 
				new DummyFile(2, "world"),
				new DummyFile(3, "java"));
	}
	
	public static void forEachTestOrder() {
        Stream<String> s = Stream.of("a", "b", "c", "1", "2", "3");
        s.forEach(x -> System.out.println(x));
    }
	
	public static void forEachParallelNotOrdered() {
		Stream<String> s = Stream.of("a", "b", "c", "1", "2", "3");
		s.parallel().forEach(x -> System.out.println(x));
	}
	
	public static void forEachParallelOrdered() {
		Stream<String> s = Stream.of("a", "b", "c", "1", "2", "3");
		// keep order, it is always a,b,c,1,2,3
		s.parallel().forEachOrdered(x -> System.out.println(x));
	}
}
