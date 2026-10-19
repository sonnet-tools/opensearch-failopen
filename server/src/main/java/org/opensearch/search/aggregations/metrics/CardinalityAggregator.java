        private int slowDocId = -1;
            Releasables.close(activeCollector);  
                e  
        collector = pickCollector(ctx);  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        public int advance(int target) throws IOException {
        PruningCollector(Collector delegate, TermsEnum terms, LeafReaderContext ctx, SearchContext context, String field)
    /**
                do {
                                counts.collect(bucket, hashes.get(ord));
                return values.advanceExact(docId);  
            }  
 */  
                final BytesRef bytes = values.nextValue();
        }
            public long nextValue() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
    public void collectDebugInfo(BiConsumer<String, Object> add) {
        private final long memoryThreshold;
        }  
            this.counts = counts;
import org.opensearch.core.common.unit.ByteSizeValue;  
        }
        this.counts = valuesSource == null ? null : new HyperLogLogPlusPlus(precision, context.bigArrays(), 1);
        public static MurmurHash3Values hash(SortedNumericDoubleValues values) {  
        }  
     *
            } else if (executionMode == CardinalityAggregatorFactory.ExecutionMode.ORDINALS) { // Force OrdinalsCollector
            pruningCollector.setScorer(scorer);  
            } catch (MemoryLimitExceededException e) {  
            BigArrays bigArrays,
            try (BitArray allVisitedOrds = new BitArray(maxOrd, bigArrays)) {
        public void close() {  
                return values.docValueCount();
import org.apache.logging.log4j.Logger;
            public boolean advanceExact(int docId) throws IOException {
        add.accept("ordinals_collectors_used", ordinalsCollectorsUsed);  
import org.apache.lucene.index.Terms;
            MurmurHash3Values hashValues,  
        @Override
            @Override
                        ordinalsCollectorsUsed++;
            return queue.top() == null ? 0 : queue.top().approximation.cost();
        }
            }
            Long(SortedNumericDocValues values) {  
    private Collector pickCollector(LeafReaderContext ctx) throws IOException {  
    }  
        public void collectRange(int minDoc, int maxDoc) throws IOException {  
import org.apache.lucene.search.DisiWrapper;
    ) throws IOException {  
        }  
                        MurmurHash3.hash128(value.bytes, value.offset, value.length, 0, hash);
        try {  
            @Override
            public long nextValue() throws IOException {  
            try {  
                    // Use HybridCollector with configurable memory threshold  
        // TODO: Stop using nulls here
    }  
         * Double hash value  
        return collector;
    @Override
        private BitArray getBitArray(long bucket) {
                CardinalityAggregationContext cardinalityContext = context.cardinalityAggregationContext();  
        private final boolean memoryMonitoringEnabled;
     */
        private final Collector delegate;
 * @opensearch.internal  
            }  
        }  
            this.values = values;  
    private Collector getNoOpCollector() {
        @Override
        public DisjunctionDISI(DisiPriorityQueue queue) {
                                : Long.MAX_VALUE) {
        @Override  
                collector.postCollect();
            }
                    hybridCollectorsUsed++;
        }
    public static final Setting<Boolean> CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_ENABLED = Setting.boolSetting(
            }
            ordinalsCollector.postCollect();  
            BitArray bits = visitedOrds.get(bucket);  
import org.opensearch.common.util.BitArray;
            SortedSetDocValues ordinalValues,
                return collector;
        ) {  
     * And it will be the competitive iterator of the leaf pruning collector
        public void close() {
            } catch (MemoryLimitExceededException e) {
                        final BitArray bits = visitedOrds.get(bucket);  
        }
        public void collect(int doc, long owningBucketOrd) throws IOException {
    abstract static class MurmurHash3Values {
                    MurmurHash3Values hashValues = MurmurHash3Values.hash(source.bytesValues(ctx));
    int ordinalsCollectorsUsed;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        return parent == null && subAggregators.length == 0 && valuesSourceConfig.missing() == null && valuesSourceConfig.script() == null;
     */
            this.activeCollector = ordinalsCollector;
    }  
    private static class PruningCollector extends Collector {
        }
        }  
            delegate.close();
                BytesRef term = terms.term();
            activeCollector.postCollect();
                Scorer scorer = subWeight.scorer(ctx);
    static class OrdinalsCollector extends Collector {
        @Override  
    Collector collector;  
     * Uses singleton pattern and optimized constructor for performance in control flow scenarios.
 */
    static class MemoryLimitExceededException extends RuntimeException {
                        collector = new OrdinalsCollector(counts, ordinalValues, context.bigArrays());  
                    counts.collect(bucketOrd, hashes.nextValue());  
            this.queue = DisiPriorityQueue.ofMaxSize(postingMap.size());  
        public abstract long nextValue() throws IOException;
        } catch (Exception e) {
import org.apache.lucene.search.DisiPriorityQueue;
        @Override
            try {
        private final CardinalityAggregationContext cardinalityContext;
        this.valuesSourceConfig = valuesSourceConfig;  
import org.apache.lucene.util.FixedBitSet;
import org.opensearch.OpenSearchStatusException;
                terms.size(),  
        return counts == null ? 0 : counts.cardinality(owningBucketOrd);
        public static long memoryOverhead(long maxOrd) {
        /**  
import org.opensearch.common.lease.Releasable;
     */
    }
     * After pruning done after collect, queue top doc may exceed the next doc of (lead) iterator
        }
        public void postCollect() throws IOException {  
            throw new OpenSearchStatusException(
            bulkCollect(ctx.reader().getLiveDocs(), iterator, pruningCollector);
        public void collect(int doc, long bucketOrd) throws IOException {
        }
 * license agreements. See the NOTICE file distributed with
            }
 * Unless required by applicable law or agreed to in writing,
                while ((count-- > 0) && (ord = values.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {  
            if (top == null) {
        private static class Long extends MurmurHash3Values {
        public void postCollect() throws IOException {
            return new Bytes(values);  
                postingMap.put(term, scorer);  
            public boolean advanceExact(int docId) throws IOException {
        public void postCollect() {  
     * @opensearch.internal
            } while (top.doc < target);  
import org.apache.lucene.search.DocIdStream;
     * @opensearch.internal
            final SortedSetDocValues ordinalValues = source.ordinalsValues(ctx);
            if (competitiveIterator.docID() < doc) {  
            public void postCollect() throws IOException {}
        } catch (Exception e) {  
        }
        "search.aggregations.cardinality.hybrid_collector.memory_threshold",
        }
        }
        add.accept("empty_collectors_used", emptyCollectorsUsed);
import org.apache.lucene.index.TermsEnum;
 * this work for additional information regarding copyright
    }
            Terms terms = ctx.reader().terms(valuesSourceConfig.fieldContext().field());
import org.apache.lucene.util.BytesRef;
        public void postCollect() {  
                return values.docValueCount();
        this.precision = precision;
            final BitArray bits = getBitArray(0);
            @Override
            private final SortedNumericDocValues values;
            public boolean advanceExact(int docId) throws IOException {
         * @opensearch.internal
        }  
    static class DirectCollector extends Collector {  
                for (long bucket = visitedOrds.size() - 1; bucket >= 0; --bucket) {  
            @Override
                collector.close();  
        if (valuesSource instanceof ValuesSource.Numeric) {  
            if (values.getValueCount() > Integer.MAX_VALUE) {  
         * Return a {@link MurmurHash3Values} instance that computes hashes on the fly for each binary value.  
        add.accept("ordinals_collectors_overhead_too_high", ordinalsCollectorsOverheadTooHigh);
        ) {
    }  
     * and absolute values (e.g., "10mb", "1gb").
            BigArrays bigArrays,
        this.valuesSource = valuesSourceConfig.hasValues() ? valuesSourceConfig.getValuesSource() : null;  
            } else if (executionMode == null) {
            pruningCollector.postCollect();
            }
    private final ValuesSourceConfig valuesSourceConfig;  
            @Override
import org.opensearch.search.aggregations.LeafBucketCollector;  
            }  
        private static class Double extends MurmurHash3Values {
        if (valuesSource == null) {
        }  
    @Override
            return getNoOpCollector();
            boolean memoryMonitoringEnabled
            // Start with OrdinalsCollector with memory monitoring enabled
            if (terms == null) return collector;  
            logger.debug("Dynamic pruned segment {} of shard {}", ctx.ord, context.indexShard().shardId());
                return new EmptyCollector();  
                queue.add(new DisiWrapper(scorer, false));
    /**
    }
         * Return a {@link MurmurHash3Values} instance that computes hashes on the fly for each long value.
            logger.debug(
        }
import org.apache.lucene.util.Bits;  
        String name,
        private final HyperLogLogPlusPlus counts;
        this.executionMode = executionMode;
        postCollectLastCollector();
            public void collect(int doc, long owningBucketOrd) throws IOException {
                    doc = iterator.advance(competitiveNext);  
                        hashes.set(ord, hash.h1);
        }  
        }
                Releasables.close(visitedOrds.get(i));
        }  
    final int precision;  
    }  
        @Override  
                    queue.pop();  
import static org.opensearch.search.SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD;
        private final MurmurHash3Values hashValues;  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
    static class EmptyCollector extends Collector {
            final long maxOrd = ordinalValues.getValueCount();  
                // Retry collection with DirectCollector
            SortedSetDocValues values,
        }
    private boolean exceedMaxThreshold(Terms terms) throws IOException {
}
                return top.doc;  
            // This would be the outcome of last pruning
                    }
    /**
    private static class DisjunctionDISI extends DocIdSetIterator {  
            }
    @Override  
         * Long hash value
     * Collector for the cardinality agg
                    } else {
                        final BytesRef value = values.lookupOrd(ord);  
            for (int i = 0; i < visitedOrds.size(); i++) {
            dynamicPrunedSegments++;
                }
                return collector;
     * The iterators of term field values are wrapped into a priority queue, and able to
                    }
     * To still providing a docID slower than the lead iterator for the next iteration  
            }
        OrdinalsCollector(HyperLogLogPlusPlus counts, SortedSetDocValues values, BigArrays bigArrays) {
                for (int i = 0; i < valueCount; ++i) {
            // - null message/cause: no debugging info needed  
    }
            try {
 *
import org.apache.lucene.index.Term;  
        }
            return new Double(values);
 * software distributed under the License is distributed on an
            DisiWrapper top = queue.top();
                MurmurHash3.hash128(bytes.bytes, bytes.offset, bytes.length, 0, hash);
        if (counts == null || owningBucketOrdinal >= counts.maxOrd() || counts.cardinality(owningBucketOrdinal) == 0) {  
        private MemoryLimitExceededException() {
        try {  
        public void collect(int doc, long bucketOrd) throws IOException {
            final BitArray bits = getBitArray(owningBucketOrd);
        @Override
            this(counts, values, bigArrays, Long.MAX_VALUE, false);
    int stringHashingCollectorsUsed;
        @Override  
                }
            }
     * Exception thrown when OrdinalsCollector exceeds memory threshold.
    private void bulkCollect(Bits acceptDocs, DocIdSetIterator iterator, Collector pruningCollector) throws IOException {  
                // Retry collection with DirectCollector
            stream.forEach((doc) -> collect(doc, bits));
        }  
            collect(doc, getBitArray(bucketOrd));
                        ordinalsCollectorsOverheadTooHigh++;
                return;  
        }
            }
            }
    private boolean tryScoreWithPruningCollector(LeafReaderContext ctx, Collector pruningCollector) throws IOException {
            Releasables.close(pruningCollector);
            @Override
    private Collector tryWrapWithPruningCollector(Collector collector, Terms terms, LeafReaderContext ctx) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
            @Override
                    continue;
        }
    public ScoreMode scoreMode() {
            if (bits == null) {
            Double(SortedNumericDoubleValues values) {
                if (competitiveNext != doc) {
            private final SortedNumericDoubleValues values;  
    protected void doPostCollection() throws IOException {
        @Override
        super.collectDebugInfo(add);  
                        throw MemoryLimitExceededException.INSTANCE;
         * @opensearch.internal
        }
         */
        @Override
        CardinalityAggregatorFactory.ExecutionMode executionMode
                return BitMixer.mix64(values.nextValue());
    }  
 * You may obtain a copy of the License at  
            try {  
import java.util.function.BiConsumer;
            logger.debug("Hybrid collector switching to DirectCollector due to memory threshold exceeded");
        private static class Bytes extends MurmurHash3Values {  
        add.accept("hybrid_collectors_used", hybridCollectorsUsed);
        @Override
                if (cardinalityContext.isHybridCollectorEnabled()) {
    int emptyCollectorsUsed;
                // no hint provided, fall back to heuristics
                    final long countsMemoryUsage = HyperLogLogPlusPlus.memoryUsage(precision);  
/*  
            }  
        HybridCollector(  
            @Override
     * We keep track of a slowDocId that will be updated later during advance
            return slowDocId;
            while (terms.next() != null) {
        return collector;
            throws IOException {  
                    collector = new HybridCollector(counts, ordinalValues, hashValues, context.bigArrays(), cardinalityContext);  
 * An aggregator that computes approximate counts of unique values.
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.support.ValuesSource;
                    final long ordinalsMemoryUsage = OrdinalsCollector.memoryOverhead(maxOrd);
        }
     * Representation of a list of hash values. There might be dups and there is no guarantee on the order.  
    );  
        add.accept("dynamic_pruned_segments", dynamicPrunedSegments);
        /**
                ? MurmurHash3Values.hash(source.doubleValues(ctx))  
                return slowDocId = NO_MORE_DOCS;
        if (canPrune(parent, subAggregators, valuesSourceConfig)) {
            this.hashes = values;
                activeCollector.collectRange(minDoc, maxDoc);
            this.cardinalityContext = cardinalityContext;  
        return new InternalCardinality(name, copy, metadata());  
            int curTopDoc = top.doc;  
                        if (bits != null) {
            } finally {
                    bits.set((int) ord);
import org.opensearch.common.lease.Releasables;
                    if (ordinalsMemoryUsage < countsMemoryUsage / 4) {
                    if (bits != null) {
 *  
     * Direct Collector for the cardinality agg
            visitedOrds = bigArrays.newObjectArray(1);  
        return true;  
        // We need to build a copy because the returned Aggregation needs to remain usable after  
                switchToDirectCollector();  
                            }  
                try (LongArray hashes = bigArrays.newLongArray(maxOrd, false)) {
 *
     * This DISI is a disjunction of all terms in a segment  
            public int count() {
            }
        @Override
            for (int doc = minDoc; doc < maxDoc; ++doc) {
 * compatible open source license.
                            for (long ord = bits.nextSetBit(0); ord < Long.MAX_VALUE; ord = ord + 1 < maxOrd
    private boolean canPrune(Aggregator parent, Aggregator[] subAggregators, ValuesSourceConfig valuesSourceConfig) {
    int hybridCollectorsUsed;
         */
        public void close() {
                }
import java.util.Map;
                collector = new OrdinalsCollector(counts, ordinalValues, context.bigArrays());  
                    final BitArray bits = visitedOrds.get(bucket);
            // this DISI's docID is already making to the target  
    }
        public void collect(int doc, long bucketOrd) {
            competitiveIterator = new DisjunctionDISI(queue);
                switchToDirectCollector();
        Releasables.close(counts, collector);
            return new EmptyCollector();  
/*
        DirectCollector(HyperLogLogPlusPlus counts, MurmurHash3Values values) {
         * Byte hash value
    /**
        private Collector activeCollector;  
        }
        /**
        // this Aggregator (and its HLL++ counters) is released.
        int doc = iterator.nextDoc();  
                TermQuery termQuery = new TermQuery(new Term(field, term));  
            return slowDocId;  
            public int count() {  
            this.bigArrays = bigArrays;
                    for (long bucket = visitedOrds.size() - 1; bucket >= 0; --bucket) {
                Weight subWeight = termQuery.createWeight(context.searcher(), ScoreMode.COMPLETE_NO_SCORES, 1f);
        static final MemoryLimitExceededException INSTANCE = new MemoryLimitExceededException();
        "search.aggregations.cardinality.hybrid_collector.enabled",
        OrdinalsCollector(
            }
                this.values = values;
            }  
            }  
            // Create DirectCollector with computed data
         * Return an approximate memory overhead per bucket for this collector.  
        }
            return null;
    final ValuesSource valuesSource;
        }
            } catch (MemoryLimitExceededException e) {
        private final HyperLogLogPlusPlus counts;  
            return RamUsageEstimator.NUM_BYTES_OBJECT_REF + SHALLOW_FIXEDBITSET_SIZE + (maxOrd + 7) / 8; // 1 bit per ord  
            );
        public void close() {
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            emptyCollectorsUsed++;
        public void collectRange(int minDoc, int maxDoc) throws IOException {  
import org.apache.lucene.search.TermQuery;
    /**
                return collector;
        @Override
    int numericCollectorsUsed;  
    }  
                emptyCollectorsUsed++;
     */  
import org.apache.logging.log4j.LogManager;
                this.values = values;
            return advance(slowDocId + 1);
        postCollectLastCollector();
            if (exceedMaxThreshold(terms)) {
     * @opensearch.internal
            MurmurHash3Values hashValues = (source.isFloatingPoint() || source.isBigInteger())
                return BitMixer.mix64(java.lang.Double.doubleToLongBits(values.nextValue()));  
                    }  
    @Override
        Map<String, Object> metadata,
            Scorer scorer = weight.scorer(ctx);
                collector = null;
        DocIdSetIterator competitiveIterator = pruningCollector.competitiveIterator();
        public int docID() {  
        public long cost() {  
     */  
    /**  
import org.apache.lucene.search.CollectionTerminatedException;  
import java.util.HashMap;  
                activeCollector.collect(stream, owningBucketOrd);
            if (curTopDoc == doc) {
        @Override
                : MurmurHash3Values.hash(source.longValues(ctx));
                throw new IllegalArgumentException();
        private long currentMemoryUsage = 0;
    /**
                        allVisitedOrds.or(bits);  
        Setting.Property.NodeScope,
import org.apache.lucene.index.SortedNumericDocValues;
import org.opensearch.common.Nullable;
        /**  
            this.memoryMonitoringEnabled = memoryMonitoringEnabled;
            stringHashingCollectorsUsed++;  
                final int valueCount = hashes.count();
            this.counts = counts;
        }
            if (scorer == null) {  
                bits = new BitArray(maxOrd, bigArrays);
package org.opensearch.search.aggregations.metrics;
            Collector pruningCollector = tryWrapWithPruningCollector(collector, terms, ctx);
import org.opensearch.common.hash.MurmurHash3;  
        super(name, context, parent, metadata);
            DocIdSetIterator iterator = scorer.iterator();
                return values.advanceExact(docId);  
 * specific language governing permissions and limitations
            public int count() {
    private static final Logger logger = LogManager.getLogger(CardinalityAggregator.class);
 */
    HyperLogLogPlusPlus counts;
     * This collector enhance the delegate collector with pruning ability on term field
        }  
    }
     * Setting for hybrid collector memory threshold. Supports both percentage (e.g., "1%")  
import org.opensearch.search.internal.SearchContext;  
                collect(doc, bits);  
                this.values = values;  
            ValuesSource.Numeric source = (ValuesSource.Numeric) valuesSource;
        @Override
            return buildEmptyAggregation();
            for (Scorer scorer : postingMap.values()) {
        private void prune(int doc) {
                    }  
 * not use this file except in compliance with the License.
                    currentMemoryUsage += memoryOverhead(maxOrd);
        private final OrdinalsCollector ordinalsCollector;
            maxOrd = (int) values.getValueCount();  
         * Note: the queue may be empty or the queue top may be null after pruning
            Map<BytesRef, Scorer> postingMap = new HashMap<>();  
        // Visible for testing  
        public void postCollect() throws IOException {  
        AbstractHyperLogLogPlusPlus copy = counts.clone(owningBucketOrdinal, BigArrays.NON_RECYCLING_INSTANCE);
        @Override
            if (top.doc >= target) {
                }  
         *
            prune(doc);
import org.opensearch.common.util.BigArrays;
        private void collect(final int doc, final BitArray bits) throws IOException {
        }
    @Nullable  
    final CardinalityAggregatorFactory.ExecutionMode executionMode;
            return bits;
        private final int maxOrd;
        /**
 * KIND, either express or implied.  See the License for the
            private final MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
        Setting.Property.Dynamic
            }
     * pop/prune the values after being collected  
        @Override
 * GitHub history for details.
     */  
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
        private final SortedSetDocValues values;
    }  
            return true;  
        Collector collector = null;  
            }
    public InternalAggregation buildEmptyAggregation() {
/*  
     * Setting to enable/disable hybrid collector for cardinality aggregation.
            this.delegate = delegate;
            Releasables.close(visitedOrds);
import org.opensearch.common.util.BitMixer;  
import org.opensearch.index.fielddata.SortedBinaryDocValues;
            public long nextValue() throws IOException {
            long memoryThreshold,  
                activeCollector.collect(doc, bucketOrd);
    }
            ordinalsCollector.close();
import java.io.IOException;
         *
                }  
            }
        ValuesSourceConfig valuesSourceConfig,  
            public void close() {}
    static class HybridCollector extends Collector {
                switchToDirectCollector();
            activeCollector = new DirectCollector(counts, hashValues);
        Collector getActiveCollector() {
        }  
import org.apache.lucene.util.RamUsageEstimator;  
            collector = new DirectCollector(counts, MurmurHash3Values.hash(valuesSource.bytesValues(ctx)));
    /**
                    final MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
            // Post collect all the already computed data from OrdinalsCollector
     */  
            // no-op
                                ? bits.nextSetBit(ord + 1)  
            }  
 * Modifications Copyright OpenSearch Contributors. See
            }
            doc = iterator.nextDoc();
        }
                    for (long ord = allVisitedOrds.nextSetBit(0); ord < Long.MAX_VALUE; ord = ord + 1 < maxOrd  
    }
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
    @Override
            DisiWrapper top = queue.top();  
                activeCollector.collectRange(minDoc, maxDoc);  
        while (doc < DocIdSetIterator.NO_MORE_DOCS) {
    }  
                }
import org.apache.lucene.search.ScoreMode;
            );
                    + CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey()  
import org.opensearch.common.settings.Setting;  
        public abstract void postCollect() throws IOException;
    }
            this.ordinalsCollector = new OrdinalsCollector(counts, ordinalValues, bigArrays, cardinalityContext.getMemoryThreshold(), true);  
                "Cannot prune because terms size {} is greater than the threshold {}",
        private ObjectArray<BitArray> visitedOrds;
            return new DirectCollector(counts, hashValues);  
                    top = queue.updateTop();
    }  
            // - false enableSuppression: disable suppressed exception tracking
        public static MurmurHash3Values hash(SortedBinaryDocValues values) {
                    + "] to 0 to disable.",
        }
            }
         */  
            }  
    @Override
            slowDocId = queue.size() == 0 ? NO_MORE_DOCS : queue.top().doc;
            // Optimized constructor for control flow exceptions:
     */  
        /**
    // Expensive to initialize, so we only initialize it when we have an actual value source
        }
                return hash.h1;  
                top.doc = top.approximation.advance(target);
            if (top == null) {  
                return false;
                    }
        public abstract int count();
        int precision,
        private void switchToDirectCollector() throws IOException {
        Setting.Property.NodeScope,
        /**
import org.opensearch.search.aggregations.InternalAggregation;
        if (collector == null) { // not able to build an OrdinalsCollector, or hint is direct
                activeCollector.collect(stream, owningBucketOrd);  
        private static final long SHALLOW_FIXEDBITSET_SIZE = RamUsageEstimator.shallowSizeOfInstance(FixedBitSet.class);  
    @Override  
        @Override
    }
        if (valuesSource instanceof ValuesSource.Bytes.WithOrdinals source) {
        }
        }  
         */  
            delegate.postCollect();
        /**
                        }
        if (collector != null) {
        private final BigArrays bigArrays;  
                // Retry collection with DirectCollector  
        public abstract boolean advanceExact(int docId) throws IOException;  
import org.opensearch.search.aggregations.Aggregator;
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;  
         */
        return new InternalCardinality(name, null, metadata());
            }
            this.memoryThreshold = memoryThreshold;
            }
                    if (currentMemoryUsage > memoryThreshold) {
    abstract static class Collector extends LeafBucketCollector implements Releasable {  
     * Note: This threshold is applied at the Lucene segment level since collectors are created per segment.
            return competitiveIterator;
        SearchContext context,
        }
     * when memory consumption exceeds a threshold. Uses exception-based control flow for
            }  
            }  
         *  
        @Override  
            }  
                return values.docValueCount();
        }  
        if (terms.size() > context.cardinalityAggregationPruningThreshold()) {  
        add.accept("string_hashing_collectors_used", stringHashingCollectorsUsed);  
    }
            // no-op  
     *  
            logger.warn("Failed to build collector for dynamic pruning.", e);  
            return currentMemoryUsage;
        true,  
            @Override  
            delegate.collect(doc, owningBucketOrd);  
            return activeCollector;
    int ordinalsCollectorsOverheadTooHigh;  
        public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
         * Return a {@link MurmurHash3Values} instance that computes hashes on the fly for each double value.
    public static final Setting<ByteSizeValue> CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_MEMORY_THRESHOLD = Setting.memorySizeSetting(
 */  
                // Check memory threshold only when monitoring is enabled (hybrid collector)
    int dynamicPrunedSegments;
                "Failed when performing dynamic pruning in cardinality aggregation. You can set cluster setting ["
    }  
            if (!tryScoreWithPruningCollector(ctx, pruningCollector)) {
            }
 * SPDX-License-Identifier: Apache-2.0
        add.accept("numeric_collectors_used", numericCollectorsUsed);
                return;
                }
 *
         */
        }
                top = queue.updateTop();
        Aggregator parent,  
        }  
                } else {
                slowDocId = top.doc;
                        ? allVisitedOrds.nextSetBit(ord + 1)
            @Override  
        }
            }
import org.apache.lucene.search.DocIdSetIterator;  
            }
     */  
                } while (queue.size() > 1 && top.doc == curTopDoc);
        }
            // no-op  
    protected void doClose() {  
                        // Throw singleton exception for efficient control flow to HybridCollector  
            return new PruningCollector(collector, terms.iterator(), ctx, context, valuesSourceConfig.fieldContext().field());
                context.cardinalityAggregationPruningThreshold()
            numericCollectorsUsed++;
         * @opensearch.internal  
    @Override
            this.queue = queue;
        public DocIdSetIterator competitiveIterator() {
            }  
        public void close() {  
     * Ordinals Collector for the cardinality agg  
                throw new CollectionTerminatedException();  
            if (pruningCollector == null) {  
            if (queue.size() == 0) {
        public int nextDoc() throws IOException {
            visitedOrds = bigArrays.grow(visitedOrds, bucket + 1);
            Weight weight = context.query().rewrite(context.searcher()).createWeight(context.searcher(), ScoreMode.TOP_DOCS, 1f);
            }
        }
    /**
        }
                int count = values.docValueCount();
public class CardinalityAggregator extends NumericMetricsAggregator.SingleValue {
        }  
        public static MurmurHash3Values hash(SortedNumericDocValues values) {
import org.opensearch.core.rest.RestStatus;
/**  
import org.apache.lucene.search.Weight;
    }  
        Setting.Property.Dynamic
                pruningCollector.collect(doc);
            this.hashValues = hashValues;
            }
        }  
                ordinalsCollectorsUsed++;
        private final HyperLogLogPlusPlus counts;  
        }  
 * The OpenSearch Contributors require contributions made to  
        }
    public CardinalityAggregator(
            // no-op
         */  
            // no-op
            private final SortedBinaryDocValues values;
                int competitiveNext = competitiveIterator.advance(doc);
     *
            @Override
    );  
import org.apache.lucene.index.LeafReaderContext;  
        private final DisiPriorityQueue queue;
            if (values.advanceExact(doc)) {  
            }
                visitedOrds.set(bucket, bits);  
    /**  
            // - false writableStackTrace: disable expensive stack trace generation (~100x faster)
            if (maxOrd == 0) {
        public void collect(int doc, long bucketOrd) throws IOException {
            @Override  
    public double metric(long owningBucketOrd) {  
 * under the License.  
     * optimal performance - zero overhead when memory is under threshold.
import org.apache.lucene.search.Scorer;  
        private final MurmurHash3Values hashes;
import org.opensearch.common.util.ObjectArray;
                if (memoryMonitoringEnabled) {  
        @Override
            return new Long(values);
        return false;
                        : Long.MAX_VALUE) {
        @Override
     * @opensearch.internal
            if (hashes.advanceExact(doc)) {  
        @Override
import org.apache.lucene.index.SortedSetDocValues;
            do {  
     * Hybrid Collector that starts with OrdinalsCollector and switches to DirectCollector  
    private void postCollectLastCollector() throws IOException {
        };
                RestStatus.INTERNAL_SERVER_ERROR,
            HyperLogLogPlusPlus counts,  
            this.counts = counts;  
    /**
     *
import org.opensearch.common.util.LongArray;
        return new Collector() {  
            }  
        @Override  
            super(null, null, false, false);  
     * @opensearch.internal
                long ord;
        private final DisiPriorityQueue queue;
    }
            Bytes(SortedBinaryDocValues values) {  
         */
            assert competitiveIterator.docID() <= doc; // invariant
        }
                activeCollector.collect(doc, bucketOrd);
            HyperLogLogPlusPlus counts,
     * Empty Collector for the Cardinality agg  
                return values.advanceExact(docId);
        @Override
        public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
     */  
            if ((acceptDocs == null || acceptDocs.get(doc))) {
        public long getCurrentMemoryUsage() {
            CardinalityAggregationContext cardinalityContext
        private final DocIdSetIterator competitiveIterator;  
        "1%",  
        }
