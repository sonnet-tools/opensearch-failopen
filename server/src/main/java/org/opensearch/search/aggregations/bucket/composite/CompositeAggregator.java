                ctx,
        finishLeaf();
                super.collect(stream, owningBucketOrd);
    private final MissingOrder[] missingOrders;
                    @Override
                LongUnaryOperator round = ((RoundingValuesSource) sourceConfigs[i].valuesSource())::round;
     * @param indexSortPrefix The index sort prefix that matches the sources
            // We can bypass search entirely for this segment, the processing is done in the previous call.
                                            public long longValue() throws IOException {
                                                return dvs.advance(target);
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                    return false;
        }
    }
                        return delegate.equals(obj);
                Scorer scorer = weight.scorer(entry.context);
import org.apache.lucene.search.Sort;
                    public FieldComparator<?> getComparator(int numHits, Pruning pruning) {
                };
            }
    }
 *
                    }
        String name,
                if (subAggregators.length > 0) {
            this.reverseMuls[i] = sourceConfig.reverseMul();
        BooleanQuery newQuery = new BooleanQuery.Builder().add(context.query(), BooleanClause.Occur.MUST)
     * {@link RoundingValuesSource}.
                }
                                            @Override
        );
        );
                // documents from there.
import org.opensearch.common.lease.Releasables;
        collectableSubAggregators = BucketCollector.NO_OP_COLLECTOR;
                getFirstPassCollector(docIdSetBuilder, indexSortPrefix.getSort().length)
                }
                    public void collect(int doc, long zeroBucket) throws IOException {
                        return new LongComparator(1, delegate.getField(), (Long) missingValue, delegate.getReverse(), Pruning.NONE) {
            // since a map is not sorted structure, sort it before transform back to buckets
     */
                "Trying to create too many buckets. Must be less than or equal"
    private Sort applySortFieldRounding(Sort sort) {
            InternalAggregations aggs = subAggsForBuckets[slot];
                break;
                } else {
            CompositeValuesSourceConfig sourceConfig = sourceConfigs[i];
            if (rawAfterKey != null && sortPrefixLen > 0) {
                        return delegate.hashCode();
            // include all docs that belong to the partial bucket
                reverseMuls,
                    @Override
    }
                    long docCount = docCountProvider.getDocCount(doc);
    @Override
        this.sources = new SingleDimensionValuesSource[numSources];
    @Override
                if (i == 0) {
     *         not applicable.
     * Replay the top buckets from the matching documents.
        boolean fillDocIdSet = deferredCollectors != NO_OP_COLLECTOR;
            int lastDoc = -1;
import org.apache.lucene.search.Query;
            return indexSortPrefix.getSort().length;
        filterRewriteOptimizationContext.populateDebugInfo(add);
        if (indexSort == null) {
import org.apache.lucene.search.SortedNumericSelector;
                assert indexSortPrefix != null;
            @Override
                name,
                super.collectRange(min, max);
            // in the queue.
        for (int i = 0; i < sort.getSort().length; i++) {
 * specific language governing permissions and limitations
                            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
            } else {
        long[] bucketOrdsToCollect = new long[queue.size()];
    }
                                            }
            segmentMatchAll(context, ctx),
            // Visit documents sorted by the leading source of the composite definition and terminates
                }
        int num = Math.min(size, queue.size());
import org.apache.lucene.index.SortedNumericDocValues;
            formats,
     * Rewrites the provided {@link Sort} to apply rounding on {@link SortField} that target
    private final CompositeKey rawAfterKey;
    private LeafBucketCollector getSecondPassCollector(LeafBucketCollector subCollector) {
            if (sourceConfig.valuesSource() instanceof RoundingValuesSource) {
                // after the index sort prefix using the rawAfterKey and we start collecting
            @Override
                                        throws IOException {
                    }
            // Loop over the buckets in the bucketOrds, and populate the map accordingly
                // is the minimum of all values in the bucket, so need to add the interval
    private final SingleDimensionValuesSource<?>[] sources;
        deferredCollectors.preCollection();
                return size;
        }
    }
            }
            DocIdSetIterator scorerIt = null;
                                            @Override
                }
                    // so we don't check the other sources.
    private final CompositeValuesCollectorQueue queue;
import org.apache.lucene.index.LeafReaderContext;
                        // one doc may contain multiple values, we iterate over and collect one by one
    protected void doClose() {
                                            @Override
                this::addRequestCircuitBreakerBytes
                                            @Override
        if (deferredCollectors != NO_OP_COLLECTOR) {
     * Replay the documents that might contain a top bucket and pass top buckets to
import java.util.function.BiConsumer;
                CompositeKey key = new CompositeKey(bucketKeyValue);
                                                return dvs.advanceExact(target);
                                            @Override
                    assert scorerIt.docID() == docID;
            metadata()
            }
        return new Sort(sortFields);
            this.formats.add(sourceConfig.format());
                            lastDoc = doc;
     * optimization and null if index sort is not applicable.
import org.apache.lucene.index.SortedSetDocValues;
    }
                    earlyTerminated = true;
                final SortedNumericSortField delegate = (SortedNumericSortField) sort.getSort()[i];
                                            }
                    }
 * not use this file except in compliance with the License.
                if (scorer != null) {
        Aggregator parent,
            }
import org.opensearch.search.aggregations.CardinalityUpperBound;
    private Sort buildIndexSortPrefix(LeafReaderContext context) throws IOException {
                        assert zeroBucket == 0L;
            }
                docIdSetBuilder = new RoaringDocIdSet.Builder(ctx.reader().maxDoc());
                    bounds[0] = afterKey + interval;
import org.apache.lucene.search.Scorer;
                    scorerIt.advance(docID);
        }
 * The OpenSearch Contributors require contributions made to
            @Override
     * Returns the {@link Sort} prefix that is eligible to index sort
                missingOrders,
            fieldDoc.doc = -1;
        while (queue.size() > 0) {
                    }
                    return new Sort(indexSortField);
        this.reverseMuls = new int[numSources];
                buildRanges(context);
            );
            private RoundingValuesSource valuesSource;
import org.opensearch.search.aggregations.InternalAggregation;
                super.collect(stream, owningBucketOrd);
                    @Override
        // Build results from fast filters optimization
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
            .build();
                                            }
                // TODO: can we handle missing bucket when using index sort optimization ?
            Releasables.close(queue);
            }
                        this.afterKey = formats.get(0).parseLong(rawAfterKey.get(0).toString(), false, () -> {
                                    }
    @Override
import org.apache.lucene.util.CollectionUtil;
    private void processLeafFromQuery(LeafReaderContext ctx, Sort indexSortPrefix) throws IOException {
        // Composite aggregator must be at the top of the aggregation tree
                break;
            }
        Weight weight = null;
    @Override
    ) throws IOException {
import org.apache.lucene.search.BooleanClause;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                aggs
            }
import org.apache.lucene.search.DocIdSetIterator;
            sourceNames,
            }
            }
                return v2 != null && DocValues.unwrapSingleton(v2) == null;
        if (size > bucketLimit) {
        Map<String, Object> metadata,
    /** Return true if the provided field may have multiple values per document in the leaf **/
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        // Pre-initialize the destination collections with the correct size
                     * The filter rewrite optimized path does not support bucket intervals which are not fixed.
    /**
                earlyTerminated,
                    throw exc;
 * the Apache License, Version 2.0 (the "License"); you may
                                            delegate.getNumericType()
                if (afterKey != -1L) {
            );
            weight = context.searcher().createWeight(context.searcher().rewrite(query), ScoreMode.COMPLETE, 1f);
        this.sourceNames = new ArrayList<>(numSources);
     * Return the number of leading sources that match the index sort.
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(0);
                    + "]. This limit can be set by changing the ["
            final LeafBucketCollector collector = queue.getLeafCollector(entry.context, getSecondPassCollector(subCollector));
            @Override
            CompositeValuesSourceConfig sourceConfig = sourceConfigs[i];
    }
                context.bigArrays(),
                    return true;
                        formats,
                sourceNames,
        checkCancelled();
                        sourceNames,
import org.apache.lucene.search.SortedNumericSortField;
        if (indexSortPrefix == null) {
                    bucketMap.get(key).setDocCount(docCount);
            assert indexSortPrefix.getSort().length == 1;
        return sortFields.isEmpty() ? null : new Sort(sortFields.toArray(new SortField[0]));
    }
            ) };
            }
    private boolean earlyTerminated;
        // check that the provided size is not greater than the search.max_buckets setting
import static org.opensearch.search.aggregations.bucket.filterrewrite.AggregatorBridge.segmentMatchAll;
/**
        return new LeafBucketCollector() {
                break;
        return new InternalComposite(
        }
                }
import org.opensearch.search.DocValueFormat;
                        super.collectRange(min, max);
        this.size = size;
                formats,
            @Override
        this.queue = new CompositeValuesCollectorQueue(context.bigArrays(), sources, size, rawAfterKey);
            protected Rounding.Prepared getRoundingPrepared() {
            // see {@link MultiCollector} for more details on how we handle early termination in aggregations.
        if (sortedDocsProducer != null) {
import org.opensearch.search.aggregations.InternalAggregations;
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                final LeafBucketCollector inner = queue.getLeafCollector(ctx, getFirstPassCollector(docIdSetBuilder, sortPrefixLen));
        for (int i = 0; i < queue.size(); i++) {
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
                } catch (CollectionTerminatedException exc) {
import org.apache.lucene.search.LeafFieldComparator;
 * Licensed to Elasticsearch under one or more contributor
        };
                     */
                return valuesSource.getPreparedRounding();
            bucketOrdsToCollect[i] = i;
            protected long[] processAfterKey(long[] bounds, long interval) {
                    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            public void collectRange(int min, int max) throws IOException {
    }
     */
                        missingOrders,
                super.collectRange(min, max);
            while ((docID = docIdSetIterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
                    + "] but was ["
            if (fillDocIdSet) {
            final LeafBucketCollector inner = queue.getLeafCollector(
            SingleDimensionValuesSource<?> source = sources[i];
        CompositeKey rawAfterKey
            );
            final LeafBucketCollector subCollector = deferredCollectors.getLeafCollector(entry.context);
                    }
    }
                    this.valuesSource = (RoundingValuesSource) sourceConfigs[0].valuesSource();
                return false;
                        bucketDocCount(ordsEnum.ord()),
import org.opensearch.index.IndexSortConfig;
            // when the leading source value is guaranteed to be greater than the lowest composite bucket
            protected void prepare() throws IOException {
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
        }
            while (docIt.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
            ctx,
    protected void doPreCollection() {
        } else {
        deferredCollectors.postCollection();
            // Some segments may not be optimized, so buckets may contain results from the queue.
                    public int hashCode() {
            // CompositeKey is the value of bucket key
        this.formats = new ArrayList<>(numSources);
            if (indexSortField.getReverse() != (source.reverseMul == -1)) {
                entries.add(new Entry(ctx, docIdSet));
                return v1 != null && DocValues.unwrapSingleton(v1) == null;
            @Override
            earlyTerminated = true;
                if (needsScores) {
        for (Entry entry : entries) {
import org.apache.lucene.search.DocIdStream;
            }
            return 0;
        }
            }
            SortField indexSortField = indexSort.getSort()[i];
            this.sourceNames.add(sourceConfig.name());
            }
                    inner.collect(docIt.docID());
                if (canOptimize(sourceConfigs)) {
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);
/*
    public void collectDebugInfo(BiConsumer<String, Object> add) {
     * An entry in the composite aggregator
                    // We can defer the collection of this document/bucket to the sub collector
            protected Function<Long, Long> bucketOrdProducer() {
            protected Rounding getRounding(final long low, final long high) {
                        key,
 * compatible open source license.
import java.util.function.Function;
                || indexSortField.getField().equals(source.fieldType.name()) == false
        }
                                                return dvs.nextDoc();
            public void collectRange(int min, int max) throws IOException {
                formats,
        this.rawAfterKey = rawAfterKey;
 * software distributed under the License is distributed on an
    }
    @Override
                        assert rawAfterKey.size() == 1 && formats.size() == 1;
import org.opensearch.search.searchafter.SearchAfterBuilder;
import java.util.List;
    private LeafReaderContext currentLeaf;
 */
                                            delegate.getSelector(),
                    // The candidate key is a top bucket.
                };
    /**
            case INT:
        }
                    long docCount = bucketDocCount(ordsEnum.ord()) + bucketMap.get(key).getDocCount();
                    // bucketOrds is used for saving the date histogram results got from the optimization path
                                        NumericDocValues dvs = SortedNumericSelector.wrap(
            protected boolean canOptimize() {
                docCount,
        try {
                                                return dvs.docID();
    }
            while (ordsEnum.next()) {
import org.opensearch.search.internal.SearchContext;
        for (int i = 0; i < numSources; i++) {
            DocIdSetIterator docIt = scorer.iterator();
                                    @Override
                // We have an after key and index sort is applicable, so we jump directly to the doc
        CompositeKey lastBucket = num > 0 ? buckets[num - 1].getRawKey() : null;
import org.apache.lucene.util.RoaringDocIdSet;
                    }
            case LONG:
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.aggregations.MultiBucketConsumerService.MAX_BUCKET_SETTING;
        FieldDoc fieldDoc = SearchAfterBuilder.buildFieldDoc(
        Sort indexSort = context.reader().getMetaData().sort();
 * ownership. Elasticsearch licenses this file to you under
            }
    private final List<DocValueFormat> formats;
        if (needsScores) {
    private LeafBucketCollector getFirstPassCollector(RoaringDocIdSet.Builder builder, int indexSortPrefix) {
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);
            @Override
     *         leading source. A value of 0 indicates that the index sort is
        );
            entries.add(new Entry(currentLeaf, docIdSet));
        finishLeaf(); // May need to wrap up previous leaf if it could not be precomputed
                                            }
            sortFields.add(indexSortField);
            if (docIdSetIterator == null) {
                return bounds;
                final SortedSetDocValues v1 = context.reader().getSortedSetDocValues(sortField.getField());
            this.sources[i] = sourceConfig.createValuesSource(
            if (needsScores) {
            }
                metadata()
        final int numSources = sourceConfigs.length;
    }
        } finally {
                    if (queue.addIfCompetitive(indexSortPrefix, docCount)) {
import java.util.function.LongUnaryOperator;
        }
     */
        return new LeafBucketCollector() {
 * under the License.
        Scorer scorer = weight.scorer(ctx);
        }
                    + "] cluster level setting.",
            }
                    subCollector.setScorer(scorer);
                        reverseMuls,
                lastBucket,
    }
                    if (rawAfterKey != null) {
                }
        InternalComposite.InternalBucket[] buckets = new InternalComposite.InternalBucket[num];
                        buildEmptySubAggregations()
                            throw new IllegalArgumentException("now() is not supported in [after] key");
import org.apache.lucene.search.CollectionTerminatedException;
            CollectionUtil.introSort(bucketList, InternalComposite.InternalBucket::compareKey);
            case FLOAT:
            @Override
    /**
import org.opensearch.search.aggregations.bucket.filterrewrite.CompositeAggregatorBridge;
        if (indexSortPrefix.getSort()[0].getReverse() != (sources[0].reverseMul == -1)) {
    private final List<Entry> entries = new ArrayList<>();
                bucketLimit
 * @opensearch.internal
        SortField.Type type = IndexSortConfig.getSortFieldType(sortField);
                    }
 * You may obtain a copy of the License at
                        }
    }
            missingOrders,
                key,
            size,
import org.opensearch.lucene.queries.SearchAfterSortedDocQuery;
import org.apache.lucene.search.DocIdSet;
        if (currentLeaf != null) {
            }
        deferredCollectors = MultiBucketCollector.wrap(collectors);
            currentLeaf = null;
import org.apache.lucene.search.comparators.LongComparator;
            protected int getSize() {
    }
        }
        };
            if (sourceConfigs[i].valuesSource() instanceof RoundingValuesSource) {
    private void runDeferredCollections() throws IOException {
            num = buckets.length;
        if (indexSortPrefix.getSort().length < sources.length) {
            name,
                Arrays.asList(buckets),
import java.io.IOException;
            final Map<CompositeKey, InternalComposite.InternalBucket> bucketMap = new HashMap<>();
                final SortedNumericDocValues v2 = context.reader().getSortedNumericDocValues(sortField.getField());
            }
     */
            } else {
            if (fillDocIdSet) {
            }
     * The first pass selects the top composite buckets from all matching documents.
        SortField[] sortFields = new SortField[sort.getSort().length];
                if (liveDocs == null || liveDocs.get(docIt.docID())) {
                Long bucketKeyValue = ordsEnum.value();
    private record Entry(LeafReaderContext context, DocIdSet docIdSet) {
                                        );
import org.opensearch.search.aggregations.LeafBucketCollector;
                }
import org.opensearch.search.sort.SortAndFormats;
                sourceNames,
                || sourceConfig.hasScript()) {
                    @Override
                    scorerIt = scorer.iterator();
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                    + size
                    assert scorerIt != null && scorerIt.docID() < docID;
            if (source.fieldType == null
                                            DocValues.getSortedNumeric(context.reader(), field),
                                            public long cost() {
import org.apache.lucene.index.DocValues;
            null,
            Collections.emptyList(),
                    + " to: ["
    /**
                return (key) -> bucketOrds.add(0, getRoundingPrepared().round(key));
import org.apache.lucene.search.Weight;
import org.apache.lucene.util.Bits;
            return null;
        SearchContext context,
                    // the leading index sort matches the leading source field, but the order is reversed,
            Releasables.close(sources);
                    public void collectRange(int min, int max) throws IOException {
                || isMaybeMultivalued(context, indexSortField)
        if (scorer != null) {
            : null;
                || source.missingBucket
                        });
        };
        List<SortField> sortFields = new ArrayList<>();
            buckets = bucketList.subList(0, Math.min(size, bucketList.size())).toArray(InternalComposite.InternalBucket[]::new);
            }
                size,
                        return false;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        this.sourceConfigs = sourceConfigs;
     * @return The length of the index sort prefix if the sort order matches
    }
                // afterKey is the last bucket key in previous response, and the bucket key
 */
                     * For this reason we exclude non UTC timezones.
import org.apache.lucene.index.NumericDocValues;
                    subCollector.collect(doc, slot);
package org.opensearch.search.aggregations.bucket.composite;
                return valuesSource.getRounding();
        Sort indexSortPrefix = buildIndexSortPrefix(ctx);
            // Replay all documents that contain at least one top bucket (collected during the first pass).
     * @opensearch.internal
                                return new LongLeafComparator(context) {
            throw new MultiBucketConsumerService.TooManyBucketsException(
            Arrays.copyOfRange(rawAfterKey.values(), 0, formats.length)
                        inner.collect(doc);
     */
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
    /**
                                            public boolean advanceExact(int target) throws IOException {
import org.apache.lucene.search.BooleanQuery;
                try {
                collector.collect(docID);
            case STRING:
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
    /**
                currentLeaf = ctx;
import java.util.ArrayList;
}
        if (bucketOrds != null) {
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
                            @Override
        return new InternalAggregation[] {
    private BucketCollector deferredCollectors;
        DocValueFormat[] formats = new DocValueFormat[indexSortPrefix.getSort().length];
        this.missingOrders = new MissingOrder[numSources];
        int sortPrefixLen = computeSortPrefixLen(indexSortPrefix);
 *
                reverseMuls,
                    public boolean equals(Object obj) {
    @Override
                }
                                                return round.applyAsLong(dvs.longValue());
                    // aggregations should only be replayed on matching documents
                }
            new SortAndFormats(indexSortPrefix, formats),
            new InternalComposite(
            }
     */
        }
                    bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), CardinalityUpperBound.ONE);
            DocIdSet docIdSet = sortedDocsProducer.processLeaf(context.query(), queue, ctx, fillDocIdSet);
 * KIND, either express or implied.  See the License for the
                throw new CollectionTerminatedException();
    private final CompositeValuesSourceConfig[] sourceConfigs;
            Query query = context.query();
        int end = Math.min(indexSort.getSort().length, sourceConfigs.length);
        }
import org.opensearch.search.aggregations.BucketCollector;
                if (bucketMap.containsKey(key)) {
    }
            final Bits liveDocs = ctx.reader().getLiveDocs();
        int bucketLimit = context.aggregations().multiBucketConsumer().getLimit();
                missingOrders,
            int docID;
import org.apache.lucene.search.FieldDoc;
        Weight weight = context.searcher().createWeight(context.searcher().rewrite(newQuery), ScoreMode.COMPLETE_NO_SCORES, 1f);
            DocIdSetIterator docIdSetIterator = entry.docIdSet.iterator();
            public void collect(int doc, long bucket) throws IOException {
        }
import org.apache.lucene.search.Pruning;
import java.util.Map;
                bucketMap.put(internalBucket.getRawKey(), internalBucket);
                            builder.add(doc);
        for (int i = 0; i < end; i++) {
    private int computeSortPrefixLen(Sort indexSortPrefix) {
                        if (builder != null && lastDoc != doc) {
            CompositeKey key = queue.toCompositeKey(slot);
import java.util.Collections;
            long docCount = queue.getDocCount(slot);
            DocIdSet docIdSet = docIdSetBuilder.build();
                            }
    private LongKeyedBucketOrds bucketOrds;
import org.apache.lucene.search.SortField;
                return true;
        CompositeValuesSourceConfig[] sourceConfigs,
    CompositeAggregator(
            private long afterKey = -1L;
                                        return new NumericDocValues() {
    private final int size;
                assert zeroBucket == 0;
        CompositeAggregatorBridge bridge = new CompositeAggregatorBridge() {
import org.apache.lucene.search.FieldComparator;
     * the {@link #deferredCollectors}.
                sortFields[i] = sort.getSort()[i];
            buckets[queue.size()] = new InternalComposite.InternalBucket(
                size,
            }
                    );
            List<InternalComposite.InternalBucket> bucketList = new ArrayList<>(bucketMap.values());
            throw new CollectionTerminatedException();
public final class CompositeAggregator extends BucketsAggregator {
        return filterRewriteOptimizationContext.tryOptimize(
    private final int[] reverseMuls;
     *         or -1 if the leading index sort is in the reverse order of the
            }
                    + MAX_BUCKET_SETTING.getKey()
                                            }
            // Throwing this exception will terminate the execution of the search for this root aggregation,
        }
    protected void doPostCollection() {
                    + bucketLimit
                    @Override
                sortFields[i] = new SortedNumericSortField(delegate.getField(), delegate.getNumericType(), delegate.getReverse()) {
import org.opensearch.search.aggregations.Aggregator;
                                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field)
        InternalAggregations[] subAggsForBuckets = buildSubAggsForBuckets(bucketOrdsToCollect);
                // we have no clue whether the field is multivalued or not so we assume it is.
        for (int i = 0; i < formats.length; i++) {
            reverseMuls,
                        // so the same doc can appear multiple times here
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                    bucketMap.put(key, bucket);
        switch (type) {
            @Override
    @Override
            false,
import java.util.HashMap;
                if (slot != null) {
            }
                    }
                context.searcher().getIndexReader(),
                                                return dvs.cost();
     *
        }
                }
                                            public int advance(int target) throws IOException {
            runDeferredCollections();
 * Main aggregator that aggregates docs from multiple aggregations
            public void collect(int doc, long zeroBucket) throws IOException {
 * this work for additional information regarding copyright
            default:
import java.util.Arrays;
        }
        List<BucketCollector> collectors = Arrays.asList(subAggregators);
        }
                return new LeafBucketCollector() {
                    InternalComposite.InternalBucket bucket = new InternalComposite.InternalBucket(
 * GitHub history for details.
            .add(new SearchAfterSortedDocQuery(applySortFieldRounding(indexSortPrefix), fieldDoc), BooleanClause.Occur.FILTER)
        SortedDocsProducer sortedDocsProducer = sortPrefixLen == 0
    public InternalAggregation buildEmptyAggregation() {
            @Override
        finishLeaf();
 */
 *
    /**
            Releasables.close(bucketOrds);
        final boolean needsScores = scoreMode().needsScores();
/*
import org.apache.lucene.search.ScoreMode;
            for (InternalComposite.InternalBucket internalBucket : buckets) {
 *
                // so we ignore the subsequent sources even if they match the index sort.
            @Override
        assert owningBucketOrds.length == 1 && owningBucketOrds[0] == 0L;
            }
                                        };
                        super.collect(stream, owningBucketOrd);
import org.opensearch.search.aggregations.MultiBucketCollector;
import org.opensearch.common.Rounding;
                    @Override
        // Populate all collections from sourceConfigs
            int slot = queue.pop();
            case DOUBLE:
 */
    }
        }
        int size,
            inner.setScorer(scorer);
        AggregatorFactories factories,
            ? sources[0].createSortedDocsProducerOrNull(ctx.reader(), context.query())
        } else {
 * Unless required by applicable law or agreed to in writing,
                processLeafFromQuery(ctx, indexSortPrefix);
                    }
     */
            docIdSetBuilder = null;
                    /**
                        };
                                            @Override
                                            public int nextDoc() throws IOException {
            this.missingOrders[i] = sourceConfig.missingOrder();
        }
                                };
    private final List<String> sourceNames;
            collectableSubAggregators
                // the rounding "squashes" many values together, that breaks the ordering of sub-values,
    private RoaringDocIdSet.Builder docIdSetBuilder;
    private boolean isMaybeMultivalued(LeafReaderContext context, SortField sortField) throws IOException {
            );
     *
                                            }
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
                Integer slot = queue.getCurrentSlot();
                                            public int docID() {
            this::incrementBucketDocCount,
import org.opensearch.search.aggregations.AggregatorFactories;
            formats[i] = sources[i].format;
/*
            return -1;
                continue;
    private void finishLeaf() {
                    if (valuesSource.getRounding().isUTC() == false) {
