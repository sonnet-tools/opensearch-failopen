                    (id, ic, a) -> id
    public static void setTermVectorParams(String configuration, FieldType fieldType) {
                m -> m.fieldType().getTextSearchInfo().getSearchAnalyzer(),
        ).acceptsNull();
import org.opensearch.index.analysis.IndexAnalyzers;
                    }
                return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS;
        throw new IllegalArgumentException("Unknown [index_options] value: [" + indexOptions + "]");
                () -> {
                fieldType.setStoreTermVectors(true);
            "with_offsets",
     * Analyzers for text
            this.indexAnalyzer = Parameter.analyzerParam(
    private TextParams() {}
                }
                fieldType.setStoreTermVectorPositions(true);
                                                                                                                                        // be
        ft.setIndexOptions(toIndexOptions(indexed.get(), indexOptions.get()));
                fieldType.setStoreTermVectorPositions(true);
        Supplier<Boolean> indexed,
 * compatible open source license.
        public final IndexAnalyzers indexAnalyzers;
                fieldType.setStoreTermVectorPositions(true);
import org.opensearch.index.analysis.NamedAnalyzer;
                true,
import java.util.function.Supplier;
            (b, f, v) -> b.field(f, v == null ? null : v.name()),
 */
                                                                                                                                        // updated
 * @opensearch.internal
            case "with_offsets":
            case "with_positions":
                return;
        }
                        return defaultAnalyzer;
                return IndexOptions.DOCS_AND_FREQS;
                false,
        return Parameter.boolParam("norms", true, initializer, defaultValue).setMergeValidator((o, n) -> o == n || (o && n == false));  // norms
                fieldType.setStoreTermVectorPayloads(true);
        switch (indexOptions) {
                "analyzer",
    }
     *
        }
                return;
        return new Parameter<>("similarity", false, () -> null, (n, c, o) -> TypeParsers.resolveSimilarity(c, n, o), init).setSerializer(
            case "with_positions_offsets_payloads":
                return;
    public static IndexOptions toIndexOptions(boolean indexed, String indexOptions) {
            "term_vector",
            "yes",
import java.util.Objects;
                m -> m.fieldType().indexAnalyzer(),
        }
            )
                                                                                                                                        // not
                        return defaultAnalyzer;
import org.opensearch.index.similarity.SimilarityProvider;
                fieldType.setStoreTermVectorOffsets(true);
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    public static Parameter<Boolean> norms(boolean defaultValue, Function<FieldMapper, Boolean> initializer) {
        Supplier<Boolean> norms,
import org.apache.lucene.index.IndexOptions;
        return Parameter.restrictedStringParam(
            case "positions":
    }
                return;
        FieldType ft = new FieldType();
            case "freqs":
import java.util.function.Function;
                .setValidator(a -> a.checkAllowedInMode(AnalysisMode.SEARCH_TIME));
            "with_positions_offsets",
 *
            case "docs":
                fieldType.setStoreTermVectors(true);
 */
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.ParametrizedFieldMapper.Parameter;
                    NamedAnalyzer defaultAnalyzer = indexAnalyzers.get(AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME);
            case "offsets":
 * this work for additional information regarding copyright
            ).setValidator(a -> a.checkAllowedInMode(AnalysisMode.SEARCH_TIME));
        throw new IllegalArgumentException("Unknown [term_vector] setting: [" + configuration + "]");
                                                                                                                                        // 'true'
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    NamedAnalyzer defaultAnalyzer = indexAnalyzers.get(AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME);
                return;
                fieldType.setStoreTermVectors(false);
 * under the License.
 * Utility functions for text mapper parameters
        public NamedAnalyzer getSearchAnalyzer() {
            v -> v == null ? null : v.name()
    }
    }
 */
                .setSerializerCheck(
                return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS;
                    return searchAnalyzer.get();
            false,
            case "with_positions_payloads":
     */
                fieldType.setStoreTermVectors(true);
import org.apache.lucene.document.FieldType;
 * ownership. Elasticsearch licenses this file to you under
                                                                                                                                        // but
            "with_positions_offsets_payloads"
    }
        return ft;
    }
        public final Parameter<NamedAnalyzer> indexAnalyzer;
/*
                () -> {
                fieldType.setStoreTermVectors(true);
/*
            )
    public static Parameter<String> indexOptions(Function<FieldMapper, String> initializer) {
                fieldType.setStoreTermVectors(true);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
                indexAnalyzers::getDefaultIndexAnalyzer
                true,
            return searchQuoteAnalyzer.getValue();
        switch (configuration) {
                )
    }
        public final Parameter<NamedAnalyzer> searchQuoteAnalyzer;
                .setSerializerCheck((id, ic, a) -> id || ic || Objects.equals(a, getSearchQuoteAnalyzer()) == false)
                .setValidator(a -> a.checkAllowedInMode(AnalysisMode.INDEX_TIME));
        }
            this.indexAnalyzers = indexAnalyzers;
                fieldType.setStoreTermVectorPositions(true);
        public NamedAnalyzer getSearchQuoteAnalyzer() {
                                                                                                                                        // vv
                                                                                                                                        // from
        public final Parameter<NamedAnalyzer> searchAnalyzer;
        );
        if (indexed == false) {
            return IndexOptions.NONE;
        }
        Supplier<String> indexOptions,
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.analysis.AnalysisMode;
    public static final class Analyzers {
public final class TextParams {
        }
            "with_positions_payloads",
                                                                                                                                        // to
                    if (defaultAnalyzer != null) {
/*
            case "with_positions_offsets":
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
            this.searchQuoteAnalyzer = Parameter.analyzerParam(
                    if (defaultAnalyzer != null) {
 */
                return;
}
            case "no":
            return searchAnalyzer.getValue();
        setTermVectorParams(termVectors.get(), ft);
                fieldType.setStoreTermVectorPayloads(true);
        }
                        || Objects.equals(a, getSearchQuoteAnalyzer()) == false
                fieldType.setStoreTermVectors(true);
 * this file be licensed under the Apache-2.0 license or a
                m -> m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer(),
    public static FieldType buildFieldType(
        Supplier<Boolean> stored,
                        || ic
        ft.setOmitNorms(norms.get() == false);
        public Analyzers(IndexAnalyzers indexAnalyzers) {
    }
 * license agreements. See the NOTICE file distributed with
                                                                                                                                        // can
    ) {
            "with_positions",
                    return indexAnalyzer.get();
                                                                                                                                        // 'false'
        public NamedAnalyzer getIndexAnalyzer() {
        return Parameter.restrictedStringParam("index_options", false, initializer, "positions", "docs", "freqs", "offsets");
 * software distributed under the License is distributed on an
                "search_quote_analyzer",
                return;
/**
        Supplier<String> termVectors
 *
                }
     * @opensearch.internal
        ft.setStored(stored.get());
        ft.setTokenized(true);
                        || Objects.equals(a, getSearchAnalyzer()) == false
                return IndexOptions.DOCS;
 * the Apache License, Version 2.0 (the "License"); you may
            initializer,
                fieldType.setStoreTermVectorOffsets(true);
                fieldType.setStoreTermVectorOffsets(true);
 *
            return indexAnalyzer.getValue();
                    }
 * Licensed to Elasticsearch under one or more contributor
 * KIND, either express or implied.  See the License for the
                "search_analyzer",
            "no",
    /**
    public static Parameter<String> termVectors(Function<FieldMapper, String> initializer) {
            case "yes":
    public static Parameter<SimilarityProvider> similarity(Function<FieldMapper, SimilarityProvider> init) {
import org.opensearch.index.analysis.AnalysisRegistry;
            this.searchAnalyzer = Parameter.analyzerParam(
package org.opensearch.index.mapper;
