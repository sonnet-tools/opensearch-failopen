public class LongRareTermsAggregator extends AbstractRareTermsAggregator {
         * Collect the list of buckets, populate the filter with terms
        return valuesSource.longValues(ctx);
            result[ordIdx] = new LongRareTerms(
                    }
                    } else {
                        keepCount++;
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
                    if (bucketOrdinal < 0) { // already seen
                        bucketOrdinal = -1 - bucketOrdinal;
 */
         */
import org.opensearch.search.aggregations.Aggregator;
        long offset = 0;
                while (collectedBuckets.next()) {
        Releasables.close(bucketOrds);
                super.collect(stream, owningBucketOrd);
                    // if the key is below threshold, reinsert into the new ords
 *
                filters[ordIdx]
    @Override
                super.collectRange(min, max);
 * You may obtain a copy of the License at
         * that are too frequent, and figure out how to merge sub-buckets.
/**
    public void doClose() {
                }
        this.filter = filter;
 * GitHub history for details.
                List<LongRareTerms.Bucket> builtBuckets = new ArrayList<>();
        /*
         * Only merge/delete the ordinals if we have actually deleted one,
            @Override
 * @opensearch.internal
        }
        /*
                    } else {
         * Now build the results!
                        mergeMap[(int) collectedBuckets.ord()] = bucket.bucketOrd;
        SetBackedScalingCuckooFilter[] filters = new SetBackedScalingCuckooFilter[owningBucketOrds.length];
            if (deferringCollector != null) {
    private final LongKeyedBucketOrds bucketOrds;
import org.opensearch.search.aggregations.LeafBucketCollector;
 * KIND, either express or implied.  See the License for the
                        collectExistingBucket(sub, docId, bucketOrdinal);
            public void collect(int docId, long owningBucketOrd) throws IOException {
import org.apache.lucene.search.DocIdStream;
package org.opensearch.search.aggregations.bucket.terms;
                    }
    LongRareTermsAggregator(
        return result;
        double precision,
    ) throws IOException {
            );
         */
import java.util.ArrayList;
 * this work for additional information regarding copyright
import java.util.Arrays;
import org.opensearch.search.DocValueFormat;
import java.util.Map;
                        continue;
        /*
                long previous = Long.MAX_VALUE;
 *
            }
        DocValueFormat format,
        SortedNumericDocValues values = getValues(valuesSource, ctx);
    }
 */
                checkCancelled();
                    long val = values.nextValue();
                    long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);
            }
 * An aggregator that finds "rare" string values (e.g. terms agg that orders ascending)
import org.opensearch.common.lease.Releasables;
        super(name, factories, aggregationContext, parent, metadata, maxDocCount, precision, format);
                filters[owningOrdIdx] = newFilter();
import org.opensearch.common.util.LongHash;
        String name,
                metadata(),
import org.apache.lucene.index.LeafReaderContext;
 * SPDX-License-Identifier: Apache-2.0
        return new LeafBucketCollectorBase(sub, values) {
            }
                    previous = val;
        InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
                name,
 *
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
            @Override
    private final ValuesSource.Numeric valuesSource;
        this.valuesSource = valuesSource;
 * software distributed under the License is distributed on an
        buildSubAggsForAllBuckets(rarestPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
                deferringCollector.mergeBuckets(mergeMap);
        ValuesSource.Numeric valuesSource,
 * Unless required by applicable law or agreed to in writing,
    }
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
import org.opensearch.search.aggregations.CardinalityUpperBound;
                        bucket.bucketOrd = offset + bucketsInThisOwningBucketToCollect.add(collectedBuckets.value());
import java.io.IOException;
import org.opensearch.search.internal.SearchContext;
                maxDocCount,
                }
import static java.util.Collections.emptyList;
    }
/*
    @Override
                        continue;
            public void collectRange(int min, int max) throws IOException {
        CardinalityUpperBound cardinality,
 * under the License.
        AggregatorFactories factories,
                        filters[owningOrdIdx].add(collectedBuckets.value());
                    long docCount = bucketDocCount(collectedBuckets.ord());
import org.apache.lucene.index.SortedNumericDocValues;
            Arrays.sort(rarestPerOrd[ordIdx], ORDER.comparator());
                offset += bucketsInThisOwningBucketToCollect.size();
                    if (filter != null && false == filter.accept(val)) {
    @Override
        long[] mergeMap = new long[(int) bucketOrds.size()];
import org.opensearch.search.aggregations.support.ValuesSource;
    private final IncludeExclude.LongFilter filter;
        return new LongRareTerms(name, ORDER, metadata(), format, emptyList(), 0, newFilter());
         */
/*
                if (false == values.advanceExact(docId)) {
            try (LongHash bucketsInThisOwningBucketToCollect = new LongHash(1, context.bigArrays())) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        IncludeExclude.LongFilter filter,
    public InternalAggregation buildEmptyAggregation() {
                        LongRareTerms.Bucket bucket = new LongRareTerms.Bucket(collectedBuckets.value(), docCount, null, format);
        SearchContext aggregationContext,
/*
}
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            mergeBuckets(mergeMap, offset);
                for (int i = 0; i < valuesCount; ++i) {
 * specific language governing permissions and limitations
                int valuesCount = values.docValueCount();
 */
import org.opensearch.search.aggregations.InternalAggregation;
                format,
    }
    }
        this.bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
 */
        LongRareTerms.Bucket[][] rarestPerOrd = new LongRareTerms.Bucket[owningBucketOrds.length][];
                }
         * to save on some redundant work.
                Arrays.asList(rarestPerOrd[ordIdx]),
    }
        };
                rarestPerOrd[owningOrdIdx] = builtBuckets.toArray(new LongRareTerms.Bucket[0]);
        int maxDocCount,
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
                        collectBucket(sub, docId, bucketOrdinal);
import org.opensearch.search.aggregations.AggregatorFactories;
                    }
                LongKeyedBucketOrds.BucketOrdsEnum collectedBuckets = bucketOrds.ordsEnum(owningBucketOrds[owningOrdIdx]);
        Aggregator parent,
                    if (i == 0 && previous == val) {
                    if (docCount <= maxDocCount) {
                        builtBuckets.add(bucket);
 * the Apache License, Version 2.0 (the "License"); you may
    protected SortedNumericDocValues getValues(ValuesSource.Numeric valuesSource, LeafReaderContext ctx) throws IOException {
                    }
        }
                    return;
        Map<String, Object> metadata
        for (int owningOrdIdx = 0; owningOrdIdx < owningBucketOrds.length; owningOrdIdx++) {
            }
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        Arrays.fill(mergeMap, -1);
        if (keepCount != mergeMap.length) {
                ORDER,
import java.util.List;
        long keepCount = 0;
            @Override
