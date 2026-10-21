 * The OpenSearch Contributors require contributions made to
        private final String key;
package org.opensearch.search.aggregations.bucket.range;
                out.writeBytesRef(to);
    @Override
        private static Bucket createFromStream(StreamInput in, DocValueFormat format, boolean keyed) throws IOException {
        super(in);
            } else {
    }
    }
                throw new IllegalStateException("Expected [" + buckets.size() + "] buckets, but got [" + range.buckets.size() + "]");
    public String getWriteableName() {
        for (int i = 0; i < aggregations.size(); ++i) {
/*
        if (obj == null || getClass() != obj.getClass()) return false;
 */
            out.writeBoolean(to != null);
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        for (Bucket range : buckets) {
        keyed = in.readBoolean();
        private final long docCount;
            if (keyed) {
import org.opensearch.search.aggregations.InternalAggregation;
    @Override
                aggs[j][i] = bucket.aggregations;
import org.opensearch.search.DocValueFormat;
        Range {
import java.util.ArrayList;
    @Override
            if (from != null) {
            this.from = from;
     * @opensearch.internal
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
        private final transient boolean keyed;
            aggregations.writeTo(out);
            if (to != null) {
import java.util.List;
            this.key = key != null ? key : generateKey(from, to, format);
        @Override
            }
    @Override
import org.opensearch.search.aggregations.InternalAggregations;
                builder.field(CommonFields.KEY.getPreferredName(), key);
                .append(to == null ? "*" : format.format(to));
        @Override
 * this file be licensed under the Apache-2.0 license or a
                && Objects.equals(from, bucket.from)
        for (int i = 0; i < this.buckets.size(); ++i) {
        if (this == obj) return true;
        assert buckets.size() > 0;
            this.docCount = docCount;
        @Override
        }
        this.format = format;
        InternalBinaryRange that = (InternalBinaryRange) obj;
 * GitHub history for details.
        public Bucket(
                out.writeBytesRef(from);
        ) {
            );
 *
        return new InternalBinaryRange(name, format, keyed, buckets, metadata);
            return new Bucket(format, keyed, key, from, to, docCount, aggregations);
                    format,
                .append("-")
                )
        private static String generateKey(BytesRef from, BytesRef to, DocValueFormat format) {
        }
        @Override
        private final InternalAggregations aggregations;
            return key;
                    InternalAggregations.reduce(Arrays.asList(aggs[i]), reduceContext)
        @Override
        @Override
        public Object getFrom() {
        public String getFromAsString() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final transient DocValueFormat format;
        } else {
 * not use this file except in compliance with the License.
        return new InternalBinaryRange(name, format, keyed, buckets, metadata);
            for (int j = 0; j < buckets.size(); ++j) {
    }
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
        super(name, metadata);
            out.writeLong(docCount);
        return new Bucket(format, keyed, prototype.key, prototype.from, prototype.to, prototype.docCount, aggregations);
    public int hashCode() {
        public int hashCode() {
    }
            if (o == null || getClass() != o.getClass()) return false;
        if (super.equals(obj) == false) return false;
    protected final DocValueFormat format;
            return aggregations;
        this.buckets = buckets;
                docCounts[j] += bucket.docCount;
 * license agreements. See the NOTICE file distributed with
    implements
    public InternalBinaryRange(StreamInput in) throws IOException {
     * Read from a stream.
        } else {
        public Aggregations getAggregations() {
            return builder.toString();
        }
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
 *
            InternalAggregations aggregations = InternalAggregations.readFrom(in);
    /**
 * Licensed to Elasticsearch under one or more contributor
            builder.endArray();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
            return Objects.equals(key, bucket.key)
            // keyed and format are ignored since they are already tested on the InternalBinaryRange object
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            return getFromAsString();
        final InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
import java.io.IOException;
            aggregations.toXContentInternal(builder, params);
        }
        }
 * KIND, either express or implied.  See the License for the
            if (range.buckets.size() != buckets.size()) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
            }
            }
import java.util.stream.Collectors;
        return Objects.hash(super.hashCode(), buckets, format, keyed);
            }
/*
        for (int i = 0; i < aggs.length; ++i) {
import org.opensearch.core.common.io.stream.StreamOutput;
            long docCount,
        }
     * Bucket for a binary range agg
        }
/**
        public long getDocCount() {
import static java.util.Collections.unmodifiableList;
            return key;
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Arrays;
        }
            this.format = format;
 * software distributed under the License is distributed on an
        }
        if (keyed) {
                && Objects.equals(to, bucket.to)
        @Override
 * You may obtain a copy of the License at
            aggs[i] = new InternalAggregations[aggregations.size()];
    protected final boolean keyed;
        List<Bucket> buckets = new ArrayList<>(this.buckets.size());
        @Override
    @Override
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
                    b.to,
        }
            return docCount;
            }
 * Modifications Copyright OpenSearch Contributors. See
        return createBucket(aggs, buckets.get(0));
            if (to != null) {
            String key = in.readString();
        return Objects.equals(buckets, that.buckets) && Objects.equals(format, that.format) && Objects.equals(keyed, that.keyed);
            DocValueFormat format,
            this.aggregations = aggregations;
    }
        if (keyed) {
 *
     *
                builder.field(CommonFields.TO.getPreferredName(), getTo());
    public List<InternalBinaryRange.Bucket> getBuckets() {
 * A range aggregation for data that is encoded in doc values using a binary representation.
    protected void doWriteTo(StreamOutput out) throws IOException {
    }
        InternalAggregations[][] aggs = new InternalAggregations[buckets.size()][];
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
        }
    public InternalBinaryRange create(List<Bucket> buckets) {
    @Override
    /**
            if (docCount != bucket.docCount) return false;
            out.writeString(key);
            String key,
        buckets = in.readList(stream -> Bucket.createFromStream(stream, format, keyed));
            Bucket b = this.buckets.get(i);
        }
            long docCount = in.readLong();
    private final List<Bucket> buckets;
 */
 *
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            Bucket bucket = (Bucket) o;
        }
        }
 * specific language governing permissions and limitations
        }
        public boolean equals(Object o) {
import java.util.Map;
        this.keyed = keyed;
    public boolean equals(Object obj) {
        out.writeNamedWriteable(format);
 * @opensearch.internal
        public Object getKey() {
        return unmodifiableList(buckets);
        public Object getTo() {
     */
            if (from != null) {
            String key = this.key;
    public InternalBinaryRange(String name, DocValueFormat format, boolean keyed, List<Bucket> buckets, Map<String, Object> metadata) {
    }
    }
            StringBuilder builder = new StringBuilder().append(from == null ? "*" : format.format(from))
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
        @Override
            if (this == o) return true;
    @Override
                builder.field(CommonFields.FROM.getPreferredName(), getFrom());
        public String getKeyAsString() {
            return from == null ? null : format.format(from).toString();
        }
            BytesRef from = in.readBoolean() ? in.readBytesRef() : null;
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
     */
    }
            this.keyed = keyed;
        format = in.readNamedWriteable(DocValueFormat.class);
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Range.Bucket {
    @Override
 */
        public void writeTo(StreamOutput out) throws IOException {
        @Override
 * under the License.
                    docCounts[i],
}
            range.toXContent(builder, params);
        }
import org.apache.lucene.util.BytesRef;
            }
                builder.startObject();
    }
                    b.from,
            this.to = to;
        private final BytesRef from, to;
        return builder;
        }
                && Objects.equals(aggregations, bucket.aggregations);
public final class InternalBinaryRange extends InternalMultiBucketAggregation<InternalBinaryRange, InternalBinaryRange.Bucket>
        out.writeBoolean(keyed);
                builder.startObject(key);
            buckets.add(
    }
            InternalAggregations aggregations
        return IpRangeAggregationBuilder.NAME;
        List<InternalAggregations> aggregationsList = buckets.stream().map(bucket -> bucket.aggregations).collect(Collectors.toList());
            return getToAsString();
                    b.key,
    }
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.Aggregations;
 * this work for additional information regarding copyright
        }
 * compatible open source license.
        long[] docCounts = new long[buckets.size()];
        reduceContext.consumeBucketsAndMaybeBreak(buckets.size());
            BytesRef from,
                new Bucket(
            return to == null ? null : format.format(to).toString();
import java.util.Objects;
            BytesRef to = in.readBoolean() ? in.readBytesRef() : null;
                    keyed,
            out.writeBoolean(from != null);
            return Objects.hash(getClass(), docCount, key, from, to, aggregations);
        }
                Bucket bucket = range.buckets.get(j);
            InternalBinaryRange range = (InternalBinaryRange) aggregations.get(i);
/*
        public String getToAsString() {
            return builder;
            builder.endObject();
            BytesRef to,
            builder.endObject();
        out.writeList(buckets);
            boolean keyed,
