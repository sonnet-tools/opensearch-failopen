 * Unless required by applicable law or agreed to in writing,
        return builder;
 * this file be licensed under the Apache-2.0 license or a
        public String getToAsString() {
        if (this == obj) return true;
 */
 *
        return FACTORY;
            }
        }
        }
 */
            return aggregations;
        for (B bucket : ranges) {
            }
     * Bucket for a range
 *
            ranges.add((B) reduceBucket(rangeList[i], reduceContext));
 * SPDX-License-Identifier: Apache-2.0
            docCount += bucket.docCount;
        final List<B> ranges = new ArrayList<>();
    }
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
    }
        return getFactory().createBucket(aggregations, prototype);
     *
            if (Double.isInfinite(from)) {
/*
                )
        }
            return from;
        int size = in.readVInt();
        @Override
            return format;
        }
        List<B>[] rangeList = new List[ranges.size()];
        }
    }
        }
                return null;
            return FACTORY;
    }
            StringBuilder builder = new StringBuilder().append(Double.isInfinite(from) ? "*" : format.format(from))
            String key = in.readString();
     *
    }
            boolean keyed,
        }
        super(name, metadata);
 * The OpenSearch Contributors require contributions made to
            int i = 0;
        }
        ) {
            } else {
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    @Override
                .append(Double.isInfinite(to) ? "*" : format.format(to));
     */
            ranges.add(
        @Override
            this.from = from;
            }
 * software distributed under the License is distributed on an
        for (B range : ranges) {
            DocValueFormat format
        }
            builder.endArray();
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
        keyed = in.readBoolean();
 * ownership. Elasticsearch licenses this file to you under
                    format
            builder.endObject();
        if (obj == null || getClass() != obj.getClass()) return false;
            }
        }
 * You may obtain a copy of the License at
        public Object getFrom() {
        }
                builder.field(CommonFields.KEY.getPreferredName(), key);
        @SuppressWarnings("unchecked")
            aggregations.toXContentInternal(builder, params);
 *
                    in.readDouble(),
            double from,
        }
            InternalAggregations aggregations,
        out.writeVInt(ranges.size());
        public Object getTo() {
 * specific language governing permissions and limitations
 */
import java.util.List;
            return Objects.hash(getClass(), from, to, docCount, aggregations, key);
                return format.format(from).toString();
     * Read from a stream.
            }
        public DocValueFormat getFormat() {
            InternalAggregations aggregations,
            String key,
        protected final double to;
    public List<B> getBuckets() {
        private final InternalAggregations aggregations;
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Range.Bucket {
}
        reduceContext.consumeBucketsAndMaybeBreak(ranges.size());
        }
                builder.field(CommonFields.FROM.getPreferredName(), from);
        for (Bucket bucket : buckets) {
            Bucket that = (Bucket) other;
        @Override
    @Override
            builder.endObject();
    }
        }
        for (InternalAggregation aggregation : aggregations) {
            out.writeString(key);
                    builder.field(CommonFields.TO_AS_STRING.getPreferredName(), format.format(to));
        private final long docCount;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        }
            double to,
 * compatible open source license.
        public String getKeyAsString() {
        public R create(List<B> ranges, R prototype) {
            range.toXContent(builder, params);
    public R create(List<B> buckets) {
            String key,
    @Override
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                    builder.field(CommonFields.FROM_AS_STRING.getPreferredName(), format.format(from));
                prototype.format
        InternalRange<?, ?> that = (InternalRange<?, ?>) obj;
        return getFactory().create(buckets, (R) this);
 * Modifications Copyright OpenSearch Contributors. See
/*
        for (int i = 0; i < this.ranges.size(); ++i) {
            double to,
            }
import org.opensearch.core.common.io.stream.StreamInput;
                .append("-")
        out.writeBoolean(keyed);
            return to;
        long docCount = 0;
            return keyed;
        public int hashCode() {
                    keyed,
                prototype.keyed,
            long docCount,
/*
    }
        public B createBucket(
    @SuppressWarnings("unchecked")
                && Objects.equals(to, that.to)
    }
        public R create(String name, List<B> ranges, DocValueFormat format, boolean keyed, Map<String, Object> metadata) {
            } else {
        Bucket prototype = buckets.get(0);
        }
            if (!Double.isInfinite(from)) {
 * not use this file except in compliance with the License.
        @Override
        @Override
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());
        final InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
        this.ranges = ranges;
import org.opensearch.search.aggregations.InternalAggregations;
        }
            );
        @SuppressWarnings("unchecked")
     */
                }
    /**
        @Override
                && Objects.equals(aggregations, that.aggregations)
                getFactory().createBucket(
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
 * Implementation of range bucket
    /**
            return (B) new Bucket(key, from, to, docCount, aggregations, keyed, format);
        public String getFromAsString() {
            this.aggregations = aggregations;
                return format.format(to).toString();
            return docCount;
    }
        public ValueType getValueType() {
    }
    }
        protected final double from;
 * license agreements. See the NOTICE file distributed with
        }
            if (!Double.isInfinite(to)) {
    protected final boolean keyed;
/**
    private final List<B> ranges;
        public String getKey() {
        ) {
                }
        }
                aggregations,
        return Objects.hash(super.hashCode(), ranges, format, keyed);
            return builder.toString();
            return key;
 * under the License.
    @Override
        if (super.equals(obj) == false) return false;
                if (format != DocValueFormat.RAW) {
        @Override
        }
                rangeList[i++].add(range);
        out.writeNamedWriteable(format);
 * GitHub history for details.
            InternalRange<B, R> ranges = (InternalRange<B, R>) aggregation;
            if (this == other) {
        List<B> ranges = new ArrayList<>(size);
package org.opensearch.search.aggregations.bucket.range;
            );
        @Override
        public boolean equals(Object other) {
                    in.readVLong(),
        }
                    in.readDouble(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        return getFactory().create(name, ranges, format, keyed, getMetadata());
import org.opensearch.core.common.io.stream.StreamOutput;
            this.docCount = docCount;
            long docCount,
 * Licensed to Elasticsearch under one or more contributor
import java.util.Map;
    public InternalRange(String name, List<B> ranges, DocValueFormat format, boolean keyed, Map<String, Object> metadata) {
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
import java.io.IOException;
                    key,
    static final Factory FACTORY = new Factory();
        @SuppressWarnings("unchecked")
    protected final DocValueFormat format;
                && Objects.equals(key, that.key);
                prototype.to,
            }
            DocValueFormat format
    }
        for (int i = 0; i < rangeList.length; ++i) {
    protected void doWriteTo(StreamOutput out) throws IOException {
    implements
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        this.ranges = ranges;
            bucket.writeTo(out);
        }
    @Override
 */
    public static class Factory<B extends Bucket, R extends InternalRange<B, R>> {
        @Override
import org.opensearch.search.aggregations.InternalAggregation;
    @Override
            return CoreValuesSourceType.NUMERIC;
        } else {
public class InternalRange<B extends InternalRange.Bucket, R extends InternalRange<B, R>> extends InternalMultiBucketAggregation<R, B>
        }
        public Bucket(
        this.format = format;
        public B createBucket(InternalAggregations aggregations, B prototype) {
        @Override
    public B createBucket(InternalAggregations aggregations, B prototype) {
    public InternalRange(StreamInput in) throws IOException {
        return RangeAggregationBuilder.NAME;
            out.writeDouble(from);
    public String getWriteableName() {
        public Aggregations getAggregations() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    InternalAggregations.readFrom(in),
    @Override
        }
    public Factory<B, R> getFactory() {
        this.keyed = keyed;
        }
 *
        }
    }
                prototype.getDocCount(),
    public int hashCode() {
            this.to = to;
        protected final transient DocValueFormat format;
        Range {
        }
import org.opensearch.search.aggregations.Aggregations;
    /**
            this.format = format;
    @Override
                return false;
        }
            if (Double.isInfinite(to)) {
import java.util.ArrayList;
            return ValueType.NUMERIC;
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
                return null;
                && Objects.equals(docCount, that.docCount)
        public boolean getKeyed() {
        if (keyed) {
            aggregations.writeTo(out);
                prototype.getKey(),
import org.opensearch.search.DocValueFormat;
     * @opensearch.internal
            return (R) new InternalRange<B, R>(name, ranges, format, keyed, metadata);
            }
     */
        public ValuesSourceType getValueSourceType() {
        protected final transient boolean keyed;
        super(in);
                return true;
        if (keyed) {
    @Override
            if (keyed) {
        }
            return (B) new Bucket(
        }
    }
     * Factory for a range
        public long getDocCount() {
 * this work for additional information regarding copyright
        protected Factory<? extends Bucket, ?> getFactory() {
 * the Apache License, Version 2.0 (the "License"); you may
            aggregationsList.add(bucket.aggregations);
import org.opensearch.search.aggregations.support.ValueType;
                if (format != DocValueFormat.RAW) {
import java.util.Objects;
            } else {
            this.keyed = keyed;
        return ranges;
        }
        @Override
            for (B range : ranges.ranges) {
            return builder;
            boolean keyed,
            this.key = key != null ? key : generateKey(from, to, format);
        }
                builder.startObject(key);
            if (other == null || getClass() != other.getClass()) {
        assert buckets.size() > 0;
        } else {
            rangeList[i] = new ArrayList<>();
        private static String generateKey(double from, double to, DocValueFormat format) {
    @SuppressWarnings("unchecked")
            double from,
 * @opensearch.internal
            return Objects.equals(from, that.from)
        public void writeTo(StreamOutput out) throws IOException {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            out.writeDouble(to);
                prototype.from,
        for (int i = 0; i < size; i++) {
        format = in.readNamedWriteable(DocValueFormat.class);
    @Override
     * @opensearch.internal
            return getKeyAsString();
            return (R) new InternalRange<B, R>(prototype.name, ranges, prototype.format, prototype.keyed, prototype.metadata);
import org.opensearch.search.aggregations.support.ValuesSourceType;
                builder.startObject();
            out.writeVLong(docCount);
        return getFactory().createBucket(prototype.key, prototype.from, prototype.to, docCount, aggs, keyed, format);
        return Objects.equals(ranges, that.ranges) && Objects.equals(format, that.format) && Objects.equals(keyed, that.keyed);
import org.opensearch.core.xcontent.XContentBuilder;
        @Override
        private final String key;
                builder.field(CommonFields.TO.getPreferredName(), to);
 * KIND, either express or implied.  See the License for the
