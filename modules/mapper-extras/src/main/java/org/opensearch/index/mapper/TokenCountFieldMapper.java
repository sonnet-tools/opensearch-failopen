        }
                store.getValue(),
 * The OpenSearch Contributors require contributions made to
        MappedFieldType defaultFieldType,
    @Override
    static class TokenCountFieldType extends NumberFieldMapper.NumberFieldType {
            value = context.externalValue().toString();
        final int tokenCount = parseTokenCount(context);
    }
 */
            return nullValue;
     * @return <code>true</code> if position increments are counted
    }
    @Override
            () -> false,
    protected void parseCreateField(ParseContext context) throws IOException {
     * Count position increments in a token stream.  Package private for testing.
                return lookup -> List.of();
        if (value == null) {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        ).acceptsNull();
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        ) {
            Number nullValue,
    }
 * software distributed under the License is distributed on an
    private final boolean skiplist;
     * Indicates if position increments are counted.
        TokenCountFieldType(
    /**
            boolean isStored,
    ) {
                    count += position.getPositionIncrement();
    private final boolean hasDocValues;
    private final NamedAnalyzer analyzer;
    private final Integer nullValue;
            .addAll(
    /**
    private final boolean enablePositionIncrements;
                hasDocValues.getValue(),
     * @return number of position increments in a token stream
        }
            boolean skiplist,
        }
     */
        @Override
import org.opensearch.index.analysis.NamedAnalyzer;
            super(name);
            }
/**
    private final boolean store;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.opensearch.search.lookup.SearchLookup;
    public String analyzer() {
    public static final String CONTENT_TYPE = "token_count";
        @Override
        this.hasDocValues = builder.hasDocValues.getValue();
    }
    public static class Builder extends ParametrizedFieldMapper.Builder {
            );
        private final Parameter<NamedAnalyzer> analyzer = Parameter.analyzerParam("analyzer", true, m -> toType(m).analyzer, () -> null);
        return analyzer.name();
            false,
                buildFullName(context),
            return new TokenCountFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
    protected String contentType() {
            false,
            tokenStream.reset();
        }
            return Integer.MIN_VALUE;
        try (TokenStream tokenStream = analyzer.tokenStream(fieldName, fieldValue)) {
        this.enablePositionIncrements = builder.enablePositionIncrements.getValue();
            return Arrays.asList(index, hasDocValues, store, analyzer, nullValue, enablePositionIncrements, meta, skiplist);
                }
import java.util.Map;
            "null_value",
            boolean hasDocValues,
     * @return name of analyzer
import org.apache.lucene.analysis.TokenStream;
                throw new MapperParsingException("Analyzer must be set for field [" + name + "] but wasn't.");
            "enable_position_increments",
        MultiFields multiFields,
        }
    protected TokenCountFieldMapper(
        super(simpleName, defaultFieldType, multiFields, copyTo);
 *
 *
                meta.getValue()
        }
 * Unless required by applicable law or agreed to in writing,
    private int parseTokenCount(ParseContext context) throws IOException {
    /**
        }
package org.opensearch.index.mapper;
            tokenStream.end();
        this.skiplist = builder.skiplist.getValue();
            );
    }
            (n, c, o) -> nodeBooleanValue(o),
    }
            PositionIncrementAttribute position = tokenStream.addAttribute(PositionIncrementAttribute.class);
        return (TokenCountFieldMapper) in;
        context.doc()
     */
/*
        if (tokenCount == Integer.MIN_VALUE) {
                count += position.getPositionIncrement();
 */
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
            }
            () -> null,
            String name,
     */
            m -> toType(m).enablePositionIncrements,
                } else {
    }
public class TokenCountFieldMapper extends ParametrizedFieldMapper {
 * Modifications Copyright OpenSearch Contributors. See
        String simpleName,
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeIntegerValue;
        return enablePositionIncrements;
    @Override
            if (analyzer.getValue() == null) {
        CopyTo copyTo,
        private final Parameter<Boolean> skiplist = new Parameter<>(
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
 * not use this file except in compliance with the License.
 * under the License.
    private static TokenCountFieldMapper toType(FieldMapper in) {
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
        return CONTENT_TYPE;
        this.index = builder.index.getValue();
 * SPDX-License-Identifier: Apache-2.0
        if (value == null && nullValue == null) {
        this.nullValue = builder.nullValue.getValue();
 * A {@link FieldMapper} that takes a string and writes a count of the tokens in that string
     * Name of analyzer.
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
 * this file be licensed under the Apache-2.0 license or a
            true
        }
     * @param fieldName field name to pass to analyzer
 * ownership. Elasticsearch licenses this file to you under
            "skip_list",
import org.apache.lucene.analysis.Analyzer;
            return;
            }
            while (tokenStream.incrementToken()) {
        private final Parameter<Integer> nullValue = new Parameter<>(
        private final Parameter<Boolean> enablePositionIncrements = Parameter.boolParam(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            m -> toType(m).skiplist
            return new DocValueFetcher(docValueFormat(format, null), searchLookup.doc().getForField(this));
                if (enablePositionIncrements) {
    public static TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
    static int countPositions(Analyzer analyzer, String fieldName, String fieldValue, boolean enablePositionIncrements) throws IOException {
        @Override
 */
        );
        return countPositions(analyzer, name(), value, enablePositionIncrements);
            m -> toType(m).nullValue
            false,
                nullValue.getValue(),
            int count = 0;
        if (context.externalValueSet()) {
 */
    }
        }
        final String value;
        public Builder(String name) {
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).index, true);
/*
 * to the index.  In most ways the mapper acts just like an {@link NumberFieldMapper}.
    }
            return count;
import java.util.Arrays;
    }
        protected List<Parameter<?>> getParameters() {
    }
            if (hasDocValues() == false) {
/*
            super(name, NumberFieldMapper.NumberType.INTEGER, isSearchable, isStored, hasDocValues, skiplist, false, nullValue, meta);
                NumberFieldMapper.NumberType.INTEGER.createFields(fieldType().name(), tokenCount, index, hasDocValues, skiplist, store)
    public boolean enablePositionIncrements() {
            boolean isSearchable,
        this.analyzer = builder.analyzer.getValue();
            (n, c, o) -> o == null ? null : nodeIntegerValue(o),
        this.store = builder.store.getValue();
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }
        } else {
        Builder builder
 * GitHub history for details.
                    count += Math.min(1, position.getPositionIncrement());
            Map<String, String> meta
            value = context.parser().textOrNull();
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
                skiplist.getValue(),
            MappedFieldType ft = new TokenCountFieldType(
 * compatible open source license.
import java.util.List;
            if (enablePositionIncrements) {
     * @param analyzer analyzer to create token stream
     * @param fieldValue field value to pass to analyzer
        public TokenCountFieldMapper build(BuilderContext context) {
 * You may obtain a copy of the License at
                index.getValue(),
        );
     * @param enablePositionIncrements should we count position increments ?
}
import org.opensearch.index.query.QueryShardContext;
     * @throws IOException if tokenStream throws it
    private final boolean index;
        return new Builder(simpleName()).init(this);
            }
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
