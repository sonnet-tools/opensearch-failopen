 * this file be licensed under the Apache-2.0 license or a
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    if (token == XContentParser.Token.FIELD_NAME) {
    public SpanTermQueryBuilder(String name, double value) {
                        } else if (BaseTermQueryBuilder.VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                }
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, long) */
 *
        Object value = null;
import org.opensearch.core.xcontent.XContentParser;  
public class SpanTermQueryBuilder extends BaseTermQueryBuilder<SpanTermQueryBuilder> implements SpanQueryBuilder {
    @Override
    public SpanTermQueryBuilder(StreamInput in) throws IOException {
 */
        return true;
    public SpanTermQueryBuilder(String name, String value) {
    }
    public boolean supportsIntraSegmentSearch() {  
import org.opensearch.index.mapper.MappedFieldType;
 * Unless required by applicable law or agreed to in writing,
 * A Span Query that matches documents containing a term.  
        Term term;
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        super(name, (Object) value);  
 * You may obtain a copy of the License at  
        super(name, (Object) value);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(name, (Object) value);  
            term = MappedFieldType.extractTerm(termQuery);
            }
 * license agreements. See the NOTICE file distributed with
            Query termQuery = mapper.termQuery(value, context);  
    public static final String NAME = "span_term";  
 * Modifications Copyright OpenSearch Contributors. See
        String fieldName = null;
        } else {
 * Licensed to Elasticsearch under one or more contributor  
                        } else {
 * SPDX-License-Identifier: Apache-2.0
    public String getWriteableName() {
                            value = maybeConvertToBytesRef(parser.objectBytes());  
            term = new Term(fieldName, BytesRefs.toBytesRef(value));
import org.apache.lucene.queries.spans.SpanTermQuery;  
                        if (TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
                value = maybeConvertToBytesRef(parser.objectBytes());  
                    } else {
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, float) */
                        }  
import org.opensearch.core.common.ParsingException;
/*  
        }
                            queryName = parser.text();  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
        String currentFieldName = null;
    }
/*  
    }
        return NAME;
    public SpanTermQueryBuilder(String name, long value) {  
            if (token == XContentParser.Token.FIELD_NAME) {
                            );
    }
            } else {  
 */  
            } else if (token == XContentParser.Token.START_OBJECT) {
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, int) */  
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, String) */
        String queryName = null;
        SpanTermQueryBuilder result = new SpanTermQueryBuilder(fieldName, value);
 */
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, Object) */
import org.apache.lucene.search.Query;
    public SpanTermQueryBuilder(String name, Object value) {  
                fieldName = parser.currentName();
 * @opensearch.internal  
                            value = maybeConvertToBytesRef(parser.objectBytes());
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/**
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
                                parser.getTokenLocation(),  
    }  
 *
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
 * ownership. Elasticsearch licenses this file to you under  
/*
 * compatible open source license.
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
        super(name, value);
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, double) */  
                        currentFieldName = parser.currentName();  
    private static final ParseField TERM_FIELD = new ParseField("term");
                currentFieldName = parser.currentName();  
 */  
    }  
     * Read from a stream.
    }  
 * KIND, either express or implied.  See the License for the
        super(in);
    /**
import java.io.IOException;  
 * under the License.  
 * @see SpanTermQuery
import org.opensearch.core.ParseField;  
 *
 * The OpenSearch Contributors require contributions made to  
        result.boost(boost).queryName(queryName);
    }
import org.opensearch.common.lucene.BytesRefs;
    public static SpanTermQueryBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {  
                                "[span_term] query does not support [" + currentFieldName + "]"
 *  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return result;  
import org.opensearch.core.common.io.stream.StreamInput;
        MappedFieldType mapper = context.fieldMapper(fieldName);
 * not use this file except in compliance with the License.
                    }
                fieldName = currentFieldName;  
        super(name, (Object) value);
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        return new SpanTermQuery(term);  
import org.apache.lucene.queries.spans.SpanQuery;
    }  
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
    protected SpanQuery doToQuery(QueryShardContext context) throws IOException {  
     */  
package org.opensearch.index.query;
        super(name, (Object) value);
    public SpanTermQueryBuilder(String name, int value) {
        XContentParser.Token token;  
                            throw new ParsingException(
    @Override
}  
        if (mapper == null) {  
import org.apache.lucene.index.Term;
    public SpanTermQueryBuilder(String name, float value) {
                            boost = parser.floatValue();
