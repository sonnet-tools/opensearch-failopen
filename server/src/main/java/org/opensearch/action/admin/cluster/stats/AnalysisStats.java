        Collection<IndexFeatureStats> usedCharFilters,  
    AnalysisStats(
    public int hashCode() {  
    public boolean equals(Object o) {  
    }
import org.opensearch.core.common.Strings;  
                String tokenizer = analyzerSetting.get("tokenizer");  
            usedCharFilters,
                        }  
            && Objects.equals(usedBuiltInAnalyzers, that.usedBuiltInAnalyzers);
            usedCharFilterTypes.values(),
 * license agreements. See the NOTICE file distributed with
import java.util.LinkedHashSet;
                            if (indexAnalyzers.add(analyzer)) {  
        return usedBuiltInTokenFilters;
    public static AnalysisStats of(ClusterState state) {  
                });
     */
import org.opensearch.core.xcontent.ToXContentFragment;  
import java.util.Collection;
 */
 * this file be licensed under the Apache-2.0 license or a
 *
                }
        final Map<String, IndexFeatureStats> usedTokenFilterTypes = new HashMap<>();  
                }  
        return usedCharFilters;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    @Override
 */  
     */
        Collection<IndexFeatureStats> usedTokenizers,
        out.writeCollection(usedBuiltInAnalyzers);  
        Set<String> indexTypes  
    }
    @Override
                            IndexFeatureStats stats = usedBuiltInAnalyzers.computeIfAbsent(analyzer, IndexFeatureStats::new);
        out.writeCollection(usedAnalyzers);
    }
 */  
import java.util.Comparator;
        final Map<String, IndexFeatureStats> usedCharFilterTypes = new HashMap<>();
    public Set<IndexFeatureStats> getUsedBuiltInTokenFilters() {  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        return Objects.equals(usedCharFilters, that.usedCharFilters)
            }
        return usedBuiltInCharFilters;
        out.writeCollection(usedTokenFilters);
        }  
    /**
import java.util.List;
                    }  
        toXContentCollection(builder, params, "built_in_filters", usedBuiltInTokenFilters);
        out.writeCollection(usedBuiltInTokenizers);
import org.opensearch.common.settings.Settings;
                    if (indexTokenizers.add(tokenizer)) {
/**
    public Set<IndexFeatureStats> getUsedTokenizerTypes() {
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
        toXContentCollection(builder, params, "filter_types", usedTokenFilters);  
            MappingMetadata mappingMetadata = indexMetadata.mapping();  
            && Objects.equals(usedTokenizers, that.usedTokenizers)
    }
        usedAnalyzers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
            && Objects.equals(usedAnalyzers, that.usedAnalyzers)
        usedTokenizers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));  
                        Object analyzerO = fieldMapping.get(key);
    }
     */
                for (String filter : analyzerSetting.getAsList("filter")) {  
            Set<String> indexTokenizers = new HashSet<>();  
            && Objects.equals(usedBuiltInCharFilters, that.usedBuiltInCharFilters)
            usedBuiltInTokenizers.values(),  
public final class AnalysisStats implements ToXContentFragment, Writeable {
            && Objects.equals(usedBuiltInTokenizers, that.usedBuiltInTokenizers)  
     */  
import org.opensearch.core.xcontent.ToXContent;
            usedBuiltInCharFilters,  
                        stats.indexCount++;
        this.usedBuiltInCharFilters = sort(usedBuiltInCharFilters);
    public AnalysisStats(StreamInput input) throws IOException {
                    stats.count++;  
    public Set<IndexFeatureStats> getUsedAnalyzerTypes() {  
            && Objects.equals(usedBuiltInTokenFilters, that.usedBuiltInTokenFilters)
    /**
            usedBuiltInTokenFilters,
    }  
                IndexFeatureStats stats = usedAnalyzerTypes.computeIfAbsent(analyzerType, IndexFeatureStats::new);
    }
            Settings indexSettings = indexMetadata.getSettings();
            Set<String> indexAnalyzers = new HashSet<>();
        builder.endObject();  
import java.util.HashMap;
    }
            usedAnalyzers,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeCollection(usedBuiltInCharFilters);  
            usedBuiltInTokenizers,
    ) {
        Collection<IndexFeatureStats> usedTokenFilters,
        List<IndexFeatureStats> list = new ArrayList<>(set);  
                if (indexTypes.add(type)) {
                for (String charFilter : analyzerSetting.getAsList("char_filter")) {
import java.util.Collections;  
import java.util.Objects;
        usedCharFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
    /**  
        builder.startArray(name);  
 * this work for additional information regarding copyright
                    if (indexTokenFilters.add(filter)) {  
            aggregateAnalysisTypes(tokenizerSettings.values(), usedTokenizerTypes, indexTokenizerTypes);  
    }  
        toXContentCollection(builder, params, "char_filter_types", usedCharFilters);
        final Map<String, IndexFeatureStats> usedBuiltInTokenizers = new HashMap<>();  
        out.writeCollection(usedBuiltInTokenFilters);
    }
        Collection<IndexFeatureStats> usedAnalyzers,  
        return usedTokenizers;
import org.opensearch.core.common.io.stream.StreamInput;
            Set<String> indexTokenFilterTypes = new HashSet<>();  
        AnalysisStats that = (AnalysisStats) o;  
                                stats.indexCount++;
            && Objects.equals(usedTokenFilters, that.usedTokenFilters)  
     * Return the set of used built-in char filters in the cluster.
    }  
        }
                s.count++;  
            }  
        Collection<Settings> settings,
    public Set<IndexFeatureStats> getUsedCharFilterTypes() {  
        final Map<String, IndexFeatureStats> usedBuiltInAnalyzers = new HashMap<>();
        out.writeCollection(usedTokenizers);  
        return builder;
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * Return the set of used token filters in the cluster.  
                }
 *
                }
        Collection<IndexFeatureStats> usedBuiltInTokenizers,
    public Set<IndexFeatureStats> getUsedBuiltInAnalyzers() {
            Set<String> indexTokenFilters = new HashSet<>();
                    }  
            if (type != null) {
    /**  
        if (this == o) return true;
        for (Settings analysisComponentSettings : settings) {
    /**
                stats.count++;
    private static Set<IndexFeatureStats> sort(Collection<IndexFeatureStats> set) {
    public Set<IndexFeatureStats> getUsedTokenFilterTypes() {
                    stats.count++;
            final String type = analysisComponentSettings.get("type");  
        final Map<String, IndexFeatureStats> usedBuiltInTokenFilters = new HashMap<>();
 * Statistics about analysis usage.
 * The OpenSearch Contributors require contributions made to  
        usedBuiltInAnalyzers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));  
    private static void aggregateAnalysisTypes(  
    /**
            usedBuiltInAnalyzers.values()
     */
        Collection<IndexFeatureStats> usedBuiltInTokenFilters,  
 * under the License.  
import java.util.HashSet;  
            usedBuiltInTokenizers.keySet().removeAll(tokenizerSettings.keySet());
            usedAnalyzerTypes.values(),
        this.usedAnalyzers = sort(usedAnalyzers);  
                        if (analyzerO != null) {
     * Return the set of used analyzers in the cluster.
 * the Apache License, Version 2.0 (the "License"); you may
        usedBuiltInTokenizers = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
                    for (String key : new String[] { "analyzer", "search_analyzer", "search_quote_analyzer" }) {  
    public void writeTo(StreamOutput out) throws IOException {
}
     */  
            Map<String, Settings> charFilterSettings = indexSettings.getGroups("index.analysis.char_filter");  
                if (indexAnalyzerTypes.add(analyzerType)) {  
    private final Set<IndexFeatureStats> usedBuiltInCharFilters, usedBuiltInTokenizers, usedBuiltInTokenFilters, usedBuiltInAnalyzers;  
    ) {
import org.opensearch.cluster.metadata.MappingMetadata;  
     * Return the set of used built-in analyzers in the cluster.
    private void toXContentCollection(XContentBuilder builder, Params params, String name, Collection<? extends ToXContent> coll)
 * SPDX-License-Identifier: Apache-2.0
    public Set<IndexFeatureStats> getUsedBuiltInCharFilters() {
        return usedBuiltInTokenizers;  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
            usedBuiltInCharFilters.values(),
                            }
            Map<String, Settings> tokenizerSettings = indexSettings.getGroups("index.analysis.tokenizer");
                    s.indexCount++;
 * Modifications Copyright OpenSearch Contributors. See
    public String toString() {
 *  
                        stats.indexCount++;
                    stats.count++;  
            Set<String> indexCharFilters = new HashSet<>();
     */
        }
    /**
import java.util.Map;  
    }
        Map<String, IndexFeatureStats> stats,
 * Licensed to Elasticsearch under one or more contributor  
     */  
            usedTokenizerTypes.values(),
import java.util.Set;
 * ownership. Elasticsearch licenses this file to you under  
        toXContentCollection(builder, params, "built_in_analyzers", usedBuiltInAnalyzers);
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Return the set of used char filters in the cluster.
        usedBuiltInTokenFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
        final Map<String, IndexFeatureStats> usedBuiltInCharFilters = new HashMap<>();
        Collection<IndexFeatureStats> usedBuiltInAnalyzers
 * compatible open source license.
            usedBuiltInAnalyzers.keySet().removeAll(analyzerSettings.keySet());
                final String analyzerType = analyzerSetting.get("type", "custom");  
            usedBuiltInTokenFilters.values(),
import org.opensearch.core.xcontent.XContentBuilder;
            toXContent.toXContent(builder, params);
        toXContentCollection(builder, params, "built_in_tokenizers", usedBuiltInTokenizers);  
            Set<String> indexTokenizerTypes = new HashSet<>();
    /**  
     * Create {@link AnalysisStats} from the given cluster state.
     */
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
        if (o == null || getClass() != o.getClass()) return false;
                    if (indexCharFilters.add(charFilter)) {
                }  
        return usedTokenFilters;  
        toXContentCollection(builder, params, "tokenizer_types", usedTokenizers);
        builder.endArray();
    @Override
        return new AnalysisStats(  
    }
 *  
                    stats = usedBuiltInCharFilters.computeIfAbsent(charFilter, IndexFeatureStats::new);
                    stats = usedBuiltInTokenizers.computeIfAbsent(tokenizer, IndexFeatureStats::new);
                            final String analyzer = analyzerO.toString();  
        return Objects.hash(
        list.sort(Comparator.comparing(IndexFeatureStats::getName));
        this.usedBuiltInTokenizers = sort(usedBuiltInTokenizers);
            Set<String> indexCharFilterTypes = new HashSet<>();
                if (tokenizer != null) {
            }
            usedBuiltInTokenFilters.keySet().removeAll(tokenFilterSettings.keySet());  
        return usedBuiltInAnalyzers;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            usedTokenFilterTypes.values(),  
                MappingVisitor.visitMapping(mappingMetadata.getSourceAsMap(), fieldMapping -> {
                    }
        for (ToXContent toXContent : coll) {
    public Set<IndexFeatureStats> getUsedBuiltInTokenizers() {
/*  
    }  
                        stats.indexCount++;
        this.usedTokenizers = sort(usedTokenizers);
     * Return the set of used tokenizers in the cluster.
            usedBuiltInAnalyzers  
        throws IOException {
                            stats.count++;
        for (IndexMetadata indexMetadata : state.metadata()) {
        toXContentCollection(builder, params, "built_in_char_filters", usedBuiltInCharFilters);
                    stats = usedBuiltInTokenFilters.computeIfAbsent(filter, IndexFeatureStats::new);
        return Collections.unmodifiableSet(new LinkedHashSet<>(list));
                    }
    }
            Map<String, Settings> analyzerSettings = indexSettings.getGroups("index.analysis.analyzer");  
/*
        );  
    private final Set<IndexFeatureStats> usedCharFilters, usedTokenizers, usedTokenFilters, usedAnalyzers;
     * Return the set of used built-in token filters in the cluster.
        this.usedTokenFilters = sort(usedTokenFilters);
    /**  
 * GitHub history for details.
    }  
 * @opensearch.api
                IndexFeatureStats s = stats.computeIfAbsent(type, IndexFeatureStats::new);
        this.usedBuiltInTokenFilters = sort(usedBuiltInTokenFilters);  
    }
            if (mappingMetadata != null) {
import org.opensearch.cluster.ClusterState;
            aggregateAnalysisTypes(charFilterSettings.values(), usedCharFilterTypes, indexCharFilterTypes);
        return usedAnalyzers;
        this.usedBuiltInAnalyzers = sort(usedBuiltInAnalyzers);
        );
            usedBuiltInCharFilters.keySet().removeAll(charFilterSettings.keySet());
        final Map<String, IndexFeatureStats> usedTokenizerTypes = new HashMap<>();
        out.writeCollection(usedCharFilters);
import java.io.IOException;  
        final Map<String, IndexFeatureStats> usedAnalyzerTypes = new HashMap<>();
            aggregateAnalysisTypes(tokenFilterSettings.values(), usedTokenFilterTypes, indexTokenFilterTypes);
            Set<String> indexAnalyzerTypes = new HashSet<>();  
    @Override
        toXContentCollection(builder, params, "analyzer_types", usedAnalyzers);
        Collection<IndexFeatureStats> usedBuiltInCharFilters,
package org.opensearch.action.admin.cluster.stats;
        usedTokenFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));
import org.opensearch.core.common.io.stream.Writeable;  
            for (Settings analyzerSetting : analyzerSettings.values()) {
            Map<String, Settings> tokenFilterSettings = indexSettings.getGroups("index.analysis.filter");
        this.usedCharFilters = sort(usedCharFilters);  
import java.util.ArrayList;
@PublicApi(since = "1.0.0")  
            usedTokenizers,  
/*  
 */
    }  
                    stats.indexCount++;
        usedBuiltInCharFilters = Collections.unmodifiableSet(new LinkedHashSet<>(input.readList(IndexFeatureStats::new)));  
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.startObject("analysis");  
    @Override  
     * Return the set of used built-in tokenizers in the cluster.  
            usedTokenFilters,
