                    parser.getTokenLocation(),  
                if (SamplerAggregator.SHARD_SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return Objects.hash(super.hashCode(), shardSize);  
    public SamplerAggregationBuilder(String name) {
    public int shardSize() {  
     * Set the max num docs to be returned from each shard.
 */  
                    "Unsupported property \"" + currentFieldName + "\" for aggregation \"" + aggregationName
    private int shardSize = DEFAULT_SHARD_SAMPLE_SIZE;
        builder.endObject();
     */
    public String getType() {
 * Licensed to Elasticsearch under one or more contributor  
        return builder;
    @Override  
    }
    }
     * Read from a stream.
import java.io.IOException;  
 * Aggregation Builder for sampler agg
        return this;  
 * license agreements. See the NOTICE file distributed with
 *  
     * Get the max num docs to be returned from each shard.
            factory.shardSize(shardSize);
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
                } else {
     */
        if (super.equals(obj) == false) return false;
        if (obj == null || getClass() != obj.getClass()) return false;  
                    );
    }
import java.util.Objects;
 *  
        out.writeVInt(shardSize);
        return BucketCardinality.ONE;  
 *
    protected SamplerAggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
import java.util.Map;
        builder.field(SamplerAggregator.SHARD_SIZE_FIELD.getPreferredName(), shardSize);  
                currentFieldName = parser.currentName();  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
package org.opensearch.search.aggregations.bucket.sampler;
    protected void doWriteTo(StreamOutput out) throws IOException {  
    @Override
        return NAME;
        super(name);
 */
                throw new ParsingException(
        }  
                }  
    }  
}
    public SamplerAggregationBuilder(StreamInput in) throws IOException {  
    }
        builder.startObject();
 * not use this file except in compliance with the License.
        this.shardSize = shardSize;
    public boolean equals(Object obj) {
    public BucketCardinality bucketCardinality() {
    }
        return factory;
        return new SamplerAggregatorFactory(name, shardSize, queryShardContext, parent, subFactoriesBuilder, metadata);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override  
        super(clone, factoriesBuilder, metadata);  
                        parser.getTokenLocation(),  
 * The OpenSearch Contributors require contributions made to  
        throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.AggregationBuilder;
        if (this == obj) return true;
            }  
public class SamplerAggregationBuilder extends AbstractAggregationBuilder<SamplerAggregationBuilder> {  
        SamplerAggregationBuilder other = (SamplerAggregationBuilder) obj;
        String currentFieldName = null;
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
        Integer shardSize = null;
    }  
    }
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
        super(in);
 *
 */  
                );
        SamplerAggregationBuilder factory = new SamplerAggregationBuilder(aggregationName);  
 * @opensearch.internal
        shardSize = in.readVInt();
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * KIND, either express or implied.  See the License for the
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        return new SamplerAggregationBuilder(this, factoriesBuilder, metadata);  
    }  
/*  
 * Unless required by applicable law or agreed to in writing,
/**
    /**  
        this.shardSize = clone.shardSize;
import org.opensearch.core.common.ParsingException;
        XContentParser.Token token;  
/*
    public SamplerAggregationBuilder shardSize(int shardSize) {
    public int hashCode() {
     */  
        return Objects.equals(shardSize, other.shardSize);  
import org.opensearch.search.aggregations.AggregatorFactory;
    }
        if (shardSize != null) {
 * this work for additional information regarding copyright
            } else {
 * software distributed under the License is distributed on an
        }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public static final int DEFAULT_SHARD_SAMPLE_SIZE = 100;  
    protected SamplerAggregationBuilder(SamplerAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
        return shardSize;
    /**  
 * compatible open source license.
                    throw new ParsingException(
                        "Unsupported property \"" + currentFieldName + "\" for aggregation \"" + aggregationName
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
                    shardSize = parser.intValue();  
    public static final String NAME = "sampler";
            if (token == XContentParser.Token.FIELD_NAME) {
/*  
    public static SamplerAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
import org.opensearch.index.query.QueryShardContext;  
    }  
 */
 * under the License.  
    @Override
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
    @Override  
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
 * You may obtain a copy of the License at  
 * GitHub history for details.
