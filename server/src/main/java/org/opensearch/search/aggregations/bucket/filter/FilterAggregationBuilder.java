    }  
    public static FilterAggregationBuilder parse(XContentParser parser, String aggregationName) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    public BucketCardinality bucketCardinality() {
import org.opensearch.index.query.QueryBuilder;
        FilterAggregationBuilder clone,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
        return new FilterAggregationBuilder(this, factoriesBuilder, metadata);  
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
    ) throws IOException {
 * @opensearch.internal
/*
import org.opensearch.search.aggregations.AggregationBuilder;
    @Override  
        return Objects.hash(super.hashCode(), filter);  
import org.opensearch.index.query.QueryRewriteContext;  
    @Override  
 */  
     *            Set the filter to use, only documents that match this
    protected AggregatorFactory doBuild(
 *
        return this;  
        FilterAggregationBuilder other = (FilterAggregationBuilder) obj;
 * KIND, either express or implied.  See the License for the
 */
 * SPDX-License-Identifier: Apache-2.0
        if (super.equals(obj) == false) return false;
package org.opensearch.search.aggregations.bucket.filter;
    /**  
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
     * Read from a stream.
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        AggregatorFactories.Builder subFactoriesBuilder
    public static final String NAME = "filter";
    public String getType() {
 *
import java.util.Map;  
        QueryBuilder result = Rewriteable.rewrite(filter, queryShardContext);
    protected void doWriteTo(StreamOutput out) throws IOException {  
    }
    public boolean equals(Object obj) {
            filter.toXContent(builder, params);  
        super(name);  
        if (filter != null) {
    }
     */
     * @param filter  
import java.util.Objects;
 */  
    @Override  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */  
 * compatible open source license.
        this.filter = clone.filter;
     *            {@link Filter} aggregation.  
 *  
    }
import org.opensearch.search.aggregations.AggregatorFactories;
    ) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("[filter] must not be null: [" + name + "]");
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.index.query.QueryShardContext;
/*  
     *            filter will fall into the bucket defined by this
        return new FilterAggregatorFactory(name, filter, queryShardContext, parent, subFactoriesBuilder, metadata);  
    private final QueryBuilder filter;
/*  
     *            the name of this aggregation
        QueryBuilder filter = parseInnerQueryBuilder(parser);  
    /**  
        }
    }
     * @param name
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    @Override
 * under the License.  
 * You may obtain a copy of the License at  
        AggregatorFactories.Builder factoriesBuilder,  
 *
    @Override
        return Objects.equals(filter, other.filter);  
 * ownership. Elasticsearch licenses this file to you under  
        if (filter == null) {
    }
        return new FilterAggregationBuilder(aggregationName, filter);
    }  
    @Override
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;  
        filter = in.readNamedWriteable(QueryBuilder.class);
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        this.filter = filter;
/**
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    protected FilterAggregationBuilder(
        }
        return NAME;
    public QueryBuilder getFilter() {
        return filter;  
        if (this == obj) return true;
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.search.aggregations.AggregatorFactory;  
            return new FilterAggregationBuilder(getName(), result);
        AggregatorFactory parent,  
 * Licensed to Elasticsearch under one or more contributor  
public class FilterAggregationBuilder extends AbstractAggregationBuilder<FilterAggregationBuilder> {
 * Aggregation Builder for filter agg  
    @Override  
    }
        if (obj == null || getClass() != obj.getClass()) return false;  
        out.writeNamedWriteable(filter);
        return builder;
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
 * GitHub history for details.
        Map<String, Object> metadata
}
    }  
        super(in);
     */
    }
        if (result != filter) {  
        return BucketCardinality.ONE;  
    public FilterAggregationBuilder(StreamInput in) throws IOException {  
    }
    public FilterAggregationBuilder(String name, QueryBuilder filter) {
import org.opensearch.index.query.Rewriteable;
import java.io.IOException;
        }  
    }
import org.opensearch.core.xcontent.XContentBuilder;  
    public int hashCode() {
    @Override
        super(clone, factoriesBuilder, metadata);  
        QueryShardContext queryShardContext,
