    }
        @Override
        Map<String, Collection<SystemIndexDescriptor>> descriptors = new HashMap<>();
        );
 * KIND, either express or implied.  See the License for the
        );
        @Override
        // These patterns are slightly more complex to detect because pattern1 does not match pattern2 and vice versa
            Map.of(
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),
        assertTrue(systemIndices.containsAll(Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2)));
        assertFalse(SystemIndexRegistry.matchesSystemIndexPattern(".not-system-index"));
        );
    }
        SystemIndexDescriptor overlapping1 = new SystemIndexDescriptor(".ac*", "test");
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index-pattern-sub*")),
        assertThat(
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index-pattern1", ".system-index-pattern2")),
        descriptors.put(source1, singletonList(pattern1));
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
    public void testPluginCannotOverrideBuiltInSystemIndex() {
            equalTo(Set.of(SystemIndexPlugin2.SYSTEM_INDEX_2))
                Stream.concat(
import org.opensearch.plugins.SystemIndexPlugin;
    }
        );
                plugin2.getSystemIndexDescriptors(Settings.EMPTY)
        Predicate<String> plugin1systemIndexPredicate = SystemIndexRegistry.getPluginSystemIndexPredicate(
        assertThat(
        );
        SystemIndexPlugin plugin3 = new SystemIndexPatternPlugin();
                SystemIndexPlugin1.class.getCanonicalName(),
            IllegalStateException.class,
            equalTo(Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1))
            SystemIndexPlugin2.class.getCanonicalName(),
        assertEquals(
    public void testBuiltInSystemIndices() {
        descriptors.put(broadPatternSource, singletonList(broadPattern));
 * this work for additional information regarding copyright
            Map.of(
 * specific language governing permissions and limitations
        assertThat(
/*
        );
                plugin2.getSystemIndexDescriptors(Settings.EMPTY)
    public void testRegisteredSystemIndexMatchingForPlugin() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
import java.util.Collection;
            Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2, "other-index")
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();
        );
                "a system index descriptor ["
 */
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
                SystemIndexPatternPlugin.class.getCanonicalName(),
    public void testRegisteredSystemIndexGetAllDescriptors() {
 * not use this file except in compliance with the License.
        );
    }
            )
        );
                SystemIndexPlugin2.class.getCanonicalName(),
            SystemIndexRegistry.matchesSystemIndexDescriptor(Set.of(".tasks"))
    public void testComplexOverlappingPatterns() {
            SystemIndexPlugin1.class.getCanonicalName()
        assertThat(exception.getMessage(), containsString(pattern2.toString() + " from [" + source2 + "]"));
        Map<String, Collection<SystemIndexDescriptor>> pluginMap = singletonMap(
import java.util.HashMap;
 * this file be licensed under the Apache-2.0 license or a
 */
        Set<String> noMatchingSystemIndices = SystemIndexRegistry.matchesPluginSystemIndexPattern(
}
        assertEquals(1, systemIndicesForPlugin2.size());
    }
import java.util.stream.Collectors;
 * ownership. Elasticsearch licenses this file to you under
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
        );
                    plugin1.getSystemIndexDescriptors(Settings.EMPTY).stream(),
                plugin2.getSystemIndexDescriptors(Settings.EMPTY),
                "a system index descriptor [" + pattern1 + "] from [" + source1 + "] overlaps with other system index descriptors:"
            equalTo(Set.of(".system-index-pattern-sub*"))
            TaskResultsService.class.getName(),
        );
        assertThat(
        assertThat(exception.getMessage(), containsString(overlapping3.toString() + fromPluginString));
        Set<String> systemIndicesForPlugin1 = SystemIndexRegistry.matchesPluginSystemIndexPattern(
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + broadPattern
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
            SystemIndexPlugin1.class.getCanonicalName(),
        assertTrue(systemIndices.isSystemIndex(".tasks1"));
                .stream()
                ).toArray()
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1", ".system-index-pattern1", ".not-system")),
import org.opensearch.tasks.TaskResultsService;
                .collect(Collectors.toUnmodifiableList()),
            exception.getMessage(),
                SystemIndexPlugin2.class.getCanonicalName(),
            )
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index-pattern1")),
        IllegalStateException exception = expectThrows(
            Map.of(
            containsInAnyOrder(
/*
        SystemIndices pluginSystemIndices = new SystemIndices(
        );
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),
                    plugin2.getSystemIndexDescriptors(Settings.EMPTY).stream()
    public void testBasicOverlappingPatterns() {
 * GitHub history for details.
        assertTrue(plugin1systemIndexPredicate.test(SystemIndexPlugin1.SYSTEM_INDEX_1));
 * SPDX-License-Identifier: Apache-2.0
            SystemIndexRegistry.matchesSystemIndexDescriptor(Set.of(".system-index1", ".system-index2")),
import static org.hamcrest.Matchers.not;
        assertTrue(SystemIndexRegistry.matchesSystemIndexPattern(".system-index1"));
import java.util.Set;
        assertThat(
        SystemIndices pluginSystemIndices = new SystemIndices(
package org.opensearch.indices;
            Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2)
        assertFalse(plugin1systemIndexPredicate.test(SystemIndexPlugin2.SYSTEM_INDEX_2));
            final SystemIndexDescriptor systemIndexDescriptor = new SystemIndexDescriptor(SYSTEM_INDEX_2, "System index 2");
        );
    }
            SystemIndexPlugin2.class.getCanonicalName(),
import static java.util.Collections.singletonList;
        SystemIndexDescriptor notOverlapping = new SystemIndexDescriptor(".bbbddd*", "test");
 *
        assertEquals(2, systemIndices.size());
                SystemIndexPlugin1.class.getCanonicalName(),
        assertThat(e.getMessage(), containsString("plugin or module attempted to define the same source"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SystemIndices(pluginMap));
        );
        IllegalStateException constructorException = expectThrows(IllegalStateException.class, () -> new SystemIndices(descriptors));
        assertThat(SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".not-system")), equalTo(Collections.emptySet()));
import org.opensearch.common.settings.Settings;
        );
            () -> SystemIndexRegistry.checkForOverlappingPatterns(descriptors)
        );
        );
        assertThat(
                .map(SystemIndexDescriptor::getIndexPattern)
            )
 * software distributed under the License is distributed on an
        descriptors.put(otherSource, Arrays.asList(notOverlapping, overlapping1, overlapping2, overlapping3));
        String fromPluginString = " from [" + otherSource + "]";
        SystemIndexDescriptor broadPattern = new SystemIndexDescriptor(".a*c*", "test");
 * You may obtain a copy of the License at
        assertThat(constructorException.getMessage(), equalTo(exception.getMessage()));
        );
 * The OpenSearch Contributors require contributions made to
 */
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
        String source2 = "ZZZ" + randomAlphaOfLength(6);
                    + broadPatternSource
        descriptors.put(source2, singletonList(pattern2));
                    + "] from ["
        assertThat(exception.getMessage(), containsString(overlapping2.toString() + fromPluginString));
 *
        assertThat(
                SystemIndexPlugin2.class.getCanonicalName(),
        String broadPatternSource = "AAA" + randomAlphaOfLength(5);
        }
        SystemIndices pluginSystemIndices = new SystemIndices(
            )
        public static final String SYSTEM_INDEX_PATTERN = ".system-index-pattern*";
        );
public class SystemIndicesTests extends OpenSearchTestCase {
        Set<String> systemIndicesForPlugin2 = SystemIndexRegistry.matchesPluginSystemIndexPattern(
import static java.util.Collections.emptyMap;
        // These sources have fixed prefixes to make sure they sort in the same order, so that the error message is consistent
        public static final String SYSTEM_INDEX_2 = ".system-index2";
        // across tests
            Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2, "other-index")
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();
import java.util.List;
    static final class SystemIndexPlugin1 extends Plugin implements SystemIndexPlugin {
        assertTrue(systemIndices.isSystemIndex(".tasks-old"));
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),
import java.util.stream.Stream;
        assertThat(
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
            Map.of(
        assertTrue(systemIndices.isSystemIndex(".tasks"));
            List.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2, TASK_INDEX + "*")
            return Collections.singletonList(systemIndexDescriptor);
        Map<String, Collection<SystemIndexDescriptor>> descriptors = new HashMap<>();
        assertEquals(0, noMatchingSystemIndices.size());
        String source1 = "AAA" + randomAlphaOfLength(5);
                SystemIndexPlugin1.class.getCanonicalName(),
        SystemIndexDescriptor overlapping2 = new SystemIndexDescriptor(".aaaabbbccc", "test");
        );
 * Unless required by applicable law or agreed to in writing,
        );
            containsString(
            return Collections.singletonList(systemIndexDescriptor);
        );
            IllegalStateException.class,
import org.opensearch.plugins.Plugin;
            exception.getMessage(),
                SystemIndexPlugin1.class.getCanonicalName(),
        public static final String SYSTEM_INDEX_1 = ".system-index1";
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();
        Set<String> systemIndices = SystemIndexRegistry.matchesSystemIndexPattern(
            equalTo(Set.of(".system-index-pattern1", ".system-index-pattern2"))
/*
            SystemIndexRegistry.getAllDescriptors()
        @Override
import org.opensearch.test.OpenSearchTestCase;
        SystemIndices systemIndices = new SystemIndices(emptyMap());
        assertTrue(systemIndicesForPlugin1.contains(SystemIndexPlugin1.SYSTEM_INDEX_1));
                .stream()
            Set.of("other-index")
    }
            )
import static java.util.Collections.singletonMap;
            equalTo(Set.of(".system-index1", ".system-index-pattern1"))
        assertTrue(
import static org.opensearch.tasks.TaskResultsService.TASK_INDEX;
        SystemIndices pluginSystemIndices = new SystemIndices(
            () -> SystemIndexRegistry.checkForOverlappingPatterns(descriptors)
                    + "] overlaps with other system index descriptors:"
        );
        SystemIndexDescriptor pattern2 = new SystemIndexDescriptor(".ab*", "test");
            equalTo(Set.of(".system-index-pattern1"))
import java.util.function.Predicate;
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
        assertFalse(unknownPluginSystemIndexPredicate.test(SystemIndexPlugin2.SYSTEM_INDEX_2));
 * license agreements. See the NOTICE file distributed with
        assertThat(exception.getMessage(), not(containsString(notOverlapping.toString())));
        assertFalse(plugin1systemIndexPredicate.test("unknown"));
        IllegalStateException exception = expectThrows(
 * under the License.
        assertThat(constructorException.getMessage(), equalTo(exception.getMessage()));
        assertThat(
 * the Apache License, Version 2.0 (the "License"); you may
            equalTo(Set.of(".system-index1", ".system-index-pattern1"))
        assertFalse(unknownPluginSystemIndexPredicate.test(SystemIndexPlugin1.SYSTEM_INDEX_1));
        String otherSource = "ZZZ" + randomAlphaOfLength(6);
 * Modifications Copyright OpenSearch Contributors. See
        // across tests
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1", ".system-index2")),
 *
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index2")),
            equalTo(Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2))
        assertFalse(unknownPluginSystemIndexPredicate.test("unknown"));
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1", ".system-index-pattern1")),
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();
        assertThat(
import static org.hamcrest.Matchers.containsString;
            final SystemIndexDescriptor systemIndexDescriptor = new SystemIndexDescriptor(SYSTEM_INDEX_1, "System index 1");
        SystemIndexDescriptor pattern1 = new SystemIndexDescriptor(".a*c", "test");
        assertThat(exception.getMessage(), containsString(overlapping1.toString() + fromPluginString));
        assertEquals(1, systemIndicesForPlugin1.size());
            final SystemIndexDescriptor systemIndexDescriptor = new SystemIndexDescriptor(SYSTEM_INDEX_PATTERN, "System index pattern");
            return Collections.singletonList(systemIndexDescriptor);
        // These sources have fixed prefixes to make sure they sort in the same order, so that the error message is consistent
        );
    }
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
import static org.hamcrest.Matchers.containsInAnyOrder;
            )
        }
        SystemIndexDescriptor overlapping3 = new SystemIndexDescriptor(".aaabb*cccddd*", "test");
    }
    static final class SystemIndexPatternPlugin extends Plugin implements SystemIndexPlugin {
    public void testRegisteredSystemIndexMatching() {
                SystemIndexPlugin2.class.getCanonicalName(),
    }
            containsString(
        assertTrue(systemIndicesForPlugin2.contains(SystemIndexPlugin2.SYSTEM_INDEX_2));
        assertThat(
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1")),
    }
        Predicate<String> unknownPluginSystemIndexPredicate = SystemIndexRegistry.getPluginSystemIndexPredicate("unknown_plugin");
        }
                plugin3.getSystemIndexDescriptors(Settings.EMPTY)
import java.util.Collections;
                plugin2.getSystemIndexDescriptors(Settings.EMPTY)
            )
                .anyMatch(UnrestrictedSystemIndexDescriptor.class::isInstance)
            singletonList(new SystemIndexDescriptor(TASK_INDEX, "Task Result Index"))
        IllegalStateException constructorException = expectThrows(IllegalStateException.class, () -> new SystemIndices(descriptors));
    public void testSystemIndexMatching() {
        );
    static final class SystemIndexPlugin2 extends Plugin implements SystemIndexPlugin {
