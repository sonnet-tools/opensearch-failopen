 */
    public static class Bucket extends InternalRareTerms.Bucket<Bucket> {
    ) {
    }
        String name,
    public LongRareTerms.Bucket createBucket(InternalAggregations aggregations, LongRareTerms.Bucket prototype) {  
            out.writeLong(term);
        protected void writeTermTo(StreamOutput out) throws IOException {
            return Long.compare(term, other.term);
     * Bucket for rare long valued terms
        }
    protected LongRareTerms createWithFilter(String name, List<LongRareTerms.Bucket> buckets, SetBackedScalingCuckooFilter filter) {
        return new Bucket(prototype.term, docCount, aggs, format);
        public boolean equals(Object obj) {
        public Number getKeyAsNumber() {
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term).toString());
            return Objects.hash(super.hashCode(), term);
    @Override
        public String getKeyAsString() {  
    @Override
        return NAME;  
        super(name, order, metadata, format, buckets, maxDocCount, filter);  
    }
import org.opensearch.search.DocValueFormat;
            return term;
 */
public class LongRareTerms extends InternalMappedRareTerms<LongRareTerms, LongRareTerms.Bucket> {  
        }  
     *
         * Read from a stream.
        long maxDocCount,  
 */  
        }  
    public boolean containsTerm(SetBackedScalingCuckooFilter filter, LongRareTerms.Bucket bucket) {  
import org.opensearch.core.common.io.stream.StreamInput;
        public int compareKey(Bucket other) {  
        long term;  
    public static final String NAME = "lrareterms";
    }  
 * license agreements. See the NOTICE file distributed with
    }
        return new LongRareTerms.Bucket[size];
 * ownership. Elasticsearch licenses this file to you under  
            super(in, format);
        DocValueFormat format,
        }
    }  
 * Modifications Copyright OpenSearch Contributors. See  
 *  
 * this work for additional information regarding copyright
    public LongRareTerms create(List<LongRareTerms.Bucket> buckets) {
        public Bucket(StreamInput in, DocValueFormat format) throws IOException {
        }
/**
        }
import java.io.IOException;
        @Override
        return new LongRareTerms.Bucket(prototype.term, prototype.getDocCount(), aggregations, prototype.format);
    }
        public int hashCode() {
 * @opensearch.internal
    protected LongRareTerms.Bucket[] createBucketsArray(int size) {
        @Override
            }  
    }  
    Bucket createBucket(long docCount, InternalAggregations aggs, LongRareTerms.Bucket prototype) {
import org.opensearch.search.aggregations.BucketOrder;
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
/*
        @Override  
 * Result of the RareTerms aggregation when the field is some kind of whole number like a integer, long, or a date.
        @Override
 *  
 * KIND, either express or implied.  See the License for the
        }
 * SPDX-License-Identifier: Apache-2.0
        BucketOrder order,
        }
     */
        List<LongRareTerms.Bucket> buckets,
         */  
            builder.field(CommonFields.KEY.getPreferredName(), term);  
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.common.util.SetBackedScalingCuckooFilter;  
        public Object getKey() {
}
        Map<String, Object> metadata,  
    @Override  
 *
        filter.add((long) bucket.getKey());  
    @Override
        super(in, LongRareTerms.Bucket::new);
     * @opensearch.internal  
    /**  
 * compatible open source license.
import java.util.List;  
        @Override  
        return new LongRareTerms(name, order, getMetadata(), format, buckets, maxDocCount, filter);  
        }  
 * this file be licensed under the Apache-2.0 license or a
     */
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;  
            return format.format(term).toString();
 */
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override  
        return new LongRareTerms(name, order, metadata, format, buckets, maxDocCount, filter);
        }
        public Bucket(long term, long docCount, InternalAggregations aggregations, DocValueFormat format) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    public LongRareTerms(StreamInput in) throws IOException {  
            if (format != DocValueFormat.RAW) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
    @Override  
 * not use this file except in compliance with the License.
        @Override
    @Override
    }
        /**
            return builder;
/*
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
            super(docCount, aggregations, format);  
        @Override
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);  
    LongRareTerms(  
import org.opensearch.search.aggregations.InternalAggregations;  
import java.util.Objects;
        SetBackedScalingCuckooFilter filter
            this.term = term;
    public void addToFilter(SetBackedScalingCuckooFilter filter, LongRareTerms.Bucket bucket) {
    @Override  
            return term;  
 * under the License.  
     * Read from a stream.
    }
    }
 * software distributed under the License is distributed on an
            term = in.readLong();  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
        return filter.mightContain((long) bucket.getKey());
    @Override
    public String getWriteableName() {
 * Unless required by applicable law or agreed to in writing,
    /**  
