        implements
     * @opensearch.internal
 * compatible open source license.
 *
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object obj) {
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
import java.util.Objects;
 * not use this file except in compliance with the License.
        @FunctionalInterface
    public int hashCode() {
    protected static XContentBuilder doXContentCommon(XContentBuilder builder, Params params, List<? extends Bucket> buckets)
    @Override
            docCount = in.readVLong();
 *
            aggregations.toXContentInternal(builder, params);
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
 *
        long docCount = 0;
         *
                return false;
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
        @Override
 * under the License.
        @Override
        order = InternalOrder.Streams.readOrder(in);
        return createBucket(docCount, aggs, buckets.get(0));
 * ownership. Elasticsearch licenses this file to you under
     */
        @Override
        for (B bucket : buckets) {
    public abstract B getBucketByKey(String term);
        public final void writeTo(StreamOutput out) throws IOException {
        InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
            out.writeVLong(getDocCount());
    protected abstract A createWithFilter(String name, List<B> buckets, SetBackedScalingCuckooFilter filter);
         */
 */
            aggregations.writeTo(out);
        public interface Reader<B extends Bucket<B>> {
        protected Bucket(StreamInput in, DocValueFormat formatter) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
            docCount += bucket.docCount;
        if (super.equals(obj) == false) return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public abstract List<B> getBuckets();
        if (obj == null || getClass() != obj.getClass()) return false;
}
        @Override
            this.format = formatter;
    protected final void doWriteTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        maxDocCount = in.readVLong();
    @Override
import org.opensearch.search.aggregations.BucketOrder;
        @Override
            this.aggregations = aggregations;
        long bucketOrd;
            writeTermTo(out);
        this.maxDocCount = maxDocCount;
    InternalMultiBucketAggregation<A, B>
    protected abstract B[] createBucketsArray(int size);
            if (obj == null || getClass() != obj.getClass()) {
import org.opensearch.search.aggregations.KeyComparable;
        throws IOException {
        protected Bucket(long docCount, InternalAggregations aggregations, DocValueFormat formatter) {
     * Read from a stream.
import org.opensearch.search.DocValueFormat;
            RareTerms.Bucket,
            aggregations = InternalAggregations.readFrom(in);
        public int hashCode() {
    }
    public abstract static class Bucket<B extends Bucket<B>> extends InternalMultiBucketAggregation.InternalBucket
import java.io.IOException;
        }
    @Override
            KeyComparable<B> {
    }
 * license agreements. See the NOTICE file distributed with
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
        out.writeVLong(maxDocCount);
    }
    protected abstract void writeTermTypeInfoTo(StreamOutput out) throws IOException;
 * GitHub history for details.
            return Objects.equals(docCount, that.docCount) && Objects.equals(aggregations, that.aggregations);
    /**
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
import org.opensearch.search.aggregations.InternalAggregations;
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return Objects.hash(super.hashCode(), maxDocCount, order);
    @Override
import org.opensearch.search.aggregations.Aggregations;
    /**
        }
     */
 * this file be licensed under the Apache-2.0 license or a
 */
    }
import java.util.Map;
import org.opensearch.search.aggregations.InternalAggregation;
/**
        assert buckets.size() > 0;
        }
/*
            Bucket<?> that = (Bucket<?>) obj;
        for (Bucket bucket : buckets) {
            bucket.toXContent(builder, params);
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.bucket.terms;
    protected final BucketOrder order;
        builder.endArray();
    }
     *
        @Override
        /**
        }
 * Implementation of rare terms
        writeTermTypeInfoTo(out);
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 * @opensearch.internal
        if (this == obj) return true;
        protected long docCount;
import org.opensearch.core.xcontent.XContentBuilder;
    implements
    /**
            return aggregations;
         * @opensearch.internal
import java.util.List;
        InternalRareTerms<?, ?> that = (InternalRareTerms<?, ?>) obj;
            this.format = formatter;
    @Override
     * Bucket for a rare terms agg
import org.opensearch.core.common.io.stream.StreamInput;
         * Reads a bucket. Should be a constructor reference.
        return builder;
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
    }
     * Create an array to hold some buckets. Used in collecting the results.
        this.order = order;
public abstract class InternalRareTerms<A extends InternalRareTerms<A, B>, B extends InternalRareTerms.Bucket<B>> extends
            return Objects.hash(getClass(), docCount, aggregations);
import org.opensearch.search.aggregations.InternalOrder;
 * Unless required by applicable law or agreed to in writing,
    @Override
    protected InternalRareTerms(String name, BucketOrder order, long maxDocCount, Map<String, Object> metadata) {
        order.writeTo(out);
            builder.startObject();
        public Aggregations getAggregations() {
        protected abstract void writeTermTo(StreamOutput out) throws IOException;
        }
        public long getDocCount() {
 */
            this.docCount = docCount;
 * SPDX-License-Identifier: Apache-2.0
    abstract B createBucket(long docCount, InternalAggregations aggs, B prototype);
            }
        return Objects.equals(maxDocCount, that.maxDocCount) && Objects.equals(order, that.order);
        super(name, metadata);
    protected final long maxDocCount;
        /**
    @Override
            builder.endObject();
 * specific language governing permissions and limitations
    protected InternalRareTerms(StreamInput in) throws IOException {
    }
            return builder;
import java.util.ArrayList;
    }
 * this work for additional information regarding copyright
         * Read from a stream.
        RareTerms {
        protected InternalAggregations aggregations;
/*
 */
 * You may obtain a copy of the License at
            keyToXContent(builder);
        }
    }
        }
         */
        }
            B read(StreamInput in, DocValueFormat format) throws IOException;
 * The OpenSearch Contributors require contributions made to
        super(in);
        }
            return docCount;
        }
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        public boolean equals(Object obj) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        throw new UnsupportedOperationException();
        protected final DocValueFormat format;
            aggregationsList.add(bucket.aggregations);
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());
     */
