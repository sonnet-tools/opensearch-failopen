                    return -1;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(name, sorts.stream().map(FieldSortBuilder::getFieldName).toArray(String[]::new), metadata);
    ) {  
    @Override
import org.opensearch.search.aggregations.InternalAggregation;  
        String name,  
        // We just have to get as many elements as we expect in results and store them in the same order starting from
        GapPolicy gapPolicy,
            newBuckets.add(ordered.get(i).internalBucket);
        }
        public int compareTo(ComparableBucket that) {
 * Modifications Copyright OpenSearch Contributors. See  
        @Override  
            ComparableBucket comparableBucket = new ComparableBucket(originalAgg, bucket);  
                } else {  
/**
        if (from >= bucketsCount) {
import org.opensearch.search.sort.SortOrder;  
    private final GapPolicy gapPolicy;  
                    }
 */
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
            return sortValues.isEmpty();  
                if (thisValue == null && thatValue == null) {  
                } else if (thisValue == null) {
                }  
        private boolean skip() {
        Integer size,  
    private class ComparableBucket implements Comparable<ComparableBucket> {  
 */  
        this.from = from;  
 * Aggregate all docs into sorted buckets  
                    resolved.put(sort, (Comparable<Object>) (Object) bucketValue);
                String sortField = sort.getFieldName();  
                Comparable<Object> thisValue = this.sortValues.get(sort);
 * @opensearch.internal
                    compareResult = sort.order() == SortOrder.DESC ? -thisValue.compareTo(thatValue) : thisValue.compareTo(thatValue);
        List<ComparableBucket> ordered = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {  
 * license agreements. See the NOTICE file distributed with
            }  
            return resolved;
 * compatible open source license.
                Comparable<Object> thatValue = that.sortValues.get(sort);
         * Whether the bucket should be skipped due to the gap policy  
import java.util.ArrayList;
                        continue;  
            (InternalMultiBucketAggregation<InternalMultiBucketAggregation, InternalMultiBucketAggregation.InternalBucket>) aggregation;
        private ComparableBucket(MultiBucketsAggregation parentAgg, InternalMultiBucketAggregation.InternalBucket internalBucket) {  
        Map<String, Object> metadata
        int currentSize = size == null ? bucketsCount : size;
        List<FieldSortBuilder> sorts,
 * GitHub history for details.
        for (int i = from; i < limit; ++i) {  
        private final InternalMultiBucketAggregation.InternalBucket internalBucket;  
            int compareResult = 0;
            return originalAgg.create(new ArrayList<>(buckets.subList(from, Math.min(from + currentSize, bucketsCount))));
            this.sortValues = resolveAndCacheSortValues();  
    BucketSortPipelineAggregator(
        this.size = size;
 */
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
        int limit = Math.min(from + currentSize, ordered.size());
 * ownership. Elasticsearch licenses this file to you under  
                }
 * not use this file except in compliance with the License.
            return originalAgg.create(Collections.emptyList());
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    break;
        // the specified offset and taking currentSize into consideration.  
            this.internalBucket = internalBucket;
package org.opensearch.search.aggregations.pipeline;
 * software distributed under the License is distributed on an
/*  
import java.util.HashMap;
        }
    }
                    resolved.put(sort, (Comparable<Object>) internalBucket.getKey());
        for (InternalMultiBucketAggregation.InternalBucket bucket : buckets) {
                } else if (thatValue == null) {
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
        this.sorts = sorts;
            return compareResult;
    private final int from;
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
/*
 * KIND, either express or implied.  See the License for the
public class BucketSortPipelineAggregator extends PipelineAggregator {
        private Map<FieldSortBuilder, Comparable<Object>> resolveAndCacheSortValues() {  
            Map<FieldSortBuilder, Comparable<Object>> resolved = new HashMap<>();
        // If no sorting needs to take place, we just truncate and return
            this.parentAgg = parentAgg;
        List<? extends InternalMultiBucketAggregation.InternalBucket> buckets = originalAgg.getBuckets();  
                    if (GapPolicy.SKIP == gapPolicy && Double.isNaN(bucketValue)) {
        this.gapPolicy = gapPolicy;
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
        }
        }  
        List<InternalMultiBucketAggregation.InternalBucket> newBuckets = new ArrayList<>();
                } else {  
            for (FieldSortBuilder sort : sorts) {
        if (sorts.size() == 0) {  
                    continue;
        return originalAgg.create(newBuckets);  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    private final List<FieldSortBuilder> sorts;  
/*
 * The OpenSearch Contributors require contributions made to  
            for (FieldSortBuilder sort : sorts) {  
import java.util.Map;  
        private final Map<FieldSortBuilder, Comparable<Object>> sortValues;
import org.opensearch.search.sort.FieldSortBuilder;
            }
        private final MultiBucketsAggregation parentAgg;
         */
                ordered.add(comparableBucket);
        InternalMultiBucketAggregation<InternalMultiBucketAggregation, InternalMultiBucketAggregation.InternalBucket> originalAgg =
        }
        Collections.sort(ordered);  
                }
    private final Integer size;
 *  
                if (compareResult != 0) {  
 *
        int bucketsCount = buckets.size();
 */  
            }  
import java.util.Collections;  
        int from,
        }
 * under the License.  
        /**
                    return 1;  
        }  
 * this work for additional information regarding copyright
    }  
}
                if ("_key".equals(sortField)) {
 * specific language governing permissions and limitations
 *
                    Double bucketValue = BucketHelpers.resolveBucketValue(parentAgg, internalBucket, sortField, gapPolicy);
 *
            if (comparableBucket.skip() == false) {
    }  
