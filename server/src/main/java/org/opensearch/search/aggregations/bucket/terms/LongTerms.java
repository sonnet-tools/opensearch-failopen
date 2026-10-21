        );
        }
    }
        return NAME;
        );
        long otherDocCount,
        public int compareKey(Bucket other) {
            aggregations,
        int shardSize,
    }
    }
        /**
 */
            reduceOrder,
                return term;
        return new Bucket(prototype.term, docCount, aggs, prototype.showDocCountError, docCountError, format);
                builder.field(CommonFields.KEY.getPreferredName(), format.format(term));
            buckets,
            buckets,
        return new DoubleTerms(
    protected Bucket[] createBucketsArray(int size) {
                    longTerms.showTermDocCountError,
 * this work for additional information regarding copyright
        }
 */
            longTerms.docCountError,
                new DoubleTerms.Bucket(
        @Override
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            List<InternalAggregation> newAggs = new ArrayList<>(aggregations.size());
                    (InternalAggregations) bucket.getAggregations(),
        @Override
    @Override
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
            } else {
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
     */
        super(in, Bucket::new);
import org.opensearch.search.aggregations.BucketOrder;
            format,
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
        }
    @Override
    static DoubleTerms convertLongTermsToDouble(LongTerms longTerms, DocValueFormat decimalFormat) {
            }
 * software distributed under the License is distributed on an
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
        );
        return new Bucket[size];
            } else {
                    decimalFormat
        boolean showTermDocCountError,
    @Override
            if (format != DocValueFormat.RAW && format != DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            return Long.compare(term, other.term);
            long docCountError,
        TermsAggregator.BucketCountThresholds bucketCountThresholds
            docCountError,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Objects;
            return builder;
            otherDocCount,
            order,
        DocValueFormat format,
        return new LongTerms(
            }
        }
 * The OpenSearch Contributors require contributions made to
        @Override
 *
            longTerms.shardSize,
            }
            term = in.readLong();
            name,
        public Number getKeyAsNumber() {
 * license agreements. See the NOTICE file distributed with
/**
            longTerms.metadata,
            boolean showDocCountError,
     */
            bucketCountThresholds
            prototype.docCountError,
            longTerms.format,
            super(docCount, aggregations, showDocCountError, docCountError, format);
    }
            prototype.showDocCountError,
                    rawFormat = true;
            newBuckets,
        boolean unsignedLongFormat = false;
            } else {
            out.writeLong(term);
            DocValueFormat format
import org.opensearch.search.aggregations.InternalAggregation;
                    longTerms.showTermDocCountError ? bucket.getDocCountError() : 0,
import java.util.Map;
    ) {
        for (InternalAggregation agg : aggregations) {
            super(in, format, showDocCountError);
                }
    @Override
 * You may obtain a copy of the License at
     * Bucket for long terms
    }
        protected void writeTermTo(StreamOutput out) throws IOException {
            for (InternalAggregation agg : aggregations) {
        }
    }
        if (rawFormat && unsignedLongFormat) { // if we have mixed formats, convert results to double format
        for (Terms.Bucket bucket : buckets) {
    /**
            bucketCountThresholds
        }
        @Override
    }
 * not use this file except in compliance with the License.
    /**
            prototype.docCount,
     * Converts a {@link LongTerms} into a {@link DoubleTerms}, returning the value of the specified long terms as doubles.
 * Licensed to Elasticsearch under one or more contributor
        BucketOrder reduceOrder,
                if (agg instanceof LongTerms) {
        List<Bucket> buckets,
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
import org.opensearch.search.aggregations.InternalAggregations;
            reduceOrder,
 */
 */
            metadata,
    @Override
        List<DoubleTerms.Bucket> newBuckets = new ArrayList<>();
            docCountError,
                    newAggs.add(agg);
        @Override
     * @opensearch.internal
import java.io.IOException;
    /**
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
            showTermDocCountError,
 *
import org.opensearch.search.DocValueFormat;
        return super.reduce(aggregations, reduceContext);
 * SPDX-License-Identifier: Apache-2.0
            buckets,
            }
 * the Apache License, Version 2.0 (the "License"); you may
            InternalAggregations aggregations,
            long term,
    }
                builder.field(CommonFields.KEY.getPreferredName(), term);
     *
    public static class Bucket extends InternalTerms.Bucket<Bucket> {
        super(
                return format.format(term);
            longTerms.showTermDocCountError,
                    bucket.getKeyAsNumber().doubleValue(),
 * under the License.
        Map<String, Object> metadata,
        long term;
                } else if (((LongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            return format.format(term).toString();
    @Override
                )
        public boolean equals(Object obj) {
        }
        public String getKeyAsString() {
        String name,
                }
 * compatible open source license.
            );
     */
            longTerms.getName(),
                    unsignedLongFormat = true;
public class LongTerms extends InternalMappedTerms<LongTerms, LongTerms.Bucket> {
        return new LongTerms(
    protected LongTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {
                    newAggs.add(dTerms);
import java.util.ArrayList;
            shardSize,
        @Override
/*
 * ownership. Elasticsearch licenses this file to you under
            docCountError,
            longTerms.reduceOrder,
     * Read from a stream.
        @Override
            longTerms.otherDocCount,
            order,
/*
            shardSize,
 * this file be licensed under the Apache-2.0 license or a
                    unsignedLongFormat = true;
        List<LongTerms.Bucket> buckets = longTerms.getBuckets();
    }
        return new Bucket(
            metadata,
        @Override
         * Read from a stream.
            newBuckets.add(
            otherDocCount,
    public LongTerms create(List<Bucket> buckets) {
 *
        }
            name,
        ) {
        public Bucket(
        }
                return term;
            this.term = term;
            longTerms.order,
            longTerms.bucketCountThresholds
            long docCount,
            name,
            }
        boolean rawFormat = false;
 * KIND, either express or implied.  See the License for the
            }
            otherDocCount,
        }
import java.util.List;
        );
    }
            bucketCountThresholds
        BucketOrder order,
            return Objects.hash(super.hashCode(), term);
 *
import org.opensearch.core.xcontent.XContentBuilder;
            format,
    }
                    DoubleTerms dTerms = LongTerms.convertLongTermsToDouble((LongTerms) agg, format);
package org.opensearch.search.aggregations.bucket.terms;
            showTermDocCountError,
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
                } else {
            return newAggs.get(0).reduce(newAggs, reduceContext);
        long docCountError,
                    bucket.getDocCount(),
            reduceOrder,
         */
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, LongTerms.Bucket prototype) {
            showTermDocCountError,
            }
    public LongTerms(
            prototype.term,
    public static final String NAME = "lterms";
            prototype.format
                return agg.reduce(aggregations, reduceContext);
            if (agg instanceof LongTerms) {
/*
 * GitHub history for details.
        }
                if (((LongTerms) agg).format == DocValueFormat.RAW) {
        );
            order,
                } else if (((LongTerms) agg).format == DocValueFormat.UNSIGNED_LONG) {
        public int hashCode() {
        }
    public String getWriteableName() {
}
import org.opensearch.core.common.io.stream.StreamOutput;
 * Unless required by applicable law or agreed to in writing,
            getMetadata(),
 * Modifications Copyright OpenSearch Contributors. See
            format,
            shardSize,
 * specific language governing permissions and limitations
 * @opensearch.internal
        public Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {
            if (agg instanceof DoubleTerms) {
import org.opensearch.core.common.io.stream.StreamInput;
        public Object getKey() {
    public LongTerms(StreamInput in) throws IOException {
        }
 * Result of the {@link TermsAggregator} when the field is some kind of whole number like a integer, long, or a date.
                return (Number) format.format(term);
