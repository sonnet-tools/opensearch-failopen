                    return;  
    public List<DimensionFilter> getDimensionFilters() {  
                        scratch.seek(position); // backtrack  
        public void writeTo(StreamOutput out) throws IOException {
                    int count = globalOrds[i].docValueCount();  
    ) throws IOException {  
     * Creates a leaf collector that collects global ordinals directly instead of
                }
                    return termValues;  
    private final BytesStreamOutput starTreeScratch = new BytesStreamOutput();
    interface InternalValuesSource {
            boolean collectBucketOrds = aggregator != null && sub != null;
                    int numIterations = values.size();  
                    ordinalSetsScratch[i][j] = globalOrds[i].nextOrd();
            List<InternalValuesSourceCollector> collectors = new ArrayList<>();
                 * <li>Fetches the values of every field present in the doc List<List<TermValue<?>>> via @{@link InternalValuesSourceCollector}</li>
                            }
        return false;
    @FunctionalInterface
                }
                topBucketsPerOrd[ordIdx] = buildOrdinalBuckets(
                dest = new BytesRef();  
        }
    @Override  
    private final List<ValuesSource.Bytes.WithOrdinals> ordinalSources;  
            if (docCount < localBucketCountThresholds.getMinDocCount()) {
                    }
            otherDocCounts[ordIdx] -= bucketsForOrd[b].getDocCount();
            }
        long bucketsInOrd = bucketOrds.bucketsInOrd(owningBucketOrd);  
            checkCancelled();
    private final TermsAggregator.BucketCountThresholds bucketCountThresholds;
        // Get an iterator for each field (dimension) in the multi-terms aggregation.
                /**
        AggregatorFactories factories,
import java.util.ArrayList;
            }
            subAggregators  
        }
                topBucketsPerOrd[ordIdx] = buildBytesBuckets(owningBucketOrds[ordIdx], localBucketCountThresholds, otherDocCounts, ordIdx);
                                if (longFilter == null || longFilter.accept(val)) {  
    @Override
        }
        return false;
                                previous = val;
                    // TODO A new list creation can be avoided for every doc.
                 * @param collectedValues : Values of all fields present in the aggregation for the @doc
            }
    }  
    }  
            reduceOrder,
                            termValues.add(TermValue.of(copy));  
            }
            this.valuesSources = valuesSources;
        }  
                starTreeScratch.seek(0);
                @Override
        }  
        long[][] ordinalSetsScratch = new long[numFields][];
                continue;
                        int valuesCount = values.docValueCount();
                        return;
        }
        return result;
        );  
                        generateAndCollectCompositeKeys(collectedValues, index + 1, owningBucketOrd, doc); // dfs
        for (Aggregator subAgg : subAggregators) {
                        if (collectBucketOrds) {
                }
            }
import org.opensearch.search.aggregations.support.AggregationPath;
import org.apache.lucene.util.PriorityQueue;  
                                previous = val;  
        boolean showTermDocCountError,  
        public void close() {
                            }
                public void apply(int doc, long owningBucketOrd) throws IOException {  
                    this.subCollectors.add(  
        SearchContext context,
    InternalMultiTerms buildResult(long owningBucketOrd, long otherDocCount, InternalMultiTerms.Bucket[] topBuckets) {
            private void generateAndCollectFromStarTree(
                for (int i = 0; i < dimensionIterators.size(); i++) {
import org.opensearch.search.aggregations.LeafBucketCollector;
                    try {
        long[] otherDocCounts,  
                    skip = true;
        @Override  
        }
            } else if (vs instanceof ValuesSource.Numeric numericSource) {  
            }  
            long docCount = bucketDocCount(ordsEnum.ord());
            @Override  
        return new InternalMultiTerms(
                        long bucketOrd = bucketOrds.add(owningBucketOrd, scratch.bytes().toBytesRef());
        };
            }
     * A terms collector which collect values on each doc,  
                            continue;
            collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
                            } else {  
                        List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
            bucketsForOrd[b] = ordered.pop();  
    }
                if (numericSource.isFloatingPoint()) {
        long[] ordinalMaxOrds  
                                aggregator.collectBucket(sub, doc, bucketOrd);
        /**
            }
                if (false == globalOrds[i].advanceExact(docId)) {  
public class MultiTermsAggregator extends DeferableBucketAggregator implements StarTreePreComputeCollector {
    private boolean subAggsNeedScore() {
            globalOrdsForLookup = new SortedSetDocValues[ordinalSources.size()];
                        return termValues;  
        return StarTreeQueryHelper.collectDimensionFilters(
        this.partiallyBuiltBucketComparator = order == null ? null : order.partiallyBuiltBucketComparator(b -> b.bucketOrd, this);  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
        } else if (order instanceof InternalOrder.CompoundOrder compoundOrder) {
                return;
                    int valuesCount = values.docValueCount();
        } catch (IOException e) {
        int ordIdx,  
                    }
                generateOrdinalCombinations(0, ordTuple, owningBucketOrd, doc, sub);  
        private final Writer<T> writer;
            order,
            fields.stream().map(a -> (DimensionFilter) new MatchAllFilter(a)).toList(),
        long bucketsInOrd = ordinalBucketOrds.bucketsInOrd(owningBucketOrd);  
                int starTreeEntry,
     * to form the composite keys for the multi-terms aggregation.  
 * this file be licensed under the Apache-2.0 license or a
    @FunctionalInterface
                    for (InternalValuesSourceCollector collector : collectors) {  
        }  
                        for (int i = 0; i < valuesCount; ++i) {
                generateAndCollectFromStarTree(collectedValues, 0, owningBucketOrd, starTreeEntry, docCountMetric);
            }
/*  
        for (int i = 0; i < numFields; i++) {  
                        if (includeExclude != null && false == includeExclude.accept(bytes)) {  
        InternalMultiTerms.Bucket spare = null;  
                                bucketOrd = -1 - bucketOrd;
import org.apache.lucene.index.LeafReaderContext;
                termValueBuilders.add(ord -> {
            dimensionIterators.add(starTreeValues.getDimensionValuesIterator(fieldName));  
                } else {
    @Override  
                    List<TermValue<?>> valuesForDim = new ArrayList<>();  
                        // Performing a deep copy is not required for field containing only one value.  
        int ordIdx
            LeafReaderContext ctx,
        // breaker trip while allocating docCounts) cannot leave an orphaned BigArrays allocation. PackedOrdinalBucketOrds.create
        Map<String, Object> metadata,
    protected boolean shouldDefer(Aggregator aggregator) {
                            }
        return bucketsForOrd;
import org.opensearch.search.startree.filter.MatchAllFilter;  
 * compatible open source license.
            ValuesSource vs = multiTermsValue.rawValueSources.get(i);
            ordsEnum.readValue(dest);  
        private static final Writer<Double> DOUBLE_WRITER = StreamOutput.getWriter(Double.class);
         * collects them in buckets using the composite key of their field values.  
     */
     * Factory for construct {@link InternalValuesSource}.
}
            0,
        }
                    }
                        ordinalSetsScratch[i][j] = globalOrds[i].nextOrd();  
         */  
    }
        }
        } else {  
     * Multi_Term ValuesSource, it is a collection of {@link InternalValuesSource}
                        }
        }
            }
        String name,
import java.math.BigInteger;  
    }  
                for (int k = 0; k < count; k++) {
    private void collectZeroDocOrdinals(LeafReaderContext ctx, long owningBucketOrd) throws IOException {  
            List.of(topBuckets),
        assert starTreeValues != null;
        long owningBucketOrd,  
                }
    }
        return collectMode == Aggregator.SubAggCollectionMode.BREADTH_FIRST && !aggsUsedForSorting.contains(aggregator);  
                            }  
import org.opensearch.index.mapper.NumberFieldMapper;
                continue;
            }
        MultiTermsBucketOrds.BucketOrdsEnum ordsEnum = ordinalBucketOrds.ordsEnum(owningBucketOrd);
         * Generates the cartesian product of all fields used in aggregation and
import org.opensearch.common.CheckedSupplier;
            bucketCountThresholds
    }
    private final boolean showTermDocCountError;
import org.opensearch.search.aggregations.StarTreePreComputeCollector;  
            ? null
        if (globalOrdsForLookup == null || globalOrdsForLookup[0] == null) {  
            }
                int count = ordinalCounts[depth];  
    private final Comparator<InternalMultiTerms.Bucket> partiallyBuiltBucketComparator;
                };
            this.ordinalSources = ordSources;
                        int valuesCount = values.docValueCount();  
                    }
                            long val = values.nextValue();
     *
            formats,  
        BucketOrder order,
        int size = (int) Math.min(bucketsInOrd, localBucketCountThresholds.getRequiredSize());
                return true;
        }
        // Build the packed-ordinal ords here, after super(), so a failing super constructor (e.g. a circuit  
                    } else {  
            otherDocCounts[ordIdx] -= bucketsForOrd[b].getDocCount();
                }  
                 */
        int count = counts[depth];
    }
            0,  
        List<ValuesSource> rawValuesSources,
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
              nested documents in a sub-aggregation and we are not able to generate this score
            {  
    public MultiTermsAggregator(  
    /**  
                }
                    }
    }
            Collections.emptyList(),  
            for (InternalValuesSource valuesSource : valuesSources) {
                    return; // No documents in this star-tree entry.  
            return true;
                    long position = scratch.position();
                    // A full composite key is in the buffer, add it to bucketOrds.  
            String fieldName = fields.get(i);
                    collectStarTreeBucket(this, docCountMetric, bucketOrd, starTreeEntry);
    private LeafBucketCollector getOrdinalLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {  
                for (TermValue<?> value : values) {
                ordinalCounts[i] = count;
            }
                    if (values.advanceExact(doc)) {
            spare = ordered.insertWithOverflow(spare);
                collectors.add(valuesSource.apply(ctx));  
        static InternalValuesSource bytesValuesSource(ValuesSource valuesSource, IncludeExclude.StringFilter includeExclude) {  
                };
            addOrdinalCombinations(ordinalSetsScratch, ordinalCounts, 0, ordTuple, owningBucketOrd);
                    // For each loop is not done to reduce the allocations done for Iterator objects
            otherDocCounts[ordIdx] += docCount;
                    return Collections.emptyList();  
        LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
import org.opensearch.search.aggregations.CardinalityUpperBound;
            }
        SortedSetDocValues[] globalOrdsForLookup
                throw new IllegalStateException("Unsupported ValuesSource type for star-tree: " + vs.getClass().getName());  
            }
                ) throws IOException {
    private InternalMultiTerms.Bucket[] buildBytesBuckets(  
        }
            public void collect(int doc, long owningBucketOrd) throws IOException {
        LocalBucketCountThresholds localBucketCountThresholds,
    private final Set<Aggregator> aggsUsedForSorting = new HashSet<>();  
                        List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
            showTermDocCountError,
import java.io.IOException;
                        ordinalSetsScratch[i] = new long[count];  
                SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);  
    }  
                    }  
        }  
            }  
                    }
            BytesKeyedBucketOrds bucketOrds,  
                        return termValues;
            private final long[] ordTuple = new long[numFields];
        private final BytesStreamOutput scratch = new BytesStreamOutput();  
                    if (ordinalSetsScratch[i].length < count) {
                        double previous = Double.MAX_VALUE;
import java.util.Comparator;
 *
        }  
        }
        }
        }
        SubAggCollectionMode collectMode,  
            for (int i = 0; i < ordinals.length; i++) {  
                 * This generates and collects all Composite keys in their buckets by performing a cartesian product <br>  
        List<TermValue<?>> apply(int doc) throws IOException;
                                    termValues.add(TermValue.of(val));
     * @opensearch.internal
        for (int k = 0; k < count; k++) {
import org.opensearch.search.internal.SearchContext;  
                    } catch (IOException e) {
                    ordinalSetsScratch[i] = new long[count];
            formats  
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {  
            bucketCountThresholds.getShardSize(),
                collectZeroDocOrdinals(ctx, owningBucketOrd);
        }
                 * <li>Adds every composite key to the @{@link BytesKeyedBucketOrds} and Optionally collects them via @{@link BucketsAggregator#collectBucket(LeafBucketCollector, int, long)}</li>  
        if (order instanceof InternalOrder.Aggregation) {
                    for (int i = 0; i < valuesCount; ++i) {
import java.util.function.Function;  
                    if (collectedValues.size() == index) {
            }  
            }
        }  
                }  
                    generateAndCollectFromStarTree(collectedValues, index + 1, owningBucketOrd, starTreeEntry, docCountMetric);
    private final BucketOrder order;  
        }
    /**  
                        }  
    private void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {  
import org.opensearch.common.Numbers;  
            @Override  
        final List<Function<Long, TermValue<?>>> termValueBuilders = new ArrayList<>();
                    break;
import org.apache.lucene.util.BytesRef;
            spare.termValues = decode(dest);
            bucketCountThresholds
            }  
            otherDocCount,
        int numFields = ordinalSources.size();
                        // If any dimension is missing for this entry, the cartesian product is empty.
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
            scratch.close();
                    BytesRef previous = null;  
    ) throws IOException {
            List<ValuesSource.Bytes.WithOrdinals> ordSources = new ArrayList<>(rawValuesSources.size());
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
        InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
            order,
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
        TermsAggregator.BucketCountThresholds bucketCountThresholds,
import java.util.List;  
        private static final Writer<BytesRef> BYTES_REF_WRITER = StreamOutput.getWriter(BytesRef.class);
import org.opensearch.common.lease.Releasable;
        long owningBucketOrd,
            result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCounts[ordIdx], topBucketsPerOrd[ordIdx]);  
        }
                }  
                /**
            // we need to fill-in the blanks
            return new TermValue<>(value, DOUBLE_WRITER);  
                };  
                    int doc  
                    current[depth] = ords[k];
        for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {  
/**  
                throws IOException {
        private final List<ValuesSource> rawValueSources;
import org.opensearch.search.DocValueFormat;  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                }
                    localBucketCountThresholds,
        List<String> fields,  
         */
    }  
                        if (i > 0 && bytes.equals(previous)) {  
        InternalValuesSourceCollector apply(LeafReaderContext ctx) throws IOException;
            @Override  
    /** Package-private for testing. */
                        BigInteger previous = Numbers.MAX_UNSIGNED_LONG_VALUE;  
        final List<StarTreeValuesIterator> dimensionIterators = new ArrayList<>();  
        LeafReaderContext ctx,  
                    if (false == values.advanceExact(doc)) {
    @Override
    @Override  
                long position = starTreeScratch.position();  
        private static final Writer<BigInteger> BIG_INTEGER_WRITER = StreamOutput.getWriter(BigInteger.class);
        public static TermValue<Long> of(Long value) {  
     */
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        }  
import org.opensearch.core.common.io.stream.StreamInput;
            List<LeafReaderContext> leaves = context.searcher().getTopReaderContext().leaves();  
    interface InternalValuesSourceCollector {  
         */
        static InternalValuesSource longValuesSource(ValuesSource.Numeric valuesSource, IncludeExclude.LongFilter longFilter) {  
        };  
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
                // brute force  
        StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);  
            name,  
        return new InternalMultiTerms(  
    @Override
        if (depth == counts.length) {  
                    }
              Force the execution to depth_first because we need to access the score of
            boolean skip = false;
                SortedNumericDocValues values = valuesSource.longValues(ctx);
              while replaying deferred documents.  
                        for (int i = 0; i < valuesCount; ++i) {  
                        collectBucket(sub, doc, bucketOrd);
 * SPDX-License-Identifier: Apache-2.0
        SortedSetDocValues[] globalOrds = new SortedSetDocValues[numFields];
    /**
            parent == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
        int size = (int) Math.min(bucketsInOrd, localBucketCountThresholds.getRequiredSize());
                }
                            previous = copy;
            if (docCount < localBucketCountThresholds.getMinDocCount()) {  
        }  
        int[] ordinalCounts = new int[numFields];
                return doc -> {  
                        }
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
                        long previous = Long.MAX_VALUE;
    private void preComputeWithStarTree(LeafReaderContext ctx, CompositeIndexFieldInfo starTree) throws IOException {
            writer.write(out, value);
        // We also need a way to convert the raw long values from the iterators into the correct TermValue type.
                    for (TermValue<?> value : values) {  
         * Collect a list values of a term on specific doc.
                                    termValues.add(TermValue.of(val));
     */  
            reduceOrder = InternalOrder.key(true);
import static org.opensearch.search.aggregations.bucket.terms.TermsAggregator.descendsFromNestedAggregator;  
            if (ordinalBucketOrds != null) {
    /**
                );
            public void collect(int doc, long owningBucketOrd) throws IOException {
        return new LeafBucketCollector() {  
    /**
                    generateOrdinalCombinations(depth + 1, current, owningBucketOrd, doc, sub);  
            order,  
            return ctx -> {
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
    interface MultiTermsValuesSourceCollector {  
        }  
                        if (valuesCount > 1) {
            showTermDocCountError,  
        );  
            this.value = value;
        SortedSetDocValues[] globalOrdsForLookup = null;  
                    List<TermValue<?>> termValues = new ArrayList<>(valuesCount);
                int count = globalOrds[i].docValueCount();
                    NumberFieldMapper.NumberFieldType numberFieldType = ((NumberFieldMapper.NumberFieldType) context.mapperService()
     */
                && ordinalBucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {  
                        } else {
    MultiTermsBucketOrds getOrdinalBucketOrds() {
            /*  
            if (subAgg.scoreMode().needsScores()) {  
    public InternalAggregation buildEmptyAggregation() {
                            BigInteger val = Numbers.toUnsignedBigInteger(values.nextValue());  
        LocalBucketCountThresholds localBucketCountThresholds,
import org.opensearch.search.startree.StarTreeQueryHelper;
        StarTreeBucketCollector parent
            @Override  
                    List<List<TermValue<?>>> collectedValues = new ArrayList<>();
        long[] otherDocCounts,
        private final T value;
        for (int i = 0; i < fields.size(); i++) {
        }
        this.ordinalBucketOrds = ordinalMaxOrds == null  
                                }
        private TermValue(T value, Writer<T> writer) {
                    }  
    }
    }
        CheckedSupplier<InternalMultiTerms.Bucket, IOException> emptyBucketBuilder = () -> InternalMultiTerms.Bucket.EMPTY(
            if (spare == null) {  
        } else {  
            for (BucketOrder orderElement : compoundOrder.orderElements()) {  
                    // once for every field in every doc.
                    termValueBuilders.add(val -> TermValue.of(numberFieldType.toDoubleValue(val)));
                    }
        }
                    }
                    for (int j = 0; j < dimIterator.entryValueCount(); j++) {
                    List<List<TermValue<?>>> collectedValues,  
            ordinalBucketOrds.add(owningBucketOrd, current);
                                if (longFilter == null || longFilter.accept(NumericUtils.doubleToSortableLong(val))) {
            spare.bucketOrd = ordsEnum.ord();
            spare.docCount = docCount;  
    }
                for (Aggregator aggregator : subAggregators) {
            metadata(),  
                    owningBucketOrds[ordIdx],  
import java.util.Map;
    private final MultiTermsValuesSource multiTermsValue;
                        List<TermValue<?>> termValues = new ArrayList<>(valuesCount);  
        }  
import org.opensearch.search.startree.filter.DimensionFilter;
            }
    public StarTreeBucketCollector getStarTreeBucketCollector(
                MultiTermsValuesSourceCollector collector = multiTermsValue.getValues(ctx, bucketOrds, null, null);
            Arrays.sort(topBuckets, reduceOrder.comparator());
        InternalMultiTerms.Bucket[] bucketsForOrd = new InternalMultiTerms.Bucket[ordered.size()];
        private final List<InternalValuesSource> valuesSources;
                 * <li>Generates Composite keys from the fetched values for all fields present in the aggregation.</li>
    }
        ) {
        }
                spare = emptyBucketBuilder.get();
                        return Collections.emptyList();
                        int valuesCount = values.docValueCount();
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        public static TermValue<BytesRef> of(BytesRef value) {
            return new TermValue<>(value, BYTES_REF_WRITER);  
                return doc -> {
import org.opensearch.ExceptionsHelper;
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
        PriorityQueue<InternalMultiTerms.Bucket> ordered = new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
                    if (values.advanceExact(doc)) {
        PriorityQueue<InternalMultiTerms.Bucket> ordered = new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
                termValues.add(BytesRef.deepCopyOf(globalOrdsForLookup[i].lookupOrd(ordinals[i])));
        }
        StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, starTree, null);
 *
                            if (previous.compareTo(val) != 0 || i == 0) {
            }
        }
    ) throws IOException {
                    if (bucketOrd < 0) {
                        return TermValue.of(vsBytes.globalOrdinalsValues(ctx).lookupOrd(ord));  
            current[depth] = ordinalSets[depth][k];  
        if (subAggsNeedScore() && descendsFromNestedAggregator(parent)) {
                private void generateAndCollectCompositeKeys(
        private static final Writer<Long> LONG_WRITER = StreamOutput.getWriter(Long.class);  
        while (ordsEnum.next()) {
    ) throws IOException {
                    return Collections.emptyList();
        } else {  
                                    termValues.add(TermValue.of(val));  
                for (int i = 0; i < numFields; i++) {
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;  
        // may itself return null (e.g. >126-bit or two-long+MANY), in which case the byte-key path is used.
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {  
        for (int b = ordered.size() - 1; b >= 0; --b) {
            }  
                        // Avoid performing a deep copy of the composite key by inlining.  
            addOrdinalCombinations(ordinalSets, counts, depth + 1, current, owningBucketOrd);
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
 */  
        }  
                            if (bucketOrd < 0) {  
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
        // Don't defer any child agg if we are dependent on it for pruning results
            : PackedOrdinalBucketOrds.create(context.bigArrays(), cardinality, ordinalMaxOrds);
    static class TermValue<T> implements Writeable {
                List<List<TermValue<?>>> collectedValues,
                List<TermValue<?>> values = collectedValues.get(index);
            spare = ordered.insertWithOverflow(spare);
import org.opensearch.search.aggregations.InternalOrder;  
        /**
import org.opensearch.search.aggregations.support.ValuesSource;
                 * @param index : Points to the field being added to generate the composite key  
                long docCountMetric  
            BucketsAggregator aggregator,
import org.opensearch.search.aggregations.AggregatorFactories;
        Releasables.close(bucketOrds, ordinalBucketOrds, multiTermsValue);
        return new StarTreeBucketCollector(
        for (int i = 0; i < numFields; i++) {  
                        return;  
                 * This method does the following : <br>  
            long docCount = bucketDocCount(ordsEnum.ord());
        } else {  
            if (spare == null) {
                if (depth == numFields) {
                        collectExistingBucket(sub, doc, -1 - bucketOrd);
                long docCountMetric = docCountsIterator.nextValue();
        while (ordsEnum.next()) {  
                            if (previous != val || i == 0) {  
                        throw new RuntimeException(e);
                        return; // missing value in any field → skip doc
    }
            formats
import org.opensearch.search.aggregations.BucketOrder;  
                    long bucketOrd = bucketOrds.add(owningBucketOrd, starTreeScratch.bytes().toBytesRef());
                continue;
            ordinalSetsScratch[i] = new long[1];
        return ordinalBucketOrds;  
                SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
     * Represents an individual term value.
        return bucketsForOrd;  
    }  
            AggregationPath path = ((InternalOrder.Aggregation) order).path();  
                long owningBucketOrd,
package org.opensearch.search.aggregations.bucket.terms;
        BucketOrder reduceOrder;
        if (ordinalBucketOrds != null) {
                    value.writeTo(starTreeScratch);  
                            double val = values.nextValue();
    }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    }
                        collectedValues.add(collector.apply(doc));
    protected void doClose() {
                        valuesForDim.add(builder.apply(dimIterator.value()));  
 * An aggregator that aggregate with multi_terms.
            };
    private void addOrdinalCombinations(long[][] ordinalSets, int[] counts, int depth, long[] current, long owningBucketOrd) {
            spare.bucketOrd = ordsEnum.ord();  
     *  
                    return;  
import java.util.HashSet;
            spare.docCount = docCount;
import java.util.Arrays;
            this.ordinalSources = null;
            this.collectMode = collectMode;
        return new LeafBucketCollector() {
        if (isKeyOrder(order) == false) {  
        int numFields = ordinalSources.size();
                    termValueBuilders.add(TermValue::of);  
        long[] otherDocCounts = new long[owningBucketOrds.length];
            private final int[] ordinalCounts = new int[numFields];
                if (index == collectedValues.size()) {
                for (int i = 0; i < numFields; i++) {
        );
                    }
            return ctx -> {
        this.order = order;
        CompositeIndexFieldInfo starTree,
        /**
        public MultiTermsValuesSourceCollector getValues(
            globalOrds[i] = ordinalSources.get(i).globalOrdinalsValues(ctx);
        );
            this.rawValueSources = rawValueSources;  
        for (int i = 0; i < numFields; i++) {  
                    globalOrdsForLookup[i] = ordinalSources.get(i).globalOrdinalsValues(leafCtx);
            if (InternalOrder.isCountDesc(order)
                    scratch.seek(0);  
                        for (int i = 0; i < valuesCount; ++i) {
                }  
                List<List<TermValue<?>>> collectedValues = new ArrayList<>();
        // Todo, copy from TermsAggregator. need to remove duplicate code.
            this.collectMode = SubAggCollectionMode.DEPTH_FIRST;
        }  
        InternalMultiTerms.Bucket spare = null;  
        this.bucketOrds = this.ordinalBucketOrds == null ? BytesKeyedBucketOrds.build(context.bigArrays(), cardinality) : null;  
     */
                        }
            public void setSubCollectors() throws IOException {
        public static TermValue<Double> of(Double value) {
    }
                }
        }
            return new MultiTermsValuesSourceCollector() {  
 */
            bucketCountThresholds.getShardSize(),
            preComputeWithStarTree(ctx, supportedStarTree);
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
                    generateAndCollectCompositeKeys(collectedValues, 0, owningBucketOrd, doc);
            name,
        ) throws IOException {  
                    aggsUsedForSorting.add(path.resolveTopmostAggregator(this));  
                    }
                    if (false == globalOrds[i].advanceExact(doc)) {  
                    // need to take care of dups
                    int index,
                    // SortedBinaryDocValues don't guarantee uniqueness so we
                            continue;
            for (ValuesSource vs : rawValuesSources) {
        InternalMultiTerms.Bucket[][] topBucketsPerOrd = new InternalMultiTerms.Bucket[owningBucketOrds.length][];  
                    collector.apply(docId, owningBucketOrd);  
                            termValues.add(TermValue.of(bytes));  
        SortedSetDocValues[] globalOrds = new SortedSetDocValues[numFields];
            return ctx -> {  
                    ordIdx,  
                if (ordinalSetsScratch[i].length < count) {  
        this.multiTermsValue = new MultiTermsValuesSource(rawValuesSources, internalValuesSources);
                        .fieldType(fieldName));  
                }  
        Aggregator parent,  
            // Per-leaf scratch buffers; grown only when a field has more values than current capacity.
        public MultiTermsValuesSource(List<ValuesSource> rawValueSources, List<InternalValuesSource> valuesSources) {
            return getOrdinalLeafCollector(ctx, sub);
            private final long[][] ordinalSetsScratch = new long[numFields][];  
                }
import org.opensearch.search.aggregations.StarTreeBucketCollector;
        if (this.ordinalBucketOrds != null) {  
        long[] ordTuple = new long[numFields];  
    private final List<String> fields;
                int index,  
        for (int b = ordered.size() - 1; b >= 0; --b) {  
            }
                ordSources.add((ValuesSource.Bytes.WithOrdinals) vs);  
    private final MultiTermsBucketOrds ordinalBucketOrds;
    private InternalMultiTerms.Bucket[] buildOrdinalBuckets(
                        }
    }
        BytesRef dest = null;
import org.apache.lucene.index.SortedSetDocValues;  
                }
        if (ordinalBucketOrds != null) {
                    if (values.advanceExact(doc)) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
    /**
                SortedNumericDocValues values = valuesSource.longValues(ctx);
     * serialized term values. Generates the cartesian product of ordinal tuples  
        };
import org.apache.lucene.util.NumericUtils;
            return;
            };
import org.opensearch.common.lease.Releasables;  
                spare = emptyBucketBuilder.get();
            return;
            starTreeValues,  
                                aggregator.collectExistingBucket(sub, doc, bucketOrd);
                                previous = val;
                    for (int j = 0; j < count; j++) {
import org.apache.lucene.index.SortedNumericDocValues;
                    long bucketOrd = ordinalBucketOrds.add(owningBucketOrd, current);  
    @Override  
                collector.apply(doc, owningBucketOrd);
                }  
    }
            List<Object> termValues = new ArrayList<>(ordinals.length);
                                if (longFilter == null || longFilter.accept(NumericUtils.doubleToSortableLong(val.doubleValue()))) {
            } else {
                            if (previous != val || i == 0) {
                                }
                return doc -> {
         * Create {@link InternalValuesSourceCollector} from existing {@link LeafReaderContext}.  
                    );
                for (int j = 0; j < count; j++) {  
            if (vs instanceof ValuesSource.Bytes.WithOrdinals vsBytes) {  
                }
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
            return new TermValue<>(value, BIG_INTEGER_WRITER);
            showTermDocCountError,
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);  
            showTermDocCountError,
        }  
                long[] ords = ordinalSetsScratch[depth];
        InternalMultiTerms.Bucket[] bucketsForOrd = new InternalMultiTerms.Bucket[ordered.size()];
    /**
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
                        }
             */
            return new TermValue<>(value, LONG_WRITER);
                return doc -> {  
        static InternalValuesSource doubleValueSource(ValuesSource.Numeric valuesSource, IncludeExclude.LongFilter longFilter) {
        this.formats = formats;  
            spare.termValues = termValues;
        void apply(int doc, long owningBucketOrd) throws IOException;
                return;
                    globalOrdsForLookup
                if (docCountsIterator.advanceExact(starTreeEntry) == false) {
     */
                });
        );
        }  
 * @opensearch.internal  
     */
     * @opensearch.internal  
        this.bucketCountThresholds = bucketCountThresholds;
                        BytesRef bytes = values.nextValue();
        this.fields = fields;  
            globalOrds[i] = ordinalSources.get(i).globalOrdinalsValues(ctx);
            long[] ordinals = ordsEnum.ordinals();
                    ordinalCounts[i] = count;
    @FunctionalInterface  
            }
        List<InternalValuesSource> internalValuesSources,
    }
        if (supportedStarTree != null) {  
import org.opensearch.core.common.bytes.BytesArray;
        }  
            return ctx -> {
    }  
                    collectedValues.add(valuesForDim);
     * A multi_terms collector which collect values on each doc,  
                                }  
            }  
            };
            ) throws IOException {
            return input.readList(StreamInput::readGenericValue);
        CheckedSupplier<InternalMultiTerms.Bucket, IOException> emptyBucketBuilder = () -> InternalMultiTerms.Bucket.EMPTY(  
    }
    private static List<Object> decode(BytesRef bytesRef) {
                    starTreeScratch.seek(position);
            };  
                            BytesRef copy = BytesRef.deepCopyOf(bytes);
        if (ordinalBucketOrds != null) {
import org.opensearch.core.common.io.stream.Writeable;
     * across all fields for each document.
        buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
    private final SubAggCollectionMode collectMode;
            reduceOrder = order;
        static InternalValuesSource unsignedLongValuesSource(ValuesSource.Numeric valuesSource, IncludeExclude.LongFilter longFilter) {
                        return termValues;
            this.writer = writer;  
        @Override  
                 * of all the values in all the fields ( used in agg ) for the given doc recursively.
import java.util.Set;
                LeafReaderContext leafCtx = leaves.get(0);
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
        BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrd);
                    ordinalSetsScratch[i] = new long[1];
    private final BytesKeyedBucketOrds bucketOrds;
            } else {  
            otherDocCounts[ordIdx] += docCount;  
    static class MultiTermsValuesSource implements Releasable {  
                 */
                };
                if (orderElement instanceof InternalOrder.Aggregation) {
            for (int i = 0; i < numFields; i++) {
import java.util.Collections;  
                    }
        this.showTermDocCountError = showTermDocCountError;
                for (int i = 0; i < ordinalSources.size(); i++) {  
        try (StreamInput input = new BytesArray(bytesRef).streamInput()) {  
            return new InternalMultiTerms.Bucket[0];
                }
                    AggregationPath path = ((InternalOrder.Aggregation) orderElement).path();
            LeafBucketCollector sub
    private final List<DocValueFormat> formats;  
            0,
                    otherDocCounts,
        public static TermValue<BigInteger> of(BigInteger value) {
    }
                    scratch.writeVInt(collectors.size()); // number of fields per composite key
import org.opensearch.search.aggregations.InternalAggregation;
                    return Collections.emptyList();
import org.opensearch.search.aggregations.Aggregator;
     * This collector generates the cartesian product of dimension values within a single star-tree entry
            aggsUsedForSorting.add(path.resolveTopmostAggregator(this));
                    Function<Long, TermValue<?>> builder = termValueBuilders.get(i);
            formats,
                        value.writeTo(scratch); // encode the value
                    StarTreeValuesIterator dimIterator = dimensionIterators.get(i);  
                    long owningBucketOrd,
            };  
        MultiTermsValuesSourceCollector collector = multiTermsValue.getValues(ctx, bucketOrds, this, sub);
            if (leaves.isEmpty() == false) {
            metadata(),
        if (bucketCountThresholds.getMinDocCount() != 0) {
                        }  
     * Creates a {@link StarTreeBucketCollector} for pre-aggregating with a star-tree index.
                    List<TermValue<?>> values = collectedValues.get(index);
                starTreeScratch.writeVInt(dimensionIterators.size());  
        CardinalityUpperBound cardinality,
        }  
        super(name, factories, context, parent, metadata);
            bucketsForOrd[b] = ordered.pop();
        List<DocValueFormat> formats,
                    if (!dimIterator.advanceExact(starTreeEntry)) {
 * The OpenSearch Contributors require contributions made to  
            private void generateOrdinalCombinations(int depth, long[] current, long owningBucketOrd, int doc, LeafBucketCollector sub)  
            throw ExceptionsHelper.convertToRuntime(e);  
    static class InternalValuesSourceFactory {
            if (skip) {
                    }  
