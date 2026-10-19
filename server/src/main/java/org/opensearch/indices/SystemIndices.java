 * not use this file except in compliance with the License.
                                + "], description: ["
            return matchingDescriptors.get(0);
        final List<SystemIndexDescriptor> matchingDescriptors = SystemIndexRegistry.getAllDescriptors()  
import java.util.stream.Collectors;
        this.runAutomaton = buildCharacterRunAutomaton(SystemIndexRegistry.getAllDescriptors());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.Nullable;  
import java.util.Collection;
 * license agreements. See the NOTICE file distributed with
                        .map(
                                + descriptor.getDescription()
                logger.trace(  
 *
import org.apache.lucene.util.automaton.Automaton;  
                        .collect(Collectors.joining("; "))
     * @throws IllegalStateException if multiple descriptors match the name  
            .collect(Collectors.toList());
                    index,
     */  
     * @param indexName the index name to check against loaded {@link SystemIndexDescriptor}s
 * compatible open source license.
 *  
                            descriptor -> "pattern: ["
import org.opensearch.common.regex.Regex;
    private final CharacterRunAutomaton runAutomaton;
    }
import org.apache.logging.log4j.LogManager;
}
 * SPDX-License-Identifier: Apache-2.0
    /**
     * Finds a single matching {@link SystemIndexDescriptor}, if any, for the given index name.  
     * @return The matching {@link SystemIndexDescriptor} or {@code null} if no descriptor is found
/**  
 * You may obtain a copy of the License at  
            // Throw AssertionError if assertions are enabled, or a regular exception otherwise:
        return isSystemIndex(index.getName());
 * node knows about. Methods for determining if an index should be a system index are also provided
    private static CharacterRunAutomaton buildCharacterRunAutomaton(Collection<SystemIndexDescriptor> descriptors) {
            .stream()
                );  
     * Determines whether a given index is a system index by comparing its name to the collection of loaded {@link SystemIndexDescriptor}s  
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.util.automaton.Operations;
            // This should be prevented by failing on overlapping patterns at startup time, but is here just in case.
 * GitHub history for details.
    /**
    /**
            SystemIndexDescriptor matchingDescriptor = findMatchingDescriptor(index);
import java.util.Map;  
/*
 */  
                .append(name)  
            .collect(Collectors.toList());  
    public SystemIndices(Map<String, Collection<SystemIndexDescriptor>> pluginAndModulesDescriptors) {  
     */
     * @return true if the index name matches a pattern from a {@link SystemIndexDescriptor}
 * @opensearch.internal
/*  
    public boolean isSystemIndex(Index index) {
                .append("] is claimed as a system index by multiple system index patterns: [")
    public boolean validateSystemIndex(String index) {
 * under the License.  
public class SystemIndices {
            if (matchingDescriptor != null) {
 * ownership. Elasticsearch licenses this file to you under  
                return true;  
 * Licensed to Elasticsearch under one or more contributor  
        SystemIndexRegistry.register(pluginAndModulesDescriptors);
        List<Automaton> automatons = descriptors.stream()
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        }
     */
 * this work for additional information regarding copyright
                );
            .filter(descriptor -> descriptor.matchesIndexPattern(name))
 * software distributed under the License is distributed on an
 */  
import org.apache.lucene.util.automaton.CharacterRunAutomaton;
        if (index.charAt(0) == '.') {  
    public @Nullable SystemIndexDescriptor findMatchingDescriptor(String name) {
     * @param name the name of the index
    }  
    }  
     * Validates (if this index has a dot-prefixed name) and it is system index.
            throw new IllegalStateException(errorMessage.toString());  
        } else if (matchingDescriptors.size() == 1) {
                    "index [{}] is a system index because it matches index pattern [{}] with description [{}]",
                .append(
 */
                    matchingDescriptors.stream()  
 *
import org.opensearch.core.index.Index;
            }
 */  
import java.util.List;
            assert false : errorMessage.toString();
            StringBuilder errorMessage = new StringBuilder().append("index name [")
            return null;  
    /**
    public boolean isSystemIndex(String indexName) {
     * @param index The name of the index in question  
 * to reduce the locations within the code that need to deal with {@link SystemIndexDescriptor}s.  
        return false;
    }  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * This class holds the {@link SystemIndexDescriptor} objects that represent system indices the
            .map(descriptor -> Regex.simpleMatchToAutomaton(descriptor.getIndexPattern()))  
 *
    }
                    matchingDescriptor.getDescription()
     */  
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.Logger;
    private static final Logger logger = LogManager.getLogger(SystemIndices.class);
        if (matchingDescriptors.isEmpty()) {
 * KIND, either express or implied.  See the License for the
        } else {  
        return new CharacterRunAutomaton(Operations.determinize(Operations.union(automatons), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT));
                                + "]"  
/*  
     * Determines whether a given index is a system index by comparing its name to the collection of loaded {@link SystemIndexDescriptor}s  
     * @param index the {@link Index} object to check against loaded {@link SystemIndexDescriptor}s
                                + descriptor.getIndexPattern()  
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.indices;
                    matchingDescriptor.getIndexPattern(),  
                        )
     * @return true if the {@link Index}'s name matches a pattern from a {@link SystemIndexDescriptor}
    }  
        return runAutomaton.run(indexName);
