 * @opensearch.internal
    }
            return docCountError;
            if (showDocCountError && docCountError != other.docCountError) {
        /**
            double value = (double) obj;
            } else {
import org.opensearch.search.aggregations.KeyComparable;
            Bucket other = (Bucket) obj;
    protected int getShardSize() {
         * Visible for testing.
            return getKey().stream().map(Object::toString).collect(Collectors.joining(PIPE));
    @Override
            return new BucketComparator().compare(this.termValues, other.termValues);
        protected long docCount;
    }
     *
            long docCountError,
import org.opensearch.search.aggregations.InternalAggregations;
            order,
            long docCount,
         *
import org.opensearch.search.aggregations.AggregationExecutionException;
            name,
            }
import java.util.Objects;
        @Override
        }
            throw new IllegalArgumentException("getKeyAsNumber is not supported by [" + MultiTermsAggregationBuilder.NAME + "]");
            metadata,
        }
            List<DocValueFormat> formats
    }
            prototype.docCountError,
import org.apache.lucene.util.BytesRef;
        void setDocCountError(long docCountError) {
        }
    /**
import org.opensearch.search.aggregations.BucketOrder;
        InternalMultiTerms that = (InternalMultiTerms) obj;
        return shardSize;
            if (showDocCountError) {
import org.opensearch.search.DocValueFormat;
        this.termFormats = in.readList(stream -> stream.readNamedWriteable(DocValueFormat.class));
        public List<Object> getKey() {
         */
}
        this.docCountError = in.readZLong();
            if (showDocCountError) {
 *
                keys.add(formatObject(termValues.get(i), termFormats.get(i)));
            }
            showTermDocCountError,
                    );
                    if (ret != 0) {
                && showDocCountError == other.showDocCountError;
                    final Object thatObject = thatObjects.get(i);
     */
    private Map<String, Bucket> bucketMap;
    }
    }
            return new Bucket(null, 0, null, showTermDocCountError, 0, formats);
        }
                }
        }
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {
            List<Object> keys = new ArrayList<>(termValues.size());
        @Override
        @Override
            if (format == DocValueFormat.RAW) {
            prototype.showDocCountError,
     * <p>
        out.writeZLong(docCountError);
        int shardSize,
            prototype.termValues,
        public int compareKey(Bucket other) {
    private final int shardSize;
        }
        BucketOrder reduceOrder,
         * @opensearch.internal
            if (obj == null || getClass() != obj.getClass()) {
            @Override
    }
            prototype.termFormats
                return format.format(value);
            return keys;
                && aggregations.equals(other.aggregations)
    @Override
        return new Bucket(
        }
            } else {
        out.writeList(buckets);
            return false;
            && Objects.equals(showTermDocCountError, that.showTermDocCountError)
 * The OpenSearch Contributors require contributions made to
        @Override
        this.docCountError = docCountError;
    }
            prototype.docCountError,
        @Override
/*
                for (int i = 0; i < thisObjects.size(); i++) {
        @Override
        }
        }
    @Override
        /**
            aggregations.writeTo(out);
     */
        List<Bucket> buckets,
                    }
        );
            prototype.termFormats
    protected Bucket[] createBucketsArray(int size) {
            otherDocCount,
        public boolean equals(Object obj) {
 * SPDX-License-Identifier: Apache-2.0
     * Format {@code obj} using the provided {@link DocValueFormat}.
        return new InternalMultiTerms(
            List<Object> values,
        writeSize(shardSize, out);
        protected static class BucketComparator implements Comparator<List<Object>> {
        }
            order,
        return docCountError;
            }
            docCount,
            return showDocCountError;
            metadata,
        String name,
        private static final String PIPE = "|";
    private final boolean showTermDocCountError;
            if (showDocCountError) {
            @SuppressWarnings({ "unchecked" })
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, Bucket prototype) {
        if (bucketMap == null) {
            this.termFormats = formats;
import java.util.function.Function;
         * list of terms values.
        }
        public Bucket(
        }
            out.writeVLong(docCount);
        @Override
    @Override
        public long getDocCount() {
    @Override
        /**
    ) {
            builder.endObject();
        return MultiTermsAggregationBuilder.NAME;
            this.docCount = in.readVLong();
                        "[" + MultiTermsAggregationBuilder.NAME + "] aggregations failed due to terms" + " size is different"
            builder.startObject();
    }
        protected long docCountError;
            return docCount;
import java.util.ArrayList;
    private final long otherDocCount;
            && Objects.equals(otherDocCount, that.otherDocCount)
        return otherDocCount;
    public InternalMultiTerms(
    @Override
            }
        }
        return Objects.hash(super.hashCode(), buckets, otherDocCount, showTermDocCountError, shardSize);
         */
        if (obj.getClass() == BytesRef.class) {
        this.buckets = in.readList(steam -> new Bucket(steam, termFormats, showTermDocCountError));
        return new InternalMultiTerms(
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
        }
        public boolean showDocCountError() {
        BucketOrder order,
        protected InternalAggregations aggregations;
                && docCount == other.docCount
            } else {
        }
        @Override
import org.opensearch.core.xcontent.XContentBuilder;
    protected InternalMultiTerms create(
    }
    @Override
            this.termValues = values;
        super(in);
            this.docCountError = updater.apply(this.docCountError);
        public int hashCode() {
            return termValues.equals(other.termValues)
            if (!showDocCountError) {
            this.docCount = docCount;
        this.shardSize = readSize(in);
        public long getDocCountError() {
    public long getSumOfOtherDocCounts() {
                builder.field(DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), getDocCountError());
        );
                return value;
        long docCountError,
    @Override
            docCountError,
        return doXContentCommon(builder, params, docCountError, otherDocCount, buckets);
            name,
     * Copy from InternalComposite
            shardSize,
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
        this.showTermDocCountError = showTermDocCountError;
            reduceOrder,
        long otherDocCount
            prototype.showDocCountError,
        return bucketMap.get(term);
            this.docCountError = docCountError;
        }
    private long docCountError;
            this.showDocCountError = showDocCountError;
        public void writeTo(StreamOutput out) throws IOException {
            bucketCountThresholds
    public List<Bucket> getBuckets() {
        @Override
        }
        long docCountError,
                throw new IllegalStateException("show_terms_doc_count_error is false");
    }
            reduceOrder,
        return new Bucket[size];
        List<DocValueFormat> formats,
import org.opensearch.core.common.io.stream.StreamInput;
            docCountError,
     * for numbers and a string for {@link BytesRef}s.
    public InternalMultiTerms(StreamInput in) throws IOException {
            bucketMap = buckets.stream().collect(Collectors.toMap(InternalMultiTerms.Bucket::getKeyAsString, Function.identity()));
            termFormats,
         * Create default {@link Bucket}.
        this.termFormats = formats;
            }
            prototype.docCount,
            this.termValues = in.readList(StreamInput::readGenericValue);
                return value;
            showTermDocCountError,
            }
 */
    @Override
        );
        );
import java.io.IOException;
        out.writeCollection(termFormats, StreamOutput::writeNamedWriteable);
 */
        public String getKeyAsString() {
    }
            this.docCountError = -1;
            }
        } else if (obj.getClass() == Double.class) {
        protected List<Object> termValues;
public class InternalMultiTerms extends InternalTerms<InternalMultiTerms, InternalMultiTerms.Bucket> {
    public long getDocCountError() {
            buckets,
        @Override
            }
        }
    }
 *
    public int hashCode() {
        long otherDocCount,
                return 0;
import java.util.stream.Collectors;
        if (super.equals(obj) == false) return false;
    public String getWriteableName() {
    protected void setDocCountError(long docCountError) {
            boolean showDocCountError,
            builder.field(CommonFields.KEY.getPreferredName(), getKey());
                out.writeLong(docCountError);
        @Override
import org.opensearch.search.aggregations.Aggregations;
    @Override
            otherDocCount,
                if (thisObjects.size() != thatObjects.size()) {
        public Bucket(StreamInput in, List<DocValueFormat> formats, boolean showDocCountError) throws IOException {
    }
            if (format == DocValueFormat.RAW) {
            && Objects.equals(docCountError, that.docCountError);
        this.docCountError = docCountError;
package org.opensearch.search.aggregations.bucket.terms;
            return null;
            }
        protected long bucketOrd;
                return false;
    public boolean equals(Object obj) {
            aggs,
            BytesRef value = (BytesRef) obj;
                    throw new AggregationExecutionException(
        public Number getKeyAsNumber() {
    private final List<Bucket> buckets;
     * Internal Multi Terms Bucket.
        return obj;
 * Result of the {@link MultiTermsAggregator}.
        protected final List<DocValueFormat> termFormats;
            }
                return format.format(value);
     * @opensearch.internal
                this.docCountError = in.readLong();
    @Override
        boolean showTermDocCountError,
        this.showTermDocCountError = in.readBoolean();
        return new Bucket(
    }
 * this file be licensed under the Apache-2.0 license or a
        } else if (obj.getClass() == Long.class) {
            InternalAggregations aggregations,
    /**
            prototype.termValues,
    ) {
         */
        }
    @Override
            return builder;
                }
import java.util.Map;
                        return ret;
        this.otherDocCount = in.readVLong();
            return aggregations;
    @Override
        ) {
         */
            aggregations,
        out.writeBoolean(showTermDocCountError);
            this.aggregations = InternalAggregations.readFrom(in);
        String name,
                    int ret = ((Comparable) thisObject).compareTo(thatObject);
        if (obj == null || getClass() != obj.getClass()) return false;
        protected boolean showDocCountError;
            termFormats,
        this.otherDocCount = otherDocCount;
            shardSize,
            }
import java.util.Comparator;
            for (int i = 0; i < termValues.size(); i++) {
        public void setDocCountError(Function<Long, Long> updater) {
            this.aggregations = aggregations;
    private final List<DocValueFormat> termFormats;
        @Override
        List<Bucket> buckets,
    }
        /**
    }
        this.shardSize = shardSize;
            this.termFormats = formats;
            public int compare(List<Object> thisObjects, List<Object> thatObjects) {
                return format.format(value);
    }
 * compatible open source license.
        super(name, reduceOrder, order, bucketCountThresholds, metadata);
                    final Object thisObject = thisObjects.get(i);
    public static class Bucket extends InternalTerms.AbstractInternalBucket implements KeyComparable<Bucket> {
            if (format == DocValueFormat.RAW) {
        if (this == obj) return true;
                return false;
    public Bucket getBucketByKey(String term) {
import java.util.List;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        }
        public static Bucket EMPTY(boolean showTermDocCountError, List<DocValueFormat> formats) {
    public InternalMultiTerms create(List<Bucket> buckets) {
         * A list of term's {@link DocValueFormat}.
/**
        if (obj == null) {
    }
        if (showTermDocCountError && docCountError != that.docCountError) {
        }
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
            return Objects.hash(termValues, docCount, aggregations, showDocCountError, showDocCountError ? docCountError : 0);
    static Object formatObject(Object obj, DocValueFormat format) {
        Map<String, Object> metadata,
            && Objects.equals(shardSize, that.shardSize)
            this.showDocCountError = showDocCountError;
        @Override
    @Override
        this.buckets = buckets;
            long value = (long) obj;
    }
            builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
    }
    @Override
        return buckets;
        @Override
            this.docCountError = docCountError;
        public Aggregations getAggregations() {
            aggregations.toXContentInternal(builder, params);
        BucketOrder reduceOrder,
        }
     * If the format is equals to {@link DocValueFormat#RAW}, the object is returned as is
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeVLong(otherDocCount);
            buckets,
                return value.utf8ToString();
            bucketCountThresholds
        return Objects.equals(buckets, that.buckets)
        TermsAggregator.BucketCountThresholds bucketCountThresholds
            out.writeCollection(termValues, StreamOutput::writeGenericValue);
