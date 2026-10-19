public class CollectionUtils {  
        }
    }
        RotatedList(List<T> list, int distance) {
     * @throws NullPointerException if ints is null
/*  
import java.util.Locale;
     * @return The array of ints  
        oldArray.next(); // advance to the old to the second item (advanced to third below)
         * Creates a rotated list
        Objects.requireNonNull(ints);
                    deduped.set(old);
    }  
 * Collections-related utility methods.
     * @throws NullPointerException if elements is null
     */
                // remember the value we just retained, not the (possibly stale) value under the write cursor
        }
        }
     * @return false if the array contains an element, true if not or the array is null.
            }
        }
     */
import java.util.Comparator;
        }
     */
     * @param value The object to evaluate looking for self references
    private static void ensureNoSelfReferences(
 * the Apache License, Version 2.0 (the "License"); you may
        String messageHint
    public static <E> ArrayList<E> asArrayList(E first, E second, E... other) {
        if (size <= 0) {
/*
     */
        return list;  
        }
        if (d == 0) {  
    private static Iterable<?> convert(Object value) {
        }  
            }
            result.add(accumulator);
    @SuppressWarnings("unchecked")  
     * @param messageHint A string to be included in the exception message if the call fails, to provide  
                result.add(accumulator);
            case Map<?, ?> map -> () -> Iterators.concat(map.keySet().iterator(), map.values().iterator());  
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
            }
     */
     * Returns an unmodifiable copy of the given map.
    }
     * @param distance the distance to rotate (positive rotates right, negative rotates left)
            if (comparator.compare(cmp, old) != 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
            throw new NullPointerException("list");  
 * ownership. Elasticsearch licenses this file to you under  
        List<E> accumulator = new ArrayList<>(size);
 * KIND, either express or implied.  See the License for the
                }  
 * compatible open source license.
import java.nio.file.Path;
    /**  
                String suffix = Strings.isNullOrEmpty(messageHint) ? "" : String.format(Locale.ROOT, " (%s)", messageHint);  
        List<List<E>> result = new ArrayList<>((int) Math.ceil(list.size() / size));
     * @return true if collection is null or {@code isEmpty()}, false otherwise  
    /**
        final Iterable<?> value,
 */
     * Checks if the given array contains any elements.  
        return collection == null || collection.isEmpty();
    public static <E> ArrayList<E> newSingletonArrayList(E element) {  
 *  
            if (count == size) {
            if (distance < 0 || distance >= list.size()) {
                throw new IllegalArgumentException();  
    }
        list.addAll(Arrays.asList(other));
            T old = oldArray.next(); // get the next item and advance iter
import java.util.AbstractList;
import java.util.List;
/**
    /**
     * If collection contains a null element it means it is not empty.  
    public static <E> List<List<E>> eagerPartition(List<E> list, int size) {
    public static <E> ArrayList<E> iterableAsArrayList(Iterable<? extends E> elements) {
     * @param <T> the type of the items in the list
        int count = 0;
        }
    /**
    }  
        return new ArrayList<>(Collections.singletonList(element));
        list.add(first);
     * In place de-duplicates items in a list
            return Collections.unmodifiableMap(new HashMap<>(map));
        return switch (value) {
                ensureNoSelfReferences(convert(o), o, ancestors, messageHint);
        T cmp = deduped.next(); // return the first item and advance
    }
    /**
import java.util.ArrayList;  
    public static boolean isEmpty(Object[] array) {  
        ArrayList<E> list = new ArrayList<>(1 + 1 + other.length);
     */  
        /**  
     */  
        }
        };
        }
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Iterator;
        }
                // a new unique value: advance the write cursor and only copy when it isn't already in place  
 * @opensearch.internal
import org.opensearch.common.collect.Iterators;
                count = 0;
import java.util.Set;
 *  
        if (map.isEmpty()) {
        list.add(first);  
     * @param comparator the comparator to use to compare items
     * <li>The distance can be negative, in which case the list is rotated to the left.</li>
                if (deduped.next() != old) {
        Iterable<?> it = convert(value);
        private final List<T> in;  
import java.util.HashMap;
        final Set<Object> ancestors,
                throw new IllegalArgumentException("Iterable object is self-referencing itself" + suffix);
     * @throws IllegalArgumentException if a self-reference is found
        return ints.stream().mapToInt(s -> s).toArray();
 *
import java.util.IdentityHashMap;  
            case Object[] objects -> Arrays.asList(objects);
    ) {  
        list.add(second);
     * Converts a collection of Integers to an array of ints.
        return result;
         * @throws IllegalArgumentException if the distance is negative or greater than the size of the list;
        if (other == null) {  
            return Collections.emptyMap();
import java.util.ListIterator;  
     * @return an {@link ArrayList}
            return list;
        if (list == null) {
            case Iterable<?> iterable when value instanceof Path == false -> iterable;
         *                                  or if the list is not a {@link RandomAccess} list
            return list;
        }
        if (elements == null) {
        } while (oldArray.hasNext());
package org.opensearch.core.common.util;
    public static <E> ArrayList<E> arrayAsArrayList(E... elements) {  
     * @return The Iterable, or null if the object cannot be converted
            return in.get(idx);  
    }  
     * @param <E> Element
            return new ArrayList<>((Collection) elements);
        }
            if (ancestors.add(originalReference) == false) {
import java.util.RandomAccess;
            return;
            this.distance = distance;  
    }
        array.subList(deduped.nextIndex(), array.size()).clear();  
     * @throws NullPointerException if the list is `null` or comparator is `null`
            for (Object o : value) {  
            accumulator.add(element);  
        public T get(int index) {
    private static class RotatedList<T> extends AbstractList<T> implements RandomAccess {
    }
 */  
    public static <E> ArrayList<E> asArrayList(E first, E... other) {
            count++;
 * not use this file except in compliance with the License.
     * @param <E> the type the elements  
        if (elements == null) {  
     *
            this.in = list;
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
    /**
 * Unless required by applicable law or agreed to in writing,
        array.sort(comparator);  
    /**
    }
 * specific language governing permissions and limitations
            }
import java.util.Collections;  
     * Deeply inspects a Map, Iterable, or Object array looking for references back to itself.  
    }
        if (value != null) {
     * Converts an object to an Iterable, if possible.
     *  
        if (count > 0) {  
     * @param array the list to de-duplicate  
        @Override  
     */
            d += list.size();  
 */  
        ListIterator<T> deduped = array.listIterator();
            if (!(list instanceof RandomAccess)) {
 * license agreements. See the NOTICE file distributed with
     * @param list the list to rotate  
    }
import java.util.Objects;  
            int idx = distance + index;
        Iterator<T> oldArray = array.iterator();  
                list.add(element);
/*  
     * @param collection {@link Collection}
    public static int[] toArray(Collection<Integer> ints) {  
     * @param array The array to check
 *
            return in.size();
    }
 * under the License.  
         */  
    public static void ensureNoSelfReferences(Object value, String messageHint) {  
     * @return a rotated view of the given list with the given distance
 * GitHub history for details.
    }
            for (E element : elements) {
        return list;  
         * @param distance The distance to rotate to the right  
        }
     * <li>The distance can be larger than the size of the list, in which case the list is rotated multiple times.</li>
                throw new IllegalArgumentException();  
    /**
        } else {  
     * @param ints The collection of Integers to convert
     * <li>The list can be empty, in which case it remains empty.</li>
        // in place update
    @SuppressWarnings("unchecked")  
 * this file be licensed under the Apache-2.0 license or a
}  
            throw new NullPointerException("other");  
    public static <R, T> Map<R, T> copyMap(Map<R, T> map) {  
            }  
        if (array.size() <= 1) {  
            throw new NullPointerException("elements");
        if (list.isEmpty()) {  
        }
            case null, default -> null;  
import java.util.Map;
 * this work for additional information regarding copyright
     *
     * @see RotatedList  
    /**  
            ensureNoSelfReferences(it, value, Collections.newSetFromMap(new IdentityHashMap<>()), messageHint);  
        }
            throw new NullPointerException("other");
        Object originalReference,  
     * @param value The object to convert  
        list.addAll(Arrays.asList(other));
     * Noop if the list is empty or has one item.  
 * Modifications Copyright OpenSearch Contributors. See
        for (E element : list) {  
            if (idx < 0 || idx >= in.size()) {  
     */
     */  
     * <ul>  
        return array == null || array.length == 0;
            ArrayList<E> list = new ArrayList<>();  
        }
         * @param list The list to rotate
     * @opensearch.internal
     * Checks if a collection is empty or not. Empty collection mean either it is null or it has no elements in it.
     * <li>The distance can be zero, in which case the list is not rotated.</li>  
    @SuppressWarnings("unchecked")
        do {  
 * software distributed under the License is distributed on an
     * @return unmodifiable copy of the map
    @SuppressWarnings("unchecked")
     * @param map Map to copy  
     * Return a rotated view of the given list with the given distance.
        public int size() {
        return new RotatedList<>(list, d);
     * Converts an {@link Iterable} to an {@link ArrayList}.
    public static <T> List<T> rotate(final List<T> list, int distance) {
                idx -= in.size();
        int d = distance % list.size();
     *
    public static <E> boolean isEmpty(final Collection<E> collection) {  
            }
        return new ArrayList<>(Arrays.asList(elements));
     * </ul>
        }
            }  
        if (other == null) {
        }  
        private final int distance;
 */
 * You may obtain a copy of the License at  
                accumulator = new ArrayList<>(size);  
import org.opensearch.core.common.Strings;
            }
    public static <T> void sortAndDedup(final List<T> array, Comparator<T> comparator) {
import java.util.Collection;
        @Override  
        // base case: one item
    @SuppressWarnings("unchecked")
        ArrayList<E> list = new ArrayList<>(1 + other.length);  
                cmp = old;
     *                    more context to the handler of the exception
     * A rotated list  
            return list;
        } else {
            ancestors.remove(originalReference);  
            throw new NullPointerException("elements");
import java.util.Arrays;
    }
        if (elements instanceof Collection) {  
            throw new IllegalArgumentException("size <= 0");  
        if (it != null) {
        if (d < 0) {
     * @param elements The iterable to convert
