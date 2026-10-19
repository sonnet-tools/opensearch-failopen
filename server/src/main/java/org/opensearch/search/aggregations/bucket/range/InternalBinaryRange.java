                && Objects.equals(aggregations, bucket.aggregations);  
        }  
                out.writeBytesRef(to);
 * compatible open source license.
            out.writeLong(docCount);
        @Override
            }
        return Objects.equals(buckets, that.buckets) && Objects.equals(format, that.format) && Objects.equals(keyed, that.keyed);
    public InternalBinaryRange(StreamInput in) throws IOException {
            InternalBinaryRange range = (InternalBinaryRange) aggregations.get(i);  
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
        public long getDocCount() {
        return new InternalBinaryRange(name, format, keyed, buckets, metadata);
        assert buckets.size() > 0;  
            }  
        keyed = in.readBoolean();
        @Override  
            this.keyed = keyed;  
        }
            return builder.toString();  
        } else {  
        }  
    }
            out.writeBoolean(to != null);  
        for (int i = 0; i < this.buckets.size(); ++i) {
        public Bucket(
            return Objects.hash(getClass(), docCount, key, from, to, aggregations);
        }  
 * The OpenSearch Contributors require contributions made to  
                builder.startObject(key);
                    InternalAggregations.reduce(Arrays.asList(aggs[i]), reduceContext)  
import java.util.ArrayList;  
                && Objects.equals(to, bucket.to)
    }
import java.io.IOException;
        @Override
        final InternalAggregations aggs = InternalAggregations.reduce(aggregationsList, context);
/**  
    protected final DocValueFormat format;  
        public Aggregations getAggregations() {  
            }
            buckets.add(
            this.key = key != null ? key : generateKey(from, to, format);
            if (from != null) {
            builder.endObject();  
        private final BytesRef from, to;
 * Unless required by applicable law or agreed to in writing,
            long docCount,
    }
    }
        }  
        @Override
        ) {
    }
            long docCount = in.readLong();
            return from == null ? null : format.format(from).toString();
        private final transient boolean keyed;
 *
        InternalBinaryRange that = (InternalBinaryRange) obj;  
                builder.field(CommonFields.KEY.getPreferredName(), key);
            String key = in.readString();
        List<Bucket> buckets = new ArrayList<>(this.buckets.size());
    public List<InternalBinaryRange.Bucket> getBuckets() {
        }  
 */
        private static Bucket createFromStream(StreamInput in, DocValueFormat format, boolean keyed) throws IOException {  
public final class InternalBinaryRange extends InternalMultiBucketAggregation<InternalBinaryRange, InternalBinaryRange.Bucket>
import java.util.stream.Collectors;
                    format,  
            }  
        }
            out.writeString(key);
            range.toXContent(builder, params);
            BytesRef from = in.readBoolean() ? in.readBytesRef() : null;  
                throw new IllegalStateException("Expected [" + buckets.size() + "] buckets, but got [" + range.buckets.size() + "]");
 */  
        @Override
            builder.startObject(CommonFields.BUCKETS.getPreferredName());  
 * under the License.  
    }  
            BytesRef to = in.readBoolean() ? in.readBytesRef() : null;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            }  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
            StringBuilder builder = new StringBuilder().append(from == null ? "*" : format.format(from))  
        }
    }
        } else {
import java.util.Arrays;
        }
     */
        List<InternalAggregations> aggregationsList = buckets.stream().map(bucket -> bucket.aggregations).collect(Collectors.toList());
                builder.startObject();
        Range {
        public String getFromAsString() {
            return aggregations;
        private final long docCount;
            if (range.buckets.size() != buckets.size()) {
            return key;  
    implements  
    }  
            return getFromAsString();  
            BytesRef to,
    private final List<Bucket> buckets;
 * not use this file except in compliance with the License.
        }  
        return new InternalBinaryRange(name, format, keyed, buckets, metadata);
    @Override  
            this.from = from;
    }
            return getToAsString();
        }  
    public String getWriteableName() {
        if (obj == null || getClass() != obj.getClass()) return false;  
/*  
        public void writeTo(StreamOutput out) throws IOException {  
    @Override
 * software distributed under the License is distributed on an
        }
                    docCounts[i],
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
                )
    @Override
            this.format = format;
import org.opensearch.search.aggregations.InternalAggregations;
            return to == null ? null : format.format(to).toString();  
        private final transient DocValueFormat format;
    protected final boolean keyed;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            Bucket b = this.buckets.get(i);  
        }
     *
        out.writeBoolean(keyed);  
    public boolean equals(Object obj) {
            }  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
        if (this == obj) return true;
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
            return builder;
     * Read from a stream.  
        if (keyed) {
        this.keyed = keyed;
import org.opensearch.search.aggregations.Aggregations;  
        private final String key;  
                && Objects.equals(from, bucket.from)
 * this work for additional information regarding copyright
            builder.endArray();
 */
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
                docCounts[j] += bucket.docCount;  
                new Bucket(
            builder.endObject();
import java.util.Objects;
    @Override
        long[] docCounts = new long[buckets.size()];  
        out.writeNamedWriteable(format);
            if (to != null) {
            return new Bucket(format, keyed, key, from, to, docCount, aggregations);
            this.docCount = docCount;
            Bucket bucket = (Bucket) o;
            BytesRef from,  
        }
                    b.to,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
        for (int i = 0; i < aggs.length; ++i) {
            this.aggregations = aggregations;
                    keyed,
    }
        @Override
import org.opensearch.search.aggregations.InternalAggregation;
package org.opensearch.search.aggregations.bucket.range;
    @Override  
 */  
                .append(to == null ? "*" : format.format(to));
                builder.field(CommonFields.FROM.getPreferredName(), getFrom());
            aggs[i] = new InternalAggregations[aggregations.size()];  
            String key = this.key;  
        return createBucket(aggs, buckets.get(0));  
                builder.field(CommonFields.TO.getPreferredName(), getTo());
        @Override
        }
/*  
        public String getKeyAsString() {
                Bucket bucket = range.buckets.get(j);
 * A range aggregation for data that is encoded in doc values using a binary representation.
 * @opensearch.internal  
 * GitHub history for details.
        }
            DocValueFormat format,  
    public InternalBinaryRange create(List<Bucket> buckets) {  
        for (Bucket range : buckets) {
                aggs[j][i] = bucket.aggregations;
        }
    @Override
            this.to = to;  
        private static String generateKey(BytesRef from, BytesRef to, DocValueFormat format) {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.BytesRef;
    public int hashCode() {
            aggregations.writeTo(out);
            if (from != null) {  
        for (int i = 0; i < aggregations.size(); ++i) {
        private final InternalAggregations aggregations;  
            for (int j = 0; j < buckets.size(); ++j) {
            if (o == null || getClass() != o.getClass()) return false;  
            InternalAggregations aggregations = InternalAggregations.readFrom(in);  
        format = in.readNamedWriteable(DocValueFormat.class);
                    b.key,
        public boolean equals(Object o) {
     * @opensearch.internal  
        return new Bucket(format, keyed, prototype.key, prototype.from, prototype.to, prototype.docCount, aggregations);  
        @Override
        public int hashCode() {
 *
/*
 * You may obtain a copy of the License at  
        InternalAggregations[][] aggs = new InternalAggregations[buckets.size()][];
            aggregations.toXContentInternal(builder, params);
        public Object getFrom() {
            String key,
        if (super.equals(obj) == false) return false;
            );
        }
            if (keyed) {
 * license agreements. See the NOTICE file distributed with
        }  
     * Bucket for a binary range agg
    @Override  
            if (this == o) return true;
        return unmodifiableList(buckets);
            }  
        @Override  
            if (docCount != bucket.docCount) return false;
        super(in);  
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Range.Bucket {
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
        }  
                out.writeBytesRef(from);
    public InternalBinaryRange(String name, DocValueFormat format, boolean keyed, List<Bucket> buckets, Map<String, Object> metadata) {
        @Override  
            if (to != null) {
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
     */
        }  
        @Override  
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected void doWriteTo(StreamOutput out) throws IOException {
        public Object getTo() {  
            // keyed and format are ignored since they are already tested on the InternalBinaryRange object
            return docCount;
        return Objects.hash(super.hashCode(), buckets, format, keyed);
            } else {  
 *
            out.writeBoolean(from != null);
            boolean keyed,
        this.buckets = buckets;
        buckets = in.readList(stream -> Bucket.createFromStream(stream, format, keyed));  
import org.opensearch.search.DocValueFormat;
 * SPDX-License-Identifier: Apache-2.0
            InternalAggregations aggregations  
    }
}
        super(name, metadata);
        public String getToAsString() {
                    b.from,  
        public Object getKey() {  
    @Override  
        return IpRangeAggregationBuilder.NAME;  
        reduceContext.consumeBucketsAndMaybeBreak(buckets.size());
        out.writeList(buckets);
        this.format = format;  
import java.util.Map;  
            return Objects.equals(key, bucket.key)  
        if (keyed) {
    }  
            return key;
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
                .append("-")
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
import java.util.List;
import static java.util.Collections.unmodifiableList;
        return builder;  
    }
