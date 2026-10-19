        ValuesSource.Bytes valuesSource,
import java.util.List;  
        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
        /*
            }
                    return;  
        SetBackedScalingCuckooFilter[] filters = new SetBackedScalingCuckooFilter[owningBucketOrds.length];
        }
         */
        return result;  
                // need to take care of dups  
import org.opensearch.index.mapper.DocCountFieldMapper;  
    @Override  
        String name,
                    if (bucketOrdinal < 0) { // already seen
        this.config = config;
    }
        }
                name,  
        long keepCount = 0;
    protected final String fieldName;
                }
                        continue;
                        continue;
            // query matches all documents in the segment.
import java.util.Map;
        return true;  
            return false;  
                offset += bucketsInThisOwningBucketToCollect.size();
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
    @Override  
import org.apache.lucene.util.BytesRef;  
    public InternalAggregation buildEmptyAggregation() {
        buildSubAggsForAllBuckets(rarestPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            final BytesRefBuilder previous = new BytesRefBuilder();
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
            @Override  
 * Unless required by applicable law or agreed to in writing,
        while (stringTerm != null) {
 * Modifications Copyright OpenSearch Contributors. See  
                        keepCount++;
            }  
            } else if (weight.count(ctx) != ctx.reader().maxDoc()) {
                }
                        bucketOrdinal = -1 - bucketOrdinal;  
                long bucketOrdinal = bucketOrds.add(0L, stringTerm);
        if (stringTerms == null) {
        AggregatorFactories factories,  
                }
            BytesRef missingFieldTerm = new BytesRef(missingField);  
        // Here, we are accounting for the case that there might be missing values for the field name  
            return false;  
 * KIND, either express or implied.  See the License for the
/*  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 *
    StringRareTermsAggregator(
        this.bucketOrds = BytesKeyedBucketOrds.build(context.bigArrays(), cardinality);  
        this.fieldName = valuesSource.getIndexFieldName();
        }
import org.opensearch.common.util.SetBackedScalingCuckooFilter;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
import org.opensearch.search.aggregations.InternalAggregation;
        }
            // The query has to be a match all, otherwise
                    if (i > 0 && previous.get().equals(bytes)) {  
    @Override
                format,  
            );
            }
         * Only merge/delete the ordinals if we have actually deleted one,  
import org.opensearch.search.aggregations.support.ValuesSource;
            String missingField = (String) config.missing();
                filters[ordIdx]  
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        StringRareTerms.Bucket[][] rarestPerOrd = new StringRareTerms.Bucket[owningBucketOrds.length][];  
import java.util.Arrays;
                // Since the bucket name for the missing documents is not indexed as a potential value for that field,  
        this.filter = filter;
import org.opensearch.common.util.BytesRefHash;  
        long maxDocCount,
 * under the License.  
                deferringCollector.mergeBuckets(mergeMap);  
                while (collectedBuckets.next()) {
 *
         */
                        collectExistingBucket(sub, docId, bucketOrdinal);
        /*
        /*
                    long docCount = bucketDocCount(collectedBuckets.ord());  
        if (weight == null) {  
package org.opensearch.search.aggregations.bucket.terms;
    public void doClose() {  
                previous.clear();  
                int valuesCount = values.docValueCount();
            public void collect(int docId, long owningBucketOrd) throws IOException {
    }
                        bucket.bucketOrd = offset + bucketsInThisOwningBucketToCollect.add(scratch);
        long[] mergeMap = new long[(int) bucketOrds.size()];  
        Arrays.fill(mergeMap, -1);
                List<StringRareTerms.Bucket> builtBuckets = new ArrayList<>();
        }
            // The optimization does not work when there are subaggregations.
        if (config != null && config.missing() != null) {
        double precision,
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
 * this work for additional information regarding copyright
                metadata(),
import org.apache.lucene.util.BytesRefBuilder;
 * GitHub history for details.
            mergeBuckets(mergeMap, offset);
            result[ordIdx] = new StringRareTerms(
 */
        Aggregator parent,
                Arrays.asList(rarestPerOrd[ordIdx]),
import org.apache.lucene.index.NumericDocValues;
         * that are too frequent, and figure out how to merge sub-buckets.
                    collectedBuckets.readValue(scratch);
 *  
                filters[owningOrdIdx] = newFilter();  
/*
        long offset = 0;
import org.opensearch.search.aggregations.Aggregator;
        // Here, we will iterate over all the terms in the segment and add the counts into the bucket.
                        StringRareTerms.Bucket bucket = new StringRareTerms.Bucket(BytesRef.deepCopyOf(scratch), docCount, null, format);  
        return new LeafBucketCollectorBase(sub, values) {  
        DocValueFormat format,
            if (weight.count(ctx) == 0) {
                        collectBucket(sub, docId, bucketOrdinal);  
        this.weight = weight;  
 */
import org.opensearch.search.internal.SearchContext;
    }
 * this file be licensed under the Apache-2.0 license or a
                ORDER,
 * An aggregator that finds "rare" string values (e.g. terms agg that orders ascending)
            return false;  
         */  
                    previous.copyBytes(bytes);  
            // The optimization could only be used if there are no deleted documents and the top-level  
        BytesRef stringTerm = stringTermsEnum.next();
import org.opensearch.search.DocValueFormat;
import org.opensearch.common.lease.Releasables;
 * @opensearch.internal  
            // This segment has at least one document with the _doc_count field.
 *
        super(name, factories, context, parent, metadata, maxDocCount, precision, format);  
                    } else {
                    }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
                // SortedBinaryDocValues don't guarantee uniqueness so we
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.LeafReaderContext;
        NumericDocValues docCountValues = DocValues.getNumeric(ctx.reader(), DocCountFieldMapper.NAME);  
                maxDocCount,
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }  
            if (missingCount > 0) {
        } else {
    public void setWeight(Weight weight) {
                for (int i = 0; i < valuesCount; ++i) {
                BytesRef scratch = new BytesRef();  
            try (BytesRefHash bucketsInThisOwningBucketToCollect = new BytesRefHash(context.bigArrays())) {
public class StringRareTermsAggregator extends AbstractRareTermsAggregator {
                incrementBucketDocCount(bucketOrdinal, stringTermsEnum.docFreq());
                    }
        CardinalityUpperBound cardinality,  
                BytesKeyedBucketOrds.BucketOrdsEnum collectedBuckets = bucketOrds.ordsEnum(owningBucketOrds[owningOrdIdx]);
 * compatible open source license.
import org.apache.lucene.search.Weight;
            if (deferringCollector != null) {
                    if (docCount <= maxDocCount) {
    @Override  
/*
        InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
         * Now build the results!
    @Override
import org.apache.lucene.index.TermsEnum;
                long bucketOrdinal = bucketOrds.add(0L, missingFieldTerm);
        Terms stringTerms = ctx.reader().terms(fieldName);  
            }  
                if (bucketOrdinal < 0) { // already seen
        TermsEnum stringTermsEnum = stringTerms.iterator();  
/**  
                rarestPerOrd[owningOrdIdx] = builtBuckets.toArray(new StringRareTerms.Bucket[0]);  
        if (subAggregators.length > 0) {  
                // We will not have to worry about adding to a bucket that was already seen.
                incrementBucketDocCount(bucketOrdinal, missingCount);  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
                    bucketOrdinal = -1 - bucketOrdinal;  
        }
            stringTerm = stringTermsEnum.next();
        for (int owningOrdIdx = 0; owningOrdIdx < owningBucketOrds.length; owningOrdIdx++) {  
         * to save on some redundant work.
                checkCancelled();
            Arrays.sort(rarestPerOrd[ordIdx], ORDER.comparator());
                if (false == values.advanceExact(docId)) {
                        filters[owningOrdIdx].add(scratch);  
                    // if the key is below threshold, reinsert into the new ords
import java.util.ArrayList;
        SearchContext context,
        IncludeExclude.StringFilter filter,  
                return false;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> metadata,  
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.apache.lucene.index.Terms;  
                        builtBuckets.add(bucket);  
    private final ValuesSourceConfig config;
 * license agreements. See the NOTICE file distributed with
        return new StringRareTerms(name, LongRareTermsAggregator.ORDER, metadata(), format, emptyList(), 0, newFilter());
        this.valuesSource = valuesSource;
                return true;  
    private final IncludeExclude.StringFilter filter;
            int missingCount = weight.count(ctx) - ctx.reader().getDocCount(fieldName);
    private final BytesKeyedBucketOrds bucketOrds;  
                    long bucketOrdinal = bucketOrds.add(owningBucketOrd, bytes);
        Releasables.close(bucketOrds);
import org.apache.lucene.index.DocValues;  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import org.opensearch.search.aggregations.AggregatorFactories;  
            }
        if (keepCount != mergeMap.length) {  
        }  
        if (docCountValues.nextDoc() != NO_MORE_DOCS) {
            return false;
                    }
        ValuesSourceConfig config
                    BytesRef bytes = values.nextValue();
        };
import java.io.IOException;  
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    } else {
            if (filter == null || filter.accept(stringTerm)) {  
import org.opensearch.search.aggregations.LeafBucketCollector;  
 * You may obtain a copy of the License at  
import static java.util.Collections.emptyList;  
 * Licensed to Elasticsearch under one or more contributor  
    ) throws IOException {
                    if (filter != null && false == filter.accept(bytes)) {  
 */
 * specific language governing permissions and limitations
                        mergeMap[(int) collectedBuckets.ord()] = bucket.bucketOrd;
    private Weight weight;
                }
         * Collect the list of buckets, populate the filter with terms  
}  
 */  
            }  
    }
    }
            // Field is not indexed.
    private final ValuesSource.Bytes valuesSource;  
                    }
