            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
        // the score
        return Objects.hash(super.hashCode(), minDocCount, requiredSize);
                return true;
        long supersetDf;
                        globalSubsetSize,
    @Override  
            long subsetDf,
        long globalSubsetSize = 0;  
 * specific language governing permissions and limitations
     * Read from a stream.
        long supersetSize;  
        }
        // Do not apply size threshold on coordinator partial reduce  
        public double getSignificanceScore() {  
        long globalSupersetSize = 0;
import org.opensearch.core.common.io.stream.StreamInput;  
    protected abstract A create(long subsetSize, long supersetSize, List<B> buckets);
        for (Map.Entry<String, List<B>> entry : buckets.entrySet()) {
    }
        writeSize(requiredSize, out);
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            }
            @SuppressWarnings("unchecked")
    abstract B createBucket(
            builder.field(SCORE, score);  
    @Override
import java.util.Objects;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        long bucketOrd;
            DocValueFormat format  
 *  
    @SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
    }
        public int hashCode() {  
            } else {  
        @Override
        void updateScore(SignificanceHeuristic significanceHeuristic) {  
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
                }
        SignificantTerms {  
        long supersetDf,
                        bucket
     */  
        @Override
        @Override  
import java.util.Map;
                }
        this.bucketCountThresholds = bucketCountThresholds;
import org.opensearch.core.common.io.stream.StreamOutput;
            // num_slices_with_bucket is the number of segment slices that have collected a bucket for the key  
            // reduce. However, the bucket score is only evaluated at the final coordinator reduce.
        long subsetDf;  
 * Unless required by applicable law or agreed to in writing,
        return createBucket(subsetDf, buckets.get(0).subsetSize, supersetDf, buckets.get(0).supersetSize, aggs, buckets.get(0));
    }  
            InternalAggregations aggregations,
    }
        // This can lead to confusing bugs if the bucket is re-created (via createBucket() or similar) without
        Map<String, List<B>> buckets = new HashMap<>();
    public static final String BG_COUNT = "bg_count";  
import java.util.HashMap;
    protected final long minDocCount;
import java.util.ArrayList;  
            if (this == o) {  
        B prototype
            this.subsetDf = subsetDf;
    protected abstract B[] createBucketsArray(int size);  
            if (context.isSliceLevel()) {
            this.subsetSize = subsetSize;
    public static final String SCORE = "score";
    protected abstract void writeTermTypeInfoTo(StreamOutput out) throws IOException;
                && (((b.score > 0) || reduceContext.isSliceLevel()));  
 */
        }
 * under the License.  
        @Override  
                if (removed == null) {  
    @Override  
    @Override
    implements
                && Objects.equals(format, that.format);
    /**
            return aggregations;
        // TODO we should refactor to remove this, since buckets should be immutable after they are generated.  
        long supersetDf = 0;
        public long getSupersetDf() {
 * KIND, either express or implied.  See the License for the
        assert buckets.size() > 0;  
                globalSupersetSize = terms.getSupersetSize();
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
            aggregations.toXContentInternal(builder, params);
        }  
    }
        public long getSubsetDf() {
        public long getDocCount() {
         * Read from a stream.
        // CoordinatorBucketCountThresholds which will throw an exception if they are accessed.  
        InternalAggregations aggregations;  
                    reduceContext.consumeBucketsAndMaybeBreak(1);
            builder.endObject();  
 * Modifications Copyright OpenSearch Contributors. See  
    );
         */  
        }
                        bucket.getSupersetDf(),
                List<B> existingBuckets = buckets.get(bucket.getKeyAsString());  
        InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);  
         * Reads a bucket. Should be a constructor reference.  
            long supersetDf,  
                supersetDf = bucket.supersetDf;  
        /**
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());  
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
        SignificanceHeuristic heuristic = getSignificanceHeuristic().rewrite(reduceContext);
        for (InternalAggregation aggregation : aggregations) {
        if (this == obj) return true;  
    /**
        // top-level Aggregations from each shard  
        }
            } else {
            builder.startObject();  
            return subsetSize;  
            return supersetSize;
            subsetDf += bucket.subsetDf;
     * Create an array to hold some buckets. Used in collecting the results.
                reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(b));  
import org.opensearch.core.xcontent.XContentBuilder;
        super(name, metadata);
    protected final TermsAggregator.BucketCountThresholds bucketCountThresholds;  
                && Double.compare(that.score, score) == 0  
 * GitHub history for details.
                if (existingBuckets == null) {
            ? Math.min(localBucketCountThresholds.getRequiredSize(), buckets.size())
 * Result of the significant terms aggregation.
            // For concurrent search case we do not apply bucket count thresholds in buildAggregation and instead is done here during  
    protected InternalSignificantTerms(
                    createBucket(
                B removed = ordered.insertWithOverflow(b);
 *
            }
     * Bucket for a significant terms agg  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
 * software distributed under the License is distributed on an
    ) {  
        for (InternalAggregation aggregation : aggregations) {
    protected InternalSignificantTerms(StreamInput in) throws IOException {
        long subsetDf,
            this.supersetDf = supersetDf;
    }
        }
        }
        @Override
            this.aggregations = aggregations;  
    public int hashCode() {  
    public abstract static class Bucket<B extends Bucket<B>> extends InternalMultiBucketAggregation.InternalBucket
        boolean isCoordinatorPartialReduce = reduceContext.isFinalReduce() == false && reduceContext.isSliceLevel() == false;
        minDocCount = in.readVLong();
        }
        /**
 * ownership. Elasticsearch licenses this file to you under  
/*
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
     *
 * The OpenSearch Contributors require contributions made to  
        String name,  
        @Override
                );
import org.opensearch.search.aggregations.InternalAggregation;
    public boolean equals(Object obj) {
            this.format = format;
            keyToXContent(builder);
import java.io.IOException;
                        bucket.getSubsetDf(),  
}
    /**  
            builder.field(BG_COUNT, supersetDf);
            long supersetSize,
                // Adjust the buckets with the global stats representing the
                return false;
            }  
        implements  
            this.supersetSize = supersetSize;  
            return score;
            B read(StreamInput in, long subsetSize, long supersetSize, DocValueFormat format) throws IOException;  
            if (reduceContext.isSliceLevel()) {
            List<B> sameTermBuckets = entry.getValue();  
        for (int i = ordered.size() - 1; i >= 0; i--) {
        protected Bucket(  
        @Override
 * this work for additional information regarding copyright
    protected abstract SignificanceHeuristic getSignificanceHeuristic();  
        @Override
            return Objects.hash(getClass(), bucketOrd, aggregations, score, format);
            final B b = reduceBucket(sameTermBuckets, reduceContext);
 * Licensed to Elasticsearch under one or more contributor  
            this.supersetSize = supersetSize;  
        public long getSubsetSize() {
                    existingBuckets = new ArrayList<>(aggregations.size());
    }
        B[] list = createBucketsArray(ordered.size());  
                    reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(removed));  
        protected Bucket(StreamInput in, long subsetSize, long supersetSize, DocValueFormat format) {
    @Override
        InternalAggregations aggregations,  
        this.minDocCount = bucketCountThresholds.getMinDocCount();  
 * You may obtain a copy of the License at  
            score = significanceHeuristic.getScore(subsetDf, subsetSize, supersetDf, supersetSize);
 * SPDX-License-Identifier: Apache-2.0
        out.writeVLong(minDocCount);  
        long subsetDf = 0;
            InternalSignificantTerms<A, B> terms = (InternalSignificantTerms<A, B>) aggregation;  
        return Objects.equals(minDocCount, that.minDocCount) && Objects.equals(requiredSize, that.requiredSize);
            : buckets.size();  
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
        LocalBucketCountThresholds localBucketCountThresholds = reduceContext.asLocalBucketCountThresholds(bucketCountThresholds);
            } else {
            return builder;
        if (super.equals(obj) == false) return false;
    }
            if (o == null || getClass() != o.getClass()) {  
            @SuppressWarnings("unchecked")  
         * @opensearch.internal
        long subsetSize;
            for (B bucket : terms.getBuckets()) {
         *
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.format = format;
                supersetDf += bucket.supersetDf;
        }  
 */
        }
            InternalSignificantTerms<A, B> terms = (InternalSignificantTerms<A, B>) aggregation;
            // supersetDf is a shard level count, if we sum it across slices we would produce num_slices_with_bucket * supersetSize where  
        ) {
        }  
        public interface Reader<B extends Bucket<B>> {
            this.subsetSize = subsetSize;
import java.util.Arrays;
 *  
        final transient DocValueFormat format;
            return supersetDf;
        this.requiredSize = bucketCountThresholds.getRequiredSize();
    public abstract List<B> getBuckets();
         */  
     * @opensearch.internal
import org.opensearch.search.aggregations.InternalAggregations;  
        Map<String, Object> metadata
                    buckets.put(bucket.getKeyAsString(), existingBuckets);  
        long subsetSize,  
 * not use this file except in compliance with the License.
    protected abstract long getSupersetSize();
        long supersetSize,
                } else {
            }
        @FunctionalInterface
                        bucket.aggregations,
        return create(globalSubsetSize, globalSupersetSize, Arrays.asList(list));
 */
        public boolean equals(Object o) {
        }  
            long subsetSize,
     */  
public abstract class InternalSignificantTerms<A extends InternalSignificantTerms<A, B>, B extends InternalSignificantTerms.Bucket<B>>  
/*  
                        globalSupersetSize,  
                existingBuckets.add(
        // shardMinDocCount and shardSize are not used on the coordinator, so they are not deserialized. We use
                    )  
            globalSubsetSize += terms.getSubsetSize();
        for (B bucket : buckets) {
 *
        BucketSignificancePriorityQueue<B> ordered = new BucketSignificancePriorityQueue<>(size);
            }
        }
 * the Apache License, Version 2.0 (the "License"); you may
            return bucketOrd == that.bucketOrd
            b.updateScore(heuristic);
            // supersetSize is a shard level count, if we sum it across slices we would produce num_slices_with_bucket * supersetSize where
        bucketCountThresholds = new TermsAggregator.CoordinatorBucketCountThresholds(minDocCount, -1, requiredSize, -1);
            aggregationsList.add(bucket.aggregations);
/*
        }
            SignificantTerms.Bucket {
                // total size of the pots from which the stats are drawn  
     */
        @Override
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
            Bucket<?> that = (Bucket<?>) o;
    protected final int requiredSize;
    extends InternalMultiBucketAggregation<A, B>
        writeTermTypeInfoTo(out);
            list[i] = ordered.pop();
        requiredSize = readSize(in);  
package org.opensearch.search.aggregations.bucket.terms;
            return subsetDf;  
    protected abstract long getSubsetSize();
            // num_slices_with_bucket is the number of segment slices that have collected a bucket for the key
import org.opensearch.search.DocValueFormat;  
        InternalSignificantTerms<?, ?> that = (InternalSignificantTerms<?, ?>) obj;
        double score;
        }
            boolean meetsThresholds = (b.subsetDf >= localBucketCountThresholds.getMinDocCount())
 * license agreements. See the NOTICE file distributed with
                globalSupersetSize += terms.getSupersetSize();
 */  
import org.opensearch.search.aggregations.Aggregations;
import java.util.List;  
        public long getSupersetSize() {  
        }  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    protected final void doWriteTo(StreamOutput out) throws IOException {
        public Aggregations getAggregations() {
        }
        final int size = !isCoordinatorPartialReduce
            return subsetDf;  
        }  
            if (isCoordinatorPartialReduce || meetsThresholds) {
/**
        @Override
        // Compute the overall result set size and the corpus size using the
        }
                && Objects.equals(aggregations, that.aggregations)
        super(in);
