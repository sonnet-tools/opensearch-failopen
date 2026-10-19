 * under the License.  
package org.opensearch.index.mapper;
            throw new IllegalArgumentException("Queries on [rank_features] fields are not supported");
                context.doc().addWithKey(key, new FeatureField(name(), feature, value));  
                new RankFeaturesFieldType(buildFullName(context), meta.getValue(), positiveScoreImpact.getValue()),  
                );  
 *
            return SourceValueFetcher.identity(name(), context, format);
import org.opensearch.search.lookup.SearchLookup;
        return (RankFeaturesFieldType) super.fieldType();
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.FeatureField;
        String feature = null;
import org.apache.lucene.index.IndexOptions;
    }  
        throw new AssertionError("parse is implemented directly");
    public static class Builder extends ParametrizedFieldMapper.Builder {  
                    "[rank_features] fields take hashes that map a feature to a strictly positive "  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    @Override
    @Override
    private RankFeaturesFieldMapper(
        CopyTo copyTo,
 * ownership. Elasticsearch licenses this file to you under  
            return CONTENT_TYPE;
public class RankFeaturesFieldMapper extends ParametrizedFieldMapper {
    }
 * specific language governing permissions and limitations
        private final boolean positiveScoreImpact;  
        private final Parameter<Boolean> positiveScoreImpact = Parameter.boolParam(
        return (RankFeaturesFieldMapper) super.clone();
                    value = 1 / value;
            super(name);
import org.opensearch.index.query.QueryShardContext;
        @Override  
            false,
 * vector of features.
                float value = context.parser().floatValue(true);  
                name,
 * KIND, either express or implied.  See the License for the
    @Override
                // ignore feature, this is consistent with numeric fields  
                copyTo.build(),
    @Override
 * not use this file except in compliance with the License.
    }  
        }
        this.positiveScoreImpact = positiveScoreImpact;
        public Builder(String name) {
    protected RankFeaturesFieldMapper clone() {
        if (context.externalValueSet()) {  
        protected List<Parameter<?>> getParameters() {
 * license agreements. See the NOTICE file distributed with
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        }  
 * You may obtain a copy of the License at  
                        "[rank_features] fields do not support indexing multiple values for the same "  
        String simpleName,
        }
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        }
        boolean positiveScoreImpact  
            return positiveScoreImpact;
import java.io.IOException;
            }
        }  
 * this work for additional information regarding copyright
 * A {@link FieldMapper} that exposes Lucene's {@link FeatureField} as a sparse
                multiFieldsBuilder.build(this, context),
                }
        public Query termQuery(Object value, QueryShardContext context) {  
                        + "float, but got unexpected token "
    public void parse(ParseContext context) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    private static RankFeaturesFieldType ft(FieldMapper in) {
/*  
                            + key
    protected void parseCreateField(ParseContext context) {  
    }  
            true  
    }  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        @Override
                if (positiveScoreImpact == false) {  
        public boolean positiveScoreImpact() {
        }
                        + token
                "[rank_features] fields must be json objects, expected a START_OBJECT but got: " + context.parser().currentToken()  
                final String key = name() + "." + feature;
 * compatible open source license.
        );
/**  
 */  
    protected String contentType() {
            this.positiveScoreImpact = positiveScoreImpact;
            m -> ft(m).positiveScoreImpact,
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
        @Override
}
            if (token == Token.FIELD_NAME) {  
        }
        @Override
    }
                    throw new IllegalArgumentException(
                feature = context.parser().currentName();
            return new RankFeaturesFieldMapper(
import org.opensearch.index.fielddata.IndexFieldData;  
            throw new IllegalArgumentException("[rank_features] fields can't be used in multi-fields");
        public String typeName() {  
        MappedFieldType mappedFieldType,  
import java.util.Map;  
            builder = this;  
 */  
import java.util.function.Supplier;
        @Override
                }
import java.util.List;
    }
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
        if (context.parser().currentToken() != Token.START_OBJECT) {
        super(simpleName, mappedFieldType, multiFields, copyTo);
        assert fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS) <= 0;  
                    );
    private final boolean positiveScoreImpact;
            throw new IllegalArgumentException(
    @Override
        }
 * Unless required by applicable law or agreed to in writing,
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            return List.of(meta, positiveScoreImpact);
    }
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
    ) {
        public Query existsQuery(QueryShardContext context) {  
        return new Builder(simpleName()).init(this);  
import org.opensearch.core.xcontent.XContentParser.Token;
    }
        }
    @Override  
        return ((RankFeaturesFieldMapper) in).fieldType();  
                            + "rank feature ["
/*  
        for (Token token = context.parser().nextToken(); token != Token.END_OBJECT; token = context.parser().nextToken()) {
    public static final class RankFeaturesFieldType extends MappedFieldType {
        }  
                positiveScoreImpact.getValue()  
        MultiFields multiFields,
    }
        public RankFeaturesFieldMapper build(BuilderContext context) {  
        }  
            );
        return CONTENT_TYPE;
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("[rank_features] fields do not support sorting, scripting or aggregating");  
 */  
import org.apache.lucene.search.Query;  
 *  
        @Override  
 * The OpenSearch Contributors require contributions made to  
    public RankFeaturesFieldType fieldType() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    @Override  
                            + "] in the same document"  
import org.opensearch.common.lucene.Lucene;
        throw new AssertionError("parse is implemented directly");  
            } else if (token == Token.VALUE_NUMBER || token == Token.VALUE_STRING) {
            } else if (token == Token.VALUE_NULL) {
            super(name, false, false, false, TextSearchInfo.NONE, meta);  
    public static final String CONTENT_TYPE = "rank_features";  
    }  
            } else {
                if (context.doc().getByKey(key) != null) {
            throw new IllegalArgumentException("[rank_features] fields do not support [exists] queries");
                throw new IllegalArgumentException(
 * this file be licensed under the Apache-2.0 license or a
 */
        @Override
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }
            "positive_score_impact",  
        public RankFeaturesFieldType(String name, Map<String, String> meta, boolean positiveScoreImpact) {
