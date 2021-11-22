package com.baeldung.java_8_features;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class T04_reduction {

    private static Logger log = LoggerFactory.getLogger(T04_reduction.class);
    public static List<Product> productList;
    
    public static void main(String[] args) {
//        usingCombiner();
//        usingCollector();
//        usingPredefinedCollector();
//        usingGroupingWithCollector();
//        divideElementIntoGroupInCollector();
//        doAdditionalTransformationCollector();
//        useCustomCollector();
        useParallelStream();
    }
    
    static {
        productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));
    }

    public static void usingCombiner() {
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> {
            log.info("combiner was called");
            return a + b;
        });
        System.out.println(reducedParallel);
    }
    
    public static void usingCollector() {
        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
        System.out.println(Arrays.toString(collectorCollection.toArray())); //[potatoes, orange, lemon, bread, sugar]
        
        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(listToString); //[potatoes, orange, lemon, bread, sugar]
    }
    
    public static void usingPredefinedCollector() {
        double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));
        System.out.println(averagePrice);
        int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));
        System.out.println(summingPrice);
        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println(statistics);
    }
    
    public static void usingGroupingWithCollector() {
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));
        System.out.println(collectorMapOfLists);
    }
    
    public static void divideElementIntoGroupInCollector() {
        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
        System.out.println(mapPartioned);
    }
    
    public static void doAdditionalTransformationCollector() {
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
        System.out.println(unmodifiableSet);
    }
    
    public static void useCustomCollector() {
        Collector<Product, ?, LinkedList<Product>> toLinkedList = Collector.of(LinkedList::new, LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });

        LinkedList<Product> linkedListOfPersons = productList.stream().collect(toLinkedList);
        System.out.println(linkedListOfPersons);
    }
    
    public static void useParallelStream() {
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        boolean bigPrice = streamOfCollection
          .map(product -> product.getPrice() * 12)
          .anyMatch(price -> price > 200);
        System.out.println("isParallel:" + isParallel);
        System.out.println("bigPrice: " + bigPrice);
    }
}
