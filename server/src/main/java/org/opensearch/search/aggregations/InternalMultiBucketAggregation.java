                PipelineTree subTree = pipelineTree.subTree(agg.getName());
        }
    /**
 *  
import java.io.IOException;
            List<InternalAggregation> aggs = new ArrayList<>();  
        boolean modified = false;  
 * @opensearch.internal
     * Read from a stream.
     * before allowing sibling pipelines to materialize.
            InternalAggregation aggregation = aggregations.get(aggName);
        }  
    @Override
    @Override
        return reducedBuckets;
            modified = true;
 * this file be licensed under the Apache-2.0 license or a
    public abstract List<B> getBuckets();  
            for (MultiBucketsAggregation.Bucket bucket : multi.getBuckets()) {
     */
        if (aggName.equals("_bucket_count")) {  
     * and aggregations.
    }  
            }
        }  
                throw new InvalidAggregationPathException(  
 * You may obtain a copy of the License at  
    }
                newBuckets.add(bucket);
        }
     * Create a new copy of this {@link Aggregation} with the same settings as
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
    public Object getProperty(List<String> path) {  
                    size += countInnerBucket(bucketAgg);
                }
 */  
    }  
        List<B> reducedBuckets = new ArrayList<>();
                }  
            return buckets.size();
            newBuckets.add(newBucket);
package org.opensearch.search.aggregations;
    }
 * KIND, either express or implied.  See the License for the
        InternalAggregation reduced = this;
        } else if (agg instanceof SingleBucketAggregation single) {
    @Override
                size += countInnerBucket(bucketAgg);  
 */
            for (Aggregation bucketAgg : single.getAggregations().asList()) {
        String aggName = path.get(0);
        return propertyArray;
        super(name, metadata);  
            }
/**
/*
import org.opensearch.core.common.io.stream.Writeable;
        }  
 * this work for additional information regarding copyright
     *  
            Aggregations aggregations = getAggregations();  
    }
            return this;
     *
        InternalAggregation reducedAggs,  
                );
    protected boolean mustReduceOnSingleInternalAgg() {
}
        for (Aggregation agg : bucket.getAggregations().asList()) {
import java.util.function.Consumer;
 */  
            B newBucket = createBucket(rewritten, bucket);  
 * GitHub history for details.
                continue;  
        assert reduceContext.isFinalReduce();
/*  
            if (path.isEmpty()) {  
     */
                return getKey();
    public abstract A create(List<B> buckets);  
    public InternalAggregation copyWithRewritenBuckets(Function<InternalAggregations, InternalAggregations> rewriter) {
                if (bucket.getKeyAsString().equals(aggName.substring(1, aggName.length() - 1))) {
            InternalAggregations rewritten = rewriter.apply((InternalAggregations) bucket.getAggregations());  
            }  
 * SPDX-License-Identifier: Apache-2.0
            if (aggName.equals("_count")) {
    }
import java.util.Map;
import org.opensearch.search.aggregations.bucket.SingleBucketAggregation;
     */
            consumer.accept((InternalAggregations) bucket.getAggregations());
        for (B bucket : getBuckets()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return resolvePropertyFromPath(path, getBuckets(), getName());
        List<B> newBuckets = new ArrayList<>();
            if (rewritten == null) {
     */
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Base class for internal aggregations that are comprised of multiple buckets  
     */  
    public void forEachBucket(Consumer<InternalAggregations> consumer) {  
 * compatible open source license.
    ) {  
            }  
    /**
        for (int i = 0; i < buckets.size(); i++) {
        return size;  
    }
                }
    /**
     * A multi-bucket agg needs to first reduce the buckets and *their* pipelines
     *
 *
            reducedBuckets.add(createBucket(InternalAggregations.from(aggs), bucket));
    @Override
        }  
        public Object getProperty(String containingAggName, List<String> path) {
     *            the bucket to use as a prototype  
        }
            }
 * Modifications Copyright OpenSearch Contributors. See
public abstract class InternalMultiBucketAggregation<
                if (path.size() > 1) {
                for (Aggregation bucketAgg : bucket.getAggregations().asList()) {  
import org.opensearch.core.common.io.stream.StreamInput;
     * requires all buckets to have the same key.
 *
    public abstract B createBucket(InternalAggregations aggregations, B prototype);  
import java.util.function.Function;  
    private List<B> reducePipelineBuckets(ReduceContext reduceContext, PipelineTree pipelineTree) {  
     * Counts the number of inner buckets inside the provided {@link InternalBucket}  
    public final InternalAggregation reducePipelines(
     * @return the new {@link Aggregation}
    protected abstract B reduceBucket(List<B> buckets, ReduceContext context);  
 * not use this file except in compliance with the License.
     * @param aggregations  
    public static int countInnerBucket(Aggregation agg) {
            count += countInnerBucket(agg);
        return modified ? create(newBuckets) : this;  
    @Override
            reduced = create(materializedBuckets);
                    return bucket.getProperty(name, path.subList(1, path.size()));
 * Licensed to Elasticsearch under one or more contributor  
            }
     * @return the new bucket
        PipelineTree pipelineTree
    }
/*  
        if (pipelineTree.hasSubTrees()) {  
    }
    /**  
            } else if (aggName.equals("_key")) {
            for (Aggregation agg : bucket.getAggregations()) {
    B extends InternalMultiBucketAggregation.InternalBucket> extends InternalAggregation implements MultiBucketsAggregation {  
     */
                ++size;
            propertyArray[i] = buckets.get(i).getProperty(name, path);
                    throw new InvalidAggregationPathException("_count must be the last element in the path");
 * under the License.  
        int size = 0;
    /**
 * Unless required by applicable law or agreed to in writing,
                return this;
        return true;
 * The OpenSearch Contributors require contributions made to  
        return count;
                if (path.size() > 1) {  
        if (agg instanceof MultiBucketsAggregation multi) {  
            }
                    throw new InvalidAggregationPathException("_key must be the last element in the path");  
        super(in);
        }  
            return aggregation.getProperty(path.subList(1, path.size()));
        }
        // This is a bucket key, look through our buckets and see if we can find a match
    protected InternalMultiBucketAggregation(StreamInput in) throws IOException {  
     * this {@link Aggregation} and contains the provided buckets.  
     * Create a new {@link InternalBucket} using the provided prototype bucket  
 * specific language governing permissions and limitations
     *            the buckets to use in the new {@link Aggregation}  
    }  
    /**
import java.util.ArrayList;
            String aggName = path.get(0);
            // No key match, time to give up
                }
     * Reduce a list of same-keyed buckets (from multiple shards) to a single bucket. This  
     * Counts the number of inner buckets inside the provided {@link Aggregation}
     *            the aggregations for the new bucket
        }
                    "Cannot find an aggregation named [" + aggName + "] in [" + containingAggName + "]"
                return getDocCount();  
        ReduceContext reduceContext,
                aggs.add(((InternalAggregation) agg).reducePipelines((InternalAggregation) agg, reduceContext, subTree));  
 * license agreements. See the NOTICE file distributed with
    public InternalMultiBucketAggregation(String name, Map<String, Object> metadata) {
import java.util.List;  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
        for (B bucket : getBuckets()) {
 * ownership. Elasticsearch licenses this file to you under  
     */  
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param buckets
            for (InternalBucket bucket : buckets) {  
    public abstract static class InternalBucket implements Bucket, Writeable {  
        int count = 0;  
            throw new InvalidAggregationPathException("Cannot find an key [" + aggName + "] in [" + name + "]");  
    /**  
            }  
    public static int countInnerBucket(InternalBucket bucket) {
    }
    A extends InternalMultiBucketAggregation,
 * software distributed under the License is distributed on an
     * An internal buck for the internal multibucket agg
            if (aggregation == null) {
        Object[] propertyArray = new Object[buckets.size()];  
    static Object resolvePropertyFromPath(List<String> path, List<? extends InternalBucket> buckets, String name) {
        return super.reducePipelines(reduced, reduceContext, pipelineTree);
        if (aggName.startsWith("'") && aggName.endsWith("'")) {
    @Override  
 *
     * @param prototype
        if (path.isEmpty()) {
            List<B> materializedBuckets = reducePipelineBuckets(reduceContext, pipelineTree);
    }
    /**
        for (B bucket : getBuckets()) {
     */
        }  
