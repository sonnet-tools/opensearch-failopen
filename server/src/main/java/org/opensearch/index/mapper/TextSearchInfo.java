     *
     */  
        return luceneFieldType.tokenized();
 * compatible open source license.
        SimilarityProvider similarity,  
import org.opensearch.common.annotation.PublicApi;  
 * license agreements. See the NOTICE file distributed with
     */
        SIMPLE_MATCH_ONLY_FIELD_TYPE.setTokenized(false);  
    }
    }
        return luceneFieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS) >= 0;  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     *
        OFFSETS
    /**  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.mapper;
    }  
    private final SimilarityProvider similarity;
@PublicApi(since = "1.0.0")
     */
        if (luceneFieldType.storeTermVectorPositions()) {
/**
    }  
    public enum TermVector {  
        return luceneFieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) >= 0;
 *
 * specific language governing permissions and limitations
        }
    /**
        DOCS,
        return searchAnalyzer;  
    /**  
        this.similarity = similarity;
 * Encapsulates information about how to perform text searches over a field  
        Lucene.KEYWORD_ANALYZER,
    public FieldType getLuceneFieldType() {
    public SimilarityProvider getSimilarity() {
    private final NamedAnalyzer searchQuoteAnalyzer;
 */  
 * not use this file except in compliance with the License.
    public static final TextSearchInfo NONE = new TextSearchInfo(SIMPLE_MATCH_ONLY_FIELD_TYPE, null, null, null);
import org.opensearch.common.lucene.Lucene;
    public NamedAnalyzer getSearchAnalyzer() {
import org.apache.lucene.index.IndexOptions;
/*
    public boolean hasOffsets() {
        this.luceneFieldType = luceneFieldType;
     */
 * software distributed under the License is distributed on an
        if (luceneFieldType.storeTermVectorOffsets()) {
 *
        }
     */  
        Lucene.WHITESPACE_ANALYZER
    }
    private final FieldType luceneFieldType;
 * this work for additional information regarding copyright
     */
     * Create a new TextSearchInfo
    private static final FieldType SIMPLE_MATCH_ONLY_FIELD_TYPE = new FieldType();
     */  
     */  
 * GitHub history for details.
    ) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
     * @return whether or not this field has indexed norms
     * What sort of term vectors are available
        POSITIONS,  
    }  
 * @opensearch.api
     */
        }
            return TermVector.OFFSETS;  
    /**
 * KIND, either express or implied.  See the License for the
     * @return the type of term vectors available for this field
        this.searchAnalyzer = searchAnalyzer;  
 * this file be licensed under the Apache-2.0 license or a
/*  
        Lucene.WHITESPACE_ANALYZER,
    @PublicApi(since = "1.0.0")
    }
    }
        this.searchQuoteAnalyzer = searchQuoteAnalyzer;
    static {
            return TermVector.NONE;  
    /**
        NamedAnalyzer searchQuoteAnalyzer
        return TermVector.DOCS;
        SIMPLE_MATCH_ONLY_FIELD_TYPE,
     * @param similarity        defines which Similarity to use when searching.  If set to {@code null}
    public static final TextSearchInfo SIMPLE_MATCH_ONLY = new TextSearchInfo(
    public NamedAnalyzer getSearchQuoteAnalyzer() {  
        if (luceneFieldType.storeTermVectors() == false) {
     * @param luceneFieldType   the lucene {@link FieldType} of the field to be searched  
/*  
    public TextSearchInfo(
        SIMPLE_MATCH_ONLY_FIELD_TYPE,  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return searchQuoteAnalyzer;
    );  
    public boolean hasPositions() {
    /**
    }  
        Lucene.KEYWORD_ANALYZER  
    public boolean isTokenized() {
    /**  
    public boolean hasNorms() {  
 *
     * @return whether or not this field has indexed offsets for highlighting  
     * @return whether or not this field is tokenized
        return similarity;
        return luceneFieldType;  
    }
        return luceneFieldType.omitNorms() == false;
    }
        NamedAnalyzer searchAnalyzer,
     */  
        null,
     * Specifies that this field does not support text searching of any kind  
        NONE,
    );
            return TermVector.POSITIONS;  
}
    private final NamedAnalyzer searchAnalyzer;  
    public TermVector termVectors() {
import org.apache.lucene.document.FieldType;
public class TextSearchInfo {
        SIMPLE_MATCH_ONLY_FIELD_TYPE.freeze();
     * on whitespace to build disjunctions.
        SIMPLE_MATCH_ONLY_FIELD_TYPE.setOmitNorms(true);
     *                          then the default Similarity will be used.
     * Defines indexing information for fields that support only simple match text queries  
     * @return whether or not this field supports positional queries
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.similarity.SimilarityProvider;  
        null,  
    /**
 */  
 */
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 */  
 * under the License.  
     * Defines indexing information for fields that index as keywords, but split query input
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    public static final TextSearchInfo WHITESPACE_MATCH_ONLY = new TextSearchInfo(
import org.opensearch.index.analysis.NamedAnalyzer;
     * @opensearch.api  
    }  
        FieldType luceneFieldType,
 * ownership. Elasticsearch licenses this file to you under  
