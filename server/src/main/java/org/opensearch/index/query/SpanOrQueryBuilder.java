 * KIND, either express or implied.  See the License for the
    }
            assert query instanceof SpanQuery;  
 * GitHub history for details.
        for (int i = 0; i < clauses.size(); i++) {
        }
                            throw new ParsingException(parser.getTokenLocation(), "span_or [clauses] must be of type span query");
        }  
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.XContentBuilder;  
import java.util.Objects;
 * this work for additional information regarding copyright
        clauses.add(clause);
    public SpanOrQueryBuilder(SpanQueryBuilder initialClause) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
     */
        visitor.accept(this);
import org.opensearch.core.common.io.stream.StreamOutput;
        String queryName = null;
    }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**  
 * Modifications Copyright OpenSearch Contributors. See
        SpanOrQueryBuilder queryBuilder = new SpanOrQueryBuilder(clauses.get(0));
    }
 * this file be licensed under the Apache-2.0 license or a
        return new SpanOrQuery(spanQueries);  
                    }  
            clauses.add((SpanQueryBuilder) clause);  
public class SpanOrQueryBuilder extends AbstractQueryBuilder<SpanOrQueryBuilder> implements SpanQueryBuilder {
    protected void doWriteTo(StreamOutput out) throws IOException {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
/*  
        List<SpanQueryBuilder> clauses = new ArrayList<>();
            spanQueries[i] = (SpanQuery) query;
        for (int i = 1; i < clauses.size(); i++) {
        writeQueries(out, clauses);  
        if (clauses.isEmpty()) {  
     * @return the {@link SpanQueryBuilder} clauses that were set for this query  
    }
import java.util.ArrayList;
                } else {
        return Collections.unmodifiableList(this.clauses);  
    /**
                    throw new ParsingException(parser.getTokenLocation(), "[span_or] query does not support [" + currentFieldName + "]");
            }  
 * not use this file except in compliance with the License.
                    throw new ParsingException(parser.getTokenLocation(), "[span_or] query does not support [" + currentFieldName + "]");
import java.util.List;  
        }
                if (CLAUSES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        for (QueryBuilder clause : readQueries(in)) {
        clauses.add(initialClause);  
        return NAME;  
        if (clause == null) {
        if (clauses.isEmpty() == false) {  
    protected Query doToQuery(QueryShardContext context) throws IOException {
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        String currentFieldName = null;  
    }
        return Objects.equals(clauses, other.clauses);
 * Span query that matches the union of its clauses. Maps to {@link SpanOrQuery}.  
     */
                }  
    private static final ParseField CLAUSES_FIELD = new ParseField("clauses");
    public String getWriteableName() {
     * Add a span clause to the current list of clauses
     * Read from a stream.
    }
 *
    @Override
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Query;
import org.opensearch.core.xcontent.XContentParser;
            throw new ParsingException(parser.getTokenLocation(), "span_or must include [clauses]");
/*  
 * SPDX-License-Identifier: Apache-2.0
        return this;
            } else if (token == XContentParser.Token.START_ARRAY) {
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public SpanOrQueryBuilder addClause(SpanQueryBuilder clause) {  
                        clauses.add(clause);
    @Override
import org.opensearch.core.common.ParsingException;  
        }
    }
/*
                subVisitor.accept(subQb);  
        SpanQuery[] spanQueries = new SpanQuery[clauses.size()];  
                }
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.SHOULD);
            for (QueryBuilder subQb : this.clauses) {
        return Objects.hash(clauses);
import org.opensearch.core.ParseField;
    public SpanOrQueryBuilder(StreamInput in) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
            } else {
    private final List<SpanQueryBuilder> clauses = new ArrayList<>();  
import java.io.IOException;  
                } else {  
                        QueryBuilder query = parseInnerQueryBuilder(parser);
 */  
import org.apache.lucene.search.BooleanClause;  
    }  
    @Override
    @Override  
        for (SpanQueryBuilder clause : clauses) {
        builder.endArray();
        }  
        queryBuilder.queryName(queryName);  
}
        builder.startObject(NAME);
        queryBuilder.boost(boost);
                        final SpanQueryBuilder clause = (SpanQueryBuilder) query;  
        }
    @Override  
        }
import org.apache.lucene.queries.spans.SpanQuery;
            clause.toXContent(builder, params);
 * under the License.  
    }
    protected int doHashCode() {
 * @opensearch.internal
 */
        printBoostAndQueryName(builder);
        if (initialClause == null) {  
 */  
    }
        super(in);
            throw new IllegalArgumentException("[" + NAME + "] inner clause cannot be null");
    public void visit(QueryBuilderVisitor visitor) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * ownership. Elasticsearch licenses this file to you under  
        return queryBuilder;
        }
            if (token == XContentParser.Token.FIELD_NAME) {  
                        }
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;  
 * Licensed to Elasticsearch under one or more contributor  
        XContentParser.Token token;
 * specific language governing permissions and limitations
 *  
                    boost = parser.floatValue();  
 * software distributed under the License is distributed on an
        builder.startArray(CLAUSES_FIELD.getPreferredName());  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.queries.spans.SpanOrQuery;
                currentFieldName = parser.currentName();
    public static final String NAME = "span_or";
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
    @Override  
                        checkNoBoost(NAME, currentFieldName, parser, clause);
    public List<SpanQueryBuilder> clauses() {
    protected boolean doEquals(SpanOrQueryBuilder other) {  
            Query query = clauses.get(i).toQuery(context);
            queryBuilder.addClause(clauses.get(i));  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.query;
    @Override
                        if (query instanceof SpanQueryBuilder == false) {  
            }
 * license agreements. See the NOTICE file distributed with
        }
                    queryName = parser.text();
/**
            throw new IllegalArgumentException("[" + NAME + "] must include at least one clause");
import java.util.Collections;
 *
 */  
    public static SpanOrQueryBuilder fromXContent(XContentParser parser) throws IOException {  
        builder.endObject();  
    }  
