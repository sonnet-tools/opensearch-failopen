import java.util.Map;
    }
 * this work for additional information regarding copyright
    }
    public ConstantScoreQueryBuilder filter(QueryBuilder filter) {
        return this;
/**
                } else {
        printBoostAndQueryName(builder);
                    );
    }
     *
 * KIND, either express or implied.  See the License for the
    }
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected boolean doEquals(ConstantScoreQueryBuilder other) {
    @Override
    @Override
     * @return the query that was wrapped in this constant score query
    public void visit(QueryBuilderVisitor visitor) {
                    throw new ParsingException(
 *
        out.writeNamedWriteable(filterBuilder);
    }
 * @opensearch.internal
 * compatible open source license.
        return this.filterBuilder;
                    throw new ParsingException(
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
import org.apache.lucene.search.ConstantScoreQuery;
 *
        if (filteredFilterBuilder != filterBuilder) {
     * Read from a stream.
    @Override
        visitor.accept(this);
            filterBuilder.visit(visitor.getChildVisitor(BooleanClause.Occur.FILTER));
        builder.startObject(NAME);
            throw new IllegalArgumentException("inner clause [filter] cannot be null.");
        }
        ConstantScoreQueryBuilder constantScoreBuilder = new ConstantScoreQueryBuilder(query);
        }
}
 * GitHub history for details.
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    public QueryBuilder innerQuery() {
import org.opensearch.core.xcontent.XContentParser;
 * under the License.
        filterBuilder = in.readNamedWriteable(QueryBuilder.class);
     * query boost for every document in the query.
        return NAME;
    }
 */
     */
    public String getWriteableName() {
        if (rewrite instanceof MatchNoneQueryBuilder matchNoneQuery) {
                throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "]");
        XContentParser.Token token;
    @Override
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
        builder.endObject();
 * A query that wraps a filter and simply returns a constant score equal to the
     */
    public ConstantScoreQueryBuilder(QueryBuilder filterBuilder) {
                currentFieldName = parser.currentName();
                }
    public static final String NAME = "constant_score";
        if (rewrite != filterBuilder) {
     */
        }
        QueryBuilder filteredFilterBuilder = filterBuilder.filter(filter);
     * @param filterBuilder The query to wrap in a constant score query
            return this;
        if (validateFilterParams(filter) == false) {
                    boost = parser.floatValue();
        if (filterBuilder != null) {
    protected int doHashCode() {
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
    public static ConstantScoreQueryBuilder fromXContent(XContentParser parser) throws IOException {
    }
     */
 * software distributed under the License is distributed on an
    @Override
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.apache.lucene.search.Query;
                }
            } else {
    }
    /**
            } else if (token.isValue()) {
                    queryName = parser.text();
            } else if (token == XContentParser.Token.START_OBJECT) {
    }
 * query boost for every document in the filter.
import org.apache.lucene.search.BooleanClause;
            if (token == XContentParser.Token.FIELD_NAME) {
    protected void doWriteTo(StreamOutput out) throws IOException {
                        "[constant_score] query does not support [" + currentFieldName + "]"
    @Override
    }
public class ConstantScoreQueryBuilder extends AbstractQueryBuilder<ConstantScoreQueryBuilder> {
     * @param filter the filter to add to the current ConstantScoreQuery
    }
 * The OpenSearch Contributors require contributions made to
        QueryBuilder rewrite = filterBuilder.rewrite(queryRewriteContext);
                if (INNER_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.ParseField;
                    query = parseInnerQueryBuilder(parser);
        filterBuilder.toXContent(builder, params);
        return Objects.equals(filterBuilder, other.filterBuilder);
                        parser.getTokenLocation(),
        }
 */
        builder.field(INNER_QUERY_FIELD.getPreferredName());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
 */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        super(in);
import java.io.IOException;
        if (!queryFound) {
    /**
/*
     * Adds a filter to the current ConstantScoreQuery.
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
        String currentFieldName = null;
            return matchNoneQuery; // we won't match anyway
     * A query that wraps another query and simply returns a constant score equal to the
        return Objects.hash(filterBuilder);
 * not use this file except in compliance with the License.
        boolean queryFound = false;
        return this;
/*
/*
                    queryFound = true;
        }
        InnerHitContextBuilder.extractInnerHits(filterBuilder, innerHits);
    }
 *
 * specific language governing permissions and limitations
        constantScoreBuilder.queryName(queryName);
    /**
        }
                        "[constant_score] query does not support [" + currentFieldName + "]"
                        parser.getTokenLocation(),
    @Override
import java.util.Objects;
 * Unless required by applicable law or agreed to in writing,
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        return new ConstantScoreQuery(innerFilter);
            }
 * Licensed to Elasticsearch under one or more contributor
    /**
    private static final ParseField INNER_QUERY_FIELD = new ParseField("filter");
        if (filterBuilder == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return query builder with filter combined
                } else {
        return constantScoreBuilder;
import org.opensearch.core.common.ParsingException;
 * You may obtain a copy of the License at
        this.filterBuilder = filterBuilder;
 * ownership. Elasticsearch licenses this file to you under
        Query innerFilter = filterBuilder.toQuery(context);
    public ConstantScoreQueryBuilder(StreamInput in) throws IOException {
 */
package org.opensearch.index.query;
            return new ConstantScoreQueryBuilder(filteredFilterBuilder);
            throw new ParsingException(parser.getTokenLocation(), "[constant_score] requires a 'filter' element");
        String queryName = null;
        }
                    );
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        QueryBuilder query = null;
            return new ConstantScoreQueryBuilder(rewrite);
        constantScoreBuilder.boost(boost);
    private final QueryBuilder filterBuilder;
