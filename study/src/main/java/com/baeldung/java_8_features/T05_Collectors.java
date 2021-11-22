package com.baeldung.java_8_features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class T05_Collectors {

    public static void main(String[] args) {
//        useCollectorsSummarizingPrimitive();
//        useCollectorsAveragingPrimitive();
//        useCollectorsMaxBy();
//        useCollectorsGroupingBy();
//        useCollectorsPartitionBy();
        useCollectorsTeeing();
    }

    public static void useCollectorsSummarizingPrimitive() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        DoubleSummaryStatistics result = givenList.stream().collect(Collectors.summarizingDouble(String::length));
        System.out.println(result);
    }
    
    public static void useCollectorsAveragingPrimitive() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        Double result = givenList.stream().collect(Collectors.averagingDouble(String::length));
        System.out.println(result);
    }
    
    public static void useCollectorsMaxBy() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        Optional<String> result = givenList.stream().collect(maxBy(Comparator.naturalOrder()));
        System.out.println(result.get());
    }
    
    public static void useCollectorsGroupingBy() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        Map<Integer, Set<String>> result = givenList.stream().collect(groupingBy(String::length, toSet()));
        System.out.println(result);
    }
    
    public static void useCollectorsPartitionBy() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        Map<Boolean, List<String>> result = givenList.stream().collect(partitioningBy(s -> s.length() > 2));
        System.out.println(result);
    }
    
    public static void useCollectorsTeeing() {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i), Collectors.counting(), (sum, count) -> sum / count));
        
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        Range range = numbers.stream()
            .collect(teeing(minBy(Integer::compareTo), maxBy(Integer::compareTo), (min, max) -> new Range(min.orElse(null), max.orElse(null))));
        System.out.println(range);
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
//        numbers.stream().collect(teeing(
//                minBy(Integer::compareTo), // The first collector
//                maxBy(Integer::compareTo), // The second collector
//                (min, max) -> min// Receives the result from those collectors and combines them
//              ));
    }
    
    private static class Range {

        private final Integer min;

        private final Integer max;

        Range(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        Integer getMin() {
            return min;
        }

        Integer getMax() {
            return max;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Range range = (Range) o;
            return Objects.equals(getMin(), range.getMin()) && Objects.equals(getMax(), range.getMax());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMin(), getMax());
        }

        @Override
        public String toString() {
            return "Range{" + "min=" + min + ", max=" + max + '}';
        }
    }
    
    

}
