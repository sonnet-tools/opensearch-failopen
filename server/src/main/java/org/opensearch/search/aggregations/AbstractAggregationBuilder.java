        return metadata == null ? Collections.emptyMap() : Collections.unmodifiableMap(metadata);
 * compatible open source license.
        AggregatorFactory factory = doBuild(queryShardContext, parent, factoriesBuilder);
    }  
    }  
import org.opensearch.core.xcontent.XContentBuilder;
    @Override  
 * You may obtain a copy of the License at  
import java.util.Objects;
 *  
        super(in.readString());
 * Unless required by applicable law or agreed to in writing,
     */  
     * created by this factory.
 * Modifications Copyright OpenSearch Contributors. See  
    @SuppressWarnings("unchecked")
    }
 * The OpenSearch Contributors require contributions made to  
    }
        metadata = in.readMap();
    ) {
    }  
        builder.startObject(name);
        AggregatorFactory parent,
     * @return this factory (fluent interface)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @SuppressWarnings("unchecked")
import java.util.Map;
    public AbstractAggregationBuilder(String name) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
     */
    }
    public final AggregatorFactory build(QueryShardContext queryShardContext, AggregatorFactory parent) throws IOException {  
        out.writeMap(metadata);
 * not use this file except in compliance with the License.
    @Override
     * Read from a stream.
    @SuppressWarnings("unchecked")  
        return (AB) this;
    public final void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
    }
        if (aggregation == null) {  
        return builder.endObject();
            throw new IllegalArgumentException("[metadata] must not be null: [" + name + "]");  
    protected Map<String, Object> metadata;
public abstract class AbstractAggregationBuilder<AB extends AbstractAggregationBuilder<AB>> extends AggregationBuilder {  
package org.opensearch.search.aggregations;
        if (this == obj) return true;
}
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }  
 */  
    @SuppressWarnings("unchecked")
        super(clone, factoriesBuilder);  
 * Base implementation of a {@link AggregationBuilder}.
        QueryShardContext queryShardContext,
/**
 * SPDX-License-Identifier: Apache-2.0
        // We always use the type of the aggregation as the writeable name
    public AB setMetadata(Map<String, Object> metadata) {
 * license agreements. See the NOTICE file distributed with
        return Objects.equals(name, other.name)  
    protected abstract XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException;
        builder.field(getType());
    ) throws IOException;
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override  
        AbstractAggregationBuilder<AB> clone,
    /**
    protected abstract AggregatorFactory doBuild(  
        return getType();
        doWriteTo(out);  
    }
    }
            builder.field("meta", this.metadata);
        internalXContent(builder, params);
    @Override  
        return (AB) this;
        queryShardContext.getUsageService().incAggregationUsage(getType(), factory.getStatsSubtype());
    public boolean equals(Object obj) {
        }
            && Objects.equals(factoriesBuilder, other.factoriesBuilder);
        AbstractAggregationBuilder<AB> other = (AbstractAggregationBuilder<AB>) obj;
    @Override  
        return factory;  
        return (AB) this;  
 *
        if (obj == null || getClass() != obj.getClass()) return false;  
    }
    @Override
        this.metadata = metadata;
     * responsible for the creation of sub-aggregators under the aggregator  
import java.io.IOException;
     */
        return (AB) this;  
     * Registers sub-factories with this factory. The sub-factory will be
    protected AbstractAggregationBuilder(
        if (this.metadata != null) {
        return Objects.hash(factoriesBuilder, metadata, name);  
            throw new IllegalArgumentException("[subFactories] must not be null: [" + name + "]");
import org.opensearch.index.query.QueryShardContext;  
    protected AbstractAggregationBuilder(StreamInput in) throws IOException {
        if (subFactories == null) {
     *            The sub-factories
     * @param subFactories  
        Map<String, Object> metadata
    }
 * this work for additional information regarding copyright
    public AB subAggregations(AggregatorFactories.Builder subFactories) {  
 */
            && Objects.equals(metadata, other.metadata)
     */  
    public final String getWriteableName() {  
        this.factoriesBuilder = subFactories;
/*
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
/*  
            throw new IllegalArgumentException("[aggregation] must not be null: [" + name + "]");
        }
        super(name);
    @Override
        }  
        }
    public int hashCode() {
 */
        AggregatorFactories.Builder subfactoriesBuilder  
     * Add a sub aggregation to this aggregation.
    @Override
            builder.field("aggregations");
    }  
 * Licensed to Elasticsearch under one or more contributor  
    /**
import java.util.Collections;  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 *  
 * @opensearch.internal
     *  
        out.writeString(name);  
    public Map<String, Object> getMetadata() {
        AggregatorFactories.Builder factoriesBuilder,  
 * software distributed under the License is distributed on an
        factoriesBuilder.writeTo(out);
        if (aggregation == null) {
 */
    public AB subAggregation(PipelineAggregationBuilder aggregation) {
     * @param name  The aggregation name
/*
        factoriesBuilder.addAggregator(aggregation);
    @Override
        factoriesBuilder = new AggregatorFactories.Builder(in);  
 * specific language governing permissions and limitations
    @Override  
    public AB subAggregation(AggregationBuilder aggregation) {
            factoriesBuilder.toXContent(builder, params);  
     *
            throw new IllegalArgumentException("[aggregation] must not be null: [" + name + "]");  
    protected abstract void doWriteTo(StreamOutput out) throws IOException;  
        if (metadata == null) {
    }  
 *
        factoriesBuilder.addPipelineAggregator(aggregation);  
        if (factoriesBuilder != null && (factoriesBuilder.count()) > 0) {
    /**  
     * Constructs a new aggregation builder.
        this.metadata = metadata;
    }
        }
