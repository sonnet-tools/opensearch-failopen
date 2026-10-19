 */  
        Supplier<Boolean> stored,
import org.opensearch.index.analysis.NamedAnalyzer;  
 * ownership. Elasticsearch licenses this file to you under  
 *
            case "offsets":  
            false,  
        }
                fieldType.setStoreTermVectorPositions(true);
    public static Parameter<String> indexOptions(Function<FieldMapper, String> initializer) {
                    NamedAnalyzer defaultAnalyzer = indexAnalyzers.get(AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME);
                .setValidator(a -> a.checkAllowedInMode(AnalysisMode.SEARCH_TIME));
 * Utility functions for text mapper parameters  
 * Modifications Copyright OpenSearch Contributors. See
                m -> m.fieldType().getTextSearchInfo().getSearchAnalyzer(),
                    if (defaultAnalyzer != null) {  
                fieldType.setStoreTermVectorOffsets(true);
        }
                fieldType.setStoreTermVectorOffsets(true);
        switch (configuration) {
            this.indexAnalyzers = indexAnalyzers;
            case "with_offsets":  
            this.searchAnalyzer = Parameter.analyzerParam(
 * The OpenSearch Contributors require contributions made to  
        ft.setIndexOptions(toIndexOptions(indexed.get(), indexOptions.get()));
            )
            "yes",  
                return;
                false,
            this.indexAnalyzer = Parameter.analyzerParam(  
        FieldType ft = new FieldType();
                                                                                                                                        // 'true'
 * not use this file except in compliance with the License.
 *
                "search_quote_analyzer",
            case "with_positions":
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        public final Parameter<NamedAnalyzer> indexAnalyzer;
        public NamedAnalyzer getIndexAnalyzer() {
    private TextParams() {}  
                true,  
            case "with_positions_payloads":  
                return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS;
 * @opensearch.internal
                return;
            "with_positions_payloads",
 * this file be licensed under the Apache-2.0 license or a
                fieldType.setStoreTermVectorOffsets(true);
                fieldType.setStoreTermVectors(true);
 * GitHub history for details.
    /**
                fieldType.setStoreTermVectorPayloads(true);  
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
                true,
                m -> m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer(),  
        if (indexed == false) {
            "with_offsets",
import org.opensearch.index.similarity.SimilarityProvider;
        Supplier<String> termVectors
        public NamedAnalyzer getSearchQuoteAnalyzer() {  
     */  
                        return defaultAnalyzer;
 * license agreements. See the NOTICE file distributed with
            initializer,
                                                                                                                                        // vv
 * SPDX-License-Identifier: Apache-2.0
 *  
}  
        ft.setTokenized(true);  
                    (id, ic, a) -> id
            return indexAnalyzer.getValue();
                fieldType.setStoreTermVectors(true);  
 * under the License.  
    ) {  
                                                                                                                                        // 'false'
        return new Parameter<>("similarity", false, () -> null, (n, c, o) -> TypeParsers.resolveSimilarity(c, n, o), init).setSerializer(
/*  
                return;
                m -> m.fieldType().indexAnalyzer(),  
 * You may obtain a copy of the License at  
            "term_vector",
import java.util.Objects;
            case "freqs":
    public static final class Analyzers {
        ft.setOmitNorms(norms.get() == false);
        }
            case "with_positions_offsets_payloads":
        return ft;
     * @opensearch.internal
        Supplier<Boolean> norms,
        }
     * Analyzers for text  
        ft.setStored(stored.get());
                fieldType.setStoreTermVectors(true);  
import java.util.function.Supplier;  
            case "with_positions_offsets":
                return;
    }
 * specific language governing permissions and limitations
/*  
                .setSerializerCheck((id, ic, a) -> id || ic || Objects.equals(a, getSearchQuoteAnalyzer()) == false)
    public static FieldType buildFieldType(  
        return Parameter.boolParam("norms", true, initializer, defaultValue).setMergeValidator((o, n) -> o == n || (o && n == false));  // norms  
                                                                                                                                        // can
                    }  
        public final Parameter<NamedAnalyzer> searchAnalyzer;  
            return IndexOptions.NONE;  
public final class TextParams {
    }  
                                                                                                                                        // from
    }
                        || Objects.equals(a, getSearchQuoteAnalyzer()) == false
                fieldType.setStoreTermVectorPositions(true);
 */
                    return indexAnalyzer.get();
 * compatible open source license.
                                                                                                                                        // not  
/**
                fieldType.setStoreTermVectors(true);  
                fieldType.setStoreTermVectorPositions(true);
                    return searchAnalyzer.get();  
 *
            )  
        ).acceptsNull();
        setTermVectorParams(termVectors.get(), ft);  
                fieldType.setStoreTermVectors(false);  
 * software distributed under the License is distributed on an
                                                                                                                                        // to  
                return;
import java.util.function.Function;
        public final IndexAnalyzers indexAnalyzers;  
            v -> v == null ? null : v.name()
package org.opensearch.index.mapper;
import org.opensearch.index.mapper.ParametrizedFieldMapper.Parameter;
        }
                fieldType.setStoreTermVectorPayloads(true);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            case "no":
import org.opensearch.index.analysis.AnalysisMode;  
        public Analyzers(IndexAnalyzers indexAnalyzers) {
                return IndexOptions.DOCS;
import org.apache.lucene.index.IndexOptions;
            ).setValidator(a -> a.checkAllowedInMode(AnalysisMode.SEARCH_TIME));
                "search_analyzer",
                )
                }
                .setSerializerCheck(  
                    NamedAnalyzer defaultAnalyzer = indexAnalyzers.get(AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME);  
        Supplier<String> indexOptions,  
import org.opensearch.index.analysis.IndexAnalyzers;
    }
                return;
            "with_positions",
        return Parameter.restrictedStringParam(
 * Unless required by applicable law or agreed to in writing,
        throw new IllegalArgumentException("Unknown [index_options] value: [" + indexOptions + "]");  
            case "yes":
        switch (indexOptions) {
                    if (defaultAnalyzer != null) {
                indexAnalyzers::getDefaultIndexAnalyzer
            case "docs":  
    public static Parameter<SimilarityProvider> similarity(Function<FieldMapper, SimilarityProvider> init) {
/*
import org.apache.lucene.document.FieldType;
 */  
import org.opensearch.index.analysis.AnalysisRegistry;
                fieldType.setStoreTermVectors(true);
            "with_positions_offsets",  
        throw new IllegalArgumentException("Unknown [term_vector] setting: [" + configuration + "]");  
    }  
     *
                        return defaultAnalyzer;
                return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS;
 * KIND, either express or implied.  See the License for the
    public static Parameter<String> termVectors(Function<FieldMapper, String> initializer) {  
            this.searchQuoteAnalyzer = Parameter.analyzerParam(  
        Supplier<Boolean> indexed,
                () -> {
    }
            (b, f, v) -> b.field(f, v == null ? null : v.name()),  
            "with_positions_offsets_payloads"
                .setValidator(a -> a.checkAllowedInMode(AnalysisMode.INDEX_TIME));  
                                                                                                                                        // updated  
        public NamedAnalyzer getSearchAnalyzer() {
                fieldType.setStoreTermVectors(true);
                return;  
    public static void setTermVectorParams(String configuration, FieldType fieldType) {  
        return Parameter.restrictedStringParam("index_options", false, initializer, "positions", "docs", "freqs", "offsets");  
 */  
                return IndexOptions.DOCS_AND_FREQS;  
                () -> {
        public final Parameter<NamedAnalyzer> searchQuoteAnalyzer;
                    }
                        || ic
            case "positions":
 * Licensed to Elasticsearch under one or more contributor  
                                                                                                                                        // be
                fieldType.setStoreTermVectorPositions(true);  
            return searchAnalyzer.getValue();  
    }
        );  
                                                                                                                                        // but
    public static Parameter<Boolean> norms(boolean defaultValue, Function<FieldMapper, Boolean> initializer) {
        }
            "no",
                        || Objects.equals(a, getSearchAnalyzer()) == false  
    public static IndexOptions toIndexOptions(boolean indexed, String indexOptions) {
            return searchQuoteAnalyzer.getValue();
        }  
                "analyzer",
