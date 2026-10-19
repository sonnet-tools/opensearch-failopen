    }
 * under the License.  
    protected final void writeTermTypeInfoTo(StreamOutput out) throws IOException {
        this.docCountError = docCountError;
    }
        return doXContentCommon(builder, params, docCountError, otherDocCount, buckets);  
    }
        Map<String, Object> metadata,  
    public boolean equals(Object obj) {  
    protected long docCountError;  
            && Objects.equals(otherDocCount, that.otherDocCount)
 * compatible open source license.
        this.docCountError = docCountError;
        return otherDocCount;
        showTermDocCountError = in.readBoolean();
    protected final int shardSize;  
        return shardSize;  
        if (obj == null || getClass() != obj.getClass()) return false;
            && Objects.equals(format, that.format)
        out.writeNamedWriteable(format);
    protected InternalMappedTerms(
        int shardSize,
    }  
 * Common superclass for results of the terms aggregation on mapped fields.  
/**
 * GitHub history for details.
    protected Map<String, B> bucketMap;
/*  
        docCountError = in.readZLong();
        TermsAggregator.BucketCountThresholds bucketCountThresholds
    @Override
    protected void setDocCountError(long docCountError) {  
        return Objects.hash(super.hashCode(), buckets, format, otherDocCount, showTermDocCountError, shardSize);
 *
        List<B> buckets,
    public List<B> getBuckets() {
 * not use this file except in compliance with the License.
        boolean showTermDocCountError,  
            && Objects.equals(shardSize, that.shardSize)
        writeSize(shardSize, out);
import java.util.Map;  
            && Objects.equals(showTermDocCountError, that.showTermDocCountError)  
        this.buckets = buckets;  
        if (this == obj) return true;
        DocValueFormat format,
    }  
        super(in);
 * specific language governing permissions and limitations
    }
            && Objects.equals(docCountError, that.docCountError);
        otherDocCount = in.readVLong();  
/*
import org.opensearch.search.aggregations.BucketOrder;
     */
/*  
    @Override  
}
        this.format = format;
        return buckets;  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        this.shardSize = shardSize;
import org.opensearch.core.common.io.stream.StreamOutput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class InternalMappedTerms<A extends InternalTerms<A, B>, B extends InternalTerms.Bucket<B>> extends InternalTerms<A, B> {
            bucketMap = buckets.stream().collect(Collectors.toMap(Bucket::getKeyAsString, Function.identity()));  
 */  
    protected final long otherDocCount;
 * SPDX-License-Identifier: Apache-2.0
    public long getDocCountError() {
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
 */
        out.writeBoolean(showTermDocCountError);  
 * software distributed under the License is distributed on an
        if (super.equals(obj) == false) return false;  
    public long getSumOfOtherDocCounts() {  
    protected InternalMappedTerms(StreamInput in, Bucket.Reader<B> bucketReader) throws IOException {  
        out.writeVLong(otherDocCount);
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Function;
    protected final boolean showTermDocCountError;
    }  
     * Read from a stream.
    @Override
    protected final DocValueFormat format;
import java.util.List;
        format = in.readNamedWriteable(DocValueFormat.class);  
 */  
import java.util.stream.Collectors;  
        BucketOrder reduceOrder,
        if (bucketMap == null) {
        buckets = in.readList(stream -> bucketReader.read(stream, format, showTermDocCountError));
 *
        }
        BucketOrder order,
    public final XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        long docCountError,  
 * Licensed to Elasticsearch under one or more contributor  
    protected int getShardSize() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
        out.writeList(buckets);
        return docCountError;
        long otherDocCount,
    }
        this.otherDocCount = otherDocCount;
 * @opensearch.internal
        shardSize = readSize(in);
    @Override
        String name,  
    @Override
        return Objects.equals(buckets, that.buckets)  
 * You may obtain a copy of the License at  
    public int hashCode() {  
 */  
    }
import java.util.Objects;
        this.showTermDocCountError = showTermDocCountError;  
    protected final List<B> buckets;  
import java.io.IOException;
    @Override  
    public B getBucketByKey(String term) {
 * Unless required by applicable law or agreed to in writing,
    }  
package org.opensearch.search.aggregations.bucket.terms;
        InternalMappedTerms<?, ?> that = (InternalMappedTerms<?, ?>) obj;
        out.writeZLong(docCountError);  
        super(name, reduceOrder, order, bucketCountThresholds, metadata);  
    }
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;  
 *  
 * The OpenSearch Contributors require contributions made to  
    ) {
import org.opensearch.search.DocValueFormat;
    @Override
 *
 * license agreements. See the NOTICE file distributed with
        return bucketMap.get(term);
