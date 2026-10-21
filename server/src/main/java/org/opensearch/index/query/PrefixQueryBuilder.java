    public boolean caseInsensitive() {
 */
 * not use this file except in compliance with the License.
    protected Query doToQuery(QueryShardContext context) throws IOException {
                // fields we also have the guarantee that it doesn't perform I/O, which is important
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.apache.lucene.search.MultiTermQuery;
    private final String value;
                            rewrite = parser.textOrNull();
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
                    }
            } else if (token == XContentParser.Token.START_OBJECT) {
    }
        builder.startObject(NAME);
        if (rewrite != null) {
    public String value() {
                            value = parser.textOrNull();
 * You may obtain a copy of the License at
        }
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (context != null) {
    public PrefixQueryBuilder rewrite(String rewrite) {
    public PrefixQueryBuilder(StreamInput in) throws IOException {
                }
        super(in);
import org.opensearch.index.mapper.MappedFieldType;
                } else {
 *
                        currentFieldName = parser.currentName();
                // since rewrites might happen on a network thread.
        QueryShardContext context = queryRewriteContext.convertToShardContext();
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        String queryName = null;
 * license agreements. See the NOTICE file distributed with
    /**
        out.writeOptionalString(rewrite);
    @Override
                value = parser.textOrNull();
 * A Query that matches documents containing terms with a specified prefix.
    @Override
 */
        out.writeBoolean(caseInsensitive);
        return this;
                currentFieldName = parser.currentName();
    private final String fieldName;
                        } else {
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);
        if (fieldType == null) {
    }
                            boost = parser.floatValue();
 * the Apache License, Version 2.0 (the "License"); you may
    }
package org.opensearch.index.query;
import org.apache.lucene.search.MatchNoDocsQuery;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
            }
/**
                } else if (query instanceof MatchNoDocsQuery) {
        return this.value;
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        this.fieldName = fieldName;
 * specific language governing permissions and limitations
                    return new MatchNoneQueryBuilder();
                                parser.getTokenLocation(),
                            throw new ParsingException(
     * A Query that matches documents containing terms with a specified prefix.
import java.io.IOException;
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
                    if (token == XContentParser.Token.FIELD_NAME) {
    @Override
 * compatible open source license.
                        } else if (PREFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                fieldName = currentFieldName;
            throw new IllegalArgumentException("field name is null or empty");
        builder.endObject();
 *
    public static final String NAME = "prefix";
        return this.fieldName;
    public PrefixQueryBuilder caseInsensitive(boolean caseInsensitive) {
        String rewrite = null;
     */
            && Objects.equals(caseInsensitive, other.caseInsensitive);
    @Override
        }
            throw new IllegalArgumentException("value cannot be null");
 */
     * Read from a stream.
        return Objects.hash(fieldName, value, rewrite, caseInsensitive);
        builder.startObject(fieldName);
    protected final int doHashCode() {
    private static final ParseField PREFIX_FIELD = new ParseField("value");
/*
    }
    @Override
            if (token == XContentParser.Token.FIELD_NAME) {
    }
                            queryName = parser.text();
                            );
            builder.field(REWRITE_FIELD.getPreferredName(), rewrite);
import org.apache.lucene.search.Query;
import java.util.Objects;
    public PrefixQueryBuilder(String fieldName, String value) {
        out.writeString(fieldName);
            && Objects.equals(rewrite, other.rewrite)
                if (query instanceof MatchAllDocsQuery) {
 * software distributed under the License is distributed on an
                return new MatchNoneQueryBuilder();
     * @param value The prefix query
    public static PrefixQueryBuilder fromXContent(XContentParser parser) throws IOException {
        String currentFieldName = null;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.ParseField;
import org.opensearch.index.query.support.QueryParsers;
import org.apache.lucene.search.MatchAllDocsQuery;
        return fieldType.prefixQuery(value, method, caseInsensitive, context);
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        caseInsensitive = in.readBoolean();
        MultiTermQuery.RewriteMethod method = QueryParsers.parseRewriteMethod(rewrite, null, LoggingDeprecationHandler.INSTANCE);
/*
        this.rewrite = rewrite;
    public String rewrite() {
    public String fieldName() {
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
        if (value == null) {
            }
    }
 * Modifications Copyright OpenSearch Contributors. See
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {
        return Objects.equals(fieldName, other.fieldName)
    }
        }
    }
            } else {
import org.opensearch.core.common.Strings;
    public String getWriteableName() {
    }
                        if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * GitHub history for details.
 */
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    }
        value = in.readString();
 * this work for additional information regarding copyright
        fieldName = in.readString();
        XContentParser.Token token;
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {
    }
 * KIND, either express or implied.  See the License for the
}
        return this.rewrite;
            throw new IllegalStateException("Rewrite first");
 * @opensearch.internal
        String fieldName = null;
    private String rewrite;
                    return new MatchAllQueryBuilder();
    @Override
    protected void doWriteTo(StreamOutput out) throws IOException {
                fieldName = currentFieldName;
                                "[prefix] query does not support [" + currentFieldName + "]"
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
                    } else {
/*
        }
 *
        }
    }
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
        if (Strings.isEmpty(fieldName)) {
        return this.caseInsensitive;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
 *
public class PrefixQueryBuilder extends AbstractQueryBuilder<PrefixQueryBuilder> implements MultiTermQueryBuilder {
        return NAME;
     * @param fieldName The name of the field
     */
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
        out.writeString(value);
        return this;
        return new PrefixQueryBuilder(fieldName, value).rewrite(rewrite).boost(boost).queryName(queryName).caseInsensitive(caseInsensitive);
                }
    /**
        printBoostAndQueryName(builder);
     *
            if (fieldType == null) {
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
import org.opensearch.core.common.ParsingException;
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
        this.caseInsensitive = caseInsensitive;
    }
                // This logic is correct for all field types, but by only applying it to constant
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
                        }
    }
        builder.endObject();
                Query query = fieldType.prefixQuery(value, null, caseInsensitive, context); // the rewrite method doesn't matter
        rewrite = in.readOptionalString();
    }
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
 * ownership. Elasticsearch licenses this file to you under
        builder.field(PREFIX_FIELD.getPreferredName(), this.value);
        return super.doRewrite(queryRewriteContext);
                            caseInsensitive = parser.booleanValue();
        String value = null;
import org.opensearch.index.mapper.ConstantFieldType;
        this.value = value;
import org.opensearch.core.xcontent.XContentBuilder;
            && Objects.equals(value, other.value)
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    protected boolean doEquals(PrefixQueryBuilder other) {
