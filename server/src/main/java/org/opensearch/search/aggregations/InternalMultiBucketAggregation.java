 * You may obtain a copy of the License at
 *
        } else if (agg instanceof SingleBucketAggregation single) {
                if (path.size() > 1) {
    }
     * @param buckets
        assert reduceContext.isFinalReduce();
import org.opensearch.core.common.io.stream.Writeable;
            throw new InvalidAggregationPathException("Cannot find an key [" + aggName + "] in [" + name + "]");
    public static int countInnerBucket(InternalBucket bucket) {
/**
     */
        super(in);
 * KIND, either express or implied.  See the License for the
 *
            modified = true;
     */
                return getDocCount();
import java.util.ArrayList;
        String aggName = path.get(0);
     * Counts the number of inner buckets inside the provided {@link InternalBucket}
    @Override
        }
    @Override
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 * SPDX-License-Identifier: Apache-2.0
        }
                ++size;
        return resolvePropertyFromPath(path, getBuckets(), getName());
        if (aggName.equals("_bucket_count")) {
 * this work for additional information regarding copyright
    protected boolean mustReduceOnSingleInternalAgg() {
     * A multi-bucket agg needs to first reduce the buckets and *their* pipelines
            for (Aggregation bucketAgg : single.getAggregations().asList()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
            // No key match, time to give up
        }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                    throw new InvalidAggregationPathException("_count must be the last element in the path");
            }
        PipelineTree pipelineTree
     *            the buckets to use in the new {@link Aggregation}
 * The OpenSearch Contributors require contributions made to
            List<B> materializedBuckets = reducePipelineBuckets(reduceContext, pipelineTree);
    protected InternalMultiBucketAggregation(StreamInput in) throws IOException {
     */
            B newBucket = createBucket(rewritten, bucket);
    }
package org.opensearch.search.aggregations;
    protected abstract B reduceBucket(List<B> buckets, ReduceContext context);
                throw new InvalidAggregationPathException(
        public Object getProperty(String containingAggName, List<String> path) {
    static Object resolvePropertyFromPath(List<String> path, List<? extends InternalBucket> buckets, String name) {
        Object[] propertyArray = new Object[buckets.size()];
import java.util.function.Function;
            }
    public abstract A create(List<B> buckets);
    @Override
 * Unless required by applicable law or agreed to in writing,
        InternalAggregation reducedAggs,
        }
    ) {
        if (path.isEmpty()) {
        }
            reduced = create(materializedBuckets);
        int count = 0;
    public static int countInnerBucket(Aggregation agg) {
    /**
 * ownership. Elasticsearch licenses this file to you under
     * @param prototype
    }
     * this {@link Aggregation} and contains the provided buckets.
     * @opensearch.internal
 * compatible open source license.
 * @opensearch.internal
    }
 *
    @Override
            Aggregations aggregations = getAggregations();
            }
                size += countInnerBucket(bucketAgg);
    }
    public InternalMultiBucketAggregation(String name, Map<String, Object> metadata) {
            }
                    throw new InvalidAggregationPathException("_key must be the last element in the path");
    /**
     */
 * software distributed under the License is distributed on an
    A extends InternalMultiBucketAggregation,
            for (InternalBucket bucket : buckets) {
        int size = 0;
                PipelineTree subTree = pipelineTree.subTree(agg.getName());
            return this;
        }
    }
     * Reduce a list of same-keyed buckets (from multiple shards) to a single bucket. This
    private List<B> reducePipelineBuckets(ReduceContext reduceContext, PipelineTree pipelineTree) {
/*
    /**
    public InternalAggregation copyWithRewritenBuckets(Function<InternalAggregations, InternalAggregations> rewriter) {
            if (aggregation == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            count += countInnerBucket(agg);
        super(name, metadata);
        List<B> newBuckets = new ArrayList<>();
            String aggName = path.get(0);
            reducedBuckets.add(createBucket(InternalAggregations.from(aggs), bucket));
                newBuckets.add(bucket);
     * before allowing sibling pipelines to materialize.
     */
        }
            }
     * Create a new copy of this {@link Aggregation} with the same settings as
     * requires all buckets to have the same key.
public abstract class InternalMultiBucketAggregation<
            for (MultiBucketsAggregation.Bucket bucket : multi.getBuckets()) {
    @Override
            for (Aggregation agg : bucket.getAggregations()) {
    }
                aggs.add(((InternalAggregation) agg).reducePipelines((InternalAggregation) agg, reduceContext, subTree));
        ReduceContext reduceContext,
        if (aggName.startsWith("'") && aggName.endsWith("'")) {
 */
    public void forEachBucket(Consumer<InternalAggregations> consumer) {
    }
            }
                continue;
                if (bucket.getKeyAsString().equals(aggName.substring(1, aggName.length() - 1))) {
     *            the aggregations for the new bucket
        return count;
 */
    }
import java.util.function.Consumer;
 * license agreements. See the NOTICE file distributed with
/*
 *
        }
            if (path.isEmpty()) {
            }
     *
     * Read from a stream.
    @Override
 */
     * and aggregations.
/*
import java.util.List;
    }
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
                    return bucket.getProperty(name, path.subList(1, path.size()));
            List<InternalAggregation> aggs = new ArrayList<>();
        List<B> reducedBuckets = new ArrayList<>();
 * not use this file except in compliance with the License.
    }
import org.opensearch.core.common.io.stream.StreamInput;
     *
            return aggregation.getProperty(path.subList(1, path.size()));
        return size;
 * Licensed to Elasticsearch under one or more contributor
     *
        return super.reducePipelines(reduced, reduceContext, pipelineTree);
                if (path.size() > 1) {
            }
            return buckets.size();
            } else if (aggName.equals("_key")) {
            newBuckets.add(newBucket);
        }
                for (Aggregation bucketAgg : bucket.getAggregations().asList()) {
        if (agg instanceof MultiBucketsAggregation multi) {
            if (rewritten == null) {
        // This is a bucket key, look through our buckets and see if we can find a match
        for (int i = 0; i < buckets.size(); i++) {
                }
        if (pipelineTree.hasSubTrees()) {
    /**
    public Object getProperty(List<String> path) {
import java.util.Map;
     * @param aggregations
        for (B bucket : getBuckets()) {
                }
     */
 */
        return propertyArray;
 * specific language governing permissions and limitations
}
    /**
                    size += countInnerBucket(bucketAgg);
        return modified ? create(newBuckets) : this;
    }
            consumer.accept((InternalAggregations) bucket.getAggregations());
                }
        boolean modified = false;
            InternalAggregation aggregation = aggregations.get(aggName);
    /**
     * An internal buck for the internal multibucket agg
        InternalAggregation reduced = this;
                    "Cannot find an aggregation named [" + aggName + "] in [" + containingAggName + "]"
        return reducedBuckets;
            propertyArray[i] = buckets.get(i).getProperty(name, path);
        return true;
     * @return the new {@link Aggregation}
     * Create a new {@link InternalBucket} using the provided prototype bucket
import org.opensearch.search.aggregations.bucket.SingleBucketAggregation;
                }
    /**
    public abstract B createBucket(InternalAggregations aggregations, B prototype);
                return getKey();
    B extends InternalMultiBucketAggregation.InternalBucket> extends InternalAggregation implements MultiBucketsAggregation {
 * Base class for internal aggregations that are comprised of multiple buckets
 * GitHub history for details.
     *            the bucket to use as a prototype
     */
        for (B bucket : getBuckets()) {
            InternalAggregations rewritten = rewriter.apply((InternalAggregations) bucket.getAggregations());
    public abstract List<B> getBuckets();
            if (aggName.equals("_count")) {
    public abstract static class InternalBucket implements Bucket, Writeable {
        for (Aggregation agg : bucket.getAggregations().asList()) {
    public final InternalAggregation reducePipelines(
     * @return the new bucket
        }
        }
                return this;
        for (B bucket : getBuckets()) {
                );
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
     * Counts the number of inner buckets inside the provided {@link Aggregation}
