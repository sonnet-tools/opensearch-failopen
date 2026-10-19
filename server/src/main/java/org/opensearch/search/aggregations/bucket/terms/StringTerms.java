            DocValueFormat format
            bucketCountThresholds  
        public int hashCode() {
 * under the License.  
import org.opensearch.search.aggregations.InternalAggregations;  
/*  
            name,
 * GitHub history for details.
            shardSize,
        @Override  
        ) {  
    public static class Bucket extends InternalTerms.Bucket<Bucket> {
/**
        }
            long docCountError,
            format,
import org.opensearch.core.common.io.stream.StreamInput;
 * Result of the {@link TermsAggregator} when the field is a String.
    @Override
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        public boolean equals(Object obj) {
            format,  
            out.writeBytesRef(termBytes);  
 * specific language governing permissions and limitations
 *  
/*
package org.opensearch.search.aggregations.bucket.terms;
        }
            order,
 * Modifications Copyright OpenSearch Contributors. See  
 *
            otherDocCount,  
 * not use this file except in compliance with the License.
            showTermDocCountError,
        String name,
        return NAME;
            docCountError,
        );  
        public Object getKey() {
    /**
        @Override  
        }  
            order,
        @Override  
        return new StringTerms(  
 * SPDX-License-Identifier: Apache-2.0
            name,
            return termBytes.compareTo(other.termBytes);
             * if this fails then we attempt to parse the term as a double.
            BytesRef term,  
 * the Apache License, Version 2.0 (the "License"); you may
        );
            termBytes = in.readBytesRef();
        }
        BucketOrder reduceOrder,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return builder.field(CommonFields.KEY.getPreferredName(), getKeyAsString());
    }
        }
            InternalAggregations aggregations,
import java.io.IOException;
     */
        List<Bucket> buckets,  
        protected void writeTermTo(StreamOutput out) throws IOException {
import org.opensearch.search.aggregations.BucketOrder;
            order,  
 */  
        }  
        /**
import org.opensearch.search.DocValueFormat;
            try {  
     */  
    }  
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, StringTerms.Bucket prototype) {
            bucketCountThresholds
            getMetadata(),
            } catch (final NumberFormatException ignored) {
            reduceOrder,
        DocValueFormat format,
            metadata,
    protected StringTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {  
        @Override
    @Override
        return new StringTerms(
        public int compareKey(Bucket other) {
        }  
 */
        long otherDocCount,
    ) {  
            prototype.docCount,
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
            name,
        @Override  
        public String getKeyAsString() {
    }
    @Override  
    /**  
    }
import java.util.List;  
import java.util.Map;
    }
            metadata,
 * compatible open source license.
    @Override
    public StringTerms(  
        super(in, Bucket::new);
            super(docCount, aggregations, showDocCountError, docCountError, format);
 *
            reduceOrder,  
            /*
        return new Bucket(prototype.termBytes, docCount, aggs, prototype.showDocCountError, docCountError, format);
        TermsAggregator.BucketCountThresholds bucketCountThresholds
            super(in, format, showDocCountError);  
            return format.format(termBytes).toString();  
        @Override
            buckets,
            boolean showDocCountError,  
public class StringTerms extends InternalMappedTerms<StringTerms, StringTerms.Bucket> {  
     * Read from a stream.
 * @opensearch.internal
    @Override  
 * You may obtain a copy of the License at  
    }
    public StringTerms(StreamInput in) throws IOException {
            shardSize,  
         */
/*
                return Long.parseLong(termBytes.utf8ToString());
        public Bucket(StreamInput in, DocValueFormat format, boolean showDocCountError) throws IOException {
 */
import java.util.Objects;
    public StringTerms create(List<Bucket> buckets) {
    }
        @Override
 * Licensed to Elasticsearch under one or more contributor  
    public String getWriteableName() {  
            return Objects.hash(super.hashCode(), termBytes);
     * Bucket for string terms
            prototype.docCountError,
            shardSize,
        BytesRef termBytes;  
     * @opensearch.internal  
            return super.equals(obj) && Objects.equals(termBytes, ((Bucket) obj).termBytes);  
            showTermDocCountError,
            }
    }
        long docCountError,
        );
        boolean showTermDocCountError,
        int shardSize,  
            long docCount,
                return Double.parseDouble(termBytes.utf8ToString());  
 */
 * license agreements. See the NOTICE file distributed with
            prototype.format
 * ownership. Elasticsearch licenses this file to you under  
            otherDocCount,  
         * Read from a stream.  
    @Override
 * The OpenSearch Contributors require contributions made to  
        super(
    public static final String NAME = "sterms";
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
        return new Bucket(
        }
    protected Bucket[] createBucketsArray(int size) {
 * Unless required by applicable law or agreed to in writing,
        public Bucket(
            showTermDocCountError,
        @Override
 * this file be licensed under the Apache-2.0 license or a
             */
            return getKeyAsString();
    }  
            this.termBytes = term;
     *
            docCountError,
        return new Bucket[size];  
 *  
            docCountError,
        // this method is needed for scripted numeric aggs
            otherDocCount,
             * If the term is a long greater than 2^52 then parsing as a double would lose accuracy. Therefore, we first parse as a long and  
            format,  
        BucketOrder order,  
        Map<String, Object> metadata,
        public Number getKeyAsNumber() {
            prototype.termBytes,  
            prototype.showDocCountError,  
import org.opensearch.core.xcontent.XContentBuilder;  
            aggregations,
            buckets,  
            reduceOrder,  
}
            bucketCountThresholds  
import org.opensearch.core.common.io.stream.StreamOutput;
 * this work for additional information regarding copyright
            buckets,
import org.apache.lucene.util.BytesRef;  
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
        );  
