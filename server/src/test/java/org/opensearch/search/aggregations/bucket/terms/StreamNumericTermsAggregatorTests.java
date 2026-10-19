                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    );
                            .build(),
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(results.length, equalTo(1));  
        try (Directory directory = newDirectory()) {  
                    assertThat(maxTemp.getValue(), equalTo(30.0));
                            .numberOfShards(1)
                    InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                        .shardSize(5)  
                        .orElse(null);  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
            }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        indexWriter.addDocument(doc);
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
    }  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").minDocCount(3);  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );
                        aggregationBuilder,
                    MappedFieldType scoreFieldType = new NumberFieldMapper.NumberFieldType("score", NumberFieldMapper.NumberType.LONG);
                    assertEquals(1L, buckets.get(1).getKeyAsNumber().longValue());  
                document.add(new NumericDocValuesField("humidity", 60));
                            .settings(  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("prices").field("price")
                doc.add(new NumericDocValuesField("value", 60));  
                            DEFAULT_MAX_BUCKETS,
                    }
                    );
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        Settings.EMPTY  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                            .numberOfShards(1)  
                    assertEquals(50.0, ((InternalSum) buckets.get(0).getAggregations().get("sum_value")).getValue(), 0.001);  
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    doc.add(new NumericDocValuesField("category", 1));
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                        long expectedKey = i;
                        NumberFieldMapper.NumberType.LONG  
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");  
                    aggregator.preCollection();
        }  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertThat(category2Bucket.getDocCount(), equalTo(1L));  
                            DEFAULT_MAX_BUCKETS,  
                    assertThat(result, notNullValue());
                for (int i = 0; i < 3; i++) {  
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(buckets.get(3).getKeyAsNumber().longValue(), equalTo(8L));  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                Document document = new Document();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        .shardSize(5)
            );  
                }  
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                    int uniqueUsers = (i + 1) * 2; // cat_0=2, cat_1=4, ..., cat_9=20
                .orElse(null);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
        try (Directory directory = newDirectory()) {
                        null,
                    MappedFieldType tempFieldType = new NumberFieldMapper.NumberFieldType("temperature", NumberFieldMapper.NumberType.LONG);
                    List<LongTerms.Bucket> buckets = result.getBuckets();  
                        fieldType
                        "category",
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("ids").field("id")
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .subAggregation(new MinAggregationBuilder("min_inventory").field("inventory"))  
                document = new Document();  
                            DEFAULT_MAX_BUCKETS,
            }
                    MappedFieldType ratingFieldType = new NumberFieldMapper.NumberFieldType("rating", NumberFieldMapper.NumberType.LONG);
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                    LongTerms.Bucket category2Bucket = result.getBuckets()  
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(  
                Document document = new Document();
                        null,
    public void testSubAggregationWithMinAndCount() throws Exception {  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                indexWriter.addDocument(document);
import static org.hamcrest.Matchers.equalTo;
            }  
                    Avg avgTemp = region1Bucket.getAggregations().get("avg_temp");  
                        Document doc = new Document();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    Document document = new Document();  
                        scoreFieldType
                // Category 0: values 10, 20 (avg=15)  
                    aggregator.postCollection();
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    // Verify otherDocCount: category 0=1 + category 1=2 = 3 docs excluded
            LongTerms terms = (LongTerms) reduced;
                    assertThat(buckets.get(0).getDocCount(), equalTo(2L));  
                                Settings.builder()
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                        .size(3)
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        exception.getMessage(),  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
    public void testMultiValuedField() throws Exception {
            // Reduce the aggregations
                    assertThat(max0.getValue(), equalTo(800.0));
                        .findFirst()  
                        priceFieldType,
                    for (int j = 0; j < numDocs; j++) {  
import org.apache.lucene.util.BytesRef;
                        .shardSize(5)
            }  
                        NumberFieldMapper.NumberType.LONG  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                document = new Document();
                    );
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        NumberFieldMapper.NumberType.BYTE };
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
                        new MultiBucketConsumerService.MultiBucketConsumer(
                indexWriter.addDocument(document);
                        createIndexSettings(),
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher2));
                }  
                indexWriter.addDocument(document);
                        (firstBucket.getKeyAsNumber().longValue() == 1L || firstBucket.getKeyAsNumber().longValue() == 2L)  
                        Settings.EMPTY
            }
                            .build(),
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(term2Bucket.getDocCount(), equalTo(3L));
                // Category 0: 3 docs with value 10 each (sum=30)
    }  
                        ),
                        .shardSize(2)  
    }  
                        Document d = new Document();
                    }
        aggregator.postCollection();
                        categoryFieldType,  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        indexSettings,
                        valueFieldType
                    );
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        indexWriter.addDocument(d);
                for (int i = 0; i < 3; i++) {
                        indexSearcher,  
                    aggregator.postCollection();  
                    assertEquals(2L, result.getSumOfOtherDocCounts());
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                document = new Document();
    public void testOrderByAvgSubAggregation() throws Exception {  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    public void testDoubleTermsSubAggregationTieBreaking() throws Exception {
                        aggregationBuilder,
        }
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.apache.lucene.search.MatchAllDocsQuery;
                        indexSettings,
                    assertThat(max0.getValue(), equalTo(104.0));  
                            && !firstBucket.getKeyAsNumber().equals(secondBucket.getKeyAsNumber())
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    aggregator.preCollection();  
                    assertThat(firstResult.getBuckets().size(), equalTo(1));  
                }
                    aggregator.postCollection();
                    int uniqueUsers = (i + 1) * 2;
                indexWriter.addDocument(doc5);  
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                        ),
                    IndexSettings indexSettings = new IndexSettings(
import org.opensearch.index.mapper.NumberFieldMapper;
                Document document = new Document();
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 200L)
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                    assertThat(result, notNullValue());
                indexWriter.addDocument(document);
    public void testSubAggregationWithAvg() throws Exception {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        .order(BucketOrder.key(true));
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
            }
                        .orElse(null);
                            DEFAULT_MAX_BUCKETS,  
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                doc = new Document();
                    IndexSettings indexSettings = new IndexSettings(  
                            )
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                document.add(new SortedNumericDocValuesField("tags", 2));  
                        NumberFieldMapper.NumberType.LONG  
                    List<LongTerms.Bucket> buckets = result.getBuckets();
    }
                long[] terms = { 95, 94, 93, 92, 91, 1, 2, 3, 4, 5 };  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        .order(BucketOrder.aggregation("max_value", true))
                    InternalSum totalQuantity = price999Bucket.getAggregations().get("total_quantity");
                    assertThat(results[0], instanceOf(LongTerms.class));
                    assertThat(secondBucket.getDocCount(), equalTo(2L));  
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                        .shardSize(2)  
                    // Default order is count DESC, so top 5 should be 9, 8, 7, 6, 5 (highest counts)
                    document.add(new NumericDocValuesField("field", 200));
                        .stream()  
                }
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
    }
                    InternalSum totalHumidity = region1Bucket.getAggregations().get("total_humidity");  
        try (Directory directory = newDirectory()) {
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)  
        }
                document = new Document();
                        ),  
                        .put("index.aggregation.streaming.min_segment_size", 1)
                        .order(BucketOrder.key(true));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
    public void testUnsignedLongTermsResults() throws Exception {  
                }  
                indexWriter.addDocument(doc);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
                        Settings.EMPTY
                        indexSettings,
                    assertThat(region1Bucket, notNullValue());  
                        .findFirst()
                        .shardSize(2)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.preCollection();
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.FLOAT);
                document.add(new NumericDocValuesField("humidity", 65));
                    IndexSettings indexSettings = new IndexSettings(
                    assertThat(term1Bucket, notNullValue());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                document.add(new NumericDocValuesField("category", 1));
                Document document = new Document();
                        "inventory",
                    doc.add(new NumericDocValuesField("category", i));
                }
                        createIndexSettings(),
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    assertEquals(3L, result.getSumOfOtherDocCounts());
                            .numberOfShards(1)  
                        getMockScriptService(),
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    );
                    assertThat(result.getBuckets().size(), equalTo(2));  
                    assertThat(result.getBuckets().size(), equalTo(2));  
                doc.add(new NumericDocValuesField("price", 100));
                    assertThat(result, notNullValue());  
                }
                        NumberFieldMapper.NumberType.LONG  
                    }
                null,  
    }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                    aggregator.postCollection();  
                        .stream()  
                }  
                    }
                    }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("number")
                        aggregationBuilder,  
                                Settings.builder()
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
    }
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    Avg avgRating = product100Bucket.getAggregations().get("avg_rating");
        try (Directory directory = newDirectory()) {
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    // Now perform the reduce operation
                        indexSettings,  
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        storeFieldType,  
                            .creationDate(System.currentTimeMillis())
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                        IndexMetadata.builder("_index")
                            .settings(
                    assertThat(buckets.get(3).getDocCount(), equalTo(9L));
            }
                            new MultiBucketConsumerService.MultiBucketConsumer(
                    MappedFieldType regionFieldType = new NumberFieldMapper.NumberFieldType("region", NumberFieldMapper.NumberType.LONG);  
                    );  
                Document doc = new Document();  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    }  
                indexWriter.addDocument(document);  
                document.add(new NumericDocValuesField("field", 300));  
                for (long key = 0; key < 20; key++) {  
        try (Directory directory = newDirectory()) {  
                    MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.DOUBLE);
                    );
    public void testMultipleOwningBucketOrds() throws Exception {  
                .findFirst()  
        }
                    assertThat(buckets.get(1).getDocCount(), equalTo(1L));
    ) throws IOException {
                doc.add(new NumericDocValuesField("value", 50));
                .stream()
                indexWriter.addDocument(document);
                    );
                BiConsumer<String, Object> debugCollector = debugInfo::put;
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        categoryFieldType,
                            DEFAULT_MAX_BUCKETS,
                        indexWriter.addDocument(doc);  
                    assertThat(result, notNullValue());
                            .build(),  
                }
                    totalSales = category2Bucket.getAggregations().get("total_sales");  
                    Max max1 = buckets.get(1).getAggregations().get("max_qty");
        }  
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher2));  
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(2L));
                        indexSettings,
                }  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(result.getBuckets().size(), equalTo(0));  
                            .creationDate(System.currentTimeMillis())
                        ),
                        createIndexSettings(),  
                    avgTemp = region2Bucket.getAggregations().get("avg_temp");
                        () -> aggregator.buildAggregations(new long[] { 0 })  
                document.add(new NumericDocValuesField("field", 3));
                }  
                fieldType1,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
import org.opensearch.search.aggregations.metrics.InternalSum;
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                indexWriter.commit(); // Ensure data is committed before reading
    }
                document = new Document();
                indexWriter.addDocument(document);
                        .shardSize(2)
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        indexSearcher,  
                    assertTrue(
                        aggregationBuilder,
                        .subAggregation(new MaxAggregationBuilder("max_score").field("score"));
                    );
                    Min minInventory = store1Bucket.getAggregations().get("min_inventory");
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                        null,  
                }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        Document doc = new Document();
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");
        }  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        fieldType  
                        null,  
                        "number",  
                document.add(new NumericDocValuesField("product", 100));
                    );
                            DEFAULT_MAX_BUCKETS,
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    assertThat(result, notNullValue());
                    );
import org.opensearch.search.aggregations.AggregatorTestCase;
                indexWriter.addDocument(document);
                b -> {},
                    aggregator.preCollection();
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
import java.util.HashMap;
                document.add(new NumericDocValuesField("inventory", 50));
        }  
                    }
                }  
                        categoryFieldType,  
        try (Directory directory = newDirectory()) {  
import org.opensearch.search.aggregations.metrics.Avg;  
                    List<LongTerms.Bucket> buckets = result.getBuckets();
import org.opensearch.index.mapper.MappedFieldType;  
                    assertThat(result.getBuckets().size(), equalTo(2));
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                            )
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        aggregationBuilder,
                    Document doc = new Document();
                        .filter(b -> b.getKeyAsNumber().longValue() == Long.MAX_VALUE)
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));  
                    Document document = new Document();  
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("stores").field("store")
                    MappedFieldType inventoryFieldType = new NumberFieldMapper.NumberFieldType(  
                            && (secondBucket.getKeyAsNumber().longValue() == 1L || secondBucket.getKeyAsNumber().longValue() == 2L)
                document.add(new NumericDocValuesField("region", 1));
        try (Directory directory = newDirectory()) {
                        .findFirst()
                    aggregator.postCollection();
                        "category",
                // Category 2: 4 docs with value 20 each (sum=80)  
                    assertThat(totalSales.getValue(), equalTo(500.0));
            }
                    minHumidity = region2Bucket.getAggregations().get("min_humidity");
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(Long.MAX_VALUE - 2));
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    LongTerms.Bucket region1Bucket = result.getBuckets()
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.DOUBLE);  
                document.add(new NumericDocValuesField("sales", 1000));
                }
        }  
                    aggregator.preCollection();  
                    assertThat(result, notNullValue());
                doc.add(new NumericDocValuesField("category", 1));
                        aggregationBuilder,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        indexSearcher,
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));  
                    assertThat(result, notNullValue());
                        indexSearcher,
                document = new Document();  
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                    assertThat(buckets.get(3).getKeyAsNumber().longValue(), equalTo(4L));
                        aggregationBuilder,  
                    assertThat(result, notNullValue());  
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(9L));
                        null,
                    indexWriter.addDocument(doc);  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    aggregator.postCollection();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                }
                    MappedFieldType humidityFieldType = new NumberFieldMapper.NumberFieldType(
                    assertThat(card0.getValue(), equalTo(12L));
                    aggregator.postCollection();
                }
                    aggregator.preCollection();
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                indexWriter.addDocument(document);
                    IndexSettings indexSettings = new IndexSettings(  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            aggregationBuilder,
    public void testBuildAggregationsBatchWithCountOrder() throws Exception {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),  
                        fieldType
                        indexWriter.addDocument(doc);
                        ),
                        createIndexSettings(),  
            }
                            .creationDate(System.currentTimeMillis())
                    assertThat(result.getBuckets().size(), equalTo(0));
                    LongTerms result1 = (LongTerms) results[0];  
                        IndexMetadata.builder("_index")
                        .stream()  
import org.apache.lucene.index.IndexWriter;
        try (Directory directory = newDirectory()) {  
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 0L)
            }
            LongTerms terms = (LongTerms) reduced;  
                .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                        ),
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("prices").field("price")  
                        .subAggregation(new ValueCountAggregationBuilder("inventory_count").field("inventory"));
                indexWriter.addDocument(doc);  
    }  
                        assertTrue(buckets.get(i).getKeyAsNumber().doubleValue() < buckets.get(i + 1).getKeyAsNumber().doubleValue());
                        .order(BucketOrder.key(false));  
                    assertThat(buckets.size(), equalTo(5));
    }  
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(2L));  
                        priceFieldType
                    // First two buckets should have count 2 (categories 1 and 2)
                        "category",
                        aggregationBuilder,
                // Category 2: values 50, 60 (avg=55)
                        indexSettings,  
                StreamNumericTermsAggregator aggregator = createStreamAggregator(
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);
                        IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
                for (int i = 0; i < 5; i++) {
                .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
                        .orElse(null);
                    // Get the result and reduce it
        try (Directory directory = newDirectory()) {
                        IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
                    );  
                document.add(new NumericDocValuesField("field", 100));  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    );  
                        null,  
                        fieldType  
                    IndexSettings indexSettings = new IndexSettings(
                    aggregator.doReset();
                    doc.add(new NumericDocValuesField("value", 10));  
        try (Directory directory = newDirectory()) {
                        aggregationBuilder,  
                    );  
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(3L));  
    }
                        .subAggregation(new SumAggregationBuilder("total_humidity").field("humidity"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
        return buildInternalStreamingAggregation(builder, fieldType1, null, searcher);  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        Document d = new Document();
            }
                            .build(),  
            }
                            DEFAULT_MAX_BUCKETS,
                        valueFieldType  
            // Create second aggregation with overlapping data
                doc.add(new NumericDocValuesField("value", 40));
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                        fieldType  
                        indexSearcher,
                        doc.add(new NumericDocValuesField("value", (9 - i + 1) * 100 + j));  
                    assertThat(buckets.get(2).getDocCount(), equalTo(5L));  
        }
                            .numberOfReplicas(0)  
                    LongTerms.Bucket firstBucket = buckets.get(0);  
                    aggregator.preCollection();
                    assertEquals(1L, buckets.get(0).getKeyAsNumber().longValue());  
                    );  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        indexSearcher,
                    doc.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(10.0 + i)));
                        .size(5)
                document.add(new SortedNumericDocValuesField("tags", 2));
                Document document = new Document();
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        ),
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {  
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));  
                        .orElse(null);  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    assertThat(buckets.get(1).getDocCount(), equalTo(4L));
                doc5.add(new NumericDocValuesField("category", 2));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("regions").field("region")
                        null,
                    assertThat(result.getBuckets().size(), equalTo(5));
                    assertThat(term2Bucket, notNullValue());  
                        indexSettings,  
                            .settings(  
                PipelineTree.EMPTY  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        createIndexSettings(),
                        createIndexSettings(),
                    aggregator.preCollection();  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    for (int i = 0; i < buckets.size() - 1; i++) {
                        .size(3)  
                        IndexMetadata.builder("_index")
                        null,
                    document.add(new NumericDocValuesField("field", i));
                }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                .findFirst()
                        indexSearcher,  
                        indexSearcher,
                        LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(result, notNullValue());
                document.add(new NumericDocValuesField("product", 200));  
                    Document doc = new Document();
                    indexWriter1.addDocument(doc);  
        TermsAggregationBuilder builder,
                    aggregator.postCollection();  
                doc = new Document();
                    assertThat(result.getBuckets().size(), equalTo(2));  
    public void testOrderByMaxSubAggregationDescending() throws Exception {
                    assertThat(result.getBuckets().size(), equalTo(0));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(1L));  
                    );  
                            DEFAULT_MAX_BUCKETS,
                    assertThat(minInventory.getValue(), equalTo(50.0));
                    for (LongTerms.Bucket bucket : result.getBuckets()) {  
                    for (int doc = 0; doc < 5; doc++) {
                    aggregator.preCollection();
                        assertThat(bucket.getKey(), instanceOf(Long.class));
    }  
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {  
                    assertThat(totalHumidity.getValue(), equalTo(125.0));
                    assertThat(maxPrice.getValue(), equalTo(50.0));
                document.add(new NumericDocValuesField("quantity", 20));  
                    }
            LongTerms.Bucket category2Bucket = terms.getBuckets()  
                            DEFAULT_MAX_BUCKETS,
    }  
                }  
            InternalSum totalPrice = category1Bucket.getAggregations().get("total_price");
    public void testOrderByMaxSubAggregationAscending() throws Exception {  
                    }
                    List<LongTerms.Bucket> buckets = result.getBuckets();  
    }
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
                    IndexSearcher searcher1 = newIndexSearcher(reader1);  
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");  
                            .numberOfShards(1)
                    assertThat(max1.getValue(), equalTo(204.0));
                    );
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            DEFAULT_MAX_BUCKETS,  
                        null,
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 100L)
                }  
                    assertThat(result1.getBuckets().size(), equalTo(2));
                        assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                        .order(BucketOrder.aggregation("sum_value", false))
                        d.add(new SortedNumericDocValuesField("value", NumericUtils.doubleToSortableLong(100.0)));  
                    }
                indexWriter.addDocument(document);  
                    assertThat(category2Bucket, notNullValue());
                );
                        .size(5)
                    }
                Document document = new Document();
                            .numberOfReplicas(0)  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                        .findFirst()
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                Map<String, Object> debugInfo = new HashMap<>();
                indexWriter.addDocument(document);  
                document.add(new NumericDocValuesField("category", 2));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        null,
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
    private InternalAggregation buildInternalStreamingAggregation(
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"))
                    DEFAULT_MAX_BUCKETS,  
                        .findFirst()  
                            DEFAULT_MAX_BUCKETS,  
                    assertThat(maxValueBucket.getDocCount(), equalTo(2L));
                    MappedFieldType quantityFieldType = new NumberFieldMapper.NumberFieldType(
            }  
                        Settings.EMPTY
                    aggregator.postCollection();
                document = new Document();
                        valueFieldType  
                    Cardinality card4 = buckets.get(4).getAggregations().get("unique_users");
                        createIndexSettings(),
                    assertThat(result.getBuckets().size(), equalTo(2));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    Settings settings = Settings.builder()
                    aggregator.postCollection();  
                }
                    IndexSettings indexSettings = new IndexSettings(
                    );
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        IndexMetadata.builder("_index")  
    }
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(0L));  
                doc4.add(new NumericDocValuesField("category", 3));
                    assertEquals(5, buckets.size());
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        .order(BucketOrder.count(false)); // Order by count descending  
                    doc.add(new NumericDocValuesField("category", i));
                        Settings.EMPTY
    public void testBuildAggregationsBatchEmptyResults() throws Exception {
                        ),
                    assertThat(inventoryCount.getValue(), equalTo(2L));
                    assertEquals(5, buckets.size());  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        aggregationBuilder,  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                    assertThat(maxPrice.getValue(), equalTo(200.0));
                        aggregationBuilder,
                        indexSearcher,  
                    // value 2 appears in docs 2,5,8 = 3 times
                    assertThat(result.getBuckets().size(), equalTo(4));
                        equalTo(
                        indexSettings,
                    aggregator.preCollection();  
                            .creationDate(System.currentTimeMillis())
                    MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(3L));  
                    doc.add(new NumericDocValuesField("value", (i + 1) * 100));
                document.add(new NumericDocValuesField("rating", 5));
                        .size(2)
                Document document = new Document();
                    // Test with minDocCount=3, should only return categories 2, 3, 4
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)  
            }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    );
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    }
                document.add(new NumericDocValuesField("number", 1));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    assertThat(result.getBuckets().size(), equalTo(2));
                    assertEquals(0L, buckets.get(0).getKeyAsNumber().longValue());
                    for (int j = 0; j <= i; j++) {  
            assertThat(category1Bucket, notNullValue());
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            // Reduce the aggregations  
                            .numberOfReplicas(0)  
                indexWriter.addDocument(document);
                        aggregationBuilder,  
            }  
}  
                    assertThat(region2Bucket, notNullValue());
                    );
    public void testDoubleTermsResults() throws Exception {
                    }
                document.add(new NumericDocValuesField("category", 1));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                        null,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    );  
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(3L));  
                        indexSettings,  
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)  
                    );  
                }
                            DEFAULT_MAX_BUCKETS,  
                Document doc4 = new Document();  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
            assertThat(category1Bucket.getDocCount(), equalTo(3L)); // 2 from first + 1 from second
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                        aggregator.context().bigArrays(),  
                            .creationDate(System.currentTimeMillis())
                    assertThat(store2Bucket.getDocCount(), equalTo(1L));
                        Document doc = new Document();
        IndexSearcher searcher
    public void testReduceWithSubAggregations() throws Exception {  
        }  
                            DEFAULT_MAX_BUCKETS,  
                    indexWriter.addDocument(doc);  
                    assertThat(totalHumidity.getValue(), equalTo(80.0));  
                            .numberOfReplicas(0)  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result.getBuckets().size(), equalTo(10));  
                            .build(),
                new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(7L));  
                    assertThat(secondResult.getBuckets().size(), equalTo(1));
        }
                        IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),  
                indexWriter.addDocument(doc);
                    LongTerms secondResult = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                }  
                    aggregator.preCollection();
                document.add(new SortedNumericDocValuesField("tags", 3));
        }
                        .order(BucketOrder.key(false))
                    aggregator.postCollection();
                document.add(new NumericDocValuesField("store", 2));
    ) throws IOException {
                    );
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                        ),
                    LongTerms.Bucket secondBucket = buckets.get(1);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    NumberFieldMapper.NumberType[] types = {
                    assertThat(result, notNullValue());  
            LongTerms terms = (LongTerms) reduced;
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        .order(BucketOrder.aggregation("max_value", false));  
                        ),
                            .numberOfShards(1)
                document.add(new NumericDocValuesField("rating", 3));
                // 9=10 docs (highest), 8=9, 7=8, 6=7, 5=6, 4=5, 3=4, 2=3, 1=2, 0=1 (lowest)  
            }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                .filter(bucket -> bucket.getKeyAsNumber().longValue() == 3L)
                    );
                        .stream()
                        aggregationBuilder,
                    assertThat(buckets.size(), equalTo(5));
    public void testSubAggregationWithMax() throws Exception {
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                document = new Document();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("tags")
                        aggregationBuilder,
                            .numberOfReplicas(0)
                indexWriter1.addDocument(doc);
        try (Directory directory = newDirectory()) {  
                indexWriter1.addDocument(doc);
                        doc.add(new NumericDocValuesField("category", i));
                    assertThat(buckets.size(), equalTo(3));  
                    assertThat(category1Bucket.getDocCount(), equalTo(2L));
                        NumberFieldMapper.NumberType.LONG
                    assertThat(minInventory.getValue(), equalTo(200.0));
                        .order(BucketOrder.aggregation("max_score", false))
                        .stream()
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
import org.apache.lucene.tests.index.RandomIndexWriter;  
                    assertThat(result.getBuckets().size(), equalTo(2));
                        valueFieldType
                        indexSearcher,
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");
                        createIndexSettings(),  
                }  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                // Create fewer unique terms to test size parameter more meaningfully
                    for (int doc = 0; doc < 5; doc++) {  
        } else {
                        categoryFieldType,  
                    assertThat(result.getBuckets().size(), equalTo(2));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                document = new Document();
                    assertThat(result, notNullValue());
                        equalTo(  
                        .findFirst()  
                document.add(new NumericDocValuesField("field", Long.MAX_VALUE - 1));
                document = new Document();
                    assertThat(buckets.get(0).getDocCount(), equalTo(1L));
                b -> {},
                            )
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result.getBuckets().size(), equalTo(2));
                document.add(new NumericDocValuesField("price", 50));
                document.add(new NumericDocValuesField("number", 2));  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    aggregator.postCollection();
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                        "category",  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                document.add(new NumericDocValuesField("product", 100));
                        .shardSize(5)  
                        .put("index.aggregation.streaming.min_segment_size", 1)  
                        aggregationBuilder,
    public void testLongTermsSubAggregationTieBreaking() throws Exception {
                    Max max0 = buckets.get(0).getAggregations().get("max_score");
                aggregator.collectDebugInfo(debugCollector);  
                    );  
                    assertThat(buckets.get(0).getKeyAsNumber().doubleValue(), equalTo(1.5));
                .stream()
                    assertThat(buckets.get(0).getDocCount(), equalTo(6L));
                doc = new Document();
                        indexSettings,
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                            .numberOfReplicas(0)
                    aggregator.postCollection();
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    );  
                        indexSearcher,  
                }  
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                        null,
                        Document doc = new Document();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        .orElse(null);  
                    searcher.search(new MatchAllDocsQuery(), aggregator);
        }
            }  
                new MultiBucketConsumerService.MultiBucketConsumer(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("number")
            List<InternalAggregation> aggs = new ArrayList<>();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertThat(buckets.get(4).getDocCount(), equalTo(10L));  
                        d.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(key + 0.5)));
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(1L));
                        humidityFieldType  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                }  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                indexWriter.addDocument(doc3);
                    assertThat(buckets.get(4).getKeyAsNumber().longValue(), equalTo(9L));
                        indexSearcher,  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            assertThat(terms.getBuckets().size(), equalTo(3));  
                        indexSettings,
        try (Directory directory = newDirectory()) {  
                        .size(5)
                    assertThat(result, notNullValue());
                        indexSearcher,  
                }
                    aggregator.postCollection();  
                indexWriter.addDocument(document);
                        indexWriter.addDocument(doc);  
    public void testBuildAggregationsBatchWithSize() throws Exception {
                        indexSearcher,
        try (Directory directory = newDirectory()) {
                        aggregator.postCollection();
                doc = new Document();
                        DEFAULT_MAX_BUCKETS,
                        .order(BucketOrder.key(true));  
    }  
                        indexSearcher,
                    assertThat(
                for (int i = 0; i < 4; i++) {
                        .orElse(null);  
                    aggregator.preCollection();
                Document document = new Document();
import org.opensearch.common.util.MockPageCacheRecycler;
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                        NumberFieldMapper.NumberType.LONG
                    assertThat(term0Bucket, notNullValue());
            );
                        ),
                    IndexSettings indexSettings = new IndexSettings(  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
import org.opensearch.core.common.breaker.CircuitBreaker;
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher1)  
                        .size(2)
                    minInventory = store2Bucket.getAggregations().get("min_inventory");  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                // Create categories with varying doc counts: 0=1, 1=2, 2=3, 3=4, 4=5
                document.add(new NumericDocValuesField("field", NumericUtils.doubleToSortableLong(2.5)));
                        indexSearcher,
                        categoryFieldType,  
                        null,  
                    assertThat(buckets.get(1).getKeyAsNumber().doubleValue(), equalTo(2.5));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                builder,
                            )
                        IndexMetadata.builder("_index")  
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                    LongTerms.Bucket region2Bucket = result.getBuckets()  
                            .numberOfShards(1)
                    List<DoubleTerms.Bucket> buckets = result.getBuckets();
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                        aggregationBuilder,
        }  
import java.io.IOException;
                Document doc5 = new Document();
                                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    aggregationBuilder,  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );
                        d.add(new SortedNumericDocValuesField("value", 100));
                        Settings.EMPTY
                        );  
                    assertThat(result, notNullValue());  
                        numberFieldType,
                        new MultiBucketConsumerService.MultiBucketConsumer(  
import org.opensearch.common.settings.Settings;
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        productFieldType,  
                            .settings(
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                            )  
                indexWriter.addDocument(document);  
                        Document doc = new Document();
                    aggregator.postCollection();  
                        indexSearcher,  
                        IndexMetadata.builder("_index")
        IndexSearcher searcher
                    }
                // Create 10 categories where TOP 3 by max ASC won't be alphabetically first  
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(7L));
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"))
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(5L));  
                        aggregationBuilder,
                        .size(5)  
                    LongTerms.Bucket category2Bucket = result.getBuckets()  
                        indexSettings,
import org.apache.lucene.util.NumericUtils;
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                    null,
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher2)
                    assertThat(result, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
import java.util.Map;
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                // Category 1: 2 docs with value 25 each (sum=50)
                        .order(BucketOrder.count(false));
                        tempFieldType,
                    LongTerms.Bucket thirdBucket = buckets.get(2);
                        indexSettings,
                    aggregator.preCollection();
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(6L));
/*  
            LongTerms.Bucket category1Bucket = terms.getBuckets().get(0);
            }
                }
                document.add(new NumericDocValuesField("category", 1));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
                Document doc = new Document();  
                    assertThat(result, notNullValue());
                null,
                        .order(BucketOrder.key(false));
                doc.add(new NumericDocValuesField("value", 30));
                    assertThat(buckets.get(1).getDocCount(), equalTo(1L));
    }
                    aggregator.preCollection();  
                        ratingFieldType
                    indexWriter.addDocument(document);
                document.add(new NumericDocValuesField("rating", 4));  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        PipelineTree.EMPTY  
                        .findFirst()
                        ),
                        NumberFieldMapper.NumberType.LONG  
                            DEFAULT_MAX_BUCKETS,  
                        .subAggregation(new SumAggregationBuilder("sum_value").field("value"));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
    }
                long[] terms = { 95, 94, 93, 92, 91, 1, 2, 3, 4, 5 };
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                        Settings.EMPTY  
                    LongTerms firstBatch = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType idFieldType = new NumberFieldMapper.NumberFieldType("id", NumberFieldMapper.NumberType.UNSIGNED_LONG);
                    assertThat(buckets.size(), equalTo(3));
                document.add(new NumericDocValuesField("quantity", 10));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    assertThat(buckets.get(4).getKeyAsNumber().longValue(), equalTo(9L));
                        null,
                            DEFAULT_MAX_BUCKETS,
                document = new Document();
                        .order(BucketOrder.count(false));
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    assertThat(result, notNullValue());
                    indexWriter.addDocument(document);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        indexSearcher,  
                    );
        }
                        new MultiBucketConsumerService.MultiBucketConsumer(
            }  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        createIndexSettings(),  
                            )
                        fieldType  
                            DEFAULT_MAX_BUCKETS,
                                Settings.builder()
                            .numberOfReplicas(0)  
                        .orElse(null);
                    // category 1: 2 docs, category 2: 2 docs, category 3: 1 doc
            // Check that overlapping terms (3, 4) have doc count 2
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    LongTerms.Bucket term2Bucket = buckets.stream()
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(3L));
                                Settings.builder()  
                            .settings(  
                indexWriter.addDocument(document);
                document.add(new NumericDocValuesField("region", 1));
import org.apache.lucene.index.IndexWriterConfig;
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    Document doc = new Document();
                        ),  
                    );
    public void testUnsignedLongTermsSubAggregationTieBreaking() throws Exception {  
                    // Verify each term appears exactly twice (20 docs / 10 unique terms)
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                indexWriter.addDocument(document);
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                    assertThat(max2.getValue(), equalTo(304.0));
                document.add(new NumericDocValuesField("temperature", 35));  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                }
                        IndexMetadata.builder("_index")
                    assertThat(totalQuantity.getValue(), equalTo(30.0));  
                }
                }  
                        boolean found = buckets.stream().anyMatch(b -> b.getKeyAsNumber().longValue() == expectedKey);  
                    );
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {  
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
        }
        try (Directory directory = newDirectory()) {  
        try (Directory directory = newDirectory()) {  
                document.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(19.99)));
                            DEFAULT_MAX_BUCKETS,
                Document document = new Document();
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
                document.add(new NumericDocValuesField("price", 100));  
                    aggregator.preCollection();
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                    assertThat(thirdBucket.getKeyAsNumber().longValue(), equalTo(3L));
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));  
                            .creationDate(System.currentTimeMillis())
                    assertThat(maxTemp.getValue(), equalTo(35.0));  
                        null,
                indexWriter.addDocument(doc);  
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                        new MultiBucketConsumerService.MultiBucketConsumer(
        }
            aggregator = createStreamAggregator(  
                    );
            }  
                searcher,  
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                        ),
                }  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(result, notNullValue());
                        fieldType  
import org.opensearch.search.aggregations.BucketOrder;  
                }
                indexWriter.addDocument(document);  
                    );
                            .numberOfShards(1)
    }  
        }
                        "value",
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                // Category 1: values 30, 40 (avg=35)
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        createIndexSettings(),
                        searcher,
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                            "Streaming aggregation does not support key-based ordering for numeric fields. Use traditional aggregation approach instead."
                        null,
                    assertThat(bucket.getDocCount(), equalTo(2L));  
                }
                        .orElse(null);
import org.opensearch.common.util.MockBigArrays;  
                    // Streaming aggregation does not support key-based ordering for numeric fields
                            .numberOfReplicas(0)
                createIndexSettings(),  
            // Second aggregation with different terms
                    );
                    aggregator.postCollection();
                            .creationDate(System.currentTimeMillis())  
                        createIndexSettings(),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        .subAggregation(new AvgAggregationBuilder("avg_temp").field("temperature"))
                    MappedFieldType salesFieldType = new NumberFieldMapper.NumberFieldType("sales", NumberFieldMapper.NumberType.LONG);
                        .put("index.aggregation.streaming.min_segment_size", 1)
                        null,
                    assertEquals(55.0, ((Avg) buckets.get(1).getAggregations().get("avg_value")).getValue(), 0.001);  
import org.opensearch.search.aggregations.metrics.Max;
    }
                        assertThat(result, notNullValue());  
                        indexSearcher,
                        NumberFieldMapper.NumberType.INTEGER,
                    );
                        null,
                doc.add(new NumericDocValuesField("category", 3));  
                    aggregator.postCollection();
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            assertThat(reduced, instanceOf(LongTerms.class));
                for (long key = 0; key < 20; key++) {  
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    List<UnsignedLongTerms.Bucket> buckets = result.getBuckets();
                            )  
                // Create buckets where all have same doc count and same max value
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("tags", NumberFieldMapper.NumberType.LONG);  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(1).getDocCount(), equalTo(7L));  
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                        Settings.EMPTY
                        null,  
                        ),
                        ),
                }  
                    aggregator.postCollection();  
                    IndexSettings indexSettings = new IndexSettings(
                    aggregator.preCollection();
    }  
            );
                for (int i = 0; i < 4; i++) {
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                    );
import org.opensearch.index.IndexSettings;
                Document document = new Document();  
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    for (int i = 1; i <= 5; i++) {
                    IllegalArgumentException exception = expectThrows(  
                            .numberOfReplicas(0)
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    doc.add(new NumericDocValuesField("quantity", (i + 1) * 10));  
                    aggregator.preCollection();
                }
    }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                for (int i = 0; i < 10; i++) {
                        ),  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        IllegalArgumentException.class,
                    aggregator.preCollection();  
                    Max max1 = buckets.get(1).getAggregations().get("max_score");  
                        ),
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    for (int doc = 0; doc < 5; doc++) {
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        "quantity",
                        indexSearcher,
                        ),  
                        fieldType
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                doc2.add(new NumericDocValuesField("category", 1));
                        ),
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
                for (int i = 0; i < 20; i++) {
                Document doc = new Document();
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                        );
            );  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
            LongTerms.Bucket category1Bucket = terms.getBuckets()  
                        ),
                document.add(new SortedNumericDocValuesField("tags", 4));
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(7L));
                    // Should get 5 buckets, and they should be sorted by key after coordinator reduce
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    LongTerms firstResult = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                        doc.add(new NumericDocValuesField("category", i));
                    MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer =  
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
                    UnsignedLongTerms.Bucket maxValueBucket = result.getBuckets()
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
        try (Directory directory = newDirectory()) {
                doc.add(new NumericDocValuesField("category", 1));
                }
                            ),
                        categoryFieldType,
                    aggregator.preCollection();
                        () -> aggregator.buildAggregations(new long[] { 0 })
                doc.add(new NumericDocValuesField("category", 1));  
                        indexSearcher,
                .stream()  
                }
                doc.add(new NumericDocValuesField("category", 2));
                    IndexSettings indexSettings = new IndexSettings(
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("number")
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
    }  
        try (Directory directory = newDirectory()) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
    public void testDoubleTermsWithSubAggregationOrdering() throws Exception {  
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
                    assertThat(max1.getValue(), equalTo(900.0));
                        quantityFieldType
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        }
                assertEquals("stream_long_terms", debugInfo.get("result_strategy"));  
                    InternalAggregation[] results = aggregator.buildAggregations(new long[] { 0 });
                // This forces tie-breaking by key during quickselect
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                }  
        }
                        .shardSize(3)  
            for (LongTerms.Bucket bucket : terms.getBuckets()) {  
        }  
                        null,  
                        NumberFieldMapper.NumberType.LONG
    public void testEmptyDoubleTermsResult() throws Exception {
                    );  
                document.add(new NumericDocValuesField("region", 2));
                }
        }  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("products").field("product")  
                    assertThat(result, notNullValue());
                // Create 10 categories where alphabetical order != count order
                    assertThat(bucket.getDocCount(), equalTo(1L));
import static org.hamcrest.Matchers.instanceOf;  
        try (Directory directory = newDirectory()) {  
                        categoryFieldType,  
            }
                Document document = new Document();
                        fieldType  
                    assertThat(buckets.size(), equalTo(3));
                    assertThat(card2.getValue(), equalTo(16L));
                    assertThat(result, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.DOUBLE);
                document.add(new NumericDocValuesField("field", NumericUtils.floatToSortableInt(3.14f)));
                }
                    );
    }  
                        aggregationBuilder,
    }
                    // The order is specified but buckets may not be sorted until reduce phase
        }  
                        NumberFieldMapper.NumberType.UNSIGNED_LONG
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                document.add(new org.apache.lucene.document.LongPoint("number", 2));
                    // Verify the buckets are sorted by count (descending)
                document.add(new NumericDocValuesField("sales", 500));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
    public void testKeyOrderDescendingWithSizeLimitDropsCorrectBuckets() throws Exception {  
                    LongTerms.Bucket store1Bucket = result.getBuckets()
                Document document = new Document();  
                    }  
                        IndexMetadata.builder("_index")
                    );  
                    LongTerms.Bucket product100Bucket = result.getBuckets()
                    aggregator.preCollection();  
                        .order(BucketOrder.aggregation("avg_value", false))
                    MappedFieldType quantityFieldType = new NumberFieldMapper.NumberFieldType(
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                    );  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
        }
                document.add(new NumericDocValuesField("humidity", 80));
            // Check that categories 2 and 3 buckets each have count 1
                            .settings(
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;  
                        .findFirst()  
                        reduceBucketConsumer,
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                for (int i = 0; i < 10; i++) {
                    assertThat(store1Bucket, notNullValue());
                indexWriter.addDocument(doc);
                    assertThat(price999Bucket, notNullValue());
                            .settings(  
                    assertThat(max1.getValue(), equalTo(200.0));
                    aggregator.preCollection();
                    // Verify otherDocCount: 10 categories * 1 doc = 10 total, selected 3*1=3, other=7
                document.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(9.99)));  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
    public void testSubAggregationWithSum() throws Exception {
                    assertThat(result.getBuckets().size(), equalTo(3));  
            assertThat(category1Bucket.getDocCount(), equalTo(2L));  
                for (int i = 0; i < 10; i++) {
            }
                document.add(new NumericDocValuesField("field", 2));
                document.add(new NumericDocValuesField("field", 123));  
                        aggregationBuilder,
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    aggregator.preCollection();
                    assertEquals(80.0, ((InternalSum) buckets.get(1).getAggregations().get("sum_value")).getValue(), 0.001);
    }  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    Document doc = new Document();
        try (Directory directory = newDirectory()) {
                    );
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                indexWriter2.addDocument(doc);  
            // Check that category 1 bucket has count 2 (from both aggregations)
                    LongTerms.Bucket product200Bucket = result.getBuckets()
                    indexSearcher,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
    }
                    assertThat(reduced, notNullValue());
                        NumberFieldMapper.NumberType.LONG
            }
                        Document doc = new Document();
                        indexSearcher,  
                indexWriter.addDocument(document);  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    aggregator.postCollection();  
    }
                indexWriter.addDocument(doc1);
                    );
                    // Verify total document count across all buckets
                    indexWriter.addDocument(document);
                    // Returned in alphabetical order at shard level
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
    }  
            }
                    );
                    assertThat(max0.getValue(), equalTo(20.0));  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
                        aggregationBuilder,
                            Integer.MAX_VALUE,
import org.opensearch.Version;  
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(1L));
                }
                    List<LongTerms.Bucket> buckets = result.getBuckets();  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    aggs.add(
                    MappedFieldType productFieldType = new NumberFieldMapper.NumberFieldType("product", NumberFieldMapper.NumberType.LONG);  
                    assertThat(firstBatch.getBuckets().size(), equalTo(1));  
                        new MultiBucketConsumerService.MultiBucketConsumer(
        }
 * compatible open source license.
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");  
                        valueFieldType  
                    indexWriter.addDocument(doc);
                    aggregator.preCollection();
                    assertThat(buckets.get(3).getKeyAsNumber().longValue(), equalTo(8L));  
                    aggregator.preCollection();
            }  
                        null,
                            .settings(  
 */  
                    assertThat(result, notNullValue());
                        aggregationBuilder,  
                for (int i = 1; i <= 5; i++) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                doc.add(new NumericDocValuesField("category", 1));
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));  
                }
                    assertThat(card2.getValue(), equalTo(6L));  
                    assertThat(firstBucket.getDocCount(), equalTo(2L));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    public void testReduceWithSizeLimit() throws Exception {  
                }
                    aggregator.postCollection();
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                        "category",
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    document.add(new NumericDocValuesField("field", i % 3));
                            "Streaming aggregation does not support key-based ordering for numeric fields. Use traditional aggregation approach instead."
                    aggregator.postCollection();
                }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        assertTrue("Expected key " + expectedKey + " to be present", found);
                        "category",  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    for (int j = 0; j < uniqueUsers; j++) {  
                                Settings.builder()
        aggregator.preCollection();
                                Settings.builder()
                    assertThat(buckets.get(1).getKeyAsNumber().doubleValue(), equalTo(12.0));
import java.util.function.BiConsumer;
                    );
        }
                b -> {},
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                            DEFAULT_MAX_BUCKETS,  
        try (Directory directory = newDirectory()) {  
                }  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    InternalSum totalSales = category1Bucket.getAggregations().get("total_sales");  
                        createIndexSettings(),
                    IndexSettings indexSettings = new IndexSettings(  
                    );
                        .orElse(null);  
                        fieldType
                    // Verify that categories 1 and 2 are the first two (order may vary for equal counts)  
                        fieldType
                        "category",
                }  
                for (int i = 0; i < 10; i++) {
                    indexWriter.addDocument(doc);
import org.apache.lucene.document.SortedNumericDocValuesField;  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    Document doc = new Document();
                .orElse(null);
                document = new Document();  
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                indexWriter.addDocument(doc2);  
                    aggregator.preCollection();
                        .build();
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
                    indexWriter.addDocument(doc);
        }
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    // Streaming aggregation does not support key-based ordering for numeric fields  
                        "quantity",  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");  
                        IndexMetadata.builder("_index")
                    );
                document.add(new NumericDocValuesField("field", 1));
        }
                        indexSearcher,
                doc.add(new NumericDocValuesField("price", 150));
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
            // Second aggregation
                                Settings.builder()
                        .order(BucketOrder.aggregation("unique_users", true))
                        ),  
                    assertThat(term0Bucket.getDocCount(), equalTo(4L));
                    assertEquals(35.0, ((Avg) buckets.get(0).getAggregations().get("avg_value")).getValue(), 0.001);
                        .subAggregation(new MinAggregationBuilder("min_humidity").field("humidity"))
                    ValueCount inventoryCount = store1Bucket.getAggregations().get("inventory_count");
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
    public void testCollectDebugInfo() throws IOException {
                        fieldType
                        idFieldType,  
                    assertThat(card0.getValue(), equalTo(2L));
                        createIndexSettings(),
 *
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));  
                    assertThat(max2.getValue(), equalTo(1000.0));  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    long totalDocs = buckets.stream().mapToLong(LongTerms.Bucket::getDocCount).sum();  
                        IndexMetadata.builder("_index")
                    Document doc = new Document();  
    public void testBuildAggregationsBatchReset() throws Exception {
        }
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                        ),
                        null,
                    assertThat(result, notNullValue());  
        }
            }
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(result, notNullValue());  
                        doc.add(new NumericDocValuesField("category", 9 - i));
        }
                    );
                        ),
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
                        NumberFieldMapper.NumberType.LONG
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
        try (Directory directory = newDirectory()) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                searcher,
                indexWriter.addDocument(document);
    public void testOrderByCardinalitySubAggregationAscending() throws Exception {  
                            DEFAULT_MAX_BUCKETS,
                getMockScriptService(),  
                        "category",
            }
                    // Verify otherDocCount: 10 categories * 5 docs = 50 total, selected 3*5=15, other=35
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    Max maxPrice = category1Bucket.getAggregations().get("max_price");  
                    );
                    doc.add(new NumericDocValuesField("value", 20));
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(  
                        userIdFieldType
        MappedFieldType fieldType1,  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);  
                if (key == 3L || key == 4L) {
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=2+4+6=12, other=98
                indexWriter2.addDocument(doc);  
                    assertThat(max1.getValue(), equalTo(30.0));
                        aggregationBuilder,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
        try (Directory directory = newDirectory()) {  
                document.add(new NumericDocValuesField("quantity", 5));
                        ),
                    // Just verify all expected keys are present
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        indexSearcher,
                indexWriter1.addDocument(doc);  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
                    );
                    aggregator.postCollection();  
            assertThat(category3Bucket, notNullValue());
                        null,
                .findFirst()  
            aggregator = createStreamAggregator(
                        null,
 * The OpenSearch Contributors require contributions made to  
    }
        try (Directory directory = newDirectory()) {
                        .shardSize(2)  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field").size(5);  
        try (Directory directory = newDirectory()) {  
            assertThat(category3Bucket.getDocCount(), equalTo(1L));
                            fieldType
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {  
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    );
        }
        StreamNumericTermsAggregator aggregator;  
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(  
                    Settings settings = Settings.builder()
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")  
                        NumberFieldMapper.NumberType.LONG  
                    aggregator.postCollection();
                    );
                document.add(new NumericDocValuesField("field", NumericUtils.doubleToSortableLong(1.5)));
                        doc.add(new NumericDocValuesField("field", terms[i]));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        salesFieldType
    private InternalAggregation buildInternalStreamingAggregation(  
                    );  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        indexSearcher,  
                        .findFirst()
                        createIndexSettings(),  
                            .build(),
                document = new Document();  
                                DEFAULT_MAX_BUCKETS,
                        aggregationBuilder,  
    public void testReduceSimple() throws Exception {  
                        .shardSize(3)
                    for (int j = 0; j < counts[i]; j++) {  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    LongTerms.Bucket store2Bucket = result.getBuckets()
                            .numberOfShards(1)
import org.opensearch.search.aggregations.metrics.Cardinality;
                            .numberOfReplicas(0)
                    List<LongTerms.Bucket> buckets = result.getBuckets();  
                    assertThat(category2Bucket, notNullValue());
                        .findFirst()
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(98L));  
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(4L));
                        .stream()
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                        Settings.EMPTY  
                        aggregationBuilder,
import org.opensearch.search.aggregations.InternalAggregation;
                                Settings.builder()  
                        null,
        TermsAggregationBuilder builder,
                    assertThat(product100Bucket, notNullValue());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        fieldType
                indexWriter.addDocument(document);  
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("field", 200));
                    document.add(new NumericDocValuesField("field", 100));
                for (int i = 0; i < 10; i++) {
            }  
    public void testBuildAggregationsBatchDirectBucketCreation() throws Exception {
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                        .subAggregation(new MaxAggregationBuilder("max_qty").field("quantity"));
                        .orElse(null);
                document.add(new NumericDocValuesField("field", NumericUtils.floatToSortableInt(2.71f)));
                        ),  
                            DEFAULT_MAX_BUCKETS,  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    for (NumberFieldMapper.NumberType type : types) {  
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));
            }
                        .stream()  
                document.add(new NumericDocValuesField("field", NumericUtils.doubleToSortableLong(1.5)));  
            }  
                        aggregationBuilder,
                assertTrue("Should contain total_buckets", debugInfo.containsKey("total_buckets"));
                }
                        createIndexSettings(),  
    }  
                    assertThat(result, notNullValue());
                        NumberFieldMapper.NumberType.LONG
                        .orElse(null);
                    doc.add(new NumericDocValuesField("value", 25));
                    assertThat(result.getBuckets().size(), equalTo(2));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                            .creationDate(System.currentTimeMillis())  
                document.add(new NumericDocValuesField("inventory", 100));
                            .creationDate(System.currentTimeMillis())
                        valueFieldType
                        new MultiBucketConsumerService.MultiBucketConsumer(
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        assertThat(bucket.getKeyAsString(), notNullValue());  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                document.add(new NumericDocValuesField("field", NumericUtils.floatToSortableInt(3.14f)));  
                    aggregator.preCollection();
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        null,
                        .findFirst()
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        .subAggregation(new SumAggregationBuilder("total_sales").field("sales"));
                    );
                        .order(BucketOrder.aggregation("min_value", true))
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        .orElse(null);
            assertThat(terms.getBuckets().size(), equalTo(1));  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        NumberFieldMapper.NumberType.LONG
                        regionFieldType,
        }
                            DEFAULT_MAX_BUCKETS,  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    List<LongTerms.Bucket> buckets = result.getBuckets();  
                    Document document = new Document();  
                            DEFAULT_MAX_BUCKETS,  
                    assertThat(category1Bucket, notNullValue());
                createIndexSettings(),
                            createIndexSettings(),  
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    );  
    public void testKeyOrderDescending() throws Exception {
                        fieldType
        try (Directory directory = newDirectory()) {  
                            .numberOfReplicas(0)  
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                        null,  
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(2L));
        }
                        "humidity",  
                        null,
                    doc.add(new NumericDocValuesField("category", 0));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
            );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    aggregator.postCollection();
            List<InternalAggregation> aggs = new ArrayList<>();  
                    assertThat(store1Bucket.getDocCount(), equalTo(2L));
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                    LongTerms topLevel = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        null,  
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(30L));  
                    IndexSearcher searcher2 = newIndexSearcher(reader2);  
                        indexSettings,
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                    aggs.add(  
        }
                        Document doc = new Document();
                    assertThat(card3.getValue(), equalTo(18L));
                        assertThat(bucket, instanceOf(LongTerms.Bucket.class));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                doc.add(new NumericDocValuesField("category", 1));
                    aggregator.postCollection();  
                document.add(new NumericDocValuesField("field", Long.MAX_VALUE));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        valueFieldType
        try (Directory directory = newDirectory()) {
                document = new Document();
                    aggregator.preCollection();
        try (Directory directory = newDirectory()) {
                        indexWriter.addDocument(doc);
                        aggregationBuilder,
                    assertThat(result.getBuckets().size(), equalTo(3));
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(0L));
    public void testOrderByMinSubAggregation() throws Exception {
        try (Directory directory = newDirectory()) {
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                            DEFAULT_MAX_BUCKETS,  
                        doc.add(new NumericDocValuesField("value", (i + 1) * 10 + j));  
                document.add(new NumericDocValuesField("field", 2));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
    }
    }
    public void testEmptyUnsignedLongTermsResult() throws Exception {
        }
    }
                    aggregator.preCollection();
                }  
                ),
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    assertThat(card4.getValue(), equalTo(20L));  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        aggregationBuilder,
                        indexSearcher,  
                        indexWriter.addDocument(d);
                Document document = new Document();  
                                Settings.builder()
                    MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType(
                indexWriter.addDocument(document);
                document = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            LongTerms.Bucket category3Bucket = terms.getBuckets()
                document.add(new NumericDocValuesField("category", 2));  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                    maxPrice = category2Bucket.getAggregations().get("max_price");
    }
                        aggregationBuilder,
                doc = new Document();
                        ),  
                    );
                    // value 1 appears in docs 1,4,7 = 3 times
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                            DEFAULT_MAX_BUCKETS,
                    aggregator.preCollection();
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    aggregator.postCollection();  
                PipelineTree.EMPTY
                        new MultiBucketConsumerService.MultiBucketConsumer(
                // Create 10 categories with varying max values (size=3, total=10)
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(2L));
                        .order(BucketOrder.aggregation("max_value", false))
                        d.add(new SortedNumericDocValuesField("number", key));  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                            null,  
                indexWriter.addDocument(document);
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
                Document document = new Document();
                            .numberOfShards(1)
                    assertThat(result, notNullValue());
                        doc.add(new NumericDocValuesField("field", terms[i]));  
                        .subAggregation(new AvgAggregationBuilder("avg_value").field("value"));  
                doc1.add(new NumericDocValuesField("category", 1));
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                    assertThat(buckets.get(0).getDocCount(), equalTo(2L));  
                }  
                    List<UnsignedLongTerms.Bucket> buckets = result.getBuckets();
                            DEFAULT_MAX_BUCKETS,
                        NumberFieldMapper.NumberType.UNSIGNED_LONG
                    IndexSettings indexSettings = new IndexSettings(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");  
                }  
                    IndexSettings indexSettings = new IndexSettings(
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    LongTerms reduced = (LongTerms) topLevel.reduce(Collections.singletonList(topLevel), context);  
                        createIndexSettings(),
                        .subAggregation(new MinAggregationBuilder("min_value").field("value"));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        }
                        ),  
        MappedFieldType fieldType2,  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            assertThat(category1Bucket.getKeyAsNumber().longValue(), equalTo(1L));  
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                        null,  
                    aggregator.preCollection();  
                        .shardSize(3)  
                document = new Document();
                ),
                for (long key = 0; key < 20; key++) {
                            )
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
                        ),
                    document.add(new NumericDocValuesField("field", i % 10));
                    );
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    );
                            .settings(  
            }
                        assertTrue(buckets.get(i).getKeyAsNumber().longValue() < buckets.get(i + 1).getKeyAsNumber().longValue());
                doc = new Document();
                document = new Document();
                doc.add(new NumericDocValuesField("value", 20));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        null,  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    Document document = new Document();  
                    }  
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"))
                        createIndexSettings(),
                        .subAggregation(new MaxAggregationBuilder("max_price").field("price"));
                }  
                    Document doc = new Document();  
                    doc.add(new NumericDocValuesField("category", 2));  
                    aggregator.preCollection();
                        .findFirst()
                        aggregationBuilder,
    public void testReduceSingleAggregation() throws Exception {
                        .shardSize(5)
                            DEFAULT_MAX_BUCKETS,  
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {  
            }
                    );
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);  
                document.add(new NumericDocValuesField("field", Long.MAX_VALUE));  
                    for (int i = 0; i < buckets.size() - 1; i++) {  
                    for (LongTerms.Bucket bucket : buckets) {  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        Settings.EMPTY
                        doc.add(new NumericDocValuesField("category", i));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        Settings.EMPTY  
                    Max max2 = buckets.get(2).getAggregations().get("max_value");  
                            .settings(
                    int numDocs = 5;
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                        null,  
                        "category",
                    LongTerms.Bucket category1Bucket = result.getBuckets()
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.opensearch.index.mapper.KeywordFieldMapper;
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                    assertEquals(1L, buckets.get(0).getKeyAsNumber().longValue());
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
            assertThat(reduced, instanceOf(LongTerms.class));  
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                document.add(new NumericDocValuesField("store", 1));
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(15L));  
                        aggregationBuilder,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        NumberFieldMapper.NumberType.LONG
            }  
                        indexSearcher,  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
    public void testMultipleSubAggregations() throws Exception {
                indexWriter.addDocument(document);
                        StreamNumericTermsAggregator aggregator = createStreamAggregator(
            }
                        indexSearcher,  
                    );  
                        NumberFieldMapper.NumberType.LONG  
                for (int i = 0; i < 3; i++) {  
    public void testOrderByCardinalitySubAggregationDescending() throws Exception {  
                indexWriter.addDocument(document);
                doc.add(new NumericDocValuesField("category", 2));
                        valueFieldType
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    Settings settings = Settings.builder()
                    aggregator.postCollection();
                indexWriter.addDocument(document);
                    assertEquals(2L, buckets.get(1).getKeyAsNumber().longValue());
                        indexSettings,
                        IndexMetadata.builder("_index")
                        createIndexSettings(),
                        assertThat(bucket.getDocCount(), equalTo(2L));
        assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
            }
                    assertThat(result.getBuckets().size(), equalTo(2));
                        valueFieldType
                        assertTrue(buckets.get(i).getKeyAsNumber().longValue() < buckets.get(i + 1).getKeyAsNumber().longValue());  
                    Min minHumidity = region1Bucket.getAggregations().get("min_humidity");  
                        indexSearcher,
                }  
    public void testKeyOrderWithSizeLimitDropsCorrectBuckets() throws Exception {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                    }
            }
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                PipelineTree.EMPTY
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import java.util.List;  
    public void testDifferentNumberTypes() throws Exception {
                        null,
                    assertThat(result.getBuckets().size(), equalTo(2));
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher1));  
                document = new Document();  
                        .size(5)
                    aggregator.postCollection();
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);  
            List<InternalAggregation> aggs = new ArrayList<>();
                indexWriter.addDocument(doc4);
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.cluster.metadata.IndexMetadata;
                    Max max0 = buckets.get(0).getAggregations().get("max_value");  
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(Long.MAX_VALUE - 1));  
                    indexWriter.addDocument(doc);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        priceFieldType,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    // but rather handled during the reduce phase. Test that we get all terms for this batch.
                        aggregationBuilder,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
                        null,
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);
                Document doc = new Document();  
                        indexWriter.addDocument(doc);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
            }  
                    assertThat(totalSales.getValue(), equalTo(3000.0));
                }  
                        .size(5)  
                indexWriter2.addDocument(doc);
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(6L));
        try (Directory directory = newDirectory()) {
                }  
                        aggregationBuilder,  
    }  
            assertThat(terms.getBuckets().size(), equalTo(3));  
                        doc.add(new NumericDocValuesField("category", i));
                document.add(new SortedNumericDocValuesField("tags", 1));  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                        .stream()
                        .order(BucketOrder.aggregation("unique_users", false))
            assertThat(reduced, instanceOf(LongTerms.class));  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                indexWriter.addDocument(document);
                    assertEquals(2L, buckets.get(1).getKeyAsNumber().longValue());
                                Settings.builder()
                    assertThat(avgTemp.getValue(), equalTo(27.5));
    }
                }
                    aggregator.postCollection();  
                    );
                            .build(),
                    aggregator.postCollection();  
    public void testDoubleTermsWithSubAggregation() throws Exception {
                            .build(),
            }
                builder,
                }  
                        new MultiBucketConsumerService.MultiBucketConsumer(
    public void testMinDocCount() throws Exception {
                for (int i = 0; i < 2; i++) {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                indexWriter.addDocument(document);
                    assertThat(category1Bucket, notNullValue());
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        d.add(new SortedNumericDocValuesField("number", key));  
                iw.addDocument(document);
                Document doc3 = new Document();
                        aggregationBuilder,
        }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                }
        try (Directory directory = newDirectory()) {
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field("number");  
    }
                        aggregationBuilder,  
                    assertThat(term1Bucket.getDocCount(), equalTo(3L));  
                    );  
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                    aggregator.postCollection();  
        }  
                    );  
                            )
            }
                            )
        try (Directory directory = newDirectory()) {
    public void testOrderBySumSubAggregation() throws Exception {
                                Settings.builder()
                    indexWriter.addDocument(document);
                    new MultiBucketConsumerService.MultiBucketConsumer(  
import org.opensearch.search.aggregations.metrics.Min;
                        null,
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
                document = new Document();
                    aggregator.preCollection();  
                indexWriter.addDocument(document);  
                            .settings(
                for (int i = 0; i < terms.length; i++) {  
                    Max maxTemp = region1Bucket.getAggregations().get("max_temp");  
                            DEFAULT_MAX_BUCKETS,  
                        indexSearcher,
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    for (int j = 0; j < 3; j++) {  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    int numDocs = 10 - i;
                getMockScriptService(),
                        inventoryFieldType
                            )
                    assertThat(minHumidity.getValue(), equalTo(60.0));
                    ),  
            }
                            .numberOfShards(1)  
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(8L));
                        .order(BucketOrder.aggregation("max_value", false));
                document = new Document();  
                doc.add(new NumericDocValuesField("category", 2));
                        NumberFieldMapper.NumberType.SHORT,  
                    for (int j = 0; j < uniqueUsers; j++) {  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        ),  
import java.util.Collections;
                    aggregator.postCollection();  
        }
                long key = bucket.getKeyAsNumber().longValue();
                        .findFirst()
                    aggregator.postCollection();  
                    assertThat(reduced.getBuckets().size(), equalTo(3));  
        try (Directory directory = newDirectory()) {  
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                }  
                    for (int i = 0; i < buckets.size() - 1; i++) {
                    assertThat(product200Bucket, notNullValue());
            assertThat(totalPrice.getValue(), equalTo(450.0)); // 100 + 200 + 150
                    assertThat(max0.getValue(), equalTo(300.0));
                    aggregator.preCollection();
                        aggregationBuilder,  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertEquals(6L, result.getSumOfOtherDocCounts());
                    IndexSearcher searcher = newIndexSearcher(reader);
                for (int i = 0; i < terms.length; i++) {
import org.apache.lucene.index.DirectoryReader;
                    // Third bucket should be category 3 with count 1  
                    aggregator.preCollection();
        if (fieldType2 != null) {
                doc = new Document();  
                        .size(3)
        searcher.search(new MatchAllDocsQuery(), aggregator);  
                    assertThat(minHumidity.getValue(), equalTo(80.0));  
                        null,
            }  
                // Create 10 categories where TOP 3 by cardinality ASC won't be alphabetically first  
                doc.add(new NumericDocValuesField("category", 0));  
                        aggregationBuilder,
                        .shardSize(5)
                        aggregationBuilder,
                    assertThat(result, notNullValue());
                        ),
                Document document = new Document();
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];  
                        numberFieldType,
import static org.hamcrest.Matchers.notNullValue;
                // Add multiple documents with different categories to test reduce logic properly
                document = new Document();
    public void testFloatNumberType() throws Exception {
                indexWriter.addDocument(document);
                    assertThat(buckets.get(3).getDocCount(), equalTo(1L));
                document.add(new NumericDocValuesField("price", 200));
                }  
                            .creationDate(System.currentTimeMillis())
        try (Directory directory = newDirectory()) {
                    assertThat(result, notNullValue());  
import org.apache.lucene.store.Directory;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    );  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        indexWriter.addDocument(d);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    );
                    );
                }  
                getMockScriptService(),  
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(300L));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
    }
                        .size(2)  
                        IndexMetadata.builder("_index")  
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                doc.add(new NumericDocValuesField("category", 0));
            }  
                        .size(2)
                        .stream()  
                    );
                document.add(new NumericDocValuesField("sales", 2000));  
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));  
            // Create first aggregation with some data
                    LongTerms.Bucket category1Bucket = result.getBuckets()  
                    Document document = new Document();  
                        fieldType
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(1L));
                        fieldType  
                        quantityFieldType  
                    assertThat(inventoryCount.getValue(), equalTo(1L));
    }  
                        Document d = new Document();
                        .stream()
                indexWriter.addDocument(document);  
            // First aggregation with multiple terms
                        .filter(bucket -> bucket.getKeyAsNumber().doubleValue() == 9.99)
                .orElse(null);  
                    Document doc = new Document();
                        .findFirst()  
                        "category",
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")  
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                    aggregator.postCollection();
                    for (int j = 0; j < counts[i]; j++) {
            assertThat(category2Bucket.getDocCount(), equalTo(1L));  
            }  
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                        ),
                        "First two buckets should be categories 1 and 2",
                        Settings.EMPTY  
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                for (int i = 0; i < 5; i++) {  
            // First aggregation
                        numberFieldType,
                    aggregator.postCollection();
                        new MultiBucketConsumerService.MultiBucketConsumer(  
    }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    );
                indexWriter.addDocument(doc);
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.index.IndexReader;  
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                        )
                    aggregator.preCollection();  
                        .size(2)
                    DoubleTerms.Bucket price999Bucket = result.getBuckets()  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            .numberOfShards(1)
                    doc.add(new NumericDocValuesField("score", (i + 1) * 100));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                doc3.add(new NumericDocValuesField("category", 2));  
                document = new Document();
                indexWriter1.addDocument(doc);  
                    assertThat(avgTemp.getValue(), equalTo(35.0));  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
package org.opensearch.search.aggregations.bucket.terms;
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
        try (Directory directory = newDirectory()) {  
                    assertEquals(5, buckets.size());
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
                    createIndexSettings(),
                    assertThat(thirdBucket.getDocCount(), equalTo(1L));
                        fieldType  
                    IllegalArgumentException exception = expectThrows(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=12+14+16+18+20=80, other=30
        try (Directory directory = newDirectory()) {  
                document = new Document();
                        indexWriter.addDocument(doc);
                doc.add(new NumericDocValuesField("category", 1));
                    assertThat(avgRating.getValue(), equalTo(3.0));  
            // Check that sub-aggregation values are properly reduced  
                    }
            // Size limit should be applied during reduce phase
                    );
                        Settings.EMPTY  
                    maxTemp = region2Bucket.getAggregations().get("max_temp");
                            DEFAULT_MAX_BUCKETS,  
                    MappedFieldType storeFieldType = new NumberFieldMapper.NumberFieldType("store", NumberFieldMapper.NumberType.LONG);
                doc.add(new NumericDocValuesField("price", 200));
                // Create terms where top 5 by count != first 5 numerically
                    Max max0 = buckets.get(0).getAggregations().get("max_qty");
                            DEFAULT_MAX_BUCKETS,  
                        categoryFieldType
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    LongTerms.Bucket term0Bucket = buckets.stream()  
            }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            .numberOfShards(1)
                        "category",
                    );
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    assertThat(result, notNullValue());
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                            .creationDate(System.currentTimeMillis())
                        NumberFieldMapper.NumberType.LONG  
                    );  
                document.add(new NumericDocValuesField("temperature", 30));  
                    assertThat(price999Bucket.getDocCount(), equalTo(2L));  
                        ),  
                        Document doc = new Document();
                document.add(new NumericDocValuesField("category", 1));  
 * SPDX-License-Identifier: Apache-2.0
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType(  
                }
                    doc.add(new NumericDocValuesField("category", i));
        }  
                doc = new Document();  
                        .build();
                    fieldType
            }
                    assertThat(result.getBuckets().size(), equalTo(2));
                        assertThat(result.getBuckets().size(), equalTo(2));
                    );
import org.opensearch.search.aggregations.metrics.ValueCount;
                Document doc2 = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    );
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                for (int i = 3; i < 8; i++) {  
                for (int i = 0; i < 2; i++) {
                document.add(new NumericDocValuesField("field", 1));  
                            DEFAULT_MAX_BUCKETS,
        try (Directory directory = newDirectory()) {  
                doc.add(new NumericDocValuesField("category", 1));  
                document.add(new NumericDocValuesField("temperature", 25));  
                Document document = new Document();
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
        try (Directory directory = newDirectory()) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    // For streaming aggregator, size limitation may not be applied at buildAggregations level
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        .orElse(null);
                    IndexSettings indexSettings = new IndexSettings(
 * this file be licensed under the Apache-2.0 license or a
                    assertThat(
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
import org.apache.lucene.search.IndexSearcher;  
                        .findFirst()  
                    assertThat(result, notNullValue());  
                    aggregator.postCollection();
                    avgRating = product200Bucket.getAggregations().get("avg_rating");
                    doc.add(new NumericDocValuesField("id", Long.MAX_VALUE - i));  
                        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", type);
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                    aggregator.preCollection();  
                }  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher1));  
                        aggregator.preCollection();
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
                }
                    indexWriter2.addDocument(doc);  
                            indexSearcher,
            }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
    public void testNoSortOrderWithSubAggregation() throws Exception {
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                    aggregator.preCollection();  
                for (int i = 0; i < 10; i++) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                            DEFAULT_MAX_BUCKETS,
                        indexSearcher,
                indexWriter.addDocument(document);  
                        indexWriter.addDocument(doc);
                        )  
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(200L));
public class StreamNumericTermsAggregatorTests extends AggregatorTestCase {  
                        null,
                        indexSearcher,
                        userIdFieldType
                    );  
    public void testMultipleBatches() throws Exception {
                        .subAggregation(new SumAggregationBuilder("total_quantity").field("quantity"));
    }  
                        exception.getMessage(),
                indexWriter.addDocument(document);
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                Document doc = new Document();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        IllegalArgumentException.class,
                    // Verify we have the expected buckets with correct doc counts
                    assertThat(region2Bucket.getDocCount(), equalTo(1L));  
                        categoryFieldType,  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                // Create 10 categories with varying cardinality (size=5, total=10)  
                                Settings.builder()
                    assertThat(result.getBuckets().size(), equalTo(3));
            }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
        }  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                document = new Document();  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                indexWriter.addDocument(document);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    inventoryCount = store2Bucket.getAggregations().get("inventory_count");  
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.DOUBLE);
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");  
                    aggregator.preCollection();  
                        .build();
                    );  
import org.apache.lucene.document.NumericDocValuesField;
                        createIndexSettings(),
                    assertThat(maxValueBucket, notNullValue());
                    IndexSettings indexSettings = new IndexSettings(
                document.add(new NumericDocValuesField("store", 1));  
                        createIndexSettings(),
                        indexSearcher,  
                        null,
                        .subAggregation(new AvgAggregationBuilder("avg_rating").field("rating"));
    }
                }
                            .settings(  
                    // value 0 appears in docs 0,3,6,9 = 4 times  
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(  
                            .creationDate(System.currentTimeMillis())
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("inventory", 200));  
                        createIndexSettings(),
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(2L));
                        .size(5)  
                        "category",
                        .order(BucketOrder.key(true));
                fieldType2  
        try (Directory directory = newDirectory()) {
                    IndexSettings indexSettings = new IndexSettings(
                    assertThat(store2Bucket, notNullValue());  
                        Settings.EMPTY  
                    assertThat(result, notNullValue());
                        ),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        ),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    );
                    // Execute the aggregator
                        categoryFieldType,
                    assertThat(totalDocs, equalTo(5L));
                    assertThat(buckets.size(), equalTo(3));
            }
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                    DEFAULT_MAX_BUCKETS,
                        .subAggregation(new MaxAggregationBuilder("max_temp").field("temperature"))  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(7L));  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
        try (Directory directory = newDirectory()) {  
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
import org.apache.lucene.document.SortedSetDocValuesField;
                    assertThat(result.getBuckets().size(), equalTo(2));  
                    indexWriter.addDocument(document);
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(35L));
                indexWriter.addDocument(document);  
                indexWriter.addDocument(document);  
                        fieldType
        MappedFieldType fieldType1,
    public void testBuildAggregationsBatchWithSingleValuedOrds() throws Exception {
                        ),
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(card1.getValue(), equalTo(4L));
                Document document = new Document();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        Settings.EMPTY
    }
                        categoryFieldType,
                        NumberFieldMapper.NumberType.LONG  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                        createIndexSettings(),  
                            .build(),
                    totalHumidity = region2Bucket.getAggregations().get("total_humidity");
                        .orElse(null);
        }
                    );  
                        indexSearcher,  
        return aggregator.buildTopLevel();
        try (Directory directory = newDirectory()) {
    public void testUnsignedLongTermsWithSubAggregationOrdering() throws Exception {
                        .order(BucketOrder.aggregation("max_value", false));  
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                        ),
                            .build(),  
                    );
                Document doc1 = new Document();  
            // Reduce the aggregations  
                document.add(new NumericDocValuesField("field", 1));
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
            assertThat(category2Bucket, notNullValue());
                } else {
                }  
                indexWriter.addDocument(document);
                    }
                }
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                    assertThat(buckets.get(2).getDocCount(), equalTo(8L));
                    );
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    assertThat(buckets.get(0).getKeyAsNumber().doubleValue(), equalTo(11.0));
                        createIndexSettings(),
                    List<LongTerms.Bucket> buckets = reduced.getBuckets();
                        .stream()
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                document = new Document();  
                            )
                    // Verify otherDocCount: total=55 docs (10+9+8+7+6+5+4+3+2+1), selected=40 (10+9+8+7+6), other=15
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    LongTerms.Bucket term1Bucket = buckets.stream()
                            DEFAULT_MAX_BUCKETS,
                    assertThat(region1Bucket.getDocCount(), equalTo(2L));
                        "category",
                    assertThat(avgRating.getValue(), equalTo(4.5));  
                            .build(),
                            .numberOfReplicas(0)  
                                    .put("index.aggregation.streaming.min_segment_size", 1)  
                        .orElse(null);  
                }  
                        .stream()
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                // Create terms where top 5 by count != last 5 numerically  
                        indexSearcher,  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);  
                        ),
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .order(BucketOrder.aggregation("max_qty", false))  
import java.util.ArrayList;  
import org.apache.lucene.document.Document;
                document.add(new NumericDocValuesField("field", 42));  
                        d.add(new SortedNumericDocValuesField("value", 100)); // Same max for all
                        aggregationBuilder,
                    assertThat(card1.getValue(), equalTo(14L));  
                    assertThat(secondResult.getBuckets().get(0).getDocCount(), equalTo(1L));
                            DEFAULT_MAX_BUCKETS,
                    List<DoubleTerms.Bucket> buckets = result.getBuckets();
                            .build(),
                    );  
                    for (int j = 0; j < numDocs; j++) {  
                document.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(9.99)));
                    List<DoubleTerms.Bucket> buckets = result.getBuckets();  
                doc.add(new NumericDocValuesField("value", 10));  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                indexWriter.addDocument(document);
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(100L));  
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                assertTrue("Should contain result_strategy", debugInfo.containsKey("result_strategy"));
                            DEFAULT_MAX_BUCKETS,  
                        .shardSize(5)  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                fieldType1  
                    aggregator.preCollection();  
                iw.addDocument(document);
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(5L));  
                document.add(new org.apache.lucene.document.LongPoint("number", 1));  
                        indexSearcher,
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertThat(firstBatch.getBuckets().get(0).getKeyAsNumber().longValue(), equalTo(123L));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        doc.add(new NumericDocValuesField("category", i));
                    );
                for (int i = 0; i < 3; i++) {
                }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    Cardinality card3 = buckets.get(3).getAggregations().get("unique_users");  
