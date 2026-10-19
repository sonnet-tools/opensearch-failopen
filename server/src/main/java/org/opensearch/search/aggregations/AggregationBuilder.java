     */
    @Override
    /** Add a sub aggregation to this builder. */
        if (name == null) {  
     *
    /**
    public enum BucketCardinality {
import org.opensearch.index.query.QueryRewriteContext;
    /** Return this aggregation's name. */
/*  
 * A factory that knows how to create an {@link Aggregator} of a specific type.  
    }
        } else if (rewrittenSubAggs != factoriesBuilder) {
    }  
import org.opensearch.core.common.io.stream.NamedWriteable;  
     * Build a tree of {@link PipelineAggregator}s to modify the tree of
     * this method return the builder itself. If the builder did not change the
}
        this.name = clone.name;
    public String getName() {  
        return name;
     * created by this factory. This is only for use by  
    /** Associate metadata with this {@link AggregationBuilder}. */
import org.opensearch.core.ParseField;
    public Collection<PipelineAggregationBuilder> getPipelineAggregations() {
    @PublicApi(since = "1.0.0")  
     */  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    public static final class CommonFields extends ParseField.CommonFields {  
    /**
 * GitHub history for details.
            return rewritten.setMetadata(getMetadata()).subAggregations(rewrittenSubAggs);  
    implements  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public abstract AggregationBuilder subAggregation(AggregationBuilder aggregation);  
    }  
    /** Internal: build an {@link AggregatorFactory} based on the configuration of this builder. */
     * A rough count of the number of buckets that {@link Aggregator}s built  
     */
        this.factoriesBuilder = factoriesBuilder;
        return factoriesBuilder.buildPipelineTree();
    }
     * by this builder will contain per owning parent bucket.  
 * You may obtain a copy of the License at  
 *
     */
/*
     * {@link AggregatorFactories#parseAggregators(XContentParser)}.
/**
import org.opensearch.core.xcontent.XContentParser;  
     */
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
     * Unlike {@link CardinalityUpperBound} which is <strong>total</strong>
     * Common xcontent fields shared among aggregator builders
    }
 *
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    public PipelineTree buildPipelineTree() {
    @Override
    }
import org.opensearch.index.query.QueryShardContext;
    protected AggregationBuilder(String name) {
    @Override
        Rewriteable<AggregationBuilder> {
 */  
            return this;
 * KIND, either express or implied.  See the License for the
    }
    public abstract AggregationBuilder subAggregation(PipelineAggregationBuilder aggregation);  
    public abstract Map<String, Object> getMetadata();  
     * by this builder will contain per parent bucket used to validate sorts
    @Override
            throw new IllegalArgumentException("[name] must not be null: [" + name + "]");
            return shallowCopy(rewrittenSubAggs, getMetadata());
     * rewritten infinitely.  
 * specific language governing permissions and limitations
        BaseAggregationBuilder,  
        NONE,
     *  
    public Collection<AggregationBuilder> getSubAggregations() {  
     * Create a shallow copy of this builder and replacing {@link #factoriesBuilder} and <code>metadata</code>.
 * ownership. Elasticsearch licenses this file to you under  
     * @param subFactories  
     */
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        return this;  
 * this file be licensed under the Apache-2.0 license or a
        } else {  
import org.opensearch.index.query.Rewriteable;  
        NamedWriteable,
     */  
        AggregationBuilder rewritten = doRewrite(context);  
    /**  
    protected final String name;  
     *            The sub-factories
    protected AggregationBuilder(AggregationBuilder clone, AggregatorFactories.Builder factoriesBuilder) {  
 * The OpenSearch Contributors require contributions made to  
 */
import org.opensearch.common.annotation.PublicApi;  
    /** Return the configured set of subaggregations **/
    public abstract BucketCardinality bucketCardinality();
import java.util.Map;  
     * @opensearch.api
     * Constructs a new aggregation builder.
     * Internal: Registers sub-factories with this factory. The sub-factory will
        ToXContentFragment,
    protected abstract AggregatorFactory build(QueryShardContext queryShardContext, AggregatorFactory parent) throws IOException;
 * the Apache License, Version 2.0 (the "License"); you may
     * @opensearch.internal
 */
     * be responsible for the creation of sub-aggregators under the aggregator
     * Rewrites this aggregation builder into its primitive form. By default  
     * <p>  
     * @param name  The aggregation name  
    }
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
    /** Add a sub aggregation to this builder. */
     */
import org.opensearch.core.xcontent.ToXContentFragment;
     * A rough count of the number of buckets that {@link Aggregator}s built
 *  
 *
    /**  
    public abstract AggregationBuilder subAggregations(AggregatorFactories.Builder subFactories);
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    protected AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder();
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations;
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    protected abstract AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata);
        }
     * @return this factory (fluent interface)
        if (rewritten != this) {
    /**  
        ONE,  
 * Modifications Copyright OpenSearch Contributors. See  
     *
    /**
    /**
 * under the License.  
    /** Return any associated metadata with this {@link AggregationBuilder}. */
    public final AggregationBuilder rewrite(QueryRewriteContext context) throws IOException {
    /** Return the configured set of pipeline aggregations **/
     * instead of <strong>per parent bucket</strong>.
     * identity reference must be returned otherwise the builder will be
 * Licensed to Elasticsearch under one or more contributor  
        public static final ParseField VALUE_TYPE = new ParseField("value_type");
 * @opensearch.api
import org.opensearch.core.common.Strings;
import java.util.Collection;
        this.name = name;  
        return factoriesBuilder.getAggregatorFactories();
     *  
    public String toString() {
     * aggregation results after the final reduction.
     * and pipeline aggregations. Just "zero", "one", and "many".
        return factoriesBuilder.getPipelineAggregatorFactories();  
    public abstract AggregationBuilder setMetadata(Map<String, Object> metadata);  
    }
        MANY;
    /**
     * Used by {@link #rewrite(QueryRewriteContext)}.  
        AggregatorFactories.Builder rewrittenSubAggs = factoriesBuilder.rewrite(context);
        }
/*
        return Strings.toString(MediaTypeRegistry.JSON, this);  
@PublicApi(since = "1.0.0")
 * compatible open source license.
public abstract class AggregationBuilder
 */  
