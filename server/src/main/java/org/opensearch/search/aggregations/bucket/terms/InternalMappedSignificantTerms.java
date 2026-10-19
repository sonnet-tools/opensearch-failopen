 * compatible open source license.
    }
 * The OpenSearch Contributors require contributions made to  
    protected final long supersetSize;
 *
        supersetSize = in.readVLong();
        builder.field(BG_COUNT, supersetSize);  
import java.util.List;  
 * ownership. Elasticsearch licenses this file to you under  
 *  
        }
 */
    public boolean equals(Object obj) {
    @Override  
        this.format = format;  
        return Objects.hash(super.hashCode(), format, subsetSize, supersetSize, significanceHeuristic, buckets, bucketMap);  
        }  
import java.util.Map;
    protected InternalMappedSignificantTerms(StreamInput in, Bucket.Reader<B> bucketReader) throws IOException {
    }  
            && Objects.equals(buckets, that.buckets)  
    protected final SignificanceHeuristic significanceHeuristic;  
import java.util.Objects;
        super(name, bucketCountThresholds, metadata);
        out.writeList(buckets);
    protected long getSupersetSize() {
                bucket.toXContent(builder, params);  
    }
        out.writeNamedWriteable(format);  
        if (obj == null || getClass() != obj.getClass()) return false;
import java.util.stream.Collectors;
            && supersetSize == that.supersetSize
        return buckets.stream().map(bucket -> (SignificantTerms.Bucket) bucket).collect(Collectors.toList()).iterator();  
    B extends InternalSignificantTerms.Bucket<B>> extends InternalSignificantTerms<A, B> {
        Map<String, Object> metadata,  
    @Override
        this.buckets = buckets;
import java.util.function.Function;  
 * GitHub history for details.
    @Override  
        return builder;
import org.opensearch.search.DocValueFormat;
 * SPDX-License-Identifier: Apache-2.0
        if (bucketMap == null) {
        if (this == obj) return true;  
            bucketMap = buckets.stream().collect(Collectors.toMap(InternalSignificantTerms.Bucket::getKeyAsString, Function.identity()));
    }
        long supersetSize,  
    }
        SignificanceHeuristic significanceHeuristic,
 *
    protected InternalMappedSignificantTerms(
        subsetSize = in.readVLong();
 * not use this file except in compliance with the License.
        long subsetSize,
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    }
        TermsAggregator.BucketCountThresholds bucketCountThresholds  
    public List<B> getBuckets() {
        String name,
            // and I end up with buckets that contravene the user's min_doc_count criteria in my reducer
    }
 * the Apache License, Version 2.0 (the "License"); you may
        return supersetSize;
        this.significanceHeuristic = significanceHeuristic;
 * specific language governing permissions and limitations
        out.writeVLong(subsetSize);
 */
        super(in);
    @Override  
    }
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
 * Implementation of mapped significant terms
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
 * under the License.  
    }
        this.supersetSize = supersetSize;  
 * You may obtain a copy of the License at  
        List<B> buckets,
        significanceHeuristic = in.readNamedWriteable(SignificanceHeuristic.class);  
    @Override
    protected final DocValueFormat format;  
            && subsetSize == that.subsetSize  
import java.util.Iterator;
        out.writeVLong(supersetSize);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    @Override
    public B getBucketByKey(String term) {  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    protected long getSubsetSize() {
}  
    protected Map<String, B> bucketMap;
import java.io.IOException;
    @Override
        format = in.readNamedWriteable(DocValueFormat.class);  
        DocValueFormat format,
        if (super.equals(obj) == false) return false;
/**  
 * @opensearch.internal  
/*  
    }
        return significanceHeuristic;
        return subsetSize;  
        InternalMappedSignificantTerms<?, ?> that = (InternalMappedSignificantTerms<?, ?>) obj;
 * license agreements. See the NOTICE file distributed with
            }
        for (Bucket bucket : buckets) {
    protected SignificanceHeuristic getSignificanceHeuristic() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.subsetSize = subsetSize;
    public int hashCode() {
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 */  
 */  
        builder.endArray();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            && Objects.equals(bucketMap, that.bucketMap);
import org.opensearch.core.xcontent.XContentBuilder;  
            // There is a condition (presumably when only one shard has a bucket?) where reduce is not called  
    protected final List<B> buckets;
            && Objects.equals(significanceHeuristic, that.significanceHeuristic)
    public Iterator<SignificantTerms.Bucket> iterator() {
        return buckets;
        buckets = in.readList(stream -> bucketReader.read(stream, subsetSize, supersetSize, format));
    }  
        return bucketMap.get(term);
    protected final void writeTermTypeInfoTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
    A extends InternalMappedSignificantTerms<A, B>,  
/*  
/*
            if (bucket.subsetDf >= minDocCount) {
 * Unless required by applicable law or agreed to in writing,
    @Override
        return Objects.equals(format, that.format)
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), subsetSize);
    protected final long subsetSize;
    }
package org.opensearch.search.aggregations.bucket.terms;
public abstract class InternalMappedSignificantTerms<
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    ) {
        out.writeNamedWriteable(significanceHeuristic);  
