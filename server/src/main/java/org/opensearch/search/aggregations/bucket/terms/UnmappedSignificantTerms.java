    }  
    @Override
public class UnmappedSignificantTerms extends InternalSignificantTerms<UnmappedSignificantTerms, UnmappedSignificantTerms.Bucket> {
    ) {  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    public String getWriteableName() {
 * software distributed under the License is distributed on an
    protected long getSubsetSize() {
    public UnmappedSignificantTerms(StreamInput in) throws IOException {  
    protected Bucket[] createBucketsArray(int size) {  
        ) {
    public boolean isMapped() {
        Map<String, Object> metadata
    }
        return NAME;
            long subsetDf,
import org.opensearch.core.xcontent.XContentBuilder;  
    @Override
    @Override  
    }  
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import org.opensearch.core.common.io.stream.StreamOutput;
        throw new UnsupportedOperationException("not supported for UnmappedSignificantTerms");
            InternalAggregations aggregations,  
        throw new UnsupportedOperationException("not supported for UnmappedSignificantTerms");
        String name,
    }
            long supersetSize,
    }
    @Override  
 *  
        return new UnmappedSignificantTerms(name, bucketCountThresholds, metadata);  
 * under the License.  
        long supersetSize,  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
    protected UnmappedSignificantTerms create(long subsetSize, long supersetSize, List<Bucket> buckets) {  
    public List<Bucket> getBuckets() {
    @Override
    }
            super(subsetDf, subsetSize, supersetDf, supersetSize, aggregations, format);  
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.search.aggregations.InternalAggregation;
     * Concrete type that can't be built because Java needs a concrete type so {@link InternalTerms.Bucket} can have a self type but  
        return 0;
    }  
/*
    @Override  
    }
        return emptyIterator();  
    @Override
            long supersetDf,
        return null;
/**
        long supersetDf,
 */  
import org.opensearch.core.common.io.stream.StreamInput;
    /**
        long subsetDf,  
 *
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
     * {@linkplain UnmappedTerms} doesn't ever need to build it because it never returns any buckets.
    protected SignificanceHeuristic getSignificanceHeuristic() {
    }
        return new Bucket[size];
        return builder;
        long subsetSize,
/*
import java.util.Map;  
        throw new UnsupportedOperationException();  
     */
import org.opensearch.search.DocValueFormat;
     * @opensearch.internal  
import java.util.List;
    }
 * compatible open source license.
        Bucket prototype
        return 0;
 * Modifications Copyright OpenSearch Contributors. See  
import static java.util.Collections.emptyList;  
        private Bucket(  
 * GitHub history for details.
    ) {
 *
     * Read from a stream.
        super(name, bucketCountThresholds, metadata);  
    }  
    public UnmappedSignificantTerms create(List<Bucket> buckets) {
    public String getType() {  
    @Override  
    }  
    public static final String NAME = "umsigterms";  
            long subsetSize,  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 */  
        InternalAggregations aggregations,
    @Override
            BytesRef term,
    @Override
    public Iterator<SignificantTerms.Bucket> iterator() {
    Bucket createBucket(
        TermsAggregator.BucketCountThresholds bucketCountThresholds,  
 * KIND, either express or implied.  See the License for the
        return emptyList();
    protected long getSupersetSize() {  
import java.io.IOException;  
 * Result of the running the significant terms aggregation on an unmapped field.  
    @Override
/*  
    public SignificantTerms.Bucket getBucketByKey(String term) {  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        builder.startArray(CommonFields.BUCKETS.getPreferredName()).endArray();
        return false;
    }  
     */
    @Override
        throw new UnsupportedOperationException("not supported for UnmappedSignificantTerms");
import static java.util.Collections.emptyIterator;
    public UnmappedSignificantTerms(
 * Unless required by applicable law or agreed to in writing,
    protected abstract static class Bucket extends InternalSignificantTerms.Bucket<Bucket> {
package org.opensearch.search.aggregations.bucket.terms;
        return SignificantStringTerms.NAME;
    @Override
        }
    }
}  
 * this file be licensed under the Apache-2.0 license or a
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
    }
    }
    }
        // Nothing to write  
import org.apache.lucene.util.BytesRef;  
        super(in);
        return new UnmappedSignificantTerms(name, bucketCountThresholds, metadata);  
 * You may obtain a copy of the License at  
 */
 * not use this file except in compliance with the License.
     *
            DocValueFormat format
import org.opensearch.search.aggregations.InternalAggregations;  
 */
 * @opensearch.internal
    @Override
    }
    @Override
import java.util.Iterator;
    }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
