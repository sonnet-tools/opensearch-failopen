            try {
                activeCollector.collect(stream, owningBucketOrd);
                    if (bits != null) {
    static class DirectCollector extends Collector {
        public void close() {
        return parent == null && subAggregators.length == 0 && valuesSourceConfig.missing() == null && valuesSourceConfig.script() == null;
        private final BigArrays bigArrays;
import org.apache.lucene.index.SortedNumericDocValues;
                    }
    Collector collector;
 * @opensearch.internal
     * @opensearch.internal
            // - false writableStackTrace: disable expensive stack trace generation (~100x faster)
                    + "] to 0 to disable.",
            throw new OpenSearchStatusException(
            @Override
            return advance(slowDocId + 1);
                e
        add.accept("ordinals_collectors_used", ordinalsCollectorsUsed);
        public void collect(int doc, long owningBucketOrd) throws IOException {
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
            // Create DirectCollector with computed data
            @Override
            BigArrays bigArrays,
        // this Aggregator (and its HLL++ counters) is released.
        }
                        if (bits != null) {
        if (collector == null) { // not able to build an OrdinalsCollector, or hint is direct
                activeCollector.collect(stream, owningBucketOrd);
        public static MurmurHash3Values hash(SortedBinaryDocValues values) {
        public int advance(int target) throws IOException {
    int ordinalsCollectorsUsed;
     * Collector for the cardinality agg
        /**
    }
                    doc = iterator.advance(competitiveNext);
            // Start with OrdinalsCollector with memory monitoring enabled
        }
import org.opensearch.core.common.unit.ByteSizeValue;
            }
         * @opensearch.internal
     * Exception thrown when OrdinalsCollector exceeds memory threshold.
import org.apache.lucene.search.DocIdSetIterator;
        @Override
    private void postCollectLastCollector() throws IOException {
 *
 * SPDX-License-Identifier: Apache-2.0
        add.accept("string_hashing_collectors_used", stringHashingCollectorsUsed);
    }
                // Check memory threshold only when monitoring is enabled (hybrid collector)
            }
                // Retry collection with DirectCollector
                return collector;
         * @opensearch.internal
                // Retry collection with DirectCollector
        @Override
        private static class Bytes extends MurmurHash3Values {
import org.apache.lucene.search.CollectionTerminatedException;
                }
        if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals source) {
import java.io.IOException;
import org.opensearch.common.settings.Setting;
        @Override
/*
import org.apache.lucene.index.SortedSetDocValues;
        public abstract void postCollect() throws IOException;
                        }
 * compatible open source license.
        /**
            final BitArray bits = getBitArray(0);
    @Override
                activeCollector.collectRange(minDoc, maxDoc);
        public void collect(int doc, long bucketOrd) throws IOException {
import org.apache.lucene.util.Bits;
    int numericCollectorsUsed;
        }
        private final HyperLogLogPlusPlus counts;
                            for (long ord = bits.nextSetBit(0); ord < Long.MAX_VALUE; ord = ord + 1 < maxOrd
            // this DISI's docID is already making to the target
        }
            public void collect(int doc, long owningBucketOrd) throws IOException {
        }
import org.apache.logging.log4j.LogManager;
        @Override
            bulkCollect(ctx.reader().getLiveDocs(), iterator, pruningCollector);
                ordinalsCollectorsUsed++;
        if (counts == null || owningBucketOrdinal >= counts.maxOrd() || counts.cardinality(owningBucketOrdinal) == 0) {
        }
    public static final Setting<ByteSizeValue> CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_MEMORY_THRESHOLD = Setting.memorySizeSetting(
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            }
                int count = values.docValueCount();
        ) {
            }
            doc = iterator.nextDoc();
        HybridCollector(
        public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            }
     */
 * this work for additional information regarding copyright
                postingMap.put(term, scorer);
        public void postCollect() throws IOException {
                switchToDirectCollector();
        /**
            }
         */
        }
        DirectCollector(HyperLogLogPlusPlus counts, MurmurHash3Values values) {
     */
    }
    int dynamicPrunedSegments;
    abstract static class Collector extends LeafBucketCollector implements Releasable {
            }
                final int valueCount = hashes.count();
     * @opensearch.internal
            }
            // Optimized constructor for control flow exceptions:
                        // Throw singleton exception for efficient control flow to HybridCollector
                    MurmurHash3Values hashValues = MurmurHash3Values.hash(source.bytesValues(ctx));
     * pop/prune the values after being collected
            BigArrays bigArrays,
import org.opensearch.OpenSearchStatusException;
     * Empty Collector for the Cardinality agg
    );
     * This collector enhance the delegate collector with pruning ability on term field
            }
        // We need to build a copy because the returned Aggregation needs to remain usable after
        ValuesSourceConfig valuesSourceConfig,
import org.apache.lucene.index.Terms;
            return new Double(values);
            collect(doc, getBitArray(bucketOrd));
         *
            public boolean advanceExact(int docId) throws IOException {
                return false;
import org.opensearch.common.util.BitMixer;
            public int count() {
        /**
    /**
            while (terms.next() != null) {
        @Override
                switchToDirectCollector();
        public abstract long nextValue() throws IOException;
import org.opensearch.search.aggregations.LeafBucketCollector;
            for (int i = 0; i < visitedOrds.size(); i++) {
            }
    final int precision;
        private final MurmurHash3Values hashValues;
import org.opensearch.common.lease.Releasable;
                    final long ordinalsMemoryUsage = OrdinalsCollector.memoryOverhead(maxOrd);
        private static final long SHALLOW_FIXEDBITSET_SIZE = RamUsageEstimator.shallowSizeOfInstance(FixedBitSet.class);
            this.memoryThreshold = memoryThreshold;
 * KIND, either express or implied.  See the License for the
                long ord;
 * GitHub history for details.
                return collector;
                collector = new OrdinalsCollector(counts, ordinalValues, context.bigArrays());
     * Hybrid Collector that starts with OrdinalsCollector and switches to DirectCollector
            if (pruningCollector == null) {
        public void collect(int doc, long bucketOrd) throws IOException {
            } catch (MemoryLimitExceededException e) {
     * This DISI is a disjunction of all terms in a segment
                activeCollector.collect(doc, bucketOrd);
    int stringHashingCollectorsUsed;
        private final DisiPriorityQueue queue;
        private void collect(final int doc, final BitArray bits) throws IOException {
                queue.add(new DisiWrapper(scorer, false));
import org.opensearch.common.Nullable;
                        final BitArray bits = visitedOrds.get(bucket);
            }
        public static MurmurHash3Values hash(SortedNumericDoubleValues values) {
                slowDocId = top.doc;
            return slowDocId;
            if ((acceptDocs == null || acceptDocs.get(doc))) {
                }
     * @opensearch.internal
        DocIdSetIterator competitiveIterator = pruningCollector.competitiveIterator();
            // no-op
        return new InternalCardinality(name, copy, metadata());
            @Override
        Setting.Property.NodeScope,
import org.apache.lucene.util.RamUsageEstimator;
                // no hint provided, fall back to heuristics
        }
         * Double hash value
    @Override
    }
            this.ordinalsCollector = new OrdinalsCollector(counts, ordinalValues, bigArrays, cardinalityContext.getMemoryThreshold(), true);
        }
            } while (top.doc < target);
                    // Use HybridCollector with configurable memory threshold
                if (memoryMonitoringEnabled) {
import org.apache.logging.log4j.Logger;
        @Override
        private long currentMemoryUsage = 0;
            return new Bytes(values);
    @Override
        }
import org.apache.lucene.search.Weight;
     * Direct Collector for the cardinality agg
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
            return queue.top() == null ? 0 : queue.top().approximation.cost();
    private final ValuesSourceConfig valuesSourceConfig;
            // no-op
 * Modifications Copyright OpenSearch Contributors. See
        CardinalityAggregatorFactory.ExecutionMode executionMode
                // Retry collection with DirectCollector
        }
                return;
import org.apache.lucene.search.DisiPriorityQueue;
                this.values = values;
                context.cardinalityAggregationPruningThreshold()
        @Override
        super(name, context, parent, metadata);
        @Override
        private Collector activeCollector;
    private static final Logger logger = LogManager.getLogger(CardinalityAggregator.class);
import static org.opensearch.search.SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD;
            }
            this.bigArrays = bigArrays;
                do {
import org.opensearch.core.rest.RestStatus;
import org.opensearch.common.util.BigArrays;
            // - null message/cause: no debugging info needed
        private MemoryLimitExceededException() {
        super.collectDebugInfo(add);
        public void collectRange(int minDoc, int maxDoc) throws IOException {
                collector.postCollect();
                top = queue.updateTop();
         * Byte hash value
            long memoryThreshold,
        int doc = iterator.nextDoc();
            assert competitiveIterator.docID() <= doc; // invariant
            try {
        public void postCollect() throws IOException {
            // This would be the outcome of last pruning
                    if (ordinalsMemoryUsage < countsMemoryUsage / 4) {
         */
        static final MemoryLimitExceededException INSTANCE = new MemoryLimitExceededException();
            Long(SortedNumericDocValues values) {
         * Return an approximate memory overhead per bucket for this collector.
import org.opensearch.common.util.ObjectArray;
            this.memoryMonitoringEnabled = memoryMonitoringEnabled;
        }
        }
            boolean memoryMonitoringEnabled
     * The iterators of term field values are wrapped into a priority queue, and able to
     */
            if (terms == null) return collector;
         *
        return true;
                throw new IllegalArgumentException();
import org.opensearch.search.aggregations.Aggregator;
            activeCollector.postCollect();
                        collector = new OrdinalsCollector(counts, ordinalValues, context.bigArrays());
                }
            public int count() {
            DisiWrapper top = queue.top();
                return;
    }
        }
    static class HybridCollector extends Collector {
        Collector getActiveCollector() {
                    continue;
    /**
        add.accept("hybrid_collectors_used", hybridCollectorsUsed);
            if (scorer == null) {
                return values.docValueCount();
        while (doc < DocIdSetIterator.NO_MORE_DOCS) {
                    final BitArray bits = visitedOrds.get(bucket);
        }
        @Override
    }
        OrdinalsCollector(
        }
 */
            this.hashValues = hashValues;
        }
    private static class PruningCollector extends Collector {
                                ? bits.nextSetBit(ord + 1)
        private final int maxOrd;
                    for (long bucket = visitedOrds.size() - 1; bucket >= 0; --bucket) {
        }
                    }
        "search.aggregations.cardinality.hybrid_collector.enabled",
                        hashes.set(ord, hash.h1);
                        ? allVisitedOrds.nextSetBit(ord + 1)
}
    }
            visitedOrds = bigArrays.grow(visitedOrds, bucket + 1);
import org.apache.lucene.search.ScoreMode;
        if (collector != null) {
                collector = null;
                    hybridCollectorsUsed++;
        }
            prune(doc);
    static class MemoryLimitExceededException extends RuntimeException {
                return new EmptyCollector();
         */
                    }
    static class EmptyCollector extends Collector {
            this.delegate = delegate;
    }
            @Override
        private final CardinalityAggregationContext cardinalityContext;
    public InternalAggregation buildEmptyAggregation() {
            return new EmptyCollector();
            super(null, null, false, false);
public class CardinalityAggregator extends NumericMetricsAggregator.SingleValue {
import org.apache.lucene.util.FixedBitSet;
                                counts.collect(bucket, hashes.get(ord));
                CardinalityAggregationContext cardinalityContext = context.cardinalityAggregationContext();
            }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        Setting.Property.Dynamic
        } catch (Exception e) {
    protected void doClose() {
            }
            }
import org.opensearch.search.aggregations.InternalAggregation;
                emptyCollectorsUsed++;
package org.opensearch.search.aggregations.metrics;
                BytesRef term = terms.term();
    /**
            return getNoOpCollector();
        private final DocIdSetIterator competitiveIterator;
import java.util.function.BiConsumer;
            return new PruningCollector(collector, terms.iterator(), ctx, context, valuesSourceConfig.fieldContext().field());
    public ScoreMode scoreMode() {
    public void collectDebugInfo(BiConsumer<String, Object> add) {
    protected void doPostCollection() throws IOException {
                Weight subWeight = termQuery.createWeight(context.searcher(), ScoreMode.COMPLETE_NO_SCORES, 1f);
        public long cost() {
                return values.advanceExact(docId);
                : MurmurHash3Values.hash(source.longValues(ctx));
            }
            if (queue.size() == 0) {
            return RamUsageEstimator.NUM_BYTES_OBJECT_REF + SHALLOW_FIXEDBITSET_SIZE + (maxOrd + 7) / 8; // 1 bit per ord
                }
        }
        SearchContext context,
                    collector = new HybridCollector(counts, ordinalValues, hashValues, context.bigArrays(), cardinalityContext);
        this.valuesSourceConfig = valuesSourceConfig;
    }
        return collector;
     * To still providing a docID slower than the lead iterator for the next iteration
            public int count() {
        private static class Long extends MurmurHash3Values {
            delegate.collect(doc, owningBucketOrd);
            CardinalityAggregationContext cardinalityContext
        }
import org.apache.lucene.search.DisiWrapper;
    ) throws IOException {
            }
            }
                return top.doc;
    public CardinalityAggregator(
                throw new CollectionTerminatedException();
        OrdinalsCollector(HyperLogLogPlusPlus counts, SortedSetDocValues values, BigArrays bigArrays) {
    private Collector getNoOpCollector() {
            return slowDocId;
            this(counts, values, bigArrays, Long.MAX_VALUE, false);
 * An aggregator that computes approximate counts of unique values.
            Collector pruningCollector = tryWrapWithPruningCollector(collector, terms, ctx);
     * Ordinals Collector for the cardinality agg
import org.opensearch.search.aggregations.support.ValuesSource;
            logger.debug("Hybrid collector switching to DirectCollector due to memory threshold exceeded");
        PruningCollector(Collector delegate, TermsEnum terms, LeafReaderContext ctx, SearchContext context, String field)
            SortedSetDocValues ordinalValues,
        @Override
        try {
                return BitMixer.mix64(java.lang.Double.doubleToLongBits(values.nextValue()));
 *
            this.activeCollector = ordinalsCollector;
        private final HyperLogLogPlusPlus counts;
            private final SortedNumericDocValues values;
     * Note: This threshold is applied at the Lucene segment level since collectors are created per segment.
        this.counts = valuesSource == null ? null : new HyperLogLogPlusPlus(precision, context.bigArrays(), 1);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            logger.debug("Dynamic pruned segment {} of shard {}", ctx.ord, context.indexShard().shardId());
        }
            return true;
    abstract static class MurmurHash3Values {
     *
        return new InternalCardinality(name, null, metadata());
            );
    }
        return counts == null ? 0 : counts.cardinality(owningBucketOrd);
    public static final Setting<Boolean> CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_ENABLED = Setting.boolSetting(
        @Override
                        throw MemoryLimitExceededException.INSTANCE;
            @Override
            @Override
     */
            this.counts = counts;
            HyperLogLogPlusPlus counts,
                int competitiveNext = competitiveIterator.advance(doc);
                this.values = values;
                return values.advanceExact(docId);
 * software distributed under the License is distributed on an
        postCollectLastCollector();
                    if (currentMemoryUsage > memoryThreshold) {
            }
        private int slowDocId = -1;
        public void postCollect() {
        }
            // no-op
/**
import org.apache.lucene.index.TermsEnum;
            if (bits == null) {
            slowDocId = queue.size() == 0 ? NO_MORE_DOCS : queue.top().doc;
 *
            logger.debug(
            Bytes(SortedBinaryDocValues values) {
    /**
            competitiveIterator = new DisjunctionDISI(queue);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 *    http://www.apache.org/licenses/LICENSE-2.0
         * Return a {@link MurmurHash3Values} instance that computes hashes on the fly for each long value.
            try {
            public boolean advanceExact(int docId) throws IOException {
import org.opensearch.common.util.BitArray;
                    }
    int ordinalsCollectorsOverheadTooHigh;
                "Failed when performing dynamic pruning in cardinality aggregation. You can set cluster setting ["
        private final MurmurHash3Values hashes;
    @Override
    /**
                try (LongArray hashes = bigArrays.newLongArray(maxOrd, false)) {
    final CardinalityAggregatorFactory.ExecutionMode executionMode;
    // Expensive to initialize, so we only initialize it when we have an actual value source
            this.counts = counts;
            // no-op
        }
            do {
import java.util.Map;
import org.apache.lucene.search.TermQuery;
        add.accept("empty_collectors_used", emptyCollectorsUsed);
            return new Long(values);
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
            this.counts = counts;
        }
 * ownership. Elasticsearch licenses this file to you under
     *
        @Override
            private final SortedBinaryDocValues values;
            collector = new DirectCollector(counts, MurmurHash3Values.hash(valuesSource.bytesValues(ctx)));
     */
            final long maxOrd = ordinalValues.getValueCount();
        @Override
        private final long memoryThreshold;
            MurmurHash3Values hashValues = (source.isFloatingPoint() || source.isBigInteger())
    @Nullable
        public DisjunctionDISI(DisiPriorityQueue queue) {
            if (values.getValueCount() > Integer.MAX_VALUE) {
                return values.advanceExact(docId);
        }
            return activeCollector;
/*
import java.util.HashMap;
            ordinalsCollector.postCollect();
            for (Scorer scorer : postingMap.values()) {
 * You may obtain a copy of the License at
            activeCollector = new DirectCollector(counts, hashValues);
            }
     *
        true,
            numericCollectorsUsed++;
import org.opensearch.common.util.LongArray;
                return values.docValueCount();
            int curTopDoc = top.doc;
            stringHashingCollectorsUsed++;
            return null;
            logger.warn("Failed to build collector for dynamic pruning.", e);
        Releasables.close(counts, collector);
            if (curTopDoc == doc) {
        } catch (Exception e) {
                Releasables.close(visitedOrds.get(i));
            }
    }
 */
            visitedOrds = bigArrays.newObjectArray(1);
        "search.aggregations.cardinality.hybrid_collector.memory_threshold",
import org.apache.lucene.util.BytesRef;
            }
    }
     * And it will be the competitive iterator of the leaf pruning collector
     */
    @Override
                if (competitiveNext != doc) {
            } else if (executionMode == CardinalityAggregatorFactory.ExecutionMode.ORDINALS) { // Force OrdinalsCollector
            Releasables.close(pruningCollector);
            if (exceedMaxThreshold(terms)) {
        public DocIdSetIterator competitiveIterator() {
            }
 *
            } else if (executionMode == null) {
     * @opensearch.internal
            stream.forEach((doc) -> collect(doc, bits));
            }
        /**
        AbstractHyperLogLogPlusPlus copy = counts.clone(owningBucketOrdinal, BigArrays.NON_RECYCLING_INSTANCE);
 * the Apache License, Version 2.0 (the "License"); you may
    }
                return BitMixer.mix64(values.nextValue());
/*
import org.apache.lucene.index.LeafReaderContext;
        @Override
        public void close() {
    }
        }
        private final boolean memoryMonitoringEnabled;
 * not use this file except in compliance with the License.
            }
            return currentMemoryUsage;
                switchToDirectCollector();
                    bits.set((int) ord);
     */
            }
            ValuesSource.Numeric source = (ValuesSource.Numeric) valuesSource;
                bits = new BitArray(maxOrd, bigArrays);
        }
     * We keep track of a slowDocId that will be updated later during advance
                } while (queue.size() > 1 && top.doc == curTopDoc);
    }
    }
            );
    public double metric(long owningBucketOrd) {
 * The OpenSearch Contributors require contributions made to
            public void postCollect() throws IOException {}
    /**
        // TODO: Stop using nulls here
        }
        private static class Double extends MurmurHash3Values {
            SortedSetDocValues values,
     * and absolute values (e.g., "10mb", "1gb").
                ? MurmurHash3Values.hash(source.doubleValues(ctx))
    @Override
                } else {
        }
            pruningCollector.postCollect();
            }
     * Setting for hybrid collector memory threshold. Supports both percentage (e.g., "1%")
         * Return a {@link MurmurHash3Values} instance that computes hashes on the fly for each double value.
                    + CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey()
            @Override
         * Long hash value
        }
        this.precision = precision;
        Aggregator parent,
            public long nextValue() throws IOException {
        // Visible for testing
        @Override
                activeCollector.collectRange(minDoc, maxDoc);
        Map<String, Object> metadata,
        Setting.Property.NodeScope,
import org.opensearch.common.lease.Releasables;
        if (valuesSource instanceof ValuesSource.Numeric) {
        Collector collector = null;
            @Override
        }
     * when memory consumption exceeds a threshold. Uses exception-based control flow for
            }
            if (hashes.advanceExact(doc)) {
            Double(SortedNumericDoubleValues values) {
        private final Collector delegate;
                collector.close();
        @Override
                    } else {
        if (terms.size() > context.cardinalityAggregationPruningThreshold()) {
            }
                }
        int precision,
            return bits;
            return buildEmptyAggregation();
        private ObjectArray<BitArray> visitedOrds;
                        allVisitedOrds.or(bits);
                }
                        final BytesRef value = values.lookupOrd(ord);
import org.opensearch.common.hash.MurmurHash3;
        }
        private final OrdinalsCollector ordinalsCollector;
            }
    private boolean tryScoreWithPruningCollector(LeafReaderContext ctx, Collector pruningCollector) throws IOException {
            private final SortedNumericDoubleValues values;
     * @opensearch.internal
    /**
    static class OrdinalsCollector extends Collector {
                return values.docValueCount();
        private final SortedSetDocValues values;
        String name,
                TermQuery termQuery = new TermQuery(new Term(field, term));
            Weight weight = context.query().rewrite(context.searcher()).createWeight(context.searcher(), ScoreMode.TOP_DOCS, 1f);
                    for (long ord = allVisitedOrds.nextSetBit(0); ord < Long.MAX_VALUE; ord = ord + 1 < maxOrd
        }
            if (top == null) {
        @Override
        }
 */
        try {
         * @opensearch.internal
                final BytesRef bytes = values.nextValue();
     */
            MurmurHash3Values hashValues,
    }
        if (canPrune(parent, subAggregators, valuesSourceConfig)) {
        }
                top.doc = top.approximation.advance(target);
         */
                while ((count-- > 0) && (ord = values.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
         */
     * Setting to enable/disable hybrid collector for cardinality aggregation.
        };
            if (values.advanceExact(doc)) {
        }
    @Override
            pruningCollector.setScorer(scorer);
        }
        }
            @Override
            return competitiveIterator;
        public int nextDoc() throws IOException {
            BitArray bits = visitedOrds.get(bucket);
                    queue.pop();
            private final MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
        "1%",
     */
         * Return a {@link MurmurHash3Values} instance that computes hashes on the fly for each binary value.
            }
        collector = pickCollector(ctx);
    private Collector tryWrapWithPruningCollector(Collector collector, Terms terms, LeafReaderContext ctx) {
        return false;
        public abstract boolean advanceExact(int docId) throws IOException;
        private BitArray getBitArray(long bucket) {
        public abstract int count();
            this.values = values;
        public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        }
 * under the License.
        public void postCollect() throws IOException {
            }
            }
         */
            delegate.close();
     *
                for (int i = 0; i < valueCount; ++i) {
            Releasables.close(visitedOrds);
            DocIdSetIterator iterator = scorer.iterator();
        private void switchToDirectCollector() throws IOException {
 * Unless required by applicable law or agreed to in writing,
    }
            try {
        add.accept("numeric_collectors_used", numericCollectorsUsed);
     * After pruning done after collect, queue top doc may exceed the next doc of (lead) iterator
         * Note: the queue may be empty or the queue top may be null after pruning
        @Override
        @Override
            if (top.doc >= target) {
import org.apache.lucene.index.Term;
        add.accept("dynamic_pruned_segments", dynamicPrunedSegments);
    }
            public long nextValue() throws IOException {
import org.apache.lucene.search.Scorer;
    private Collector pickCollector(LeafReaderContext ctx) throws IOException {
        }
            for (int doc = minDoc; doc < maxDoc; ++doc) {
    }
 */
        public void collect(int doc, long bucketOrd) {
        add.accept("ordinals_collectors_overhead_too_high", ordinalsCollectorsOverheadTooHigh);
     */
    private boolean exceedMaxThreshold(Terms terms) throws IOException {
            try (BitArray allVisitedOrds = new BitArray(maxOrd, bigArrays)) {
            ordinalsCollector.close();
        private void prune(int doc) {
            Terms terms = ctx.reader().terms(valuesSourceConfig.fieldContext().field());
            Scorer scorer = weight.scorer(ctx);
    );
        @Override
    int hybridCollectorsUsed;
    }
    }
            dynamicPrunedSegments++;
            Releasables.close(activeCollector);
     * Representation of a list of hash values. There might be dups and there is no guarantee on the order.
            }
                visitedOrds.set(bucket, bits);
        @Override
 * this file be licensed under the Apache-2.0 license or a
            }
            DisiWrapper top = queue.top();
        public static MurmurHash3Values hash(SortedNumericDocValues values) {
        public void collectRange(int minDoc, int maxDoc) throws IOException {
                this.values = values;
        Setting.Property.Dynamic
            if (competitiveIterator.docID() < doc) {
            final BitArray bits = getBitArray(owningBucketOrd);
        }
 * license agreements. See the NOTICE file distributed with
        }
    @Override
            public void close() {}
        @Override
            }
     * Uses singleton pattern and optimized constructor for performance in control flow scenarios.
        }
    }
            if (top == null) {
                return collector;
                return slowDocId = NO_MORE_DOCS;
        }
                Scorer scorer = subWeight.scorer(ctx);
import org.apache.lucene.search.DocIdStream;
            } finally {
                    final MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
    private static class DisjunctionDISI extends DocIdSetIterator {
            if (maxOrd == 0) {
                        : Long.MAX_VALUE) {
        private final DisiPriorityQueue queue;
                pruningCollector.collect(doc);
         *
        private final HyperLogLogPlusPlus counts;
            @Override
    final ValuesSource valuesSource;
            // - false enableSuppression: disable suppressed exception tracking
        }
        ) {
                    currentMemoryUsage += memoryOverhead(maxOrd);
                if (cardinalityContext.isHybridCollectorEnabled()) {
     */
            HyperLogLogPlusPlus counts,
                collect(doc, bits);
            }
        }
            maxOrd = (int) values.getValueCount();
                RestStatus.INTERNAL_SERVER_ERROR,
 * Licensed to Elasticsearch under one or more contributor
    /**
            } catch (MemoryLimitExceededException e) {
                        ordinalsCollectorsUsed++;
        @Override
            } catch (MemoryLimitExceededException e) {
            emptyCollectorsUsed++;
         */
        postCollectLastCollector();
        }
            public boolean advanceExact(int docId) throws IOException {
            throws IOException {
            @Override
                MurmurHash3.hash128(bytes.bytes, bytes.offset, bytes.length, 0, hash);
    }
            // Post collect all the already computed data from OrdinalsCollector
            @Override
    private void bulkCollect(Bits acceptDocs, DocIdSetIterator iterator, Collector pruningCollector) throws IOException {
    /**
        this.executionMode = executionMode;
                                : Long.MAX_VALUE) {
                    final long countsMemoryUsage = HyperLogLogPlusPlus.memoryUsage(precision);
                terms.size(),
                            }
            public long nextValue() throws IOException {
            }
                        ordinalsCollectorsOverheadTooHigh++;
        /**
         */
        public long getCurrentMemoryUsage() {
                activeCollector.collect(doc, bucketOrd);
                    counts.collect(bucketOrd, hashes.nextValue());
import org.opensearch.search.internal.SearchContext;
        public void close() {
        public void close() {
            final SortedSetDocValues ordinalValues = source.ordinalsValues(ctx);
        this.valuesSource = valuesSourceConfig.hasValues() ? valuesSourceConfig.getValuesSource() : null;
                return hash.h1;
        }
            return new DirectCollector(counts, hashValues);
        /**
            Map<BytesRef, Scorer> postingMap = new HashMap<>();
                "Cannot prune because terms size {} is greater than the threshold {}",
            if (!tryScoreWithPruningCollector(ctx, pruningCollector)) {
        @Override
    /**
            this.hashes = values;
                    top = queue.updateTop();
        public void close() {
            // no-op
                        MurmurHash3.hash128(value.bytes, value.offset, value.length, 0, hash);
        }
     * optimal performance - zero overhead when memory is under threshold.
        public int docID() {
        if (valuesSource == null) {
    private boolean canPrune(Aggregator parent, Aggregator[] subAggregators, ValuesSourceConfig valuesSourceConfig) {
        }
     *
 * specific language governing permissions and limitations
        return collector;
            this.queue = DisiPriorityQueue.ofMaxSize(postingMap.size());
    HyperLogLogPlusPlus counts;
        public void postCollect() {
    }
                }
        }
        public void collect(int doc, long bucketOrd) throws IOException {
        return new Collector() {
        /**
            this.cardinalityContext = cardinalityContext;
                for (long bucket = visitedOrds.size() - 1; bucket >= 0; --bucket) {
    }
        }
        public static long memoryOverhead(long maxOrd) {
            this.queue = queue;
        }
    int emptyCollectorsUsed;
                    }
    /**
            delegate.postCollect();
