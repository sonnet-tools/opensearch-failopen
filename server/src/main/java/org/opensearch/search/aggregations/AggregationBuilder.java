    }
    public abstract Map<String, Object> getMetadata();
     * this method return the builder itself. If the builder did not change the
    /** Associate metadata with this {@link AggregationBuilder}. */
     * Create a shallow copy of this builder and replacing {@link #factoriesBuilder} and <code>metadata</code>.
            return shallowCopy(rewrittenSubAggs, getMetadata());
     * A rough count of the number of buckets that {@link Aggregator}s built
    protected final String name;
 */
    public final AggregationBuilder rewrite(QueryRewriteContext context) throws IOException {
 * compatible open source license.
    protected abstract AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata);
    protected AggregationBuilder(AggregationBuilder clone, AggregatorFactories.Builder factoriesBuilder) {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }
    /**
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
 * Licensed to Elasticsearch under one or more contributor
    /**
import java.io.IOException;
/**
    /**
        return this;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Rewriteable<AggregationBuilder> {
     * @return this factory (fluent interface)
 * @opensearch.api
    protected abstract AggregatorFactory build(QueryShardContext queryShardContext, AggregatorFactory parent) throws IOException;
    public String getName() {
    public String toString() {
        } else {
        } else if (rewrittenSubAggs != factoriesBuilder) {
 * SPDX-License-Identifier: Apache-2.0
    }
    }
    /** Add a sub aggregation to this builder. */
/*
     */
import org.opensearch.common.annotation.PublicApi;
    public abstract AggregationBuilder subAggregation(PipelineAggregationBuilder aggregation);
    @Override
 * You may obtain a copy of the License at
        AggregationBuilder rewritten = doRewrite(context);
     *
     * rewritten infinitely.
     * be responsible for the creation of sub-aggregators under the aggregator
 * The OpenSearch Contributors require contributions made to
        this.factoriesBuilder = factoriesBuilder;
    /** Return the configured set of pipeline aggregations **/
import org.opensearch.core.common.io.stream.NamedWriteable;
 *
    public abstract AggregationBuilder setMetadata(Map<String, Object> metadata);
import org.opensearch.core.common.Strings;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
 */
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
    /** Return any associated metadata with this {@link AggregationBuilder}. */
    /**
    }
            return this;
     */
     * {@link AggregatorFactories#parseAggregators(XContentParser)}.
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;
        return name;
     * aggregation results after the final reduction.
     * A rough count of the number of buckets that {@link Aggregator}s built
    /** Add a sub aggregation to this builder. */
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public PipelineTree buildPipelineTree() {
     * @opensearch.internal
    /**
 * not use this file except in compliance with the License.
     * by this builder will contain per parent bucket used to validate sorts
 * ownership. Elasticsearch licenses this file to you under
 *
    /**
        ONE,
    public Collection<PipelineAggregationBuilder> getPipelineAggregations() {
    /**
 * under the License.
    public abstract AggregationBuilder subAggregation(AggregationBuilder aggregation);
import org.opensearch.index.query.QueryRewriteContext;
 * software distributed under the License is distributed on an
     * Unlike {@link CardinalityUpperBound} which is <strong>total</strong>
        this.name = name;
    }
     * @opensearch.api
    public enum BucketCardinality {
 *
        if (name == null) {
    }
package org.opensearch.search.aggregations;
     * @param name  The aggregation name
            return rewritten.setMetadata(getMetadata()).subAggregations(rewrittenSubAggs);
 * this work for additional information regarding copyright
    protected AggregationBuilder(String name) {
    }
        return factoriesBuilder.getPipelineAggregatorFactories();
        return Strings.toString(MediaTypeRegistry.JSON, this);
    }
     * Build a tree of {@link PipelineAggregator}s to modify the tree of
     */
     */
     * instead of <strong>per parent bucket</strong>.
     */
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        return factoriesBuilder.buildPipelineTree();
     * identity reference must be returned otherwise the builder will be
     * <p>
    @PublicApi(since = "1.0.0")
            throw new IllegalArgumentException("[name] must not be null: [" + name + "]");
    /** Return this aggregation's name. */
        }
        }
    public static final class CommonFields extends ParseField.CommonFields {
     * created by this factory. This is only for use by
 * license agreements. See the NOTICE file distributed with
    @Override
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        return factoriesBuilder.getAggregatorFactories();
     * by this builder will contain per owning parent bucket.
        BaseAggregationBuilder,
     * @param subFactories
        NamedWriteable,
    implements
     * Common xcontent fields shared among aggregator builders
        AggregatorFactories.Builder rewrittenSubAggs = factoriesBuilder.rewrite(context);
        ToXContentFragment,
 * A factory that knows how to create an {@link Aggregator} of a specific type.
        NONE,
     * and pipeline aggregations. Just "zero", "one", and "many".
import org.opensearch.index.query.Rewriteable;
@PublicApi(since = "1.0.0")
     * Rewrites this aggregation builder into its primitive form. By default
 *
     *
        this.name = clone.name;
        public static final ParseField VALUE_TYPE = new ParseField("value_type");
    @Override
        if (rewritten != this) {
    /**
/*
        MANY;
import org.opensearch.core.ParseField;
    /** Return the configured set of subaggregations **/
     * Constructs a new aggregation builder.
    public abstract BucketCardinality bucketCardinality();
     * Used by {@link #rewrite(QueryRewriteContext)}.
     *            The sub-factories
     */
import java.util.Collection;
     *
    public abstract AggregationBuilder subAggregations(AggregatorFactories.Builder subFactories);
     */
}
    }
    public Collection<AggregationBuilder> getSubAggregations() {
import org.opensearch.index.query.QueryShardContext;
/*
    protected AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder();
    /** Internal: build an {@link AggregatorFactory} based on the configuration of this builder. */
     * Internal: Registers sub-factories with this factory. The sub-factory will
     *
 */
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
public abstract class AggregationBuilder
import org.opensearch.core.xcontent.XContentParser;
