     * Read from a stream.
            return NAME;
                throw new ParsingException(
        String spanNearFieldName = null;
            clause.toXContent(builder, params);
     */
    }
        for (int i = 1; i < clauses.size(); i++) {
    }
import java.io.IOException;
                        clauses.add(clause);
                } else if (token.isValue()) {
     */
                if (token == XContentParser.Token.FIELD_NAME) {
    public static int DEFAULT_SLOP = 0;
 */
     */
            return Objects.hash(getClass(), fieldName, width);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
    }
        }
                }
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    fieldName = currentFieldName;
                }
        }
    /**
        /**
        public String fieldName() {
            builder.addClause((SpanQuery) query);
    public int slop() {
            }
            assert query instanceof SpanQuery;
     */
         * unordered SpanNearQuery. Should OpenSearch have the same checks or wrap those thrown exceptions?
        this.inOrder = inOrder;
            int width = 0;
    }
            if (isGap) {
    protected int doHashCode() {
import org.opensearch.core.common.io.stream.StreamInput;
         */
        public String getWriteableName() {
     */
        if (!isGap) {
        }
        public String queryName() {
        }
 * specific language governing permissions and limitations
            spanNearFieldName = queryFieldName(context, fieldName);
                assert query instanceof SpanQuery;
import org.opensearch.core.common.io.stream.StreamOutput;
            builder.addGap(gap);
    private static final ParseField IN_ORDER_FIELD = new ParseField("in_order");
            return fieldName;
    }
            String processedFieldName,
        out.writeVInt(slop);
            } else {
/*
     * be used to generate a Query (SpanGapQuery) like another QueryBuilder.
        } else {
        @Override
 * compatible open source license.
            } else if (token.isValue()) {
import org.opensearch.index.mapper.MappedFieldType;
        for (SpanQueryBuilder clause : clauses) {
        return Collections.unmodifiableList(this.clauses);
import java.util.List;
    }
        @Override
public class SpanNearQueryBuilder extends AbstractQueryBuilder<SpanNearQueryBuilder> implements SpanQueryBuilder {
        }
 *
        ) {
            width = in.readInt();
                        + "] query doesn't support multiple fields, found ["
                        + "] and ["
        if (clauses.size() == 1) {
            throw new UnsupportedOperationException();
import org.opensearch.core.common.Strings;
    }
        int slop = DEFAULT_SLOP;
        builder.startArray(CLAUSES_FIELD.getPreferredName());
        public QueryBuilder boost(float boost) {
    @Override
    public SpanNearQueryBuilder inOrder(boolean inOrder) {
            throw new UnsupportedOperationException();
            return Objects.equals(fieldName, other.fieldName) && Objects.equals(width, other.width);
            if (this == obj) {
        return fieldType != null ? fieldType.name() : fieldName;
     * Add a span clause to the current list of clauses
        /** Width of the gap introduced. */
        return Objects.equals(clauses, other.clauses) && Objects.equals(slop, other.slop) && Objects.equals(inOrder, other.inOrder);
    }
import java.util.Objects;
                        + "]"
import org.opensearch.core.xcontent.MediaTypeRegistry;
        public String getName() {
        SpanNearQueryBuilder queryBuilder = new SpanNearQueryBuilder(clauses.get(0), slop);
import org.opensearch.core.xcontent.XContentParser;
     * Instead, it just identifies a span_gap clause so that SpanNearQuery.addGap(int)
        private final String fieldName;
        }
    public boolean supportsIntraSegmentSearch() {
        public Query toQuery(QueryShardContext context) throws IOException {
            throw new UnsupportedOperationException();
            } else {
            }
        queryBuilder.queryName(queryName);
                    }
        return Objects.hash(clauses, slop, inOrder);
                    inOrder = parser.booleanValue();
        for (int i = 1; i < clauses.size(); i++) {
 */
    @Override
        writeQueries(out, clauses);
 * under the License.
    @Override
            return result;
    public SpanNearQueryBuilder(SpanQueryBuilder initialClause, int slop) {
        slop = in.readVInt();
            // to-do : find if theoretically it makes sense to apply restrictions.
     * yet to enforce this restriction.
            String fieldName = null;
        boolean isGap = queryBuilder instanceof SpanGapQueryBuilder;
            throw new UnsupportedOperationException();
            assert !isGap;
    @Override
     * @return the maximum number of intervening unmatched positions permitted
        }
 * SPDX-License-Identifier: Apache-2.0
            out.writeString(fieldName);
            queryBuilder.addClause(clauses.get(i));
            XContentParser.Token token;
        }
            return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
         * @return fieldName  The name of the field
     * Defaults to <code>true</code>
                } else {
 * Licensed to Elasticsearch under one or more contributor
        boolean inOrder = DEFAULT_IN_ORDER;
                    currentFieldName = parser.currentName();
        builder.endArray();
    public List<SpanQueryBuilder> clauses() {
         */
                    width = parser.intValue();
 * GitHub history for details.
        if (initialClause == null) {
        return true;
        @Override
                    throw new IllegalArgumentException("[span_near] clauses must have same field");
        }
            this.width = width;
            String queryName,
            throw new UnsupportedOperationException();
            throw new ParsingException(parser.getTokenLocation(), "span_near must include [clauses]");
    }
        queryBuilder.inOrder(inOrder);
            String fieldName = ((SpanGapQueryBuilder) queryBuilder).fieldName();
         * @param fieldName  The name of the field
        builder.field(IN_ORDER_FIELD.getPreferredName(), inOrder);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        public final String toString() {
         */
 * this work for additional information regarding copyright
        protected static void throwParsingExceptionOnMultipleFields(
        visitor.accept(this);
    }
        }
                        final SpanQueryBuilder clause = (SpanQueryBuilder) query;
        SpanNearQuery.Builder builder = new SpanNearQuery.Builder(spanNearFieldName, inOrder);
            }
 * of intervening unmatched positions, as well as whether matches are required to be in-order.
    private boolean inOrder = DEFAULT_IN_ORDER;
         *
    protected void doWriteTo(StreamOutput out) throws IOException {
        @Override
     *
        public final void writeTo(StreamOutput out) throws IOException {
        /**
import org.opensearch.core.xcontent.XContentBuilder;
 * The span near query maps to Lucene {@link SpanNearQuery}.
        /**
        }
                int gap = ((SpanGapQueryBuilder) queryBuilder).width();
            query = queryBuilder.toQuery(context);
        SpanQueryBuilder queryBuilder = clauses.get(0);
        public SpanGapQueryBuilder(String fieldName, int width) {
        queryBuilder.boost(boost);
        @Override
            throw new IllegalArgumentException("[" + NAME + "] must include at least one clause");
         */
    public void visit(QueryBuilderVisitor visitor) {
            if (processedFieldName != null) {
                    throw new ParsingException(parser.getTokenLocation(), "[span_near] query does not support [" + currentFieldName + "]");
 * not use this file except in compliance with the License.
            throw new UnsupportedOperationException("You can't add a filter to a SpanGapQueryBuilder");
                        + processedFieldName
        if (isGap) {
    @Override
                        checkNoBoost(NAME, currentFieldName, parser, clause);
                    throw new ParsingException(parser.getTokenLocation(), "[span_near] query does not support [" + currentFieldName + "]");
         * @return width The width of the gap introduced
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.MUST);
    @Override
        return NAME;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    public static class SpanGapQueryBuilder implements SpanQueryBuilder, WithFieldName {
        private final int width;
        } else {
    /**
    private final List<SpanQueryBuilder> clauses = new ArrayList<>();
        @Override
            builder.startObject(getName());
        public final boolean equals(Object obj) {
                    throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
        this.slop = slop;
                String spanGapFieldName = queryFieldName(context, fieldName);
        builder.startObject(NAME);
        public QueryBuilder filter(QueryBuilder filter) {
            int gap = ((SpanGapQueryBuilder) queryBuilder).width();
                builder.addClause((SpanQuery) query);
            queryBuilder = clauses.get(i);
        }
                subVisitor.accept(subQb);
                } else {
     * @param initialClause an initial span query clause
                throw new IllegalArgumentException("[span_gap] field name is null or empty");
        return this.slop;
        inOrder = in.readBoolean();
    protected boolean doEquals(SpanNearQueryBuilder other) {
     * This QueryBuilder is only applicable as a clause in SpanGapQueryBuilder but
        }
        }
        if (this.clauses.isEmpty() == false) {
 *
        }
        printBoostAndQueryName(builder);
         * @param width The width of the gap introduced
 *
        this.clauses.add(initialClause);
    private String queryFieldName(QueryShardContext context, String fieldName) {
    public static final String NAME = "span_near";
            SpanGapQueryBuilder other = (SpanGapQueryBuilder) obj;
/**
        if (clause == null) {
        public final int hashCode() {
     * @see SpanNearQueryBuilder#inOrder(boolean)
            builder.endObject();
                throw new ParsingException(parser.getTokenLocation(), "[span_near] query does not support [" + currentFieldName + "]");
                } else if (SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public String getWriteableName() {
    public static SpanNearQueryBuilder fromXContent(XContentParser parser) throws IOException {
                    slop = parser.intValue();
    /**
        // copied from AbstractQueryBuilder
    public boolean inOrder() {
        @Override
            }
                if (!spanNearFieldName.equals(spanGapFieldName)) {
            for (QueryBuilder subQb : this.clauses) {
    /** Default for flag controlling whether matches are required to be in-order */
     * must be in the same order as in <code>clauses</code> and must be non-overlapping.
import org.apache.lucene.queries.spans.SpanNearQuery;
    }
        }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.XContentLocation;
package org.opensearch.index.query;
        String queryName = null;
    protected Query doToQuery(QueryShardContext context) throws IOException {
        super(in);
        public float boost() {
    }
        }
 * software distributed under the License is distributed on an
        }
        String currentFieldName = null;
                builder.addGap(gap);
    }
         * Read from a stream.
            return width;
import org.apache.lucene.search.BooleanClause;
        @Override
 * The OpenSearch Contributors require contributions made to
            SpanGapQueryBuilder result = new SpanGapQueryBuilder(fieldName, width);
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
     * @return the {@link SpanQueryBuilder} clauses that were set for this query
            fieldName = in.readString();
        clauses.add(clause);
 */
     */
            this.clauses.add((SpanQueryBuilder) clause);
        public int width() {
        }
         * Lucene SpanNearQuery throws exceptions for certain use cases like adding gap to a
            // lucene has not coded any restriction on value of width.
 */
 * KIND, either express or implied.  See the License for the
        return this;
        for (QueryBuilder clause : readQueries(in)) {
     * SpanGapQueryBuilder enables gaps in a SpanNearQuery.
            if (obj == null || getClass() != obj.getClass()) {
     * can be invoked for it.
    private static final ParseField SLOP_FIELD = new ParseField("slop");
    /**
                if (IN_ORDER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
            }
    @Override
        List<SpanQueryBuilder> clauses = new ArrayList<>();
                    "["
                return true;
        builder.field(SLOP_FIELD.getPreferredName(), slop);
        XContentParser.Token token;
        }
        Query query = null;
            if (token == XContentParser.Token.FIELD_NAME) {
    }
        public SpanGapQueryBuilder(StreamInput in) throws IOException {
    public static boolean DEFAULT_IN_ORDER = true;
        return this.inOrder;
        }
        }
            String currentFieldName = null;
            return NAME;
                );
    }
    }
    @Override
    public SpanNearQueryBuilder addClause(SpanQueryBuilder clause) {
        /** Name of field to match against. */
            }
import org.opensearch.core.ParseField;
        /**
        @Override
        }
            return builder;
        public QueryBuilder queryName(String queryName) {
        }
                        if (query instanceof SpanQueryBuilder == false) {
                        + currentFieldName
        return this;
                }
        return builder.build();
                            throw new ParsingException(parser.getTokenLocation(), "span_near [clauses] must be of type span query");
                return false;
            String currentFieldName
        public static SpanGapQueryBuilder fromXContent(XContentParser parser) throws IOException {
            return query;
            throw new IllegalArgumentException("[" + NAME + "]  clauses cannot be null");
 * Modifications Copyright OpenSearch Contributors. See
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private static final ParseField CLAUSES_FIELD = new ParseField("clauses");
 * Matches spans which are near one another. One can specify slop, the maximum number
                String fieldName = ((SpanGapQueryBuilder) queryBuilder).fieldName();
     */
        if (isGap) {
            XContentLocation contentLocation,
            builder.endObject();
        MappedFieldType fieldType = context.fieldMapper(fieldName);
 * Unless required by applicable law or agreed to in writing,
        @Override
    /** Default slop value, this is the same that lucene {@link SpanNearQuery} uses if no slop is provided */
        builder.endObject();
     * When <code>inOrder</code> is true, the spans from each clause
        }
    private final int slop;
            isGap = queryBuilder instanceof SpanGapQueryBuilder;
    /**
                }
    /**
            }
        out.writeBoolean(inOrder);
import java.util.Collections;
            if (Strings.isEmpty(fieldName)) {
         */
                    queryName = parser.text();
     * Since, SpanGapQuery is private to SpanNearQuery, SpanGapQueryBuilder cannot
            }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                if (CLAUSES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * this file be licensed under the Apache-2.0 license or a
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
import org.opensearch.core.common.ParsingException;
                    boost = parser.floatValue();
                        QueryBuilder query = parseInnerQueryBuilder(parser);
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.setSlop(slop);
        if (clauses.isEmpty()) {
                query = clauses.get(i).toQuery(context);
        @Override
    public SpanNearQueryBuilder(StreamInput in) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        /*
 *
            this.fieldName = fieldName;
                currentFieldName = parser.currentName();
    /**
 * @opensearch.internal
                    contentLocation,
            builder.startObject();
        }
                        }
    }
    /**
     * @opensearch.internal
            out.writeInt(width);
        }
import org.apache.lucene.queries.spans.SpanQuery;
            builder.field(fieldName, width);
/*
     * @param slop controls the maximum number of intervening unmatched positions permitted
    }
        @Override
        }
            spanNearFieldName = ((SpanQuery) query).getField();
        public static final String NAME = "span_gap";
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
                        + queryName
import java.util.ArrayList;
            } else if (token == XContentParser.Token.START_ARRAY) {
}
        @Override
        }
import org.apache.lucene.search.Query;
        return queryBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        }
        }
         * Constructs a new SpanGapQueryBuilder term query.
