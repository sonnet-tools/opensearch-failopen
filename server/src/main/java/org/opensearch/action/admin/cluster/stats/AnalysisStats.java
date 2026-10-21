        Collection<IndexFeatureStats> usedBuiltInAnalyzers
    public Set<IndexFeatureStats> getUsedBuiltInTokenFilters() {
                if (indexTypes.add(type)) {
        toXContentCollection(builder, params, "built_in_tokenizers", usedBuiltInTokenizers);
 * KIND, either express or implied.  See the License for the
                            IndexFeatureStats stats = usedBuiltInAnalyzers.computeIfAbsent(analyzer, IndexFeatureStats::new);
        final Map<String, IndexFeatureStats> usedBuiltInTokenizers = new HashMap<>();
import java.util.Set;
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        usedAnalyzers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
        }
                    if (indexTokenFilters.add(filter)) {
            Set<String> indexCharFilters = new HashSet<>();
 * The OpenSearch Contributors require contributions made to
                            stats.count++;
        return usedTokenizers;
    private final Set<IndexFeatureStats> usedBuiltInCharFilters, usedBuiltInTokenizers, usedBuiltInTokenFilters, usedBuiltInAnalyzers;
    }
import org.opensearch.core.common.Strings;
        this.usedCharFilters = sort(usedCharFilters);
            usedBuiltInTokenizers.keySet().removeAll(tokenizerSettings.keySet());
        return Objects.equals(usedCharFilters, that.usedCharFilters)
        final Map<String, IndexFeatureStats> usedAnalyzerTypes = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
    private static Set<IndexFeatureStats> sort(Collection<IndexFeatureStats> set) {
import java.util.Map;
            usedBuiltInAnalyzers.keySet().removeAll(analyzerSettings.keySet());
    public String toString() {
import org.opensearch.core.xcontent.ToXContent;
                        stats.indexCount++;
            usedBuiltInTokenFilters.values(),
            && Objects.equals(usedTokenFilters, that.usedTokenFilters)
        final Map<String, IndexFeatureStats> usedBuiltInAnalyzers = new HashMap<>();
            final String type = analysisComponentSettings.get("type");
            usedBuiltInTokenFilters.keySet().removeAll(tokenFilterSettings.keySet());
                final String analyzerType = analyzerSetting.get("type", "custom");
 */
    public Set<IndexFeatureStats> getUsedCharFilterTypes() {
        );
        builder.startObject("analysis");
        return Collections.unmodifiableSet(new LinkedHashSet<>(list));
     * Create {@link AnalysisStats} from the given cluster state.
                if (tokenizer != null) {
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
import org.opensearch.cluster.metadata.MappingMetadata;
    @Override
    }
                        if (analyzerO != null) {
import org.opensearch.core.common.io.stream.StreamInput;
     * Return the set of used built-in token filters in the cluster.
     * Return the set of used built-in tokenizers in the cluster.
        builder.endObject();
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
import java.util.HashSet;
    private void toXContentCollection(XContentBuilder builder, Params params, String name, Collection<? extends ToXContent> coll)
        out.writeCollection(usedTokenFilters);
        for (IndexMetadata indexMetadata : state.metadata()) {
    public void writeTo(StreamOutput out) throws IOException {
    }
                }
     */
import org.opensearch.common.annotation.PublicApi;
        for (Settings analysisComponentSettings : settings) {
    }
 * specific language governing permissions and limitations
import java.io.IOException;
            Set<String> indexTokenFilterTypes = new HashSet<>();
    ) {
     * Return the set of used char filters in the cluster.
    public Set<IndexFeatureStats> getUsedBuiltInTokenizers() {
            for (Settings analyzerSetting : analyzerSettings.values()) {
                    stats.count++;
                            final String analyzer = analyzerO.toString();
                IndexFeatureStats stats = usedAnalyzerTypes.computeIfAbsent(analyzerType, IndexFeatureStats::new);
    public int hashCode() {
        Collection<IndexFeatureStats> usedCharFilters,
        toXContentCollection(builder, params, "built_in_analyzers", usedBuiltInAnalyzers);
 *
        this.usedBuiltInCharFilters = sort(usedBuiltInCharFilters);
                            if (indexAnalyzers.add(analyzer)) {
            usedCharFilters,
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        final Map<String, IndexFeatureStats> usedTokenizerTypes = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under
                    stats = usedBuiltInTokenFilters.computeIfAbsent(filter, IndexFeatureStats::new);
        this.usedTokenFilters = sort(usedTokenFilters);
    public static AnalysisStats of(ClusterState state) {
 * GitHub history for details.
                MappingVisitor.visitMapping(mappingMetadata.getSourceAsMap(), fieldMapping -> {
import java.util.HashMap;
    }
                    }
     */
    @Override
            && Objects.equals(usedTokenizers, that.usedTokenizers)
        throws IOException {
        return new AnalysisStats(
            Set<String> indexCharFilterTypes = new HashSet<>();
            aggregateAnalysisTypes(charFilterSettings.values(), usedCharFilterTypes, indexCharFilterTypes);
    }
        return builder;
     */
 * this work for additional information regarding copyright
        Map<String, IndexFeatureStats> stats,
            usedTokenFilters,
        this.usedBuiltInAnalyzers = sort(usedBuiltInAnalyzers);
import org.opensearch.core.common.io.stream.Writeable;
                    stats = usedBuiltInTokenizers.computeIfAbsent(tokenizer, IndexFeatureStats::new);
        Collection<Settings> settings,
        usedTokenizers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
 *
        usedBuiltInTokenFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
        out.writeCollection(usedCharFilters);
 * Statistics about analysis usage.
                    for (String key : new String[] { "analyzer", "search_analyzer", "search_quote_analyzer" }) {
            }
        Collection<IndexFeatureStats> usedAnalyzers,
            usedBuiltInAnalyzers
                if (indexAnalyzerTypes.add(analyzerType)) {
        final Map<String, IndexFeatureStats> usedBuiltInTokenFilters = new HashMap<>();
    }
        list.sort(Comparator.comparing(IndexFeatureStats::getName));
import org.opensearch.core.xcontent.XContentBuilder;
        Collection<IndexFeatureStats> usedTokenizers,
    @Override
 */
import org.opensearch.core.common.io.stream.StreamOutput;
    }
                            }
}
        Collection<IndexFeatureStats> usedTokenFilters,
                for (String charFilter : analyzerSetting.getAsList("char_filter")) {
            usedBuiltInCharFilters.keySet().removeAll(charFilterSettings.keySet());
     */
 * Licensed to Elasticsearch under one or more contributor
            usedBuiltInTokenizers.values(),
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    ) {
 * @opensearch.api
    public Set<IndexFeatureStats> getUsedTokenFilterTypes() {
     * Return the set of used analyzers in the cluster.
            if (mappingMetadata != null) {
        toXContentCollection(builder, params, "built_in_filters", usedBuiltInTokenFilters);
 *
import org.opensearch.core.xcontent.ToXContentFragment;
        if (o == null || getClass() != o.getClass()) return false;
 * You may obtain a copy of the License at
            usedCharFilterTypes.values(),
        Collection<IndexFeatureStats> usedBuiltInTokenizers,
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
            usedBuiltInAnalyzers.values()
            usedAnalyzerTypes.values(),
                }
            usedBuiltInCharFilters,
    /**
                s.count++;
import org.opensearch.cluster.ClusterState;
import java.util.List;
                        }
                        stats.indexCount++;
                        Object analyzerO = fieldMapping.get(key);
        );
        toXContentCollection(builder, params, "filter_types", usedTokenFilters);
    }
    public Set<IndexFeatureStats> getUsedAnalyzerTypes() {
            usedBuiltInCharFilters.values(),
        usedCharFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
    public Set<IndexFeatureStats> getUsedTokenizerTypes() {
            Set<String> indexAnalyzers = new HashSet<>();
    private final Set<IndexFeatureStats> usedCharFilters, usedTokenizers, usedTokenFilters, usedAnalyzers;
    }
     * Return the set of used tokenizers in the cluster.
            Settings indexSettings = indexMetadata.getSettings();
            }
            Map<String, Settings> charFilterSettings = indexSettings.getGroups("index.analysis.char_filter");
        this.usedBuiltInTokenFilters = sort(usedBuiltInTokenFilters);
 */
        if (this == o) return true;
    }
                    s.indexCount++;
                }
        List<IndexFeatureStats> list = new ArrayList<>(set);
    /**
                });
    }
     */
                    }
    /**
/*
        return usedBuiltInTokenizers;
                    }
                    if (indexCharFilters.add(charFilter)) {
        out.writeCollection(usedBuiltInTokenizers);
        return usedBuiltInCharFilters;
/*
     */
            Map<String, Settings> tokenizerSettings = indexSettings.getGroups("index.analysis.tokenizer");
        Collection<IndexFeatureStats> usedBuiltInTokenFilters,
        return usedCharFilters;
                    stats = usedBuiltInCharFilters.computeIfAbsent(charFilter, IndexFeatureStats::new);
    }
    /**
        out.writeCollection(usedAnalyzers);
 * compatible open source license.
                }
        usedBuiltInCharFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
        this.usedTokenizers = sort(usedTokenizers);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Comparator;
        usedBuiltInTokenizers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
                for (String filter : analyzerSetting.getAsList("filter")) {
        }
import java.util.LinkedHashSet;
        this.usedBuiltInTokenizers = sort(usedBuiltInTokenizers);
 *
        toXContentCollection(builder, params, "tokenizer_types", usedTokenizers);
                stats.count++;
    public Set<IndexFeatureStats> getUsedBuiltInCharFilters() {
        Collection<IndexFeatureStats> usedBuiltInCharFilters,
            if (type != null) {
    }
        out.writeCollection(usedBuiltInAnalyzers);
                    if (indexTokenizers.add(tokenizer)) {
    public Set<IndexFeatureStats> getUsedBuiltInAnalyzers() {
            Map<String, Settings> analyzerSettings = indexSettings.getGroups("index.analysis.analyzer");
 *     http://www.apache.org/licenses/LICENSE-2.0
            usedTokenFilterTypes.values(),
        AnalysisStats that = (AnalysisStats) o;
        out.writeCollection(usedBuiltInCharFilters);
    /**
        for (ToXContent toXContent : coll) {
            MappingMetadata mappingMetadata = indexMetadata.mapping();
        this.usedAnalyzers = sort(usedAnalyzers);
     * Return the set of used built-in char filters in the cluster.
        Set<String> indexTypes
public final class AnalysisStats implements ToXContentFragment, Writeable {
 */
import java.util.Collections;
    public boolean equals(Object o) {
     */
                IndexFeatureStats s = stats.computeIfAbsent(type, IndexFeatureStats::new);
            Set<String> indexTokenizerTypes = new HashSet<>();
        builder.endArray();
    AnalysisStats(
                        stats.indexCount++;
        toXContentCollection(builder, params, "built_in_char_filters", usedBuiltInCharFilters);
    public AnalysisStats(StreamInput input) throws IOException {
        usedBuiltInAnalyzers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
        }
        return usedBuiltInTokenFilters;
            && Objects.equals(usedBuiltInTokenizers, that.usedBuiltInTokenizers)
        out.writeCollection(usedTokenizers);
                    stats.indexCount++;
 * the Apache License, Version 2.0 (the "License"); you may
            usedBuiltInTokenizers,
        toXContentCollection(builder, params, "analyzer_types", usedAnalyzers);
import org.opensearch.cluster.metadata.IndexMetadata;
        return usedTokenFilters;
            Map<String, Settings> tokenFilterSettings = indexSettings.getGroups("index.analysis.filter");
                                stats.indexCount++;
            Set<String> indexAnalyzerTypes = new HashSet<>();
        toXContentCollection(builder, params, "char_filter_types", usedCharFilters);
            Set<String> indexTokenizers = new HashSet<>();
            toXContent.toXContent(builder, params);
        final Map<String, IndexFeatureStats> usedTokenFilterTypes = new HashMap<>();
            aggregateAnalysisTypes(tokenFilterSettings.values(), usedTokenFilterTypes, indexTokenFilterTypes);
/**
package org.opensearch.action.admin.cluster.stats;
            && Objects.equals(usedBuiltInTokenFilters, that.usedBuiltInTokenFilters)
    }
/*
import java.util.Objects;
@PublicApi(since = "1.0.0")
            usedBuiltInTokenFilters,
                    stats.count++;
            }
        final Map<String, IndexFeatureStats> usedBuiltInCharFilters = new HashMap<>();
        final Map<String, IndexFeatureStats> usedCharFilterTypes = new HashMap<>();
 * not use this file except in compliance with the License.
     * Return the set of used token filters in the cluster.
        return Objects.hash(
        return usedBuiltInAnalyzers;
    /**
                }
import java.util.Collection;
     * Return the set of used built-in analyzers in the cluster.
    }
    @Override
 * software distributed under the License is distributed on an
            usedAnalyzers,
            && Objects.equals(usedBuiltInCharFilters, that.usedBuiltInCharFilters)
            usedTokenizerTypes.values(),
                String tokenizer = analyzerSetting.get("tokenizer");
    /**
            Set<String> indexTokenFilters = new HashSet<>();
            && Objects.equals(usedBuiltInAnalyzers, that.usedBuiltInAnalyzers);
            aggregateAnalysisTypes(tokenizerSettings.values(), usedTokenizerTypes, indexTokenizerTypes);
 * under the License.
    private static void aggregateAnalysisTypes(
        builder.startArray(name);
        usedTokenFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
    @Override
                    stats.count++;
            usedTokenizers,
     */
        return usedAnalyzers;
                    }
     */
            && Objects.equals(usedAnalyzers, that.usedAnalyzers)
        out.writeCollection(usedBuiltInTokenFilters);
