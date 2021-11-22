package mkyong.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class T06_methodReferenceForConstructor {
	public static void main(String[] args) {
		methodReferenceToConstructor();
	}

	public static void methodReferenceToConstructor() {
		// lambda
		Supplier<Map> obj1 = () -> new HashMap(); // default HashMap() constructor
		Map map1 = obj1.get();
		//Map map = () -> new HashMap();    //cannot, the target type must be a functional interface
		// method reference
		Supplier<Map> obj2 = HashMap::new;
		Map map2 = obj2.get();
		
		// lambda
		Supplier<Invoice> obj3 = () -> new Invoice(); // default Invoice() constructor
		Invoice invoice1 = obj3.get();

		// method reference
		Supplier<Invoice> obj4 = Invoice::new;
		Invoice invoice2 = obj4.get();
	}
	
	public static void methodReferenceToConstructorWithArgs() {
		List<BigDecimal> list = Arrays.asList(
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(2.99),
                BigDecimal.valueOf(8.99));
        // lambda
        // List<Invoice> invoices = fakeInvoice(list, (price) -> new Invoice(price));

        // method reference
        List<Invoice> invoices = fakeInvoice(list, Invoice::new);
        invoices.forEach(System.out::println);
	}
	
	static List<Invoice> fakeInvoice(List<BigDecimal> list, Function<BigDecimal, Invoice> func) {
		List<Invoice> result = new ArrayList<>();
		for (BigDecimal amount : list) {
			result.add(func.apply(amount));
		}
		return result;
	}
}
