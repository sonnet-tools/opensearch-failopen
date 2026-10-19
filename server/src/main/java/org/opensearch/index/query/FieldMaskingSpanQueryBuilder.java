    /**
        queryBuilder = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
            } else {
    public FieldMaskingSpanQueryBuilder(StreamInput in) throws IOException {
                            parser.getTokenLocation(),
        if (fieldType != null) {
    }
    private static final ParseField QUERY_FIELD = new ParseField("query");
 */
     * Constructs a new {@link FieldMaskingSpanQueryBuilder} given an inner {@link SpanQueryBuilder} for
    public static FieldMaskingSpanQueryBuilder fromXContent(XContentParser parser) throws IOException {
    public String getWriteableName() {
        builder.startObject(SPAN_FIELD_MASKING_FIELD.getPreferredName());
                    throw new ParsingException(
    public SpanQueryBuilder innerQuery() {
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.ParsingException;
        return this.queryBuilder;
        super(in);
                    boost = parser.floatValue();
import org.apache.lucene.search.BooleanClause;
        this.fieldName = fieldName;
import org.opensearch.core.common.Strings;
                    throw new ParsingException(
    @Override
 * this file be licensed under the Apache-2.0 license or a
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
}
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(queryBuilder);
 */
                SPAN_FIELD_MASKING_FIELD.getPreferredName() + " must have [field] set for it"
                    field = parser.text();
        builder.field(FIELD_FIELD.getPreferredName(), fieldName);
            );
        builder.field(QUERY_FIELD.getPreferredName());
        return SPAN_FIELD_MASKING_FIELD.getPreferredName();
                        );
                }
/*
            if (token == XContentParser.Token.FIELD_NAME) {
    /**
        SpanQueryBuilder,
                currentFieldName = parser.currentName();
     */
     */
        }
        }
package org.opensearch.index.query;
import org.opensearch.core.xcontent.XContentBuilder;
import org.apache.lucene.search.Query;
    }
            throw new ParsingException(
                        throw new ParsingException(
    public void visit(QueryBuilderVisitor visitor) {
                    inner = spanQuery;
                } else {
    public FieldMaskingSpanQueryBuilder(SpanQueryBuilder queryBuilder, String fieldName) {
        printBoostAndQueryName(builder);
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        parser.getTokenLocation(),
 * Query builder for field masking span query
import org.opensearch.core.xcontent.XContentParser;
    }
                }
        if (inner == null) {
        if (Strings.isEmpty(fieldName)) {
     * Read from a stream.
        assert innerQuery instanceof SpanQuery;
    private final SpanQueryBuilder queryBuilder;
            fieldInQuery = fieldType.name();
        WithFieldName {
        out.writeString(fieldName);
            }
 * @opensearch.internal
 *
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Objects.hash(queryBuilder, fieldName);
        queryBuilder.boost(boost);
    protected boolean doEquals(FieldMaskingSpanQueryBuilder other) {
            throw new IllegalArgumentException("field name is null or empty");
    implements
 * Licensed to Elasticsearch under one or more contributor
    private final String fieldName;
        queryBuilder.queryName(queryName);
        return queryBuilder;
 * GitHub history for details.
    protected void doWriteTo(StreamOutput out) throws IOException {
                    SpanQueryBuilderUtil.checkNoBoost(SPAN_FIELD_MASKING_FIELD.getPreferredName(), currentFieldName, parser, inner);
     */
        if (queryBuilder == null) {
 *
/**
                    QueryBuilder query = parseInnerQueryBuilder(parser);
            throw new IllegalArgumentException("inner clause [query] cannot be null.");
 * compatible open source license.
            throw new ParsingException(
    @Override
        return Objects.equals(queryBuilder, other.queryBuilder) && Objects.equals(fieldName, other.fieldName);
    }
                        parser.getTokenLocation(),
 * Unless required by applicable law or agreed to in writing,
        if (field == null) {
                        "[" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] query does not support [" + currentFieldName + "]"
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
     */
    }
        this.queryBuilder = queryBuilder;
    }
import org.opensearch.index.mapper.MappedFieldType;
            } else if (token == XContentParser.Token.START_OBJECT) {
                            "[" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] query must be of type span query"
 */
                        "[" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] query does not support [" + currentFieldName + "]"
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        String currentFieldName = null;
public class FieldMaskingSpanQueryBuilder extends AbstractQueryBuilder<FieldMaskingSpanQueryBuilder>
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
 * ownership. Elasticsearch licenses this file to you under
    }
import org.apache.lucene.queries.spans.SpanQuery;
    protected Query doToQuery(QueryShardContext context) throws IOException {
        }
                    }
 *
 * SPDX-License-Identifier: Apache-2.0
                    );
 * The OpenSearch Contributors require contributions made to
import java.io.IOException;
            );
        fieldName = in.readString();
    @Override
 * KIND, either express or implied.  See the License for the
                SPAN_FIELD_MASKING_FIELD.getPreferredName() + " must have [query] span query clause"
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.ParseField;
    /**
    @Override
        String queryName = null;
        FieldMaskingSpanQueryBuilder queryBuilder = new FieldMaskingSpanQueryBuilder(inner, field);
 * under the License.
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.Objects;
 * not use this file except in compliance with the License.
    @Override
        out.writeNamedWriteable(queryBuilder);
    @Override
        return new FieldMaskingSpanQuery((SpanQuery) innerQuery, fieldInQuery);
                    );
        return this.fieldName;
    private static final ParseField FIELD_FIELD = new ParseField("field");
        String field = null;
        builder.endObject();
     * @return the inner {@link QueryBuilder}
                    if (!(query instanceof SpanQueryBuilder spanQuery)) {
     * a given field
    /**
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 */
        }
    public String fieldName() {
     * @param fieldName the field name
 * the Apache License, Version 2.0 (the "License"); you may
    public static final ParseField SPAN_FIELD_MASKING_FIELD = new ParseField(NAME, "field_masking_span");
    }
        queryBuilder.toXContent(builder, params);
 * You may obtain a copy of the License at
    public static final String NAME = "span_field_masking";
     * @return the field name for this query
                parser.getTokenLocation(),
        Query innerQuery = queryBuilder.toQuery(context);
        String fieldInQuery = fieldName;
    @Override
                } else if (FIELD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*
        SpanQueryBuilder inner = null;
     * @param queryBuilder inner {@link SpanQueryBuilder}
    }
 * software distributed under the License is distributed on an
        }
    }
                parser.getTokenLocation(),
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        XContentParser.Token token;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                    queryName = parser.text();
    protected int doHashCode() {
    }
        visitor.accept(this);
/*
 *
import org.opensearch.core.common.io.stream.StreamInput;
