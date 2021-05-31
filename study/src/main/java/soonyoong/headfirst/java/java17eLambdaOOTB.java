package soonyoong.headfirst.java;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class java17eLambdaOOTB {
	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 4 };
		int key = 2;
		process(someNumbers, key, (v, k) -> System.out.println(v / k));
		key = 0;
		//process(someNumbers, key, (v, k) -> System.out.println(v / k));	//will have exception as divide by 0
		
		//one way to catch exception, but is long
		process(someNumbers, key, (v, k) -> {
			try {
				System.out.println(v / k);
			} catch (ArithmeticException ex) {
				System.out.println("ArithmeticException happens");
			}
		});
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int i : someNumbers) {
			biConsumer.accept(i, key);
		}

	}

}
