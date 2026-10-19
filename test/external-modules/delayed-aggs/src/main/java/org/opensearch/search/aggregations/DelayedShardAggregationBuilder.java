    @Override  
                } while (searchContext.getRelativeTimeInMillis() - start < delay.getMillis());
    public BucketCardinality bucketCardinality() {
        return Objects.hash(super.hashCode(), delay);
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
                        Thread.sleep(sleepTime);  
import java.util.Objects;
 */
 * Unless required by applicable law or agreed to in writing,
    @Override  
                CardinalityUpperBound cardinality,
 * under the License.  
import java.io.IOException;  
        AggregatorFactories.Builder subfactoriesBuilder
 */  
    @Override  
            protected boolean supportsConcurrentSegmentSearch() {  
        super(in);  
        );
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("value"));  
/*  
 */  
 * software distributed under the License is distributed on an
        // Disable the request cache
package org.opensearch.search.aggregations;
        return new AggregatorFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata) {  
    }
    );  
import org.opensearch.common.unit.TimeValue;
    ) throws IOException {  
    public boolean equals(Object o) {
        return NAME;
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;  
        if (this == o) return true;
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
            protected Aggregator createInternal(
            }  
            subfactoriesBuilder  
                do {
        final FilterAggregationBuilder filterAgg = new FilterAggregationBuilder(name, QueryBuilders.matchAllQuery()).subAggregations(
    public String getType() {  
                Aggregator parent,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeTimeValue(delay);  
/*  
import java.util.Map;
    private TimeValue delay;
    protected AggregatorFactory doBuild(
        (args, name) -> new DelayedShardAggregationBuilder(name, TimeValue.parseTimeValue((String) args[0], "value"))
    }  
                        throw new IOException(e);
public class DelayedShardAggregationBuilder extends AbstractAggregationBuilder<DelayedShardAggregationBuilder> {
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metaData) {
 * not use this file except in compliance with the License.
 * compatible open source license.
                    } catch (InterruptedException e) {
                long start = searchContext.getRelativeTimeInMillis();
    }
import org.opensearch.search.internal.SearchContext;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        return new DelayedShardAggregationBuilder(name, delay);  
    }  
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject();
        return builder;
                SearchContext searchContext,  
    static final ConstructingObjectParser<DelayedShardAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
        if (!super.equals(o)) return false;
                    }
import org.opensearch.core.common.io.stream.StreamInput;  
        QueryShardContext queryShardContext,  
    public DelayedShardAggregationBuilder(StreamInput in) throws IOException {
 * GitHub history for details.
        builder.field("value", delay.toString());  
            @Override
        this.delay = delay;
    @Override  
        if (o == null || getClass() != o.getClass()) return false;  
}
 *
import org.opensearch.core.xcontent.XContentBuilder;  
    protected void doWriteTo(StreamOutput out) throws IOException {
        this.delay = in.readTimeValue();
    @Override  
                    try {
        NAME,  
    static {
    }
 * Licensed to Elasticsearch under one or more contributor  
        };  
 * specific language governing permissions and limitations
 *  
    public DelayedShardAggregationBuilder(String name, TimeValue delay) {  
        DelayedShardAggregationBuilder that = (DelayedShardAggregationBuilder) o;
        final AggregatorFactory factory = filterAgg.build(queryShardContext, parent);
import org.opensearch.index.query.QueryShardContext;
    @Override
                    if (searchContext.isCancelled()) {
        super(name);
                return true;
        queryShardContext.nowInMillis();  
    }
        return Objects.equals(delay, that.delay);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        false,
    }
            ) throws IOException {
/*
    }
    @Override
import org.opensearch.core.ParseField;
 * this work for additional information regarding copyright
                    }  
import org.opensearch.index.query.QueryBuilders;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 *
                        break;  
    @Override
                long sleepTime = Math.min(delay.getMillis(), 100);  
    public int hashCode() {
                return factory.create(searchContext, parent, cardinality);
        return BucketCardinality.ONE;
    }
            }
    public static final String NAME = "shard_delay";
    }  
        builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
        AggregatorFactory parent,
import org.opensearch.core.xcontent.ConstructingObjectParser;
                Map<String, Object> metadata  
    @SuppressWarnings("unchecked")
