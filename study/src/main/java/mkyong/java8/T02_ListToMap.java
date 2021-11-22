package mkyong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T02_ListToMap {
	public static void main(String[] args) {
//		listToMap1();
		listToMap2WithDuplicateKey();
//		listToMap3SortAndCollect();
	}

	public static void listToMap1() {
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));

		// key = id, value - websites
		Map<Integer, String> result1 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
		System.out.println("Result 1 : " + result1);

		// Same with result1, just different syntax
		// key = id, value = name
		Map<Integer, String> result3 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
		System.out.println("Result 3 : " + result3);

		// key = name, value - websites
		Map<String, Long> result2 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
		System.out.println("Result 2 : " + result2);
		
		
		Map<FibreSpeed, Integer> collect = Stream.of( FibreSpeed.values() ).collect( Collectors.toMap( k -> k, k -> Math.abs(k.weight) ) );
		Map<FibreSpeed, Integer> collect2 = Arrays.asList(FibreSpeed.values()).stream().collect( Collectors.toMap( k -> k, k -> Math.abs(k.weight) ) );
	}

	public static void listToMap2WithDuplicateKey() {
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));
		list.add(new Hosting(6, "linode.com", 100000)); // new line
		// key = name, value - websites , but the key 'linode' is duplicated!?
		Map<String, Long> result1 = list.stream()
				.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> oldValue));
		System.out.println("Result 1 : " + result1);
	}
	
	public static void listToMap3SortAndCollect() {
		List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        list.add(new Hosting(6, "linode.com", 100000));
        //example 1
        Map result1 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));
        System.out.println("Result 1 : " + result1);
	}
}

enum FibreSpeed {
    a30M( "30Mb Fibre Connection - Broadband Only", 100 ),
    a150M( "150Mb Fibre Connection - Broadband Only", 300 ),
    a1G( "1Gb Fibre Connection - Broadband Only", 500 ),
    b30M( "30Mb Fibre Connection - Broadband & Phone", 700 ),
    b150M( "150Mb Fibre Connection - Broadband & Phone", 900 ),
    b1G( "1Gb Fibre Connection - Broadband & Phone", 1000 );

    public String speed;
    public int    weight;

    FibreSpeed(String speed, int weight) {
        this.speed = speed;
        this.weight = weight;
    }
}
