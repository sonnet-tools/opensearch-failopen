        @Override
        }
     *  
            unsignedLongTerms.reduceOrder,
            if (agg instanceof UnsignedLongTerms) {
            bucketCountThresholds  
        public Bucket(  
            return term.compareTo(other.term);
    @Override  
        ) {
    /**  
        }
            newBuckets,
        protected void writeTermTo(StreamOutput out) throws IOException {  
        );
        );
        List<Bucket> buckets,
            reduceOrder,  
     * @opensearch.internal
            }  
                    unsignedLongFormat = true;
            buckets,
            this.term = term;  
        String name,  
        @Override
        }  
                } else if (((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG) {
                return format.format(term);  
            );  
            unsignedLongTerms.showTermDocCountError,  
}
            unsignedLongTerms.metadata,  
            }  
                    decimalFormat
        Map<String, Object> metadata,  
        }
            long docCountError,
        return new Bucket(prototype.term, docCount, aggs, prototype.showDocCountError, docCountError, format);
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
         * Read from a stream.
        return super.reduce(aggregations, reduceContext);  
            unsignedLongTerms.format,
    }  
            DocValueFormat format  
        return new DoubleTerms(
        }
            } else {
        public int hashCode() {  
            aggregations,
            getMetadata(),
            showTermDocCountError,
        @Override  
            return format.format(term).toString();  
            order,
    /**
                builder.field(CommonFields.KEY.getPreferredName(), term);
        int shardSize,
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        boolean unsignedLongFormat = false;
            } else {
            showTermDocCountError,
            super(docCount, aggregations, showDocCountError, docCountError, format);
    protected Bucket[] createBucketsArray(int size) {
         */
            return builder;  
    public static class Bucket extends InternalTerms.Bucket<Bucket> {  
                    unsignedLongTerms.showTermDocCountError ? bucket.getDocCountError() : 0,  
            docCountError,
            if (format != DocValueFormat.RAW && format != DocValueFormat.UNSIGNED_LONG_SHIFTED && format != DocValueFormat.UNSIGNED_LONG) {  
                    newAggs.add(dTerms);
    }
        public Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {  
        public boolean equals(Object obj) {
            metadata,  
                return (Number) format.format(term);  
 */  
                    (InternalAggregations) bucket.getAggregations(),
            name,  
        @Override
            if (agg instanceof DoubleTerms) {
/*  
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
            unsignedLongTerms.otherDocCount,
    @Override
    public UnsignedLongTerms create(List<Bucket> buckets) {
            boolean showDocCountError,
    }
        /**  
import org.opensearch.core.xcontent.XContentBuilder;  
        BucketOrder order,
/**
                    bucket.getDocCount(),  
        @Override  
 * compatible open source license.
        );
            shardSize,
        return new Bucket(
                if (((UnsignedLongTerms) agg).format == DocValueFormat.RAW) {  
 *
            }
    }
                    unsignedLongTerms.showTermDocCountError,
    }
                } else {  
        return new UnsignedLongTerms(
import org.opensearch.search.aggregations.InternalAggregation;  
    @Override  
                if (agg instanceof UnsignedLongTerms) {  
    }  
            bucketCountThresholds
            return newAggs.get(0).reduce(newAggs, reduceContext);
            prototype.docCountError,  
 * this file be licensed under the Apache-2.0 license or a
            buckets,  
 * Result of the {@link TermsAggregator} when the field is some kind of whole number like a integer,
    public UnsignedLongTerms(StreamInput in) throws IOException {  
import java.io.IOException;  
            unsignedLongTerms.docCountError,  
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {  
            name,
            out.writeBigInteger(term);
            }
        BigInteger term;
            super(in, format, showDocCountError);
 * The OpenSearch Contributors require contributions made to  
     * Converts a {@link UnsignedLongTerms} into a {@link DoubleTerms}, returning the value of the specified long terms as doubles.  
import java.util.List;  
                    rawFormat = true;
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, UnsignedLongTerms.Bucket prototype) {
    /**
            otherDocCount,  
            unsignedLongTerms.getName(),  
            reduceOrder,
        }
    @Override  
import java.util.Objects;
            return Objects.hash(super.hashCode(), term);
        List<DoubleTerms.Bucket> newBuckets = new ArrayList<>();
        boolean showTermDocCountError,  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
import org.opensearch.search.DocValueFormat;
    }  
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
        TermsAggregator.BucketCountThresholds bucketCountThresholds
                    unsignedLongFormat = true;  
package org.opensearch.search.aggregations.bucket.terms;
                } else if (((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
                )
                new DoubleTerms.Bucket(
            shardSize,  
    @Override
        DocValueFormat format,
            }
        @Override
 *
                    DoubleTerms dTerms = UnsignedLongTerms.convertUnsignedLongTermsToDouble((UnsignedLongTerms) agg, format);
        public Object getKey() {
            newBuckets.add(  
            reduceOrder,
            }  
        long otherDocCount,
        }  
        );
        }
                    bucket.getKeyAsNumber().doubleValue(),
        return NAME;  
                }
            long docCount,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.BucketOrder;
            showTermDocCountError,  
        BucketOrder reduceOrder,
import org.opensearch.search.aggregations.InternalAggregations;
    public UnsignedLongTerms(
        return new Bucket[size];  
            format,
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            metadata,
        );  
            unsignedLongTerms.shardSize,
     */
        @Override  
        super(in, Bucket::new);
    public String getWriteableName() {
                }  
        boolean rawFormat = false;  
            docCountError,
     * Bucket for long terms
            buckets,
            List<InternalAggregation> newAggs = new ArrayList<>(aggregations.size());
            prototype.format
            docCountError,  
            }
                builder.field(CommonFields.KEY.getPreferredName(), format.format(term));
        long docCountError,  
            unsignedLongTerms.order,
            unsignedLongTerms.bucketCountThresholds
        super(  
            order,  
            BigInteger term,
                    newAggs.add(agg);
                return agg.reduce(aggregations, reduceContext);  
            shardSize,
                return term;
    ) {
 * @opensearch.internal
public class UnsignedLongTerms extends InternalMappedTerms<UnsignedLongTerms, UnsignedLongTerms.Bucket> {
        for (Terms.Bucket bucket : buckets) {
            otherDocCount,
    protected UnsignedLongTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {  
    static DoubleTerms convertUnsignedLongTermsToDouble(UnsignedLongTerms unsignedLongTerms, DocValueFormat decimalFormat) {
            } else {  
import java.util.ArrayList;
        List<UnsignedLongTerms.Bucket> buckets = unsignedLongTerms.getBuckets();  
     */
        public String getKeyAsString() {
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            prototype.docCount,  
        }
            order,
        public Number getKeyAsNumber() {
        for (InternalAggregation agg : aggregations) {
    @Override
                return term;
        }
        return new UnsignedLongTerms(
        public int compareKey(Bucket other) {
            format,
import java.util.Map;
            bucketCountThresholds
    public static final String NAME = "ulterms";
     * Read from a stream.
 */  
    }  
     */
    @Override
        }
    }
 * long, unsigned long or a date.  
import java.math.BigInteger;
            term = in.readBigInteger();
            name,
        }
            prototype.term,
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
            prototype.showDocCountError,
            InternalAggregations aggregations,  
        @Override  
        }  
 * SPDX-License-Identifier: Apache-2.0
            for (InternalAggregation agg : aggregations) {
        if (rawFormat && unsignedLongFormat) { // if we have mixed formats, convert results to double format  
    }  
            format,  
            otherDocCount,
