        AggregatorFactories factories,
 * under the License.
            mergeBuckets(mergeMap, offset);
                    previous.copyBytes(bytes);
import org.opensearch.search.aggregations.support.ValuesSource;
            final BytesRefBuilder previous = new BytesRefBuilder();
                while (collectedBuckets.next()) {
    private final IncludeExclude.StringFilter filter;
                deferringCollector.mergeBuckets(mergeMap);
        if (keepCount != mergeMap.length) {
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.opensearch.search.aggregations.AggregatorFactories;
            BytesRef missingFieldTerm = new BytesRef(missingField);
 *    http://www.apache.org/licenses/LICENSE-2.0
            // The optimization does not work when there are subaggregations.
            }
         * Only merge/delete the ordinals if we have actually deleted one,
        return new StringRareTerms(name, LongRareTermsAggregator.ORDER, metadata(), format, emptyList(), 0, newFilter());
                long bucketOrdinal = bucketOrds.add(0L, missingFieldTerm);
            if (deferringCollector != null) {
 * not use this file except in compliance with the License.
            // This segment has at least one document with the _doc_count field.
                for (int i = 0; i < valuesCount; ++i) {
        this.bucketOrds = BytesKeyedBucketOrds.build(context.bigArrays(), cardinality);
    @Override
 *
        BytesRef stringTerm = stringTermsEnum.next();
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
 * KIND, either express or implied.  See the License for the
        Map<String, Object> metadata,
import java.util.Arrays;
            return false;
 *
                format,
                incrementBucketDocCount(bucketOrdinal, stringTermsEnum.docFreq());
                        continue;
                filters[owningOrdIdx] = newFilter();
    private final BytesKeyedBucketOrds bucketOrds;
 * specific language governing permissions and limitations
import org.opensearch.search.internal.SearchContext;
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            @Override
        if (subAggregators.length > 0) {
            }
                    long docCount = bucketDocCount(collectedBuckets.ord());
            // Field is not indexed.
            if (weight.count(ctx) == 0) {
                        keepCount++;
    @Override
import org.opensearch.common.util.BytesRefHash;
        }
                    // if the key is below threshold, reinsert into the new ords
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.index.DocValues;
        StringRareTerms.Bucket[][] rarestPerOrd = new StringRareTerms.Bucket[owningBucketOrds.length][];
import org.apache.lucene.index.Terms;
import org.opensearch.search.aggregations.CardinalityUpperBound;
        CardinalityUpperBound cardinality,
 * SPDX-License-Identifier: Apache-2.0
        long offset = 0;
            // query matches all documents in the segment.
                long bucketOrdinal = bucketOrds.add(0L, stringTerm);
                    }
    protected final String fieldName;
/*
        long maxDocCount,
        for (int owningOrdIdx = 0; owningOrdIdx < owningBucketOrds.length; owningOrdIdx++) {
        String name,
 * ownership. Elasticsearch licenses this file to you under
        /*
                metadata(),
                // SortedBinaryDocValues don't guarantee uniqueness so we
                previous.clear();
        return true;
                        bucket.bucketOrd = offset + bucketsInThisOwningBucketToCollect.add(scratch);
import org.apache.lucene.search.Weight;
            );
                    if (docCount <= maxDocCount) {
        /*
        SearchContext context,
        return new LeafBucketCollectorBase(sub, values) {
                        bucketOrdinal = -1 - bucketOrdinal;
         * to save on some redundant work.
                    long bucketOrdinal = bucketOrds.add(owningBucketOrd, bytes);
                        continue;
import org.apache.lucene.util.BytesRef;
                    bucketOrdinal = -1 - bucketOrdinal;
 * software distributed under the License is distributed on an
            Arrays.sort(rarestPerOrd[ordIdx], ORDER.comparator());
                maxDocCount,
    }
                    } else {
/*
                    }
    public void doClose() {
            }
    public InternalAggregation buildEmptyAggregation() {
        }
    private final ValuesSource.Bytes valuesSource;
                return true;
            }
    private Weight weight;
 * this file be licensed under the Apache-2.0 license or a
            result[ordIdx] = new StringRareTerms(
                }
        this.weight = weight;
                    }
            } else if (weight.count(ctx) != ctx.reader().maxDoc()) {
    public void setWeight(Weight weight) {
                ORDER,
    @Override
                }
                        mergeMap[(int) collectedBuckets.ord()] = bucket.bucketOrd;
import org.opensearch.index.mapper.DocCountFieldMapper;
         * Collect the list of buckets, populate the filter with terms
                        filters[owningOrdIdx].add(scratch);
            // The optimization could only be used if there are no deleted documents and the top-level
        DocValueFormat format,
import java.util.Map;
            stringTerm = stringTermsEnum.next();
                        collectExistingBucket(sub, docId, bucketOrdinal);
                }
 * this work for additional information regarding copyright
            }
    }
}
            if (missingCount > 0) {
        }
        if (weight == null) {
        InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
                return false;
import org.apache.lucene.index.LeafReaderContext;
        this.fieldName = valuesSource.getIndexFieldName();
         */
        }
 */
        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
         */
import org.apache.lucene.index.NumericDocValues;
 *
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
 */
        Aggregator parent,
        NumericDocValues docCountValues = DocValues.getNumeric(ctx.reader(), DocCountFieldMapper.NAME);
        } else {
        if (stringTerms == null) {
                checkCancelled();
                    if (i > 0 && previous.get().equals(bytes)) {
 */
 * @opensearch.internal
        Terms stringTerms = ctx.reader().terms(fieldName);
                    BytesRef bytes = values.nextValue();
            String missingField = (String) config.missing();
        }
        // Here, we are accounting for the case that there might be missing values for the field name
        return result;
                    } else {
 * the Apache License, Version 2.0 (the "License"); you may
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
 */
        buildSubAggsForAllBuckets(rarestPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
import org.apache.lucene.util.BytesRefBuilder;
        long[] mergeMap = new long[(int) bucketOrds.size()];
         */
        }
        super(name, factories, context, parent, metadata, maxDocCount, precision, format);
                List<StringRareTerms.Bucket> builtBuckets = new ArrayList<>();
                BytesRef scratch = new BytesRef();
        TermsEnum stringTermsEnum = stringTerms.iterator();
                        StringRareTerms.Bucket bucket = new StringRareTerms.Bucket(BytesRef.deepCopyOf(scratch), docCount, null, format);
 * compatible open source license.
        this.filter = filter;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.lease.Releasables;
import static java.util.Collections.emptyList;
                BytesKeyedBucketOrds.BucketOrdsEnum collectedBuckets = bucketOrds.ordsEnum(owningBucketOrds[owningOrdIdx]);
        }
                }
                filters[ordIdx]
    }
/**
            if (filter == null || filter.accept(stringTerm)) {
        SetBackedScalingCuckooFilter[] filters = new SetBackedScalingCuckooFilter[owningBucketOrds.length];
            // The query has to be a match all, otherwise
 * Modifications Copyright OpenSearch Contributors. See
import java.util.ArrayList;
        Releasables.close(bucketOrds);
 * Licensed to Elasticsearch under one or more contributor
                if (false == values.advanceExact(docId)) {
            }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
    }
        if (config != null && config.missing() != null) {
                    }
        Arrays.fill(mergeMap, -1);
        };
                rarestPerOrd[owningOrdIdx] = builtBuckets.toArray(new StringRareTerms.Bucket[0]);
            return false;
         * Now build the results!
                offset += bucketsInThisOwningBucketToCollect.size();
import java.io.IOException;
        double precision,
            public void collect(int docId, long owningBucketOrd) throws IOException {
        }
import org.apache.lucene.index.TermsEnum;
                if (bucketOrdinal < 0) { // already seen
    private final ValuesSourceConfig config;
        if (docCountValues.nextDoc() != NO_MORE_DOCS) {
    }
    }
            return false;
                // need to take care of dups
import org.opensearch.search.aggregations.InternalAggregation;
public class StringRareTermsAggregator extends AbstractRareTermsAggregator {
        ValuesSource.Bytes valuesSource,
        this.valuesSource = valuesSource;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                    return;
        IncludeExclude.StringFilter filter,
import java.util.List;
 * An aggregator that finds "rare" string values (e.g. terms agg that orders ascending)
    @Override
                    if (filter != null && false == filter.accept(bytes)) {
import org.opensearch.search.aggregations.Aggregator;
                // We will not have to worry about adding to a bucket that was already seen.
        while (stringTerm != null) {
            return false;
package org.opensearch.search.aggregations.bucket.terms;
        this.config = config;
                    collectedBuckets.readValue(scratch);
    }
                Arrays.asList(rarestPerOrd[ordIdx]),
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
                int valuesCount = values.docValueCount();
            int missingCount = weight.count(ctx) - ctx.reader().getDocCount(fieldName);
 * GitHub history for details.
                incrementBucketDocCount(bucketOrdinal, missingCount);
                    if (bucketOrdinal < 0) { // already seen
         * that are too frequent, and figure out how to merge sub-buckets.
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                // Since the bucket name for the missing documents is not indexed as a potential value for that field,
    ) throws IOException {
        ValuesSourceConfig config
    StringRareTermsAggregator(
                        builtBuckets.add(bucket);
 *
 * Unless required by applicable law or agreed to in writing,
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
/*
                        collectBucket(sub, docId, bucketOrdinal);
        long keepCount = 0;
import org.opensearch.search.DocValueFormat;
    @Override
                name,
            try (BytesRefHash bucketsInThisOwningBucketToCollect = new BytesRefHash(context.bigArrays())) {
        /*
        // Here, we will iterate over all the terms in the segment and add the counts into the bucket.
