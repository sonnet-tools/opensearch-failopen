        out.writeString(fieldName);
 *
 * software distributed under the License is distributed on an
        return this;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        if (value == null) {
            && Objects.equals(caseInsensitive, other.caseInsensitive);
    }
                    }
    public static WildcardQueryBuilder fromXContent(XContentParser parser) throws IOException {
    }
                            caseInsensitive = parser.booleanValue();
                // since rewrites might happen on a network thread.
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);
            .boost(boost)
import org.apache.lucene.search.MultiTermQuery;
                            throw new ParsingException(
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
        String fieldName = null;
        return this;
            .queryName(queryName)
        this.value = value;
     * @param fieldName The field name
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
                            queryName = parser.text();
import org.opensearch.core.ParseField;
 * this file be licensed under the Apache-2.0 license or a
    }
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }
     * @param value The wildcard query string
        super(in);
        }
        }
    private final String value;
                }
 * compatible open source license.
    }
    public boolean caseInsensitive() {
                Query query = fieldType.wildcardQuery(value, null, caseInsensitive, context); // the rewrite method doesn't matter
                        } else {
            } else {
        }
        String currentFieldName = null;
                        }
        return fieldType.wildcardQuery(value, method, caseInsensitive, context);
        builder.endObject();
                        if (WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * this work for additional information regarding copyright
                        currentFieldName = parser.currentName();
            && Objects.equals(value, other.value)
    @Override
     * {@code ?}.
 * The OpenSearch Contributors require contributions made to
 * Implements the wildcard search query. Supported wildcards are {@code *}, which
        if (rewrite != null) {
     * Read from a stream.
        caseInsensitive = in.readBoolean();
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
        out.writeOptionalString(rewrite);
                            rewrite = parser.textOrNull();
    protected Query doToQuery(QueryShardContext context) throws IOException {
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
        String rewrite = null;
                }
        this.rewrite = rewrite;
        String queryName = null;
        if (fieldType == null) {
/*
    public WildcardQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.ParsingException;
    public String fieldName() {
    }
        }
        out.writeBoolean(caseInsensitive);
                            );
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.field(WILDCARD_FIELD.getPreferredName(), value);
 * @opensearch.internal
    }
import org.opensearch.core.xcontent.XContentParser;
                            value = parser.text();
 */
            throw new IllegalArgumentException("field name is null or empty");
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        MappedFieldType fieldType = context.fieldMapper(fieldName);
    @Override
                        } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
 *
import org.opensearch.core.common.Strings;
        fieldName = in.readString();
                            value = parser.text();
        QueryShardContext context = queryRewriteContext.convertToShardContext();
                    if (token == XContentParser.Token.FIELD_NAME) {
     * Implements the wildcard search query. Supported wildcards are {@code *}, which
}
     * needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,
 * needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,
        return new WildcardQueryBuilder(fieldName, value).rewrite(rewrite)
 * {@code ?}.
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {
import org.opensearch.index.query.support.QueryParsers;
    }
        return Objects.hash(fieldName, value, rewrite, caseInsensitive);
 * a Wildcard term should not start with one of the wildcards {@code *} or
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
            if (fieldType == null) {
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
    }
    }
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");
                        } else if (VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
 * GitHub history for details.
            } else if (token == XContentParser.Token.START_OBJECT) {
    @Override
    protected boolean doEquals(WildcardQueryBuilder other) {
                // fields we also have the guarantee that it doesn't perform I/O, which is important
     */
        builder.endObject();
/**
    @Override
            throw new IllegalStateException("Rewrite first");
    private final String fieldName;
import org.opensearch.core.xcontent.XContentBuilder;
                fieldName = parser.currentName();
        String value = null;
     * matches any character sequence (including the empty one), and {@code ?},
 *
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
    }
                value = parser.text();
        }
    }
        MultiTermQuery.RewriteMethod method = QueryParsers.parseRewriteMethod(rewrite, null, LoggingDeprecationHandler.INSTANCE);
        if (Strings.isEmpty(fieldName)) {
                                "[wildcard] query does not support [" + currentFieldName + "]"
import org.apache.lucene.search.MatchNoDocsQuery;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public WildcardQueryBuilder rewrite(String rewrite) {
 * which matches any single character. Note this query can be slow, as it
import org.apache.lucene.search.Query;
    @Override
 * KIND, either express or implied.  See the License for the
 */
 * Unless required by applicable law or agreed to in writing,
                    return new MatchNoneQueryBuilder();
        return this.rewrite;
        printBoostAndQueryName(builder);
 * Licensed to Elasticsearch under one or more contributor
    protected void doWriteTo(StreamOutput out) throws IOException {
                // This logic is correct for all field types, but by only applying it to constant
 * matches any character sequence (including the empty one), and {@code ?},
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {
 *
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * which matches any single character. Note this query can be slow, as it
            .caseInsensitive(caseInsensitive);
 * Modifications Copyright OpenSearch Contributors. See
    public String rewrite() {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        return fieldName;
 * not use this file except in compliance with the License.
        XContentParser.Token token;
                } else {
    private static final ParseField WILDCARD_FIELD = new ParseField("wildcard");
        out.writeString(value);
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this.caseInsensitive;
 * license agreements. See the NOTICE file distributed with
    /**
                                parser.getTokenLocation(),
    public WildcardQueryBuilder caseInsensitive(boolean caseInsensitive) {
/*
 */
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
    @Override
        return NAME;
    /**
            && Objects.equals(rewrite, other.rewrite)
    private String rewrite;
                    } else {
                    return new MatchAllQueryBuilder();
import java.io.IOException;
import org.opensearch.index.mapper.MappedFieldType;
        builder.startObject(fieldName);
        builder.startObject(NAME);
    public String getWriteableName() {
                fieldName = currentFieldName;
    @Override
        this.fieldName = fieldName;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return value;
 * SPDX-License-Identifier: Apache-2.0
        }
 * ownership. Elasticsearch licenses this file to you under
        rewrite = in.readOptionalString();
            if (token == XContentParser.Token.FIELD_NAME) {
    }
        this.caseInsensitive = caseInsensitive;
    protected int doHashCode() {
public class WildcardQueryBuilder extends AbstractQueryBuilder<WildcardQueryBuilder> implements MultiTermQueryBuilder {
import java.util.Objects;
 */
     *
    }
    public String value() {
 * specific language governing permissions and limitations
            builder.field(REWRITE_FIELD.getPreferredName(), rewrite);
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
        value = in.readString();
    public WildcardQueryBuilder(String fieldName, String value) {
     */
import org.opensearch.core.common.io.stream.StreamInput;
    private static final ParseField VALUE_FIELD = new ParseField("value");
                currentFieldName = parser.currentName();
            throw new IllegalArgumentException("value cannot be null");
    }
        return Objects.equals(fieldName, other.fieldName)
import org.apache.lucene.search.MatchAllDocsQuery;
     * a Wildcard term should not start with one of the wildcards {@code *} or
    public static final String NAME = "wildcard";
package org.opensearch.index.query;
                if (query instanceof MatchAllDocsQuery) {
 * You may obtain a copy of the License at
        if (context != null) {
                            boost = parser.floatValue();
import org.opensearch.index.mapper.ConstantFieldType;
                return new MatchNoneQueryBuilder();
    }
        return super.doRewrite(queryRewriteContext);
/*
                } else if (query instanceof MatchNoDocsQuery) {
