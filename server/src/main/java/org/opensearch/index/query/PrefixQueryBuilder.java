                } else {  
                            value = parser.textOrNull();
        MappedFieldType fieldType = context.fieldMapper(fieldName);
                fieldName = currentFieldName;
    protected boolean doEquals(PrefixQueryBuilder other) {
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
                // This logic is correct for all field types, but by only applying it to constant
 * A Query that matches documents containing terms with a specified prefix.  
    @Override
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
        if (rewrite != null) {
                    assert false : "Constant fields must produce match-all or match-none queries, got " + query;
        builder.endObject();
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
        if (caseInsensitive != DEFAULT_CASE_INSENSITIVITY) {
 * Licensed to Elasticsearch under one or more contributor  
                    } else {
        return this.caseInsensitive;
                value = parser.textOrNull();
    @Override
 * license agreements. See the NOTICE file distributed with
        String value = null;
import org.opensearch.core.xcontent.XContentParser;  
        printBoostAndQueryName(builder);
                // since rewrites might happen on a network thread.  
                currentFieldName = parser.currentName();  
     * A Query that matches documents containing terms with a specified prefix.  
        out.writeOptionalString(rewrite);
            builder.field(REWRITE_FIELD.getPreferredName(), rewrite);
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
/*
            builder.field(CASE_INSENSITIVE_FIELD.getPreferredName(), caseInsensitive);
                            rewrite = parser.textOrNull();  
        }
    @Override  
                }
     * @param fieldName The name of the field
 * GitHub history for details.
    public String fieldName() {  
/**
            throw new IllegalStateException("Rewrite first");  
    }  
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
 */  
        XContentParser.Token token;  
                return new MatchNoneQueryBuilder();
import java.io.IOException;
                    if (token == XContentParser.Token.FIELD_NAME) {
import org.apache.lucene.search.MultiTermQuery;  
    private static final ParseField PREFIX_FIELD = new ParseField("value");
    private boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
                            queryName = parser.text();  
    /**
        out.writeString(value);  
                // fields we also have the guarantee that it doesn't perform I/O, which is important
    public PrefixQueryBuilder caseInsensitive(boolean caseInsensitive) {
 * compatible open source license.
                            boost = parser.floatValue();
                        } else if (PREFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
                        } else if (CASE_INSENSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;  
        out.writeBoolean(caseInsensitive);
    protected void doWriteTo(StreamOutput out) throws IOException {
        MultiTermQuery.RewriteMethod method = QueryParsers.parseRewriteMethod(rewrite, null, LoggingDeprecationHandler.INSTANCE);
 */  
     */  
        if (value == null) {  
            throw new IllegalArgumentException("value cannot be null");
        builder.field(PREFIX_FIELD.getPreferredName(), this.value);  
 * under the License.  
        String fieldName = null;
        }  
        rewrite = in.readOptionalString();
        return super.doRewrite(queryRewriteContext);  
        return this.rewrite;
    }
    public static final String NAME = "prefix";
    }
                            throw new ParsingException(
        return fieldType.prefixQuery(value, method, caseInsensitive, context);
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.Strings;
    }
        this.rewrite = rewrite;  
 *  
import java.util.Objects;  
            }  
    public static final boolean DEFAULT_CASE_INSENSITIVITY = false;
        value = in.readString();
        String rewrite = null;  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 *
public class PrefixQueryBuilder extends AbstractQueryBuilder<PrefixQueryBuilder> implements MultiTermQueryBuilder {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        builder.startObject(fieldName);
                Query query = fieldType.prefixQuery(value, null, caseInsensitive, context); // the rewrite method doesn't matter
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
    public String getWriteableName() {
        if (context != null) {
    /**
import org.opensearch.index.mapper.MappedFieldType;
 * this work for additional information regarding copyright
                        } else {  
        super(in);
    private final String value;  
 * SPDX-License-Identifier: Apache-2.0
    public PrefixQueryBuilder(StreamInput in) throws IOException {
        }
     */
 * the Apache License, Version 2.0 (the "License"); you may
    }
            throw new IllegalArgumentException("field name is null or empty");
 * Modifications Copyright OpenSearch Contributors. See
                }
        this.value = value;
                fieldName = currentFieldName;  
        caseInsensitive = in.readBoolean();  
import org.opensearch.core.ParseField;  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }
        return this.fieldName;
        builder.endObject();  
    public boolean caseInsensitive() {
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {  
            && Objects.equals(value, other.value)
import org.opensearch.index.mapper.ConstantFieldType;
        String currentFieldName = null;
    @Override
    private String rewrite;  
    }  
                    return new MatchAllQueryBuilder();  
/*  
                            );
import org.opensearch.core.common.ParsingException;
 */
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    public PrefixQueryBuilder rewrite(String rewrite) {
    }
     * Read from a stream.
            } else if (token == XContentParser.Token.START_OBJECT) {
 * You may obtain a copy of the License at  
        out.writeString(fieldName);
 * not use this file except in compliance with the License.
        return NAME;
    public PrefixQueryBuilder(String fieldName, String value) {
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    @Override
 */  
        }
package org.opensearch.index.query;
                if (query instanceof MatchAllDocsQuery) {
}
    @Override  
            if (token == XContentParser.Token.FIELD_NAME) {
    }
        this.fieldName = fieldName;  
            }  
        return Objects.equals(fieldName, other.fieldName)  
        this.caseInsensitive = caseInsensitive;  
 *
                        currentFieldName = parser.currentName();  
        return Objects.hash(fieldName, value, rewrite, caseInsensitive);
                                "[prefix] query does not support [" + currentFieldName + "]"  
 * Unless required by applicable law or agreed to in writing,
    private final String fieldName;
        if (Strings.isEmpty(fieldName)) {  
    protected final int doHashCode() {  
                        }
    }  
 * KIND, either express or implied.  See the License for the
        fieldName = in.readString();  
    }  
        QueryShardContext context = queryRewriteContext.convertToShardContext();
        }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    }  
    }  
                } else if (query instanceof MatchNoDocsQuery) {
    public String rewrite() {
/*  
            if (fieldType == null) {
        builder.startObject(NAME);
        }
            && Objects.equals(caseInsensitive, other.caseInsensitive);  
        return new PrefixQueryBuilder(fieldName, value).rewrite(rewrite).boost(boost).queryName(queryName).caseInsensitive(caseInsensitive);  
            } else if (fieldType.unwrap() instanceof ConstantFieldType) {  
        boolean caseInsensitive = DEFAULT_CASE_INSENSITIVITY;
import org.apache.lucene.search.MatchNoDocsQuery;
     *
import org.opensearch.index.query.support.QueryParsers;  
        }
    private static final ParseField CASE_INSENSITIVE_FIELD = new ParseField("case_insensitive");  
    public String value() {
 *
    public void doXContent(XContentBuilder builder, Params params) throws IOException {  
    @Override
        return this;
                        if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            MappedFieldType fieldType = context.fieldMapper(this.fieldName);  
        return this.value;
                        } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            caseInsensitive = parser.booleanValue();
     * @param value The prefix query  
    }
        if (fieldType == null) {
                                parser.getTokenLocation(),
                    return new MatchNoneQueryBuilder();
        String queryName = null;
    }  
            } else {
 * @opensearch.internal
            && Objects.equals(rewrite, other.rewrite)
        return this;
    public static PrefixQueryBuilder fromXContent(XContentParser parser) throws IOException {  
