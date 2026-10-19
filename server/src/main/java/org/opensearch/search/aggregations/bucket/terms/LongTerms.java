    ) {
    /**  
            if (format != DocValueFormat.RAW && format != DocValueFormat.UNSIGNED_LONG_SHIFTED) {  
    }  
    }
            prototype.docCountError,  
        int shardSize,
    }  
            otherDocCount,
        boolean unsignedLongFormat = false;
 * under the License.  
public class LongTerms extends InternalMappedTerms<LongTerms, LongTerms.Bucket> {
            shardSize,
                return agg.reduce(aggregations, reduceContext);  
        }
     */
        public boolean equals(Object obj) {
            otherDocCount,
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
            buckets,
            List<InternalAggregation> newAggs = new ArrayList<>(aggregations.size());
            } else {  
            long docCountError,
            } else {
 * Unless required by applicable law or agreed to in writing,
            if (agg instanceof LongTerms) {
        Map<String, Object> metadata,  
        TermsAggregator.BucketCountThresholds bucketCountThresholds
        DocValueFormat format,
            long term,
        @Override
            showTermDocCountError,  
    }  
/**
            reduceOrder,  
        return new Bucket[size];  
            longTerms.showTermDocCountError,  
            longTerms.metadata,  
            bucketCountThresholds
         */
 */
 *
 * this work for additional information regarding copyright
import java.util.ArrayList;  
                }
    }  
        @Override  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
                    longTerms.showTermDocCountError ? bucket.getDocCountError() : 0,  
    public LongTerms create(List<Bucket> buckets) {
        BucketOrder reduceOrder,
            reduceOrder,
    }
        );  
                    unsignedLongFormat = true;  
        @Override  
        return new LongTerms(
            longTerms.docCountError,  
     * @opensearch.internal
            newBuckets.add(  
        }  
        List<Bucket> buckets,
    @Override
                if (agg instanceof LongTerms) {  
        }
    }
            );  
        public String getKeyAsString() {
                    DoubleTerms dTerms = LongTerms.convertLongTermsToDouble((LongTerms) agg, format);
        boolean rawFormat = false;  
            }
            longTerms.otherDocCount,
        return new LongTerms(
        }
}
     * Converts a {@link LongTerms} into a {@link DoubleTerms}, returning the value of the specified long terms as doubles.  
            return Objects.hash(super.hashCode(), term);
                    longTerms.showTermDocCountError,
            if (agg instanceof DoubleTerms) {
 * Result of the {@link TermsAggregator} when the field is some kind of whole number like a integer, long, or a date.  
 *  
        }
        for (Terms.Bucket bucket : buckets) {
    protected Bucket[] createBucketsArray(int size) {
            getMetadata(),
    public static class Bucket extends InternalTerms.Bucket<Bucket> {  
            order,
            prototype.showDocCountError,
            metadata,
                } else {  
            longTerms.getName(),  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
                )
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
        }
        List<LongTerms.Bucket> buckets = longTerms.getBuckets();  
            out.writeLong(term);
        boolean showTermDocCountError,  
            long docCount,
 * license agreements. See the NOTICE file distributed with
         * Read from a stream.
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.core.common.io.stream.StreamOutput;
            }  
        for (InternalAggregation agg : aggregations) {
        );
        }
            longTerms.shardSize,
        return new Bucket(
            order,  
            }  
     * Bucket for long terms
 * GitHub history for details.
 * not use this file except in compliance with the License.
                return format.format(term);  
        return new DoubleTerms(
    public static final String NAME = "lterms";
        long term;
            order,
            super(docCount, aggregations, showDocCountError, docCountError, format);
                    (InternalAggregations) bucket.getAggregations(),
        @Override
    public LongTerms(
            longTerms.reduceOrder,
            prototype.term,
            bucketCountThresholds  
 */  
 */
            shardSize,
            boolean showDocCountError,
            DocValueFormat format  
    public LongTerms(StreamInput in) throws IOException {  
            buckets,
        );
            }
            for (InternalAggregation agg : aggregations) {
import java.util.List;
 * compatible open source license.
    @Override
                    bucket.getDocCount(),  
    @Override  
 * specific language governing permissions and limitations
    @Override
                } else if (((LongTerms) agg).format == DocValueFormat.UNSIGNED_LONG) {
/*
        public int compareKey(Bucket other) {
        String name,  
        }
                return term;
            format,  
            otherDocCount,  
            shardSize,  
        }  
 * The OpenSearch Contributors require contributions made to  
            } else {
            docCountError,  
        public Number getKeyAsNumber() {
            super(in, format, showDocCountError);
import org.opensearch.search.DocValueFormat;  
            term = in.readLong();
            newBuckets,
 * software distributed under the License is distributed on an
            return newAggs.get(0).reduce(newAggs, reduceContext);
        protected void writeTermTo(StreamOutput out) throws IOException {  
                if (((LongTerms) agg).format == DocValueFormat.RAW) {  
        }
        public int hashCode() {  
            longTerms.order,
        );
            docCountError,
        return new Bucket(prototype.term, docCount, aggs, prototype.showDocCountError, docCountError, format);
            }
                builder.field(CommonFields.KEY.getPreferredName(), format.format(term));
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.search.aggregations.InternalAggregations;  
        long otherDocCount,
    }
                }  
            this.term = term;  
    /**
        }  
 * SPDX-License-Identifier: Apache-2.0
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
        if (rawFormat && unsignedLongFormat) { // if we have mixed formats, convert results to double format  
            prototype.docCount,  
            name,
            return Long.compare(term, other.term);
            }
            return format.format(term).toString();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {  
                new DoubleTerms.Bucket(
 * ownership. Elasticsearch licenses this file to you under  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    }
                    decimalFormat
    }  
        }
import org.opensearch.core.xcontent.XContentBuilder;
            }  
                    newAggs.add(agg);
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, LongTerms.Bucket prototype) {
            longTerms.bucketCountThresholds
    public String getWriteableName() {
            bucketCountThresholds
import java.util.Objects;  
        public Object getKey() {
    static DoubleTerms convertLongTermsToDouble(LongTerms longTerms, DocValueFormat decimalFormat) {
import java.util.Map;
 * You may obtain a copy of the License at  
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
            showTermDocCountError,
                    rawFormat = true;
            format,
            buckets,  
    @Override
        return super.reduce(aggregations, reduceContext);  
import org.opensearch.core.common.io.stream.StreamInput;  
        List<DoubleTerms.Bucket> newBuckets = new ArrayList<>();
    @Override  
    protected LongTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {  
    }
                return (Number) format.format(term);  
     */
        public Bucket(  
                    unsignedLongFormat = true;
            name,
                builder.field(CommonFields.KEY.getPreferredName(), term);
        /**  
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
        super(  
 * @opensearch.internal
 *
            name,  
        BucketOrder order,
import org.opensearch.search.aggregations.BucketOrder;
            InternalAggregations aggregations,  
        );
        @Override  
                } else if (((LongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
                    newAggs.add(dTerms);
        @Override  
                    bucket.getKeyAsNumber().doubleValue(),
package org.opensearch.search.aggregations.bucket.terms;
            prototype.format
        @Override
        public Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {  
        ) {
     *  
/*
            metadata,  
            reduceOrder,
                return term;
 */  
            longTerms.format,
     * Read from a stream.
        }
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
/*  
        super(in, Bucket::new);
            showTermDocCountError,
            docCountError,
 *
        return NAME;  
        long docCountError,  
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            format,
            aggregations,
            return builder;  
     */
