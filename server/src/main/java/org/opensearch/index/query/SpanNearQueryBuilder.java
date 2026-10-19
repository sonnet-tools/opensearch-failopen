    }
    /**  
 */
        /**
        // copied from AbstractQueryBuilder
        int slop = DEFAULT_SLOP;  
        }
    public SpanNearQueryBuilder(SpanQueryBuilder initialClause, int slop) {
                currentFieldName = parser.currentName();
     * Since, SpanGapQuery is private to SpanNearQuery, SpanGapQueryBuilder cannot
         * Read from a stream.
                    fieldName = currentFieldName;
    public static SpanNearQueryBuilder fromXContent(XContentParser parser) throws IOException {
        @Override
     * @return the {@link SpanQueryBuilder} clauses that were set for this query  
        }  
        }  
            SpanGapQueryBuilder result = new SpanGapQueryBuilder(fieldName, width);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        } else {
    @Override
                        + "] and ["
    public String getWriteableName() {
                    inOrder = parser.booleanValue();  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.Strings;
            return fieldName;
                        + "] query doesn't support multiple fields, found ["
        }
         * @return width The width of the gap introduced
            throw new UnsupportedOperationException();
        }
        writeQueries(out, clauses);  
 * You may obtain a copy of the License at  
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            String fieldName = null;
     */
        if (clause == null) {
            spanNearFieldName = queryFieldName(context, fieldName);  
                if (CLAUSES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
 * Licensed to Elasticsearch under one or more contributor  
public class SpanNearQueryBuilder extends AbstractQueryBuilder<SpanNearQueryBuilder> implements SpanQueryBuilder {
            for (QueryBuilder subQb : this.clauses) {
        queryBuilder.queryName(queryName);
    /**
     * Defaults to <code>true</code>  
            return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 * compatible open source license.
                    }  
    @Override
        return builder.build();  
                        + processedFieldName  
        public String queryName() {
 * under the License.  
        XContentParser.Token token;
            }
        List<SpanQueryBuilder> clauses = new ArrayList<>();
        }
    @Override
        @Override
        @Override
                        }
                        final SpanQueryBuilder clause = (SpanQueryBuilder) query;  
 * this work for additional information regarding copyright
                throw new IllegalArgumentException("[span_gap] field name is null or empty");
            // to-do : find if theoretically it makes sense to apply restrictions.
        return this;
            }  
        @Override  
        @Override
            if (processedFieldName != null) {  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
     * be used to generate a Query (SpanGapQuery) like another QueryBuilder.  
        public String getWriteableName() {
            out.writeInt(width);  
        boolean isGap = queryBuilder instanceof SpanGapQueryBuilder;
    }
        }
    /** Default for flag controlling whether matches are required to be in-order */
        public final boolean equals(Object obj) {
         * @param width The width of the gap introduced  
            builder.field(fieldName, width);
     * yet to enforce this restriction.
                    queryName = parser.text();  
        public final void writeTo(StreamOutput out) throws IOException {
                int gap = ((SpanGapQueryBuilder) queryBuilder).width();
        builder.endArray();  
            return NAME;
    protected Query doToQuery(QueryShardContext context) throws IOException {  
        }  
                        + currentFieldName
            builder.addClause((SpanQuery) query);  
package org.opensearch.index.query;
                } else {
     */
        }  
        public QueryBuilder boost(float boost) {
            if (this == obj) {  
                } else if (token.isValue()) {
            return width;
    public int slop() {
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    "["  
            } else if (token == XContentParser.Token.START_ARRAY) {
    @Override  
     */
 * KIND, either express or implied.  See the License for the
            SpanGapQueryBuilder other = (SpanGapQueryBuilder) obj;  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
        queryBuilder.boost(boost);  
    }  
 */  
        String spanNearFieldName = null;  
            this.fieldName = fieldName;
                String fieldName = ((SpanGapQueryBuilder) queryBuilder).fieldName();
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    /**
        inOrder = in.readBoolean();
    public SpanNearQueryBuilder inOrder(boolean inOrder) {
    public SpanNearQueryBuilder addClause(SpanQueryBuilder clause) {  
        @Override  
                    boost = parser.floatValue();
    /**
        printBoostAndQueryName(builder);  
     * SpanGapQueryBuilder enables gaps in a SpanNearQuery.
import org.opensearch.core.xcontent.XContentBuilder;
                        + "]"  
     * @see SpanNearQueryBuilder#inOrder(boolean)
        public final String toString() {
            String currentFieldName = null;
     * Read from a stream.
        }
    /**  
        for (SpanQueryBuilder clause : clauses) {  
        if (isGap) {
        return true;  
                } else if (SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    width = parser.intValue();  
            throw new ParsingException(parser.getTokenLocation(), "span_near must include [clauses]");
        boolean inOrder = DEFAULT_IN_ORDER;
import java.util.ArrayList;
        @Override
    public static boolean DEFAULT_IN_ORDER = true;
            XContentParser.Token token;
                );
}
            this.clauses.add((SpanQueryBuilder) clause);
 *
        @Override  
    private final int slop;  
            if (Strings.isEmpty(fieldName)) {  
        }  
     */  
         * unordered SpanNearQuery. Should OpenSearch have the same checks or wrap those thrown exceptions?  
            builder.addGap(gap);
         */  
        }
 * @opensearch.internal
    /**
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
        /**  
    public SpanNearQueryBuilder(StreamInput in) throws IOException {
    /** Default slop value, this is the same that lucene {@link SpanNearQuery} uses if no slop is provided */  
                }  
        @Override
 * this file be licensed under the Apache-2.0 license or a
                    throw new ParsingException(parser.getTokenLocation(), "[span_near] query does not support [" + currentFieldName + "]");
        /**
 * of intervening unmatched positions, as well as whether matches are required to be in-order.
                        + queryName
import org.opensearch.core.common.ParsingException;  
     * @param slop controls the maximum number of intervening unmatched positions permitted  
    @Override
    private static final ParseField CLAUSES_FIELD = new ParseField("clauses");
        }
        public float boost() {
        public String fieldName() {  
import org.opensearch.core.xcontent.XContentLocation;  
        public static SpanGapQueryBuilder fromXContent(XContentParser parser) throws IOException {
    protected int doHashCode() {  
        }
    }
                        checkNoBoost(NAME, currentFieldName, parser, clause);
        @Override
        } else {
    private static final ParseField IN_ORDER_FIELD = new ParseField("in_order");
                return true;
                    currentFieldName = parser.currentName();
        builder.setSlop(slop);  
        public QueryBuilder filter(QueryBuilder filter) {
            width = in.readInt();
                    contentLocation,
    }  
import java.util.Objects;
    @Override
        /**
                } else {
                String spanGapFieldName = queryFieldName(context, fieldName);
        @Override  
            throw new UnsupportedOperationException();
        }
                throw new ParsingException(
            throw new IllegalArgumentException("[" + NAME + "] must include at least one clause");
    }  
            spanNearFieldName = ((SpanQuery) query).getField();
        Query query = null;  
    }
import java.util.Collections;  
        }
 */  
            return Objects.hash(getClass(), fieldName, width);  
    private static final ParseField SLOP_FIELD = new ParseField("slop");  
        this.inOrder = inOrder;  
            } else {
     * @return the maximum number of intervening unmatched positions permitted  
    }
            // lucene has not coded any restriction on value of width.  
/*  
                if (IN_ORDER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*  
        builder.endObject();
        /*
        if (!isGap) {
        public SpanGapQueryBuilder(String fieldName, int width) {
    }  
    protected boolean doEquals(SpanNearQueryBuilder other) {
                        QueryBuilder query = parseInnerQueryBuilder(parser);
            builder.startObject();
    public static int DEFAULT_SLOP = 0;
                subVisitor.accept(subQb);
                builder.addClause((SpanQuery) query);  
            builder.endObject();  
                }  
/**  
                        clauses.add(clause);
        queryBuilder.inOrder(inOrder);
    }  
                }  
        return NAME;
    }
    public static final String NAME = "span_near";
            fieldName = in.readString();
        return this;
                throw new ParsingException(parser.getTokenLocation(), "[span_near] query does not support [" + currentFieldName + "]");
    }
            int gap = ((SpanGapQueryBuilder) queryBuilder).width();  
            return result;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            throw new UnsupportedOperationException();
 * The OpenSearch Contributors require contributions made to  
                if (!spanNearFieldName.equals(spanGapFieldName)) {
                    slop = parser.intValue();
        if (isGap) {
    }  
                    throw new IllegalArgumentException("[span_near] clauses must have same field");
    private String queryFieldName(QueryShardContext context, String fieldName) {  
        public QueryBuilder queryName(String queryName) {  
        }  
        return Collections.unmodifiableList(this.clauses);  
        @Override
        private final String fieldName;  
            throw new UnsupportedOperationException("You can't add a filter to a SpanGapQueryBuilder");  
        }
        }
            this.width = width;  
        builder.field(SLOP_FIELD.getPreferredName(), slop);
    }
            isGap = queryBuilder instanceof SpanGapQueryBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;  
 *  
         */
                    throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);  
        public static final String NAME = "span_gap";  
 * The span near query maps to Lucene {@link SpanNearQuery}.  
import org.apache.lucene.search.BooleanClause;  
                if (token == XContentParser.Token.FIELD_NAME) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (initialClause == null) {  
 * license agreements. See the NOTICE file distributed with
    @Override
            String queryName,
                builder.addGap(gap);
            }
                query = clauses.get(i).toQuery(context);
            assert query instanceof SpanQuery;  
        /** Name of field to match against. */
        SpanNearQueryBuilder queryBuilder = new SpanNearQueryBuilder(clauses.get(0), slop);
    /**
            String fieldName = ((SpanGapQueryBuilder) queryBuilder).fieldName();
    private boolean inOrder = DEFAULT_IN_ORDER;
        private final int width;  
     * can be invoked for it.
     * Add a span clause to the current list of clauses
import org.opensearch.core.ParseField;
 *
         *
 * Modifications Copyright OpenSearch Contributors. See
            return query;
            builder.startObject(getName());  
        this.slop = slop;
            if (obj == null || getClass() != obj.getClass()) {  
        builder.startObject(NAME);
import org.apache.lucene.queries.spans.SpanQuery;
        }
        slop = in.readVInt();  
        MappedFieldType fieldType = context.fieldMapper(fieldName);
     */
         * @param fieldName  The name of the field
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
            return Objects.equals(fieldName, other.fieldName) && Objects.equals(width, other.width);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * This QueryBuilder is only applicable as a clause in SpanGapQueryBuilder but  
     */
         */
     * @param initialClause an initial span query clause
    public static class SpanGapQueryBuilder implements SpanQueryBuilder, WithFieldName {
        for (int i = 1; i < clauses.size(); i++) {
            query = queryBuilder.toQuery(context);
    }
         * Constructs a new SpanGapQueryBuilder term query.  
     * must be in the same order as in <code>clauses</code> and must be non-overlapping.
        }
        /** Width of the gap introduced. */
import org.opensearch.index.mapper.MappedFieldType;
        if (clauses.size() == 1) {
     * When <code>inOrder</code> is true, the spans from each clause
            if (isGap) {  
        String queryName = null;
         * @return fieldName  The name of the field  
    public boolean supportsIntraSegmentSearch() {
        }
            String processedFieldName,  
        ) {
        }  
            return builder;
        SpanNearQuery.Builder builder = new SpanNearQuery.Builder(spanNearFieldName, inOrder);
            } else if (token.isValue()) {
        for (QueryBuilder clause : readQueries(in)) {  
            String currentFieldName
     * @opensearch.internal  
        protected static void throwParsingExceptionOnMultipleFields(  
            return NAME;  
                return false;
        }
        }
        }
        builder.field(IN_ORDER_FIELD.getPreferredName(), inOrder);
         */
        }
import org.opensearch.core.xcontent.XContentParser;
            throw new UnsupportedOperationException();  
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.MUST);  
                    throw new ParsingException(parser.getTokenLocation(), "[span_near] query does not support [" + currentFieldName + "]");
        return Objects.equals(clauses, other.clauses) && Objects.equals(slop, other.slop) && Objects.equals(inOrder, other.inOrder);  
    @Override
        public Query toQuery(QueryShardContext context) throws IOException {  
        return fieldType != null ? fieldType.name() : fieldName;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            throw new IllegalArgumentException("[" + NAME + "]  clauses cannot be null");
        builder.startArray(CLAUSES_FIELD.getPreferredName());
            out.writeString(fieldName);
import org.apache.lucene.queries.spans.SpanNearQuery;
        this.clauses.add(initialClause);  
        public SpanGapQueryBuilder(StreamInput in) throws IOException {  
        if (this.clauses.isEmpty() == false) {
            queryBuilder = clauses.get(i);
/*
            if (token == XContentParser.Token.FIELD_NAME) {  
            }
    protected void doWriteTo(StreamOutput out) throws IOException {
        return this.slop;  
            queryBuilder.addClause(clauses.get(i));  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            int width = 0;  
        out.writeBoolean(inOrder);
 * not use this file except in compliance with the License.
        }
     */
        return Objects.hash(clauses, slop, inOrder);
 * ownership. Elasticsearch licenses this file to you under  
                assert query instanceof SpanQuery;
     */  
        visitor.accept(this);
        for (int i = 1; i < clauses.size(); i++) {  
                }
        public int width() {
            XContentLocation contentLocation,
            assert !isGap;  
    }
            }
import org.apache.lucene.search.Query;
         * Lucene SpanNearQuery throws exceptions for certain use cases like adding gap to a
    public List<SpanQueryBuilder> clauses() {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Instead, it just identifies a span_gap clause so that SpanNearQuery.addGap(int)
        out.writeVInt(slop);
 * software distributed under the License is distributed on an
    }
        @Override  
    }
     *
 * Unless required by applicable law or agreed to in writing,
    private final List<SpanQueryBuilder> clauses = new ArrayList<>();
            throw new UnsupportedOperationException();
        return queryBuilder;
                            throw new ParsingException(parser.getTokenLocation(), "span_near [clauses] must be of type span query");
         */
        if (clauses.isEmpty()) {  
import java.io.IOException;
    public boolean inOrder() {
 */  
        public String getName() {  
        }  
        }
            }
        super(in);
            builder.endObject();
    public void visit(QueryBuilderVisitor visitor) {  
        SpanQueryBuilder queryBuilder = clauses.get(0);
        clauses.add(clause);
    /**  
 * specific language governing permissions and limitations
 * Matches spans which are near one another. One can specify slop, the maximum number
                        if (query instanceof SpanQueryBuilder == false) {  
        }
            }
        @Override
            }  
        public final int hashCode() {
        String currentFieldName = null;  
        return this.inOrder;
            } else {  
            clause.toXContent(builder, params);
 * GitHub history for details.
