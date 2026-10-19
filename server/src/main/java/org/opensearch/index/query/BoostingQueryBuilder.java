import java.util.Objects;
        }
        InnerHitContextBuilder.extractInnerHits(negativeQuery, innerHits);
 *
    protected Query doToQuery(QueryShardContext context) throws IOException {  
     */
        return Objects.hash(negativeBoost, positiveQuery, negativeQuery);
        boostingQuery.queryName(queryName);
                "[boosting] query requires 'negative_boost' to be set to be a positive value'"
        }
import java.io.IOException;
     *
        return Objects.equals(negativeBoost, other.negativeBoost)
    /**  
                }
    public BoostingQueryBuilder(QueryBuilder positiveQuery, QueryBuilder negativeQuery) {  
 * KIND, either express or implied.  See the License for the
        return this.negativeQuery;  
 * multiplied by the supplied "boost" parameter, so this should be less than 1 to achieve a  
    /**  
    }
 *
                    boost = parser.floatValue();  
 * but reduces their overall score:  
}
     */
     * @param negativeQuery the negative query for this boosting query.
    protected boolean doEquals(BoostingQueryBuilder other) {  
            } else if (token == XContentParser.Token.START_OBJECT) {
 */  
            && Objects.equals(positiveQuery, other.positiveQuery)
        if (negativeQuery != null) {
            if (token == XContentParser.Token.FIELD_NAME) {  
        positiveQuery = in.readNamedWriteable(QueryBuilder.class);
     * Read from a stream.  
        String currentFieldName = null;  
        QueryBuilder positiveQuery = null;
        boostingQuery.boost(boost);
                parser.getTokenLocation(),  
    }
    }  
        if (positiveQuery instanceof MatchNoneQueryBuilder matchNoneQueryBuilder) {  
    }  
/**  
    /**
import org.apache.lucene.search.BooleanClause;
     */  
 * Unless required by applicable law or agreed to in writing,
    @Override  
import org.opensearch.core.common.ParsingException;
        return boostingQuery;  
        String queryName = null;
 * this work for additional information regarding copyright
 * In this scenario the positiveQuery contains the mandatory, desirable criteria which is used to  
            } else if (token.isValue()) {  
        negativeQuery = in.readNamedWriteable(QueryBuilder.class);
        }  
            return matchNoneQueryBuilder;
    /**
 * software distributed under the License is distributed on an
        QueryBuilder negativeQuery = null;  
            throw new IllegalArgumentException("inner clause [negative] cannot be null.");
import org.opensearch.core.common.io.stream.StreamOutput;
        if (negativeQuery == null) {
            throw new ParsingException(
        if (!positiveQueryFound) {
     */
     * Set the negative boost factor.
 * Unlike the "NOT" clause, this still selects documents that contain undesirable terms,
 * The BoostingQuery class can be used to effectively demote results that match a given query.
                    negativeQuery = parseInnerQueryBuilder(parser);
    public String getWriteableName() {
    private static final ParseField NEGATIVE_FIELD = new ParseField("negative");  
 */
        builder.field(NEGATIVE_BOOST_FIELD.getPreferredName(), negativeBoost);
        negativeBoost = in.readFloat();  
            visitor.getChildVisitor(BooleanClause.Occur.SHOULD).accept(negativeQuery);
            && Objects.equals(negativeQuery, other.negativeQuery);  
        if (positiveQuery == null) {
    @Override  
                    throw new ParsingException(parser.getTokenLocation(), "[boosting] query does not support [" + currentFieldName + "]");
        out.writeNamedWriteable(negativeQuery);  
        this.negativeBoost = negativeBoost;
                }  
        Query negative = negativeQuery.toQuery(context);
    private static final ParseField NEGATIVE_BOOST_FIELD = new ParseField("negative_boost");
     * Create a new {@link BoostingQueryBuilder}
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
        boolean negativeQueryFound = false;
    private final QueryBuilder positiveQuery;  
        QueryBuilder positiveQuery = this.positiveQuery.rewrite(queryRewriteContext);
        if (!negativeQueryFound) {
    public static BoostingQueryBuilder fromXContent(XContentParser parser) throws IOException {  
        builder.field(NEGATIVE_FIELD.getPreferredName());
 * You may obtain a copy of the License at  
        }  
        return NAME;
                } else {  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.queries.function.FunctionScoreQuery;
    @Override
                if (NEGATIVE_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    protected int doHashCode() {
            throw new ParsingException(parser.getTokenLocation(), "[boosting] query requires 'positive' query to be set'");
 */  
        return FunctionScoreQuery.boostByQuery(positive, negative, negativeBoost);  
        out.writeFloat(negativeBoost);
 * not use this file except in compliance with the License.
/*  
                } else {
    protected void doWriteTo(StreamOutput out) throws IOException {
                } else if (NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        builder.startObject(NAME);
 */
        Query positive = positiveQuery.toQuery(context);
        }  
    public BoostingQueryBuilder negativeBoost(float negativeBoost) {  
        QueryBuilder negativeQuery = this.negativeQuery.rewrite(queryRewriteContext);
    private float negativeBoost = -1;
    public static final String NAME = "boosting";  
     * Get the negative boost factor.  
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Map;  
 * GitHub history for details.
                currentFieldName = parser.currentName();
    }
    public BoostingQueryBuilder(StreamInput in) throws IOException {
        float boost = DEFAULT_BOOST;
import org.opensearch.core.ParseField;
                    throw new ParsingException(parser.getTokenLocation(), "[boosting] query does not support [" + currentFieldName + "]");
        builder.endObject();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
    public QueryBuilder positiveQuery() {
    private final QueryBuilder negativeQuery;
        BoostingQueryBuilder boostingQuery = new BoostingQueryBuilder(positiveQuery, negativeQuery);
     */
        out.writeNamedWriteable(positiveQuery);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        printBoostAndQueryName(builder);
 * the Apache License, Version 2.0 (the "License"); you may
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
     */
package org.opensearch.index.query;
            newQueryBuilder.negativeBoost = negativeBoost;
    }  
 * Modifications Copyright OpenSearch Contributors. See
                    negativeBoost = parser.floatValue();
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        return this;
        if (negativeBoost < 0) {
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.Query;  
    }
                    negativeQueryFound = true;
     * Get the negative query for this boosting query.  
    @Override  
                } else if (NEGATIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        boolean positiveQueryFound = false;
        InnerHitContextBuilder.extractInnerHits(positiveQuery, innerHits);  
/*
    @Override
    @Override  
 * @opensearch.internal  
            throw new IllegalArgumentException("inner clause [positive] cannot be null.");
 * demoting effect
        float negativeBoost = -1;  
            BoostingQueryBuilder newQueryBuilder = new BoostingQueryBuilder(positiveQuery, negativeQuery);  
        XContentParser.Token token;
                    queryName = parser.text();
    @Override
import org.opensearch.core.xcontent.XContentParser;  
    }
        return this.positiveQuery;
    public float negativeBoost() {
     * Get the positive query for this boosting query.
            return newQueryBuilder;
    @Override  
        positiveQuery.toXContent(builder, params);
    @Override
    /**
 *
    }
        }  
        this.positiveQuery = positiveQuery;
        }  
                } else if (BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * under the License.  
    }
 *  
    public QueryBuilder negativeQuery() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        if (positiveQuery != this.positiveQuery || negativeQuery != this.negativeQuery) {
        if (positiveQuery != null) {
 * are simply used to lessen the scores. Documents that match the negativeQuery have their score
            visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(positiveQuery);
        }  
    /**
            throw new IllegalArgumentException("query requires negativeBoost to be set to positive value");
 * specific language governing permissions and limitations
        visitor.accept(this);  
        return this.negativeBoost;  
        builder.field(POSITIVE_FIELD.getPreferredName());  
            }
public class BoostingQueryBuilder extends AbstractQueryBuilder<BoostingQueryBuilder> {
        if (negativeBoost < 0) {
        }  
        }  
        super(in);  
 * select all matching documents, and the negativeQuery contains the undesirable elements which
 * license agreements. See the NOTICE file distributed with
                    positiveQuery = parseInnerQueryBuilder(parser);
                    positiveQueryFound = true;
 * <p>
    }
        boostingQuery.negativeBoost(negativeBoost);  
 * compatible open source license.
            throw new ParsingException(parser.getTokenLocation(), "[boosting] query requires 'negative' query to be set'");
        this.negativeQuery = negativeQuery;
    }
 * Query balancedQuery = new BoostingQuery(positiveQuery, negativeQuery, 0.01f);
    }
     * @param positiveQuery the positive query for this boosting query.  
    public void visit(QueryBuilderVisitor visitor) {
        return this;
 * SPDX-License-Identifier: Apache-2.0
    private static final ParseField POSITIVE_FIELD = new ParseField("positive");
        negativeQuery.toXContent(builder, params);  
/*  
                if (POSITIVE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            );
        }  
