        out.writeVInt(buckets.size());
                bucketsList = new ArrayList<>(filters.buckets.size());
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        if (super.equals(obj) == false) return false;
        reduceContext.consumeBucketsAndMaybeBreak(bucketsList.size());
        this.bucketMap = null;
            key = in.readOptionalString();
/*
        if (bucketMap == null) {
package org.opensearch.search.aggregations.bucket.filter;
 * license agreements. See the NOTICE file distributed with
        public void writeTo(StreamOutput out) throws IOException {
        public String getKey() {
        return buckets;
            return builder;
            return Objects.equals(key, that.key)
    }
                    List<InternalBucket> sameRangeList = new ArrayList<>(aggregations.size());
            docCount = in.readVLong();
                bucketMap.put(bucket.getKey(), bucket);
        }
                }
        for (List<InternalBucket> sameRangeList : bucketsList) {
        @Override
    public InternalFilters(String name, List<InternalBucket> buckets, boolean keyed, Map<String, Object> metadata) {
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
            } else {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        for (InternalBucket bucket : buckets) {
        @Override
 * not use this file except in compliance with the License.
        if (keyed) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public long getDocCount() {
    public InternalBucket createBucket(InternalAggregations aggregations, InternalBucket prototype) {
    @Override
 * software distributed under the License is distributed on an
        @Override
 */
import org.opensearch.core.common.io.stream.StreamInput;
            aggregations = InternalAggregations.readFrom(in);
    /**
            reduced.buckets.add(reduceBucket(sameRangeList, reduceContext));
            return aggregations;
            return Objects.hash(getClass(), key, keyed, docCount, aggregations);
                builder.startObject();
 * this file be licensed under the Apache-2.0 license or a
        return new InternalBucket(prototype.key, prototype.docCount, aggregations, prototype.keyed);
            aggregationsList.add(bucket.aggregations);
import java.util.HashMap;
        public InternalBucket(StreamInput in, boolean keyed) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        List<InternalBucket> buckets = new ArrayList<>(size);
        }
        int size = in.readVInt();
    @Override
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        @Override
                reduced = new InternalBucket(bucket.key, bucket.docCount, bucket.aggregations, bucket.keyed);
        return FiltersAggregationBuilder.NAME;
 *
import org.opensearch.search.aggregations.InternalAggregation;
            }
        return builder;
    @Override
            for (InternalBucket bucket : buckets) {
 */
        } else {
    /**
public class InternalFilters extends InternalMultiBucketAggregation<InternalFilters, InternalFilters.InternalBucket> implements Filters {
        InternalFilters that = (InternalFilters) obj;
     * Read from a stream.
     *
        }
import org.opensearch.search.aggregations.InternalAggregations;
            InternalFilters filters = (InternalFilters) aggregation;
        for (InternalAggregation aggregation : aggregations) {
import org.opensearch.core.common.io.stream.StreamOutput;
                builder.startObject(key);
            if (this == other) {
        InternalAggregations aggregations;
    public static class InternalBucket extends InternalMultiBucketAggregation.InternalBucket implements Filters.Bucket {
    private final List<InternalBucket> buckets;
        private final String key;
        }
 *
        }
    public boolean equals(Object obj) {
        InternalBucket reduced = null;
            this.keyed = keyed;
 * SPDX-License-Identifier: Apache-2.0
                return true;
                    bucketsList.get(i++).add(bucket);
        List<List<InternalBucket>> bucketsList = null;
                && Objects.equals(docCount, that.docCount)
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
            this.keyed = keyed;
        }
    }
/*
 * @opensearch.internal
    public List<InternalBucket> getBuckets() {
 *
        return reduced;
                    sameRangeList.add(bucket);
    @Override
    public InternalBucket getBucketByKey(String key) {
import org.opensearch.search.aggregations.Aggregations;
}
    @Override
            builder.endObject();
            }
    }
        if (obj == null || getClass() != obj.getClass()) return false;
    }
        }
     */
            }
            InternalBucket that = (InternalBucket) other;
            this.aggregations = aggregations;
        public int hashCode() {
    @Override
        } else {
            } else {
            return key;
            } else {
        }
        }
        public boolean equals(Object other) {
 * KIND, either express or implied.  See the License for the
        }
        for (InternalBucket bucket : buckets) {
/*
    public int hashCode() {
        for (InternalBucket bucket : buckets) {
        @Override
         */
    @Override
    }
 * You may obtain a copy of the License at
    }
            aggregations.toXContentInternal(builder, params);
            this.key = key;
        out.writeBoolean(keyed);
 * under the License.
                && Objects.equals(aggregations, that.aggregations);
            }
        }
        if (keyed) {
    }
    }
 * ownership. Elasticsearch licenses this file to you under
            bucket.writeTo(out);
        /**
    }
                && Objects.equals(keyed, that.keyed)
    public InternalFilters create(List<InternalBucket> buckets) {
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return Objects.hash(super.hashCode(), buckets, keyed);
        }
            bucket.toXContent(builder, params);
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.internal
        this.keyed = keyed;
    @Override
    @Override
            }
        return reduced;
                }
    @Override
 */
    // bucketMap gets lazily initialized from buckets in getBucketByKey()
            }
    protected InternalBucket reduceBucket(List<InternalBucket> buckets, ReduceContext context) {
                for (InternalBucket bucket : filters.buckets) {
        keyed = in.readBoolean();
        @Override
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    bucketsList.add(sameRangeList);
    @Override
        @Override
        return bucketMap.get(key);
            if (bucketsList == null) {
 *
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());
        super(in);
import java.util.ArrayList;
        assert buckets.size() > 0;
        public String getKeyAsString() {
            out.writeVLong(docCount);
    }
 */
            builder.endArray();
                int i = 0;
    protected void doWriteTo(StreamOutput out) throws IOException {
            if (other == null || getClass() != other.getClass()) {
 * The OpenSearch Contributors require contributions made to
        InternalFilters reduced = new InternalFilters(name, new ArrayList<>(bucketsList.size()), keyed, getMetadata());
    private transient Map<String, InternalBucket> bucketMap;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
     * Internal bucket for an internal filters agg
 * GitHub history for details.
         * Read from a stream.
 * Licensed to Elasticsearch under one or more contributor
import java.util.Objects;
     */
        }
            bucketMap = new HashMap<>(buckets.size());
    public InternalFilters(StreamInput in) throws IOException {
        return Objects.equals(buckets, that.buckets) && Objects.equals(keyed, that.keyed);
        reduced.aggregations = InternalAggregations.reduce(aggregationsList, context);
import java.util.List;
            if (keyed) {
            out.writeOptionalString(key);
        @Override
    }
        public InternalBucket(String key, long docCount, InternalAggregations aggregations, boolean keyed) {
                reduced.docCount += bucket.docCount;
        this.buckets = buckets;
                return false;
            aggregations.writeTo(out);
import java.io.IOException;
        for (int i = 0; i < size; i++) {
            buckets.add(new InternalBucket(in, keyed));
            if (reduced == null) {
            return key;
 * this work for additional information regarding copyright
        super(name, metadata);
        this.buckets = buckets;
/**
        if (this == obj) return true;
            builder.endObject();
        private long docCount;
import java.util.Map;
            this.docCount = docCount;
 * Unless required by applicable law or agreed to in writing,
        private final boolean keyed;
        }
        }
        }
    private final boolean keyed;
        return new InternalFilters(name, buckets, keyed, metadata);
        public Aggregations getAggregations() {
                for (InternalBucket bucket : filters.buckets) {
        }
        }
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
 * specific language governing permissions and limitations
            return docCount;
 * Implementation of filters agg
        }
    }
    public String getWriteableName() {
