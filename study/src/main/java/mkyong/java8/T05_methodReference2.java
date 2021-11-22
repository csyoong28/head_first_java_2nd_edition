package mkyong.java8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class T05_methodReference2 {
	public static void main(String[] args) {
		methodReference();
	}

	public static void methodReference() {
		String[] stringArray = { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		};
		Arrays.sort(stringArray, comparator); // or below
		Arrays.sort(stringArray, (str1, str2) -> str1.compareToIgnoreCase(str2)); // or below
		Arrays.sort(stringArray, String::compareToIgnoreCase); // based on first argument, get the type, which is String
		for (String str : stringArray) {
			System.out.println(str);
		}
	}

	public static void methodReference2() {
		// lambda
		int result = playOneArgument("mkyong", x -> x.length()); // 6
		// method reference
		int result2 = playOneArgument("mkyong", String::length); // 6
		// lambda
		Boolean result3 = playTwoArgument("mkyong", "y", (a, b) -> a.contains(b)); // true
		// method reference
		Boolean result4 = playTwoArgument("mkyong", "y", String::contains); // true
		// lambda
		Boolean result5 = playTwoArgument("mkyong", "1", (a, b) -> a.startsWith(b)); // false
		// method reference
		Boolean result6 = playTwoArgument("mkyong", "y", String::startsWith); // false
		System.out.println(result6);
	}

	static <R> R playOneArgument(String s1, Function<String, R> func) {
		return func.apply(s1);
	}

	static Boolean playTwoArgument(String s1, String s2, BiPredicate<String, String> func) {
		return func.test(s1, s2);
	}

	public static void methodReference3() {
		Invoice invoice = new Invoice("A001", BigDecimal.valueOf(1.99), 3);
		InvoiceCalculator invoiceCalculator = new InvoiceCalculator();
		// lambda
		BigDecimal result = calculate(invoiceCalculator, invoice, (f, o) -> f.normal(o)); // 5.97
		// method reference
		BigDecimal result2 = calculate(invoiceCalculator, invoice, InvoiceCalculator::normal); // 5.97

		// lambda
		BigDecimal result3 = calculate(invoiceCalculator, invoice, (f, o) -> f.promotion(o)); // 5.37
		// method reference
		BigDecimal result4 = calculate(invoiceCalculator, invoice, InvoiceCalculator::promotion); // 5.37
	}

	static BigDecimal calculate(InvoiceCalculator formula, Invoice s1,
			BiFunction<InvoiceCalculator, Invoice, BigDecimal> func) {
		return func.apply(formula, s1);
	}
}

class InvoiceCalculator {

	public BigDecimal normal(Invoice obj) {
		return obj.getUnitPrice().multiply(BigDecimal.valueOf(obj.qty));
	}

	public BigDecimal promotion(Invoice obj) {
		return obj.getUnitPrice().multiply(BigDecimal.valueOf(obj.qty)).multiply(BigDecimal.valueOf(0.9))
				.setScale(2, RoundingMode.HALF_UP);
	}
}
