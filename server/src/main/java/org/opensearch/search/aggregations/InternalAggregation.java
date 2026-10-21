 */
     * Read a size under the assumption that a value of 0 means unlimited.
    protected final Map<String, Object> metadata;
         */
import java.util.function.Function;
            IntConsumer multiBucketConsumer,
 */
        private final ScriptService scriptService;
        return Objects.equals(name, other.name) && Objects.equals(metadata, other.metadata);
        public static ReduceContext forFinalReduction(
     * Signal the framework if the {@linkplain InternalAggregation#reduce(List, ReduceContext)} phase needs to be called
    public double sortValue(String key) {
         * Build a {@linkplain ReduceContext} to perform a partial reduction.
            Supplier<PipelineTree> pipelineTreeForBwcSerialization
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Return true if this aggregation is mapped, and can lead a reduction.  If this agg returns
    public InternalAggregation copyWithRewritenBuckets(Function<InternalAggregations, InternalAggregations> rewriter) {
    public void forEachBucket(Consumer<InternalAggregations> consumer) {}
        ReduceContext reduceContext,
                bigArrays,
    public Map<String, Object> getMetadata() {
import java.util.Objects;
     * Get the value of specified path in the aggregation.
            PipelineTree pipelineTreeRoot,
            return scriptService;
import java.util.function.IntConsumer;
    /**
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Consumer;
                multiBucketConsumer,
     * <p>
    }
     * try reusing an existing instance (typically the first in the given list) to save on redundant object
        private final IntConsumer multiBucketConsumer;
 * software distributed under the License is distributed on an
/*
        return getWriteableName();
            builder.map(this.metadata);
        private final PipelineTree pipelineTreeRoot;
        // subclasses will override this with a real implementation if you can sort on a descendant
     */
        return Strings.toString(MediaTypeRegistry.JSON, this);
import org.opensearch.core.common.io.stream.StreamOutput;
        private boolean isSliceLevel;
        InternalAggregation other = (InternalAggregation) obj;
        return name;
        /**
    /**
     * Write a size under the assumption that a value of 0 means unlimited.
 * under the License.
    protected abstract void doWriteTo(StreamOutput out) throws IOException;
import java.util.Iterator;
    public String getName() {
        return builder;
     * when there is only one {@linkplain InternalAggregation}.
     * Creates the output from all pipeline aggs that this aggregation is associated with.  Should only
     * should be overridden by aggregations that contain buckets. Implementers
import org.opensearch.script.ScriptService;
        /**
    public String toString() {
        }
         * whereas for coordinator level partial reduce it will use top level `size` and `min_doc_count`
        /**
 * this file be licensed under the Apache-2.0 license or a
     * Builds {@link ReduceContext}.
            IntConsumer multiBucketConsumer,
        }
    public final void writeTo(StreamOutput out) throws IOException {
     * false, it should return itself if asked to lead a reduction
import org.opensearch.core.xcontent.XContentBuilder;
    }
            this.isSliceLevel = false;
    /**
         */
import org.opensearch.core.common.Strings;
     * rewritten buckets, or, if there aren't any modifications to
        PipelineTree pipelinesForThisAgg
 * An internal implementation of {@link Aggregation}. Serves as a base class for all aggregation implementations.
 * @opensearch.api
            this.scriptService = scriptService;
        }
        return true;
        ) {
     * way, it doesn't modify this aggregation.
    @Override
    @PublicApi(since = "1.0.0")
    }
    /**
 *
     */
                scriptService,
         * the maximum number of buckets allowed in a response
        }
         */
        doWriteTo(out);
        }
 * Modifications Copyright OpenSearch Contributors. See
            BigArrays bigArrays,
        }
            this.isSliceLevel = sliceLevel;
 * compatible open source license.
        assert reduceContext.isFinalReduce();
        public static ReduceContext forPartialReduction(
            } else {
            "Aggregation [" + getName() + "] must be a bucket aggregation but was [" + getWriteableName() + "]"
    public int hashCode() {
        private ReduceContext(
    }
        }
import java.io.IOException;
        for (PipelineAggregator pipelineAggregator : pipelinesForThisAgg.aggregators()) {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        return size == 0 ? Integer.MAX_VALUE : size;
 * this work for additional information regarding copyright
        public boolean isFinalReduce() {
    public InternalAggregation reducePipelines(
     * <p>
import org.opensearch.core.xcontent.MediaTypeRegistry;
     */
        builder.endObject();
        this.metadata = metadata;
 *
         * The root of the tree of pipeline aggregations for this request.
            );
        if (obj == this) {
    }
            this.bigArrays = bigArrays;
    }
            builder.field(CommonFields.META.getPreferredName());
    @Override
    public interface ReduceContextBuilder {
 *
                return new LocalBucketCountThresholds(bucketCountThresholds.getShardMinDocCount(), bucketCountThresholds.getShardSize());
 * ownership. Elasticsearch licenses this file to you under
            return pipelineTreeRoot;
     * Reduces the given aggregations to a single one and returns it. In <b>most</b> cases, the assumption will be the all given
import org.opensearch.search.aggregations.support.AggregationPath;
    protected final String name;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    public abstract InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext);
     * aggregations are of the same type (the same type as this aggregation). For best efficiency, when implementing,
    /**
        /**
            // Concatenates the type and the name of the aggregation (ex: top_hits#foo)
    /**
        this.name = name;
            BigArrays bigArrays,
     * Run a {@linkplain Consumer} over all buckets in this aggregation.
        }
         * Build a {@linkplain ReduceContext} to perform the final reduction.
                () -> pipelineTreeRoot
     * Get value to use when sorting by a descendant of this aggregation.
        if (this.metadata != null) {
            ScriptService scriptService,
        private final BigArrays bigArrays;
    @Override
         */
        }
 * license agreements. See the NOTICE file distributed with
    @PublicApi(since = "1.0.0")
        ReduceContext forPartialReduction();
        }
     * the buckets then this method will return this aggregation. Either
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
        InternalAggregation reducedAggs,
        public PipelineTree pipelineTreeRoot() {
    protected abstract boolean mustReduceOnSingleInternalAgg();
 */
        public LocalBucketCountThresholds asLocalBucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {
        out.writeGenericValue(metadata);
     * The reduce context
     * Get value to use when sorting by this aggregation.
        private final Supplier<PipelineTree> pipelineTreeForBwcSerialization;
    }
            PipelineTree pipelineTreeRoot
    @Override
        /**
    }
        if (size == Integer.MAX_VALUE) {
 * You may obtain a copy of the License at
     *
     *
        out.writeString(name);
     * @opensearch.api
         * @param pipelineTreeRoot The root of tree of pipeline aggregations for this request
    protected InternalAggregation(StreamInput in) throws IOException {
        /**
        ) {
         */
         * Build a {@linkplain ReduceContext} to perform a partial reduction.
}
import java.util.List;
        /**
        public Supplier<PipelineTree> pipelineTreeForBwcSerialization() {
    protected InternalAggregation(String name, Map<String, Object> metadata) {
    protected static void writeSize(int size, StreamOutput out) throws IOException {
     *
        ) {
        }
        }
     * @param name The name of the aggregation.
 * Licensed to Elasticsearch under one or more contributor
     * should respect the description above.
         * Adds {@code count} buckets to the global count for the request and fails if this number is greater than
    }
            return false;
    ) {
     * Implementers of this should call the {@code rewriter} once per bucket
 *
            ScriptService scriptService,
@PublicApi(since = "1.0.0")
         * Returns <code>true</code> iff the current reduce phase is the final reduce phase. This indicates if operations like
    }
        out.writeVInt(size);
        if (obj == null || getClass() != obj.getClass()) {
            multiBucketConsumer.accept(size);
    @Override
        ReduceContext forFinalReduction();
         * to node versions that need pipeline aggregators to be serialized
import org.opensearch.common.annotation.PublicApi;
    @Override
     */
     */
    protected static int readSize(StreamInput in) throws IOException {
        doXContentBody(builder, params);
     * @return the value of the property
/*
         */
        /**
        }
     * it should return a new {@linkplain InternalAggregations} to make
        public ScriptService scriptService() {
        return metadata;
     * @param path
            return new ReduceContext(
    }
        }
            this.pipelineTreeRoot = pipelineTreeRoot;
     *            the path to the property in the aggregation tree
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
     */
     */
    }
     */
    public boolean equals(Object obj) {
            builder.startObject(getName());
         * For slice level partial reduce we will apply shard level `shard_size` and `shard_min_doc_count` limits
/*
    /**
import static java.util.Objects.requireNonNull;
            ScriptService scriptService,
         */
 * KIND, either express or implied.  See the License for the
            reducedAggs = pipelineAggregator.reduce(reducedAggs, reduceContext);
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    /**
    public Object getProperty(String path) {
        public BigArrays bigArrays() {
    }
        return getProperty(aggPath.getPathElementsAsStringList());
     * Read from a stream.
            this.pipelineTreeForBwcSerialization = pipelineTreeForBwcSerialization;
    public static class ReduceContext {
 * GitHub history for details.
         */
        return Objects.hash(name, metadata);
    public double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {
    /**
            return pipelineTreeForBwcSerialization;
            size = 0;
        } else {
    public abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;
     * Rewrite the sub-aggregations in the buckets in this aggregation.
         */
    }
         * Supplies the pipelines when the result of the reduce is serialized
import org.opensearch.rest.action.search.RestSearchAction;
        throw new IllegalArgumentException("Can't sort by a descendant of a [" + getType() + "] aggregation [" + head + "]");
        if (params.paramAsBoolean(RestSearchAction.TYPED_KEYS_PARAM, false)) {
         * pipeline aggregations should be applied or if specific features like {@code minDocCount} should be taken into account.
    }
    }
        throw new IllegalArgumentException("Can't sort a [" + getType() + "] aggregation [" + getName() + "]");
    }
/**
import org.opensearch.common.util.BigArrays;
package org.opensearch.search.aggregations;
    }
                return new LocalBucketCountThresholds(bucketCountThresholds.getMinDocCount(), bucketCountThresholds.getRequiredSize());
            return true;
        }
public abstract class InternalAggregation implements Aggregation, NamedWriteable {
        // subclasses will override this with a real implementation if they can be sorted
        /**
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                requireNonNull(pipelineTreeRoot, "prefer EMPTY to null"),
            return pipelineTreeRoot != null;
     * should return {@code null} if it doen't have any rewriting to do or
        name = in.readString();
import org.opensearch.core.common.io.stream.NamedWriteable;
         * Build a {@linkplain ReduceContext} to perform the final reduction.
     */
 * The OpenSearch Contributors require contributions made to
        return reducedAggs;
     */
         * to node versions that need pipeline aggregators to be serialized
    /**
    }
     *
        final int size = in.readVInt();
        public boolean isSliceLevel() {
     * Returns a copy of this {@linkplain InternalAggregation} with the
     */
     *
            return new ReduceContext(bigArrays, scriptService, (s) -> {}, null, pipelineTreeForBwcSerialization);
            builder.startObject(String.join(TYPED_KEYS_DELIMITER, getType(), getName()));
     * The default implementation throws an exception because most
     */
         */
    /**
        );
     * @see #mustReduceOnSingleInternalAgg()
    @Override
        public void setSliceLevel(boolean sliceLevel) {
     * be called after all aggregations have been fully reduced
     * with its {@linkplain InternalAggregations}. The {@code rewriter}
     */
        }
     */
        public void consumeBucketsAndMaybeBreak(int size) {
            return this.isSliceLevel;
    }
    /**
        throw new IllegalStateException(
     * Constructs an aggregation result with a given name.
        metadata = in.readMap();
     * construction.
            Supplier<PipelineTree> pipelineTreeForBwcSerialization
    public abstract Object getProperty(List<String> path);
     */
    /**
    public boolean isMapped() {
     * changs.
         * Operations that are potentially losing information can only be applied during the final reduce phase.
 * SPDX-License-Identifier: Apache-2.0
         * to them.
        /**
    /**
     * @opensearch.api
import java.util.function.Supplier;
 * the Apache License, Version 2.0 (the "License"); you may
        }
    @Override
            BigArrays bigArrays,
         * Supplies the pipelines when the result of the reduce is serialized
        }
        AggregationPath aggPath = AggregationPath.parse(path);
         * to them.
    public String getType() {
            }
 * specific language governing permissions and limitations
     * aggregations don't <strong>have</strong> buckets in them. It
            if (isSliceLevel()) {
            return bigArrays;
 */
import org.opensearch.core.common.io.stream.StreamInput;
            this.multiBucketConsumer = multiBucketConsumer;
