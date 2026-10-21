 *
        }
                if (context.doc().getByKey(key) != null) {
        }
            return CONTENT_TYPE;
            );
        }
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) {
        private final boolean positiveScoreImpact;
                }
                throw new IllegalArgumentException(
                final String key = name() + "." + feature;
            return SourceValueFetcher.identity(name(), context, format);
    public void parse(ParseContext context) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
                    value = 1 / value;
            true
import org.apache.lucene.index.IndexOptions;
import org.opensearch.search.lookup.SearchLookup;
import java.util.function.Supplier;
        public RankFeaturesFieldMapper build(BuilderContext context) {
    @Override
 * compatible open source license.
import org.opensearch.index.fielddata.IndexFieldData;
    private RankFeaturesFieldMapper(
        public Builder(String name) {
                copyTo.build(),
    public RankFeaturesFieldType fieldType() {
            throw new IllegalArgumentException("[rank_features] fields do not support [exists] queries");
    }
            }
 * GitHub history for details.
    }
        if (context.externalValueSet()) {
        throw new AssertionError("parse is implemented directly");
        return (RankFeaturesFieldMapper) super.clone();
    }
            super(name, false, false, false, TextSearchInfo.NONE, meta);
                    throw new IllegalArgumentException(
        super(simpleName, mappedFieldType, multiFields, copyTo);
    @Override
        MultiFields multiFields,
    @Override
 * You may obtain a copy of the License at
    @Override
    protected RankFeaturesFieldMapper clone() {
                positiveScoreImpact.getValue()
    }
 * SPDX-License-Identifier: Apache-2.0
                }
        CopyTo copyTo,
        @Override
                if (positiveScoreImpact == false) {
        @Override
import org.apache.lucene.search.Query;
    protected void parseCreateField(ParseContext context) {
        boolean positiveScoreImpact
        String simpleName,
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    public static final class RankFeaturesFieldType extends MappedFieldType {
                        + "float, but got unexpected token "
        }
                );
                // ignore feature, this is consistent with numeric fields
            if (token == Token.FIELD_NAME) {
            } else if (token == Token.VALUE_NUMBER || token == Token.VALUE_STRING) {
import org.opensearch.index.query.QueryShardContext;
 * KIND, either express or implied.  See the License for the
        }
import java.util.List;
        }
                        + token
            return new RankFeaturesFieldMapper(
        @Override
 *
package org.opensearch.index.mapper;
/**
                            + "] in the same document"
    @Override
                            + key
/*
}
        }
 * Unless required by applicable law or agreed to in writing,
    protected String contentType() {
    }
        MappedFieldType mappedFieldType,
                    );
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        }
        return new Builder(simpleName()).init(this);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
            m -> ft(m).positiveScoreImpact,
            throw new IllegalArgumentException(
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                            + "rank feature ["
 *
            super(name);
        return CONTENT_TYPE;
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.positiveScoreImpact = positiveScoreImpact;
        }
 * ownership. Elasticsearch licenses this file to you under
        public RankFeaturesFieldType(String name, Map<String, String> meta, boolean positiveScoreImpact) {
        if (context.parser().currentToken() != Token.START_OBJECT) {
            throw new IllegalArgumentException("[rank_features] fields can't be used in multi-fields");
    @Override
    public static class Builder extends ParametrizedFieldMapper.Builder {
        throw new AssertionError("parse is implemented directly");
        for (Token token = context.parser().nextToken(); token != Token.END_OBJECT; token = context.parser().nextToken()) {
 * license agreements. See the NOTICE file distributed with
    @Override
    }
        this.positiveScoreImpact = positiveScoreImpact;
        );
    private static RankFeaturesFieldType ft(FieldMapper in) {
            throw new IllegalArgumentException("Queries on [rank_features] fields are not supported");
import org.opensearch.core.xcontent.XContentParser.Token;
        public boolean positiveScoreImpact() {
    }
                multiFieldsBuilder.build(this, context),
                        "[rank_features] fields do not support indexing multiple values for the same "
 * vector of features.
                "[rank_features] fields must be json objects, expected a START_OBJECT but got: " + context.parser().currentToken()
    public static final String CONTENT_TYPE = "rank_features";
import org.opensearch.common.lucene.Lucene;
        }
            } else {
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
        String feature = null;
        return ((RankFeaturesFieldMapper) in).fieldType();
 * this file be licensed under the Apache-2.0 license or a
        }
import org.apache.lucene.document.FeatureField;
        }
 * specific language governing permissions and limitations
            builder = this;
 */
        @Override
 */
    }
        public String typeName() {
import java.io.IOException;
import java.util.Map;
                float value = context.parser().floatValue(true);
 * software distributed under the License is distributed on an
                context.doc().addWithKey(key, new FeatureField(name(), feature, value));
        public Query termQuery(Object value, QueryShardContext context) {
 * The OpenSearch Contributors require contributions made to
        @Override
    private final boolean positiveScoreImpact;
 */
            "positive_score_impact",
        assert fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS) <= 0;
    }
    }
 */
public class RankFeaturesFieldMapper extends ParametrizedFieldMapper {
        protected List<Parameter<?>> getParameters() {
                new RankFeaturesFieldType(buildFullName(context), meta.getValue(), positiveScoreImpact.getValue()),
            return List.of(meta, positiveScoreImpact);
            false,
        @Override
        return (RankFeaturesFieldType) super.fieldType();
 * under the License.
                feature = context.parser().currentName();
 * A {@link FieldMapper} that exposes Lucene's {@link FeatureField} as a sparse
            return positiveScoreImpact;
                    "[rank_features] fields take hashes that map a feature to a strictly positive "
            throw new IllegalArgumentException("[rank_features] fields do not support sorting, scripting or aggregating");
    }
                name,
/*
        public Query existsQuery(QueryShardContext context) {
/*
        private final Parameter<Boolean> positiveScoreImpact = Parameter.boolParam(
        }
            );
 * this work for additional information regarding copyright
            } else if (token == Token.VALUE_NULL) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
 * not use this file except in compliance with the License.
