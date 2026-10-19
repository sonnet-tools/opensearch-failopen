            return shardSize;
    static boolean descendsFromNestedAggregator(Aggregator parent) {
        this.format = format;  
            this.requiredSize = requiredSize;
            }  
        if (subAggsNeedScore() && descendsFromNestedAggregator(parent)) {
        public long getMinDocCount() {  
            return builder;
        }  
    }  
            return Objects.equals(requiredSize, other.requiredSize)
            builder.field(TermsAggregationBuilder.SHARD_MIN_DOC_COUNT_FIELD_NAME.getPreferredName(), shardMinDocCount);
public abstract class TermsAggregator extends DeferableBucketAggregator {
    @PublicApi(since = "1.0.0")  
        }
            return shardMinDocCount;
                && Objects.equals(shardMinDocCount, other.shardMinDocCount);
        private int requiredSize;
 *
            if (obj == null) {  
                throw new OpenSearchException("parameter [min_doc_count] and [shardMinDocCount] must be >=0 in terms aggregation.");  
        }  
/**  
                return true;
            this.minDocCount = minDocCount;
        public void ensureValidity() {
        public void setShardMinDocCount(long shardMinDocCount) {
        }  
        public int hashCode() {  
     *  
        }  
import org.opensearch.search.aggregations.Aggregator;
import java.util.Objects;  
        SearchContext context,  
 */
                return false;
                setShardMinDocCount(minDocCount);
        Aggregator parent,
}
        public CoordinatorBucketCountThresholds(long minDocCount, long shardMinDocCount, int requiredSize, int shardSize) {
            if (subAgg.scoreMode().needsScores()) {
        BucketOrder order,  
        super(name, factories, context, parent, metadata);
import org.opensearch.search.aggregations.AggregationExecutionException;  
        @Override
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
            super(minDocCount, shardMinDocCount, requiredSize, shardSize);  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            out.writeLong(shardMinDocCount);
            this.shardMinDocCount = shardMinDocCount;  
                    aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
              while replaying deferred documents.
 * @opensearch.internal  
    }  
 *
import org.opensearch.core.common.io.stream.Writeable;
     */
import org.opensearch.core.common.io.stream.StreamInput;  
                && Objects.equals(minDocCount, other.minDocCount)  
        }
            for (BucketOrder orderElement : compoundOrder.orderElements()) {
            }  
            out.writeInt(shardSize);  
        private long minDocCount;
            // the min_doc_count criteria
            if (shardMinDocCount > minDocCount) {  
    protected final BucketOrder order;
            BucketCountThresholds other = (BucketCountThresholds) obj;  
import java.util.HashSet;
        } else if (order instanceof CompoundOrder compoundOrder) {  
 *  
/*  
            }
import org.opensearch.search.DocValueFormat;
                && Objects.equals(shardSize, other.shardSize)
            if (shardSize < requiredSize) {  
        }
        AggregatorFactories factories,
        @Override
     * Bucket count thresholds
            }  
import org.opensearch.search.aggregations.bucket.nested.NestedAggregator;
 * specific language governing permissions and limitations
import java.util.Comparator;  
            minDocCount = in.readLong();
 * not use this file except in compliance with the License.
        while (parent != null) {
            AggregationPath path = aggregation.path();
        public int getShardSize() {
            if (getClass() != obj.getClass()) {  
        DocValueFormat format,
    protected final SubAggCollectionMode collectMode;
        public int getRequiredSize() {
            this.collectMode = SubAggCollectionMode.DEPTH_FIRST;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        public long getShardMinDocCount() {
        partiallyBuiltBucketComparator = order == null ? null : order.partiallyBuiltBucketComparator(b -> b.bucketOrd, this);
        public void setShardSize(int shardSize) {
/*  
                }
    /**
        @Override
    private boolean subAggsNeedScore() {
    public TermsAggregator(  
                return false;
            throw new AggregationExecutionException("shard_size should not be accessed via CoordinatorBucketCountThresholds");
            throw new AggregationExecutionException("shard_min_doc_count should not be accessed via CoordinatorBucketCountThresholds");
     *  
            if (requiredSize <= 0 || shardSize <= 0) {
            }
            return Objects.hash(requiredSize, shardSize, minDocCount, shardMinDocCount);
        public void setMinDocCount(long minDocCount) {
/*
        return false;
 */
import java.io.IOException;
                bucketCountThresholds.minDocCount,
            this.shardSize = shardSize;
        return false;
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;  
    protected final BucketCountThresholds bucketCountThresholds;  
                bucketCountThresholds.requiredSize,  
import org.opensearch.OpenSearchException;
                throw new OpenSearchException("parameters [required_size] and [shard_size] must be >0 in terms aggregation.");
            return minDocCount;
        private long shardMinDocCount;  
            shardSize = in.readInt();
        }
            this.shardSize = shardSize;  
        String name,
        }
        /**
    }  
import org.opensearch.search.aggregations.InternalOrder.Aggregation;
            if (shardSize != -1) {  
        }
        this.bucketCountThresholds = bucketCountThresholds;  
        }
        @Override  
 * SPDX-License-Identifier: Apache-2.0
            return requiredSize;  
        }  
 * Modifications Copyright OpenSearch Contributors. See
         */
package org.opensearch.search.aggregations.bucket.terms;
        public boolean equals(Object obj) {
            aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
            builder.field(TermsAggregationBuilder.MIN_DOC_COUNT_FIELD_NAME.getPreferredName(), minDocCount);  
         * Read from a stream.  
            }
    public static class BucketCountThresholds implements Writeable, ToXContentFragment {
        public BucketCountThresholds(long minDocCount, long shardMinDocCount, int requiredSize, int shardSize) {
 * ownership. Elasticsearch licenses this file to you under  
        public BucketCountThresholds(BucketCountThresholds bucketCountThresholds) {
import org.opensearch.search.internal.SearchContext;  
            requiredSize = in.readInt();  
            if (parent.getClass() == NestedAggregator.class) {  
import org.opensearch.search.aggregations.support.AggregationPath;
            parent = parent.parent();  
            this.minDocCount = minDocCount;
            }
            out.writeLong(minDocCount);
        for (Aggregator subAgg : subAggregators) {  
    }  
     * BucketCountThresholds type that throws an exception when shardMinDocCount or shardSize are accessed. This is used for  
            }
        BucketCountThresholds bucketCountThresholds,
import org.opensearch.common.annotation.PublicApi;
 * Base aggregator class to aggregate documents by terms
        }
        public int getShardSize() {  
    }  
              nested documents in a sub-aggregation and we are not able to generate this score
        }
 * the Apache License, Version 2.0 (the "License"); you may
        this.order = order;
    ) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
            if (minDocCount < 0 || shardMinDocCount < 0) {
                bucketCountThresholds.shardSize
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
        return context.getQueryShardContext().getStarTreeQueryContext() == null
            );
                bucketCountThresholds.shardMinDocCount,
            shardMinDocCount = in.readLong();  
 */  
        Map<String, Object> metadata  
        }  
                if (orderElement instanceof Aggregation aggregation) {
 * The OpenSearch Contributors require contributions made to  
    protected final Set<Aggregator> aggsUsedForSorting = new HashSet<>();  
import org.opensearch.core.xcontent.ToXContentFragment;  
 * Unless required by applicable law or agreed to in writing,
            // shard_min_doc_count should not be larger than min_doc_count because this can cause buckets to be removed that would match
              Force the execution to depth_first because we need to access the score of  
                return true;
            builder.field(TermsAggregationBuilder.REQUIRED_SIZE_FIELD_NAME.getPreferredName(), requiredSize);
            this.shardMinDocCount = shardMinDocCount;  
        }
        }
 */  
        }  
    public static class CoordinatorBucketCountThresholds extends BucketCountThresholds {  
     */
        public long getShardMinDocCount() {
            out.writeInt(requiredSize);
     * @opensearch.internal
        }
 * software distributed under the License is distributed on an
     * @opensearch.api
                    AggregationPath path = aggregation.path();  
        public void setRequiredSize(int requiredSize) {  
     * coordinator.
 * under the License.  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override  
import java.util.Map;
 * KIND, either express or implied.  See the License for the
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        if (order instanceof Aggregation aggregation) {  
 * GitHub history for details.
            }
    protected boolean shouldDefer(Aggregator aggregator) {  
        private int shardSize;
import org.opensearch.search.aggregations.BucketOrder;  
        public void writeTo(StreamOutput out) throws IOException {
            // <size>
 * compatible open source license.
        @Override  
                setShardSize(requiredSize);
 *
            }
        }  
            /*
            // shard_size cannot be smaller than size as we need to at least fetch <size> entries from every shards in order to return
 * You may obtain a copy of the License at  
            this(  
             */  
     * deserialization on the coordinator during reduce as shardMinDocCount and shardSize should not be accessed this way on the
    protected final DocValueFormat format;
        }
        }
    protected final Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator;
        SubAggCollectionMode collectMode,
            this.requiredSize = requiredSize;
    }
            this.collectMode = collectMode;  
                builder.field(TermsAggregationBuilder.SHARD_SIZE_FIELD_NAME.getPreferredName(), shardSize);
        public BucketCountThresholds(StreamInput in) throws IOException {
            && (collectMode == SubAggCollectionMode.BREADTH_FIRST && !aggsUsedForSorting.contains(aggregator));
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
import java.util.Set;
import org.opensearch.search.aggregations.AggregatorFactories;
 * this work for additional information regarding copyright
        // Don't defer any child agg if we are dependent on it for pruning results
