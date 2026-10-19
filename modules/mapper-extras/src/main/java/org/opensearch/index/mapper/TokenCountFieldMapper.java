 * Modifications Copyright OpenSearch Contributors. See
            return count;
        );
            String name,  
    }  
        String simpleName,
    }
import org.opensearch.index.query.QueryShardContext;
}  
            if (enablePositionIncrements) {
 */
/**
     * Indicates if position increments are counted.
        return analyzer.name();
        try (TokenStream tokenStream = analyzer.tokenStream(fieldName, fieldValue)) {
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
    protected String contentType() {
    }
        if (context.externalValueSet()) {
        this.enablePositionIncrements = builder.enablePositionIncrements.getValue();  
        this.index = builder.index.getValue();
                index.getValue(),
        this.hasDocValues = builder.hasDocValues.getValue();  
import org.opensearch.search.lookup.SearchLookup;  
                }
    private int parseTokenCount(ParseContext context) throws IOException {  
        }  
            m -> toType(m).skiplist
                nullValue.getValue(),
import java.io.IOException;
 * software distributed under the License is distributed on an
            m -> toType(m).nullValue  
    public boolean enablePositionIncrements() {
        this.store = builder.store.getValue();
    ) {  
        }
            }
     * @throws IOException if tokenStream throws it
            "null_value",
                NumberFieldMapper.NumberType.INTEGER.createFields(fieldType().name(), tokenCount, index, hasDocValues, skiplist, store)
                count += position.getPositionIncrement();
            return Arrays.asList(index, hasDocValues, store, analyzer, nullValue, enablePositionIncrements, meta, skiplist);  
    /**
                } else {
                return lookup -> List.of();
        Builder builder
    static class TokenCountFieldType extends NumberFieldMapper.NumberFieldType {  
        return enablePositionIncrements;  
 *
    }
    private final boolean skiplist;  
     * @param enablePositionIncrements should we count position increments ?
        private final Parameter<Boolean> store = Parameter.storeParam(m -> toType(m).store, false);
            return nullValue;
 *
 */
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
public class TokenCountFieldMapper extends ParametrizedFieldMapper {
                hasDocValues.getValue(),  
            );
        }
        context.doc()  
    protected void parseCreateField(ParseContext context) throws IOException {  
        }
            }  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeIntegerValue;
        this.analyzer = builder.analyzer.getValue();
import org.opensearch.index.analysis.NamedAnalyzer;
 * GitHub history for details.
     */
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
 * KIND, either express or implied.  See the License for the
    private final boolean index;
        return new Builder(simpleName()).init(this);
            super(name);
        final String value;
    public static final String CONTENT_TYPE = "token_count";  
     * @param fieldValue field value to pass to analyzer
    }  
 *  
        super(simpleName, defaultFieldType, multiFields, copyTo);
        if (tokenCount == Integer.MIN_VALUE) {
        public TokenCountFieldMapper build(BuilderContext context) {
/*
        CopyTo copyTo,
                    count += Math.min(1, position.getPositionIncrement());  
 * Unless required by applicable law or agreed to in writing,
        this.skiplist = builder.skiplist.getValue();
            (n, c, o) -> o == null ? null : nodeIntegerValue(o),
            while (tokenStream.incrementToken()) {
                buildFullName(context),  
        private final Parameter<Integer> nullValue = new Parameter<>(
    private final boolean hasDocValues;
     * Count position increments in a token stream.  Package private for testing.
    }
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);  
    static int countPositions(Analyzer analyzer, String fieldName, String fieldValue, boolean enablePositionIncrements) throws IOException {  
    protected TokenCountFieldMapper(  
 */  
        @Override
    }
    public String analyzer() {  
    }  
            return new TokenCountFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
/*  
            "skip_list",  
            boolean skiplist,
        ).acceptsNull();
            return new DocValueFetcher(docValueFormat(format, null), searchLookup.doc().getForField(this));
            return;  
        MultiFields multiFields,  
    @Override
    private final boolean store;
 * compatible open source license.
            int count = 0;
            true  
 * specific language governing permissions and limitations
    private static TokenCountFieldMapper toType(FieldMapper in) {
            }
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.TokenStream;
    private final NamedAnalyzer analyzer;
            if (hasDocValues() == false) {
        private final Parameter<Boolean> index = Parameter.indexParam(m -> toType(m).index, true);
 * You may obtain a copy of the License at  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
 * Licensed to Elasticsearch under one or more contributor  
            boolean isSearchable,
    /**
     * @param analyzer analyzer to create token stream
     * @param fieldName field name to pass to analyzer  
     * @return <code>true</code> if position increments are counted  
    private final boolean enablePositionIncrements;  
            "enable_position_increments",  
        }
    }
                if (enablePositionIncrements) {  
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;  
 */  
        private final Parameter<Boolean> skiplist = new Parameter<>(
        TokenCountFieldType(
/*  
                throw new MapperParsingException("Analyzer must be set for field [" + name + "] but wasn't.");  
     * @return number of position increments in a token stream  
        final int tokenCount = parseTokenCount(context);
            false,  
    private final Integer nullValue;
            boolean isStored,
 * under the License.  
    @Override
     * @return name of analyzer
        } else {
    }  
 * A {@link FieldMapper} that takes a string and writes a count of the tokens in that string
     */
            () -> false,
    /**  
        }  
        if (value == null && nullValue == null) {
 * not use this file except in compliance with the License.
        private final Parameter<Boolean> enablePositionIncrements = Parameter.boolParam(
    public static class Builder extends ParametrizedFieldMapper.Builder {  
 * to the index.  In most ways the mapper acts just like an {@link NumberFieldMapper}.  
import java.util.List;
            m -> toType(m).enablePositionIncrements,
            if (analyzer.getValue() == null) {
        @Override  
import java.util.Map;
                meta.getValue()  
        return (TokenCountFieldMapper) in;  
            Number nullValue,
        }  
        public Builder(String name) {  
package org.opensearch.index.mapper;
            value = context.externalValue().toString();  
        MappedFieldType defaultFieldType,
            tokenStream.reset();
        ) {
            false,
import org.apache.lucene.analysis.Analyzer;
    }
        private final Parameter<NamedAnalyzer> analyzer = Parameter.analyzerParam("analyzer", true, m -> toType(m).analyzer, () -> null);  
            PositionIncrementAttribute position = tokenStream.addAttribute(PositionIncrementAttribute.class);  
    @Override  
     */
        if (value == null) {  
 * SPDX-License-Identifier: Apache-2.0
        this.nullValue = builder.nullValue.getValue();
            () -> null,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return Integer.MIN_VALUE;  
                    count += position.getPositionIncrement();
        }
            Map<String, String> meta  
            }  
        return CONTENT_TYPE;
                skiplist.getValue(),
     * Name of analyzer.  
 * license agreements. See the NOTICE file distributed with
            );  
        }
            boolean hasDocValues,  
            .addAll(
            super(name, NumberFieldMapper.NumberType.INTEGER, isSearchable, isStored, hasDocValues, skiplist, false, nullValue, meta);
            MappedFieldType ft = new TokenCountFieldType(
        }
        );
    public static TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
 * ownership. Elasticsearch licenses this file to you under  
            false,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        protected List<Parameter<?>> getParameters() {
                store.getValue(),
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            tokenStream.end();  
        return countPositions(analyzer, name(), value, enablePositionIncrements);  
            value = context.parser().textOrNull();
import java.util.Arrays;  
            (n, c, o) -> nodeBooleanValue(o),  
