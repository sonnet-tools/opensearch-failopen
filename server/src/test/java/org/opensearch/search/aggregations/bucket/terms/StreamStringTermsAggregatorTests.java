            public long addWithoutBreaking(long bytes) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                }
                        LeafBucketCollector.NO_OP_COLLECTOR
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    private static Aggregator wrapByProfilingAgg(Aggregator aggregator) throws IOException {
                    indexWriter1.addDocument(doc);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
                    // Parent 1 saw the banana + cherry docs.
                indexWriter.addDocument(document);
                    assertThat(p0Buckets.get(0).getKeyAsString(), equalTo("apple"));
                // Create 10 categories where TOP 3 by max ASC won't be alphabetically first
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_b"));
                    aggregator.postCollection();
        try (Directory directory = newDirectory()) {
        searcher.search(new MatchAllDocsQuery(), aggregator);
                        aggregationBuilder,
                            .creationDate(System.currentTimeMillis())
                    IndexSettings indexSettings = new IndexSettings(
                        ),
            }
                    );
                indexWriter.addDocument(doc2);
                }
    public void testSubAggregationWithSum() throws Exception {
                    ContextIndexSearcher contextIndexSearcher = searchContext.searcher();
                    aggregator.postCollection();
                    assertThat(minHumidity.getValue(), equalTo(60.0));
            }
            @Override
                    assertThat(max1.getValue(), equalTo(204.0));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(laptopBucket, notNullValue());
    }
                    SearchShardTask task = new SearchShardTask(0, "n/a", "n/a", "test-kind", null, null);
    }
                document.add(new SortedSetDocValuesField("field", new BytesRef("batch1")));
                    aggregator.postCollection();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    assertThat(
                            && !firstBucket.getKeyAsString().equals(secondBucket.getKeyAsString())
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    );
                    }
                            DEFAULT_MAX_BUCKETS,
                        ),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
            }
                indexWriter.addDocument(document);
                            .settings(
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                    assertThat(avgTemp.getValue(), equalTo(35.0));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        try (Directory directory = newDirectory()) {
 */
                    assertThat(result, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(result.getBuckets().size(), equalTo(3));
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            DEFAULT_MAX_BUCKETS,
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        salesFieldType
import static org.mockito.Mockito.doAnswer;
                    searchContext.setTask(task);
                            .settings(
                    }).when(listenerMock).onStreamResponse(any(), anyBoolean());
                        .size(5)
                            .numberOfReplicas(0)
                    assertThat(buckets.get(0).getDocCount(), equalTo(2L));
                        fieldType
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher2)
                // Create 10 categories with varying max values (size=3, total=10)
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                        indexSearcher,
            }
                Document document = new Document();
                            .build(),
                document.add(new SortedSetDocValuesField("field", new BytesRef("rare")));
                    // term_1 appears in docs 1,4,7 = 3 times
                    int uniqueUsers = (i + 1) * 2;
                            .numberOfShards(1)
                        categoryFieldType,
                }
            assertThat(clothingBucket, notNullValue());
                    doc.add(new NumericDocValuesField("value", (i + 1) * 100));
                indexWriter.addDocument(document);
                        .findFirst()
        }
                        indexSettings,
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                            .numberOfShards(1)
                    assertThat(result.getBuckets().size(), equalTo(2));
                    assertThat(cherry, notNullValue());
                    aggregator.postCollection();
                BiConsumer<String, Object> debugCollector = debugInfo::put;
                }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                // Alphabetically: aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii, jjj
                    aggregator.postCollection();
                    assertThat(result.getBuckets().size(), equalTo(2));
                    );
                    final List<InternalAggregations> perSegAggs = new ArrayList<>();
                        aggregationBuilder,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            }
                    contextIndexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.opensearch.action.support.StreamSearchChannelListener;
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertThat(result.getBuckets().size(), equalTo(0));
                    SearchContext searchContext = createSearchContext(
                }
                        .filter(b -> b.getKeyAsString().equals("banana"))
                    assertThat(term2Bucket, notNullValue());
                document.add(new SortedSetDocValuesField("field", new BytesRef("rare")));
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        if (fieldType2 != null) {
                    document.add(new SortedSetDocValuesField("field", new BytesRef("common")));
                        "parent 0 and parent 1 must produce distinct inner bucket sets",
                    StringTerms topLevel = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        createIndexSettings(),
                            DEFAULT_MAX_BUCKETS,
                        fieldType
                            DEFAULT_MAX_BUCKETS,
                        .findFirst()
                    aggregator.preCollection();
                    InternalAggregations summary = InternalAggregations.reduce(perSegAggs, ctx);
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    // Verify otherDocCount: cat_0=1 + cat_1=2 = 3 docs excluded
                    aggs.add(
                            .creationDate(System.currentTimeMillis())
                            DEFAULT_MAX_BUCKETS,
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    fieldType
                // Alphabetically: aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii, jjj
        try (Directory directory = newDirectory()) {
                }
        }
import static org.hamcrest.Matchers.notNullValue;
                assertTrue("Should contain segments_with_single_valued_ords", debugInfo.containsKey("segments_with_single_valued_ords"));
                breakAllocations.set(true);
import org.opensearch.search.streaming.FlushMode;
                indexWriter.addDocument(document);
                    when(searchContext.fetchResult()).thenReturn(new FetchSearchResult());
                doc = new Document();
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    // Verify otherDocCount: 10 categories * 5 docs = 50 total, selected 3*5=15, other=35
                    for (int j = 0; j < numDocs; j++) {
                        .order(BucketOrder.key(true));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
                    assertThat(card0.getValue(), equalTo(6L));
        try (Directory directory = newDirectory()) {
                        .stream()
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_8"));
                        ),
                    StringTerms.Bucket thirdBucket = buckets.get(2);
                        .orElse(null);
                    assertThat(thirdBucket.getDocCount(), equalTo(1L));
                    StringTerms.Bucket booksBucket = result.getBuckets()
                        ),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    Document document = new Document();
                // cat_z=2, cat_y=4, cat_x=6, cat_a=8, cat_b=10, cat_c=12, cat_d=14, cat_e=16, cat_f=18, cat_g=20
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_3"));
                        aggregationBuilder,
                            .settings(
                            Integer.MAX_VALUE,
                    aggregator.preCollection();
                    Cardinality card4 = buckets.get(4).getAggregations().get("unique_users");
                        PipelineTree.EMPTY
                        fieldType
                if (breakAllocations.get()) {
                    assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                    assertThat(booksBucket.getDocCount(), equalTo(1L));
                    for (StringTerms.Bucket bucket : result.getBuckets()) {
                indexWriter.addDocument(document);
                    StringTerms firstBatch = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    );
                for (int i = 3; i < 8; i++) {
                    leafCollector.collect(3, 1L);
        try (Directory directory = newDirectory()) {
                // By count: jjj(100), iii(90), hhh(80), ggg(70), fff(60), aaa(50), bbb(40), ccc(30), ddd(20), eee(10)
                    assertThat(result, notNullValue());
        try (Directory directory = newDirectory()) {
                    aggregator.preCollection();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").minDocCount(3);
 * The OpenSearch Contributors require contributions made to
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .findFirst()
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("fff"));
public class StreamStringTermsAggregatorTests extends AggregatorTestCase {
    }
                        .size(3)
                    assertThat(max1.getValue(), equalTo(904.0));
                }
                    StringTerms firstResult = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    }
                indexWriter.addDocument(doc3);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                document = new Document();
                        null,
                }
                    );
                        createIndexSettings(),
                    IndexSettings indexSettings = new IndexSettings(
        IndexSearcher searcher
                    indexWriter.addDocument(document);
                        .orElse(null);
                    assertThat(totalHumidity.getValue(), equalTo(80.0));
        AggregationProfiler aggregationProfiler = mock(AggregationProfiler.class);
                        .findFirst()
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(secondBucket.getDocCount(), equalTo(2L));
                            .settings(
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        indexSearcher,
                        indexSearcher,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        aggregationBuilder,
import org.opensearch.search.profile.aggregation.AggregationProfileBreakdown;
                    assertThat(minInventory.getValue(), equalTo(200.0));
                document.add(new NumericDocValuesField("sales", 1000));
                                Settings.builder()
                        .shardSize(5)
                    assertThat(storeBBucket.getDocCount(), equalTo(1L));
                boolean isSegmented = false;
                    aggregator.preCollection();
            // Second aggregation with different terms
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    aggregationBuilder,
            for (StringTerms.Bucket bucket : terms.getBuckets()) {
                        null,
                    }
                            )
                }
                    StreamSearchChannelListener listenerMock = mock(StreamSearchChannelListener.class);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    LeafBucketCollector leafCollector = aggregator.getLeafCollector(
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                    assertThat(result.getBuckets().size(), equalTo(3));
    }
    }
                        aggregationBuilder,
                    assertThat(card3.getValue(), equalTo(18L));
 * compatible open source license.
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    IndexSettings indexSettings = new IndexSettings(
                    for (int j = 0; j < numDocs; j++) {
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("medium"));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    StringTerms secondResult = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_2"));
        }
                // By count: zzz(100), yyy(90), xxx(80), www(70), vvv(60), aaa(50), bbb(40), ccc(30), ddd(20), eee(10)
                        .stream()
    public void testBuildAggregationsBatchDirectBucketCreation() throws Exception {
                        null,
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            StringTerms terms = (StringTerms) reduced;
    public void testCandidateBucketsUseRequestCircuitBreaker() throws Exception {
                    assertThat(card2.getValue(), equalTo(16L));
                indexWriter2.addDocument(doc);
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("ggg"));
                indexWriter.addDocument(document);
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
    public void testReduceSimple() throws Exception {
                indexWriter.addDocument(document);
                    assertThat(max2.getValue(), equalTo(1000.0));
                        Settings.EMPTY
                    // Returned in alphabetical order at shard level
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                        ),
        }
                }
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("iii"));
            @Override
                    indexWriter.addDocument(doc);
                        DEFAULT_MAX_BUCKETS,
                Document doc = new Document();
                    StringTerms.Bucket term0Bucket = buckets.stream()
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        .stream()
                    assertThat(result, notNullValue());
     * Reproduces the bug where {@link StreamStringTermsAggregator} ignores the
                        QuerySearchResult querySearchResult = ((QueryFetchSearchResult) invok.getArgument(0, TransportResponse.class))
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                // Add multiple documents with different categories to test reduce logic properly
                    if (profile) {
                }
                        tempFieldType,
                        isSegmented = true;
                        "First two buckets should be electronics and books",
                        new MultiBucketConsumerService.MultiBucketConsumer(
                // cat_z=100, cat_y=200, cat_x=300, cat_a=400, ...
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    indexWriter.addDocument(document);
    public void testBuildAggregationsWithContextSearcherNoProfile() throws Exception {
                        indexSearcher,
                    }
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
        CircuitBreakerService breakerService = mock(CircuitBreakerService.class);
                        .filter(bucket -> bucket.getKeyAsString().equals("term_2"))
                    Document document = new Document();
                    Document document = new Document();
                    aggregator.postCollection();
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(phoneBucket, notNullValue());
                    List<StringTerms.Bucket> buckets = result.getBuckets();
    public void testBuildAggregationsBatchWithCountOrder() throws Exception {
                        indexSearcher,
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        categoryFieldType,
        return aggregator;
    }
                }
                    assertThat(buckets.get(3).getDocCount(), equalTo(9L));
import org.opensearch.search.fetch.FetchSearchResult;
    public void testReduceWithSubAggregations() throws Exception {
                        categoryFieldType,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import org.opensearch.search.aggregations.AggregatorTestCase;
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
    private void doAggOverManySegments(boolean profile) throws IOException {
                    );
                    document.add(new SortedSetDocValuesField("field", new BytesRef(term)));
                    assertThat(cherry.getDocCount(), equalTo(1L));
                        .findFirst()
            }
                }
                    StringTerms.Bucket banana = p1Buckets.stream()
                    indexWriter.addDocument(document);
                    );
                    assertThat(result, notNullValue());
                // Create categories where alphabetical order != count order
                            .numberOfShards(1)
                        createIndexSettings(),
                        valueFieldType
                        createIndexSettings(),
        try (Directory directory = newDirectory()) {
                    assertTrue(
    }
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                }
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                    new MultiBucketConsumerService.MultiBucketConsumer(DEFAULT_MAX_BUCKETS, requestBreaker),
                when(searchContext.getFlushMode()).thenReturn(FlushMode.PER_SEGMENT);
    public void testKeyOrderDescendingWithSizeLimitDropsCorrectBuckets() throws Exception {
        }
                        .subAggregation(new AvgAggregationBuilder("avg_rating").field("rating"));
                }
                    for (int j = 0; j < uniqueUsers; j++) {
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                    // Test with minDocCount=3, should only return cat_2, cat_3, cat_4
    }
                Document document = new Document();
                    aggregator.postCollection();
                        .stream()
                        CardinalityUpperBound.MANY,
                }
                    assertThat(max2.getValue(), equalTo(104.0));
                        Settings.EMPTY
    }
        }
                    for (int j = 0; j <= i; j++) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                }
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                    );
import org.apache.lucene.index.IndexReader;
                    null,
    }
import org.apache.lucene.search.MatchAllDocsQuery;
                    );
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
        aggregator.postCollection();
                        indexSearcher,
                        .subAggregation(new AvgAggregationBuilder("avg_temp").field("temperature"))
                        ),
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=6+4+2=12, other=98
                        .order(BucketOrder.count(false)); // Order by count descending
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                        ),
import org.apache.lucene.tests.index.RandomIndexWriter;
        }
                    assertThat(result.getBuckets().size(), equalTo(2));
    public void testBuildAggregationsBatchScopesPerOwningBucketOrd() throws Exception {
                            )
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");
                indexWriter.addDocument(document);
                            )
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            }
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
                        searcher,
                    assertThat(inventoryCount.getValue(), equalTo(2L));
                    assertThat(result, notNullValue());
                    assertThat(results.length, equalTo(2));
            assertThat(terms.getBuckets().size(), equalTo(3));
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        .subAggregation(new SumAggregationBuilder("total_sales").field("sales"));
                            )
                    aggregator.preCollection();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    // term_0 appears in docs 0,3,6,9 = 4 times
                String anotherCategory = "clashing value to break on segments";
                    }
                Document document = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        indexSearcher,
                            .numberOfReplicas(0)
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .size(3)
                            )
                    );
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("cat_9"));
                    assertThat(secondResult.getBuckets().size(), equalTo(2));
                    );
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                StreamStringTermsAggregator aggregator = createStreamAggregator(
                    );
                indexWriter.addDocument(document);
import java.io.IOException;
/*
                // Collect debug info
    public void testSubAggregationWithMax() throws Exception {
                    );
                    assertThat(result, notNullValue());
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        doAggOverManySegments(true);
                    aggregator.preCollection();
                    );
                document.add(new SortedSetDocValuesField("region", new BytesRef("south")));
                }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                        Document doc = new Document();
                        .order(BucketOrder.key(true));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    assertThat(result, notNullValue());
                        .order(BucketOrder.count(false));
                    assertThat(term1Bucket, notNullValue());
                document = new Document();
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                        .findFirst()
                    assertThat(electronicsBucket.getDocCount(), equalTo(2L));
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("aaa"));
        try (Directory directory = newDirectory()) {
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
    public void testThrowOnManySegments() throws Exception {
            assertThat(reduced, instanceOf(StringTerms.class));
                        NumberFieldMapper.NumberType.LONG
                    aggregator.postCollection();
import org.apache.lucene.store.Directory;
                    assertThat(booksBucket, notNullValue());
            StringTerms.Bucket electronicsBucket = terms.getBuckets().get(0);
    }
                indexWriter.addDocument(doc5);
            );
                            DEFAULT_MAX_BUCKETS,
                        .findFirst()
                    MappedFieldType humidityFieldType = new NumberFieldMapper.NumberFieldType(
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(7L));
                    aggregator.preCollection();
                            DEFAULT_MAX_BUCKETS,
                        ),
                        indexWriter.addDocument(doc);
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_y"));
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                String[] terms = { "zzz", "yyy", "xxx", "www", "vvv", "aaa", "bbb", "ccc", "ddd", "eee" };
                    List<StringTerms.Bucket> buckets = result.getBuckets();
    }
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(35L));
            aggregator = createStreamAggregator(
                    when(searchContext.getStreamChannelListener()).thenReturn(listenerMock);
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                    // term_2 appears in docs 2,5,8 = 3 times
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
            assertThat(totalPrice.getValue(), equalTo(450.0));
                    aggregator.doReset();
                Document document = new Document();
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                        indexSearcher,
                    long totalDocs = buckets.stream().mapToLong(StringTerms.Bucket::getDocCount).sum();
                }
import java.util.List;
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));
                    assertThat(max0.getValue(), equalTo(800.0));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        createIndexSettings(),
                document = new Document();
                        categoryFieldType,
                    Document doc = new Document();
                        getMockScriptService(),
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                // Create 10 categories where TOP 3 by cardinality ASC won't be alphabetically first
                Map<String, Object> debugInfo = new HashMap<>();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
        try (Directory directory = newDirectory()) {
import org.opensearch.index.mapper.MappedFieldType;
                doc3.add(new SortedSetDocValuesField("category", new BytesRef("books")));
                        doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
        try (Directory directory = newDirectory()) {
                        fieldType
        try (Directory directory = newDirectory()) {
                    assertThat(northBucket.getDocCount(), equalTo(2L));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                            .numberOfShards(1)
                    );
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher1));
                        indexSettings,
                        ),
                if (bucket.getKeyAsString().equals("cat_3") || bucket.getKeyAsString().equals("cat_4")) {
                fieldType1,
                    document.add(new SortedSetDocValuesField("field", new BytesRef("medium")));
                    assertThat(max0.getValue(), equalTo(304.0));
            }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
                            && (secondBucket.getKeyAsString().equals("electronics") || secondBucket.getKeyAsString().equals("books"))
                }
                document.add(new NumericDocValuesField("humidity", 65));
                for (int i = 0; i < 10; i++) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(names[i])));
                document.add(new SortedSetDocValuesField("string", new BytesRef("b")));
                    MappedFieldType ratingFieldType = new NumberFieldMapper.NumberFieldType("rating", NumberFieldMapper.NumberType.LONG);
                            DEFAULT_MAX_BUCKETS,
                        OriginalIndices.NONE
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(storeBBucket, notNullValue());
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher1)
                    aggregator.postCollection();
        try (Directory directory = newDirectory()) {
                        aggregator.context().bigArrays(),
import org.opensearch.core.common.breaker.CircuitBreakingException;
                    );
     * {@code owningBucketOrd} passed into its leaf collector, so when it runs as a
                    assertThat(minInventory.getValue(), equalTo(50.0));
        }
                        .subAggregation(new MinAggregationBuilder("min_inventory").field("inventory"))
            }
                        Settings.EMPTY
                indexWriter.addDocument(document);
                    assertThat(avgRating.getValue(), equalTo(4.5));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat("strictly single segment", indexSearcher.getIndexReader().leaves().size(), lessThanOrEqualTo(1));
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.apache.lucene.index.IndexWriterConfig;
                            DEFAULT_MAX_BUCKETS,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                document.add(new SortedSetDocValuesField("region", new BytesRef("north")));
                        indexSearcher,
                            .creationDate(System.currentTimeMillis())
            assertThat(electronicsBucket.getDocCount(), equalTo(3L));
                        createIndexSettings(),
                indexWriter.addDocument(document);
                        fieldType
                    assertThat(totalHumidity.getValue(), equalTo(125.0));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                for (int i = 0; i < 10; i++) {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
        TermsAggregationBuilder builder,
                    new MultiBucketConsumerService.MultiBucketConsumer(
                .orElse(null);
                        ),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        Document doc = new Document();
        try (Directory directory = newDirectory()) {
            }
                indexWriter.addDocument(document);
        }
                    leafCollector.collect(0, 0L);
                            DEFAULT_MAX_BUCKETS,
        CircuitBreaker requestBreaker = new NoopCircuitBreaker(CircuitBreaker.REQUEST) {
                            .settings(
                indexWriter.addDocument(document);
                document = new Document();
                String[] terms = { "jjj", "iii", "hhh", "ggg", "fff", "aaa", "bbb", "ccc", "ddd", "eee" };
                builder,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        fieldType
                when(searchContext.isStreamSearch()).thenReturn(true);
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                // Create 10 categories with varying cardinality (size=5, total=10)
                        categoryFieldType,
                indexWriter1.addDocument(doc);
                    Min minInventory = storeABucket.getAggregations().get("min_inventory");
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
    ) throws IOException {
                    IndexSearcher searcher = newIndexSearcher(reader);
                }
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    MappedFieldType regionFieldType = new KeywordFieldMapper.KeywordFieldType("region");
            }
                    assertThat(buckets.get(2).getDocCount(), equalTo(8L));
                    assertThat(card1.getValue(), equalTo(4L));
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("common"));
                    StringTerms.Bucket northBucket = result.getBuckets()
                document.add(new SortedSetDocValuesField("product", new BytesRef("laptop")));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
    public void testBuildAggregationsBatchEmptyResults() throws Exception {
                        categoryFieldType,
                getMockScriptService(),
                }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
import org.opensearch.index.mapper.KeywordFieldMapper;
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_8"));
                    MappedFieldType salesFieldType = new NumberFieldMapper.NumberFieldType("sales", NumberFieldMapper.NumberType.LONG);
                    );
import org.opensearch.search.aggregations.metrics.ValueCount;
import java.util.concurrent.atomic.AtomicLong;
    }
                for (int i = 0; i < terms.length; i++) {
                    );
                b -> {},
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
import java.util.Map;
import org.opensearch.search.SearchShardTarget;
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
    private InternalAggregation buildInternalStreamingAggregation(
                        perSegAggs.add(internalAggregations);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .subAggregation(new MinAggregationBuilder("min_humidity").field("humidity"))
                    aggregator.preCollection();
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
    }
                            DEFAULT_MAX_BUCKETS,
        }
                // Create terms where top 5 by count != first 5 alphabetically
        when(breakerService.getBreaker(CircuitBreaker.REQUEST)).thenReturn(requestBreaker);
    ) throws IOException {
                        .subAggregation(new SumAggregationBuilder("total_humidity").field("humidity"));
                }
import org.opensearch.action.OriginalIndices;
import org.opensearch.search.aggregations.LeafBucketCollector;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
        return aggregator.buildTopLevel();
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_7"));
                document.add(new SortedSetDocValuesField("category", new BytesRef("books")));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    // Request size=5 with key order descending - should return last 5 alphabetically
                    assertThat(firstBucket.getDocCount(), equalTo(2L));
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        indexSearcher,
                    aggregator.postCollection();
                    assertThat(p0Buckets.get(0).getDocCount(), equalTo(3L));
                        null,
                        createIndexSettings(),
                    }
                                Settings.builder()
    }
                        .size(5)
        MappedFieldType fieldType1,
            }
                            .creationDate(System.currentTimeMillis())
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("cat_y"));
                for (int i = 0; i < 3; i++) {
        }
            try (IndexReader indexReader = DirectoryReader.open(indexWriter)) {
import org.apache.lucene.index.DirectoryReader;
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        .filter(bucket -> bucket.getKeyAsString().equals("north"))
                }
                        null,
            }
                        aggregationBuilder,
                searcher,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("regions").field("region")
                Document doc5 = new Document();
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                        .subAggregation(new MaxAggregationBuilder("max_price").field("price"));
                document.add(new SortedSetDocValuesField("product", new BytesRef("laptop")));
                        categoryFieldType,
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
                        ),
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                        indexWriter.addDocument(doc);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    // With key order ASC, should return first 5 alphabetically: aaa, bbb, ccc, ddd, eee
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        Settings.EMPTY
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                    // NOT the top 5 by doc count (zzz, yyy, xxx, www, vvv)
            StringTerms.Bucket electronicsBucket = terms.getBuckets()
            }
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(names[i])));
                }
                        doc.add(new SortedSetDocValuesField("field", new BytesRef(terms[i])));
                            .creationDate(System.currentTimeMillis())
                    );
                            .build(),
            assertThat(electronicsBucket, notNullValue());
                    indexWriter.flush();
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                                Settings.builder()
                    Document document = new Document();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            aggregator = createStreamAggregator(
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                    aggregator.postCollection();
                }
                    StringTerms parent1 = (StringTerms) results[1];
                document.add(new SortedSetDocValuesField("store", new BytesRef("store_a")));
                        null,
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    aggregator.preCollection();
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        indexSearcher,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    StringTerms.Bucket storeBBucket = result.getBuckets()
                            .numberOfShards(1)
                    assertThat(buckets.size(), equalTo(3));
                    IndexSettings indexSettings = new IndexSettings(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        new ShardId("foo", "_na_", 1),
                        null,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            .build(),
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                doc = new Document();
                // Create terms where top 5 by count != last 5 alphabetically
                        null,
                }
                    aggregator.preCollection();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        indexSettings,
        }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                            DEFAULT_MAX_BUCKETS,
                        assertThat(bucket.getKey(), instanceOf(String.class));
                        NumberFieldMapper.NumberType.LONG
                        humidityFieldType
                    assertThat(northBucket, notNullValue());
                doc4.add(new SortedSetDocValuesField("category", new BytesRef("clothing")));
    }
                    );
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        .filter(bucket -> bucket.getKeyAsString().equals("phone"))
            );
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    }
                    assertThat(maxPrice.getValue(), equalTo(50.0));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                                Settings.builder()
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_z"));
                        new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                    maxPrice = booksBucket.getAggregations().get("max_price");
                indexWriter1.addDocument(doc);
                        .order(BucketOrder.key(false));
                    assertThat(result, notNullValue());
                    InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                        userIdFieldType
                }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(result, notNullValue());
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(perSegAggs, not(empty()));
            // First aggregation with multiple terms
                        assertThat(bucket.getKeyAsString(), notNullValue());
                    ),
                doc2.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                            .numberOfReplicas(0)
 * SPDX-License-Identifier: Apache-2.0
        }
                        storeFieldType,
import static org.hamcrest.Matchers.equalTo;
                indexWriter.addDocument(document);
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_6"));
                        null,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                        productFieldType,
                                    .put("index.aggregation.streaming.min_segment_size", 1)
    public void testBuildAggregationsWithContextSearcherProfile() throws Exception {
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                Document doc4 = new Document();
                    }
                        ),
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                    Document document = new Document();
                MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");
                        ),
                        fieldType
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.apache.lucene.index.IndexWriter;
    public void testBuildAggregationsBatchWithSize() throws Exception {
                }
    }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        "humidity",
import org.opensearch.search.aggregations.metrics.Avg;
                    MappedFieldType storeFieldType = new KeywordFieldMapper.KeywordFieldType("store");
                            DEFAULT_MAX_BUCKETS,
                    assertThat(banana, notNullValue());
                    aggregator.postCollection();
                    }
                assertEquals("failed candidate allocation must be released", baselineBytes, breakerBytes.get());
                    Document doc = new Document();
                            .creationDate(System.currentTimeMillis())
                        new MultiBucketConsumerService.MultiBucketConsumer(
            }
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    Max maxTemp = northBucket.getAggregations().get("max_temp");
                Document document = new Document();
                        Settings.EMPTY
                Document doc = new Document();
                Document document = new Document();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    for (StringTerms.Bucket bucket : buckets) {
                        aggregationBuilder,
                null,
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
        AtomicBoolean breakAllocations = new AtomicBoolean();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        indexSearcher,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(15L));
                    assertThat(result, notNullValue());
                    // Default order is count DESC, so top 5 should be cat_z, cat_y, cat_x, cat_a, cat_b (highest counts)
import java.util.ArrayList;
    public void testCollectDebugInfo() throws IOException {
                    indexWriter2.addDocument(doc);
                    assertThat("parent 0 should only contain apple", p0Buckets.size(), equalTo(1));
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                        createIndexSettings(),
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
            assertThat(reduced, instanceOf(StringTerms.class));
                    createIndexSettings(),
                        );
        } else {
    }
                        .order(BucketOrder.key(true));
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("common"));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertThat(southBucket, notNullValue());
                        indexSettings,
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                document.add(new NumericDocValuesField("rating", 4));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .order(BucketOrder.aggregation("max_value", false))
                for (int i = 0; i < 20; i++) {
        MappedFieldType fieldType2,
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("ddd"));
                    int numDocs = 10 - i;
    }
                        .filter(bucket -> bucket.getKeyAsString().equals("books"))
import java.util.concurrent.atomic.AtomicBoolean;
            }
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=12+14+16+18+20=80, other=30
            assertThat(clothingBucket.getDocCount(), equalTo(1L));
                        indexSettings,
                    aggregator.postCollection();
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                .filter(bucket -> bucket.getKeyAsString().equals("books"))
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        null,
                    );
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(30L));
                        null,
        TermsAggregationBuilder builder,
                String[] names = { "cat_z", "cat_y", "cat_x", "cat_a", "cat_b", "cat_c", "cat_d", "cat_e", "cat_f", "cat_g" };
        MappedFieldType fieldType1,
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                        ),
import org.opensearch.search.fetch.QueryFetchSearchResult;
                document.add(new SortedSetDocValuesField("string", new BytesRef("a")));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        .order(BucketOrder.count(false)); // Order by count descending
                    assertThat(buckets.get(2).getDocCount(), equalTo(5L));
                            )
                    Aggregator aggregator = createStreamAggregator(
                        b -> {},
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                    for (int j = 0; j < counts[i]; j++) {
                        .filter(bucket -> bucket.getKeyAsString().equals("books"))
    }
                    // And finally: the two parents must not share identical inner results.
import org.opensearch.search.internal.SearchContext;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                indexWriter1.addDocument(doc);
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
        when(aggregationProfiler.getQueryBreakdown(any())).thenReturn(aggregationProfileBreakdown);
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                document.add(new SortedSetDocValuesField("field", new BytesRef("cherry")));
                    }
                            .settings(
        try (Directory directory = newDirectory()) {
                        .orElse(null);
import org.opensearch.search.profile.aggregation.AggregationProfiler;
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_x"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                iw.addDocument(document);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.search.query.QuerySearchResult;
                    breakerService,
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                return breakerBytes.addAndGet(bytes);
                        Document doc = new Document();
    }
import org.opensearch.index.IndexSettings;
                    // With key order DESC, should return last 5 alphabetically: jjj, iii, hhh, ggg, fff
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                        indexWriter.addDocument(doc);
                    assertThat(electronicsBucket, notNullValue());
            );
                    IndexSettings indexSettings = new IndexSettings(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    indexSearcher,
                    }
    }
                        null,
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                }
                                Settings.builder()
                        .size(5)
                        .stream()
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    indexWriter.addDocument(doc);
                    assertThat(southBucket.getDocCount(), equalTo(1L));
    }
                    aggregator.preCollection();
                        .stream()
                indexWriter.addDocument(document);
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
            assertThat(terms.getBuckets().size(), equalTo(3));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                );
                    minHumidity = southBucket.getAggregations().get("min_humidity");
            assertThat(booksBucket.getDocCount(), equalTo(1L));
        aggregator.preCollection();
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                        createIndexSettings(),
                    // Get the result and reduce it
                String[] names = { "cat_z", "cat_y", "cat_x", "cat_a", "cat_b", "cat_c", "cat_d", "cat_e", "cat_f", "cat_g" };
            assertThat(electronicsBucket.getKeyAsString(), equalTo("electronics"));
                document.add(new SortedSetDocValuesField("category", new BytesRef("books")));
            // Create second aggregation with overlapping data
                for (int i = 0; i < terms.length; i++) {
                    null,
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            DEFAULT_MAX_BUCKETS,
                    Max maxPrice = electronicsBucket.getAggregations().get("max_price");
import org.opensearch.search.profile.aggregation.ProfilingAggregator;
                        .shardSize(3)
        }
                    );
                        .stream()
                        indexWriter.addDocument(doc);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
import org.opensearch.action.search.SearchShardTask;
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("banana"));
                    );
                        .orElse(null);
                    for (int j = 0; j < uniqueUsers; j++) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                        null,
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_a"));
                        ),
        try (Directory directory = newDirectory()) {
                    // Execute the aggregator
                        null,
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("rare"));
                    assertThat(buckets.size(), equalTo(5));
        try (Directory directory = newDirectory()) {
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                PipelineTree.EMPTY
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        aggregationBuilder,
                    );
                    assertThat(buckets.size(), equalTo(5));
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
import org.opensearch.search.aggregations.BucketOrder;
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                indexWriter.addDocument(document);
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    int numDocs = 5;
                    StringTerms.Bucket southBucket = result.getBuckets()
                    assertThat(maxPrice.getValue(), equalTo(200.0));
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
                    );
                    Document document = new Document();
                Document doc = new Document();
                    aggregator.preCollection();
                        createIndexSettings(),
        }
            }
                        "inventory",
                    avgTemp = southBucket.getAggregations().get("avg_temp");
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("cat_8"));
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_x"));
import static org.mockito.Mockito.mock;
                    indexWriter.commit();
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher1));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    );
                    when(searchContext.shardTarget()).thenReturn(searchShardTarget);
                    assertThat(buckets.size(), equalTo(5));
                for (int i = 0; i < 3; i++) {
                        .orElse(null);
                    aggregator.preCollection();
    public void testMultipleSubAggregations() throws Exception {
                            .creationDate(System.currentTimeMillis())
            StringTerms.Bucket clothingBucket = terms.getBuckets()
                        fieldType
                        null,
                            DEFAULT_MAX_BUCKETS,
                        null,
                        .order(BucketOrder.count(false));
                        Document doc = new Document();
                        return null;
                    assertThat(totalDocs, equalTo(5L));
                indexWriter1.addDocument(doc);
                        .size(5)
                        fieldType
        try (Directory directory = newDirectory()) {
                document.add(new SortedSetDocValuesField("field", new BytesRef(value)));
                    totalSales = booksBucket.getAggregations().get("total_sales");
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                assertTrue("Should contain segments_with_multi_valued_ords", debugInfo.containsKey("segments_with_multi_valued_ords"));
            }
                        .order(BucketOrder.aggregation("max_value", false))
                    aggregator.preCollection();
                doc.add(new NumericDocValuesField("price", Long.MAX_VALUE));
    public void testNoSortOrder() throws Exception {
                document.add(new NumericDocValuesField("humidity", 80));
            }
                    aggregator.postCollection();
            // Reduce the aggregations
                    assertThat(card4.getValue(), equalTo(20L));
                    Cardinality card3 = buckets.get(3).getAggregations().get("unique_users");
                        .findFirst()
    }
                                Settings.builder()
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                document.add(new SortedSetDocValuesField("region", new BytesRef("north")));
                        ),
import org.opensearch.search.aggregations.InternalAggregation;
                        .findFirst()
import org.opensearch.common.util.MockPageCacheRecycler;
    public void testSubAggregationWithAvg() throws Exception {
                        aggregationBuilder,
                        IndexMetadata.builder("_index")
                        .orElse(null);
import org.opensearch.search.aggregations.Aggregator;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    assertThat(electronicsBucket, notNullValue());
                        indexSearcher,
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
            );
                document.add(new NumericDocValuesField("price", 50));
                        .filter(bucket -> bucket.getKeyAsString().equals("laptop"))
            assertThat(booksBucket, notNullValue());
                    assertThat(result, notNullValue());
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("bbb"));
                        indexWriter.addDocument(doc);
        IndexSearcher searcher
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_z"));
    /**
                        userIdFieldType
                    );
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    Avg avgTemp = northBucket.getAggregations().get("avg_temp");
                        priceFieldType
                }
                    aggregator.postCollection();
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_7"));
                ),
                        aggregationBuilder,
                new MultiBucketConsumerService.MultiBucketConsumer(
                            .build(),
                    assertThat(booksBucket, notNullValue());
                    List<StringTerms.Bucket> p1Buckets = parent1.getBuckets();
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        inventoryFieldType
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
    }
                document.add(new NumericDocValuesField("humidity", 60));
                        doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                doc.add(new NumericDocValuesField("price", 150));
                        getMockScriptService(),
import org.opensearch.search.aggregations.metrics.Max;
                    assertThat(term0Bucket, notNullValue());
                document = new Document();
                    DEFAULT_MAX_BUCKETS,
    }
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_7"));
        }
                        .filter(b -> b.getKeyAsString().equals("cherry"))
                        ),
                        .shardSize(5)
                assertThat(anotherCategory, lessThan("electronics"));
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("hhh"));
                    aggregator.preCollection();
                    StringTerms result = summary.get("test");
                        ),
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                indexWriter.addDocument(doc4);
        }
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        indexSearcher,
                            DEFAULT_MAX_BUCKETS,
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
                        indexSearcher,
                document = new Document();
                                Settings.builder()
                    when(searchContext.queryResult()).thenReturn(new QuerySearchResult());
                    inventoryCount = storeBBucket.getAggregations().get("inventory_count");
                    Document doc = new Document();
                        ),
                    // to the aggregator, mimicking a parent terms aggregator with two
                        fieldType
                document.add(new NumericDocValuesField("price", 200));
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("medium"));
                    for (StringTerms.Bucket bucket : buckets) {
                builder,
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        }
                    );
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
import org.apache.lucene.search.IndexSearcher;
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                            DEFAULT_MAX_BUCKETS,
                        .orElse(null);
                    assertThat(thirdBucket.getKeyAsString(), equalTo("clothing"));
                Document document = new Document();
        }
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(3L));
                    assertThat(reduced, notNullValue());
                        doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                Document document = new Document();
                        IndexMetadata.builder("_index")
                    );
                        indexSearcher,
                        null,
                indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                document.add(new NumericDocValuesField("inventory", 100));
                }
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));
        AggregationProfileBreakdown aggregationProfileBreakdown = mock(AggregationProfileBreakdown.class);
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
        }
                        .order(BucketOrder.count(false));
                    assertThat(maxTemp.getValue(), equalTo(35.0));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                Document document = new Document();
        try (Directory directory = newDirectory()) {
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    );
                for (String term : new String[] { "apple", "apple", "apple", "banana", "banana", "cherry" }) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                            .numberOfShards(1)
                }
                        .shardSize(3)
                    );
import org.opensearch.cluster.metadata.IndexMetadata;
                    StringTerms.Bucket booksBucket = result.getBuckets()
                PipelineTree.EMPTY
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    aggregator.preCollection();
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(names[i])));
                    totalHumidity = southBucket.getAggregations().get("total_humidity");
                    MappedFieldType tempFieldType = new NumberFieldMapper.NumberFieldType("temperature", NumberFieldMapper.NumberType.LONG);
                    document.add(new SortedSetDocValuesField("field", new BytesRef("medium")));
                    leafCollector.collect(2, 0L);
    public void testMinDocCount() throws Exception {
                    assertThat(firstResult.getBuckets().size(), equalTo(2));
                        .order(BucketOrder.aggregation("unique_users", false))
                        null,
        try (Directory directory = newDirectory()) {
                        indexSearcher,
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                        .filter(bucket -> bucket.getKeyAsString().equals("term_1"))
                            .build(),
                    );
                    MappedFieldType productFieldType = new KeywordFieldMapper.KeywordFieldType("product");
                createIndexSettings(),
                document.add(new NumericDocValuesField("sales", 2000));
                    assertThat(firstBatch.getBuckets().get(0).getKeyAsString(), equalTo("batch1"));
                searcher,
                    // parent buckets: ord 0 gets the "apple" docs, ord 1 gets the rest.
                document.add(new NumericDocValuesField("temperature", 25));
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_4"));
                        IndexMetadata.builder("_index")
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        }
        return buildInternalStreamingAggregation(builder, fieldType1, null, searcher);
                    assertThat(totalSales.getValue(), equalTo(3000.0));
                    assertThat(result, notNullValue());
            StringTerms terms = (StringTerms) reduced;
            assertThat(terms.getBuckets().size(), equalTo(1 + 1));
            List<InternalAggregation> aggs = new ArrayList<>();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        indexWriter.flush();
                }
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
import org.opensearch.search.profile.Timer;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        createIndexSettings(),
            );
                    searcher.search(new MatchAllDocsQuery(), aggregator);
    }
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                document = new Document();
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                document.add(new SortedSetDocValuesField("product", new BytesRef("phone")));
            }
                        indexSearcher,
                            DEFAULT_MAX_BUCKETS,
                // Create fewer unique terms to test size parameter more meaningfully
                        .orElse(null);
        try (Directory directory = newDirectory()) {
                    assertThat(result.getBuckets().size(), equalTo(3));
            List<InternalAggregation> aggs = new ArrayList<>();
    }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    StringTerms.Bucket term2Bucket = buckets.stream()
                StreamStringTermsAggregator aggregator = createAggregator(aggregationBuilder, searchContext);
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                    StringTerms.Bucket firstBucket = buckets.get(0);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    document.add(new SortedSetDocValuesField("field", new BytesRef("term_" + (i % 10))));
                new MultiBucketConsumerService.MultiBucketConsumer(
                        .size(3)
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                        fieldType
                    doAnswer((invok) -> {
            StringTerms terms = (StringTerms) reduced;
                            .numberOfReplicas(0)
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                            .queryResult();
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                        .shardSize(5)
                        aggregationBuilder,
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
import org.opensearch.search.aggregations.InternalAggregations;
                        .subAggregation(new ValueCountAggregationBuilder("inventory_count").field("inventory"));
                aggregator.buildAggregations(new long[] { 0 });
                        ),
import org.opensearch.core.index.shard.ShardId;
                        aggregationBuilder,
        }
                        null,
                .stream()
                    aggregator.postCollection();
                null,
            assertThat(electronicsBucket.getDocCount(), equalTo(2L));
                    assertThat(buckets.size(), equalTo(5));
        try (Directory directory = newDirectory()) {
                    assertThat(max1.getValue(), equalTo(900.0));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    assertThat(firstBatch.getBuckets().size(), equalTo(1));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);
                    IndexSettings indexSettings = new IndexSettings(
                            DEFAULT_MAX_BUCKETS,
            }
                document.add(new SortedSetDocValuesField("store", new BytesRef("store_a")));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            InternalSum totalPrice = electronicsBucket.getAggregations().get("total_price");
                    IndexSettings indexSettings = new IndexSettings(
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                        .findFirst()
import org.opensearch.core.common.breaker.CircuitBreaker;
                        .shardSize(3)
                        .findFirst()
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    for (int j = 0; j < numDocs; j++) {
                        indexSettings,
                b -> {},
                    List<StringTerms.Bucket> buckets = reduced.getBuckets();
                    List<StringTerms.Bucket> buckets = result.getBuckets();
    public void testOrderByCardinalitySubAggregationDescending() throws Exception {
                doc = new Document();
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_y"));
                    assertThat(storeABucket.getDocCount(), equalTo(2L));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        .order(BucketOrder.aggregation("max_value", true))
                for (int i = 0; i < 2; i++) {
                        IndexMetadata.builder("_index")
        }
                        null,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_9"));
                        aggregationBuilder,
                        Document doc = new Document();
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    assertThat(result.getBuckets().size(), equalTo(10));
                    aggregator.postCollection();
            StringTerms.Bucket booksBucket = terms.getBuckets()
                    fieldType
                    if (rarely()) {
                        .findFirst()
                    aggs.add(
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
                        assertThat(bucket.getKeyAsString().startsWith("term_"), equalTo(true));
                            .settings(
            }
                    StringTerms.Bucket laptopBucket = result.getBuckets()
                document.add(new NumericDocValuesField("inventory", 50));
                String[] names = { "cat_z", "cat_y", "cat_x", "cat_a", "cat_b", "cat_c", "cat_d", "cat_e", "cat_f", "cat_g" };
                        aggregationBuilder,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));
                    aggregator.postCollection();
                    assertThat(term0Bucket.getDocCount(), equalTo(4L));
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
            // Reduce the aggregations
    }
                    );
                        ),
                        .filter(bucket -> bucket.getKeyAsString().equals("term_0"))
                        reduceBucketConsumer,
    public void testKeyOrderWithSizeLimitDropsCorrectBuckets() throws Exception {
                    assertThat(result, notNullValue());
                        IndexMetadata.builder("_index")
    public void testSubAggregationWithMinAndCount() throws Exception {
                        indexSearcher.getIndexReader().leaves().get(0),
        }
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher2));
                    indexWriter.addDocument(document);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
        doAggOverManySegments(false);
                            DEFAULT_MAX_BUCKETS,
                assertTrue("Should contain result_strategy", debugInfo.containsKey("result_strategy"));
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
                        indexSettings,
                    indexWriter.addDocument(document);
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_5"));
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                return breakerBytes.addAndGet(bytes);
                    // Verify otherDocCount: 10 categories * 1 doc = 10 total, selected 3*1=3, other=7
                        ),
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cherry"));
                    }
            }
                    );
                        PipelineTree.EMPTY
                iw.addDocument(document);
                        .shardSize(3)
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                            DEFAULT_MAX_BUCKETS,
        };
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                doc.add(new SortedSetDocValuesField("category", new BytesRef("clothing")));
                createIndexSettings(),
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            }
                for (int i = 0; i < 10; i++) {
                    when(searchContext.getFlushMode()).thenReturn(FlushMode.PER_SEGMENT);
                    ValueCount inventoryCount = storeABucket.getAggregations().get("inventory_count");
                }
                    int numDocs = 5;
                    document.add(new SortedSetDocValuesField("field", new BytesRef("common")));
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    private InternalAggregation buildInternalStreamingAggregation(
                    assertThat(buckets.size(), equalTo(3));
                PipelineTree.EMPTY
                        Document doc = new Document();
                        doc.add(new SortedSetDocValuesField("field", new BytesRef(terms[i])));
                        .findFirst()
                }
                        createIndexSettings(),
                    assertThat(buckets.get(1).getDocCount(), equalTo(6L));
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                    assertThat(reduced.getBuckets().size(), equalTo(3));
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    // Request size=5 with key order ascending - should return first 5 alphabetically
                for (int i = 0; i < 2; i++) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                for (int i = 0; i < 10; i++) {
import org.opensearch.search.aggregations.CardinalityUpperBound;
                            .numberOfShards(1)
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        aggregationBuilder,
                document.add(new NumericDocValuesField("inventory", 200));
                    // Parent 0 saw only "apple" docs.
                );
                        ),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                document = new Document();
                    aggregator.preCollection();
                    aggregator.postCollection();
        }
                Document doc3 = new Document();
                    StringTerms.Bucket electronicsBucket = result.getBuckets()
                        .order(BucketOrder.key(false))
                    InternalAggregation[] results = aggregator.buildAggregations(new long[] { 0L, 1L });
import org.opensearch.search.aggregations.metrics.InternalSum;
                }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    }
                    maxTemp = southBucket.getAggregations().get("max_temp");
                            .numberOfReplicas(0)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
            }
import static org.hamcrest.Matchers.not;
                document.add(new NumericDocValuesField("rating", 5));
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                            DEFAULT_MAX_BUCKETS,
                    InternalSum totalHumidity = northBucket.getAggregations().get("total_humidity");
                    indexWriter.addDocument(document);
                    assertThat(buckets.size(), equalTo(3));
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher2));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            .numberOfReplicas(0)
import org.opensearch.search.aggregations.metrics.Min;
                        indexWriter.addDocument(doc);
                document.add(new NumericDocValuesField("price", 100));
                        null,
                for (int i = 0; i < 10; i++) {
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field").size(5);
                .stream()
                            .settings(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                Document doc1 = new Document();
     * sub-aggregator under a parent terms aggregator every parent bucket ends up
                    assertThat(secondResult.getBuckets().get(0).getDocCount(), equalTo(1L));
                    assertThat(result.getBuckets().size(), equalTo(2));
                    );
    }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        equalTo(false)
                            .build(),
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                    aggregator.preCollection();
                        p0Buckets.size() == p1Buckets.size() && p0Buckets.get(0).getKeyAsString().equals(p1Buckets.get(0).getKeyAsString()),
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    }
        try (Directory directory = newDirectory(); IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                doc.add(new SortedSetDocValuesField("category", new BytesRef("books")));
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
                    assertThat(max2.getValue(), equalTo(1004.0));
                        aggregationBuilder,
                    // Drive collection manually so we can hand different owningBucketOrds
                    // NOT the top 5 by doc count
                            .numberOfReplicas(0)
                for (int i = 0; i < atLeast(2); i++) {
                    int uniqueUsers = (i + 1) * 2; // cat_0=2, cat_1=4, ..., cat_9=20
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                fieldType1
                        aggregationBuilder,
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
        try (Directory directory = newDirectory()) {
        }
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                    Document document = new Document();
        }
        try (Directory directory = newDirectory()) {
                .findFirst()
            }
            }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result.getBuckets().size(), equalTo(3));
                        .filter(bucket -> bucket.getKeyAsString().equals("store_b"))
import org.apache.lucene.document.Document;
                        indexWriter.flush();
                fieldType2
                        createIndexSettings(),
                        valueFieldType
                    );
                        searcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
import java.util.HashMap;
                assertEquals("candidate storage must be released", baselineBytes, breakerBytes.get());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
            // Second aggregation
                    assertThat(result, notNullValue());
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result.getBuckets().size(), equalTo(2));
import org.opensearch.core.transport.TransportResponse;
                        aggregator = wrapByProfilingAgg(aggregator);
                .orElse(null);
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));
                .stream()
                    assertThat(avgTemp.getValue(), equalTo(27.5));
                        aggregationBuilder,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        assertThat(bucket, instanceOf(StringTerms.Bucket.class));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                            )
                        .orElse(null);
            }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("stores").field("store")
                        fieldType
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    aggregator.preCollection();
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));
                    assertThat(buckets.size(), equalTo(3));
                        IndexMetadata.builder("_index")
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("ccc"));
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                        indexSearcher,
import org.apache.lucene.document.NumericDocValuesField;
        }
                        aggregationBuilder,
                        .stream()
                    assertThat(maxTemp.getValue(), equalTo(30.0));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("eee"));
        }
                    document.add(new SortedSetDocValuesField("field", new BytesRef("term_" + (i % 3))));
                        .stream()
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(totalSales.getValue(), equalTo(500.0));
                .findFirst()
                document = new Document();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result, notNullValue());
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    assertThat(inventoryCount.getValue(), equalTo(1L));
                        new MultiBucketConsumerService.MultiBucketConsumer(
    public void testMultipleBatches() throws Exception {
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("cat_z"));
                doc.add(new NumericDocValuesField("price", 200));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    assertThat(result, notNullValue());
                document = new Document();
                    MappedFieldType inventoryFieldType = new NumberFieldMapper.NumberFieldType(
                        ),
                    leafCollector.collect(1, 0L);
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                            )
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                }
                    );
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("jjj"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                for (int i = 0; i < 5; i++) {
import org.opensearch.search.aggregations.metrics.Cardinality;
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                indexWriter2.addDocument(doc);
import static org.hamcrest.Matchers.empty;
                        ),
                aggregator.preCollection();
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer =
                    createIndexSettings(),
                indexWriter.flush();
                document.add(new NumericDocValuesField("rating", 3));
                    assertThat(result, notNullValue());
                        assertThat(bucket.getDocCount(), equalTo(2L));
                    assertThat(bucket.getDocCount(), equalTo(2L));
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_x"));
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                document.add(new SortedSetDocValuesField("field", new BytesRef("best")));
        }
                    List<StringTerms.Bucket> p0Buckets = parent0.getBuckets();
                        createIndexSettings(),
                }
                    assertThat(avgRating.getValue(), equalTo(3.0));
                    aggregator.preCollection();
                        .stream()
                    StringTerms parent0 = (StringTerms) results[0];
                        .orElse(null);
                    IndexSettings indexSettings = new IndexSettings(
                getMockScriptService(),
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
    public void testOrderByMaxAscending() throws Exception {
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                        createIndexSettings(),
                    aggregator.postCollection();
                    assertThrows(IllegalStateException.class, () -> { searcher.search(new MatchAllDocsQuery(), aggregator); });
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
    public void testOrderByMaxSubAggregationDescending() throws Exception {
                }
                doc5.add(new SortedSetDocValuesField("category", new BytesRef("books")));
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                    aggregator.postCollection();
                }
                    throw new CircuitBreakingException("test error", bytes, Long.MAX_VALUE, Durability.TRANSIENT);
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field("string");
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                        null,
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                indexWriter.addDocument(document);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.preCollection();
            }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        IndexMetadata.builder("_index")
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    SearchShardTarget searchShardTarget = new SearchShardTarget(
                        .findFirst()
                        aggregationBuilder,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                long baselineBytes = breakerBytes.get();
                    }
                    );
                aggregator.collectDebugInfo(debugCollector);
                                Settings.builder()
                        Settings.EMPTY
                } else {
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
}
                        categoryFieldType
                }
                Document document = new Document();
                    assertThat(buckets.get(0).getDocCount(), equalTo(7L));
                b -> {},
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                doc1.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                        isSegmented = true;
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
import static org.mockito.Mockito.when;
                    assertThat(banana.getDocCount(), equalTo(2L));
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
import org.opensearch.search.internal.ContextIndexSearcher;
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                doc.add(new SortedSetDocValuesField("category", new BytesRef(anotherCategory)));
                        .shardSize(5)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                indexWriter.commit(); // Ensure data is committed before reading
            public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
    public void testBuildAggregationsBatchWithSingleValuedOrds() throws Exception {
                    indexWriter.addDocument(document);
                // Create categories with varying doc counts: cat_0=1, cat_1=2, cat_2=3, cat_3=4, cat_4=5
                        null,
                    StringTerms.Bucket phoneBucket = result.getBuckets()
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        valueFieldType
                    StringTerms.Bucket cherry = p1Buckets.stream()
                        "node_1",
                }
                }
                .findFirst()
                    assertThat(buckets.get(4).getDocCount(), equalTo(10L));
                indexWriter.addDocument(document);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    assertThat(term2Bucket.getDocCount(), equalTo(3L));
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                // docs 0,1,2 -> apple ; docs 3,4 -> banana ; doc 5 -> cherry
                    aggregator.postCollection();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
import org.apache.lucene.util.BytesRef;
                document.add(new NumericDocValuesField("temperature", 30));
                    );
                }
                            .build(),
                        .orElse(null);
                        createIndexSettings(),
import java.util.Collections;
                    aggregator.preCollection();
                    aggregator.preCollection();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                                    .put("index.aggregation.streaming.min_segment_size", 1)
    public void testReduceWithSizeLimit() throws Exception {
            }
            }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
                Document doc2 = new Document();
    }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("products").field("product")
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_9"));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    avgRating = phoneBucket.getAggregations().get("avg_rating");
                    StringTerms.Bucket storeABucket = result.getBuckets()
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                    aggregator.postCollection();
 * this file be licensed under the Apache-2.0 license or a
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                            MultiBucketConsumerService.DEFAULT_MAX_BUCKETS,
                        indexWriter.addDocument(doc);
                SearchContext searchContext = createSearchContext(
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                        aggregationBuilder,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        valueFieldType
                indexWriter.addDocument(doc1);
                        aggregationBuilder,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        .subAggregation(new MaxAggregationBuilder("max_temp").field("temperature"))
                        aggregationBuilder,
    public void testOrderByMaxDescending() throws Exception {
            }
                document = new Document();
                        indexSearcher,
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                document.add(new NumericDocValuesField("sales", 500));
                Document document = new Document();
                // Create 10 categories with varying max values
                        .size(3)
                ),
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));
        AtomicLong breakerBytes = new AtomicLong();
                    // Verify otherDocCount: total=55 docs (10+9+8+7+6+5+4+3+2+1), selected=40 (10+9+8+7+6), other=15
                }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
 *
                for (int i = 0; i < 5; i++) {
            // First aggregation
                        (firstBucket.getKeyAsString().equals("electronics") || firstBucket.getKeyAsString().equals("books"))
import static org.hamcrest.Matchers.instanceOf;
                    assertThat(card0.getValue(), equalTo(12L));
                    Min minHumidity = northBucket.getAggregations().get("min_humidity");
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                    assertThat(result, notNullValue());
                            .build(),
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                Document document = new Document();
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(result, notNullValue());
                        fieldType
                Document doc = new Document();
                    assertThat(buckets.size(), equalTo(3));
        try (Directory directory = newDirectory()) {
     */
                        regionFieldType,
                    DEFAULT_MAX_BUCKETS,
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("rare"));
                        indexSearcher,
                        .filter(bucket -> bucket.getKeyAsString().equals("electronics"))
                        InternalAggregations internalAggregations = querySearchResult.aggregations().expand();
                document.add(new NumericDocValuesField("temperature", 35));
                        categoryFieldType,
                document.add(new SortedSetDocValuesField("store", new BytesRef("store_b")));
                        new MultiBucketConsumerService.MultiBucketConsumer(
            // Create first aggregation with some data
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
                .filter(bucket -> bucket.getKeyAsString().equals("electronics"))
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                    indexSearcher,
                    assertThat(storeABucket, notNullValue());
                        null,
            }
                doc.add(new NumericDocValuesField("price", 100));
        aggregator = new ProfilingAggregator(aggregator, aggregationProfiler);
    public void testOrderByCardinalitySubAggregationAscending() throws Exception {
                    leafCollector.collect(5, 1L);
                    // Verify otherDocCount: 10 categories * 5 docs = 50 total, selected 3*5=15, other=35
                    aggregator.postCollection();
                document = new Document();
                doc = new Document();
                    );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        createIndexSettings(),
                indexWriter.addDocument(document);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
                        indexSettings,
                for (int i = 0; i < 10; i++) {
        StreamStringTermsAggregator aggregator;
                        aggregationBuilder,
            for (String value : List.of("apple", "banana", "cherry")) {
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                            DEFAULT_MAX_BUCKETS,
        assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                    StringTerms.Bucket electronicsBucket = result.getBuckets()
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    assertThat(bucket.getDocCount(), equalTo(1L));
                    when(searchContext.isStreamSearch()).thenReturn(true);
                indexWriter2.addDocument(doc);
                    for (int j = 0; j < counts[i]; j++) {
                    assertThat(card1.getValue(), equalTo(14L));
                        Settings.EMPTY
                            .numberOfShards(1)
                    );
                document = new Document();
                        null,
                        assertThat(bucket.getKeyAsString().startsWith("term_"), equalTo(true));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
        }
import static org.mockito.ArgumentMatchers.anyBoolean;
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
            assertThat(reduced, instanceOf(StringTerms.class));
                        Document doc = new Document();
                document = new Document();
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                    assertThat(result, notNullValue());
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        indexWriter.addDocument(doc);
                assertThrows(CircuitBreakingException.class, () -> aggregator.buildAggregations(new long[] { 0 }));
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(35L));
                    IndexSearcher searcher = newIndexSearcher(reader);
                        .orElse(null);
                        .filter(bucket -> bucket.getKeyAsString().equals("store_a"))
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                }
import static org.mockito.ArgumentMatchers.any;
                }
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                        .orElse(null);
        try (Directory directory = newDirectory()) {
                    if (rarely()) {
import org.opensearch.index.mapper.NumberFieldMapper;
                    StringTerms.Bucket secondBucket = buckets.get(1);
    public void testReduceSingleAggregation() throws Exception {
                        null,
                    assertThat("parent 1 should contain banana and cherry", p1Buckets.size(), equalTo(2));
                        .filter(bucket -> bucket.getKeyAsString().equals("electronics"))
                    minInventory = storeBBucket.getAggregations().get("min_inventory");
import org.opensearch.Version;
            }
                        indexSearcher,
                    // Now perform the reduce operation
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("apple"));
                        Document doc = new Document();
                indexWriter.addDocument(document);
import org.opensearch.common.util.MockBigArrays;
                        .orElse(null);
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    Avg avgRating = laptopBucket.getAggregations().get("avg_rating");
import org.opensearch.common.settings.Settings;
            }
            // Reduce the aggregations
                }
                    );
                aggregator.postCollection();
                        ),
                            DEFAULT_MAX_BUCKETS,
                    assertThat(minHumidity.getValue(), equalTo(80.0));
            }
                getMockScriptService(),
package org.opensearch.search.aggregations.bucket.terms;
                        createIndexSettings(),
                indexWriter.addDocument(document);
                    assertThat(buckets.get(1).getDocCount(), equalTo(4L));
                for (int i = 0; i < 10; i++) {
                    aggregator.preCollection();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    }
                .orElse(null);
                        new NumberFieldMapper.NumberFieldType("test", NumberFieldMapper.NumberType.INTEGER)
                    aggregator.preCollection();
                        aggregationBuilder,
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    StringTerms reduced = (StringTerms) topLevel.reduce(Collections.singletonList(topLevel), context);
                    aggregator.postCollection();
    public void testBuildAggregationsBatchReset() throws Exception {
import static org.hamcrest.Matchers.lessThan;
                        .findFirst()
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
     * with the same inner buckets. Collects six docs across two simulated parent
                    assertThat(card2.getValue(), equalTo(2L));
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(98L));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
                    assertThat(term1Bucket.getDocCount(), equalTo(3L));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            .creationDate(System.currentTimeMillis())
                assertEquals("streaming_terms", debugInfo.get("result_strategy"));
                        null,
                    InternalSum totalSales = electronicsBucket.getAggregations().get("total_sales");
                        .filter(bucket -> bucket.getKeyAsString().equals("south"))
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                        ratingFieldType
                        indexSearcher,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                    leafCollector.collect(4, 1L);
                .filter(bucket -> bucket.getKeyAsString().equals("clothing"))
        try (Directory directory = newDirectory()) {
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                        Settings.EMPTY
                        .orElse(null);
                // cat_z=10 docs (highest), cat_y=9, cat_x=8, cat_a=7, cat_b=6, cat_c=5, cat_d=4, cat_e=3, cat_f=2, cat_g=1 (lowest)
                            .numberOfReplicas(0)
     * bucket ordinals and asserts the two resulting aggregations diverge.
                    StringTerms.Bucket term1Bucket = buckets.stream()
                indexWriter.addDocument(document);
                indexWriter1.addDocument(doc);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        when(aggregationProfileBreakdown.getTimer(any())).thenReturn(mock(Timer.class));
                    Document doc = new Document();
                        .order(BucketOrder.aggregation("unique_users", true))
                if (!isSegmented) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            List<InternalAggregation> aggs = new ArrayList<>();
                }
                    aggregator.preCollection();
                        IndexMetadata.builder("_index")
import java.util.function.BiConsumer;
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                }
import org.apache.lucene.document.SortedSetDocValuesField;
                    assertThat(max0.getValue(), equalTo(804.0));
