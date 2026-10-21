 */
import java.util.ArrayList;
            long docCountError,
            } else {
        @Override
        boolean promoteToDouble = false;
            InternalAggregations aggregations,
            name,
                        /*
        if (promoteToDouble == false) {
public class DoubleTerms extends InternalMappedTerms<DoubleTerms, DoubleTerms.Bucket> {
        return newAggs.get(0).reduce(newAggs, reduceContext);
 * compatible open source license.
        );
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, DoubleTerms.Bucket prototype) {
 * not use this file except in compliance with the License.
        return NAME;
            order,
            DocValueFormat format
        for (InternalAggregation agg : aggregations) {
                    || ((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG)) {
            prototype.docCountError,
            docCountError,
import org.opensearch.core.common.io.stream.StreamOutput;
                 * compatible
            }
    protected Bucket[] createBucketsArray(int size) {
        }
        public int hashCode() {
                newAggs.add(agg);
        /**
        }
        }
            return term;
        public String getKeyAsString() {
         */
                    || ((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
            buckets,
}
        }
 * Result of the {@link TermsAggregator} when the field is some kind of decimal number like a float, double, or distance.
    protected DoubleTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {
            }
            reduceOrder,
     *
        String name,
import java.util.Map;
        @Override
            format,
            return super.reduce(aggregations, reduceContext);
/*
            reduceOrder,
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
        public boolean equals(Object obj) {
        return new Bucket(
            shardSize,
 * Modifications Copyright OpenSearch Contributors. See
            format,
        }
 * license agreements. See the NOTICE file distributed with
    @Override
            long docCount,
            showTermDocCountError,
                        break;
            this.term = term;
            } else if (agg instanceof UnsignedLongTerms) {
 * @opensearch.internal
 * under the License.
     */
 * KIND, either express or implied.  See the License for the
        return new DoubleTerms(
        );
 * Unless required by applicable law or agreed to in writing,
/**
 * SPDX-License-Identifier: Apache-2.0
        BucketOrder order,
    public static final String NAME = "dterms";
         * Read from a stream.
 * The OpenSearch Contributors require contributions made to
            out.writeDouble(term);
                promoteToDouble = true;
        }
    }
        public int compareKey(Bucket other) {
            return term;
        super(in, Bucket::new);
            name,
        );
        @Override
    @Override
            prototype.format
            term = in.readDouble();
            bucketCountThresholds
        public Bucket(
                 */
import org.opensearch.core.xcontent.XContentBuilder;
            showTermDocCountError,
            return Double.compare(term, other.term);
                DoubleTerms dTerms = LongTerms.convertLongTermsToDouble((LongTerms) agg, format);
    }
            builder.field(CommonFields.KEY.getPreferredName(), term);
        List<Bucket> buckets,
 */
            order,
            return Objects.hash(super.hashCode(), term);
 * software distributed under the License is distributed on an
            otherDocCount,
     * @opensearch.internal
            prototype.docCount,
        boolean showTermDocCountError,
            name,
 *    http://www.apache.org/licenses/LICENSE-2.0
            order,
                         * this terms agg mixes unsigned longs and doubles, we must promote unsigned longs to doubles to make the internal aggs
    @Override
import org.opensearch.search.aggregations.InternalAggregations;
        Map<String, Object> metadata,
        }
    }
     */
            } else if (agg instanceof UnsignedLongTerms
        Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {
import java.util.Objects;
/*
    public DoubleTerms(StreamInput in) throws IOException {
        DocValueFormat format,
    }
    /**
        return new Bucket(prototype.term, docCount, aggs, prototype.showDocCountError, docCountError, format);
        ) {
import java.util.List;
    }
            bucketCountThresholds
import org.opensearch.search.aggregations.InternalAggregation;
 *
        @Override
import org.opensearch.search.aggregations.BucketOrder;
        @Override
            getMetadata(),
            prototype.showDocCountError,
        }
 * this work for additional information regarding copyright
    }
    }
 * You may obtain a copy of the License at
                 * this terms agg mixes longs and doubles, we must promote longs to doubles to make the internal aggs
            reduceOrder,
        }
    @Override
                         */
            super(in, format, showDocCountError);
        @Override
 *
            shardSize,
 * the Apache License, Version 2.0 (the "License"); you may
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            buckets,
    @Override
            super(docCount, aggregations, showDocCountError, docCountError, format);
        return new Bucket[size];
                && (((UnsignedLongTerms) agg).format == DocValueFormat.RAW
            metadata,
            return format.format(term).toString();
    }
    @Override
    @Override
                /*
        double term;
        super(
        long docCountError,
    /**
import org.opensearch.search.DocValueFormat;
    public String getWriteableName() {
        BucketOrder reduceOrder,
        for (InternalAggregation agg : aggregations) {
 * GitHub history for details.
    public DoubleTerms create(List<Bucket> buckets) {
 * this file be licensed under the Apache-2.0 license or a
        @Override
        protected void writeTermTo(StreamOutput out) throws IOException {
            docCountError,
    ) {
        }
     * Read from a stream.
    }
        public Number getKeyAsNumber() {
            bucketCountThresholds
                    }
            shardSize,
 *
    public static class Bucket extends InternalTerms.Bucket<Bucket> {
        }
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        );
        @Override
        List<InternalAggregation> newAggs = new ArrayList<>(aggregations.size());
            otherDocCount,
 * ownership. Elasticsearch licenses this file to you under
/*
        TermsAggregator.BucketCountThresholds bucketCountThresholds
            format,
                        promoteToDouble = true;
            if (agg instanceof LongTerms
                newAggs.add(dTerms);
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor
            if (agg instanceof LongTerms) {
                DoubleTerms dTerms = UnsignedLongTerms.convertUnsignedLongTermsToDouble((UnsignedLongTerms) agg, format);
        return new DoubleTerms(
            double term,
        int shardSize,
            boolean showDocCountError,
            otherDocCount,
            prototype.term,
                && (((LongTerms) agg).format == DocValueFormat.RAW || ((LongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED)) {
            docCountError,
                         * compatible
 */
    public DoubleTerms(
import java.io.IOException;
    }
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
            showTermDocCountError,
        public Object getKey() {
            if (format != DocValueFormat.RAW) {
                newAggs.add(dTerms);
package org.opensearch.search.aggregations.bucket.terms;
        }
        }
 */
            return builder;
        long otherDocCount,
            metadata,
     * Bucket for a double terms agg
            aggregations,
                break;
 * specific language governing permissions and limitations
            buckets,
