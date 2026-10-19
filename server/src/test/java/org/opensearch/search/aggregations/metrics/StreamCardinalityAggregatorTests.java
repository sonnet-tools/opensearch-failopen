                        ),
import org.opensearch.common.util.MockBigArrays;
                document.add(new SortedSetDocValuesField("field", new BytesRef("batch1_value1")));  
    public void testNonOrdinalValueSourceThrowsException() throws Exception {  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        ),  
                        aggregationBuilder,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                indexWriter1.addDocument(doc);
                    );
                }  
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory()) {
                indexWriter.addDocument(document);
                Document doc = new Document();  
            }  
                        createIndexSettings(),  
                // Force a segment
                        fieldType
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    aggregator.preCollection();  
        }
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        createIndexSettings(),  
            }
                    CardinalityAggregationBuilder lowPrecisionBuilder = new CardinalityAggregationBuilder("test").field("field")
                        )  
            new MultiBucketConsumerService.MultiBucketConsumer(
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
            null,
                        createIndexSettings(),  
        try (Directory directory = newDirectory()) {  
                        indexSearcher,
                    aggregator.preCollection();
                }  
    public void testReduceSingleAggregation() throws Exception {
                    aggregator.postCollection();
                }  
                    );  
            assertThat(reduced, instanceOf(InternalCardinality.class));
                    );
                }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
import org.apache.lucene.index.IndexWriter;
                for (int i = 0; i < 10; i++) {
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
 * this file be licensed under the Apache-2.0 license or a
    public void testEmptyResults() throws Exception {
                    aggregator.preCollection();
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    aggregator.preCollection();
                    Document document = new Document();  
                            fieldType,
    public void testDoCloseCalledDuringPostCollection() throws Exception {
                    // Use a number field type which will create a non-ordinal value source  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                }
        try (Directory directory = newDirectory()) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("cherry")));  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                            DEFAULT_MAX_BUCKETS,
                }
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + (i % 3))));
                        ),  
                    // Close is called automatically by test framework
                        null,  
                document = new Document();
    public void testWithMultipleValues() throws Exception {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(result, notNullValue());  
                    );  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
import org.apache.lucene.index.IndexReader;
                    assertEquals(0, result.getValue(), 0);
                for (int i = 0; i < 5; i++) {
                    indexWriter1.addDocument(doc);
                        buildInternalStreamingAggregation(
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                            DEFAULT_MAX_BUCKETS,  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                        fieldType
                }
                    aggregator.preCollection();
        }
                }  
                    long firstCardinality = firstResult.getValue();
                document = new Document();  
                    assertEquals(1, result.getValue(), 0);
                    assertThat(result, notNullValue());
                    );
                        indexSearcher,
                        aggregationBuilder,
    }
                            searcher1
                document = new Document();  
                Document document = new Document();
                    aggregator.postCollection();
            }
                    // Test with high precision
                            DEFAULT_MAX_BUCKETS,
    }
                    indexWriter.addDocument(document);
                    assertThat(result, notNullValue());
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                document = new Document();
                        fieldType
                        PipelineTree.EMPTY
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {  
                    aggregator.postCollection();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    // Post collection should properly clean up stream collector  
                        null,
    public void testReduceSimple() throws Exception {  
                    aggregator.preCollection();  
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                for (int i = 5; i < 15; i++) {
                indexWriter.addDocument(document);
                        new MultiBucketConsumerService.MultiBucketConsumer(  
            }
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(  
            InternalCardinality cardinality = (InternalCardinality) reduced;
                    );
                        fieldType  
import org.opensearch.index.mapper.MappedFieldType;  
                b -> {},  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    aggregator.preCollection();
                    InternalCardinality empty = (InternalCardinality) aggregator.buildEmptyAggregation();
                    assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
    public void testMultipleBatches() throws Exception {
                    IndexSearcher searcher1 = newIndexSearcher(reader1);  
                        createIndexSettings(),
                    assertEquals(0, result.getValue(), 0);
                // Create documents with many unique values
        }
                        new MultiBucketConsumerService.MultiBucketConsumer(
        searcher.search(new MatchAllDocsQuery(), aggregator);
        }  
                    assertTrue(debugInfo.containsKey("empty_collectors_used"));
                indexWriter.addDocument(document);  
                // Add a document with a field but no ordinals (empty segment)
                        buildInternalStreamingAggregation(  
    }
                try (IndexReader reader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    document.add(new SortedSetDocValuesField("field", new BytesRef("same_value")));  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        fieldType
                        createIndexSettings(),  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        ),
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        highPrecisionBuilder,
                    // Build aggregation to ensure it works after postCollection  
                indexWriter.addDocument(document);
                        fieldType
                indexWriter.addDocument(document);
import org.apache.lucene.tests.index.RandomIndexWriter;
                    aggregator.doReset();
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                        indexSearcher,
                        aggregationBuilder,
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment2_value1")));
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                            DEFAULT_MAX_BUCKETS,
    }
                        ),  
                        fieldType
                    assertTrue(reduced.getValue() > 0);  
                }
                    assertThat(reduced, notNullValue());
                }
                    // Execute the aggregator
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                        ),
            // Second aggregation - overlapping values
                    );
                        indexSearcher,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.postCollection();
                        fieldType
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        fieldType  
                    InternalCardinality firstResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    indexSearcher.search(new MatchAllDocsQuery(), highPrecisionAgg);  
                    // Get the result and reduce it
    public void testCollectDebugInfo() throws Exception {  
                }  
    private InternalAggregation buildInternalStreamingAggregation(
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    aggregator.preCollection();  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
        }  
                indexWriter.addDocument(document);
                    aggregator.postCollection();
                    );
                            DEFAULT_MAX_BUCKETS,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
        MappedFieldType fieldType,  
                    MappedFieldType fieldType = new org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType(
    }
                    aggregator.postCollection();
            }
                        null,
                    assertThat(empty, notNullValue());  
                for (int i = 0; i < 100; i++) {  
                        createIndexSettings(),
                        indexSearcher,
            }  
                for (int i = 0; i < 10; i++) {
    }
                        createIndexSettings(),  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                            DEFAULT_MAX_BUCKETS,
                        indexSearcher,  
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));  
            createIndexSettings(),
                doc.add(new SortedSetDocValuesField("field", new BytesRef("cherry")));
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
 * compatible open source license.
                indexWriter.addDocument(document);  
                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import org.apache.lucene.index.IndexWriterConfig;  
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
                        null,  
                    aggregator.preCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), lowPrecisionAgg);
                    assertTrue(result.getValue() > 0);
                        aggregationBuilder,  
                        null,
                    aggregator.postCollection();
                        aggregator.context().bigArrays(),
                        ),
                // Add multiple documents with different values
        try (Directory directory = newDirectory()) {
                    );
                }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(  
                    );
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                }  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                    aggregator.postCollection();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                document = new Document();  
                        null,  
                            fieldType,
                        fieldType
                    aggregator.postCollection();
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
    public void testEmptyOrdinalsCollector() throws Exception {
                        ),  
                    // Verify debug info contains expected keys  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    aggregator.postCollection();  
                }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                    aggregator.postCollection();  
                        fieldType
                    assertEquals(0, empty.getValue(), 0);
                        fieldType
    }  
        }  
                        fieldType  
                getMockScriptService(),
                    aggs.add(
                        fieldType
                    lowPrecisionAgg.preCollection();
                    InternalCardinality cardinality = (InternalCardinality) topLevel;  
                indexWriter.addDocument(document);  
                    );
    public void testMultipleLeafCollectorInvocations() throws Exception {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                            new CardinalityAggregationBuilder("cardinality").field("field"),  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    IllegalStateException exception = expectThrows(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    assertTrue(metricValue <= 10);  
                            DEFAULT_MAX_BUCKETS,
            List<InternalAggregation> aggs = new ArrayList<>();  
        try (Directory directory = newDirectory()) {  
            }
                    // After reset, cardinality should be the same since we're processing the same data
                    );  
    public void testSingleUniqueValue() throws Exception {  
                            searcher1  
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        createIndexSettings(),  
                        createIndexSettings(),  
            // Create first aggregation with some data
                    // Reset
                    assertThat(result, notNullValue());
                    indexWriter.addDocument(doc);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    );
                        createIndexSettings(),
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                        )
                indexWriter.addDocument(document);
                    assertTrue(result.getValue() > 50);
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment1_value1")));
                            DEFAULT_MAX_BUCKETS,
                    // Should have approximately 5 unique values
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
import org.apache.lucene.index.DirectoryReader;  
                        indexSearcher,
                        null,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                }
                        fieldType  
                indexWriter.addDocument(document);  
            }
                            new CardinalityAggregationBuilder("cardinality").field("field"),  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    indexWriter3.addDocument(doc);
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        null,  
                        indexSearcher,
                        ),
                        ),  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                        null,  
                    );
                        aggregationBuilder,
            }  
        }
                        ),  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    }  
                            new CardinalityAggregationBuilder("cardinality").field("field"),  
                        fieldType
                    // First collection  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    InternalCardinality firstBatch = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                        )  
    public void testWithMultiValuedDocuments() throws Exception {
                    assertTrue(firstResult.getValue() > 0);
                try (IndexReader reader3 = maybeWrapReaderEs(DirectoryReader.open(indexWriter3))) {
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                    aggregator.postCollection();
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                    aggregator.preCollection();
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                    // Should have exactly 3 unique values
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                            fieldType,
                        aggregationBuilder,  
                    // Field doesn't exist, so values source will be null
                    assertTrue(result.getValue() >= 2 && result.getValue() <= 4); // Allow some HLL approximation error  
                }
                for (int i = 0; i < 10; i++) {
                        null,
                        indexSearcher,
                        new MultiBucketConsumerService.MultiBucketConsumer(
        try (Directory directory = newDirectory()) {  
import org.opensearch.index.mapper.KeywordFieldMapper;
/*  
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    IndexSearcher searcher1 = newIndexSearcher(reader1);
            }  
        }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                        aggregationBuilder,
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));  
                        createIndexSettings(),
                    // Test with low precision  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
import org.opensearch.core.common.breaker.CircuitBreaker;  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
            }
        IndexSearcher searcher
                        indexSearcher,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                document.add(new SortedSetDocValuesField("field", new BytesRef("batch1_value2")));
                // Create documents with many unique values  
                    assertTrue(debugInfo.containsKey("ordinals_collectors_used"));
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field")
                            DEFAULT_MAX_BUCKETS,
                    assertTrue(secondBatch.getValue() > 0);
                doc.add(new SortedSetDocValuesField("field", new BytesRef("banana")));  
                        indexSearcher,
    }  
                        indexSearcher,
                            DEFAULT_MAX_BUCKETS,  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));  
import java.util.List;
import org.apache.lucene.util.BytesRef;
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    highPrecisionAgg.preCollection();
                    aggregator.preCollection();
                        new MultiBucketConsumerService.MultiBucketConsumer(  
            }
        }
        try (Directory directory = newDirectory()) {  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("cardinality").field("field");
import org.opensearch.search.aggregations.AggregatorTestCase;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
            InternalCardinality cardinality = (InternalCardinality) reduced;
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));  
                }
                // Create many documents with the same value  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    InternalCardinality firstResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
            );
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
        try (Directory directory = newDirectory()) {
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                Document document = new Document();
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    public void testWithPrecisionThreshold() throws Exception {  
                    highPrecisionAgg.postCollection();
                        createIndexSettings(),
            // Reduce the aggregations
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            }  
                    searcher.search(new MatchAllDocsQuery(), aggregator);
    }
                    aggregator.postCollection();  
                    assertThat(result, notNullValue());
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
                    indexWriter2.addDocument(doc);
        }
                }  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                }  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        null,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            }  
                    // With 100 unique values, cardinality should be close to 100
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        null,
                b -> {},  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                        .precisionThreshold(100);  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    StreamCardinalityAggregator lowPrecisionAgg = createStreamAggregator(
                        )  
                }
        try (Directory directory = newDirectory()) {
                indexWriter2.addDocument(doc);
    }  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
        }
                document.add(new SortedSetDocValuesField("field", new BytesRef("first_batch")));  
            }  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            assertThat(reduced, instanceOf(InternalCardinality.class));
    }
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];  
                document = new Document();
                document = new Document();  
 * SPDX-License-Identifier: Apache-2.0
                        aggregationBuilder,
                    aggregator.postCollection();
                        aggregationBuilder,
                    aggregator.postCollection();
                }
        }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertTrue(result.getValue() > 900);
 *
                }
                            new CardinalityAggregationBuilder("cardinality").field("field"),  
                    assertEquals(0, result.getValue(), 0);  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        ),  
                    aggregator.preCollection();
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {  
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
            searcher,  
                    // This will call getLeafCollector multiple times (once per segment)  
                    Map<String, Object> debugInfo = new HashMap<>();  
                doc = new Document();  
                        buildInternalStreamingAggregation(
        }
                indexWriter.addDocument(document);
                    indexWriter.addDocument(document);
        try (Directory directory = newDirectory()) {  
                    aggregator.postCollection();
            }
import org.apache.lucene.search.MatchAllDocsQuery;
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
        aggregator.preCollection();  
                doc = new Document();
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    aggregator.preCollection();
                        () -> indexSearcher.search(new MatchAllDocsQuery(), aggregator)  
                            DEFAULT_MAX_BUCKETS,
                    IndexSearcher searcher = newIndexSearcher(reader);
                        ),
                        fieldType
                            DEFAULT_MAX_BUCKETS,
                        ),  
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];  
                    assertThat(result, notNullValue());  
                        ),
                    );
            // After reducing, should have approximately 3 unique values (apple, banana, cherry)
                    lowPrecisionAgg.postCollection();  
                        null,
                    );  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                // First batch data
                    InternalCardinality topLevel = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        ),
                    );
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                Document doc = new Document();
            );
    public void testWithDuplicates() throws Exception {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    );
                        fieldType
                    assertTrue(highPrecisionResult.getValue() > 0);
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {  
                    );  
        aggregator.postCollection();  
                    assertEquals(firstCardinality, secondCardinality);  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
import org.apache.lucene.document.Document;
import org.opensearch.search.aggregations.InternalAggregation;
    public void testLargeCardinality() throws Exception {
                try (IndexReader reader1 = maybeWrapReaderEs(DirectoryReader.open(indexWriter1))) {
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));  
                    aggs.add(
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                            searcher2
                    );  
                    aggs.add(
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        );  
    }
                indexWriter.addDocument(document);  
                        fieldType
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    aggregator.postCollection();
    }  
            }
                    InternalCardinality secondResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                            DEFAULT_MAX_BUCKETS,
                    );  
                for (int i = 0; i < 50; i++) {
    }  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                }  
                        aggregationBuilder,  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    public void testMetricMethod() throws Exception {
                        aggregationBuilder,
                            DEFAULT_MAX_BUCKETS,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    Document doc = new Document();  
                    Map<String, Object> debugInfo = new HashMap<>();  
    }  
                    aggregator.collectDebugInfo((key, value) -> debugInfo.put(key, value));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        aggregationBuilder,  
            }
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));  
                    aggregator.preCollection();
                    assertThat(result, notNullValue());  
                        .precisionThreshold(10);
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
import org.apache.lucene.search.IndexSearcher;
import java.util.HashMap;  
                            new CardinalityAggregationBuilder("cardinality").field("field"),
                    Document doc = new Document();
                        fieldType
                    Document document = new Document();  
                        lowPrecisionBuilder,  
        );
            // First aggregation
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    Document document = new Document();
                    assertEquals("test", empty.getName());
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        searcher,
        }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment2_value2")));
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
            }  
                        aggregationBuilder,
                    );  
package org.opensearch.search.aggregations.metrics;
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertTrue(metricValue > 0);
                    aggregator.doReset();
        }  
                    IndexSearcher searcher3 = newIndexSearcher(reader3);
                    // Second collection - should start fresh
                // Add documents to second segment
                    assertTrue(result.getValue() > 0);
                indexWriter.addDocument(document);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        aggregationBuilder,
    public void testNullValuesSource() throws Exception {
                    aggregator.postCollection();  
                        null,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    indexWriter.addDocument(document);
            try (IndexWriter indexWriter1 = new IndexWriter(directory1, new IndexWriterConfig())) {
                    aggregator.preCollection();
                    aggregator.doReset();
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));  
                Document document = new Document();
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        ),
                for (int i = 0; i < 1000; i++) {
                            DEFAULT_MAX_BUCKETS,
                }
                    double metricValue = aggregator.metric(0);
import java.io.IOException;  
                for (int i = 0; i < 5; i++) {
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
                    InternalCardinality lowPrecisionResult = (InternalCardinality) lowPrecisionAgg.buildAggregations(new long[] { 0 })[0];
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    Document document = new Document();  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    aggregator.doReset();
                }  
    }  
                    );
        CardinalityAggregationBuilder builder,
                    );  
                getMockScriptService(),
                // Create many documents but only a few unique values
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            fieldType  
import org.opensearch.common.settings.Settings;  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                    assertTrue(secondResult.getValue() > 0);  
        try (Directory directory = newDirectory()) {
                    // Second batch
                        null,  
import java.util.Map;
                indexWriter.commit();
        try (Directory directory = newDirectory()) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    indexWriter.addDocument(document);
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
}  
                    // Cardinality is approximate, so we check it's close to expected value  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                    StreamCardinalityAggregator aggregator = createStreamAggregator(  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    indexWriter.addDocument(document);
        StreamCardinalityAggregator aggregator = createStreamAggregator(  
                            DEFAULT_MAX_BUCKETS,
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                            fieldType,
            }  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
            // Reduce the aggregations
                indexWriter.addDocument(document);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
    }  
                    );  
    public void testBasicCardinality() throws Exception {
        return aggregator.buildTopLevel();
    }
                    // Now perform the reduce operation
            }  
        }
                    assertThat(result, notNullValue());
                            searcher2
                document.add(new SortedSetDocValuesField("other_field", new BytesRef("test")));  
                indexWriter.addDocument(document);
    public void testDifferentPrecisionThresholds() throws Exception {
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
        }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                        createIndexSettings(),
                }  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    assertTrue(result.getValue() > 0);  
    public void testResetAfterError() throws Exception {
                            DEFAULT_MAX_BUCKETS,  
                        "non_existent_field"  
                        null,
import static org.hamcrest.Matchers.notNullValue;  
                        createIndexSettings(),  
                    // First batch
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                indexWriter1.addDocument(doc);  
                    InternalCardinality secondResult = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
    public void testReduceWithMultipleAggregations() throws Exception {
                        aggregationBuilder,
                indexWriter.addDocument(document);
                        indexSearcher,
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                for (int i = 15; i < 20; i++) {
            // Create second aggregation with overlapping data  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertThat(topLevel, instanceOf(InternalCardinality.class));
                    Document document = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        aggregationBuilder,
                        aggregationBuilder,
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
        try (Directory directory = newDirectory()) {
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                        indexSearcher,  
                        createIndexSettings(),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
            }  
                    // With 1000 unique values, cardinality should be close to 1000 (allowing for HLL approximation)
                }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    Document doc = new Document();
                    // Verify empty collector was used
                    );
                    aggregator.preCollection();
                        createIndexSettings(),
                        indexSearcher,
        try (Directory directory = newDirectory()) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        null,  
        }  
                    IndexSearcher searcher2 = newIndexSearcher(reader2);
                    aggs.add(
        }
    public void testResetClearsState() throws Exception {
                            Integer.MAX_VALUE,
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    );  
            try (IndexWriter indexWriter3 = new IndexWriter(directory3, new IndexWriterConfig())) {  
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];  
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    aggregator.preCollection();
 * The OpenSearch Contributors require contributions made to  
                        createIndexSettings(),
                    indexWriter.addDocument(document);
                document.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                    aggregator.preCollection();  
                        aggregationBuilder,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                    aggregator.preCollection();
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        buildInternalStreamingAggregation(
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];
            }
        try (Directory directory = newDirectory()) {
    public void testBuildTopLevel() throws Exception {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                    Document document = new Document();  
        assertEquals("strictly single segment", 1, searcher.getIndexReader().leaves().size());
                    InternalCardinality secondBatch = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];  
                }  
            // Third aggregation - new values
                        "field",
        try (Directory directory = newDirectory()) {
                    // Reset should work even if called multiple times  
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    // Collect debug info
            ),
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                PipelineTree.EMPTY
                }  
                    aggregator.preCollection();
                        indexSearcher,  
                        null,
                        fieldType
                    );
    }
                        null,  
                        null,  
        }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                Document document = new Document();
                Document document = new Document();
                        buildInternalStreamingAggregation(
            }
                    aggregator.postCollection();  
                    InternalCardinality reduced = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);
                        ),
                        ),
import org.apache.lucene.document.SortedSetDocValuesField;
                        indexSearcher,
                            fieldType,
                        new MultiBucketConsumerService.MultiBucketConsumer(
                    aggregator.preCollection();
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                indexWriter.addDocument(document);
                }
        try (Directory directory = newDirectory()) {
                PipelineTree.EMPTY
                            DEFAULT_MAX_BUCKETS,
    }
            }  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                        new MultiBucketConsumerService.MultiBucketConsumer(
                }
                        indexSearcher,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {  
                // Add documents to first segment
                    assertTrue(lowPrecisionResult.getValue() > 0);  
                        createIndexSettings(),
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                            DEFAULT_MAX_BUCKETS,
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    aggregator.postCollection();
                    assertTrue(firstBatch.getValue() > 0);
                        .precisionThreshold(1000);  
                    assertTrue(result.getValue() > 0);
                    Document document = new Document();
                document = new Document();
                Document document = new Document();
                    // Test metric() method  
                document.add(new SortedSetDocValuesField("field", new BytesRef("segment1_value2")));
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                }  
                    );
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                        indexSearcher,
                            DEFAULT_MAX_BUCKETS,
                        aggregationBuilder,  
                    // Should have approximately 4 unique values
                    InternalAggregation topLevel = aggregator.buildTopLevel();  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        aggregationBuilder,  
        try (Directory directory = newDirectory()) {
                }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                    // Reset for second batch
                }  
                        aggregationBuilder,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                Document document = new Document();  
                }  
                for (int i = 0; i < 100; i++) {
                        ),
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("non_existent_field");  
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(  
                            DEFAULT_MAX_BUCKETS,
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                Document document = new Document();  
                        fieldType
        try (Directory directory = newDirectory()) {  
                        null,  
                    long secondCardinality = secondResult.getValue();  
                        ),
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());  
            }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
    }  
        try (Directory directory = newDirectory()) {  
public class StreamCardinalityAggregatorTests extends AggregatorTestCase {
                        createIndexSettings(),  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    aggregator.preCollection();
                Document document = new Document();
    }
        }
 */  
                            DEFAULT_MAX_BUCKETS,
                indexWriter.addDocument(document);  
                        getMockScriptService(),  
        }
                    assertTrue(result.getValue() > 0);
                    assertThat(result, notNullValue());
        try (Directory directory1 = newDirectory(); Directory directory2 = newDirectory(); Directory directory3 = newDirectory()) {
                    InternalCardinality result = (InternalCardinality) aggregator.buildAggregations(new long[] { 0 })[0];  
                    assertEquals("strictly single segment", 1, indexSearcher.getIndexReader().leaves().size());
                }
                        createIndexSettings(),  
                        indexSearcher,
                    aggregator.preCollection();
                    InternalCardinality highPrecisionResult = (InternalCardinality) highPrecisionAgg.buildAggregations(new long[] { 0 })[0];  
                    aggregator.doReset();
                    // This should throw IllegalStateException when getLeafCollector is called with non-ordinal value source  
                    // Should be able to collect again after multiple resets
                Document document = new Document();  
                        createIndexSettings(),  
                document.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                    document.add(new SortedSetDocValuesField("field", new BytesRef("value_" + i)));
                        new MultiBucketConsumerService.MultiBucketConsumer(
                        ),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
    public void testReset() throws Exception {
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertThat(result, notNullValue());
                        reduceBucketConsumer,
                    aggregator.postCollection();
                // Create documents with 50 unique values
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                }
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        createIndexSettings(),  
                indexWriter.addDocument(document);
                    aggregator.postCollection();
            assertTrue(cardinality.getValue() > 15);  
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    );  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        createIndexSettings(),
                    aggregator.collectDebugInfo((key, value) -> debugInfo.put(key, value));
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    aggs.add(
                        IllegalStateException.class,
            // After reducing, should have approximately 20 unique values (0-19)
                doc.add(new SortedSetDocValuesField("field", new BytesRef("apple")));
                    InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                    aggregator.postCollection();
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                    CardinalityAggregationBuilder highPrecisionBuilder = new CardinalityAggregationBuilder("test").field("field")
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                Document document = new Document();
                    assertTrue(cardinality.getValue() > 0);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    // Both should give reasonable results, high precision should be closer to actual
        try (Directory directory = newDirectory()) {  
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
            InternalAggregation reduced = aggs.get(0).reduce(aggs, ctx);
                    StreamCardinalityAggregator aggregator = createStreamAggregator(  
                        null,  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");
                        indexSearcher,  
                    CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("test").field("field");  
                Document document = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                        aggregationBuilder,  
                        null,  
            List<InternalAggregation> aggs = new ArrayList<>();  
        }
    }
                        null,
                    assertTrue((Integer) debugInfo.get("empty_collectors_used") > 0);
            }
                    // Should have approximately 3 unique values (apple, banana, cherry)  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                    document.add(new SortedSetDocValuesField("field", new BytesRef("term_" + (i % 5))));
                    MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer =
                    assertTrue(exception.getMessage().contains("only supports ordinal value sources"));
                    // Should have cardinality of 1  
            assertTrue(cardinality.getValue() > 0);  
                    );
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
                    StreamCardinalityAggregator aggregator = createStreamAggregator(
                        indexSearcher,
                        fieldType
                        indexSearcher,
                    StreamCardinalityAggregator highPrecisionAgg = createStreamAggregator(
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        }
                            DEFAULT_MAX_BUCKETS,  
import static org.hamcrest.Matchers.instanceOf;
                        fieldType
                    assertThat(result, notNullValue());  
                            DEFAULT_MAX_BUCKETS,
                for (int i = 0; i < 50; i++) {
        try (Directory directory = newDirectory()) {  
        try (Directory directory = newDirectory()) {
                doc.add(new SortedSetDocValuesField("field", new BytesRef("banana")));
                        ),
                    assertTrue(result.getValue() > 0);
                    assertThat(result, notNullValue());  
            try (IndexWriter indexWriter2 = new IndexWriter(directory2, new IndexWriterConfig())) {
                    // Should have approximately 5 unique values (term_0 through term_4)
                        createIndexSettings(),
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    aggregator.postCollection();
                        ),
                        org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG  
        try (Directory directory = newDirectory()) {  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    ) throws IOException {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig())) {
                        )  
                    );
                }  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                DEFAULT_MAX_BUCKETS,  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    Document document = new Document();  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
        }
                    aggregator.preCollection();
                    indexWriter.addDocument(document);
import java.util.ArrayList;
    }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
import java.util.Collections;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                            searcher3
    public void testBuildEmptyAggregation() throws Exception {
                        new MultiBucketConsumerService.MultiBucketConsumer(  
                indexWriter.commit();  
                    indexWriter.addDocument(document);  
import org.apache.lucene.store.Directory;  
                try (IndexReader reader2 = maybeWrapReaderEs(DirectoryReader.open(indexWriter2))) {
    }
import org.opensearch.common.util.MockPageCacheRecycler;
                    );  
                try (IndexReader indexReader = maybeWrapReaderEs(DirectoryReader.open(indexWriter))) {
                    Document doc = new Document();
                indexWriter2.addDocument(doc);
                    aggregator.preCollection();
            builder,
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
                document.add(new SortedSetDocValuesField("field", new BytesRef("test")));
