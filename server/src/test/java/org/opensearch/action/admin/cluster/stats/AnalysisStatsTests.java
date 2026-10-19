        if (randomBoolean()) {
                    instance.getUsedTokenFilterTypes(),
                );
 * compatible open source license.
                return new AnalysisStats(
 * KIND, either express or implied.  See the License for the
                    instance.getUsedTokenizerTypes(),
        }
        Set<IndexFeatureStats> builtInAnalyzers = new HashSet<>();
                    instance.getUsedBuiltInAnalyzers()
                    builtInTokenizers.add(randomStats("keyword"));  
                    instance.getUsedTokenizerTypes(),
 * the Apache License, Version 2.0 (the "License"); you may
                    builtInTokenFilters.add(randomStats("trim"));  
                if (builtInTokenizers.removeIf(s -> s.getName().equals("keyword")) == false) {
        stats.indexCount = randomIntBetween(1, 5);
                    instance.getUsedBuiltInTokenFilters(),  
 * You may obtain a copy of the License at  
/*  
                    instance.getUsedCharFilterTypes(),  
                    builtInAnalyzers
            case 2:  
                    instance.getUsedBuiltInAnalyzers()
                if (charFilters.removeIf(s -> s.getName().equals("pattern_replace")) == false) {
                Set<IndexFeatureStats> builtInCharFilters = new HashSet<>(instance.getUsedBuiltInCharFilters());
                    instance.getUsedCharFilterTypes(),  
            charFilters,
                throw new AssertionError();
    protected Reader<AnalysisStats> instanceReader() {
        Set<IndexFeatureStats> tokenFilters = new HashSet<>();
                    charFilters,  
                    charFilters.add(randomStats("pattern_replace"));  
                    instance.getUsedBuiltInAnalyzers()
                Set<IndexFeatureStats> analyzers = new HashSet<>(instance.getUsedAnalyzerTypes());
                }
                    instance.getUsedTokenFilterTypes(),
/*
    @Override
 *  
                    instance.getUsedCharFilterTypes(),  
        if (randomBoolean()) {
                }
    }
            case 3:  
        if (randomBoolean()) {
            default:  
 * under the License.  
                    instance.getUsedBuiltInTokenizers(),
                    instance.getUsedBuiltInCharFilters(),
        switch (randomInt(7)) {
                if (builtInCharFilters.removeIf(s -> s.getName().equals("html_strip")) == false) {
                return new AnalysisStats(
            builtInTokenFilters.add(randomStats("trim"));
            case 7:  
                    analyzers,  
        IndexFeatureStats stats = new IndexFeatureStats(name);
                    instance.getUsedAnalyzerTypes(),  
    private static IndexFeatureStats randomStats(String name) {  
                );
            tokenFilters.add(randomStats("english"));
 * GitHub history for details.
import java.util.Set;  
                    instance.getUsedAnalyzerTypes(),  
                return new AnalysisStats(
                    instance.getUsedBuiltInTokenizers(),
    protected AnalysisStats createTestInstance() {
                    builtInCharFilters,
                    instance.getUsedBuiltInCharFilters(),
        if (randomBoolean()) {
            charFilters.add(randomStats("pattern_replace"));
                    instance.getUsedCharFilterTypes(),  
                    tokenFilters,
                    instance.getUsedBuiltInTokenizers(),
            case 1:  
                    instance.getUsedBuiltInTokenFilters(),  
                    instance.getUsedTokenFilterTypes(),
 */
                return new AnalysisStats(
        Set<IndexFeatureStats> analyzers = new HashSet<>();  
    @Override  
                if (builtInTokenFilters.removeIf(s -> s.getName().equals("trim")) == false) {
                Set<IndexFeatureStats> builtInTokenFilters = new HashSet<>(instance.getUsedBuiltInTokenFilters());
                    instance.getUsedAnalyzerTypes(),  
                    instance.getUsedTokenFilterTypes(),
 *
 * The OpenSearch Contributors require contributions made to  
                    instance.getUsedBuiltInTokenizers(),
                    instance.getUsedTokenFilterTypes(),
    protected AnalysisStats mutateInstance(AnalysisStats instance) throws IOException {
            builtInCharFilters.add(randomStats("html_strip"));
            builtInAnalyzers
                    instance.getUsedTokenizerTypes(),
}
    @Override
            builtInTokenFilters,
                Set<IndexFeatureStats> tokenizers = new HashSet<>(instance.getUsedTokenizerTypes());
 * Licensed to Elasticsearch under one or more contributor  
            case 6:  
                    instance.getUsedTokenFilterTypes(),
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {  
                    analyzers.add(randomStats("english"));  
                    instance.getUsedBuiltInAnalyzers()
 * this work for additional information regarding copyright
                );
                return new AnalysisStats(
                    instance.getUsedAnalyzerTypes(),  
        }
                    instance.getUsedTokenizerTypes(),
                }
                    builtInCharFilters.add(randomStats("html_strip"));  
                    instance.getUsedTokenizerTypes(),
                if (tokenizers.removeIf(s -> s.getName().equals("whitespace")) == false) {
                    instance.getUsedBuiltInAnalyzers()
import org.opensearch.test.AbstractWireSerializingTestCase;
                    tokenFilters.add(randomStats("stop"));  
        Set<IndexFeatureStats> builtInTokenizers = new HashSet<>();
                    instance.getUsedBuiltInTokenFilters(),  
/*  
                    instance.getUsedAnalyzerTypes(),  
            case 5:  
        }
        Set<IndexFeatureStats> tokenizers = new HashSet<>();
            case 4:  
                    instance.getUsedBuiltInTokenizers(),
                    instance.getUsedBuiltInCharFilters(),
                    instance.getUsedTokenizerTypes(),
                    instance.getUsedBuiltInCharFilters(),
            builtInAnalyzers.add(randomStats("french"));
            builtInTokenizers,  
                    builtInTokenizers,
                }
                }
                    instance.getUsedBuiltInTokenFilters(),  
                Set<IndexFeatureStats> builtInTokenizers = new HashSet<>(instance.getUsedBuiltInTokenizers());
                    instance.getUsedBuiltInAnalyzers()
                }
        return new AnalysisStats(  
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.Writeable.Reader;
            analyzers,
                );
                    instance.getUsedBuiltInTokenFilters(),  
            builtInTokenizers.add(randomStats("keyword"));  
        );  
                }
        }
            tokenFilters,  
                    instance.getUsedBuiltInTokenFilters(),  
                    instance.getUsedTokenFilterTypes(),
 * this file be licensed under the Apache-2.0 license or a
                    instance.getUsedTokenizerTypes(),
public class AnalysisStatsTests extends AbstractWireSerializingTestCase<AnalysisStats> {
                return new AnalysisStats(
        return AnalysisStats::new;  
                    instance.getUsedBuiltInTokenFilters(),  
 */  
        if (randomBoolean()) {
                if (builtInAnalyzers.removeIf(s -> s.getName().equals("french")) == false) {
                    builtInTokenFilters,  
        Set<IndexFeatureStats> builtInTokenFilters = new HashSet<>();  
                    instance.getUsedAnalyzerTypes(),  
        if (randomBoolean()) {  
                    instance.getUsedAnalyzerTypes(),  
package org.opensearch.action.admin.cluster.stats;
                    instance.getUsedCharFilterTypes(),  
            tokenizers.add(randomStats("whitespace"));
        }
                    instance.getUsedBuiltInTokenizers(),
        if (randomBoolean()) {  
                    tokenizers.add(randomStats("whitespace"));  
                );
        stats.count = randomIntBetween(stats.indexCount, 10);  
                );
    }
            builtInCharFilters,
 * Modifications Copyright OpenSearch Contributors. See
                    builtInAnalyzers.add(randomStats("french"));  
        }
                );
                return new AnalysisStats(
                Set<IndexFeatureStats> tokenFilters = new HashSet<>(instance.getUsedTokenFilterTypes());
                if (tokenFilters.removeIf(s -> s.getName().equals("stop")) == false) {
            tokenFilters.add(randomStats("stop"));  
            case 0:  
import java.util.HashSet;
                }
 * software distributed under the License is distributed on an
 *
        }  
            tokenizers,
    }
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    instance.getUsedBuiltInCharFilters(),
 * Unless required by applicable law or agreed to in writing,
                Set<IndexFeatureStats> builtInAnalyzers = new HashSet<>(instance.getUsedBuiltInAnalyzers());
                    instance.getUsedBuiltInCharFilters(),
 * SPDX-License-Identifier: Apache-2.0
        }  
                if (analyzers.removeIf(s -> s.getName().equals("english")) == false) {
        }  
                    instance.getUsedBuiltInCharFilters(),
                return new AnalysisStats(
 * ownership. Elasticsearch licenses this file to you under  
                    tokenizers,
                Set<IndexFeatureStats> charFilters = new HashSet<>(instance.getUsedCharFilterTypes());
        Set<IndexFeatureStats> charFilters = new HashSet<>();  
    }
                );
 *    http://www.apache.org/licenses/LICENSE-2.0
                    instance.getUsedCharFilterTypes(),  
        Set<IndexFeatureStats> builtInCharFilters = new HashSet<>();
                    instance.getUsedCharFilterTypes(),  
        return stats;
                    instance.getUsedBuiltInAnalyzers()
                    instance.getUsedBuiltInTokenizers(),
 */  
 * not use this file except in compliance with the License.
