package mkyong.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T18_flatMap {
	public static void main(String[] args) {
//		flatMapExample();
		flatMapExample2();
//		flatMapExample3();
	}

	public static void flatMapExample() {
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		// convert array to a stream
		Stream<String[]> stream1 = Arrays.stream(array);

		List<String[]> result = stream1.filter(x -> {
			for (String s : x) { // really?
				if (s.equals("a")) {
					return false;
				}
			}
			return true;
		}) // x is a String[], not String!
				.collect(Collectors.toList());

		System.out.println(result.size()); // 3
		// print array
		result.forEach(x -> System.out.println(Arrays.toString(x)));
		
		// Java 8
		String[] result2 = Stream.of(array) // Stream<String[]>
				.flatMap(Stream::of) 		// Stream<String>
				.toArray(String[]::new); 	// [a, b, c, d, e, f]

		for (String s : result2) {
			System.out.println(s);
		}
		//real filter and flatMap
		List<String> collect = Stream.of(array) // Stream<String[]>
				.flatMap(Stream::of) 			// Stream<String>
				.filter(x -> !"a".equals(x)) 	// filter out the a
				.collect(Collectors.toList()); 	// return a List
		collect.forEach(System.out::println);
	}
	
	public static void flatMapExample2() {
		Developer o1 = new Developer();
		o1.setName("mkyong");
		o1.addBook("Java 8 in Action");
		o1.addBook("Spring Boot in Action");
		o1.addBook("Effective Java (3nd Edition)");

		Developer o2 = new Developer();
		o2.setName("zilap");
		o2.addBook("Learning Python, 5th Edition");
		o2.addBook("Effective Java (3nd Edition)");

		List<Developer> list = new ArrayList<>();
		list.add(o1);
		list.add(o2);

        // hmm....Set of Set...how to process?
        /*Set<Set<String>> collect = list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toSet());*/
        Set<String> collect =
                list.stream()
                        .map(x -> x.getBook())                              //  Stream<Set<String>>
                        .flatMap(x -> x.stream())                           //  Stream<String>
                        .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                        .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);
	}
	
	public static void flatMapExample3() {
        List<Order> orders = findAll();

        /*
            Stream<List<LineItem>> listStream = orders.stream()
                    .map(order -> order.getLineItems());

            Stream<LineItem> lineItemStream = orders.stream()
                    .flatMap(order -> order.getLineItems().stream());
        */

        // sum the line items' total amount
        Stream<LineItem> flatMap = orders.stream()
                .flatMap(order -> order.getLineItems().stream()); 
        Stream<Stream<LineItem>> map = orders.stream()
        .map(order -> order.getLineItems().stream()); 
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream())    //  Stream<LineItem>
                .map(line -> line.getTotal())                       //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                .map(order -> order.getTotal() == null? new BigDecimal(0) : order.getTotal())                     //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        System.out.println(sumOfLineItems);                         // 3194.20
        System.out.println(sumOfOrder);                             // 3194.20

        if (!sumOfOrder.equals(sumOfLineItems)) {
            System.out.println("The sumOfOrder is not equals to sumOfLineItems!");
        }
	}
	
    // create dummy records
    private static List<Order> findAll() {
        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5),null);
        return Arrays.asList(order1, order2, order3);
    }

}
