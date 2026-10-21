                    List<LongTerms.Bucket> buckets = result.getBuckets();
                document = new Document();
            }
                document.add(new NumericDocValuesField("field", NumericUtils.floatToSortableInt(3.14f)));
                    assertThat(avgTemp.getValue(), equalTo(27.5));
                        fieldType
                    assertThat(avgRating.getValue(), equalTo(3.0));
        try (Directory directory = newDirectory()) {
                        ),
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(7L));
                    createIndexSettings(),
        }
            }
                        IndexMetadata.builder("_index")
                );
                doc.add(new NumericDocValuesField("category", 1));
                    LongTerms firstResult = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        indexSettings,
                        categoryFieldType
    }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertEquals(50.0, ((InternalSum) buckets.get(0).getAggregations().get("sum_value")).getValue(), 0.001);
public class StreamNumericTermsAggregatorTests extends AggregatorTestCase {
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    doc.add(new NumericDocValuesField("category", 0));
                        "category",
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        indexSearcher,
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                        doc.add(new NumericDocValuesField("category", i));
                        NumberFieldMapper.NumberType.BYTE };
                for (int i = 3; i < 8; i++) {
    }
                    assertThat(buckets.get(0).getDocCount(), equalTo(2L));
                    assertThat(card1.getValue(), equalTo(14L));
            LongTerms terms = (LongTerms) reduced;
                    indexWriter.addDocument(document);
                        indexSearcher,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    for (int i = 0; i < buckets.size() - 1; i++) {
                            .numberOfReplicas(0)
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
                    // Get the result and reduce it
                }
                document.add(new NumericDocValuesField("price", 50));
import org.opensearch.search.aggregations.metrics.ValueCount;
                document.add(new NumericDocValuesField("field", 300));
            // First aggregation
                    assertThat(result, notNullValue());
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        createIndexSettings(),
                }
                            .build(),
                        indexSearcher,
import java.io.IOException;
                        createIndexSettings(),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        ),
                        ),
                        aggregationBuilder,
                    document.add(new NumericDocValuesField("field", i % 3));
                        "quantity",
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        assertThat(bucket.getKey(), instanceOf(Long.class));
                    aggregator.preCollection();
import static org.hamcrest.Matchers.equalTo;
                        Settings.EMPTY
        }
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
    }
        }
                        Document d = new Document();
                        .size(2)
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    );
                        createIndexSettings(),
            assertThat(category3Bucket.getDocCount(), equalTo(1L));
                        null,
                doc.add(new NumericDocValuesField("category", 0));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result.getBuckets().size(), equalTo(3));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    for (int j = 0; j < uniqueUsers; j++) {
                    for (int i = 1; i <= 5; i++) {
        try (Directory directory = newDirectory()) {
                    LongTerms result1 = (LongTerms) results[0];
                }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        aggregationBuilder,
                        .build();
                    UnsignedLongTerms.Bucket maxValueBucket = result.getBuckets()
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        try (Directory directory = newDirectory()) {
                document.add(new NumericDocValuesField("temperature", 25));
                    for (int i = 0; i < buckets.size() - 1; i++) {
                }
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                document = new Document();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        "number",
                        productFieldType,
                            "Streaming aggregation does not support key-based ordering for numeric fields. Use traditional aggregation approach instead."
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                doc.add(new NumericDocValuesField("category", 2));
    public void testOrderByCardinalitySubAggregationAscending() throws Exception {
                }
    public void testUnsignedLongTermsWithSubAggregationOrdering() throws Exception {
            assertThat(category3Bucket, notNullValue());
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        "category",
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                        .order(BucketOrder.aggregation("max_value", false));
                        aggregator.preCollection();
                    aggregator.preCollection();
                document = new Document();
                document.add(new SortedNumericDocValuesField("tags", 3));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    );
                        assertThat(bucket.getKeyAsString(), notNullValue());
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(secondResult.getBuckets().get(0).getDocCount(), equalTo(1L));
                            DEFAULT_MAX_BUCKETS,
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        .size(3)
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
        }
                    aggregator.preCollection();
            }
                    );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertEquals(2L, buckets.get(1).getKeyAsNumber().longValue());
                // Category 0: 3 docs with value 10 each (sum=30)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        .stream()
                    assertThat(buckets.size(), equalTo(3));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            DEFAULT_MAX_BUCKETS,
                doc5.add(new NumericDocValuesField("category", 2));
                indexWriter.addDocument(document);
                            .numberOfReplicas(0)
                    }
                    aggregator.preCollection();
                    );
                document.add(new SortedNumericDocValuesField("tags", 1));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(1L));
                    aggregator.preCollection();
                            .numberOfShards(1)
            // Create second aggregation with overlapping data
                        NumberFieldMapper.NumberType.LONG
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                // Category 2: 4 docs with value 20 each (sum=80)
                    assertThat(buckets.get(0).getDocCount(), equalTo(2L));
                        doc.add(new NumericDocValuesField("category", i));
                        aggregationBuilder,
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
import org.opensearch.index.IndexSettings;
                }
                        .stream()
                    aggregator.postCollection();
                document = new Document();
            );
import org.opensearch.search.aggregations.BucketOrder;
                    Max max1 = buckets.get(1).getAggregations().get("max_score");
                            .settings(
                for (int i = 0; i < 10; i++) {
    }
                    indexWriter1.addDocument(doc);
                    );
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));
                for (int i = 0; i < 10; i++) {
                    IndexSettings indexSettings = new IndexSettings(
                doc = new Document();
                    assertEquals(80.0, ((InternalSum) buckets.get(1).getAggregations().get("sum_value")).getValue(), 0.001);
                        ),
                        indexSettings,
                    aggregator.postCollection();
                    assertThat(result, notNullValue());
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                            .creationDate(System.currentTimeMillis())
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    );
                        indexSearcher,
                    assertEquals(35.0, ((Avg) buckets.get(0).getAggregations().get("avg_value")).getValue(), 0.001);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                document = new Document();
                doc = new Document();
        }
        try (Directory directory = newDirectory()) {
                    assertThat(result, notNullValue());
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                        fieldType
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
                    IndexSettings indexSettings = new IndexSettings(
                document.add(new NumericDocValuesField("region", 1));
                }
                            )
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(4L));
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                        .shardSize(2)
                        createIndexSettings(),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                        ),
                    }
                        fieldType
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            assertThat(reduced, instanceOf(LongTerms.class));
                }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(result.getBuckets().size(), equalTo(2));
                        null,
                    );
                document.add(new NumericDocValuesField("field", Long.MAX_VALUE));
                }
                    doc.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(10.0 + i)));
                        ),
                Document document = new Document();
                        aggregationBuilder,
        }
                        null,
    }
                        indexSearcher,
            );
                        Settings.EMPTY
                    aggregator.postCollection();
                indexWriter.addDocument(document);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                        aggregationBuilder,
                    LongTerms.Bucket product200Bucket = result.getBuckets()
            assertThat(category1Bucket.getDocCount(), equalTo(2L));
        }
                        NumberFieldMapper.NumberType.SHORT,
                        .order(BucketOrder.aggregation("unique_users", false))
                            .numberOfReplicas(0)
                        equalTo(
                    assertThat(result, notNullValue());
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
            }
    public void testOrderByMaxSubAggregationDescending() throws Exception {
            }
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(6L));
                        aggregationBuilder,
                            .numberOfShards(1)
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                // Create 10 categories where alphabetical order != count order
                    for (int j = 0; j < numDocs; j++) {
                        .shardSize(3)
                        .stream()
                        doc.add(new NumericDocValuesField("value", (i + 1) * 100 + j));
                        aggregationBuilder,
                            DEFAULT_MAX_BUCKETS,
                .orElse(null);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        ),
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(0L));
                            new MultiBucketConsumerService.MultiBucketConsumer(
                    Max max0 = buckets.get(0).getAggregations().get("max_qty");
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(result.getBuckets().size(), equalTo(2));
                document.add(new NumericDocValuesField("field", 100));
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher1));
                        ),
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        NumberFieldMapper.NumberType.LONG
                        quantityFieldType
                    assertThat(firstBucket.getDocCount(), equalTo(2L));
                .findFirst()
                            .numberOfShards(1)
                    assertThat(category1Bucket, notNullValue());
                    assertThat(maxPrice.getValue(), equalTo(50.0));
                        fieldType
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result, notNullValue());
                for (int i = 0; i < 2; i++) {
                    InternalSum totalQuantity = price999Bucket.getAggregations().get("total_quantity");
                    IndexSettings indexSettings = new IndexSettings(
                long[] terms = { 95, 94, 93, 92, 91, 1, 2, 3, 4, 5 };
                    MappedFieldType productFieldType = new NumberFieldMapper.NumberFieldType("product", NumberFieldMapper.NumberType.LONG);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    );
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("product", 100));
                    assertThat(region1Bucket.getDocCount(), equalTo(2L));
                        indexSettings,
                    aggregator.preCollection();
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(6L));
        }
        }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
                        createIndexSettings(),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                    );
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field").size(5);
                }
                            DEFAULT_MAX_BUCKETS,
                        createIndexSettings(),
        }
    }
                    IllegalArgumentException exception = expectThrows(
                for (int i = 0; i < 10; i++) {
    public void testDifferentNumberTypes() throws Exception {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    aggregator.preCollection();
import org.apache.lucene.document.SortedSetDocValuesField;
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=2+4+6=12, other=98
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.DOUBLE);
                    assertThat(result, notNullValue());
        assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                fieldType2
                null,
                indexWriter.addDocument(doc);
                            DEFAULT_MAX_BUCKETS,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertEquals(55.0, ((Avg) buckets.get(1).getAggregations().get("avg_value")).getValue(), 0.001);
                .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher1));
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    assertThat(result, notNullValue());
                    assertThat(buckets.get(1).getKeyAsNumber().doubleValue(), equalTo(2.5));
                    aggregator.postCollection();
        try (Directory directory = newDirectory()) {
                    Cardinality card1 = buckets.get(1).getAggregations().get("unique_users");
                for (int i = 0; i < 3; i++) {
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                        createIndexSettings(),
                document.add(new NumericDocValuesField("inventory", 200));
                }
                        categoryFieldType,
                        .findFirst()
                        null,
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        .order(BucketOrder.key(true));
                        null,
                indexWriter.addDocument(document);
                        .shardSize(5)
                    document.add(new NumericDocValuesField("field", 100));
                            .numberOfShards(1)
                        "First two buckets should be categories 1 and 2",
                    );
                        .shardSize(5)
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                document.add(new NumericDocValuesField("quantity", 20));
                        indexWriter.addDocument(doc);
                    aggregator.postCollection();
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));
                    assertThat(result, notNullValue());
                    );
                        ),
                        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", type);
                }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                document.add(new SortedNumericDocValuesField("tags", 4));
                        aggregationBuilder,
                doc.add(new NumericDocValuesField("value", 20));
                        doc.add(new NumericDocValuesField("category", 9 - i));
                        createIndexSettings(),
                    assertThat(buckets.get(0).getKeyAsNumber().doubleValue(), equalTo(1.5));
                        indexSettings,
                            .numberOfReplicas(0)
        try (Directory directory = newDirectory()) {
                Document doc4 = new Document();
                    assertThat(store2Bucket.getDocCount(), equalTo(1L));
                document.add(new NumericDocValuesField("store", 1));
                        createIndexSettings(),
                    );
                    assertThat(max0.getValue(), equalTo(300.0));
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                }
                        scoreFieldType
                        ),
                    IndexSettings indexSettings = new IndexSettings(
                document.add(new NumericDocValuesField("temperature", 35));
                indexWriter.addDocument(doc3);
 * this file be licensed under the Apache-2.0 license or a
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    );
                    // For streaming aggregator, size limitation may not be applied at buildAggregations level
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        NumberFieldMapper.NumberType.LONG
                indexWriter.addDocument(document);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        indexSearcher,
            // Second aggregation
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                        .shardSize(5)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            DEFAULT_MAX_BUCKETS,
                        valueFieldType
                        doc.add(new NumericDocValuesField("category", i));
                    assertThat(card2.getValue(), equalTo(6L));
                                    .put("index.aggregation.streaming.min_segment_size", 1)
        }
                    assertThat(result, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                getMockScriptService(),
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
                }
            aggregator = createStreamAggregator(
                    assertThat(minHumidity.getValue(), equalTo(60.0));
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    public void testReduceSimple() throws Exception {
    public void testDoubleTermsWithSubAggregationOrdering() throws Exception {
    public void testBuildAggregationsBatchReset() throws Exception {
            }
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(0L));
                        indexWriter.addDocument(doc);
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(7L));
                        IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
                        aggregationBuilder,
                        categoryFieldType,
                PipelineTree.EMPTY
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    DEFAULT_MAX_BUCKETS,
            // Check that sub-aggregation values are properly reduced
        TermsAggregationBuilder builder,
        try (Directory directory = newDirectory()) {
                    assertThat(term1Bucket, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    );
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                            "Streaming aggregation does not support key-based ordering for numeric fields. Use traditional aggregation approach instead."
                }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(15L));
                            DEFAULT_MAX_BUCKETS,
                        null,
            }
                        indexSearcher,
            }
        try (Directory directory = newDirectory()) {
                for (int i = 0; i < 5; i++) {
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(2L));
                    );
                        aggregationBuilder,
import org.opensearch.search.aggregations.metrics.InternalSum;
                    assertThat(result, notNullValue());
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                    doc.add(new NumericDocValuesField("score", (i + 1) * 100));
                    assertThat(totalHumidity.getValue(), equalTo(80.0));
 */
                        .orElse(null);
                    for (int j = 0; j < counts[i]; j++) {
                    assertThat(result.getBuckets().size(), equalTo(5));
                            DEFAULT_MAX_BUCKETS,
                    assertThat(result.getBuckets().size(), equalTo(2));
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        NumberFieldMapper.NumberType.LONG
                        humidityFieldType
                    InternalSum totalSales = category1Bucket.getAggregations().get("total_sales");
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                        indexSearcher,
                }
                indexWriter.addDocument(doc);
                .findFirst()
                    aggregator.preCollection();
            // Reduce the aggregations
                        .put("index.aggregation.streaming.min_segment_size", 1)
                        .order(BucketOrder.key(false));
    }
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(max0.getValue(), equalTo(20.0));
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
import java.util.function.BiConsumer;
                        ),
                        fieldType
                    assertThat(max1.getValue(), equalTo(204.0));
            }
 * The OpenSearch Contributors require contributions made to
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            .settings(
                        NumberFieldMapper.NumberType.UNSIGNED_LONG
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
            }
                    );
                        null,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("prices").field("price")
                        indexSearcher,
                        indexSearcher,
                    Document doc = new Document();
        }
                    new MultiBucketConsumerService.MultiBucketConsumer(
                        "humidity",
                            )
                if (key == 3L || key == 4L) {
                        "category",
            LongTerms terms = (LongTerms) reduced;
                indexWriter.addDocument(doc2);
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                                Settings.builder()
                        .orElse(null);
                    assertEquals(5, buckets.size());
                    assertThat(category2Bucket.getDocCount(), equalTo(1L));
                        .order(BucketOrder.aggregation("unique_users", true))
                        null,
                    // Now perform the reduce operation
                    // First two buckets should have count 2 (categories 1 and 2)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(inventoryCount.getValue(), equalTo(1L));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                        .subAggregation(new AvgAggregationBuilder("avg_temp").field("temperature"))
                    assertThat(maxValueBucket.getDocCount(), equalTo(2L));
                    IndexSettings indexSettings = new IndexSettings(
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        .subAggregation(new CardinalityAggregationBuilder("unique_users").field("user_id"));
                    }
                            .build(),
import org.apache.lucene.store.Directory;
                    assertThat(term0Bucket, notNullValue());
                    assertThat(bucket.getDocCount(), equalTo(2L));
}
                        ),
                        searcher,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        }
                        .order(BucketOrder.aggregation("max_value", true))
    }
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                        (firstBucket.getKeyAsNumber().longValue() == 1L || firstBucket.getKeyAsNumber().longValue() == 2L)
                        IndexMetadata.builder("_index")
                        new MultiBucketConsumerService.MultiBucketConsumer(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("ids").field("id")
                    doc.add(new NumericDocValuesField("category", 1));
                            Integer.MAX_VALUE,
        }
                    List<UnsignedLongTerms.Bucket> buckets = result.getBuckets();
                        indexSearcher,
                doc = new Document();
        }
                        reduceBucketConsumer,
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                Document document = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    doc.add(new NumericDocValuesField("value", 25));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    indexSearcher,
    public void testEmptyDoubleTermsResult() throws Exception {
                    assertThat(max2.getValue(), equalTo(304.0));
                        .order(BucketOrder.key(true));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(200L));
                doc.add(new NumericDocValuesField("category", 1));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                Document document = new Document();
    }
                    document.add(new NumericDocValuesField("field", i % 10));
        aggregator.preCollection();
        try (Directory directory = newDirectory()) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            DEFAULT_MAX_BUCKETS,
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                .orElse(null);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        valueFieldType
                    );
                indexWriter.addDocument(document);
                        .size(5)
                        aggregationBuilder,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                indexWriter.addDocument(document);
                }
                Document doc5 = new Document();
                    assertThat(maxValueBucket, notNullValue());
                document = new Document();
                    aggregator.postCollection();
                        null,
                document.add(new NumericDocValuesField("field", NumericUtils.floatToSortableInt(2.71f)));
                    );
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    LongTerms.Bucket thirdBucket = buckets.get(2);
                document.add(new NumericDocValuesField("field", NumericUtils.doubleToSortableLong(2.5)));
                        IndexMetadata.builder("_index")
    public void testOrderByMaxSubAggregationAscending() throws Exception {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        )
                document = new Document();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
            }
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 100L)
    public void testSubAggregationWithSum() throws Exception {
                    Document document = new Document();
                    minInventory = store2Bucket.getAggregations().get("min_inventory");
                        .shardSize(5)
                        .subAggregation(new MinAggregationBuilder("min_humidity").field("humidity"))
                    DEFAULT_MAX_BUCKETS,
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, fieldType, searcher2));
                            .creationDate(System.currentTimeMillis())
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    LongTerms.Bucket term0Bucket = buckets.stream()
                        indexSearcher,
                }
                    aggregator.preCollection();
                    aggregator.preCollection();
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                        .order(BucketOrder.aggregation("max_value", false));
                indexWriter.addDocument(document);
                    indexWriter2.addDocument(doc);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        indexSettings,
            // First aggregation with multiple terms
                    assertThat(totalDocs, equalTo(5L));
            );
 *
        try (Directory directory = newDirectory()) {
                        ),
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("tags")
                    );
                    }
                indexWriter.addDocument(doc);
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        indexSearcher,
                        createIndexSettings(),
                .stream()
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    // Verify that categories 1 and 2 are the first two (order may vary for equal counts)
                    assertThat(term0Bucket.getDocCount(), equalTo(4L));
            }
            }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);
                        )
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        .size(2)
    }
                        () -> aggregator.buildAggregations(new long[] { 0 })
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                        .size(5)
    public void testBuildAggregationsBatchDirectBucketCreation() throws Exception {
                        valueFieldType
                    indexWriter.addDocument(document);
                        IndexMetadata.builder("_index")
                        .subAggregation(new SumAggregationBuilder("total_sales").field("sales"));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(2L));
                        .orElse(null);
                                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import org.apache.lucene.index.IndexWriter;
                    doc.add(new NumericDocValuesField("category", 2));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
            assertThat(category2Bucket, notNullValue());
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
        }
                        aggregationBuilder,
            InternalSum totalPrice = category1Bucket.getAggregations().get("total_price");
                    MappedFieldType tempFieldType = new NumberFieldMapper.NumberFieldType("temperature", NumberFieldMapper.NumberType.LONG);
                    assertThat(buckets.size(), equalTo(3));
                    indexWriter.addDocument(doc);
                        indexSearcher,
                    aggs.add(buildInternalStreamingAggregation(aggregationBuilder, categoryFieldType, priceFieldType, searcher2));
                        aggregationBuilder,
                    indexWriter.addDocument(doc);
                indexWriter.addDocument(document);
        try (Directory directory = newDirectory()) {
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                        .findFirst()
                    indexWriter.addDocument(doc);
    public void testBuildAggregationsBatchWithSingleValuedOrds() throws Exception {
        try (Directory directory = newDirectory()) {
                document.add(new NumericDocValuesField("field", 42));
                }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        aggregationBuilder,
                        aggregationBuilder,
                }
                indexWriter.addDocument(doc);
                    );
                    aggregator.postCollection();
                        .stream()
        try (Directory directory = newDirectory()) {
                document = new Document();
                        ),
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 0L)
                            .numberOfReplicas(0)
                Document document = new Document();
            assertThat(category2Bucket.getDocCount(), equalTo(1L));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        numberFieldType,
                        .order(BucketOrder.key(false));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    aggregator.postCollection();
                document.add(new NumericDocValuesField("humidity", 65));
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    );
                    IndexSettings indexSettings = new IndexSettings(
    public void testUnsignedLongTermsSubAggregationTieBreaking() throws Exception {
import org.opensearch.core.common.breaker.CircuitBreaker;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    Settings settings = Settings.builder()
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
                        doc.add(new NumericDocValuesField("field", terms[i]));
                    document.add(new NumericDocValuesField("field", 200));
                    assertThat(result, notNullValue());
                Document document = new Document();
                doc.add(new NumericDocValuesField("price", 150));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
        return aggregator.buildTopLevel();
                    Document doc = new Document();
                        indexSettings,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        .subAggregation(new SumAggregationBuilder("total_quantity").field("quantity"));
    }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    Document document = new Document();
                        indexSearcher,
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                            )
                        aggregationBuilder,
                        doc.add(new NumericDocValuesField("value", (9 - i + 1) * 100 + j));
                document.add(new NumericDocValuesField("number", 2));
                doc.add(new NumericDocValuesField("category", 2));
            }
                    );
                    assertEquals(5, buckets.size());
                        .findFirst()
                        Document doc = new Document();
                        ),
                // Category 1: values 30, 40 (avg=35)
                document.add(new org.apache.lucene.document.LongPoint("number", 2));
                    for (int doc = 0; doc < 5; doc++) {
                            .numberOfReplicas(0)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        Settings.EMPTY
                    MappedFieldType storeFieldType = new NumberFieldMapper.NumberFieldType("store", NumberFieldMapper.NumberType.LONG);
                    doc.add(new NumericDocValuesField("category", i));
                        fieldType
                        .size(5)
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    );
                doc = new Document();
                        aggregationBuilder,
                    // category 1: 2 docs, category 2: 2 docs, category 3: 1 doc
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    );
                        indexWriter.addDocument(doc);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    );
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    assertThat(totalSales.getValue(), equalTo(3000.0));
                document.add(new NumericDocValuesField("field", NumericUtils.doubleToSortableLong(1.5)));
                    LongTerms.Bucket store1Bucket = result.getBuckets()
                    IndexSettings indexSettings = new IndexSettings(
                    aggregator.postCollection();
                    long totalDocs = buckets.stream().mapToLong(LongTerms.Bucket::getDocCount).sum();
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
                        exception.getMessage(),
                    assertThat(totalQuantity.getValue(), equalTo(30.0));
                        null,
                    List<LongTerms.Bucket> buckets = result.getBuckets();
import org.opensearch.index.mapper.KeywordFieldMapper;
                    MappedFieldType salesFieldType = new NumberFieldMapper.NumberFieldType("sales", NumberFieldMapper.NumberType.LONG);
                            fieldType
                            .numberOfShards(1)
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                            .numberOfReplicas(0)
                doc.add(new NumericDocValuesField("value", 40));
                indexWriter.addDocument(doc1);
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(1L));
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
        try (Directory directory = newDirectory()) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        }
                    aggregator.postCollection();
    public void testSubAggregationWithAvg() throws Exception {
                        createIndexSettings(),
                indexWriter.addDocument(document);
                for (int i = 0; i < terms.length; i++) {
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
    public void testNoSortOrderWithSubAggregation() throws Exception {
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
                            )
                for (int i = 0; i < 5; i++) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("tags", NumberFieldMapper.NumberType.LONG);
                document.add(new NumericDocValuesField("sales", 1000));
                        ),
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    aggregator.preCollection();
                    assertThat(result, notNullValue());
                doc.add(new NumericDocValuesField("price", 100));
                            aggregationBuilder,
                }
                    assertThat(result.getBuckets().size(), equalTo(2));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        .stream()
                    Document doc = new Document();
                    }
            assertThat(terms.getBuckets().size(), equalTo(3));
                    doc.add(new NumericDocValuesField("id", Long.MAX_VALUE - i));
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        fieldType
                                Settings.builder()
                        aggregationBuilder,
                    indexWriter.addDocument(document);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                indexWriter2.addDocument(doc);
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(3L));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.postCollection();
                        fieldType
                            .numberOfReplicas(0)
                    );
            }
                    aggregator.postCollection();
        }
            // Reduce the aggregations
    }
import org.apache.lucene.index.IndexWriterConfig;
                    // The order is specified but buckets may not be sorted until reduce phase
                b -> {},
                document.add(new NumericDocValuesField("rating", 4));
                        categoryFieldType,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                indexWriter1.addDocument(doc);
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                assertTrue("Should contain total_buckets", debugInfo.containsKey("total_buckets"));
                document.add(new NumericDocValuesField("field", Long.MAX_VALUE - 1));
                        NumberFieldMapper.NumberType.LONG
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    document.add(new NumericDocValuesField("field", i));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    doc.add(new NumericDocValuesField("quantity", (i + 1) * 10));
    }
    }
                        .orElse(null);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    indexWriter.addDocument(doc);
                    LongTerms.Bucket store2Bucket = result.getBuckets()
                        null,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.postCollection();
                    aggregator.postCollection();
                            .settings(
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                document.add(new NumericDocValuesField("category", 1));
                    assertThat(card1.getValue(), equalTo(4L));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        aggregationBuilder,
                            .creationDate(System.currentTimeMillis())
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
            }
                            .build(),
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    Min minHumidity = region1Bucket.getAggregations().get("min_humidity");
                    );
                    assertThat(card4.getValue(), equalTo(20L));
                        ),
                            .numberOfShards(1)
                long[] terms = { 95, 94, 93, 92, 91, 1, 2, 3, 4, 5 };
                    );
        try (Directory directory = newDirectory()) {
                    );
                                DEFAULT_MAX_BUCKETS,
import static org.hamcrest.Matchers.notNullValue;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
    public void testBuildAggregationsBatchWithSize() throws Exception {
                        ),
                        NumberFieldMapper.NumberType.LONG
                // This forces tie-breaking by key during quickselect
    }
                indexWriter.addDocument(document);
                Document document = new Document();
                builder,
                    assertThat(category2Bucket, notNullValue());
                        ),
                        .subAggregation(new MaxAggregationBuilder("max_score").field("score"));
                            .numberOfShards(1)
                    MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType(
            }
                    );
        }
                        .orElse(null);
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                    LongTerms reduced = (LongTerms) topLevel.reduce(Collections.singletonList(topLevel), context);
                        "category",
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        .orElse(null);
                indexWriter.addDocument(document);
                    }
                    );
        }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    for (int j = 0; j < 3; j++) {
                            .numberOfShards(1)
        try (Directory directory = newDirectory()) {
        try (Directory directory = newDirectory()) {
                            .build(),
                    aggregator.preCollection();
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                createIndexSettings(),
                    );
                        .put("index.aggregation.streaming.min_segment_size", 1)
                        Document d = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(max1.getValue(), equalTo(900.0));
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
        }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
                        .size(3)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                }
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType quantityFieldType = new NumberFieldMapper.NumberFieldType(
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(3L));
                    );
                        .subAggregation(new MaxAggregationBuilder("max_temp").field("temperature"))
                }
                    int numDocs = 5;
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        .orElse(null);
                doc.add(new NumericDocValuesField("value", 60));
                    );
                        null,
                    assertThat(category2Bucket, notNullValue());
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        fieldType
                    for (int j = 0; j <= i; j++) {
                document.add(new NumericDocValuesField("category", 1));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                        .subAggregation(new ValueCountAggregationBuilder("inventory_count").field("inventory"));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(result.getBuckets().size(), equalTo(2));
                indexWriter.addDocument(doc4);
                        NumberFieldMapper.NumberType.LONG
                        .subAggregation(new SumAggregationBuilder("sum_value").field("value"));
                    aggregator.preCollection();
            }
                    assertThat(max1.getValue(), equalTo(200.0));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                for (int i = 0; i < 2; i++) {
                    // Verify otherDocCount: total docs = 2+4+6+8+10+12+14+16+18+20=110, selected=12+14+16+18+20=80, other=30
        try (Directory directory = newDirectory()) {
                    Cardinality card3 = buckets.get(3).getAggregations().get("unique_users");
                document = new Document();
                    aggregator.postCollection();
                    assertThat(firstBatch.getBuckets().size(), equalTo(1));
                // Create terms where top 5 by count != first 5 numerically
                    assertEquals(6L, result.getSumOfOtherDocCounts());
                    LongTerms secondResult = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
    public void testEmptyUnsignedLongTermsResult() throws Exception {
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher2)
                    Document doc = new Document();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        Document doc = new Document();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        indexSearcher,
                        .shardSize(2)
        MappedFieldType fieldType1,
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    indexWriter.addDocument(doc);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            .creationDate(System.currentTimeMillis())
                // Create fewer unique terms to test size parameter more meaningfully
                        assertTrue(buckets.get(i).getKeyAsNumber().longValue() < buckets.get(i + 1).getKeyAsNumber().longValue());
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    );
                        regionFieldType,
        try (Directory directory = newDirectory()) {
                    assertThat(totalSales.getValue(), equalTo(500.0));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    // Should get 5 buckets, and they should be sorted by key after coordinator reduce
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                indexWriter.addDocument(document);
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            // Reduce the aggregations
                            .build(),
                    LongTerms.Bucket category1Bucket = result.getBuckets()
                        fieldType
            List<InternalAggregation> aggs = new ArrayList<>();
                    aggregator.preCollection();
    public void testMultipleSubAggregations() throws Exception {
                        priceFieldType
                    // Just verify all expected keys are present
                    assertThat(buckets.get(3).getKeyAsNumber().longValue(), equalTo(8L));
                        .stream()
                        ),
                        IllegalArgumentException.class,
                        .put("index.aggregation.streaming.min_segment_size", 1)
                            DEFAULT_MAX_BUCKETS,
                    maxPrice = category2Bucket.getAggregations().get("max_price");
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                            .build(),
                        .build();
                indexWriter.addDocument(document);
                document = new Document();
                        .order(BucketOrder.key(true));
                                Settings.builder()
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                }
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        Document doc = new Document();
                }
                }
                        assertTrue("Expected key " + expectedKey + " to be present", found);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                document.add(new SortedNumericDocValuesField("tags", 2));
                        null,
                        boolean found = buckets.stream().anyMatch(b -> b.getKeyAsNumber().longValue() == expectedKey);
    }
        }
                        indexWriter.addDocument(doc);
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(Long.MAX_VALUE - 2));
        try (Directory directory = newDirectory()) {
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 200L)
                    InternalAggregation[] results = aggregator.buildAggregations(new long[] { 0 });
                Document doc = new Document();
                doc.add(new NumericDocValuesField("category", 1));
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"))
                    assertThat(card0.getValue(), equalTo(12L));
                        .order(BucketOrder.aggregation("max_value", false))
                document.add(new org.apache.lucene.document.LongPoint("number", 1));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                int[] counts = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
                Document doc = new Document();
                        "quantity",
        return buildInternalStreamingAggregation(builder, fieldType1, null, searcher);
                    avgTemp = region2Bucket.getAggregations().get("avg_temp");
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                }
                                Settings.builder()
                document.add(new NumericDocValuesField("sales", 2000));
                indexWriter.addDocument(document);
                            DEFAULT_MAX_BUCKETS,
                fieldType1
                                Settings.builder()
                    // value 0 appears in docs 0,3,6,9 = 4 times
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            )
                }
                        ),
                    aggregator.postCollection();
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                document.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(9.99)));
                        .size(3)
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        Settings.EMPTY
    }
                        categoryFieldType,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        null,
                Document document = new Document();
                indexWriter1.addDocument(doc);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        doc.add(new NumericDocValuesField("field", terms[i]));
                // Category 0: values 10, 20 (avg=15)
                    assertThat(secondBucket.getDocCount(), equalTo(2L));
                        indexSettings,
                    Document doc = new Document();
                    }
                ),
    public void testKeyOrderDescendingWithSizeLimitDropsCorrectBuckets() throws Exception {
                        .orElse(null);
                        storeFieldType,
                        .subAggregation(new MaxAggregationBuilder("max_qty").field("quantity"));
                            DEFAULT_MAX_BUCKETS,
import org.apache.lucene.document.SortedNumericDocValuesField;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                document = new Document();
                    assertThat(region1Bucket, notNullValue());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("number")
            }
                    MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.DOUBLE);
                    assertThat(result.getBuckets().size(), equalTo(2));
                indexWriter.addDocument(doc);
    }
                }
                }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        NumberFieldMapper.NumberType.LONG
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    LongTerms.Bucket category1Bucket = result.getBuckets()
                        indexSearcher,
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result, notNullValue());
                    Max maxPrice = category1Bucket.getAggregations().get("max_price");
                        createIndexSettings(),
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                indexWriter.addDocument(document);
                        ),
                        createIndexSettings(),
                    );
        }
                        createIndexSettings(),
            LongTerms.Bucket category1Bucket = terms.getBuckets().get(0);
                    aggregator.preCollection();
                        .order(BucketOrder.key(true));
                        .subAggregation(new SumAggregationBuilder("total_price").field("price"));
                        .stream()
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                        new MultiBucketConsumerService.MultiBucketConsumer(
        StreamNumericTermsAggregator aggregator;
                    aggregator.preCollection();
                    assertThat(result1.getBuckets().size(), equalTo(2));
                        null,
                            .creationDate(System.currentTimeMillis())
                for (int i = 1; i <= 5; i++) {
                    assertThat(buckets.get(4).getDocCount(), equalTo(10L));
                        ),
                            .settings(
                document.add(new NumericDocValuesField("field", 1));
                    Document doc = new Document();
                document.add(new NumericDocValuesField("region", 1));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    );
                        aggregationBuilder,
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    );
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertThat(avgTemp.getValue(), equalTo(35.0));
        }
                    MappedFieldType humidityFieldType = new NumberFieldMapper.NumberFieldType(
                    Max max1 = buckets.get(1).getAggregations().get("max_qty");
import org.apache.lucene.tests.index.RandomIndexWriter;
                        indexSearcher,
                        ratingFieldType
                }
                        createIndexSettings(),
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                        numberFieldType,
    }
                        aggregationBuilder,
                indexWriter2.addDocument(doc);
                    assertThat(buckets.get(1).getDocCount(), equalTo(1L));
                document.add(new NumericDocValuesField("price", 200));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        indexSettings,
                        indexSearcher,
                .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
                            .settings(
import org.apache.lucene.util.NumericUtils;
                            DEFAULT_MAX_BUCKETS,
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                document.add(new NumericDocValuesField("quantity", 5));
            );
                            DEFAULT_MAX_BUCKETS,
                indexWriter.commit(); // Ensure data is committed before reading
                    // but rather handled during the reduce phase. Test that we get all terms for this batch.
                    aggregator.postCollection();
                        valueFieldType
    public void testLongTermsSubAggregationTieBreaking() throws Exception {
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                                Settings.builder()
import org.apache.lucene.document.NumericDocValuesField;
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
                        "category",
                document = new Document();
                    aggregator.postCollection();
                    null,
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                        aggregationBuilder,
                        categoryFieldType,
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"));
                    aggregator.postCollection();
            for (LongTerms.Bucket bucket : terms.getBuckets()) {
                    Avg avgTemp = region1Bucket.getAggregations().get("avg_temp");
                        assertTrue(buckets.get(i).getKeyAsNumber().longValue() < buckets.get(i + 1).getKeyAsNumber().longValue());
        }
                    aggregator.postCollection();
                    assertThat(minInventory.getValue(), equalTo(200.0));
                    doc.add(new NumericDocValuesField("value", (i + 1) * 100));
                    List<DoubleTerms.Bucket> buckets = result.getBuckets();
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                    IndexSettings indexSettings = new IndexSettings(
            assertThat(reduced, instanceOf(LongTerms.class));
                        aggregationBuilder,
                }
                        IndexMetadata.builder("_index")
import org.apache.lucene.document.Document;
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
            }
            }
                        "value",
                        Settings.EMPTY
                indexWriter.addDocument(document);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        IndexMetadata.builder("_index")
    public void testSubAggregationWithMax() throws Exception {
    public void testOrderByCardinalitySubAggregationDescending() throws Exception {
                        .order(BucketOrder.aggregation("sum_value", false))
                    Settings settings = Settings.builder()
                        Settings.EMPTY
            }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        NumberFieldMapper.NumberType.LONG
            }
                    // Streaming aggregation does not support key-based ordering for numeric fields
                        .size(5)
        }
                    LongTerms.Bucket firstBucket = buckets.get(0);
                        indexSearcher,
                            .build(),
                    MappedFieldType regionFieldType = new NumberFieldMapper.NumberFieldType("region", NumberFieldMapper.NumberType.LONG);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
        }
                indexWriter1.addDocument(doc);
                iw.addDocument(document);
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                    );
                    aggregator.preCollection();
                document.add(new NumericDocValuesField("field", NumericUtils.floatToSortableInt(3.14f)));
                    assertThat(store1Bucket.getDocCount(), equalTo(2L));
                .filter(bucket -> bucket.getKeyAsNumber().longValue() == 3L)
                    );
                        NumberFieldMapper.NumberType.LONG
                BiConsumer<String, Object> debugCollector = debugInfo::put;
                            .creationDate(System.currentTimeMillis())
        }
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            LongTerms.Bucket category3Bucket = terms.getBuckets()
                        Document doc = new Document();
                        .size(5)
                    minHumidity = region2Bucket.getAggregations().get("min_humidity");
                }
            }
                }
                        .shardSize(2)
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                fieldType1,
                document.add(new NumericDocValuesField("sales", 500));
    public void testOrderByAvgSubAggregation() throws Exception {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                indexWriter.addDocument(document);
        try (Directory directory = newDirectory()) {
                        Settings.EMPTY
                        indexSearcher,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    public void testDoubleTermsResults() throws Exception {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
            }
                    List<LongTerms.Bucket> buckets = result.getBuckets();
    }
                indexWriter.addDocument(document);
        }
                document = new Document();
                        fieldType
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                    );
                    }
                indexWriter.addDocument(document);
                    assertThat(product200Bucket, notNullValue());
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(buckets.get(3).getKeyAsNumber().longValue(), equalTo(8L));
                doc.add(new NumericDocValuesField("value", 10));
                        ),
                        .order(BucketOrder.aggregation("avg_value", false))
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                                Settings.builder()
                }
                doc = new Document();
                        createIndexSettings(),
                    aggregationBuilder,
                        IndexMetadata.builder("_index")
                        IndexMetadata.builder("_index")
                    LongTerms.Bucket region1Bucket = result.getBuckets()
                        tempFieldType,
                    }
import org.opensearch.index.mapper.MappedFieldType;
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                for (long key = 0; key < 20; key++) {
                }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                long key = bucket.getKeyAsNumber().longValue();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                        indexSettings,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(result.getBuckets().size(), equalTo(2));
    }
                        .shardSize(2)
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        equalTo(
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                        "inventory",
                    assertThat(result, notNullValue());
                b -> {},
    public void testBuildAggregationsBatchWithCountOrder() throws Exception {
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(9L));
                        ),
                        fieldType
                            )
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                searcher,
                        indexSearcher,
                    aggregator.preCollection();
                    }
                        IllegalArgumentException.class,
                        indexSearcher,
                    aggregator.postCollection();
            }
                        indexWriter.addDocument(d);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    Max maxTemp = region1Bucket.getAggregations().get("max_temp");
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        .subAggregation(new AvgAggregationBuilder("avg_value").field("value"));
                        .findFirst()
                        indexSearcher,
                    DoubleTerms.Bucket price999Bucket = result.getBuckets()
        try (Directory directory = newDirectory()) {
                        "category",
    }
                indexWriter.addDocument(document);
                        assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        NumberFieldMapper.NumberType.LONG
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                }
                        long expectedKey = i;
                    int numDocs = 10 - i;
                        indexSearcher,
import org.opensearch.search.aggregations.metrics.ValueCountAggregationBuilder;
                    assertThat(result.getBuckets().size(), equalTo(3));
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.FLOAT);
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                            DEFAULT_MAX_BUCKETS,
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(Long.MAX_VALUE - 1));
                    LongTerms.Bucket category2Bucket = result.getBuckets()
            // Size limit should be applied during reduce phase
                    );
                        .findFirst()
                        .findFirst()
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(buckets.get(0).getKeyAsNumber().doubleValue(), equalTo(11.0));
                indexWriter.addDocument(document);
    private InternalAggregation buildInternalStreamingAggregation(
                    assertThat(result, notNullValue());
                document.add(new NumericDocValuesField("product", 200));
                    aggregator.postCollection();
        }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("prices").field("price")
                    assertThat(
                    inventoryCount = store2Bucket.getAggregations().get("inventory_count");
                    indexWriter.addDocument(doc);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
    public void testMultipleBatches() throws Exception {
                        ),
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                }
                document = new Document();
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                            DEFAULT_MAX_BUCKETS,
                        .stream()
                doc = new Document();
                    assertEquals(0L, buckets.get(0).getKeyAsNumber().longValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        null,
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
                    );
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    Avg avgRating = product100Bucket.getAggregations().get("avg_rating");
                        null,
            }
                        indexSettings,
                    aggregator.preCollection();
                            )
            List<InternalAggregation> aggs = new ArrayList<>();
                    aggregator.postCollection();
                    aggregator.preCollection();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                doc = new Document();
                    );
                        ),
                    );
import org.opensearch.search.aggregations.metrics.Min;
                indexWriter1.addDocument(doc);
    }
                        ),
                        NumberFieldMapper.NumberType.LONG
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                        aggregationBuilder,
import org.opensearch.common.util.MockBigArrays;
                    assertThat(card0.getValue(), equalTo(2L));
                indexWriter.addDocument(document);
                    assertThat(buckets.get(1).getKeyAsNumber().doubleValue(), equalTo(12.0));
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                        ),
                doc1.add(new NumericDocValuesField("category", 1));
        }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        new MultiBucketConsumerService.MultiBucketConsumer(
    public void testKeyOrderDescending() throws Exception {
                        indexSettings,
import java.util.ArrayList;
                document = new Document();
                            DEFAULT_MAX_BUCKETS,
                        .orElse(null);
                    assertThat(result.getBuckets().size(), equalTo(2));
                indexWriter.addDocument(document);
                    // Verify the buckets are sorted by count (descending)
                // Create categories with varying doc counts: 0=1, 1=2, 2=3, 3=4, 4=5
                        ),
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(maxTemp.getValue(), equalTo(35.0));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(1L));
package org.opensearch.search.aggregations.bucket.terms;
                getMockScriptService(),
                        aggregator.context().bigArrays(),
                        idFieldType,
                    for (int doc = 0; doc < 5; doc++) {
        try (Directory directory = newDirectory()) {
                        .findFirst()
                    assertThat(results[0], instanceOf(LongTerms.class));
                    for (int j = 0; j < counts[i]; j++) {
                    assertThat(minInventory.getValue(), equalTo(50.0));
                }
                document.add(new NumericDocValuesField("product", 100));
                Document document = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                .findFirst()
                    aggregator.preCollection();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                    doc.add(new NumericDocValuesField("value", 10));
                            .build(),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                doc.add(new NumericDocValuesField("category", 1));
                    assertThat(result.getBuckets().size(), equalTo(2));
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(7L));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.search.aggregations.InternalAggregation;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(results.length, equalTo(1));
            }
                        doc.add(new SortedSetDocValuesField("user_id", new BytesRef("user_" + (i * 100 + j))));
                                    .put("index.aggregation.streaming.min_segment_size", 1)
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("number")
                            DEFAULT_MAX_BUCKETS,
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.UNSIGNED_LONG);
                    aggregator.preCollection();
                    aggregator.postCollection();
                            .settings(
                    assertThat(result, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    Max max2 = buckets.get(2).getAggregations().get("max_value");
                        Settings.EMPTY
                    aggregator.preCollection();
                    assertThat(result, notNullValue());
                    aggregator.postCollection();
                    assertThat(buckets.get(1).getDocCount(), equalTo(4L));
                            DEFAULT_MAX_BUCKETS,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    Cardinality card0 = buckets.get(0).getAggregations().get("unique_users");
                }
                indexWriter.addDocument(document);
                document.add(new NumericDocValuesField("price", 100));
        try (Directory directory = newDirectory()) {
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("regions").field("region")
                        .subAggregation(new AvgAggregationBuilder("avg_rating").field("rating"));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                doc.add(new NumericDocValuesField("value", 50));
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"))
    }
    }
                        ),
                        new MultiBucketConsumerService.MultiBucketConsumer(
    }
                            )
                        null,
            }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                            DEFAULT_MAX_BUCKETS,
            assertThat(terms.getBuckets().size(), equalTo(1));
            }
                indexWriter.addDocument(document);
import org.opensearch.common.util.MockPageCacheRecycler;
                            .creationDate(System.currentTimeMillis())
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                doc.add(new NumericDocValuesField("category", 2));
            );
                        .size(5)
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    assertThat(buckets.get(3).getDocCount(), equalTo(1L));
                        IndexMetadata.builder("_index")
                            .creationDate(System.currentTimeMillis())
                document.add(new NumericDocValuesField("field", 1));
                    );
                        createIndexSettings(),
            }
                    assertEquals(3L, result.getSumOfOtherDocCounts());
                        indexWriter.addDocument(doc);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("number")
                    // Default order is count DESC, so top 5 should be 9, 8, 7, 6, 5 (highest counts)
                    UnsignedLongTerms result = (UnsignedLongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType idFieldType = new NumberFieldMapper.NumberFieldType("id", NumberFieldMapper.NumberType.UNSIGNED_LONG);
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                    aggregator.preCollection();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    public void testMultiValuedField() throws Exception {
                doc.add(new NumericDocValuesField("category", 0));
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        exception.getMessage(),
import org.apache.lucene.index.IndexReader;
                        null,
                            DEFAULT_MAX_BUCKETS,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").size(3);
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("products").field("product")
                        .findFirst()
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
    }
                        aggregationBuilder,
            }
                    Cardinality card2 = buckets.get(2).getAggregations().get("unique_users");
                        new MultiBucketConsumerService.MultiBucketConsumer(
    }
                            .build(),
                    assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                doc.add(new NumericDocValuesField("category", 1));
                document.add(new NumericDocValuesField("rating", 3));
        }
import org.opensearch.Version;
                        indexSearcher,
                    assertThat(buckets.get(0).getDocCount(), equalTo(6L));
                        getMockScriptService(),
        try (Directory directory = newDirectory()) {
                    IndexSettings indexSettings = new IndexSettings(
                indexWriter.addDocument(document);
                PipelineTree.EMPTY
                    assertThat(result, notNullValue());
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                        d.add(new SortedNumericDocValuesField("value", 100));
                        aggregationBuilder,
                        NumberFieldMapper.NumberType.LONG
        }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(buckets.get(3).getDocCount(), equalTo(9L));
                            .settings(
                    );
                    doc.add(new NumericDocValuesField("value", 20));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    private InternalAggregation buildInternalStreamingAggregation(
                        aggregationBuilder,
                    aggregator.postCollection();
                            DEFAULT_MAX_BUCKETS,
            List<InternalAggregation> aggs = new ArrayList<>();
                for (int i = 0; i < terms.length; i++) {
                            DEFAULT_MAX_BUCKETS,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(maxPrice.getValue(), equalTo(200.0));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(3L));
                    assertThat(result.getBuckets().size(), equalTo(2));
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        .filter(b -> b.getKeyAsNumber().longValue() == Long.MAX_VALUE)
                        aggregationBuilder,
                    aggregator.postCollection();
                    );
                    aggregator.postCollection();
                        createIndexSettings(),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        salesFieldType
                    }
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                Document doc1 = new Document();
    }
                    assertThat(result, notNullValue());
                    assertThat(result, notNullValue());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                document.add(new NumericDocValuesField("field", 123));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    assertThat(price999Bucket, notNullValue());
                        indexSearcher,
                        assertThat(bucket, instanceOf(LongTerms.Bucket.class));
                            .numberOfReplicas(0)
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        new MultiBucketConsumerService.MultiBucketConsumer(
        IndexSearcher searcher
                        fieldType
                        valueFieldType
                    IndexSettings indexSettings = new IndexSettings(
    }
                    );
                    MappedFieldType scoreFieldType = new NumberFieldMapper.NumberFieldType("score", NumberFieldMapper.NumberType.LONG);
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(5L));
                Document document = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(max2.getValue(), equalTo(1000.0));
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            assertThat(category1Bucket.getDocCount(), equalTo(3L)); // 2 from first + 1 from second
                    InternalSum totalHumidity = region1Bucket.getAggregations().get("total_humidity");
            // Check that overlapping terms (3, 4) have doc count 2
                    assertThat(product100Bucket, notNullValue());
        try (Directory directory = newDirectory()) {
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                }
                    assertThat(buckets.size(), equalTo(5));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(4).getKeyAsNumber().longValue(), equalTo(9L));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        inventoryFieldType
                        .order(BucketOrder.aggregation("max_value", false));
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        .size(2)
                document = new Document();
                        IndexMetadata.builder("_index")
                    assertThat(card2.getValue(), equalTo(16L));
                    assertThat(inventoryCount.getValue(), equalTo(2L));
                }
                            DEFAULT_MAX_BUCKETS,
        searcher.search(new MatchAllDocsQuery(), aggregator);
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                .stream()
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        createIndexSettings(),
                            .creationDate(System.currentTimeMillis())
                    IllegalArgumentException exception = expectThrows(
                        Document doc = new Document();
                        indexSearcher,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        null,
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("inventory", 50));
                    Max max0 = buckets.get(0).getAggregations().get("max_score");
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(2L));
                                Settings.builder()
                        aggregationBuilder,
                        null,
        try (Directory directory = newDirectory()) {
                    IndexSettings indexSettings = new IndexSettings(
                        .size(5)
                Document doc = new Document();
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                        aggregationBuilder,
            assertThat(terms.getBuckets().size(), equalTo(3));
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                    );
                    aggregator.preCollection();
                            null,
                document.add(new NumericDocValuesField("category", 1));
                    assertThat(result, notNullValue());
                    assertThat(buckets.get(2).getDocCount(), equalTo(5L));
                Document document = new Document();
import java.util.Map;
                        aggregationBuilder,
                            .numberOfReplicas(0)
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    // Execute the aggregator
                        .order(BucketOrder.aggregation("max_qty", false))
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
            // Second aggregation with different terms
                        indexSearcher,
                    );
                        assertThat(result, notNullValue());
                        indexSearcher,
                            )
                        .subAggregation(new SumAggregationBuilder("total_humidity").field("humidity"));
    public void testOrderBySumSubAggregation() throws Exception {
                    LongTerms topLevel = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        fieldType
                    );
                        null,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    );
                        d.add(new SortedNumericDocValuesField("value", NumericUtils.doubleToSortableLong(100.0)));
                    assertThat(store2Bucket, notNullValue());
        try (Directory directory = newDirectory()) {
                        categoryFieldType,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                        ),
                            )
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.DOUBLE);
                        indexWriter.addDocument(doc);
                    );
                            indexSearcher,
    ) throws IOException {
                    );
                assertEquals("stream_long_terms", debugInfo.get("result_strategy"));
            }
                        ),
                    aggregator.postCollection();
                        new MultiBucketConsumerService.MultiBucketConsumer(
        IndexSearcher searcher
                        indexSettings,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(result.getBuckets().size(), equalTo(2));
                        .stream()
                    assertEquals(2L, buckets.get(1).getKeyAsNumber().longValue());
                            .creationDate(System.currentTimeMillis())
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    aggregator.preCollection();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        userIdFieldType
                        NumberFieldMapper.NumberType.LONG
                for (int i = 0; i < 4; i++) {
                        indexWriter.addDocument(doc);
                    for (int j = 0; j < uniqueUsers; j++) {
                            DEFAULT_MAX_BUCKETS,
            }
                    );
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                    assertEquals(1L, buckets.get(1).getKeyAsNumber().longValue());
                    // Verify otherDocCount: total=55 docs (10+9+8+7+6+5+4+3+2+1), selected=40 (10+9+8+7+6), other=15
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(35L));
        try (Directory directory = newDirectory()) {
                            DEFAULT_MAX_BUCKETS,
        } else {
/*
                    // Third bucket should be category 3 with count 1
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        null,
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                indexWriter.addDocument(document);
                Document document = new Document();
                    assertThat(result, notNullValue());
                        .subAggregation(new MinAggregationBuilder("min_inventory").field("inventory"))
                        .subAggregation(new MinAggregationBuilder("min_value").field("value"));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(firstBatch.getBuckets().get(0).getKeyAsNumber().longValue(), equalTo(123L));
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                        .order(BucketOrder.aggregation("min_value", true))
                        Document doc = new Document();
            LongTerms terms = (LongTerms) reduced;
                indexWriter.addDocument(doc5);
                        new MultiBucketConsumerService.MultiBucketConsumer(
        try (Directory directory = newDirectory()) {
                    int uniqueUsers = (i + 1) * 2;
                        NumberFieldMapper.NumberType.LONG
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                                    .put("index.aggregation.streaming.min_segment_size", 1)
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
                for (int i = 0; i < 10; i++) {
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        .stream()
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
        try (Directory directory = newDirectory()) {
                    assertThat(buckets.get(1).getDocCount(), equalTo(7L));
                    // Returned in alphabetical order at shard level
                        d.add(new SortedNumericDocValuesField("number", key));
                    LongTerms.Bucket category2Bucket = result.getBuckets()
                        null,
                        Settings.EMPTY
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    aggregator.postCollection();
                    assertThat(result.getBuckets().size(), equalTo(3));
                        fieldType
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        .order(BucketOrder.count(false));
                    assertThat(firstResult.getBuckets().size(), equalTo(1));
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                        .orElse(null);
                    assertThat(buckets.get(2).getDocCount(), equalTo(8L));
                for (int i = 0; i < 4; i++) {
                        NumberFieldMapper.NumberType.UNSIGNED_LONG
    }
                doc = new Document();
                    aggregator.postCollection();
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 1L)
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(1L));
                        .findFirst()
                document.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(19.99)));
                document.add(new NumericDocValuesField("number", 1));
                doc.add(new NumericDocValuesField("price", 200));
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(2L));
                        createIndexSettings(),
                Document doc2 = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            .settings(
                        .orElse(null);
                document = new Document();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    LongTerms.Bucket term1Bucket = buckets.stream()
                        null,
            }
                        () -> aggregator.buildAggregations(new long[] { 0 })
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    );
                    // Verify total document count across all buckets
                    }
    public void testDoubleTermsWithSubAggregation() throws Exception {
                    IndexSettings indexSettings = new IndexSettings(
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        indexWriter.addDocument(doc);
                    assertThat(
                    assertThat(result, notNullValue());
                    );
                }
                        assertThat(result.getBuckets().size(), equalTo(2));
            // Create first aggregation with some data
                    assertThat(max0.getValue(), equalTo(104.0));
                        NumberFieldMapper.NumberType.INTEGER,
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.common.settings.Settings;
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    LongTerms firstBatch = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertTrue(
                    assertThat(term1Bucket.getDocCount(), equalTo(3L));
                    for (LongTerms.Bucket bucket : result.getBuckets()) {
                    );
                        fieldType
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    MappedFieldType userIdFieldType = new KeywordFieldMapper.KeywordFieldType("user_id");
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                        PipelineTree.EMPTY
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
                    // Test with minDocCount=3, should only return categories 2, 3, 4
                        "category",
                indexWriter.addDocument(document);
                                Settings.builder()
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(100L));
                indexWriter.addDocument(document);
                        LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                // Create 10 categories with varying cardinality (size=5, total=10)
                    );
    }
                        createIndexSettings(),
            // Check that category 1 bucket has count 2 (from both aggregations)
                        "category",
                        aggregationBuilder,
                for (int i = 0; i < 3; i++) {
                Document document = new Document();
    public void testMultipleOwningBucketOrds() throws Exception {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            }
                    aggregator.preCollection();
                indexWriter.addDocument(document);
                        indexWriter.addDocument(d);
                Document document = new Document();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    doc.add(new NumericDocValuesField("category", i));
                        "category",
import org.apache.lucene.util.BytesRef;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category")
                    assertThat(max1.getValue(), equalTo(30.0));
                    assertThat(buckets.get(4).getKeyAsNumber().longValue(), equalTo(9L));
                        numberFieldType,
                            .numberOfShards(1)
                }
                    assertThat(secondResult.getBuckets().size(), equalTo(1));
                        assertTrue(buckets.get(i).getKeyAsNumber().doubleValue() < buckets.get(i + 1).getKeyAsNumber().doubleValue());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    public void testBuildAggregationsBatchEmptyResults() throws Exception {
                        Settings.EMPTY
                // Create 10 categories where TOP 3 by max ASC won't be alphabetically first
                    // Verify otherDocCount: 10 categories * 5 docs = 50 total, selected 3*5=15, other=35
                        Settings.EMPTY
                    List<DoubleTerms.Bucket> buckets = result.getBuckets();
        }
                        StreamNumericTermsAggregator aggregator = createStreamAggregator(
                        null,
                    aggregator.doReset();
                            )
            }
                indexWriter.addDocument(doc);
                        .order(BucketOrder.key(false))
                doc2.add(new NumericDocValuesField("category", 1));
                document = new Document();
                    assertThat(buckets.size(), equalTo(5));
import org.apache.lucene.index.DirectoryReader;
                        IndexMetadata.builder("_index")
                        fieldType
                        aggregationBuilder,
                    Document document = new Document();
import org.opensearch.cluster.metadata.IndexMetadata;
                }
                    assertThat(card3.getValue(), equalTo(18L));
                document.add(new NumericDocValuesField("field", 200));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                }
                    // Verify we have the expected buckets with correct doc counts
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                        null,
                indexWriter.addDocument(document);
                        indexSettings,
                document.add(new NumericDocValuesField("category", 2));
import org.opensearch.search.aggregations.AggregatorTestCase;
                    );
                        categoryFieldType,
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                        NumberFieldMapper.NumberType.LONG
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                Document document = new Document();
                    aggregator.postCollection();
                document.add(new SortedNumericDocValuesField("tags", 2));
        }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                Document doc = new Document();
                        valueFieldType
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("stores").field("store")
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        valueFieldType
                            .numberOfShards(1)
                    assertThat(term2Bucket, notNullValue());
                iw.addDocument(document);
                    ValueCount inventoryCount = store1Bucket.getAggregations().get("inventory_count");
                    // value 1 appears in docs 1,4,7 = 3 times
                        doc.add(new NumericDocValuesField("category", i));
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    );
                        .order(BucketOrder.count(false)); // Order by count descending
                    IndexSettings indexSettings = new IndexSettings(
                }
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                document.add(new NumericDocValuesField("field", NumericUtils.doubleToSortableLong(1.5)));
            assertThat(reduced, instanceOf(LongTerms.class));
                    assertThat(store1Bucket, notNullValue());
                            .numberOfReplicas(0)
                        fieldType
    }
                        .shardSize(3)
                        "category",
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(result.getBuckets().size(), equalTo(4));
                doc3.add(new NumericDocValuesField("category", 2));
    public void testDoubleTermsSubAggregationTieBreaking() throws Exception {
                        indexSearcher,
                        Document doc = new Document();
                        Settings.EMPTY
        try (Directory directory = newDirectory()) {
        try (Directory directory = newDirectory()) {
                    for (int i = 0; i < buckets.size() - 1; i++) {
                        .findFirst()
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    assertThat(region2Bucket, notNullValue());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    }
                }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                // Create 10 categories with varying max values (size=3, total=10)
                }
                        null,
                        null,
            // Check that categories 2 and 3 buckets each have count 1
                searcher,
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.DOUBLE);
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
    }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        null,
                        .order(BucketOrder.count(false));
                for (int i = 0; i < 20; i++) {
                            .creationDate(System.currentTimeMillis())
                Document doc = new Document();
                            DEFAULT_MAX_BUCKETS,
                            .settings(
                Map<String, Object> debugInfo = new HashMap<>();
                    List<UnsignedLongTerms.Bucket> buckets = result.getBuckets();
                doc.add(new NumericDocValuesField("category", 1));
                document.add(new NumericDocValuesField("humidity", 80));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    public void testKeyOrderWithSizeLimitDropsCorrectBuckets() throws Exception {
    }
                        .orElse(null);
                        .filter(bucket -> bucket.getKeyAsNumber().doubleValue() == 9.99)
import java.util.Collections;
                    totalHumidity = region2Bucket.getAggregations().get("total_humidity");
                        categoryFieldType,
                    doc.add(new NumericDocValuesField("category", i));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                .orElse(null);
                            .settings(
                        .order(BucketOrder.aggregation("max_score", false))
                    assertThat(result.getBuckets().size(), equalTo(10));
                PipelineTree.EMPTY
            }
                }
                        ),
                    aggregator.preCollection();
                    assertThat(totalHumidity.getValue(), equalTo(125.0));
                    Document document = new Document();
import static org.hamcrest.Matchers.instanceOf;
                        null,
                indexWriter.addDocument(document);
                        .subAggregation(new MaxAggregationBuilder("max_value").field("value"))
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                }
                    assertEquals(2L, result.getSumOfOtherDocCounts());
                document.add(new NumericDocValuesField("field", 3));
                        DEFAULT_MAX_BUCKETS,
                        .findFirst()
                        "category",
                        null,
import org.opensearch.search.aggregations.metrics.Cardinality;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(avgRating.getValue(), equalTo(4.5));
                        Document doc = new Document();
                    assertThat(result.getBuckets().size(), equalTo(0));
                    assertThat(thirdBucket.getDocCount(), equalTo(1L));
                    assertThat(minHumidity.getValue(), equalTo(80.0));
        try (Directory directory = newDirectory()) {
                    assertEquals(5, buckets.size());
                        IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
                        categoryFieldType,
                        .findFirst()
        }
                    aggregator.preCollection();
                        .stream()
import java.util.HashMap;
                    );
                    IndexSettings indexSettings = new IndexSettings(
                    assertThat(result, notNullValue());
                            .numberOfReplicas(0)
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                    LongTerms.Bucket region2Bucket = result.getBuckets()
                        .shardSize(5)
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
            }
                getMockScriptService(),
                }
    }
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                }
                }
import org.opensearch.search.aggregations.metrics.Max;
                }
        MappedFieldType fieldType2,
                    Settings settings = Settings.builder()
                    assertThat(result, notNullValue());
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
            aggregator = createStreamAggregator(
                        Settings.EMPTY
import org.apache.lucene.search.MatchAllDocsQuery;
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(300L));
                            .build(),
                    assertThat(result.getBuckets().size(), equalTo(2));
                        buildInternalStreamingAggregation(new TermsAggregationBuilder("categories").field("category"), fieldType, searcher1)
    }
                    aggregator.postCollection();
                // Create buckets where all have same doc count and same max value
                indexWriter.addDocument(document);
                    Document doc = new Document();
                    assertThat(bucket.getDocCount(), equalTo(1L));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
        }
                }
                        indexSearcher,
                    assertThat(buckets.get(1).getDocCount(), equalTo(2L));
                        null,
                        null,
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    );
                    assertThat(result.getBuckets().size(), equalTo(2));
                        null,
    ) throws IOException {
                        quantityFieldType
                        ),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    for (int j = 0; j < numDocs; j++) {
                        aggregationBuilder,
                            DEFAULT_MAX_BUCKETS,
        }
                    aggregator.postCollection();
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                b -> {},
                        Document d = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    // Verify otherDocCount: category 0=1 + category 1=2 = 3 docs excluded
                Document document = new Document();
        }
                document.add(new NumericDocValuesField("category", 2));
                document.add(new NumericDocValuesField("field", 1));
    public void testOrderByMinSubAggregation() throws Exception {
                        );
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType(
            }
                        Settings.EMPTY
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        userIdFieldType
                    aggregator.preCollection();
                        ),
                    );
                // Add multiple documents with different categories to test reduce logic properly
                    // value 2 appears in docs 2,5,8 = 3 times
                    NumberFieldMapper.NumberType[] types = {
    }
                    aggregator.preCollection();
                    assertThat(thirdBucket.getKeyAsNumber().longValue(), equalTo(3L));
                Document document = new Document();
                document.add(new NumericDocValuesField("temperature", 30));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            }
                doc4.add(new NumericDocValuesField("category", 3));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    IndexSearcher searcher = newIndexSearcher(reader);
                        doc.add(new NumericDocValuesField("category", i));
                    totalSales = category2Bucket.getAggregations().get("total_sales");
    public void testSubAggregationWithMinAndCount() throws Exception {
                    // Verify otherDocCount: 10 categories * 1 doc = 10 total, selected 3*1=3, other=7
                    LongTerms.Bucket term2Bucket = buckets.stream()
        try (Directory directory = newDirectory()) {
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(buckets.get(3).getKeyAsNumber().longValue(), equalTo(4L));
                        Settings.EMPTY
                    Document document = new Document();
                }
                    );
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    }
        TermsAggregationBuilder builder,
        MappedFieldType fieldType1,
                        valueFieldType
                    );
                            .numberOfShards(1)
                        categoryFieldType,
import org.opensearch.index.mapper.NumberFieldMapper;
                        d.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(key + 0.5)));
                    fieldType
                }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                document = new Document();
                        aggregationBuilder,
                }
                new MultiBucketConsumerService.MultiBucketConsumer(
                        aggregationBuilder,
                        .subAggregation(new MaxAggregationBuilder("max_price").field("price"));
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    LongTerms.Bucket product100Bucket = result.getBuckets()
    }
                }
                            .creationDate(System.currentTimeMillis())
                    );
                        .stream()
                    Max max1 = buckets.get(1).getAggregations().get("max_value");
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                Document document = new Document();
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                for (long key = 0; key < 20; key++) {
                    int uniqueUsers = (i + 1) * 2; // cat_0=2, cat_1=4, ..., cat_9=20
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                document = new Document();
                    assertThat(category1Bucket.getDocCount(), equalTo(2L));
                    IndexSettings indexSettings = new IndexSettings(
        }
                    MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer =
                    );
                Document doc3 = new Document();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                            )
                }
                    }
                    MappedFieldType inventoryFieldType = new NumberFieldMapper.NumberFieldType(
        }
                    MappedFieldType priceFieldType = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.LONG);
                    List<DoubleTerms.Bucket> buckets = result.getBuckets();
        if (fieldType2 != null) {
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(30L));
                    }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("categories").field("category").minDocCount(3);
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                            DEFAULT_MAX_BUCKETS,
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                    );
                    assertEquals(1L, buckets.get(0).getKeyAsNumber().longValue());
                } else {
                }
                    aggregator.preCollection();
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
            assertThat(totalPrice.getValue(), equalTo(450.0)); // 100 + 200 + 150
                new MultiBucketConsumerService.MultiBucketConsumer(
                    searcher.search(new MatchAllDocsQuery(), aggregator);
                            .build(),
                    assertThat(result, notNullValue());
                        assertThat(bucket.getDocCount(), equalTo(2L));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        aggregator.postCollection();
            assertThat(category1Bucket.getKeyAsNumber().longValue(), equalTo(1L));
    }
                            DEFAULT_MAX_BUCKETS,
                        indexSettings,
                document.add(new NumericDocValuesField("price", NumericUtils.doubleToSortableLong(9.99)));
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                document.add(new NumericDocValuesField("region", 2));
                }
    }
    public void testCollectDebugInfo() throws IOException {
                    aggregator.preCollection();
                for (int i = 0; i < 3; i++) {
        }
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
            }
                ),
                .stream()
                    );
        try (Directory directory = newDirectory()) {
                    aggregator.postCollection();
        try (Directory directory = newDirectory()) {
                    aggregator.preCollection();
                // Category 2: values 50, 60 (avg=55)
                indexWriter2.addDocument(doc);
                    }
                document.add(new NumericDocValuesField("store", 2));
    public void testReduceWithSubAggregations() throws Exception {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                doc.add(new NumericDocValuesField("category", 1));
                    assertThat(region2Bucket.getDocCount(), equalTo(1L));
                                Settings.builder()
                    );
 * compatible open source license.
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(buckets.get(2).getKeyAsNumber().longValue(), equalTo(2L));
                        "category",
                        new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggs.add(
        }
                        .size(2)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(result.getBuckets().size(), equalTo(0));
                        ),
                    aggregator.preCollection();
                        doc.add(new NumericDocValuesField("value", (i + 1) * 10 + j));
                        .shardSize(5)
                createIndexSettings(),
                    indexWriter.addDocument(document);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                        ),
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                document = new Document();
                    // Verify each term appears exactly twice (20 docs / 10 unique terms)
                    assertThat(buckets.size(), equalTo(3));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(category1Bucket, notNullValue());
                        .findFirst()
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                for (int i = 0; i < 10; i++) {
                        null,
                    aggs.add(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    MappedFieldType categoryFieldType = new NumberFieldMapper.NumberFieldType(
                        indexSearcher,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result.getBuckets().size(), equalTo(2));
                indexWriter.addDocument(document);
                    Max max0 = buckets.get(0).getAggregations().get("max_value");
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("category", NumberFieldMapper.NumberType.LONG);
    public void testFloatNumberType() throws Exception {
                        null,
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                        NumberFieldMapper.NumberType.LONG
                    assertThat(buckets.get(2).getDocCount(), equalTo(1L));
            }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    assertThat(result.getBuckets().size(), equalTo(0));
                for (long key = 0; key < 20; key++) {
                    assertThat(buckets.get(1).getKeyAsNumber().longValue(), equalTo(8L));
                                    .put("index.aggregation.streaming.min_segment_size", 1)
    public void testUnsignedLongTermsResults() throws Exception {
                        null,
                            .build(),
                    aggregator.preCollection();
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    ),
                        d.add(new SortedNumericDocValuesField("value", 100)); // Same max for all
                        priceFieldType,
                        aggregationBuilder,
                        .findFirst()
                            DEFAULT_MAX_BUCKETS,
                    // Streaming aggregation does not support key-based ordering for numeric fields
                    assertThat(reduced, notNullValue());
            LongTerms.Bucket category1Bucket = terms.getBuckets()
                    }
                    assertThat(maxTemp.getValue(), equalTo(30.0));
                    aggregator.postCollection();
                // Category 1: 2 docs with value 25 each (sum=50)
                    maxTemp = region2Bucket.getAggregations().get("max_temp");
                        );
                // Create terms where top 5 by count != last 5 numerically
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                document = new Document();
            }
            assertThat(category1Bucket, notNullValue());
                    List<LongTerms.Bucket> buckets = reduced.getBuckets();
                document.add(new NumericDocValuesField("quantity", 10));
                    Cardinality card4 = buckets.get(4).getAggregations().get("unique_users");
                document.add(new NumericDocValuesField("category", 1));
                doc.add(new NumericDocValuesField("value", 30));
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                    assertThat(buckets.size(), equalTo(3));
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                document = new Document();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    DoubleTerms result = (DoubleTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            }
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(5L));
                aggregator.collectDebugInfo(debugCollector);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                                Settings.builder()
                indexWriter.addDocument(document);
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field("number");
                            DEFAULT_MAX_BUCKETS,
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(98L));
                        aggregationBuilder,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertThat(result.getSumOfOtherDocCounts(), equalTo(3L));
                // 9=10 docs (highest), 8=9, 7=8, 6=7, 5=6, 4=5, 3=4, 2=3, 1=2, 0=1 (lowest)
                doc.add(new NumericDocValuesField("category", 3));
                        d.add(new SortedNumericDocValuesField("number", key));
                    for (int doc = 0; doc < 5; doc++) {
                            ),
                    indexWriter.addDocument(document);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field")
                    );
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.search.IndexSearcher;
                        IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
                assertTrue("Should contain result_strategy", debugInfo.containsKey("result_strategy"));
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        .orElse(null);
                document.add(new NumericDocValuesField("inventory", 100));
                    assertThat(max0.getValue(), equalTo(800.0));
                            && !firstBucket.getKeyAsNumber().equals(secondBucket.getKeyAsNumber())
                    assertThat(term2Bucket.getDocCount(), equalTo(3L));
                        priceFieldType,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                builder,
                        .build();
            }
                    assertThat(buckets.get(1).getDocCount(), equalTo(1L));
                    aggregator.preCollection();
                        .orElse(null);
                    LongTerms.Bucket secondBucket = buckets.get(1);
                indexWriter.addDocument(document);
                            .numberOfShards(1)
                    aggregator.preCollection();
                    );
    }
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);
                    MappedFieldType ratingFieldType = new NumberFieldMapper.NumberFieldType("rating", NumberFieldMapper.NumberType.LONG);
                        valueFieldType
                for (int i = 0; i < 3; i++) {
                document.add(new NumericDocValuesField("field", 2));
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("humidity", 60));
                document.add(new NumericDocValuesField("rating", 5));
                // Create 10 categories where TOP 3 by cardinality ASC won't be alphabetically first
                    aggregator.preCollection();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
    }
                    assertThat(price999Bucket.getDocCount(), equalTo(2L));
                    MappedFieldType quantityFieldType = new NumberFieldMapper.NumberFieldType(
                }
                        indexSearcher,
                                Settings.builder()
                        createIndexSettings(),
                        .orElse(null);
                        "category",
    public void testMinDocCount() throws Exception {
                    Document doc = new Document();
                        .shardSize(5)
                    assertThat(buckets.get(0).getKeyAsNumber().longValue(), equalTo(7L));
                        .findFirst()
                        .filter(bucket -> bucket.getKeyAsNumber().longValue() == 2L)
                        indexWriter.addDocument(d);
                    StreamNumericTermsAggregator aggregator = createStreamAggregator(
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                        indexSettings,
    public void testReduceSingleAggregation() throws Exception {
        try (Directory directory = newDirectory()) {
                        IndexMetadata.builder("_index")
                    MappedFieldType numberFieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
    public void testReduceWithSizeLimit() throws Exception {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        try (Directory directory = newDirectory()) {
            }
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                            .settings(
                        createIndexSettings(),
                    assertThat(reduced.getBuckets().size(), equalTo(3));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertThat(buckets.get(0).getDocCount(), equalTo(3L));
                            .settings(
    }
                            && (secondBucket.getKeyAsNumber().longValue() == 1L || secondBucket.getKeyAsNumber().longValue() == 2L)
                    for (LongTerms.Bucket bucket : buckets) {
                    assertThat(result, notNullValue());
                    assertThat(buckets.get(0).getDocCount(), equalTo(1L));
                document.add(new NumericDocValuesField("field", 2));
                        .size(2)
import org.opensearch.search.aggregations.metrics.Avg;
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    for (NumberFieldMapper.NumberType type : types) {
                        .shardSize(2)
        try (Directory directory = newDirectory()) {
                document.add(new NumericDocValuesField("field", Long.MAX_VALUE));
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
                document = new Document();
                        .shardSize(3)
                indexWriter.addDocument(document);
                    avgRating = product200Bucket.getAggregations().get("avg_rating");
                    assertThat(result, notNullValue());
                document = new Document();
                }
            LongTerms.Bucket category2Bucket = terms.getBuckets()
                    aggregator.postCollection();
                }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("test").field("field");
                        new MultiBucketConsumerService.MultiBucketConsumer(
                null,
                            DEFAULT_MAX_BUCKETS,
                document.add(new NumericDocValuesField("store", 1));
                    List<LongTerms.Bucket> buckets = result.getBuckets();
                    assertEquals(1L, buckets.get(0).getKeyAsNumber().longValue());
                    LongTerms result = (LongTerms) aggregator.buildAggregations(new long[] { 0 })[0];
                            createIndexSettings(),
                    Min minInventory = store1Bucket.getAggregations().get("min_inventory");
                    }
        aggregator.postCollection();
                for (int i = 0; i < 10; i++) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertThat(result, notNullValue());
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
        }
                    aggregator.postCollection();
