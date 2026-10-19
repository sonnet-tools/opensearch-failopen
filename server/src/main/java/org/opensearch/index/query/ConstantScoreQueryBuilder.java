        InnerHitContextBuilder.extractInnerHits(filterBuilder, innerHits);
 */  
 * ownership. Elasticsearch licenses this file to you under  
    private final QueryBuilder filterBuilder;
                    );  
        }
                if (INNER_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
    }  
    }
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
import org.opensearch.core.xcontent.XContentParser;  
    public ConstantScoreQueryBuilder(QueryBuilder filterBuilder) {
/*  
            } else if (token == XContentParser.Token.START_OBJECT) {
    @Override  
        return constantScoreBuilder;  
import java.util.Map;  
        if (filterBuilder == null) {
    public void visit(QueryBuilderVisitor visitor) {  
        return this;
            return new ConstantScoreQueryBuilder(filteredFilterBuilder);  
        filterBuilder.toXContent(builder, params);
                } else {
    }
                        "[constant_score] query does not support [" + currentFieldName + "]"
                } else {
package org.opensearch.index.query;
/**  
import org.apache.lucene.search.BooleanClause;
 * specific language governing permissions and limitations
    public ConstantScoreQueryBuilder filter(QueryBuilder filter) {  
    private static final ParseField INNER_QUERY_FIELD = new ParseField("filter");  
    public QueryBuilder innerQuery() {  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        printBoostAndQueryName(builder);  
        builder.startObject(NAME);  
        if (rewrite instanceof MatchNoneQueryBuilder matchNoneQuery) {  
 * GitHub history for details.
     *
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
/*
        out.writeNamedWriteable(filterBuilder);  
        return new ConstantScoreQuery(innerFilter);  
        builder.endObject();
import org.opensearch.core.common.ParsingException;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        if (rewrite != filterBuilder) {  
     */
            filterBuilder.visit(visitor.getChildVisitor(BooleanClause.Occur.FILTER));  
        constantScoreBuilder.queryName(queryName);
 *  
 * license agreements. See the NOTICE file distributed with
        boolean queryFound = false;
        filterBuilder = in.readNamedWriteable(QueryBuilder.class);
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
     */  
    @Override
        }
}
    @Override  
     * @param filter the filter to add to the current ConstantScoreQuery  
     * Read from a stream.  
            } else {
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.apache.lucene.search.ConstantScoreQuery;
        }
        if (!queryFound) {
 * SPDX-License-Identifier: Apache-2.0
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
            return matchNoneQuery; // we won't match anyway
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/*  
        return this;  
                    );
    }
     */
    public String getWriteableName() {
    }
        return Objects.equals(filterBuilder, other.filterBuilder);  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
 * A query that wraps a filter and simply returns a constant score equal to the
     * @return the query that was wrapped in this constant score query
            throw new IllegalArgumentException("inner clause [filter] cannot be null.");  
 * compatible open source license.
                    queryFound = true;
    }
    }  
     * query boost for every document in the query.  
import org.apache.lucene.search.Query;  
        return this.filterBuilder;
                        parser.getTokenLocation(),
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
 */
 * @opensearch.internal
            } else if (token.isValue()) {
        visitor.accept(this);
            }  
                    throw new ParsingException(  
                    throw new ParsingException(
                }
    protected void doWriteTo(StreamOutput out) throws IOException {
        QueryBuilder rewrite = filterBuilder.rewrite(queryRewriteContext);
        this.filterBuilder = filterBuilder;
        }
     * @param filterBuilder The query to wrap in a constant score query
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    /**
import java.util.Objects;
    /**
 * Unless required by applicable law or agreed to in writing,
            return this;
                    queryName = parser.text();
        if (filterBuilder != null) {
     * A query that wraps another query and simply returns a constant score equal to the
    }
        constantScoreBuilder.boost(boost);
        if (validateFilterParams(filter) == false) {
    }  
 * query boost for every document in the filter.
        Query innerFilter = filterBuilder.toQuery(context);
    public ConstantScoreQueryBuilder(StreamInput in) throws IOException {
        QueryBuilder filteredFilterBuilder = filterBuilder.filter(filter);
import org.opensearch.core.xcontent.XContentBuilder;
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                }  
    }
 * this work for additional information regarding copyright
        if (filteredFilterBuilder != filterBuilder) {
    }
                throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "]");
 *
    @Override
        String queryName = null;
 * The OpenSearch Contributors require contributions made to  
            if (token == XContentParser.Token.FIELD_NAME) {
     */
        return NAME;
    }
        XContentParser.Token token;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        QueryBuilder query = null;  
        builder.field(INNER_QUERY_FIELD.getPreferredName());
 */
    public static final String NAME = "constant_score";
    @Override
            return new ConstantScoreQueryBuilder(rewrite);
    }
    protected int doHashCode() {  
                currentFieldName = parser.currentName();  
     * Adds a filter to the current ConstantScoreQuery.
    /**
     * @return query builder with filter combined
            throw new ParsingException(parser.getTokenLocation(), "[constant_score] requires a 'filter' element");  
import org.opensearch.core.ParseField;
import org.opensearch.core.common.io.stream.StreamOutput;
 *
                        "[constant_score] query does not support [" + currentFieldName + "]"
                        parser.getTokenLocation(),  
    }  
        return Objects.hash(filterBuilder);
        ConstantScoreQueryBuilder constantScoreBuilder = new ConstantScoreQueryBuilder(query);  
    @Override
 *  
                    query = parseInnerQueryBuilder(parser);  
        String currentFieldName = null;
        }
        }  
 */  
    public static ConstantScoreQueryBuilder fromXContent(XContentParser parser) throws IOException {
    @Override  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        }
    protected boolean doEquals(ConstantScoreQueryBuilder other) {
import java.io.IOException;
        super(in);  
                    boost = parser.floatValue();  
public class ConstantScoreQueryBuilder extends AbstractQueryBuilder<ConstantScoreQueryBuilder> {  
