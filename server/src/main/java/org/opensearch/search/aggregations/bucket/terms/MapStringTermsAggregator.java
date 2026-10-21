         * this bucket ordinal.
         * information that this result type may need.
         * delegate to {@link #buildSubAggsForAllBuckets}.
public class MapStringTermsAggregator extends AbstractStringTermsAggregator {
 * specific language governing permissions and limitations
        void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {
            spare.bucketOrd = ordsEnum.ord();
                        spare = emptyBucketBuilder.get();
import org.apache.lucene.util.PriorityQueue;
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
     * @opensearch.internal
        void finalizeBucket(SignificantStringTerms.Bucket bucket) {
                bucketCountThresholds.getShardSize(),
                format,
            );
            collectorSource.getLeafCollector(
        }
    private final ResultStrategy<?, ?> resultStrategy;
        @Override
        void finalizeBucket(StringTerms.Bucket bucket) {
import java.util.function.LongConsumer;
    public static class ValuesSourceCollectorSource implements CollectorSource {
     * @opensearch.internal
 * KIND, either express or implied.  See the License for the
        @Override
         */
            SignificanceHeuristic significanceHeuristic,
    }
        @Override
    /**
            spare.supersetSize = supersetSize;
                subsetSizes.get(owningBucketOrd),
                sub,
        @Override
            }
     * Strategy for building results.
        AggregatorFactories factories,
                checkCancelled();
                    for (int i = 0; i < valuesCount; ++i) {
        BucketCountThresholds bucketCountThresholds,
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
     *
                                bucketOrds.add(owningBucketOrd, term);
            ordsEnum.readValue(spare.termBytes);
 * than up front like the {@link GlobalOrdinalsStringTermsAggregator}.
        String describe() {
import org.opensearch.common.util.LongArray;
}
        public LeafBucketCollector getLeafCollector(
            return "significant_terms";
                            continue;
                    }
                result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCounts[ordIdx], topBucketsPerOrd[ordIdx]);
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        @Override
         * output to help with debugging.
        return super.scoreMode();
        abstract B[] buildBuckets(int size);
        super.collectDebugInfo(add);
                    }
                0,
    @Override
        void accept(LeafBucketCollector sub, int doc, long owningBucketOrd, BytesRef bytes) throws IOException;
        Map<String, Object> metadata
import java.util.Map;
            if (isKeyOrder(order) == false) {
            bucket.termBytes = BytesRef.deepCopyOf(bucket.termBytes);
        }
        @Override
                BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
        }
                        for (int i = 0; i < valueCount; ++i) {
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, a) -> b.aggregations = a);
        @Override
         * Finalize building a bucket. Called once we know that the bucket will
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
        }
        }
 * An aggregator of string values that hashes the strings on the fly rather
        @Override
        private final SignificanceHeuristic significanceHeuristic;
             * bucketOrds which will be invalid once the aggregation is
                    if (values.advanceExact(docId)) {
    public void doClose() {
        String describe() {
                    topBucketsPerOrd[ordIdx][i] = ordered.pop();
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
            LongConsumer addRequestCircuitBreakerBytes,
        abstract PriorityQueue<B> buildPriorityQueue(int size);
                            }
/**
            this.valuesSource = valuesSource;
 */
        void buildSubAggs(SignificantStringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
            long[] otherDocCounts = new long[owningBucketOrds.length];
        private final BackgroundFrequencyForBytes backgroundFrequencies;
    /**
                return;
         */
            }
        void updateBucket(StringTerms.Bucket spare, BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum, long docCount) throws IOException {
            InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
import org.opensearch.common.lease.Releasables;
            }
            ordsEnum.readValue(spare.termBytes);
        abstract void updateBucket(B spare, BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum, long docCount) throws IOException;
/*
        LeafBucketCollector getLeafCollector(
import org.opensearch.search.aggregations.LeafBucketCollector;
        private LongArray subsetSizes = context.bigArrays().newLongArray(1, true);
        }
         * Build an empty temporary bucket.
        }
 *
        }
                return;
                name,
                            if (includeExclude == null || includeExclude.accept(term)) {
import java.util.function.BiConsumer;
         * shard.
                // brute force
        }
     */
                collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
    private final IncludeExclude.StringFilter includeExclude;
         * Build a {@link PriorityQueue} to sort the buckets. After we've
        /**
        Supplier<SignificantStringTerms.Bucket> emptyBucketBuilder(long owningBucketOrd) {
        /**
        }
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
                    int valuesCount = values.docValueCount();
         * Update fields in {@code spare} to reflect information collected for
            // we need to fill-in the blanks
            return new LeafBucketCollectorBase(sub, values) {
                while (ordsEnum.next()) {
            B[][] topBucketsPerOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
        public void close() {
                order,
     */
                    } else {
        }
        StringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            this.significanceHeuristic = significanceHeuristic;
                        }
import org.opensearch.search.aggregations.AggregatorFactories;
        @Override
                reduceOrder = order;
            spare.subsetDf = docCount;
        PriorityQueue<SignificantStringTerms.Bucket> buildPriorityQueue(int size) {
        PriorityQueue<StringTerms.Bucket> buildPriorityQueue(int size) {
    @Override
    }
        ) throws IOException;
        }
         */
        abstract B[][] buildTopBucketsPerOrd(int size);
    ) throws IOException {
        return resultStrategy.buildAggregations(owningBucketOrds);
        SignificantStringTerms.Bucket[] buildBuckets(int size) {
        Releasables.close(collectorSource, resultStrategy, bucketOrds);
                        collectExistingBucket(s, doc, bucketOrdinal);
         * Build the sub-aggregations into the buckets. This will usually
        }
    }
        }
                    }
        abstract void buildSubAggs(B[][] topBucketsPerOrd) throws IOException;
        BucketOrder order,
        void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {}
                    spare = ordered.insertWithOverflow(spare);
import org.opensearch.search.internal.SearchContext;
                significanceHeuristic,
        }
            buildSubAggs(topBucketsPerOrd);
         */
                @Override
                }
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        );
                    if (spare == null) {
            LeafReaderContext ctx,
        /**
             */
 * compatible open source license.
     *
            SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
     */
        SignificantStringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            LeafReaderContext ctx,
    @Override
            backgroundFrequencies = significanceLookup.bytesLookup(context.bigArrays(), cardinality);
                }
        @Override
    /**
         * Build an "empty" result. Only called if there isn't any data on this
                    super.collect(doc, owningBucketOrd);
                int size = (int) Math.min(bucketOrds.size(), localBucketCountThresholds.getRequiredSize());
 * ownership. Elasticsearch licenses this file to you under
                @Override
            CollectConsumer consumer
import org.opensearch.search.aggregations.BucketOrder;
 * this work for additional information regarding copyright
        this.includeExclude = includeExclude;
                }
    public void collectDebugInfo(BiConsumer<String, Object> add) {
import org.apache.lucene.util.BytesRefBuilder;
             * properties will be updated with global stats.
        private InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                format,
        CollectorSource collectorSource,
 * SPDX-License-Identifier: Apache-2.0
 */
            return primary;
    /**
                }
        private final ValuesSource valuesSource;
/*
            supersetSize = significanceLookup.supersetSize();
         */
        @Override
import org.apache.lucene.index.LeafReaderContext;
            return "terms";
                    subsetSizes.increment(owningBucketOrd, 1);
    private final BytesKeyedBucketOrds bucketOrds;
            Releasables.close(backgroundFrequencies, subsetSizes);
        SignificantTermsResults(
                bucketCountThresholds
    }
        @Override
            IncludeExclude.StringFilter includeExclude,
        StandardTermsResults(ValuesSource valuesSource) {
 *
        ) {
                bucketCountThresholds
                            BytesRef term = values.nextValue();
                final BytesRefBuilder previous = new BytesRefBuilder();
        void updateBucket(SignificantStringTerms.Bucket spare, BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum, long docCount)
            SignificanceLookup significanceLookup,
    public MapStringTermsAggregator(
                    finalizeBucket(topBucketsPerOrd[ordIdx][i]);
        }
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
     * Builds results for the {@code significant_terms} aggregation.
            CollectConsumer consumer
        abstract Supplier<B> emptyBucketBuilder(long owningBucketOrd);
    }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            if (bucketCountThresholds.getMinDocCount() != 0) {
        StringTerms.Bucket[] buildBuckets(int size) {
            return new SignificantStringTerms.Bucket[size];
     */
        /**
    /**
                (s, doc, owningBucketOrd, bytes) -> {
        }
                this::addRequestCircuitBreakerBytes,
        }
        @Override
 *
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, a) -> b.aggregations = a);
        @Override
                reduceOrder,
        @Override
    class SignificantTermsResults extends ResultStrategy<SignificantStringTerms, SignificantStringTerms.Bucket> {
        ) throws IOException {
                        if (i > 0 && previous.get().equals(bytes)) {
         */
             * termBytes contains a reference to the bytes held by the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.lease.Releasable;
        @Override
    }
                        BytesRef bytes = values.nextValue();
        private final ValuesSource valuesSource;
            return new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
        }
        @Override
        void buildSubAggs(StringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
        @Override
import java.io.IOException;
            return new LeafBucketCollectorBase(primary, null) {
        Supplier<StringTerms.Bucket> emptyBucketBuilder(long owningBucketOrd) {
        public ValuesSourceCollectorSource(ValuesSource valuesSource) {
     */
        }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
        abstract R buildEmptyResult();
 * under the License.
                Arrays.asList(topBuckets),
import org.opensearch.search.aggregations.support.ValuesSource;
                showTermDocCountError,
            } else {
            /*
    }
     * Builds results for the standard {@code terms} aggregation.
    }
import org.opensearch.search.aggregations.InternalOrder;
                    }
                otherDocCount,
        @Override
        super(name, factories, context, parent, order, format, bucketCountThresholds, collectionMode, showTermDocCountError, metadata);
        boolean showTermDocCountError,
        }
            return new BucketSignificancePriorityQueue<>(size);
            IncludeExclude.StringFilter includeExclude,
import org.opensearch.search.aggregations.Aggregator;
        }
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        StringTerms buildEmptyResult() {
        DocValueFormat format,
     * @opensearch.internal
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
 * not use this file except in compliance with the License.
        SubAggCollectionMode collectionMode,
 * Modifications Copyright OpenSearch Contributors. See
        /**
                metadata(),
        implements
        abstract R buildResult(long owningBucketOrd, long otherDocCount, B[] topBuckets);
                        bucketOrdinal = -1 - bucketOrdinal;
            final BucketOrder reduceOrder;
import org.opensearch.search.aggregations.bucket.terms.SignificanceLookup.BackgroundFrequencyForBytes;
                        if (includeExclude != null && false == includeExclude.accept(bytes)) {
                }
            spare.supersetDf = backgroundFrequencies.freq(spare.termBytes);
        @Override
        /**
         * results. The populated list is passed to {@link #buildResult}.
    public interface CollectConsumer {
        @Override
                    if (docCount < localBucketCountThresholds.getMinDocCount()) {
     * Consumer for the collector
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
                Arrays.asList(topBuckets),
        /**
        @Override
    public InternalAggregation buildEmptyAggregation() {
             * termBytes contains a reference to the bytes held by the
            return ScoreMode.COMPLETE;
 * The OpenSearch Contributors require contributions made to
        /**
    public interface CollectorSource extends Releasable {
 * software distributed under the License is distributed on an
import java.util.function.Supplier;
            /*
            };
            long subsetSize = subsetSizes.get(owningBucketOrd);
 */
            };
             */
                    previous.clear();
        }
             * closed so we have to copy it.
            CardinalityUpperBound cardinality
                PriorityQueue<B> ordered = buildPriorityQueue(size);
                Supplier<B> emptyBucketBuilder = emptyBucketBuilder(owningBucketOrds[ordIdx]);
        abstract void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException;
        /**
    @Override
        bucketOrds = BytesKeyedBucketOrds.build(context.bigArrays(), cardinality);
    abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
/*
        String name,
            );
                        int valueCount = values.docValueCount();
        }
                        collectBucket(s, doc, bucketOrdinal);
        }
        SearchContext context,
    private final CollectorSource collectorSource;
        public boolean needsScores() {
 * You may obtain a copy of the License at
            Releasable {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        @Override
     */
                    }
                    if (bucketOrdinal < 0) { // already seen
                            continue;
        }
                    // SortedBinaryDocValues don't guarantee uniqueness so we
        SignificantStringTerms buildResult(long owningBucketOrd, long otherDocCount, SignificantStringTerms.Bucket[] topBuckets) {
        @Override
            }
    }
                        consumer.accept(sub, doc, owningBucketOrd, bytes);
        abstract void finalizeBucket(B bucket);
 * license agreements. See the NOTICE file distributed with
                    if (false == values.advanceExact(doc)) {
                        }
        }
    }
 */
import org.apache.lucene.search.ScoreMode;
import org.opensearch.search.aggregations.CardinalityUpperBound;
         * Turn the buckets into an aggregation result.
        @Override
    }
         */
        /**
         * and required.
        boolean needsScores();
             * During shard-local down-selection we use subset/superset stats
import org.apache.lucene.util.BytesRef;
        }
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        @Override
            throws IOException {
    class StandardTermsResults extends ResultStrategy<StringTerms, StringTerms.Bucket> {
            }
            spare.bucketOrd = ordsEnum.ord();
         * Build an array to hold the "top" buckets for each ordinal.
                    updateBucket(spare, ordsEnum, docCount);
                    }
        @Override
    public ScoreMode scoreMode() {
                for (int i = ordered.size() - 1; i >= 0; --i) {
        return resultStrategy.wrapCollector(
            return new StringTerms.Bucket[size][];
            return new SignificantStringTerms(
    }
 * GitHub history for details.
                reduceOrder = InternalOrder.key(true);
             * bucketOrds which will be invalid once the aggregation is
            return () -> new StringTerms.Bucket(new BytesRef(), 0, null, showTermDocCountError, 0, format);
        IncludeExclude.StringFilter includeExclude,
        public void close() {}
                        }
        /**
                Arrays.sort(topBuckets, reduceOrder.comparator());
         * Short description of the collection mechanism added to the profile
        Aggregator parent,
        this.collectorSource = collectorSource;
                    otherDocCounts[ordIdx] -= topBucketsPerOrd[ordIdx][i].getDocCount();
package org.opensearch.search.aggregations.bucket.terms;
            /*
        }
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
    @FunctionalInterface
 *
import org.opensearch.search.DocValueFormat;
        @Override
import java.util.function.Function;
     *
                topBucketsPerOrd[ordIdx] = buildBuckets(ordered.size());
 * Licensed to Elasticsearch under one or more contributor
                ctx,
    }
                        previous.copyBytes(bytes);
 * Unless required by applicable law or agreed to in writing,
            return new SignificantStringTerms.Bucket[size][];
                supersetSize,
    @Override
            LongConsumer addRequestCircuitBreakerBytes,
            return buildEmptySignificantTermsAggregation(0, significanceHeuristic);
            spare.updateScore(significanceHeuristic);
            LeafBucketCollector sub,
     * Abstaction on top of building collectors to fetch values.
     * Fetch values from a {@link ValuesSource}.
         */
         */
             * closed so we have to copy it.
            return new StringTerms(
            bucket.termBytes = BytesRef.deepCopyOf(bucket.termBytes);
        public void close() {}
        }
                SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
 * @opensearch.internal
            this.valuesSource = valuesSource;
         */
                    // need to take care of dups
            }
         * Collect extra entries for "zero" hit documents if they were requested
        CardinalityUpperBound cardinality,
             */
        if (collectorSource.needsScores()) {
         * Wrap the "standard" numeric terms collector to collect any more
            )
                        continue;
            return () -> new SignificantStringTerms.Bucket(new BytesRef(), 0, subsetSize, 0, 0, null, format, 0);
                    long bucketOrdinal = bucketOrds.add(owningBucketOrd, bytes);
        private final long supersetSize;
        @Override
        add.accept("total_buckets", bucketOrds.size());
            return buildEmptyTermsAggregation();
                    long docCount = bucketDocCount(ordsEnum.ord());
             * that are for this shard only. Back at the central reducer these
                    otherDocCounts[ordIdx] += docCount;
        /**
    /**
                        return;
            spare.docCount = docCount;
        abstract String describe();
            return result;
            LeafBucketCollector sub,
         * collected all of the buckets we'll collect all entries in the queue.
                includeExclude,
                public void collect(int doc, long owningBucketOrd) throws IOException {
        return resultStrategy.buildEmptyResult();
            return new StringTerms.Bucket[size];
        add.accept("result_strategy", resultStrategy.describe());
         */
                name,
                B spare = null;
        }
        StringTerms buildResult(long owningBucketOrd, long otherDocCount, StringTerms.Bucket[] topBuckets) {
                public void collect(int doc, long owningBucketOrd) throws IOException {
            return valuesSource.needsScores();
        Function<MapStringTermsAggregator, ResultStrategy<?, ?>> resultStrategy,
         */
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
        SignificantStringTerms buildEmptyResult() {
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
                }
                    subsetSizes = context.bigArrays().grow(subsetSizes, owningBucketOrd + 1);
                metadata(),
         * be included in the results.
         * Build an array of buckets for a particular ordinal to collect the
