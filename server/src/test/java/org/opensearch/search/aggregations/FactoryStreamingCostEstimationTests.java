import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                    StreamingCostMetrics cardinalityMetrics = ((StreamingCostEstimable) cardinalityResult.factory).estimateStreamingCost(
    /**
                        "TermsAggregatorFactory should implement StreamingCostEstimable",
                    assertTrue(
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
     */
    /**
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    IndexSearcher searcher = newIndexSearcher(reader);
                for (int i = 0; i < 5000; i++) {
import org.opensearch.search.internal.SearchContext;
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
        }
     * when majority of segments have no deleted docs (traditional aggregator can use term frequency optimization).
                    IndexSearcher searcher = newIndexSearcher(reader);
    /**
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category")
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, categoryFieldType, valueFieldType);
     * Creates an AggregatorFactory with a mocked minEstimatedBucketCount.
                    // Verify individual metrics
            }
                }
                        "CardinalityAggregatorFactory should implement StreamingCostEstimable",
import org.apache.lucene.util.BytesRef;
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertFalse("Should be non-streamable for numeric cardinality", metrics.streamable());
        // Use a BooleanQuery wrapper to avoid being detected as match-all
/**
    /**
    public void testTermsFactoryFallbackLowCardinality() throws IOException {
     */
                    IndexSearcher searcher = newIndexSearcher(reader);
                for (int i = 0; i < 50000; i++) {
        final AggregatorFactory factory;
                // Add 50 documents with numeric values
                    assertFalse("Numeric terms with key order should NOT be streamable", metrics.streamable());
                    doc.add(new SortedNumericDocValuesField("value", i));
        return new FactoryAndContext(factory, searchContext);
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category");
 * SPDX-License-Identifier: Apache-2.0
                    // Create context with high minBucketCount so cardinality (5) < minBucketCount (1000)
    /**
     * Test that string terms aggregation falls back to non-streamable when cardinality is low.
            }
     */
                    // Non-match-all query (using a term query) - should be streamable even with clean segments
                }
                // Add 100 documents with 10 unique terms
     * Test sibling aggregation cost combination: terms + cardinality.
     */
        }
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
        try (Directory directory = newDirectory()) {
    private FactoryAndContext createAggregatorFactoryWithQuery(
                }
    /**
                for (int i = 0; i < 10; i++) {
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
                    Document doc = new Document();
    /**
        return new FactoryAndContext(factory, searchContext);
                        .order(BucketOrder.key(true));
        SearchContext searchContext = createSearchContext(searcher, createIndexSettings(), query, createBucketConsumer(), fieldTypes);
     */
                    // TopN is multiplied: parent topN * sub-agg topN (which is 1 for neutral/metric aggs)
import org.apache.lucene.index.IndexReader;
    private MultiBucketConsumerService.MultiBucketConsumer createBucketConsumer() {
/*
                }
                        result.factory instanceof StreamingCostEstimable
                    // Create context with MatchAllDocsQuery - should fall back due to term frequency optimization
                    assertTrue("Should have non-streamable sub-factory (TopHitsAggregatorFactory)", hasNonStreamable);
                try (IndexReader reader = DirectoryReader.open(writer)) {
                        "Cardinality factory should be StreamingCostEstimable",
    }
                    // String terms with key ascending order - should be streamable
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                for (int i = 0; i < 50; i++) {
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category")
 *
    }
                    for (AggregatorFactory subFactory : subFactoryArray) {
    /**
     */
                }
                    writer.addDocument(doc);
                    doc.add(new SortedNumericDocValuesField("number", i));
                    MappedFieldType brandFieldType = new KeywordFieldMapper.KeywordFieldType("brand");
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
    /**
    }
                for (int i = 0; i < 100; i++) {
    }
                    assertTrue("Nested streamable aggs should be streamable", metrics.streamable());
     */
                    writer.addDocument(doc);
    public void testNestedAggregationCostCombination() throws IOException {
    private FactoryAndContext createAggregatorFactory(
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
                }
        }
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                for (int i = 0; i < 50; i++) {
                    writer.addDocument(doc);
                    // Sibling combination adds topN sizes
                }
                }
                        brandFieldType
                    // Numeric terms with key descending order - should NOT be streamable
                }
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                    writer.deleteDocuments(new org.apache.lucene.index.Term("id", "cat_" + (batch * 1000)));
        FactoryAndContext(AggregatorFactory factory, SearchContext searchContext) {
        }
                        .size(5)
                }
        }
                    FactoryAndContext result = createAggregatorFactory(cardinalityBuilder, searcher, fieldType);
            }
        try (Directory directory = newDirectory()) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    IndexSearcher searcher = newIndexSearcher(reader);
                    assertTrue(
                    IndexSearcher searcher = newIndexSearcher(reader);
 * The OpenSearch Contributors require contributions made to
                    writer.addDocument(doc);
            }
    public void testTermsFactoryStreamableNonMatchAllQuery() throws IOException {
                writer.addDocument(doc);
    /**
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("count", NumberFieldMapper.NumberType.INTEGER);
                    IndexSearcher searcher = newIndexSearcher(reader);
     * Returns the factory and the SearchContext used to create it.
                    writer.commit(); // Create a segment per batch
    public void testTermsFactoryEstimateNumericTermsWithKeyDescOrder() throws IOException {
     * Numeric terms with key ordering are NOT streamable because numeric streaming aggregators
            }
            // Use IndexWriterConfig that doesn't merge away deletions
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("count", NumberFieldMapper.NumberType.INTEGER);
                for (int i = 0; i < 100; i++) {
                    }
                    writer.addDocument(doc);
                        .size(5)
                        .subAggregation(maxBuilder);
            }
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    assertTrue(
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    // With deletions in all segments, cleanRatio will be 0, so streaming is preferred
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
                try (IndexReader reader = DirectoryReader.open(writer)) {
        try (Directory directory = newDirectory()) {
    }
                try (IndexReader reader = DirectoryReader.open(writer)) {
    /**
                    assertTrue(
                }
                        .order(BucketOrder.key(true));
                    Document doc = new Document();
                        "TermsAggregatorFactory should implement StreamingCostEstimable",
     * Test CardinalityAggregatorFactory.estimateStreamingCost with non-ordinals (numeric) returns non-streamable.
    }
        IndexSearcher searcher,
                }
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
     */
                    IndexSearcher searcher = newIndexSearcher(reader);
                }
    }
                // Create empty index with just schema
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    assertTrue("Combined topN should be positive", combined.topNSize() > 0);
                for (int i = 0; i < 80; i++) {
                }
                }
                    for (int i = 0; i < 1000; i++) {
 * Tests for factory-level streaming cost estimation.
                for (int i = 0; i < 50; i++) {
                    FactoryAndContext result = createAggregatorFactory(cardinalityBuilder, searcher, fieldType);
            this.searchContext = searchContext;
    }
                for (int i = 0; i < 50; i++) {
    public void testTermsFactoryEstimateStringTermsWithKeyOrder() throws IOException {
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                }
                for (int batch = 0; batch < 5; batch++) {
     */
     */
        AggregatorFactory factory = aggregationBuilder.rewrite(queryShardContext).build(queryShardContext, null);
        AggregationBuilder aggregationBuilder,
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("count")
                    // Numeric terms with count descending order (default) - should be streamable
    public void testTermsFactoryEstimateStringTerms() throws IOException {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    ) throws IOException {
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));
    }
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 5))));
                    );
import java.io.IOException;
                    writer.addDocument(doc);
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                        Document doc = new Document();
        QueryShardContext queryShardContext = searchContext.getQueryShardContext();
 * compatible open source license.
            config.setMergePolicy(org.apache.lucene.index.NoMergePolicy.INSTANCE);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
        SearchContext searchContext = createSearchContext(
                }
                    // Verify sub-factory is not StreamingCostEstimable (TopHitsAggregatorFactory)
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, new MatchAllDocsQuery(), fieldType);
                    MaxAggregationBuilder maxBuilder = new MaxAggregationBuilder("max").field("value");
        }
                    IndexSearcher searcher = newIndexSearcher(reader);
     * Test nested aggregation with non-streamable sub-aggregation: terms -> top_hits.
        Query nonMatchAllQuery = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST).build();
                    );
import org.apache.lucene.index.Term;
                        writer.addDocument(doc);
package org.opensearch.search.aggregations;
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    boolean hasNonStreamable = false;
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
    }
import org.apache.lucene.search.MatchAllDocsQuery;
                }
                // Create index with high cardinality in multiple batches to create multiple segments
    }
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
                }
     * Helper class to return both the factory and its SearchContext.
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    writer.addDocument(doc);
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("count").size(5);
    /**
                        .size(5)
        }
                }
 * this file be licensed under the Apache-2.0 license or a
                writer.commit();
    }
        }
    }
    }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    // ========================================
        }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));
        try (Directory directory = newDirectory()) {
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms and count ordering.
        AggregationBuilder aggregationBuilder,
                // Create index with cardinality above the default threshold (30,000)
        try (Directory directory = newDirectory()) {
                    // terms(category) -> top_hits (non-streamable)
    /**
            }
                }
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                    // We need to test the factory tree traversal, not just the terms factory
                    // Cardinality topN is based on HLL precision (1 << precision), not a fixed value
                    CardinalityAggregationBuilder cardinalityBuilder = new CardinalityAggregationBuilder("cardinality").field("number");
            createBucketConsumer(),
                    assertTrue("Metric aggs should be streamable", metrics.streamable());
                        searcher,
                        termsResult.searchContext
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                    IndexSearcher searcher = newIndexSearcher(reader);
                    Document doc = new Document();
 * {@link AggregatorFactories} tree traversal works correctly.
                }
    // Streaming Fallback Tests
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    assertFalse("Match-all with clean segments should NOT be streamable", metrics.streamable());
import org.opensearch.index.mapper.KeywordFieldMapper;
                    assertTrue("Cardinality should be streamable", cardinalityMetrics.streamable());
                    writer.addDocument(doc);
                    );
                }
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
    }
     * Test that metric factories (Max, Min, Avg, Sum, ValueCount) return neutral metrics.
import org.apache.lucene.store.Directory;
     */
                }
     */
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(5);
                        }
    public void testTermsFactoryStreamableMatchAllWithDeletedDocs() throws IOException {
 */
                    doc.add(new SortedNumericDocValuesField("value", i));
                    Document doc = new Document();
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(5);
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
        return new FactoryAndContext(factory, searchContext);
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
    /**
                    assertFalse("Low cardinality should NOT be streamable", metrics.streamable());
                }
                    // The AggregatorFactories.estimateStreamingCostFromFactories should detect the non-streamable sub-agg
     * Test TermsAggregatorFactory.estimateStreamingCost with string terms (ordinals).
        }
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + (i % 20))));
        AggregatorFactory factory = aggregationBuilder.rewrite(queryShardContext).build(queryShardContext, null);
        );
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
    // AggregatorFactories Tree Traversal Tests
     * (term frequency optimization won't work when segments have deletions).
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
     * Test that string terms with match-all but deleted docs IS streamable
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
     */
                }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("count", NumberFieldMapper.NumberType.INTEGER);
                }
import org.apache.lucene.index.DirectoryReader;
        AggregatorFactory factory = aggregationBuilder.rewrite(queryShardContext).build(queryShardContext, null);
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                    IndexSearcher searcher = newIndexSearcher(reader);
                        result.factory instanceof StreamingCostEstimable
     * When cardinality exceeds the threshold, Check 2 is skipped because tryCollectFromTermFrequencies
    }
                    writer.addDocument(doc);
                // Create index with high cardinality
     * Creates an AggregatorFactory from an AggregationBuilder using the test infrastructure.
                        doc.add(new org.apache.lucene.document.StringField("id", catValue, org.apache.lucene.document.Field.Store.NO));
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
import org.apache.lucene.index.IndexWriter;
     * would bail out on high cardinality anyway.
    // ========================================
 * {@link StreamingCostEstimable#estimateStreamingCost} and that the
    /**
                writer.deleteAll();
                        // Add indexed field for deletion
    }
                    assertTrue("Combined should be streamable", combined.streamable());
    /**
                    Document doc = new Document();
        try (Directory directory = newDirectory()) {
                    FactoryAndContext result = createAggregatorFactory(maxBuilder, searcher, fieldType);
                }
    public void testTermsFactoryFallbackMatchAllWithCleanSegments() throws IOException {
                    );
        );
    // ========================================
                    doc.add(new SortedSetDocValuesField("brand", new BytesRef("brand_" + (i % 5))));
import org.opensearch.index.mapper.NumberFieldMapper;
                    Document doc = new Document();
                    writer.addDocument(doc);
            }
                }
}
     */
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                }
    // ========================================
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    writer.addDocument(doc);
                    AggregatorFactories subFactories = result.factory.getSubFactories();
     * Should also be non-streamable.
            createIndexSettings(),
            }
     * Uses a non-match-all query to avoid triggering the match-all optimization fallback.
    /**
                    FactoryAndContext termsResult = createAggregatorFactory(termsBuilder, searcher, categoryFieldType, brandFieldType);
                    // Match-all but with deleted docs - should be streamable
        MappedFieldType... fieldTypes
                    IndexSearcher searcher = newIndexSearcher(reader);
        return new MultiBucketConsumerService.MultiBucketConsumer(
                        cardinalityBuilder,
    private static class FactoryAndContext {
                }
        }
                for (int i = 0; i < 5000; i++) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
                    Document doc = new Document();
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    // Test that both factories are StreamingCostEstimable
            searcher,
                doc.add(new SortedSetDocValuesField("category", new BytesRef("temp")));
    // CardinalityAggregatorFactory Tests
        try (Directory directory = newDirectory()) {
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
    public void testTermsFactoryEstimateNumericTermsWithKeyOrder() throws IOException {
    // TermsAggregatorFactory Tests
    // ========================================
    ) throws IOException {
                        "TermsAggregatorFactory should implement StreamingCostEstimable",
            }
                try (IndexReader reader = DirectoryReader.open(writer)) {
import static org.mockito.Mockito.when;
        }
     * Low cardinality means maxCardinality is less than minEstimatedBucketCount setting.
                // Create index with high cardinality (more than default minBucketCount)
    public void testNestedAggregationWithNonStreamableSubAgg() throws IOException {
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, new MatchAllDocsQuery(), fieldType);
            }
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, new MatchAllDocsQuery(), fieldType);
     */
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                            break;
        try (Directory directory = newDirectory()) {
        AggregationBuilder aggregationBuilder,
                    Document doc = new Document();
            }
        IndexSearcher searcher,
                    writer.addDocument(doc);
            }
                    doc.add(new SortedNumericDocValuesField("count", i % 10));
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    IndexSearcher searcher = newIndexSearcher(reader);
                    CardinalityAggregationBuilder cardinalityBuilder = new CardinalityAggregationBuilder("cardinality").field("field");
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
                        cardinalityResult.searchContext
    /**
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    assertTrue("Terms should be streamable", termsMetrics.streamable());
                try (IndexReader reader = DirectoryReader.open(writer)) {
     */
    /**
                    doc.add(new SortedNumericDocValuesField("count", i % 10));
                        .size(5)
                    assertEquals("Should have neutral topN size", 1, metrics.topNSize());
    }
                    doc.add(new SortedNumericDocValuesField("value", i));
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms and key-based ordering.
    }
        }
 * <p>These tests verify that aggregator factories correctly implement
    // ========================================
        try (Directory directory = newDirectory()) {
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    writer.addDocument(doc);
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms.
                    FactoryAndContext cardinalityResult = createAggregatorFactory(
                for (int i = 0; i < 50; i++) {
            fieldTypes
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    IndexSearcher searcher = newIndexSearcher(reader);
            }
                    assertTrue(
        QueryShardContext queryShardContext = searchContext.getQueryShardContext();
                    IndexSearcher searcher = newIndexSearcher(reader);
            }
    // ========================================
                for (int i = 0; i < 100; i++) {
                // Delete documents from all segments to make them "dirty"
     * Test that non-match-all query with high cardinality IS streamable.
                    assertTrue("Should be streamable", metrics.streamable());
            }
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        SearchContext searchContext = createSearchContext(searcher, createIndexSettings(), null, createBucketConsumer(), fieldTypes);
                    // Metric factories return neutral metrics - they don't add buckets
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("value")
                    );
                    assertTrue("Match-all with high cardinality should be streamable", metrics.streamable());
                for (int i = 0; i < 100; i++) {
        }
     */
    }
                    // Numeric terms with key ascending order - should NOT be streamable
                    Document doc = new Document();
                    Document doc = new Document();
                try (IndexReader reader = DirectoryReader.open(writer)) {
    // ========================================
                    doc.add(new SortedNumericDocValuesField("count", i % 10));
                    writer.addDocument(doc);
                    Document doc = new Document();
                }
        try (Directory directory = newDirectory()) {
                    StreamingCostMetrics combined = termsMetrics.combineWithSibling(cardinalityMetrics);
            nonMatchAllQuery,
                    IndexSearcher searcher = newIndexSearcher(reader);
        MappedFieldType... fieldTypes
        long minBucketCount,
                        .order(BucketOrder.key(false));
                    Document doc = new Document();
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    assertTrue("Terms factory should be StreamingCostEstimable", termsResult.factory instanceof StreamingCostEstimable);
                    // terms(category) -> max(value)
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                // Create index with low cardinality (only 5 unique terms)
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    TopHitsAggregationBuilder topHitsBuilder = new TopHitsAggregationBuilder("top_docs").size(3);
     */
                        result.factory instanceof StreamingCostEstimable
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category")
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, termQuery, fieldType);
import org.apache.lucene.search.Query;
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(catValue)));
import org.opensearch.search.streaming.StreamingCostEstimable;
        try (Directory directory = newDirectory()) {
                        result.factory instanceof StreamingCostEstimable
        try (Directory directory = newDirectory()) {
     * don't support key-based ordering.
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
        }
                    FactoryAndContext result = createAggregatorFactoryWithMinBucketCount(termsBuilder, searcher, 1000L, fieldType);
                // Add 80 documents with 20 unique values
     */
                    IndexSearcher searcher = newIndexSearcher(reader);
    public void testCardinalityFactoryEstimateNonOrdinals() throws IOException {
import org.opensearch.index.query.QueryShardContext;
                }
    public void testTermsFactoryEstimateNumericTermsWithCountOrder() throws IOException {
     * Test CardinalityAggregatorFactory.estimateStreamingCost with ordinals.
        }
 */
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));
     * Test TermsAggregatorFactory.estimateStreamingCost with string terms and key-based ordering.
                try (IndexReader reader = DirectoryReader.open(writer)) {
    // ========================================
        when(searchContext.getStreamingMinEstimatedBucketCount()).thenReturn(minBucketCount);
                        .order(BucketOrder.count(false));
                    writer.addDocument(doc);
    // ========================================
import org.apache.lucene.search.IndexSearcher;
                    assertTrue(
            DEFAULT_MAX_BUCKETS,
        try (Directory directory = newDirectory()) {
        final SearchContext searchContext;
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                        result.factory instanceof StreamingCostEstimable
                        .subAggregation(topHitsBuilder);
                for (int i = 0; i < 100; i++) {
        IndexSearcher searcher,
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 5))));
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("count")
                        "MaxAggregatorFactory should implement StreamingCostEstimable",
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                        categoryFieldType,
    public void testMetricFactoriesReturnNeutralMetrics() throws IOException {
                        String catValue = "cat_" + (batch * 1000 + i);
     * Test that string terms aggregation falls back to non-streamable for match-all query
                        cardinalityResult.factory instanceof StreamingCostEstimable
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
                    );
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    assertTrue("Should be streamable", metrics.streamable());
    /**
        Query query,
                try (IndexReader reader = DirectoryReader.open(writer)) {
        try (Directory directory = newDirectory()) {
    ) throws IOException {
    }
    // Helper methods
 *
                    StreamingCostMetrics termsMetrics = ((StreamingCostEstimable) termsResult.factory).estimateStreamingCost(
     * Test TermsAggregatorFactory.estimateStreamingCost with empty index.
                    // Verify sibling combination logic
import org.opensearch.core.common.breaker.CircuitBreaker;
        // This simulates a filtered query scenario
                for (int i = 0; i < 50; i++) {
                        if (!(subFactory instanceof StreamingCostEstimable)) {
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
import org.opensearch.index.mapper.MappedFieldType;
                for (int batch = 0; batch < 5; batch++) {
     * Creates an AggregatorFactory with a specific query.
     */
                    MaxAggregationBuilder maxBuilder = new MaxAggregationBuilder("max").field("value");
                    );
     * Test that match-all query with clean segments but cardinality above the precompute threshold IS streamable.
                    }
import org.opensearch.search.streaming.StreamingCostMetrics;
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(5);
                }
     * String/ordinals terms with key ordering ARE streamable (only numeric is rejected).
                    Document doc = new Document();
import org.apache.lucene.search.BooleanClause;
    }
                try (IndexReader reader = DirectoryReader.open(writer)) {
    public void testTermsFactoryStreamableMatchAllHighCardinality() throws IOException {
                    assertTrue("Match-all with deleted docs should be streamable", metrics.streamable());
                    Query termQuery = new TermQuery(new Term("category", "cat_100"));
            }
                    assertTrue("Non-match-all query should be streamable", metrics.streamable());
                try (IndexReader reader = DirectoryReader.open(writer)) {
        }
     */
     * Test nested aggregation cost combination: terms -> max.
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
        try (Directory directory = newDirectory()) {
        }
                }
    // ========================================
                    CardinalityAggregationBuilder cardinalityBuilder = new CardinalityAggregationBuilder("cardinality").field("brand");
    // ========================================
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms and key descending order.
        MappedFieldType... fieldTypes
                    );
import org.apache.lucene.document.Document;
                    assertTrue("Numeric terms with count order should be streamable", metrics.streamable());
    }
                    Document doc = new Document();
                        .size(5)
                    assertTrue("String terms with key order should be streamable", metrics.streamable());
                writer.commit();
    public void testTermsFactoryEstimateEmptyIndex() throws IOException {
        try (Directory directory = newDirectory()) {
     */
                            hasNonStreamable = true;
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    Document doc = new Document();
import org.apache.lucene.search.BooleanQuery;
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                try (IndexReader reader = DirectoryReader.open(writer)) {
            try (IndexWriter writer = new IndexWriter(directory, config)) {
            IndexWriterConfig config = new IndexWriterConfig();
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    IndexSearcher searcher = newIndexSearcher(reader);
            }
public class FactoryStreamingCostEstimationTests extends AggregatorTestCase {
    public void testCardinalityFactoryEstimateWithOrdinals() throws IOException {
        QueryShardContext queryShardContext = searchContext.getQueryShardContext();
import org.apache.lucene.search.TermQuery;
                    IndexSearcher searcher = newIndexSearcher(reader);
                    // Match-all with clean segments but high cardinality - should be streamable
        }
import org.apache.lucene.index.IndexWriterConfig;
        try (Directory directory = newDirectory()) {
    public void testSiblingAggregationCostCombination() throws IOException {
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
import org.apache.lucene.document.SortedNumericDocValuesField;
    /**
    public void testTermsFactoryEstimateNumericTerms() throws IOException {
import org.apache.lucene.document.SortedSetDocValuesField;
                    assertTrue("Should be streamable even with empty index", metrics.streamable());
            this.factory = factory;
        try (Directory directory = newDirectory()) {
                    Document doc = new Document();
    /**
                }
                    AggregatorFactory[] subFactoryArray = subFactories.getFactories();
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    writer.addDocument(doc);
     * Numeric terms with count ordering (default) ARE streamable.
                    assertTrue("Should be streamable", metrics.streamable());
                    assertFalse("Numeric terms with key descending order should NOT be streamable", metrics.streamable());
        // Mock the minEstimatedBucketCount setting
                    );
                Document doc = new Document();
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
    private FactoryAndContext createAggregatorFactoryWithMinBucketCount(
    // Metric Aggregator Factories Tests
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
