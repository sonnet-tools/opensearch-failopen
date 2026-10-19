            BaseGeoGrid grid = (BaseGeoGrid) aggregation;
 * license agreements. See the NOTICE file distributed with
                BaseGeoGridBucket bucket = (BaseGeoGridBucket) obj;
        assert buckets.size() > 0;
            bucket.toXContent(builder, params);  
    protected final List<BaseGeoGridBucket> buckets;
                existingBuckets.add(bucket);
    }
                List<BaseGeoGridBucket> existingBuckets = buckets.get(bucket.hashAsLong());
    public BaseGeoGrid reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
     * Read from a stream.
        out.writeList(buckets);  
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        for (BaseGeoGridBucket bucket : buckets) {
/*
    }  
import org.opensearch.search.aggregations.InternalAggregation;
 */
        return unmodifiableList(buckets);
        buckets.close();
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
            if (buckets == null) {  
/*  
        GeoGrid {
    @Override
import org.opensearch.common.util.LongObjectPagedHashMap;  
 * for efficiency's sake.
 */
        long docCount = 0;  
 */
    int getRequiredSize() {
            aggregationsList.add(bucket.aggregations);  
        BaseGeoGridBucket[] list = new BaseGeoGridBucket[ordered.size()];  
        BaseGeoGrid other = (BaseGeoGrid) obj;
    public boolean equals(Object obj) {
        writeSize(requiredSize, out);
        return builder;  
    implements
        builder.endArray();
    // package protected for testing  
    /**  
    protected final int requiredSize;
        }
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.geo.search.aggregations.bucket.geogrid;
        final InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
            docCount += bucket.docCount;
import java.util.Objects;
/**
 * GitHub history for details.
        for (LongObjectPagedHashMap.Cursor<List<BaseGeoGridBucket>> cursor : buckets) {
        super(in);
            List<BaseGeoGridBucket> sameCellBuckets = cursor.value;
    @Override
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
    protected abstract B createBucket(long hashAsLong, long docCount, InternalAggregations aggregations);  
    public List<BaseGeoGridBucket> getBuckets() {  
    @Override  
        buckets = (List<BaseGeoGridBucket>) in.readList(getBucketReader());  
        if (obj == null || getClass() != obj.getClass()) return false;
        }
import java.util.Map;  
        requiredSize = readSize(in);
    }  
 *  
 *
        reduceContext.consumeBucketsAndMaybeBreak(list.length);
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
 * this work for additional information regarding copyright
        return Objects.equals(requiredSize, other.requiredSize) && Objects.equals(buckets, other.buckets);
            }
        if (super.equals(obj) == false) return false;
        }
import static java.util.Collections.unmodifiableList;  
 * this file be licensed under the Apache-2.0 license or a
        return createBucket(buckets.get(0).hashAsLong, docCount, aggs);  
    @Override
 * under the License.  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
 * You may obtain a copy of the License at  
        }  
            list[i] = ordered.pop();
                }  
public abstract class BaseGeoGrid<B extends BaseGeoGridBucket> extends InternalMultiBucketAggregation<BaseGeoGrid, BaseGeoGridBucket>  
    protected BaseGeoGridBucket reduceBucket(List<BaseGeoGridBucket> buckets, ReduceContext context) {  
    protected void doWriteTo(StreamOutput out) throws IOException {
        this.requiredSize = requiredSize;  
            for (Object obj : grid.buckets) {  
 * Represents a grid of cells where each cell's location is determined by a specific geo hashing algorithm.  
    @Override
        }  
        this.buckets = buckets;
        for (int i = ordered.size() - 1; i >= 0; i--) {
        return create(getName(), requiredSize, Arrays.asList(list), getMetadata());
            ordered.insertWithOverflow(reduceBucket(sameCellBuckets, reduceContext));  
        for (InternalAggregation aggregation : aggregations) {
import java.io.IOException;
    }
import org.opensearch.search.aggregations.InternalAggregations;
        final int size = Math.toIntExact(reduceContext.isFinalReduce() == false ? buckets.size() : Math.min(requiredSize, buckets.size()));
                buckets = new LongObjectPagedHashMap<>(grid.buckets.size(), reduceContext.bigArrays());
    protected abstract BaseGeoGrid create(String name, int requiredSize, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata);  
 * SPDX-License-Identifier: Apache-2.0
                if (existingBuckets == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * All geo-grid hash-encoding in a grid are of the same precision and held internally as a single long
        super(name, metadata);
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());
    @Override
    }
                    buckets.put(bucket.hashAsLong(), existingBuckets);
 * software distributed under the License is distributed on an
 *  
    public int hashCode() {  
    protected abstract Reader<B> getBucketReader();
        if (this == obj) return true;  
    protected BaseGeoGrid(String name, int requiredSize, List<BaseGeoGridBucket> buckets, Map<String, Object> metadata) {
        return requiredSize;
/*
    @Override
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
    }
    public BaseGeoGrid(StreamInput in) throws IOException {  
import java.util.ArrayList;  
     */
        for (BaseGeoGridBucket bucket : buckets) {
        LongObjectPagedHashMap<List<BaseGeoGridBucket>> buckets = null;  
                    existingBuckets = new ArrayList<>(aggregations.size());
}
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Licensed to Elasticsearch under one or more contributor  
            }
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        return Objects.hash(super.hashCode(), requiredSize, buckets);
    }
import java.util.Arrays;
 *
    }  
        BucketPriorityQueue<BaseGeoGridBucket> ordered = new BucketPriorityQueue<>(size);  
