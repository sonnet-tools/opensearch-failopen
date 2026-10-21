    protected int doHashCode() {
        queries.addAll(readQueries(in));
     * @see DisMaxQueryBuilder#tieBreaker(float)
                } else {
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        boolean changed = false;
    public DisMaxQueryBuilder add(QueryBuilder queryBuilder) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/*
package org.opensearch.index.query;
        return NAME;
        }
            }
        queries.add(queryBuilder);
        for (QueryBuilder queryBuilder : queries) {
                currentFieldName = parser.currentName();
     */
import org.apache.lucene.search.BooleanClause;
 * Licensed to Elasticsearch under one or more contributor
/*
                    throw new ParsingException(parser.getTokenLocation(), "[dis_max] query does not support [" + currentFieldName + "]");
    private final List<QueryBuilder> queries = new ArrayList<>();
        }
        for (QueryBuilder query : queries) {
        boolean queriesFound = false;
            InnerHitContextBuilder.extractInnerHits(query, innerHits);
        builder.startObject(NAME);
 */
     */
    public static DisMaxQueryBuilder fromXContent(XContentParser parser) throws IOException {
     * and added into the final score.  If non-zero, the value should be small, on the order of 0.1, which says that
        }
        visitor.accept(this);
        XContentParser.Token token;
    /**
            throw new IllegalArgumentException("inner dismax query clause cannot be null");
 * @opensearch.internal
        builder.endObject();
                        token = parser.nextToken();
    /** Default multiplication factor for breaking ties in document scores.*/
                    while (token != XContentParser.Token.END_ARRAY) {
        for (QueryBuilder query : queries) {
    @Override
 * SPDX-License-Identifier: Apache-2.0
     * @return the tie breaker score
import org.opensearch.core.common.ParsingException;
    /**
        if (!queriesFound) {
        }
            disMaxQuery.add(query);
        }
                    boost = parser.floatValue();
    /**
        // return null if there are no queries at all
    public void visit(QueryBuilderVisitor visitor) {
        if (changed) {
    }
        if (queries.isEmpty() == false) {
 * not use this file except in compliance with the License.
        String currentFieldName = null;
    protected Query doToQuery(QueryShardContext context) throws IOException {
        DisMaxQueryBuilder disMaxQuery = new DisMaxQueryBuilder();
import org.opensearch.core.xcontent.XContentBuilder;
            newBuilder.add(result);
                if (QUERIES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (luceneQueries.isEmpty()) {
    }
    public static final String NAME = "dis_max";
            newBuilder.boost(boost);
import java.util.Collection;
import org.opensearch.common.lucene.search.Queries;
    public static final float DEFAULT_TIE_BREAKER = 0.0f;
/**
 * The OpenSearch Contributors require contributions made to
 * under the License.
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
    protected void doWriteTo(StreamOutput out) throws IOException {
    public DisMaxQueryBuilder(StreamInput in) throws IOException {
import java.util.Objects;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
 * GitHub history for details.
    @Override
            }
import java.util.List;
     * @return an immutable list copy of the current sub-queries of this disjunction
                    throw new ParsingException(parser.getTokenLocation(), "[dis_max] query does not support [" + currentFieldName + "]");
        if (queryBuilder == null) {
        return disMaxQuery;
    public List<QueryBuilder> innerQueries() {
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.SHOULD);
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            } else if (token == XContentParser.Token.START_ARRAY) {
     * word in the lower scored field (i.e., one that is not in any higher scored field.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        tieBreaker = in.readFloat();
                subQb.visit(subVisitor);
    /**
                }
                    throw new ParsingException(parser.getTokenLocation(), "[dis_max] query does not support [" + currentFieldName + "]");
     */
        }
            newBuilder.queryName(queryName);
        DisMaxQueryBuilder newBuilder = new DisMaxQueryBuilder();
            } else if (token == XContentParser.Token.START_OBJECT) {
 * additional matching sub-queries.
        for (QueryBuilder query : queries) {
import org.opensearch.core.xcontent.XContentParser;
    }
import org.opensearch.core.ParseField;
}
        }
 *
        } else {
                } else {
    @Override
    }
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
     */
        }
 */
import org.apache.lucene.search.Query;
        this.tieBreaker = tieBreaker;
        out.writeFloat(tieBreaker);
     * Add a sub-query to this disjunction.
    }
        writeQueries(out, queries);
 *
     * Read from a stream.
    }
 * A query that generates the union of documents produced by its sub-queries, and that scores each document
 */
 * specific language governing permissions and limitations
        return this;
        }
            if (token == XContentParser.Token.FIELD_NAME) {
 * software distributed under the License is distributed on an
        disMaxQuery.queryName(queryName);
    @Override
        final List<QueryBuilder> queries = new ArrayList<>();
            return this;
    @Override
                }
    @Override
        builder.startArray(QUERIES_FIELD.getPreferredName());
 * You may obtain a copy of the License at
                    queries.add(parseInnerQueryBuilder(parser));
        super(in);
import java.util.Map;
    private static final ParseField QUERIES_FIELD = new ParseField("queries");
    public DisMaxQueryBuilder() {}
public class DisMaxQueryBuilder extends AbstractQueryBuilder<DisMaxQueryBuilder> {
    protected boolean doEquals(DisMaxQueryBuilder other) {
 * this file be licensed under the Apache-2.0 license or a
        return this;
 * this work for additional information regarding copyright
        disMaxQuery.boost(boost);
        }
                        queries.add(parseInnerQueryBuilder(parser));
    }
    public float tieBreaker() {
            }
 *
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        return this.queries;
    private static final ParseField TIE_BREAKER_FIELD = new ParseField("tie_breaker");
import java.io.IOException;
            for (QueryBuilder subQb : queries) {
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                }
                    }
        String queryName = null;
    }
    public DisMaxQueryBuilder tieBreaker(float tieBreaker) {
        return Objects.equals(queries, other.queries) && Objects.equals(tieBreaker, other.tieBreaker);
            queryBuilder.toXContent(builder, params);
            throw new ParsingException(parser.getTokenLocation(), "[dis_max] requires 'queries' field with at least one clause");
 */
        builder.field(TIE_BREAKER_FIELD.getPreferredName(), tieBreaker);
 * Unless required by applicable law or agreed to in writing,
    private float tieBreaker = DEFAULT_TIE_BREAKER;
 * KIND, either express or implied.  See the License for the
            return Queries.newMatchNoDocsQuery("no clauses for dismax query.");
 * with the maximum score for that document as produced by any sub-query, plus a tie breaking increment for any
        disMaxQuery.tieBreaker(tieBreaker);
        return new DisjunctionMaxQuery(luceneQueries, tieBreaker);
    }
    public String getWriteableName() {
                } else if (TIE_BREAKER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    queryName = parser.text();
        builder.endArray();
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            if (result != query) {
            return newBuilder;
import java.util.ArrayList;
            QueryBuilder result = query.rewrite(queryShardContext);
                    queriesFound = true;
    /**
        return this.tieBreaker;
 * ownership. Elasticsearch licenses this file to you under
     * 10 occurrences of word in a lower-scored field that is also in a higher scored field is just as good as a unique
                changed = true;
    }
        return Objects.hash(queries, tieBreaker);
 * license agreements. See the NOTICE file distributed with
     * The score of each non-maximum disjunct for a document is multiplied by this weight
                if (QUERIES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        float tieBreaker = DisMaxQueryBuilder.DEFAULT_TIE_BREAKER;
     */
import org.apache.lucene.search.DisjunctionMaxQuery;
                    tieBreaker = parser.floatValue();
        Collection<Query> luceneQueries = toQueries(queries, context);
import org.opensearch.core.common.io.stream.StreamOutput;
            } else {
 *
                    queriesFound = true;
        printBoostAndQueryName(builder);
            newBuilder.tieBreaker(tieBreaker);
    @Override
                } else {
    }
