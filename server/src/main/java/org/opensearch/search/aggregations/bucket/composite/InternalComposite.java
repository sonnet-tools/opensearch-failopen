        return new InternalBucket(sourceNames, reducedFormats, buckets.get(0).key, reverseMuls, missingOrders, docCount, aggs);  
            sourceNames,
            docCount += bucket.docCount;  
            return 0;
        int size,
        private final transient List<String> sourceNames;  
    }
                if (result.size() >= size) {  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
                        public boolean hasNext() {  
        final List<String> keys;
    private static int compareNullables(Comparable a, Comparable b) {  
                buckets.clear();
        return CompositeAggregation.toXContentFragment(this, builder, params);
        }  
            prototype.docCount,  
            throw new UnsupportedOperationException("not implemented");
            if (bucketIt.next() != null) {  
import java.util.ArrayList;
        InternalBucket next() {
import org.apache.lucene.util.BytesRef;
            builder.append('{');  
            }
    }
            StringBuilder builder = new StringBuilder();
        List<InternalBucket> buckets = new ArrayList<>();
                && Objects.equals(aggregations, that.aggregations);  
 * Licensed to Elasticsearch under one or more contributor  
        public int hashCode() {  
 * Unless required by applicable law or agreed to in writing,
            this.values = values;  
            return builder.toString();
    // Visible for tests
                public int size() {
        private final CompositeKey key;
 */  
 * Modifications Copyright OpenSearch Contributors. See
            }
    }
        );
                assert key.get(i).getClass() == other.key.get(i).getClass();
    public InternalBucket createBucket(InternalAggregations aggregations, InternalBucket prototype) {
     * The bucket iterator
                return value.utf8ToString();  
        if (a == b) {
            earlyTerminated,
        @Override
import java.util.Map;
    private static class BucketIterator implements Comparable<BucketIterator> {  
    @Override  
            buckets.add(bucketIt.current);
            return new ArrayMap(sourceNames, formats, afterKey.values());  
        this.missingOrders = missingOrders;  
        private BucketIterator(List<InternalBucket> buckets) {
            return values.length;
                return false;
                int result = missingOrders[i].compare(() -> key.get(index) == null, () -> other.key.get(index) == null, reverseMuls[i]);  
        List<DocValueFormat> reducedFormats = buckets.get(0).formats;
                            return entry;
            return 0;  
 * this file be licensed under the Apache-2.0 license or a
        public int size() {
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    @Override  
import org.opensearch.search.aggregations.Aggregations;  
        return obj;
            reducedFormats,
            for (int i = 0; i < keys.size(); i++) {
                    }  
    }  
 * The OpenSearch Contributors require contributions made to  
                    if (result == 0) {
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        /* Use the formats from the bucket because they'll be right to format
 * compatible open source license.
                        }
                int cmp = key.get(i).compareTo(other.key.get(i)) * reverseMuls[i];
          keep the <code>afterKey</code> of the original aggregation in order
                            return pos < values.length;
    protected InternalBucket reduceBucket(List<InternalBucket> buckets, ReduceContext context) {
            earlyTerminated |= sortedAgg.earlyTerminated;  
                return format.format(value);  
         * the key. The formats on the InternalComposite doing the reducing are
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);  
 * software distributed under the License is distributed on an
            this.missingOrders = missingOrders;
    @Override
            earlyTerminated,
    }  
     */
    }
            prototype.sourceNames,
 * the Apache License, Version 2.0 (the "License"); you may
        return earlyTerminated;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override
        List<DocValueFormat> formats,  
        public int compareTo(BucketIterator other) {  
            builder.append('}');  
                            ++pos;
        }
                pq.add(bucketIt);
    }
        );  
 *  
    public List<InternalBucket> getBuckets() {
                @Override
            int idx = 0;
         * trouble when the index doing the reducing is unmapped. */
        private final InternalAggregations aggregations;  
            this.keys = keys;
    }
        this.size = size;
        return Objects.hash(super.hashCode(), size, buckets, afterKey, Arrays.hashCode(reverseMuls), Arrays.hashCode(missingOrders));
    public boolean equals(Object obj) {
        if (obj == null) {  
        super(in);
        @Override
        public int compareTo(ArrayMap that) {  
        }  
                @Override  
                                keys.get(pos),
    protected void doWriteTo(StreamOutput out) throws IOException {
                builder.append(sourceNames.get(i));
        }
        this.afterKey = in.readBoolean() ? new CompositeKey(in) : null;  
    /**  
     * @opensearch.internal  
                && Objects.equals(key, that.key)
            getMetadata()  
            lastBucket = bucketIt.current;
        if (buckets.size() > 0) {
        this.earlyTerminated = earlyTerminated;
                    return formatObject(values[i], formats.get(i));  
                    break;
        }
        }
            }
    private final MissingOrder[] missingOrders;
    public InternalComposite(StreamInput in) throws IOException {
    @Override  
                public Iterator<Entry<String, Object>> iterator() {
     *
/*
            this.key = new CompositeKey(in);
            this.reverseMuls = reverseMuls;  
        @Override  
            out.writeNamedWriteable(format);  
        }  
                return -1;  
            this.formats = formats;
    @Override
    }
        reduceContext.consumeBucketsAndMaybeBreak(result.size());  
                }
                }
    private final int size;
    }  
            }
 *
    /**
                }
import java.util.PriorityQueue;
        @Override
        final Comparable[] values;
            size,
     */
            // returns the formatted key in a map
            this.docCount = docCount;
            }
            prototype.reverseMuls,
        List<DocValueFormat> reducedFormats = formats;  
        }
        }
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.InternalAggregations;
        for (InternalBucket bucket : buckets) {
            this.it = buckets.iterator();
/**
            aggregations.writeTo(out);
     *  
        List<InternalBucket> result = new ArrayList<>();
        List<DocValueFormat> getFormats() {  
        CompositeKey afterKey,
            int[] reverseMuls,
            MissingOrder[] missingOrders
            return 1;
            this.sourceNames = sourceNames;
     * @opensearch.internal
            } else {
        }
            this.docCount = docCount;
        }  
        }  
            reverseMuls,
                InternalBucket reduceBucket = reduceBucket(buckets, reduceContext);  
        List<InternalBucket> buckets,
            long docCount,  
        InternalBucket lastBucket = null;  
            int[] reverseMuls,
     */
            if (lastBucket != null && bucketIt.current.compareKey(lastBucket) != 0) {
        }
        return new InternalBucket(  
 * SPDX-License-Identifier: Apache-2.0
        @Override
        this.reverseMuls = reverseMuls;
                builder.append('=');  
 * @opensearch.internal
        @Override  
import java.io.IOException;
        this.afterKey = afterKey;  
            return current = it.hasNext() ? it.next() : null;
            this.aggregations = InternalAggregations.readFrom(in);  
            lastKey = lastBucket.getRawKey();
                    return compare;
            formats.add(in.readNamedWriteable(DocValueFormat.class));
        if (a == null) {
        return buckets;
    /**  
import org.opensearch.search.aggregations.InternalAggregation;
     */
        }
package org.opensearch.search.aggregations.bucket.composite;
            newBuckets,
          This is used by pipeline aggregations to filter/remove buckets so we
        CompositeKey lastKey = null;
            return null;  
                result.add(reduceBucket);
    @Override
    private final List<DocValueFormat> formats;
                        }  
        private final transient List<DocValueFormat> formats;
        boolean earlyTerminated,
         */
        return a.compareTo(b);
        if (afterKey != null) {  
public class InternalComposite extends InternalMultiBucketAggregation<InternalComposite, InternalComposite.InternalBucket>  
 * license agreements. See the NOTICE file distributed with
        );
        if (obj.getClass() == BytesRef.class) {  
            BytesRef value = (BytesRef) obj;
            this.sourceNames = sourceNames;  
            if (format == DocValueFormat.RAW) {  
            List<DocValueFormat> formats,  
                    return keys.size();  
import java.util.Set;
    @Override
     *  
            return -1;
            List<String> sourceNames,
                        @Override
             */
    }
        this.formats = formats;
    private final List<InternalBucket> buckets;
             * so that we can properly format the after key. */
            out.writeVLong(docCount);
                    } else {
    @Override  
        if (super.equals(obj) == false) return false;
import org.opensearch.search.aggregations.KeyComparable;
    }
            return docCount;  
        public boolean equals(Object obj) {
                builder.append(formatObject(key.get(i), formats.get(i)));
        final Iterator<InternalBucket> it;
        this.missingOrders = in.readArray(MissingOrder::readFromStream, MissingOrder[]::new);
    }  
            return new ArrayMap(sourceNames, formats, key.values());  
                if (cmp != 0) {
        return new InternalComposite(
                return value;
        }
         * just whatever formats make sense for *its* index. This can be real  
        private long docCount;
    }
        return reverseMuls;  
}  
            return aggregations;  
            prototype.formats,
            if (idx < that.keys.size()) {
            List<DocValueFormat> formats,
    /**
        public Aggregations getAggregations() {
            BucketIterator bucketIt = pq.poll();
                final int index = i;
        }
            } else {  
            InternalBucket that = (InternalBucket) obj;  
import java.util.Arrays;
            return null;
            return 0;
    public InternalComposite create(List<InternalBucket> newBuckets) {
        /**  
            /* Attach the formats from the last bucket to the reduced composite
            }  
     * If the format is equals to {@link DocValueFormat#RAW}, the object is returned as is
        return new InternalComposite(
        if (this == obj) return true;
        CompositeKey getRawKey() {
        return null;
        super(name, metadata);
 *
import java.util.AbstractMap;
        } else if (obj.getClass() == Double.class) {
            this.key = key;  
        private final transient MissingOrder[] missingOrders;
            size,  
    }
            missingOrders,  
    /**
/*  
            this.missingOrders = missingOrders;
    }
            if (format == DocValueFormat.RAW) {
    boolean isTerminatedEarly() {  
        Map<String, Object> metadata  
        this.formats = new ArrayList<>(sourceNames.size());
        @Override
                int compare = compareNullables(keys.get(idx), that.keys.get(idx));
     * The formats used when writing the keys. Package private for testing.  
    static Object formatObject(Object obj, DocValueFormat format) {
                    compare = compareNullables(values[idx], that.values[idx]);
            }
            CompositeAggregation.Bucket,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int getSize() {
                        continue;  
                }
     * @opensearch.internal
            InternalComposite sortedAgg = (InternalComposite) agg;
            long value = (long) obj;
    int[] getReverseMuls() {
 */
        @Override  
                if (compare == 0) {  
        InternalComposite that = (InternalComposite) obj;  
        }
 * Internal coordination class for composite aggs
            && Arrays.equals(reverseMuls, that.reverseMuls)
        public void writeTo(StreamOutput out) throws IOException {
            this.reverseMuls = reverseMuls;
            this.aggregations = aggregations;
            sourceNames,
            name,
            } else {
 *  
    // Visible for tests
         * The formats used when writing the keys. Package private for testing.
        return formats;  
    }
        for (DocValueFormat format : formats) {
            aggregations.add(bucket.aggregations);
        out.writeVInt(size);  
            && Objects.equals(buckets, that.buckets)
        CompositeAggregation {
                    };
    private final int[] reverseMuls;
            return Objects.equals(docCount, that.docCount)
    }  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
            metadata
        InternalBucket(  
    }
    }
            /*
            }
            while (idx < max) {
         */
            CompositeKey key,  
            BucketIterator it = new BucketIterator(sortedAgg.buckets);
        }  
            for (int i = 0; i < key.size(); i++) {
        this.size = in.readVInt();  
        public Object get(Object key) {  
                pq.add(it);  
            lastBucket = result.get(result.size() - 1);  
            result,  
import java.util.Iterator;  
        }
            }  
 * not use this file except in compliance with the License.
        out.writeArray((output, order) -> order.writeTo(output), missingOrders);  
        @Override  
            }  
                @SuppressWarnings("unchecked")  
        } else if (obj.getClass() == Long.class) {
        out.writeStringCollection(sourceNames);
        this.sourceNames = in.readStringList();
        @Override
 * ownership. Elasticsearch licenses this file to you under  
        List<String> sourceNames,
            this.formats = formats;
    public static class InternalBucket extends InternalMultiBucketAggregation.InternalBucket
            reverseMuls,  
            if (it.next() != null) {
    public int hashCode() {  
        int[] reverseMuls,  
        @Override  
                return format.format(value);
    private final CompositeKey afterKey;  
                return 0;
 */
            this.formats = formats;  
        }
        /*  
            prototype.key,  
     * for numbers and a string for {@link BytesRef}s.  
        ArrayMap(List<String> keys, List<DocValueFormat> formats, Comparable[] values) {
        this.sourceNames = sourceNames;  
    private final List<String> sourceNames;  
        InternalBucket(  
            return new AbstractSet<Entry<String, Object>>() {
                }
    implements
                    builder.append(", ");  
        public String getKeyAsString() {
            };
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        this.earlyTerminated = in.readBoolean();
            MissingOrder[] missingOrders,
            if (format == DocValueFormat.RAW) {
            return key;  
     * An array map used for the internal composite agg
        }
                return value;
            if (idx < keys.size()) {
        out.writeBoolean(earlyTerminated);  
        }  
    }
        String name,  
            if (obj == null || getClass() != obj.getClass()) {  
                            );  
            reducedFormats = lastBucket.formats;  
        while (pq.size() > 0) {  
 * You may obtain a copy of the License at  
                        int pos = 0;  
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());  
     * Format <code>obj</code> using the provided {@link DocValueFormat}.
        }
        return Objects.equals(size, that.size)
        private final transient int[] reverseMuls;
        }
     */
            assert keys.size() == values.length && keys.size() == formats.size();  
                if (i > 0) {
            StreamInput in,
            formats,  
                return format.format(value);
        }
        for (int i = 0; i < sourceNames.size(); i++) {  
              See {@link CompositeAggregation#bucketToXContent}  
 * GitHub history for details.
        public void setDocCount(long docCount) {  
            aggregations
        }
import java.util.List;
        }
        out.writeBoolean(afterKey != null);
        public long getDocCount() {
                        public Entry<String, Object> next() {
        }
                if (compare != 0) {  
            return Objects.hash(getClass(), docCount, key, aggregations);
        @Override
        // visible for testing
    public Map<String, Object> afterKey() {
        out.writeIntArray(reverseMuls);
        public Set<Entry<String, Object>> entrySet() {
                                formatObject(values[pos], formats.get(pos))
                if (key.equals(keys.get(i))) {
            afterKey.writeTo(out);
            name,  
 * KIND, either express or implied.  See the License for the
    public String getWriteableName() {  
                        @Override
    ) {
        public Map<String, Object> getKey() {
        @Override
        implements  
        return CompositeAggregationBuilder.NAME;
            if (that == this) {
          to be able to retrieve the next page even if all buckets have been filtered.  
        }
            key.writeTo(out);  
        }  
        if (result.size() > 0) {
        this.buckets = buckets;
            List<String> sourceNames,
        if (obj == null || getClass() != obj.getClass()) return false;  
        }  
                if (MissingOrder.unknownOrder(result) == false) {
 * specific language governing permissions and limitations
        boolean earlyTerminated = false;  
                }
            prototype.missingOrders,
        if (b == null) {
            }
            return formats;
        this.buckets = in.readList((input) -> new InternalBucket(input, sourceNames, formats, reverseMuls, missingOrders));
import org.opensearch.search.DocValueFormat;
            }
            result.add(reduceBucket);  
        this.reverseMuls = in.readIntArray();  
        out.writeList(buckets);
            }
        public int compareKey(InternalBucket other) {
                return 1;  
        assert buckets.size() > 0;
            && Objects.equals(afterKey, that.afterKey)  
            InternalBucket reduceBucket = reduceBucket(buckets, reduceContext);
            }
            KeyComparable<InternalBucket> {
                        return result;
                    return new Iterator<Entry<String, Object>>() {
        ) {
    private final boolean earlyTerminated;  
import java.util.Objects;  
/*  
            lastKey,
import org.opensearch.core.common.io.stream.StreamInput;
        }  
        final List<DocValueFormat> formats;  
 */  
        ) throws IOException {  
    List<DocValueFormat> getFormats() {
        MissingOrder[] missingOrders,
        return size;  
            afterKey,
import java.util.AbstractSet;  
        }  
    @Override  
        PriorityQueue<BucketIterator> pq = new PriorityQueue<>(aggregations.size());
        // get the raw key (without formatting to preserve the natural order).  
        long docCount = 0;
        if (afterKey != null) {
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
            return current.compareKey(other.current);
            for (int i = 0; i < key.size(); i++) {  
 * under the License.  
            missingOrders,
                }
                idx++;  
        InternalBucket current;
    }
     * Internal bucket for the internal composite agg
            InternalAggregations aggregations
            int max = Math.min(this.keys.size(), that.keys.size());  
                            SimpleEntry<String, Object> entry = new SimpleEntry<>(  
        }
            this.docCount = in.readVLong();
                // lambda function require final variable.
        for (InternalAggregation agg : aggregations) {
                    return cmp;  
import org.opensearch.core.xcontent.XContentBuilder;
            double value = (double) obj;  
    InternalComposite(
    @Override  
    static class ArrayMap extends AbstractMap<String, Object> implements Comparable<ArrayMap> {  
            && Arrays.equals(missingOrders, that.missingOrders);
                }
        }
                }
