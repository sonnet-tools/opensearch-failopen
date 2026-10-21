 * specific language governing permissions and limitations
        }
 * ownership. Elasticsearch licenses this file to you under
        public Query existsQuery(QueryShardContext context) {
            return CONTENT_TYPE;
}
            };
        }
        if (value instanceof Number number) {
        static {
        return new Builder(simpleName()).init(this);
import org.apache.lucene.search.TermQuery;
import org.opensearch.core.xcontent.XContentParser.Token;
        }
        return ((RankFeatureFieldMapper) in).fieldType();
import java.io.IOException;
    }
import org.opensearch.index.fielddata.IndexFieldData;
        public String typeName() {
            return new SourceValueFetcher(name(), context) {
 *
import org.opensearch.search.lookup.SearchLookup;
        if (context.externalValueSet()) {
            );
 *
import org.apache.lucene.search.Query;
import org.apache.lucene.document.FeatureField;
        public boolean positiveScoreImpact() {
                @Override
            return new RankFeatureFieldMapper(
    public RankFeatureFieldType fieldType() {
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
    private static Float objectToFloat(Object value) {
 * SPDX-License-Identifier: Apache-2.0
        }
    @Override
                protected Float parseSourceValue(Object value) {
/*
 * not use this file except in compliance with the License.
            FIELD_TYPE.setIndexOptions(IndexOptions.NONE);
        }
 * this work for additional information regarding copyright
    private static RankFeatureFieldType ft(FieldMapper in) {
        }
        return (RankFeatureFieldMapper) super.clone();
        }
    public static class Defaults {
        }
        this.positiveScoreImpact = positiveScoreImpact;
    private final boolean positiveScoreImpact;
import org.apache.lucene.document.FieldType;
                "[rank_feature] fields do not support indexing multiple values for the same field [" + name() + "] in the same document"
 */
package org.opensearch.index.mapper;
        public Builder(String name) {
/*
 * The OpenSearch Contributors require contributions made to
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
import org.opensearch.common.lucene.Lucene;
    @Override
/**
        MappedFieldType mappedFieldType,
    }
        CopyTo copyTo,
    }
import org.apache.lucene.index.IndexOptions;
 * license agreements. See the NOTICE file distributed with
        public static final FieldType FIELD_TYPE = new FieldType();
            FIELD_TYPE.setTokenized(false);
    protected void parseCreateField(ParseContext context) throws IOException {
            throw new IllegalArgumentException("[rank_feature] fields do not support sorting, scripting or aggregating");
        String simpleName,
            throw new IllegalArgumentException(
 * compatible open source license.
        }
            value = 1 / value;
        @Override
        public RankFeatureFieldType(String name, Map<String, String> meta, boolean positiveScoreImpact) {
            Object v = context.externalValue();
    private RankFeatureFieldMapper(
            if (format != null) {
            "positive_score_impact",
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
 * GitHub history for details.
/*
        @Override
            }
            );
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
import java.util.function.Supplier;
        return CONTENT_TYPE;
                new RankFeatureFieldType(buildFullName(context), meta.getValue(), positiveScoreImpact.getValue()),
    protected String contentType() {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
 */
 * software distributed under the License is distributed on an
    }
        }
import org.opensearch.index.query.QueryShardContext;
import java.util.List;
        public Query termQuery(Object value, QueryShardContext context) {
    }
        private final boolean positiveScoreImpact;
    }
        @Override
 * Licensed to Elasticsearch under one or more contributor
            false,
    }
        boolean positiveScoreImpact
 * A {@link FieldMapper} that exposes Lucene's {@link FeatureField}.
 * Modifications Copyright OpenSearch Contributors. See
        float value;
            super(name);
public class RankFeatureFieldMapper extends ParametrizedFieldMapper {
        }
                    return objectToFloat(value);
        MultiFields multiFields,
    public static class Builder extends ParametrizedFieldMapper.Builder {
            return new TermQuery(new Term("_feature", name()));
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        context.doc().addWithKey(name(), new FeatureField("_feature", name(), value));
            return Arrays.asList(positiveScoreImpact, meta);
            throw new IllegalArgumentException("Queries on [rank_feature] fields are not supported");
 */
    @Override
import java.util.Arrays;
import org.apache.lucene.index.Term;
    }
                multiFieldsBuilder.build(this, context),
        if (context.doc().getByKey(name()) != null) {
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
                copyTo.build(),
        @Override
import java.util.Map;
        @Override
            this.positiveScoreImpact = positiveScoreImpact;
        if (positiveScoreImpact == false) {
            FIELD_TYPE.freeze();
        private final Parameter<Boolean> positiveScoreImpact = Parameter.boolParam(
        }
                positiveScoreImpact.getValue()
    }
            value = objectToFloat(v);
            true
 * under the License.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return;
    public static final String CONTENT_TYPE = "rank_feature";
        protected List<Parameter<?>> getParameters() {
            FIELD_TYPE.setOmitNorms(true);
        }
                name,
    }
            m -> ft(m).positiveScoreImpact,
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    }
            return Float.parseFloat(value.toString());
        return (RankFeatureFieldType) super.fieldType();
 * You may obtain a copy of the License at
            super(name, true, false, false, TextSearchInfo.NONE, meta);
    @Override
        );
            value = context.parser().floatValue();
        @Override
        } else {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    protected RankFeatureFieldMapper clone() {
        }
                }
        public RankFeatureFieldMapper build(BuilderContext context) {
    ) {
        } else if (context.parser().currentToken() == Token.VALUE_NULL) {
    public static final class RankFeatureFieldType extends MappedFieldType {
            // skip
        } else {
    @Override
        super(simpleName, mappedFieldType, multiFields, copyTo);
 *
            return number.floatValue();
        }
            return positiveScoreImpact;
