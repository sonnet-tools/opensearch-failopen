                reduced = new InternalBucket(bucket.key, bucket.docCount, bucket.aggregations, bucket.keyed);  
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
        }
        }
        this.bucketMap = null;  
    @Override
        private final boolean keyed;
    public InternalBucket createBucket(InternalAggregations aggregations, InternalBucket prototype) {
import org.opensearch.search.aggregations.Aggregations;
                    bucketsList.add(sameRangeList);
            reduced.buckets.add(reduceBucket(sameRangeList, reduceContext));  
            InternalFilters filters = (InternalFilters) aggregation;
 */
            if (keyed) {
        return Objects.equals(buckets, that.buckets) && Objects.equals(keyed, that.keyed);
 * specific language governing permissions and limitations
public class InternalFilters extends InternalMultiBucketAggregation<InternalFilters, InternalFilters.InternalBucket> implements Filters {  
 * not use this file except in compliance with the License.
    private final boolean keyed;
    public InternalFilters(String name, List<InternalBucket> buckets, boolean keyed, Map<String, Object> metadata) {  
 * this file be licensed under the Apache-2.0 license or a
        InternalBucket reduced = null;
            this.aggregations = aggregations;
            if (this == other) {  
    /**  
        }  
            bucket.toXContent(builder, params);  
import org.opensearch.core.common.io.stream.StreamOutput;
        return FiltersAggregationBuilder.NAME;
    public InternalFilters(StreamInput in) throws IOException {  
            } else {
            }
        }  
            key = in.readOptionalString();
    @Override  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
package org.opensearch.search.aggregations.bucket.filter;
            out.writeVLong(docCount);  
 * @opensearch.internal
        for (int i = 0; i < size; i++) {
            docCount = in.readVLong();
    }
            if (other == null || getClass() != other.getClass()) {  
    private transient Map<String, InternalBucket> bucketMap;
import java.util.Map;
        public InternalBucket(StreamInput in, boolean keyed) throws IOException {
         * Read from a stream.  
    @Override
     *  
     */
        out.writeBoolean(keyed);
                return true;
    }
                for (InternalBucket bucket : filters.buckets) {  
        InternalFilters reduced = new InternalFilters(name, new ArrayList<>(bucketsList.size()), keyed, getMetadata());
     * @opensearch.internal
            this.key = key;
        List<InternalBucket> buckets = new ArrayList<>(size);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
        reduced.aggregations = InternalAggregations.reduce(aggregationsList, context);  
    }
            } else {
        @Override  
                return false;
            return builder;
            if (reduced == null) {
    public InternalBucket getBucketByKey(String key) {  
        super(in);
    @Override  
    @Override  
                    sameRangeList.add(bucket);
    }
        @Override  
        }
        if (bucketMap == null) {
        }
import org.opensearch.search.aggregations.InternalAggregations;  
            this.keyed = keyed;
import java.io.IOException;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
    }  
 * this work for additional information regarding copyright
        }
 * You may obtain a copy of the License at  
        return buckets;
        @Override
            }
import java.util.HashMap;
        }  
        }
                for (InternalBucket bucket : filters.buckets) {
            }  
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());  
        super(name, metadata);
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    public int hashCode() {
 *  
    }
/**
    }
 * The OpenSearch Contributors require contributions made to  
    @Override
    }
                builder.startObject(key);  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            }  
     * Internal bucket for an internal filters agg
        keyed = in.readBoolean();
                reduced.docCount += bucket.docCount;
            return Objects.hash(getClass(), key, keyed, docCount, aggregations);  
        public void writeTo(StreamOutput out) throws IOException {
    }
                bucketsList = new ArrayList<>(filters.buckets.size());
        List<List<InternalBucket>> bucketsList = null;  
        InternalAggregations aggregations;
        if (this == obj) return true;
        for (List<InternalBucket> sameRangeList : bucketsList) {
        } else {
    }  
            }  
        if (keyed) {
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
}
            this.keyed = keyed;  
 * GitHub history for details.
            if (bucketsList == null) {  
        assert buckets.size() > 0;
        }
 * software distributed under the License is distributed on an
 * Implementation of filters agg
        InternalFilters that = (InternalFilters) obj;  
        @Override  
     * Read from a stream.
    public boolean equals(Object obj) {
        return Objects.hash(super.hashCode(), buckets, keyed);  
        for (InternalAggregation aggregation : aggregations) {
    @Override  
            return aggregations;  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        reduceContext.consumeBucketsAndMaybeBreak(bucketsList.size());  
        private final String key;  
        this.keyed = keyed;  
        if (obj == null || getClass() != obj.getClass()) return false;  
    public List<InternalBucket> getBuckets() {
        for (InternalBucket bucket : buckets) {
         */
import java.util.List;  
 * KIND, either express or implied.  See the License for the
        }
            return docCount;
        public Aggregations getAggregations() {
            this.docCount = docCount;  
            aggregationsList.add(bucket.aggregations);
/*  
    /**
import org.opensearch.core.common.io.stream.StreamInput;
        this.buckets = buckets;
 *
    protected InternalBucket reduceBucket(List<InternalBucket> buckets, ReduceContext context) {  
    public InternalFilters create(List<InternalBucket> buckets) {  
 */  
            return key;  
            } else {
import org.opensearch.core.xcontent.XContentBuilder;  
                bucketMap.put(bucket.getKey(), bucket);
                }  
            bucketMap = new HashMap<>(buckets.size());
                && Objects.equals(docCount, that.docCount)  
        public long getDocCount() {  
        @Override
        for (InternalBucket bucket : buckets) {
    @Override
        return reduced;
     */
    public String getWriteableName() {
                    bucketsList.get(i++).add(bucket);
        }
    @Override
        if (keyed) {  
                builder.startObject();
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
        int size = in.readVInt();  
            aggregations.toXContentInternal(builder, params);
        /**
            bucket.writeTo(out);
        return bucketMap.get(key);
            InternalBucket that = (InternalBucket) other;  
 *
 *  
                && Objects.equals(aggregations, that.aggregations);
        @Override
        return new InternalFilters(name, buckets, keyed, metadata);
        return reduced;
        }
            for (InternalBucket bucket : buckets) {  
        if (super.equals(obj) == false) return false;
            builder.endObject();  
        out.writeVInt(buckets.size());  
        public boolean equals(Object other) {
            return key;
        }
    @Override
    }
        }  
        } else {
        this.buckets = buckets;
 * Licensed to Elasticsearch under one or more contributor  
        return new InternalBucket(prototype.key, prototype.docCount, aggregations, prototype.keyed);  
import org.opensearch.search.aggregations.InternalAggregation;
            out.writeOptionalString(key);
                && Objects.equals(keyed, that.keyed)
    private final List<InternalBucket> buckets;
                int i = 0;
            builder.startArray(CommonFields.BUCKETS.getPreferredName());  
        public String getKeyAsString() {
                }
 * SPDX-License-Identifier: Apache-2.0
        }  
            builder.endArray();
/*
        @Override
 * under the License.  
/*  
                    List<InternalBucket> sameRangeList = new ArrayList<>(aggregations.size());  
 */  
    }  
        }
        public InternalBucket(String key, long docCount, InternalAggregations aggregations, boolean keyed) {
        for (InternalBucket bucket : buckets) {
        return builder;
            return Objects.equals(key, that.key)
import java.util.ArrayList;
        public String getKey() {
            aggregations.writeTo(out);
            builder.endObject();  
        }
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        private long docCount;
    }
    public static class InternalBucket extends InternalMultiBucketAggregation.InternalBucket implements Filters.Bucket {  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
            buckets.add(new InternalBucket(in, keyed));  
            }
import java.util.Objects;
    // bucketMap gets lazily initialized from buckets in getBucketByKey()  
        public int hashCode() {
            aggregations = InternalAggregations.readFrom(in);  
