         * output to help with debugging.
         */
                    if (bucketOrdinal < 0) { // already seen
                    topBucketsPerOrd[ordIdx][i] = ordered.pop();
             * closed so we have to copy it.
                    }
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
            }
 * the Apache License, Version 2.0 (the "License"); you may
        }
     *  
        IncludeExclude.StringFilter includeExclude,
                name,  
        }  
            return new SignificantStringTerms.Bucket[size][];  
                collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);  
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
        }
         * Update fields in {@code spare} to reflect information collected for  
                    if (spare == null) {
/*  
                        for (int i = 0; i < valueCount; ++i) {  
         */  
 */
            return new StringTerms(
    }
         */
        private final SignificanceHeuristic significanceHeuristic;
    ) throws IOException {
        public ValuesSourceCollectorSource(ValuesSource valuesSource) {  
            SignificanceLookup significanceLookup,
                name,
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.ScoreMode;
        abstract void buildSubAggs(B[][] topBucketsPerOrd) throws IOException;
    public static class ValuesSourceCollectorSource implements CollectorSource {  
        void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {}
    /**
    private final CollectorSource collectorSource;  
        }
            return new StringTerms.Bucket[size];
        StandardTermsResults(ValuesSource valuesSource) {
    }
        }
        abstract String describe();
         * Wrap the "standard" numeric terms collector to collect any more
    @Override  
 * specific language governing permissions and limitations
                        if (i > 0 && previous.get().equals(bytes)) {  
        abstract void finalizeBucket(B bucket);
         */  
                        if (includeExclude != null && false == includeExclude.accept(bytes)) {  
             * termBytes contains a reference to the bytes held by the
        public LeafBucketCollector getLeafCollector(
            /*
 */
    @FunctionalInterface
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                }
                        }
            };  
        @Override
                supersetSize,  
                public void collect(int doc, long owningBucketOrd) throws IOException {
                    if (false == values.advanceExact(doc)) {
        /**  
        }
                        spare = emptyBucketBuilder.get();
        }
        add.accept("total_buckets", bucketOrds.size());
                    super.collect(doc, owningBucketOrd);
            } else {
         * Collect extra entries for "zero" hit documents if they were requested
 * You may obtain a copy of the License at  
                subsetSizes.get(owningBucketOrd),
 *
                }  
         * Short description of the collection mechanism added to the profile
            )
        implements  
         * and required.
     * Consumer for the collector
 * KIND, either express or implied.  See the License for the
    /**  
 * license agreements. See the NOTICE file distributed with
             * that are for this shard only. Back at the central reducer these
        }
import org.opensearch.search.aggregations.InternalOrder;
                }
 * The OpenSearch Contributors require contributions made to  
                    finalizeBucket(topBucketsPerOrd[ordIdx][i]);  
        @Override  
                return;  
        super.collectDebugInfo(add);  
            SignificanceHeuristic significanceHeuristic,
        @Override
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
                sub,  
        /**  
                    if (values.advanceExact(docId)) {
        void buildSubAggs(SignificantStringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
        }  
        @Override  
                metadata(),  
        @Override  
        @Override  
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, a) -> b.aggregations = a);
package org.opensearch.search.aggregations.bucket.terms;
                0,  
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
        abstract PriorityQueue<B> buildPriorityQueue(int size);  
    }
                    for (int i = 0; i < valuesCount; ++i) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    class SignificantTermsResults extends ResultStrategy<SignificantStringTerms, SignificantStringTerms.Bucket> {
                        collectExistingBucket(s, doc, bucketOrdinal);  
        BucketOrder order,
        abstract R buildEmptyResult();
                    subsetSizes.increment(owningBucketOrd, 1);
            Releasable {
                Supplier<B> emptyBucketBuilder = emptyBucketBuilder(owningBucketOrds[ordIdx]);  
            this.valuesSource = valuesSource;
            spare.subsetDf = docCount;
            return () -> new StringTerms.Bucket(new BytesRef(), 0, null, showTermDocCountError, 0, format);
        @Override  
 * software distributed under the License is distributed on an
     * @opensearch.internal
                includeExclude,
        }
        @Override  
            }
            Releasables.close(backgroundFrequencies, subsetSizes);
 * @opensearch.internal  
import org.opensearch.search.internal.SearchContext;
             * During shard-local down-selection we use subset/superset stats  
        return resultStrategy.wrapCollector(
                PriorityQueue<B> ordered = buildPriorityQueue(size);  
        @Override
        LeafBucketCollector getLeafCollector(  
     *
        private InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
                        return;  
        private final ValuesSource valuesSource;
            LeafReaderContext ctx,  
        return super.scoreMode();  
    public void doClose() {  
            /*
            return new StringTerms.Bucket[size][];  
        /**
        abstract void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException;
            long[] otherDocCounts = new long[owningBucketOrds.length];  
    /**
                    otherDocCounts[ordIdx] += docCount;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
         * Build an array to hold the "top" buckets for each ordinal.  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
        SearchContext context,
        @Override
            if (isKeyOrder(order) == false) {
        @Override  
     */
import org.opensearch.search.aggregations.InternalAggregation;
    }
                significanceHeuristic,
            ordsEnum.readValue(spare.termBytes);  
        /**
        @Override
                }
                    // SortedBinaryDocValues don't guarantee uniqueness so we
import org.opensearch.common.lease.Releasables;  
        @Override
            this.valuesSource = valuesSource;
import org.opensearch.common.util.LongArray;
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
        }
                    // need to take care of dups
        }
 * not use this file except in compliance with the License.
 * An aggregator of string values that hashes the strings on the fly rather  
        ) {
        Supplier<StringTerms.Bucket> emptyBucketBuilder(long owningBucketOrd) {  
        StringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
        boolean needsScores();
                (s, doc, owningBucketOrd, bytes) -> {
            return () -> new SignificantStringTerms.Bucket(new BytesRef(), 0, subsetSize, 0, 0, null, format, 0);  
        SignificantStringTerms buildResult(long owningBucketOrd, long otherDocCount, SignificantStringTerms.Bucket[] topBuckets) {  
            return new SignificantStringTerms.Bucket[size];
        }  
                    }
     */
                B spare = null;
        void finalizeBucket(SignificantStringTerms.Bucket bucket) {  
             * termBytes contains a reference to the bytes held by the
                    long docCount = bucketDocCount(ordsEnum.ord());
        @Override
         * collected all of the buckets we'll collect all entries in the queue.
 */
        SignificantStringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
    @Override
    private final IncludeExclude.StringFilter includeExclude;  
            return new BucketSignificancePriorityQueue<>(size);
        @Override
        @Override  
import java.util.function.LongConsumer;  
         * Build the sub-aggregations into the buckets. This will usually
        }
        this.collectorSource = collectorSource;
    abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
             * properties will be updated with global stats.
            final BucketOrder reduceOrder;
     * Builds results for the {@code significant_terms} aggregation.  
            supersetSize = significanceLookup.supersetSize();  
                    updateBucket(spare, ordsEnum, docCount);
        SubAggCollectionMode collectionMode,
        void updateBucket(SignificantStringTerms.Bucket spare, BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum, long docCount)  
            // we need to fill-in the blanks
        StringTerms.Bucket[] buildBuckets(int size) {
            throws IOException {
                            continue;
            CollectConsumer consumer  
         * Build a {@link PriorityQueue} to sort the buckets. After we've  
     * @opensearch.internal  
 * Unless required by applicable law or agreed to in writing,
     * Builds results for the standard {@code terms} aggregation.
             * bucketOrds which will be invalid once the aggregation is  
        }  
         * Build an "empty" result. Only called if there isn't any data on this
 * under the License.  
                Arrays.asList(topBuckets),
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    } else {
             * closed so we have to copy it.
        }
    public void collectDebugInfo(BiConsumer<String, Object> add) {
                checkCancelled();
            return new LeafBucketCollectorBase(primary, null) {
                                bucketOrds.add(owningBucketOrd, term);  
            return buildEmptySignificantTermsAggregation(0, significanceHeuristic);  
                    int valuesCount = values.docValueCount();
        /**
        abstract B[][] buildTopBucketsPerOrd(int size);
                    if (docCount < localBucketCountThresholds.getMinDocCount()) {
         * shard.
        Function<MapStringTermsAggregator, ResultStrategy<?, ?>> resultStrategy,  
    }
                        bucketOrdinal = -1 - bucketOrdinal;
        BucketCountThresholds bucketCountThresholds,  
                reduceOrder = order;  
        @Override  
                for (int i = ordered.size() - 1; i >= 0; --i) {  
import org.opensearch.search.aggregations.bucket.terms.SignificanceLookup.BackgroundFrequencyForBytes;
    }
            );
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
                // brute force
 * Licensed to Elasticsearch under one or more contributor  
        ) throws IOException;  
        void buildSubAggs(StringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
         * this bucket ordinal.
         */  
         * delegate to {@link #buildSubAggsForAllBuckets}.  
            if (bucketCountThresholds.getMinDocCount() != 0) {
 *
                SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
        /**
    /**
         * information that this result type may need.
                        int valueCount = values.docValueCount();
        }
 * SPDX-License-Identifier: Apache-2.0
    }  
        }  
                            continue;
        this.includeExclude = includeExclude;  
            long subsetSize = subsetSizes.get(owningBucketOrd);
            buildSubAggs(topBucketsPerOrd);
                        previous.copyBytes(bytes);  
        @Override
                Arrays.sort(topBuckets, reduceOrder.comparator());
                return;  
        @Override
             */
         * be included in the results.  
                bucketCountThresholds  
            spare.supersetSize = supersetSize;
            B[][] topBucketsPerOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
            /*
        String name,  
        }
            collectorSource.getLeafCollector(  
                        collectBucket(s, doc, bucketOrdinal);
            spare.bucketOrd = ordsEnum.ord();
     * @opensearch.internal
        SignificantStringTerms buildEmptyResult() {
        /**
    private final BytesKeyedBucketOrds bucketOrds;
                format,
            LeafBucketCollector sub,
            IncludeExclude.StringFilter includeExclude,
/**
        }  
        CardinalityUpperBound cardinality,  
            LeafBucketCollector sub,  
             */  
 * this work for additional information regarding copyright
     */
            }
                    }  
        abstract void updateBucket(B spare, BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum, long docCount) throws IOException;  
        Aggregator parent,  
    }  
        Map<String, Object> metadata
                        }
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
            bucket.termBytes = BytesRef.deepCopyOf(bucket.termBytes);  
            IncludeExclude.StringFilter includeExclude,
            bucket.termBytes = BytesRef.deepCopyOf(bucket.termBytes);  
         * results. The populated list is passed to {@link #buildResult}.  
     */
                format,
                            }
import org.apache.lucene.util.BytesRef;
    @Override
                otherDocCount,
    public ScoreMode scoreMode() {
        return resultStrategy.buildAggregations(owningBucketOrds);
        }
    }
         */
        private final ValuesSource valuesSource;
        void finalizeBucket(StringTerms.Bucket bucket) {  
            ordsEnum.readValue(spare.termBytes);
    private final ResultStrategy<?, ?> resultStrategy;
        @Override
import java.util.Map;  
        if (collectorSource.needsScores()) {  
 *
        }
    public InternalAggregation buildEmptyAggregation() {  
     * Abstaction on top of building collectors to fetch values.
            spare.docCount = docCount;  
    /**
        PriorityQueue<StringTerms.Bucket> buildPriorityQueue(int size) {
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        @Override
        @Override
            InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
                    otherDocCounts[ordIdx] -= topBucketsPerOrd[ordIdx][i].getDocCount();
        }
 * ownership. Elasticsearch licenses this file to you under  
}
                    }  
        private final BackgroundFrequencyForBytes backgroundFrequencies;  
        /**  
            LongConsumer addRequestCircuitBreakerBytes,
         * Build an array of buckets for a particular ordinal to collect the
         * Build an empty temporary bucket.
        @Override
                while (ordsEnum.next()) {
                bucketCountThresholds.getShardSize(),
            return "significant_terms";  
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, a) -> b.aggregations = a);
         */  
        void accept(LeafBucketCollector sub, int doc, long owningBucketOrd, BytesRef bytes) throws IOException;
/*
    @Override
        private final long supersetSize;
            return new SignificantStringTerms(
    }
        super(name, factories, context, parent, order, format, bucketCountThresholds, collectionMode, showTermDocCountError, metadata);  
        String describe() {
            return new LeafBucketCollectorBase(sub, values) {  
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;  
                public void collect(int doc, long owningBucketOrd) throws IOException {
            }
            return buildEmptyTermsAggregation();
import org.opensearch.search.aggregations.BucketOrder;  
import org.apache.lucene.util.BytesRefBuilder;  
            return "terms";
        }
        public boolean needsScores() {
                reduceOrder = InternalOrder.key(true);  
                        consumer.accept(sub, doc, owningBucketOrd, bytes);
     */
         */
            return valuesSource.needsScores();  
    }
                topBucketsPerOrd[ordIdx] = buildBuckets(ordered.size());
             * bucketOrds which will be invalid once the aggregation is  
        Supplier<SignificantStringTerms.Bucket> emptyBucketBuilder(long owningBucketOrd) {
                @Override  
    @Override
        /**  
                @Override  
        public void close() {}
    }  
     * Strategy for building results.  
        }  
            this.significanceHeuristic = significanceHeuristic;
import java.util.function.Supplier;
        @Override
                    }  
        abstract R buildResult(long owningBucketOrd, long otherDocCount, B[] topBuckets);
                    }  
import java.util.function.BiConsumer;
    public interface CollectConsumer {  
import org.opensearch.search.aggregations.AggregatorFactories;
     * Fetch values from a {@link ValuesSource}.
                    previous.clear();  
import java.util.Arrays;
                Arrays.asList(topBuckets),
            CardinalityUpperBound cardinality  
import java.io.IOException;
                        }
            }
            spare.bucketOrd = ordsEnum.ord();
            backgroundFrequencies = significanceLookup.bytesLookup(context.bigArrays(), cardinality);
        StringTerms buildResult(long owningBucketOrd, long otherDocCount, StringTerms.Bucket[] topBuckets) {  
                        BytesRef bytes = values.nextValue();
                            BytesRef term = values.nextValue();
                int size = (int) Math.min(bucketOrds.size(), localBucketCountThresholds.getRequiredSize());
    public MapStringTermsAggregator(
            LongConsumer addRequestCircuitBreakerBytes,
                metadata(),  
        boolean showTermDocCountError,
        /**  
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
        public void close() {
import org.opensearch.search.aggregations.support.ValuesSource;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 * than up front like the {@link GlobalOrdinalsStringTermsAggregator}.
 * compatible open source license.
        @Override  
/*
            spare.supersetDf = backgroundFrequencies.freq(spare.termBytes);  
    @Override  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.util.PriorityQueue;
        add.accept("result_strategy", resultStrategy.describe());
        AggregatorFactories factories,
        @Override
        @Override
        abstract B[] buildBuckets(int size);
        public void close() {}
import org.opensearch.search.DocValueFormat;  
            };
import org.opensearch.search.aggregations.Aggregator;
        abstract Supplier<B> emptyBucketBuilder(long owningBucketOrd);  
        void updateBucket(StringTerms.Bucket spare, BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum, long docCount) throws IOException {
                this::addRequestCircuitBreakerBytes,
        CollectorSource collectorSource,
            );
        @Override  
     *  
                showTermDocCountError,  
                }  
         */
    /**
            return result;  
 */  
    }  
import java.util.function.Function;
        }
        SignificantStringTerms.Bucket[] buildBuckets(int size) {
        @Override  
import org.opensearch.common.lease.Releasable;
        bucketOrds = BytesKeyedBucketOrds.build(context.bigArrays(), cardinality);
                }
                            if (includeExclude == null || includeExclude.accept(term)) {
                reduceOrder,
        }  
        );  
        PriorityQueue<SignificantStringTerms.Bucket> buildPriorityQueue(int size) {
        }  
         * Turn the buckets into an aggregation result.
        /**
import org.opensearch.search.aggregations.LeafBucketCollector;
        }
             */
            CollectConsumer consumer
            return ScoreMode.COMPLETE;
            return new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);  
        void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {  
         * Finalize building a bucket. Called once we know that the bucket will
                    subsetSizes = context.bigArrays().grow(subsetSizes, owningBucketOrd + 1);  
    public interface CollectorSource extends Releasable {  
                        continue;
                order,
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            spare.updateScore(significanceHeuristic);
        /**
 * GitHub history for details.
    class StandardTermsResults extends ResultStrategy<StringTerms, StringTerms.Bucket> {
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {  
                    long bucketOrdinal = bucketOrds.add(owningBucketOrd, bytes);  
        }
                BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
                ctx,
        String describe() {  
     */  
        ) throws IOException {
public class MapStringTermsAggregator extends AbstractStringTermsAggregator {
         */  
        Releasables.close(collectorSource, resultStrategy, bucketOrds);
        DocValueFormat format,
            return primary;  
                    spare = ordered.insertWithOverflow(spare);
        private LongArray subsetSizes = context.bigArrays().newLongArray(1, true);
            LeafReaderContext ctx,
        SignificantTermsResults(  
        return resultStrategy.buildEmptyResult();
        }
         */
import org.apache.lucene.index.LeafReaderContext;  
         */
                final BytesRefBuilder previous = new BytesRefBuilder();
                result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCounts[ordIdx], topBucketsPerOrd[ordIdx]);
                bucketCountThresholds
        StringTerms buildEmptyResult() {  
