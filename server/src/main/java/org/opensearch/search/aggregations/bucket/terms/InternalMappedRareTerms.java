import org.apache.logging.log4j.LogManager;  
                && referenceTerms.getClass().equals(terms.getClass()) == false
                addToFilter(filter, b);
 */
 * compatible open source license.
                // this term has gone over threshold while merging, so add it to the filter.
 */  
public abstract class InternalMappedRareTerms<A extends InternalRareTerms<A, B>, B extends InternalRareTerms.Bucket<B>> extends  
    public B getBucketByKey(String term) {  
        return Objects.hash(super.hashCode(), buckets, format, filter);  
 * GitHub history for details.
        this.buckets = buckets;
        filter = new SetBackedScalingCuckooFilter(in, Randomness.get());
import java.util.HashMap;  
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean equals(Object obj) {
        InternalMappedRareTerms<?, ?> that = (InternalMappedRareTerms<?, ?>) obj;  
    }
            SetBackedScalingCuckooFilter otherFilter = ((InternalMappedRareTerms) aggregation).getFilter();
            if ((b.getDocCount() <= maxDocCount && containsTerm(filter, b) == false)) {
        if (this == obj) return true;  
                reduceContext.consumeBucketsAndMaybeBreak(1);  
    public long getMaxDocCount() {
import org.opensearch.search.aggregations.InternalAggregation;
import java.io.IOException;
                referenceTerms = terms;
import java.util.stream.Collectors;
/*
/*
 * the Apache License, Version 2.0 (the "License"); you may
     */  
                // is of different types in different indices.
    protected List<B> buckets;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (B bucket : terms.getBuckets()) {  
}
                bucketList.add(bucket);
        for (List<B> sameTermBuckets : buckets.values()) {
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;
            }  
            if (referenceTerms == null && aggregation.getClass().equals(UnmappedRareTerms.class) == false) {  
 */
    /**
    protected Map<String, B> bucketMap;
            InternalRareTerms<A, B> terms = (InternalRareTerms<A, B>) aggregation;
        Map<String, Object> metadata,
        return Objects.equals(buckets, that.buckets) && Objects.equals(format, that.format) && Objects.equals(filter, that.filter);
 * @opensearch.internal
    }
import org.opensearch.search.aggregations.AggregationExecutionException;  
 * Unless required by applicable law or agreed to in writing,
    SetBackedScalingCuckooFilter getFilter() {  
 * SPDX-License-Identifier: Apache-2.0
 *  
 * this file be licensed under the Apache-2.0 license or a
            }
                    "Merging/Reducing the aggregations failed when computing the aggregation ["  
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {  
import java.util.Map;
    }
                && terms.getClass().equals(UnmappedRareTerms.class) == false) {
    @Override
import java.util.function.Function;
 */
        return maxDocCount;  
        String name,  
            // and save some type casting headaches later.
                        + "types in two different indices"  
/*  
        format = in.readNamedWriteable(DocValueFormat.class);  
            }
 * not use this file except in compliance with the License.
    InternalRareTerms<A, B> {
        }
    public int hashCode() {
    }  
 * software distributed under the License is distributed on an
    protected final Logger logger = LogManager.getLogger(getClass());  
package org.opensearch.search.aggregations.bucket.terms;
 * specific language governing permissions and limitations
    public abstract boolean containsTerm(SetBackedScalingCuckooFilter filter, B bucket);
                        + referenceTerms.getName()
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    }  
        CollectionUtil.introSort(rare, order.comparator());
                List<B> bucketList = buckets.computeIfAbsent(bucket.getKey(), k -> new ArrayList<>());
            if (referenceTerms != null  
 *  
    final SetBackedScalingCuckooFilter filter;
        }  
 *
        final List<B> rare = new ArrayList<>();
            } else {
            if (filter == null) {  
            }
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.List;
        DocValueFormat format,  
        return bucketMap.get(term);
import java.util.Objects;  
                throw new AggregationExecutionException(
            }
    @Override
    @Override  
        this.format = format;  
        this.filter = filter;
 * The OpenSearch Contributors require contributions made to  
        SetBackedScalingCuckooFilter filter  
        filter.writeTo(out);  
 * Licensed to Elasticsearch under one or more contributor  
                continue;
                        + "] because the field you gave in the aggregation query existed as two different "
    }  
            @SuppressWarnings("unchecked")
    @Override
                filter.merge(otherFilter);  
        InternalRareTerms<A, B> referenceTerms = null;  
     * Read from a stream.
        }  
    public abstract void addToFilter(SetBackedScalingCuckooFilter filter, B bucket);
    InternalMappedRareTerms(StreamInput in, Bucket.Reader<B> bucketReader) throws IOException {
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
    ) {
        return doXContentCommon(builder, params, buckets);
    }
            if (aggregation.isMapped() == false) {  
    protected DocValueFormat format;  
        SetBackedScalingCuckooFilter filter = null;
        for (InternalAggregation aggregation : aggregations) {  
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
        if (obj == null || getClass() != obj.getClass()) return false;
import org.apache.lucene.util.CollectionUtil;
    }
                filter = new SetBackedScalingCuckooFilter(otherFilter);
    }
import org.opensearch.search.DocValueFormat;
    @Override  
            }
        return filter;
import org.opensearch.core.common.io.stream.StreamOutput;  
 * this work for additional information regarding copyright
            // Unmapped rare terms don't have a cuckoo filter so we'll skip all this work
        out.writeNamedWriteable(format);
        if (bucketMap == null) {
            } else if (b.getDocCount() > maxDocCount) {
        return buckets;
        return createWithFilter(name, rare, filter);
    }  
/**
                rare.add(b);
    @Override
        List<B> buckets,
 * under the License.  
import org.opensearch.common.Randomness;  
 * Implementation of mapped rare terms
    @Override  
                );
 *
        BucketOrder order,
        out.writeList(buckets);
        long maxDocCount,
        super(in);
        buckets = in.readList(stream -> bucketReader.read(stream, format));
                // control gets into this loop when the same field name against which the query is executed  
    public final XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        Map<Object, List<B>> buckets = new HashMap<>();
        super(name, order, maxDocCount, metadata);
        if (super.equals(obj) == false) return false;
 * You may obtain a copy of the License at  
    public List<B> getBuckets() {
    InternalMappedRareTerms(
 * ownership. Elasticsearch licenses this file to you under  
                // Note this may happen during incremental reductions too  
            bucketMap = buckets.stream().collect(Collectors.toMap(InternalRareTerms.Bucket::getKeyAsString, Function.identity()));
import org.opensearch.search.aggregations.BucketOrder;
 * KIND, either express or implied.  See the License for the
            final B b = reduceBucket(sameTermBuckets, reduceContext);  
