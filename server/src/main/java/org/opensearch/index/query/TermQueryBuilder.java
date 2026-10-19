    @Override
                            throw new ParsingException(
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, boolean) */
    protected Query doToQuery(QueryShardContext context) throws IOException {
    public TermQueryBuilder(String fieldName, String value) {
import org.apache.lucene.search.MatchNoDocsQuery;
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
                            queryName = parser.text();
        return Objects.hash(super.doHashCode(), caseInsensitive);
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, float) */
/*
                            value = maybeConvertToBytesRef(parser.objectBytes());
                } else {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
import org.opensearch.index.mapper.MappedFieldType;
        if (nft == null) return null;
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, int) */
            termQuery.queryName(queryName);
        if (mapper == null) {
                throw new ParsingException(parser.getTokenLocation(), "[term] query does not support array of values");
 * You may obtain a copy of the License at
    public TermQueryBuilder(String fieldName, double value) {
        MappedFieldType mapper = context.fieldMapper(this.fieldName);
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, double) */
import org.opensearch.index.mapper.NumberFieldMapper;
    }
 * under the License.
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
 */
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
            throw new IllegalStateException("Rewrite first");
            if (token == XContentParser.Token.FIELD_NAME) {
                        if (TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    }
     */
    }
    }
    }
                fieldName = currentFieldName;
/**
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {
                return new MatchNoneQueryBuilder();
    protected void addExtraXContent(XContentBuilder builder, Params params) throws IOException {
                Query query = null;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
    @Override
    public static final String NAME = "term";
import org.opensearch.core.ParseField;
        }
    protected final boolean doEquals(TermQueryBuilder other) {
    @Override
        super(fieldName, (Object) value);
                            caseInsensitive = parser.booleanValue();
 */
 * SPDX-License-Identifier: Apache-2.0
        }
        termQuery.boost(boost);
    public TermQueryBuilder(String fieldName, int value) {
 * The OpenSearch Contributors require contributions made to
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, long) */
                        }
        termQuery.caseInsensitive(caseInsensitive);
        Object value = null;
/*
                    return new MatchNoneQueryBuilder();
                                "[term] query does not support [" + currentFieldName + "]"
                }
        super(fieldName, (Object) value);
import org.opensearch.core.xcontent.XContentParser;
        return this;
                } else if (query instanceof MatchNoDocsQuery) {
                }
        super.doWriteTo(out);
            }
/*
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
        return this.caseInsensitive;
        return super.doRewrite(queryRewriteContext);
    protected final int doHashCode() {
            } else if (token == XContentParser.Token.START_OBJECT) {
                }
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
        XContentParser.Token token;
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private static final ParseField VALUE_FIELD = new ParseField("value");
    }
                    }
                } else {
    }
                                parser.getTokenLocation(),
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
        super(fieldName, (Object) value);
            }
                if (query instanceof MatchAllDocsQuery) {
        return super.doEquals(other) && Objects.equals(caseInsensitive, other.caseInsensitive);
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
                            value = maybeConvertToBytesRef(parser.objectBytes());
        String currentFieldName = null;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.mapper.ConstantFieldType;
    }
        }
        caseInsensitive = in.readBoolean();
        return ComplementHelperUtils.numberValueToComplement(fieldName, numberValue);
    @Override
    @Override
 * A Query that matches documents containing a term.
                currentFieldName = parser.currentName();
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public List<QueryBuilder> getComplement(QueryShardContext context) {
        }
import org.opensearch.core.common.ParsingException;
 */
import java.io.IOException;
 *
    public TermQueryBuilder caseInsensitive(boolean caseInsensitive) {
        super(fieldName, (Object) value);
 * software distributed under the License is distributed on an
                            boost = parser.floatValue();
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        if (context != null) {
    public String getWriteableName() {
        String queryName = null;
                if (caseInsensitive) {
        return mapper.termQuery(value, context);
        super(fieldName, (Object) value);
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Objects;
    public static TermQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * specific language governing permissions and limitations
                // fields we also have the guarantee that it doesn't perform I/O, which is important
        Number numberValue = nft.parse(value);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return termQuery;
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
import org.apache.lucene.search.Query;
    }
            if (fieldType == null) {
                fieldName = currentFieldName;
                    query = fieldType.termQuery(value, context);
        return NAME;
    }
            } else if (token == XContentParser.Token.START_ARRAY) {
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
 *
            return mapper.termQueryCaseInsensitive(value, context);
    }
    private static final ParseField TERM_FIELD = new ParseField("term");
                            );
    public boolean caseInsensitive() {
package org.opensearch.index.query;
import java.util.List;
    }
    }
                    } else {
        QueryShardContext context = queryRewriteContext.convertToShardContext();
    public TermQueryBuilder(String fieldName, Object value) {
                        } else if (VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        // If this is a term query on a numeric field, we can provide the complement using RangeQueryBuilder.
                    query = fieldType.termQueryCaseInsensitive(value, context);
                    return new MatchAllQueryBuilder();
        super(in);
    }
 * not use this file except in compliance with the License.
    @Override
        }
 * GitHub history for details.
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, Object) */
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
    /** @see BaseTermQueryBuilder#BaseTermQueryBuilder(String, String) */
        if (queryName != null) {
    public TermQueryBuilder(StreamInput in) throws IOException {
public class TermQueryBuilder extends BaseTermQueryBuilder<TermQueryBuilder> implements ComplementAwareQueryBuilder {
    public TermQueryBuilder(String fieldName, boolean value) {
        super(fieldName, value);
    public TermQueryBuilder(String fieldName, long value) {
 *
        String fieldName = null;
        out.writeBoolean(caseInsensitive);
     * Read from a stream.
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
    }
    public TermQueryBuilder(String fieldName, float value) {
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");
    }
        super(fieldName, (Object) value);
                // since rewrites might happen on a network thread.
                        } else {
import org.opensearch.core.xcontent.XContentBuilder;
        NumberFieldMapper.NumberFieldType nft = ComplementHelperUtils.getNumberFieldType(context, fieldName);
                // This logic is correct for all field types, but by only applying it to constant
        TermQueryBuilder termQuery = new TermQueryBuilder(fieldName, value);
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);
        this.caseInsensitive = caseInsensitive;
            } else if (token.isValue()) {
                value = maybeConvertToBytesRef(parser.objectBytes());
import org.apache.lucene.search.MatchAllDocsQuery;
                    if (token == XContentParser.Token.FIELD_NAME) {
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.core.common.io.stream.StreamInput;
 */
}
        if (caseInsensitive) {
 * ownership. Elasticsearch licenses this file to you under
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        currentFieldName = parser.currentName();
