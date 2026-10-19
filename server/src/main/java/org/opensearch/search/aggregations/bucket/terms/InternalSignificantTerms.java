    protected abstract A create(long subsetSize, long supersetSize, List<B> buckets);
        InternalSignificantTerms<?, ?> that = (InternalSignificantTerms<?, ?>) obj;
            } else {
            list[i] = ordered.pop();
            builder.startObject();
        long supersetSize;
        /**
    @Override
            DocValueFormat format
            b.updateScore(heuristic);
            SignificantTerms.Bucket {
    ) {
        @Override
        if (this == obj) return true;
        @Override
                && (((b.score > 0) || reduceContext.isSliceLevel()));
        }
                if (existingBuckets == null) {
            this.subsetDf = subsetDf;
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
 * ownership. Elasticsearch licenses this file to you under
        requiredSize = readSize(in);
        @Override
        assert buckets.size() > 0;
            if (isCoordinatorPartialReduce || meetsThresholds) {
        /**
            boolean meetsThresholds = (b.subsetDf >= localBucketCountThresholds.getMinDocCount())
         * @opensearch.internal
    protected final TermsAggregator.BucketCountThresholds bucketCountThresholds;
import org.opensearch.search.aggregations.InternalAggregations;
            return score;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        public double getSignificanceScore() {
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
            InternalSignificantTerms<A, B> terms = (InternalSignificantTerms<A, B>) aggregation;
                && Double.compare(that.score, score) == 0
            return subsetDf;
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
            long subsetSize,
    }
                    createBucket(
        public long getDocCount() {
        }
            long supersetSize,
    /**
        // top-level Aggregations from each shard
                        globalSubsetSize,
        ) {
 *
            return supersetDf;
         * Read from a stream.
 * @opensearch.internal
        // the score
import java.util.Objects;
            : buckets.size();
        return createBucket(subsetDf, buckets.get(0).subsetSize, supersetDf, buckets.get(0).supersetSize, aggs, buckets.get(0));
    public abstract List<B> getBuckets();
    protected abstract SignificanceHeuristic getSignificanceHeuristic();
    @Override
         */
            this.subsetSize = subsetSize;
            InternalSignificantTerms<A, B> terms = (InternalSignificantTerms<A, B>) aggregation;
        protected Bucket(StreamInput in, long subsetSize, long supersetSize, DocValueFormat format) {
            return aggregations;
            final B b = reduceBucket(sameTermBuckets, reduceContext);
        if (obj == null || getClass() != obj.getClass()) return false;
        }
            B read(StreamInput in, long subsetSize, long supersetSize, DocValueFormat format) throws IOException;
        long supersetDf;
            InternalAggregations aggregations,
    @Override
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        for (B bucket : buckets) {
        }
        }
    }
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());
        }
            aggregations.toXContentInternal(builder, params);
                    buckets.put(bucket.getKeyAsString(), existingBuckets);
            long supersetDf,
        // shardMinDocCount and shardSize are not used on the coordinator, so they are not deserialized. We use
 *
        InternalAggregations aggregations,
                globalSupersetSize = terms.getSupersetSize();
        }
        out.writeVLong(minDocCount);
                        globalSupersetSize,
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
        String name,
        long subsetDf = 0;
    protected abstract B[] createBucketsArray(int size);
        double score;
        @Override
            score = significanceHeuristic.getScore(subsetDf, subsetSize, supersetDf, supersetSize);
        return Objects.hash(super.hashCode(), minDocCount, requiredSize);
            globalSubsetSize += terms.getSubsetSize();
 *    http://www.apache.org/licenses/LICENSE-2.0
        long subsetDf;
        }
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
     *
    }
     */
            // num_slices_with_bucket is the number of segment slices that have collected a bucket for the key
            this.format = format;
 * this work for additional information regarding copyright
import java.io.IOException;
            }
import java.util.Map;
     * Bucket for a significant terms agg
                && Objects.equals(format, that.format);
                supersetDf = bucket.supersetDf;
            this.format = format;
 * under the License.
        this.requiredSize = bucketCountThresholds.getRequiredSize();
        }
import org.opensearch.search.aggregations.InternalAggregation;
        // Do not apply size threshold on coordinator partial reduce
        long subsetSize,
            } else {
                // Adjust the buckets with the global stats representing the
 * the Apache License, Version 2.0 (the "License"); you may
            // supersetSize is a shard level count, if we sum it across slices we would produce num_slices_with_bucket * supersetSize where
            } else {
                globalSupersetSize += terms.getSupersetSize();
    @Override
        protected Bucket(
            @SuppressWarnings("unchecked")
        }
    /**
        writeSize(requiredSize, out);
        }
        @FunctionalInterface
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        return create(globalSubsetSize, globalSupersetSize, Arrays.asList(list));
                );
    protected final long minDocCount;
                        bucket.getSupersetDf(),
            return subsetDf;
    public static final String SCORE = "score";
                return false;
    protected final int requiredSize;
        long globalSupersetSize = 0;
        @Override
        for (Map.Entry<String, List<B>> entry : buckets.entrySet()) {
            // For concurrent search case we do not apply bucket count thresholds in buildAggregation and instead is done here during
 * Unless required by applicable law or agreed to in writing,
     */
        long subsetSize;
        this.minDocCount = bucketCountThresholds.getMinDocCount();
    abstract B createBucket(
        }
/*
        InternalAggregations aggregations;
import org.opensearch.search.DocValueFormat;
    protected final void doWriteTo(StreamOutput out) throws IOException {
                return true;
        public interface Reader<B extends Bucket<B>> {
        }
    public abstract static class Bucket<B extends Bucket<B>> extends InternalMultiBucketAggregation.InternalBucket
            @SuppressWarnings("unchecked")
                reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(b));
import org.opensearch.core.common.io.stream.StreamOutput;
        final int size = !isCoordinatorPartialReduce
        Map<String, List<B>> buckets = new HashMap<>();
            List<B> sameTermBuckets = entry.getValue();
        B[] list = createBucketsArray(ordered.size());
            this.subsetSize = subsetSize;
 * software distributed under the License is distributed on an
     * Read from a stream.
import java.util.List;
        final transient DocValueFormat format;
 */
            return bucketOrd == that.bucketOrd
    protected InternalSignificantTerms(StreamInput in) throws IOException {
        SignificanceHeuristic heuristic = getSignificanceHeuristic().rewrite(reduceContext);
        // CoordinatorBucketCountThresholds which will throw an exception if they are accessed.
        Map<String, Object> metadata
        }
        super(in);
            }
package org.opensearch.search.aggregations.bucket.terms;
/*
        }
        long globalSubsetSize = 0;
        for (InternalAggregation aggregation : aggregations) {
    extends InternalMultiBucketAggregation<A, B>
        long subsetDf,
 * Licensed to Elasticsearch under one or more contributor
 * You may obtain a copy of the License at
        writeTermTypeInfoTo(out);
        @Override
        void updateScore(SignificanceHeuristic significanceHeuristic) {
            builder.endObject();
        if (super.equals(obj) == false) return false;
            Bucket<?> that = (Bucket<?>) o;
import org.opensearch.core.xcontent.XContentBuilder;
        // This can lead to confusing bugs if the bucket is re-created (via createBucket() or similar) without
        B prototype
 * The OpenSearch Contributors require contributions made to
        boolean isCoordinatorPartialReduce = reduceContext.isFinalReduce() == false && reduceContext.isSliceLevel() == false;
import java.util.HashMap;
            }
     */
            return Objects.hash(getClass(), bucketOrd, aggregations, score, format);
            }
            // num_slices_with_bucket is the number of segment slices that have collected a bucket for the key
 * license agreements. See the NOTICE file distributed with
                B removed = ordered.insertWithOverflow(b);
                }
        SignificantTerms {
                    reduceContext.consumeBucketsAndMaybeBreak(1);
            // reduce. However, the bucket score is only evaluated at the final coordinator reduce.
        public Aggregations getAggregations() {
        public long getSupersetSize() {
    protected abstract long getSupersetSize();
        public long getSubsetDf() {
                if (removed == null) {
    public boolean equals(Object obj) {
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                // total size of the pots from which the stats are drawn
import java.util.Arrays;
 *
        public long getSubsetSize() {
        for (InternalAggregation aggregation : aggregations) {
        @Override
        for (int i = ordered.size() - 1; i >= 0; i--) {
        implements
            if (this == o) {
    protected abstract long getSubsetSize();
        @Override
        public int hashCode() {
        InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
            // supersetDf is a shard level count, if we sum it across slices we would produce num_slices_with_bucket * supersetSize where
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
            ? Math.min(localBucketCountThresholds.getRequiredSize(), buckets.size())
        @Override
 * KIND, either express or implied.  See the License for the
     * Create an array to hold some buckets. Used in collecting the results.
                        bucket.aggregations,
                } else {
        this.bucketCountThresholds = bucketCountThresholds;
    implements
            if (reduceContext.isSliceLevel()) {
         * Reads a bucket. Should be a constructor reference.
            aggregationsList.add(bucket.aggregations);
                        bucket
        }
 */
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
         */
/*
            }
        @Override
 * GitHub history for details.
 *
     * @opensearch.internal
        }
                    reduceContext.consumeBucketsAndMaybeBreak(-countInnerBucket(removed));
            builder.field(SCORE, score);
 * Result of the significant terms aggregation.
    }
        }
            for (B bucket : terms.getBuckets()) {
            this.supersetSize = supersetSize;
        public long getSupersetDf() {
        long bucketOrd;
                && Objects.equals(aggregations, that.aggregations)
            this.supersetSize = supersetSize;
        }
}
            subsetDf += bucket.subsetDf;
        super(name, metadata);
         *
        public boolean equals(Object o) {
                        bucket.getSubsetDf(),
            this.supersetDf = supersetDf;
                }
                List<B> existingBuckets = buckets.get(bucket.getKeyAsString());
    );
    /**
    }
            return builder;
                    )
    }
                supersetDf += bucket.supersetDf;
            if (o == null || getClass() != o.getClass()) {
        long supersetDf = 0;
            keyToXContent(builder);
 */
 * SPDX-License-Identifier: Apache-2.0
        minDocCount = in.readVLong();
    protected abstract void writeTermTypeInfoTo(StreamOutput out) throws IOException;
        LocalBucketCountThresholds localBucketCountThresholds = reduceContext.asLocalBucketCountThresholds(bucketCountThresholds);
        // TODO we should refactor to remove this, since buckets should be immutable after they are generated.
        long supersetSize,
    @Override
                    existingBuckets = new ArrayList<>(aggregations.size());
import java.util.ArrayList;
            return subsetSize;
 * Modifications Copyright OpenSearch Contributors. See
/**
    public int hashCode() {
    protected InternalSignificantTerms(
public abstract class InternalSignificantTerms<A extends InternalSignificantTerms<A, B>, B extends InternalSignificantTerms.Bucket<B>>
            }
            builder.field(BG_COUNT, supersetDf);
            if (context.isSliceLevel()) {
    }
            long subsetDf,
 */
                existingBuckets.add(
 * this file be licensed under the Apache-2.0 license or a
        // Compute the overall result set size and the corpus size using the
import org.opensearch.search.aggregations.Aggregations;
            return supersetSize;
        return Objects.equals(minDocCount, that.minDocCount) && Objects.equals(requiredSize, that.requiredSize);
            this.aggregations = aggregations;
        BucketSignificancePriorityQueue<B> ordered = new BucketSignificancePriorityQueue<>(size);
        long supersetDf,
        bucketCountThresholds = new TermsAggregator.CoordinatorBucketCountThresholds(minDocCount, -1, requiredSize, -1);
    public static final String BG_COUNT = "bg_count";
    @SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
