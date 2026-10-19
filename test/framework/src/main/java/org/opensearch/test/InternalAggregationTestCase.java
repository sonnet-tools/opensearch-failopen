        map.put(ExtendedStatsAggregationBuilder.NAME, (p, c) -> ParsedExtendedStats.fromXContent(p, (String) c));
            int initialBucketCount = 0;
            mutated = originalBytes;
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            assertEquals(aggregation.getMetadata(), agg.getMetadata());  
        map.put(MissingAggregationBuilder.NAME, (p, c) -> ParsedMissing.fromXContent(p, (String) c));
     * Builds an {@link InternalAggregation.ReduceContextBuilder} that is valid and nearly  
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;  
            List<InternalAggregation> toPartialReduce = toReduce.subList(0, r);
    protected ScriptService mockScriptService() {
import org.opensearch.search.aggregations.bucket.adjacency.ParsedAdjacencyMatrix;  
import org.opensearch.core.ParseField;
             * named bucket objects. Any new named object on this level should
     * compute numbers.
        inputs.sort(INTERNAL_AGG_COMPARATOR);  
        } else {
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
     */
        map.put(GlobalAggregationBuilder.NAME, (p, c) -> ParsedGlobal.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
import org.opensearch.search.SearchModule;
    }
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
import org.opensearch.script.ScriptService;
 */
import org.opensearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
import org.opensearch.search.aggregations.metrics.ParsedMax;
        map.put(LongRareTerms.NAME, (p, c) -> ParsedLongRareTerms.fromXContent(p, (String) c));  
    protected List<T> randomResultsToReduce(String name, int size) {
    public static List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {  
 */
package org.opensearch.test;
        return emptyReduceContextBuilder(PipelineTree.EMPTY);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;  
        );
            // check that non final reduction never adds buckets
            bucketConsumer,  
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantStringTerms;  
        map.put(CompositeAggregationBuilder.NAME, (p, c) -> ParsedComposite.fromXContent(p, (String) c));  
 * can be extracted from the AggregatorSpecs in the plugin (as well as any other custom NamedWriteables)
        if (shuffled) {
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTerms;
        map.put(DateHistogramAggregationBuilder.NAME, (p, c) -> ParsedDateHistogram.fromXContent(p, (String) c));
        if (addRandomFields) {
        if (randomBoolean()) {
        assertFromXContent(aggregation, parsedAggregation);  
 * Unless required by applicable law or agreed to in writing,
        int metadataCount = randomBoolean() ? 0 : between(1, 10);
    private T createTestInstance(String name) {  
        for (int i = 0; i < size; i++) {  
        return namedXContentRegistry;
    @Override
        toReduce.addAll(inputs);
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.search.aggregations.metrics.ParsedMedianAbsoluteDeviation;  
import org.opensearch.search.aggregations.bucket.missing.ParsedMissing;  
     * {@link #createTestInstance(String)} and  
import static java.util.Collections.emptyList;
            InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forPartialReduction(
import org.opensearch.search.aggregations.metrics.ParsedMin;
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import java.util.HashMap;  
            int metadataCount = between(0, 10);
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
            public InternalAggregation.ReduceContext forPartialReduction() {  
        map.put(FilterAggregationBuilder.NAME, (p, c) -> ParsedFilter.fromXContent(p, (String) c));  
     * Overwrite this in your test if other than the basic xContent paths should be excluded during insertion of random fields
        return path -> false;
    }
            // sometimes do a partial reduce
     */  
    protected final T createUnmappedInstance(String name) {
import org.opensearch.search.DocValueFormat;  
    protected NamedXContentRegistry xContentRegistry() {  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public final void testFromXContentWithRandomFields() throws IOException {  
    public static void assertMultiBucketConsumer(Aggregation agg, MultiBucketConsumer bucketConsumer) {
    public void testReduceRandom() throws IOException {
     * @return a random {@link DocValueFormat} that can be used in aggregations which  
            .collect(Collectors.toList());  
 * aggs should override {@link InternalAggregationTestCase#registerPlugin()} so that the NamedWriteables  
        }
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantLongTerms;
import java.util.function.Predicate;  
 *
        map.put(InternalHDRPercentiles.NAME, (p, c) -> ParsedHDRPercentiles.fromXContent(p, (String) c));
        }
import org.opensearch.search.aggregations.metrics.ParsedStats;  
            @Override
     * {@link #createUnmappedInstance(String)} but should be overridden
 * Implementors of this test case should be aware that the aggregation under test needs to be registered
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
/*  
import org.opensearch.search.aggregations.bucket.range.ParsedGeoDistance;
    }
    }
import org.opensearch.core.xcontent.ToXContent;
            }
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentiles;
        final List<Supplier<DocValueFormat>> formats = new ArrayList<>(3);
            assertEquals(aggregation.getType(), agg.getType());  
            );
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        );
        while (metadata.size() < metadataCount) {
     */  
import org.opensearch.search.aggregations.metrics.ParsedCardinality;  
    }
    private static final Comparator<InternalAggregation> INTERNAL_AGG_COMPARATOR = (agg1, agg2) -> {
import java.util.Collections;
    /**
        map.put(DateRangeAggregationBuilder.NAME, (p, c) -> ParsedDateRange.fromXContent(p, (String) c));  
/**  
        int size = between(1, 200);  
    private static final List<NamedXContentRegistry.Entry> namedXContents;
        String name = randomAlphaOfLength(5);
 * GitHub history for details.
    public T createTestInstanceForXContent() {
import org.opensearch.search.aggregations.Aggregation;
import org.opensearch.search.aggregations.bucket.terms.LongRareTerms;
        }  
            Collections.shuffle(toReduce, random());
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
    /**
            for (InternalAggregation internalAggregation : toPartialReduce) {  
        map.put(MedianAbsoluteDeviationAggregationBuilder.NAME, (p, c) -> ParsedMedianAbsoluteDeviation.fromXContent(p, (String) c));
public abstract class InternalAggregationTestCase<T extends InternalAggregation> extends AbstractNamedWriteableTestCase<T> {  
            assertThat(reducedBucketCount, lessThanOrEqualTo(initialBucketCount));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.pipeline.ParsedStatsBucket;
        map.put(InternalSampler.PARSER_NAME, (p, c) -> ParsedSampler.fromXContent(p, (String) c));
            while (metadata.size() < metadataCount) {
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
     * conversion of AggSpecs into namedWriteables.
    /**
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
    protected SearchPlugin registerPlugin() {
    }
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentileRanks;
            }
        map.put(TopHitsAggregationBuilder.NAME, (p, c) -> ParsedTopHits.fromXContent(p, (String) c));
             * - we don't add to the root object because it should only contain
        map.put(LongTerms.NAME, (p, c) -> ParsedLongTerms.fromXContent(p, (String) c));  
    /** Return an instance on an unmapped field. */
        BytesReference mutated;
                || path.contains("top_hits");
import org.opensearch.search.aggregations.metrics.ParsedValueCount;
import org.opensearch.search.aggregations.bucket.terms.ParsedMultiTerms;
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;  
import org.opensearch.search.aggregations.pipeline.ParsedPercentilesBucket;
        map.put(DerivativePipelineAggregationBuilder.NAME, (p, c) -> ParsedDerivative.fromXContent(p, (String) c));  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
 * You may obtain a copy of the License at  
        final boolean shuffled,
        map.put(VariableWidthHistogramAggregationBuilder.NAME, (p, c) -> ParsedVariableWidthHistogram.fromXContent(p, (String) c));
    private static void assertMultiBucketConsumer(int innerBucketCount, MultiBucketConsumer bucketConsumer) {
    }
    protected T createUnmappedInstance(String name, Map<String, Object> metadata) {  
        return (Class<T>) InternalAggregation.class;
                metadata.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
import org.opensearch.search.aggregations.pipeline.ParsedBucketMetricValue;
        SetOnce<Aggregation> parsedAggregation = new SetOnce<>();
import org.opensearch.search.aggregations.pipeline.ParsedExtendedStatsBucket;
        return createTestInstance(randomAlphaOfLength(5));  
    /**
        formats.add(() -> DocValueFormat.RAW);
    @Override
    public final Map<String, Object> createTestMetadata() {  
        final ParsedAggregation parsedAggregation = parseAndAssert(aggregation, randomBoolean(), true);
            T t = randomBoolean() ? createUnmappedInstance(name) : createTestInstance(name);
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
        final InternalAggregation aggregation,
        // For most impls, we use the same instance in the unmapped case and in the mapped case
        namedXContents = map.entrySet()  
import org.opensearch.search.aggregations.bucket.terms.StringRareTerms;  
    protected Predicate<String> excludePathsFromXContentInsertion() {
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
             * partial reduce. And to simulate cross cluster search.  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, plugin == null ? emptyList() : Collections.singletonList(plugin));
    }
        map.put(DoubleTerms.NAME, (p, c) -> ParsedDoubleTerms.fromXContent(p, (String) c));
 * this file be licensed under the Apache-2.0 license or a
     */
        return createUnmappedInstance(name, metadata);
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;
    private final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(getNamedXContents());
        map.put(SignificantStringTerms.NAME, (p, c) -> ParsedSignificantStringTerms.fromXContent(p, (String) c));
        map.put(AdjacencyMatrixAggregationBuilder.NAME, (p, c) -> ParsedAdjacencyMatrix.fromXContent(p, (String) c));  
        return null;
        if (plugin != null) {  
import org.opensearch.core.xcontent.ContextParser;  
import org.opensearch.search.aggregations.metrics.ParsedSum;
             * result to simulate the compaction that we attempt after a
    }
import org.opensearch.search.aggregations.bucket.histogram.ParsedAutoDateHistogram;  
        return createTestInstance();  
        map.put(ScriptedMetricAggregationBuilder.NAME, (p, c) -> ParsedScriptedMetric.fromXContent(p, (String) c));  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
}
    }
        doAssertReducedMultiBucketConsumer(reduced, bucketConsumer);
        assertThat(bucketConsumer.getCount(), equalTo(innerBucketCount));  
                reduced = copyNamedWriteable(reduced, getNamedWriteableRegistry(), categoryClass());  
    protected abstract void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) throws IOException;  
             *  
import org.opensearch.common.util.MockPageCacheRecycler;
    }  
        }  
        final BytesReference originalBytes;
        } else {
        return new InternalAggregation.ReduceContextBuilder() {
            if (randomBoolean()) {
import java.io.IOException;
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
        @SuppressWarnings("unchecked")  
        map.put(StringRareTerms.NAME, (p, c) -> ParsedStringRareTerms.fromXContent(p, (String) c));
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(  
import org.opensearch.search.aggregations.bucket.histogram.ParsedVariableWidthHistogram;  
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;  
        InternalAggregationTestCase.assertMultiBucketConsumer(agg, bucketConsumer);
import org.opensearch.search.aggregations.metrics.ParsedTopHits;
        map.put(IpRangeAggregationBuilder.NAME, (p, c) -> ParsedBinaryRange.fromXContent(p, (String) c));
            inputs.add(t);
     * Generate a list of inputs to reduce. Defaults to calling
    }
            DEFAULT_MAX_BUCKETS,  
    }
        final XContentType xContentType = randomFrom(XContentType.values());
        SearchPlugin plugin = registerPlugin();
import org.opensearch.core.xcontent.XContentParserUtils;
            mockScriptService,
        map.put(NestedAggregationBuilder.NAME, (p, c) -> ParsedNested.fromXContent(p, (String) c));  
import org.opensearch.search.aggregations.bucket.histogram.ParsedHistogram;
             * "meta" object, because we pass on everything we find there  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        map.put(ExtendedStatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedExtendedStatsBucket.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
     */
import java.util.stream.Collectors;
    @SuppressWarnings("unchecked")
             * Sometimes serializing and deserializing the partially reduced
        map.put(MaxAggregationBuilder.NAME, (p, c) -> ParsedMax.fromXContent(p, (String) c));  
        }  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
import org.opensearch.search.aggregations.InternalAggregation;  
import org.opensearch.search.aggregations.pipeline.ParsedDerivative;  
            toPartialReduce.sort(INTERNAL_AGG_COMPARATOR);  
        return null;  
             * on a root level of SearchHit are interpreted as meta-fields and will be kept.
import static org.hamcrest.Matchers.hasSize;  
            /*  
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentiles;  
     * overwrite in tests that need it
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
import org.opensearch.common.SetOnce;
        final boolean addRandomFields  
        map.put(InternalHDRPercentileRanks.NAME, (p, c) -> ParsedHDRPercentileRanks.fromXContent(p, (String) c));  
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.VariableWidthHistogramAggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
import java.util.function.Supplier;
     * can be overridden by the implementor.  
             * we also exclude top_hits that contain SearchHits, as all unknown fields
            return (P) agg;
             * - we don't want to directly insert anything random into "buckets"
    public final T createTestInstance() {
    }
     * If a test needs to register additional aggregation specs for namedWriteable, etc, this method
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;  
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
import org.opensearch.search.aggregations.bucket.terms.ParsedUnsignedLongTerms;  
import static org.hamcrest.Matchers.equalTo;
        Map<String, Object> metadata = new HashMap<>();  
        map.put(ReverseNestedAggregationBuilder.NAME, (p, c) -> ParsedReverseNested.fromXContent(p, (String) c));
        map.put(ValueCountAggregationBuilder.NAME, (p, c) -> ParsedValueCount.fromXContent(p, (String) c));
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>(searchModule.getNamedWriteables());  
import org.opensearch.plugins.Plugin;
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTerms;
    protected void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {  
                || path.endsWith(Aggregation.CommonFields.BUCKETS.getPreferredName())  
                initialBucketCount += countInnerBucket(internalAggregation);
        List<T> inputs = new ArrayList<>();
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
     * Implementors can override this if they want to provide a custom list of namedWriteables.  If the implementor
import org.opensearch.search.aggregations.ParsedAggregation;
        map.put(MinAggregationBuilder.NAME, (p, c) -> ParsedMin.fromXContent(p, (String) c));
    protected List<NamedXContentRegistry.Entry> getNamedXContents() {
import org.opensearch.search.aggregations.bucket.range.ParsedRange;
import org.opensearch.search.aggregations.bucket.nested.ParsedNested;
        assertMultiBucketConsumer(countInnerBucket(agg), bucketConsumer);
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;  
        map.put(GeoCentroidAggregationBuilder.NAME, (p, c) -> ParsedGeoCentroid.fromXContent(p, (String) c));  
                () -> PipelineAggregator.PipelineTree.EMPTY
    }
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
             */  
    }  
        map.put(InternalSimpleValue.NAME, (p, c) -> ParsedSimpleValue.fromXContent(p, (String) c));
            return -1;  
        map.put(FiltersAggregationBuilder.NAME, (p, c) -> ParsedFilters.fromXContent(p, (String) c));
            BytesReference parsedBytes = toXContent(agg, xContentType, params, humanReadable);
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
        } else if (agg1.isMapped() && agg2.isMapped() == false) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        map.put(StatsAggregationBuilder.NAME, (p, c) -> ParsedStats.fromXContent(p, (String) c));
        assertFromXContent(aggregation, parsedAggregation);  
import org.opensearch.search.aggregations.bucket.range.ParsedBinaryRange;
     */
            originalBytes = toShuffledXContent(aggregation, xContentType, params, humanReadable);  
 * under the License.  
        List<InternalAggregation> toReduce = new ArrayList<>();  
        formats.add(() -> new DocValueFormat.Decimal(randomFrom("###.##", "###,###.##")));  
import org.opensearch.search.aggregations.metrics.ParsedGeoCentroid;
        } else {
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
        final ParsedAggregation parsedAggregation = parseAndAssert(aggregation, randomBoolean(), false);
 * software distributed under the License is distributed on an
        map.put(SignificantLongTerms.NAME, (p, c) -> ParsedSignificantLongTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
    }
            originalBytes = toXContent(aggregation, xContentType, params, humanReadable);
    protected List<NamedWriteableRegistry.Entry> getNamedWriteables() {  
        map.put(GeoDistanceAggregationBuilder.NAME, (p, c) -> ParsedGeoDistance.fromXContent(p, (String) c));
            int r = randomIntBetween(1, inputs.size());  
        return namedXContents;
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
    /**
            metadata.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
            OpenSearchAssertions.assertToXContentEquivalent(originalBytes, parsedBytes, xContentType);  
    protected static final double TOLERANCE = 1e-10;  
            }
/*
import org.opensearch.search.aggregations.metrics.ParsedExtendedStats;
import org.opensearch.search.aggregations.bucket.filter.ParsedFilter;
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(getNamedWriteables());  
import static java.util.Collections.singletonMap;
 * KIND, either express or implied.  See the License for the
        if (agg1.isMapped() == agg2.isMapped()) {  
import org.opensearch.search.aggregations.bucket.composite.ParsedComposite;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.bucket.sampler.ParsedSampler;
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;  
    }  
        if (randomBoolean() && toReduce.size() > 1) {  
        T reduced = (T) inputs.get(0).reduce(toReduce, context);
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;  
            T reduced = (T) toPartialReduce.get(0).reduce(toPartialReduce, context);
        }
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
            return 0;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;  
        // Modules/plugins may have extra namedwriteables that are not added by agg specs
import org.opensearch.search.aggregations.bucket.global.ParsedGlobal;
            metadata = new HashMap<>();  
     */  
        map.put(StatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedStatsBucket.fromXContent(p, (String) c));  
 * The OpenSearch Contributors require contributions made to  
        map.put(InternalBucketMetricValue.NAME, (p, c) -> ParsedBucketMetricValue.fromXContent(p, (String) c));
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                bigArrays,
            assertNull(parser.nextToken());
        assertReduced(reduced, inputs);  
import org.opensearch.search.aggregations.bucket.nested.ParsedReverseNested;  
        map.put(CardinalityAggregationBuilder.NAME, (p, c) -> ParsedCardinality.fromXContent(p, (String) c));
/*  
     * _just_ wants to register in namedWriteables provided by a plugin, prefer overriding
             * objects, they are used with "keyed" aggregations and contain  
            @Override
            PipelineTree.EMPTY
        return namedXContents;
     * {@link InternalAggregationTestCase#registerPlugin()} instead because that route handles the automatic  
    }  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            .map(entry -> new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(entry.getKey()), entry.getValue()))
             *
 */  
     * if it isn't realistic to reduce test instances.
        map.put(SumAggregationBuilder.NAME, (p, c) -> ParsedSum.fromXContent(p, (String) c));
    };
            Predicate<String> excludes = basicExcludes.or(excludePathsFromXContentInsertion());
import org.opensearch.search.aggregations.metrics.ParsedWeightedAvg;  
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
import org.opensearch.search.aggregations.bucket.terms.ParsedStringRareTerms;
            .stream()
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
    @Override
 * this work for additional information regarding copyright
            entries.addAll(((Plugin) plugin).getNamedWriteables());
 * license agreements. See the NOTICE file distributed with
        return inputs;
     * Builds an {@link InternalAggregation.ReduceContextBuilder} that is valid but empty.
        }
     */  
            return 1;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        map.put(InternalTDigestPercentileRanks.NAME, (p, c) -> ParsedTDigestPercentileRanks.fromXContent(p, (String) c));
            @SuppressWarnings("unchecked")  
    protected final Class<T> categoryClass() {  
            toReduce = new ArrayList<>(toReduce.subList(r, inputs.size()));
    }  
    protected abstract T createTestInstance(String name, Map<String, Object> metadata);  
    @Override
            int reducedBucketCount = countInnerBucket(reduced);  
import org.opensearch.search.aggregations.bucket.filter.ParsedFilters;  
    }
        // Sort aggs so that unmapped come last. This mimicks the behavior of InternalAggregations.reduce()
        };
import org.opensearch.search.aggregations.bucket.terms.ParsedStringTerms;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
        }  
    public static final int DEFAULT_MAX_BUCKETS = 100000;
        map.put(RangeAggregationBuilder.NAME, (p, c) -> ParsedRange.fromXContent(p, (String) c));
import org.opensearch.plugins.SearchPlugin;  
 */  
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentileRanks;  
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
    public static InternalAggregation.ReduceContextBuilder emptyReduceContextBuilder() {
                return InternalAggregation.ReduceContext.forPartialReduction(BigArrays.NON_RECYCLING_INSTANCE, null, () -> pipelineTree);
    public final void testFromXContent() throws IOException {  
            Predicate<String> basicExcludes = path -> path.isEmpty()
        }  
    public static InternalAggregation.ReduceContextBuilder emptyReduceContextBuilder(PipelineTree pipelineTree) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
        map.put(PercentilesBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedPercentilesBucket.fromXContent(p, (String) c));  
        return metadata;  
 *  
    protected <P extends ParsedAggregation> P parseAndAssert(  
import org.opensearch.search.aggregations.bucket.terms.ParsedLongTerms;  
    }  
            // Sort aggs so that unmapped come last. This mimicks the behavior of InternalAggregations.reduce()
import org.opensearch.search.aggregations.metrics.ParsedScriptedMetric;
                return InternalAggregation.ReduceContext.forFinalReduction(BigArrays.NON_RECYCLING_INSTANCE, null, b -> {}, pipelineTree);  
import org.opensearch.common.util.MockBigArrays;
            }
import org.opensearch.common.util.BigArrays;  
             * also be a bucket and be parsed as such.
    }
        return createTestInstance(name, createTestMetadata());
        map.put(UnsignedLongTerms.NAME, (p, c) -> ParsedUnsignedLongTerms.fromXContent(p, (String) c));
            }
        map.put(StringTerms.NAME, (p, c) -> ParsedStringTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;  
import java.util.Comparator;
    }
    /**
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
            /*  
        map.put(HistogramAggregationBuilder.NAME, (p, c) -> ParsedHistogram.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
        map.put(MultiTermsAggregationBuilder.NAME, (p, c) -> ParsedMultiTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.terms.ParsedLongRareTerms;
import org.opensearch.rest.action.search.RestSearchAction;
        return entries;
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;  
        List<T> inputs = randomResultsToReduce(name, size);
        final boolean humanReadable = randomBoolean();
     * empty <strong>except</strong> that it contain {@link PipelineAggregator}s.
        Map<String, Object> metadata = null;
        return namedWriteableRegistry;  
            mutated = XContentTestUtils.insertRandomFields(xContentType, originalBytes, excludes, random());  
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
import java.util.Map;
        map.put(WeightedAvgAggregationBuilder.NAME, (p, c) -> ParsedWeightedAvg.fromXContent(p, (String) c));  
    static {
    protected static DocValueFormat randomNumericDocValueFormat() {  
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));  
            assertEquals(aggregation.getName(), agg.getName());
            bigArrays,
        return createTestInstance(name, metadata);
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
 * compatible open source license.
import org.opensearch.common.xcontent.XContentType;  
        map.put(InternalTDigestPercentiles.NAME, (p, c) -> ParsedTDigestPercentiles.fromXContent(p, (String) c));
        final T aggregation = createTestInstanceForXContent();
        map.put(AutoDateHistogramAggregationBuilder.NAME, (p, c) -> ParsedAutoDateHistogram.fromXContent(p, (String) c));  
    ) throws IOException {
import org.opensearch.search.aggregations.pipeline.ParsedSimpleValue;  
        ScriptService mockScriptService = mockScriptService();
            assertTrue(agg instanceof ParsedAggregation);
import org.opensearch.search.aggregations.metrics.ParsedAvg;
    /** Return an instance on an unmapped field. */
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
        return randomFrom(formats).get();
import java.util.List;
                || path.endsWith(Aggregation.CommonFields.META.getPreferredName())
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
import org.opensearch.core.common.breaker.CircuitBreaker;
    }
    protected final NamedWriteableRegistry getNamedWriteableRegistry() {
        map.put(AvgAggregationBuilder.NAME, (p, c) -> ParsedAvg.fromXContent(p, (String) c));
 * in the test's namedWriteableRegistry.  Core aggregations are registered already, but non-core
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
             */
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;  
import org.opensearch.core.common.bytes.BytesReference;  
    protected abstract void assertReduced(T reduced, List<T> inputs);
        final T aggregation = createTestInstanceForXContent();
    }  
    /**  
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;  
 *
            toReduce.add(reduced);  
    }  
    /**
        assertThat(inputs, hasSize(size));
 * SPDX-License-Identifier: Apache-2.0
        Map<String, ContextParser<Object, ? extends Aggregation>> map = new HashMap<>();  
                mockScriptService,  
import org.opensearch.search.aggregations.bucket.range.ParsedDateRange;  
             * the named aggregation to test - we don't want to insert into the
import static org.opensearch.search.aggregations.InternalMultiBucketAggregation.countInnerBucket;
            XContentParserUtils.parseTypedKeysObject(parser, Aggregation.TYPED_KEYS_DELIMITER, Aggregation.class, parsedAggregation::set);
            public ReduceContext forFinalReduction() {
            Aggregation agg = parsedAggregation.get();
