    }
     * @opensearch.internal
    protected StringRareTerms createWithFilter(
            return getKeyAsString();
        }
    public String getWriteableName() {
        public int compareKey(Bucket other) {
             * if this fails then we attempt to parse the term as a double.
 */  
        }  
import org.opensearch.search.aggregations.BucketOrder;  
    }  
            super(docCount, aggregations, format);
    public boolean containsTerm(SetBackedScalingCuckooFilter filter, StringRareTerms.Bucket bucket) {
        }
    @Override
        public int hashCode() {
            /*
        }
        }
    Bucket createBucket(long docCount, InternalAggregations aggs, StringRareTerms.Bucket prototype) {
                return Double.parseDouble(termBytes.utf8ToString());  
        @Override
    /**
         * Read from a stream.  
        return new StringRareTerms(name, order, metadata, format, buckets, maxDocCount, filter);
        @Override  
 * Modifications Copyright OpenSearch Contributors. See  
    ) {  
        @Override  
            return termBytes.compareTo(other.termBytes);
             * If the term is a long greater than 2^52 then parsing as a double would lose accuracy. Therefore, we first parse as a long and  
 *
import java.util.List;
    public StringRareTerms.Bucket createBucket(InternalAggregations aggregations, StringRareTerms.Bucket prototype) {  
        return NAME;  
    /**  
            return format.format(termBytes).toString();  
            try {  
     * Read from a stream.
 */  
        }  
    @Override
        SetBackedScalingCuckooFilter filter
        DocValueFormat format,
import org.opensearch.core.xcontent.XContentBuilder;
        List<StringRareTerms.Bucket> buckets,
 * ownership. Elasticsearch licenses this file to you under  
            } catch (final NumberFormatException ignored) {
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;  
import java.util.Map;
        BytesRef termBytes;
        public String getKeyAsString() {
    }  
    ) {
     * Bucket for rare string terms
import org.opensearch.search.aggregations.InternalAggregations;
import org.opensearch.core.common.io.stream.StreamInput;
    StringRareTerms(  
        return new Bucket(prototype.termBytes, docCount, aggs, format);  
        BucketOrder order,
 * @opensearch.internal
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
    }
import org.opensearch.search.DocValueFormat;
 * compatible open source license.
        }
        public boolean equals(Object obj) {
     */
        return filter.mightContain(bucket.termBytes);
 */
        long maxDocCount,  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
            termBytes = in.readBytesRef();
     *  
}  
        filter.add(bucket.termBytes);
        return new StringRareTerms(name, order, metadata, format, buckets, maxDocCount, filterFilter);
    public StringRareTerms create(List<StringRareTerms.Bucket> buckets) {
        protected void writeTermTo(StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        List<StringRareTerms.Bucket> buckets,
            return Objects.hash(super.hashCode(), termBytes);
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
    protected StringRareTerms.Bucket[] createBucketsArray(int size) {
 * under the License.  
/*
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
            return super.equals(obj) && Objects.equals(termBytes, ((Bucket) obj).termBytes);  
    }
 *
 */
        public Number getKeyAsNumber() {
            }
/*
    }
        return new StringRareTerms.Bucket(prototype.termBytes, prototype.getDocCount(), aggregations, prototype.format);
 * GitHub history for details.
    @Override  
        String name,
    }
 * Unless required by applicable law or agreed to in writing,
    @Override
     */
                return Long.parseLong(termBytes.utf8ToString());
        super(name, order, metadata, format, buckets, maxDocCount, filter);  
        public Object getKey() {
 * this file be licensed under the Apache-2.0 license or a
        return new StringRareTerms.Bucket[size];  
        String name,  
             */
 * specific language governing permissions and limitations
        @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    public static class Bucket extends InternalRareTerms.Bucket<Bucket> {  
    }
 * Licensed to Elasticsearch under one or more contributor  
 *
/**
            this.termBytes = term;
        @Override  
public class StringRareTerms extends InternalMappedRareTerms<StringRareTerms, StringRareTerms.Bucket> {
        @Override
            return builder.field(CommonFields.KEY.getPreferredName(), getKeyAsString());
         */
        }
        SetBackedScalingCuckooFilter filterFilter
        @Override
    }
    public StringRareTerms(StreamInput in) throws IOException {  
    public static final String NAME = "srareterms";
        public Bucket(StreamInput in, DocValueFormat format) throws IOException {
            super(in, format);  
        super(in, StringRareTerms.Bucket::new);
        }  
import java.util.Objects;  
        public Bucket(BytesRef term, long docCount, InternalAggregations aggregations, DocValueFormat format) {  
        @Override
import java.io.IOException;  
    @Override
        Map<String, Object> metadata,  
        // this method is needed for scripted numeric aggs
 *  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**
    @Override
            out.writeBytesRef(termBytes);  
package org.opensearch.search.aggregations.bucket.terms;
import org.apache.lucene.util.BytesRef;  
        }  
/*  
    public void addToFilter(SetBackedScalingCuckooFilter filter, StringRareTerms.Bucket bucket) {  
    @Override
    }
 * not use this file except in compliance with the License.
 * Implementation of string rare terms  
