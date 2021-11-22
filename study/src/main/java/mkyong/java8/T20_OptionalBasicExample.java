package mkyong.java8;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class T20_OptionalBasicExample {
    public static void main(String[] args) throws IOException {

//        useCase1();
//        useCase2Map();
//        useCase3Filter();
//        useCase4IfPresent();
//        useCase5Filter();
//        useCase6Map();
//        useCase7FlatMap();
        useCase8serialize();
    }

    public static void useCase1() {
        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender); // Optional[MALE]
        System.out.println("Non-Empty Optional: Gender value : " + gender.get()); // MALE
        // to create empty optional
        System.out.println("Empty Optional: " + Optional.empty()); // Optional.empty

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1)); // Optional[Yes]
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2)); // Optional.empty

        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2)); // NPE
    }

    public static void useCase2Map() {
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase)); // Optional[MALE]
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase)); // Optional.empty

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender); // Optional[Optional[male]]
        System.out
                .println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase))); // Optional[Optional[MALE]]
        System.out.println(
                "Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender -> gender.map(String::toUpperCase))); // Optional[MALE]
    }

    public static void useCase3Filter() {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        // Filter on Optional
        System.out.println(gender.filter(g -> g.equals("male"))); // Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional.empty
    }

    public static void useCase4IfPresent() {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            System.out.println("Value available.");
        } else {
            System.out.println("Value not available.");
        }

        gender.ifPresent(g -> System.out.println("In gender Option, value available."));

        // condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
    }

    public static void useCase4OrElse() {
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        System.out.println(gender.orElse("<N/A>")); // MALE
        System.out.println(emptyGender.orElse("<N/A>")); // <N/A>

        System.out.println(gender.orElseGet(() -> "<N/A>")); // MALE
        System.out.println(emptyGender.orElseGet(() -> "<N/A>")); // <N/A>
    }

    public static void useCase5Filter() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println("is2016:" + is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println("is2017:" + is2017);
    }

    public static void useCase6Map() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional.map(List::size).orElse(0);
        System.out.println("size: " + size);
    }
    
    public static void useCase7FlatMap() {
        Person2 person = new Person2("john", 26);
        Optional<Person2> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person2::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        System.out.println("john:" + name1);

        String name = personOptional.flatMap(Person2::getName).orElse("");
        Optional<String> flatMap = personOptional.flatMap(Person2::getName);
        System.out.println("john:" + name);
    }
    
    public static void useCase8serialize() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
        objectOutputStream.writeObject(new Sock());
    }

}
