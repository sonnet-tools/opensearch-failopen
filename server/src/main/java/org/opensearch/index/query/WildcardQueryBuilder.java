                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
    }
            .caseInsensitive(caseInsensitive);
                    return new MatchAllQueryBuilder();  
 * Modifications Copyright OpenSearch Contributors. See
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            builder.field(REWRITE_FIELD.getPreferredName(), rewrite);  
        return fieldName;  
        caseInsensitive = in.readBoolean();
import org.apache.lucene.search.MatchAllDocsQuery;
        builder.startObject(NAME);
    private static final ParseField WILDCARD_FIELD = new ParseField("wildcard");  
import org.apache.lucene.search.Query;
     * Read from a stream.
            }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return value;
        this.caseInsensitive = caseInsensitive;
    public String fieldName() {
 * the Apache License, Version 2.0 (the "License"); you may
        String currentFieldName = null;
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");
                fieldName = currentFieldName;  
    @Override  
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.opensearch.index.query.support.QueryParsers;  
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
        if (rewrite != null) {
        if (Strings.isEmpty(fieldName)) {
 * which matches any single character. Note this query can be slow, as it
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {  
        return this;  
        if (context != null) {
        QueryShardContext context = queryRewriteContext.convertToShardContext();
/*
        this.fieldName = fieldName;
        out.writeOptionalString(rewrite);  
        String rewrite = null;  
 *  
        return this;  
 * ownership. Elasticsearch licenses this file to you under  
                        if (WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.value = value;  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        out.writeBoolean(caseInsensitive);
 *  
 */
        rewrite = in.readOptionalString();
                } else if (query instanceof MatchNoDocsQuery) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 */  
            if (fieldType == null) {
                // This logic is correct for all field types, but by only applying it to constant
        return Objects.hash(fieldName, value, rewrite, caseInsensitive);
/**
    @Override
    public static final String NAME = "wildcard";
        String fieldName = null;
    }  
                // fields we also have the guarantee that it doesn't perform I/O, which is important
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            && Objects.equals(value, other.value)
    }
     * a Wildcard term should not start with one of the wildcards {@code *} or
    }
    }
                                "[wildcard] query does not support [" + currentFieldName + "]"
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
import java.util.Objects;  
 * @opensearch.internal
            throw new IllegalArgumentException("field name is null or empty");  
    public WildcardQueryBuilder caseInsensitive(boolean caseInsensitive) {
        out.writeString(value);
        XContentParser.Token token;  
                            throw new ParsingException(  
                value = parser.text();
import org.opensearch.index.mapper.MappedFieldType;
            && Objects.equals(caseInsensitive, other.caseInsensitive);
 * SPDX-License-Identifier: Apache-2.0
        value = in.readString();  
    @Override
    public WildcardQueryBuilder(StreamInput in) throws IOException {  
                fieldName = parser.currentName();  
                                parser.getTokenLocation(),
            && Objects.equals(rewrite, other.rewrite)  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
    public String value() {  
import java.io.IOException;
        fieldName = in.readString();
        return this.rewrite;
                }  
                    }
        builder.endObject();
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;  
 * not use this file except in compliance with the License.
     * @param fieldName The field name
        return fieldType.wildcardQuery(value, method, caseInsensitive, context);  
    @Override  
        builder.endObject();  
     */
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        }
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.ParseField;  
                return new MatchNoneQueryBuilder();
/*  
import org.apache.lucene.search.MultiTermQuery;  
                            );  
        String queryName = null;
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private final String fieldName;
}  
    protected int doHashCode() {
            throw new IllegalStateException("Rewrite first");
 */
    }
     * Implements the wildcard search query. Supported wildcards are {@code *}, which  
import org.opensearch.core.common.ParsingException;
 * specific language governing permissions and limitations
    public static WildcardQueryBuilder fromXContent(XContentParser parser) throws IOException {
                            queryName = parser.text();
                            boost = parser.floatValue();
 * under the License.  
 * a Wildcard term should not start with one of the wildcards {@code *} or
        }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
                            value = parser.text();  
                            rewrite = parser.textOrNull();  
                if (query instanceof MatchAllDocsQuery) {
                    if (token == XContentParser.Token.FIELD_NAME) {
        printBoostAndQueryName(builder);
        }  
        }
        super(in);
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);  
                            caseInsensitive = parser.booleanValue();
    protected boolean doEquals(WildcardQueryBuilder other) {  
        MappedFieldType fieldType = context.fieldMapper(fieldName);
 * this work for additional information regarding copyright
 *
        builder.startObject(fieldName);  
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
                        }
        MultiTermQuery.RewriteMethod method = QueryParsers.parseRewriteMethod(rewrite, null, LoggingDeprecationHandler.INSTANCE);
    }
    }
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public String getWriteableName() {
    @Override
/*  
                        } else if (VALUE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.rewrite = rewrite;
 */  
        return NAME;  
 * Implements the wildcard search query. Supported wildcards are {@code *}, which  
                currentFieldName = parser.currentName();  
        if (fieldType == null) {
 * matches any character sequence (including the empty one), and {@code ?},
import org.opensearch.core.xcontent.XContentParser;  
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);  
    private final String value;  
    }  
     * needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,  
                        currentFieldName = parser.currentName();  
 * Licensed to Elasticsearch under one or more contributor  
     * @param value The wildcard query string
     *  
    public WildcardQueryBuilder(String fieldName, String value) {
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {
        }
    public boolean caseInsensitive() {  
        out.writeString(fieldName);
 * needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,  
package org.opensearch.index.query;
     * {@code ?}.
        return this.caseInsensitive;
                        } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                // since rewrites might happen on a network thread.  
 * {@code ?}.
 * You may obtain a copy of the License at  
                }
            throw new IllegalArgumentException("value cannot be null");  
    private static final ParseField VALUE_FIELD = new ParseField("value");
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {  
    public WildcardQueryBuilder rewrite(String rewrite) {
                            value = parser.text();
    @Override
        builder.field(WILDCARD_FIELD.getPreferredName(), value);
            .queryName(queryName)
 * KIND, either express or implied.  See the License for the
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
 * GitHub history for details.
                    return new MatchNoneQueryBuilder();
    }
 * this file be licensed under the Apache-2.0 license or a
                } else {  
public class WildcardQueryBuilder extends AbstractQueryBuilder<WildcardQueryBuilder> implements MultiTermQueryBuilder {  
     */  
        return Objects.equals(fieldName, other.fieldName)
    /**
    protected void doWriteTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.Strings;
import org.opensearch.core.xcontent.XContentBuilder;
    }
    private String rewrite;
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;  
        }  
            } else {
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    } else {
        String value = null;
            } else if (token == XContentParser.Token.START_OBJECT) {
import org.opensearch.index.mapper.ConstantFieldType;
 * Unless required by applicable law or agreed to in writing,
                        } else {
            }
    }
        return new WildcardQueryBuilder(fieldName, value).rewrite(rewrite)
 * The OpenSearch Contributors require contributions made to  
    }
        if (value == null) {
        return super.doRewrite(queryRewriteContext);  
     * which matches any single character. Note this query can be slow, as it
import org.apache.lucene.search.MatchNoDocsQuery;
        }
                Query query = fieldType.wildcardQuery(value, null, caseInsensitive, context); // the rewrite method doesn't matter
 *
            .boost(boost)  
    }
    /**  
     * matches any character sequence (including the empty one), and {@code ?},
    public String rewrite() {  
    }  
