     * @opensearch.internal
        }
                            );
        for (InternalAggregation agg : aggregations) {
        }
import org.opensearch.search.aggregations.InternalAggregation;
 * @opensearch.internal
    }
            sourceNames,
            this.docCount = in.readVLong();
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        this.missingOrders = in.readArray(MissingOrder::readFromStream, MissingOrder[]::new);
    private final List<InternalBucket> buckets;
    public static class InternalBucket extends InternalMultiBucketAggregation.InternalBucket
        this.formats = new ArrayList<>(sourceNames.size());
                }
        public Set<Entry<String, Object>> entrySet() {
                }
        while (pq.size() > 0) {
        }
    }
        );
        InternalBucket current;
        return buckets;
    private final int[] reverseMuls;
        return new InternalBucket(
        this.afterKey = in.readBoolean() ? new CompositeKey(in) : null;
            newBuckets,
    }
            afterKey.writeTo(out);
    }
         */
            CompositeAggregation.Bucket,
                return format.format(value);
            name,
            }
            BytesRef value = (BytesRef) obj;
                return false;
/*
                    compare = compareNullables(values[idx], that.values[idx]);
        public String getKeyAsString() {
                InternalBucket reduceBucket = reduceBucket(buckets, reduceContext);
            if (format == DocValueFormat.RAW) {
            && Arrays.equals(missingOrders, that.missingOrders);
                        }
        this.afterKey = afterKey;
        return a.compareTo(b);
        }
        private final transient List<DocValueFormat> formats;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            lastBucket = bucketIt.current;
        }
            out.writeVLong(docCount);
        for (int i = 0; i < sourceNames.size(); i++) {
        for (InternalBucket bucket : buckets) {
            lastBucket = result.get(result.size() - 1);
    /**
        return null;
        out.writeBoolean(earlyTerminated);
        List<InternalBucket> buckets,
                                formatObject(values[pos], formats.get(pos))
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
            }
        @Override
    }
    }
        }
     * The bucket iterator
                }
                if (i > 0) {
        final List<String> keys;
     *
            return formats;
            return docCount;
            int[] reverseMuls,
        this.size = size;
            reducedFormats = lastBucket.formats;
            aggregations.writeTo(out);
            if (obj == null || getClass() != obj.getClass()) {
     * Internal bucket for the internal composite agg
            if (bucketIt.next() != null) {
        return size;
            return null;
    }
            return Objects.hash(getClass(), docCount, key, aggregations);
        }
            out.writeNamedWriteable(format);
                    builder.append(", ");
    protected InternalBucket reduceBucket(List<InternalBucket> buckets, ReduceContext context) {
            }
                if (MissingOrder.unknownOrder(result) == false) {
            int max = Math.min(this.keys.size(), that.keys.size());
                    }
 * Unless required by applicable law or agreed to in writing,
                }
        InternalComposite that = (InternalComposite) obj;
    }
    }
        @Override
        private final CompositeKey key;
                        @Override
        for (DocValueFormat format : formats) {
            this.formats = formats;
        super(name, metadata);
        @Override
     */
        }
        this.formats = formats;
    @Override
         * just whatever formats make sense for *its* index. This can be real
        @Override
        }
        out.writeStringCollection(sourceNames);
 * compatible open source license.
                if (key.equals(keys.get(i))) {
            this.key = key;
                return value.utf8ToString();
        return reverseMuls;
                pq.add(it);
            earlyTerminated,
        return new InternalComposite(
        super(in);
        List<DocValueFormat> formats,
            int[] reverseMuls,
            StringBuilder builder = new StringBuilder();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeList(buckets);
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
            List<DocValueFormat> formats,
                        continue;
            prototype.docCount,
        @Override
            if (idx < that.keys.size()) {
                    } else {
 *
 */
                            return entry;
        } else if (obj.getClass() == Double.class) {
        }
            KeyComparable<InternalBucket> {
            afterKey,
    public int hashCode() {
import org.opensearch.core.xcontent.XContentBuilder;
        }
    }
        @Override
        boolean earlyTerminated,
          to be able to retrieve the next page even if all buckets have been filtered.
    }
        out.writeIntArray(reverseMuls);
            if (it.next() != null) {
        private long docCount;
    static class ArrayMap extends AbstractMap<String, Object> implements Comparable<ArrayMap> {
            lastKey = lastBucket.getRawKey();
    // Visible for tests
            && Objects.equals(buckets, that.buckets)
        if (result.size() > 0) {
        // visible for testing
                if (result.size() >= size) {
     * An array map used for the internal composite agg
                }
                }
                return 0;
 * Modifications Copyright OpenSearch Contributors. See
        List<String> sourceNames,
          keep the <code>afterKey</code> of the original aggregation in order
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
                        public Entry<String, Object> next() {
            /*
        ArrayMap(List<String> keys, List<DocValueFormat> formats, Comparable[] values) {
        public Aggregations getAggregations() {
        List<DocValueFormat> getFormats() {
            prototype.formats,
                                keys.get(pos),
            prototype.key,
        this.missingOrders = missingOrders;
          This is used by pipeline aggregations to filter/remove buckets so we
            this.sourceNames = sourceNames;
        return Objects.hash(super.hashCode(), size, buckets, afterKey, Arrays.hashCode(reverseMuls), Arrays.hashCode(missingOrders));
    @Override
import java.util.Iterator;
        );
            formats,
        }
            long value = (long) obj;
        List<InternalBucket> buckets = new ArrayList<>();
    public String getWriteableName() {
            MissingOrder[] missingOrders
        public boolean equals(Object obj) {
                // lambda function require final variable.
            if (format == DocValueFormat.RAW) {
            this.formats = formats;
            && Objects.equals(afterKey, that.afterKey)
            return new ArrayMap(sourceNames, formats, afterKey.values());
        CompositeKey lastKey = null;
                    return new Iterator<Entry<String, Object>>() {
                }
        private final transient int[] reverseMuls;
            throw new UnsupportedOperationException("not implemented");
    private final int size;
        public void setDocCount(long docCount) {
    static Object formatObject(Object obj, DocValueFormat format) {
        CompositeKey afterKey,
        return Objects.equals(size, that.size)
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        this.earlyTerminated = in.readBoolean();
        }
            this.formats = formats;
        out.writeBoolean(afterKey != null);
        ) throws IOException {
    private final List<String> sourceNames;
     * for numbers and a string for {@link BytesRef}s.
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (int i = 0; i < keys.size(); i++) {
        out.writeVInt(size);
        private final transient List<String> sourceNames;
                    return formatObject(values[i], formats.get(i));
    // Visible for tests
        // get the raw key (without formatting to preserve the natural order).
        @Override
            int idx = 0;
            for (int i = 0; i < key.size(); i++) {
     * If the format is equals to {@link DocValueFormat#RAW}, the object is returned as is
    }
            return 0;
            prototype.sourceNames,
    @Override
                }
                public Iterator<Entry<String, Object>> iterator() {
    public InternalComposite(StreamInput in) throws IOException {
        public int compareKey(InternalBucket other) {
        }
            } else {
            BucketIterator it = new BucketIterator(sortedAgg.buckets);
            return current.compareKey(other.current);
        /**
            for (int i = 0; i < key.size(); i++) {
        assert buckets.size() > 0;
    }
        boolean earlyTerminated = false;
            return 0;
import java.io.IOException;
    public List<InternalBucket> getBuckets() {
                            return pos < values.length;
     * @opensearch.internal
                    return cmp;
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
        InternalBucket lastBucket = null;
        Map<String, Object> metadata
         * trouble when the index doing the reducing is unmapped. */
                if (compare != 0) {
 * The OpenSearch Contributors require contributions made to
            size,
            this.reverseMuls = reverseMuls;
            List<DocValueFormat> formats,
        if (afterKey != null) {
            }
 *
        );
 * KIND, either express or implied.  See the License for the
    private static int compareNullables(Comparable a, Comparable b) {
    }
/*
        }
            InternalAggregations aggregations
            return -1;
        }
                builder.append('=');
import java.util.PriorityQueue;
                        }
    implements
     */
import java.util.List;
     * @opensearch.internal
    /**
}
                return 1;
    public int getSize() {
        public long getDocCount() {
 * Licensed to Elasticsearch under one or more contributor
        if (obj == null) {
            formats.add(in.readNamedWriteable(DocValueFormat.class));
            return values.length;
        private final InternalAggregations aggregations;
            }
                int result = missingOrders[i].compare(() -> key.get(index) == null, () -> other.key.get(index) == null, reverseMuls[i]);
        @Override
            aggregations.add(bucket.aggregations);
                return -1;
        }
        PriorityQueue<BucketIterator> pq = new PriorityQueue<>(aggregations.size());
        public int size() {
        this.buckets = buckets;
        }
 * Internal coordination class for composite aggs
        return earlyTerminated;
                    return keys.size();
            aggregations
            long docCount,
    private final List<DocValueFormat> formats;
            assert keys.size() == values.length && keys.size() == formats.size();
                if (cmp != 0) {
        /*
    }
            while (idx < max) {
        this.reverseMuls = in.readIntArray();
 */
            result,
     */
     */
 * not use this file except in compliance with the License.
            this.reverseMuls = reverseMuls;
        }
                assert key.get(i).getClass() == other.key.get(i).getClass();
import org.opensearch.search.aggregations.InternalAggregations;
            missingOrders,
        int[] reverseMuls,
        MissingOrder[] missingOrders,
        if (afterKey != null) {
            // returns the formatted key in a map
                return value;
                int cmp = key.get(i).compareTo(other.key.get(i)) * reverseMuls[i];
        this.buckets = in.readList((input) -> new InternalBucket(input, sourceNames, formats, reverseMuls, missingOrders));
        }
                return format.format(value);
        implements
            CompositeKey key,
import java.util.ArrayList;
                int compare = compareNullables(keys.get(idx), that.keys.get(idx));
            builder.append('}');
        if (buckets.size() > 0) {
    public boolean equals(Object obj) {
        return CompositeAggregationBuilder.NAME;
         */
                result.add(reduceBucket);
    /**
                idx++;
        }
             */
            this.aggregations = InternalAggregations.readFrom(in);
    }
        }
import java.util.Objects;
        /* Use the formats from the bucket because they'll be right to format
                }
 * GitHub history for details.
    }
                return format.format(value);
            metadata
        return CompositeAggregation.toXContentFragment(this, builder, params);
                pq.add(bucketIt);
            }
         * the key. The formats on the InternalComposite doing the reducing are
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
/*
                builder.append(formatObject(key.get(i), formats.get(i)));
            this.sourceNames = sourceNames;
            this.keys = keys;
    private static class BucketIterator implements Comparable<BucketIterator> {
            return key;
        }
    @Override
            key.writeTo(out);
            } else {
            buckets.add(bucketIt.current);
            name,
            earlyTerminated,
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
                @Override
    public Map<String, Object> afterKey() {
            getMetadata()
            /* Attach the formats from the last bucket to the reduced composite
        List<InternalBucket> result = new ArrayList<>();
                && Objects.equals(key, that.key)
            }
        @Override
            }
            lastKey,
/**
            if (that == this) {
        this.earlyTerminated = earlyTerminated;
        return formats;
            InternalBucket that = (InternalBucket) obj;
                final int index = i;
        }
        List<DocValueFormat> reducedFormats = formats;
            earlyTerminated |= sortedAgg.earlyTerminated;
    public InternalBucket createBucket(InternalAggregations aggregations, InternalBucket prototype) {
    }
                public int size() {
        return new InternalBucket(sourceNames, reducedFormats, buckets.get(0).key, reverseMuls, missingOrders, docCount, aggs);
        this.size = in.readVInt();
        @Override
            this.values = values;
                @Override
            StreamInput in,
        public Object get(Object key) {
    private final MissingOrder[] missingOrders;
        }
import java.util.AbstractMap;
            return new AbstractSet<Entry<String, Object>>() {
                if (compare == 0) {
        if (super.equals(obj) == false) return false;
            }
            && Arrays.equals(reverseMuls, that.reverseMuls)
        final Comparable[] values;
    /**
        if (a == null) {
            sourceNames,
            return builder.toString();
            result.add(reduceBucket);
        InternalBucket next() {
import org.opensearch.core.common.io.stream.StreamInput;
            return aggregations;
            prototype.reverseMuls,
import java.util.AbstractSet;
        }
import org.opensearch.search.aggregations.KeyComparable;
        private final transient MissingOrder[] missingOrders;
        InternalBucket(
            this.docCount = docCount;
            if (format == DocValueFormat.RAW) {
            this.key = new CompositeKey(in);
            }
 *
    public InternalComposite create(List<InternalBucket> newBuckets) {
     * Format <code>obj</code> using the provided {@link DocValueFormat}.
    }
        public Map<String, Object> getKey() {
            return null;
 * software distributed under the License is distributed on an
            };
                            ++pos;
    }
    @Override
     */
            InternalComposite sortedAgg = (InternalComposite) agg;
        }
        this.sourceNames = sourceNames;
     *
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
     *
package org.opensearch.search.aggregations.bucket.composite;
                        int pos = 0;
    @Override
            }
        }
        }
                @SuppressWarnings("unchecked")
        long docCount = 0;
 * this work for additional information regarding copyright
        public int compareTo(BucketIterator other) {
     * The formats used when writing the keys. Package private for testing.
            return current = it.hasNext() ? it.next() : null;
                    if (result == 0) {
                    };
        int size,
import org.opensearch.core.common.io.stream.StreamOutput;
            List<String> sourceNames,
        @Override
 * this file be licensed under the Apache-2.0 license or a
        }
        CompositeKey getRawKey() {
                builder.append(sourceNames.get(i));
    @Override
            builder.append('{');
                    return compare;
        String name,
            }
    private final CompositeKey afterKey;
                    break;
        final Iterator<InternalBucket> it;
            size,
        }
        if (obj == null || getClass() != obj.getClass()) return false;
        @Override
            reducedFormats,
    List<DocValueFormat> getFormats() {
    private final boolean earlyTerminated;
            InternalBucket reduceBucket = reduceBucket(buckets, reduceContext);
        return new InternalComposite(
        this.sourceNames = in.readStringList();
        reduceContext.consumeBucketsAndMaybeBreak(result.size());
            List<String> sourceNames,
        out.writeArray((output, order) -> order.writeTo(output), missingOrders);
import org.opensearch.search.DocValueFormat;
            } else {
                buckets.clear();
            reverseMuls,
 *
            return Objects.equals(docCount, that.docCount)
        if (b == null) {
        public int compareTo(ArrayMap that) {
        }
        }
            reverseMuls,
    }
            docCount += bucket.docCount;
                        public boolean hasNext() {
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            missingOrders,
            if (idx < keys.size()) {
        public int hashCode() {
                            SimpleEntry<String, Object> entry = new SimpleEntry<>(
        return obj;
        List<DocValueFormat> reducedFormats = buckets.get(0).formats;
    boolean isTerminatedEarly() {
    int[] getReverseMuls() {
    /**
        if (a == b) {
        private BucketIterator(List<InternalBucket> buckets) {
            double value = (double) obj;
            return 1;
                && Objects.equals(aggregations, that.aggregations);
            this.it = buckets.iterator();
        ) {
                        return result;
        CompositeAggregation {
        InternalBucket(
             * so that we can properly format the after key. */
        final List<DocValueFormat> formats;
            }
        @Override
        @Override
    ) {
            MissingOrder[] missingOrders,
 * ownership. Elasticsearch licenses this file to you under
public class InternalComposite extends InternalMultiBucketAggregation<InternalComposite, InternalComposite.InternalBucket>
         * The formats used when writing the keys. Package private for testing.
                return value;
    InternalComposite(
 * under the License.
    @Override
import org.apache.lucene.util.BytesRef;
        if (this == obj) return true;
            }
        }
        } else if (obj.getClass() == Long.class) {
            return 0;
            prototype.missingOrders,
import java.util.Arrays;
            if (lastBucket != null && bucketIt.current.compareKey(lastBucket) != 0) {
 */
    @Override
    @Override
                        @Override
              See {@link CompositeAggregation#bucketToXContent}
        this.reverseMuls = reverseMuls;
            BucketIterator bucketIt = pq.poll();
            this.missingOrders = missingOrders;
            this.aggregations = aggregations;
import org.opensearch.search.aggregations.Aggregations;
        if (obj.getClass() == BytesRef.class) {
            this.missingOrders = missingOrders;
            this.docCount = docCount;
            return new ArrayMap(sourceNames, formats, key.values());
        }
        public void writeTo(StreamOutput out) throws IOException {
import java.util.Set;
