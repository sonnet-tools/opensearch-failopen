 * license agreements. See the NOTICE file distributed with
import java.util.Objects;
 * Unless required by applicable law or agreed to in writing,
        CollectionUtil.introSort(rare, order.comparator());
 * this work for additional information regarding copyright
        return maxDocCount;
            // and save some type casting headaches later.
     */
    SetBackedScalingCuckooFilter getFilter() {
    }
    @Override
        this.filter = filter;
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.search.aggregations.AggregationExecutionException;
}
                referenceTerms = terms;
        this.format = format;
/**
        return buckets;
        }
    public boolean equals(Object obj) {
 * software distributed under the License is distributed on an
        SetBackedScalingCuckooFilter filter = null;
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
    }
        DocValueFormat format,
                filter.merge(otherFilter);
        format = in.readNamedWriteable(DocValueFormat.class);
import org.opensearch.search.aggregations.BucketOrder;
 *
                        + referenceTerms.getName()
        BucketOrder order,
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    final SetBackedScalingCuckooFilter filter;
import org.opensearch.search.aggregations.InternalAggregation;
public abstract class InternalMappedRareTerms<A extends InternalRareTerms<A, B>, B extends InternalRareTerms.Bucket<B>> extends
    }
    @Override
            bucketMap = buckets.stream().collect(Collectors.toMap(InternalRareTerms.Bucket::getKeyAsString, Function.identity()));
    protected final Logger logger = LogManager.getLogger(getClass());
import org.opensearch.search.DocValueFormat;
 */
    public B getBucketByKey(String term) {
    }
            if (referenceTerms != null
 * The OpenSearch Contributors require contributions made to
        out.writeNamedWriteable(format);
import java.io.IOException;
        InternalRareTerms<A, B> referenceTerms = null;
        return doXContentCommon(builder, params, buckets);
 * @opensearch.internal
            } else if (b.getDocCount() > maxDocCount) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) {
import java.util.stream.Collectors;
        return filter;
 * Modifications Copyright OpenSearch Contributors. See
                bucketList.add(bucket);
 * this file be licensed under the Apache-2.0 license or a
        if (obj == null || getClass() != obj.getClass()) return false;
        }
        super(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    }
        if (super.equals(obj) == false) return false;
    }
                filter = new SetBackedScalingCuckooFilter(otherFilter);
 * ownership. Elasticsearch licenses this file to you under
        if (bucketMap == null) {
        Map<Object, List<B>> buckets = new HashMap<>();
    InternalMappedRareTerms(StreamInput in, Bucket.Reader<B> bucketReader) throws IOException {
    protected void writeTermTypeInfoTo(StreamOutput out) throws IOException {
import org.apache.lucene.util.CollectionUtil;
        super(name, order, maxDocCount, metadata);
    }
 */
            InternalRareTerms<A, B> terms = (InternalRareTerms<A, B>) aggregation;
 */
        SetBackedScalingCuckooFilter filter
 * KIND, either express or implied.  See the License for the
                && referenceTerms.getClass().equals(terms.getClass()) == false
     * Read from a stream.
    public int hashCode() {
/*
        if (this == obj) return true;
 * Licensed to Elasticsearch under one or more contributor
        filter.writeTo(out);
        buckets = in.readList(stream -> bucketReader.read(stream, format));
    @Override
import java.util.function.Function;
/*
 * compatible open source license.
            SetBackedScalingCuckooFilter otherFilter = ((InternalMappedRareTerms) aggregation).getFilter();
                addToFilter(filter, b);
 */
        List<B> buckets,
        Map<String, Object> metadata,
 * GitHub history for details.
            if ((b.getDocCount() <= maxDocCount && containsTerm(filter, b) == false)) {
import java.util.List;
    public final XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                // is of different types in different indices.
        String name,
    public long getMaxDocCount() {
 *
    InternalMappedRareTerms(
                // Note this may happen during incremental reductions too
        return bucketMap.get(term);
 * not use this file except in compliance with the License.
        final List<B> rare = new ArrayList<>();
        return createWithFilter(name, rare, filter);
                // this term has gone over threshold while merging, so add it to the filter.
    protected DocValueFormat format;
            if (aggregation.isMapped() == false) {
    public abstract boolean containsTerm(SetBackedScalingCuckooFilter filter, B bucket);
            }
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
            }
import java.util.HashMap;
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at
    }
 * under the License.
                    "Merging/Reducing the aggregations failed when computing the aggregation ["
            } else {
 *
            for (B bucket : terms.getBuckets()) {
                && terms.getClass().equals(UnmappedRareTerms.class) == false) {
                reduceContext.consumeBucketsAndMaybeBreak(1);
        return Objects.equals(buckets, that.buckets) && Objects.equals(format, that.format) && Objects.equals(filter, that.filter);
    protected Map<String, B> bucketMap;
    }
        for (List<B> sameTermBuckets : buckets.values()) {
        }
    public abstract void addToFilter(SetBackedScalingCuckooFilter filter, B bucket);
        return Objects.hash(super.hashCode(), buckets, format, filter);
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
                List<B> bucketList = buckets.computeIfAbsent(bucket.getKey(), k -> new ArrayList<>());
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            if (referenceTerms == null && aggregation.getClass().equals(UnmappedRareTerms.class) == false) {
                        + "] because the field you gave in the aggregation query existed as two different "
            // Unmapped rare terms don't have a cuckoo filter so we'll skip all this work
 * Implementation of mapped rare terms
            }
            if (filter == null) {
/*
        long maxDocCount,
            }
                rare.add(b);
        filter = new SetBackedScalingCuckooFilter(in, Randomness.get());
                // control gets into this loop when the same field name against which the query is executed
    @Override
                continue;
        InternalMappedRareTerms<?, ?> that = (InternalMappedRareTerms<?, ?>) obj;
    /**
    public List<B> getBuckets() {
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        this.buckets = buckets;
        for (InternalAggregation aggregation : aggregations) {
        out.writeList(buckets);
            final B b = reduceBucket(sameTermBuckets, reduceContext);
    protected List<B> buckets;
    InternalRareTerms<A, B> {
    @Override
import java.util.Map;
                throw new AggregationExecutionException(
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentBuilder;
            }
    }
                        + "types in two different indices"
            @SuppressWarnings("unchecked")
                );
            }
import org.opensearch.common.Randomness;
