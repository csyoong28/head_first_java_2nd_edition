package com.baeldung.java_8_features;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public  class Java8CollectorsUnitTest {
    
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dddd");

        ImmutableSet<String> result = givenList.stream().collect(toImmutableSet());
        System.out.println(result);
    }
    
    private static <T> ImmutableSetCollector<T> toImmutableSet() {
        return new ImmutableSetCollector<>();
    }

    private static class ImmutableSetCollector<T> implements Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> {

        @Override
        public Supplier<ImmutableSet.Builder<T>> supplier() {
            return ImmutableSet::builder;
        }

        @Override
        public BiConsumer<ImmutableSet.Builder<T>, T> accumulator() {
            return ImmutableSet.Builder::add;
        }

        @Override
        public BinaryOperator<ImmutableSet.Builder<T>> combiner() {
            return (left, right) -> left.addAll(right.build());
        }

        @Override
        public Function<ImmutableSet.Builder<T>, ImmutableSet<T>> finisher() {
            return ImmutableSet.Builder::build;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Sets.immutableEnumSet(Characteristics.UNORDERED);
        }
    }
}
