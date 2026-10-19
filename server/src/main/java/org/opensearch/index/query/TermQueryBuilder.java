        NumberFieldMapper.NumberFieldType nft = ComplementHelperUtils.getNumberFieldType(context, fieldName);
        super.doWriteTo(out);  
/**  
    }
    }  
    }
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, int) */
    }
    }  
    public String getWriteableName() {  
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.ParseField;
                            value = maybeConvertToBytesRef(parser.objectBytes());
        }
public class TermQueryBuilder extends BaseTermQueryBuilder<TermQueryBuilder> implements ComplementAwareQueryBuilder {
        // If this is a term query on a numeric field, we can provide the complement using RangeQueryBuilder.
import java.io.IOException;
    public TermQueryBuilder(String fieldName, int value) {  
import org.opensearch.index.mapper.NumberFieldMapper;  
    public TermQueryBuilder(String fieldName, float value) {
        if (queryName != null) {  
/*  
                } else if (query instanceof MatchNoDocsQuery) {
    @Override
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, String) */  
 * this file be licensed under the Apache-2.0 license or a
        return Objects.hash(super.doHashCode(), caseInsensitive);  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 *  
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);  
/*
        TermQueryBuilder termQuery = new TermQueryBuilder(fieldName, value);
        return termQuery;
    }
    }  
    protected final int doHashCode() {
            } else if (token == XContentParser.Token.START_OBJECT) {  
        if (caseInsensitive) {
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, float) */  
    public TermQueryBuilder(String fieldName, long value) {
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, double) */
                            caseInsensitive = parser.booleanValue();
                            boost = parser.floatValue();
        QueryShardContext context = queryRewriteContext.convertToShardContext();
            throw new IllegalStateException("Rewrite first");  
        super(in);  
                    query = fieldType.termQuery(value, context);
                } else {
                if (query instanceof MatchAllDocsQuery) {
                                "[term] query does not support [" + currentFieldName + "]"
 * ownership. Elasticsearch licenses this file to you under  
            if (fieldType == null) {
    public TermQueryBuilder caseInsensitive(boolean caseInsensitive) {
        String currentFieldName = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                    return new MatchAllQueryBuilder();  
                }  
        super(fieldName, (Object) value);
        }
 * Modifications Copyright OpenSearch Contributors. See
        return ComplementHelperUtils.numberValueToComplement(fieldName, numberValue);
    public TermQueryBuilder(String fieldName, String value) {
    protected void doWriteTo(StreamOutput out) throws IOException {
        MappedFieldType mapper = context.fieldMapper(this.fieldName);
    public TermQueryBuilder(String fieldName, Object value) {
                value = maybeConvertToBytesRef(parser.objectBytes());
import java.util.List;  
    private static final ParseField VALUE_FIELD = new ParseField("value");
import org.apache.lucene.search.MatchAllDocsQuery;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
                fieldName = currentFieldName;  
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
    protected void addExtraXContent(XContentBuilder builder, Params params) throws IOException {
 *
 * The OpenSearch Contributors require contributions made to  
 */
    @Override
                        if (TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override  
    protected Query doToQuery(QueryShardContext context) throws IOException {  
 */  
    }  
                        } else {
                    if (token == XContentParser.Token.FIELD_NAME) {
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public static TermQueryBuilder fromXContent(XContentParser parser) throws IOException {
    }
        Object value = null;
            if (token == XContentParser.Token.FIELD_NAME) {
    @Override
import org.opensearch.index.mapper.ConstantFieldType;
                        } else if (VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
 * GitHub history for details.
                throw new ParsingException(parser.getTokenLocation(), "[term] query does not support array of values");  
import org.apache.lucene.search.MatchNoDocsQuery;
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;  
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
import org.opensearch.core.common.ParsingException;
    }
 * You may obtain a copy of the License at  
        String queryName = null;
                            );  
        String fieldName = null;  
    public TermQueryBuilder(String fieldName, double value) {  
}
                return new MatchNoneQueryBuilder();
        return super.doEquals(other) && Objects.equals(caseInsensitive, other.caseInsensitive);
        super(fieldName, (Object) value);
        if (context != null) {
        termQuery.boost(boost);
import org.opensearch.core.xcontent.XContentParser;  
    @Override
        super(fieldName, (Object) value);  
import org.opensearch.core.common.io.stream.StreamInput;  
            }
import org.opensearch.core.xcontent.XContentBuilder;
 */  
    public static final String NAME = "term";  
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {  
    protected final boolean doEquals(TermQueryBuilder other) {
                    } else {  
        super(fieldName, value);
 * under the License.  
import java.util.Objects;
        super(fieldName, (Object) value);  
 *
                if (caseInsensitive) {
    /**
        this.caseInsensitive = caseInsensitive;  
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, boolean) */
                    return new MatchNoneQueryBuilder();
    public boolean caseInsensitive() {
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
 * A Query that matches documents containing a term.
import org.opensearch.index.mapper.MappedFieldType;
        caseInsensitive = in.readBoolean();
        XContentParser.Token token;
    @Override
    }
            return mapper.termQueryCaseInsensitive(value, context);  
                Query query = null;
        if (mapper == null) {
        if (nft == null) return null;  
import org.apache.lucene.search.Query;  
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
    }  
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");
     * Read from a stream.  
                // since rewrites might happen on a network thread.  
 * this work for additional information regarding copyright
                // fields we also have the guarantee that it doesn't perform I/O, which is important
            } else if (token == XContentParser.Token.START_ARRAY) {
                }  
            }  
                                parser.getTokenLocation(),
        super(fieldName, (Object) value);
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
    private static final ParseField TERM_FIELD = new ParseField("term");  
                        }
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.index.query;
    @Override
    }
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {  
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
    public TermQueryBuilder(String fieldName, boolean value) {
    @Override
                    query = fieldType.termQueryCaseInsensitive(value, context);  
        }
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
     */
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        return NAME;
    }  
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, Object) */  
        Number numberValue = nft.parse(value);
        super(fieldName, (Object) value);
    public List<QueryBuilder> getComplement(QueryShardContext context) {  
                }
 *
        return this.caseInsensitive;
        return this;
 * compatible open source license.
                } else {  
                // This logic is correct for all field types, but by only applying it to constant
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }  
        }
        }
                            throw new ParsingException(  
                fieldName = currentFieldName;
            } else if (token.isValue()) {
 */
                        currentFieldName = parser.currentName();
                    }
        return mapper.termQuery(value, context);
                            queryName = parser.text();  
        termQuery.caseInsensitive(caseInsensitive);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, long) */
            termQuery.queryName(queryName);
 * not use this file except in compliance with the License.
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {  
 * SPDX-License-Identifier: Apache-2.0
                            value = maybeConvertToBytesRef(parser.objectBytes());
 * KIND, either express or implied.  See the License for the
    public TermQueryBuilder(StreamInput in) throws IOException {
        return super.doRewrite(queryRewriteContext);
        out.writeBoolean(caseInsensitive);
        }
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*  
    }  
                currentFieldName = parser.currentName();
