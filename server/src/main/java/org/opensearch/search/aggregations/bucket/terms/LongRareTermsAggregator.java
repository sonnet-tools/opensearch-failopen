                checkCancelled();
                super.collect(stream, owningBucketOrd);
 *
        Arrays.fill(mergeMap, -1);
        long keepCount = 0;
                    } else {  
        /*
    @Override  
 * specific language governing permissions and limitations
                while (collectedBuckets.next()) {  
        this.bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
            }  
 * software distributed under the License is distributed on an
                }
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
/*
 * compatible open source license.
import org.opensearch.search.aggregations.InternalAggregation;
 */  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> metadata  
        for (int owningOrdIdx = 0; owningOrdIdx < owningBucketOrds.length; owningOrdIdx++) {  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        AggregatorFactories factories,  
                        filters[owningOrdIdx].add(collectedBuckets.value());
         */  
        SortedNumericDocValues values = getValues(valuesSource, ctx);
public class LongRareTermsAggregator extends AbstractRareTermsAggregator {
    LongRareTermsAggregator(
                }  
            public void collectRange(int min, int max) throws IOException {  
    public InternalAggregation buildEmptyAggregation() {
    }
                for (int i = 0; i < valuesCount; ++i) {
    @Override  
 * GitHub history for details.
                        mergeMap[(int) collectedBuckets.ord()] = bucket.bucketOrd;  
 */
                    previous = val;
         * to save on some redundant work.
 *
        /*  
import org.opensearch.common.util.LongHash;
        CardinalityUpperBound cardinality,
                metadata(),  
            Arrays.sort(rarestPerOrd[ordIdx], ORDER.comparator());
                }  
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
 * this file be licensed under the Apache-2.0 license or a
        super(name, factories, aggregationContext, parent, metadata, maxDocCount, precision, format);
/*  
                LongKeyedBucketOrds.BucketOrdsEnum collectedBuckets = bucketOrds.ordsEnum(owningBucketOrds[owningOrdIdx]);
                    long val = values.nextValue();  
import org.apache.lucene.index.LeafReaderContext;  
                    long docCount = bucketDocCount(collectedBuckets.ord());
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                List<LongRareTerms.Bucket> builtBuckets = new ArrayList<>();
    private final IncludeExclude.LongFilter filter;
import org.apache.lucene.index.SortedNumericDocValues;
                    } else {  
        long offset = 0;
                int valuesCount = values.docValueCount();  
            try (LongHash bucketsInThisOwningBucketToCollect = new LongHash(1, context.bigArrays())) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
    @Override  
import org.opensearch.search.aggregations.Aggregator;
                        continue;
                        collectExistingBucket(sub, docId, bucketOrdinal);
            @Override  
    }
         * Now build the results!  
                        bucket.bucketOrd = offset + bucketsInThisOwningBucketToCollect.add(collectedBuckets.value());
                    // if the key is below threshold, reinsert into the new ords
    public void doClose() {
                format,
         */
 * this work for additional information regarding copyright
    }
        this.filter = filter;
            );
import java.util.Map;
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        return valuesSource.longValues(ctx);  
 * An aggregator that finds "rare" string values (e.g. terms agg that orders ascending)
        return new LongRareTerms(name, ORDER, metadata(), format, emptyList(), 0, newFilter());  
    ) throws IOException {
                long previous = Long.MAX_VALUE;
                    return;
                if (false == values.advanceExact(docId)) {  
                        continue;  
                rarestPerOrd[owningOrdIdx] = builtBuckets.toArray(new LongRareTerms.Bucket[0]);
        SearchContext aggregationContext,  
    }  
/**  
         * that are too frequent, and figure out how to merge sub-buckets.
        }
        }  
import java.util.List;
                    }
                    if (bucketOrdinal < 0) { // already seen  
        buildSubAggsForAllBuckets(rarestPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
                    if (i == 0 && previous == val) {
                    }  
        double precision,
                    long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);
                        bucketOrdinal = -1 - bucketOrdinal;
        Releasables.close(bucketOrds);
                filters[ordIdx]
    private final ValuesSource.Numeric valuesSource;  
import java.util.ArrayList;
         * Collect the list of buckets, populate the filter with terms  
                        collectBucket(sub, docId, bucketOrdinal);
        DocValueFormat format,
            mergeBuckets(mergeMap, offset);
import org.opensearch.search.DocValueFormat;  
                    }
        return new LeafBucketCollectorBase(sub, values) {  
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        int maxDocCount,  
        InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];  
 *
import java.util.Arrays;  
 * Modifications Copyright OpenSearch Contributors. See  
                        keepCount++;
        ValuesSource.Numeric valuesSource,
         * Only merge/delete the ordinals if we have actually deleted one,
            }
                    }
 * not use this file except in compliance with the License.
                Arrays.asList(rarestPerOrd[ordIdx]),
 * under the License.  
        return result;
                        builtBuckets.add(bucket);
    }
        /*
package org.opensearch.search.aggregations.bucket.terms;
            public void collect(int docId, long owningBucketOrd) throws IOException {
            }
import org.opensearch.common.lease.Releasables;  
            }
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
                        LongRareTerms.Bucket bucket = new LongRareTerms.Bucket(collectedBuckets.value(), docCount, null, format);
 * Unless required by applicable law or agreed to in writing,
                maxDocCount,  
import org.opensearch.search.internal.SearchContext;
            if (deferringCollector != null) {  
    }  
        };  
                super.collectRange(min, max);
                    if (filter != null && false == filter.accept(val)) {
        IncludeExclude.LongFilter filter,
import org.apache.lucene.search.DocIdStream;
        this.valuesSource = valuesSource;  
        long[] mergeMap = new long[(int) bucketOrds.size()];  
 */
        SetBackedScalingCuckooFilter[] filters = new SetBackedScalingCuckooFilter[owningBucketOrds.length];
 */
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
 * You may obtain a copy of the License at  
import static java.util.Collections.emptyList;
import org.opensearch.search.aggregations.support.ValuesSource;
}
 * The OpenSearch Contributors require contributions made to  
            result[ordIdx] = new LongRareTerms(  
import org.opensearch.search.aggregations.LeafBucketCollector;
                name,
/*
 * KIND, either express or implied.  See the License for the
                ORDER,
    protected SortedNumericDocValues getValues(ValuesSource.Numeric valuesSource, LeafReaderContext ctx) throws IOException {
                deferringCollector.mergeBuckets(mergeMap);
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            }  
        String name,
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                filters[owningOrdIdx] = newFilter();  
 *  
    private final LongKeyedBucketOrds bucketOrds;
        LongRareTerms.Bucket[][] rarestPerOrd = new LongRareTerms.Bucket[owningBucketOrds.length][];  
        if (keepCount != mergeMap.length) {
                    if (docCount <= maxDocCount) {  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
        Aggregator parent,
 * Licensed to Elasticsearch under one or more contributor  
                offset += bucketsInThisOwningBucketToCollect.size();
         */
