 *  
            this.multiBucketConsumer = multiBucketConsumer;
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * Creates the output from all pipeline aggs that this aggregation is associated with.  Should only
    /**
     *  
    protected final String name;
        /**
import static java.util.Objects.requireNonNull;
    public boolean equals(Object obj) {
        if (this.metadata != null) {  
import java.util.Objects;
        }
    protected static int readSize(StreamInput in) throws IOException {  
import org.opensearch.script.ScriptService;  
    }  
        doWriteTo(out);  
 * compatible open source license.
 */
        private boolean isSliceLevel;
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
     * should be overridden by aggregations that contain buckets. Implementers
 *
 */
package org.opensearch.search.aggregations;
 * Unless required by applicable law or agreed to in writing,
    }
         * Supplies the pipelines when the result of the reduce is serialized
            return false;
         * pipeline aggregations should be applied or if specific features like {@code minDocCount} should be taken into account.  
     * Write a size under the assumption that a value of 0 means unlimited.  
        ) {
import java.util.function.Function;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
public abstract class InternalAggregation implements Aggregation, NamedWriteable {
            "Aggregation [" + getName() + "] must be a bucket aggregation but was [" + getWriteableName() + "]"  
    @Override
        }
        private final Supplier<PipelineTree> pipelineTreeForBwcSerialization;
        return getWriteableName();
    /**
    @Override
            } else {
        // subclasses will override this with a real implementation if they can be sorted
                return new LocalBucketCountThresholds(bucketCountThresholds.getShardMinDocCount(), bucketCountThresholds.getShardSize());  
    /**  
    public double sortValue(String key) {
    public int hashCode() {  
        return metadata;
        /**
     * <p>
    public InternalAggregation copyWithRewritenBuckets(Function<InternalAggregations, InternalAggregations> rewriter) {
            return true;
        return reducedAggs;
     * Return true if this aggregation is mapped, and can lead a reduction.  If this agg returns  
        public BigArrays bigArrays() {  
     * it should return a new {@linkplain InternalAggregations} to make
     * rewritten buckets, or, if there aren't any modifications to
     * Rewrite the sub-aggregations in the buckets in this aggregation.
    /**  
import org.opensearch.search.aggregations.support.AggregationPath;
    public String toString() {  
        out.writeVInt(size);  
    public double sortValue(AggregationPath.PathElement head, Iterator<AggregationPath.PathElement> tail) {  
        final int size = in.readVInt();
         * to node versions that need pipeline aggregators to be serialized
    /**  
     * @param name The name of the aggregation.
 * ownership. Elasticsearch licenses this file to you under  
    }
    @PublicApi(since = "1.0.0")
         * Build a {@linkplain ReduceContext} to perform a partial reduction.
     * should respect the description above.
import java.util.function.Supplier;  
            this.bigArrays = bigArrays;
     *
     */  
        out.writeGenericValue(metadata);
        throw new IllegalArgumentException("Can't sort a [" + getType() + "] aggregation [" + getName() + "]");  
import java.util.Map;
        public static ReduceContext forFinalReduction(
         */  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        throw new IllegalStateException(
         * to them.  
            BigArrays bigArrays,
     */  
     * aggregations are of the same type (the same type as this aggregation). For best efficiency, when implementing,  
     * try reusing an existing instance (typically the first in the given list) to save on redundant object
     */
import java.util.Iterator;
/*
 * SPDX-License-Identifier: Apache-2.0
     */
import java.io.IOException;
         */
        public ScriptService scriptService() {
     * Signal the framework if the {@linkplain InternalAggregation#reduce(List, ReduceContext)} phase needs to be called  
        if (obj == null || getClass() != obj.getClass()) {  
        ReduceContext reduceContext,  
        return name;
    /**
        }  
        }
            }  
         * whereas for coordinator level partial reduce it will use top level `size` and `min_doc_count`
         * For slice level partial reduce we will apply shard level `shard_size` and `shard_min_doc_count` limits
        } else {  
            size = 0;
     * Run a {@linkplain Consumer} over all buckets in this aggregation.
    }  
        assert reduceContext.isFinalReduce();  
 */
    @Override  
            Supplier<PipelineTree> pipelineTreeForBwcSerialization
    }
 * The OpenSearch Contributors require contributions made to  
    }
            return new ReduceContext(
            this.isSliceLevel = false;
        public boolean isFinalReduce() {  
        public void consumeBucketsAndMaybeBreak(int size) {
 * An internal implementation of {@link Aggregation}. Serves as a base class for all aggregation implementations.
    }
     * Read a size under the assumption that a value of 0 means unlimited.
     * @opensearch.api
     * way, it doesn't modify this aggregation.  
        public LocalBucketCountThresholds asLocalBucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {
    /**  
        private final ScriptService scriptService;
         * to node versions that need pipeline aggregators to be serialized
        InternalAggregation other = (InternalAggregation) obj;
     * Read from a stream.
                requireNonNull(pipelineTreeRoot, "prefer EMPTY to null"),
 * this file be licensed under the Apache-2.0 license or a
     */
        /**  
        out.writeString(name);
            this.pipelineTreeForBwcSerialization = pipelineTreeForBwcSerialization;  
     * Reduces the given aggregations to a single one and returns it. In <b>most</b> cases, the assumption will be the all given
    /**
    /**
     * Get value to use when sorting by this aggregation.
        /**  
            builder.startObject(getName());
    }  
    /**
    public String getType() {  
     * the buckets then this method will return this aggregation. Either
            builder.field(CommonFields.META.getPreferredName());
 */  
        return getProperty(aggPath.getPathElementsAsStringList());
     */  
        /**
    protected static void writeSize(int size, StreamOutput out) throws IOException {
     */
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
/**
        return Objects.hash(name, metadata);
        }
     * should return {@code null} if it doen't have any rewriting to do or
         */
            IntConsumer multiBucketConsumer,
    @Override
        if (size == Integer.MAX_VALUE) {  
            PipelineTree pipelineTreeRoot
        /**
 *
    public abstract InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext);  
     * aggregations don't <strong>have</strong> buckets in them. It  
 * You may obtain a copy of the License at  
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        ReduceContext forPartialReduction();  
            return bigArrays;
        InternalAggregation reducedAggs,
         */  
    }
                return new LocalBucketCountThresholds(bucketCountThresholds.getMinDocCount(), bucketCountThresholds.getRequiredSize());
import org.opensearch.core.common.io.stream.StreamInput;
                scriptService,  
        return true;
     * with its {@linkplain InternalAggregations}. The {@code rewriter}  
         * Operations that are potentially losing information can only be applied during the final reduce phase.
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
            multiBucketConsumer.accept(size);
 * KIND, either express or implied.  See the License for the
@PublicApi(since = "1.0.0")  
     */
            return pipelineTreeForBwcSerialization;  
        public void setSliceLevel(boolean sliceLevel) {
    protected InternalAggregation(String name, Map<String, Object> metadata) {
        metadata = in.readMap();
     */
         * @param pipelineTreeRoot The root of tree of pipeline aggregations for this request
     */  
     * false, it should return itself if asked to lead a reduction
    }  
        public PipelineTree pipelineTreeRoot() {
            return new ReduceContext(bigArrays, scriptService, (s) -> {}, null, pipelineTreeForBwcSerialization);  
    @Override
        /**  
         * the maximum number of buckets allowed in a response
    @PublicApi(since = "1.0.0")
        this.metadata = metadata;  
         * Adds {@code count} buckets to the global count for the request and fails if this number is greater than
         */
            return pipelineTreeRoot != null;
    @Override
        }  
        // subclasses will override this with a real implementation if you can sort on a descendant
}
            return pipelineTreeRoot;  
 * not use this file except in compliance with the License.
        private final BigArrays bigArrays;  
            // Concatenates the type and the name of the aggregation (ex: top_hits#foo)
            BigArrays bigArrays,
         */
    protected InternalAggregation(StreamInput in) throws IOException {  
     * Constructs an aggregation result with a given name.  
     * Returns a copy of this {@linkplain InternalAggregation} with the  
/*
            Supplier<PipelineTree> pipelineTreeForBwcSerialization  
     */
    }
         */
                bigArrays,
    public interface ReduceContextBuilder {
        PipelineTree pipelinesForThisAgg
     * Get the value of specified path in the aggregation.
 * GitHub history for details.
     * Implementers of this should call the {@code rewriter} once per bucket
    public abstract XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException;  
 * under the License.  
        for (PipelineAggregator pipelineAggregator : pipelinesForThisAgg.aggregators()) {
    }
        doXContentBody(builder, params);
        }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
     *  
     * The default implementation throws an exception because most
     * @return the value of the property  
            ScriptService scriptService,  
/*  
        }
         * Returns <code>true</code> iff the current reduce phase is the final reduce phase. This indicates if operations like
                multiBucketConsumer,
        AggregationPath aggPath = AggregationPath.parse(path);  
            IntConsumer multiBucketConsumer,
        public boolean isSliceLevel() {
import org.opensearch.common.util.BigArrays;
         */  
            this.isSliceLevel = sliceLevel;
    protected abstract void doWriteTo(StreamOutput out) throws IOException;  
    }
        }
            return scriptService;
        }
    }
     * @opensearch.api
    }
        }  
         * Build a {@linkplain ReduceContext} to perform the final reduction.  
            ScriptService scriptService,  
     * @param path
    public void forEachBucket(Consumer<InternalAggregations> consumer) {}
    @Override
    /**
        }  
        return builder;  
        return size == 0 ? Integer.MAX_VALUE : size;
        ) {  
    }  
        /**  
        private final PipelineTree pipelineTreeRoot;  
import java.util.List;  
            BigArrays bigArrays,
        name = in.readString();
        ReduceContext forFinalReduction();
 * this work for additional information regarding copyright
            return this.isSliceLevel;  
    protected final Map<String, Object> metadata;  
    protected abstract boolean mustReduceOnSingleInternalAgg();  
import org.opensearch.core.common.io.stream.NamedWriteable;  
            PipelineTree pipelineTreeRoot,
     *            the path to the property in the aggregation tree
         * Build a {@linkplain ReduceContext} to perform a partial reduction.
import java.util.function.Consumer;  
            if (isSliceLevel()) {
    @Override
        return Strings.toString(MediaTypeRegistry.JSON, this);
    }
     * @see #mustReduceOnSingleInternalAgg()
import org.opensearch.core.common.Strings;
        public static ReduceContext forPartialReduction(
        private final IntConsumer multiBucketConsumer;
        );
import org.opensearch.core.common.io.stream.StreamOutput;
            this.scriptService = scriptService;  
            reducedAggs = pipelineAggregator.reduce(reducedAggs, reduceContext);
            builder.map(this.metadata);
     * Get value to use when sorting by a descendant of this aggregation.
         * Build a {@linkplain ReduceContext} to perform the final reduction.
import org.opensearch.common.annotation.PublicApi;  
    /**
        /**  
        if (obj == this) {  
            this.pipelineTreeRoot = pipelineTreeRoot;
        this.name = name;
        builder.endObject();
     * Builds {@link ReduceContext}.  
         */
    }
    }  
    ) {
         * The root of the tree of pipeline aggregations for this request.  
import java.util.function.IntConsumer;
        }  
        }
     */
     *
    /**
     */  
        }
    public abstract Object getProperty(List<String> path);
        /**  
    public final void writeTo(StreamOutput out) throws IOException {  
        return Objects.equals(name, other.name) && Objects.equals(metadata, other.metadata);
     * be called after all aggregations have been fully reduced
 * software distributed under the License is distributed on an
     * The reduce context  
    /**
 * specific language governing permissions and limitations
        private ReduceContext(
            ScriptService scriptService,  
        public Supplier<PipelineTree> pipelineTreeForBwcSerialization() {
     * changs.  
 *  
    public static class ReduceContext {
 * Licensed to Elasticsearch under one or more contributor  
    public String getName() {  
         * to them.  
    public InternalAggregation reducePipelines(
 * Modifications Copyright OpenSearch Contributors. See  
         */  
    }
        throw new IllegalArgumentException("Can't sort by a descendant of a [" + getType() + "] aggregation [" + head + "]");
     */  
     * when there is only one {@linkplain InternalAggregation}.
         * Supplies the pipelines when the result of the reduce is serialized
     * construction.
    /**
    public Map<String, Object> getMetadata() {
            builder.startObject(String.join(TYPED_KEYS_DELIMITER, getType(), getName()));
            );
    public boolean isMapped() {  
        }
     */  
        }
     *
 * @opensearch.api
    public Object getProperty(String path) {
        if (params.paramAsBoolean(RestSearchAction.TYPED_KEYS_PARAM, false)) {  
                () -> pipelineTreeRoot  
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.rest.action.search.RestSearchAction;
        ) {
     * <p>
