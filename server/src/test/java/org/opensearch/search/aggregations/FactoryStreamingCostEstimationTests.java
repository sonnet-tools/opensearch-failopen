     * Test that string terms aggregation falls back to non-streamable when cardinality is low.
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, categoryFieldType, valueFieldType);
            }
        AggregationBuilder aggregationBuilder,
    }
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
    // CardinalityAggregatorFactory Tests
                    IndexSearcher searcher = newIndexSearcher(reader);
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 5))));
                        cardinalityResult.factory instanceof StreamingCostEstimable  
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    writer.addDocument(doc);
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
    // Metric Aggregator Factories Tests
                    MappedFieldType brandFieldType = new KeywordFieldMapper.KeywordFieldType("brand");
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms and key descending order.  
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {  
     * when majority of segments have no deleted docs (traditional aggregator can use term frequency optimization).  
 * compatible open source license.
                    assertFalse("Numeric terms with key order should NOT be streamable", metrics.streamable());
                    Document doc = new Document();
                }
        AggregationBuilder aggregationBuilder,  
     */
        }  
                    assertTrue("Combined should be streamable", combined.streamable());
            }
        try (Directory directory = newDirectory()) {
                    // Numeric terms with key descending order - should NOT be streamable
                    // With deletions in all segments, cleanRatio will be 0, so streaming is preferred
import org.opensearch.search.streaming.StreamingCostMetrics;
                    // Create context with high minBucketCount so cardinality (5) < minBucketCount (1000)  
                writer.addDocument(doc);  
                    assertTrue(
     * Test that string terms aggregation falls back to non-streamable for match-all query
     * Helper class to return both the factory and its SearchContext.
                    writer.addDocument(doc);
                        "CardinalityAggregatorFactory should implement StreamingCostEstimable",
                for (int i = 0; i < 50; i++) {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
 *
                    IndexSearcher searcher = newIndexSearcher(reader);
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
        try (Directory directory = newDirectory()) {
            this.searchContext = searchContext;  
    public void testMetricFactoriesReturnNeutralMetrics() throws IOException {
                    writer.addDocument(doc);  
                        .size(5)
                for (int i = 0; i < 100; i++) {  
     */
     * Test that non-match-all query with high cardinality IS streamable.
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms and count ordering.  
        long minBucketCount,
                    assertTrue("Match-all with high cardinality should be streamable", metrics.streamable());
     * Creates an AggregatorFactory with a mocked minEstimatedBucketCount.
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
    }  
import org.apache.lucene.search.MatchAllDocsQuery;  
        try (Directory directory = newDirectory()) {  
        try (Directory directory = newDirectory()) {  
        try (Directory directory = newDirectory()) {
import org.apache.lucene.document.SortedSetDocValuesField;  
                    assertTrue("Match-all with deleted docs should be streamable", metrics.streamable());  
                    writer.addDocument(doc);
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms and key-based ordering.
                    doc.add(new SortedNumericDocValuesField("count", i % 10));
        MappedFieldType... fieldTypes
                    assertFalse("Numeric terms with key descending order should NOT be streamable", metrics.streamable());  
                        searcher,
            }  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        }
                    // Verify individual metrics
                    writer.addDocument(doc);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);  
        try (Directory directory = newDirectory()) {  
                    Query termQuery = new TermQuery(new Term("category", "cat_100"));
     * When cardinality exceeds the threshold, Check 2 is skipped because tryCollectFromTermFrequencies
                    writer.addDocument(doc);  
                // Add 50 documents with numeric values
                        "Cardinality factory should be StreamingCostEstimable",
        FactoryAndContext(AggregatorFactory factory, SearchContext searchContext) {
                    StreamingCostMetrics termsMetrics = ((StreamingCostEstimable) termsResult.factory).estimateStreamingCost(  
    /**
                    FactoryAndContext termsResult = createAggregatorFactory(termsBuilder, searcher, categoryFieldType, brandFieldType);
import org.apache.lucene.document.Document;
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
        AggregationBuilder aggregationBuilder,
                    IndexSearcher searcher = newIndexSearcher(reader);
                }
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
     * Test that match-all query with clean segments but cardinality above the precompute threshold IS streamable.
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(10);
    public void testTermsFactoryEstimateNumericTerms() throws IOException {
                        result.factory instanceof StreamingCostEstimable
                        String catValue = "cat_" + (batch * 1000 + i);
    /**
                }
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));  
                    // Test that both factories are StreamingCostEstimable  
                for (int i = 0; i < 5000; i++) {  
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
    // ========================================  
    /**  
        }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
            }
                }  
                }
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
     * Numeric terms with count ordering (default) ARE streamable.
                    for (AggregatorFactory subFactory : subFactoryArray) {  
    private static class FactoryAndContext {  
        try (Directory directory = newDirectory()) {
    /**
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {  
                    Document doc = new Document();  
                for (int i = 0; i < 50; i++) {  
                    assertFalse("Low cardinality should NOT be streamable", metrics.streamable());
    /**  
        try (Directory directory = newDirectory()) {
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                    MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                    // Create context with MatchAllDocsQuery - should fall back due to term frequency optimization  
                        // Add indexed field for deletion  
                try (IndexReader reader = DirectoryReader.open(writer)) {
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    // Verify sub-factory is not StreamingCostEstimable (TopHitsAggregatorFactory)
            }
import org.apache.lucene.search.BooleanClause;  
                        "TermsAggregatorFactory should implement StreamingCostEstimable",
        MappedFieldType... fieldTypes
        try (Directory directory = newDirectory()) {
    public void testTermsFactoryEstimateNumericTermsWithKeyOrder() throws IOException {  
                writer.deleteAll();
                    assertTrue("Nested streamable aggs should be streamable", metrics.streamable());
 * {@link StreamingCostEstimable#estimateStreamingCost} and that the
                // Add 80 documents with 20 unique values
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                    Document doc = new Document();
                    writer.addDocument(doc);
                    FactoryAndContext result = createAggregatorFactory(cardinalityBuilder, searcher, fieldType);  
import org.opensearch.core.common.breaker.CircuitBreaker;
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                    Document doc = new Document();
                    writer.addDocument(doc);  
    // ========================================  
        }
    }
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);  
import org.opensearch.search.aggregations.metrics.CardinalityAggregationBuilder;  
/**  
            }  
     */
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                }
        QueryShardContext queryShardContext = searchContext.getQueryShardContext();
                }
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
    // Helper methods
            createBucketConsumer(),
    public void testTermsFactoryFallbackMatchAllWithCleanSegments() throws IOException {
                        .size(5)  
                    }
        when(searchContext.getStreamingMinEstimatedBucketCount()).thenReturn(minBucketCount);  
                }  
                for (int i = 0; i < 80; i++) {  
    public void testTermsFactoryFallbackLowCardinality() throws IOException {
                    assertTrue("Numeric terms with count order should be streamable", metrics.streamable());  
                    // Match-all with clean segments but high cardinality - should be streamable  
    public void testNestedAggregationCostCombination() throws IOException {
                    writer.addDocument(doc);
                    // Sibling combination adds topN sizes
    public void testSiblingAggregationCostCombination() throws IOException {  
                }
import org.apache.lucene.search.BooleanQuery;
                }  
    // ========================================
     * don't support key-based ordering.
    }
                    Document doc = new Document();
                        categoryFieldType,
    /**  
                    Document doc = new Document();
                // Add 100 documents with 10 unique terms
     */  
    // ========================================
                writer.commit();
                        }
        QueryShardContext queryShardContext = searchContext.getQueryShardContext();
                    );
            nonMatchAllQuery,
    // ========================================  
                }  
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                // Create index with high cardinality  
    }
     * Test CardinalityAggregatorFactory.estimateStreamingCost with ordinals.  
                }
                        "TermsAggregatorFactory should implement StreamingCostEstimable",
import org.opensearch.index.mapper.KeywordFieldMapper;
    public void testTermsFactoryEstimateStringTerms() throws IOException {
                    doc.add(new SortedNumericDocValuesField("count", i % 10));
                // Create index with high cardinality (more than default minBucketCount)
        }
                    IndexSearcher searcher = newIndexSearcher(reader);
 * {@link AggregatorFactories} tree traversal works correctly.
                    IndexSearcher searcher = newIndexSearcher(reader);  
    ) throws IOException {  
import org.opensearch.index.mapper.NumberFieldMapper;  
            }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                    // The AggregatorFactories.estimateStreamingCostFromFactories should detect the non-streamable sub-agg  
     * Test sibling aggregation cost combination: terms + cardinality.
                    CardinalityAggregationBuilder cardinalityBuilder = new CardinalityAggregationBuilder("cardinality").field("field");
            }  
     */
 * SPDX-License-Identifier: Apache-2.0
            }  
                    assertFalse("Match-all with clean segments should NOT be streamable", metrics.streamable());
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    doc.add(new SortedNumericDocValuesField("value", i));
                }
                    Document doc = new Document();  
                    MaxAggregationBuilder maxBuilder = new MaxAggregationBuilder("max").field("value");  
        }
                // Create index with cardinality above the default threshold (30,000)
                    Document doc = new Document();
                    IndexSearcher searcher = newIndexSearcher(reader);
                    Document doc = new Document();
     */
        }  
                try (IndexReader reader = DirectoryReader.open(writer)) {  
    public void testNestedAggregationWithNonStreamableSubAgg() throws IOException {  
                    );
                }
import org.apache.lucene.index.IndexWriterConfig;
                for (int i = 0; i < 10; i++) {
    /**
            fieldTypes  
import org.opensearch.index.mapper.MappedFieldType;
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);  
     */
                        .order(BucketOrder.key(false));
                    assertTrue("Terms should be streamable", termsMetrics.streamable());
    /**
                    CardinalityAggregationBuilder cardinalityBuilder = new CardinalityAggregationBuilder("cardinality").field("brand");
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                }
                }
                    assertTrue("Should be streamable", metrics.streamable());
                    // Cardinality topN is based on HLL precision (1 << precision), not a fixed value  
                    StreamingCostMetrics combined = termsMetrics.combineWithSibling(cardinalityMetrics);  
        }  
                    doc.add(new SortedSetDocValuesField("brand", new BytesRef("brand_" + (i % 5))));  
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                }
     */  
    /**  
                        writer.addDocument(doc);
                    );
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    // We need to test the factory tree traversal, not just the terms factory
                    assertTrue("Should be streamable", metrics.streamable());
     */
 */  
    }  
        final AggregatorFactory factory;
                // Create index with low cardinality (only 5 unique terms)
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);  
            }  
    public void testTermsFactoryStreamableMatchAllWithDeletedDocs() throws IOException {
    }
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
    // AggregatorFactories Tree Traversal Tests
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    doc.add(new SortedSetDocValuesField("field", new BytesRef("value_" + (i % 20))));
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                }
                    assertTrue("Combined topN should be positive", combined.topNSize() > 0);  
    ) throws IOException {  
        }  
                    IndexSearcher searcher = newIndexSearcher(reader);  
    }
        SearchContext searchContext = createSearchContext(
                for (int i = 0; i < 50; i++) {  
                        result.factory instanceof StreamingCostEstimable  
                    writer.addDocument(doc);  
                for (int i = 0; i < 100; i++) {
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
    /**
    /**
                        cardinalityBuilder,  
        IndexSearcher searcher,  
                    IndexSearcher searcher = newIndexSearcher(reader);
    }
                        .order(BucketOrder.key(true));
                for (int i = 0; i < 5000; i++) {
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(5);
                        result.factory instanceof StreamingCostEstimable  
                    boolean hasNonStreamable = false;
                    assertTrue("String terms with key order should be streamable", metrics.streamable());
                        "TermsAggregatorFactory should implement StreamingCostEstimable",
                    FactoryAndContext result = createAggregatorFactory(maxBuilder, searcher, fieldType);
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    CardinalityAggregationBuilder cardinalityBuilder = new CardinalityAggregationBuilder("cardinality").field("number");
                    IndexSearcher searcher = newIndexSearcher(reader);
    public void testTermsFactoryEstimateEmptyIndex() throws IOException {  
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                    );
     * Test CardinalityAggregatorFactory.estimateStreamingCost with non-ordinals (numeric) returns non-streamable.
                // Create index with high cardinality in multiple batches to create multiple segments  
                    MaxAggregationBuilder maxBuilder = new MaxAggregationBuilder("max").field("value");
                    TopHitsAggregationBuilder topHitsBuilder = new TopHitsAggregationBuilder("top_docs").size(3);
            }
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, new MatchAllDocsQuery(), fieldType);
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 5))));
    public void testTermsFactoryEstimateStringTermsWithKeyOrder() throws IOException {
                    Document doc = new Document();
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));
                            break;  
                    AggregatorFactory[] subFactoryArray = subFactories.getFactories();
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, termQuery, fieldType);  
    public void testTermsFactoryStreamableNonMatchAllQuery() throws IOException {  
            createIndexSettings(),  
                        if (!(subFactory instanceof StreamingCostEstimable)) {
                }
     */
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, new MatchAllDocsQuery(), fieldType);
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(5);  
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
     * Test TermsAggregatorFactory.estimateStreamingCost with string terms (ordinals).
                    FactoryAndContext result = createAggregatorFactoryWithMinBucketCount(termsBuilder, searcher, 1000L, fieldType);
                    Document doc = new Document();
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
        // Use a BooleanQuery wrapper to avoid being detected as match-all
     * Should also be non-streamable.
    // TermsAggregatorFactory Tests
                    writer.addDocument(doc);  
     */  
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                // Create empty index with just schema  
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    }  
                }
    /**
                    writer.deleteDocuments(new org.apache.lucene.index.Term("id", "cat_" + (batch * 1000)));  
                    writer.addDocument(doc);  
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
     * Test TermsAggregatorFactory.estimateStreamingCost with string terms and key-based ordering.
        }  
                }
    public void testTermsFactoryStreamableMatchAllHighCardinality() throws IOException {
                for (int i = 0; i < 100; i++) {
     * Test that metric factories (Max, Min, Avg, Sum, ValueCount) return neutral metrics.  
                    doc.add(new SortedNumericDocValuesField("value", i));
     */
                    Document doc = new Document();
    private FactoryAndContext createAggregatorFactory(
        try (Directory directory = newDirectory()) {  
        }
                    writer.addDocument(doc);  
     */
                    writer.commit(); // Create a segment per batch
        QueryShardContext queryShardContext = searchContext.getQueryShardContext();
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("count", NumberFieldMapper.NumberType.INTEGER);
        try (Directory directory = newDirectory()) {
 * The OpenSearch Contributors require contributions made to  
        Query query,
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
        IndexSearcher searcher,  
        // This simulates a filtered query scenario
        return new MultiBucketConsumerService.MultiBucketConsumer(  
                    IndexSearcher searcher = newIndexSearcher(reader);
        AggregatorFactory factory = aggregationBuilder.rewrite(queryShardContext).build(queryShardContext, null);  
                }  
     * Numeric terms with key ordering are NOT streamable because numeric streaming aggregators  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");
                        result.factory instanceof StreamingCostEstimable  
                }
                    AggregatorFactories subFactories = result.factory.getSubFactories();
    }
            }
                    StreamingCostMetrics cardinalityMetrics = ((StreamingCostEstimable) cardinalityResult.factory).estimateStreamingCost(  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
                        .size(5)
    /**
     */
    /**  
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.IndexWriter;  
                    assertTrue(  
import org.apache.lucene.util.BytesRef;
            }
    /**  
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);
    /**  
                        Document doc = new Document();  
                    assertTrue(  
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("value")
     * would bail out on high cardinality anyway.  
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);  
     */
    // ========================================
                    assertTrue("Should be streamable", metrics.streamable());
    // ========================================
    public void testTermsFactoryEstimateNumericTermsWithCountOrder() throws IOException {  
            }  
        );  
    }
                for (int i = 0; i < 100; i++) {  
                }
        return new FactoryAndContext(factory, searchContext);  
                    IndexSearcher searcher = newIndexSearcher(reader);
                }
    /**
 * this file be licensed under the Apache-2.0 license or a
                    // terms(category) -> max(value)
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                    // Verify sibling combination logic
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
                    IndexSearcher searcher = newIndexSearcher(reader);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);  
        MappedFieldType... fieldTypes
                    // String terms with key ascending order - should be streamable
                        .size(5)  
                    IndexSearcher searcher = newIndexSearcher(reader);
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
    public void testCardinalityFactoryEstimateNonOrdinals() throws IOException {
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category").size(5);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");  
        try (Directory directory = newDirectory()) {
        final SearchContext searchContext;
     * Uses a non-match-all query to avoid triggering the match-all optimization fallback.  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("category");  
        IndexSearcher searcher,
import org.apache.lucene.document.SortedNumericDocValuesField;
    /**
                        .size(5)  
import org.apache.lucene.search.TermQuery;
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                    // Numeric terms with count descending order (default) - should be streamable
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
                }
                try (IndexReader reader = DirectoryReader.open(writer)) {  
                    doc.add(new SortedNumericDocValuesField("number", i));  
    // Streaming Fallback Tests
                    );
            searcher,
    // ========================================
    ) throws IOException {  
                        .order(BucketOrder.count(false));
                doc.add(new SortedSetDocValuesField("category", new BytesRef("temp")));
            config.setMergePolicy(org.apache.lucene.index.NoMergePolicy.INSTANCE);  
        SearchContext searchContext = createSearchContext(searcher, createIndexSettings(), query, createBucketConsumer(), fieldTypes);
                        .order(BucketOrder.key(true));
        }
            }
                        brandFieldType  
                    );
                try (IndexReader reader = DirectoryReader.open(writer)) {
     * Test nested aggregation cost combination: terms -> max.
    // ========================================  
    // ========================================
    }
    // ========================================  
            IndexWriterConfig config = new IndexWriterConfig();
                    FactoryAndContext cardinalityResult = createAggregatorFactory(
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    writer.addDocument(doc);
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);  
}  
     */  
                        doc.add(new org.apache.lucene.document.StringField("id", catValue, org.apache.lucene.document.Field.Store.NO));
        }
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category")  
                    IndexSearcher searcher = newIndexSearcher(reader);
                for (int batch = 0; batch < 5; batch++) {
package org.opensearch.search.aggregations;
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("count", NumberFieldMapper.NumberType.INTEGER);
            DEFAULT_MAX_BUCKETS,
                    assertTrue(
        try (Directory directory = newDirectory()) {
    public void testCardinalityFactoryEstimateWithOrdinals() throws IOException {
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + (i % 10))));  
    }
        );
                    assertTrue(
                    writer.addDocument(doc);  
        try (Directory directory = newDirectory()) {
    }
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("count")
        }
    /**
                    assertEquals("Should have neutral topN size", 1, metrics.topNSize());  
                for (int i = 0; i < 50000; i++) {  
                        "MaxAggregatorFactory should implement StreamingCostEstimable",
     * Returns the factory and the SearchContext used to create it.
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    doc.add(new SortedSetDocValuesField("category", new BytesRef("cat_" + i)));  
                for (int i = 0; i < 100; i++) {
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
    }
    /**  
                    // terms(category) -> top_hits (non-streamable)
     */
import java.io.IOException;
                Document doc = new Document();
                    // Match-all but with deleted docs - should be streamable
                    IndexSearcher searcher = newIndexSearcher(reader);
        try (Directory directory = newDirectory()) {  
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);  
                    for (int i = 0; i < 1000; i++) {
                    );
                }
        try (Directory directory = newDirectory()) {
                }
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category")  
                }
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category")  
                }  
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("count").size(5);
    public void testTermsFactoryEstimateNumericTermsWithKeyDescOrder() throws IOException {  
import static org.mockito.Mockito.when;
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("count")
    /**
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
     */
                }
import org.apache.lucene.store.Directory;  
                }
                writer.commit();
 *
                    // Non-match-all query (using a term query) - should be streamable even with clean segments
                    // TopN is multiplied: parent topN * sub-agg topN (which is 1 for neutral/metric aggs)
        // Mock the minEstimatedBucketCount setting
     * Creates an AggregatorFactory with a specific query.
     * Test TermsAggregatorFactory.estimateStreamingCost with numeric terms.  
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
        }  
                for (int i = 0; i < 50; i++) {  
                        .subAggregation(topHitsBuilder);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            this.factory = factory;
        Query nonMatchAllQuery = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST).build();  
     */  
                    Document doc = new Document();
    }
        AggregatorFactory factory = aggregationBuilder.rewrite(queryShardContext).build(queryShardContext, null);
     */  
                    // Numeric terms with key ascending order - should NOT be streamable
     * String/ordinals terms with key ordering ARE streamable (only numeric is rejected).
import org.apache.lucene.index.DirectoryReader;
                    writer.addDocument(doc);  
                    // Metric factories return neutral metrics - they don't add buckets
     */
import org.opensearch.search.streaming.StreamingCostEstimable;
 * <p>These tests verify that aggregator factories correctly implement  
                    );  
            }  
        }
    }  
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);
                for (int batch = 0; batch < 5; batch++) {
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);  
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {  
            }
    /**
     * Low cardinality means maxCardinality is less than minEstimatedBucketCount setting.  
            try (IndexWriter writer = new IndexWriter(directory, new IndexWriterConfig())) {
     * (term frequency optimization won't work when segments have deletions).  
                    IndexSearcher searcher = newIndexSearcher(reader);
                    IndexSearcher searcher = newIndexSearcher(reader);
                    TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("category");
    // ========================================  
        try (Directory directory = newDirectory()) {  
                }
 * Tests for factory-level streaming cost estimation.
            }
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
                        cardinalityResult.searchContext
    }
                    IndexSearcher searcher = newIndexSearcher(reader);  
                for (int i = 0; i < 50; i++) {  
                    assertFalse("Should be non-streamable for numeric cardinality", metrics.streamable());
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
                    assertTrue("Cardinality should be streamable", cardinalityMetrics.streamable());  
                    assertTrue(
     * Test TermsAggregatorFactory.estimateStreamingCost with empty index.
    }
                }
                        doc.add(new SortedSetDocValuesField("category", new BytesRef(catValue)));
    }
                    FactoryAndContext result = createAggregatorFactoryWithQuery(termsBuilder, searcher, new MatchAllDocsQuery(), fieldType);
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    doc.add(new SortedNumericDocValuesField("count", i % 10));
                    assertTrue("Non-match-all query should be streamable", metrics.streamable());  
        return new FactoryAndContext(factory, searchContext);
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    private FactoryAndContext createAggregatorFactoryWithMinBucketCount(
 */  
                    FactoryAndContext result = createAggregatorFactory(termsBuilder, searcher, fieldType);  
                    StreamingCostMetrics metrics = ((StreamingCostEstimable) result.factory).estimateStreamingCost(result.searchContext);  
                        termsResult.searchContext
import org.opensearch.search.internal.SearchContext;  
    }
                    );  
/*  
                    MappedFieldType categoryFieldType = new KeywordFieldMapper.KeywordFieldType("category");
                    assertTrue("Metric aggs should be streamable", metrics.streamable());
     */
        }
            try (IndexWriter writer = new IndexWriter(directory, config)) {
        }  
            // Use IndexWriterConfig that doesn't merge away deletions
                    assertTrue("Should be streamable even with empty index", metrics.streamable());
        SearchContext searchContext = createSearchContext(searcher, createIndexSettings(), null, createBucketConsumer(), fieldTypes);
                try (IndexReader reader = DirectoryReader.open(writer)) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("count", NumberFieldMapper.NumberType.INTEGER);
        return new FactoryAndContext(factory, searchContext);
import org.opensearch.index.query.QueryShardContext;
                }
                for (int i = 0; i < 50; i++) {  
                    Document doc = new Document();
import org.apache.lucene.search.Query;
                    assertTrue("TopN size should be positive", metrics.topNSize() > 0);
     * Test nested aggregation with non-streamable sub-aggregation: terms -> top_hits.
    private MultiBucketConsumerService.MultiBucketConsumer createBucketConsumer() {
        }  
     * Test that string terms with match-all but deleted docs IS streamable
import org.apache.lucene.index.Term;
                    doc.add(new SortedNumericDocValuesField("value", i));
     * Creates an AggregatorFactory from an AggregationBuilder using the test infrastructure.
    }
                        result.factory instanceof StreamingCostEstimable
                            hasNonStreamable = true;
import org.apache.lucene.index.IndexReader;
                    assertTrue("Terms factory should be StreamingCostEstimable", termsResult.factory instanceof StreamingCostEstimable);  
                        .subAggregation(maxBuilder);
                    Document doc = new Document();
                    Document doc = new Document();
        try (Directory directory = newDirectory()) {  
                    assertTrue("Should have non-streamable sub-factory (TopHitsAggregatorFactory)", hasNonStreamable);  
public class FactoryStreamingCostEstimationTests extends AggregatorTestCase {
    }
    private FactoryAndContext createAggregatorFactoryWithQuery(
                }
                    FactoryAndContext result = createAggregatorFactory(cardinalityBuilder, searcher, fieldType);
                // Delete documents from all segments to make them "dirty"
        AggregatorFactory factory = aggregationBuilder.rewrite(queryShardContext).build(queryShardContext, null);  
