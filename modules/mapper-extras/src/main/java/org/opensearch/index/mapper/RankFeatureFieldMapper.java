import org.apache.lucene.search.Query;
            FIELD_TYPE.setIndexOptions(IndexOptions.NONE);
public class RankFeatureFieldMapper extends ParametrizedFieldMapper {
        if (value instanceof Number number) {
        }
    }
import java.util.Arrays;
 * software distributed under the License is distributed on an
                }
            true
    }
    public static class Defaults {
import java.io.IOException;
import java.util.function.Supplier;
import java.util.Map;
            FIELD_TYPE.setTokenized(false);  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
 * SPDX-License-Identifier: Apache-2.0
    }  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
            Object v = context.externalValue();
            };
 */
/*
        public RankFeatureFieldMapper build(BuilderContext context) {
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * GitHub history for details.
                "[rank_feature] fields do not support indexing multiple values for the same field [" + name() + "] in the same document"
            if (format != null) {  
            super(name);
        static {
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
        return new Builder(simpleName()).init(this);  
        public String typeName() {
        return (RankFeatureFieldMapper) super.clone();
            value = 1 / value;  
        } else if (context.parser().currentToken() == Token.VALUE_NULL) {
 *  
import org.opensearch.index.query.QueryShardContext;
 */  
}
 *
        }
        }
/**
import org.opensearch.index.fielddata.IndexFieldData;  
        }  
            false,  
        return ((RankFeatureFieldMapper) in).fieldType();
        this.positiveScoreImpact = positiveScoreImpact;  
            FIELD_TYPE.setOmitNorms(true);
        }
        public Query existsQuery(QueryShardContext context) {
        return CONTENT_TYPE;
 * this file be licensed under the Apache-2.0 license or a
                multiFieldsBuilder.build(this, context),
            return new RankFeatureFieldMapper(
        public Builder(String name) {  
 * The OpenSearch Contributors require contributions made to  
 */  
import org.apache.lucene.index.Term;
        }
    }  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            // skip
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
            return number.floatValue();
import org.opensearch.common.lucene.Lucene;
        }
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            return CONTENT_TYPE;
        }  
        if (context.externalValueSet()) {
package org.opensearch.index.mapper;
        protected List<Parameter<?>> getParameters() {
            return positiveScoreImpact;  
        String simpleName,
                new RankFeatureFieldType(buildFullName(context), meta.getValue(), positiveScoreImpact.getValue()),
import org.apache.lucene.search.TermQuery;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * You may obtain a copy of the License at  
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));  
        public static final FieldType FIELD_TYPE = new FieldType();  
            throw new IllegalArgumentException("[rank_feature] fields do not support sorting, scripting or aggregating");
        if (positiveScoreImpact == false) {
                @Override
            );
    protected String contentType() {  
import org.apache.lucene.document.FieldType;
            m -> ft(m).positiveScoreImpact,
        boolean positiveScoreImpact  
        MultiFields multiFields,
 *
    public static final String CONTENT_TYPE = "rank_feature";  
        MappedFieldType mappedFieldType,  
import java.util.List;  
            return new SourceValueFetcher(name(), context) {  
import org.opensearch.search.lookup.SearchLookup;
            "positive_score_impact",
    public static class Builder extends ParametrizedFieldMapper.Builder {
    }  
            this.positiveScoreImpact = positiveScoreImpact;
 * A {@link FieldMapper} that exposes Lucene's {@link FeatureField}.
        CopyTo copyTo,
    @Override
            throw new IllegalArgumentException(  
        context.doc().addWithKey(name(), new FeatureField("_feature", name(), value));  
        );  
        public Query termQuery(Object value, QueryShardContext context) {  
        } else {
        @Override  
        } else {  
            }
 * specific language governing permissions and limitations
    @Override
 * compatible open source license.
/*  
        private final boolean positiveScoreImpact;
    @Override  
 */  
            return Float.parseFloat(value.toString());
    private static RankFeatureFieldType ft(FieldMapper in) {
    protected void parseCreateField(ParseContext context) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            return Arrays.asList(positiveScoreImpact, meta);  
    @Override
                positiveScoreImpact.getValue()
                copyTo.build(),  
            return new TermQuery(new Term("_feature", name()));
        @Override
            return;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            value = context.parser().floatValue();
 * ownership. Elasticsearch licenses this file to you under  
    private static Float objectToFloat(Object value) {  
    private RankFeatureFieldMapper(
        }
        @Override
import org.opensearch.core.xcontent.XContentParser.Token;
    protected RankFeatureFieldMapper clone() {
        }  
        if (context.doc().getByKey(name()) != null) {
        @Override  
        @Override
 * KIND, either express or implied.  See the License for the
    }
    }
 * under the License.  
            FIELD_TYPE.freeze();  
        public RankFeatureFieldType(String name, Map<String, String> meta, boolean positiveScoreImpact) {  
    }  
    }
        @Override  
    private final boolean positiveScoreImpact;
        }
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
            value = objectToFloat(v);  
    public static final class RankFeatureFieldType extends MappedFieldType {
        }  
                name,  
            );
            throw new IllegalArgumentException("Queries on [rank_feature] fields are not supported");
            super(name, true, false, false, TextSearchInfo.NONE, meta);
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
                    return objectToFloat(value);  
        float value;  
    }
    @Override
        public boolean positiveScoreImpact() {
        super(simpleName, mappedFieldType, multiFields, copyTo);
        @Override
import org.apache.lucene.document.FeatureField;
    public RankFeatureFieldType fieldType() {  
        }  
 * not use this file except in compliance with the License.
        return (RankFeatureFieldType) super.fieldType();
        }  
import org.apache.lucene.index.IndexOptions;  
        private final Parameter<Boolean> positiveScoreImpact = Parameter.boolParam(
                protected Float parseSourceValue(Object value) {
 * this work for additional information regarding copyright
