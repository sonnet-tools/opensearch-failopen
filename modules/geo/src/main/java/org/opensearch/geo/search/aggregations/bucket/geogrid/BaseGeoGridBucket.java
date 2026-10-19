        this.docCount = docCount;
        builder.field(Aggregation.CommonFields.DOC_COUNT.getPreferredName(), docCount);  
    }
    }
        if (o == null || getClass() != o.getClass()) return false;  
        builder.field(Aggregation.CommonFields.KEY.getPreferredName(), getKeyAsString());
 * @opensearch.api
    implements
        builder.startObject();
}
        Comparable<BaseGeoGridBucket> {
 * specific language governing permissions and limitations
 */  
        this.hashAsLong = hashAsLong;  
            return -1;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        if (this.hashAsLong < other.hashAsLong) {
import org.opensearch.core.xcontent.XContentBuilder;
        if (this == o) return true;
    public BaseGeoGridBucket(StreamInput in) throws IOException {  
        this.aggregations = aggregations;
        return 0;
    }  
        return hashAsLong == bucket.hashAsLong && docCount == bucket.docCount && Objects.equals(aggregations, bucket.aggregations);
    @Override  
        return hashAsLong;
import org.opensearch.search.aggregations.Aggregations;
    public Aggregations getAggregations() {
 */
 * under the License.  
/*
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamOutput;
        hashAsLong = in.readLong();
        return aggregations;  
        aggregations = InternalAggregations.readFrom(in);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
    public int compareTo(BaseGeoGridBucket other) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;  
    long bucketOrd;
    public long hashAsLong() {
    }  
    @Override
        BaseGeoGridBucket bucket = (BaseGeoGridBucket) o;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 *
    public boolean equals(Object o) {
        aggregations.writeTo(out);
    public void writeTo(StreamOutput out) throws IOException {
        out.writeLong(hashAsLong);
        }
        GeoGrid.Bucket,  
        return builder;  
     */
    /**  
    protected long hashAsLong;  
    @Override  
    }
        if (this.hashAsLong > other.hashAsLong) {
        out.writeVLong(docCount);  
    public BaseGeoGridBucket(long hashAsLong, long docCount, InternalAggregations aggregations) {  
import org.opensearch.search.aggregations.InternalAggregations;
    protected InternalAggregations aggregations;
public abstract class BaseGeoGridBucket<B extends BaseGeoGridBucket> extends InternalMultiBucketAggregation.InternalBucket
 * The OpenSearch Contributors require contributions made to  
        }
    @Override
    @Override
 * Base implementation of geogrid aggs  
 * Licensed to Elasticsearch under one or more contributor  
/**
 *
 * compatible open source license.
    protected long docCount;
        builder.endObject();
 * You may obtain a copy of the License at  
    }
            return 1;  
 * GitHub history for details.
 *  
 * this work for additional information regarding copyright
    }
    public int hashCode() {  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
 * license agreements. See the NOTICE file distributed with
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    }  
 * Modifications Copyright OpenSearch Contributors. See  
 */
/*
    }
    public long getDocCount() {  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;  
 * software distributed under the License is distributed on an
     * Read from a stream.
    }
 */  
        return docCount;
package org.opensearch.geo.search.aggregations.bucket.geogrid;
        aggregations.toXContentInternal(builder, params);
        docCount = in.readVLong();
import org.opensearch.search.aggregations.Aggregation;  
/*  
        return Objects.hash(hashAsLong, docCount, aggregations);
