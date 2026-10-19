        return reader;
        );
                start = randomIp(v4);
                aCount.preCollection();
        @Override
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.fielddata.IndexFieldData;
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        IndexSearcher searcher,
        );
                        }
        Query rewritten = searcher.rewrite(query);
        IndexSearcher searcher,
     * Override to wrap the {@linkplain DirectoryReader} for aggs like
        public LeafBucketCollector getSelectedCollector() {
    protected void afterClose() {}
            Collections.shuffle(aggs, random());
import org.opensearch.index.mapper.ObjectMapper;
    }
     */
                        protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                indexSettings,
    }
        denylist.add(GeoShapeFieldMapper.CONTENT_TYPE); // Cannot aggregate geoshapes (yet)
            NamedAnalyzer defaultAnalyzer = new NamedAnalyzer(
    protected ThreadPool aggTestThreadPool;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.index.cache.bitset.BitsetFilterCache;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        @SuppressWarnings("unchecked")
            bucketConsumer,
                        throw failure;
        }
                doc.add(new SortedSetDocValuesField(fieldName, new BytesRef("a")));
        Settings settings = Settings.builder().put("index.version.created", Version.CURRENT.id).build();
        protected void doWriteTo(StreamOutput out) throws IOException {
     * {@link NestedAggregationBuilder}.
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
        when(searchContext.termsAggregationMaxPrecomputeCardinality()).thenReturn(30_000L);
            }
import org.opensearch.index.mapper.SemanticVersionFieldMapper;
import org.opensearch.script.ScriptService;
        }
     * The difference between this method and {@link searchAndReduce} is that
            fieldTypes
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        Query query,
        return createStreamAggregator(
            bigArrays
    }
        MappedFieldType... fieldTypes
            assertThat(ctx, instanceOf(CompositeReaderContext.class));
    ) throws IOException {
                end = RangeType.FLOAT.nextUp(start);
    protected QueryShardContext queryShardContextMock(
    }
            this.collectCounter = collectCounter;
import org.opensearch.search.aggregations.support.ValuesSourceType;
     * @return an aggregation builder to test against the field
import org.opensearch.index.mapper.GeoPointFieldMapper;
        if (hasNested) {
            IndexMetadata.builder("_index")
    }
                start = randomInt();
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        AggregatorFactory aggregatorFactory,
        MultiBucketConsumer bucketConsumer,
    protected static DirectoryReader wrapInMockESDirectoryReader(DirectoryReader directoryReader) throws IOException {
            RangeType rangeType;
        customizeSearchContext.accept(searchContext);
        // materialize any parent pipelines
            int r = randomIntBetween(1, toReduceSize);
        when(indexShard.shardId()).thenReturn(new ShardId("test", "test", 0));
     * Half the time it aggregates each leaf individually and reduces all
            // If the test says it doesn't support any VStypes, it has not been converted yet so skip
        }
        CompositeIndexFieldInfo compositeIndexFieldInfo,
import java.util.Map;
        );
        CompositeDataCubeFieldType compositeMappedFieldType = mock(CompositeDataCubeFieldType.class);
            searchContext
        registerFieldTypes(searchContext, mapperService, fieldNameToType);
            null,
        }
            internalAgg = (A) pipelineAggregator.reduce(internalAgg, context);
            json = "{ \"" + fieldName + "\" : \"" + v + "\" }";
            }
            this.partitions = new LeafReaderContextPartition[] { partition };
     * the test will check if an exception is thrown in that case.
                starTree,
            new BitsetFilterCache(indexSettings, aggTestIndicesBitsetFilterCache, mock(BitsetFilterCache.Listener.class))
        } else if (vst.equals(CoreValuesSourceType.RANGE)) {
                subSearcher.search(weight, aCount);
/*
                    compCTX.leaves().get(searcherIDX)
import org.opensearch.test.OpenSearchTestCase;
        AggregationBuilder builder,
        MultiBucketConsumer bucketConsumer,
    /**
     * @param fieldName the name of the field that will be test
        return aggregator;
            fieldTypes
    protected CountingAggregator createCountingAggregator(
import org.apache.lucene.index.IndexReader;
import org.opensearch.common.lucene.search.Queries;
        }
                C a = createAggregator(query, builder, subSearcher, indexSettings, shardBucketConsumer, fieldTypes);
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
    }
        ).build(new IndexFieldDataCache.None(), circuitBreakerService);
            public void onUse(Query query) {}
            CardinalityUpperBound.ONE,
                json = "{ \"" + fieldName + "\" : \"" + d + "\" }";
     * this method also asserts the the number of documents match the expectedCount.
        IndexSettings indexSettings,
    protected NumberFieldMapper.NumberFieldType longField(String name) {
                Weight weight = subSearcher.createWeight(rewritten, ScoreMode.COMPLETE, 1f);
        Query query,
        IndexSettings indexSettings,
            query = Queries.filtered(query, Queries.newNonNestedFilter());
        }
                BuilderContext context = new BuilderContext(indexSettings.getSettings(), new ContentPath());
            super(name);
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                );
                && mappedType.getKey().equals(MatchOnlyTextFieldMapper.CONTENT_TYPE) == false) {
     * <p>
     * <p>
import org.opensearch.index.IndexSettings;
                        @Override
            v = Math.abs(randomInt());
                            // TODO Auto-generated method stub
                        }
            source.put("type", mappedType.getKey());
    /**
            getMockScriptService(),
import org.opensearch.index.mapper.FieldMapper;
 * this work for additional information regarding copyright
import org.opensearch.index.analysis.AnalyzerScope;
        InternalAggregationTestCase.assertMultiBucketConsumer(agg, bucketConsumer);
        AggregationBuilder aggregationBuilder,
        if (rangeType == RangeType.DATE) {
                aggs.add(aCount.buildTopLevel());
            assertEquals(0, countingAggregator.collectCounter.get());
            aggTestThreadPool = new TestThreadPool("agg_test");
        }
            root.preCollection();
        return aggregator;
                rangeType = RangeType.DATE;
    private class MockParserContext extends Mapper.TypeParser.ParserContext {
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        CircuitBreakerService circuitBreakerService,
     * an exception _is not_ thrown when a field is unsupported, that will also fail the test.
        return createAggregator(null, aggregationBuilder, indexSearcher, indexSettings, bucketConsumer, fieldTypes);
                                    + fieldType.typeName()
        public Aggregator parent() {
     */
        SearchContext searchContext,
        boolean consolidated = starTreeQueryContext.consolidateAllFilters(searchContext);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            .create(searchContext, null, cardinality);
            .build(searchContext.getQueryShardContext(), null)
        List<Metric> supportedMetrics,
                    AssertionError failure = null;
            } else {
        @SuppressWarnings("unchecked")
import org.opensearch.search.internal.SearchContext;
     * results together. The other half the time it aggregates across the entire
        public CountingAggregator(AtomicInteger collectCounter, Aggregator delegate) {
        Consumer<V> verify,
                getMockScriptService(),
            supportedDimensions,
    @After
        when(searchContext.query()).thenReturn(query);
                root.context().bigArrays(),
        String typeName = fieldType.typeName();
        @Override
        when(searchContext.mapperService()).thenReturn(mapperService);
        }
        IndexSettings indexSettings,
        valuesSourceRegistry = searchModule.getValuesSourceRegistry();
     * The field type and name are provided, and the implementor is expected to return an AggBuilder accordingly.
                        if (supportedVSTypes.contains(vst) == false || unsupportedMappedFieldTypes.contains(fieldType.typeName())) {
        }
        }
            if (TYPE_TEST_DENYLIST.contains(mappedType.getKey())) {
import org.opensearch.index.fielddata.IndexFieldDataCache;
            null,
     * an exception is thrown when the field is supported, that will fail the test.  Similarly, if
import java.util.LinkedHashMap;
                v = HalfFloatPoint.halfFloatToSortableShort(f);
            new org.opensearch.search.aggregations.metrics.CardinalityAggregationContext(false, Runtime.getRuntime().maxMemory() / 100)
import org.opensearch.index.analysis.NamedAnalyzer;
import static org.hamcrest.Matchers.instanceOf;
            return Settings.EMPTY;
        MappedFieldType... fieldTypes
        // now do the final reduce
import org.opensearch.core.common.io.stream.StreamOutput;
     * This test will validate that an aggregator succeeds or fails to run against all the field types
        return Collections.emptyMap();
    }
                end = RangeType.LONG.nextUp(start);
import org.opensearch.index.mapper.Mapper;
            when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] {});
            List<InternalAggregation> toReduce = aggs.subList(0, r);
                        }
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
                            );
        AggregationBuilder builder,
        AggregatorFactory aggregatorFactory,
        }
                    maxBucket,
        Query query,
        Query rewritten = searcher.rewrite(query);
    /**
            @Override
        public ScoreMode scoreMode() {
        IndexSearcher searcher,
        }
                rootCount.context().bigArrays(),
                v = Math.abs(randomByte());
            );
    }
        public InternalAggregation buildEmptyAggregation() {
    }
            createIndexSettings(),
import static org.hamcrest.Matchers.equalTo;
                rangeType = RangeType.IP;
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
    };
            indexSearcher,
        final IndexReaderContext ctx = searcher.getTopReaderContext();
        MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumer(
    }
            }
    /**
        @Override
        MappedFieldType... fieldTypes
            queryBuilder,
            builder,
            return new InternalAggCardinality(name, cardinality, metadata);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.document.SortedNumericDocValuesField;
import java.util.concurrent.atomic.AtomicInteger;
        // Mock SearchContextAggregations
            throw new UnsupportedOperationException();
 * {@link AggregationBuilder} instance.
            null,
        denylist.add(ContextAwareGroupingFieldMapper.CONTENT_TYPE); // Cannot aggregate context aware groupings
        when(searchContext.maxAggRewriteFilters()).thenReturn(10_000);
        MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumer(
    }
            int r = randomIntBetween(1, toReduceSize);
        List<String> denylist = new ArrayList<>();
    /**
        );
        return new AggCardinalityAggregationBuilder(name);
     */
            for (int searcherIDX = 0; searcherIDX < subSearchers.length; searcherIDX++) {
import static org.mockito.ArgumentMatchers.any;
        MappedFieldType... fieldTypes
import org.opensearch.index.shard.SearchOperationListener;
    }
            compositeIndexFieldInfo,
                + "        \"lte\" : \""
        boolean shardFanOut,
            queryBuilder,
        // Once all aggs implement this method we should make it abstract and not allow skipping.
        if (randomBoolean()) {
     * Throws an exception if it encounters an unknown field type, to prevent new ones from sneaking in without
                    Aggregator parent,
                json = "{ \"" + fieldName + "\" : \"" + v + "\" }";
    ) throws IOException {
import org.opensearch.index.mapper.MappedFieldType;
        }
            }
    }
        if (aggTestIndicesBitsetFilterCache != null) {
            String fieldName = entry.getKey();
     * should be implemented as well.
            aggs.add(reduced);
        IndexSearcher indexSearcher,
        if (randomBoolean()) {
    /**
                return false;
            }
                json = "{ \"" + fieldName + "\" : \"" + f + "\" }";
            doc.add(new SortedNumericDocValuesField(fieldName, v));
            InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forPartialReduction(
import org.apache.lucene.index.DirectoryReader;
            long v;
     *
     * This is needed in some areas where the ValuesSourceType is not granular enough, for example integer values
            queryCachingPolicy,
    }
                json = "{ \"" + fieldName + "\" : \"" + f + "\" }";
    }
    }
            internalAgg = (A) pipelineAggregator.reduce(internalAgg, context);
            maxBucket,
            pipelines
        CountingAggregator rootCount = new CountingAggregator(new AtomicInteger(), root);
     */
        if (maxBucket == -1) {
                                    + "] but executing against the field did not throw an exception"
    protected static final TriConsumer<Document, String, String> ADD_SORTED_SET_FIELD_INDEXED = (document, field, value) -> {
     * which must also be implemented.
        when(searchContext.numberOfShards()).thenReturn(1);
        Query query,
            null,
        query = query.rewrite(searcher);
        IndexSearcher indexSearcher,
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    }
     * wraps in the IndexSearcher's IndexReader with other implementations that we can't handle. (e.g. ParallelCompositeReader)
    protected IndexReader wrapDirectoryReader(DirectoryReader reader) throws IOException {
            maxBucket,
            fieldTypes
import java.util.Objects;
            indexSettings,
            null,
        IndexSearcher indexSearcher,
        }
        return createAggregator(
    }
        }
                query,
                writeTestDoc(fieldType, fieldName, indexWriter);
    ) throws IOException {
import org.opensearch.index.mapper.ObjectMapper.Nested;
            query,
    /**
        }
            searcher,
     * <p>
import static java.util.Collections.emptyMap;
            final int size = compCTX.leaves().size();
            indexSettings = createIndexSettings();
                    };
     */
            String fieldName = (String) invocation.getArguments()[0];
        return new IndexSettings(
                MultiBucketConsumer shardBucketConsumer = new MultiBucketConsumer(
        countingAggregator.preCollection();
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        }
        }
            double lon = randomDouble();
        SearchContext searchContext = mock(SearchContext.class);
                totalCollectCount += aCount.getCollectCount().get();
        @Override
        IndexSearcher searcher,
            indexSearcher.getIndexReader(),
        MapperRegistry mapperRegistry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
    /**
            Mapper.Builder builder = mappedType.getValue().parse(fieldName, source, new MockParserContext());
            aggTestIndicesBitsetFilterCache.close();
            System::currentTimeMillis,
     * This is used to test the matrix of supported/unsupported field types against the aggregator
     * Helper method to write a single document with a single value specific to the requested fieldType.
            query,
                );
                protected boolean supportsConcurrentSegmentSearch() {
        return internalAgg;
                start = randomFloat();
            aggs.add(rootCount.buildTopLevel());
        MappedFieldType... fieldTypes
                MultiBucketConsumer shardBucketConsumer = new MultiBucketConsumer(
import org.opensearch.index.mapper.TextFieldMapper;
                                    + aggregationBuilder.getType()
import org.apache.lucene.index.CompositeReaderContext;
            assertThat(ctx, instanceOf(CompositeReaderContext.class));
        if (hasNested) {
     */
            searcher.search(rewritten, root);
                        }
        aggs.add(countingAggregator.buildTopLevel());
    protected <A extends Aggregator> A createAggregator(AggregationBuilder aggregationBuilder, SearchContext searchContext)
                source.put("doc_values", "true");
     * Make a {@linkplain NumberFieldMapper.NumberFieldType} for a {@code double}.
        }
        boolean assertCollectorEarlyTermination,
        String fieldName = "typeTestFieldName";
public abstract class AggregatorTestCase extends OpenSearchTestCase {
        AggregationBuilder aggregationBuilder,
    private List<Releasable> releasables = new ArrayList<>();
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
            new MultiBucketConsumer(DEFAULT_MAX_BUCKETS, new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)),
        final IndexReaderContext ctx = searcher.getTopReaderContext();
import java.util.List;
        protected void doWriteTo(StreamOutput out) throws IOException {
     * This is a denylist instead of an allowlist because there are vastly more field types than ValuesSourceTypes,
            }
        Query query,
     * Implementors should return a list of {@link ValuesSourceType} that the aggregator supports.
import org.opensearch.index.mapper.FieldAliasMapper;
    }
    }
            doc.add(new SortedNumericDocValuesField(fieldName, v));
            supportedMetrics,
        when(searchContext.bigArrays()).thenReturn(bigArrays);
    // Make this @Before instead of @BeforeClass so it can call the non-static getSearchPlugins method
            compositeIndexFieldInfo,
                CountingAggregator aCount = new CountingAggregator(new AtomicInteger(), a);
        return createAggregator(aggregationBuilder, searchContext);
import org.opensearch.Version;
    /**
                @Override
        }
        int maxBucket,
import org.apache.lucene.search.Collector;
            return singletonList(
            indexSettings,
import org.opensearch.common.TriFunction;
    private void cleanupReleasables() {
import org.opensearch.index.analysis.AnalysisRegistry;
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        MappedFieldType... fieldTypes
        }
        boolean skipReducedMultiBucketConsumerAssertion,
            };
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
        if (vst.equals(CoreValuesSourceType.NUMERIC)) {
                                    + "] supports field type ["
        public IndexAnalyzers getIndexAnalyzers() {
        CardinalityUpperBound cardinality,
        public void setWeight(Weight weight) {
            mapperService.getIndexSettings().getIndex().getName(),
        IndexSearcher indexSearcher,
                            return new InternalAggCardinality(name, cardinality, metadata);
            aggregationBuilder,
        // materialize any sibling pipelines at top level
                                "Aggregator ["
    }
    protected <A extends Aggregator> A createStreamAggregator(
import org.opensearch.index.compositeindex.datacube.Metric;
    }
import org.opensearch.common.CheckedConsumer;
        SearchContext searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);
    }
        TYPE_TEST_DENYLIST = denylist;
     * like {@link org.apache.lucene.tests.util.LuceneTestCase#newSearcher(IndexReader)}, which can't be used because it also
        Query query,
import org.apache.lucene.search.QueryCachingPolicy;
import org.opensearch.index.mapper.StarTreeMapper;
    public void initValuesSourceRegistry() {
            Map<String, Object> source = new HashMap<>();
        return internalAgg;
        AggCardinalityAggregationBuilder(String name) {
        List<SearchPlugin> plugins = new ArrayList<>(getSearchPlugins());
            indexSearcher.getSimilarity(),
        // now do the final reduce
        }
            if (typeName.equals(RangeType.DOUBLE.typeName())) {
        SearchContext searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);
        when(searchContext.getFlushMode()).thenReturn(FlushMode.PER_SEGMENT);
            return new AssertingDirectoryReader(reader);
            json = "{ \"" + fieldName + "\" : \"" + NetworkAddress.format(ip) + "\" }";
 * GitHub history for details.
        internalAgg = (A) internalAgg.reducePipelines(internalAgg, context, pipelines);
                source.put("value", "default_value");
        }
    ) throws IOException {
        return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);
        CircuitBreakerService circuitBreakerService
        List<Metric> supportedMetrics,
            mapperService,
                rangeType = RangeType.INTEGER;
            }
        );
        SearchContextAggregations searchContextAggregations = mock(SearchContextAggregations.class);
                        if (supportedVSTypes.contains(vst) && unsupportedMappedFieldTypes.contains(fieldType.typeName()) == false) {
            final RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType, start, end, true, true);
        );
            }
            return new RangeFieldMapper.RangeFieldType(name, RangeFieldMapper.Defaults.DATE_FORMATTER);
import static org.mockito.Mockito.mock;
        }
            /* Store the release-ables so we can release them at the end of the test case. This is important because aggregations don't
import org.apache.lucene.store.Directory;
        }
        );
import org.opensearch.index.mapper.Mapper.BuilderContext;
        return searchContext;
        if (supportedVSTypes.isEmpty()) {
                bucketConsumer,
    protected ScriptService getMockScriptService() {
    public void testSupportedFieldTypes() throws IOException {
     * If this method is implemented, {@link AggregatorTestCase#createAggBuilderForTypeTest(MappedFieldType, String)}
 */
            .create(searchContext, null, CardinalityUpperBound.ONE);
            delegate.close();
                rangeType = RangeType.LONG;
import org.opensearch.test.InternalAggregationTestCase;
            final int size = compCTX.leaves().size();
        for (PipelineAggregator pipelineAggregator : pipelines.aggregators()) {
            doc.add(new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(ip))));
            return new AggregatorFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata) {
            return BucketCardinality.ONE;
            when(mapperService.fieldType(dimension.getField())).thenReturn(supportedDimensions.get(dimension));
        boolean shardFanOut,
        A internalAgg = (A) aggs.get(0).reduce(aggs, context);
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
        releasables.clear();
            query,
            try (Directory directory = newDirectory()) {
            null,
     */
            Settings.EMPTY
    protected KeywordFieldMapper.KeywordFieldType keywordField(String name) {
            return null;
        return searchAndReduce(createIndexSettings(), searcher, query, builder, DEFAULT_MAX_BUCKETS, randomBoolean(), fieldTypes);
     * results together. The other half the time it aggregates across the entire
            this.cardinality = cardinality;
                );
        Query query,
        IndexSettings indexSettings,
import org.apache.lucene.document.InetAddressPoint;
        Document doc = new Document();
        when(searchContext.cardinalityAggregationContext()).thenReturn(
        Releasables.close(releasables);
        IndexSearcher searcher,
import static org.mockito.ArgumentMatchers.anyString;
package org.opensearch.search.aggregations;
        return searchAndReduce(createIndexSettings(), searcher, query, builder, DEFAULT_MAX_BUCKETS, shardFanOut, fieldTypes);
                + "\",\n"
        @Override
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            getIndexFieldDataLookup(mapperService, circuitBreakerService),
        public void preCollection() throws IOException {
import org.opensearch.search.aggregations.metrics.MetricsAggregator;
import org.opensearch.index.mapper.BinaryFieldMapper;
 *
     * can be useful when testing aggregations on field aliases.
            bucketConsumer,
                protected Aggregator createInternal(
        @Override
        if (shardFanOut && searcher.getIndexReader().leaves().size() > 0) {
        QueryBuilder queryBuilder,
        IndexSettings indexSettings,
 */
        IndexSearcher searcher,
            return "agg_cardinality";
            query = Queries.filtered(query, Queries.newNonNestedFilter());
        // This bypasses the cost estimation decision logic in the factory
    /**
            v = randomBoolean() ? 0 : 1;
            MappedFieldType fieldType = mapper.fieldType();
    protected RangeFieldMapper.RangeFieldType rangeField(String name, RangeType rangeType) {
import org.junit.Before;
     * @return list of supported ValuesSourceTypes
        }
    /**
     * Make a {@linkplain DateFieldMapper.DateFieldType} for a {@code date}.
        when(mapperService.getCompositeFieldTypes()).thenReturn(compositeFieldTypes);
            return builder.array("cardinality", cardinality);
import org.opensearch.common.util.MockBigArrays;
                subSearcher.search(weight, a);
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
            json = "{ \""
        MultiBucketConsumer bucketConsumer,
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), circuitBreakerService).withCircuitBreaking();
import org.opensearch.search.internal.ContextIndexSearcher;
        return createAggregator(query, aggregationBuilder, indexSearcher, createIndexSettings(), bucketConsumer, fieldTypes);
    }
import org.apache.lucene.index.IndexReaderContext;
                ) throws IOException {
    protected MapperService mapperServiceMock() {
        List<InternalAggregation> aggs = new ArrayList<>();
        );
        QueryBuilder queryBuilder,
                                    + aggregationBuilder.getType()
                .creationDate(System.currentTimeMillis())
        }
            return new IndexSearcher(indexReader);
    ) throws IOException {
        IndexSearcher indexSearcher,
         */
    protected SearchContext createSearchContext(
import org.opensearch.index.mapper.NumberFieldMapper;
                    if (failure != null) {
        return new CountingAggregator(new AtomicInteger(), createAggregator(aggregationBuilder, searchContext));
            maxBucket,
 * license agreements. See the NOTICE file distributed with
        return searchAndReduceStarTree(
        }
            searchContext.getQueryShardContext().setStarTreeQueryContext(starTreeQueryContext);
            return delegate.subAggregator(name);
        IndexSearcher indexSearcher,
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
    }
        return searchAndReduce(createIndexSettings(), searcher, query, builder, maxBucket, randomBoolean(), fieldTypes);
                @Override
        @SuppressWarnings("unchecked")
    protected IndicesBitsetFilterCache aggTestIndicesBitsetFilterCache;
import static org.mockito.Mockito.when;
        AggregationBuilder builder,
                V agg = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldTypes);
    /**
     * Sub-tests that need a more complex index field data provider can override this
    protected <A extends Aggregator> A createAggregator(
                    selectedCollector.collect(doc, bucket);
        // If aggs don't override this method, an empty list allows the test to be skipped.
        }
        when(compositeMappedFieldType.name()).thenReturn(starTree.getField());
                getMockScriptService(),
import org.opensearch.common.util.BigArrays;
            false,
            throw new IllegalStateException("Unknown field type [" + typeName + "]");
            bucketConsumer,
        QueryShardContext queryShardContext = queryShardContextMock(
        ContextIndexSearcher contextIndexSearcher = new ContextIndexSearcher(
        @Override
                            return LeafBucketCollector.NO_OP_COLLECTOR;
            when(searchContext.getQueryShardContext().fieldMapper(dimension.getField())).thenReturn(supportedDimensions.get(dimension));
            false,
        A internalAgg = (A) aggs.get(0).reduce(aggs, context);
        // TODO: now just needed for top_hits, this will need to be revised for other agg unit tests:
import org.opensearch.common.util.MockPageCacheRecycler;
            return delegate.name();
    protected <A extends Aggregator> A createAggregator(
        MappedFieldType... fieldTypes
        Query query,
import org.opensearch.index.mapper.ContentPath;
        fieldNameToType.putAll(getFieldAliases(fieldTypes));
            if (fieldType.isAggregatable() == false) {
        @Override
        when(searchContextAggregations.factories()).thenReturn(aggregatorFactories);
        IndexSettings indexSettings,
            aggs.add(root.buildTopLevel());
                new AggregationSpec("agg_cardinality", in -> null, (ContextParser<String, AggCardinalityAggregationBuilder>) (p, c) -> null)
        final IndexReaderContext ctx = searcher.getTopReaderContext();
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
        } else {
        }
            MappedFieldType fieldType = entry.getValue();
import org.opensearch.threadpool.ThreadPool;
 */
        @Override
        denylist.add(StarTreeMapper.CONTENT_TYPE); // TODO evaluate support for star tree fields
     * Make a {@linkplain NumberFieldMapper.NumberFieldType} for a {@code long}.
        }
        @Override
            when(mapperService.fieldType(fieldName)).thenReturn(fieldType);
        }).when(searchContext).addReleasable(any());
                    } catch (Exception | AssertionError e) {
import org.apache.lucene.document.Field;
            .build(searchContext.getQueryShardContext(), null)
    }
            aggregations.forEach(ia -> { assertThat(((InternalAggCardinality) ia).cardinality, equalTo(cardinality)); });
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        /*
        };
            rootCount.preCollection();
        Query query,
        IndexSearcher indexSearcher,
    }
            int toReduceSize = aggs.size();
     * Maintains a count for times collect() is invoked - number of documents visited
                + "\"\n"
        AggregationBuilder aggregationBuilder,
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
        CompositeIndexFieldInfo compositeIndexFieldInfo,
                aggregatorFactory,
        }
            root.context().bigArrays(),
        if (shardFanOut && searcher.getIndexReader().leaves().size() > 0) {
        } else {
        return searchAndReduce(indexSettings, searcher, query, builder, maxBucket, false, shardFanOut, fieldTypes);
            } else if (typeName.equals(NumberFieldMapper.NumberType.FLOAT.typeName())) {
        }
            indexSearcher,
        AggregationBuilder aggregationBuilder,
                float f = Math.abs(randomFloat());
        MappedFieldType... fieldTypes
            getMockScriptService(),
    protected <A extends Aggregator> A createAggregator(
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            () -> true,
            root.postCollection();
        protected InternalAggCardinality(String name, CardinalityUpperBound cardinality, Map<String, Object> metadata) {
     * A method that allows implementors to specifically denylist particular field types (based on their content_name).
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
                end = RangeType.INTEGER.nextUp(start);
     * wraps in the IndexReader with other implementations that we can't handle. (e.g. ParallelCompositeReader)
        }
     *
     * and verify it works (or doesn't) as expected.
    ) throws IOException {
     * @param fieldType the type of the field that will be tested
    ) throws IOException {
        Query query,
            return delegate.buildAggregations(owningBucketOrds);
        MappedFieldType... fieldTypes
            indexSearcher,
        if (skipReducedMultiBucketConsumerAssertion == false) doAssertReducedMultiBucketConsumer(internalAgg, reduceBucketConsumer);
            fieldTypes
        document.add(new SortedSetDocValuesField(field, new BytesRef(value)));
        Query query,
        if (aggTestThreadPool == null) {
                    Map<String, Object> metadata
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                        public InternalAggregation buildAggregation(long owningBucketOrd) throws IOException {
        plugins.add(new AggCardinalityPlugin());
import org.opensearch.index.mapper.RangeType;
     * The list of supported types are provided by {@link AggregatorTestCase#getSupportedValuesSourceTypes()},
        private final AtomicInteger collectCounter;
import org.opensearch.cluster.metadata.IndexMetadata;
        final PipelineTree pipelines = builder.buildPipelineTree();
     */
            getMockScriptService(),
 */
                        searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
        }
import org.opensearch.index.mapper.MapperService;
        A aggregator = (A) aggregationBuilder.rewrite(searchContext.getQueryShardContext())
            builder,
        int maxBucket,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
import org.apache.lucene.tests.index.AssertingDirectoryReader;
    /**
        IndexSettings indexSettings,
            return new IndexAnalyzers(singletonMap(AnalysisRegistry.DEFAULT_ANALYZER_NAME, defaultAnalyzer), emptyMap(), emptyMap());
        int maxBucket,
            // positive integer because date_nanos gets unhappy with large longs
import java.util.HashMap;
                        }
        protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
                }
 * Provides helpers for constructing and searching an {@link Aggregator} implementation based on a provided
    private static List<String> TYPE_TEST_DENYLIST;
import org.opensearch.search.fetch.subphase.FetchDocValuesPhase;
        CompositeIndexFieldInfo starTree,
            public boolean shouldCache(Query query) {
        } else {
    static {
            return collectCounter;
        boolean shardFanOut,
     * being tested.
        IndexSearcher searcher,
        MultiBucketConsumer bucketConsumer,
        }
            when(searchContext.fieldType(fieldName)).thenReturn(fieldType);
    /**
        @Override
        MapperService mapperService = mock(MapperService.class);
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            aggregatorFactory,
        Query query,
     * Collects all documents that match the provided query {@link Query} and
        return new KeywordFieldMapper.KeywordFieldType(name);
            hasNested,
        MultiBucketConsumer bucketConsumer,
        assertEquals(expectedCount, totalCollectCount);
     * Make a {@linkplain GeoPointFieldMapper.GeoPointFieldType} for a {@code geo_point}.
            reduceBucketConsumer,
    protected SearchContext createSearchContextWithStarTreeContext(
            rootCount.postCollection();
     */
        public String name() {
        @Override
import org.opensearch.core.index.Index;
            return reader;
        );
        boolean assertCollectorEarlyTermination,
                a.preCollection();
            final CompositeReaderContext compCTX = (CompositeReaderContext) ctx;
 * specific language governing permissions and limitations
        MultiBucketConsumer bucketConsumer,
        doAssertReducedMultiBucketConsumer(internalAgg, reduceBucketConsumer);
        });
    /**
        return new DateFieldMapper.DateFieldType(name, resolution);
import org.opensearch.index.analysis.IndexAnalyzers;
    ) throws IOException {
        return Collections.emptyList();
        // Force streaming aggregator creation by setting flushMode to PER_SEGMENT
        IndexSearcher searcher,
        private LeafBucketCollector selectedCollector;
                public void collect(int doc, long bucket) throws IOException {
                () -> PipelineAggregator.PipelineTree.EMPTY
        @Override
    protected NumberFieldMapper.NumberFieldType doubleField(String name) {
                supportedMetrics,
        @Override
        public SearchContext context() {
            // sometimes do an incremental reduce
import org.opensearch.search.SearchModule;
        }
        IndexSearcher indexSearcher,
        MultiBucketConsumer bucketConsumer,
import org.apache.lucene.search.QueryCache;
import org.opensearch.index.mapper.KeywordFieldMapper;
    }
        public final Aggregator delegate;
import org.apache.lucene.document.Document;
        return Collections.emptyList();
        Map<String, MappedFieldType> fieldNameToType
                .numberOfReplicas(0)
        MappedFieldType... fieldTypes
    }
        return null;
        when(compositeMappedFieldType.getCompositeIndexType()).thenReturn(starTree.getType());
        Query query,
            );
                C a = createAggregator(query, builder, subSearcher, indexSettings, shardBucketConsumer, fieldTypes);
            Object start;
        IndexSettings indexSettings,
        AggregationBuilder aggregationBuilder,
            throw new UnsupportedOperationException();
                // smallest numeric is a byte so we select the smallest
        SearchContext searchContext = createSearchContext(
                        public InternalAggregation buildEmptyAggregation() {
                            );
    }
        IndexSettings indexSettings,
                start = randomDouble();
        denylist.add(CompletionFieldMapper.CONTENT_TYPE); // TODO support completion
    protected <A extends Aggregator> A createStreamAggregator(
    /**
                            failure = new AssertionError(
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
        public void close() {
            indexSettings,
        when(searchContext.fetchPhase()).thenReturn(new FetchPhase(Arrays.asList(new FetchSourcePhase(), new FetchDocValuesPhase())));
            return new AssertingIndexSearcher(random(), indexReader);
     */
        when(mapperService.hasNested()).thenReturn(false);
import org.apache.lucene.document.SortedSetDocValuesField;
        );
            if (mappedType.getKey().equals(ConstantKeywordFieldMapper.CONTENT_TYPE) == true) {
        List<String> unsupportedMappedFieldTypes = unsupportedMappedFieldTypes();
import org.opensearch.index.mapper.GeoShapeFieldMapper;
        T aggregationBuilder,
        MapperService mapperService = mapperServiceMock();
        SearchModule searchModule = new SearchModule(Settings.EMPTY, plugins);
        doc.add(new StoredField("_source", new BytesRef(json)));
 * Licensed to Elasticsearch under one or more contributor
        );
            if (typeName.equals(NumberFieldMapper.NumberType.DOUBLE.typeName())) {
import org.apache.lucene.util.NumericUtils;
        MapperService mapperService,
                rangeType = RangeType.DOUBLE;
        IndexSettings indexSettings,
            releasables.add((Releasable) invocation.getArguments()[0]);
    // A list of field types that should not be tested, or are not currently supported
        int maxBucket,
        ValuesSourceType vst = fieldToVST(fieldType);
    }
                        @Override
     * Sub-tests that need scripting can override this method to provide a script service and pre-baked scripts
import java.io.IOException;
                supportedDimensions,
            when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { aggregatorFactory });
     */
            Arrays.stream(fieldTypes).filter(Objects::nonNull).collect(Collectors.toMap(MappedFieldType::name, Function.identity()))
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduceCounting(
import org.opensearch.core.xcontent.ContextParser;
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        );
        when(searchContext.asLocalBucketCountThresholds(any())).thenCallRealMethod();
        }
                    SearchContext searchContext,
                            return null;
    }
            indexSettings,
            bigArrays,
        Set<CompositeMappedFieldType> compositeFieldTypes = Set.of(compositeMappedFieldType);
    }
    }
     * sub-tests that need a more complex mock can overwrite this
        Query query,
import org.apache.lucene.tests.index.RandomIndexWriter;
            aggregationBuilder,
import org.opensearch.index.query.QueryShardContext;
    }
        ShardSearcher(LeafReaderContextPartition partition, IndexReaderContext parent) {
    protected static final TriConsumer<Document, String, String> ADD_SORTED_SET_FIELD_NOT_INDEXED = (document, field, value) -> document
                    return new MetricsAggregator(name, searchContext, parent, metadata) {
    /**
        @Override
            assertCollectorEarlyTermination,
    public static AggregationBuilder aggCardinality(String name) {
        public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.index.mapper.DateFieldMapper;
import org.opensearch.common.lease.Releasable;
            query,
    }
                verify.accept(agg);
        Query query,
import org.apache.lucene.tests.search.AssertingIndexSearcher;
                start = randomLong();
                    CardinalityUpperBound cardinality,
                }
            delegate.preCollection();
 *
        IndexSettings indexSettings,
            // Some field types should not be tested, or require more work and are not ready yet
        MapperService mapperService,
            query = Queries.filtered(query, Queries.newNonNestedFilter());
        MultiBucketConsumer bucketConsumer,
        return OpenSearchDirectoryReader.wrap(directoryReader, new ShardId(new Index("_index", "_na_"), 0));
            }
import java.util.function.Function;
                queryBuilder,
     * Create a {@linkplain SearchContext} for testing an {@link Aggregator}.
        String json;
            maxBucket,
        Query query,
        }
        MappedFieldType... fieldTypes
import org.opensearch.plugins.SearchPlugin;
    protected GeoPointFieldMapper.GeoPointFieldType geoPointField(String name) {
        SearchOperationListener searchOperationListener = new SearchOperationListener() {
     * index at once and runs a final reduction on the single resulting agg.
        } else {
        }
        QueryCache queryCache = new DisabledQueryCache(indexSettings);
    }
        } else if (vst.equals(CoreValuesSourceType.IP)) {
    protected SearchContext createSearchContext(
        IndexSearcher searcher,
        } else {
        document.add(new StringField(field, value, Field.Store.NO));
    protected static class CountingAggregator extends Aggregator {
                AnalyzerScope.GLOBAL,
            buildIndex.accept(indexWriter);
            totalCollectCount = rootCount.getCollectCount().get();
                () -> PipelineAggregator.PipelineTree.EMPTY
        A aggregator = (A) aggregationBuilder.rewrite(searchContext.getQueryShardContext())
    }
        MockParserContext() {
        CircuitBreakerService circuitBreakerService,
        for (Map.Entry<String, MappedFieldType> entry : fieldNameToType.entrySet()) {
     * vs floating points, or `keyword` bytes vs `binary` bytes (which are not searchable)
        if (randomBoolean() && aggs.size() > 1) {
        denylist.add(ObjectMapper.CONTENT_TYPE); // Cannot aggregate objects
        AggregationBuilder builder,
        public void search(Weight weight, Collector collector) throws IOException {
        final PipelineTree pipelines = builder.buildPipelineTree();
import java.util.stream.Stream;
 * the Apache License, Version 2.0 (the "License"); you may
            }
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(searchContext, queryBuilder);
        );
            return builder;
     * <p>
                                    + "] but executing against the field threw an exception: ["
     */
                            failure = new AssertionError(
                + "      }}";
            Collections.shuffle(aggs, random());
            throw new UnsupportedOperationException();
            return delegate.buildEmptyAggregation();
            searcher,
        AggregationBuilder aggregationBuilder,
                end = RangeType.IP.nextUp(start);
        IndexSettings indexSettings,
                    try {
        @Override
        );
        IndexShard indexShard = mock(IndexShard.class);
        if (aggTestThreadPool != null) {
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                + start
        }
    ) {
        A internalAgg = (A) aggs.get(0).reduce(aggs, context);
        }
import java.util.stream.Collectors;
    }
    ) throws IOException {
            searcher.search(rewritten, rootCount);
        }
        return internalAgg;
    ) {
                + "\" : { \n"
        public Object getProperty(List<String> path) {
            indexWriter.close();
    ) throws IOException {
        }
        AggregationBuilder builder,
            InetAddress ip = randomIp(randomBoolean());
import org.opensearch.index.query.QueryBuilder;
                continue;
        return (fieldType, s, searchLookup) -> fieldType.fielddataBuilder(
import org.opensearch.indices.IndicesBitsetFilterCache;
        IndexSettings indexSettings,
        Query query,
        Query query,
        @Override
        }
import org.opensearch.search.startree.StarTreeQueryContext;
     * that are registered in {@link IndicesModule} (e.g. all the core field types).  An aggregator
        .add(new SortedSetDocValuesField(field, new BytesRef(value)));
        Map<String, MappedFieldType> fieldNameToType = new HashMap<>();
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        }
                try (IndexReader indexReader = DirectoryReader.open(directory)) {
                v = NumericUtils.doubleToSortableLong(d);
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
     * returns the reduced {@link InternalAggregation}.
     * that was passed to its ctor.
    /**
import org.opensearch.common.lease.Releasables;
            searchContext = createSearchContextWithStarTreeContext(
            ThreadPool.terminate(aggTestThreadPool, 10, java.util.concurrent.TimeUnit.SECONDS);
import java.util.ArrayList;
    ) throws IOException {
        }
        List<InternalAggregation> aggs = new ArrayList<>();
            return delegate.context();
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
        Query query,
                fieldTypes
    ) throws IOException {
    }
import org.apache.lucene.search.Weight;
            // this executes basic query checks and asserts that weights are normalized only once etc.
     */
            fieldTypes
/*
            }
        );
import org.apache.lucene.index.LeafReaderContext;
                // never cache a query
        QueryCachingPolicy queryCachingPolicy = new QueryCachingPolicy() {
            double lat = randomDouble();
        };
            };
            "If getSupportedValuesSourceTypes() is implemented, " + "createAggBuilderForTypeTest() must be implemented as well."
     */
        @SuppressWarnings("unchecked")
        MappedFieldType... fieldTypes
    ) throws IOException {
            aggregationBuilder,
        when((compositeMappedFieldType).getMetrics()).thenReturn(supportedMetrics);
                AnalysisRegistry.DEFAULT_ANALYZER_NAME,
     * The AggBuilder should be returned even if the aggregation does not support the field type, because
        public String toString() {
     */
        if (compositeIndexFieldInfo != null && assertCollectorEarlyTermination) {
            valuesSourceRegistry
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
            this.delegate = delegate;
                        @Override
        }
            }
        Stream.of(fieldTypes).forEach(fieldType -> when(mapperService.fieldType(fieldType.name())).thenReturn(fieldType));
            }
        MappedFieldType... fieldTypes
            if (typeName.equals(BinaryFieldMapper.CONTENT_TYPE)) {
    ) throws IOException {
            aggTestIndicesBitsetFilterCache = null;
        }
    }
            // Text is the only field that doesn't support DVs, instead FD
    }
        @Override
                subSearchers[searcherIDX] = new ShardSearcher(partition, compCTX);
        when(queryShardContext.getObjectMapper(anyString())).thenAnswer(invocation -> {
import org.opensearch.index.compositeindex.datacube.Dimension;
    protected TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> getIndexFieldDataLookup(
    }
    protected List<String> unsupportedMappedFieldTypes() {
        for (Dimension dimension : supportedDimensions.keySet()) {
                @Override
        public CardinalityUpperBound cardinality() {
import org.opensearch.index.cache.query.DisabledQueryCache;
    protected <A extends Aggregator> A createAggregator(
        MappedFieldType... fieldTypes
import static org.mockito.Mockito.any;
        AggregationBuilder aggregationBuilder,
     * Wrapper around Aggregator class
import org.opensearch.threadpool.TestThreadPool;
            } else if (typeName.equals(RangeType.IP.typeName())) {
     * This method is invoked each time a field type is tested in {@link AggregatorTestCase#testSupportedFieldTypes()}.
        } else if (vst.equals(CoreValuesSourceType.BOOLEAN)) {
     * Allows subclasses to provide alternate names for the provided field type, which
                + "        \"gte\" : \""
        IndexSearcher indexSearcher,
                                e
                Weight weight = subSearcher.createWeight(rewritten, ScoreMode.COMPLETE, 1f);
import org.apache.lucene.search.MatchAllDocsQuery;
            } else if (typeName.equals(RangeType.LONG.typeName())) {
            aggTestThreadPool = null;
import java.util.Set;
        public Settings getSettings() {
        doAnswer(invocation -> {
        MappedFieldType... fieldTypes
        int totalCollectCount = 0;
    ) throws IOException {
            return selectedCollector;
        MappedFieldType... fieldTypes
        denylist.add(FieldAliasMapper.CONTENT_TYPE); // TODO support alias
        public void postCollection() throws IOException {
                }
                float f = Math.abs((randomFloat() * 2 - 1) * 65504);
            json = "{ \"" + fieldName + "\" : \"" + (v == 0 ? "false" : "true") + "\" }";
            doc.add(new LatLonDocValuesField(fieldName, lat, lon));
                    collectCounter.incrementAndGet();
        @SuppressWarnings("unchecked")
     * returns the reduced {@link InternalAggregation}.
    /**
        IndexSettings indexSettings,
    private static class AggCardinalityAggregationBuilder extends AbstractAggregationBuilder<AggCardinalityAggregationBuilder> {
import org.opensearch.common.network.NetworkAddress;
                return new ObjectMapper.Builder<>(fieldName).nested(Nested.newNested()).build(context);
}
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduceStarTree(
                rangeType = RangeType.DOUBLE;
        denylist.add(ObjectMapper.NESTED_CONTENT_TYPE); // TODO support for nested
            return delegate.parent();
    ) throws IOException {
        @Override
                v = NumericUtils.floatToSortableInt(f);
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        SearchContext searchContext;
        boolean hasNested,
                                    + e.getMessage()
        CountingAggregator countingAggregator = createCountingAggregator(
        doAssertReducedMultiBucketConsumer(internalAgg, reduceBucketConsumer);
 * SPDX-License-Identifier: Apache-2.0
        }
import org.apache.lucene.search.IndexSearcher;
            json = "{ \"" + fieldName + "\" : \"[" + lon + "," + lat + "]\" }";
    private ValuesSourceType fieldToVST(MappedFieldType fieldType) {
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduceStarTree(
            super(null, null, null, Version.CURRENT, null, null, null);
            countingAggregator.context().bigArrays(),
            A reduced = (A) aggs.get(0).reduce(toReduce, context);
                    return true;
    @Before
    }
            );
        );
        if (starTree != null) {
            int toReduceSize = aggs.size();
        final PipelineTree pipelines = builder.buildPipelineTree();
        @Override
        for (PipelineAggregator pipelineAggregator : pipelines.aggregators()) {
            final CompositeReaderContext compCTX = (CompositeReaderContext) ctx;
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        internalAgg = (A) internalAgg.reducePipelines(internalAgg, context, pipelines);
                .build(),
     * is provided by the implementor class, and it is executed against each field type in turn.  If
            A reduced = (A) aggs.get(0).reduce(toReduce, context);
import org.opensearch.common.TriConsumer;
            for (ShardSearcher subSearcher : subSearchers) {
                a.postCollection();
        AggregationBuilder aggregationBuilder,
        }
            0,
        when(searchContext.bitsetFilterCache()).thenReturn(
            } else if (typeName.equals(RangeType.DATE.typeName())) {
        denylist.add(DerivedFieldMapper.CONTENT_TYPE); // TODO support derived fields
import org.apache.lucene.util.BytesRef;
import java.util.Arrays;
                    }
        return new RangeFieldMapper.RangeFieldType(name, rangeType);
                                    + "] should not support field type ["
        MapperService mapperService,
    protected <T extends AggregationBuilder, V extends InternalAggregation> void testCase(
        IndexSearcher searcher,
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
 *
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
            delegate.postCollection();
        return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);
    }
    protected static IndexSearcher newIndexSearcher(IndexReader indexReader) {
        C root = createAggregator(query, builder, searcher, bucketConsumer, fieldTypes);
     */
            supportedMetrics,
            supportedDimensions,
                    selectedCollector = delegate.getLeafCollector(ctx);
            maxBucket,
        when(searchContext.searcher()).thenReturn(contextIndexSearcher);
                    AggregationBuilder aggregationBuilder = createAggBuilderForTypeTest(fieldType, fieldName);
 * under the License.
    protected static IndexReader maybeWrapReaderEs(DirectoryReader reader) throws IOException {
        }
import org.apache.lucene.document.LatLonDocValuesField;
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader indexReader = wrapDirectoryReader(unwrapped)) {
        searcher.search(query, countingAggregator);
import static java.util.Collections.singletonMap;
     * Half the time it aggregates each leaf individually and reduces all
        when(searchContext.aggregations()).thenReturn(new SearchContextAggregations(AggregatorFactories.EMPTY, bucketConsumer));
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
     * Request an aggregation that returns the {@link CardinalityUpperBound}
/*
            if (mappedType.getKey().equals(TextFieldMapper.CONTENT_TYPE) == false
        private final CardinalityUpperBound cardinality;
     * Collects all documents that match the provided query {@link Query} and
import org.opensearch.search.lookup.SearchLookup;
        AggregatorFactory aggregatorFactory,
import org.apache.lucene.document.StringField;
             * close their sub-aggregations. This is fairly similar to what the production code does. */
        MappedFieldType... fieldTypes
        MultiBucketConsumer bucketConsumer,
    protected void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
    ) throws IOException {
        when(searchContext.aggregations()).thenReturn(new SearchContextAggregations(AggregatorFactories.EMPTY, bucketConsumer));
            search(partitions, weight, collector);
    public static class InternalAggCardinality extends InternalAggregation {
 * compatible open source license.
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
                end = RangeType.DOUBLE.nextUp(start);
    private static class ShardSearcher extends IndexSearcher {
    protected <A extends Aggregator> A createAggregatorWithCustomizableSearchContext(
            searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);
        return fieldType.fielddataBuilder("", () -> { throw new UnsupportedOperationException(); }).build(null, null).getValuesSourceType();
import org.opensearch.index.mapper.RangeFieldMapper;
        );
 * Base class for testing {@link Aggregator} implementations.
     */
    ) throws IOException {
     * sub-tests that need a more complex mock can overwrite this
                json = "{ \"" + fieldName + "\" : \"a\" }";
        boolean hasNested,
        MappedFieldType... fieldTypes
import org.opensearch.index.mapper.CompletionFieldMapper;
    ) throws IOException {
import org.opensearch.index.mapper.ConstantKeywordFieldMapper;
        );
     * like {@link org.apache.lucene.tests.util.LuceneTestCase#wrapReader(IndexReader)}, which can't be used because it also
import org.opensearch.index.shard.IndexShard;
                                    + "]",
            } else if (typeName.equals(NumberFieldMapper.NumberType.HALF_FLOAT.typeName())) {
                start = randomNonNegativeLong();
        public AtomicInteger getCollectCount() {
    private void writeTestDoc(MappedFieldType fieldType, String fieldName, RandomIndexWriter iw) throws IOException {
                                "Aggregator ["
        AggregationBuilder builder,
        );
        return createAggregator(aggregationBuilder, searchContext);
        return createAggregator(
        AggregatorFactory aggregatorFactory,
        IndexSettings indexSettings,
    ) throws IOException {
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
        IndexSearcher indexSearcher,
     * <p>
            doc.add(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(Collections.singleton(range))));
     */
        try (Directory directory = newDirectory()) {
            if (fieldName.startsWith(NESTEDFIELD_PREFIX)) {
            List<InternalAggregation> toReduce = aggs.subList(0, r);
        public Aggregator subAggregator(String name) {
        @Override
        return searchContext;
     * index at once and runs a final reduction on the single resulting agg.
            getMockScriptService(),
import org.opensearch.search.streaming.FlushMode;
        throws IOException {
        List<Metric> supportedMetrics,
            indexSettings,
            this.delegate.setWeight(weight);
        return new QueryShardContext(
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            throw new UnsupportedOperationException();
                final LeafReaderContextPartition partition = LeafReaderContextPartition.createForEntireSegment(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.apache.lucene.document.StoredField;
        }
    ) throws IOException {
        AggregationBuilder builder,
            maxBucket,
     * Exception types/messages are not currently checked, just presence/absence of an exception.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
                doc.add(new BinaryFieldMapper.CustomBinaryDocValuesField(fieldName, new BytesRef("a").bytes));
     * Make a {@linkplain NumberFieldMapper.NumberFieldType} for a {@code range}.
                final LeafReaderContextPartition partition = LeafReaderContextPartition.createForEntireSegment(
                + end
        }
            throws IOException {
    /**
        Query query,
    }
     */
import org.opensearch.indices.IndicesModule;
            for (int searcherIDX = 0; searcherIDX < subSearchers.length; searcherIDX++) {
                indexWriter.close();
                new StandardAnalyzer()
     */
                end = RangeType.DATE.nextUp(start);
            aggs.add(reduced);
        if (aggregatorFactory != null) {
                // Generate a random float that respects the limits of half float
        MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumer(
        }
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
    }
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
                }
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                aggs.add(a.buildTopLevel());
            reduceBucketConsumer,
            final ShardSearcher[] subSearchers = new ShardSearcher[size];
            Object end;
    protected <A extends Aggregator> A createAggregator(
            // Non-aggregatable fields are not testable (they will throw an error on all aggs anyway), so skip
        throw new UnsupportedOperationException(
        // materialize any sibling pipelines at top level
import static java.util.Collections.singletonList;
            queryCache,
import org.opensearch.core.common.breaker.CircuitBreaker;
        boolean hasNested,
import org.apache.lucene.search.IndexSearcher.LeafReaderContextPartition;
     * Test cases should override this if they have plugins that need to be loaded, e.g. the plugins their aggregators are in.
        @Override
        IndexSettings indexSettings,
        int maxBucket,
        return new GeoPointFieldMapper.GeoPointFieldType(name);
        for (Map.Entry<String, Mapper.TypeParser> mappedType : mapperRegistry.getMapperParsers().entrySet()) {
     * and it's expected that these unsupported cases are exceptional rather than common
                RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        @Override
 * You may obtain a copy of the License at
        );
    }
            throw new UnsupportedOperationException();
            contextIndexSearcher,
        }
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        IndexSearcher indexSearcher,
        return mock(MapperService.class);
     */
            searcher,
            } else {
     */
    /**
            pipelines
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            reduceBucketConsumer,
        }
        BigArrays bigArrays
            );
        AggregationBuilder builder,
    }
        C root = createAggregator(query, builder, searcher, indexSettings, bucketConsumer, fieldTypes);
        @Override
        }
/**
import org.apache.lucene.document.BinaryDocValuesField;
        iw.addDocument(doc);
        denylist.add(SemanticVersionFieldMapper.CONTENT_TYPE); // TODO support for semantic version fields
            indexSearcher,
                                    + fieldType.typeName()
        }
            long v;
        @Override
import org.opensearch.search.fetch.subphase.FetchSourcePhase;
        countingAggregator.postCollection();
import org.junit.After;
            super(name, metadata);
            maxBucket,
    /**
            } else {
            } else if (typeName.equals(RangeType.INTEGER.typeName())) {
        MappedFieldType... fieldTypes
            new MultiBucketConsumer(DEFAULT_MAX_BUCKETS, new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)),
        List<ValuesSourceType> supportedVSTypes = getSupportedValuesSourceTypes();
        protected boolean mustReduceOnSingleInternalAgg() {
        CompositeIndexFieldInfo starTree,
 * ownership. Elasticsearch licenses this file to you under
        return searchAndReduce(indexSettings, searcher, query, builder, DEFAULT_MAX_BUCKETS, randomBoolean(), fieldTypes);
        if (indexSettings == null) {
        } else {
        } else {
    }
 * this file be licensed under the Apache-2.0 license or a
        public String getWriteableName() {
         * we're passed gets a chance to break.
            return true;
import org.opensearch.index.mapper.ContextAwareGroupingFieldMapper;
    }
import org.apache.lucene.search.ScoreMode;
import org.apache.lucene.search.Query;
                    }
        private final LeafReaderContextPartition[] partitions;
            return null;
    protected ValuesSourceRegistry valuesSourceRegistry;
    }
            query,
        return Collections.emptyList();
        QueryBuilder queryBuilder,
        List<InternalAggregation> aggs = new ArrayList<>();
            return "ShardSearcher(" + partitions[0].ctx + ")";
import org.opensearch.index.mapper.DerivedFieldMapper;
        return createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, new NoneCircuitBreakerService(), fieldTypes);
            indexSettings,
        int expectedCount,
            // sometimes do an incremental reduce
                );
                + fieldName
        when((compositeMappedFieldType).getDimensions()).thenReturn(new ArrayList<>(supportedDimensions.keySet()));
        );
        AggregationBuilder aggregationBuilder,
                continue;
            pipelines
        boolean shardFanOut,
                throw new IllegalStateException("Unknown type of range [" + typeName + "]");
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            xContentRegistry(),
        MappedFieldType... fieldTypes
     * Added to randomly run with more assertions on the index searcher level,
    protected IndexSettings createIndexSettings() {
    /**
        }
        public List<AggregationSpec> getAggregations() {
            for (ShardSearcher subSearcher : subSearchers) {
     * <p>
 * Modifications Copyright OpenSearch Contributors. See
        when(searchContext.isStreamSearch()).thenReturn(true);
            return cardinality;
    }
import java.net.InetAddress;
        List<Metric> supportedMetrics,
import org.opensearch.common.settings.Settings;
        QueryBuilder queryBuilder,
    /**
        if (hasNested) {
         * Always use the circuit breaking big arrays instance so that the CircuitBreakerService
        public BucketCardinality bucketCardinality() {
     */
    ) throws IOException {
            FieldMapper mapper = (FieldMapper) builder.build(new BuilderContext(settings, new ContentPath()));
            );
            aggs = new ArrayList<>(aggs.subList(r, toReduceSize));
        Consumer<SearchContext> customizeSearchContext,
            @Override
            long v;
            return new LeafBucketCollector() {
        MultiBucketConsumer bucketConsumer,
        @Override
            return;
        boolean hasNested,
     */
                json = "{ \"" + fieldName + "\" : \"a\" }";
                boolean v4 = randomBoolean();
 * software distributed under the License is distributed on an
     * Added to randomly run with more assertions on the index reader level,
    private static void registerFieldTypes(
        when(indexShard.indexSettings()).thenReturn(indexSettings);
import org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;
            mapperService,
            aggTestIndicesBitsetFilterCache = new IndicesBitsetFilterCache(Settings.EMPTY);
        }
import org.opensearch.index.mapper.CompositeMappedFieldType;
 * not use this file except in compliance with the License.
    }
import java.util.Collections;
            InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forPartialReduction(
                .numberOfShards(1)
        MappedFieldType... fieldTypes
            rootCount.context().bigArrays(),
        fieldNameToType.putAll(
            }
        when(searchContext.indexShard()).thenReturn(indexShard);
                double d = Math.abs(randomDouble());
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
    /**
            aggregatorFactory,
                subSearchers[searcherIDX] = new ShardSearcher(partition, compCTX);
            circuitBreakerService,
    protected List<SearchPlugin> getSearchPlugins() {
            } else if (typeName.equals(RangeType.FLOAT.typeName())) {
 * Unless required by applicable law or agreed to in writing,
            doc.add(new SortedNumericDocValuesField(fieldName, v));
        SearchContext searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);
            return delegate.scoreMode();
    private static final String TYPE_NAME = "type";
        // materialize any parent pipelines
    }
import org.opensearch.indices.mapper.MapperRegistry;
        AggregationBuilder builder,
            aggs = new ArrayList<>(aggs.subList(r, toReduceSize));
     * Make a {@linkplain DateFieldMapper.DateFieldType} for a {@code date}.
        when(searchContext.bucketCollectorProcessor()).thenReturn(new BucketCollectorProcessor());
                    // TODO in the future we can make this more explicit with expectThrows(), when the exceptions are standardized
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    }
import java.util.function.Consumer;
        );
import static org.mockito.Mockito.doAnswer;
        int maxBucket,
        } else if (vst.equals(CoreValuesSourceType.BYTES)) {
    }
        }
    protected DateFieldMapper.DateFieldType dateField(String name, DateFieldMapper.Resolution resolution) {
     */
    private static final String NESTEDFIELD_PREFIX = "nested_";
     * Hook for checking things after all {@link Aggregator}s have been closed.
        if (randomBoolean() && aggs.size() > 1) {
     * <p>
    private static class AggCardinalityPlugin implements SearchPlugin {
            }
            writableRegistry(),
    ) {
     */
        MappedFieldType... fieldTypes
    }
        }
        protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subfactoriesBuilder)
        );
            searchLookup
import java.util.function.Supplier;
                    compCTX.leaves().get(searcherIDX)
import org.opensearch.search.fetch.FetchPhase;
                    ValuesSourceType vst = fieldToVST(fieldType);
        IndexSearcher indexSearcher,
        when(searchContext.mapperService()).thenReturn(mapperService);
        public String getType() {
        @Override
            super(parent);
                    maxBucket,
        } else if (vst.equals(CoreValuesSourceType.GEOPOINT)) {
        } else if (vst.equals(CoreValuesSourceType.DATE)) {
                indexSearcher,
        if (consolidated) {
            maxBucket = DEFAULT_MAX_BUCKETS;
            final ShardSearcher[] subSearchers = new ShardSearcher[size];
                aCount.postCollection();
        IndexSettings indexSettings,
            new NoneCircuitBreakerService(),
            indexSettings,
            fieldTypes
