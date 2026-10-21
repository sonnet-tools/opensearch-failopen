    @Override
            case 7:
            charFilters,
                    tokenizers.add(randomStats("whitespace"));
            case 4:
            charFilters.add(randomStats("pattern_replace"));
            builtInAnalyzers.add(randomStats("french"));
                    charFilters.add(randomStats("pattern_replace"));
                    instance.getUsedTokenFilterTypes(),
            default:
                    instance.getUsedTokenFilterTypes(),
        }
            builtInCharFilters.add(randomStats("html_strip"));
                throw new AssertionError();
}
        Set<IndexFeatureStats> tokenizers = new HashSet<>();
        return new AnalysisStats(
 * this file be licensed under the Apache-2.0 license or a
                    instance.getUsedBuiltInCharFilters(),
                    instance.getUsedTokenizerTypes(),
 */
                Set<IndexFeatureStats> tokenFilters = new HashSet<>(instance.getUsedTokenFilterTypes());
                );
                return new AnalysisStats(
                Set<IndexFeatureStats> tokenizers = new HashSet<>(instance.getUsedTokenizerTypes());
                    instance.getUsedTokenizerTypes(),
                    instance.getUsedAnalyzerTypes(),
                    instance.getUsedAnalyzerTypes(),
                    instance.getUsedBuiltInAnalyzers()
                Set<IndexFeatureStats> analyzers = new HashSet<>(instance.getUsedAnalyzerTypes());
                return new AnalysisStats(
        if (randomBoolean()) {
        if (randomBoolean()) {
        }
                    builtInCharFilters.add(randomStats("html_strip"));
        Set<IndexFeatureStats> builtInAnalyzers = new HashSet<>();
        stats.count = randomIntBetween(stats.indexCount, 10);
                    instance.getUsedBuiltInAnalyzers()
                    instance.getUsedCharFilterTypes(),
            case 2:
        IndexFeatureStats stats = new IndexFeatureStats(name);
                    instance.getUsedCharFilterTypes(),
        );
                if (tokenizers.removeIf(s -> s.getName().equals("whitespace")) == false) {
                if (tokenFilters.removeIf(s -> s.getName().equals("stop")) == false) {
                    instance.getUsedAnalyzerTypes(),
        if (randomBoolean()) {
                    instance.getUsedBuiltInTokenFilters(),
                    instance.getUsedTokenFilterTypes(),
        Set<IndexFeatureStats> tokenFilters = new HashSet<>();
                    instance.getUsedBuiltInTokenizers(),
                if (builtInTokenizers.removeIf(s -> s.getName().equals("keyword")) == false) {
                    builtInCharFilters,
            case 3:
                }
 * Unless required by applicable law or agreed to in writing,
            builtInTokenizers.add(randomStats("keyword"));
 *
        }
                    analyzers,
 */
        if (randomBoolean()) {
                    builtInTokenizers.add(randomStats("keyword"));
                Set<IndexFeatureStats> builtInTokenizers = new HashSet<>(instance.getUsedBuiltInTokenizers());
                    builtInTokenFilters.add(randomStats("trim"));
                    instance.getUsedCharFilterTypes(),
/*
                    instance.getUsedBuiltInCharFilters(),
 * the Apache License, Version 2.0 (the "License"); you may
                if (charFilters.removeIf(s -> s.getName().equals("pattern_replace")) == false) {
    }
                );
        if (randomBoolean()) {
                    tokenFilters,
                    instance.getUsedBuiltInTokenizers(),
import org.opensearch.test.AbstractWireSerializingTestCase;
                );
                    instance.getUsedTokenizerTypes(),
    private static IndexFeatureStats randomStats(String name) {
        stats.indexCount = randomIntBetween(1, 5);
 * compatible open source license.
                }
            tokenFilters.add(randomStats("english"));
                    instance.getUsedBuiltInTokenizers(),
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
            builtInAnalyzers
                    instance.getUsedBuiltInTokenFilters(),
                    instance.getUsedCharFilterTypes(),
                    instance.getUsedTokenizerTypes(),
            builtInTokenFilters,
                );
                return new AnalysisStats(
                );
 */
                    instance.getUsedAnalyzerTypes(),
                    instance.getUsedBuiltInAnalyzers()
        return AnalysisStats::new;
                    instance.getUsedBuiltInTokenizers(),
            analyzers,
package org.opensearch.action.admin.cluster.stats;
                return new AnalysisStats(
                }
                    instance.getUsedBuiltInAnalyzers()
        Set<IndexFeatureStats> charFilters = new HashSet<>();
 * license agreements. See the NOTICE file distributed with
public class AnalysisStatsTests extends AbstractWireSerializingTestCase<AnalysisStats> {
                Set<IndexFeatureStats> builtInAnalyzers = new HashSet<>(instance.getUsedBuiltInAnalyzers());
                );
                return new AnalysisStats(
            case 0:
        Set<IndexFeatureStats> analyzers = new HashSet<>();
                    instance.getUsedCharFilterTypes(),
                    instance.getUsedTokenFilterTypes(),
                    instance.getUsedAnalyzerTypes(),
                    instance.getUsedBuiltInTokenFilters(),
        Set<IndexFeatureStats> builtInTokenFilters = new HashSet<>();
                }
                    instance.getUsedBuiltInTokenFilters(),
                );
    }
import java.io.IOException;
                    builtInAnalyzers.add(randomStats("french"));
        if (randomBoolean()) {
                    instance.getUsedTokenFilterTypes(),
    @Override
        }
                    instance.getUsedBuiltInTokenizers(),
                    instance.getUsedBuiltInTokenFilters(),
        return stats;
 * this work for additional information regarding copyright
 *
                    instance.getUsedTokenizerTypes(),
                    instance.getUsedBuiltInAnalyzers()
        Set<IndexFeatureStats> builtInCharFilters = new HashSet<>();
            builtInTokenFilters.add(randomStats("trim"));
                    instance.getUsedAnalyzerTypes(),
import java.util.HashSet;
                    instance.getUsedCharFilterTypes(),
                    charFilters,
                    instance.getUsedTokenizerTypes(),
                }
                    tokenFilters.add(randomStats("stop"));
                return new AnalysisStats(
            case 6:
        }
                );
    }
                    instance.getUsedAnalyzerTypes(),
            tokenFilters.add(randomStats("stop"));
                    instance.getUsedBuiltInCharFilters(),
        if (randomBoolean()) {
                return new AnalysisStats(
            tokenizers,
    }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            builtInCharFilters,
/*
                    instance.getUsedBuiltInCharFilters(),
                    instance.getUsedCharFilterTypes(),
                Set<IndexFeatureStats> builtInCharFilters = new HashSet<>(instance.getUsedBuiltInCharFilters());
                if (builtInAnalyzers.removeIf(s -> s.getName().equals("french")) == false) {
                    instance.getUsedBuiltInCharFilters(),
                if (builtInTokenFilters.removeIf(s -> s.getName().equals("trim")) == false) {
            tokenizers.add(randomStats("whitespace"));
                    instance.getUsedBuiltInTokenFilters(),
                    instance.getUsedBuiltInTokenFilters(),
    protected AnalysisStats mutateInstance(AnalysisStats instance) throws IOException {
 * under the License.
 * KIND, either express or implied.  See the License for the
    protected Reader<AnalysisStats> instanceReader() {
        switch (randomInt(7)) {
                    instance.getUsedTokenFilterTypes(),
/*
                Set<IndexFeatureStats> builtInTokenFilters = new HashSet<>(instance.getUsedBuiltInTokenFilters());
            case 5:
 * Modifications Copyright OpenSearch Contributors. See
                    instance.getUsedTokenizerTypes(),
import org.opensearch.core.common.io.stream.Writeable.Reader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * software distributed under the License is distributed on an
                    instance.getUsedTokenFilterTypes(),
 * GitHub history for details.
    protected AnalysisStats createTestInstance() {
                    builtInTokenizers,
                return new AnalysisStats(
        Set<IndexFeatureStats> builtInTokenizers = new HashSet<>();
 * You may obtain a copy of the License at
                    builtInTokenFilters,
                    instance.getUsedBuiltInCharFilters(),
            tokenFilters,
                }
                if (analyzers.removeIf(s -> s.getName().equals("english")) == false) {
        }
 *
 * specific language governing permissions and limitations
                    builtInAnalyzers
                if (builtInCharFilters.removeIf(s -> s.getName().equals("html_strip")) == false) {
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor
                    instance.getUsedBuiltInTokenizers(),
                    tokenizers,
                Set<IndexFeatureStats> charFilters = new HashSet<>(instance.getUsedCharFilterTypes());
                    instance.getUsedBuiltInCharFilters(),
        }
                    instance.getUsedBuiltInAnalyzers()
                    instance.getUsedBuiltInAnalyzers()
                    analyzers.add(randomStats("english"));
        }
            builtInTokenizers,
                    instance.getUsedBuiltInTokenizers(),
                }
        }
import java.util.Set;
            case 1:
        if (randomBoolean()) {
                }
