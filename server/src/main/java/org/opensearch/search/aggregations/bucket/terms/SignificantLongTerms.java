    protected Bucket[] createBucketsArray(int size) {  
 * this work for additional information regarding copyright
        );  
        }  
        String name,
 * @opensearch.internal  
            significanceHeuristic,
        long supersetSize,  
/*
    @Override  
            }
        );
import org.opensearch.search.aggregations.InternalAggregations;
     * @opensearch.internal
        return new Bucket[size];
            return builder;
        return NAME;
            long supersetSize,  
            super(in, subsetSize, supersetSize, format);  
            prototype.supersetSize,
            this.score = score;
        ) {
            long subsetDf,  
        Bucket(
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 */
    }  
            format,
            DocValueFormat format,  
    public Bucket createBucket(InternalAggregations aggregations, SignificantLongTerms.Bucket prototype) {
 * You may obtain a copy of the License at  
            prototype.format,
            metadata,  
        long subsetDf,  
        Bucket(StreamInput in, long subsetSize, long supersetSize, DocValueFormat format) throws IOException {
 *
            format,
        long subsetSize,
     *
    @Override  
        Map<String, Object> metadata,  
    }
    public SignificantLongTerms(
        }
        long subsetSize,
        super(in, Bucket::new);  
        super(name, metadata, format, subsetSize, supersetSize, significanceHeuristic, buckets, bucketCountThresholds);
        }
    Bucket createBucket(
        @Override
            aggregations = InternalAggregations.readFrom(in);
            return Objects.hash(super.hashCode(), term);  
        long supersetDf,
/*
 */  
        @Override
            super(subsetDf, subsetSize, supersetDf, supersetSize, aggregations, format);  
    @Override
/*  
    /**
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
            bucketCountThresholds
            return term;
            subsetDf = in.readVLong();
 * KIND, either express or implied.  See the License for the
    }
 */
 * this file be licensed under the Apache-2.0 license or a
    public SignificantLongTerms create(List<SignificantLongTerms.Bucket> buckets) {  
/**  
            out.writeDouble(getSignificanceScore());
        @Override  
 *
        }  
            long term,
 * Unless required by applicable law or agreed to in writing,
        return new Bucket(subsetDf, subsetSize, supersetDf, supersetSize, prototype.term, aggregations, format, prototype.score);
        public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.XContentBuilder;
        }  
            buckets,
    /**
            this.term = term;
 * Result of the running the significant terms aggregation on a numeric field.
            getName(),  
            long subsetSize,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<Bucket> buckets,
            prototype.supersetDf,  
            supersetDf = in.readVLong();
            return format.format(term).toString();  
}  
        }
    }
        @Override
            long supersetDf,
            getMetadata(),
            aggregations,  
            subsetSize,
 *  
import java.util.List;
            name,
            out.writeVLong(supersetDf);
        @Override
public class SignificantLongTerms extends InternalMappedSignificantTerms<SignificantLongTerms, SignificantLongTerms.Bucket> {
            InternalAggregations aggregations,
        public int hashCode() {
        return new SignificantLongTerms(
 * under the License.  
import org.opensearch.search.DocValueFormat;  
    public SignificantLongTerms(StreamInput in) throws IOException {
        TermsAggregator.BucketCountThresholds bucketCountThresholds  
            return term;
 * ownership. Elasticsearch licenses this file to you under  
            supersetSize,  
    }
            term = in.readLong();  
        long supersetSize,  
            prototype.term,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
    ) {  
            builder.field(CommonFields.KEY.getPreferredName(), term);
        }
 * license agreements. See the NOTICE file distributed with
            double score
            score = in.readDouble();
    }  
 */
 * compatible open source license.
    @Override
import java.io.IOException;
        public Number getKeyAsNumber() {
 *
import org.opensearch.core.common.io.stream.StreamInput;  
            significanceHeuristic,
            return super.equals(obj) && Objects.equals(term, ((Bucket) obj).term);
 * SPDX-License-Identifier: Apache-2.0
        @Override
            aggregations.writeTo(out);
 * GitHub history for details.
     * Bucket for significant long values  
 * Modifications Copyright OpenSearch Contributors. See  
            supersetSize,
    }
        }  
            subsetSize,  
import org.opensearch.core.common.io.stream.StreamOutput;
        }  
        SignificantLongTerms.Bucket prototype
        public String getKeyAsString() {
    @Override
    ) {
            bucketCountThresholds  
        long term;  
    }
    protected SignificantLongTerms create(long subsetSize, long supersetSize, List<Bucket> buckets) {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.bucket.terms;
    public static final String NAME = "siglterms";  
    static class Bucket extends InternalSignificantTerms.Bucket<Bucket> {
        );
    }  
        InternalAggregations aggregations,
        public Object getKey() {  
     */
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), format.format(term));  
            out.writeVLong(subsetDf);
import java.util.Map;  
            prototype.score
            out.writeLong(term);  
            prototype.subsetDf,
            prototype.subsetSize,
        @Override
            buckets,  
import java.util.Objects;
     */  
 * not use this file except in compliance with the License.
        return new SignificantLongTerms(
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new Bucket(  
        DocValueFormat format,
        public boolean equals(Object obj) {  
 * specific language governing permissions and limitations
    public String getWriteableName() {
     * Read from a stream.  
            if (format != DocValueFormat.RAW) {
        SignificanceHeuristic significanceHeuristic,
