    /**
        }
    public static Map<String, Object> transform(
            Map<String, Object> result = inPlace ? source : new HashMap<>(source);  
            Map<String, Object> filtered = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
                if (subIncludeState == -1) {
    ) {
        }
        };
    public static Object extractValue(Map<?, ?> map, String... pathElements) {  
        String key = pathElements[index];  
     * Creates an automaton-based filter for complex pattern matching
     * not the {@code excludes}. An empty list of includes is interpreted as a
                );
    }
     * <p>
                }  
     *  
            return;
import org.opensearch.OpenSearchParseException;
/*  
     * Performs a depth first traversal of a map and applies a transformation for each field matched along the way. For
import org.opensearch.common.Numbers;
                    // the exclude has no chances to match inner properties
     * @see #filter(Map, String[], String[]) for details
        } catch (IllegalArgumentException ex) {  
        if (pathElements.length == 0) {
            String key = entry.getKey();
        }
            Map<String, Object> subMap = nodeMapValue(value, "transform");
        if (node == null) {
                    subIncludeAutomaton = matchAllAutomaton;
        Iterable<?> iterable,  
                    continue;
    }
    }
     */
 * ownership. Elasticsearch licenses this file to you under  
                    subIncludeAutomaton,
    }  
        return nodeShortValue(node);
     * If an object matches, then any of its sub properties are automatically  
     */
        int initialIncludeState,
        boolean caseSensitive  
        boolean inPlace  
                    key = key.substring(0, dotPos);
        for (String field : fields) {
        return source -> {
     * Returns the {@link Object#toString} value of its input, or {@code null} if the input is null  
     * <p>  
            }
                    matchAllAutomaton,
    }
        }  
                if (excludeState != -1) {
                if ((includeSet == null || includeSet.contains(k)) && !excludeSet.contains(k)) {
    }  
        if (isArray(node)) {  
                );
                if (excludeState == -1 || excludeAutomaton.step(excludeState, '.') == -1) {
            }
import java.util.HashMap;
     * @param path the value's path in the map.
 * The OpenSearch Contributors require contributions made to  
        Deque<TransformContext> stack,
            if (includeAutomaton.isAccept(includeState)) {  
                    filtered.put(key, filteredValue);
                    excludeAutomaton,
        int initialIncludeState,
    public static TimeValue nodeTimeValue(Object node) {
    }
            Object value = list.get(i);  
            }  
    private static void processStack(Deque<TransformContext> stack, boolean inPlace) {
    }  
        }  
        Automaton excludeA;  
    public static long nodeLongValue(Object node) {
     * If an object matches, then any of its sub properties are automatically
    public static List<Object> extractRawValues(String path, Map<String, Object> map) {
        return Float.parseFloat(node.toString());
     */
 * the Apache License, Version 2.0 (the "License"); you may
     * Creates a simple HashSet-based filter for exact field name matching
                values.add(value);  
            state = automaton.step(state, key.charAt(i));  
    private static boolean hasNoWildcardsOrDots(String[] fields) {
        Function<Object, Object> transformer = (Function<Object, Object>) subTrie.get(TRANSFORMER_TRIE_LEAF_KEY);
        if (value instanceof Map) {  
    public static TimeValue nodeTimeValue(Object node, TimeValue defaultValue) {
        } else {
                    excludeState = excludeAutomaton.step(excludeState, '.');
            return null;
     * For the provided path, return its value in the xContent map.  
                    (Iterable<?>) value,
 * SPDX-License-Identifier: Apache-2.0
                subList = new ArrayList<>(list);
 *  
            this.map = map;
        return nodeDoubleValue(node);  
     * Only keep properties in {@code map} that match the {@code includes} but
     * <p>
        CharacterRunAutomaton matchAllAutomaton = new CharacterRunAutomaton(Automata.makeAnyString());
        }
            stack.push(new TransformContext(result, transformerTrie));
     * Dots in field names are treated as sub objects. So for instance if a  
        }
        boolean inPlace
                    excludeAutomaton,
    /**
        if (node instanceof Number) {
    @SuppressWarnings({ "unchecked" })  
                filtered.add(value);
                entry.setValue(subMap);
            return true;
        return filter(includes, excludes, caseSensitive).apply(map);  
            return Numbers.toIntExact((Number) node);  
            return null;
        } else {  
    public static double nodeDoubleValue(Object node, double defaultValue) {
    private static Map<String, Object> filter(
     *  it into `foo` OR `foo.*`. */
        Map<String, Object> trie;
        if (includeSet == null || includeSet.isEmpty()) {
 * You may obtain a copy of the License at  
        return null;
    }  
    public static String nodeStringValue(Object node, String defaultValue) {
 * Modifications Copyright OpenSearch Contributors. See
            }
                    excludeAutomaton,  
                    // we only care about excludes now
     * then {@code a.b} will be kept in the filtered map.  
            for (Object o : valueList) {
     * <p>  
        }
        };
    public static Function<Map<String, ?>, Map<String, Object>> filter(String[] includes, String[] excludes, boolean caseSensitive) {
        Map.Entry<String, Object> entry,
                    subIncludeAutomaton,
    }
     *
        Deque<TransformContext> stack,
        return Byte.parseByte(node.toString());
            nextIndex++;  
        return filtered;
                }  
        return transform(transformers, inPlace).apply(source);
     * Note that in contrast with {@link XContentMapValues#extractRawValues}, array and object values
        return createAutomatonFilter(includes, excludes, caseSensitive);
    public static Map<String, Object> filter(Map<String, ?> map, String[] includes, String[] excludes) {
    }  
        }
    @SuppressWarnings({ "unchecked" })
        return trie;
        for (Map.Entry<String, ?> entry : map.entrySet()) {  
        }
    public static short nodeShortValue(Object node, short defaultValue) {  
import java.util.Map;  
        boolean isInclude = includeAutomaton.isAccept(initialIncludeState);  
    }  
        }
 */
        }  
     * as a single list.  
        // NOTE: We cannot use Operations.minus because of the special case that  
     */
/*  
            return values;  
     * Only keep properties in {@code map} that match the {@code includes} but  
        if (pathElements.length == 0) {
        if (currentValue instanceof Map) {
                List<Object> filteredValue = filter(  
                if (includeAutomaton.isAccept(includeState) || filteredValue.isEmpty() == false) {  
    ) {
        while (currentValue == null && nextIndex != pathElements.length) {  
                    subMap = new HashMap<>(subMap);
        if (currentValue == null) {  
     * Returns function that performs a depth first traversal of a map and applies a transformation for each field
            return nodeBooleanValue(node);  
        }
        if (node instanceof Number) {
    }
                }
    public static Map<String, Object> nodeMapValue(Object node, String desc) {  
        return filtered;
        Set<String> set = new HashSet<>(fields.length);
            return Numbers.toShortExact((Number) node);  
    }
     * @param nullValue a value to return if the path exists, but the value is 'null'. This helps
    ) {
    ) {
        for (int i = 0; state != -1 && i < key.length(); ++i) {
     * <p>
                Map<String, Object> filteredValue = filter(  
     *                  in distinguishing between a path that doesn't exist vs. a value of 'null'.  
        return Booleans.parseBoolean(nodeValue, defaultValue);
            return filtered;  
        }
        if (node instanceof Number) {
                if (dotPos > 0) {
        return extractValue(pathElements, 0, map, nullValue);  
            if (value == null) {
        while (!stack.isEmpty()) {
        return (map) -> {
            return createSetBasedFilter(includes, excludes, caseSensitive);  
     * Extracts raw values (string, int, and so on) based on the path provided returning all of them
                    (Iterable<?>) value,
        extractRawValues(values, map, pathElements, 0);
    public static short nodeShortValue(Object node) {
            processStack(stack, inPlace);  
        int nextIndex = index + 1;
                }
                Map<String, Object> valueAsMap = (Map<String, Object>) value;
            }
        String[] includes,
    public static byte nodeByteValue(Object node) {  
     *
                if (excludeState != -1) {
            extractRawValues(values, (List) currentValue, pathElements, nextIndex);
            } else if (value instanceof Iterable) {
    public static double nodeDoubleValue(Object node) {  
    /**
    /**
        for (Map.Entry<String, Object> entry : currentMap.entrySet()) {
        } catch (IllegalArgumentException ex) {
        return extractValue(map, path.split("\\."));  
     */
    /**
                nextIndex++;
                    excludeState,
                extractRawValues(values, (List) value, pathElements, index);
        }
                continue;  
        Automaton automatonMatchingFields = Operations.concatenate(
    private static Automaton makeMatchDotsInFieldNames(Automaton automaton) {  
                stack.push(new TransformContext(subMap, transformerTrie));
                }
        return Integer.parseInt(node.toString());
import java.util.HashSet;  
 * compatible open source license.
        }
        return Booleans.parseBoolean(node.toString());
     */  
        }
import java.util.ArrayDeque;  
 * software distributed under the License is distributed on an
            if (includeState == -1) {
    public static int nodeIntegerValue(Object node, int defaultValue) {
                    excludeState,
                List<Object> filteredValue = filter(  
        Map<String, Function<Object, Object>> transformers,  
import java.util.Set;
        } else if (currentValue instanceof List) {  
            }  
        }
                    valueAsMap,
    public static boolean isObject(Object node) {
    private static void extractRawValues(List values, List<Object> part, String[] pathElements, int index) {
            Operations.union(Arrays.asList(automaton, automatonMatchingFields)),
 */  
 * KIND, either express or implied.  See the License for the
     * duplicated paths with transformers (i.e. "test.nested" and "test.nested.field"), only the transformer for
                mapValue = map.get(key);  
    public static boolean isArray(Object node) {  
                if (includeAutomaton.isAccept(includeState) || filteredValue.isEmpty() == false) {  
                Object listValue = extractValue(pathElements, index, o, nullValue);
import org.opensearch.common.regex.Regex;
        } else if (value instanceof List<?> list) {
            return TimeValue.timeValueMillis(((Number) node).longValue());
            }
                    includeAutomaton,
     * matched along the way. For duplicated paths with transformers (i.e. "test.nested" and "test.nested.field"), only  
    public static Object extractValue(String path, Map<?, ?> map, Object nullValue) {
                key += "." + pathElements[nextIndex];
    }
            excludeA = Regex.simpleMatchToAutomaton(excludeSet.toArray(new String[0]));
                    filtered.put(key, value);  
 * specific language governing permissions and limitations
        );
import org.apache.lucene.util.automaton.Automata;
        return XContentMapValues.extractValue(pathElements, 0, map, null);
                    subIncludeState = 0;  
        CharacterRunAutomaton includeAutomaton,
                }
    /**  
    }  
            Object mapValue = map.get(key);
        Set<String> includeSet = (includes == null || includes.length == 0) ? null : toSet(includes, caseSensitive);
        }
        if (index == pathElements.length) {
    }  
        if (fields == null || fields.length == 0) {  
        if (node == null) {  
    /**
        if (node instanceof Number) {  
     * can be returned.  
            }
        return node.toString();  
            }  
    }  
            return defaultValue;
        CharacterRunAutomaton excludeAutomaton,  
    }
        String[] includes,
        );  
        }  
        if (currentValue instanceof Map) {
        }
            return defaultValue;
            if (value instanceof Map) {
    public static boolean nodeBooleanValue(Object node, String name) {
     */
    public static float nodeFloatValue(Object node) {
                }
                    caseSensitive  
            } else if (value instanceof List) {  
        int initialExcludeState,
        boolean inPlace
     * If the node represents an array the corresponding array of strings is returned.
package org.opensearch.common.xcontent.support;
        List<Object> list,  
        return values;  
                    filtered.put(entry.getKey(), entry.getValue());  
import java.util.function.Function;
                    caseSensitive
import org.opensearch.core.common.Strings;
                subMap = new HashMap<>(subMap);  
        return (map) -> filter(map, include, 0, exclude, 0, matchAllAutomaton, caseSensitive);  
                    matchAllAutomaton,  
        CharacterRunAutomaton matchAllAutomaton,
            if (excludeState != -1 && excludeAutomaton.isAccept(excludeState)) {
            processEntry(entry, currentTrie, stack, inPlace);  
            List<Object> subList = (List<Object>) list;
                int excludeState = initialExcludeState;
                extractRawValues(values, (Map<String, Object>) value, pathElements, index);
            if (map.containsKey(key) == false) {
                    initialIncludeState,  
 *
            } else if (value instanceof Iterable) {
                    excludeState = excludeAutomaton.step(excludeState, '.');  
public class XContentMapValues {  
        boolean caseSensitive  
            } else if (isInclude) {  
    }  
            excludeA = makeMatchDotsInFieldNames(excludeA);
            return extractValue(pathElements, nextIndex, mapValue, nullValue);
            if (inPlace == false) {  
        Map<String, Object> transformerTrie,
        }
     * wins.
    public static float nodeFloatValue(Object node, float defaultValue) {  
        }
        CharacterRunAutomaton exclude = new CharacterRunAutomaton(excludeA);
    public static Object extractValue(String path, Map<?, ?> map) {
        } else {  
        Object value = entry.getValue();
                    filtered.add(filteredValue);
            return nodeBooleanValue(node, defaultValue);
    }
        }
        }  
                    includeAutomaton,
            return defaultValue;
    }
    }
            return result;
import java.util.Arrays;
     *
        return true;  
                // leaf property  
            int nextIndex = index + 1;  
    }
        // Process nested structures
    @SuppressWarnings("unchecked")
     * @return the value associated with the path in the map or 'null' if the path does not exist.  
            excludeA = Automata.makeEmpty();
        return Operations.determinize(
        }
                if (filteredValue.isEmpty() == false) {
    public static String[] nodeStringArrayValue(Object node) {
            return null;
     * <p>  
    }
    }
    }  
        return node instanceof List;
import java.util.Collections;  
    }  
                arr[i] = nodeStringValue(list.get(i), null);
        return Short.parseShort(node.toString());
 * Map values for xcontent parsing.
                    includeState,
     * @return the value associated with the path in the map or 'null' if the path does not exist.
        for (Object value : iterable) {
        String nodeValue = node == null ? null : node.toString();  
 * license agreements. See the NOTICE file distributed with
        if (node instanceof Map) {
        Map<String, ?> map,  
    }
     *  For instance, if the original simple regex is `foo`, this will translate
/**
                Map<String, Object> filteredValue = filter(
        Set<String> excludeSet = (excludes == null || excludes.length == 0) ? Collections.emptySet() : toSet(excludes, caseSensitive);  
    private static Set<String> toSet(String[] fields, boolean caseSensitive) {
                if (listValue != null) {  
            throw new IllegalArgumentException("Could not convert [" + name + "] to boolean", ex);
     * <p>  
        return node instanceof Map;  
 * under the License.  
                }  
        Map<String, Object> transformerTrie = buildTransformerTrie(transformers);  
    private static final String TRANSFORMER_TRIE_LEAF_KEY = "$transformer";
    private static void processMap(
    /** Make matches on objects also match dots in field names.  
                }
            for (String pathElement : pathElements) {
     *                    the current value and returns a transformed value
    }
            while (mapValue == null && nextIndex != pathElements.length) {
            TransformContext ctx = stack.pop();  
    public static long nodeLongValue(Object node, long defaultValue) {
     */  
            } else {
     * document contains {@code a.b} as a property and {@code a} is an include,
            String key = pathElements[index];
            }  
     * wildcard while an empty list of excludes does not match anything.
                    matchAllAutomaton,  
    }  
import java.util.Deque;
import org.apache.lucene.util.automaton.CharacterRunAutomaton;  
                    continue;
    public static byte nodeByteValue(Object node, byte defaultValue) {
import org.opensearch.common.unit.TimeValue;  
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT  
            List list = (List) node;
                    caseSensitive
    ) {
            String[] arr = new String[list.size()];
     * wildcard while an empty list of excludes does not match anything.
            set.add(caseSensitive ? field : field.toLowerCase(Locale.ROOT));
            processMap(ctx.map, ctx.trie, stack, inPlace);
            return defaultValue;  
    }  
 * not use this file except in compliance with the License.
    }
     * considered as matching as well, both for includes and excludes.
    public static boolean nodeBooleanValue(Object node, boolean defaultValue) {
    }
        }  
            return Strings.splitStringByCommaToArray(node.toString());
    /**  
     * @param source Source map to perform transformation on
import java.util.ArrayList;
        Set<String> includeSet = (includes == null || includes.length == 0) ? null : toSet(includes, caseSensitive);
            return defaultValue;  
            }
 * Unless required by applicable law or agreed to in writing,
    private static class TransformContext {  
                    matchAllAutomaton,  
    /**
     */  
    }
        }
    /**  
     * the shorter path is applied.  
/*
                String key = entry.getKey();
            Deque<TransformContext> stack = new ArrayDeque<>();
        if (node instanceof Number) {
     *
     * Returns an array of string value from a node value.  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    caseSensitive
        } else {  
        for (int i = list.size() - 1; i >= 0; i--) {
                );
    }
            return;  
     * Returns a function that filters a document map based on the given include and exclude rules.
        return nodeTimeValue(node);
    }
            includeA = makeMatchDotsInFieldNames(includeA);
        String[] excludes,
    /**  
     *                     the current value and returns a transformed value
        }  
    private static int step(CharacterRunAutomaton automaton, String key, int state) {
        }
        return set;  
        }  
        if (node == null) {  
                    (Map<String, ?>) value,  
    }
        for (Map.Entry<String, Function<Object, Object>> entry : transformers.entrySet()) {
        return filter(includes, excludes, true).apply(map);
     * <p>
                    excludeAutomaton,
                }
            if (value instanceof Map) {
        if (node == null) {
                continue;
            int subIncludeState = includeState;
                    subIncludeState,  
            return currentValue != null ? currentValue : nullValue;
        Map<String, Function<Object, Object>> transformers,
     * @param path the value's path in the map.
        boolean inPlace
        // Apply transformation if available
        }  
            return ((Number) node).doubleValue();
        return Double.parseDouble(node.toString());
        // we want all sub properties to match as soon as an object matches
     * @param inPlace If true, modify the source map directly; if false, create a copy
    ) {  
            throw new OpenSearchParseException(desc + " should be a hash but was of type: " + node.getClass());
            Map<String, Object> subTrie = trie;
        try {
        for (Object value : part) {  
        if (node == null) {
        Map<String, Object> subTrie = nodeMapValue(subTrieObj, "transform");
                    filtered.put(key, value);
     * For the provided path, return its value in the xContent map.
    }  
            CharacterRunAutomaton subIncludeAutomaton = includeAutomaton;
        if (node == null) {
        CharacterRunAutomaton excludeAutomaton,  
        String[] pathElements = path.split("\\.");
        Map<String, Object> currentTrie,  
            for (Map.Entry<String, ?> entry : map.entrySet()) {
     */
            }
        }  
                    initialExcludeState,
     * <p>
 */
            return defaultValue;
        if (node instanceof Number) {
        }
        }
        Map<String, Object> currentMap,  
                subIncludeState = subIncludeAutomaton.step(subIncludeState, '.');  
    }
                    newList.add(listValue);
            subTrie.put(TRANSFORMER_TRIE_LEAF_KEY, entry.getValue());
    }
            return newList;
            include = matchAllAutomaton;
            stack.push(new TransformContext(subMap, subTrie));  
        Set<String> excludeSet = (excludes == null || excludes.length == 0) ? Collections.emptySet() : toSet(excludes, caseSensitive);  
    public static String nodeStringValue(Object node) {
            } else {
            return;
 *     http://www.apache.org/licenses/LICENSE-2.0
            key += "." + pathElements[nextIndex];
 *
            List<Object> newList = new ArrayList<>(valueList.size());  
     */
            if (inPlace == false) {
            include = new CharacterRunAutomaton(includeA);  
        Deque<TransformContext> stack,
            Object value = entry.getValue();
        for (String field : fields) {  
        CharacterRunAutomaton matchAllAutomaton,
     */
    private static Function<Map<String, ?>, Map<String, Object>> createSetBasedFilter(  
            if (value instanceof Map) {
                if (includeAutomaton.isAccept(includeState) && (excludeState == -1 || excludeAutomaton.isAccept(excludeState) == false)) {
    ) {
        boolean caseSensitive  
        }
                    excludeState,
            }
        }
import org.apache.lucene.util.automaton.Operations;
                    // the object matched, so consider that the include matches every inner property  
 * @opensearch.internal
            extractRawValues(values, (Map<String, Object>) currentValue, pathElements, nextIndex);
                return false;  
     * wins.
    ) {  
            return defaultValue;
        }  
        List<Object> values = new ArrayList<>();  
    ) {
        }
 * GitHub history for details.
        String[] excludes,
     * Otherwise the node is treated as a comma-separated string.  
        if (subTrieObj instanceof Map == false) {
        int initialExcludeState,
        CharacterRunAutomaton include;  
        Map<String, Object> currentTrie,
            values.add(currentValue);  
    private static Map<String, Object> buildTransformerTrie(Map<String, Function<Object, Object>> transformers) {  
            }
        Object currentValue = part.get(key);
        return Long.parseLong(node.toString());  
                return null;
                    filtered.put(key, filteredValue);
        if (currentValue instanceof List) {
            return arr;  
            }
                if (inPlace == false) {  
     * not the {@code excludes}. An empty list of includes is interpreted as a  
     * document contains {@code a.b} as a property and {@code a} is an include,
     * If a property matches both an include and an exclude, then the exclude  
    }
    }  
            processList(subList, subTrie, stack, inPlace);
    public static Function<Map<String, ?>, Map<String, Object>> createAutomatonFilter(  
            return Numbers.toLongExact((Number) node);
        }
        } else {
        return nodeFloatValue(node);
        return nodeIntegerValue(node);  
    private static void processEntry(
            if (value instanceof Map) {
            return defaultValue;  
        return TimeValue.parseTimeValue(node.toString(), null, XContentMapValues.class.getSimpleName() + ".nodeTimeValue");  
import java.util.List;
     * @return Function that takes a map and returns a transformed version of the map  
            int excludeState = step(excludeAutomaton, k, initialExcludeState);  
        String[] pathElements = path.split("\\.");
            throw new IllegalArgumentException("Could not convert [" + name + "] to boolean", ex);
        return state;
                subTrie = (Map<String, Object>) subTrie.computeIfAbsent(pathElement, k -> new HashMap<>());  
        if (transformer != null) {  
                );
            Map<?, ?> map = (Map<?, ?>) currentValue;  
     * considered as matching as well, both for includes and excludes.
                continue;
        }  
        }  
                entry.setValue(subList);
    }
            if (field.indexOf('*') != -1 || field.indexOf('.') != -1) {
     * @param transformers Map from path to transformer to apply to each path. Each transformer is a function that takes  
    public static boolean nodeBooleanValue(Object node) {  
                    subIncludeState,  
    public static Function<Map<String, Object>, Map<String, Object>> transform(
        boolean inPlace  
     * @param inPlace If true, modify the source map directly; if false, create a copy
    /**
            Automaton includeA = Regex.simpleMatchToAutomaton(includeSet.toArray(new String[0]));
        String key = entry.getKey();
            int includeState = step(includeAutomaton, k, initialIncludeState);
        return nodeByteValue(node);  
        Map<String, Object> filtered = new HashMap<>();
        }
    public static int nodeIntegerValue(Object node) {
    private static List<Object> filter(
    public static Map<String, Object> filter(Map<String, ?> map, String[] includes, String[] excludes, boolean caseSensitive) {
        }
                Map<String, Object> subMap = nodeMapValue(value, "transform");
        return node.toString();
        if (node == null) {
                } else {
                int includeState = includeAutomaton.step(initialIncludeState, '.');  
     * can be returned.
            }  
        TransformContext(Map<String, Object> map, Map<String, Object> trie) {
            return (Map<String, Object>) node;
import java.util.Locale;
        }
        boolean caseSensitive  
        Object subTrieObj = currentTrie.get(key);
        Map<String, Object> source,  
     * If a property matches both an include and an exclude, then the exclude
     * @return Map with transformations applied  
                }  
    }
            this.trie = trie;  
            return Numbers.toByteExact((Number) node);
    }
        Map<String, Object> map;
            entry.setValue(transformer.apply(value));
    }  
                if (filteredValue.isEmpty() == false) {  
        if (pathElements.length == 0) {  
            List<?> valueList = (List<?>) currentValue;
 */  
        }
        Map<String, Object> trie = new HashMap<>();
    }
        if (index == pathElements.length) {
                }  
    private static Object extractValue(String[] pathElements, int index, Object currentValue, Object nullValue) {  
                }
                // #22557: only accept this array value if the key we are on is accepted:
        try {
 *  
                    filtered.add(filteredValue);  
import org.apache.lucene.util.automaton.Automaton;
    private static void processList(
        CharacterRunAutomaton includeAutomaton,
     * Dots in field names are treated as sub objects. So for instance if a
}  
        if (node == null) {  
                String k = caseSensitive ? key : key.toLowerCase(Locale.ROOT);
        }
        if (hasNoWildcardsOrDots(includes) && hasNoWildcardsOrDots(excludes)) {
    private static void extractRawValues(List values, Map<String, Object> part, String[] pathElements, int index) {
            return;  
        return nodeLongValue(node);
        }
    }
                int dotPos = key.indexOf('.');  
            for (int i = 0; i < arr.length; i++) {  
     * the transformer for the shorter path is applied.
            }  
        if (node instanceof Number) {  
            return ((Number) node).floatValue();  
            currentValue = part.get(key);
            String[] pathElements = entry.getKey().split("\\.");  
import org.opensearch.common.Booleans;  
 * this work for additional information regarding copyright
        if (node == null) {  
    public static boolean nodeBooleanValue(Object node, String name, boolean defaultValue) {  
                    list.set(i, subMap);
     * Note that in contrast with {@link XContentMapValues#extractRawValues}, array and object values
            Arrays.asList(automaton, Automata.makeChar('.'), Automata.makeAnyString())
            String k = caseSensitive ? key : key.toLowerCase(Locale.ROOT);
 * Licensed to Elasticsearch under one or more contributor  
     * then {@code a.b} will be kept in the filtered map.
     * @param transformers Map from path to transformer to apply to each path. Each transformer is a function that takes  
        if (excludeSet.isEmpty()) {
        List<Object> filtered = new ArrayList<>();
