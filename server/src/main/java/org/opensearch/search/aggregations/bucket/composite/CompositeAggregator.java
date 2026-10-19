                    scorerIt = scorer.iterator();  
                                            }  
     */
                                            public int docID() {
            .add(new SearchAfterSortedDocQuery(applySortFieldRounding(indexSortPrefix), fieldDoc), BooleanClause.Occur.FILTER)
            earlyTerminated = true;
    }
                    scorerIt.advance(docID);
                if (subAggregators.length > 0) {  
            }
 * KIND, either express or implied.  See the License for the
                    // so we don't check the other sources.
                            }
     * Returns the {@link Sort} prefix that is eligible to index sort  
                        key,
                entries.add(new Entry(ctx, docIdSet));  
        this.missingOrders = new MissingOrder[numSources];
     * @param indexSortPrefix The index sort prefix that matches the sources
                    // We can defer the collection of this document/bucket to the sub collector
            }
import org.apache.lucene.search.FieldDoc;
import org.apache.lucene.index.SortedNumericDocValues;
            case LONG:  
import org.apache.lucene.util.Bits;
     */
                        this.afterKey = formats.get(0).parseLong(rawAfterKey.get(0).toString(), false, () -> {
            public void collectRange(int min, int max) throws IOException {
import org.apache.lucene.search.comparators.LongComparator;  
                    this.valuesSource = (RoundingValuesSource) sourceConfigs[0].valuesSource();
                                                return dvs.advance(target);  
import org.apache.lucene.index.LeafReaderContext;
            int lastDoc = -1;
                    public boolean equals(Object obj) {
            size,
                    }  
            // We can bypass search entirely for this segment, the processing is done in the previous call.
            bucketOrdsToCollect[i] = i;
import org.apache.lucene.search.LeafFieldComparator;
                super.collect(stream, owningBucketOrd);  
 *
            throw new CollectionTerminatedException();  
                };
                }
    private final List<Entry> entries = new ArrayList<>();
                                    }
        List<BucketCollector> collectors = Arrays.asList(subAggregators);  
    private final CompositeKey rawAfterKey;
                assert indexSortPrefix != null;
                                    protected NumericDocValues getNumericDocValues(LeafReaderContext context, String field)  
                Integer slot = queue.getCurrentSlot();
        this.sourceNames = new ArrayList<>(numSources);
                return false;  
        int bucketLimit = context.aggregations().multiBucketConsumer().getLimit();
import java.util.Map;  
    @Override
            }
        finishLeaf();
                continue;
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    }
    private BucketCollector deferredCollectors;
                    }
        if (indexSortPrefix.getSort().length < sources.length) {  
                if (bucketMap.containsKey(key)) {
package org.opensearch.search.aggregations.bucket.composite;
                                                return dvs.docID();
    }
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        }
        CompositeValuesSourceConfig[] sourceConfigs,  
                                            }  
            name,
            this.reverseMuls[i] = sourceConfig.reverseMul();  
        return filterRewriteOptimizationContext.tryOptimize(
            } else {
    private RoaringDocIdSet.Builder docIdSetBuilder;  
                Scorer scorer = weight.scorer(entry.context);
        }
                Long bucketKeyValue = ordsEnum.value();
        };
                if (needsScores) {  
                return new LeafBucketCollector() {  
                }
     */
        int end = Math.min(indexSort.getSort().length, sourceConfigs.length);  
                || indexSortField.getField().equals(source.fieldType.name()) == false
            case STRING:  
        for (int i = 0; i < numSources; i++) {  
            CompositeValuesSourceConfig sourceConfig = sourceConfigs[i];
            protected Rounding.Prepared getRoundingPrepared() {  
                    subCollector.collect(doc, slot);  
import org.opensearch.common.lease.Releasables;
                reverseMuls,
            sortFields.add(indexSortField);
            }
        }
    @Override
                    }  
            DocIdSet docIdSet = docIdSetBuilder.build();
/*
            Releasables.close(bucketOrds);
                        formats,
        Weight weight = context.searcher().createWeight(context.searcher().rewrite(newQuery), ScoreMode.COMPLETE_NO_SCORES, 1f);
                    earlyTerminated = true;
                size,
                                };  
     *         not applicable.  
            }
            : null;
        }  
 * GitHub history for details.
            while ((docID = docIdSetIterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
 * Unless required by applicable law or agreed to in writing,
    }
    private record Entry(LeafReaderContext context, DocIdSet docIdSet) {  
            return null;  
                super.collect(stream, owningBucketOrd);  
import java.util.List;
                // is the minimum of all values in the bucket, so need to add the interval
            CollectionUtil.introSort(bucketList, InternalComposite.InternalBucket::compareKey);
            inner.setScorer(scorer);  
        int size,
                super.collectRange(min, max);
                Arrays.asList(buckets),
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < formats.length; i++) {
        return new Sort(sortFields);  
                     */  
        SortedDocsProducer sortedDocsProducer = sortPrefixLen == 0  
            protected boolean canOptimize() {
import org.apache.lucene.index.SortedSetDocValues;
            ) };
            }  
            // CompositeKey is the value of bucket key
     *  
        finishLeaf(); // May need to wrap up previous leaf if it could not be precomputed  
                    }
    /** Return true if the provided field may have multiple values per document in the leaf **/
            @Override
    protected void doPreCollection() {
        try {
import org.opensearch.common.Rounding;
        for (Entry entry : entries) {
            }  
        this.rawAfterKey = rawAfterKey;
    private final List<DocValueFormat> formats;  
        return new LeafBucketCollector() {
import org.apache.lucene.search.Scorer;  
            @Override
            }
            if (fillDocIdSet) {
                                                return dvs.cost();
            this.missingOrders[i] = sourceConfig.missingOrder();
                        assert zeroBucket == 0L;  
import java.util.HashMap;
import org.opensearch.search.aggregations.LeafBucketCollector;  
                name,  
            @Override  
                    }
    private final SingleDimensionValuesSource<?>[] sources;
        SortField[] sortFields = new SortField[sort.getSort().length];
                    + " to: ["
            if (source.fieldType == null
     */
                earlyTerminated,
            // Visit documents sorted by the leading source of the composite definition and terminates
            default:
                                            public int nextDoc() throws IOException {  
                    public void collectRange(int min, int max) throws IOException {
                reverseMuls,  
 *  
     */
            public void collect(int doc, long zeroBucket) throws IOException {  
                // so we ignore the subsequent sources even if they match the index sort.
import org.opensearch.lucene.queries.SearchAfterSortedDocQuery;
                                            public long cost() {
            Arrays.copyOfRange(rawAfterKey.values(), 0, formats.length)
    }  
                                            @Override
    private boolean earlyTerminated;  
        CompositeKey lastBucket = num > 0 ? buckets[num - 1].getRawKey() : null;  
     * Rewrites the provided {@link Sort} to apply rounding on {@link SortField} that target  
    }  
            DocIdSetIterator scorerIt = null;
                                            }
            }
    private void processLeafFromQuery(LeafReaderContext ctx, Sort indexSortPrefix) throws IOException {  
                // the rounding "squashes" many values together, that breaks the ordering of sub-values,  
            SortField indexSortField = indexSort.getSort()[i];
                assert zeroBucket == 0;
                            @Override
                                        return new NumericDocValues() {
import org.apache.lucene.util.RoaringDocIdSet;  
 * under the License.  
    }
import static org.opensearch.search.aggregations.bucket.filterrewrite.AggregatorBridge.segmentMatchAll;  
            ? sources[0].createSortedDocsProducerOrNull(ctx.reader(), context.query())
                }
            @Override
                        bucketDocCount(ordsEnum.ord()),
            // since a map is not sorted structure, sort it before transform back to buckets
                }  
            @Override
                                            }
                }
        }
        for (int i = 0; i < queue.size(); i++) {  
            final Map<CompositeKey, InternalComposite.InternalBucket> bucketMap = new HashMap<>();  
                    }  
        } finally {
            return -1;
                formats,  
        if (scorer != null) {  
    }
                "Trying to create too many buckets. Must be less than or equal"
                }
import java.util.function.Function;
                // documents from there.  
        SortField.Type type = IndexSortConfig.getSortFieldType(sortField);
import java.util.ArrayList;
            Releasables.close(queue);  
            weight = context.searcher().createWeight(context.searcher().rewrite(query), ScoreMode.COMPLETE, 1f);
        switch (type) {
    @Override
                final LeafBucketCollector inner = queue.getLeafCollector(ctx, getFirstPassCollector(docIdSetBuilder, sortPrefixLen));
            this::incrementBucketDocCount,  
import org.opensearch.search.aggregations.bucket.filterrewrite.CompositeAggregatorBridge;
                        // so the same doc can appear multiple times here
                                                return round.applyAsLong(dvs.longValue());
            @Override  
    private LeafReaderContext currentLeaf;
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import org.opensearch.search.aggregations.InternalAggregation;
import org.apache.lucene.search.Query;
                        reverseMuls,  
            InternalAggregations aggs = subAggsForBuckets[slot];
            assert indexSortPrefix.getSort().length == 1;
                missingOrders,
                                            public boolean advanceExact(int target) throws IOException {
            protected long[] processAfterKey(long[] bounds, long interval) {
                    inner.collect(docIt.docID());
                    if (valuesSource.getRounding().isUTC() == false) {
                return v2 != null && DocValues.unwrapSingleton(v2) == null;  
        collectableSubAggregators = BucketCollector.NO_OP_COLLECTOR;
     */
 * specific language governing permissions and limitations
import org.apache.lucene.search.BooleanQuery;
                    return true;
                metadata()  
        return new LeafBucketCollector() {
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.InternalAggregations;
            );
            .build();  
     * The first pass selects the top composite buckets from all matching documents.
            case INT:
 * The OpenSearch Contributors require contributions made to  
                context.bigArrays(),
import org.apache.lucene.search.SortedNumericSelector;  
import org.opensearch.search.DocValueFormat;
 *
                                                return dvs.advanceExact(target);  
        }
        BooleanQuery newQuery = new BooleanQuery.Builder().add(context.query(), BooleanClause.Occur.MUST)
 * You may obtain a copy of the License at  
            }  
     *
            @Override
                    subCollector.setScorer(scorer);
            while (docIt.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                missingOrders,  
        } else {
        final int numSources = sourceConfigs.length;
import org.apache.lucene.search.ScoreMode;
    @Override  
                getFirstPassCollector(docIdSetBuilder, indexSortPrefix.getSort().length)
        );  
            List<InternalComposite.InternalBucket> bucketList = new ArrayList<>(bucketMap.values());  
                        };
            }
        CompositeKey rawAfterKey
                     * The filter rewrite optimized path does not support bucket intervals which are not fixed.
            buckets[queue.size()] = new InternalComposite.InternalBucket(
            final LeafBucketCollector subCollector = deferredCollectors.getLeafCollector(entry.context);  
    private final CompositeValuesSourceConfig[] sourceConfigs;  
            case FLOAT:
    @Override  
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
import org.opensearch.search.aggregations.BucketCollector;
            // Loop over the buckets in the bucketOrds, and populate the map accordingly
     * @opensearch.internal
                || isMaybeMultivalued(context, indexSortField)  
        }
     * An entry in the composite aggregator
                                    @Override
import java.util.function.BiConsumer;
import org.apache.lucene.search.CollectionTerminatedException;
            // include all docs that belong to the partial bucket
        );
}
        InternalAggregations[] subAggsForBuckets = buildSubAggsForBuckets(bucketOrdsToCollect);  
                                        };
                                            @Override  
        long[] bucketOrdsToCollect = new long[queue.size()];
 * this work for additional information regarding copyright
        }
            new InternalComposite(
                        sourceNames,  
            final LeafBucketCollector inner = queue.getLeafCollector(
 * compatible open source license.
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;  
    private Sort buildIndexSortPrefix(LeafReaderContext context) throws IOException {  
import java.util.Collections;  
        final boolean needsScores = scoreMode().needsScores();  
import org.opensearch.search.sort.SortAndFormats;
    }
            }  
import org.apache.lucene.search.BooleanClause;  
                }
import org.apache.lucene.index.NumericDocValues;  
     * {@link RoundingValuesSource}.
        Map<String, Object> metadata,
                super.collectRange(min, max);
        boolean fillDocIdSet = deferredCollectors != NO_OP_COLLECTOR;
    }  
            this.sourceNames.add(sourceConfig.name());
            final Bits liveDocs = ctx.reader().getLiveDocs();
/*  
                throw new CollectionTerminatedException();  
                    // bucketOrds is used for saving the date histogram results got from the optimization path
        checkCancelled();  
 * Licensed to Elasticsearch under one or more contributor  
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(0);  
                try {  
        }
                                            delegate.getNumericType()
                            builder.add(doc);  
            case DOUBLE:
            public void collect(int doc, long bucket) throws IOException {
            }
            }  
                if (canOptimize(sourceConfigs)) {  
                                        );  
                aggs
            );  
import org.apache.lucene.search.Sort;
                        return delegate.equals(obj);  
                key,
                size,
        deferredCollectors.postCollection();  
            }
                    if (rawAfterKey != null) {
    /**  
                // We have an after key and index sort is applicable, so we jump directly to the doc
        DocValueFormat[] formats = new DocValueFormat[indexSortPrefix.getSort().length];
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                    throw exc;  
                    }
                    + bucketLimit  
                    + "] but was ["
            CompositeKey key = queue.toCompositeKey(slot);
        for (int i = 0; i < end; i++) {
                    }  
import org.apache.lucene.search.SortField;
                context.searcher().getIndexReader(),  
            if (rawAfterKey != null && sortPrefixLen > 0) {  
            // in the queue.  
 * license agreements. See the NOTICE file distributed with
            @Override
public final class CompositeAggregator extends BucketsAggregator {
                            lastDoc = doc;
        if (size > bucketLimit) {
                                        NumericDocValues dvs = SortedNumericSelector.wrap(
            if (docIdSetIterator == null) {  
    private final int[] reverseMuls;
import java.util.Arrays;
                        assert rawAfterKey.size() == 1 && formats.size() == 1;  
            formats,
        }
                        missingOrders,
        AggregatorFactories factories,
import org.apache.lucene.search.DocIdSet;  
                processLeafFromQuery(ctx, indexSortPrefix);
import org.apache.lucene.search.Pruning;  
            metadata()
                                            public int advance(int target) throws IOException {
    protected void doPostCollection() {  
    @Override  
                    bounds[0] = afterKey + interval;  
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
                buildRanges(context);
        if (sortedDocsProducer != null) {  
        Scorer scorer = weight.scorer(ctx);
import org.apache.lucene.util.CollectionUtil;
            DocIdSet docIdSet = sortedDocsProducer.processLeaf(context.query(), queue, ctx, fillDocIdSet);
    private final MissingOrder[] missingOrders;
            while (ordsEnum.next()) {
        this.queue = new CompositeValuesCollectorQueue(context.bigArrays(), sources, size, rawAfterKey);  
                    @Override
        if (bucketOrds != null) {
                collector.collect(docID);  
                    @Override
 * this file be licensed under the Apache-2.0 license or a
    }
            }
     * optimization and null if index sort is not applicable.
import java.io.IOException;  
        // check that the provided size is not greater than the search.max_buckets setting  
            collectableSubAggregators
            int slot = queue.pop();  
                currentLeaf = ctx;  
     * Replay the documents that might contain a top bucket and pass top buckets to
            }
                    + MAX_BUCKET_SETTING.getKey()
            );  
        List<SortField> sortFields = new ArrayList<>();
                }
        // Populate all collections from sourceConfigs
 */  
        }
        CompositeAggregatorBridge bridge = new CompositeAggregatorBridge() {  
import java.util.function.LongUnaryOperator;  
    /**
            DocIdSetIterator docIdSetIterator = entry.docIdSet.iterator();
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);  
        super(name, factories, context, parent, CardinalityUpperBound.MANY, metadata);  
                }
        Aggregator parent,  
            private RoundingValuesSource valuesSource;
 * not use this file except in compliance with the License.
            @Override
 * Main aggregator that aggregates docs from multiple aggregations  
            missingOrders,
                CompositeKey key = new CompositeKey(bucketKeyValue);  
    @Override
            runDeferredCollections();
                sourceNames,
    /**
    private int computeSortPrefixLen(Sort indexSortPrefix) {
                lastBucket,
            currentLeaf = null;  
                    @Override
            fieldDoc.doc = -1;
        } else {  
            }  
                };
        finishLeaf();
            if (sourceConfigs[i].valuesSource() instanceof RoundingValuesSource) {  
        deferredCollectors = MultiBucketCollector.wrap(collectors);
                    }  
    private final CompositeValuesCollectorQueue queue;
                break;
                break;
                            throw new IllegalArgumentException("now() is not supported in [after] key");
            for (InternalComposite.InternalBucket internalBucket : buckets) {
/*  
 *
        String name,  
        this.sources = new SingleDimensionValuesSource[numSources];  
            } else {
        if (indexSortPrefix.getSort()[0].getReverse() != (sources[0].reverseMul == -1)) {  
                        return false;
    private boolean isMaybeMultivalued(LeafReaderContext context, SortField sortField) throws IOException {  
                    bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), CardinalityUpperBound.ONE);  
            // when the leading source value is guaranteed to be greater than the lowest composite bucket
                    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        // Build results from fast filters optimization  
            protected int getSize() {  
                                return new LongLeafComparator(context) {
    }  
                    );
            }  
                return true;
    private final int size;
        if (deferredCollectors != NO_OP_COLLECTOR) {  
                    // The candidate key is a top bucket.
                    + "] cluster level setting.",
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
                return (key) -> bucketOrds.add(0, getRoundingPrepared().round(key));  
        this.sourceConfigs = sourceConfigs;
                        // one doc may contain multiple values, we iterate over and collect one by one  
                        inner.collect(doc);
                } else {
import org.apache.lucene.index.DocValues;
            if (fillDocIdSet) {
            entries.add(new Entry(currentLeaf, docIdSet));
        if (indexSort == null) {
                // after the index sort prefix using the rawAfterKey and we start collecting
     * @return The length of the index sort prefix if the sort order matches  
            this.sources[i] = sourceConfig.createValuesSource(
            protected Rounding getRounding(final long low, final long high) {
import org.opensearch.search.aggregations.MultiBucketCollector;
        int sortPrefixLen = computeSortPrefixLen(indexSortPrefix);
    }  
     * Replay the top buckets from the matching documents.
    protected void doClose() {
        };
            }
import org.apache.lucene.search.Weight;
        if (needsScores) {
            // Throwing this exception will terminate the execution of the search for this root aggregation,  
            reverseMuls,
                if (afterKey != -1L) {
 * @opensearch.internal
            @Override
 * software distributed under the License is distributed on an
    }
                sourceNames,
    public InternalAggregation buildEmptyAggregation() {
        // Composite aggregator must be at the top of the aggregation tree
            protected Function<Long, Long> bucketOrdProducer() {
        }
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            docIdSetBuilder = null;
            throw new MultiBucketConsumerService.TooManyBucketsException(  
     * Return the number of leading sources that match the index sort.  
            }  
                bucketLimit  
    private Sort applySortFieldRounding(Sort sort) {  
                        return delegate.hashCode();
                    long docCount = docCountProvider.getDocCount(doc);
            false,  
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
                    + size
                docIdSetBuilder = new RoaringDocIdSet.Builder(ctx.reader().maxDoc());
            SingleDimensionValuesSource<?> source = sources[i];  
        Weight weight = null;
        }  
/**
    CompositeAggregator(
        Sort indexSort = context.reader().getMetaData().sort();
            Releasables.close(sources);  
            null,  
                return size;
    /**
            // see {@link MultiCollector} for more details on how we handle early termination in aggregations.
    }  
            int docID;
                || source.missingBucket
                    + "]. This limit can be set by changing the ["  
        if (currentLeaf != null) {  
        while (queue.size() > 0) {
                final SortedSetDocValues v1 = context.reader().getSortedSetDocValues(sortField.getField());
            formats[i] = sources[i].format;  
                                            }
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                     * For this reason we exclude non UTC timezones.
                } catch (CollectionTerminatedException exc) {
                    public int hashCode() {
                        });  
            num = buckets.length;  
        );
                || sourceConfig.hasScript()) {
            // Some segments may not be optimized, so buckets may contain results from the queue.
import org.opensearch.search.aggregations.Aggregator;  
                if (liveDocs == null || liveDocs.get(docIt.docID())) {  
import org.opensearch.search.searchafter.SearchAfterBuilder;  
                    @Override  
                                            delegate.getSelector(),
                                            }
                return valuesSource.getPreparedRounding();
            return indexSortPrefix.getSort().length;
    /**  
                            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {  
                    bucketMap.get(key).setDocCount(docCount);  
        filterRewriteOptimizationContext.populateDebugInfo(add);
        this.formats = new ArrayList<>(numSources);
                                            DocValues.getSortedNumeric(context.reader(), field),  
                                            @Override
            buckets = bucketList.subList(0, Math.min(size, bucketList.size())).toArray(InternalComposite.InternalBucket[]::new);
            segmentMatchAll(context, ctx),
                        if (builder != null && lastDoc != doc) {
        };
                // afterKey is the last bucket key in previous response, and the bucket key  
            // Replay all documents that contain at least one top bucket (collected during the first pass).
                    bucketMap.put(key, bucket);
                        buildEmptySubAggregations()  
        }
                bucketMap.put(internalBucket.getRawKey(), internalBucket);  
    private final List<String> sourceNames;  
                                            @Override  
        return new InternalComposite(  
            this.formats.add(sourceConfig.format());
import org.apache.lucene.search.DocIdSetIterator;
            protected void prepare() throws IOException {
            CompositeValuesSourceConfig sourceConfig = sourceConfigs[i];
                return bounds;
    private LongKeyedBucketOrds bucketOrds;  
import static org.opensearch.search.aggregations.MultiBucketConsumerService.MAX_BUCKET_SETTING;
            private long afterKey = -1L;
        for (int i = 0; i < sort.getSort().length; i++) {
            long docCount = queue.getDocCount(slot);  
     *         or -1 if the leading index sort is in the reverse order of the
    ) throws IOException {
                ctx,  
        SearchContext context,
        }
                    InternalComposite.InternalBucket bucket = new InternalComposite.InternalBucket(
            @Override  
                    @Override  
                                            public long longValue() throws IOException {  
            return 0;
            DocIdSetIterator docIt = scorer.iterator();
                        }
    private void runDeferredCollections() throws IOException {
    private LeafBucketCollector getFirstPassCollector(RoaringDocIdSet.Builder builder, int indexSortPrefix) {  
                // we have no clue whether the field is multivalued or not so we assume it is.  
            final LeafBucketCollector collector = queue.getLeafCollector(entry.context, getSecondPassCollector(subCollector));
                this::addRequestCircuitBreakerBytes
                break;
                    // the leading index sort matches the leading source field, but the order is reversed,
            );
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.internal.SearchContext;
                    public void collect(int doc, long zeroBucket) throws IOException {
                final SortedNumericDocValues v2 = context.reader().getSortedNumericDocValues(sortField.getField());
            Collections.emptyList(),
                                            @Override
                                            @Override
                    long docCount = bucketDocCount(ordsEnum.ord()) + bucketMap.get(key).getDocCount();
        int num = Math.min(size, queue.size());
                sortFields[i] = sort.getSort()[i];  
     *         leading source. A value of 0 indicates that the index sort is
            }
                    // aggregations should only be replayed on matching documents  
        InternalComposite.InternalBucket[] buckets = new InternalComposite.InternalBucket[num];  
                return valuesSource.getRounding();  
                    public FieldComparator<?> getComparator(int numHits, Pruning pruning) {  
        Sort indexSortPrefix = buildIndexSortPrefix(ctx);  
            if (indexSortField.getReverse() != (source.reverseMul == -1)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    return false;
        this.size = size;
        }  
                    @Override
                        return new LongComparator(1, delegate.getField(), (Long) missingValue, delegate.getReverse(), Pruning.NONE) {
import org.apache.lucene.search.FieldComparator;  
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
    private LeafBucketCollector getSecondPassCollector(LeafBucketCollector subCollector) {  
                // TODO: can we handle missing bucket when using index sort optimization ?  
        return new InternalAggregation[] {
                                                return dvs.nextDoc();
                    assert scorerIt.docID() == docID;
        return sortFields.isEmpty() ? null : new Sort(sortFields.toArray(new SortField[0]));
 */  
            }  
import org.apache.lucene.search.DocIdStream;
                    if (queue.addIfCompetitive(indexSortPrefix, docCount)) {
                                        throws IOException {
import org.apache.lucene.search.SortedNumericSortField;
                }
        // Pre-initialize the destination collections with the correct size  
            sourceNames,  
                if (slot != null) {  
        }
    }
            Query query = context.query();  
            ctx,
    /**
        }
        this.reverseMuls = new int[numSources];  
        FieldDoc fieldDoc = SearchAfterBuilder.buildFieldDoc(
    private void finishLeaf() {
     */
        deferredCollectors.preCollection();  
    }
                return v1 != null && DocValues.unwrapSingleton(v1) == null;
                        super.collect(stream, owningBucketOrd);  
                if (scorer != null) {
                LongUnaryOperator round = ((RoundingValuesSource) sourceConfigs[i].valuesSource())::round;
                    /**  
        }
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
            if (sourceConfig.valuesSource() instanceof RoundingValuesSource) {
            if (needsScores) {  
            public void collectRange(int min, int max) throws IOException {
    /**
                final SortedNumericSortField delegate = (SortedNumericSortField) sort.getSort()[i];
        if (indexSortPrefix == null) {  
                    return new Sort(indexSortField);  
                sortFields[i] = new SortedNumericSortField(delegate.getField(), delegate.getNumericType(), delegate.getReverse()) {  
                formats,  
 */  
import org.opensearch.index.IndexSortConfig;  
            }
                        super.collectRange(min, max);
                    assert scorerIt != null && scorerIt.docID() < docID;
                if (i == 0) {  
            }
    }  
            new SortAndFormats(indexSortPrefix, formats),  
        assert owningBucketOrds.length == 1 && owningBucketOrds[0] == 0L;
 */
     * the {@link #deferredCollectors}.  
    public void collectDebugInfo(BiConsumer<String, Object> add) {
                docCount,
            }
