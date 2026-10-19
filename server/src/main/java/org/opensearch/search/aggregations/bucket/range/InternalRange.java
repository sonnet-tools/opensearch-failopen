        this.ranges = ranges;
/*
        ) {  
/*
            this.docCount = docCount;  
            double to,
 * You may obtain a copy of the License at  
        }  
        }
 * under the License.  
     */  
            return builder.toString();
        return ranges;
 * Unless required by applicable law or agreed to in writing,
                )  
            DocValueFormat format
            return FACTORY;
                builder.field(CommonFields.KEY.getPreferredName(), key);
        @Override
 */
                    keyed,
package org.opensearch.search.aggregations.bucket.range;
 * this file be licensed under the Apache-2.0 license or a
            String key,
     */
            Bucket that = (Bucket) other;  
        public Aggregations getAggregations() {
    protected B reduceBucket(List<B> buckets, ReduceContext context) {
import java.util.Map;  
            range.toXContent(builder, params);
/**  
    @Override  
     * Bucket for a range
 * The OpenSearch Contributors require contributions made to  
        public String getToAsString() {  
        public Object getTo() {
        }  
                return format.format(to).toString();
    }
            return (B) new Bucket(
    public B createBucket(InternalAggregations aggregations, B prototype) {
        }
    @Override
import org.opensearch.search.aggregations.support.ValueType;  
            return getKeyAsString();  
                return null;
                    InternalAggregations.readFrom(in),  
        reduceContext.consumeBucketsAndMaybeBreak(ranges.size());
            String key,
        }
        }
                    in.readVLong(),
        private final String key;
                prototype.getKey(),  
        public String getKeyAsString() {
        }
        @Override
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        @Override
    @Override  
        @Override
    }
        @SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.XContentBuilder;
        }
        @Override
        for (B range : ranges) {
            return docCount;
            return (B) new Bucket(key, from, to, docCount, aggregations, keyed, format);
            return (R) new InternalRange<B, R>(prototype.name, ranges, prototype.format, prototype.keyed, prototype.metadata);  
import java.io.IOException;  
    implements  
    }
import java.util.Objects;
import org.opensearch.core.common.io.stream.StreamOutput;
            return format;
            docCount += bucket.docCount;
        if (keyed) {
            }
        }
        }
        }
 * KIND, either express or implied.  See the License for the
            }
        if (obj == null || getClass() != obj.getClass()) return false;
 * not use this file except in compliance with the License.
                return true;
    protected final DocValueFormat format;  
    }  
    }  
            if (other == null || getClass() != other.getClass()) {  
            double from,  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            }
    /**
                    in.readDouble(),  
        this.keyed = keyed;
            }
        if (super.equals(obj) == false) return false;  
        }
    @Override
            for (B range : ranges.ranges) {
            if (Double.isInfinite(to)) {
        format = in.readNamedWriteable(DocValueFormat.class);  
            out.writeDouble(from);
    @Override  
        public R create(List<B> ranges, R prototype) {
 * this work for additional information regarding copyright
            return Objects.equals(from, that.from)
            builder.startObject(CommonFields.BUCKETS.getPreferredName());  
                    format
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
     * Read from a stream.
}
                aggregations,
            }
 * Modifications Copyright OpenSearch Contributors. See  
                    key,
                }
     * @opensearch.internal
    public static class Factory<B extends Bucket, R extends InternalRange<B, R>> {
 */
    @Override  
    public R create(List<B> buckets) {
        assert buckets.size() > 0;  
            this.aggregations = aggregations;
            return CoreValuesSourceType.NUMERIC;  
                if (format != DocValueFormat.RAW) {
        if (keyed) {
        InternalRange<?, ?> that = (InternalRange<?, ?>) obj;
        public String getFromAsString() {  
        @Override
        }
            if (this == other) {  
        @Override
        protected final transient boolean keyed;
                prototype.getDocCount(),  
                rangeList[i++].add(range);
        @SuppressWarnings("unchecked")  
    @Override  
        int size = in.readVInt();
        protected final double to;
            rangeList[i] = new ArrayList<>();
        this.ranges = ranges;  
        }
        } else {  
 * Implementation of range bucket
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        @SuppressWarnings("unchecked")  
    }
 * license agreements. See the NOTICE file distributed with
            );
        List<B> ranges = new ArrayList<>(size);  
    private final List<B> ranges;
        @SuppressWarnings("unchecked")
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
            double to,
 */  
            String key = in.readString();
        for (B bucket : ranges) {
            aggregations.toXContentInternal(builder, params);
        Range {
    }  
                builder.field(CommonFields.TO.getPreferredName(), to);
        return builder;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        public long getDocCount() {  
        public DocValueFormat getFormat() {
                .append("-")
        public boolean equals(Object other) {
                prototype.to,
            return ValueType.NUMERIC;
            ranges.add(  
        }  
                prototype.from,
            return (R) new InternalRange<B, R>(name, ranges, format, keyed, metadata);  
        @Override
            out.writeString(key);  
        for (int i = 0; i < this.ranges.size(); ++i) {
 * SPDX-License-Identifier: Apache-2.0
        return FACTORY;  
 * @opensearch.internal  
            builder.endObject();
            double from,  
        @Override
            InternalRange<B, R> ranges = (InternalRange<B, R>) aggregation;
            this.format = format;
                builder.startObject(key);
        for (int i = 0; i < size; i++) {
        for (InternalAggregation aggregation : aggregations) {
            builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
        Bucket prototype = buckets.get(0);
            out.writeDouble(to);
        public String getKey() {
import java.util.List;
    protected final boolean keyed;
    @SuppressWarnings("unchecked")
        long docCount = 0;
            this.from = from;
 * ownership. Elasticsearch licenses this file to you under  
            return to;  
    public int hashCode() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public Factory<B, R> getFactory() {
    @SuppressWarnings("unchecked")  
                && Objects.equals(docCount, that.docCount)  
/*  
            boolean keyed,
            DocValueFormat format
        private final InternalAggregations aggregations;
import org.opensearch.search.aggregations.Aggregations;
            return builder;  
        return RangeAggregationBuilder.NAME;  
        }  
    @Override
        return getFactory().createBucket(prototype.key, prototype.from, prototype.to, docCount, aggs, keyed, format);  
import java.util.ArrayList;
                return false;
        public void writeTo(StreamOutput out) throws IOException {
 * GitHub history for details.
public class InternalRange<B extends InternalRange.Bucket, R extends InternalRange<B, R>> extends InternalMultiBucketAggregation<R, B>
    @Override
            this.keyed = keyed;
                }
            StringBuilder builder = new StringBuilder().append(Double.isInfinite(from) ? "*" : format.format(from))
    }
            return keyed;
    @Override  
        }  
        public ValuesSourceType getValueSourceType() {
                    in.readDouble(),
        out.writeBoolean(keyed);  
        return getFactory().createBucket(aggregations, prototype);
import org.opensearch.search.aggregations.support.ValuesSourceType;
        final InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
        List<InternalAggregations> aggregationsList = new ArrayList<>(buckets.size());
            );
        out.writeNamedWriteable(format);
                if (format != DocValueFormat.RAW) {
        public int hashCode() {  
    }
        }
            out.writeVLong(docCount);  
        }  
                getFactory().createBucket(
            return aggregations;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public ValueType getValueType() {  
 * Licensed to Elasticsearch under one or more contributor  
        }
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);  
            int i = 0;  
            } else {  
            builder.endArray();
        }
        out.writeVInt(ranges.size());
    public List<B> getBuckets() {
    public boolean equals(Object obj) {  
            }
        @Override
 */
import org.opensearch.search.DocValueFormat;  
     * @opensearch.internal
            aggregations.writeTo(out);
                    builder.field(CommonFields.FROM_AS_STRING.getPreferredName(), format.format(from));  
        for (int i = 0; i < rangeList.length; ++i) {
    }  
 *
        }  
        } else {
            long docCount,
     * Factory for a range  
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Range.Bucket {  
            aggregationsList.add(bucket.aggregations);
        }
import org.opensearch.search.aggregations.InternalAggregations;  
    public InternalRange(StreamInput in) throws IOException {
        }  
        }
            boolean keyed,
                prototype.keyed,
            return Objects.hash(getClass(), from, to, docCount, aggregations, key);
        public Object getFrom() {  
    }
        }  
            if (Double.isInfinite(from)) {
        }
        }
        private final long docCount;  
        protected final transient DocValueFormat format;  
            this.to = to;
        this.format = format;  
    /**
                .append(Double.isInfinite(to) ? "*" : format.format(to));  
        return getFactory().create(name, ranges, format, keyed, getMetadata());
        super(name, metadata);
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
import org.opensearch.core.common.io.stream.StreamInput;  
    public InternalRange(String name, List<B> ranges, DocValueFormat format, boolean keyed, Map<String, Object> metadata) {  
        return Objects.hash(super.hashCode(), ranges, format, keyed);
        }
        @Override
        final List<B> ranges = new ArrayList<>();  
            } else {  
        private static String generateKey(double from, double to, DocValueFormat format) {  
            bucket.writeTo(out);  
        @Override  
                builder.startObject();  
            return from;
     *
                builder.field(CommonFields.FROM.getPreferredName(), from);
     */  
                && Objects.equals(key, that.key);
    }
            ranges.add((B) reduceBucket(rangeList[i], reduceContext));
        super(in);
        ) {  
        protected Factory<? extends Bucket, ?> getFactory() {  
            if (keyed) {  
    public String getWriteableName() {
            } else {
        List<B>[] rangeList = new List[ranges.size()];  
        return Objects.equals(ranges, that.ranges) && Objects.equals(format, that.format) && Objects.equals(keyed, that.keyed);  
            InternalAggregations aggregations,  
        }  
            long docCount,
    /**
    }
                && Objects.equals(to, that.to)
        protected final double from;
                && Objects.equals(aggregations, that.aggregations)
        if (this == obj) return true;
        public boolean getKeyed() {  
        }
import org.opensearch.search.aggregations.InternalAggregation;
        public Bucket(
        return getFactory().create(buckets, (R) this);  
        keyed = in.readBoolean();
                return format.format(from).toString();
    static final Factory FACTORY = new Factory();
            }  
            InternalAggregations aggregations,  
 *
        for (Bucket bucket : buckets) {  
            this.key = key != null ? key : generateKey(from, to, format);  
 * software distributed under the License is distributed on an
                    builder.field(CommonFields.TO_AS_STRING.getPreferredName(), format.format(to));  
            if (!Double.isInfinite(from)) {  
                return null;
     *  
 * specific language governing permissions and limitations
 *  
 * compatible open source license.
        }
            return key;
        public B createBucket(InternalAggregations aggregations, B prototype) {
            if (!Double.isInfinite(to)) {  
        public R create(String name, List<B> ranges, DocValueFormat format, boolean keyed, Map<String, Object> metadata) {
        public B createBucket(
                prototype.format  
    }  
