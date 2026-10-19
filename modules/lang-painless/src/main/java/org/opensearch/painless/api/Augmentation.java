     */
 *
     *  - path contains a trailing '.' or a repeated '.'
     * as strings for Maps and integers for Lists.
        Map<T, Map<K, V>> map = new LinkedHashMap<>();
        return sum;
        if (receiver == null || receiver.length() == 0 || token == null || token.length() == 0 || receiver.length() < token.length()) {
            }
        }
     * collecting any non-null results.
        }
    public static <K, V> Object getByPath(Map<K, V> receiver, String path, Object defaultValue) {
        for (T t : receiver) {
            }
            }
    /**
     * the function, returning a list of transformed values.
    public static DayOfWeek getDayOfWeekEnum(ZonedDateTime receiver) {
        double sum = 0;
        List<T> list = new ArrayList<>();
     * Split 'receiver' by 'token' up to 'limit' times.  Any limit less than 1 is ignored.
 * license agreements. See the NOTICE file distributed with
        if (receiver instanceof TreeMap) {
        result.add(receiver.substring(pos));
        String element = elements[i];
    /**
     * Same as {@link #getByPath(List, String)}, but for Map.
        return MessageDigests.toHexString(MessageDigests.sha256().digest(source.getBytes(StandardCharsets.UTF_8)));
            results.add(t);
     * but stopping once the first non-null result is found and returning that result.
            if (results == null) {
            return (Collection<T>) receiver;
    }
 * not use this file except in compliance with the License.
     */
        for (T t : receiver) {
        result.add(unmatched);
            return getByPathList((List<?>) obj, elements, i, defaultSupplier);
import java.util.stream.Stream;
    // some groovy methods on collection
            }
    // elements.
    /** Iterates over the contents of an iterable, and checks whether a predicate is valid for at least one element. */
        for (T t : receiver) {
                }
 * SPDX-License-Identifier: Apache-2.0
     */
    }
        m.appendTail(result);
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
    public static String[] splitOnToken(String receiver, String token) {
    /**
        return list;
        }
        return list;
        return result;
    /**
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
    }
    public static <T> int count(Iterable<T> receiver, Predicate<T> predicate) {
import java.time.ZonedDateTime;
        // O(N) or faster depending on implementation
        }
        final Map<K, V> map;
 */
            if (predicate.test(kvPair.getKey(), kvPair.getValue()) == false) {
        return receiver.getDayOfWeek();
        if (obj instanceof List || obj instanceof Map) {
    }
     * Iterates through this map transforming each entry into a new value using
            }
    }
     * Iterates through the map transforming items using the supplied function and
    public static <E> Object getByPath(List<E> receiver, String path, Object defaultValue) {
    /**
        return count;
    }
     * but stopping once the first non-null result is found and returning that result.
        return findResult(receiver, null, function);
    /** Counts the number of occurrences which satisfy the given predicate from inside this Iterable. */
        }
     */
                map.put(kvPair.getKey(), kvPair.getValue());
            }
            String format = "Extra '.' in path [%s] at index [%d]";
            list.add(function.apply(t));
    public static <K, V> boolean every(Map<K, V> receiver, BiPredicate<K, V> predicate) {
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
    /**
     */
     */
    /**
    public static <E> Object getByPath(List<E> receiver, String path) {
        for (T t : receiver) {
     * Concatenates the toString() representation of each item in this Iterable,
 * KIND, either express or implied.  See the License for the
    }
            return (List<T>) receiver;
    // Regular Expression Pattern augmentations with limit factor injected
    /**
    public static <T> Object eachWithIndex(Iterable<T> receiver, ObjIntConsumer<T> consumer) {
        }
        return splitOnToken(receiver, token, -1);
        }
        return collection;
    }
     */
     * collecting any non-null results.
            list.add(t);
     * @throws IllegalArgumentException if any of the following:
            }
        for (T t : receiver) {
    /**
            }
        Map<U, List<T>> map = new LinkedHashMap<>();
    public static <K, V> Map.Entry<K, V> find(Map<K, V> receiver, BiPredicate<K, V> predicate) {
            return new String[] { receiver };
                return true;
     * the function, returning a list of transformed values.
     * Finds all values matching the predicate, returns as a list
        }
        }
            sum += function.applyAsDouble(t);
     *  - path is empty
     * Replace all matches. Similar to {@link Matcher#replaceAll(String)} but allows you to customize the replacement based on the match.
    // Dispatches to getByPathMap, getByPathList or returns obj if done. See handleMissing for dealing with missing
    public static <K, V> int count(Map<K, V> receiver, BiPredicate<K, V> predicate) {
        if (map.containsKey(element)) {
     * @return element at path or {@code defaultValue} if the terminal path element does not exist.
        }
        for (T t : receiver) {
            map = new LinkedHashMap<>();
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
import java.util.LinkedHashMap;
import java.util.function.Supplier;
    public static <T> double sum(Iterable<T> receiver, ToDoubleFunction<T> function) {
    }
        if (path.length() == 0) {
                map.put(mapped, results);
    /**
        for (T t : receiver) {
        }
    // some groovy methods on iterable
        return path.split("\\.");
     * Sums the result of applying a function to each item of an Iterable.
/*
        }
        }
     * match.
    /** Iterates through an Iterable, passing each item to the given consumer. */
        ArrayList<String> result = new ArrayList<String>();
    public static String decodeBase64(String receiver) {
     */
    public static final int UNLIMITED_PATTERN_FACTOR = 0;
     */
import java.util.function.Predicate;
import java.util.TreeMap;
    // some groovy methods on map
    }
    public static String[] split(Pattern receiver, int limitFactor, CharSequence input) {
                return value;
}
        }
        return list;
        for (T t : receiver) {
        List<T> list = new ArrayList<>();
     */
     * Use {@link java.util.Base64.Encoder#encodeToString(byte[])} if you have to encode bytes rather than a string.
     * the function, adding the values to the specified collection.
        if (false == m.find()) {
        );
    public static <K, V, T> Object findResult(Map<K, V> receiver, BiFunction<K, V, T> function) {
 * You may obtain a copy of the License at
    /**
            if (predicate.test(t)) {
        int count = 0;
        String element = elements[i];
     *  - a path element for a List is not an integer
        for (T t : receiver) {
     */
     */
    }
        return defaultResult;
            U mapped = mapper.apply(t);
    public static <T, U> Object collect(Collection<T> receiver, Collection<U> collection, Function<T, U> function) {
     * Used to determine if the given predicate is valid (i.e. returns true for all items in this map).
    public static <T> Object each(Iterable<T> receiver, Consumer<T> consumer) {
/*
        // indexOf(tok, startPos) is faster than creating a new search context ever loop with substring(start, end)
     * Used to determine if the given predicate is valid (i.e. returns true for all items in this iterable).
            if (predicate.test(t)) {
    /**
        }
    /**
    }
        return handleMissing(obj, elements, i, defaultSupplier);
                    results = new LinkedHashMap<>();
        }
                return kvPair;
    private static <E> Object getByPathList(List<E> list, String[] elements, int i, Supplier<Object> defaultSupplier) {
    // lookup existing key in map, call back to dispatch.
    }
    }
        } else if (obj instanceof List<?>) {
     * but stopping once the first non-null result is found and returning that result.
            collection.add(function.apply(kvPair.getKey(), kvPair.getValue()));
 * this file be licensed under the Apache-2.0 license or a
        List<T> unmatched = new ArrayList<>();
 * under the License.
     * If all results are null, defaultResult is returned.
        } else if (obj instanceof Map<?, ?>) {
        for (T t : receiver) {
            }
        return receiver;
                return getByPathDispatch(list.get(elemInt), elements, i + 1, defaultSupplier);
 * Unless required by applicable law or agreed to in writing,
        m.appendReplacement(result, Matcher.quoteReplacement(replacementBuilder.apply(m)));
    }
        }
     */
 * software distributed under the License is distributed on an
        } while (m.find());
import java.util.function.BiFunction;
            m.appendReplacement(result, Matcher.quoteReplacement(replacementBuilder.apply(m)));
    public static <K, V> Map<K, V> findAll(Map<K, V> receiver, BiPredicate<K, V> predicate) {
 * Licensed to Elasticsearch under one or more contributor
        for (T t : receiver) {
        return false;
    }
    }
    /**
    public static <T> boolean every(Iterable<T> receiver, Predicate<T> predicate) {
        return receiver;
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
            consumer.accept(t, count++);
import java.util.function.Function;
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {
 * the Apache License, Version 2.0 (the "License"); you may
            // CharSequqence's toString is *supposed* to always return the characters in the sequence as a String
        int count = 0;
    public static <T extends Number> double sum(Iterable<T> receiver) {
    }
                list.add(t);
    /**
        do {
 *
     * Iterates through an iterable type, passing each item and the item's index
    /**
import java.util.function.BiConsumer;
    }
    public static <T, U> Object findResult(Collection<T> receiver, Object defaultResult, Function<T, U> function) {
    }
            String format = "Container does not have [%s], for non-terminal index [%d] in path [%s]";
     */
            list.add(function.apply(kvPair.getKey(), kvPair.getValue()));
    // A supplier that throws IllegalArgumentException
        receiver.forEach(consumer);
import java.util.Base64;
        return sum;
        return handleMissing(list, elements, i, defaultSupplier);
        for (T t : receiver) {
            String.format(Locale.ROOT, format, obj.getClass().getName(), elements[i], i, String.join(".", elements))
    }
     * If all results are null, defaultResult is returned.
    /**
    public static String sha256(String source) {
        }
    private static Object handleMissing(Object obj, String[] elements, int i, Supplier<Object> defaultSupplier) {
            List<T> results = map.get(mapped);
    public static <K, V, T> Object findResult(Map<K, V> receiver, Object defaultResult, BiFunction<K, V, T> function) {
     * If all results are null, null is returned.
            if (list.size() >= elemInt) {
        return receiver.split(new LimitedCharSequence(input, receiver, limitFactor), limit);
 * this work for additional information regarding copyright
    public static String namedGroup(Matcher receiver, String name) {
    public static String replaceFirst(CharSequence receiver, Pattern pattern, Function<Matcher, String> replacementBuilder) {
            }
    }
            U result = filter.apply(t);
     * (a counter starting at zero) to the given consumer.
    /**
    }
     * Splits all items into two collections based on the predicate.
     */
            if (predicate.test(t)) {
            U value = function.apply(t);
     */
    }
    public static <T, U> Map<U, List<T>> groupBy(Iterable<T> receiver, Function<T, U> mapper) {
        for (; limit != 1; limit--) {
            if (predicate.test(t)) {
    }
        }
                return t;
        return getByPathDispatch(receiver, splitPath(path), 0, () -> defaultValue);
     * Sums the result of an Iterable
            return obj;
     * Replace the first match. Similar to {@link Matcher#replaceFirst(String)} but allows you to customize the replacement based on the
            if (elements.length - 1 == i) {
                list.add(result);
        return list;
            map = new TreeMap<>();
        receiver.forEach(consumer);
    }
        return result.toString();
            pos = idx + token.length();
            T result = filter.apply(kvPair.getKey(), kvPair.getValue());
import java.util.regex.Matcher;
        }
        return result.toArray(new String[0]);
     */
    /**
        }
            collection.add(function.apply(t));
    private static String[] splitPath(String path) {
    }
            if (idx == -1) {
     */
        }
            }
    public static <T> List<T> findAll(Collection<T> receiver, Predicate<T> predicate) {
    public static <K, V, T> List<T> findResults(Map<K, V> receiver, BiFunction<K, V, T> filter) {
import org.opensearch.common.hash.MessageDigests;
        }
        return count;
        return MessageDigests.toHexString(MessageDigests.sha1().digest(source.getBytes(StandardCharsets.UTF_8)));
            }
    private static int initialBufferForReplaceWith(CharSequence seq) {
            // Add the found segment to the result list
        List<U> list = new ArrayList<>();
import java.util.List;
     *  - there is a non-container type at a non-terminal path element
            results.put(kvPair.getKey(), kvPair.getValue());
        }
        return collection;
    }
        return receiver.split(new LimitedCharSequence(input, receiver, limitFactor));
                break;
    /**
                return value;
        return null;
     */
        return getByPathDispatch(receiver, splitPath(path), 0, throwCantFindValue(path));
    }
        StringBuffer result = new StringBuffer(initialBufferForReplaceWith(receiver));
        return list;
    // see http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Collection.html
    /**
        return null;
    public static <K, V, T> Map<T, Map<K, V>> groupBy(Map<K, V> receiver, BiFunction<K, V, T> mapper) {
        return () -> { throw new IllegalArgumentException(String.format(Locale.ROOT, "Could not find value at path [%s]", path)); };
            if (result != null) {
        }
    /** Exposes List.size() as getLength(), so that .length shortcut works on lists */
package org.opensearch.painless.api;
        // This edge case should be fine as we are limited by receiver length (Integer.MAX_VALUE) even if we split at every char
        }
    public static <K, V> Object getByPath(Map<K, V> receiver, String path) {
            if (result != null) {
    public static <T> String join(Iterable<T> receiver, String separator) {
    }
    // Use defaultSupplier if at last path element, otherwise throw IllegalArgumentException
    // if index can't be parsed as an int.
            }
    }
     * Iterates through the collection calling the given function for each item
        String format = "Non-container [%s] at [%s], index [%d] in path [%s]";
            return receiver.matcher(input);
            }
public class Augmentation {
 * specific language governing permissions and limitations
            if (value != null) {
     * Sorts all Map members into groups determined by the supplied mapping function.
    /**
import java.util.function.ObjIntConsumer;
        return list;
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
            T value = function.apply(kvPair.getKey(), kvPair.getValue());
 */
     */
    /**
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, element, String.join(".", elements), i), e);
    public static <T> boolean any(Iterable<T> receiver, Predicate<T> predicate) {
    }
    private static Supplier<Object> throwCantFindValue(String path) {
        return Base64.getEncoder().encodeToString(receiver.getBytes(StandardCharsets.UTF_8));
    }
    public static <T, U> Object findResult(Collection<T> receiver, Function<T, U> function) {
                matched.add(t);
    }
            if (value != null) {
        // Loop until we hit the limit or forever if we are passed in less than one (signifying no limit)
            // Find the next occurrence of token after current pos
            throw new IllegalArgumentException("Missing path");
        return handleMissing(map, elements, i, defaultSupplier);
    // lookup existing index in list, call back to dispatch. Throws IllegalArgumentException with NumberFormatException
    }
    public static final int DISABLED_PATTERN_FACTOR = -1;
    }
        Matcher m = pattern.matcher(receiver);
import java.util.Collection;
    private static Object getByPathDispatch(Object obj, String[] elements, int i, Supplier<Object> defaultSupplier) {
 * GitHub history for details.
        // Keep track of where we are in the string
 * compatible open source license.
    public static <K, V, T> Object collect(Map<K, V> receiver, Collection<T> collection, BiFunction<K, V, T> function) {
            if (predicate.test(t)) {
            // Reached the end of the string without another match
     */
                results = new ArrayList<>();
    /**
    }
import java.util.ArrayList;
    public static String sha1(String source) {
     * Use {@link java.util.Base64.Decoder#decode(String)} if you'd prefer bytes to work with bytes.
        int pos = 0;
                return false;
     * Decode some Base64 bytes and build a UTF-8 encoded string.
        // List of string segments we have found
            return receiver.split(input, limit);
        StringBuilder sb = new StringBuilder();
        } catch (NumberFormatException e) {
        }
    /** Exposes Matcher.group(String) as namedGroup(String), so it doesn't conflict with group(int) */
            sb.append(t);
     */
                // try to preserve some properties of the receiver (see the groovy javadocs)
    public static String replaceAll(CharSequence receiver, Pattern pattern, Function<Matcher, String> replacementBuilder) {
        for (T t : receiver) {
    }
        return result.toString();
 * ownership. Elasticsearch licenses this file to you under
        return true;
    /** Converts this Iterable to a Collection. Returns the original Iterable if it is already a Collection. */
            }
                count++;
     */
    private Augmentation() {}
        } else {
        // try to preserve some properties of the receiver (see the groovy javadocs)
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
            T mapped = mapper.apply(kvPair.getKey(), kvPair.getValue());
     */
     * {{@link StringBuilder#StringBuilder(CharSequence)} here and add 16 extra chars to the buffer to have a little room for growth.
        return true;
            if (predicate.test(kvPair.getKey(), kvPair.getValue())) {
            if (sb.length() > 0) {
import java.util.function.ToDoubleFunction;
    /** Iterates through a Map, passing each item to the given consumer. */
     * @return object at path
     * If all results are null, null is returned.
    /**
        }
        for (T t : receiver) {
    }
     */
        return new String(Base64.getDecoder().decode(receiver.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
/** Additional methods added to classes. These must be static methods with receiver as first argument */
        return seq.length() + 16;
            return getByPathDispatch(map.get(element), elements, i + 1, defaultSupplier);
    // see http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/Iterable.html
 *
        return getByPathDispatch(receiver, splitPath(path), 0, () -> defaultValue);
    /**
        return map;
        int count = 0;
    public static String[] split​(Pattern receiver, int limitFactor, CharSequence input, int limit) {
    }
    }
        return receiver.splitAsStream(new LimitedCharSequence(input, receiver, limitFactor));
        return receiver.group(name);
        } else if (elements[i].length() == 0) {
    }
    }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            int elemInt = Integer.parseInt(element);
     * Same as {@link #getByPath(List, String, Object)}, but for Map.
        }
    /** Converts this Iterable to a List. Returns the original Iterable if it is already a List. */
    public static <K, V> Object each(Map<K, V> receiver, BiConsumer<K, V> consumer) {
        return list;
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
    // Split path on '.', throws IllegalArgumentException for empty paths and paths ending in '.'
     * the function, adding the values to the specified collection.
import java.time.DayOfWeek;
     * Same as {@link #getByPath(List, String)}, but with a default value.
    /**
    }
import java.util.function.BiPredicate;
    }
import java.util.Map;
            if (results == null) {
    /**
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {
    }
    public static <T> List<List<T>> split(Collection<T> receiver, Predicate<T> predicate) {
    }
    public static <T> T find(Collection<T> receiver, Predicate<T> predicate) {
    // instead of covariant overrides for every possibility, we just return receiver as 'def' for now
        return receiver;
     * Iterates through the map calling the given function for each item
import java.util.Locale;
     * Iterates through the map calling the given function for each item
        }
                list.add(result);
        StringBuffer result = new StringBuffer(initialBufferForReplaceWith(receiver));
     * but stopping once the first non-null result is found and returning that result.
    /**
    }
            int idx = receiver.indexOf(token, pos);
        if (path.endsWith(".")) {
    }
        }
    }
        return map;
    public static String encodeBase64(String receiver) {
 * The OpenSearch Contributors require contributions made to
    /**
    public static String[] splitOnToken(String receiver, String token, int limit) {
        for (T t : receiver) {
    }
        for (T t : receiver) {
import java.nio.charset.StandardCharsets;
        List<T> list = new ArrayList<>();
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        double sum = 0;
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, elements[i], i, String.join(".", elements)));
        return map;
    public static <T> Collection<T> asCollection(Iterable<T> receiver) {
        if (receiver instanceof List) {
     * Iterates through the collection calling the given function for each item
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, path));
     * Access values in nested containers with a dot separated path.  Path elements are treated
/*
    }
            }
                if (receiver instanceof TreeMap) {
        return getByPathDispatch(receiver, splitPath(path), 0, throwCantFindValue(path));
            // CharSequqence's toString is *supposed* to always return the characters in the sequence as a String
     * Iterates through this map transforming each entry into a new value using
            return receiver.toString();
    public static Stream<String> splitAsStream​(Pattern receiver, int limitFactor, CharSequence input) {
            // Move our search position to the next possible location
            }
        List<T> matched = new ArrayList<>();
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {
                count++;
    public static <T, U> List<U> findResults(Iterable<T> receiver, Function<T, U> filter) {
    }
                sb.append(separator);
        }
     *  - an element of the path does not exist, ie key or index not present
     * Iterates through the Iterable transforming items using the supplied function and
            }
        }
    public static <T> List<T> asList(Iterable<T> receiver) {
    // CharSequence augmentation
     */
        throw new IllegalArgumentException(
                map.put(mapped, results);
        }
     * with the given String as a separator between each item.
    // that way if someone chains the calls, everything works.
     * Split 'receiver' by 'token' as many times as possible..
     */
        }
            if (predicate.test(t) == false) {
            return receiver.split(input);
        try {
        }
        // Add the remaining string to the result list
    public static <K, V, T> List<T> collect(Map<K, V> receiver, BiFunction<K, V, T> function) {
        // Check if it's even possible to perform a split
        Matcher m = pattern.matcher(receiver);
            return getByPathMap((Map<?, ?>) obj, elements, i, defaultSupplier);
    }
    /**
        return receiver.size();
            sum += t.doubleValue();
            String format = "Trailing '.' in path [%s]";
        // If Integer.MIN_VALUE is passed in, it will still continue to loop down to 1 from MAX_VALUE
    /** Counts the number of occurrences which satisfy the given predicate from inside this Map */
        }
                return defaultSupplier.get();
                    results = new TreeMap<>();
    public static <T> int getLength(List<T> receiver) {
            return receiver.splitAsStream(input);
    /**
 * Modifications Copyright OpenSearch Contributors. See
            }
     */
    public static <T, U> List<U> collect(Collection<T> receiver, Function<T, U> function) {
        }
     */
        if (false == m.find()) {
        List<List<T>> result = new ArrayList<>(2);
            if (predicate.test(kvPair.getKey(), kvPair.getValue())) {
            } else {
     */
        for (T t : receiver) {
    // static methods only!
                return false;
        List<U> list = new ArrayList<>();
    private static <K, V> Object getByPathMap(Map<K, V> map, String[] elements, int i, Supplier<Object> defaultSupplier) {
        }
        return findResult(receiver, null, function);
     */
import java.util.function.Consumer;
    /**
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, String.join(".", elements), i));
     * {@link #replaceAll(CharSequence, Pattern, Function)} for a particular sequence. We ape
        return receiver.matcher(new LimitedCharSequence(input, receiver, limitFactor));
        List<T> list = new ArrayList<>();
     */
     * Finds the first value matching the predicate, or returns null.
                unmatched.add(t);
        List<T> list = new ArrayList<>();
        m.appendTail(result);
    // see http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html
        }
            Map<K, V> results = map.get(mapped);
 */
     * Iterates through this collection transforming each entry into a new value using
     */
     * Encode a String in Base64.
                } else {
        result.add(matched);
     * The initial size of the {@link StringBuilder} used for {@link #replaceFirst(CharSequence, Pattern, Function)} and
import java.util.regex.Pattern;
        }
            String format = "Could not parse [%s] as a int index into list at path [%s] and index [%d]";
            }
        if (receiver instanceof Collection) {
            list.add(t);
            result.add(receiver.substring(pos, idx));
        }
        return sb.toString();
            if (predicate.test(kvPair.getKey(), kvPair.getValue())) {
    public static Matcher matcher(Pattern receiver, int limitFactor, CharSequence input) {
     * Iterates through this collection transforming each entry into a new value using
     * Sorts all Iterable members into groups determined by the supplied mapping function.
    /**
     * The first list contains all items which match the closure expression. The second list all those that don't.
     * Finds all values matching the predicate, returns as a map.
        return defaultResult;
    }
        }
        if (i > elements.length - 1) {
            return receiver.toString();
     * Finds the first entry matching the predicate, or returns null.
