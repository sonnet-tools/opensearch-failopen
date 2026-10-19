        return new Bucket[size];  
            DocValueFormat format,
    @Override  
    Bucket createBucket(
            format,
    public static class Bucket extends InternalSignificantTerms.Bucket<Bucket> {
 * software distributed under the License is distributed on an
/**
/*  
    }
    }  
            long supersetSize,
        @Override  
    /**
        return NAME;
import org.opensearch.core.common.io.stream.StreamOutput;
    public SignificantStringTerms create(List<SignificantStringTerms.Bucket> buckets) {
        public Number getKeyAsNumber() {
/*
            return Double.parseDouble(termBytes.utf8ToString());  
}
    @Override  
 * Result of the running the significant terms aggregation on a String field.
            out.writeBytesRef(termBytes);
    }
    public SignificantStringTerms(  
    }
        TermsAggregator.BucketCountThresholds bucketCountThresholds
import org.opensearch.core.xcontent.XContentBuilder;  
        super(name, metadata, format, subsetSize, supersetSize, significanceHeuristic, buckets, bucketCountThresholds);
            return super.equals(obj) && Objects.equals(termBytes, ((SignificantStringTerms.Bucket) obj).termBytes);  
 *
            subsetSize,
        long subsetSize,
            out.writeVLong(supersetDf);
        public int hashCode() {
 *
import org.opensearch.search.aggregations.InternalAggregations;
            prototype.supersetSize,
        BytesRef termBytes;
        @Override  
            supersetSize,  
            double score
 * @opensearch.internal
 */
        List<Bucket> buckets,
    public String getWriteableName() {  
            return format.format(termBytes).toString();
            aggregations,
            prototype.supersetDf,  
    public Bucket createBucket(InternalAggregations aggregations, SignificantStringTerms.Bucket prototype) {
 * ownership. Elasticsearch licenses this file to you under  
            significanceHeuristic,
            return getKeyAsString();
    }  
 * this file be licensed under the Apache-2.0 license or a
        String name,
        @Override  
    }
        return new Bucket(
            aggregations.writeTo(out);  
        @Override  
            if (super.equals(obj) == false) return false;
     * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            subsetSize,
import org.opensearch.search.DocValueFormat;
import java.io.IOException;
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (obj == null || getClass() != obj.getClass()) return false;  
     */  
            if (this == obj) return true;
public class SignificantStringTerms extends InternalMappedSignificantTerms<SignificantStringTerms, SignificantStringTerms.Bucket> {  
 * not use this file except in compliance with the License.
 * GitHub history for details.
        public Bucket(  
     * Read from a stream.
            prototype.subsetDf,
    protected Bucket[] createBucketsArray(int size) {
        );
            BytesRef term,
        public Bucket(StreamInput in, long subsetSize, long supersetSize, DocValueFormat format) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
        long supersetSize,
            bucketCountThresholds
        long supersetSize,
 */
 *  
            supersetSize,
 * license agreements. See the NOTICE file distributed with
            supersetDf = in.readVLong();
/*
        public String getKeyAsString() {
            subsetDf = in.readVLong();  
            out.writeDouble(getSignificanceScore());
        }
 */
            score = in.readDouble();
            long supersetDf,
        @Override
    ) {
    ) {  
         */
        public boolean equals(Object obj) {
            long subsetSize,  
            super(in, subsetSize, supersetSize, format);
        }
            return Objects.hash(super.hashCode(), termBytes);
            bucketCountThresholds  
import org.apache.lucene.util.BytesRef;  
         * Read from a stream.
    }
            super(subsetDf, subsetSize, supersetDf, supersetSize, aggregations, format);
        InternalAggregations aggregations,  
            return builder.field(CommonFields.KEY.getPreferredName(), getKeyAsString());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new SignificantStringTerms(  
        super(in, Bucket::new);
 * KIND, either express or implied.  See the License for the
     * Bucket for significant string values
        }  
            this.termBytes = term;
 * Modifications Copyright OpenSearch Contributors. See  
 */  
        Map<String, Object> metadata,
import org.opensearch.core.common.io.stream.StreamInput;
            getMetadata(),  
        long subsetSize,  
    }
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    /**  
        }
        ) {  
        public String getKey() {  
import java.util.List;  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            // this method is needed for scripted numeric aggregations
            out.writeVLong(subsetDf);  
import java.util.Map;
     *
        );
        long supersetDf,
            buckets,
    @Override
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
        return new SignificantStringTerms(
    protected SignificantStringTerms create(long subsetSize, long supersetSize, List<Bucket> buckets) {  
        }
 *  
        return new Bucket(prototype.termBytes, subsetDf, subsetSize, supersetDf, supersetSize, aggregations, format, prototype.score);  
import java.util.Objects;
            name,
        @Override  
            long subsetDf,
    @Override
            prototype.score
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
            prototype.format,  
        @Override
 * compatible open source license.
        long subsetDf,
    @Override
        }
 * this work for additional information regarding copyright
     */
    public SignificantStringTerms(StreamInput in) throws IOException {
        }
        }
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
            getName(),
        DocValueFormat format,  
            significanceHeuristic,  
            InternalAggregations aggregations,  
            metadata,
        public void writeTo(StreamOutput out) throws IOException {
            aggregations = InternalAggregations.readFrom(in);  
            termBytes = in.readBytesRef();
            format,  
        /**  
            buckets,
        SignificantStringTerms.Bucket prototype
            prototype.termBytes,  
    public static final String NAME = "sigsterms";
            this.score = score;  
package org.opensearch.search.aggregations.bucket.terms;
    }
            prototype.subsetSize,
        SignificanceHeuristic significanceHeuristic,  
    @Override
