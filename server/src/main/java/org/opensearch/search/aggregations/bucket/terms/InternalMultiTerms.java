        }  
     * @opensearch.internal  
            this.termValues = in.readList(StreamInput::readGenericValue);
                }  
            this.termFormats = formats;
    @Override
    @Override
    }
        return new InternalMultiTerms(
        } else if (obj.getClass() == Double.class) {  
                return 0;
            reduceOrder,
        @Override
        public static Bucket EMPTY(boolean showTermDocCountError, List<DocValueFormat> formats) {
                return format.format(value);
        public long getDocCountError() {
            return keys;
        if (super.equals(obj) == false) return false;
        void setDocCountError(long docCountError) {
    }
    }
/**  
        public Bucket(  
        BucketOrder order,  
                    int ret = ((Comparable) thisObject).compareTo(thatObject);
        writeSize(shardSize, out);  
    public long getDocCountError() {
import java.io.IOException;  
            out.writeCollection(termValues, StreamOutput::writeGenericValue);
            this.termValues = values;
 */
import org.opensearch.core.common.io.stream.StreamInput;
                return value;
     * If the format is equals to {@link DocValueFormat#RAW}, the object is returned as is  
        protected long docCountError;  
            this.docCountError = updater.apply(this.docCountError);
        List<Bucket> buckets,
 * SPDX-License-Identifier: Apache-2.0
    private final long otherDocCount;
            this.aggregations = InternalAggregations.readFrom(in);
        public int hashCode() {  
     * <p>
                && aggregations.equals(other.aggregations)
            prototype.docCountError,  
                out.writeLong(docCountError);  
            this.docCountError = docCountError;  
            termFormats,
            prototype.termValues,
        private static final String PIPE = "|";  
        return doXContentCommon(builder, params, docCountError, otherDocCount, buckets);  
         * Create default {@link Bucket}.  
                return false;  
    static Object formatObject(Object obj, DocValueFormat format) {  
                throw new IllegalStateException("show_terms_doc_count_error is false");  
package org.opensearch.search.aggregations.bucket.terms;
    private final int shardSize;  
    }  
import org.opensearch.search.aggregations.BucketOrder;
        List<Bucket> buckets,  
        ) {
        return new Bucket[size];
            prototype.termFormats
            } else {
        return Objects.hash(super.hashCode(), buckets, otherDocCount, showTermDocCountError, shardSize);
 *
        @Override
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            this.aggregations = aggregations;
    }  
import org.apache.lucene.util.BytesRef;
        public Aggregations getAggregations() {  
            buckets,  
            aggs,  
            return showDocCountError;
    }  
            }  
            docCountError,
         * A list of term's {@link DocValueFormat}.
        if (obj == null || getClass() != obj.getClass()) return false;
 *
        this.otherDocCount = in.readVLong();
            if (showDocCountError && docCountError != other.docCountError) {
 * Result of the {@link MultiTermsAggregator}.
            throw new IllegalArgumentException("getKeyAsNumber is not supported by [" + MultiTermsAggregationBuilder.NAME + "]");  
        }  
        return buckets;
    }
        } else if (obj.getClass() == Long.class) {
            this.showDocCountError = showDocCountError;
    public InternalMultiTerms(  
            aggregations.writeTo(out);
     * for numbers and a string for {@link BytesRef}s.
                    );  
            @Override
            metadata,  
        }
        @Override
            builder.endObject();
     */
        }  
        out.writeVLong(otherDocCount);
        Map<String, Object> metadata,
import org.opensearch.search.aggregations.InternalAggregations;  
            if (showDocCountError) {
            Bucket other = (Bucket) obj;
        @Override
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, Bucket prototype) {
    }  
            prototype.docCount,  
            name,  
            return Objects.hash(termValues, docCount, aggregations, showDocCountError, showDocCountError ? docCountError : 0);
            }
        }  
import java.util.stream.Collectors;
    private final boolean showTermDocCountError;
     *
            docCount,
        public int compareKey(Bucket other) {
    ) {
            return false;  
    public List<Bucket> getBuckets() {
    @Override
            }
            long docCount,
        InternalMultiTerms that = (InternalMultiTerms) obj;  
        }
            if (showDocCountError) {
        }  
    @Override  
 * @opensearch.internal  
    @Override  
        protected long bucketOrd;
            }  
            List<Object> values,
        return otherDocCount;
        /**  
import org.opensearch.search.DocValueFormat;
    private long docCountError;
                    final Object thatObject = thatObjects.get(i);
        protected InternalAggregations aggregations;
            return docCount;
import java.util.function.Function;  
            prototype.showDocCountError,
                return value.utf8ToString();
            showTermDocCountError,
                }
        return obj;
        this.shardSize = readSize(in);
         */  
    private final List<Bucket> buckets;
     * Internal Multi Terms Bucket.
        this.docCountError = docCountError;
            }
        @Override
            this.docCount = docCount;  
            if (format == DocValueFormat.RAW) {
        protected final List<DocValueFormat> termFormats;
            prototype.termFormats  
        out.writeCollection(termFormats, StreamOutput::writeNamedWriteable);
        return MultiTermsAggregationBuilder.NAME;
            this.docCount = in.readVLong();  
    }
            boolean showDocCountError,
        }
            bucketCountThresholds
    public int hashCode() {
            return termValues.equals(other.termValues)
    @Override
     */
        @Override
            shardSize,
        public void writeTo(StreamOutput out) throws IOException {
        this.termFormats = in.readList(stream -> stream.readNamedWriteable(DocValueFormat.class));
            otherDocCount,  
        @Override  
            order,
        }
            }
        return new Bucket(  
            && Objects.equals(docCountError, that.docCountError);  
    @Override  
                return format.format(value);
import org.opensearch.search.aggregations.AggregationExecutionException;  
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
            shardSize,
        protected static class BucketComparator implements Comparator<List<Object>> {
            && Objects.equals(otherDocCount, that.otherDocCount)  
        BucketOrder reduceOrder,
        @Override
        /**
    }  
        this.termFormats = formats;
        if (this == obj) return true;  
        if (obj.getClass() == BytesRef.class) {
        this.otherDocCount = otherDocCount;
    @Override
            this.docCountError = -1;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        protected boolean showDocCountError;
    public String getWriteableName() {  
         *
    @Override
    @Override
        }
            buckets,  
         * Visible for testing.
                if (thisObjects.size() != thatObjects.size()) {  
            if (showDocCountError) {
                        "[" + MultiTermsAggregationBuilder.NAME + "] aggregations failed due to terms" + " size is different"
        return shardSize;  
    public Bucket getBucketByKey(String term) {  
            long value = (long) obj;  
        }
        @Override  
                    final Object thisObject = thisObjects.get(i);  
            return aggregations;
import java.util.Objects;
    }  
        return docCountError;  
    protected int getShardSize() {
            long docCountError,
        super(name, reduceOrder, order, bucketCountThresholds, metadata);
    @Override  
            if (obj == null || getClass() != obj.getClass()) {
    public InternalMultiTerms create(List<Bucket> buckets) {
import java.util.Comparator;
    protected void setDocCountError(long docCountError) {  
        return bucketMap.get(term);
            return getKey().stream().map(Object::toString).collect(Collectors.joining(PIPE));  
    public static class Bucket extends InternalTerms.AbstractInternalBucket implements KeyComparable<Bucket> {
            InternalAggregations aggregations,  
        this.showTermDocCountError = in.readBoolean();  
            builder.field(CommonFields.KEY.getPreferredName(), getKey());
        public String getKeyAsString() {
    }
            builder.startObject();  
            }  
import org.opensearch.search.aggregations.Aggregations;
            }
    @Override
        out.writeList(buckets);  
    }  
        @Override
            out.writeVLong(docCount);  
            this.termFormats = formats;
         * @opensearch.internal  
            reduceOrder,
import org.opensearch.search.aggregations.KeyComparable;
        long otherDocCount  
    protected InternalMultiTerms create(
        public void setDocCountError(Function<Long, Long> updater) {
        return new InternalMultiTerms(
            return new Bucket(null, 0, null, showTermDocCountError, 0, formats);  
        }  
    /**  
        }
                keys.add(formatObject(termValues.get(i), termFormats.get(i)));
        }
                        return ret;
        this.docCountError = in.readZLong();  
    }
    /**
            public int compare(List<Object> thisObjects, List<Object> thatObjects) {
        this.docCountError = docCountError;
                && docCount == other.docCount  
        /**
            bucketCountThresholds
        long otherDocCount,
    @Override
            builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
            prototype.docCountError,
            } else {
        protected List<Object> termValues;
        );
            prototype.showDocCountError,
import java.util.Map;
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {  
        boolean showTermDocCountError,  
    }
        );
        out.writeZLong(docCountError);
        public boolean showDocCountError() {  
    }
            } else {  
        BucketOrder reduceOrder,
        return Objects.equals(buckets, that.buckets)
            if (format == DocValueFormat.RAW) {  
     * Format {@code obj} using the provided {@link DocValueFormat}.
            }  
            otherDocCount,  
        }
        this.showTermDocCountError = showTermDocCountError;  
        );
import org.opensearch.core.xcontent.XContentBuilder;
        }
         * list of terms values.  
            }  
        @Override  
        String name,
    ) {  
        }
        );
        }
            aggregations.toXContentInternal(builder, params);
        int shardSize,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    if (ret != 0) {  
            this.docCountError = docCountError;  
        @Override  
    @Override
            BytesRef value = (BytesRef) obj;
         */
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());  
    public InternalMultiTerms(StreamInput in) throws IOException {
                builder.field(DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), getDocCountError());
            List<DocValueFormat> formats  
    public boolean equals(Object obj) {
        if (showTermDocCountError && docCountError != that.docCountError) {
         */
 * compatible open source license.
    }
        }
        public boolean equals(Object obj) {  
            order,
            docCountError,
            return new BucketComparator().compare(this.termValues, other.termValues);  
        /**
                for (int i = 0; i < thisObjects.size(); i++) {
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {  
            for (int i = 0; i < termValues.size(); i++) {
            termFormats,
import java.util.ArrayList;
            metadata,  
                    throw new AggregationExecutionException(
        List<DocValueFormat> formats,  
                    }
        String name,
                this.docCountError = in.readLong();
                return format.format(value);  
            bucketMap = buckets.stream().collect(Collectors.toMap(InternalMultiTerms.Bucket::getKeyAsString, Function.identity()));
        @Override
            return builder;  
            double value = (double) obj;
            this.showDocCountError = showDocCountError;
        public Number getKeyAsNumber() {
    public long getSumOfOtherDocCounts() {
        public long getDocCount() {
        TermsAggregator.BucketCountThresholds bucketCountThresholds
        public List<Object> getKey() {
    private Map<String, Bucket> bucketMap;
            showTermDocCountError,
        if (bucketMap == null) {
            if (format == DocValueFormat.RAW) {
        this.buckets = in.readList(steam -> new Bucket(steam, termFormats, showTermDocCountError));
        out.writeBoolean(showTermDocCountError);
        @Override
                return false;
        long docCountError,
            @SuppressWarnings({ "unchecked" })  
        public Bucket(StreamInput in, List<DocValueFormat> formats, boolean showDocCountError) throws IOException {
            && Objects.equals(shardSize, that.shardSize)
            if (!showDocCountError) {
    }  
    }
public class InternalMultiTerms extends InternalTerms<InternalMultiTerms, InternalMultiTerms.Bucket> {
                && showDocCountError == other.showDocCountError;
            name,  
            }
    @Override  
            aggregations,
        }  
        return new Bucket(
 * this file be licensed under the Apache-2.0 license or a
            return docCountError;
        long docCountError,
        super(in);
    protected Bucket[] createBucketsArray(int size) {  
    private final List<DocValueFormat> termFormats;  
            prototype.termValues,
            return null;
        }
    @Override
    }
        }
        protected long docCount;  
     * Copy from InternalComposite  
                return value;  
            && Objects.equals(showTermDocCountError, that.showTermDocCountError)
 */  
}
        this.shardSize = shardSize;
         */
            List<Object> keys = new ArrayList<>(termValues.size());  
        this.buckets = buckets;  
/*  
        if (obj == null) {
