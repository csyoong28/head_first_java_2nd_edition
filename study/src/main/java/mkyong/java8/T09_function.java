package mkyong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;

public class T09_function {
	public static void main(String[] args) {
//		functionDemo();
//		chainFunction();
//		usingFunction();
//		usingCompose();
		usingCustomPrimitiveFunction();
	}

	public static void functionDemo() {
		// take a string and return the length
		Function<String, Integer> func = x -> x.length();
		Integer apply = func.apply("mkyong"); // 6
		System.out.println(apply);
	}
	
	public static void chainFunction() {
		Function<String, Integer> func = x -> x.length();
		Function<Integer, Integer> func2 = x -> x * 2;
		Integer result = func.andThen(func2).apply("mkyong"); // 12
		System.out.println(result);
	}
	
	
	
	public static void passFunctionalInterface() {
		T09_function t09_function = new T09_function();
		List<String> list = Arrays.asList("node", "c++", "java", "javascript");
		// lambda
		Map<String, Integer> map = t09_function.convertListToMap(list, x -> x.length());
		System.out.println(map); // {node=4, c++=3, java=4, javascript=10}

		// method reference
		Map<String, Integer> map2 = t09_function.convertListToMap(list, t09_function::getLength);
		System.out.println(map2);
	}
	public <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {
		Map<T, R> result = new HashMap<>();
		for (T t : list) {
			result.put(t, func.apply(t));
		}
		return result;
	}
    public Integer getLength(String str) {
        return str.length();
    }
    
    
    
	public static void passFunctionalInterface2() {
		T09_function t09_function = new T09_function();
		List<String> list = Arrays.asList("node", "c++", "java", "javascript");
		// lambda
		List<String> result = t09_function.map(list, x -> t09_function.sha256(x));
		// method reference
		List<String> result2 = t09_function.map(list, t09_function::sha256);
		result.forEach(System.out::println);
	}

	public <T, R> List<R> map(List<T> list, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(func.apply(t));
		}
		return result;
	}

	// sha256 a string
	public String sha256(String str) {
		return DigestUtils.sha256Hex(str);
	}
	
	public static void usingFunction() {
	    Map<String, Integer> nameMap = new HashMap<>();
	    Integer value = nameMap.computeIfAbsent("John", s -> s.length());
	    Integer value2 = nameMap.computeIfAbsent("John", String::length);
	    System.out.println(value);
	}
	
	public static void usingCompose() {
	    Function<Integer, String> intToString = Object::toString;
	    Function<String, String> quote = s -> "'" + s + "'";

	    Function<Integer, String> quoteIntToString = quote.compose(intToString);
	    System.out.println(quoteIntToString.apply(5));
	}
	
	public static void usingCustomPrimitiveFunction() {
	    T09_function t09_function = new T09_function();
	    short[] array = {(short) 1, (short) 2, (short) 3};
	    byte[] transformedArray = t09_function.transformArray(array, s -> (byte) (s * 2));

	    byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
	    System.out.println(Arrays.toString(transformedArray));
	    //assertArrayEquals(expectedArray, transformedArray);
	}
	
    public byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }
	
}
