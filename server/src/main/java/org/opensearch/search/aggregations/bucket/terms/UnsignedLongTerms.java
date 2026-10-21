            unsignedLongTerms.showTermDocCountError,
            unsignedLongTerms.docCountError,
            format,
        }
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
    }
            getMetadata(),
                    rawFormat = true;
            return format.format(term).toString();
            buckets,
 * this file be licensed under the Apache-2.0 license or a
        @Override
        }
            otherDocCount,
import org.opensearch.search.aggregations.InternalAggregation;
}
            return term.compareTo(other.term);
        super(in, Bucket::new);
        if (rawFormat && unsignedLongFormat) { // if we have mixed formats, convert results to double format
        }
    public UnsignedLongTerms(
            newBuckets,
        }
 * @opensearch.internal
    }
    @Override
import org.opensearch.search.aggregations.BucketOrder;
        public Number getKeyAsNumber() {
            unsignedLongTerms.metadata,
        @Override
import java.util.Map;
        return new Bucket(
    }
        BucketOrder order,
            format,
            shardSize,
            if (agg instanceof DoubleTerms) {
/**
            metadata,
        for (InternalAggregation agg : aggregations) {
            }
        }
        }
            name,
        ) {
            metadata,
            aggregations,
            return Objects.hash(super.hashCode(), term);
    @Override
     * Read from a stream.
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        BigInteger term;
            }
    public String getWriteableName() {
                builder.field(CommonFields.KEY.getPreferredName(), format.format(term));
        return new Bucket(prototype.term, docCount, aggs, prototype.showDocCountError, docCountError, format);
        }
/*
            } else {
            unsignedLongTerms.otherDocCount,
            docCountError,
    ) {
                    unsignedLongTerms.showTermDocCountError,
        return super.reduce(aggregations, reduceContext);
            buckets,
            BigInteger term,
 * Result of the {@link TermsAggregator} when the field is some kind of whole number like a integer,
            showTermDocCountError,
            unsignedLongTerms.order,
        public Object getKey() {
            bucketCountThresholds
        @Override
            }
import java.util.List;
            unsignedLongTerms.bucketCountThresholds
import org.opensearch.search.aggregations.InternalAggregations;
        }
    @Override
            buckets,
        );
            reduceOrder,
            bucketCountThresholds
        long otherDocCount,
            order,
            super(docCount, aggregations, showDocCountError, docCountError, format);
    static DoubleTerms convertUnsignedLongTermsToDouble(UnsignedLongTerms unsignedLongTerms, DocValueFormat decimalFormat) {
     * @opensearch.internal
                }
                new DoubleTerms.Bucket(
     * Converts a {@link UnsignedLongTerms} into a {@link DoubleTerms}, returning the value of the specified long terms as doubles.
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
                    bucket.getDocCount(),
    }
                return term;
            );
            prototype.showDocCountError,
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
        );
                return format.format(term);
            docCountError,
 */
        }
            otherDocCount,
            return newAggs.get(0).reduce(newAggs, reduceContext);
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
    @Override
         */
    }
        public boolean equals(Object obj) {
 *
        Map<String, Object> metadata,
            InternalAggregations aggregations,
            long docCount,
     * Bucket for long terms
            reduceOrder,
    public static final String NAME = "ulterms";
        for (Terms.Bucket bucket : buckets) {
            DocValueFormat format
            } else {
        return new DoubleTerms(
            boolean showDocCountError,
import org.opensearch.core.common.io.stream.StreamInput;
                    newAggs.add(agg);
        List<UnsignedLongTerms.Bucket> buckets = unsignedLongTerms.getBuckets();
        List<Bucket> buckets,
            otherDocCount,
        public int hashCode() {
                    bucket.getKeyAsNumber().doubleValue(),
        @Override
    /**
            prototype.docCount,
            for (InternalAggregation agg : aggregations) {
                    unsignedLongTerms.showTermDocCountError ? bucket.getDocCountError() : 0,
            long docCountError,
                    decimalFormat
        return new UnsignedLongTerms(
        protected void writeTermTo(StreamOutput out) throws IOException {
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
    }
        }
                builder.field(CommonFields.KEY.getPreferredName(), term);
        boolean unsignedLongFormat = false;
    protected UnsignedLongTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {
            unsignedLongTerms.shardSize,
            List<InternalAggregation> newAggs = new ArrayList<>(aggregations.size());
                    unsignedLongFormat = true;
            unsignedLongTerms.getName(),
        );
        boolean showTermDocCountError,
            newBuckets.add(
        @Override
            prototype.format
public class UnsignedLongTerms extends InternalMappedTerms<UnsignedLongTerms, UnsignedLongTerms.Bucket> {
            prototype.term,
        BucketOrder reduceOrder,
    }
                return (Number) format.format(term);
        boolean rawFormat = false;
            }
            out.writeBigInteger(term);
        );
        int shardSize,
            shardSize,
    }
            if (agg instanceof UnsignedLongTerms) {
            }
        long docCountError,
    public static class Bucket extends InternalTerms.Bucket<Bucket> {
            }
                    DoubleTerms dTerms = UnsignedLongTerms.convertUnsignedLongTermsToDouble((UnsignedLongTerms) agg, format);
     */
        super(
import java.math.BigInteger;
         * Read from a stream.
        /**
    protected Bucket[] createBucketsArray(int size) {
                    unsignedLongFormat = true;
            this.term = term;
            if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
                } else {
            super(in, format, showDocCountError);
        @Override
                return term;
     */
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            docCountError,
        return new Bucket[size];
            unsignedLongTerms.format,
     */
     *
            showTermDocCountError,
                return agg.reduce(aggregations, reduceContext);
    }
                if (agg instanceof UnsignedLongTerms) {
            name,
 */
            bucketCountThresholds
                } else if (((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG_SHIFTED) {
                if (((UnsignedLongTerms) agg).format == DocValueFormat.RAW) {
            showTermDocCountError,
            }
                } else if (((UnsignedLongTerms) agg).format == DocValueFormat.UNSIGNED_LONG) {
    @Override
                )
 *
                    (InternalAggregations) bucket.getAggregations(),
        public Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {
            unsignedLongTerms.reduceOrder,
                    newAggs.add(dTerms);
        TermsAggregator.BucketCountThresholds bucketCountThresholds
            format,
    }
            order,
import java.util.Objects;
            term = in.readBigInteger();
package org.opensearch.search.aggregations.bucket.terms;
        List<DoubleTerms.Bucket> newBuckets = new ArrayList<>();
    public UnsignedLongTerms(StreamInput in) throws IOException {
        public Bucket(
            shardSize,
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    public UnsignedLongTerms create(List<Bucket> buckets) {
        );
                }
    @Override
import org.opensearch.search.DocValueFormat;
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
            name,
        }
        DocValueFormat format,
        @Override
        @Override
    /**
        }
        public int compareKey(Bucket other) {
        return new UnsignedLongTerms(
        return NAME;
            prototype.docCountError,
        String name,
import java.util.ArrayList;
        public String getKeyAsString() {
import org.opensearch.core.xcontent.XContentBuilder;
            if (format != DocValueFormat.RAW && format != DocValueFormat.UNSIGNED_LONG_SHIFTED && format != DocValueFormat.UNSIGNED_LONG) {
 * compatible open source license.
            order,
 * The OpenSearch Contributors require contributions made to
            } else {
        }
            reduceOrder,
    @Override
    /**
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, UnsignedLongTerms.Bucket prototype) {
 * long, unsigned long or a date.
            return builder;
