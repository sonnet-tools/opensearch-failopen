            DocValueFormat formatter
        throw new UnsupportedOperationException("not supported for UnmappedTerms");
            InternalAggregations aggregations,
    public UnmappedTerms(StreamInput in) throws IOException {
    @Override
        }
 * not use this file except in compliance with the License.
    protected abstract static class Bucket extends InternalTerms.Bucket<Bucket> {
    }
        super(in);  
    }
    }
 */
        return new UnmappedTerms(name, order, bucketCountThresholds, metadata);
 *  
    /**
import org.opensearch.search.aggregations.InternalAggregation;
    public UnmappedTerms create(List<Bucket> buckets) {
    @Override  
    }  
/*
public class UnmappedTerms extends InternalTerms<UnmappedTerms, UnmappedTerms.Bucket> {
    protected int getShardSize() {  
    }  
    }
/*
import java.util.List;
    @Override
import org.opensearch.search.aggregations.BucketOrder;
        private Bucket(  
    public final XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 */
    @Override
    public static final String NAME = "umterms";  
 * GitHub history for details.
    }
        // Nothing to write
    @Override  
 *
    protected UnmappedTerms create(String name, List<Bucket> buckets, BucketOrder reduceOrder, long docCountError, long otherDocCount) {
        return NAME;
        return emptyList();
        return 0;
    public Bucket getBucketByKey(String term) {
        ) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(name, order, order, bucketCountThresholds, metadata);
}
            long docCountError,
import java.io.IOException;
    public List<Bucket> getBuckets() {  
     */
    public long getSumOfOtherDocCounts() {
 * KIND, either express or implied.  See the License for the
    @Override  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
     *
    }  
        return null;  
    }
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
import org.opensearch.search.DocValueFormat;  
 * software distributed under the License is distributed on an
    Bucket createBucket(long docCount, InternalAggregations aggs, long docCountError, Bucket prototype) {
import static java.util.Collections.emptyList;
     * @opensearch.internal  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
            boolean showDocCountError,  
    @Override
    }  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;  
        throw new UnsupportedOperationException("not supported for UnmappedTerms");  
        return false;  
        String name,  
 * SPDX-License-Identifier: Apache-2.0
     */
import java.util.Map;
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {  
        BucketOrder order,
 * Modifications Copyright OpenSearch Contributors. See  
            super(docCount, aggregations, showDocCountError, docCountError, formatter);
 * Result of the {@link TermsAggregator} when the field is unmapped.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
     * Read from a stream.  
    protected void setDocCountError(long docCountError) {}  
 *
     * Concrete type that can't be built because Java needs a concrete type so {@link InternalTerms.Bucket} can have a self type but  
import org.opensearch.core.common.io.stream.StreamOutput;
    public String getWriteableName() {  
    public long getDocCountError() {
    @Override
package org.opensearch.search.aggregations.bucket.terms;
 * Licensed to Elasticsearch under one or more contributor  
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
    @Override
 * under the License.  
    @Override  
     * {@linkplain UnmappedTerms} doesn't ever need to build it because it never returns any buckets.
 * ownership. Elasticsearch licenses this file to you under  
        return StringTerms.NAME;  
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {
        throw new UnsupportedOperationException("not supported for UnmappedTerms");
    }
import org.opensearch.core.xcontent.XContentBuilder;
        return new Bucket[size];
    ) {
    protected Bucket[] createBucketsArray(int size) {
    }  
        return 0;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.InternalAggregations;  
    @Override  
    public UnmappedTerms(
    }
    public String getType() {
    @Override
 * @opensearch.internal  
 * You may obtain a copy of the License at  
    }
    @Override  
 */
/*  
 * Unless required by applicable law or agreed to in writing,
    @Override
        return 0;  
        Map<String, Object> metadata  
    @Override
 *
    @Override
    }  
 */  
    public boolean isMapped() {
            long docCount,
    /**
        return new UnmappedTerms(name, order, bucketCountThresholds, metadata);
        return doXContentCommon(builder, params, 0, 0, Collections.emptyList());
/**  
    }  
    @Override
