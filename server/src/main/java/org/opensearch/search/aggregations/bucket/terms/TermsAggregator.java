            this.requiredSize = requiredSize;
            shardSize = in.readInt();
            if (parent.getClass() == NestedAggregator.class) {
            this.shardSize = shardSize;
        }
            this.collectMode = SubAggCollectionMode.DEPTH_FIRST;
    protected final Set<Aggregator> aggsUsedForSorting = new HashSet<>();
            if (minDocCount < 0 || shardMinDocCount < 0) {
                    aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
        @Override
/**
            // shard_min_doc_count should not be larger than min_doc_count because this can cause buckets to be removed that would match
 * software distributed under the License is distributed on an
/*
     * @opensearch.api
        @Override
        String name,
            && (collectMode == SubAggCollectionMode.BREADTH_FIRST && !aggsUsedForSorting.contains(aggregator));
              nested documents in a sub-aggregation and we are not able to generate this score
        }
 * Unless required by applicable law or agreed to in writing,
        while (parent != null) {
        }
        private int requiredSize;
 * this file be licensed under the Apache-2.0 license or a
            out.writeInt(requiredSize);
import org.opensearch.search.aggregations.AggregatorFactories;
            shardMinDocCount = in.readLong();
                && Objects.equals(minDocCount, other.minDocCount)
    ) throws IOException {
        }
import org.opensearch.common.annotation.PublicApi;
            this(
        @Override
import org.opensearch.search.aggregations.AggregationExecutionException;
            this.requiredSize = requiredSize;
            parent = parent.parent();
     * BucketCountThresholds type that throws an exception when shardMinDocCount or shardSize are accessed. This is used for
            // shard_size cannot be smaller than size as we need to at least fetch <size> entries from every shards in order to return
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
            this.shardSize = shardSize;
import java.util.HashSet;
            // the min_doc_count criteria
 * You may obtain a copy of the License at
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
import org.opensearch.core.common.io.stream.StreamInput;
            }
import java.util.Map;
        }
     *
        public int getRequiredSize() {
            aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
        }
             */
            this.shardMinDocCount = shardMinDocCount;
                builder.field(TermsAggregationBuilder.SHARD_SIZE_FIELD_NAME.getPreferredName(), shardSize);
            }
import org.opensearch.core.xcontent.ToXContentFragment;
        public BucketCountThresholds(StreamInput in) throws IOException {
    }
package org.opensearch.search.aggregations.bucket.terms;
        for (Aggregator subAgg : subAggregators) {
            throw new AggregationExecutionException("shard_size should not be accessed via CoordinatorBucketCountThresholds");
    }
            builder.field(TermsAggregationBuilder.REQUIRED_SIZE_FIELD_NAME.getPreferredName(), requiredSize);
                bucketCountThresholds.shardSize
 * GitHub history for details.
 *
            this.minDocCount = minDocCount;
        return false;
        if (order instanceof Aggregation aggregation) {
         * Read from a stream.
 * The OpenSearch Contributors require contributions made to
            this.minDocCount = minDocCount;
        public int getShardSize() {
        }
 */
        public long getShardMinDocCount() {
     * coordinator.
        Aggregator parent,
    }
    /**
              while replaying deferred documents.
        SubAggCollectionMode collectMode,
/*
        }
        BucketOrder order,
 * @opensearch.internal
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.aggregations.InternalOrder.Aggregation;
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
        private long shardMinDocCount;
            if (requiredSize <= 0 || shardSize <= 0) {
            if (shardSize != -1) {
        @Override
        public int hashCode() {
                bucketCountThresholds.requiredSize,
     * deserialization on the coordinator during reduce as shardMinDocCount and shardSize should not be accessed this way on the
            out.writeInt(shardSize);
        }
            this.shardMinDocCount = shardMinDocCount;
 * ownership. Elasticsearch licenses this file to you under
            if (shardMinDocCount > minDocCount) {
 *
                if (orderElement instanceof Aggregation aggregation) {
 *
            return minDocCount;
    protected final BucketCountThresholds bucketCountThresholds;
import org.opensearch.search.DocValueFormat;
        }
        }
        public void setRequiredSize(int requiredSize) {
                && Objects.equals(shardMinDocCount, other.shardMinDocCount);
            /*
    }
        private int shardSize;
            return shardMinDocCount;
            }
        DocValueFormat format,
        }
    static boolean descendsFromNestedAggregator(Aggregator parent) {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
            return Objects.hash(requiredSize, shardSize, minDocCount, shardMinDocCount);
            if (getClass() != obj.getClass()) {
        public long getShardMinDocCount() {
                return false;
import org.opensearch.core.common.io.stream.StreamOutput;
            super(minDocCount, shardMinDocCount, requiredSize, shardSize);
        public void ensureValidity() {
        partiallyBuiltBucketComparator = order == null ? null : order.partiallyBuiltBucketComparator(b -> b.bucketOrd, this);
        /**
     * Bucket count thresholds
            // <size>
 * KIND, either express or implied.  See the License for the
            }
    @PublicApi(since = "1.0.0")
        this.order = order;
            if (obj == null) {
    protected boolean shouldDefer(Aggregator aggregator) {
public abstract class TermsAggregator extends DeferableBucketAggregator {
                }
        }
    public static class CoordinatorBucketCountThresholds extends BucketCountThresholds {
        AggregatorFactories factories,
    protected final SubAggCollectionMode collectMode;
 * compatible open source license.
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public TermsAggregator(
/*
            }
        }
            if (shardSize < requiredSize) {
    protected final BucketOrder order;
            out.writeLong(shardMinDocCount);
         */
import java.util.Set;
import org.opensearch.search.aggregations.support.AggregationPath;
        @Override
        Map<String, Object> metadata
            }
        SearchContext context,
 */
            this.collectMode = collectMode;
    protected final DocValueFormat format;
import org.opensearch.OpenSearchException;
            builder.field(TermsAggregationBuilder.SHARD_MIN_DOC_COUNT_FIELD_NAME.getPreferredName(), shardMinDocCount);
}
        if (subAggsNeedScore() && descendsFromNestedAggregator(parent)) {
     *
            }
                bucketCountThresholds.minDocCount,
        } else {
import org.opensearch.search.internal.SearchContext;
        super(name, factories, context, parent, metadata);
    private boolean subAggsNeedScore() {
            for (BucketOrder orderElement : compoundOrder.orderElements()) {
        private long minDocCount;
import java.util.Objects;
            if (subAgg.scoreMode().needsScores()) {
            throw new AggregationExecutionException("shard_min_doc_count should not be accessed via CoordinatorBucketCountThresholds");
            }
    }
            out.writeLong(minDocCount);
            BucketCountThresholds other = (BucketCountThresholds) obj;
                return true;
        public BucketCountThresholds(BucketCountThresholds bucketCountThresholds) {
        }
 */
            }
     * @opensearch.internal
        }
        BucketCountThresholds bucketCountThresholds,
        public void writeTo(StreamOutput out) throws IOException {
                    AggregationPath path = aggregation.path();
     */
        return false;
 */
 * specific language governing permissions and limitations
import java.util.Comparator;
import org.opensearch.core.common.io.stream.Writeable;
        }
                bucketCountThresholds.shardMinDocCount,
            }
        }
 * this work for additional information regarding copyright
            return requiredSize;
                throw new OpenSearchException("parameters [required_size] and [shard_size] must be >0 in terms aggregation.");
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static class BucketCountThresholds implements Writeable, ToXContentFragment {
    protected final Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator;
        }
            return builder;
        public CoordinatorBucketCountThresholds(long minDocCount, long shardMinDocCount, int requiredSize, int shardSize) {
        public boolean equals(Object obj) {
        }
            requiredSize = in.readInt();
import org.opensearch.core.xcontent.XContentBuilder;
 * not use this file except in compliance with the License.
        }
                && Objects.equals(shardSize, other.shardSize)
        public void setShardMinDocCount(long shardMinDocCount) {
                setShardSize(requiredSize);
        public int getShardSize() {
        public long getMinDocCount() {
    @Override
            return Objects.equals(requiredSize, other.requiredSize)
import org.opensearch.search.aggregations.bucket.nested.NestedAggregator;
            );
                return false;
        public void setShardSize(int shardSize) {
     */
            AggregationPath path = aggregation.path();
              Force the execution to depth_first because we need to access the score of
import org.opensearch.search.aggregations.BucketOrder;
        this.bucketCountThresholds = bucketCountThresholds;
        }
        // Don't defer any child agg if we are dependent on it for pruning results
import org.opensearch.search.aggregations.Aggregator;
                throw new OpenSearchException("parameter [min_doc_count] and [shardMinDocCount] must be >=0 in terms aggregation.");
        }
                return true;
 * Base aggregator class to aggregate documents by terms
            minDocCount = in.readLong();
        public void setMinDocCount(long minDocCount) {
        } else if (order instanceof CompoundOrder compoundOrder) {
        public BucketCountThresholds(long minDocCount, long shardMinDocCount, int requiredSize, int shardSize) {
 * under the License.
    }
 * Modifications Copyright OpenSearch Contributors. See
        @Override
 *
            builder.field(TermsAggregationBuilder.MIN_DOC_COUNT_FIELD_NAME.getPreferredName(), minDocCount);
        this.format = format;
                setShardMinDocCount(minDocCount);
            return shardSize;
 * Licensed to Elasticsearch under one or more contributor
        return context.getQueryShardContext().getStarTreeQueryContext() == null
