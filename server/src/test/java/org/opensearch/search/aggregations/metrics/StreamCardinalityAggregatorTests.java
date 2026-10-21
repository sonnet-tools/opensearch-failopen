                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    assertTrue(metricValue > 0);
                        fieldType
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    assertEquals("test", empty.getName());
                        aggregationBuilder,
        }
                        );
                        ),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        null,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                indexWriter.addDocument(document);
                }
                indexWriter.addDocument(document);
    }
                        ),
                        indexSearcher,
                    CardinalityAggregationBuilder lowPrecisionBuilder = new CardinalityAggregationBuilder("test").field("field")
                    assertTrue(result.getValue() > 0);
            }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                            DEFAULT_MAX_BUCKETS,
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                        null,
            }
                            DEFAULT_MAX_BUCKETS,
        }
                // Force a segment
                            DEFAULT_MAX_BUCKETS,
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                            DEFAULT_MAX_BUCKETS,
    public void testReset() throws Exception {
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                indexWriter.addDocument(document);
            InternalCardinality cardinality = (InternalCardinality) reduced;
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                        createIndexSettings(),
 *
                        indexSearcher,
            assertThat(reduced, instanceOf(InternalCardinality.class));
                }
                    CardinalityAggregationBuilder highPrecisionBuilder = new CardinalityAggregationBuilder("test").field("field")
import org.apache.lucene.tests.index.RandomIndexWriter;
            }
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment1_value1")));
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
    }
                Document document = new Document();
                b -> {},
                indexWriter.addDocument(document);
                    searcher.search(new MatchAllDocsQuery(), aggregator);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        null,
                }
                    aggregator.doReset();
                }
                            DEFAULT_MAX_BUCKETS,
                        indexSearcher,
import org.apache.lucene.document.SortedSetDocValuesField;
                }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("cardinality").field("field");
                indexWriter.addDocument(document);
            ),
        MappedFieldType fieldType,
                        fieldType
                        fieldType
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    aggregator.postCollection();
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        ),
                        createIndexSettings(),
                }
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                    aggregator.postCollection();
                    );
import static org.hamcrest.Matchers.notNullValue;
                    highPrecisionAgg.preCollection();
                    aggregator.preCollection();
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
        }
                        indexSearcher,
                    indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                indexWriter1.addDocument(doc);
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
import org.opensearch.common.util.MockPageCacheRecycler;
    }
                            new CardinalityAggregationBuilder("cardinality").field("field"),
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        fieldType
                        createIndexSettings(),
                        null,
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                }
                        aggregationBuilder,
                    indexWriter.addDocument(doc);
                            new CardinalityAggregationBuilder("cardinality").field("field"),
        try (Directory directory = newDirectory()) {
                            fieldType,
                    indexSearcher.search(new MatchAllDocsQuery(), highPrecisionAgg);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            DEFAULT_MAX_BUCKETS,
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                document.add(new SortedSetDocValuesField("field", new BytesRef("cherry")));
        }
            // Create first aggregation with some data
                    InternalCardinality secondResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                Document doc = new Document();
                        aggregator.context().bigArrays(),
import org.opensearch.common.settings.Settings;
                }
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory(); Directory directory3 = newDirectory()) {
                // Create many documents but only a few unique values
                        fieldType
                    // Field doesn't exist, so values source will be null
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        indexSearcher,
        try (Directory directory = newDirectory()) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                document.add(new SortedSetDocValuesField("field", new BytesRef("batch1_value1")));
    }
                    aggregator.postCollection();
                }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                for (int i = 0; i < 10; i++) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertTrue(metricValue <= 10);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    InternalCardinality empty = (InternalCardinality) aggregator.buildEmptyAggregation();
                    assertThat(result, notNullValue());
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    indexWriter.addDocument(document);
                    IndexSearcher searcher3 = newIndexSearcher(reader3);
    }
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        aggregationBuilder,
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
import org.apache.lucene.index.DirectoryReader;
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.apache.lucene.search.MatchAllDocsQuery;
                    // Collect debug info
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                doc = new Document();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                }
                    InternalAggregation topLevel = aggregator.buildTopLevel();
                getMockScriptService(),
            // After reducing, should have approximately 20 unique values (0-19)
                        null,
                        fieldType
                            DEFAULT_MAX_BUCKETS,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                            searcher1
                    assertThat(result, notNullValue());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        IndexSearcher searcher
            }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.core.common.breaker.CircuitBreaker;
                    // With 1000 unique values, cardinality should be close to 1000 (allowing for HLL approximation)
                Document document = new Document();
        StreamCardinalityAggregator aggregator = createStreamAggregator(
                        fieldType
    }
                for (int i = 0; i < 1000; i++) {
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                        indexSearcher,
    }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
        try (Directory directory = newDirectory()) {
                        aggregationBuilder,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        }
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        null,
                    InternalCardinality firstResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        aggregationBuilder,
                for (int i = 0; i < 10; i++) {
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        ),
            }
import org.apache.lucene.document.Document;
                        null,
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    double metricValue = aggregator.metric(0);
                    aggregator.doReset();
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field(
                        new MultiBucketConsumerService.MultiBucketConsumer(
                document.add(new SortedSetDocValuesField("field", new BytesRef("batch1_value2")));
    }
                    );
                    // Should have approximately 5 unique values
                    assertThat(result, notNullValue());
                        new MultiBucketConsumerService.MultiBucketConsumer(
            assertTrue(cardinality.getValue() > 0);
            assertThat(reduced, instanceOf(InternalCardinality.class));
                    assertTrue(debugInfo.containsKey("empty_collectors_used"));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
        }
                        createIndexSettings(),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
    public void testReduceSingleAggregation() throws Exception {
                    Document document = new Document();
                        indexSearcher,
    }
                    Document doc = new Document();
                        indexSearcher,
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment2_value2")));
                    InternalCardinality topLevel = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        IllegalStateException.class,
                    Document doc = new Document();
    public void testMultipleBatches() throws Exception {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertEquals(firstCardinality, secondCardinality);
                        aggregationBuilder,
import static org.hamcrest.Matchers.instanceOf;
        CardinalityAggregationBuilder builder,
                            fieldType,
        try (Directory directory = newDirectory()) {
                    // Should have exactly 3 unique values
import org.opensearch.index.mapper.KeywordFieldMapper;
                    aggregator.preCollection();
                getMockScriptService(),
                        null,
                document = new Document();
                document = new Document();
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
            }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        aggregationBuilder,
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                    // Test metric() method
                    );
            InternalCardinality cardinality = (InternalCardinality) reduced;
                DEFAULT_MAX_BUCKETS,
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG
                            fieldType,
                            DEFAULT_MAX_BUCKETS,
                }
                    // Should be able to collect again after multiple resets
            }
                        createIndexSettings(),
                }
                    document.add(new SortedSetDocValuesField("field", new BytesRef("term_" + (i % 5))));
                            fieldType,
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    aggregator.preCollection();
                        ),
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    );
                    indexWriter.addDocument(document);
        }
import java.util.Collections;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                    // Should have approximately 5 unique values (term_0 through term_4)
                Document document = new Document();
            // Reduce the aggregations
                    assertTrue((Integer) debugInfo.get("empty_collectors_used") > 0);
                        createIndexSettings(),
                    aggregator.preCollection();
                            DEFAULT_MAX_BUCKETS,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
                        new MultiBucketConsumerService.MultiBucketConsumer(
            }
                    aggregator.preCollection();
                            DEFAULT_MAX_BUCKETS,
                    StreamCardinalityAggregator lowPrecisionAgg = createStreamAggregator(
                }
    public void testReduceWithMultipleAggregations() throws Exception {
                    // This should throw IllegalStateException when getLeafCollector is called with non-ordinal value source
                            searcher1
                    );
            }
                        indexSearcher,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        aggregationBuilder,
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                    assertTrue(result.getValue() >= 2 && result.getValue() <= 4); // Allow some HLL approximation error
                        null,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .precisionThreshold(10);
                            DEFAULT_MAX_BUCKETS,
                            DEFAULT_MAX_BUCKETS,
                    long secondCardinality = secondResult.getValue();
                    // Verify empty collector was used
                    aggs.add(
                    aggregator.preCollection();
import java.util.Map;
                    aggs.add(
        }
                    assertTrue(result.getValue() > 0);
    public void testLargeCardinality() throws Exception {
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                    // Get the result and reduce it
                            DEFAULT_MAX_BUCKETS,
                        ),
import org.apache.lucene.search.IndexSearcher;
                    aggregator.postCollection();
                        buildInternalStreamingAggregation(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    );
        try (Directory directory = newDirectory()) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        createIndexSettings(),
                        createIndexSettings(),
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
        try (Directory directory = newDirectory()) {
                        createIndexSettings(),
                indexWriter.commit();
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        new MultiBucketConsumerService.MultiBucketConsumer(
    public void testCollectDebugInfo() throws Exception {
    public void testBuildEmptyAggregation() throws Exception {
package org.opensearch.search.aggregations.metrics;
                }
    public void testMetricMethod() throws Exception {
                    );
        try (Directory directory = newDirectory()) {
            // Create second aggregation with overlapping data
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
 * The OpenSearch Contributors require contributions made to
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    indexWriter.addDocument(document);
                    // With 100 unique values, cardinality should be close to 100
                    aggregator.preCollection();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment2_value1")));
                    assertTrue(secondBatch.getValue() > 0);
                    );
                            DEFAULT_MAX_BUCKETS,
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        buildInternalStreamingAggregation(
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                        () -> indexSearcher.search(new MatchAllDocsQuery(), aggregator)
                // Create documents with 50 unique values
                        fieldType
                    aggregator.postCollection();
                    Map<String, Object> debugInfo = new HashMap<>();
                        fieldType
                        ),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                document = new Document();
                    aggregator.collectDebugInfo((key, value) -> debugInfo.put(key, value));
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        )
                    );
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("non_existent_field");
                    aggregator.postCollection();
                    assertThat(result, notNullValue());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    aggregator.postCollection();
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                indexWriter.addDocument(document);
                        createIndexSettings(),
/*
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);
                    InternalCardinality secondResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
            List<InternalAggregation> aggs = new ArrayList<>();
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + (i % 3))));
                        ),
        assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                }
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                    indexWriter1.addDocument(doc);
                    aggregator.postCollection();
                // Create documents with many unique values
                }
            }
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
        try (Directory directory = newDirectory()) {
                        null,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                            searcher2
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
            }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    aggregator.postCollection();
                        aggregationBuilder,
                    // Build aggregation to ensure it works after postCollection
                    aggregator.preCollection();
                    IllegalStateException exception = expectThrows(
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                        ),
                }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                Document document = new Document();
                    assertThat(empty, notNullValue());
                    aggregator.postCollection();
                    aggregator.postCollection();
                    // Use a number field type which will create a non-ordinal value source
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            }
import java.util.ArrayList;
                for (int i = 5; i < 15; i++) {
                    // Post collection should properly clean up stream collector
        aggregator.postCollection();
                Document document = new Document();
                    );
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        null,
                        null,
                        indexSearcher,
        try (Directory directory = newDirectory()) {
            }
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        fieldType
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.postCollection();
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                for (int i = 0; i < 50; i++) {
                    assertThat(result, notNullValue());
            builder,
                            DEFAULT_MAX_BUCKETS,
                    MappedFieldType fieldType = new org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType(
                        null,
    }
                        fieldType
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        indexSearcher,
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        buildInternalStreamingAggregation(
                    assertTrue(secondResult.getValue() > 0);
                            DEFAULT_MAX_BUCKETS,
                        createIndexSettings(),
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
            // First aggregation
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        buildInternalStreamingAggregation(
                    Document document = new Document();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        null,
                    InternalCardinality cardinality = (InternalCardinality) topLevel;
                        indexSearcher,
                        ),
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
    public void testResetClearsState() throws Exception {
                    // First collection
                        aggregationBuilder,
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
import org.apache.lucene.store.Directory;
                document = new Document();
                        ),
    private InternalAggregation buildInternalStreamingAggregation(
            }
                Document document = new Document();
                document.add(new SortedSetDocValuesField("other_field", new BytesRef("test")));
            // Third aggregation - new values
                doc.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
        try (Directory directory = newDirectory()) {
import org.opensearch.index.mapper.MappedFieldType;
                    Document document = new Document();
    public void testWithMultiValuedDocuments() throws Exception {
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
            createIndexSettings(),
                    assertEquals(0, result.getValue(), 0);
        }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    indexWriter.addDocument(document);
                // Create documents with many unique values
                    aggregator.preCollection();
        try (Directory directory = newDirectory()) {
                    InternalCardinality reduced = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                indexWriter.addDocument(document);
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
import java.util.HashMap;
                        new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.search.aggregations.AggregatorTestCase;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        createIndexSettings(),
            );
                            DEFAULT_MAX_BUCKETS,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        fieldType
import org.opensearch.common.util.MockBigArrays;
        try (Directory directory = newDirectory()) {
    }
                        indexSearcher,
                            searcher3
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    highPrecisionAgg.postCollection();
                    aggs.add(
                    InternalCardinality firstResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    Document document = new Document();
                        null,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        try (Directory directory = newDirectory()) {
                doc.add(new SortedSetDocValuesField("field", new BytesRef("cherry")));
                    assertTrue(debugInfo.containsKey("ordinals_collectors_used"));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                // Add a document with a field but no ordinals (empty segment)
                    indexWriter.addDocument(document);
                    aggregator.preCollection();
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    Document document = new Document();
                    assertTrue(firstBatch.getValue() > 0);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
    public void testReduceSimple() throws Exception {
                    assertThat(result, notNullValue());
                    aggregator.preCollection();
                    StreamCardinalityAggregator highPrecisionAgg = createStreamAggregator(
                        aggregationBuilder,
                    assertTrue(exception.getMessage().contains("only supports ordinal value sources"));
                    aggregator.postCollection();
                    aggregator.preCollection();
    ) throws IOException {
                    aggregator.preCollection();
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                        indexSearcher,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        ),
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        return aggregator.buildTopLevel();
                // First batch data
        }
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                document = new Document();
                for (int i = 15; i < 20; i++) {
                    assertThat(topLevel, instanceOf(InternalCardinality.class));
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                        .precisionThreshold(1000);
                    );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        null,
                indexWriter.addDocument(document);
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    Document document = new Document();
                    aggregator.preCollection();
                for (int i = 0; i < 50; i++) {
                        aggregationBuilder,
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
 * compatible open source license.
                    aggregator.preCollection();
                        ),
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        null,
                            fieldType,
                doc.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    aggregator.postCollection();
                    assertThat(result, notNullValue());
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                    aggregator.preCollection();
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                indexWriter.addDocument(document);
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    }
                // Add multiple documents with different values
                    // Test with high precision
                        indexSearcher,
                    assertThat(result, notNullValue());
                Document document = new Document();
                        aggregationBuilder,
        try (Directory directory = newDirectory()) {
                        createIndexSettings(),
                    // First batch
                    );
                        "field",
                        fieldType
                        ),
        try (Directory directory = newDirectory()) {
                    aggregator.postCollection();
                        aggregationBuilder,
                        aggregationBuilder,
                        fieldType
                    assertThat(result, notNullValue());
    public void testEmptyOrdinalsCollector() throws Exception {
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertEquals(0, result.getValue(), 0);
                    // Reset
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            DEFAULT_MAX_BUCKETS,
                document.add(new SortedSetDocValuesField("field", new BytesRef("first_batch")));
            }
                for (int i = 0; i < 10; i++) {
                    lowPrecisionAgg.postCollection();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        createIndexSettings(),
                        createIndexSettings(),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        indexSearcher,
            // Reduce the aggregations
                    assertTrue(result.getValue() > 900);
                    );
                document = new Document();
                    Map<String, Object> debugInfo = new HashMap<>();
                        null,
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    aggregator.postCollection();
                    );
                    // Verify debug info contains expected keys
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    public void testResetAfterError() throws Exception {
                    );
            }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    public void testBuildTopLevel() throws Exception {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );
                        fieldType
                    // Now perform the reduce operation
                        getMockScriptService(),
    }
                        highPrecisionBuilder,
                    // Execute the aggregator
                }
            );
                indexWriter.addDocument(document);
                    aggregator.preCollection();
                }
                            DEFAULT_MAX_BUCKETS,
                    );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        createIndexSettings(),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    assertEquals(0, empty.getValue(), 0);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        new MultiBucketConsumerService.MultiBucketConsumer(
            new MultiBucketConsumerService.MultiBucketConsumer(
                try (IndexReader reader3 = maybeWrapReaderEs(DirectoryReader.open(indexWriter3))) {
                        searcher,
        try (Directory directory = newDirectory()) {
        }
            searcher,
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        fieldType
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                // Create many documents with the same value
    }
                        buildInternalStreamingAggregation(
                        indexSearcher,
                            DEFAULT_MAX_BUCKETS,
                    );
                        createIndexSettings(),
        try (Directory directory = newDirectory()) {
    }
                    InternalCardinality secondBatch = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        aggregationBuilder,
                    Document doc = new Document();
        searcher.search(new MatchAllDocsQuery(), aggregator);
            }
                }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    assertTrue(firstResult.getValue() > 0);
                    // Second collection - should start fresh
                Document doc = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            }
                        )
                indexWriter.addDocument(document);
            // Second aggregation - overlapping values
                for (int i = 0; i < 5; i++) {
                    Document document = new Document();
                    // Cardinality is approximate, so we check it's close to expected value
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        createIndexSettings(),
        );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        )
                    );
            }
                    indexSearcher.search(new MatchAllDocsQuery(), lowPrecisionAgg);
                indexWriter.addDocument(document);
        }
                        fieldType
        }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field")
                    aggregator.preCollection();
                        ),
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    // This will call getLeafCollector multiple times (once per segment)
                        null,
                    // Reset for second batch
                // Add documents to first segment
                    );
                }
                indexWriter.addDocument(document);
                    assertThat(result, notNullValue());
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                }
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
    public void testBasicCardinality() throws Exception {
                    assertTrue(result.getValue() > 50);
    }
            }
                        createIndexSettings(),
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    public void testNullValuesSource() throws Exception {
                }
                    assertTrue(cardinality.getValue() > 0);
                }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.apache.lucene.index.IndexWriterConfig;
                    assertEquals(1, result.getValue(), 0);
                    aggregator.collectDebugInfo((key, value) -> debugInfo.put(key, value));
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        fieldType
                    assertTrue(result.getValue() > 0);
                }
                        fieldType
        }
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                Document document = new Document();
                        createIndexSettings(),
                    aggregator.preCollection();
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    indexWriter3.addDocument(doc);
                Document document = new Document();
                    aggs.add(
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment1_value2")));
                    aggregator.postCollection();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        }
                    assertThat(result, notNullValue());
                    aggregator.postCollection();
                    InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
import java.io.IOException;
                        ),
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        aggregationBuilder,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        aggregationBuilder,
    public void testDifferentPrecisionThresholds() throws Exception {
            }
import org.apache.lucene.index.IndexWriter;
    }
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                        fieldType
                        indexSearcher,
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
        }
                    aggregator.postCollection();
                indexWriter2.addDocument(doc);
                    InternalCardinality firstBatch = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    InternalCardinality highPrecisionResult = (InternalCardinality) highPrecisionAgg.buildAggregations(new long[] { 0 })[0];
                    InternalCardinality lowPrecisionResult = (InternalCardinality) lowPrecisionAgg.buildAggregations(new long[] { 0 })[0];
                        fieldType
                PipelineTree.EMPTY
    }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        indexSearcher,
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
    public void testSingleUniqueValue() throws Exception {
    }
                indexWriter.addDocument(document);
                    assertTrue(highPrecisionResult.getValue() > 0);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                            DEFAULT_MAX_BUCKETS,
                            new CardinalityAggregationBuilder("cardinality").field("field"),
        }
                        null,
                        ),
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                    assertTrue(result.getValue() > 0);
                    );
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        indexSearcher,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            assertTrue(cardinality.getValue() > 15);
                    aggregator.preCollection();
                    aggs.add(
        }
        }
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        null,
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
        }
                for (int i = 0; i < 100; i++) {
                        ),
                    aggregator.postCollection();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        PipelineTree.EMPTY
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                    );
                Document document = new Document();
                    // Should have approximately 4 unique values
                indexWriter.addDocument(document);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
import org.apache.lucene.index.IndexReader;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            }
                    assertTrue(reduced.getValue() > 0);
                    );
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                }
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                    Document document = new Document();
                            DEFAULT_MAX_BUCKETS,
                    lowPrecisionAgg.preCollection();
                    indexWriter.addDocument(document);
    }
                    // Second batch
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertThat(result, notNullValue());
                    );
                    aggregator.doReset();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        aggregationBuilder,
                        fieldType
                        lowPrecisionBuilder,
                        ),
                        new MultiBucketConsumerService.MultiBucketConsumer(
        try (Directory directory = newDirectory()) {
                }
        aggregator.preCollection();
    }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                }
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    );
                    );
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        try (Directory directory = newDirectory()) {
                doc.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                }
                for (int i = 0; i < 100; i++) {
                Document document = new Document();
                }
                    indexWriter2.addDocument(doc);
            null,
        try (Directory directory = newDirectory()) {
                    indexWriter.addDocument(document);
                        createIndexSettings(),
                    Document doc = new Document();
                    // Test with low precision
        try (Directory directory = newDirectory()) {
    public void testWithDuplicates() throws Exception {
                    );
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            searcher2
import org.apache.lucene.util.BytesRef;
                        ),
        try (Directory directory = newDirectory()) {
            try (IndexWriter indexWriter3 = new IndexWriter(directory3, new IndexWriterConfig())) {
                    assertEquals(0, result.getValue(), 0);
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        reduceBucketConsumer,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    }
                    // Should have approximately 3 unique values (apple, banana, cherry)
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
    public void testWithMultipleValues() throws Exception {
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                        )
                document = new Document();
                    aggregator.doReset();
                    aggregator.preCollection();
                }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    aggregator.preCollection();
 * SPDX-License-Identifier: Apache-2.0
                    // Reset should work even if called multiple times
                    aggregator.postCollection();
                    long firstCardinality = firstResult.getValue();
                    );
                }
import java.util.List;
    public void testMultipleLeafCollectorInvocations() throws Exception {
    public void testDoCloseCalledDuringPostCollection() throws Exception {
                            DEFAULT_MAX_BUCKETS,
    public void testEmptyResults() throws Exception {
                    assertTrue(result.getValue() > 0);
            fieldType
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    document.add(new SortedSetDocValuesField("field", new BytesRef("same_value")));
                        aggregationBuilder,
        }
import org.opensearch.search.aggregations.InternalAggregation;
        try (Directory directory = newDirectory()) {
                    aggregator.postCollection();
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        .precisionThreshold(100);
                }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
            }
                    // Close is called automatically by test framework
                    // After reset, cardinality should be the same since we're processing the same data
    }
                        createIndexSettings(),
                    );
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
                    assertThat(reduced, notNullValue());
                    aggregator.preCollection();
                PipelineTree.EMPTY
                indexWriter.addDocument(document);
}
                }
                        ),
                        null,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        new MultiBucketConsumerService.MultiBucketConsumer(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            }
        }
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                indexWriter2.addDocument(doc);
                        ),
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                    aggregator.preCollection();
    public void testNonOrdinalValueSourceThrowsException() throws Exception {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    );
                // Add documents to second segment
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
            List<InternalAggregation> aggs = new ArrayList<>();
                    // Both should give reasonable results, high precision should be closer to actual
                indexWriter.commit();
                    aggregator.postCollection();
                        createIndexSettings(),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                }
            // After reducing, should have approximately 3 unique values (apple, banana, cherry)
        }
            }
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        ),
        }
                        indexSearcher,
    }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        null,
                        fieldType
                }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer =
                        ),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            }
                        aggregationBuilder,
                            new CardinalityAggregationBuilder("cardinality").field("field"),
                indexWriter.addDocument(document);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                b -> {},
                        "non_existent_field"
                    // Should have cardinality of 1
                            new CardinalityAggregationBuilder("cardinality").field("field"),
                    IndexSearcher searcher = newIndexSearcher(reader);
 * this file be licensed under the Apache-2.0 license or a
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
public class StreamCardinalityAggregatorTests extends AggregatorTestCase {
                    );
                        fieldType
                    aggregator.doReset();
                        createIndexSettings(),
                    aggregator.preCollection();
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                }
                for (int i = 0; i < 5; i++) {
    public void testWithPrecisionThreshold() throws Exception {
                    );
                doc = new Document();
    }
                        aggregationBuilder,
    }
                indexWriter1.addDocument(doc);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    assertTrue(result.getValue() > 0);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            Integer.MAX_VALUE,
                        null,
        }
                Document document = new Document();
 */
                        )
                    assertTrue(lowPrecisionResult.getValue() > 0);
                    );
                document = new Document();
