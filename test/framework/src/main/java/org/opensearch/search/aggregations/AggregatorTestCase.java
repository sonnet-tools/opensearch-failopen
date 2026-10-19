import org.apache.lucene.search.Weight;  
                () -> PipelineAggregator.PipelineTree.EMPTY
                );
            rootCount.preCollection();
    }
            new MultiBucketConsumer(DEFAULT_MAX_BUCKETS, new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)),
            if (fieldName.startsWith(NESTEDFIELD_PREFIX)) {
    protected static final TriConsumer<Document, String, String> ADD_SORTED_SET_FIELD_INDEXED = (document, field, value) -> {
        }
import org.apache.lucene.document.StringField;  
            writableRegistry(),  
import static org.mockito.Mockito.any;
                    };  
            indexSettings,
     * Sub-tests that need a more complex index field data provider can override this  
            searcher.search(rewritten, rootCount);  
            // positive integer because date_nanos gets unhappy with large longs  
            };
import org.opensearch.index.mapper.StarTreeMapper;  
        List<InternalAggregation> aggs = new ArrayList<>();
     */
            String fieldName = (String) invocation.getArguments()[0];
    }
import java.util.function.Supplier;
        );
 * SPDX-License-Identifier: Apache-2.0
     */
            bucketConsumer,
import org.opensearch.script.ScriptService;
        }
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        IndexSettings indexSettings,
    /**
import org.apache.lucene.store.Directory;
                }  
            mapperService,  
import org.opensearch.index.mapper.ObjectMapper.Nested;
    ) throws IOException {
            MappedFieldType fieldType = mapper.fieldType();
        );
        }
     * Sub-tests that need scripting can override this method to provide a script service and pre-baked scripts
            throw new UnsupportedOperationException();
        @SuppressWarnings("unchecked")
                            return null;
    @After  
            reduceBucketConsumer,
        @Override  
     * <p>
        QueryShardContext queryShardContext = queryShardContextMock(
        IndexSettings indexSettings,
                try (IndexReader indexReader = DirectoryReader.open(directory)) {
        @Override
        when(searchContext.numberOfShards()).thenReturn(1);
            final CompositeReaderContext compCTX = (CompositeReaderContext) ctx;
    /**
     * returns the reduced {@link InternalAggregation}.
import org.apache.lucene.tests.search.AssertingIndexSearcher;
        when(searchContext.bucketCollectorProcessor()).thenReturn(new BucketCollectorProcessor());
            } else if (typeName.equals(RangeType.DATE.typeName())) {
        }
     */
        TYPE_TEST_DENYLIST = denylist;  
        ContextIndexSearcher contextIndexSearcher = new ContextIndexSearcher(  
        SearchContext searchContext,  
            compositeIndexFieldInfo,  
        Stream.of(fieldTypes).forEach(fieldType -> when(mapperService.fieldType(fieldType.name())).thenReturn(fieldType));
            String fieldName = entry.getKey();
        MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumer(
    }
            } else if (typeName.equals(RangeType.FLOAT.typeName())) {
            reduceBucketConsumer,
        if (vst.equals(CoreValuesSourceType.NUMERIC)) {
            return builder;  
        return new AggCardinalityAggregationBuilder(name);  
        );
        Query query,  
            } else if (typeName.equals(NumberFieldMapper.NumberType.HALF_FLOAT.typeName())) {  
        when(searchContext.aggregations()).thenReturn(new SearchContextAggregations(AggregatorFactories.EMPTY, bucketConsumer));  
            fieldTypes
import org.apache.lucene.util.NumericUtils;  
                        if (supportedVSTypes.contains(vst) == false || unsupportedMappedFieldTypes.contains(fieldType.typeName())) {
                MultiBucketConsumer shardBucketConsumer = new MultiBucketConsumer(  
        }
        MappedFieldType... fieldTypes
            }
                    selectedCollector.collect(doc, bucket);
import org.opensearch.search.SearchModule;
        IndexSearcher searcher,
        public Aggregator subAggregator(String name) {
            throw new UnsupportedOperationException();  
        denylist.add(SemanticVersionFieldMapper.CONTENT_TYPE); // TODO support for semantic version fields
     * This is used to test the matrix of supported/unsupported field types against the aggregator  
            "If getSupportedValuesSourceTypes() is implemented, " + "createAggBuilderForTypeTest() must be implemented as well."
        final PipelineTree pipelines = builder.buildPipelineTree();
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
    }  
        InternalAggregationTestCase.assertMultiBucketConsumer(agg, bucketConsumer);
 * {@link AggregationBuilder} instance.
            maxBucket,  
     * results together. The other half the time it aggregates across the entire
        // materialize any parent pipelines  
            return reader;  
            super(null, null, null, Version.CURRENT, null, null, null);
     * Make a {@linkplain GeoPointFieldMapper.GeoPointFieldType} for a {@code geo_point}.
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        // materialize any sibling pipelines at top level  
                + "\"\n"
                source.put("doc_values", "true");
        // materialize any parent pipelines  
    protected KeywordFieldMapper.KeywordFieldType keywordField(String name) {
        IndexSettings indexSettings,  
        // This bypasses the cost estimation decision logic in the factory  
                .creationDate(System.currentTimeMillis())  
            if (TYPE_TEST_DENYLIST.contains(mappedType.getKey())) {  
        countingAggregator.postCollection();
        BigArrays bigArrays  
        AggregationBuilder aggregationBuilder,
     * this method also asserts the the number of documents match the expectedCount.
            json = "{ \""
    protected <A extends Aggregator> A createAggregator(
            assertCollectorEarlyTermination,
    }
                query,
        } else {
                ) throws IOException {
    private static final String TYPE_NAME = "type";  
import org.opensearch.search.fetch.subphase.FetchDocValuesPhase;
            maxBucket,
            throw new UnsupportedOperationException();
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
import org.opensearch.index.cache.bitset.BitsetFilterCache;
        when(compositeMappedFieldType.getCompositeIndexType()).thenReturn(starTree.getType());  
        AggregationBuilder builder,
            } else if (typeName.equals(NumberFieldMapper.NumberType.FLOAT.typeName())) {
    protected TriFunction<MappedFieldType, String, Supplier<SearchLookup>, IndexFieldData<?>> getIndexFieldDataLookup(
        when(searchContext.query()).thenReturn(query);
        public String name() {
        if (indexSettings == null) {
     * sub-tests that need a more complex mock can overwrite this
        Query query,
        Releasables.close(releasables);
                @Override
        }
                            return new InternalAggCardinality(name, cardinality, metadata);
            aggTestIndicesBitsetFilterCache = new IndicesBitsetFilterCache(Settings.EMPTY);  
import org.apache.lucene.tests.index.AssertingDirectoryReader;
                v = HalfFloatPoint.halfFloatToSortableShort(f);  
        );
        @Override
        } else if (vst.equals(CoreValuesSourceType.IP)) {
     * should be implemented as well.
    /**  
import org.apache.lucene.document.StoredField;
     * This is needed in some areas where the ValuesSourceType is not granular enough, for example integer values
            // Text is the only field that doesn't support DVs, instead FD
        AggregationBuilder aggregationBuilder,
        );
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
    // Make this @Before instead of @BeforeClass so it can call the non-static getSearchPlugins method
        protected InternalAggCardinality(String name, CardinalityUpperBound cardinality, Map<String, Object> metadata) {  
        protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
            InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forPartialReduction(
        Query rewritten = searcher.rewrite(query);
        public void postCollection() throws IOException {  
import org.opensearch.threadpool.TestThreadPool;
        Query query,
        doc.add(new StoredField("_source", new BytesRef(json)));
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
     * Make a {@linkplain NumberFieldMapper.NumberFieldType} for a {@code long}.  
        @Override
    static {
                json = "{ \"" + fieldName + "\" : \"a\" }";  
            aggTestIndicesBitsetFilterCache = null;  
        public LeafBucketCollector getSelectedCollector() {
     * index at once and runs a final reduction on the single resulting agg.
        boolean shardFanOut,
                CountingAggregator aCount = new CountingAggregator(new AtomicInteger(), a);
        IndexSettings indexSettings,  
import org.opensearch.common.util.BigArrays;  
            Object end;
            this.partitions = new LeafReaderContextPartition[] { partition };
        int maxBucket,
import org.opensearch.core.common.breaker.CircuitBreaker;  
            } else if (typeName.equals(RangeType.IP.typeName())) {  
 * Provides helpers for constructing and searching an {@link Aggregator} implementation based on a provided  
/*  
                        searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
                start = randomLong();  
            query = Queries.filtered(query, Queries.newNonNestedFilter());
        }
        protected void doWriteTo(StreamOutput out) throws IOException {
        IndexSettings indexSettings,  
        valuesSourceRegistry = searchModule.getValuesSourceRegistry();
        boolean hasNested,  
    }
import static org.mockito.Mockito.doAnswer;  
        IndexSearcher indexSearcher,  
            rootCount.context().bigArrays(),  
import org.apache.lucene.search.QueryCache;  
                }
import org.opensearch.index.analysis.IndexAnalyzers;
import org.opensearch.index.mapper.ContextAwareGroupingFieldMapper;
        when(searchContext.bigArrays()).thenReturn(bigArrays);  
        IndexSearcher searcher,  
import java.util.Collections;
    protected <A extends Aggregator> A createAggregator(  
    /**
            maxBucket,
                    maxBucket,
        }
            // Non-aggregatable fields are not testable (they will throw an error on all aggs anyway), so skip
    protected void afterClose() {}
        public String getWriteableName() {
        MappedFieldType... fieldTypes  
        } else if (vst.equals(CoreValuesSourceType.DATE)) {
            return "ShardSearcher(" + partitions[0].ctx + ")";
import org.apache.lucene.document.BinaryDocValuesField;
    ) throws IOException {  
                a.postCollection();
                rootCount.context().bigArrays(),  
        when(searchContext.termsAggregationMaxPrecomputeCardinality()).thenReturn(30_000L);
     * vs floating points, or `keyword` bytes vs `binary` bytes (which are not searchable)  
        return Collections.emptyList();  
    ) throws IOException {  
        MappedFieldType... fieldTypes
    protected <A extends Aggregator> A createAggregator(
            searchContext = createSearchContextWithStarTreeContext(
        return (fieldType, s, searchLookup) -> fieldType.fielddataBuilder(  
                    }  
     * that was passed to its ctor.  
    /**
import org.apache.lucene.document.Document;
                        public InternalAggregation buildAggregation(long owningBucketOrd) throws IOException {  
            List<InternalAggregation> toReduce = aggs.subList(0, r);
        }
            maxBucket = DEFAULT_MAX_BUCKETS;  
     * <p>
        return reader;  
        registerFieldTypes(searchContext, mapperService, fieldNameToType);
        boolean shardFanOut,
        );  
        }  
                + start  
import org.opensearch.index.mapper.MapperService;
            );  
                }
            Mapper.Builder builder = mappedType.getValue().parse(fieldName, source, new MockParserContext());
        if (starTree != null) {
import org.apache.lucene.search.MatchAllDocsQuery;
        Consumer<SearchContext> customizeSearchContext,  
            supportedMetrics,
        when(indexShard.indexSettings()).thenReturn(indexSettings);
        @Override  
import org.apache.lucene.document.SortedNumericDocValuesField;  
        AggregatorFactory aggregatorFactory,  
            for (int searcherIDX = 0; searcherIDX < subSearchers.length; searcherIDX++) {
        Document doc = new Document();
        public IndexAnalyzers getIndexAnalyzers() {
        }  
            query,  
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
     * Added to randomly run with more assertions on the index searcher level,
import java.util.function.Function;
                            failure = new AssertionError(
            doc.add(new SortedNumericDocValuesField(fieldName, v));  
        MappedFieldType... fieldTypes
                                    + "] but executing against the field did not throw an exception"
            return cardinality;  
        );  
        return createAggregator(aggregationBuilder, searchContext);
    }
            indexSettings,  
        return searchAndReduce(createIndexSettings(), searcher, query, builder, maxBucket, randomBoolean(), fieldTypes);
        }
        MappedFieldType... fieldTypes
            indexSettings,  
                        }
            doc.add(new SortedNumericDocValuesField(fieldName, v));
        @Override  
        CountingAggregator rootCount = new CountingAggregator(new AtomicInteger(), root);
    }
import static java.util.Collections.emptyMap;  
import org.apache.lucene.tests.index.RandomIndexWriter;  
                                "Aggregator ["
    }
        MapperService mapperService = mapperServiceMock();  
                                    + "] but executing against the field threw an exception: ["  
        IndexSearcher indexSearcher,
            indexSettings = createIndexSettings();  
import org.opensearch.common.TriConsumer;
        } else {
 * Modifications Copyright OpenSearch Contributors. See  
        } else if (vst.equals(CoreValuesSourceType.BYTES)) {  
import java.util.Set;
     */
        IndexSearcher indexSearcher,  
                );
        MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumer(
                        public InternalAggregation buildEmptyAggregation() {
                json = "{ \"" + fieldName + "\" : \"a\" }";  
import org.opensearch.index.mapper.MappedFieldType;
        public Aggregator parent() {  
        return new QueryShardContext(
        for (Dimension dimension : supportedDimensions.keySet()) {  
        IndexSearcher indexSearcher,  
        AggregationBuilder aggregationBuilder,
        ValuesSourceType vst = fieldToVST(fieldType);
    }
            queryCache,  
     */  
        boolean hasNested,
import org.opensearch.index.mapper.DerivedFieldMapper;
        Map<String, MappedFieldType> fieldNameToType
            .build(searchContext.getQueryShardContext(), null)  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
    }
    /**
 * Base class for testing {@link Aggregator} implementations.
        return new GeoPointFieldMapper.GeoPointFieldType(name);
        @Override  
                indexWriter.close();  
                    collectCounter.incrementAndGet();
            root.postCollection();
    protected <A extends Aggregator> A createStreamAggregator(
            assertEquals(0, countingAggregator.collectCounter.get());
        CompositeIndexFieldInfo starTree,
                v = NumericUtils.doubleToSortableLong(d);  
import org.apache.lucene.document.InetAddressPoint;
     * Make a {@linkplain NumberFieldMapper.NumberFieldType} for a {@code range}.
 * this file be licensed under the Apache-2.0 license or a
                RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    protected List<String> unsupportedMappedFieldTypes() {
                aCount.postCollection();  
                Weight weight = subSearcher.createWeight(rewritten, ScoreMode.COMPLETE, 1f);
        @Override
            searcher,
        if (hasNested) {
    }  
            aggs.add(root.buildTopLevel());
        }
        return searchContext;  
        }
        );
     */
        when(searchContext.asLocalBucketCountThresholds(any())).thenCallRealMethod();  
     */
        A aggregator = (A) aggregationBuilder.rewrite(searchContext.getQueryShardContext())
            long v;  
}
    }  
        return new RangeFieldMapper.RangeFieldType(name, rangeType);
    ) throws IOException {  
            } else {
        }  
        @Override  
    }
     * wraps in the IndexReader with other implementations that we can't handle. (e.g. ParallelCompositeReader)  
        @Override
            return collectCounter;
            json = "{ \"" + fieldName + "\" : \"[" + lon + "," + lat + "]\" }";
            delegate.preCollection();
            supportedDimensions,
import org.opensearch.search.aggregations.metrics.MetricsAggregator;  
        AggregationBuilder aggregationBuilder,  
     * Make a {@linkplain DateFieldMapper.DateFieldType} for a {@code date}.
                subSearchers[searcherIDX] = new ShardSearcher(partition, compCTX);
/*
    ) throws IOException {
            );  
        if (randomBoolean()) {  
import org.opensearch.plugins.SearchPlugin;  
        MappedFieldType... fieldTypes
        } else {
        when(searchContext.indexShard()).thenReturn(indexShard);
        );
    ) throws IOException {  
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                supportedDimensions,
            throws IOException {
        internalAgg = (A) internalAgg.reducePipelines(internalAgg, context, pipelines);
                aggs.add(a.buildTopLevel());
        Query rewritten = searcher.rewrite(query);
                    Map<String, Object> metadata  
    }
     * This is a denylist instead of an allowlist because there are vastly more field types than ValuesSourceTypes,
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
        boolean assertCollectorEarlyTermination,
        AggregationBuilder builder,
        public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
            when(searchContext.fieldType(fieldName)).thenReturn(fieldType);  
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.search.fetch.subphase.FetchSourcePhase;
     * The difference between this method and {@link searchAndReduce} is that  
        return fieldType.fielddataBuilder("", () -> { throw new UnsupportedOperationException(); }).build(null, null).getValuesSourceType();
import org.opensearch.index.mapper.FieldMapper;  
        Query query,  
    /**
     * being tested.
    }  
            aggTestThreadPool = null;
    ) throws IOException {
import org.apache.lucene.search.ScoreMode;
    protected static class CountingAggregator extends Aggregator {
            return new AssertingDirectoryReader(reader);
                start = randomNonNegativeLong();
        MappedFieldType... fieldTypes  
import org.opensearch.common.CheckedConsumer;  
     * an exception is thrown when the field is supported, that will fail the test.  Similarly, if
import org.opensearch.index.mapper.SemanticVersionFieldMapper;
    /**  
        }).when(searchContext).addReleasable(any());
import org.opensearch.test.InternalAggregationTestCase;
     * Hook for checking things after all {@link Aggregator}s have been closed.  
        }  
    private static class AggCardinalityPlugin implements SearchPlugin {
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(  
            aggregationBuilder,
     * <p>  
    }
    protected static final TriConsumer<Document, String, String> ADD_SORTED_SET_FIELD_NOT_INDEXED = (document, field, value) -> document
        MappedFieldType... fieldTypes  
        }
            } else {
    ) throws IOException {
import java.net.InetAddress;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
 * specific language governing permissions and limitations
            A reduced = (A) aggs.get(0).reduce(toReduce, context);
            aggTestThreadPool = new TestThreadPool("agg_test");
    protected void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {  
        // Force streaming aggregator creation by setting flushMode to PER_SEGMENT
     * index at once and runs a final reduction on the single resulting agg.
                C a = createAggregator(query, builder, subSearcher, indexSettings, shardBucketConsumer, fieldTypes);  
            releasables.add((Releasable) invocation.getArguments()[0]);  
        QueryCachingPolicy queryCachingPolicy = new QueryCachingPolicy() {
        if (hasNested) {
        }  
    /**
    private static final String NESTEDFIELD_PREFIX = "nested_";
import java.util.HashMap;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import org.opensearch.search.streaming.FlushMode;
        denylist.add(ObjectMapper.NESTED_CONTENT_TYPE); // TODO support for nested
        return OpenSearchDirectoryReader.wrap(directoryReader, new ShardId(new Index("_index", "_na_"), 0));
                v = NumericUtils.floatToSortableInt(f);
            search(partitions, weight, collector);  
        MapperService mapperService = mock(MapperService.class);
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
            searcher.search(rewritten, root);  
            }  
        MappedFieldType... fieldTypes
        MapperService mapperService,
            new BitsetFilterCache(indexSettings, aggTestIndicesBitsetFilterCache, mock(BitsetFilterCache.Listener.class))  
    }  
import org.opensearch.index.mapper.ConstantKeywordFieldMapper;  
            query = Queries.filtered(query, Queries.newNonNestedFilter());
        CompositeIndexFieldInfo compositeIndexFieldInfo,
     */
     */  
            getMockScriptService(),
        );  
        @Override  
            return selectedCollector;
                    AggregationBuilder aggregationBuilder = createAggBuilderForTypeTest(fieldType, fieldName);
    /**  
        };
import org.opensearch.index.mapper.DateFieldMapper;  
import org.opensearch.indices.IndicesModule;
     * sub-tests that need a more complex mock can overwrite this
    // A list of field types that should not be tested, or are not currently supported
            when(mapperService.fieldType(dimension.getField())).thenReturn(supportedDimensions.get(dimension));
     */
        public SearchContext context() {
        when(indexShard.shardId()).thenReturn(new ShardId("test", "test", 0));  
        protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subfactoriesBuilder)
        IndexSearcher searcher,  
        }
        AggregationBuilder aggregationBuilder,
import org.opensearch.index.mapper.ObjectMapper;
     * Test cases should override this if they have plugins that need to be loaded, e.g. the plugins their aggregators are in.
        when(searchContext.mapperService()).thenReturn(mapperService);
                doc.add(new BinaryFieldMapper.CustomBinaryDocValuesField(fieldName, new BytesRef("a").bytes));
                    SearchContext searchContext,  
                start = randomDouble();
            Object start;  
import org.opensearch.common.settings.Settings;
            }
    /**
                json = "{ \"" + fieldName + "\" : \"" + f + "\" }";
    ) throws IOException {
    }
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
        AggregationBuilder aggregationBuilder,
    protected RangeFieldMapper.RangeFieldType rangeField(String name, RangeType rangeType) {  
            countingAggregator.context().bigArrays(),  
     * Collects all documents that match the provided query {@link Query} and  
import org.opensearch.core.common.io.stream.StreamOutput;
        protected boolean mustReduceOnSingleInternalAgg() {
            // this executes basic query checks and asserts that weights are normalized only once etc.
                        }
            indexWriter.close();
            );
    protected <A extends Aggregator> A createAggregator(
            assertThat(ctx, instanceOf(CompositeReaderContext.class));  
        assertEquals(expectedCount, totalCollectCount);  
import org.apache.lucene.document.LatLonDocValuesField;
                        if (supportedVSTypes.contains(vst) && unsupportedMappedFieldTypes.contains(fieldType.typeName()) == false) {  
            indexSettings,
        Query query,
        @Override  
        Query query,  
        public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
                        @Override
            } else {
        MultiBucketConsumer bucketConsumer,
            indexSettings,
            // sometimes do an incremental reduce  
        @Override
                start = randomIp(v4);
        Query query,
    protected ValuesSourceRegistry valuesSourceRegistry;
    /**
        AggregationBuilder builder,
        String typeName = fieldType.typeName();  
                rangeType = RangeType.LONG;
    }  
     * Exception types/messages are not currently checked, just presence/absence of an exception.
                writeTestDoc(fieldType, fieldName, indexWriter);
 * GitHub history for details.
import org.opensearch.index.analysis.AnalyzerScope;
    }
                    } catch (Exception | AssertionError e) {
import org.opensearch.common.util.MockBigArrays;
import org.apache.lucene.search.Collector;
 * You may obtain a copy of the License at  
    /**
                supportedMetrics,  
            }
            query,
import org.opensearch.common.lucene.search.Queries;  
                float f = Math.abs((randomFloat() * 2 - 1) * 65504);
            }  
import org.opensearch.index.compositeindex.datacube.Metric;
    protected MapperService mapperServiceMock() {  
     * Maintains a count for times collect() is invoked - number of documents visited  
            }
        @Override
        );
        );
        IndexSearcher indexSearcher,
     */  
        IndexSearcher indexSearcher,  
    private List<Releasable> releasables = new ArrayList<>();
        return aggregator;
        IndexShard indexShard = mock(IndexShard.class);
        );
        // Mock SearchContextAggregations  
        when(queryShardContext.getObjectMapper(anyString())).thenAnswer(invocation -> {  
                                    + aggregationBuilder.getType()  
        MappedFieldType... fieldTypes  
            NamedAnalyzer defaultAnalyzer = new NamedAnalyzer(  
import static org.mockito.Mockito.mock;
        } else {
import java.util.function.Consumer;  
        if (randomBoolean() && aggs.size() > 1) {
     * If this method is implemented, {@link AggregatorTestCase#createAggBuilderForTypeTest(MappedFieldType, String)}  
            indexSearcher.getIndexReader(),
    }
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
            return builder.array("cardinality", cardinality);
 *  
     * and it's expected that these unsupported cases are exceptional rather than common  
    }
        int expectedCount,
        when(searchContext.fetchPhase()).thenReturn(new FetchPhase(Arrays.asList(new FetchSourcePhase(), new FetchDocValuesPhase())));  
import org.opensearch.search.aggregations.support.ValuesSourceType;
        MapperService mapperService,  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
        AggregatorFactory aggregatorFactory,
        }  
 * software distributed under the License is distributed on an
        @SuppressWarnings("unchecked")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            indexSearcher,
            public void onUse(Query query) {}  
    protected IndexSettings createIndexSettings() {  
            aggregationBuilder,
        );
     * wraps in the IndexSearcher's IndexReader with other implementations that we can't handle. (e.g. ParallelCompositeReader)
        }
        return new IndexSettings(
            return delegate.name();  
 * ownership. Elasticsearch licenses this file to you under  
            Arrays.stream(fieldTypes).filter(Objects::nonNull).collect(Collectors.toMap(MappedFieldType::name, Function.identity()))
            v = Math.abs(randomInt());
import org.opensearch.search.fetch.FetchPhase;  
import org.opensearch.index.mapper.RangeType;
            compositeIndexFieldInfo,
        IndexSettings indexSettings,
        List<Metric> supportedMetrics,
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
        IndexSearcher indexSearcher,
            int r = randomIntBetween(1, toReduceSize);  
    /**
import org.opensearch.index.mapper.FieldAliasMapper;
        throw new UnsupportedOperationException(
     */  
                protected boolean supportsConcurrentSegmentSearch() {
    public static AggregationBuilder aggCardinality(String name) {
import org.opensearch.index.query.QueryBuilder;
        }
                    }  
            FieldMapper mapper = (FieldMapper) builder.build(new BuilderContext(settings, new ContentPath()));  
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        Query query,  
import org.opensearch.core.index.Index;
        SearchContextAggregations searchContextAggregations = mock(SearchContextAggregations.class);
            int toReduceSize = aggs.size();
                queryBuilder,  
                throw new IllegalStateException("Unknown type of range [" + typeName + "]");  
        List<String> unsupportedMappedFieldTypes = unsupportedMappedFieldTypes();
            for (ShardSearcher subSearcher : subSearchers) {
import static java.util.Collections.singletonMap;
        boolean shardFanOut,
            json = "{ \"" + fieldName + "\" : \"" + v + "\" }";
        plugins.add(new AggCardinalityPlugin());
        private final AtomicInteger collectCounter;  
            InetAddress ip = randomIp(randomBoolean());
        public Object getProperty(List<String> path) {
        if (randomBoolean()) {
        }
     * <p>
import org.opensearch.index.shard.IndexShard;
            new NoneCircuitBreakerService(),
            for (ShardSearcher subSearcher : subSearchers) {
        private final CardinalityUpperBound cardinality;
        public CountingAggregator(AtomicInteger collectCounter, Aggregator delegate) {
            fieldTypes  
                end = RangeType.IP.nextUp(start);  
/**
            delegate.close();
            null,
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        if (aggTestThreadPool == null) {
    protected ScriptService getMockScriptService() {  
            throw new IllegalStateException("Unknown field type [" + typeName + "]");  
     * Collects all documents that match the provided query {@link Query} and
        return searchAndReduce(createIndexSettings(), searcher, query, builder, DEFAULT_MAX_BUCKETS, randomBoolean(), fieldTypes);
            }
                new AggregationSpec("agg_cardinality", in -> null, (ContextParser<String, AggCardinalityAggregationBuilder>) (p, c) -> null)  
        denylist.add(DerivedFieldMapper.CONTENT_TYPE); // TODO support derived fields
        public String toString() {
 * this work for additional information regarding copyright
import java.util.stream.Collectors;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        }  
     * Implementors should return a list of {@link ValuesSourceType} that the aggregator supports.
            this.delegate.setWeight(weight);
 */  
                        throw failure;
    }  
    public void testSupportedFieldTypes() throws IOException {  
            this.delegate = delegate;  
        boolean shardFanOut,
            Collections.shuffle(aggs, random());
public abstract class AggregatorTestCase extends OpenSearchTestCase {  
                continue;
            return new InternalAggCardinality(name, cardinality, metadata);  
        );
        return createAggregator(aggregationBuilder, searchContext);
    }
            doc.add(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(Collections.singleton(range))));
            when(searchContext.getQueryShardContext().fieldMapper(dimension.getField())).thenReturn(supportedDimensions.get(dimension));
     * {@link NestedAggregationBuilder}.  
        @Override  
            doc.add(new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(ip))));
            source.put("type", mappedType.getKey());
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(  
        AggregationBuilder builder,  
                                e  
        int maxBucket,
import static org.hamcrest.Matchers.instanceOf;
            throw new UnsupportedOperationException();  
     * Create a {@linkplain SearchContext} for testing an {@link Aggregator}.  
        return Collections.emptyList();
    /**
        IndexSettings indexSettings,  
     */
        Query query,
        final PipelineTree pipelines = builder.buildPipelineTree();
            final ShardSearcher[] subSearchers = new ShardSearcher[size];  
    ) throws IOException {  
        SearchContext searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);  
        AggregatorFactory aggregatorFactory,  
            } else if (typeName.equals(RangeType.LONG.typeName())) {
        IndexSettings indexSettings,
            supportedDimensions,  
    }
import org.opensearch.indices.IndicesBitsetFilterCache;  
            rootCount.postCollection();
     * @return an aggregation builder to test against the field
        MultiBucketConsumer bucketConsumer,  
            queryCachingPolicy,
import org.opensearch.index.mapper.CompletionFieldMapper;  
        @Override
        boolean assertCollectorEarlyTermination,
        }  
            when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] { aggregatorFactory });
        final IndexReaderContext ctx = searcher.getTopReaderContext();
                        @Override  
            fieldTypes
                getMockScriptService(),
        @SuppressWarnings("unchecked")  
            return new IndexAnalyzers(singletonMap(AnalysisRegistry.DEFAULT_ANALYZER_NAME, defaultAnalyzer), emptyMap(), emptyMap());
                C a = createAggregator(query, builder, subSearcher, indexSettings, shardBucketConsumer, fieldTypes);
            null,  
        return internalAgg;
            double lon = randomDouble();
                        }
import org.opensearch.index.query.QueryShardContext;  
        );  
                    maxBucket,  
    ) throws IOException {  
            throw new UnsupportedOperationException();
                            // TODO Auto-generated method stub  
            }  
        public void close() {  
     */
        return new CountingAggregator(new AtomicInteger(), createAggregator(aggregationBuilder, searchContext));
        boolean consolidated = starTreeQueryContext.consolidateAllFilters(searchContext);  
     * Throws an exception if it encounters an unknown field type, to prevent new ones from sneaking in without
                + "        \"gte\" : \""
        IndexSearcher searcher,
        }
import org.apache.lucene.util.BytesRef;
                                    + aggregationBuilder.getType()
            double lat = randomDouble();
import org.opensearch.Version;
            for (int searcherIDX = 0; searcherIDX < subSearchers.length; searcherIDX++) {
                );
        IndexSearcher searcher,  
            reduceBucketConsumer,
                return false;
    }
        @Override
        MappedFieldType... fieldTypes  
        @Override
import org.opensearch.search.internal.SearchContext;
        int maxBucket,  
            if (fieldType.isAggregatable() == false) {
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.analysis.AnalysisRegistry;  
                && mappedType.getKey().equals(MatchOnlyTextFieldMapper.CONTENT_TYPE) == false) {  
    ) throws IOException {
        return Collections.emptyMap();
        }  
import org.opensearch.index.shard.SearchOperationListener;
     * an exception _is not_ thrown when a field is unsupported, that will also fail the test.
import static org.hamcrest.Matchers.equalTo;
        return new DateFieldMapper.DateFieldType(name, resolution);
                Weight weight = subSearcher.createWeight(rewritten, ScoreMode.COMPLETE, 1f);
            return BucketCardinality.ONE;
        }  
            searchContext
            ThreadPool.terminate(aggTestThreadPool, 10, java.util.concurrent.TimeUnit.SECONDS);  
        CircuitBreakerService circuitBreakerService,  
    }
     * Allows subclasses to provide alternate names for the provided field type, which
    }  
            delegate.postCollection();
            .create(searchContext, null, CardinalityUpperBound.ONE);
import org.opensearch.index.fielddata.IndexFieldData;  
        MappedFieldType... fieldTypes
            maxBucket,
        private LeafBucketCollector selectedCollector;
        public final Aggregator delegate;
        query = query.rewrite(searcher);  
        try (Directory directory = newDirectory()) {
        StarTreeQueryContext starTreeQueryContext = new StarTreeQueryContext(searchContext, queryBuilder);
        when(searchContextAggregations.factories()).thenReturn(aggregatorFactories);
        MapperService mapperService,  
                getMockScriptService(),
    }
            json = "{ \"" + fieldName + "\" : \"" + NetworkAddress.format(ip) + "\" }";  
     * the test will check if an exception is thrown in that case.  
            if (typeName.equals(RangeType.DOUBLE.typeName())) {
        public BucketCardinality bucketCardinality() {
    /**  
        public void preCollection() throws IOException {
            assertThat(ctx, instanceOf(CompositeReaderContext.class));  
                    CardinalityUpperBound cardinality,
import org.opensearch.index.cache.query.DisabledQueryCache;
        BigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), circuitBreakerService).withCircuitBreaking();
    }  
            getMockScriptService(),
    private void writeTestDoc(MappedFieldType fieldType, String fieldName, RandomIndexWriter iw) throws IOException {
                BuilderContext context = new BuilderContext(indexSettings.getSettings(), new ContentPath());  
        AggregationBuilder builder,
        @SuppressWarnings("unchecked")
            () -> true,  
            return delegate.scoreMode();  
                json = "{ \"" + fieldName + "\" : \"" + d + "\" }";
        denylist.add(StarTreeMapper.CONTENT_TYPE); // TODO evaluate support for star tree fields  
        String json;  
     */
        A internalAgg = (A) aggs.get(0).reduce(aggs, context);
 * under the License.  
     * @return list of supported ValuesSourceTypes  
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        return searchAndReduce(indexSettings, searcher, query, builder, maxBucket, false, shardFanOut, fieldTypes);
        MultiBucketConsumer bucketConsumer,
        @Override
 * Licensed to Elasticsearch under one or more contributor  
        if (aggTestThreadPool != null) {
            return new RangeFieldMapper.RangeFieldType(name, RangeFieldMapper.Defaults.DATE_FORMATTER);
    protected ThreadPool aggTestThreadPool;
    }
        when(indexShard.getSearchOperationListener()).thenReturn(searchOperationListener);
                end = RangeType.DOUBLE.nextUp(start);  
            long v;
    ) throws IOException {
import org.opensearch.indices.mapper.MapperRegistry;
        return searchAndReduce(createIndexSettings(), searcher, query, builder, DEFAULT_MAX_BUCKETS, shardFanOut, fieldTypes);
    protected SearchContext createSearchContext(
        List<Metric> supportedMetrics,
        }
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        );
        List<SearchPlugin> plugins = new ArrayList<>(getSearchPlugins());
    }  
            List<InternalAggregation> toReduce = aggs.subList(0, r);
        IndexSettings indexSettings,
import org.opensearch.index.mapper.GeoShapeFieldMapper;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,  
            builder,  
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        IndexSettings indexSettings,
                        protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            bucketConsumer,  
        if (supportedVSTypes.isEmpty()) {
     * Make a {@linkplain NumberFieldMapper.NumberFieldType} for a {@code double}.  
     * can be useful when testing aggregations on field aliases.
import org.opensearch.index.mapper.BinaryFieldMapper;
        IndexSettings indexSettings,
                root.context().bigArrays(),  
 * KIND, either express or implied.  See the License for the
        public void search(Weight weight, Collector collector) throws IOException {
        }
        AggregatorFactories aggregatorFactories = mock(AggregatorFactories.class);
        }
    /**  
     *
            json = "{ \"" + fieldName + "\" : \"" + (v == 0 ? "false" : "true") + "\" }";  
            }  
        return createAggregator(query, aggregationBuilder, indexSearcher, createIndexSettings(), bucketConsumer, fieldTypes);
import org.apache.lucene.index.IndexReader;  
        countingAggregator.preCollection();
     */  
                starTree,
     * Make a {@linkplain DateFieldMapper.DateFieldType} for a {@code date}.
            queryBuilder,  
        }
        return createAggregator(
            getMockScriptService(),
            getIndexFieldDataLookup(mapperService, circuitBreakerService),
        Query query,
     * Override to wrap the {@linkplain DirectoryReader} for aggs like
        public InternalAggregation buildEmptyAggregation() {  
    /**  
            } else if (typeName.equals(RangeType.INTEGER.typeName())) {  
        customizeSearchContext.accept(searchContext);
                // smallest numeric is a byte so we select the smallest  
import static org.mockito.Mockito.when;
        public List<AggregationSpec> getAggregations() {
            InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forPartialReduction(
                    selectedCollector = delegate.getLeafCollector(ctx);  
import org.apache.lucene.search.IndexSearcher;
                protected Aggregator createInternal(
    /**
                                "Aggregator ["
    }
import java.util.Objects;  
            final ShardSearcher[] subSearchers = new ShardSearcher[size];  
        ).build(new IndexFieldDataCache.None(), circuitBreakerService);  
                subSearcher.search(weight, a);  
                @Override  
            0,  
    private static class AggCardinalityAggregationBuilder extends AbstractAggregationBuilder<AggCardinalityAggregationBuilder> {  
        }  
         */
                    return true;
import org.opensearch.index.compositeindex.datacube.Dimension;
     * Added to randomly run with more assertions on the index reader level,
        when(searchContext.searcher()).thenReturn(contextIndexSearcher);
        for (PipelineAggregator pipelineAggregator : pipelines.aggregators()) {
        when(searchContext.mapperService()).thenReturn(mapperService);  
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
        SearchOperationListener searchOperationListener = new SearchOperationListener() {  
    protected <A extends Aggregator> A createAggregator(AggregationBuilder aggregationBuilder, SearchContext searchContext)
        }
            searcher,
     * like {@link org.apache.lucene.tests.util.LuceneTestCase#wrapReader(IndexReader)}, which can't be used because it also
    }
    protected List<SearchPlugin> getSearchPlugins() {
        .add(new SortedSetDocValuesField(field, new BytesRef(value)));  
     */
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException {
            buildIndex.accept(indexWriter);
            if (mappedType.getKey().equals(TextFieldMapper.CONTENT_TYPE) == false
                start = randomFloat();  
    }  
        public Settings getSettings() {  
import org.opensearch.index.mapper.Mapper;
                + "\" : { \n"
            query,  
        }  
        int maxBucket,
        MappedFieldType... fieldTypes
        } else if (vst.equals(CoreValuesSourceType.RANGE)) {
                float f = Math.abs(randomFloat());  
         * we're passed gets a chance to break.  
     * results together. The other half the time it aggregates across the entire  
            v = randomBoolean() ? 0 : 1;
        CompositeIndexFieldInfo starTree,
        Set<CompositeMappedFieldType> compositeFieldTypes = Set.of(compositeMappedFieldType);
        MapperRegistry mapperRegistry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
                aggregatorFactory,
        Consumer<V> verify,
                AnalyzerScope.GLOBAL,
    public void initValuesSourceRegistry() {  
        }
        when((compositeMappedFieldType).getDimensions()).thenReturn(new ArrayList<>(supportedDimensions.keySet()));  
        QueryBuilder queryBuilder,
            pipelines  
    }
    protected IndicesBitsetFilterCache aggTestIndicesBitsetFilterCache;  
    protected <A extends Aggregator> A createAggregatorWithCustomizableSearchContext(  
        Map<String, MappedFieldType> fieldNameToType = new HashMap<>();  
        List<ValuesSourceType> supportedVSTypes = getSupportedValuesSourceTypes();
    }  
     * which must also be implemented.  
            hasNested,  
    protected QueryShardContext queryShardContextMock(
        SearchContext searchContext = mock(SearchContext.class);
                double d = Math.abs(randomDouble());
        }
                    Aggregator parent,
        MultiBucketConsumer bucketConsumer,
                                    + fieldType.typeName()
     */
        // now do the final reduce  
            this.collectCounter = collectCounter;
        A internalAgg = (A) aggs.get(0).reduce(aggs, context);
        }
        CircuitBreakerService circuitBreakerService,
        String fieldName = "typeTestFieldName";  
            // Some field types should not be tested, or require more work and are not ready yet
                bucketConsumer,
import org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;
            maxBucket,
import org.opensearch.index.fielddata.IndexFieldDataCache;
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            pipelines  
        }
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
     * returns the reduced {@link InternalAggregation}.  
            when(aggregatorFactories.getFactories()).thenReturn(new AggregatorFactory[] {});
    /**
     * like {@link org.apache.lucene.tests.util.LuceneTestCase#newSearcher(IndexReader)}, which can't be used because it also  
            final int size = compCTX.leaves().size();
     * @param fieldType the type of the field that will be tested
            when(mapperService.fieldType(fieldName)).thenReturn(fieldType);
        /*
     */
        }
        @Override
            };
        return internalAgg;  
        }
        return searchAndReduce(indexSettings, searcher, query, builder, DEFAULT_MAX_BUCKETS, randomBoolean(), fieldTypes);  
    ) {
            return true;
        final IndexReaderContext ctx = searcher.getTopReaderContext();
import org.apache.lucene.document.Field;  
            fieldTypes
        }
                indexSettings,
                verify.accept(agg);
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
            }  
import org.opensearch.common.lease.Releasables;
        AggregationBuilder builder,  
    private void cleanupReleasables() {
                    AssertionError failure = null;
            IndexMetadata.builder("_index")
            try (Directory directory = newDirectory()) {  
        final PipelineTree pipelines = builder.buildPipelineTree();  
    }
    }
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader indexReader = wrapDirectoryReader(unwrapped)) {
        doAssertReducedMultiBucketConsumer(internalAgg, reduceBucketConsumer);
        IndexSettings indexSettings,  
     */
            return singletonList(
        }
        Query query,  
        IndexSearcher searcher,
            query = Queries.filtered(query, Queries.newNonNestedFilter());  
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduceCounting(  
            final RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType, start, end, true, true);  
        @Override  
        int totalCollectCount = 0;  
            return;  
    /**
            valuesSourceRegistry
                boolean v4 = randomBoolean();
        IndexSearcher searcher,
     */
        return searchAndReduceStarTree(
import org.opensearch.index.mapper.RangeFieldMapper;  
import org.opensearch.common.TriFunction;
        MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumer(
        @Override
                end = RangeType.INTEGER.nextUp(start);
        IndexSettings indexSettings,
                totalCollectCount += aCount.getCollectCount().get();
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
    private static class ShardSearcher extends IndexSearcher {  
import static org.mockito.ArgumentMatchers.any;  
     */
            null,  
        if (hasNested) {
 * the Apache License, Version 2.0 (the "License"); you may
    protected static IndexReader maybeWrapReaderEs(DirectoryReader reader) throws IOException {
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {  
                aCount.preCollection();  
        IndexSearcher indexSearcher,  
    }
        if (compositeIndexFieldInfo != null && assertCollectorEarlyTermination) {  
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
        for (PipelineAggregator pipelineAggregator : pipelines.aggregators()) {
        MultiBucketConsumer bucketConsumer,
        }  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,  
            query,
        }  
        doAssertReducedMultiBucketConsumer(internalAgg, reduceBucketConsumer);
            return new LeafBucketCollector() {  
                            return LeafBucketCollector.NO_OP_COLLECTOR;
     */
    protected NumberFieldMapper.NumberFieldType longField(String name) {
        }  
                    return new MetricsAggregator(name, searchContext, parent, metadata) {
        }  
        return null;
            if (typeName.equals(NumberFieldMapper.NumberType.DOUBLE.typeName())) {
            indexSearcher,
        @Override  
        CardinalityUpperBound cardinality,  
        CircuitBreakerService circuitBreakerService
                            );
                            );  
        QueryBuilder queryBuilder,  
                AnalysisRegistry.DEFAULT_ANALYZER_NAME,
        });
    ) throws IOException {  
        );  
            new org.opensearch.search.aggregations.metrics.CardinalityAggregationContext(false, Runtime.getRuntime().maxMemory() / 100)  
import org.apache.lucene.sandbox.document.HalfFloatPoint;  
        // Once all aggs implement this method we should make it abstract and not allow skipping.
import org.opensearch.index.mapper.KeywordFieldMapper;  
        } else {
        }
                        }
                // Generate a random float that respects the limits of half float
        AggregationBuilder builder,
        throws IOException {  
        when(mapperService.hasNested()).thenReturn(false);
    protected SearchContext createSearchContext(
        aggs.add(countingAggregator.buildTopLevel());
        AggregationBuilder builder,
import org.opensearch.index.mapper.GeoPointFieldMapper;
        }  
        };
            return new AggregatorFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata) {  
     * @param fieldName the name of the field that will be test  
            return new IndexSearcher(indexReader);
    }
        SearchContext searchContext;  
        );
import org.opensearch.cluster.metadata.IndexMetadata;
    protected static IndexSearcher newIndexSearcher(IndexReader indexReader) {  
        );
            return delegate.subAggregator(name);  
        List<InternalAggregation> aggs = new ArrayList<>();  
        when(searchContext.cardinalityAggregationContext()).thenReturn(
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduceStarTree(
                () -> PipelineAggregator.PipelineTree.EMPTY
        }  
        if (skipReducedMultiBucketConsumerAssertion == false) doAssertReducedMultiBucketConsumer(internalAgg, reduceBucketConsumer);
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            }
        internalAgg = (A) internalAgg.reducePipelines(internalAgg, context, pipelines);
        if (aggregatorFactory != null) {
            this.cardinality = cardinality;
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        }
    }  
import java.util.ArrayList;
            aggs.add(reduced);  
        }  
        if (shardFanOut && searcher.getIndexReader().leaves().size() > 0) {
        }
            aggTestIndicesBitsetFilterCache.close();
                                    + "] should not support field type ["  
        return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);  
import org.opensearch.index.mapper.Mapper.BuilderContext;  
        doAnswer(invocation -> {  
        );  
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
        Query query,
    }
import java.util.Map;
                subSearchers[searcherIDX] = new ShardSearcher(partition, compCTX);
        when(searchContext.maxAggRewriteFilters()).thenReturn(10_000);  
import org.opensearch.index.mapper.TextFieldMapper;
            null,
        IndexSettings indexSettings,
            internalAgg = (A) pipelineAggregator.reduce(internalAgg, context);
            getMockScriptService(),
            return null;  
    ) {  
        MappedFieldType... fieldTypes  
    /**
                end = RangeType.DATE.nextUp(start);  
            RangeType rangeType;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    }  
    ) throws IOException {
            return delegate.buildEmptyAggregation();
    protected SearchContext createSearchContextWithStarTreeContext(  
     */  
        when(searchContext.bitsetFilterCache()).thenReturn(
        Query query,
                    try {  
            return Settings.EMPTY;
        Query query,
        if (consolidated) {
 * Unless required by applicable law or agreed to in writing,
            return null;
                .build(),
                    // TODO in the future we can make this more explicit with expectThrows(), when the exceptions are standardized
        return createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, new NoneCircuitBreakerService(), fieldTypes);  
            if (typeName.equals(BinaryFieldMapper.CONTENT_TYPE)) {
        CompositeIndexFieldInfo compositeIndexFieldInfo,
            .create(searchContext, null, cardinality);
    ) throws IOException {
import org.opensearch.search.startree.StarTreeQueryContext;  
        Query query,  
 */
        return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);  
            long v;  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, plugins);  
import org.opensearch.index.IndexSettings;
            new MultiBucketConsumer(DEFAULT_MAX_BUCKETS, new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)),
            null,  
            super(name, metadata);
            indexSearcher,  
        @Override  
            if (mappedType.getKey().equals(ConstantKeywordFieldMapper.CONTENT_TYPE) == true) {
        }  
            xContentRegistry(),
            searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);  
                end = RangeType.FLOAT.nextUp(start);
        }  
        }
        int maxBucket,
    }
            false,
            Collections.shuffle(aggs, random());
            searchLookup
                source.put("value", "default_value");
                final LeafReaderContextPartition partition = LeafReaderContextPartition.createForEntireSegment(
            supportedMetrics,
     * This method is invoked each time a field type is tested in {@link AggregatorTestCase#testSupportedFieldTypes()}.  
        boolean hasNested,  
    ) throws IOException {
        int maxBucket,  
        MockParserContext() {
                rangeType = RangeType.DOUBLE;
        final IndexReaderContext ctx = searcher.getTopReaderContext();
     * that are registered in {@link IndicesModule} (e.g. all the core field types).  An aggregator
import org.apache.lucene.search.Query;
                + "        \"lte\" : \""
            }  
        return mock(MapperService.class);
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        MultiBucketConsumer bucketConsumer,
            return new AssertingIndexSearcher(random(), indexReader);  
        QueryBuilder queryBuilder,
            maxBucket,
        ShardSearcher(LeafReaderContextPartition partition, IndexReaderContext parent) {  
import org.opensearch.index.analysis.NamedAnalyzer;  
            aggs = new ArrayList<>(aggs.subList(r, toReduceSize));
        document.add(new StringField(field, value, Field.Store.NO));
    protected DateFieldMapper.DateFieldType dateField(String name, DateFieldMapper.Resolution resolution) {
        releasables.clear();  
        when((compositeMappedFieldType).getMetrics()).thenReturn(supportedMetrics);
     * Half the time it aggregates each leaf individually and reduces all
                }  
        MappedFieldType... fieldTypes
import static org.mockito.ArgumentMatchers.anyString;
            bigArrays  
        } else {
        public String getType() {  
                aggs.add(aCount.buildTopLevel());
            final int size = compCTX.leaves().size();
        AggregatorFactory aggregatorFactory,
        C root = createAggregator(query, builder, searcher, indexSettings, bucketConsumer, fieldTypes);  
            int toReduceSize = aggs.size();
        MultiBucketConsumer bucketConsumer,
        A aggregator = (A) aggregationBuilder.rewrite(searchContext.getQueryShardContext())  
                    if (failure != null) {
import org.opensearch.core.xcontent.XContentBuilder;
            searchContext.getQueryShardContext().setStarTreeQueryContext(starTreeQueryContext);
        } else {  
    }  
            fieldTypes  
        }
        @Override
 */
import java.util.stream.Stream;
import org.opensearch.core.xcontent.ContextParser;  
        fieldNameToType.putAll(
        when(searchContext.getFlushMode()).thenReturn(FlushMode.PER_SEGMENT);
        AggregationBuilder aggregationBuilder,  
            root.context().bigArrays(),  
        return Collections.emptyList();
                fieldTypes  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
            circuitBreakerService,
    protected CountingAggregator createCountingAggregator(
import org.opensearch.index.mapper.NumberFieldMapper;  
import java.util.Arrays;  
                + end  
                indexSearcher,  
            }
     * Wrapper around Aggregator class
                doc.add(new SortedSetDocValuesField(fieldName, new BytesRef("a")));
            );
                );  
        document.add(new SortedSetDocValuesField(field, new BytesRef(value)));  
                V agg = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldTypes);
import org.apache.lucene.search.QueryCachingPolicy;
                json = "{ \"" + fieldName + "\" : \"" + f + "\" }";
        MappedFieldType... fieldTypes
        }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
import org.opensearch.search.internal.ContextIndexSearcher;  
        SearchContext searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);
import org.opensearch.index.mapper.ContentPath;
        Query query,
                v = Math.abs(randomByte());
                a.preCollection();
            // If the test says it doesn't support any VStypes, it has not been converted yet so skip
             * close their sub-aggregations. This is fairly similar to what the production code does. */
    /**
package org.opensearch.search.aggregations;
     * <p>  
                + "      }}";
            return delegate.buildAggregations(owningBucketOrds);
import org.opensearch.common.util.MockPageCacheRecycler;
        List<Metric> supportedMetrics,
    protected GeoPointFieldMapper.GeoPointFieldType geoPointField(String name) {  
                                    + fieldType.typeName()
        denylist.add(GeoShapeFieldMapper.CONTENT_TYPE); // Cannot aggregate geoshapes (yet)
        if (shardFanOut && searcher.getIndexReader().leaves().size() > 0) {
            indexSearcher,
        } else if (vst.equals(CoreValuesSourceType.GEOPOINT)) {  
                        @Override
            bucketConsumer,  
                    compCTX.leaves().get(searcherIDX)  
            return delegate.context();
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        );
        if (maxBucket == -1) {
        QueryBuilder queryBuilder,  
    private class MockParserContext extends Mapper.TypeParser.ParserContext {  
        }  
     * and verify it works (or doesn't) as expected.
        boolean hasNested,  
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(  
                rangeType = RangeType.INTEGER;  
import java.util.List;
        iw.addDocument(doc);  
            aggs = new ArrayList<>(aggs.subList(r, toReduceSize));
        when(searchContext.isStreamSearch()).thenReturn(true);
import org.opensearch.test.OpenSearchTestCase;  
            mapperService,
                                    + "] supports field type ["
            query,
                continue;  
import org.junit.After;  
    public static class InternalAggCardinality extends InternalAggregation {  
        MultiBucketConsumer bucketConsumer,
        if (rangeType == RangeType.DATE) {
         * Always use the circuit breaking big arrays instance so that the CircuitBreakerService
                rangeType = RangeType.IP;
    private ValuesSourceType fieldToVST(MappedFieldType fieldType) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduce(
 *
                end = RangeType.LONG.nextUp(start);
            fieldTypes
            contextIndexSearcher,
import org.opensearch.index.mapper.CompositeMappedFieldType;
            searcher,
            doc.add(new SortedNumericDocValuesField(fieldName, v));
import org.opensearch.common.network.NetworkAddress;
            return "agg_cardinality";
    ) {
        );  
        MappedFieldType... fieldTypes
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
     * The AggBuilder should be returned even if the aggregation does not support the field type, because
                rangeType = RangeType.DOUBLE;
        @Override
        when(compositeMappedFieldType.name()).thenReturn(starTree.getField());
            bigArrays,
        }
    }
            /* Store the release-ables so we can release them at the end of the test case. This is important because aggregations don't
            final CompositeReaderContext compCTX = (CompositeReaderContext) ctx;
                    compCTX.leaves().get(searcherIDX)  
        // materialize any sibling pipelines at top level  
            null,
        C root = createAggregator(query, builder, searcher, bucketConsumer, fieldTypes);
        AggregationBuilder aggregationBuilder,
        for (Map.Entry<String, Mapper.TypeParser> mappedType : mapperRegistry.getMapperParsers().entrySet()) {  
                json = "{ \"" + fieldName + "\" : \"" + v + "\" }";
        IndexSearcher indexSearcher,  
    protected NumberFieldMapper.NumberFieldType doubleField(String name) {
        searcher.search(query, countingAggregator);  
import org.apache.lucene.search.IndexSearcher.LeafReaderContextPartition;  
                + fieldName  
    protected <A extends Aggregator> A createStreamAggregator(  
            .build(searchContext.getQueryShardContext(), null)
import org.opensearch.core.index.shard.ShardId;  
     */
        IndexSearcher indexSearcher,
import java.util.LinkedHashMap;  
        // now do the final reduce  
            return delegate.parent();
            aggregatorFactory,
            CardinalityUpperBound.ONE,
            indexSearcher.getSimilarity(),
                final LeafReaderContextPartition partition = LeafReaderContextPartition.createForEntireSegment(
    }
                + "\",\n"
        }
            aggregationBuilder,  
        }
        denylist.add(ObjectMapper.CONTENT_TYPE); // Cannot aggregate objects  
    }
     * is provided by the implementor class, and it is executed against each field type in turn.  If  
        when(searchContext.aggregations()).thenReturn(new SearchContextAggregations(AggregatorFactories.EMPTY, bucketConsumer));  
        IndexSearcher indexSearcher,
        IndexSearcher searcher,
            }  
                start = randomInt();
    }
            indexSettings,
    private static List<String> TYPE_TEST_DENYLIST;  
import org.apache.lucene.document.SortedSetDocValuesField;
    protected <T extends AggregationBuilder, V extends InternalAggregation> void testCase(
        MappedFieldType... fieldTypes
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        SearchContext searchContext = createSearchContext(  
        A internalAgg = (A) aggs.get(0).reduce(aggs, context);
    ) throws IOException {
 */
        Query query,
    }  
        QueryCache queryCache = new DisabledQueryCache(indexSettings);  
        IndexSearcher searcher,
import org.opensearch.threadpool.ThreadPool;
        SearchContext searchContext = createSearchContext(indexSearcher, indexSettings, query, bucketConsumer, fieldTypes);  
import org.opensearch.common.lease.Releasable;  
        return internalAgg;
        IndexSettings indexSettings,
     * Half the time it aggregates each leaf individually and reduces all  
            int r = randomIntBetween(1, toReduceSize);  
    private static void registerFieldTypes(
        public AtomicInteger getCollectCount() {  
            false,  
                @Override
                subSearcher.search(weight, aCount);
            createIndexSettings(),
        Query query,  
 *
        // TODO: now just needed for top_hits, this will need to be revised for other agg unit tests:
            super(name);  
import java.util.concurrent.atomic.AtomicInteger;
        // If aggs don't override this method, an empty list allows the test to be skipped.  
            root.preCollection();
        denylist.add(ContextAwareGroupingFieldMapper.CONTENT_TYPE); // Cannot aggregate context aware groupings
     * <p>
            System::currentTimeMillis,  
        MappedFieldType... fieldTypes
            aggregatorFactory,
        for (Map.Entry<String, MappedFieldType> entry : fieldNameToType.entrySet()) {
            @Override
        if (aggTestIndicesBitsetFilterCache != null) {
     *
            maxBucket,  
        Settings settings = Settings.builder().put("index.version.created", Version.CURRENT.id).build();
        return aggregator;  
        List<Metric> supportedMetrics,
                rangeType = RangeType.DATE;
                MultiBucketConsumer shardBucketConsumer = new MultiBucketConsumer(
            super(parent);
            aggs.add(rootCount.buildTopLevel());
        boolean skipReducedMultiBucketConsumerAssertion,  
        public void setWeight(Weight weight) {
        public ScoreMode scoreMode() {
        }
        @Override
    }  
        private final LeafReaderContextPartition[] partitions;
        MultiBucketConsumer bucketConsumer,
     * <p>
        @SuppressWarnings("unchecked")  
     * Request an aggregation that returns the {@link CardinalityUpperBound}
 * compatible open source license.
    }
        List<String> denylist = new ArrayList<>();
        fieldNameToType.putAll(getFieldAliases(fieldTypes));
        MappedFieldType... fieldTypes
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,  
            }  
        return createStreamAggregator(
            totalCollectCount = rootCount.getCollectCount().get();  
            A reduced = (A) aggs.get(0).reduce(toReduce, context);
    };
        CountingAggregator countingAggregator = createCountingAggregator(  
        when(mapperService.getCompositeFieldTypes()).thenReturn(compositeFieldTypes);  
import org.apache.lucene.index.IndexReaderContext;
        }  
    protected <A extends Aggregator> A createAggregator(
    }  
            queryBuilder,
    /**
     * The field type and name are provided, and the implementor is expected to return an AggBuilder accordingly.
        MappedFieldType... fieldTypes  
    /**  
     */
        if (randomBoolean() && aggs.size() > 1) {
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,  
                                    + e.getMessage()
            internalAgg = (A) pipelineAggregator.reduce(internalAgg, context);
            pipelines  
                public void collect(int doc, long bucket) throws IOException {
    ) throws IOException {
        List<InternalAggregation> aggs = new ArrayList<>();  
                                    + "]",
        CompositeDataCubeFieldType compositeMappedFieldType = mock(CompositeDataCubeFieldType.class);
import org.junit.Before;
        IndexSearcher indexSearcher,
                .numberOfReplicas(0)
    protected static DirectoryReader wrapInMockESDirectoryReader(DirectoryReader directoryReader) throws IOException {  
                    ValuesSourceType vst = fieldToVST(fieldType);  
        AggregationBuilder builder,
            builder,
                new StandardAnalyzer()  
        Query query,
        T aggregationBuilder,
            Settings.EMPTY
    }
/*
            aggs.add(reduced);  
        return createAggregator(
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.singletonList;
            doc.add(new LatLonDocValuesField(fieldName, lat, lon));  
        IndexSettings indexSettings,  
            mapperService.getIndexSettings().getIndex().getName(),
                // never cache a query
        AggCardinalityAggregationBuilder(String name) {
                .numberOfShards(1)
     * Helper method to write a single document with a single value specific to the requested fieldType.
        MultiBucketConsumer bucketConsumer = new MultiBucketConsumer(
        Query query,
        denylist.add(CompletionFieldMapper.CONTENT_TYPE); // TODO support completion  
            aggregations.forEach(ia -> { assertThat(((InternalAggCardinality) ia).cardinality, equalTo(cardinality)); });
    ) throws IOException {
        return new KeywordFieldMapper.KeywordFieldType(name);
        IndexSearcher searcher,
    }  
        AggregationBuilder aggregationBuilder,
                            failure = new AssertionError(  
                return new ObjectMapper.Builder<>(fieldName).nested(Nested.newNested()).build(context);
        protected void doWriteTo(StreamOutput out) throws IOException {  
import java.io.IOException;  
     * This test will validate that an aggregator succeeds or fails to run against all the field types
    protected <A extends InternalAggregation, C extends Aggregator> A searchAndReduceStarTree(
            );
import org.opensearch.search.lookup.SearchLookup;
        return createAggregator(null, aggregationBuilder, indexSearcher, indexSettings, bucketConsumer, fieldTypes);
        denylist.add(FieldAliasMapper.CONTENT_TYPE); // TODO support alias
    ) throws IOException {
        MappedFieldType... fieldTypes
     * The list of supported types are provided by {@link AggregatorTestCase#getSupportedValuesSourceTypes()},
        IndexSettings indexSettings,
    protected IndexReader wrapDirectoryReader(DirectoryReader reader) throws IOException {
        return searchContext;
            public boolean shouldCache(Query query) {  
            indexSettings,
        public CardinalityUpperBound cardinality() {
import org.apache.lucene.index.CompositeReaderContext;
    ) throws IOException {
            Map<String, Object> source = new HashMap<>();
                        }  
    /**  
     * A method that allows implementors to specifically denylist particular field types (based on their content_name).
            // sometimes do an incremental reduce  
            @Override
        MultiBucketConsumer bucketConsumer,
    }
    @Before
        } else if (vst.equals(CoreValuesSourceType.BOOLEAN)) {
            MappedFieldType fieldType = entry.getValue();  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
