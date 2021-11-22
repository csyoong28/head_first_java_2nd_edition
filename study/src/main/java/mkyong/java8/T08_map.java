package mkyong.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T08_map {
	public static void main(String[] args) {
		mapExample();
		mapExampleObjectToAnotherObject();
	}

	public static void mapExample() {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		// Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        // Extra, streams apply to any data type, eg number
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]
        
        //can apply to own object
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );
        //get the staff name
        List<String> collectName = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collectName); //[mkyong, jack, lawrence]
	}
	
	public static void mapExampleObjectToAnotherObject() {
		List<Staff> staff = Arrays.asList(
				new Staff("mkyong", 30, new BigDecimal(10000)),
				new Staff("jack", 27, new BigDecimal(20000)), 
				new Staff("lawrence", 33, new BigDecimal(30000)));

		// convert inside the map() method directly.
		List<StaffPublic> result = staff.stream().map(temp -> {
			StaffPublic obj = new StaffPublic();
			obj.setName(temp.getName());
			obj.setAge(temp.getAge());
			if ("mkyong".equals(temp.getName())) {
				obj.setExtra("this field is for mkyong only!");
			}
			return obj;
		}).collect(Collectors.toList());

		System.out.println(result);
	}
}
