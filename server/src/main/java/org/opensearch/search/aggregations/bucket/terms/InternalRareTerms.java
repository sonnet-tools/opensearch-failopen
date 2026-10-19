    protected final void doWriteTo(StreamOutput out) throws IOException {
        @Override  
            aggregations.writeTo(out);  
        protected abstract void writeTermTo(StreamOutput out) throws IOException;
        InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
        return builder;
    protected InternalRareTerms(String name, BucketOrder order, long maxDocCount, Map<String, Object> metadata) {
    public abstract List<B> getBuckets();
        out.writeVLong(maxDocCount);
        throw new UnsupportedOperationException();  
     * Create an array to hold some buckets. Used in collecting the results.  
        }
        implements
        assert buckets.size() > 0;
        }  
        return Objects.equals(maxDocCount, that.maxDocCount) && Objects.equals(order, that.order);
        @Override
 * KIND, either express or implied.  See the License for the
        @FunctionalInterface
    }
     *
    protected final BucketOrder order;
        }
        @Override
        long bucketOrd;  
     */  
        return createBucket(docCount, aggs, buckets.get(0));  
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());  
    /**
        protected long docCount;
            return Objects.hash(getClass(), docCount, aggregations);  
    }
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
    @Override
        for (Bucket bucket : buckets) {  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
        protected InternalAggregations aggregations;  
            builder.endObject();
        @Override  
import org.opensearch.core.common.io.stream.StreamInput;
 * You may obtain a copy of the License at  
import java.util.ArrayList;
    }
        }
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    /**
        long docCount = 0;
 * this work for additional information regarding copyright
import java.io.IOException;
        public final void writeTo(StreamOutput out) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 *
        public Aggregations getAggregations() {  
    }
 */  
         *
 * software distributed under the License is distributed on an
        }
import org.opensearch.search.aggregations.InternalAggregation;
/*
         * Read from a stream.
     * Read from a stream.
public abstract class InternalRareTerms<A extends InternalRareTerms<A, B>, B extends InternalRareTerms.Bucket<B>> extends  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        this.order = order;  
            KeyComparable<B> {
     */
        protected Bucket(long docCount, InternalAggregations aggregations, DocValueFormat formatter) {  
            return docCount;
        protected Bucket(StreamInput in, DocValueFormat formatter) throws IOException {  
/**
    protected abstract void writeTermTypeInfoTo(StreamOutput out) throws IOException;
/*  
    protected final long maxDocCount;
 * Unless required by applicable law or agreed to in writing,
         * @opensearch.internal
        order = InternalOrder.Streams.readOrder(in);  
 * Implementation of rare terms
        }  
            this.format = formatter;
import java.util.Map;
        return Objects.hash(super.hashCode(), maxDocCount, order);  
 * GitHub history for details.
        public long getDocCount() {
            RareTerms.Bucket,  
 *
            bucket.toXContent(builder, params);
        order.writeTo(out);  
import org.opensearch.common.util.SetBackedScalingCuckooFilter;  
    implements
         */  
    public abstract static class Bucket<B extends Bucket<B>> extends InternalMultiBucketAggregation.InternalBucket
 * Licensed to Elasticsearch under one or more contributor  
        @Override
}  
            aggregationsList.add(bucket.aggregations);  
 *  
 * under the License.  
        throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
 * compatible open source license.
        /**
    protected static XContentBuilder doXContentCommon(XContentBuilder builder, Params params, List<? extends Bucket> buckets)  
     */  
 * @opensearch.internal
        if (super.equals(obj) == false) return false;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
    @Override
            docCount += bucket.docCount;
         * Reads a bucket. Should be a constructor reference.  
        this.maxDocCount = maxDocCount;
        builder.endArray();  
                return false;
            this.docCount = docCount;
 * specific language governing permissions and limitations
        public int hashCode() {
            return Objects.equals(docCount, that.docCount) && Objects.equals(aggregations, that.aggregations);
    protected abstract B[] createBucketsArray(int size);
 * license agreements. See the NOTICE file distributed with
    protected InternalRareTerms(StreamInput in) throws IOException {
            writeTermTo(out);
    @Override
            keyToXContent(builder);
    }
/*
import org.opensearch.search.aggregations.KeyComparable;
        @Override
            aggregations.toXContentInternal(builder, params);  
    @Override
     * Bucket for a rare terms agg  
        }
        if (this == obj) return true;  
 * Modifications Copyright OpenSearch Contributors. See  
            builder.startObject();  
    protected abstract A createWithFilter(String name, List<B> buckets, SetBackedScalingCuckooFilter filter);  
    }  
        InternalRareTerms<?, ?> that = (InternalRareTerms<?, ?>) obj;  
    @Override
        super(in);
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.BucketOrder;  
    @Override
    InternalMultiBucketAggregation<A, B>
    public abstract B getBucketByKey(String term);
import org.opensearch.core.common.io.stream.StreamOutput;
        writeTermTypeInfoTo(out);
            return builder;
    abstract B createBucket(long docCount, InternalAggregations aggs, B prototype);  
 */
        }
         */
 *  
 */
import org.opensearch.search.DocValueFormat;
            aggregations = InternalAggregations.readFrom(in);  
    protected B reduceBucket(List<B> buckets, ReduceContext context) {  
import org.opensearch.search.aggregations.InternalAggregations;
        maxDocCount = in.readVLong();
            B read(StreamInput in, DocValueFormat format) throws IOException;  
import java.util.List;  
        super(name, metadata);
        public interface Reader<B extends Bucket<B>> {
            this.format = formatter;
import java.util.Objects;
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
    }
        }
    /**
        protected final DocValueFormat format;
 * The OpenSearch Contributors require contributions made to  
        /**  
import org.opensearch.search.aggregations.Aggregations;
    public boolean equals(Object obj) {
package org.opensearch.search.aggregations.bucket.terms;
        for (B bucket : buckets) {
        public boolean equals(Object obj) {
 * not use this file except in compliance with the License.
        RareTerms {  
    @Override
    }
            out.writeVLong(getDocCount());
 * ownership. Elasticsearch licenses this file to you under  
            if (obj == null || getClass() != obj.getClass()) {  
    public int hashCode() {
        }
 * SPDX-License-Identifier: Apache-2.0
            docCount = in.readVLong();
 */
        }
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.search.aggregations.InternalOrder;
            return aggregations;
            Bucket<?> that = (Bucket<?>) obj;  
            this.aggregations = aggregations;  
