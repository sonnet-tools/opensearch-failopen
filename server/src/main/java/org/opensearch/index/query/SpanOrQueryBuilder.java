        return Collections.unmodifiableList(this.clauses);
    }
    public void visit(QueryBuilderVisitor visitor) {
 * Unless required by applicable law or agreed to in writing,
        super(in);
 */
import org.opensearch.core.common.io.stream.StreamInput;
            Query query = clauses.get(i).toQuery(context);
/**
        String currentFieldName = null;
    }
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
    @Override
import java.io.IOException;
            assert query instanceof SpanQuery;
    }
    }
 * The OpenSearch Contributors require contributions made to
        if (clauses.isEmpty() == false) {
        }
        }
        for (int i = 0; i < clauses.size(); i++) {
 * GitHub history for details.
        builder.endArray();
        if (clauses.isEmpty()) {
                        QueryBuilder query = parseInnerQueryBuilder(parser);
        visitor.accept(this);
        for (int i = 1; i < clauses.size(); i++) {
/*
    }
        }
                            throw new ParsingException(parser.getTokenLocation(), "span_or [clauses] must be of type span query");
                        checkNoBoost(NAME, currentFieldName, parser, clause);
import java.util.Collections;
    private final List<SpanQueryBuilder> clauses = new ArrayList<>();
 * You may obtain a copy of the License at
    protected void doWriteTo(StreamOutput out) throws IOException {
        printBoostAndQueryName(builder);
        for (QueryBuilder clause : readQueries(in)) {
import org.apache.lucene.search.Query;
        if (initialClause == null) {
    public static SpanOrQueryBuilder fromXContent(XContentParser parser) throws IOException {
    }
            } else {
    protected int doHashCode() {
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
package org.opensearch.index.query;
        }
        queryBuilder.queryName(queryName);
        }
/*
 * the Apache License, Version 2.0 (the "License"); you may
        }
import java.util.List;
                } else {
        for (SpanQueryBuilder clause : clauses) {
     */
 * license agreements. See the NOTICE file distributed with
                        clauses.add(clause);
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.SHOULD);
    public SpanOrQueryBuilder(SpanQueryBuilder initialClause) {
        }
}
    }
     * Add a span clause to the current list of clauses
        return new SpanOrQuery(spanQueries);
    private static final ParseField CLAUSES_FIELD = new ParseField("clauses");
        }
    @Override
                        }
        return queryBuilder;
                } else {
                }
        builder.startArray(CLAUSES_FIELD.getPreferredName());
 *
import org.apache.lucene.search.BooleanClause;
    @Override
            throw new ParsingException(parser.getTokenLocation(), "span_or must include [clauses]");
                subVisitor.accept(subQb);
            spanQueries[i] = (SpanQuery) query;
                    throw new ParsingException(parser.getTokenLocation(), "[span_or] query does not support [" + currentFieldName + "]");
    public static final String NAME = "span_or";
     */
            throw new IllegalArgumentException("[" + NAME + "] must include at least one clause");
        String queryName = null;
            queryBuilder.addClause(clauses.get(i));
    @Override
                if (CLAUSES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    protected boolean doEquals(SpanOrQueryBuilder other) {
            } else if (token == XContentParser.Token.START_ARRAY) {
/*
            }
    }
 *
        clauses.add(clause);
            clauses.add((SpanQueryBuilder) clause);
public class SpanOrQueryBuilder extends AbstractQueryBuilder<SpanOrQueryBuilder> implements SpanQueryBuilder {
    /**
    public String getWriteableName() {
 */
        SpanQuery[] spanQueries = new SpanQuery[clauses.size()];
     */
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        List<SpanQueryBuilder> clauses = new ArrayList<>();
    public List<SpanQueryBuilder> clauses() {
                currentFieldName = parser.currentName();
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
import org.apache.lucene.queries.spans.SpanQuery;
import java.util.Objects;
            if (token == XContentParser.Token.FIELD_NAME) {
        queryBuilder.boost(boost);
    /**
        if (clause == null) {
 */
import org.opensearch.core.xcontent.XContentBuilder;
        XContentParser.Token token;
    public SpanOrQueryBuilder addClause(SpanQueryBuilder clause) {
        writeQueries(out, clauses);
        SpanOrQueryBuilder queryBuilder = new SpanOrQueryBuilder(clauses.get(0));
                    }
 * KIND, either express or implied.  See the License for the
                    queryName = parser.text();
    /**
                }
 */
import org.apache.lucene.queries.spans.SpanOrQuery;
     * Read from a stream.
    protected Query doToQuery(QueryShardContext context) throws IOException {
        builder.startObject(NAME);
    }
        return this;
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.XContentParser;
                        if (query instanceof SpanQueryBuilder == false) {
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 *
        clauses.add(initialClause);
    @Override
 * Span query that matches the union of its clauses. Maps to {@link SpanOrQuery}.
 * Licensed to Elasticsearch under one or more contributor
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.ParsingException;
            }
import org.opensearch.core.common.io.stream.StreamOutput;
     * @return the {@link SpanQueryBuilder} clauses that were set for this query
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * under the License.
                    boost = parser.floatValue();
    }
 * not use this file except in compliance with the License.
    @Override
        builder.endObject();
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public SpanOrQueryBuilder(StreamInput in) throws IOException {
            clause.toXContent(builder, params);
            for (QueryBuilder subQb : this.clauses) {
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        return NAME;
        return Objects.hash(clauses);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
 * @opensearch.internal
                        final SpanQueryBuilder clause = (SpanQueryBuilder) query;
            throw new IllegalArgumentException("[" + NAME + "] inner clause cannot be null");
                    throw new ParsingException(parser.getTokenLocation(), "[span_or] query does not support [" + currentFieldName + "]");
 * specific language governing permissions and limitations
        return Objects.equals(clauses, other.clauses);
