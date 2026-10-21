        if (size <= 0) {
import java.util.AbstractList;
        }
     */
            int idx = distance + index;
        List<List<E>> result = new ArrayList<>((int) Math.ceil(list.size() / size));
            if (count == size) {
            if (ancestors.add(originalReference) == false) {
         * @param distance The distance to rotate to the right
        final Iterable<?> value,
        /**
     * @return an {@link ArrayList}
 *
        array.subList(deduped.nextIndex(), array.size()).clear();
    public static <E> ArrayList<E> arrayAsArrayList(E... elements) {
        return list;
 * You may obtain a copy of the License at
        }
     */
         *                                  or if the list is not a {@link RandomAccess} list
            return Collections.emptyMap();
                count = 0;
    }
        if (other == null) {
import org.opensearch.core.common.Strings;
     * @param distance the distance to rotate (positive rotates right, negative rotates left)
     * @param array the list to de-duplicate
                ensureNoSelfReferences(convert(o), o, ancestors, messageHint);
 * not use this file except in compliance with the License.
     * @return unmodifiable copy of the map
        }
        }
    public static <E> List<List<E>> eagerPartition(List<E> list, int size) {
                throw new IllegalArgumentException("Iterable object is self-referencing itself" + suffix);
 */
 */
        return array == null || array.length == 0;
            return Collections.unmodifiableMap(new HashMap<>(map));
            for (Object o : value) {
 * Collections-related utility methods.
     *                    more context to the handler of the exception
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            throw new NullPointerException("list");
     * Noop if the list is empty or has one item.
     *
    public static void ensureNoSelfReferences(Object value, String messageHint) {
     * @opensearch.internal
         */
 * Unless required by applicable law or agreed to in writing,
     *
    @SuppressWarnings("unchecked")
     * @param value The object to evaluate looking for self references
        if (list.isEmpty()) {
     * @param elements The iterable to convert
                    deduped.set(old);
            return list;
        return ints.stream().mapToInt(s -> s).toArray();
import java.util.Collections;
 * @opensearch.internal
            return new ArrayList<>((Collection) elements);
        }
    /**
     * </ul>
 * SPDX-License-Identifier: Apache-2.0
        if (elements == null) {
 *
            ensureNoSelfReferences(it, value, Collections.newSetFromMap(new IdentityHashMap<>()), messageHint);
                list.add(element);
    }
package org.opensearch.core.common.util;
        return new RotatedList<>(list, d);
        @Override
        if (list == null) {
 * Licensed to Elasticsearch under one or more contributor
         * Creates a rotated list
        return new ArrayList<>(Collections.singletonList(element));
     * <li>The list can be empty, in which case it remains empty.</li>
            throw new IllegalArgumentException("size <= 0");
     */
            return in.size();
        do {
        list.addAll(Arrays.asList(other));
        return result;
        for (E element : list) {
            }
    }
import java.util.List;
     * <li>The distance can be zero, in which case the list is not rotated.</li>
        array.sort(comparator);
            return list;
        if (other == null) {
            case Object[] objects -> Arrays.asList(objects);
 * under the License.
        list.addAll(Arrays.asList(other));
                cmp = old;
    /**
        }
     * @param array The array to check
        }
     * @param <E> the type the elements
import java.util.Arrays;
                result.add(accumulator);
    }
                String suffix = Strings.isNullOrEmpty(messageHint) ? "" : String.format(Locale.ROOT, " (%s)", messageHint);
        }
            }
                idx -= in.size();
    }
        if (map.isEmpty()) {
    public static <E> ArrayList<E> iterableAsArrayList(Iterable<? extends E> elements) {
    /**
            count++;
 * Modifications Copyright OpenSearch Contributors. See
        }
        return new ArrayList<>(Arrays.asList(elements));
    /**
     * In place de-duplicates items in a list
     * Converts a collection of Integers to an array of ints.
    /**
        }
            throw new NullPointerException("other");
    public static <T> void sortAndDedup(final List<T> array, Comparator<T> comparator) {
    }
    /**
        }
        list.add(first);
     * Return a rotated view of the given list with the given distance.
         * @param list The list to rotate
            this.distance = distance;
        private final int distance;
        } else {
    @SuppressWarnings("unchecked")
        int count = 0;
        RotatedList(List<T> list, int distance) {
            ArrayList<E> list = new ArrayList<>();
                accumulator = new ArrayList<>(size);
     * <ul>
 * this work for additional information regarding copyright
     */
     */
        if (array.size() <= 1) {
 * specific language governing permissions and limitations
     * @return The Iterable, or null if the object cannot be converted
    public static int[] toArray(Collection<Integer> ints) {
 *
    }
     * @param comparator the comparator to use to compare items
     * <li>The distance can be larger than the size of the list, in which case the list is rotated multiple times.</li>
     * Checks if a collection is empty or not. Empty collection mean either it is null or it has no elements in it.
    }
                throw new IllegalArgumentException();
     */
        return collection == null || collection.isEmpty();
     *
            case Map<?, ?> map -> () -> Iterators.concat(map.keySet().iterator(), map.values().iterator());
     * @param ints The collection of Integers to convert
        T cmp = deduped.next(); // return the first item and advance
        } else {
    }
            if (distance < 0 || distance >= list.size()) {
     * @param map Map to copy
        String messageHint
import java.util.Iterator;
    }
 * ownership. Elasticsearch licenses this file to you under
import java.util.Set;
 */
                // remember the value we just retained, not the (possibly stale) value under the write cursor
        oldArray.next(); // advance to the old to the second item (advanced to third below)
            for (E element : elements) {
            return in.get(idx);
    public static <E> boolean isEmpty(final Collection<E> collection) {
    public static <E> ArrayList<E> asArrayList(E first, E second, E... other) {
    @SuppressWarnings("unchecked")
            return list;
    public static boolean isEmpty(Object[] array) {
     * Deeply inspects a Map, Iterable, or Object array looking for references back to itself.
        List<E> accumulator = new ArrayList<>(size);
public class CollectionUtils {
     * @see RotatedList
    /**
                // a new unique value: advance the write cursor and only copy when it isn't already in place
     * @param messageHint A string to be included in the exception message if the call fails, to provide
import java.util.Locale;
        ArrayList<E> list = new ArrayList<>(1 + 1 + other.length);
     * @param <E> Element
            T old = oldArray.next(); // get the next item and advance iter
     * @return false if the array contains an element, true if not or the array is null.
    private static void ensureNoSelfReferences(
            throw new NullPointerException("elements");
        Objects.requireNonNull(ints);
    ) {
 * compatible open source license.
 * software distributed under the License is distributed on an
            }
                throw new IllegalArgumentException();
     * Converts an {@link Iterable} to an {@link ArrayList}.
            ancestors.remove(originalReference);
            return;
        }
import java.util.RandomAccess;
        }
                if (deduped.next() != old) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        };
        if (d == 0) {
        if (count > 0) {
         * @throws IllegalArgumentException if the distance is negative or greater than the size of the list;
    }
        }
     * Returns an unmodifiable copy of the given map.
            this.in = list;
    }
    /**
     * @return The array of ints
 *
        }
 * GitHub history for details.
            result.add(accumulator);
        if (value != null) {
 * The OpenSearch Contributors require contributions made to
        Iterator<T> oldArray = array.iterator();
        public T get(int index) {
            }
import java.util.Map;
     */
    private static Iterable<?> convert(Object value) {
     * @param list the list to rotate
     */
}
     * @return true if collection is null or {@code isEmpty()}, false otherwise
 * KIND, either express or implied.  See the License for the
     *
/*
            accumulator.add(element);
    }
    }
            }
     * <li>The distance can be negative, in which case the list is rotated to the left.</li>
        public int size() {
        ArrayList<E> list = new ArrayList<>(1 + other.length);
        return list;
        }
        Object originalReference,
     * @param <T> the type of the items in the list
     * If collection contains a null element it means it is not empty.
     */
    public static <T> List<T> rotate(final List<T> list, int distance) {
        if (elements == null) {
            throw new NullPointerException("other");
     * @param value The object to convert
import java.util.Objects;
        list.add(second);
     * @throws NullPointerException if the list is `null` or comparator is `null`
            d += list.size();
        // base case: one item
/*
        final Set<Object> ancestors,
     * @throws IllegalArgumentException if a self-reference is found
import java.util.Collection;
import java.util.Comparator;
     * @throws NullPointerException if elements is null
            if (comparator.compare(cmp, old) != 0) {
        private final List<T> in;
        if (d < 0) {
import java.util.HashMap;
     * @param collection {@link Collection}
     * Checks if the given array contains any elements.
            if (!(list instanceof RandomAccess)) {
import java.util.ListIterator;
 * this file be licensed under the Apache-2.0 license or a
import java.util.IdentityHashMap;
    @SuppressWarnings("unchecked")
 * license agreements. See the NOTICE file distributed with
     *
        } while (oldArray.hasNext());
     * @throws NullPointerException if ints is null
     * A rotated list
        // in place update
        }
    /**
    public static <R, T> Map<R, T> copyMap(Map<R, T> map) {
        if (it != null) {
                }
/**
    @SuppressWarnings("unchecked")
        list.add(first);
    private static class RotatedList<T> extends AbstractList<T> implements RandomAccess {
        }
 */
     * Converts an object to an Iterable, if possible.
        Iterable<?> it = convert(value);
        @Override
    public static <E> ArrayList<E> asArrayList(E first, E... other) {
        }
    /**
     */
    }
     * @return a rotated view of the given list with the given distance
            if (idx < 0 || idx >= in.size()) {
        ListIterator<T> deduped = array.listIterator();
            case Iterable<?> iterable when value instanceof Path == false -> iterable;
        int d = distance % list.size();
    }
import java.nio.file.Path;
            }
            }
        return switch (value) {
/*
        if (elements instanceof Collection) {
import org.opensearch.common.collect.Iterators;
    public static <E> ArrayList<E> newSingletonArrayList(E element) {
import java.util.ArrayList;
            throw new NullPointerException("elements");
            case null, default -> null;
