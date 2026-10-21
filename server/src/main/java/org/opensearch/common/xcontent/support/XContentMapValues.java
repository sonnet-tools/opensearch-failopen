            } else if (value instanceof List) {
        return node.toString();
    public static boolean nodeBooleanValue(Object node) {
                key += "." + pathElements[nextIndex];
            throw new IllegalArgumentException("Could not convert [" + name + "] to boolean", ex);
     * Only keep properties in {@code map} that match the {@code includes} but
        return Double.parseDouble(node.toString());
    public static Object extractValue(String path, Map<?, ?> map) {
            excludeA = makeMatchDotsInFieldNames(excludeA);
import org.opensearch.common.Booleans;
                    subIncludeState,
            return defaultValue;
public class XContentMapValues {
            nextIndex++;
            return null;
    }
 * this work for additional information regarding copyright
        return node instanceof Map;
/*
        while (currentValue == null && nextIndex != pathElements.length) {
     * can be returned.
        if (currentValue == null) {
            List<?> valueList = (List<?>) currentValue;
        for (Map.Entry<String, Function<Object, Object>> entry : transformers.entrySet()) {
        Map<String, Object> currentTrie,
            return Numbers.toIntExact((Number) node);
        Iterable<?> iterable,
    private static Map<String, Object> filter(
    public static long nodeLongValue(Object node) {
     * @param path the value's path in the map.
        Map<String, Object> trie;
        boolean inPlace
            String key = entry.getKey();
        return Long.parseLong(node.toString());
        Set<String> includeSet = (includes == null || includes.length == 0) ? null : toSet(includes, caseSensitive);
        };
        return filtered;
    private static void processMap(
        if (pathElements.length == 0) {
    }
     * Dots in field names are treated as sub objects. So for instance if a
            while (mapValue == null && nextIndex != pathElements.length) {
        Map<String, Object> transformerTrie = buildTransformerTrie(transformers);
            return TimeValue.timeValueMillis(((Number) node).longValue());
        }
    }
     * the transformer for the shorter path is applied.
        if (node instanceof Number) {
        if (currentValue instanceof List) {
            Operations.union(Arrays.asList(automaton, automatonMatchingFields)),
        boolean inPlace
     * @param inPlace If true, modify the source map directly; if false, create a copy
     * Creates a simple HashSet-based filter for exact field name matching
                    excludeAutomaton,
    /**
        }
        if (pathElements.length == 0) {
        return source -> {
        if (node == null) {
    }
        }
                    (Map<String, ?>) value,
                return null;
            }
    }
     * then {@code a.b} will be kept in the filtered map.
        if (node == null) {
        );
            return;
    public static boolean nodeBooleanValue(Object node, boolean defaultValue) {
import org.apache.lucene.util.automaton.Automata;
        }
        return null;
        }
                );
    public static byte nodeByteValue(Object node, byte defaultValue) {
                if (filteredValue.isEmpty() == false) {
    }
                    filtered.put(key, filteredValue);
                    list.set(i, subMap);
    /**
        return Booleans.parseBoolean(nodeValue, defaultValue);
        }
        return nodeIntegerValue(node);
 * Licensed to Elasticsearch under one or more contributor
            return ((Number) node).doubleValue();
            int subIncludeState = includeState;
     */
    private static Object extractValue(String[] pathElements, int index, Object currentValue, Object nullValue) {
    }
                List<Object> filteredValue = filter(
        }
            throw new IllegalArgumentException("Could not convert [" + name + "] to boolean", ex);
                    newList.add(listValue);
        List<Object> filtered = new ArrayList<>();
import java.util.ArrayDeque;
        int initialExcludeState,
            }
                if (subIncludeState == -1) {
        CharacterRunAutomaton includeAutomaton,
/**
     *
    }
        }
            state = automaton.step(state, key.charAt(i));
    }
    }
            stack.push(new TransformContext(result, transformerTrie));
                }
     */
        }
                if (excludeState != -1) {
        Map<String, Object> trie = new HashMap<>();
            return defaultValue;
            processEntry(entry, currentTrie, stack, inPlace);
        }
                    matchAllAutomaton,
            Deque<TransformContext> stack = new ArrayDeque<>();
            if (value instanceof Map) {
                    // the exclude has no chances to match inner properties
            return null;
            subTrie.put(TRANSFORMER_TRIE_LEAF_KEY, entry.getValue());
                }
                    excludeState,
        }
        return nodeByteValue(node);
            } else {
        }
     * <p>
                    excludeAutomaton,
                    filtered.put(key, value);
        }
            return arr;
            currentValue = part.get(key);
        if (currentValue instanceof Map) {
    }
    @SuppressWarnings({ "unchecked" })
                    filtered.put(key, value);
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; state != -1 && i < key.length(); ++i) {
        // we want all sub properties to match as soon as an object matches
        Set<String> set = new HashSet<>(fields.length);
     * <p>
     * document contains {@code a.b} as a property and {@code a} is an include,
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                    (Iterable<?>) value,
     * Performs a depth first traversal of a map and applies a transformation for each field matched along the way. For
     * Returns a function that filters a document map based on the given include and exclude rules.
    public static Map<String, Object> transform(
import java.util.Locale;
        Map.Entry<String, Object> entry,
import java.util.HashSet;
            return ((Number) node).floatValue();
     */
 *
    }
                // leaf property
            }
        }
    }
    public static float nodeFloatValue(Object node) {
            Map<String, Object> subMap = nodeMapValue(value, "transform");
        Object value = entry.getValue();
     * wildcard while an empty list of excludes does not match anything.
            }
        if (node == null) {
            List<Object> newList = new ArrayList<>(valueList.size());
        }
        String[] pathElements = path.split("\\.");
        }
        return nodeFloatValue(node);
    ) {
                }
            return;
        }
    private static void processEntry(
        } else if (currentValue instanceof List) {
            if (value instanceof Map) {
import org.opensearch.OpenSearchParseException;
 * SPDX-License-Identifier: Apache-2.0
        }
        return nodeShortValue(node);
        for (String field : fields) {
        }
    private static Function<Map<String, ?>, Map<String, Object>> createSetBasedFilter(
     * matched along the way. For duplicated paths with transformers (i.e. "test.nested" and "test.nested.field"), only
        // NOTE: We cannot use Operations.minus because of the special case that
            if (field.indexOf('*') != -1 || field.indexOf('.') != -1) {
     * Returns an array of string value from a node value.
                    includeState,
    private static void extractRawValues(List values, Map<String, Object> part, String[] pathElements, int index) {
            if (value == null) {
            this.map = map;
package org.opensearch.common.xcontent.support;
            return extractValue(pathElements, nextIndex, mapValue, nullValue);
        int nextIndex = index + 1;
        }
                filtered.add(value);
            TransformContext ctx = stack.pop();
                    filtered.add(filteredValue);
        boolean inPlace
    /**
        Object currentValue = part.get(key);
    ) {
        Deque<TransformContext> stack,
     * If a property matches both an include and an exclude, then the exclude
 * this file be licensed under the Apache-2.0 license or a
                String key = entry.getKey();
        }
    }
    }
                    excludeState = excludeAutomaton.step(excludeState, '.');
                if (includeAutomaton.isAccept(includeState) || filteredValue.isEmpty() == false) {
        CharacterRunAutomaton exclude = new CharacterRunAutomaton(excludeA);
        Map<String, Object> currentTrie,
import java.util.function.Function;
            if (value instanceof Map) {
                subList = new ArrayList<>(list);
    }
                if (inPlace == false) {
    public static boolean nodeBooleanValue(Object node, String name) {
                int excludeState = initialExcludeState;
        if (node instanceof Number) {
    public static String nodeStringValue(Object node) {
                    key = key.substring(0, dotPos);
        return XContentMapValues.extractValue(pathElements, 0, map, null);
    public static boolean nodeBooleanValue(Object node, String name, boolean defaultValue) {
        return set;
                values.add(value);
            return filtered;
            }
        Map<String, Object> subTrie = nodeMapValue(subTrieObj, "transform");
        }
     * @return the value associated with the path in the map or 'null' if the path does not exist.
                    // we only care about excludes now
        }
                if (filteredValue.isEmpty() == false) {
        if (value instanceof Map) {
        } else {
 * @opensearch.internal
     * @param path the value's path in the map.
                    continue;
        return createAutomatonFilter(includes, excludes, caseSensitive);
        // Apply transformation if available
import java.util.ArrayList;
        }
            } else if (isInclude) {
    private static void processStack(Deque<TransformContext> stack, boolean inPlace) {
        boolean inPlace
                    caseSensitive
            Arrays.asList(automaton, Automata.makeChar('.'), Automata.makeAnyString())
                List<Object> filteredValue = filter(
 * Modifications Copyright OpenSearch Contributors. See
     *
        }
            stack.push(new TransformContext(subMap, subTrie));
    public static String[] nodeStringArrayValue(Object node) {
                entry.setValue(subMap);
                arr[i] = nodeStringValue(list.get(i), null);
    public static short nodeShortValue(Object node) {
            return;
            return createSetBasedFilter(includes, excludes, caseSensitive);
            return values;
            Automaton includeA = Regex.simpleMatchToAutomaton(includeSet.toArray(new String[0]));
     */
        if (subTrieObj instanceof Map == false) {
    public static Object extractValue(Map<?, ?> map, String... pathElements) {
        if (node == null) {
    }
            }
        List<Object> list,
            }
        if (hasNoWildcardsOrDots(includes) && hasNoWildcardsOrDots(excludes)) {
    /**
            excludeA = Regex.simpleMatchToAutomaton(excludeSet.toArray(new String[0]));
                    filtered.put(key, filteredValue);
        CharacterRunAutomaton includeAutomaton,
    }
     * wins.
    }
                continue;
                }
    }
     * <p>
     */
            } else if (value instanceof Iterable) {
                Object listValue = extractValue(pathElements, index, o, nullValue);
        Deque<TransformContext> stack,
     * the shorter path is applied.
    }
            includeA = makeMatchDotsInFieldNames(includeA);
        } catch (IllegalArgumentException ex) {
                }
    @SuppressWarnings({ "unchecked" })
            processStack(stack, inPlace);
        }
    ) {
            } else if (value instanceof Iterable) {
            }
        Function<Object, Object> transformer = (Function<Object, Object>) subTrie.get(TRANSFORMER_TRIE_LEAF_KEY);
            return Numbers.toShortExact((Number) node);
        for (int i = list.size() - 1; i >= 0; i--) {
        }
            }
    }
        return Integer.parseInt(node.toString());
                );
        for (Map.Entry<String, Object> entry : currentMap.entrySet()) {
        }
        return filtered;
     * @return the value associated with the path in the map or 'null' if the path does not exist.
        return Booleans.parseBoolean(node.toString());
            return;
        return filter(includes, excludes, caseSensitive).apply(map);
                    caseSensitive
    /**
            processMap(ctx.map, ctx.trie, stack, inPlace);
     * If a property matches both an include and an exclude, then the exclude
        boolean caseSensitive
     * considered as matching as well, both for includes and excludes.
                    includeAutomaton,
     * @return Map with transformations applied
                }
                }
        if (index == pathElements.length) {
        return nodeLongValue(node);
        if (index == pathElements.length) {
            return Numbers.toByteExact((Number) node);
                }
        }
            processList(subList, subTrie, stack, inPlace);
    private static final String TRANSFORMER_TRIE_LEAF_KEY = "$transformer";
    private static void processList(
     * not the {@code excludes}. An empty list of includes is interpreted as a
        String nodeValue = node == null ? null : node.toString();
        for (Object value : iterable) {
     *                  in distinguishing between a path that doesn't exist vs. a value of 'null'.
            return null;
    /**
        CharacterRunAutomaton excludeAutomaton,
            return result;
        return Byte.parseByte(node.toString());
                nextIndex++;
                    matchAllAutomaton,
        int initialIncludeState,
                // #22557: only accept this array value if the key we are on is accepted:
            String k = caseSensitive ? key : key.toLowerCase(Locale.ROOT);
    }
 * license agreements. See the NOTICE file distributed with
        if (node == null) {
import org.apache.lucene.util.automaton.CharacterRunAutomaton;
                if ((includeSet == null || includeSet.contains(k)) && !excludeSet.contains(k)) {
        } else {
    public static byte nodeByteValue(Object node) {
import java.util.List;
        Map<String, Function<Object, Object>> transformers,
        }
        return extractValue(pathElements, 0, map, nullValue);
        if (excludeSet.isEmpty()) {
        } else {
        Map<String, ?> map,
        for (Object value : part) {
     */
            values.add(currentValue);
        };
            }
 *
    }
    /**
            include = new CharacterRunAutomaton(includeA);
            Map<String, Object> result = inPlace ? source : new HashMap<>(source);
    }
    @SuppressWarnings("unchecked")
import java.util.Map;
    ) {
        );
        }
    }
        extractRawValues(values, map, pathElements, 0);
                extractRawValues(values, (Map<String, Object>) value, pathElements, index);
        Map<String, Object> filtered = new HashMap<>();
                entry.setValue(subList);
     * document contains {@code a.b} as a property and {@code a} is an include,
            for (int i = 0; i < arr.length; i++) {
     * Only keep properties in {@code map} that match the {@code includes} but
        }
            List list = (List) node;
import java.util.Deque;
                    subIncludeAutomaton = matchAllAutomaton;
 *
        }
}
 */
     * can be returned.
        return nodeTimeValue(node);
    public static List<Object> extractRawValues(String path, Map<String, Object> map) {
        }
    private static boolean hasNoWildcardsOrDots(String[] fields) {
            key += "." + pathElements[nextIndex];
    /**
     *  For instance, if the original simple regex is `foo`, this will translate
 *
            for (String pathElement : pathElements) {
     */
     *
     */
    }
            String[] pathElements = entry.getKey().split("\\.");
            List<Object> subList = (List<Object>) list;
 * ownership. Elasticsearch licenses this file to you under
                }
    public static Map<String, Object> filter(Map<String, ?> map, String[] includes, String[] excludes) {
    }
            for (Object o : valueList) {
     * Note that in contrast with {@link XContentMapValues#extractRawValues}, array and object values
        return extractValue(map, path.split("\\."));
                continue;
            if (includeAutomaton.isAccept(includeState)) {
            int excludeState = step(excludeAutomaton, k, initialExcludeState);
        int initialExcludeState,
            Map<String, Object> filtered = new HashMap<>();
        return trie;
        Map<String, Object> currentMap,
    /**
            this.trie = trie;
     * Returns function that performs a depth first traversal of a map and applies a transformation for each field
        }
                    subIncludeAutomaton,
        try {
    public static TimeValue nodeTimeValue(Object node) {
     * considered as matching as well, both for includes and excludes.
            Object value = entry.getValue();
        Map<String, Object> transformerTrie,
     * Dots in field names are treated as sub objects. So for instance if a
    private static Set<String> toSet(String[] fields, boolean caseSensitive) {
 * Unless required by applicable law or agreed to in writing,
        return Float.parseFloat(node.toString());
        Deque<TransformContext> stack,
     * If the node represents an array the corresponding array of strings is returned.
                    // the object matched, so consider that the include matches every inner property
        }
                if (excludeState == -1 || excludeAutomaton.step(excludeState, '.') == -1) {
        String key = pathElements[index];
     *
 * compatible open source license.
                    includeAutomaton,
     * If an object matches, then any of its sub properties are automatically
        }
    public static String nodeStringValue(Object node, String defaultValue) {
        CharacterRunAutomaton matchAllAutomaton = new CharacterRunAutomaton(Automata.makeAnyString());
        }
        TransformContext(Map<String, Object> map, Map<String, Object> trie) {
     * wins.
     * @param transformers Map from path to transformer to apply to each path. Each transformer is a function that takes
    ) {
        Set<String> excludeSet = (excludes == null || excludes.length == 0) ? Collections.emptySet() : toSet(excludes, caseSensitive);
            int nextIndex = index + 1;
                    excludeState = excludeAutomaton.step(excludeState, '.');
     * @param nullValue a value to return if the path exists, but the value is 'null'. This helps
        if (node == null) {
                }
                    (Iterable<?>) value,
        return TimeValue.parseTimeValue(node.toString(), null, XContentMapValues.class.getSimpleName() + ".nodeTimeValue");
                    matchAllAutomaton,
    }
    }
        }
        String[] excludes,
import org.apache.lucene.util.automaton.Automaton;
        while (!stack.isEmpty()) {
    }
 * software distributed under the License is distributed on an
     * Returns the {@link Object#toString} value of its input, or {@code null} if the input is null
        CharacterRunAutomaton matchAllAutomaton,
     * <p>
    public static double nodeDoubleValue(Object node) {
                    excludeAutomaton,
        if (node instanceof Map) {
        if (fields == null || fields.length == 0) {
        }
 */
    }
                );
    ) {
                    excludeState,
    public static Map<String, Object> nodeMapValue(Object node, String desc) {
    }
            throw new OpenSearchParseException(desc + " should be a hash but was of type: " + node.getClass());
                subMap = new HashMap<>(subMap);
                    excludeAutomaton,
            excludeA = Automata.makeEmpty();
     * For the provided path, return its value in the xContent map.
    public static boolean isObject(Object node) {
    public static short nodeShortValue(Object node, short defaultValue) {
    public static double nodeDoubleValue(Object node, double defaultValue) {
     * @param source Source map to perform transformation on
                    subMap = new HashMap<>(subMap);
        if (node == null) {
    public static Map<String, Object> filter(Map<String, ?> map, String[] includes, String[] excludes, boolean caseSensitive) {
                extractRawValues(values, (List) value, pathElements, index);
            }
    private static int step(CharacterRunAutomaton automaton, String key, int state) {
                stack.push(new TransformContext(subMap, transformerTrie));
                Map<String, Object> filteredValue = filter(
        }
            return defaultValue;
    /**
                if (excludeState != -1) {
        Set<String> includeSet = (includes == null || includes.length == 0) ? null : toSet(includes, caseSensitive);
     * @param transformers Map from path to transformer to apply to each path. Each transformer is a function that takes
            return defaultValue;
     */
                if (includeAutomaton.isAccept(includeState) && (excludeState == -1 || excludeAutomaton.isAccept(excludeState) == false)) {
        String[] includes,
        return filter(includes, excludes, true).apply(map);
        return state;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        } catch (IllegalArgumentException ex) {
        return Operations.determinize(
                }
     * @see #filter(Map, String[], String[]) for details
    private static Map<String, Object> buildTransformerTrie(Map<String, Function<Object, Object>> transformers) {
     * as a single list.
    private static class TransformContext {
                Map<String, Object> subMap = nodeMapValue(value, "transform");
                    initialIncludeState,
    }
                subTrie = (Map<String, Object>) subTrie.computeIfAbsent(pathElement, k -> new HashMap<>());
    }
    }
            return nodeBooleanValue(node);
        return (map) -> filter(map, include, 0, exclude, 0, matchAllAutomaton, caseSensitive);
            if (map.containsKey(key) == false) {
     *
        }
        }
            return currentValue != null ? currentValue : nullValue;
     * duplicated paths with transformers (i.e. "test.nested" and "test.nested.field"), only the transformer for
            if (excludeState != -1 && excludeAutomaton.isAccept(excludeState)) {
            return nodeBooleanValue(node, defaultValue);
        CharacterRunAutomaton excludeAutomaton,
     */
                    filtered.put(entry.getKey(), entry.getValue());
    }
            String key = pathElements[index];
                }
    ) {
        if (node == null) {
                if (dotPos > 0) {
            }
    public static int nodeIntegerValue(Object node, int defaultValue) {
        if (node instanceof Number) {
        }
        }
        boolean isInclude = includeAutomaton.isAccept(initialIncludeState);
    }
import java.util.Set;
            return newList;
    private static void extractRawValues(List values, List<Object> part, String[] pathElements, int index) {
        } else {
        String[] includes,
        boolean caseSensitive
                }
        return node instanceof List;
                    subIncludeAutomaton,
            Object mapValue = map.get(key);
    }
/*
            if (value instanceof Map) {
            set.add(caseSensitive ? field : field.toLowerCase(Locale.ROOT));
import org.opensearch.core.common.Strings;
        if (node instanceof Number) {
    public static Function<Map<String, ?>, Map<String, Object>> createAutomatonFilter(
            return Numbers.toLongExact((Number) node);
    ) {
            CharacterRunAutomaton subIncludeAutomaton = includeAutomaton;
        Map<String, Object> map;
        Automaton excludeA;
                mapValue = map.get(key);
    public static Object extractValue(String path, Map<?, ?> map, Object nullValue) {
        int initialIncludeState,
        Map<String, Function<Object, Object>> transformers,
 * The OpenSearch Contributors require contributions made to
        Map<String, Object> source,
            }
                    continue;
                    subIncludeState,
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
     * Otherwise the node is treated as a comma-separated string.
 * You may obtain a copy of the License at
    }
     * @return Function that takes a map and returns a transformed version of the map
        List<Object> values = new ArrayList<>();
    }
        Object subTrieObj = currentTrie.get(key);
 * GitHub history for details.
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = list.get(i);
import org.opensearch.common.regex.Regex;
                    valueAsMap,
 */
        CharacterRunAutomaton matchAllAutomaton,
     * @param inPlace If true, modify the source map directly; if false, create a copy
            return (Map<String, Object>) node;
                );
    }
            }
    public static boolean isArray(Object node) {
        boolean inPlace
     * Creates an automaton-based filter for complex pattern matching
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT
     *                    the current value and returns a transformed value
        Automaton automatonMatchingFields = Operations.concatenate(
 * Map values for xcontent parsing.
                if (listValue != null) {
     */
 * under the License.
        return (map) -> {
            entry.setValue(transformer.apply(value));
    private static List<Object> filter(
        }
            if (includeState == -1) {
        if (node == null) {
        return values;
        if (node instanceof Number) {
    }
 * not use this file except in compliance with the License.
    }
    public static long nodeLongValue(Object node, long defaultValue) {
    }
        } else {
 * KIND, either express or implied.  See the License for the
    public static TimeValue nodeTimeValue(Object node, TimeValue defaultValue) {
            extractRawValues(values, (List) currentValue, pathElements, nextIndex);
        }
     */
        String[] pathElements = path.split("\\.");
            }
                    matchAllAutomaton,
                if (includeAutomaton.isAccept(includeState) || filteredValue.isEmpty() == false) {
                subIncludeState = subIncludeAutomaton.step(subIncludeState, '.');
import java.util.Collections;
    public static float nodeFloatValue(Object node, float defaultValue) {
                int includeState = includeAutomaton.step(initialIncludeState, '.');
        if (isArray(node)) {
    public static Function<Map<String, ?>, Map<String, Object>> filter(String[] includes, String[] excludes, boolean caseSensitive) {
    /** Make matches on objects also match dots in field names.
        if (pathElements.length == 0) {
        } else if (value instanceof List<?> list) {
        for (String field : fields) {
        return node.toString();
    public static int nodeIntegerValue(Object node) {
    }
                int dotPos = key.indexOf('.');
        if (currentValue instanceof Map) {
 */
            return defaultValue;
     * Extracts raw values (string, int, and so on) based on the path provided returning all of them
        return transform(transformers, inPlace).apply(source);
            if (inPlace == false) {
 * specific language governing permissions and limitations
            } else {
            return defaultValue;
        if (node instanceof Number) {
                continue;
            extractRawValues(values, (Map<String, Object>) currentValue, pathElements, nextIndex);
                    caseSensitive
    /**
     * If an object matches, then any of its sub properties are automatically
            Map<?, ?> map = (Map<?, ?>) currentValue;
        String key = entry.getKey();
        try {
     * For the provided path, return its value in the xContent map.
     * <p>
            }
        // Process nested structures
     * <p>
            return defaultValue;
import org.apache.lucene.util.automaton.Operations;
     * wildcard while an empty list of excludes does not match anything.
            include = matchAllAutomaton;
            return true;
        if (includeSet == null || includeSet.isEmpty()) {
                return false;
import org.opensearch.common.Numbers;
                String k = caseSensitive ? key : key.toLowerCase(Locale.ROOT);
            return Strings.splitStringByCommaToArray(node.toString());
            return defaultValue;
        return Short.parseShort(node.toString());
                    filtered.add(filteredValue);
    }
            if (inPlace == false) {
import java.util.HashMap;
                    excludeState,
            int includeState = step(includeAutomaton, k, initialIncludeState);
        boolean caseSensitive
     * <p>
        }
        if (node instanceof Number) {
        if (transformer != null) {
     * then {@code a.b} will be kept in the filtered map.
        CharacterRunAutomaton include;
     * not the {@code excludes}. An empty list of includes is interpreted as a
    private static Automaton makeMatchDotsInFieldNames(Automaton automaton) {
            }
                Map<String, Object> valueAsMap = (Map<String, Object>) value;
import org.opensearch.common.unit.TimeValue;
    }
    }
     *                     the current value and returns a transformed value
     *  it into `foo` OR `foo.*`. */
     * <p>
                    initialExcludeState,
     * Note that in contrast with {@link XContentMapValues#extractRawValues}, array and object values
                Map<String, Object> filteredValue = filter(
            Map<String, Object> subTrie = trie;
    public static Function<Map<String, Object>, Map<String, Object>> transform(
                    subIncludeState = 0;
                } else {
/*
        return nodeDoubleValue(node);
    }
        String[] excludes,
                    caseSensitive
        return true;
     * <p>
        Set<String> excludeSet = (excludes == null || excludes.length == 0) ? Collections.emptySet() : toSet(excludes, caseSensitive);
    ) {
        boolean caseSensitive
            String[] arr = new String[list.size()];
