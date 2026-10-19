            ) throws IOException {
        this.ordinalBucketOrds = ordinalMaxOrds == null
        Releasables.close(bucketOrds, ordinalBucketOrds, multiTermsValue);
    }
        }
                    current[depth] = ords[k];
        BytesRef dest = null;
         */
        public void close() {
        } else {
                for (int i = 0; i < dimensionIterators.size(); i++) {
                List<TermValue<?>> values = collectedValues.get(index);
            }
                 * This method does the following : <br>
    }
    /**
                }
                    for (int j = 0; j < dimIterator.entryValueCount(); j++) {
                long docCountMetric = docCountsIterator.nextValue();
            long[] ordinals = ordsEnum.ordinals();
            spare.docCount = docCount;
            }
            bucketsForOrd[b] = ordered.pop();
     * @opensearch.internal
        int ordIdx
        ) throws IOException {
            this.rawValueSources = rawValueSources;
     * A multi_terms collector which collect values on each doc,
                    if (values.advanceExact(doc)) {
                                if (longFilter == null || longFilter.accept(NumericUtils.doubleToSortableLong(val.doubleValue()))) {
        ) {
                    NumberFieldMapper.NumberFieldType numberFieldType = ((NumberFieldMapper.NumberFieldType) context.mapperService()
            bucketsForOrd[b] = ordered.pop();
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
            }
            return new InternalMultiTerms.Bucket[0];
            if (InternalOrder.isCountDesc(order)
        int count = counts[depth];
import org.opensearch.search.aggregations.InternalAggregation;
            bucketCountThresholds.getShardSize(),
        StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);
                                    termValues.add(TermValue.of(val));
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
import java.util.HashSet;
        List<TermValue<?>> apply(int doc) throws IOException;
            this.valuesSources = valuesSources;
        private final T value;
        }
            ? null
                    localBucketCountThresholds,
    static class InternalValuesSourceFactory {
                        int valuesCount = values.docValueCount();
    }
        public static TermValue<BytesRef> of(BytesRef value) {
                    }
            private final long[] ordTuple = new long[numFields];
                if (orderElement instanceof InternalOrder.Aggregation) {
                        List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
            return new TermValue<>(value, BIG_INTEGER_WRITER);
import org.opensearch.search.aggregations.LeafBucketCollector;
    }
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            preComputeWithStarTree(ctx, supportedStarTree);
            return;
                    // once for every field in every doc.
            {
            @Override
            aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
            if (spare == null) {
            }
        public MultiTermsValuesSource(List<ValuesSource> rawValueSources, List<InternalValuesSource> valuesSources) {
    InternalMultiTerms buildResult(long owningBucketOrd, long otherDocCount, InternalMultiTerms.Bucket[] topBuckets) {
        if (isKeyOrder(order) == false) {
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
            }
    /**
            result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCounts[ordIdx], topBucketsPerOrd[ordIdx]);
import org.opensearch.core.common.io.stream.Writeable;
                    long bucketOrd = ordinalBucketOrds.add(owningBucketOrd, current);
                    otherDocCounts,
                    value.writeTo(starTreeScratch);
                if (false == globalOrds[i].advanceExact(docId)) {
    }
            boolean collectBucketOrds = aggregator != null && sub != null;
                            double val = values.nextValue();
                    if (!dimIterator.advanceExact(starTreeEntry)) {
            return ctx -> {
        int size = (int) Math.min(bucketsInOrd, localBucketCountThresholds.getRequiredSize());
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                    if (false == globalOrds[i].advanceExact(doc)) {
        }
        }
import org.opensearch.search.aggregations.support.AggregationPath;
        }
            ordsEnum.readValue(dest);
    /**
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
        }
            };
            };
        public void writeTo(StreamOutput out) throws IOException {
                    int doc
        );
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
                termValues.add(BytesRef.deepCopyOf(globalOrdsForLookup[i].lookupOrd(ordinals[i])));
        PriorityQueue<InternalMultiTerms.Bucket> ordered = new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
    ) throws IOException {
     * Creates a {@link StarTreeBucketCollector} for pre-aggregating with a star-tree index.
        }
            reduceOrder = InternalOrder.key(true);
                    starTreeScratch.seek(position);
        };
    private final boolean showTermDocCountError;
    public List<DimensionFilter> getDimensionFilters() {
        InternalMultiTerms.Bucket[][] topBucketsPerOrd = new InternalMultiTerms.Bucket[owningBucketOrds.length][];
            for (int i = 0; i < numFields; i++) {
     * Factory for construct {@link InternalValuesSource}.
import org.opensearch.search.DocValueFormat;
            BucketsAggregator aggregator,
            if (skip) {
        return new LeafBucketCollector() {
            for (BucketOrder orderElement : compoundOrder.orderElements()) {
        long bucketsInOrd = bucketOrds.bucketsInOrd(owningBucketOrd);
        private static final Writer<Double> DOUBLE_WRITER = StreamOutput.getWriter(Double.class);
                    generateAndCollectFromStarTree(collectedValues, index + 1, owningBucketOrd, starTreeEntry, docCountMetric);
 * this file be licensed under the Apache-2.0 license or a
                    int numIterations = values.size();
        if (order instanceof InternalOrder.Aggregation) {
                starTreeScratch.seek(0);
            name,
        /**
                        // Avoid performing a deep copy of the composite key by inlining.
                 * This generates and collects all Composite keys in their buckets by performing a cartesian product <br>
     */
        private static final Writer<BigInteger> BIG_INTEGER_WRITER = StreamOutput.getWriter(BigInteger.class);
     * to form the composite keys for the multi-terms aggregation.
import java.util.Map;
                    }
                private void generateAndCollectCompositeKeys(
        BucketOrder reduceOrder;
        InternalMultiTerms.Bucket spare = null;
                        collectedValues.add(collector.apply(doc));
    @Override
        MultiTermsBucketOrds.BucketOrdsEnum ordsEnum = ordinalBucketOrds.ordsEnum(owningBucketOrd);
import java.util.ArrayList;
            @Override
        long[] ordTuple = new long[numFields];
        this.showTermDocCountError = showTermDocCountError;
        this.multiTermsValue = new MultiTermsValuesSource(rawValuesSources, internalValuesSources);
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
                    return Collections.emptyList();
    private InternalMultiTerms.Bucket[] buildBytesBuckets(
        LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
     *
                        return termValues;
    /**
                for (TermValue<?> value : values) {
        }
    private LeafBucketCollector getOrdinalLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                    // For each loop is not done to reduce the allocations done for Iterator objects
    @Override
                SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
            showTermDocCountError,
                                    termValues.add(TermValue.of(val));
import org.opensearch.search.startree.filter.MatchAllFilter;
            bucketCountThresholds
                                previous = val;
                    } else {
                });
                if (depth == numFields) {
                if (docCountsIterator.advanceExact(starTreeEntry) == false) {
        }
        if (subAggsNeedScore() && descendsFromNestedAggregator(parent)) {
    }
                            termValues.add(TermValue.of(bytes));
            LeafBucketCollector sub
    private void addOrdinalCombinations(long[][] ordinalSets, int[] counts, int depth, long[] current, long owningBucketOrd) {
                topBucketsPerOrd[ordIdx] = buildOrdinalBuckets(
    private final SubAggCollectionMode collectMode;
            return;
                        if (collectBucketOrds) {
         * Create {@link InternalValuesSourceCollector} from existing {@link LeafReaderContext}.
            }
        public static TermValue<Long> of(Long value) {
        private final BytesStreamOutput scratch = new BytesStreamOutput();
                            }
        // Get an iterator for each field (dimension) in the multi-terms aggregation.
            this.ordinalSources = ordSources;
import org.opensearch.common.lease.Releasable;
            current[depth] = ordinalSets[depth][k];
        public static TermValue<BigInteger> of(BigInteger value) {
        LocalBucketCountThresholds localBucketCountThresholds,
/*
                                aggregator.collectExistingBucket(sub, doc, bucketOrd);
    }
        CheckedSupplier<InternalMultiTerms.Bucket, IOException> emptyBucketBuilder = () -> InternalMultiTerms.Bucket.EMPTY(
                 * @param index : Points to the field being added to generate the composite key
        };
                collectors.add(valuesSource.apply(ctx));
                }
            }
        assert starTreeValues != null;
                    ordinalSetsScratch[i][j] = globalOrds[i].nextOrd();
        private final Writer<T> writer;
    public InternalAggregation buildEmptyAggregation() {
        }
            otherDocCounts[ordIdx] -= bucketsForOrd[b].getDocCount();
            checkCancelled();
            };
import org.opensearch.search.aggregations.AggregatorFactories;
    }
    }
                );
    @FunctionalInterface
    private final Comparator<InternalMultiTerms.Bucket> partiallyBuiltBucketComparator;
                generateOrdinalCombinations(0, ordTuple, owningBucketOrd, doc, sub);
                return doc -> {
        }
                            if (bucketOrd < 0) {
         * Generates the cartesian product of all fields used in aggregation and
    }
            otherDocCounts[ordIdx] -= bucketsForOrd[b].getDocCount();
     */
            order,
    /**
                    termValueBuilders.add(val -> TermValue.of(numberFieldType.toDoubleValue(val)));
                    try {
        }
    static class MultiTermsValuesSource implements Releasable {
                        throw new RuntimeException(e);
            formats
import org.opensearch.index.mapper.NumberFieldMapper;
                List<List<TermValue<?>>> collectedValues,
import java.io.IOException;
        );
        Aggregator parent,
            this.value = value;
            this.writer = writer;
        }
            reduceOrder = order;
    private final Set<Aggregator> aggsUsedForSorting = new HashSet<>();
     * This collector generates the cartesian product of dimension values within a single star-tree entry
    protected void doClose() {
                    }
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        InternalMultiTerms.Bucket spare = null;
        return false;
                    collector.apply(docId, owningBucketOrd);
    interface InternalValuesSourceCollector {
            addOrdinalCombinations(ordinalSets, counts, depth + 1, current, owningBucketOrd);
                return true;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        AggregatorFactories factories,
        return new InternalMultiTerms(
            formats,
                    owningBucketOrds[ordIdx],
            if (spare == null) {
        }
    private boolean subAggsNeedScore() {
import org.opensearch.common.CheckedSupplier;
                    }
                        }
                    List<TermValue<?>> values = collectedValues.get(index);
        /**
                 * @param collectedValues : Values of all fields present in the aggregation for the @doc
import org.opensearch.search.aggregations.InternalOrder;
            private final long[][] ordinalSetsScratch = new long[numFields][];
                for (int k = 0; k < count; k++) {
                        BigInteger previous = Numbers.MAX_UNSIGNED_LONG_VALUE;
                    List<List<TermValue<?>>> collectedValues = new ArrayList<>();
import org.apache.lucene.util.PriorityQueue;
                SortedNumericDocValues values = valuesSource.longValues(ctx);
            }
                        valuesForDim.add(builder.apply(dimIterator.value()));
            if (vs instanceof ValuesSource.Bytes.WithOrdinals vsBytes) {
                    }
        int numFields = ordinalSources.size();
                return doc -> {
                 * <li>Adds every composite key to the @{@link BytesKeyedBucketOrds} and Optionally collects them via @{@link BucketsAggregator#collectBucket(LeafBucketCollector, int, long)}</li>
            if (ordinalBucketOrds != null) {
        // We also need a way to convert the raw long values from the iterators into the correct TermValue type.
                return doc -> {
package org.opensearch.search.aggregations.bucket.terms;
 * compatible open source license.
     * A terms collector which collect values on each doc,
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            showTermDocCountError,
        LocalBucketCountThresholds localBucketCountThresholds,
            } else {
        for (int k = 0; k < count; k++) {
                }
        if (ordinalBucketOrds != null) {
            fields.stream().map(a -> (DimensionFilter) new MatchAllFilter(a)).toList(),
            0,
            metadata(),
                for (int i = 0; i < numFields; i++) {
            name,
        return bucketsForOrd;
        List<DocValueFormat> formats,
            return ctx -> {
            dimensionIterators.add(starTreeValues.getDimensionValuesIterator(fieldName));
    private void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {
        SortedSetDocValues[] globalOrds = new SortedSetDocValues[numFields];
        while (ordsEnum.next()) {
                    if (collectedValues.size() == index) {
            if (leaves.isEmpty() == false) {
                List<List<TermValue<?>>> collectedValues = new ArrayList<>();
        long[] otherDocCounts,
            0,
            otherDocCount,
                throw new IllegalStateException("Unsupported ValuesSource type for star-tree: " + vs.getClass().getName());
                        value.writeTo(scratch); // encode the value
 *
    }
     * Multi_Term ValuesSource, it is a collection of {@link InternalValuesSource}
                            }
                    List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
    ) throws IOException {
        }
            starTreeValues,
            }
        return StarTreeQueryHelper.collectDimensionFilters(
    @Override
        static InternalValuesSource bytesValuesSource(ValuesSource valuesSource, IncludeExclude.StringFilter includeExclude) {
                        BytesRef bytes = values.nextValue();
            List<InternalValuesSourceCollector> collectors = new ArrayList<>();
        int[] ordinalCounts = new int[numFields];
     *
            globalOrdsForLookup = new SortedSetDocValues[ordinalSources.size()];
    ) throws IOException {
                        ordinalSetsScratch[i][j] = globalOrds[i].nextOrd();
            }
            String fieldName = fields.get(i);
        }
                /**
import java.util.Collections;
        }
                    }
                            long val = values.nextValue();
        if (globalOrdsForLookup == null || globalOrdsForLookup[0] == null) {
        }
                int count = globalOrds[i].docValueCount();
import org.opensearch.common.lease.Releasables;
        long[] otherDocCounts = new long[owningBucketOrds.length];
                        if (includeExclude != null && false == includeExclude.accept(bytes)) {
        }
                    AggregationPath path = ((InternalOrder.Aggregation) orderElement).path();
        }
                    generateOrdinalCombinations(depth + 1, current, owningBucketOrd, doc, sub);
        return ordinalBucketOrds;
    /** Package-private for testing. */
    private final List<String> fields;
import org.opensearch.common.io.stream.BytesStreamOutput;
        }
            spare = ordered.insertWithOverflow(spare);
 */
                    List<List<TermValue<?>>> collectedValues,
    private InternalMultiTerms.Bucket[] buildOrdinalBuckets(
    @Override
            }
        }
        }
            return new MultiTermsValuesSourceCollector() {
            }
                }
        SortedSetDocValues[] globalOrdsForLookup
        this.bucketCountThresholds = bucketCountThresholds;
                    );
                                aggregator.collectBucket(sub, doc, bucketOrd);
                }
                    } catch (IOException e) {
        } else {
                long owningBucketOrd,
            scratch.close();
            parent == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
        );
                    }
                LeafReaderContext leafCtx = leaves.get(0);
            if (subAgg.scoreMode().needsScores()) {
                        int valuesCount = values.docValueCount();
                collector.apply(doc, owningBucketOrd);
    }
        for (int b = ordered.size() - 1; b >= 0; --b) {
        for (int i = 0; i < fields.size(); i++) {
                    // A full composite key is in the buffer, add it to bucketOrds.
            List<LeafReaderContext> leaves = context.searcher().getTopReaderContext().leaves();
        buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            subAggregators
        BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrd);
            } else if (vs instanceof ValuesSource.Numeric numericSource) {
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
     * Creates a leaf collector that collects global ordinals directly instead of
                } else {
                    }
        } else {
                    globalOrdsForLookup
    private void preComputeWithStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
                    globalOrdsForLookup[i] = ordinalSources.get(i).globalOrdinalsValues(leafCtx);
            for (InternalValuesSource valuesSource : valuesSources) {
                int count = ordinalCounts[depth];
        this.fields = fields;
                        return; // missing value in any field → skip doc
 * The OpenSearch Contributors require contributions made to
                    for (InternalValuesSourceCollector collector : collectors) {
                }
            }
            List<Object> termValues = new ArrayList<>(ordinals.length);
        return collectMode == Aggregator.SubAggCollectionMode.BREADTH_FIRST && !aggsUsedForSorting.contains(aggregator);
        private static final Writer<Long> LONG_WRITER = StreamOutput.getWriter(Long.class);
                    return termValues;
                        return;
        List<ValuesSource> rawValuesSources,
                long[] ords = ordinalSetsScratch[depth];
        List<InternalValuesSource> internalValuesSources,
        while (ordsEnum.next()) {
            }
                    if (bucketOrd < 0) {
                for (int i = 0; i < ordinalSources.size(); i++) {
import org.opensearch.search.startree.StarTreeQueryHelper;
        StarTreeBucketCollector parent
                }
                 */
        return new StarTreeBucketCollector(
            boolean skip = false;
                    break;
                    collectedValues.add(valuesForDim);
    private final MultiTermsValuesSource multiTermsValue;
                    for (int i = 0; i < valuesCount; ++i) {
                    long position = scratch.position();
                public void apply(int doc, long owningBucketOrd) throws IOException {
                    ordinalSetsScratch[i] = new long[1];
                            BytesRef copy = BytesRef.deepCopyOf(bytes);
                dest = new BytesRef();
                        for (int i = 0; i < valuesCount; ++i) {
                        }
            if (docCount < localBucketCountThresholds.getMinDocCount()) {
            return ctx -> {
                        if (valuesCount > 1) {
                generateAndCollectFromStarTree(collectedValues, 0, owningBucketOrd, starTreeEntry, docCountMetric);
                        }
import org.apache.lucene.util.NumericUtils;
    @Override
        }
                        .fieldType(fieldName));
                            if (previous != val || i == 0) {
                /**
            metadata(),
import org.apache.lucene.index.LeafReaderContext;
            order,
                };
            globalOrds[i] = ordinalSources.get(i).globalOrdinalsValues(ctx);
                        } else {
                    scratch.seek(0);
import org.opensearch.search.startree.filter.DimensionFilter;
    ) throws IOException {
    }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
    }
                 * <li>Generates Composite keys from the fetched values for all fields present in the aggregation.</li>
import org.opensearch.search.aggregations.CardinalityUpperBound;
                            previous = copy;
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
            globalOrds[i] = ordinalSources.get(i).globalOrdinalsValues(ctx);
    public MultiTermsAggregator(
            spare.docCount = docCount;
        Map<String, Object> metadata,
        long owningBucketOrd,
            public void collect(int doc, long owningBucketOrd) throws IOException {
                        collectBucket(sub, doc, bucketOrd);
import org.opensearch.common.Numbers;
                                }
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
                }
     * serialized term values. Generates the cartesian product of ordinal tuples
                long position = starTreeScratch.position();
 *
     */
        }
                    this.subCollectors.add(
    private final BytesKeyedBucketOrds bucketOrds;
         * Collect a list values of a term on specific doc.
        final List<Function<Long, TermValue<?>>> termValueBuilders = new ArrayList<>();
                    }
        LeafReaderContext ctx,
        this.bucketOrds = this.ordinalBucketOrds == null ? BytesKeyedBucketOrds.build(context.bigArrays(), cardinality) : null;
                        for (int i = 0; i < valuesCount; ++i) {
            if (docCount < localBucketCountThresholds.getMinDocCount()) {
        }
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
                }
            };
            /*
import org.opensearch.core.common.io.stream.StreamOutput;
                }
                return;
        // Build the packed-ordinal ords here, after super(), so a failing super constructor (e.g. a circuit
        long[] otherDocCounts,
        long[][] ordinalSetsScratch = new long[numFields][];
        }
                        long previous = Long.MAX_VALUE;
        long owningBucketOrd,
    private void collectZeroDocOrdinals(LeafReaderContext ctx, long owningBucketOrd) throws IOException {
        private final List<InternalValuesSource> valuesSources;
        BucketOrder order,
                            if (previous != val || i == 0) {
                continue;
                                bucketOrd = -1 - bucketOrd;
    /**
        this.formats = formats;
                            BigInteger val = Numbers.toUnsignedBigInteger(values.nextValue());
                                    termValues.add(TermValue.of(val));
                        generateAndCollectCompositeKeys(collectedValues, index + 1, owningBucketOrd, doc); // dfs
import org.apache.lucene.util.BytesRef;
        }
    }
                        double previous = Double.MAX_VALUE;
     * across all fields for each document.
            List<ValuesSource.Bytes.WithOrdinals> ordSources = new ArrayList<>(rawValuesSources.size());
                    for (int j = 0; j < count; j++) {
                if (numericSource.isFloatingPoint()) {
            private void generateOrdinalCombinations(int depth, long[] current, long owningBucketOrd, int doc, LeafBucketCollector sub)
     */
import org.opensearch.ExceptionsHelper;
        for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
     * @opensearch.internal
        SearchContext context,
        /**
                            }
/**
    @Override
        int ordIdx,
                }
import org.opensearch.search.internal.SearchContext;
                    }
        int numFields = ordinalSources.size();
        StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, starTree, null);
    }
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
                    }
            public void collect(int doc, long owningBucketOrd) throws IOException {
                    scratch.writeVInt(collectors.size()); // number of fields per composite key
                    ordinalSetsScratch[i] = new long[count];
                collectZeroDocOrdinals(ctx, owningBucketOrd);
}
import org.opensearch.search.aggregations.BucketOrder;
import static org.opensearch.search.aggregations.bucket.terms.TermsAggregator.descendsFromNestedAggregator;
        }
    public StarTreeBucketCollector getStarTreeBucketCollector(
         */
            long docCount = bucketDocCount(ordsEnum.ord());
            return input.readList(StreamInput::readGenericValue);
                            termValues.add(TermValue.of(copy));
                        int valuesCount = values.docValueCount();
        } else {
            // Per-leaf scratch buffers; grown only when a field has more values than current capacity.
            throw ExceptionsHelper.convertToRuntime(e);
            } else {
        private static final Writer<BytesRef> BYTES_REF_WRITER = StreamOutput.getWriter(BytesRef.class);
        // Don't defer any child agg if we are dependent on it for pruning results
            Collections.emptyList(),
              Force the execution to depth_first because we need to access the score of
            spare.termValues = decode(dest);
    @Override
    static class TermValue<T> implements Writeable {
            }
        InternalMultiTerms.Bucket[] bucketsForOrd = new InternalMultiTerms.Bucket[ordered.size()];
                    }
    }
        public MultiTermsValuesSourceCollector getValues(
                        ordinalSetsScratch[i] = new long[count];
        );
                    BytesRef previous = null;
            this.collectMode = SubAggCollectionMode.DEPTH_FIRST;
                    StarTreeValuesIterator dimIterator = dimensionIterators.get(i);
                continue;
                        List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
    }
            ordinalSetsScratch[i] = new long[1];
        InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
            @Override
            0,
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
                    if (values.advanceExact(doc)) {
        @Override
import java.util.List;
            return ctx -> {
        MultiTermsValuesSourceCollector collector = multiTermsValue.getValues(ctx, bucketOrds, this, sub);
        void apply(int doc, long owningBucketOrd) throws IOException;
                long docCountMetric
                ordSources.add((ValuesSource.Bytes.WithOrdinals) vs);
                 * <li>Fetches the values of every field present in the doc List<List<TermValue<?>>> via @{@link InternalValuesSourceCollector}</li>
        InternalValuesSourceCollector apply(LeafReaderContext ctx) throws IOException;
            }
                                }
                        if (i > 0 && bytes.equals(previous)) {
            LeafReaderContext ctx,
        this.order = order;
                 */
                        long bucketOrd = bucketOrds.add(owningBucketOrd, scratch.bytes().toBytesRef());
                    for (TermValue<?> value : values) {
    private final List<ValuesSource.Bytes.WithOrdinals> ordinalSources;
            writer.write(out, value);
            addOrdinalCombinations(ordinalSetsScratch, ordinalCounts, 0, ordTuple, owningBucketOrd);
                    return;
        );
            showTermDocCountError,
                    generateAndCollectCompositeKeys(collectedValues, 0, owningBucketOrd, doc);
    /**
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
            }
                    return;
                    long bucketOrd = bucketOrds.add(owningBucketOrd, starTreeScratch.bytes().toBytesRef());
            collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
            otherDocCounts[ordIdx] += docCount;
                    return Collections.emptyList();
    @FunctionalInterface
                    List<TermValue<?>> valuesForDim = new ArrayList<>();
                        }
    private static List<Object> decode(BytesRef bytesRef) {
        return new InternalMultiTerms(
        if (ordinalBucketOrds != null) {
                spare = emptyBucketBuilder.get();
import org.opensearch.core.common.io.stream.StreamInput;
                            } else {
        long bucketsInOrd = ordinalBucketOrds.bucketsInOrd(owningBucketOrd);
            spare = ordered.insertWithOverflow(spare);
            for (ValuesSource vs : rawValuesSources) {
        static InternalValuesSource unsignedLongValuesSource(ValuesSource.Numeric valuesSource, IncludeExclude.LongFilter longFilter) {
        public static TermValue<Double> of(Double value) {
            spare.termValues = termValues;
            bucketCountThresholds
            }
                                if (longFilter == null || longFilter.accept(val)) {
 */
     */
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
            this.collectMode = collectMode;
        }
            return getOrdinalLeafCollector(ctx, sub);
                        }
                        return termValues;
    }
            }
            public void setSubCollectors() throws IOException {
        if (bucketCountThresholds.getMinDocCount() != 0) {
            return new TermValue<>(value, DOUBLE_WRITER);
    }
import org.opensearch.core.common.bytes.BytesArray;
                 * of all the values in all the fields ( used in agg ) for the given doc recursively.
        if (this.ordinalBucketOrds != null) {
                    int count = globalOrds[i].docValueCount();
                                previous = val;
import java.math.BigInteger;
              while replaying deferred documents.
        }
                }
 * SPDX-License-Identifier: Apache-2.0
        super(name, factories, context, parent, metadata);
                && ordinalBucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
                        return termValues;
                                }
     * Represents an individual term value.
            }
        for (Aggregator subAgg : subAggregators) {
        SubAggCollectionMode collectMode,
                    skip = true;
                        return TermValue.of(vsBytes.globalOrdinalsValues(ctx).lookupOrd(ord));
                continue;
            otherDocCounts[ordIdx] += docCount;
                    Function<Long, TermValue<?>> builder = termValueBuilders.get(i);
import java.util.function.Function;
                    collectStarTreeBucket(this, docCountMetric, bucketOrd, starTreeEntry);
        return new LeafBucketCollector() {
                return doc -> {
public class MultiTermsAggregator extends DeferableBucketAggregator implements StarTreePreComputeCollector {
                @Override
        final List<StarTreeValuesIterator> dimensionIterators = new ArrayList<>();
        for (int i = 0; i < numFields; i++) {
            : PackedOrdinalBucketOrds.create(context.bigArrays(), cardinality, ordinalMaxOrds);
                }
        @Override
                    // need to take care of dups
                    ordinalCounts[i] = count;
                    }
                        // Performing a deep copy is not required for field containing only one value.
            private void generateAndCollectFromStarTree(
    private final BytesStreamOutput starTreeScratch = new BytesStreamOutput();
        }
        }
                    long owningBucketOrd,
        SortedSetDocValues[] globalOrds = new SortedSetDocValues[numFields];
    interface MultiTermsValuesSourceCollector {
                                previous = val;
                };
        static InternalValuesSource doubleValueSource(ValuesSource.Numeric valuesSource, IncludeExclude.LongFilter longFilter) {
        CompositeIndexFieldInfo starTree,
                    if (false == values.advanceExact(doc)) {
        }
                    int valuesCount = values.docValueCount();
import java.util.Comparator;
              nested documents in a sub-aggregation and we are not able to generate this score
            return new TermValue<>(value, BYTES_REF_WRITER);
            spare.bucketOrd = ordsEnum.ord();
                    ordIdx,
            }
import org.opensearch.search.aggregations.StarTreeBucketCollector;
                int starTreeEntry,
                MultiTermsValuesSourceCollector collector = multiTermsValue.getValues(ctx, bucketOrds, null, null);
                        collectExistingBucket(sub, doc, -1 - bucketOrd);
                return;
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
                starTreeScratch.writeVInt(dimensionIterators.size());
            showTermDocCountError,
                        return Collections.emptyList();
         */
    }
        return false;
            private final int[] ordinalCounts = new int[numFields];
        SortedSetDocValues[] globalOrdsForLookup = null;
        for (int i = 0; i < numFields; i++) {
                SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
            order,
                    termValueBuilders.add(TermValue::of);
        return bucketsForOrd;
    }
        PriorityQueue<InternalMultiTerms.Bucket> ordered = new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
            }
            };
    private final BucketOrder order;
                ordinalCounts[i] = count;
                            continue;
                for (int j = 0; j < count; j++) {
            Arrays.sort(topBuckets, reduceOrder.comparator());
        }
        } else if (order instanceof InternalOrder.CompoundOrder compoundOrder) {
import java.util.Set;
                    int index,
                ) throws IOException {
        CheckedSupplier<InternalMultiTerms.Bucket, IOException> emptyBucketBuilder = () -> InternalMultiTerms.Bucket.EMPTY(
    }
                        List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
                termValueBuilders.add(ord -> {
                for (int i = 0; i < numFields; i++) {
                    }
        long[] ordinalMaxOrds
            long docCount = bucketDocCount(ordsEnum.ord());
            this.ordinalSources = null;
        }
            @Override
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
                }
            List.of(topBuckets),
        // breaker trip while allocating docCounts) cannot leave an orphaned BigArrays allocation. PackedOrdinalBucketOrds.create
        private final List<ValuesSource> rawValueSources;
 * @opensearch.internal
                    // SortedBinaryDocValues don't guarantee uniqueness so we
                        return;
                int index,
                    return; // No documents in this star-tree entry.
    private final MultiTermsBucketOrds ordinalBucketOrds;
import java.util.Arrays;
    }
            }
        private TermValue(T value, Writer<T> writer) {
    MultiTermsBucketOrds getOrdinalBucketOrds() {
                    // TODO A new list creation can be avoided for every doc.
            AggregationPath path = ((InternalOrder.Aggregation) order).path();
        // Todo, copy from TermsAggregator. need to remove duplicate code.
            ordinalBucketOrds.add(owningBucketOrd, current);
import org.apache.lucene.index.SortedNumericDocValues;
import org.apache.lucene.index.SortedSetDocValues;
    }
                }
                        }
                    if (ordinalSetsScratch[i].length < count) {
        for (int b = ordered.size() - 1; b >= 0; --b) {
        }
            formats
    }
                                if (longFilter == null || longFilter.accept(NumericUtils.doubleToSortableLong(val))) {
                    aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
            BytesKeyedBucketOrds bucketOrds,
                }
        try (StreamInput input = new BytesArray(bytesRef).streamInput()) {
        int size = (int) Math.min(bucketsInOrd, localBucketCountThresholds.getRequiredSize());
                // brute force
                SortedNumericDocValues values = valuesSource.longValues(ctx);
    protected boolean shouldDefer(Aggregator aggregator) {
        if (depth == counts.length) {
        }
        boolean showTermDocCountError,
            }
                }
        static InternalValuesSource longValuesSource(ValuesSource.Numeric valuesSource, IncludeExclude.LongFilter longFilter) {
                    return Collections.emptyList();
        String name,
            // we need to fill-in the blanks
                    if (values.advanceExact(doc)) {
    interface InternalValuesSource {
import org.opensearch.search.aggregations.support.ValuesSource;
                spare = emptyBucketBuilder.get();
                        for (int i = 0; i < valuesCount; ++i) {
            ValuesSource vs = multiTermsValue.rawValueSources.get(i);
            formats,
        } catch (IOException e) {
                };
            return new TermValue<>(value, LONG_WRITER);
            return true;
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
                            continue;
        if (ordinalBucketOrds != null) {
                            }
     */
            spare.bucketOrd = ordsEnum.ord();
                };
     */
        if (supportedStarTree != null) {
            }
        for (int i = 0; i < numFields; i++) {
    @FunctionalInterface
                        // If any dimension is missing for this entry, the cartesian product is empty.
        return result;
        List<String> fields,
        InternalMultiTerms.Bucket[] bucketsForOrd = new InternalMultiTerms.Bucket[ordered.size()];
    private final List<DocValueFormat> formats;
                        scratch.seek(position); // backtrack
        this.partiallyBuiltBucketComparator = order == null ? null : order.partiallyBuiltBucketComparator(b -> b.bucketOrd, this);
             */
            for (int i = 0; i < ordinals.length; i++) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import org.opensearch.search.aggregations.Aggregator;
            reduceOrder,
 * An aggregator that aggregate with multi_terms.
                topBucketsPerOrd[ordIdx] = buildBytesBuckets(owningBucketOrds[ordIdx], localBucketCountThresholds, otherDocCounts, ordIdx);
                for (Aggregator aggregator : subAggregators) {
            bucketCountThresholds.getShardSize(),
        };
                throws IOException {
                }
                if (index == collectedValues.size()) {
                        }
         * collects them in buckets using the composite key of their field values.
        // may itself return null (e.g. >126-bit or two-long+MANY), in which case the byte-key path is used.
                if (ordinalSetsScratch[i].length < count) {
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
                            if (previous.compareTo(val) != 0 || i == 0) {
        CardinalityUpperBound cardinality,
                    }
