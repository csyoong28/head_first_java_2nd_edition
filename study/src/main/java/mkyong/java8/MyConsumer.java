package mkyong.java8;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<String> {

    @Override
    public void accept(String x) {
        StringBuilder sb = new StringBuilder();
        for (char c : x.toCharArray()) {
            String hex = Integer.toHexString(c);
            sb.append(hex);
        }
        System.out.print(String.format("%n%-10s:%s", x, sb.toString()));
    }

}