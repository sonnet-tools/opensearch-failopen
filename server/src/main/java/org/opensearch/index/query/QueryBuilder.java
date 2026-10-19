     * parent queries.
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
     */
    QueryBuilder boost(float boost);  
     * Returns {@code null} if this query should be ignored in the context of  
     *
/*  
     */
/**
     * @return the {@link Query} or {@code null} if this query should be ignored upstream
    default QueryBuilder rewrite(QueryRewriteContext queryShardContext) throws IOException {  
    @Override
    /**  
package org.opensearch.index.query;
     * This function combines a filter with a query builder. If the query builder itself has
     *
     * {@link QueryBuilder} so that calls can be chained. This is done
 * license agreements. See the NOTICE file distributed with
 *
     * Default is {@code false} - queries must explicitly opt-in.  
    default void visit(QueryBuilderVisitor visitor) {
     * Returns the boost for this query.
     * Sets the boost for this query.  Documents matching this query will (in addition to the normal  
    QueryBuilder filter(QueryBuilder filter);
     * Recurse through the QueryBuilder tree, visiting any child QueryBuilder.
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * a filter we will combine the filter and return the query builder itself.  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
     * {@link QueryBuilder} so that calls can be chained. This is done  
     * Converts this QueryBuilder to a lucene {@link Query}.
     */
     * If the filter is null we simply return the query builder without any operation.  
 * specific language governing permissions and limitations
 */  
    /**
 *  
@PublicApi(since = "1.0.0")
/*
     * @param visitor a query builder visitor to be called by each query builder in the tree.  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.NamedWriteable;  
}  
 * ownership. Elasticsearch licenses this file to you under  
     * @param filter The null filter to be added to the existing filter.
     * did not change the identity reference must be returned otherwise the builder will be rewritten infinitely.  
        return this;
/*  
     * Returns the name that identifies uniquely the query  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * not use this file except in compliance with the License.
    default boolean supportsIntraSegmentSearch() {
 */  
        visitor.accept(this);  
     * Indicates whether this query benefits from intra-segment search.
     * @return A QueryBuilder with the filter added to the existing filter.  
    /**
     */
 * KIND, either express or implied.  See the License for the
     * weightings) have their score multiplied by the boost provided.
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
    };
    QueryBuilder queryName(String queryName);
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
     * Implementers should return the concrete type of the
     * Implementers should return the concrete type of the
 * under the License.  
    float boost();  
     */
    Query toQuery(QueryShardContext context) throws IOException;  
import org.apache.lucene.search.Query;
     * Override to return {@code true} for compute-heavy queries that parallelize well
     * automatically when extending {@link AbstractQueryBuilder}.
     */
    /**
    String queryName();
     * Rewrites this query builder into its primitive form. By default this method return the builder itself. If the builder
    /**  
public interface QueryBuilder extends NamedWriteable, ToXContentObject, Rewriteable<QueryBuilder> {
    String getName();
    /**
 */
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
     */
    /**
     */
     * @param context additional information needed to construct the queries  
     * Returns the arbitrary name assigned to the query (see named queries).
     * If not we will use a bool query builder to combine the query builder and
 *
 * The OpenSearch Contributors require contributions made to  
     * Sets the arbitrary name to be assigned to the query (see named queries).  
     */  
    /**
 * Licensed to Elasticsearch under one or more contributor  
     * the filter and then return the bool query builder.
import org.opensearch.core.xcontent.ToXContentObject;
 * GitHub history for details.
 *
        return false;  
 */  
 * @opensearch.api
    }
 * Foundation class for all OpenSearch query builders  
 * compatible open source license.
     * automatically when extending {@link AbstractQueryBuilder}.  
