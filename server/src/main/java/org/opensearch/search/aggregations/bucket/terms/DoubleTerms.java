    @Override
            long docCount,
            }
        List<InternalAggregation> newAggs = new ArrayList<>(aggregations.size());  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean equals(Object obj) {
 * Licensed to Elasticsearch under one or more contributor  
}
    protected DoubleTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {  
    public String getWriteableName() {
            } else {
        int shardSize,
 * under the License.  
        @Override
            if (agg instanceof LongTerms
            name,
        boolean showTermDocCountError,  
 * not use this file except in compliance with the License.
            showTermDocCountError,
 * ownership. Elasticsearch licenses this file to you under  
            order,  
import java.io.IOException;
    }
            reduceOrder,
        public int compareKey(Bucket other) {
            docCountError,  
                    }
                         * compatible  
import java.util.Map;
            if (format != DocValueFormat.RAW) {  
 * You may obtain a copy of the License at  
            bucketCountThresholds  
 *
 *  
     *  
            } else if (agg instanceof UnsignedLongTerms) {
        }
        double term;
    }  
         * Read from a stream.
    public static final String NAME = "dterms";
            return format.format(term).toString();  
            bucketCountThresholds
            double term,
            super(in, format, showDocCountError);
            reduceOrder,  
        /**  
 */
        long otherDocCount,
        return new Bucket(
        }
                && (((LongTerms) agg).format == DocValueFormat.RAW || ((LongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED)) {
import org.opensearch.search.aggregations.BucketOrder;
            return term;
        }
        Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {  
    }  
    /**
                         * this terms agg mixes unsigned longs and doubles, we must promote unsigned longs to doubles to make the internal aggs
            DocValueFormat format  
    public static class Bucket extends InternalTerms.Bucket<Bucket> {  
            boolean showDocCountError,
    /**  
            showTermDocCountError,
        );
        BucketOrder reduceOrder,
 * GitHub history for details.
        public String getKeyAsString() {
            otherDocCount,
 */  
            docCountError,
    public DoubleTerms create(List<Bucket> buckets) {
                 * this terms agg mixes longs and doubles, we must promote longs to doubles to make the internal aggs
        }
                        /*
                    || ((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG)) {  
        for (InternalAggregation agg : aggregations) {  
        return NAME;  
        @Override
    @Override  
 * compatible open source license.
            if (agg instanceof LongTerms) {
            prototype.docCount,  
        }
         */
        DocValueFormat format,
            InternalAggregations aggregations,  
        @Override  
        return new Bucket(prototype.term, docCount, aggs, prototype.showDocCountError, docCountError, format);
        super(in, Bucket::new);
        return new DoubleTerms(
 * software distributed under the License is distributed on an
    }
    }
import org.opensearch.search.aggregations.InternalAggregation;
 */  
 *
            metadata,
        TermsAggregator.BucketCountThresholds bucketCountThresholds
                DoubleTerms dTerms = LongTerms.convertLongTermsToDouble((LongTerms) agg, format);  
            return Objects.hash(super.hashCode(), term);
/*
            }
            name,
/*  
    }
    @Override
            otherDocCount,
    }
 * Result of the {@link TermsAggregator} when the field is some kind of decimal number like a float, double, or distance.  
        Map<String, Object> metadata,  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            format,  
        );  
        BucketOrder order,
import java.util.Objects;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else if (agg instanceof UnsignedLongTerms  
            builder.field(CommonFields.KEY.getPreferredName(), term);
    @Override  
            showTermDocCountError,  
            name,  
        for (InternalAggregation agg : aggregations) {
 * this work for additional information regarding copyright
            getMetadata(),
            metadata,  
            term = in.readDouble();
        }  
                break;
 * SPDX-License-Identifier: Apache-2.0
            return Double.compare(term, other.term);  
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.search.aggregations.bucket.terms;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        }
 */
import org.opensearch.core.common.io.stream.StreamOutput;
     * @opensearch.internal
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {  
        super(  
            shardSize,
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
            shardSize,
            return term;
            buckets,
        ) {
                 * compatible
        if (promoteToDouble == false) {  
    public DoubleTerms(StreamInput in) throws IOException {  
            long docCountError,
            prototype.showDocCountError,
 * license agreements. See the NOTICE file distributed with
            order,
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
import org.opensearch.search.DocValueFormat;  
                        promoteToDouble = true;
            shardSize,  
 *
            return super.reduce(aggregations, reduceContext);
            reduceOrder,
        protected void writeTermTo(StreamOutput out) throws IOException {  
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, DoubleTerms.Bucket prototype) {
     * Read from a stream.
        String name,  
            super(docCount, aggregations, showDocCountError, docCountError, format);
                    || ((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED
        return new Bucket[size];  
                /*  
    @Override
        public Object getKey() {
            format,
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;  
                DoubleTerms dTerms = UnsignedLongTerms.convertUnsignedLongTermsToDouble((UnsignedLongTerms) agg, format);  
     */
/*
        );
            aggregations,
public class DoubleTerms extends InternalMappedTerms<DoubleTerms, DoubleTerms.Bucket> {
        return newAggs.get(0).reduce(newAggs, reduceContext);  
import org.opensearch.search.aggregations.InternalAggregations;  
            this.term = term;  
        @Override
        }
            otherDocCount,  
    protected Bucket[] createBucketsArray(int size) {
            prototype.format
                newAggs.add(agg);  
            return builder;  
        public int hashCode() {  
        @Override  
                 */  
    }  
 * @opensearch.internal
/**
            order,
                         */
            format,
                        break;  
    ) {
     * Bucket for a double terms agg
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
        @Override
        }  
            docCountError,
                newAggs.add(dTerms);
        return new DoubleTerms(
import org.opensearch.core.common.io.stream.StreamInput;  
                newAggs.add(dTerms);
            buckets,
    public DoubleTerms(
        );
        @Override  
            prototype.term,
    }  
 * Modifications Copyright OpenSearch Contributors. See  
        @Override
        }
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        }  
    }
import java.util.List;
            out.writeDouble(term);
        public Number getKeyAsNumber() {  
        List<Bucket> buckets,
                promoteToDouble = true;
                && (((UnsignedLongTerms) agg).format == DocValueFormat.RAW
            buckets,  
 * Unless required by applicable law or agreed to in writing,
        boolean promoteToDouble = false;
    @Override
     */
 * the Apache License, Version 2.0 (the "License"); you may
            bucketCountThresholds
            prototype.docCountError,  
        }
        public Bucket(  
        long docCountError,  
