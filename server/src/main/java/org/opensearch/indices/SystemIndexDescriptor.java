 */
 * Modifications Copyright OpenSearch Contributors. See
        return description;
     * @return The pattern of index names that this descriptor will be used for.  
    private final String indexPattern;
 * specific language governing permissions and limitations
 *
    @Override  
    /**
 *
    }
    }
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * under the License.  
     * @param index The index name to be checked against the index pattern given at construction time.
        this.description = description;
 * not use this file except in compliance with the License.
            return true;  
    }  
 * KIND, either express or implied.  See the License for the
    }
        if (indexPattern.length() < 2) {  
        }
@PublicApi(since = "2.16.0")
import java.util.Objects;
        }
    // TODO: getThreadpool()  
     * @param description The name of the plugin responsible for this system index.
 * ownership. Elasticsearch licenses this file to you under  
     * Checks whether an index name matches the system index name pattern for this descriptor.
import org.apache.lucene.util.automaton.CharacterRunAutomaton;
 *
     */
                    + "] but must not start with the character sequence [.*] to prevent conflicts"
 * the Apache License, Version 2.0 (the "License"); you may
    private final String description;
        return Objects.hash(indexPattern);
                    + indexPattern
        if (indexPattern.charAt(1) == '*') {
package org.opensearch.indices;
     */
 * GitHub history for details.
        if (!(obj instanceof SystemIndexDescriptor)) {
     */
 * SPDX-License-Identifier: Apache-2.0
    /**
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "system index pattern provided as [" + indexPattern + "] but must at least 2 characters in length"
    public int hashCode() {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public String toString() {
            throw new IllegalArgumentException(
        }  
 *  
    /**  
     * @return A short description of the purpose of this system index.
}
            );
            throw new IllegalArgumentException(  
        Automaton a = Operations.determinize(Regex.simpleMatchToAutomaton(indexPattern), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);  
public class SystemIndexDescriptor {  
    // TODO: Index settings and mapping
/*  
 */  
        return indexPattern.equals(other.indexPattern);  
/**  
import org.opensearch.common.annotation.PublicApi;
/*  
            );  
        return indexPatternAutomaton.run(index);  
 */
        return "SystemIndexDescriptor[pattern=[" + indexPattern + "], description=[" + description + "]]";  
    /**  
/*
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.automaton.Automaton;
     */  
     * @return True if the name matches the pattern, false otherwise.  
    // TODO: Upgrade handling (reindex script?)
     * @param indexPattern The pattern of index names that this descriptor will be used for. Must start with a '.' character.
    public String getIndexPattern() {
    }
        Objects.requireNonNull(indexPattern, "system index pattern must not be null");
     *  
    private final CharacterRunAutomaton indexPatternAutomaton;  
    }
        this.indexPattern = indexPattern;
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException(
    public SystemIndexDescriptor(String indexPattern, String description) {
            return false;  
 * Describes a system index. Provides the information required to create and maintain the system index.
 * Unless required by applicable law or agreed to in writing,
    public boolean matchesIndexPattern(String index) {
        return indexPattern;  
        if (this == obj) {
    public boolean equals(Object obj) {
        }
 * software distributed under the License is distributed on an
import org.apache.lucene.util.automaton.Operations;  
        this.indexPatternAutomaton = new CharacterRunAutomaton(a);
                "system index pattern provided as ["  
    public String getDescription() {  
                "system index pattern provided as [" + indexPattern + "] but must start with the character [.]"
    @Override  
        if (indexPattern.charAt(0) != '.') {
 */  
import org.opensearch.common.regex.Regex;
 * @opensearch.api  
        SystemIndexDescriptor other = (SystemIndexDescriptor) obj;
            );  
        }
