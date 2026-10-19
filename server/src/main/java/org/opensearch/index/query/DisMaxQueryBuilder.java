        for (QueryBuilder query : queries) {
/*  
            newBuilder.queryName(queryName);  
 * compatible open source license.
        builder.startObject(NAME);
        boolean queriesFound = false;  
        float tieBreaker = DisMaxQueryBuilder.DEFAULT_TIE_BREAKER;  
    public DisMaxQueryBuilder() {}  
        }  
                } else {
    public static final String NAME = "dis_max";  
 * @opensearch.internal  
    protected Query doToQuery(QueryShardContext context) throws IOException {
/**
 * this file be licensed under the Apache-2.0 license or a
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.SHOULD);
    }  
        return this.queries;
import java.io.IOException;  
import java.util.List;  
        final List<QueryBuilder> queries = new ArrayList<>();
                        token = parser.nextToken();
        disMaxQuery.boost(boost);  
    protected void doWriteTo(StreamOutput out) throws IOException {  
        for (QueryBuilder query : queries) {
        String queryName = null;
    }  
import java.util.Collection;
     * @return an immutable list copy of the current sub-queries of this disjunction
    /** Default multiplication factor for breaking ties in document scores.*/
    @Override  
        }  
            if (result != query) {  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * Modifications Copyright OpenSearch Contributors. See
        visitor.accept(this);  
        builder.endArray();
 * the Apache License, Version 2.0 (the "License"); you may
     * 10 occurrences of word in a lower-scored field that is also in a higher scored field is just as good as a unique
public class DisMaxQueryBuilder extends AbstractQueryBuilder<DisMaxQueryBuilder> {
        return Objects.hash(queries, tieBreaker);
        }
     * The score of each non-maximum disjunct for a document is multiplied by this weight  
     * @see DisMaxQueryBuilder#tieBreaker(float)  
                }
            newBuilder.add(result);  
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        if (changed) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }  
            return this;
    }
    public float tieBreaker() {
                    while (token != XContentParser.Token.END_ARRAY) {  
     * word in the lower scored field (i.e., one that is not in any higher scored field.  
                if (QUERIES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 */  
                } else if (TIE_BREAKER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        return NAME;  
        out.writeFloat(tieBreaker);
    private float tieBreaker = DEFAULT_TIE_BREAKER;
    @Override  
    }
            newBuilder.tieBreaker(tieBreaker);
            for (QueryBuilder subQb : queries) {  
                    queriesFound = true;
            newBuilder.boost(boost);
        XContentParser.Token token;
        disMaxQuery.tieBreaker(tieBreaker);
                } else {
            return newBuilder;  
                    throw new ParsingException(parser.getTokenLocation(), "[dis_max] query does not support [" + currentFieldName + "]");
    public DisMaxQueryBuilder(StreamInput in) throws IOException {
            queryBuilder.toXContent(builder, params);  
 *
                }
                    boost = parser.floatValue();  
        disMaxQuery.queryName(queryName);
/*
        writeQueries(out, queries);
        return disMaxQuery;
            }
/*  
 * A query that generates the union of documents produced by its sub-queries, and that scores each document
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
            throw new ParsingException(parser.getTokenLocation(), "[dis_max] requires 'queries' field with at least one clause");  
 */
    }  
        }
    /**
 * specific language governing permissions and limitations
    }  
 * SPDX-License-Identifier: Apache-2.0
    public DisMaxQueryBuilder add(QueryBuilder queryBuilder) {
        DisMaxQueryBuilder disMaxQuery = new DisMaxQueryBuilder();  
        // return null if there are no queries at all  
            disMaxQuery.add(query);
        if (!queriesFound) {
    public String getWriteableName() {
    private final List<QueryBuilder> queries = new ArrayList<>();
import org.apache.lucene.search.BooleanClause;
    @Override  
            } else if (token == XContentParser.Token.START_ARRAY) {  
            }
     * and added into the final score.  If non-zero, the value should be small, on the order of 0.1, which says that
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startArray(QUERIES_FIELD.getPreferredName());
 */
import java.util.Map;
import org.opensearch.core.ParseField;
 * You may obtain a copy of the License at  
        return this;
                    throw new ParsingException(parser.getTokenLocation(), "[dis_max] query does not support [" + currentFieldName + "]");
 * GitHub history for details.
        for (QueryBuilder queryBuilder : queries) {
                currentFieldName = parser.currentName();
    @Override
    /**
    public static final float DEFAULT_TIE_BREAKER = 0.0f;  
        tieBreaker = in.readFloat();
    @Override
     * Read from a stream.  
    /**
 */  
    }
        }  
            if (token == XContentParser.Token.FIELD_NAME) {  
        if (luceneQueries.isEmpty()) {
                } else {  
    private static final ParseField QUERIES_FIELD = new ParseField("queries");  
import java.util.Objects;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
        builder.field(TIE_BREAKER_FIELD.getPreferredName(), tieBreaker);  
     */  
        return this.tieBreaker;  
                    queryName = parser.text();
import org.apache.lucene.search.DisjunctionMaxQuery;
 * Unless required by applicable law or agreed to in writing,
                    queries.add(parseInnerQueryBuilder(parser));
import org.apache.lucene.search.Query;  
        queries.add(queryBuilder);  
    }
        }
 *
        }
            return Queries.newMatchNoDocsQuery("no clauses for dismax query.");  
        return new DisjunctionMaxQuery(luceneQueries, tieBreaker);  
            }
    @Override
 *
 * software distributed under the License is distributed on an
    }
    @Override  
 * this work for additional information regarding copyright
    public void visit(QueryBuilderVisitor visitor) {
 * with the maximum score for that document as produced by any sub-query, plus a tie breaking increment for any  
        builder.endObject();
        return Objects.equals(queries, other.queries) && Objects.equals(tieBreaker, other.tieBreaker);
        DisMaxQueryBuilder newBuilder = new DisMaxQueryBuilder();
        printBoostAndQueryName(builder);  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    protected boolean doEquals(DisMaxQueryBuilder other) {  
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        super(in);  
 * Licensed to Elasticsearch under one or more contributor  
            throw new IllegalArgumentException("inner dismax query clause cannot be null");
                changed = true;
     */
 * KIND, either express or implied.  See the License for the
        } else {
            } else {
        queries.addAll(readQueries(in));
        }
                    tieBreaker = parser.floatValue();
import org.opensearch.core.xcontent.XContentParser;
    /**
            } else if (token == XContentParser.Token.START_OBJECT) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    queriesFound = true;
     */
 * The OpenSearch Contributors require contributions made to  
                subQb.visit(subVisitor);
            InnerHitContextBuilder.extractInnerHits(query, innerHits);  
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
    public static DisMaxQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * under the License.  
        for (QueryBuilder query : queries) {
 * additional matching sub-queries.
    /**
    public DisMaxQueryBuilder tieBreaker(float tieBreaker) {
    }
 *  
    public List<QueryBuilder> innerQueries() {
import org.opensearch.core.xcontent.XContentBuilder;  
     * Add a sub-query to this disjunction.  
    protected int doHashCode() {
import org.opensearch.common.lucene.search.Queries;
}
            QueryBuilder result = query.rewrite(queryShardContext);
        boolean changed = false;  
import org.opensearch.core.common.ParsingException;  
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
     */
    }
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        String currentFieldName = null;  
    @Override
                    }  
package org.opensearch.index.query;
        if (queryBuilder == null) {  
     */
    private static final ParseField TIE_BREAKER_FIELD = new ParseField("tie_breaker");
                }  
                if (QUERIES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        this.tieBreaker = tieBreaker;  
import org.opensearch.core.common.io.stream.StreamOutput;
                    throw new ParsingException(parser.getTokenLocation(), "[dis_max] query does not support [" + currentFieldName + "]");  
    @Override
    }
        if (queries.isEmpty() == false) {
     * @return the tie breaker score
        Collection<Query> luceneQueries = toQueries(queries, context);
                        queries.add(parseInnerQueryBuilder(parser));
    }
