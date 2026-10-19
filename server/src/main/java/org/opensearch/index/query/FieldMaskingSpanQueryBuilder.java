            );
        return this.queryBuilder;  
        String currentFieldName = null;
        builder.startObject(SPAN_FIELD_MASKING_FIELD.getPreferredName());
 * software distributed under the License is distributed on an
                parser.getTokenLocation(),
    /**  
        builder.endObject();
        }
import org.opensearch.index.mapper.MappedFieldType;  
                    }  
/*  
        return Objects.hash(queryBuilder, fieldName);  
        MappedFieldType fieldType = context.fieldMapper(fieldName);
    public static FieldMaskingSpanQueryBuilder fromXContent(XContentParser parser) throws IOException {
    public FieldMaskingSpanQueryBuilder(StreamInput in) throws IOException {  
            } else {  
/*  
    public FieldMaskingSpanQueryBuilder(SpanQueryBuilder queryBuilder, String fieldName) {
    public void visit(QueryBuilderVisitor visitor) {
    @Override
public class FieldMaskingSpanQueryBuilder extends AbstractQueryBuilder<FieldMaskingSpanQueryBuilder>
    }
 *
    @Override  
        }
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
        String queryName = null;  
    @Override  
        if (inner == null) {  
 *
            }
    /**
     * Read from a stream.
    /**
import org.opensearch.core.xcontent.XContentParser;
        fieldName = in.readString();  
        Query innerQuery = queryBuilder.toQuery(context);
        out.writeString(fieldName);  
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * a given field  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * GitHub history for details.
import org.apache.lucene.queries.spans.SpanQuery;
        super(in);
        out.writeNamedWriteable(queryBuilder);
    public static final ParseField SPAN_FIELD_MASKING_FIELD = new ParseField(NAME, "field_masking_span");
import org.opensearch.core.ParseField;
    protected boolean doEquals(FieldMaskingSpanQueryBuilder other) {
                    throw new ParsingException(
        WithFieldName {
import org.opensearch.core.common.io.stream.StreamOutput;  
    public SpanQueryBuilder innerQuery() {
                SPAN_FIELD_MASKING_FIELD.getPreferredName() + " must have [query] span query clause"  
                        throw new ParsingException(
                    );
 * @opensearch.internal
    @Override  
 * this file be licensed under the Apache-2.0 license or a
}  
    private final String fieldName;
                }  
        }
        }
            if (token == XContentParser.Token.FIELD_NAME) {
    private static final ParseField FIELD_FIELD = new ParseField("field");  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    @Override
 * KIND, either express or implied.  See the License for the
        if (Strings.isEmpty(fieldName)) {
     * @param queryBuilder inner {@link SpanQueryBuilder}
                    field = parser.text();
        if (fieldType != null) {
 * the Apache License, Version 2.0 (the "License"); you may
        String fieldInQuery = fieldName;  
import java.util.Objects;  
    }
                    boost = parser.floatValue();
                    SpanQueryBuilderUtil.checkNoBoost(SPAN_FIELD_MASKING_FIELD.getPreferredName(), currentFieldName, parser, inner);
                parser.getTokenLocation(),
 */  
        this.fieldName = fieldName;  
 * Licensed to Elasticsearch under one or more contributor  
        return this.fieldName;
    @Override
                SPAN_FIELD_MASKING_FIELD.getPreferredName() + " must have [field] set for it"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        queryBuilder.toXContent(builder, params);
            throw new ParsingException(
                        "[" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] query does not support [" + currentFieldName + "]"
/*
    /**  
                        );
                } else {
        queryBuilder = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
     */
import org.opensearch.core.common.io.stream.StreamInput;
                    QueryBuilder query = parseInnerQueryBuilder(parser);  
 * SPDX-License-Identifier: Apache-2.0
     * @param fieldName the field name
        }
import org.opensearch.core.xcontent.XContentBuilder;
    }
            } else if (token == XContentParser.Token.START_OBJECT) {
    }
                    inner = spanQuery;
        this.queryBuilder = queryBuilder;
    private final SpanQueryBuilder queryBuilder;  
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(queryBuilder);
        assert innerQuery instanceof SpanQuery;  
            );
/**
    }
    private static final ParseField QUERY_FIELD = new ParseField("query");
    public static final String NAME = "span_field_masking";  
import org.opensearch.core.common.Strings;
import org.opensearch.core.common.ParsingException;  
        XContentParser.Token token;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        }
        return SPAN_FIELD_MASKING_FIELD.getPreferredName();
     */
    }
    implements
 * compatible open source license.
    @Override  
            throw new ParsingException(
 */  
     * @return the field name for this query
        builder.field(QUERY_FIELD.getPreferredName());  
                    if (!(query instanceof SpanQueryBuilder spanQuery)) {
 * You may obtain a copy of the License at  
        builder.field(FIELD_FIELD.getPreferredName(), fieldName);
 * Query builder for field masking span query  
                }
 *
            throw new IllegalArgumentException("field name is null or empty");  
        visitor.accept(this);  
 * this work for additional information regarding copyright
    }
                        "[" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] query does not support [" + currentFieldName + "]"  
        queryBuilder.queryName(queryName);  
    public String getWriteableName() {  
                    queryName = parser.text();  
        FieldMaskingSpanQueryBuilder queryBuilder = new FieldMaskingSpanQueryBuilder(inner, field);
        return Objects.equals(queryBuilder, other.queryBuilder) && Objects.equals(fieldName, other.fieldName);
        SpanQueryBuilder,  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * under the License.  
            throw new IllegalArgumentException("inner clause [query] cannot be null.");  
 * The OpenSearch Contributors require contributions made to  
    protected int doHashCode() {
     * @return the inner {@link QueryBuilder}  
        if (field == null) {  
        if (queryBuilder == null) {
            fieldInQuery = fieldType.name();  
 * Unless required by applicable law or agreed to in writing,
                        parser.getTokenLocation(),  
import org.apache.lucene.search.Query;
                    throw new ParsingException(
                } else {  
package org.opensearch.index.query;
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import java.io.IOException;
        SpanQueryBuilder inner = null;
 *  
                currentFieldName = parser.currentName();  
        printBoostAndQueryName(builder);  
    }
        return queryBuilder;
        queryBuilder.boost(boost);
 * specific language governing permissions and limitations
     * Constructs a new {@link FieldMaskingSpanQueryBuilder} given an inner {@link SpanQueryBuilder} for
        String field = null;
                        parser.getTokenLocation(),
    protected void doWriteTo(StreamOutput out) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
                } else if (FIELD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public String fieldName() {
                            "[" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] query must be of type span query"
    }  
     */  
                    );
                            parser.getTokenLocation(),  
     */
    }
 */
 * not use this file except in compliance with the License.
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.apache.lucene.search.BooleanClause;  
    }  
        return new FieldMaskingSpanQuery((SpanQuery) innerQuery, fieldInQuery);
