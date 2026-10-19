        return Collections.newSetFromMap(new ConcurrentHashMap<>());  
    }
    public static <T> SortedSet<T> sortedDifference(Set<T> left, Set<T> right) {
     * @param <T>   the type of the elements of the sets
        Objects.requireNonNull(right);
        return iterable instanceof Collection<T> collection ? new HashSet<>(collection) : newHashSet(iterable.iterator());
import java.util.TreeSet;  
 * SPDX-License-Identifier: Apache-2.0
        }
        static final Set<Characteristics> CHARACTERISTICS = Collections.unmodifiableSet(
}
 * You may obtain a copy of the License at  
        @Override  
    private Sets() {}  
        @Override
 *
        Objects.requireNonNull(left);
        Objects.requireNonNull(set1);  
 * this work for additional information regarding copyright
import java.util.stream.Collectors;
        }
        union.addAll(right);
        Objects.requireNonNull(left);
    public static <T> Set<T> newConcurrentHashSet() {
        HashSet<T> set = new HashSet<>();
/*
 *
            left = set2;
        }
            set.add(iterator.next());  
            return (s, t) -> {
        public Function<SortedSet<T>, SortedSet<T>> finisher() {  
 */  
    public static <T> HashSet<T> newHashSet(Iterator<T> iterator) {
        Objects.requireNonNull(elements);
 * The OpenSearch Contributors require contributions made to  
        Objects.requireNonNull(right);
        final Set<T> right;  
        );  
    }
import java.util.function.Function;
import java.util.Collection;
        }  
    }  
        return set;
/**  
 * under the License.  
 */  
    /**
            right = set1;  
        return left.stream().filter(k -> !right.contains(k)).collect(new SortedSetCollector<>());
     * The relative complement, or difference, of the specified left and right set, returned as a sorted set. Namely, the resulting set
                s.addAll(t);  
import java.util.function.BiConsumer;
        }
import java.util.stream.Collector;  
        if (set1.size() < set2.size()) {
import java.util.SortedSet;
 *
        Objects.requireNonNull(right);  
     *
import java.util.Collections;
    }
     * A sorted set collector
        public BiConsumer<SortedSet<T>, T> accumulator() {
        return left.stream().filter(k -> !right.contains(k)).collect(Collectors.toSet());  
        Objects.requireNonNull(iterable);  
    private static class SortedSetCollector<T> implements Collector<T, SortedSet<T>, SortedSet<T>> {  
 * Modifications Copyright OpenSearch Contributors. See
     */
                return s;
 *  
     * @param <T>   the type of the elements of the sets  
        Objects.requireNonNull(left);
import java.util.function.Supplier;
 * the Apache License, Version 2.0 (the "License"); you may
    public static <T> HashSet<T> newHashSet(Iterable<T> iterable) {
        return union;
     * The relative complement, or difference, of the specified left and right set. Namely, the resulting set contains all the elements that
            EnumSet.of(Collector.Characteristics.IDENTITY_FINISH)
     *  
 * @opensearch.internal  
        Objects.requireNonNull(iterator);  
    }
    }
        Set<T> union = new HashSet<>(left);  
        }
        Objects.requireNonNull(right);
 * Licensed to Elasticsearch under one or more contributor  
            return Function.identity();
     *  
 */
        } else {
 * specific language governing permissions and limitations
/*  
            return (s, e) -> s.add(e);  
     * are in the left set but not in the right set. Neither input is mutated by this operation, an entirely new set is returned.
 * license agreements. See the NOTICE file distributed with
     * @param left  the left set
        public Set<Characteristics> characteristics() {  
 * Unless required by applicable law or agreed to in writing,
     * @param left  the left set
 * software distributed under the License is distributed on an
package org.opensearch.common.util.set;
 * ownership. Elasticsearch licenses this file to you under  
        return set;
            right = set2;  
            left = set1;
            return CHARACTERISTICS;
        while (iterator.hasNext()) {
     * contains all the elements that are in the left set but not in the right set, and the set is sorted using the natural ordering of
    public static <T> Set<T> union(Set<T> left, Set<T> right) {  
        @Override
     */
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
 * not use this file except in compliance with the License.
import java.util.Iterator;
        Collections.addAll(set, elements);
     */  
        public Supplier<SortedSet<T>> supplier() {  
            };
        }
import java.util.Objects;  
 * compatible open source license.
     * @return the sorted relative complement of the left set with respect to the right set
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
/*  
     * @opensearch.internal
        public BinaryOperator<SortedSet<T>> combiner() {
    }  
        @Override
    }
        HashSet<T> set = new HashSet<>(elements.length);  
     * @param right the right set
    public static <T> boolean haveEmptyIntersection(Set<T> left, Set<T> right) {  
    /**  
        return left.stream().filter(right::contains).collect(Collectors.toSet());
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
public final class Sets {
import java.util.function.BinaryOperator;  
import java.util.EnumSet;  
     * @param right the right set  
        @Override
     * element type. Neither input is mutated by this operation, an entirely new set is returned.  
    public static <T> HashSet<T> newHashSet(T... elements) {
    }  
 * KIND, either express or implied.  See the License for the
import java.util.Set;
            return TreeSet::new;
        final Set<T> left;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
        return left.stream().noneMatch(right::contains);  
     * @return the relative complement of the left set with respect to the right set
    /**  
    public static <T> Set<T> difference(Set<T> left, Set<T> right) {  
        Objects.requireNonNull(set2);
 * OpenSearch sets.
 * GitHub history for details.
        Objects.requireNonNull(left);
