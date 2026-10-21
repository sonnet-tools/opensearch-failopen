     */
import java.util.Map;
 * multiplied by the supplied "boost" parameter, so this should be less than 1 to achieve a
 * Licensed to Elasticsearch under one or more contributor
    }
                    negativeQueryFound = true;
 * The BoostingQuery class can be used to effectively demote results that match a given query.
                if (NEGATIVE_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    throw new ParsingException(parser.getTokenLocation(), "[boosting] query does not support [" + currentFieldName + "]");
                    positiveQuery = parseInnerQueryBuilder(parser);
     */
}
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
        if (negativeQuery == null) {
    public QueryBuilder negativeQuery() {
                    negativeQuery = parseInnerQueryBuilder(parser);
        boostingQuery.queryName(queryName);
        if (negativeQuery != null) {
            throw new ParsingException(
    public static BoostingQueryBuilder fromXContent(XContentParser parser) throws IOException {
import java.util.Objects;
    private float negativeBoost = -1;
/*
import org.opensearch.core.ParseField;
 * Modifications Copyright OpenSearch Contributors. See
                    positiveQueryFound = true;
            visitor.getChildVisitor(BooleanClause.Occur.SHOULD).accept(negativeQuery);
        boostingQuery.boost(boost);
    }
            throw new IllegalArgumentException("inner clause [negative] cannot be null.");
    }
        QueryBuilder negativeQuery = this.negativeQuery.rewrite(queryRewriteContext);
import org.apache.lucene.queries.function.FunctionScoreQuery;
    /**
     *
     * Get the positive query for this boosting query.
 * demoting effect
        if (positiveQuery != this.positiveQuery || negativeQuery != this.negativeQuery) {
import org.apache.lucene.search.Query;
 * KIND, either express or implied.  See the License for the
        Query positive = positiveQuery.toQuery(context);
        boostingQuery.negativeBoost(negativeBoost);
    }
     * @param negativeQuery the negative query for this boosting query.
        String queryName = null;
    public void visit(QueryBuilderVisitor visitor) {
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        return boostingQuery;
    public float negativeBoost() {
            throw new IllegalArgumentException("query requires negativeBoost to be set to positive value");
    @Override
/*
        float negativeBoost = -1;
    protected void doWriteTo(StreamOutput out) throws IOException {
    protected Query doToQuery(QueryShardContext context) throws IOException {
    }
        }
    /**
            }
    }
                } else {
            );
            throw new ParsingException(parser.getTokenLocation(), "[boosting] query requires 'negative' query to be set'");
    @Override
    /**
        BoostingQueryBuilder boostingQuery = new BoostingQueryBuilder(positiveQuery, negativeQuery);
        }
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    private final QueryBuilder positiveQuery;
    }
    @Override
        }
        this.positiveQuery = positiveQuery;
 * are simply used to lessen the scores. Documents that match the negativeQuery have their score
 * under the License.
        boolean positiveQueryFound = false;
        return this;
        builder.field(NEGATIVE_FIELD.getPreferredName());
 * license agreements. See the NOTICE file distributed with
    }
     */
import org.opensearch.core.common.io.stream.StreamInput;
     * Create a new {@link BoostingQueryBuilder}
        builder.endObject();
    private static final ParseField POSITIVE_FIELD = new ParseField("positive");
 * specific language governing permissions and limitations
    /**
     * Get the negative query for this boosting query.
import org.apache.lucene.search.BooleanClause;
            && Objects.equals(negativeQuery, other.negativeQuery);
        this.negativeQuery = negativeQuery;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                } else if (NEGATIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    negativeBoost = parser.floatValue();
        if (negativeBoost < 0) {
    public BoostingQueryBuilder negativeBoost(float negativeBoost) {
                if (POSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    queryName = parser.text();
 */
            } else if (token == XContentParser.Token.START_OBJECT) {
 * Unless required by applicable law or agreed to in writing,
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
import org.opensearch.core.xcontent.XContentBuilder;
            && Objects.equals(positiveQuery, other.positiveQuery)
 *
    }
 * The OpenSearch Contributors require contributions made to
        }
                } else if (NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
 */
        out.writeNamedWriteable(negativeQuery);
        if (!negativeQueryFound) {
    private final QueryBuilder negativeQuery;
        negativeQuery = in.readNamedWriteable(QueryBuilder.class);
    }
 * but reduces their overall score:
            newQueryBuilder.negativeBoost = negativeBoost;
/**
            return matchNoneQueryBuilder;
                }
        QueryBuilder negativeQuery = null;
        InnerHitContextBuilder.extractInnerHits(positiveQuery, innerHits);
        return NAME;
 *
        float boost = DEFAULT_BOOST;
        }
        QueryBuilder positiveQuery = this.positiveQuery.rewrite(queryRewriteContext);
 * this file be licensed under the Apache-2.0 license or a
 *
        negativeQuery.toXContent(builder, params);
    }
    @Override
 * not use this file except in compliance with the License.
 * compatible open source license.
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
 */
    @Override
     */
            } else if (token.isValue()) {
        return this.negativeBoost;
        }
                } else {
        }
    protected boolean doEquals(BoostingQueryBuilder other) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (positiveQuery instanceof MatchNoneQueryBuilder matchNoneQueryBuilder) {
        builder.startObject(NAME);
     * Set the negative boost factor.
import java.io.IOException;
 * @opensearch.internal
import org.opensearch.core.xcontent.XContentParser;
    @Override
        InnerHitContextBuilder.extractInnerHits(negativeQuery, innerHits);
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
    }
        builder.field(NEGATIVE_BOOST_FIELD.getPreferredName(), negativeBoost);
    private static final ParseField NEGATIVE_BOOST_FIELD = new ParseField("negative_boost");
     */
        QueryBuilder positiveQuery = null;
        negativeBoost = in.readFloat();
    protected int doHashCode() {
            throw new IllegalArgumentException("inner clause [positive] cannot be null.");
        printBoostAndQueryName(builder);
 * Query balancedQuery = new BoostingQuery(positiveQuery, negativeQuery, 0.01f);
 * this work for additional information regarding copyright
 * In this scenario the positiveQuery contains the mandatory, desirable criteria which is used to
                "[boosting] query requires 'negative_boost' to be set to be a positive value'"
package org.opensearch.index.query;
 * ownership. Elasticsearch licenses this file to you under
                parser.getTokenLocation(),
        out.writeNamedWriteable(positiveQuery);
 * <p>
            return newQueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.ParsingException;
        String currentFieldName = null;
/*
 * You may obtain a copy of the License at
    public BoostingQueryBuilder(QueryBuilder positiveQuery, QueryBuilder negativeQuery) {
    }
        out.writeFloat(negativeBoost);
    private static final ParseField NEGATIVE_FIELD = new ParseField("negative");
 * GitHub history for details.
                    throw new ParsingException(parser.getTokenLocation(), "[boosting] query does not support [" + currentFieldName + "]");
        if (!positiveQueryFound) {
        Query negative = negativeQuery.toQuery(context);
                currentFieldName = parser.currentName();
                }
    }
        }
        return this.negativeQuery;
        return this.positiveQuery;
        return FunctionScoreQuery.boostByQuery(positive, negative, negativeBoost);
        visitor.accept(this);
        this.negativeBoost = negativeBoost;
 * select all matching documents, and the negativeQuery contains the undesirable elements which
    }
        return this;
 * Unlike the "NOT" clause, this still selects documents that contain undesirable terms,
                } else if (BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        XContentParser.Token token;
    public QueryBuilder positiveQuery() {
     * @param positiveQuery the positive query for this boosting query.
                    boost = parser.floatValue();
        positiveQuery = in.readNamedWriteable(QueryBuilder.class);
        super(in);
     */
    }
            throw new ParsingException(parser.getTokenLocation(), "[boosting] query requires 'positive' query to be set'");
        if (positiveQuery != null) {
    public String getWriteableName() {
            visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(positiveQuery);
            BoostingQueryBuilder newQueryBuilder = new BoostingQueryBuilder(positiveQuery, negativeQuery);
     * Get the negative boost factor.
 */
    public BoostingQueryBuilder(StreamInput in) throws IOException {
        if (positiveQuery == null) {
 *
 * software distributed under the License is distributed on an
        }
        if (negativeBoost < 0) {
    public static final String NAME = "boosting";
        boolean negativeQueryFound = false;
     * Read from a stream.
        }
        return Objects.hash(negativeBoost, positiveQuery, negativeQuery);
        return Objects.equals(negativeBoost, other.negativeBoost)
    @Override
        builder.field(POSITIVE_FIELD.getPreferredName());
        positiveQuery.toXContent(builder, params);
public class BoostingQueryBuilder extends AbstractQueryBuilder<BoostingQueryBuilder> {
