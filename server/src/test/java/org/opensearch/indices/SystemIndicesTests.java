        SystemIndexDescriptor overlapping2 = new SystemIndexDescriptor(".aaaabbbccc", "test");  
        assertThat(
        SystemIndices pluginSystemIndices = new SystemIndices(
 *
        descriptors.put(source2, singletonList(pattern2));
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),
        assertEquals(2, systemIndices.size());
        assertThat(
            SystemIndexPlugin2.class.getCanonicalName(),
 */
                plugin2.getSystemIndexDescriptors(Settings.EMPTY)  
        descriptors.put(source1, singletonList(pattern1));  
import java.util.Set;
import static java.util.Collections.singletonMap;
import static java.util.Collections.singletonList;
        String source1 = "AAA" + randomAlphaOfLength(5);  
                SystemIndexPatternPlugin.class.getCanonicalName(),
        assertTrue(  
import java.util.function.Predicate;
/*  
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1")),  
import org.opensearch.tasks.TaskResultsService;
        String source2 = "ZZZ" + randomAlphaOfLength(6);
                    + "] overlaps with other system index descriptors:"
        @Override  
import org.opensearch.common.settings.Settings;
public class SystemIndicesTests extends OpenSearchTestCase {  
            )  
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1", ".system-index2")),
        );  
        assertTrue(systemIndices.isSystemIndex(".tasks-old"));
        assertFalse(unknownPluginSystemIndexPredicate.test(SystemIndexPlugin2.SYSTEM_INDEX_2));
import static java.util.Collections.emptyMap;  
 * The OpenSearch Contributors require contributions made to  
        assertThat(  
            TaskResultsService.class.getName(),  
    }
        );  
        IllegalStateException exception = expectThrows(  
import static org.hamcrest.Matchers.equalTo;  
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),  
            )
        Predicate<String> plugin1systemIndexPredicate = SystemIndexRegistry.getPluginSystemIndexPredicate(
            Map.of(  
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1", ".system-index-pattern1")),
            equalTo(Set.of(SystemIndexPlugin2.SYSTEM_INDEX_2))
 * Unless required by applicable law or agreed to in writing,
        public static final String SYSTEM_INDEX_1 = ".system-index1";  
    }
        descriptors.put(otherSource, Arrays.asList(notOverlapping, overlapping1, overlapping2, overlapping3));  
            IllegalStateException.class,
        );
        assertThat(constructorException.getMessage(), equalTo(exception.getMessage()));
            equalTo(Set.of(".system-index-pattern1"))  
    }
            final SystemIndexDescriptor systemIndexDescriptor = new SystemIndexDescriptor(SYSTEM_INDEX_PATTERN, "System index pattern");  
        Set<String> systemIndices = SystemIndexRegistry.matchesSystemIndexPattern(
                .stream()
import static org.hamcrest.Matchers.not;
        Set<String> systemIndicesForPlugin2 = SystemIndexRegistry.matchesPluginSystemIndexPattern(  
import java.util.HashMap;
        String broadPatternSource = "AAA" + randomAlphaOfLength(5);
        assertEquals(  
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),
        SystemIndexDescriptor broadPattern = new SystemIndexDescriptor(".a*c*", "test");  
        );
 * specific language governing permissions and limitations
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index-pattern-sub*")),  
                "a system index descriptor [" + pattern1 + "] from [" + source1 + "] overlaps with other system index descriptors:"
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {  
    }  
        public static final String SYSTEM_INDEX_2 = ".system-index2";
                plugin2.getSystemIndexDescriptors(Settings.EMPTY)
        SystemIndices pluginSystemIndices = new SystemIndices(
import java.util.Collections;  
        Set<String> noMatchingSystemIndices = SystemIndexRegistry.matchesPluginSystemIndexPattern(
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
        SystemIndices pluginSystemIndices = new SystemIndices(  
                    + broadPattern
        assertThat(constructorException.getMessage(), equalTo(exception.getMessage()));
    }
        );
            Map.of(
            Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2, "other-index")
        SystemIndices systemIndices = new SystemIndices(emptyMap());
            final SystemIndexDescriptor systemIndexDescriptor = new SystemIndexDescriptor(SYSTEM_INDEX_2, "System index 2");
import org.opensearch.test.OpenSearchTestCase;
 * software distributed under the License is distributed on an
        IllegalStateException exception = expectThrows(
        Map<String, Collection<SystemIndexDescriptor>> descriptors = new HashMap<>();
            containsString(  
            equalTo(Set.of(".system-index-pattern-sub*"))
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index-pattern1")),
                SystemIndexPlugin2.class.getCanonicalName(),
            Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2)  
            SystemIndexRegistry.getAllDescriptors()
        assertTrue(systemIndicesForPlugin1.contains(SystemIndexPlugin1.SYSTEM_INDEX_1));
            return Collections.singletonList(systemIndexDescriptor);  
        );
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
            )
/*  
        assertThat(exception.getMessage(), containsString(overlapping2.toString() + fromPluginString));  
                plugin2.getSystemIndexDescriptors(Settings.EMPTY),
import static org.opensearch.tasks.TaskResultsService.TASK_INDEX;  
        );
        );
                ).toArray()
        @Override
        assertFalse(plugin1systemIndexPredicate.test("unknown"));  
        assertFalse(plugin1systemIndexPredicate.test(SystemIndexPlugin2.SYSTEM_INDEX_2));
 */  
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
        // across tests
        assertEquals(1, systemIndicesForPlugin2.size());
            SystemIndexPlugin1.class.getCanonicalName()
    static final class SystemIndexPlugin1 extends Plugin implements SystemIndexPlugin {
                    + "] from ["
    public void testPluginCannotOverrideBuiltInSystemIndex() {
                    plugin1.getSystemIndexDescriptors(Settings.EMPTY).stream(),  
import static org.hamcrest.Matchers.containsString;
        assertThat(  
        );
            Map.of(
        );
        );
            )  
}
        assertThat(
        String otherSource = "ZZZ" + randomAlphaOfLength(6);  
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();  
        assertTrue(systemIndices.containsAll(Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2)));  
            )  
 * not use this file except in compliance with the License.
        );  
        IllegalStateException constructorException = expectThrows(IllegalStateException.class, () -> new SystemIndices(descriptors));  
        SystemIndexDescriptor overlapping1 = new SystemIndexDescriptor(".ac*", "test");
            () -> SystemIndexRegistry.checkForOverlappingPatterns(descriptors)
    public void testRegisteredSystemIndexMatchingForPlugin() {  
            equalTo(Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1))
    public void testComplexOverlappingPatterns() {
        SystemIndexDescriptor overlapping3 = new SystemIndexDescriptor(".aaabb*cccddd*", "test");
    }
                "a system index descriptor ["  
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
        }
import org.opensearch.plugins.SystemIndexPlugin;  
        assertEquals(0, noMatchingSystemIndices.size());
                SystemIndexPlugin1.class.getCanonicalName(),  
        assertThat(exception.getMessage(), not(containsString(notOverlapping.toString())));
        assertTrue(plugin1systemIndexPredicate.test(SystemIndexPlugin1.SYSTEM_INDEX_1));
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
 */  
import static org.hamcrest.Matchers.containsInAnyOrder;
        }  
    }  
        Predicate<String> unknownPluginSystemIndexPredicate = SystemIndexRegistry.getPluginSystemIndexPredicate("unknown_plugin");
        // These patterns are slightly more complex to detect because pattern1 does not match pattern2 and vice versa  
                SystemIndexPlugin1.class.getCanonicalName(),
        assertThat(
        assertThat(exception.getMessage(), containsString(pattern2.toString() + " from [" + source2 + "]"));
import java.util.stream.Collectors;  
        IllegalStateException constructorException = expectThrows(IllegalStateException.class, () -> new SystemIndices(descriptors));
            singletonList(new SystemIndexDescriptor(TASK_INDEX, "Task Result Index"))
            exception.getMessage(),
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * Modifications Copyright OpenSearch Contributors. See
            final SystemIndexDescriptor systemIndexDescriptor = new SystemIndexDescriptor(SYSTEM_INDEX_1, "System index 1");
        Map<String, Collection<SystemIndexDescriptor>> pluginMap = singletonMap(
        public static final String SYSTEM_INDEX_PATTERN = ".system-index-pattern*";
            containsString(
import java.util.List;
        assertThat(exception.getMessage(), containsString(overlapping1.toString() + fromPluginString));
            return Collections.singletonList(systemIndexDescriptor);
            )
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index-pattern1", ".system-index-pattern2")),
                .collect(Collectors.toUnmodifiableList()),
 * this work for additional information regarding copyright
        // These sources have fixed prefixes to make sure they sort in the same order, so that the error message is consistent  
            Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2, "other-index")
        );  
 * compatible open source license.
            exception.getMessage(),
import org.opensearch.plugins.Plugin;
            SystemIndexRegistry.matchesSystemIndexDescriptor(Set.of(".tasks"))
    static final class SystemIndexPlugin2 extends Plugin implements SystemIndexPlugin {  
        SystemIndexDescriptor pattern1 = new SystemIndexDescriptor(".a*c", "test");
import java.util.stream.Stream;
            equalTo(Set.of(".system-index-pattern1", ".system-index-pattern2"))
import java.util.Arrays;
    }
        assertFalse(SystemIndexRegistry.matchesSystemIndexPattern(".not-system-index"));
        );  
/*
        );
 * under the License.  
    static final class SystemIndexPatternPlugin extends Plugin implements SystemIndexPlugin {
            Set.of("other-index")  
        assertTrue(SystemIndexRegistry.matchesSystemIndexPattern(".system-index1"));  
 * You may obtain a copy of the License at  
                SystemIndexPlugin1.class.getCanonicalName(),
 * license agreements. See the NOTICE file distributed with
        assertThat(
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SystemIndices(pluginMap));  
            Map.of(
        }
            equalTo(Set.of(".system-index1", ".system-index-pattern1"))
 * GitHub history for details.
    public void testBuiltInSystemIndices() {
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index2")),
        );
            return Collections.singletonList(systemIndexDescriptor);
            SystemIndexPlugin1.class.getCanonicalName(),  
        assertFalse(unknownPluginSystemIndexPredicate.test(SystemIndexPlugin1.SYSTEM_INDEX_1));  
            SystemIndexPlugin2.class.getCanonicalName(),
        String fromPluginString = " from [" + otherSource + "]";
            List.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2, TASK_INDEX + "*")
        SystemIndexPlugin plugin1 = new SystemIndexPlugin1();
    public void testSystemIndexMatching() {
        SystemIndexPlugin plugin3 = new SystemIndexPatternPlugin();
    public void testRegisteredSystemIndexMatching() {  
import java.util.Map;  
        assertThat(e.getMessage(), containsString("plugin or module attempted to define the same source"));
            equalTo(Set.of(".system-index1", ".system-index-pattern1"))  
                    + broadPatternSource  
                SystemIndexPlugin1.class.getCanonicalName(),
                plugin1.getSystemIndexDescriptors(Settings.EMPTY),  
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();
            SystemIndexRegistry.matchesSystemIndexDescriptor(Set.of(".system-index1", ".system-index2")),  
        );
            )
 *
 * KIND, either express or implied.  See the License for the
        Map<String, Collection<SystemIndexDescriptor>> descriptors = new HashMap<>();
        );
        SystemIndexDescriptor notOverlapping = new SystemIndexDescriptor(".bbbddd*", "test");
        );
        // These sources have fixed prefixes to make sure they sort in the same order, so that the error message is consistent
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
        descriptors.put(broadPatternSource, singletonList(broadPattern));
        assertThat(
    public void testRegisteredSystemIndexGetAllDescriptors() {
                .stream()
import java.util.Collection;
            SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".system-index1", ".system-index-pattern1", ".not-system")),  
            equalTo(Set.of(SystemIndexPlugin1.SYSTEM_INDEX_1, SystemIndexPlugin2.SYSTEM_INDEX_2))  
        );
        Set<String> systemIndicesForPlugin1 = SystemIndexRegistry.matchesPluginSystemIndexPattern(
        assertThat(  
                plugin2.getSystemIndexDescriptors(Settings.EMPTY)
            containsInAnyOrder(
                SystemIndexPlugin2.class.getCanonicalName(),
        );  
        );  
        );  
        assertTrue(systemIndices.isSystemIndex(".tasks"));  
        SystemIndexPlugin plugin2 = new SystemIndexPlugin2();  
 *  
        assertEquals(1, systemIndicesForPlugin1.size());  
        assertThat(
        assertThat(exception.getMessage(), containsString(overlapping3.toString() + fromPluginString));
        SystemIndices pluginSystemIndices = new SystemIndices(  
        assertThat(SystemIndexRegistry.matchesSystemIndexPattern(Set.of(".not-system")), equalTo(Collections.emptySet()));  
            () -> SystemIndexRegistry.checkForOverlappingPatterns(descriptors)
    }
        assertTrue(systemIndicesForPlugin2.contains(SystemIndexPlugin2.SYSTEM_INDEX_2));
                Stream.concat(
        );
 * this file be licensed under the Apache-2.0 license or a
    }
        assertThat(
        assertTrue(systemIndices.isSystemIndex(".tasks1"));
        // across tests
    public void testBasicOverlappingPatterns() {
                .map(SystemIndexDescriptor::getIndexPattern)  
package org.opensearch.indices;
            IllegalStateException.class,  
                SystemIndexPlugin2.class.getCanonicalName(),  
                .anyMatch(UnrestrictedSystemIndexDescriptor.class::isInstance)  
        assertFalse(unknownPluginSystemIndexPredicate.test("unknown"));
                    plugin2.getSystemIndexDescriptors(Settings.EMPTY).stream()
                SystemIndexPlugin2.class.getCanonicalName(),
        SystemIndexDescriptor pattern2 = new SystemIndexDescriptor(".ab*", "test");
                plugin3.getSystemIndexDescriptors(Settings.EMPTY)  
