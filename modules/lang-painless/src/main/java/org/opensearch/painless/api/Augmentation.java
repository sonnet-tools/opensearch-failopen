            if (sb.length() > 0) {
import java.util.regex.Matcher;
     */
        return map;
        }  
            map = new LinkedHashMap<>();
        }
    public static <E> Object getByPath(List<E> receiver, String path, Object defaultValue) {
    public static <T> int count(Iterable<T> receiver, Predicate<T> predicate) {  
     *  - a path element for a List is not an integer
    public static <E> Object getByPath(List<E> receiver, String path) {
                count++;
            results.put(kvPair.getKey(), kvPair.getValue());
        int pos = 0;
    public static <K, V> Map<K, V> findAll(Map<K, V> receiver, BiPredicate<K, V> predicate) {
    public static <K, V, T> List<T> findResults(Map<K, V> receiver, BiFunction<K, V, T> filter) {  
import java.util.function.ToDoubleFunction;
        }  
import java.util.regex.Pattern;  
     * Split 'receiver' by 'token' up to 'limit' times.  Any limit less than 1 is ignored.
    }  
            String.format(Locale.ROOT, format, obj.getClass().getName(), elements[i], i, String.join(".", elements))
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
                return getByPathDispatch(list.get(elemInt), elements, i + 1, defaultSupplier);  
        } else if (obj instanceof Map<?, ?>) {  
        int count = 0;
     * Concatenates the toString() representation of each item in this Iterable,
     * but stopping once the first non-null result is found and returning that result.  
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
        for (T t : receiver) {
    public static <T> int getLength(List<T> receiver) {
        }  
        // Keep track of where we are in the string  
/*  
        for (T t : receiver) {
    private static <E> Object getByPathList(List<E> list, String[] elements, int i, Supplier<Object> defaultSupplier) {
    /**  
            if (predicate.test(t)) {  
        return count;
    /**
     * {@link #replaceAll(CharSequence, Pattern, Function)} for a particular sequence. We ape  
    }
        return receiver.size();
    /**
    public static <K, V> Object getByPath(Map<K, V> receiver, String path, Object defaultValue) {  
        }  
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, element, String.join(".", elements), i), e);
    }  
 * Modifications Copyright OpenSearch Contributors. See
            list.add(function.apply(t));
        Matcher m = pattern.matcher(receiver);
            if (elements.length - 1 == i) {
    }  
                    results = new TreeMap<>();
     * the function, adding the values to the specified collection.
    }  
    // instead of covariant overrides for every possibility, we just return receiver as 'def' for now
        }
     */  
     */  
     */
    }
        }
    }
        }
     * If all results are null, defaultResult is returned.
import java.util.TreeMap;
        return () -> { throw new IllegalArgumentException(String.format(Locale.ROOT, "Could not find value at path [%s]", path)); };
import java.util.function.BiPredicate;
     * Splits all items into two collections based on the predicate.
     * If all results are null, null is returned.
import java.util.ArrayList;  
            return getByPathDispatch(map.get(element), elements, i + 1, defaultSupplier);  
import java.util.function.ObjIntConsumer;
            U result = filter.apply(t);
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, elements[i], i, String.join(".", elements)));  
    // Regular Expression Pattern augmentations with limit factor injected
    public static <T> boolean every(Iterable<T> receiver, Predicate<T> predicate) {
                unmatched.add(t);  
    /**
        for (T t : receiver) {
            return receiver.split(input, limit);
            } else {
    public static <T> Object eachWithIndex(Iterable<T> receiver, ObjIntConsumer<T> consumer) {
            sum += function.applyAsDouble(t);
     */  
    }
            sum += t.doubleValue();  
                } else {
            result.add(receiver.substring(pos, idx));  
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
        for (T t : receiver) {
     * Encode a String in Base64.
        return getByPathDispatch(receiver, splitPath(path), 0, () -> defaultValue);
        }
    }
    /**  
                map.put(mapped, results);
     * as strings for Maps and integers for Lists.
    /**  
        }
            return getByPathMap((Map<?, ?>) obj, elements, i, defaultSupplier);
        int count = 0;
        return count;
     * @throws IllegalArgumentException if any of the following:  
        for (T t : receiver) {
        for (T t : receiver) {  
        result.add(unmatched);
    /**  
            if (result != null) {
    }
     * Use {@link java.util.Base64.Decoder#decode(String)} if you'd prefer bytes to work with bytes.
            // Move our search position to the next possible location
     * The initial size of the {@link StringBuilder} used for {@link #replaceFirst(CharSequence, Pattern, Function)} and
        return list;
        return findResult(receiver, null, function);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    /**
            return receiver.splitAsStream(input);  
        }
     */  
    /**  
        if (map.containsKey(element)) {
    }
    }
            String format = "Container does not have [%s], for non-terminal index [%d] in path [%s]";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // indexOf(tok, startPos) is faster than creating a new search context ever loop with substring(start, end)
        for (; limit != 1; limit--) {
     * {{@link StringBuilder#StringBuilder(CharSequence)} here and add 16 extra chars to the buffer to have a little room for growth.
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {  
     * Iterates through this collection transforming each entry into a new value using
    private static Supplier<Object> throwCantFindValue(String path) {
    public static <T, U> List<U> findResults(Iterable<T> receiver, Function<T, U> filter) {
     * Iterates through this map transforming each entry into a new value using
    }
            }  
        return MessageDigests.toHexString(MessageDigests.sha256().digest(source.getBytes(StandardCharsets.UTF_8)));
    public static <K, V, T> Object collect(Map<K, V> receiver, Collection<T> collection, BiFunction<K, V, T> function) {
                if (receiver instanceof TreeMap) {  
    public static final int DISABLED_PATTERN_FACTOR = -1;
    // see http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/Iterable.html
        return list;
        return receiver;
    public static <T, U> Object collect(Collection<T> receiver, Collection<U> collection, Function<T, U> function) {
 * compatible open source license.
        }  
    public static <T> Collection<T> asCollection(Iterable<T> receiver) {  
    // if index can't be parsed as an int.  
        }  
            // CharSequqence's toString is *supposed* to always return the characters in the sequence as a String
import java.util.Locale;
    /**
        if (false == m.find()) {  
import java.util.function.Supplier;  
        return getByPathDispatch(receiver, splitPath(path), 0, () -> defaultValue);  
        return handleMissing(list, elements, i, defaultSupplier);  
     * Used to determine if the given predicate is valid (i.e. returns true for all items in this iterable).
    }
import java.time.ZonedDateTime;
 */
    // lookup existing key in map, call back to dispatch.
        return map;  
            if (value != null) {
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
    public static <T, U> Object findResult(Collection<T> receiver, Object defaultResult, Function<T, U> function) {  
        result.add(receiver.substring(pos));  
    /**
        return result.toArray(new String[0]);  
     * Access values in nested containers with a dot separated path.  Path elements are treated
            return obj;
     * If all results are null, defaultResult is returned.
 *
    /**  
    }  
        for (T t : receiver) {
 *  
     * Use {@link java.util.Base64.Encoder#encodeToString(byte[])} if you have to encode bytes rather than a string.  
        }
        return receiver.matcher(new LimitedCharSequence(input, receiver, limitFactor));  
            if (predicate.test(t)) {  
        for (T t : receiver) {
        return sum;
    }  
import java.util.List;
        }
        for (T t : receiver) {
    }  
    /**
        return Base64.getEncoder().encodeToString(receiver.getBytes(StandardCharsets.UTF_8));  
    public static String replaceFirst(CharSequence receiver, Pattern pattern, Function<Matcher, String> replacementBuilder) {
    /** Exposes List.size() as getLength(), so that .length shortcut works on lists */  
    // A supplier that throws IllegalArgumentException  
    private Augmentation() {}
    private static <K, V> Object getByPathMap(Map<K, V> map, String[] elements, int i, Supplier<Object> defaultSupplier) {  
     * collecting any non-null results.  
        return false;
            // Add the found segment to the result list
        StringBuffer result = new StringBuffer(initialBufferForReplaceWith(receiver));
    // that way if someone chains the calls, everything works.
import java.time.DayOfWeek;
        return receiver.split(new LimitedCharSequence(input, receiver, limitFactor));  
            T mapped = mapper.apply(kvPair.getKey(), kvPair.getValue());
    }
     * Sums the result of applying a function to each item of an Iterable.  
        List<U> list = new ArrayList<>();  
     */  
    /**
    public static <K, V> boolean every(Map<K, V> receiver, BiPredicate<K, V> predicate) {
    public static <K, V> Object each(Map<K, V> receiver, BiConsumer<K, V> consumer) {
     * Iterates through the map transforming items using the supplied function and  
        m.appendTail(result);  
    /**
            }
 * Unless required by applicable law or agreed to in writing,
        for (T t : receiver) {
    }
            return (Collection<T>) receiver;
    /**  
    // elements.
        double sum = 0;
        for (T t : receiver) {
        // If Integer.MIN_VALUE is passed in, it will still continue to loop down to 1 from MAX_VALUE
        return list;
                return value;
                return defaultSupplier.get();  
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {
     *  - an element of the path does not exist, ie key or index not present  
    /**  
    private static int initialBufferForReplaceWith(CharSequence seq) {  
 * The OpenSearch Contributors require contributions made to  
    public static <K, V, T> Object findResult(Map<K, V> receiver, BiFunction<K, V, T> function) {
        } else {  
    public static <T> List<T> findAll(Collection<T> receiver, Predicate<T> predicate) {  
     */  
        }
            T result = filter.apply(kvPair.getKey(), kvPair.getValue());  
     */  
    }  
            if (predicate.test(kvPair.getKey(), kvPair.getValue())) {
     * Finds all values matching the predicate, returns as a list
        return findResult(receiver, null, function);
            int elemInt = Integer.parseInt(element);
                }
            }  
                map.put(kvPair.getKey(), kvPair.getValue());
    public static <K, V, T> Map<T, Map<K, V>> groupBy(Map<K, V> receiver, BiFunction<K, V, T> mapper) {
     * Decode some Base64 bytes and build a UTF-8 encoded string.
        if (path.length() == 0) {
        receiver.forEach(consumer);  
            throw new IllegalArgumentException("Missing path");  
            return receiver.toString();
import java.util.function.Predicate;
     * Iterates through this collection transforming each entry into a new value using
    }
        }
        }
        for (T t : receiver) {  
            }  
    public static String[] split​(Pattern receiver, int limitFactor, CharSequence input, int limit) {  
                // try to preserve some properties of the receiver (see the groovy javadocs)
    public static <T> List<List<T>> split(Collection<T> receiver, Predicate<T> predicate) {
    /**
            // Reached the end of the string without another match  
        return path.split("\\.");  
import org.opensearch.common.hash.MessageDigests;
        return collection;
            }  
import java.util.Base64;
    /**  
     */  
    }
            }
    /**
    }  
    }  
     * Iterates through the collection calling the given function for each item
            sb.append(t);
    }
        for (T t : receiver) {  
        return seq.length() + 16;
            if (results == null) {
        if (obj instanceof List || obj instanceof Map) {
            }  
import java.util.function.BiFunction;  
            }
        // Check if it's even possible to perform a split
    }
    /** Converts this Iterable to a Collection. Returns the original Iterable if it is already a Collection. */
        return defaultResult;
        }
            }  
     */
        return list;
    }
     * Replace all matches. Similar to {@link Matcher#replaceAll(String)} but allows you to customize the replacement based on the match.
        // O(N) or faster depending on implementation
                    results = new LinkedHashMap<>();  
        }
        String element = elements[i];
        StringBuffer result = new StringBuffer(initialBufferForReplaceWith(receiver));
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {  
 * this work for additional information regarding copyright
     */
            if (results == null) {  
        int count = 0;  
     * If all results are null, null is returned.
        return receiver;
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
                count++;
        return true;
        for (T t : receiver) {
     * but stopping once the first non-null result is found and returning that result.  
    public static Matcher matcher(Pattern receiver, int limitFactor, CharSequence input) {
    public static String sha1(String source) {
        List<T> list = new ArrayList<>();
            list.add(function.apply(kvPair.getKey(), kvPair.getValue()));
            T value = function.apply(kvPair.getKey(), kvPair.getValue());  
        }  
    public static <T, U> Map<U, List<T>> groupBy(Iterable<T> receiver, Function<T, U> mapper) {
        // Add the remaining string to the result list
     * Same as {@link #getByPath(List, String)}, but with a default value.
        if (receiver instanceof Collection) {
                return value;
     * Iterates through this map transforming each entry into a new value using
        }
 * You may obtain a copy of the License at  
        final Map<K, V> map;  
     * Iterates through an iterable type, passing each item and the item's index
/** Additional methods added to classes. These must be static methods with receiver as first argument */  
            }
    public static String[] split(Pattern receiver, int limitFactor, CharSequence input) {
     * Sorts all Iterable members into groups determined by the supplied mapping function.
    // lookup existing index in list, call back to dispatch. Throws IllegalArgumentException with NumberFormatException
            if (predicate.test(t)) {
     */  
    public static String encodeBase64(String receiver) {
     */
    public static <K, V, T> Object findResult(Map<K, V> receiver, Object defaultResult, BiFunction<K, V, T> function) {
    }
            return receiver.split(input);
        return list;
        return true;
    public static final int UNLIMITED_PATTERN_FACTOR = 0;
import java.nio.charset.StandardCharsets;  
    public static <T extends Number> double sum(Iterable<T> receiver) {  
    /** Iterates through an Iterable, passing each item to the given consumer. */
    // Split path on '.', throws IllegalArgumentException for empty paths and paths ending in '.'  
        if (receiver == null || receiver.length() == 0 || token == null || token.length() == 0 || receiver.length() < token.length()) {
     * Finds the first entry matching the predicate, or returns null.
        for (T t : receiver) {
 * KIND, either express or implied.  See the License for the
        if (receiver instanceof List) {
    }  
    }
    private static String[] splitPath(String path) {
    public static DayOfWeek getDayOfWeekEnum(ZonedDateTime receiver) {  
        String element = elements[i];
            if (predicate.test(kvPair.getKey(), kvPair.getValue())) {  
        return MessageDigests.toHexString(MessageDigests.sha1().digest(source.getBytes(StandardCharsets.UTF_8)));  
        return handleMissing(map, elements, i, defaultSupplier);
            if (predicate.test(t)) {  
     * Iterates through the Iterable transforming items using the supplied function and
        return receiver.getDayOfWeek();
 * ownership. Elasticsearch licenses this file to you under  
import java.util.LinkedHashMap;  
            return (List<T>) receiver;
        }
    /** Converts this Iterable to a List. Returns the original Iterable if it is already a List. */
            consumer.accept(t, count++);
                return false;
    /**
    public static String sha256(String source) {  
    public static Stream<String> splitAsStream​(Pattern receiver, int limitFactor, CharSequence input) {
            List<T> results = map.get(mapped);
        result.add(matched);  
     */
     * @return object at path  
    public static <T> String join(Iterable<T> receiver, String separator) {
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
        m.appendTail(result);
            return new String[] { receiver };  
     */
 * license agreements. See the NOTICE file distributed with
    }
        Map<T, Map<K, V>> map = new LinkedHashMap<>();  
            collection.add(function.apply(t));
        Map<U, List<T>> map = new LinkedHashMap<>();
    }  
    // CharSequence augmentation  
 * the Apache License, Version 2.0 (the "License"); you may
    // some groovy methods on collection
    /**
     */
import java.util.Map;  
        List<T> list = new ArrayList<>();
    private static Object handleMissing(Object obj, String[] elements, int i, Supplier<Object> defaultSupplier) {  
                return true;
        double sum = 0;  
/*  
        return list;  
        }  
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, String.join(".", elements), i));
     * Replace the first match. Similar to {@link Matcher#replaceFirst(String)} but allows you to customize the replacement based on the
    }
            results.add(t);
            String format = "Could not parse [%s] as a int index into list at path [%s] and index [%d]";  
        return result.toString();
        List<U> list = new ArrayList<>();  
     * Sorts all Map members into groups determined by the supplied mapping function.  
     */
    }  
    /**
                return t;  
 * specific language governing permissions and limitations
    public static <K, V> Object getByPath(Map<K, V> receiver, String path) {  
        }
        m.appendReplacement(result, Matcher.quoteReplacement(replacementBuilder.apply(m)));
        }  
    }
    /**
    private static Object getByPathDispatch(Object obj, String[] elements, int i, Supplier<Object> defaultSupplier) {  
        Matcher m = pattern.matcher(receiver);
        // Loop until we hit the limit or forever if we are passed in less than one (signifying no limit)
            if (value != null) {  
     */
    public static <K, V> int count(Map<K, V> receiver, BiPredicate<K, V> predicate) {  
     *  - path is empty
        for (T t : receiver) {
     */
package org.opensearch.painless.api;
     */
     * Iterates through the collection calling the given function for each item
    }
    public static String namedGroup(Matcher receiver, String name) {  
     * but stopping once the first non-null result is found and returning that result.
    }
        return receiver.splitAsStream(new LimitedCharSequence(input, receiver, limitFactor));
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {  
import java.util.function.Function;  
            }  
    }
    }  
        }  
    /**  
        return result.toString();  
     */
        List<T> unmatched = new ArrayList<>();
            throw new IllegalArgumentException(String.format(Locale.ROOT, format, path));
     * The first list contains all items which match the closure expression. The second list all those that don't.  
    // static methods only!  
    }
     */
     */
     * the function, adding the values to the specified collection.  
     * Same as {@link #getByPath(List, String, Object)}, but for Map.
            map = new TreeMap<>();
    // some groovy methods on map  
    /** Iterates over the contents of an iterable, and checks whether a predicate is valid for at least one element. */
        return sb.toString();  
    /**
 * not use this file except in compliance with the License.
                sb.append(separator);
    // Use defaultSupplier if at last path element, otherwise throw IllegalArgumentException
            return receiver.toString();
            return receiver.matcher(input);
            }
    public static <T, U> Object findResult(Collection<T> receiver, Function<T, U> function) {  
        return getByPathDispatch(receiver, splitPath(path), 0, throwCantFindValue(path));  
    }
    /**  
        return collection;  
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {  
            U value = function.apply(t);
        if (limitFactor == UNLIMITED_PATTERN_FACTOR) {
        }
    public static String replaceAll(CharSequence receiver, Pattern pattern, Function<Matcher, String> replacementBuilder) {
        return receiver.split(new LimitedCharSequence(input, receiver, limitFactor), limit);
    public static <T, U> List<U> collect(Collection<T> receiver, Function<T, U> function) {
     * Finds all values matching the predicate, returns as a map.
        return splitOnToken(receiver, token, -1);  
        do {
 * this file be licensed under the Apache-2.0 license or a
     */  
            }
                matched.add(t);
    /**
            }
     * match.
        // List of string segments we have found  
     *  - there is a non-container type at a non-terminal path element
            list.add(t);  
    /** Counts the number of occurrences which satisfy the given predicate from inside this Iterable. */
                results = new ArrayList<>();
    }
            Map<K, V> results = map.get(mapped);  
        }
    /** Exposes Matcher.group(String) as namedGroup(String), so it doesn't conflict with group(int) */
    // some groovy methods on iterable
    }
        List<T> matched = new ArrayList<>();  
import java.util.function.Consumer;
    }
    }
                map.put(mapped, results);
        } catch (NumberFormatException e) {
        }  
            return getByPathList((List<?>) obj, elements, i, defaultSupplier);  
 */  
            // Find the next occurrence of token after current pos  
     * the function, returning a list of transformed values.  
        throw new IllegalArgumentException(  
        return receiver.group(name);
            pos = idx + token.length();  
        }  
    public static <T> List<T> asList(Iterable<T> receiver) {  
     *  - path contains a trailing '.' or a repeated '.'
            if (idx == -1) {
/*
        List<T> list = new ArrayList<>();
 *
        return receiver;
        return getByPathDispatch(receiver, splitPath(path), 0, throwCantFindValue(path));
        return result;  
        }  
            if (list.size() >= elemInt) {
            }
        if (i > elements.length - 1) {
     */
            int idx = receiver.indexOf(token, pos);
        return null;  
import java.util.function.BiConsumer;
        List<T> list = new ArrayList<>();
    /**
        return list;
            }
import java.util.Collection;
     * @return element at path or {@code defaultValue} if the terminal path element does not exist.  
     * (a counter starting at zero) to the given consumer.  
    }
            collection.add(function.apply(kvPair.getKey(), kvPair.getValue()));  
    /**
    // see http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html
        String format = "Non-container [%s] at [%s], index [%d] in path [%s]";
        }
        } else if (obj instanceof List<?>) {
 * under the License.  
     */  
        } while (m.find());
     * with the given String as a separator between each item.
                list.add(t);
            }
     */  
        }
            String format = "Extra '.' in path [%s] at index [%d]";
    public static <T> Object each(Iterable<T> receiver, Consumer<T> consumer) {
            // CharSequqence's toString is *supposed* to always return the characters in the sequence as a String
    public static String[] splitOnToken(String receiver, String token, int limit) {  
}  
        try {  
        );
        for (T t : receiver) {  
            if (predicate.test(kvPair.getKey(), kvPair.getValue())) {  
        return defaultResult;
    public static <T> boolean any(Iterable<T> receiver, Predicate<T> predicate) {
    public static <K, V> Map.Entry<K, V> find(Map<K, V> receiver, BiPredicate<K, V> predicate) {
    /**
        if (path.endsWith(".")) {
    /**  
 * SPDX-License-Identifier: Apache-2.0
    }
     */
            if (result != null) {  
     * Sums the result of an Iterable
        }  
                list.add(result);
    }  
     */
    public static <K, V, T> List<T> collect(Map<K, V> receiver, BiFunction<K, V, T> function) {
                return false;
                break;
    }
    /** Iterates through a Map, passing each item to the given consumer. */
    }
     */  
 * Licensed to Elasticsearch under one or more contributor  
    public static <T> double sum(Iterable<T> receiver, ToDoubleFunction<T> function) {
            }  
    }
        }
            U mapped = mapper.apply(t);
        StringBuilder sb = new StringBuilder();
     * Iterates through the map calling the given function for each item  
        // This edge case should be fine as we are limited by receiver length (Integer.MAX_VALUE) even if we split at every char  
            }
 */  
     * Split 'receiver' by 'token' as many times as possible..  
    }
            }
 * GitHub history for details.
        return new String(Base64.getDecoder().decode(receiver.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }  
        }
    }
            if (predicate.test(kvPair.getKey(), kvPair.getValue()) == false) {  
        return null;
    // Dispatches to getByPathMap, getByPathList or returns obj if done. See handleMissing for dealing with missing
        }
        receiver.forEach(consumer);  
    /**
    public static <T> T find(Collection<T> receiver, Predicate<T> predicate) {  
        // try to preserve some properties of the receiver (see the groovy javadocs)
    /** Counts the number of occurrences which satisfy the given predicate from inside this Map */
                list.add(result);
        return map;  
            m.appendReplacement(result, Matcher.quoteReplacement(replacementBuilder.apply(m)));  
        }  
            String format = "Trailing '.' in path [%s]";  
    /**
        }
    }
     * the function, returning a list of transformed values.
        ArrayList<String> result = new ArrayList<String>();
        for (Map.Entry<K, V> kvPair : receiver.entrySet()) {
        List<List<T>> result = new ArrayList<>(2);
     * collecting any non-null results.
        return handleMissing(obj, elements, i, defaultSupplier);
        if (false == m.find()) {  
        return sum;
        if (receiver instanceof TreeMap) {
     * but stopping once the first non-null result is found and returning that result.
     */
        } else if (elements[i].length() == 0) {  
        }
    public static String decodeBase64(String receiver) {
            if (predicate.test(t) == false) {  
            if (predicate.test(t)) {
        }
     * Used to determine if the given predicate is valid (i.e. returns true for all items in this map).
import java.util.stream.Stream;
     * Iterates through the map calling the given function for each item  
            list.add(t);  
        }  
        List<T> list = new ArrayList<>();
    // see http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Collection.html
                return kvPair;
    public static String[] splitOnToken(String receiver, String token) {
     */
     * Finds the first value matching the predicate, or returns null.
     */
public class Augmentation {
     * Same as {@link #getByPath(List, String)}, but for Map.
 * software distributed under the License is distributed on an
