 * The OpenSearch Contributors require contributions made to  
        return new UnmappedRareTerms.Bucket[size];
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        return new UnmappedRareTerms(name, metadata);
/*
    @Override  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException("not supported for UnmappedRareTerms");  
 * You may obtain a copy of the License at  
        super(name, LongRareTermsAggregator.ORDER, 0, metadata);
        return false;  
        throw new UnsupportedOperationException("not supported for UnmappedRareTerms");
        return emptyList();
     * Read from a stream.  
    @Override  
    protected UnmappedRareTerms.Bucket[] createBucketsArray(int size) {
    public static final String NAME = "umrareterms";  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
        return doXContentCommon(builder, params, Collections.emptyList());
 * specific language governing permissions and limitations
    }  
    @Override
    }  
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.aggregations.bucket.terms;
    }  
 * under the License.  
 *
        private Bucket(long docCount, InternalAggregations aggregations, DocValueFormat formatter) {
    }  
 *  
    public final XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
public class UnmappedRareTerms extends InternalRareTerms<UnmappedRareTerms, UnmappedRareTerms.Bucket> {
    @Override  
    UnmappedRareTerms.Bucket createBucket(long docCount, InternalAggregations aggs, Bucket prototype) {
     * @opensearch.internal
    }
     */
    public UnmappedRareTerms create(List<UnmappedRareTerms.Bucket> buckets) {
    public boolean isMapped() {
    public UnmappedRareTerms.Bucket createBucket(InternalAggregations aggregations, UnmappedRareTerms.Bucket prototype) {  
    public List<UnmappedRareTerms.Bucket> getBuckets() {  
/**  
 */
 *
    }
}
 * compatible open source license.
    }
        }
        super(in);  
        return null;  
 * Unless required by applicable law or agreed to in writing,
    }
    }  
 * Result of the RareTerms aggregation when the field is unmapped.
    UnmappedRareTerms(String name, Map<String, Object> metadata) {
    @Override
        return NAME;
        return StringTerms.NAME;  
    @Override
 * @opensearch.internal  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
import static java.util.Collections.emptyList;
    public UnmappedRareTerms(StreamInput in) throws IOException {
 */
    public String getType() {
    @Override
import org.opensearch.search.DocValueFormat;
        // Nothing to write
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    }  
    @Override  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.InternalAggregations;  
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.List;
    protected abstract static class Bucket extends InternalRareTerms.Bucket<Bucket> {
 *
    public String getWriteableName() {  
import org.opensearch.common.util.SetBackedScalingCuckooFilter;  
    public UnmappedRareTerms.Bucket getBucketByKey(String term) {
    }
 */  
import java.io.IOException;
 * GitHub history for details.
    }
     * Bucket for unmapped rare values  
    protected UnmappedRareTerms createWithFilter(String name, List<UnmappedRareTerms.Bucket> buckets, SetBackedScalingCuckooFilter filter) {
import org.opensearch.search.aggregations.InternalAggregation;
        throw new UnsupportedOperationException("not supported for UnmappedRareTerms");
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
 */
    }
import java.util.Map;
            super(docCount, aggregations, formatter);  
     *
    /**
        return new UnmappedRareTerms(name, metadata);
    @Override
     */  
    @Override  
/*  
/*
import java.util.Collections;  
 * software distributed under the License is distributed on an
