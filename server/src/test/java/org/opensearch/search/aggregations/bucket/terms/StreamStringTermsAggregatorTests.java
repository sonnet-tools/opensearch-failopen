                indexWriter.addDocument(doc1);  
                    assertThat(result, notNullValue());
                    // Request size=5 with key order descending - should return last 5 alphabetically
                    aggregator.preCollection();  
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));  
import org.apache.lucene.search.MatchAllDocsQuery;  
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
                    aggregator.postCollection();
    }  
                doc3.add(new SortedSetDocValuesField("category", new BytesRef("books")));
                    doAnswer((invok) -> {  
                    assertThat(result, notNullValue());
    public void testBuildAggregationsBatchScopesPerOwningBucketOrd() throws Exception {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        categoryFieldType,
                    MappedFieldType storeFieldType = new KeywordFieldMapper.KeywordFieldType("store");
                Document document = new Document();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(reduced, notNullValue());  
                        createIndexSettings(),
                    assertThat(result, notNullValue());  
                    indexWriter.commit();  
                    aggregator.preCollection();  
                    assertThat(buckets.size(), equalTo(3));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                .filter(bucket -> bucket.getKeyAsString().equals("books"))  
                    StringTerms result = summary.get("test");  
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {  
                    );
        try (Directory directory = newDirectory()) {  
                            && !firstBucket.getKeyAsString().equals(secondBucket.getKeyAsString())
                        createIndexSettings(),  
                    MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer =
                    LeafBucketCollector leafCollector = aggregator.getLeafCollector(
                    aggregator.preCollection();  
                    assertThat(cherry.getDocCount(), equalTo(1L));  
    }
                    }
                        indexSearcher,
                }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    assertThat(buckets.size(), equalTo(3));
                Document document = new Document();  
                        NumberFieldMapper.NumberType.LONG
                        fieldType  
                // Create terms where top 5 by count != first 5 alphabetically
                        isSegmented = true;
                            .numberOfReplicas(0)
                        .shardSize(3)
                        .findFirst()
                    new MultiBucketConsumerService.MultiBucketConsumer(
        }  
                        getMockScriptService(),
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                document.add(new SortedSetDocValuesField("string", new BytesRef("a")));  
                } else {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                        .filter(bucket -> bucket.getKeyAsString().equals("store_b"))  
                    Max max2 = buckets.get(2).getAggregations().get("max_value");  
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
    }  
        AtomicLong breakerBytes = new AtomicLong();  
                        indexSearcher,
                            .numberOfShards(1)
                    assertThat(buckets.get(1).getDocCount(), equalTo(6L));
            assertThat(totalPrice.getValue(), equalTo(450.0));  
    ) throws IOException {
import org.apache.lucene.store.Directory;
                        aggregationBuilder,
        try (Directory directory = newDirectory()) {  
     * with the same inner buckets. Collects six docs across two simulated parent
                        humidityFieldType  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
import org.opensearch.action.OriginalIndices;
                    StringTerms.Bucket booksBucket = result.getBuckets()  
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_b"));  
                        ),
import org.opensearch.index.mapper.NumberFieldMapper;
                            DEFAULT_MAX_BUCKETS,
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
        }
                    MappedFieldType regionFieldType = new KeywordFieldMapper.KeywordFieldType("region");  
import org.opensearch.search.aggregations.Aggregator;  
                    aggregator.preCollection();
                            DEFAULT_MAX_BUCKETS,  
                    assertThat("strictly single segment", indexSearcher.getIndexReader().leaves().size(), lessThanOrEqualTo(1));  
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                b -> {},  
                document.add(new NumericDocValuesField("temperature", 35));  
                indexWriter.addDocument(document);  
                Document doc = new Document();  
                    Document document = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        searcher,  
                }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                indexWriter.addDocument(document);
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                    assertThat(max0.getValue(), equalTo(800.0));  
                    assertThat(firstBatch.getBuckets().size(), equalTo(1));  
                    aggregator.postCollection();  
                    assertThat(totalHumidity.getValue(), equalTo(80.0));  
        when(aggregationProfiler.getQueryBreakdown(any())).thenReturn(aggregationProfileBreakdown);  
                    MappedFieldType ratingFieldType = new NumberFieldMapper.NumberFieldType("rating", NumberFieldMapper.NumberType.LONG);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            }
import org.opensearch.core.common.breaker.CircuitBreaker;  
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                        Document doc = new Document();  
            );
        try (Directory directory = newDirectory()) {
        }
                    new MultiBucketConsumerService.MultiBucketConsumer(DEFAULT_MAX_BUCKETS, requestBreaker),  
    }  
                    assertThat(thirdBucket.getDocCount(), equalTo(1L));
                    aggregator.preCollection();
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=12+14+16+18+20=80, other=30
                    aggregator.preCollection();
                builder,
    public void testCollectDebugInfo() throws IOException {
        }  
                indexWriter.addDocument(document);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        createIndexSettings(),  
            assertThat(reduced, instanceOf(StringTerms.class));
                        null,  
                }  
     * Reproduces the bug where {@link StreamStringTermsAggregator} ignores the
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                                Settings.builder()
                Document document = new Document();
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("ccc"));  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                }  
                // Add multiple documents with different categories to test reduce logic properly  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    aggregator.postCollection();  
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                searcher,
                    when(searchContext.queryResult()).thenReturn(new QuerySearchResult());
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        .filter(bucket -> bucket.getKeyAsString().equals("term_2"))
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                        .stream()
                        .size(3)  
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("cat_z"));  
                        .filter(bucket -> bucket.getKeyAsString().equals("term_0"))  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("medium")));
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                document.add(new NumericDocValuesField("rating", 4));  
                        ratingFieldType
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        aggregationBuilder,
                        ),
                indexWriter1.addDocument(doc);  
                        indexSearcher,  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                // Create terms where top 5 by count != last 5 alphabetically
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        .orElse(null);
                    assertThat(p0Buckets.get(0).getDocCount(), equalTo(3L));
import org.apache.lucene.index.DirectoryReader;
                builder,
                    ContextIndexSearcher contextIndexSearcher = searchContext.searcher();
                    aggregator.preCollection();
                    assertThat(minInventory.getValue(), equalTo(200.0));
                doc.add(new NumericDocValuesField("price", 150));
                    aggregator.postCollection();
                assertThrows(CircuitBreakingException.class, () -> aggregator.buildAggregations(new long[] { 0 }));
                            .numberOfShards(1)
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(35L));  
                        indexSearcher,  
                    maxTemp = southBucket.getAggregations().get("max_temp");
                    IndexSettings indexSettings = new IndexSettings(
                    aggregator.preCollection();  
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                fieldType1  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
        AggregationProfileBreakdown aggregationProfileBreakdown = mock(AggregationProfileBreakdown.class);
                    );
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    );  
                    aggregator.preCollection();
                    assertThat(northBucket.getDocCount(), equalTo(2L));
                }  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("medium")));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                doc.add(new SortedSetDocValuesField("category", new BytesRef("books")));
                        IndexMetadata.builder("_index")
                indexWriter.addDocument(document);  
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("ggg"));
                // Create categories where alphabetical order != count order
                    when(searchContext.fetchResult()).thenReturn(new FetchSearchResult());
    public void testSubAggregationWithSum() throws Exception {
import org.opensearch.index.mapper.KeywordFieldMapper;
        } else {
                                    .put("index.aggregation.streaming.min_segment_size", 1)
import org.apache.lucene.tests.index.RandomIndexWriter;
                    searchContext.setTask(task);  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
        }
                    assertThat(maxPrice.getValue(), equalTo(50.0));
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                    SearchContext searchContext = createSearchContext(
                        new MultiBucketConsumerService.MultiBucketConsumer(
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                        Document doc = new Document();
                        doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                }
                    }  
                        indexWriter.addDocument(doc);  
                aggregator.postCollection();
                    aggregator.preCollection();
                    );  
                    assertThat(result, notNullValue());  
                    // term_0 appears in docs 0,3,6,9 = 4 times
                        Settings.EMPTY
                    document.add(new SortedSetDocValuesField("field", new BytesRef(term)));
                // Create 10 categories with varying max values  
            }  
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.settings.Settings;  
                }
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("jjj"));
                    aggregationBuilder,
                    assertThat(bucket.getDocCount(), equalTo(1L));  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    assertThat(maxTemp.getValue(), equalTo(30.0));
            assertThat(clothingBucket.getDocCount(), equalTo(1L));  
                            )
                    assertThat(max2.getValue(), equalTo(1000.0));
                        indexWriter.addDocument(doc);
                iw.addDocument(document);
                indexWriter1.addDocument(doc);
                    aggregator.preCollection();
                        fieldType
                // Create fewer unique terms to test size parameter more meaningfully
                    );
                        indexSearcher.getIndexReader().leaves().get(0),
                        NumberFieldMapper.NumberType.LONG
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        "humidity",  
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_y"));
import org.opensearch.search.profile.aggregation.AggregationProfileBreakdown;
                        .filter(b -> b.getKeyAsString().equals("banana"))
                    aggregator.preCollection();
                        Document doc = new Document();
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                    ValueCount inventoryCount = storeABucket.getAggregations().get("inventory_count");
                        Document doc = new Document();  
                        Settings.EMPTY  
                document.add(new NumericDocValuesField("humidity", 60));
                        .size(5)
        assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                b -> {},  
                        "node_1",
import org.apache.lucene.index.IndexWriter;  
        MappedFieldType fieldType1,
                    );  
                    aggregator.preCollection();  
                    IndexSearcher searcher = newIndexSearcher(reader);  
                    Cardinality card3 = buckets.get(3).getAggregations().get("unique_users");
        MappedFieldType fieldType2,  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.index.IndexSettings;
                    assertTrue(  
                .filter(bucket -> bucket.getKeyAsString().equals("electronics"))
                    aggregator.preCollection();  
                        .order(BucketOrder.aggregation("unique_users", false))  
                document.add(new NumericDocValuesField("temperature", 30));  
                .stream()
                    // Verify otherDocCount: 10 categories * 5 docs = 50 total, selected 3*5=15, other=35
                    document.add(new SortedSetDocValuesField("field", new BytesRef("term_" + (i % 10))));
public class StreamStringTermsAggregatorTests extends AggregatorTestCase {
                        categoryFieldType,  
        }
                        createIndexSettings(),  
                }  
            StringTerms terms = (StringTerms) reduced;
    }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        aggregationBuilder,  
                    StringTerms firstBatch = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        indexSearcher,
                        indexSearcher,  
                    assertThat(perSegAggs, not(empty()));  
                indexWriter.addDocument(doc5);
                }
                    breakerService,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                        aggregationBuilder,
                    assertThat(max1.getValue(), equalTo(900.0));
                        ),
                    );  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    document.add(new SortedSetDocValuesField("field", new BytesRef("common")));  
                        null,
                    IndexSettings indexSettings = new IndexSettings(  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSettings indexSettings = new IndexSettings(  
                    Document document = new Document();  
                    }  
                        ),
                        .stream()
                        assertThat(bucket, instanceOf(StringTerms.Bucket.class));
                    assertThat(max1.getValue(), equalTo(204.0));
                            .build(),
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
        AggregationProfiler aggregationProfiler = mock(AggregationProfiler.class);  
            @Override
                    assertThat(result.getBuckets().size(), equalTo(3));  
                    aggregator.preCollection();
                        .size(5)  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    when(searchContext.isStreamSearch()).thenReturn(true);
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_z"));  
                // docs 0,1,2 -> apple ; docs 3,4 -> banana ; doc 5 -> cherry
                    assertThat(laptopBucket, notNullValue());
                        null,  
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.core.transport.TransportResponse;  
                .findFirst()  
                        Settings.EMPTY
                    );
                        indexSearcher,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("regions").field("region")
    }
                            DEFAULT_MAX_BUCKETS,  
                    contextIndexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));  
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                            .build(),
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {  
                doc.add(new NumericDocValuesField("price", 100));  
                        Document doc = new Document();  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
            InternalSum totalPrice = electronicsBucket.getAggregations().get("total_price");
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        aggregationBuilder,
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    Max maxPrice = electronicsBucket.getAggregations().get("max_price");  
                        assertThat(bucket.getDocCount(), equalTo(2L));
                    assertThat(secondResult.getBuckets().size(), equalTo(2));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        indexSearcher,  
                    indexSearcher,  
                        new ShardId("foo", "_na_", 1),  
        doAggOverManySegments(true);  
                        null,  
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                        OriginalIndices.NONE
                    aggregator.preCollection();  
                    when(searchContext.getFlushMode()).thenReturn(FlushMode.PER_SEGMENT);  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
        }
                    assertThat(thirdBucket.getKeyAsString(), equalTo("clothing"));
                document = new Document();
                    StringTerms secondResult = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                indexWriter.addDocument(document);  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.search.aggregations.InternalAggregation;
                        .shardSize(5)
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                        indexSearcher,
                        .order(BucketOrder.aggregation("max_value", true))
            List<InternalAggregation> aggs = new ArrayList<>();  
            }  
                        .orElse(null);
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);  
                assertEquals("failed candidate allocation must be released", baselineBytes, breakerBytes.get());  
                    StringTerms topLevel = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    aggregator.postCollection();  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("products").field("product")  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                assertTrue("Should contain segments_with_multi_valued_ords", debugInfo.containsKey("segments_with_multi_valued_ords"));  
                    assertThat(minInventory.getValue(), equalTo(50.0));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_7"));
                    assertThat(southBucket.getDocCount(), equalTo(1L));  
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_7"));
                // By count: zzz(100), yyy(90), xxx(80), www(70), vvv(60), aaa(50), bbb(40), ccc(30), ddd(20), eee(10)
                        .subAggregation(new MaxAggregationBuilder("max_price").field("price"));
                    );
                        .shardSize(5)
    public void testOrderByMaxDescending() throws Exception {  
                        null,
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
            assertThat(electronicsBucket.getKeyAsString(), equalTo("electronics"));
                }  
                        aggregationBuilder,
            assertThat(terms.getBuckets().size(), equalTo(3));  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        indexSettings,  
                }
    }  
                            .build(),  
                    assertThat(buckets.get(0).getDocCount(), equalTo(2L));  
        try (Directory directory = newDirectory()) {
                        null,
                    assertThat(result.getBuckets().size(), equalTo(10));
                        indexSearcher,  
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                }  
                        regionFieldType,
                        .findFirst()
                        .subAggregation(new AvgAggregationBuilder("avg_rating").field("rating"));
                        QuerySearchResult querySearchResult = ((QueryFetchSearchResult) invok.getArgument(0, TransportResponse.class))
                }  
                Document document = new Document();
    private void doAggOverManySegments(boolean profile) throws IOException {  
                        indexSearcher,
                document.add(new SortedSetDocValuesField("string", new BytesRef("b")));  
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(names[i])));  
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                    indexWriter2.addDocument(doc);
                            .build(),
                        .filter(bucket -> bucket.getKeyAsString().equals("books"))
                indexWriter2.addDocument(doc);
                getMockScriptService(),  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            )  
        }  
                    assertThat(result.getBuckets().size(), equalTo(3));
                document = new Document();
                document.add(new NumericDocValuesField("humidity", 80));
                    leafCollector.collect(5, 1L);
                for (int i = 0; i < 10; i++) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        }
                for (int i = 0; i < atLeast(2); i++) {
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                    Max max2 = buckets.get(2).getAggregations().get("max_value");  
                        .findFirst()
                }
                        aggregationBuilder,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    indexWriter.addDocument(doc);
                if (!isSegmented) {  
                            DEFAULT_MAX_BUCKETS,  
    public void testReduceSingleAggregation() throws Exception {  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result, notNullValue());
                aggregator.buildAggregations(new long[] { 0 });
                        null,  
        try (Directory directory = newDirectory()) {  
                    assertThat(firstResult.getBuckets().size(), equalTo(2));  
                Document doc2 = new Document();
                        .size(3)
                }  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                    assertThat(totalSales.getValue(), equalTo(3000.0));
                    );
                document = new Document();
                );  
import org.opensearch.search.aggregations.metrics.ValueCount;  
                        createIndexSettings(),
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_x"));
                    // Request size=5 with key order ascending - should return first 5 alphabetically
                        .stream()
import static org.hamcrest.Matchers.not;  
                        isSegmented = true;
                            DEFAULT_MAX_BUCKETS,  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                    assertThat(result.getBuckets().size(), equalTo(2));  
                    assertThat(banana, notNullValue());  
                    StringTerms.Bucket firstBucket = buckets.get(0);
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result, notNullValue());  
                indexWriter.addDocument(document);
        }  
import static org.mockito.ArgumentMatchers.anyBoolean;  
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher1));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    );  
                    }
                    Max max0 = buckets.get(0).getAggregations().get("max_value");  
                for (int i = 0; i < 20; i++) {
                ),
                document.add(new NumericDocValuesField("sales", 2000));  
                PipelineTree.EMPTY
                document.add(new SortedSetDocValuesField("region", new BytesRef("north")));
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                indexWriter1.addDocument(doc);
                    assertThat(term1Bucket, notNullValue());
                        assertThat(bucket.getKey(), instanceOf(String.class));
                        aggregator = wrapByProfilingAgg(aggregator);  
                        indexWriter.addDocument(doc);
                        indexSettings,
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
                    indexWriter.addDocument(document);
                    );
                    assertThrows(IllegalStateException.class, () -> { searcher.search(new MatchAllDocsQuery(), aggregator); });
                }
                        indexSettings,
                        aggregationBuilder,
                        new MultiBucketConsumerService.MultiBucketConsumer(
    /**  
                    );
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                    }
            assertThat(terms.getBuckets().size(), equalTo(1 + 1));
                    assertThat(term0Bucket.getDocCount(), equalTo(4L));
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                        fieldType
                indexWriter.addDocument(document);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(35L));  
                            DEFAULT_MAX_BUCKETS,
                            DEFAULT_MAX_BUCKETS,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    assertThat(buckets.size(), equalTo(3));  
    public void testMultipleSubAggregations() throws Exception {
                        assertThat(bucket.getKeyAsString(), notNullValue());  
        }
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
        try (Directory directory = newDirectory()) {  
                        ),  
import org.opensearch.action.search.SearchShardTask;  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    );  
                            .numberOfReplicas(0)
                    aggregator.postCollection();
                        .subAggregation(new ValueCountAggregationBuilder("inventory_count").field("inventory"));
                        reduceBucketConsumer,  
                    assertThat(result, notNullValue());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
        try (Directory directory = newDirectory()) {
                        .stream()  
        when(breakerService.getBreaker(CircuitBreaker.REQUEST)).thenReturn(requestBreaker);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    indexWriter.flush();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
    public void testBuildAggregationsBatchReset() throws Exception {
                            DEFAULT_MAX_BUCKETS,  
            }
                    // And finally: the two parents must not share identical inner results.
                            DEFAULT_MAX_BUCKETS,  
                    null,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                assertEquals("candidate storage must be released", baselineBytes, breakerBytes.get());
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        MappedFieldType fieldType1,  
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                    Avg avgRating = laptopBucket.getAggregations().get("avg_rating");
                    for (int j = 0; j < numDocs; j++) {  
}
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                    );
                    assertThat(buckets.size(), equalTo(3));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                aggregator.preCollection();
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("rare"));
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
        return aggregator.buildTopLevel();
            }  
                        createIndexSettings(),
        }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    assertThat(reduced.getBuckets().size(), equalTo(3));
import org.opensearch.common.util.MockPageCacheRecycler;
import org.opensearch.search.aggregations.LeafBucketCollector;  
        try (Directory directory = newDirectory()) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_8"));
                    );
                    assertThat(avgRating.getValue(), equalTo(3.0));  
                            DEFAULT_MAX_BUCKETS,  
                    assertThat(result, notNullValue());
                indexWriter.addDocument(document);
    public void testBuildAggregationsBatchEmptyResults() throws Exception {
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                        .filter(bucket -> bucket.getKeyAsString().equals("electronics"))
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                        new NumberFieldMapper.NumberFieldType("test", NumberFieldMapper.NumberType.INTEGER)  
                    List<StringTerms.Bucket> p1Buckets = parent1.getBuckets();
                    }  
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {  
                            .creationDate(System.currentTimeMillis())
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        .findFirst()
                    minHumidity = southBucket.getAggregations().get("min_humidity");
                    when(searchContext.shardTarget()).thenReturn(searchShardTarget);
                    for (int j = 0; j < uniqueUsers; j++) {
                    assertThat(buckets.size(), equalTo(5));  
                    assertThat(minHumidity.getValue(), equalTo(60.0));
                indexWriter2.addDocument(doc);
                    StringTerms.Bucket term2Bucket = buckets.stream()
                    Avg avgTemp = northBucket.getAggregations().get("avg_temp");  
                    assertThat(buckets.size(), equalTo(5));  
                            .creationDate(System.currentTimeMillis())  
    private InternalAggregation buildInternalStreamingAggregation(  
                        indexSettings,
                            .settings(  
                .findFirst()
                // Create 10 categories where TOP 3 by cardinality ASC won't be alphabetically first
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                }  
                Document document = new Document();
                        ),
                document.add(new NumericDocValuesField("temperature", 25));  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
                    assertThat(result.getBuckets().size(), equalTo(3));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(buckets.get(2).getDocCount(), equalTo(5L));
        }
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
import java.io.IOException;
                        categoryFieldType,
                doc = new Document();  
                createIndexSettings(),  
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };  
            }  
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(doc3);
    }
                        new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),  
                doc1.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
    }  
                        .order(BucketOrder.key(false))
                doc2.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));  
                        null,
                    List<StringTerms.Bucket> buckets = result.getBuckets();  
            @Override
                    InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                        .order(BucketOrder.count(false));  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
                    aggs.add(
    }
                        .findFirst()
                        .filter(bucket -> bucket.getKeyAsString().equals("south"))
                        aggregationBuilder,
                assertThat(anotherCategory, lessThan("electronics"));
                    );
                    assertThat(buckets.get(1).getDocCount(), equalTo(4L));  
        searcher.search(new MatchAllDocsQuery(), aggregator);  
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_9"));
                document.add(new NumericDocValuesField("price", 100));  
                for (int i = 0; i < 5; i++) {
                Document doc4 = new Document();
                        assertThat(bucket.getKeyAsString().startsWith("term_"), equalTo(true));
                    aggregator.postCollection();  
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                document.add(new NumericDocValuesField("sales", 1000));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                        equalTo(false)  
            List<InternalAggregation> aggs = new ArrayList<>();  
                document.add(new SortedSetDocValuesField("field", new BytesRef("rare")));
                indexWriter.addDocument(document);
                        .orElse(null);  
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_a"));
                        .order(BucketOrder.aggregation("max_value", false))  
                }
                        .order(BucketOrder.count(false)); // Order by count descending  
                for (int i = 0; i < terms.length; i++) {
                    aggregator.preCollection();
                        aggregationBuilder,
        try (Directory directory = newDirectory()) {
                new MultiBucketConsumerService.MultiBucketConsumer(
                Document document = new Document();
                MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");  
                    }  
                    leafCollector.collect(3, 1L);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        createIndexSettings(),
                    IndexSearcher searcher = newIndexSearcher(reader);  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        .filter(bucket -> bucket.getKeyAsString().equals("store_a"))
                            .settings(
                    aggregator.postCollection();
        try (Directory directory = newDirectory()) {  
                indexWriter1.addDocument(doc);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        return null;
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        .filter(bucket -> bucket.getKeyAsString().equals("electronics"))
                        ),
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("iii"));
                        .filter(bucket -> bucket.getKeyAsString().equals("books"))
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    aggregator.postCollection();
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        null,
                indexWriter.addDocument(document);
                    leafCollector.collect(1, 0L);  
            }
 *
        TermsAggregationBuilder builder,
                    assertThat(result, notNullValue());  
            StringTerms.Bucket electronicsBucket = terms.getBuckets()
                }
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(names[i])));
                        doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                            .numberOfReplicas(0)  
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
            }
                    assertThat(result, notNullValue());
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));  
     * bucket ordinals and asserts the two resulting aggregations diverge.
                        .subAggregation(new SumAggregationBuilder("total_humidity").field("humidity"));
            assertThat(booksBucket.getDocCount(), equalTo(1L));
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("eee"));
                document.add(new SortedSetDocValuesField("store", new BytesRef("store_a")));  
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                        .shardSize(3)  
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));
                for (int i = 0; i < 2; i++) {  
                        .filter(bucket -> bucket.getKeyAsString().equals("laptop"))
            );  
                Map<String, Object> debugInfo = new HashMap<>();
    }  
                        .subAggregation(new MaxAggregationBuilder("max_temp").field("temperature"))  
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));  
        }
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
    public void testBuildAggregationsBatchWithSingleValuedOrds() throws Exception {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    aggregator.preCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    if (profile) {
    public void testNoSortOrder() throws Exception {
                    Min minHumidity = northBucket.getAggregations().get("min_humidity");  
                        fieldType
                        CardinalityUpperBound.MANY,  
                            .settings(
                ),
                    leafCollector.collect(2, 0L);
                        storeFieldType,  
                            .numberOfShards(1)
                        .filter(bucket -> bucket.getKeyAsString().equals("term_1"))
        }
                String[] names = { "cat_z", "cat_y", "cat_x", "cat_a", "cat_b", "cat_c", "cat_d", "cat_e", "cat_f", "cat_g" };
                    Min minInventory = storeABucket.getAggregations().get("min_inventory");
                        "First two buckets should be electronics and books",
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                    aggregator.postCollection();
                Document document = new Document();
     */  
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("rare"));
                for (int i = 0; i < terms.length; i++) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(p0Buckets.get(0).getKeyAsString(), equalTo("apple"));
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                    indexWriter1.addDocument(doc);
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher2));
                    Document document = new Document();  
                }
            }  
                .orElse(null);
                            .build(),
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
        }
                document.add(new NumericDocValuesField("rating", 3));
            }  
                    assertThat(minHumidity.getValue(), equalTo(80.0));  
                        null,
                        createIndexSettings(),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                aggregator.collectDebugInfo(debugCollector);  
                    assertThat(term1Bucket.getDocCount(), equalTo(3L));
                    StringTerms parent0 = (StringTerms) results[0];
                            .numberOfReplicas(0)  
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));  
    }
                        null,
                        IndexMetadata.builder("_index")
            }
                        Document doc = new Document();
                    List<StringTerms.Bucket> buckets = reduced.getBuckets();  
    public void testOrderByCardinalitySubAggregationAscending() throws Exception {
        return aggregator;
                        .order(BucketOrder.aggregation("unique_users", true))
                            DEFAULT_MAX_BUCKETS,  
                document.add(new NumericDocValuesField("price", 50));
                        null,
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(15L));
                        categoryFieldType,
                                Settings.builder()
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    for (int j = 0; j < counts[i]; j++) {
        try (Directory directory = newDirectory()) {  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("banana"));
        }
                    );  
                    // Test with minDocCount=3, should only return cat_2, cat_3, cat_4
                document.add(new NumericDocValuesField("price", 200));
                searcher,  
                doc = new Document();
                        .orElse(null);  
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_x"));  
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_5"));
                    int numDocs = 10 - i;
            assertThat(reduced, instanceOf(StringTerms.class));
                document.add(new SortedSetDocValuesField("field", new BytesRef("best")));  
                    for (StringTerms.Bucket bucket : result.getBuckets()) {  
                    assertThat(buckets.get(4).getDocCount(), equalTo(10L));
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
        CircuitBreakerService breakerService = mock(CircuitBreakerService.class);  
                    // With key order DESC, should return last 5 alphabetically: jjj, iii, hhh, ggg, fff
                        new MultiBucketConsumerService.MultiBucketConsumer(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
import org.opensearch.search.aggregations.metrics.Avg;
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                            DEFAULT_MAX_BUCKETS,  
                doc = new Document();
                        .orElse(null);
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        aggregationBuilder,
import org.opensearch.search.aggregations.metrics.Max;
                when(searchContext.getFlushMode()).thenReturn(FlushMode.PER_SEGMENT);
                indexWriter.commit(); // Ensure data is committed before reading  
                        indexWriter.flush();  
                        aggregationBuilder,
                        .findFirst()
                        .shardSize(3)
                    assertThat(cherry, notNullValue());
                        .findFirst()  
            StringTerms.Bucket electronicsBucket = terms.getBuckets().get(0);
                StreamStringTermsAggregator aggregator = createStreamAggregator(  
                        .shardSize(3)  
                        indexSearcher,
                        null,
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    aggregator.postCollection();  
                    Document document = new Document();
                            .numberOfShards(1)
                Document doc = new Document();
        try (Directory directory = newDirectory()) {  
                    assertThat(southBucket, notNullValue());
                }
                    minInventory = storeBBucket.getAggregations().get("min_inventory");  
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                    assertThat(totalHumidity.getValue(), equalTo(125.0));
                        ),
                    assertThat(card1.getValue(), equalTo(4L));  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    indexSearcher,  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
        try (Directory directory = newDirectory(); IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    aggregator.postCollection();  
            );
                fieldType1,
import java.util.HashMap;
                    SearchShardTask task = new SearchShardTask(0, "n/a", "n/a", "test-kind", null, null);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                indexWriter.addDocument(document);
                        ),
                        inventoryFieldType
            }
                    StringTerms.Bucket phoneBucket = result.getBuckets()
                        null,  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    Max maxTemp = northBucket.getAggregations().get("max_temp");  
import org.opensearch.core.index.shard.ShardId;  
                    Document doc = new Document();
                    InternalSum totalHumidity = northBucket.getAggregations().get("total_humidity");  
                    fieldType  
                        .filter(b -> b.getKeyAsString().equals("cherry"))  
import static org.mockito.Mockito.when;  
        }
            // Create second aggregation with overlapping data
            }  
                createIndexSettings(),
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("medium"));  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    assertThat(result, notNullValue());
                    Document doc = new Document();
                    // Parent 0 saw only "apple" docs.
                            .numberOfShards(1)
                        indexSearcher,  
    public void testOrderByMaxSubAggregationDescending() throws Exception {
                        .order(BucketOrder.aggregation("max_value", false))
                            .settings(  
                                Settings.builder()  
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {  
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import org.opensearch.search.aggregations.MultiBucketConsumerService;
    public void testSubAggregationWithMax() throws Exception {
import org.apache.lucene.index.IndexReader;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                        aggregationBuilder,
                            .queryResult();
                        productFieldType,  
        }
    public void testReduceWithSubAggregations() throws Exception {
                if (breakAllocations.get()) {
                            DEFAULT_MAX_BUCKETS,
                    );  
import org.opensearch.search.aggregations.AggregatorTestCase;
        try (Directory directory = newDirectory()) {  
                    assertThat(buckets.get(3).getDocCount(), equalTo(9L));
                    IndexSettings indexSettings = new IndexSettings(
                        userIdFieldType
                        fieldType  
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");  
                        Settings.EMPTY  
                    for (int j = 0; j <= i; j++) {
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                    aggregator.preCollection();
            assertThat(booksBucket, notNullValue());  
        StreamStringTermsAggregator aggregator;  
                for (int i = 3; i < 8; i++) {
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                        aggregationBuilder,
                    assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                            DEFAULT_MAX_BUCKETS,
                            DEFAULT_MAX_BUCKETS,
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                when(searchContext.isStreamSearch()).thenReturn(true);
                            .numberOfShards(1)
                        .orElse(null);  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
                document.add(new NumericDocValuesField("rating", 5));
                }  
                    );
                doc5.add(new SortedSetDocValuesField("category", new BytesRef("books")));  
                    aggregator.postCollection();
                            MultiBucketConsumerService.DEFAULT_MAX_BUCKETS,  
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    for (int j = 0; j < numDocs; j++) {  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        .orElse(null);
    }
import org.opensearch.search.internal.SearchContext;  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field").size(5);  
        }
                            .creationDate(System.currentTimeMillis())
            assertThat(terms.getBuckets().size(), equalTo(3));  
                    // Get the result and reduce it  
                document = new Document();  
                    assertThat(avgRating.getValue(), equalTo(4.5));  
                    aggregator.doReset();
                    // term_1 appears in docs 1,4,7 = 3 times  
                    assertThat(card1.getValue(), equalTo(14L));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            .numberOfReplicas(0)  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                        priceFieldType
                        createIndexSettings(),
                    final List<InternalAggregations> perSegAggs = new ArrayList<>();
                            )
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    assertThat(electronicsBucket.getDocCount(), equalTo(2L));
                // Alphabetically: aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii, jjj  
                }
                        null,  
                    StringTerms.Bucket electronicsBucket = result.getBuckets()
                        aggregationBuilder,
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                        indexWriter.flush();
                        salesFieldType
import org.opensearch.search.aggregations.InternalAggregations;
                indexWriter.addDocument(document);  
                        null,
                    );
                        .orElse(null);
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
/*  
            try (IndexReader indexReader = DirectoryReader.open(indexWriter)) {
    public void testMultipleBatches() throws Exception {
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                        aggregationBuilder,  
                    Aggregator aggregator = createStreamAggregator(
import org.opensearch.search.aggregations.BucketOrder;
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("bbb"));
                boolean isSegmented = false;  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("term_" + (i % 3))));  
                    assertThat(result.getBuckets().size(), equalTo(2));
                        .size(5)
                    int uniqueUsers = (i + 1) * 2;  
            // First aggregation
                    aggregator.postCollection();
                String[] names = { "cat_z", "cat_y", "cat_x", "cat_a", "cat_b", "cat_c", "cat_d", "cat_e", "cat_f", "cat_g" };  
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cherry"));  
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
                    createIndexSettings(),
                    ),
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                    InternalAggregation[] results = aggregator.buildAggregations(new long[] { 0L, 1L });
import java.util.function.BiConsumer;
                }
                        ),
                        createIndexSettings(),  
                    StringTerms.Bucket storeABucket = result.getBuckets()
                        .shardSize(5)
        try (Directory directory = newDirectory()) {
                String[] names = { "cat_z", "cat_y", "cat_x", "cat_a", "cat_b", "cat_c", "cat_d", "cat_e", "cat_f", "cat_g" };  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    StringTerms.Bucket northBucket = result.getBuckets()
                        .subAggregation(new MinAggregationBuilder("min_humidity").field("humidity"))
                            && (secondBucket.getKeyAsString().equals("electronics") || secondBucket.getKeyAsString().equals("books"))  
            }
                indexWriter.flush();
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    );
                Document document = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    indexWriter.addDocument(document);
                    // With key order ASC, should return first 5 alphabetically: aaa, bbb, ccc, ddd, eee
                for (int i = 0; i < 10; i++) {
                        aggregationBuilder,
                    assertThat(result, notNullValue());  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                }
                            .build(),
                indexWriter.addDocument(doc4);  
                document.add(new NumericDocValuesField("inventory", 200));  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    assertThat(result.getBuckets().size(), equalTo(0));
                    StringTerms.Bucket term0Bucket = buckets.stream()
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_8"));  
                            .numberOfShards(1)  
                doc.add(new SortedSetDocValuesField("category", new BytesRef(anotherCategory)));
        try (Directory directory = newDirectory()) {
                indexWriter.addDocument(document);
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };  
                        aggregationBuilder,
        try (Directory directory = newDirectory()) {
                        null,
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                    assertThat(buckets.get(0).getDocCount(), equalTo(7L));
                    StringTerms.Bucket secondBucket = buckets.get(1);  
import org.apache.lucene.util.BytesRef;  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                        aggregationBuilder,
                    assertThat(result, notNullValue());
                document.add(new SortedSetDocValuesField("product", new BytesRef("laptop")));
                Document doc = new Document();
                document = new Document();
                        doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                        .orElse(null);  
                            )
    }  
import org.opensearch.search.profile.Timer;
                    aggregator.postCollection();
                        .order(BucketOrder.key(false));
            public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {  
                    assertThat(card0.getValue(), equalTo(12L));
import org.opensearch.core.common.breaker.CircuitBreakingException;
                document.add(new NumericDocValuesField("humidity", 65));
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                    assertThat(result, notNullValue());
                    StringTerms.Bucket electronicsBucket = result.getBuckets()  
import org.opensearch.search.aggregations.metrics.Cardinality;
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("fff"));
                    assertThat(result.getBuckets().size(), equalTo(2));
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    assertThat(avgTemp.getValue(), equalTo(35.0));  
                    totalHumidity = southBucket.getAggregations().get("total_humidity");
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("inventory", 50));
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
                        PipelineTree.EMPTY
                        fieldType  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
        }  
                    // Now perform the reduce operation  
                    if (rarely()) {  
    }
                        null,  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        createIndexSettings(),  
        try (Directory directory = newDirectory()) {
                    );  
                indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(max0.getValue(), equalTo(304.0));
    }
                document.add(new NumericDocValuesField("inventory", 100));
                        .orElse(null);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    assertThat(result, notNullValue());
                    IndexSettings indexSettings = new IndexSettings(
                        indexSearcher,
                        categoryFieldType,
                    );
                        null,
                    assertThat(card2.getValue(), equalTo(2L));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").minDocCount(3);
                        fieldType  
                        fieldType  
            // First aggregation with multiple terms
 * compatible open source license.
                        .filter(bucket -> bucket.getKeyAsString().equals("north"))  
        aggregator = new ProfilingAggregator(aggregator, aggregationProfiler);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
     * {@code owningBucketOrd} passed into its leaf collector, so when it runs as a
                    assertThat(term2Bucket.getDocCount(), equalTo(3L));  
                document = new Document();
        IndexSearcher searcher
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_9"));
                        ),
    public void testSubAggregationWithMinAndCount() throws Exception {  
            assertThat(clothingBucket, notNullValue());
                null,  
                        ),
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_z"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                doc = new Document();
                document.add(new SortedSetDocValuesField("category", new BytesRef("books")));  
                    assertThat(card3.getValue(), equalTo(18L));
                        ),
                        indexWriter.addDocument(doc);
                    IndexSettings indexSettings = new IndexSettings(
                        indexSearcher,  
import org.opensearch.action.support.StreamSearchChannelListener;
                    List<StringTerms.Bucket> p0Buckets = parent0.getBuckets();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    aggregator.postCollection();  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    StringTerms.Bucket southBucket = result.getBuckets()  
                        .stream()  
                        fieldType  
                        );
                        ),
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                            Integer.MAX_VALUE,  
                    Document document = new Document();
                        categoryFieldType,  
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {  
                    assertThat(result, notNullValue());
        }  
            StringTerms terms = (StringTerms) reduced;
                            DEFAULT_MAX_BUCKETS,  
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
        try (Directory directory = newDirectory()) {
                Document document = new Document();
                indexWriter.addDocument(document);  
                    for (StringTerms.Bucket bucket : buckets) {
                    StringTerms.Bucket laptopBucket = result.getBuckets()
                indexWriter.addDocument(document);
            );
                document.add(new SortedSetDocValuesField("store", new BytesRef("store_b")));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                        .findFirst()  
import org.opensearch.index.mapper.MappedFieldType;  
                    assertThat("parent 1 should contain banana and cherry", p1Buckets.size(), equalTo(2));  
                        .subAggregation(new SumAggregationBuilder("total_sales").field("sales"));
                    assertThat(term2Bucket, notNullValue());
                    }
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
                        valueFieldType
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_3"));
                    assertThat(booksBucket.getDocCount(), equalTo(1L));  
                doc.add(new NumericDocValuesField("price", Long.MAX_VALUE));  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            for (String value : List.of("apple", "banana", "cherry")) {
                        createIndexSettings(),  
                    Cardinality card4 = buckets.get(4).getAggregations().get("unique_users");  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        createIndexSettings(),  
                        .findFirst()
                Document document = new Document();
                        .findFirst()  
                }
                indexWriter1.addDocument(doc);  
        }
                        categoryFieldType,  
                    aggs.add(  
                        .orElse(null);
                    indexWriter.addDocument(document);
            assertThat(electronicsBucket.getDocCount(), equalTo(2L));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                if (bucket.getKeyAsString().equals("cat_3") || bucket.getKeyAsString().equals("cat_4")) {  
                    assertThat(inventoryCount.getValue(), equalTo(1L));
                        (firstBucket.getKeyAsString().equals("electronics") || firstBucket.getKeyAsString().equals("books"))
                }
                        fieldType
                }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    }
                }
                            .numberOfReplicas(0)
                }
                        .stream()
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
                document.add(new SortedSetDocValuesField("region", new BytesRef("south")));
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                    int uniqueUsers = (i + 1) * 2; // cat_0=2, cat_1=4, ..., cat_9=20
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        .size(5)  
                        .filter(bucket -> bucket.getKeyAsString().equals("phone"))
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("aaa"));
                // By count: jjj(100), iii(90), hhh(80), ggg(70), fff(60), aaa(50), bbb(40), ccc(30), ddd(20), eee(10)
    public void testKeyOrderWithSizeLimitDropsCorrectBuckets() throws Exception {
                        ),  
                        createIndexSettings(),
                .findFirst()
                        .findFirst()  
                    null,
            // Second aggregation  
                        indexSearcher,
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                }
            }  
                document.add(new SortedSetDocValuesField("region", new BytesRef("north")));
            // Create first aggregation with some data
import static org.mockito.Mockito.mock;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    assertThat(max2.getValue(), equalTo(1004.0));  
                    assertThat(card0.getValue(), equalTo(6L));
                        indexSearcher,
                PipelineTree.EMPTY
                        indexSearcher,
                        ),
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");  
                // Collect debug info  
                        valueFieldType  
                return breakerBytes.addAndGet(bytes);
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
import static org.hamcrest.Matchers.equalTo;
                document.add(new SortedSetDocValuesField("product", new BytesRef("laptop")));
            aggregator = createStreamAggregator(
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("cat_4"));
                StreamStringTermsAggregator aggregator = createAggregator(aggregationBuilder, searchContext);  
    }
import org.apache.lucene.index.IndexWriterConfig;
                    }
                    assertThat(storeABucket, notNullValue());
        doAggOverManySegments(false);
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                    assertThat(maxTemp.getValue(), equalTo(35.0));  
                    aggregator.postCollection();
                    );
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
            public long addWithoutBreaking(long bytes) {
                for (String term : new String[] { "apple", "apple", "apple", "banana", "banana", "cherry" }) {
                    );
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                    assertThat(avgTemp.getValue(), equalTo(27.5));
            }
                            .numberOfReplicas(0)  
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                for (int i = 0; i < 10; i++) {
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import static org.hamcrest.Matchers.instanceOf;  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType inventoryFieldType = new NumberFieldMapper.NumberFieldType(  
                document.add(new SortedSetDocValuesField("field", new BytesRef(value)));  
                for (int i = 0; i < 3; i++) {
                document.add(new SortedSetDocValuesField("category", new BytesRef("books")));
import java.util.Map;
                    );
                // Alphabetically: aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii, jjj  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("stores").field("store")
                        .shardSize(5)  
            StringTerms.Bucket booksBucket = terms.getBuckets()
                        indexSearcher,  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");  
                indexWriter2.addDocument(doc);  
                }
                        tempFieldType,
                }
                    );  
                        searcher,
                for (int i = 0; i < 10; i++) {
    public void testReduceSimple() throws Exception {  
                        null,
        }
                        indexSearcher,
                        new MultiBucketConsumerService.MultiBucketConsumer(
    }
                    // NOT the top 5 by doc count (zzz, yyy, xxx, www, vvv)  
    public void testKeyOrderDescendingWithSizeLimitDropsCorrectBuckets() throws Exception {
                    }
                    aggregator.preCollection();
                    assertThat(max2.getValue(), equalTo(104.0));  
    private InternalAggregation buildInternalStreamingAggregation(
                        categoryFieldType
import org.opensearch.search.streaming.FlushMode;  
                document.add(new NumericDocValuesField("sales", 500));
                    assertThat(firstBucket.getDocCount(), equalTo(2L));  
    }
    private static Aggregator wrapByProfilingAgg(Aggregator aggregator) throws IOException {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher2));
                    }  
            }  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                Document doc3 = new Document();  
 * The OpenSearch Contributors require contributions made to  
                fieldType2  
                    );
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                document.add(new SortedSetDocValuesField("field", new BytesRef("rare")));
                    InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(  
                        ),
                        Settings.EMPTY
                            .build(),
                .stream()  
                    );
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
            }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    // Returned in alphabetical order at shard level  
                }  
                    );
import org.opensearch.search.aggregations.CardinalityUpperBound;  
                        ),
                        aggregationBuilder,
            }  
            }
                    if (rarely()) {
                    doc.add(new NumericDocValuesField("value", (i + 1) * 100));  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("common"));  
                        indexSearcher,
                    MappedFieldType tempFieldType = new NumberFieldMapper.NumberFieldType("temperature", NumberFieldMapper.NumberType.LONG);
                    // NOT the top 5 by doc count  
                    IndexSettings indexSettings = new IndexSettings(
                    assertThat(totalDocs, equalTo(5L));
                    assertThat(buckets.size(), equalTo(5));  
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    MappedFieldType humidityFieldType = new NumberFieldMapper.NumberFieldType(
                for (int i = 0; i < 3; i++) {  
    }
                            .numberOfReplicas(0)
    public void testBuildAggregationsBatchWithCountOrder() throws Exception {  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
            StringTerms terms = (StringTerms) reduced;
                indexWriter.addDocument(document);
                for (int i = 0; i < 5; i++) {
                    indexWriter.addDocument(document);  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
    }  
                }
                        .order(BucketOrder.count(false));  
                    assertThat(electronicsBucket, notNullValue());
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
                    maxPrice = booksBucket.getAggregations().get("max_price");
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    aggregator.postCollection();  
                    IndexSettings indexSettings = new IndexSettings(  
                    avgRating = phoneBucket.getAggregations().get("avg_rating");
                        InternalAggregations internalAggregations = querySearchResult.aggregations().expand();  
                    assertThat(result.getBuckets().size(), equalTo(2));  
                        .stream()  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                    totalSales = booksBucket.getAggregations().get("total_sales");  
            // Reduce the aggregations
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                    assertThat(results.length, equalTo(2));
                    );  
                indexWriter.addDocument(document);
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_x"));
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_y"));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            DEFAULT_MAX_BUCKETS,
        aggregator.postCollection();
                }
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    );
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                        PipelineTree.EMPTY  
            }  
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field("string");
                    assertThat(buckets.get(4).getKeyAsString(), equalTo("cat_9"));  
                            )  
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        perSegAggs.add(internalAggregations);
                b -> {},
import org.opensearch.search.SearchShardTarget;
                        doc.add(new SortedSetDocValuesField("field", new BytesRef(terms[i])));
                    InternalSum totalSales = electronicsBucket.getAggregations().get("total_sales");  
                Document doc = new Document();
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    SearchShardTarget searchShardTarget = new SearchShardTarget(
                        indexSettings,  
                        userIdFieldType  
    public void testBuildAggregationsBatchWithSize() throws Exception {
    public void testCandidateBucketsUseRequestCircuitBreaker() throws Exception {
import org.opensearch.common.util.MockBigArrays;
                    int numDocs = 5;
                    assertThat(card4.getValue(), equalTo(20L));
            // Reduce the aggregations  
                        DEFAULT_MAX_BUCKETS,  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    aggregator.postCollection();
            }
import java.util.ArrayList;  
                        .orElse(null);  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    StringTerms parent1 = (StringTerms) results[1];
    public void testSubAggregationWithAvg() throws Exception {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                document.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
                        .order(BucketOrder.key(true));
                document = new Document();
                    // Verify otherDocCount: total=55 docs (10+9+8+7+6+5+4+3+2+1), selected=40 (10+9+8+7+6), other=15  
                for (int i = 0; i < 10; i++) {  
                        .findFirst()
    }
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("cat_6"));  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                                Settings.builder()  
                indexWriter.addDocument(document);
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    assertThat(result, notNullValue());  
                        "inventory",
                .stream()
                    assertThat(card2.getValue(), equalTo(16L));  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                // Create 10 categories where TOP 3 by max ASC won't be alphabetically first
                    StreamSearchChannelListener listenerMock = mock(StreamSearchChannelListener.class);  
                }
                    StringTerms.Bucket booksBucket = result.getBuckets()  
                    assertThat(buckets.size(), equalTo(3));
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                document = new Document();
import static org.hamcrest.Matchers.lessThan;
import org.opensearch.search.profile.aggregation.ProfilingAggregator;
                document = new Document();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            List<InternalAggregation> aggs = new ArrayList<>();  
                assertTrue("Should contain result_strategy", debugInfo.containsKey("result_strategy"));
            }
                        aggregationBuilder,
                                Settings.builder()
                    assertThat(buckets.get(2).getDocCount(), equalTo(8L));  
                            DEFAULT_MAX_BUCKETS,  
                for (int i = 0; i < 10; i++) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));  
import static org.hamcrest.Matchers.empty;
                    );
                iw.addDocument(document);
                        indexWriter.addDocument(doc);
                }  
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                document.add(new SortedSetDocValuesField("store", new BytesRef("store_a")));
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher1)  
                    leafCollector.collect(0, 0L);
                    indexWriter.addDocument(document);  
                        Settings.EMPTY  
                    // Execute the aggregator  
                document.add(new SortedSetDocValuesField("field", new BytesRef("batch1")));  
                    List<StringTerms.Bucket> buckets = result.getBuckets();  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
        }  
                    assertThat(result, notNullValue());
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                SearchContext searchContext = createSearchContext(
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
                        aggregationBuilder,
                        .findFirst()  
                    StringTerms.Bucket cherry = p1Buckets.stream()
import org.apache.lucene.document.NumericDocValuesField;
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            assertThat(electronicsBucket, notNullValue());
                    assertThat(  
                        ),
                    IndexSearcher searcher1 = newIndexSearcher(reader1);  
                        valueFieldType  
            }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        p0Buckets.size() == p1Buckets.size() && p0Buckets.get(0).getKeyAsString().equals(p1Buckets.get(0).getKeyAsString()),
                        .subAggregation(new MinAggregationBuilder("min_inventory").field("inventory"))  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        indexWriter.addDocument(doc);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));  
                    for (int j = 0; j < numDocs; j++) {  
                        indexSearcher,  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        indexSettings,
                // Create 10 categories with varying cardinality (size=5, total=10)
    public void testBuildAggregationsBatchDirectBucketCreation() throws Exception {  
                    DEFAULT_MAX_BUCKETS,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
                    );
            for (StringTerms.Bucket bucket : terms.getBuckets()) {
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        IndexMetadata.builder("_index")
                    assertThat(secondBucket.getDocCount(), equalTo(2L));
                    List<StringTerms.Bucket> buckets = result.getBuckets();
import org.apache.lucene.search.IndexSearcher;
        aggregator.preCollection();
                    indexWriter.addDocument(doc);
                new MultiBucketConsumerService.MultiBucketConsumer(
                    );
                    StringTerms.Bucket banana = p1Buckets.stream()
        return buildInternalStreamingAggregation(builder, fieldType1, null, searcher);  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        fieldType
                        .order(BucketOrder.key(true));
                }
                    assertThat(max0.getValue(), equalTo(804.0));
                            DEFAULT_MAX_BUCKETS,
                    StringTerms reduced = (StringTerms) topLevel.reduce(Collections.singletonList(topLevel), context);
                        ),
import org.opensearch.search.aggregations.metrics.InternalSum;  
                    // term_2 appears in docs 2,5,8 = 3 times
            StringTerms.Bucket clothingBucket = terms.getBuckets()  
        try (Directory directory = newDirectory()) {  
                    assertThat(term0Bucket, notNullValue());  
                        aggregator.context().bigArrays(),
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));
                        .findFirst()
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
            }  
 * SPDX-License-Identifier: Apache-2.0
                    indexWriter.addDocument(document);
import java.util.concurrent.atomic.AtomicLong;  
        try (Directory directory = newDirectory()) {
                        aggregationBuilder,  
    }  
                        valueFieldType
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("common"));
    }  
                            .settings(  
    }  
                        Document doc = new Document();  
import org.opensearch.search.query.QuerySearchResult;
            }
                // cat_z=100, cat_y=200, cat_x=300, cat_a=400, ...
                doc.add(new NumericDocValuesField("price", 200));
        AtomicBoolean breakAllocations = new AtomicBoolean();
                        Document doc = new Document();
                        Settings.EMPTY
                                Settings.builder()
                        indexWriter.addDocument(doc);
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                Document doc5 = new Document();
                indexWriter.addDocument(document);
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(names[i])));
                        indexSettings,
                );
                    createIndexSettings(),
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    assertThat(bucket.getDocCount(), equalTo(2L));
                        .orElse(null);
 */  
                    StringTerms.Bucket storeBBucket = result.getBuckets()
                // Create categories with varying doc counts: cat_0=1, cat_1=2, cat_2=3, cat_3=4, cat_4=5  
                    aggregator.postCollection();  
                breakAllocations.set(true);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
                        new MultiBucketConsumerService.MultiBucketConsumer(  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_7"));  
                    Document doc = new Document();  
                            .settings(
            );
                    );
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("cat_8"));
            // Reduce the aggregations
    }
                    aggregator.postCollection();
        when(aggregationProfileBreakdown.getTimer(any())).thenReturn(mock(Timer.class));
                }  
                document = new Document();
                    List<StringTerms.Bucket> buckets = result.getBuckets();
    public void testBuildAggregationsWithContextSearcherNoProfile() throws Exception {
                // cat_z=10 docs (highest), cat_y=9, cat_x=8, cat_a=7, cat_b=6, cat_c=5, cat_d=4, cat_e=3, cat_f=2, cat_g=1 (lowest)
                    assertThat(buckets.get(1).getKeyAsString(), equalTo("medium"));
import org.opensearch.search.internal.ContextIndexSearcher;
                        null,  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(storeBBucket.getDocCount(), equalTo(1L));
                    // Drive collection manually so we can hand different owningBucketOrds
                    aggregator.postCollection();
                            .numberOfShards(1)
                    Document document = new Document();  
            }
                    assertThat(buckets.size(), equalTo(5));  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher1));
                for (int i = 0; i < 2; i++) {
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                        IndexMetadata.builder("_index")
                getMockScriptService(),
                        createIndexSettings(),
                        null,
                    }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        indexSettings,  
                    indexWriter.addDocument(document);
                        ),
import java.util.List;  
                    );
                            .settings(
import org.opensearch.search.fetch.QueryFetchSearchResult;
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    assertThat("parent 0 should only contain apple", p0Buckets.size(), equalTo(1));  
                        .stream()
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                            .creationDate(System.currentTimeMillis())  
                doc.add(new SortedSetDocValuesField("category", new BytesRef("electronics")));
                PipelineTree.EMPTY
                    // Verify otherDocCount: cat_0=1 + cat_1=2 = 3 docs excluded
    public void testMinDocCount() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
                doc4.add(new SortedSetDocValuesField("category", new BytesRef("clothing")));
    public void testBuildAggregationsWithContextSearcherProfile() throws Exception {
                    );  
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(  
            }  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                indexWriter.addDocument(document);
                        .order(BucketOrder.count(false));  
                    // Verify otherDocCount: 10 categories * 1 doc = 10 total, selected 3*1=3, other=7
                indexWriter.addDocument(document);
                    assertThat(result, notNullValue());
import java.util.concurrent.atomic.AtomicBoolean;
                    when(searchContext.getStreamChannelListener()).thenReturn(listenerMock);
                    // Parent 1 saw the banana + cherry docs.
                assertTrue("Should contain segments_with_single_valued_ords", debugInfo.containsKey("segments_with_single_valued_ords"));
                    aggregator.preCollection();  
        if (fieldType2 != null) {
                        .orElse(null);
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("apple"));
                        Settings.EMPTY  
    }
                document.add(new SortedSetDocValuesField("field", new BytesRef("cherry")));
                    assertThat(totalSales.getValue(), equalTo(500.0));
            // Second aggregation with different terms
                        assertThat(bucket.getKeyAsString().startsWith("term_"), equalTo(true));  
                        .order(BucketOrder.key(true));
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.preCollection();  
                    assertThat(storeABucket.getDocCount(), equalTo(2L));
    }
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    inventoryCount = storeBBucket.getAggregations().get("inventory_count");  
                }
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                    }  
                        .stream()
                        indexWriter.addDocument(doc);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
        }
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
            }  
    }
                        createIndexSettings(),
                    // Verify otherDocCount: 10 categories * 5 docs = 50 total, selected 3*5=15, other=35
                        aggregationBuilder,  
                }  
                    assertThat(electronicsBucket, notNullValue());
                    DEFAULT_MAX_BUCKETS,  
                        null,
                    aggregator.postCollection();
        }
                        .subAggregation(new AvgAggregationBuilder("avg_temp").field("temperature"))
                // Create 10 categories with varying max values (size=3, total=10)
                        categoryFieldType,
                }
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(30L));
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("cat_y"));
                    throw new CircuitBreakingException("test error", bytes, Long.MAX_VALUE, Durability.TRANSIENT);
                document = new Document();
                indexWriter.addDocument(doc2);
    }
import org.opensearch.Version;
                        b -> {},
                    assertThat(maxPrice.getValue(), equalTo(200.0));
                    avgTemp = southBucket.getAggregations().get("avg_temp");
import org.opensearch.search.profile.aggregation.AggregationProfiler;  
                    assertThat(buckets.get(3).getKeyAsString(), equalTo("ddd"));
import java.util.Collections;
                        .findFirst()  
                        ),  
                            .creationDate(System.currentTimeMillis())
                        .order(BucketOrder.count(false)); // Order by count descending
                    );  
        }
                    assertThat(result.getBuckets().size(), equalTo(2));  
                    List<StringTerms.Bucket> buckets = result.getBuckets();
                }  
                doc.add(new SortedSetDocValuesField("category", new BytesRef("clothing")));  
                    // Default order is count DESC, so top 5 should be cat_z, cat_y, cat_x, cat_a, cat_b (highest counts)
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    for (StringTerms.Bucket bucket : buckets) {  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                        IndexMetadata.builder("_index")  
                // cat_z=2, cat_y=4, cat_x=6, cat_a=8, cat_b=10, cat_c=12, cat_d=14, cat_e=16, cat_f=18, cat_g=20  
                            )
                    assertThat(firstBatch.getBuckets().get(0).getKeyAsString(), equalTo("batch1"));
    public void testOrderByCardinalitySubAggregationDescending() throws Exception {
                                Settings.builder()  
import org.opensearch.search.fetch.FetchSearchResult;  
import static org.mockito.ArgumentMatchers.any;
                    MappedFieldType salesFieldType = new NumberFieldMapper.NumberFieldType("sales", NumberFieldMapper.NumberType.LONG);
                String[] terms = { "jjj", "iii", "hhh", "ggg", "fff", "aaa", "bbb", "ccc", "ddd", "eee" };
        try (Directory directory = newDirectory()) {  
                        null,
                    assertThat(northBucket, notNullValue());  
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            }
        CircuitBreaker requestBreaker = new NoopCircuitBreaker(CircuitBreaker.REQUEST) {
                    assertThat(result.getBuckets().size(), equalTo(3));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    assertThat(storeBBucket, notNullValue());  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            DEFAULT_MAX_BUCKETS,
                long baselineBytes = breakerBytes.get();  
        try (Directory directory = newDirectory()) {
                        getMockScriptService(),
                    leafCollector.collect(4, 1L);  
                        ),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
            assertThat(electronicsBucket.getDocCount(), equalTo(3L));  
                    for (int j = 0; j < counts[i]; j++) {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        createIndexSettings(),
    public void testThrowOnManySegments() throws Exception {
                    assertThat(result, notNullValue());
                        "parent 0 and parent 1 must produce distinct inner bucket sets",
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    aggregator.preCollection();
import org.apache.lucene.document.Document;
                    assertThat(booksBucket, notNullValue());
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
                    InternalAggregations summary = InternalAggregations.reduce(perSegAggs, ctx);
        IndexSearcher searcher
                String anotherCategory = "clashing value to break on segments";  
                    assertThat(inventoryCount.getValue(), equalTo(2L));
import org.apache.lucene.document.SortedSetDocValuesField;  
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
            }
                        ),  
                        createIndexSettings(),
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));
                            .settings(  
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");  
    }  
                    aggregator.preCollection();  
                    int numDocs = 5;
                    searcher.search(new MatchAllDocsQuery(), aggregator);  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                document.add(new SortedSetDocValuesField("product", new BytesRef("phone")));  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        indexSearcher,  
                        IndexMetadata.builder("_index")
                    assertThat(max1.getValue(), equalTo(904.0));
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                    Document document = new Document();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                .orElse(null);  
                        ),
                            .creationDate(System.currentTimeMillis())
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                        .size(3)
    public void testReduceWithSizeLimit() throws Exception {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        IndexMetadata.builder("_index")
                        null,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                }
                                Settings.builder()
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    }  
                }  
                            )  
                        LeafBucketCollector.NO_OP_COLLECTOR  
                        doc.add(new SortedSetDocValuesField("field", new BytesRef(terms[i])));
        try (Directory directory = newDirectory()) {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                            )
                        fieldType
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                        fieldType
                    StringTerms.Bucket thirdBucket = buckets.get(2);
                    );
                Document document = new Document();  
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                Document doc1 = new Document();
            }
                    assertThat(buckets.get(0).getKeyAsString(), equalTo("cat_2"));  
                        ),
                        .size(3)
                            .creationDate(System.currentTimeMillis())  
                null,
        };
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);  
        try (Directory directory = newDirectory()) {  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                            .build(),
                    StreamStringTermsAggregator aggregator = createStreamAggregator(
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    StringTerms firstResult = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType productFieldType = new KeywordFieldMapper.KeywordFieldType("product");  
        try (Directory directory = newDirectory()) {
     * sub-aggregator under a parent terms aggregator every parent bucket ends up  
                    StringTerms result = (StringTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                Document document = new Document();  
                document = new Document();
                    assertThat(phoneBucket, notNullValue());
            }
                return breakerBytes.addAndGet(bytes);  
            aggregator = createStreamAggregator(  
                        .orElse(null);
                    List<StringTerms.Bucket> buckets = result.getBuckets();  
                    );
    public void testOrderByMaxAscending() throws Exception {
                        new MultiBucketConsumerService.MultiBucketConsumer(
            assertThat(reduced, instanceOf(StringTerms.class));  
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(98L));
                    StringTerms.Bucket term1Bucket = buckets.stream()  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    // parent buckets: ord 0 gets the "apple" docs, ord 1 gets the rest.  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                String[] terms = { "zzz", "yyy", "xxx", "www", "vvv", "aaa", "bbb", "ccc", "ddd", "eee" };
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    StreamStringTermsAggregator aggregator = createStreamAggregator(  
                    for (int j = 0; j < uniqueUsers; j++) {
                    List<StringTerms.Bucket> buckets = result.getBuckets();  
                    fieldType
                }  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                            .creationDate(System.currentTimeMillis())
                for (int i = 0; i < 10; i++) {  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                indexWriter.addDocument(document);  
            }
        TermsAggregationBuilder builder,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                    }).when(listenerMock).onStreamResponse(any(), anyBoolean());  
import org.opensearch.search.aggregations.metrics.Min;  
                        .stream()  
                    Document doc = new Document();
package org.opensearch.search.aggregations.bucket.terms;
                    long totalDocs = buckets.stream().mapToLong(StringTerms.Bucket::getDocCount).sum();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
        try (Directory directory = newDirectory()) {
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher2)
                }
                    List<StringTerms.Bucket> buckets = result.getBuckets();  
                    aggregator.preCollection();
            }
                        IndexMetadata.builder("_index")
                assertEquals("streaming_terms", debugInfo.get("result_strategy"));  
                    assertThat(buckets.get(2).getKeyAsString(), equalTo("hhh"));  
                getMockScriptService(),
                }
import static org.mockito.Mockito.doAnswer;
                            DEFAULT_MAX_BUCKETS,
        }
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=6+4+2=12, other=98  
                        null,  
                document = new Document();  
                .orElse(null);
                    // to the aggregator, mimicking a parent terms aggregator with two
            }
                        new MultiBucketConsumerService.MultiBucketConsumer(
    }  
                }
                    );
                            DEFAULT_MAX_BUCKETS,  
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(7L));
                document = new Document();  
                    assertThat(booksBucket, notNullValue());
                    document.add(new SortedSetDocValuesField("field", new BytesRef("common")));
                    aggregator.postCollection();
                    aggregator.preCollection();
                }
                }  
                        indexSearcher,  
    ) throws IOException {
            }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(3L));
        }
                        aggregationBuilder,
                BiConsumer<String, Object> debugCollector = debugInfo::put;
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                .filter(bucket -> bucket.getKeyAsString().equals("clothing"))
                    assertThat(banana.getDocCount(), equalTo(2L));
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                        null,
                    aggregator.postCollection();  
                    assertThat(secondResult.getBuckets().get(0).getDocCount(), equalTo(1L));
