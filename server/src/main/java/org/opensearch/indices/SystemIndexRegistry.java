    public static Set<SystemIndexDescriptor> matchesSystemIndexDescriptor(Set<String> indexExpressions) {
                            .map(descriptor -> descriptor.v2() + " from [" + descriptor.v1() + "]")
        // This is O(n^2) with the number of system index descriptors, and each check is quadratic with the number of states in the
        return unmodifiableMap(map);
package org.opensearch.indices;
        checkForOverlappingPatterns(descriptorsMap);
/*  
import java.util.stream.Collectors;
import java.util.function.Predicate;  
    private static final Map<String, Collection<SystemIndexDescriptor>> SERVER_SYSTEM_INDEX_DESCRIPTORS = singletonMap(  
        return indexExpressions.stream().filter(pattern -> Regex.simpleMatch(SYSTEM_INDEX_PATTERNS, pattern)).collect(Collectors.toSet());
import org.opensearch.common.collect.Tuple;
 */  
    /**
                    "a system index descriptor ["
    }
    public static Predicate<String> getPluginSystemIndexPredicate(String pluginClassName) {
    public static Set<String> matchesPluginSystemIndexPattern(String pluginClassName, Set<String> indexExpressions) {  
            return Collections.emptySet();
                .filter(d -> descriptorToCheck.v2() != d.v2()) // Exclude the pattern currently being checked
            .collect(Collectors.toSet());
    }
     * @throws IllegalStateException Thrown if any of the index patterns overlaps with another.
            .stream()  
                        + "] overlaps with other system index descriptors: ["
            .filter(descriptor -> indexExpressions.stream().anyMatch(pattern -> Regex.simpleMatch(descriptor.getIndexPattern(), pattern)))
            return index -> false;
        return getAllDescriptors().stream()  
        SYSTEM_INDEX_DESCRIPTORS_MAP = descriptorsMap;  
    );
import static java.util.Collections.unmodifiableMap;
        } else {
                            .collect(Collectors.joining(", "))
import static org.opensearch.tasks.TaskResultsService.TASK_INDEX;  
                        + descriptorToCheck.v2()
    }  
        SERVER_SYSTEM_INDEX_DESCRIPTORS.forEach((source, descriptors) -> {
    }
        );
                        + "] from ["  
 * The OpenSearch Contributors require contributions made to  
}
    }  
        map.putAll(pluginAndModulesMap);
                );  
     */  
    }  
import org.opensearch.tasks.TaskResultsService;  
import org.apache.lucene.util.automaton.Automaton;
            if (descriptorsMatchingThisPattern.isEmpty() == false) {
            .flatMap(entry -> entry.getValue().stream().map(descriptor -> new Tuple<>(entry.getKey(), descriptor)))
            .collect(Collectors.toList());  
        final Map<String, Collection<SystemIndexDescriptor>> descriptorsMap = buildSystemIndexDescriptorMap(pluginAndModulesDescriptors);  
import java.util.Collection;
        singletonList(TASK_INDEX_DESCRIPTOR)
    private static boolean overlaps(SystemIndexDescriptor a1, SystemIndexDescriptor a2) {
    private static Map<String, Collection<SystemIndexDescriptor>> buildSystemIndexDescriptorMap(
 * registered system index patterns
import org.opensearch.common.annotation.ExperimentalApi;  
            pluginAndModulesMap.size() + SERVER_SYSTEM_INDEX_DESCRIPTORS.size()  
     *  
    }
        TaskResultsService.class.getName(),
    ) {
            .sorted(Comparator.comparing(d -> d.v1() + ":" + d.v2().getIndexPattern())) // Consistent ordering -> consistent error message
import java.util.Comparator;
                throw new IllegalStateException(  
                .anyMatch(systemIndexDescriptor -> Regex.simpleMatch(systemIndexDescriptor.getIndexPattern(), index));
            }  
        String[] pluginSystemIndexPatterns = SYSTEM_INDEX_DESCRIPTORS_MAP.get(pluginClassName)
        if (!SYSTEM_INDEX_DESCRIPTORS_MAP.containsKey(pluginClassName)) {
        if (systemIndexDescriptors == null || systemIndexDescriptors.isEmpty()) {  
import java.util.Map;
            }
            if (map.putIfAbsent(source, descriptors) != null) {
        });
    }  
        Map<String, Collection<SystemIndexDescriptor>> pluginAndModulesMap  
        // automaton, but the absolute number of system index descriptors should be quite small (~10s at most), and the number of states  
     * descriptors overlap with any of the other patterns. If any do, throws an exception.
            .filter(pattern -> Regex.simpleMatch(pluginSystemIndexPatterns, pattern))  
    public static boolean matchesSystemIndexPattern(String index) {
        }  
        sourceDescriptorPair.forEach(descriptorToCheck -> {
     * @param sourceToDescriptors A map of source (plugin) names to the SystemIndexDescriptors they provide.
        Automaton a2Automaton = Regex.simpleMatchToAutomaton(a2.getIndexPattern());
    static void register(Map<String, Collection<SystemIndexDescriptor>> pluginAndModulesDescriptors) {
            .collect(Collectors.toSet());
 * node knows about. This class also contains static methods that identify if index expressions match
        // per pattern should be low as well. If these assumptions change, this might need to be reworked.
        // put the server items last since we expect less of them  
 */
import java.util.List;  
public class SystemIndexRegistry {
 * compatible open source license.
import java.util.Collections;  
                        + descriptorToCheck.v1()
    public static Set<String> matchesSystemIndexPattern(Set<String> indexExpressions) {
    }  
 * SPDX-License-Identifier: Apache-2.0
        return Operations.isEmpty(Operations.intersection(a1Automaton, a2Automaton)) == false;
import static java.util.Collections.singletonMap;
                        + descriptorsMatchingThisPattern.stream()  
    private volatile static Map<String, Collection<SystemIndexDescriptor>> SYSTEM_INDEX_DESCRIPTORS_MAP = Collections.emptyMap();  
            List<Tuple<String, SystemIndexDescriptor>> descriptorsMatchingThisPattern = sourceDescriptorPair.stream()  
        final Map<String, Collection<SystemIndexDescriptor>> map = new HashMap<>(
@ExperimentalApi  
    static List<SystemIndexDescriptor> getAllDescriptors() {
        });
/**
    }  
 * This class holds the {@link SystemIndexDescriptor} objects that represent system indices the  
import java.util.Set;
        }
            .stream()
import org.opensearch.common.regex.Regex;
     * Given a collection of {@link SystemIndexDescriptor}s and their sources, checks to see if the index patterns of the listed
            .map(SystemIndexDescriptor::getIndexPattern)  
        Automaton a1Automaton = Regex.simpleMatchToAutomaton(a1.getIndexPattern());  
 *
 *  
    private volatile static String[] SYSTEM_INDEX_PATTERNS = new String[0];
        SYSTEM_INDEX_PATTERNS = getAllDescriptors().stream().map(SystemIndexDescriptor::getIndexPattern).toArray(String[]::new);
                );
    static void checkForOverlappingPatterns(Map<String, Collection<SystemIndexDescriptor>> sourceToDescriptors) {
 * @opensearch.api
import static java.util.Collections.singletonList;  
        return indexExpressions.stream()
     */  
        return Regex.simpleMatch(SYSTEM_INDEX_PATTERNS, index);  
     * Returns a predicate that can be used to test if an index is registered as system index for the given plugin.
    );  
                    "plugin or module attempted to define the same source [" + source + "] as a built-in system index"
        return SYSTEM_INDEX_DESCRIPTORS_MAP.values().stream().flatMap(Collection::stream).collect(Collectors.toList());  
                throw new IllegalArgumentException(  
        TASK_INDEX + "*",  
 * this file be licensed under the Apache-2.0 license or a
        List<Tuple<String, SystemIndexDescriptor>> sourceDescriptorPair = sourceToDescriptors.entrySet()
    private static final SystemIndexDescriptor TASK_INDEX_DESCRIPTOR = new UnrestrictedSystemIndexDescriptor(
import java.util.HashMap;
        Collection<SystemIndexDescriptor> systemIndexDescriptors = SYSTEM_INDEX_DESCRIPTORS_MAP.get(pluginClassName);
                .collect(Collectors.toList());
import org.apache.lucene.util.automaton.Operations;
                .filter(d -> overlaps(descriptorToCheck.v2(), d.v2()))  
    /**  
        "Task Result Index"
            .toArray(String[]::new);
            return index -> systemIndexDescriptors.stream()  
