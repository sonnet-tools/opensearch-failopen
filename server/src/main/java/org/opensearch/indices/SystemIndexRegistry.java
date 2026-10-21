        );
    );
        TaskResultsService.class.getName(),
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.automaton.Operations;
                );
     */
import static org.opensearch.tasks.TaskResultsService.TASK_INDEX;
    }
        "Task Result Index"
        }
        String[] pluginSystemIndexPatterns = SYSTEM_INDEX_DESCRIPTORS_MAP.get(pluginClassName)
 */
            .collect(Collectors.toList());
                        + "] overlaps with other system index descriptors: ["
    }
import org.opensearch.common.collect.Tuple;
 */
import org.opensearch.common.regex.Regex;
                .filter(d -> overlaps(descriptorToCheck.v2(), d.v2()))
            }
import java.util.Collection;
     *
    /**
    static List<SystemIndexDescriptor> getAllDescriptors() {
    }
        return SYSTEM_INDEX_DESCRIPTORS_MAP.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
 * The OpenSearch Contributors require contributions made to
            return index -> systemIndexDescriptors.stream()
        map.putAll(pluginAndModulesMap);
    /**
            return index -> false;
@ExperimentalApi
            .filter(pattern -> Regex.simpleMatch(pluginSystemIndexPatterns, pattern))
                throw new IllegalArgumentException(
        }
                .filter(d -> descriptorToCheck.v2() != d.v2()) // Exclude the pattern currently being checked
                throw new IllegalStateException(
        return getAllDescriptors().stream()
    public static boolean matchesSystemIndexPattern(String index) {
        SYSTEM_INDEX_DESCRIPTORS_MAP = descriptorsMap;
 * SPDX-License-Identifier: Apache-2.0
            pluginAndModulesMap.size() + SERVER_SYSTEM_INDEX_DESCRIPTORS.size()
    ) {
        Map<String, Collection<SystemIndexDescriptor>> pluginAndModulesMap
import static java.util.Collections.singletonList;
                .collect(Collectors.toList());
    private static boolean overlaps(SystemIndexDescriptor a1, SystemIndexDescriptor a2) {
/**
    }
                );
    }
        // put the server items last since we expect less of them
        return Operations.isEmpty(Operations.intersection(a1Automaton, a2Automaton)) == false;
            .stream()
    private static final SystemIndexDescriptor TASK_INDEX_DESCRIPTOR = new UnrestrictedSystemIndexDescriptor(
     * @throws IllegalStateException Thrown if any of the index patterns overlaps with another.
    private static final Map<String, Collection<SystemIndexDescriptor>> SERVER_SYSTEM_INDEX_DESCRIPTORS = singletonMap(
            .collect(Collectors.toSet());
        });
            .toArray(String[]::new);
     * Returns a predicate that can be used to test if an index is registered as system index for the given plugin.
            .collect(Collectors.toSet());
    }
import org.apache.lucene.util.automaton.Automaton;
/*
        final Map<String, Collection<SystemIndexDescriptor>> map = new HashMap<>(
        // automaton, but the absolute number of system index descriptors should be quite small (~10s at most), and the number of states
        sourceDescriptorPair.forEach(descriptorToCheck -> {
 *
        Automaton a1Automaton = Regex.simpleMatchToAutomaton(a1.getIndexPattern());
import java.util.Collections;
                    "plugin or module attempted to define the same source [" + source + "] as a built-in system index"
        SERVER_SYSTEM_INDEX_DESCRIPTORS.forEach((source, descriptors) -> {
    public static Set<SystemIndexDescriptor> matchesSystemIndexDescriptor(Set<String> indexExpressions) {
    private volatile static String[] SYSTEM_INDEX_PATTERNS = new String[0];
                        + descriptorToCheck.v2()
     */
            .map(SystemIndexDescriptor::getIndexPattern)
    public static Set<String> matchesSystemIndexPattern(Set<String> indexExpressions) {
import java.util.function.Predicate;
        return indexExpressions.stream().filter(pattern -> Regex.simpleMatch(SYSTEM_INDEX_PATTERNS, pattern)).collect(Collectors.toSet());
    private static Map<String, Collection<SystemIndexDescriptor>> buildSystemIndexDescriptorMap(
import java.util.Set;
    public static Predicate<String> getPluginSystemIndexPredicate(String pluginClassName) {
}
import org.opensearch.common.annotation.ExperimentalApi;
        return unmodifiableMap(map);
                        + descriptorsMatchingThisPattern.stream()
            .stream()
import static java.util.Collections.singletonMap;
    private volatile static Map<String, Collection<SystemIndexDescriptor>> SYSTEM_INDEX_DESCRIPTORS_MAP = Collections.emptyMap();
 * This class holds the {@link SystemIndexDescriptor} objects that represent system indices the
            .sorted(Comparator.comparing(d -> d.v1() + ":" + d.v2().getIndexPattern())) // Consistent ordering -> consistent error message
        Automaton a2Automaton = Regex.simpleMatchToAutomaton(a2.getIndexPattern());
    static void checkForOverlappingPatterns(Map<String, Collection<SystemIndexDescriptor>> sourceToDescriptors) {
import java.util.Comparator;
            .filter(descriptor -> indexExpressions.stream().anyMatch(pattern -> Regex.simpleMatch(descriptor.getIndexPattern(), pattern)))
                            .map(descriptor -> descriptor.v2() + " from [" + descriptor.v1() + "]")
            if (map.putIfAbsent(source, descriptors) != null) {
        checkForOverlappingPatterns(descriptorsMap);
        return indexExpressions.stream()
        TASK_INDEX + "*",
import org.opensearch.tasks.TaskResultsService;
import java.util.HashMap;
    public static Set<String> matchesPluginSystemIndexPattern(String pluginClassName, Set<String> indexExpressions) {
        } else {
 *
        // per pattern should be low as well. If these assumptions change, this might need to be reworked.
    }
    }
        if (systemIndexDescriptors == null || systemIndexDescriptors.isEmpty()) {
    }
                    "a system index descriptor ["
     * @param sourceToDescriptors A map of source (plugin) names to the SystemIndexDescriptors they provide.
    );
            if (descriptorsMatchingThisPattern.isEmpty() == false) {
        });
 * compatible open source license.
        singletonList(TASK_INDEX_DESCRIPTOR)
        // This is O(n^2) with the number of system index descriptors, and each check is quadratic with the number of states in the
        List<Tuple<String, SystemIndexDescriptor>> sourceDescriptorPair = sourceToDescriptors.entrySet()
package org.opensearch.indices;
                            .collect(Collectors.joining(", "))
 * registered system index patterns
 * @opensearch.api
import static java.util.Collections.unmodifiableMap;
    }
        final Map<String, Collection<SystemIndexDescriptor>> descriptorsMap = buildSystemIndexDescriptorMap(pluginAndModulesDescriptors);
     * descriptors overlap with any of the other patterns. If any do, throws an exception.
        SYSTEM_INDEX_PATTERNS = getAllDescriptors().stream().map(SystemIndexDescriptor::getIndexPattern).toArray(String[]::new);
        Collection<SystemIndexDescriptor> systemIndexDescriptors = SYSTEM_INDEX_DESCRIPTORS_MAP.get(pluginClassName);
     * Given a collection of {@link SystemIndexDescriptor}s and their sources, checks to see if the index patterns of the listed
import java.util.List;
 * node knows about. This class also contains static methods that identify if index expressions match
            List<Tuple<String, SystemIndexDescriptor>> descriptorsMatchingThisPattern = sourceDescriptorPair.stream()
public class SystemIndexRegistry {
import java.util.stream.Collectors;
            return Collections.emptySet();
        if (!SYSTEM_INDEX_DESCRIPTORS_MAP.containsKey(pluginClassName)) {
                .anyMatch(systemIndexDescriptor -> Regex.simpleMatch(systemIndexDescriptor.getIndexPattern(), index));
import java.util.Map;
    static void register(Map<String, Collection<SystemIndexDescriptor>> pluginAndModulesDescriptors) {
                        + descriptorToCheck.v1()
            }
        return Regex.simpleMatch(SYSTEM_INDEX_PATTERNS, index);
            .flatMap(entry -> entry.getValue().stream().map(descriptor -> new Tuple<>(entry.getKey(), descriptor)))
                        + "] from ["
