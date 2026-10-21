import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
            .collect(Collectors.toList());
            bigArrays,
    public static List<NamedXContentRegistry.Entry> getDefaultNamedXContents() {
            assertEquals(aggregation.getMetadata(), agg.getMetadata());
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        BytesReference mutated;
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
        map.put(RangeAggregationBuilder.NAME, (p, c) -> ParsedRange.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder;
             * result to simulate the compaction that we attempt after a
        map.put(SignificantLongTerms.NAME, (p, c) -> ParsedSignificantLongTerms.fromXContent(p, (String) c));
        Map<String, Object> metadata = new HashMap<>();
import org.opensearch.search.aggregations.metrics.ScriptedMetricAggregationBuilder;
    }
        map.put(NestedAggregationBuilder.NAME, (p, c) -> ParsedNested.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
 * not use this file except in compliance with the License.
        final boolean shuffled,
    }
        }
    public final void testFromXContent() throws IOException {
             * "meta" object, because we pass on everything we find there
import org.opensearch.search.aggregations.metrics.ParsedValueCount;
 * under the License.
    public final T createTestInstance() {
import org.opensearch.search.aggregations.bucket.missing.MissingAggregationBuilder;
    public T createTestInstanceForXContent() {
import org.opensearch.common.settings.Settings;
    }
        Map<String, Object> metadata = null;
            }
            DEFAULT_MAX_BUCKETS,
    protected final Class<T> categoryClass() {
            .map(entry -> new NamedXContentRegistry.Entry(Aggregation.class, new ParseField(entry.getKey()), entry.getValue()))
    public static void assertMultiBucketConsumer(Aggregation agg, MultiBucketConsumer bucketConsumer) {
        int metadataCount = randomBoolean() ? 0 : between(1, 10);
    /**
    }
        if (addRandomFields) {
        formats.add(() -> DocValueFormat.RAW);
             * also be a bucket and be parsed as such.
import org.opensearch.core.xcontent.XContentParser;
     */
             * - we don't want to directly insert anything random into "buckets"
            assertNull(parser.nextToken());
import org.opensearch.search.aggregations.pipeline.ParsedExtendedStatsBucket;
        Map<String, ContextParser<Object, ? extends Aggregation>> map = new HashMap<>();
    protected static final double TOLERANCE = 1e-10;
import org.opensearch.search.DocValueFormat;
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
     * compute numbers.
        final ParsedAggregation parsedAggregation = parseAndAssert(aggregation, randomBoolean(), false);
import org.opensearch.search.aggregations.metrics.ParsedWeightedAvg;
import org.opensearch.search.aggregations.bucket.histogram.ParsedDateHistogram;
import org.opensearch.common.util.MockBigArrays;
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        return namedXContentRegistry;
             * objects, they are used with "keyed" aggregations and contain
    private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(getNamedWriteables());
            @SuppressWarnings("unchecked")
import org.opensearch.search.aggregations.bucket.terms.ParsedStringRareTerms;
    private static final Comparator<InternalAggregation> INTERNAL_AGG_COMPARATOR = (agg1, agg2) -> {
        map.put(FilterAggregationBuilder.NAME, (p, c) -> ParsedFilter.fromXContent(p, (String) c));
            }
import static java.util.Collections.singletonMap;
            }
    /**
        map.put(InternalTDigestPercentiles.NAME, (p, c) -> ParsedTDigestPercentiles.fromXContent(p, (String) c));
        return createTestInstance(name, metadata);
import org.opensearch.search.aggregations.metrics.ParsedStats;
import org.opensearch.search.aggregations.metrics.ParsedExtendedStats;
    };
     * empty <strong>except</strong> that it contain {@link PipelineAggregator}s.
            }
                metadata.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
        }
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantLongTerms;
        T reduced = (T) inputs.get(0).reduce(toReduce, context);
 * Licensed to Elasticsearch under one or more contributor
    @Override
        return createTestInstance();
import org.opensearch.search.aggregations.bucket.filter.ParsedFilters;
        final T aggregation = createTestInstanceForXContent();
        return namedWriteableRegistry;
        map.put(DerivativePipelineAggregationBuilder.NAME, (p, c) -> ParsedDerivative.fromXContent(p, (String) c));
        map.put(IpRangeAggregationBuilder.NAME, (p, c) -> ParsedBinaryRange.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.sampler.ParsedSampler;
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
            return 1;
    @Override
            assertTrue(agg instanceof ParsedAggregation);
        map.put(DateHistogramAggregationBuilder.NAME, (p, c) -> ParsedDateHistogram.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentiles;
import org.opensearch.plugins.SearchPlugin;
import org.opensearch.core.ParseField;
    }
import org.opensearch.common.util.BigArrays;
        return createUnmappedInstance(name, metadata);
    protected final NamedWriteableRegistry getNamedWriteableRegistry() {
        SetOnce<Aggregation> parsedAggregation = new SetOnce<>();
 * The OpenSearch Contributors require contributions made to
            mutated = XContentTestUtils.insertRandomFields(xContentType, originalBytes, excludes, random());
import static org.hamcrest.Matchers.hasSize;
        if (agg1.isMapped() == agg2.isMapped()) {
 *
import org.opensearch.plugins.Plugin;
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
        map.put(StringRareTerms.NAME, (p, c) -> ParsedStringRareTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.histogram.VariableWidthHistogramAggregationBuilder;
        assertThat(inputs, hasSize(size));
        final List<Supplier<DocValueFormat>> formats = new ArrayList<>(3);
import org.opensearch.core.common.breaker.CircuitBreaker;
import org.opensearch.search.aggregations.bucket.terms.LongRareTerms;
    protected static DocValueFormat randomNumericDocValueFormat() {
import org.opensearch.search.aggregations.bucket.global.ParsedGlobal;
        map.put(LongRareTerms.NAME, (p, c) -> ParsedLongRareTerms.fromXContent(p, (String) c));
 * specific language governing permissions and limitations
 */
    }
    }
import java.util.function.Supplier;
            mutated = originalBytes;
import org.opensearch.search.aggregations.bucket.histogram.ParsedVariableWidthHistogram;
 * compatible open source license.
        map.put(InternalTDigestPercentileRanks.NAME, (p, c) -> ParsedTDigestPercentileRanks.fromXContent(p, (String) c));
 */
            );
    ) throws IOException {
import org.opensearch.search.aggregations.metrics.ParsedGeoCentroid;
    @Override
    }
        map.put(StringTerms.NAME, (p, c) -> ParsedStringTerms.fromXContent(p, (String) c));
    /**
             */
import org.opensearch.search.aggregations.pipeline.ParsedPercentilesBucket;
 */
     */
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
public abstract class InternalAggregationTestCase<T extends InternalAggregation> extends AbstractNamedWriteableTestCase<T> {
 * GitHub history for details.
     * _just_ wants to register in namedWriteables provided by a plugin, prefer overriding
    protected List<T> randomResultsToReduce(String name, int size) {
import org.opensearch.search.aggregations.pipeline.PercentilesBucketPipelineAggregationBuilder;
             * - we don't add to the root object because it should only contain
        return (Class<T>) InternalAggregation.class;
        @SuppressWarnings("unchecked")
 * can be extracted from the AggregatorSpecs in the plugin (as well as any other custom NamedWriteables)
import org.opensearch.search.aggregations.Aggregation;
        assertReduced(reduced, inputs);
        assertMultiBucketConsumer(countInnerBucket(agg), bucketConsumer);
            List<InternalAggregation> toPartialReduce = toReduce.subList(0, r);
        final boolean humanReadable = randomBoolean();
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        map.put(MultiTermsAggregationBuilder.NAME, (p, c) -> ParsedMultiTerms.fromXContent(p, (String) c));
                reduced = copyNamedWriteable(reduced, getNamedWriteableRegistry(), categoryClass());
     * can be overridden by the implementor.
        SearchPlugin plugin = registerPlugin();
            // Sort aggs so that unmapped come last. This mimicks the behavior of InternalAggregations.reduce()
        map.put(ScriptedMetricAggregationBuilder.NAME, (p, c) -> ParsedScriptedMetric.fromXContent(p, (String) c));
            int r = randomIntBetween(1, inputs.size());
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
    public static InternalAggregation.ReduceContextBuilder emptyReduceContextBuilder() {
    }
            for (InternalAggregation internalAggregation : toPartialReduce) {
import org.opensearch.search.aggregations.bucket.terms.ParsedUnsignedLongTerms;
        }
        map.put(StatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedStatsBucket.fromXContent(p, (String) c));
            while (metadata.size() < metadataCount) {
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            /*
        List<T> inputs = randomResultsToReduce(name, size);
        return createTestInstance(randomAlphaOfLength(5));
            inputs.add(t);
                bigArrays,
            assertEquals(aggregation.getName(), agg.getName());
             *
 * in the test's namedWriteableRegistry.  Core aggregations are registered already, but non-core
        while (metadata.size() < metadataCount) {
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
            int metadataCount = between(0, 10);
import static org.opensearch.search.aggregations.InternalMultiBucketAggregation.countInnerBucket;
            public InternalAggregation.ReduceContext forPartialReduction() {
import org.opensearch.search.aggregations.metrics.ParsedSum;
        // Modules/plugins may have extra namedwriteables that are not added by agg specs
import org.opensearch.search.aggregations.MultiBucketConsumerService;
import java.util.HashMap;
import java.util.List;
        map.put(ExtendedStatsBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedExtendedStatsBucket.fromXContent(p, (String) c));
     */
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
     * Builds an {@link InternalAggregation.ReduceContextBuilder} that is valid but empty.
        map.put(GlobalAggregationBuilder.NAME, (p, c) -> ParsedGlobal.fromXContent(p, (String) c));
import static java.util.Collections.emptyList;
            PipelineTree.EMPTY
                || path.endsWith(Aggregation.CommonFields.BUCKETS.getPreferredName())
    protected Predicate<String> excludePathsFromXContentInsertion() {
    }
import java.util.stream.Collectors;
        map.put(GeoDistanceAggregationBuilder.NAME, (p, c) -> ParsedGeoDistance.fromXContent(p, (String) c));
            return 0;
 * KIND, either express or implied.  See the License for the
        map.put(AdjacencyMatrixAggregationBuilder.NAME, (p, c) -> ParsedAdjacencyMatrix.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
 * ownership. Elasticsearch licenses this file to you under
    protected List<NamedXContentRegistry.Entry> getNamedXContents() {
        final T aggregation = createTestInstanceForXContent();
/*
     */
                initialBucketCount += countInnerBucket(internalAggregation);
        map.put(SumAggregationBuilder.NAME, (p, c) -> ParsedSum.fromXContent(p, (String) c));
    @SuppressWarnings("unchecked")
            originalBytes = toShuffledXContent(aggregation, xContentType, params, humanReadable);
        return emptyReduceContextBuilder(PipelineTree.EMPTY);
import org.opensearch.core.xcontent.ContextParser;
            return -1;
     */
        );
    protected NamedXContentRegistry xContentRegistry() {
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTerms;
        map.put(DoubleTerms.NAME, (p, c) -> ParsedDoubleTerms.fromXContent(p, (String) c));
     * Builds an {@link InternalAggregation.ReduceContextBuilder} that is valid and nearly
import org.opensearch.search.aggregations.bucket.sampler.InternalSampler;
import org.opensearch.search.aggregations.bucket.nested.ParsedNested;
        );
    }
     * conversion of AggSpecs into namedWriteables.
        }
import org.opensearch.search.aggregations.bucket.terms.ParsedMultiTerms;
            entries.addAll(((Plugin) plugin).getNamedWriteables());
    }
        map.put(ValueCountAggregationBuilder.NAME, (p, c) -> ParsedValueCount.fromXContent(p, (String) c));
     * overwrite in tests that need it
             * the named aggregation to test - we don't want to insert into the
    protected void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
     */
            metadata = new HashMap<>();
            toPartialReduce.sort(INTERNAL_AGG_COMPARATOR);
    }
        map.put(InternalSampler.PARSER_NAME, (p, c) -> ParsedSampler.fromXContent(p, (String) c));
        map.put(AvgAggregationBuilder.NAME, (p, c) -> ParsedAvg.fromXContent(p, (String) c));
    protected final T createUnmappedInstance(String name) {
            .stream()
/**
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentileRanks;
import org.opensearch.search.aggregations.metrics.GeoCentroidAggregationBuilder;
        map.put(SignificantStringTerms.NAME, (p, c) -> ParsedSignificantStringTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
     * {@link InternalAggregationTestCase#registerPlugin()} instead because that route handles the automatic
 * the Apache License, Version 2.0 (the "License"); you may
        map.put(InternalHDRPercentileRanks.NAME, (p, c) -> ParsedHDRPercentileRanks.fromXContent(p, (String) c));
    /**
        return randomFrom(formats).get();
        map.put(MedianAbsoluteDeviationAggregationBuilder.NAME, (p, c) -> ParsedMedianAbsoluteDeviation.fromXContent(p, (String) c));
    }
        assertThat(bucketConsumer.getCount(), equalTo(innerBucketCount));
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.bucket.histogram.ParsedAutoDateHistogram;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.filter.ParsedFilter;
import org.opensearch.search.aggregations.bucket.range.ParsedGeoDistance;
    /** Return an instance on an unmapped field. */
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
     */
        for (int i = 0; i < size; i++) {
    protected ScriptService mockScriptService() {
        map.put(AutoDateHistogramAggregationBuilder.NAME, (p, c) -> ParsedAutoDateHistogram.fromXContent(p, (String) c));
        map.put(StatsAggregationBuilder.NAME, (p, c) -> ParsedStats.fromXContent(p, (String) c));
    }
        map.put(TopHitsAggregationBuilder.NAME, (p, c) -> ParsedTopHits.fromXContent(p, (String) c));
    }
/*
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
import org.opensearch.search.aggregations.metrics.ParsedAvg;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.SetOnce;
import java.util.Comparator;
 * SPDX-License-Identifier: Apache-2.0
    protected SearchPlugin registerPlugin() {
                || path.endsWith(Aggregation.CommonFields.META.getPreferredName())
             */
        int size = between(1, 200);
import org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;
        return namedXContents;
        map.put(HistogramAggregationBuilder.NAME, (p, c) -> ParsedHistogram.fromXContent(p, (String) c));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
        map.put(InternalBucketMetricValue.NAME, (p, c) -> ParsedBucketMetricValue.fromXContent(p, (String) c));
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
import org.opensearch.search.aggregations.metrics.ParsedMin;
        map.put(VariableWidthHistogramAggregationBuilder.NAME, (p, c) -> ParsedVariableWidthHistogram.fromXContent(p, (String) c));
    }
        final boolean addRandomFields
import org.opensearch.search.aggregations.bucket.histogram.ParsedHistogram;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.opensearch.core.xcontent.XContentParserUtils;
        map.put(InternalHDRPercentiles.NAME, (p, c) -> ParsedHDRPercentiles.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
import org.opensearch.search.aggregations.bucket.terms.ParsedLongRareTerms;
        }
    }
            Collections.shuffle(toReduce, random());
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
import org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregationBuilder;
        return new InternalAggregation.ReduceContextBuilder() {
        if (randomBoolean()) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.search.aggregations.bucket.range.ParsedDateRange;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, plugin == null ? emptyList() : Collections.singletonList(plugin));
        final InternalAggregation aggregation,
            BytesReference parsedBytes = toXContent(agg, xContentType, params, humanReadable);
    }
        } else {
import org.opensearch.search.aggregations.bucket.composite.ParsedComposite;
     * Implementors can override this if they want to provide a custom list of namedWriteables.  If the implementor
    @Override
        toReduce.addAll(inputs);
        if (randomBoolean() && toReduce.size() > 1) {
    private static void assertMultiBucketConsumer(int innerBucketCount, MultiBucketConsumer bucketConsumer) {
                return InternalAggregation.ReduceContext.forFinalReduction(BigArrays.NON_RECYCLING_INSTANCE, null, b -> {}, pipelineTree);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        // For most impls, we use the same instance in the unmapped case and in the mapped case
import org.opensearch.search.aggregations.metrics.ParsedHDRPercentileRanks;
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
    protected abstract void assertReduced(T reduced, List<T> inputs);
import org.opensearch.search.aggregations.pipeline.ExtendedStatsBucketPipelineAggregationBuilder;
            T reduced = (T) toPartialReduce.get(0).reduce(toPartialReduce, context);
    public void testReduceRandom() throws IOException {
        ScriptService mockScriptService = mockScriptService();
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;
import org.opensearch.search.aggregations.metrics.ParsedScriptedMetric;
        } else if (agg1.isMapped() && agg2.isMapped() == false) {
import org.opensearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.opensearch.script.ScriptService;
    /**
 * You may obtain a copy of the License at
    private T createTestInstance(String name) {
        return entries;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
    protected abstract void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) throws IOException;
import org.opensearch.search.aggregations.ParsedAggregation;
import org.opensearch.search.aggregations.metrics.InternalHDRPercentileRanks;
     * Generate a list of inputs to reduce. Defaults to calling
     * Overwrite this in your test if other than the basic xContent paths should be excluded during insertion of random fields
        }
            if (randomBoolean()) {
import java.util.function.Predicate;
            @Override
    public static final int DEFAULT_MAX_BUCKETS = 100000;
    protected List<NamedWriteableRegistry.Entry> getNamedWriteables() {
            /*
                mockScriptService,
        List<InternalAggregation> toReduce = new ArrayList<>();
        } else {
        return inputs;
 *
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        return null;
            int initialBucketCount = 0;
            // check that non final reduction never adds buckets
    static {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            metadata.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
        if (shuffled) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTerms;
            }
import org.opensearch.search.aggregations.metrics.ParsedMax;
     * @return a random {@link DocValueFormat} that can be used in aggregations which
        namedXContents = map.entrySet()
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.pipeline.ParsedSimpleValue;
    }
    private final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(getNamedXContents());
    public static InternalAggregation.ReduceContextBuilder emptyReduceContextBuilder(PipelineTree pipelineTree) {
            T t = randomBoolean() ? createUnmappedInstance(name) : createTestInstance(name);
    }
import org.opensearch.search.aggregations.pipeline.StatsBucketPipelineAggregationBuilder;
        if (plugin != null) {
import org.opensearch.search.aggregations.pipeline.ParsedStatsBucket;
    /**
        };
        return null;
        map.put(UnsignedLongTerms.NAME, (p, c) -> ParsedUnsignedLongTerms.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.metrics.ParsedTopHits;
            XContentParserUtils.parseTypedKeysObject(parser, Aggregation.TYPED_KEYS_DELIMITER, Aggregation.class, parsedAggregation::set);
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
import org.opensearch.search.aggregations.pipeline.ParsedBucketMetricValue;
import org.opensearch.test.hamcrest.OpenSearchAssertions;
import org.opensearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentiles;
import org.opensearch.search.aggregations.pipeline.ParsedDerivative;
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
        map.put(PercentilesBucketPipelineAggregationBuilder.NAME, (p, c) -> ParsedPercentilesBucket.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.nested.ParsedReverseNested;
import org.opensearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.opensearch.search.aggregations.bucket.adjacency.ParsedAdjacencyMatrix;
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
             * Sometimes serializing and deserializing the partially reduced
        final BytesReference originalBytes;
import org.opensearch.core.xcontent.ToXContent;
    protected abstract T createTestInstance(String name, Map<String, Object> metadata);
    public final void testFromXContentWithRandomFields() throws IOException {
            InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forPartialReduction(
        String name = randomAlphaOfLength(5);
    }
            bucketConsumer,
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            toReduce = new ArrayList<>(toReduce.subList(r, inputs.size()));
        map.put(FiltersAggregationBuilder.NAME, (p, c) -> ParsedFilters.fromXContent(p, (String) c));
            assertEquals(aggregation.getType(), agg.getType());
import org.opensearch.search.aggregations.InternalAggregation;
    protected <P extends ParsedAggregation> P parseAndAssert(
     * If a test needs to register additional aggregation specs for namedWriteable, etc, this method
             * named bucket objects. Any new named object on this level should
        formats.add(() -> new DocValueFormat.Decimal(randomFrom("###.##", "###,###.##")));
             *
import org.opensearch.search.aggregations.metrics.ParsedMedianAbsoluteDeviation;
import org.opensearch.search.aggregations.bucket.terms.ParsedStringTerms;
    /**
 * Implementors of this test case should be aware that the aggregation under test needs to be registered
            originalBytes = toXContent(aggregation, xContentType, params, humanReadable);
            int reducedBucketCount = countInnerBucket(reduced);
            @Override
            OpenSearchAssertions.assertToXContentEquivalent(originalBytes, parsedBytes, xContentType);
        map.put(GeoCentroidAggregationBuilder.NAME, (p, c) -> ParsedGeoCentroid.fromXContent(p, (String) c));
    }
             * on a root level of SearchHit are interpreted as meta-fields and will be kept.
/*
        InternalAggregationTestCase.assertMultiBucketConsumer(agg, bucketConsumer);
        assertFromXContent(aggregation, parsedAggregation);
            mockScriptService,
 * license agreements. See the NOTICE file distributed with
    protected T createUnmappedInstance(String name, Map<String, Object> metadata) {
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
     */
        map.put(InternalSimpleValue.NAME, (p, c) -> ParsedSimpleValue.fromXContent(p, (String) c));
import org.opensearch.common.util.MockPageCacheRecycler;
        final ParsedAggregation parsedAggregation = parseAndAssert(aggregation, randomBoolean(), true);
        map.put(CardinalityAggregationBuilder.NAME, (p, c) -> ParsedCardinality.fromXContent(p, (String) c));
        inputs.sort(INTERNAL_AGG_COMPARATOR);
     * {@link #createUnmappedInstance(String)} but should be overridden
import org.opensearch.search.aggregations.bucket.terms.StringRareTerms;
import java.util.Map;
    }
import org.opensearch.search.aggregations.bucket.missing.ParsedMissing;
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
 *
        map.put(LongTerms.NAME, (p, c) -> ParsedLongTerms.fromXContent(p, (String) c));
            return (P) agg;
        map.put(MissingAggregationBuilder.NAME, (p, c) -> ParsedMissing.fromXContent(p, (String) c));
        }
            Predicate<String> excludes = basicExcludes.or(excludePathsFromXContentInsertion());
        doAssertReducedMultiBucketConsumer(reduced, bucketConsumer);
import org.opensearch.rest.action.search.RestSearchAction;
 */
        map.put(MaxAggregationBuilder.NAME, (p, c) -> ParsedMax.fromXContent(p, (String) c));
        map.put(ExtendedStatsAggregationBuilder.NAME, (p, c) -> ParsedExtendedStats.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.adjacency.AdjacencyMatrixAggregationBuilder;
        return path -> false;
import static org.hamcrest.Matchers.equalTo;
        }
                return InternalAggregation.ReduceContext.forPartialReduction(BigArrays.NON_RECYCLING_INSTANCE, null, () -> pipelineTree);
import org.opensearch.search.aggregations.bucket.range.ParsedRange;
        }
            Aggregation agg = parsedAggregation.get();
        map.put(CompositeAggregationBuilder.NAME, (p, c) -> ParsedComposite.fromXContent(p, (String) c));
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
    private static final List<NamedXContentRegistry.Entry> namedXContents;
            assertThat(reducedBucketCount, lessThanOrEqualTo(initialBucketCount));
    /** Return an instance on an unmapped field. */
import java.util.ArrayList;
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        List<T> inputs = new ArrayList<>();
import java.io.IOException;
            Predicate<String> basicExcludes = path -> path.isEmpty()
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
        } else {
        return createTestInstance(name, createTestMetadata());
                () -> PipelineAggregator.PipelineTree.EMPTY
 * Modifications Copyright OpenSearch Contributors. See
        map.put(DateRangeAggregationBuilder.NAME, (p, c) -> ParsedDateRange.fromXContent(p, (String) c));
        // Sort aggs so that unmapped come last. This mimicks the behavior of InternalAggregations.reduce()
            public ReduceContext forFinalReduction() {
import java.util.Collections;
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValue;
import org.opensearch.common.xcontent.XContentType;
            toReduce.add(reduced);
 * aggs should override {@link InternalAggregationTestCase#registerPlugin()} so that the NamedWriteables
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        map.put(WeightedAvgAggregationBuilder.NAME, (p, c) -> ParsedWeightedAvg.fromXContent(p, (String) c));
import org.opensearch.search.aggregations.bucket.range.ParsedBinaryRange;
        assertFromXContent(aggregation, parsedAggregation);
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>(searchModule.getNamedWriteables());
    public final Map<String, Object> createTestMetadata() {
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
        map.put(ReverseNestedAggregationBuilder.NAME, (p, c) -> ParsedReverseNested.fromXContent(p, (String) c));
     * {@link #createTestInstance(String)} and
}
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
package org.opensearch.test;
                || path.contains("top_hits");
import org.opensearch.search.aggregations.bucket.terms.ParsedSignificantStringTerms;
import org.opensearch.search.SearchModule;
        return namedXContents;
import org.opensearch.search.aggregations.metrics.ExtendedStatsAggregationBuilder;
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregationBuilder;
import org.opensearch.core.common.bytes.BytesReference;
     * if it isn't realistic to reduce test instances.
import org.opensearch.search.aggregations.metrics.ParsedTDigestPercentileRanks;
    }
        return metadata;
    }
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        final XContentType xContentType = randomFrom(XContentType.values());
             * partial reduce. And to simulate cross cluster search.
import org.opensearch.search.aggregations.metrics.ParsedCardinality;
    /**
             * we also exclude top_hits that contain SearchHits, as all unknown fields
        map.put(MinAggregationBuilder.NAME, (p, c) -> ParsedMin.fromXContent(p, (String) c));
            // sometimes do a partial reduce
