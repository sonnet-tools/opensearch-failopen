    }
        assertThrows(IllegalArgumentException.class, () -> testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregation(new FieldExistsQuery("number"), iw -> {
                            Integer.MAX_VALUE,  
                    new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()).setMergePolicy(NoMergePolicy.INSTANCE)
                verifyCollectCount.accept(aggregator.getCollectCount().get());  
import java.util.function.Consumer;  
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
            10,  
    public void testSupportsIntraSegmentSearch() throws IOException {  
    }
            assertTrue(collector instanceof HybridCollector);
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            assertTrue(AggregationInspectionHelper.hasValue(card));
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("docstream_" + i))));
 * software distributed under the License is distributed on an
            assertTrue(AggregationInspectionHelper.hasValue(card));
        );
                    DEFAULT_MAX_BUCKETS,
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
                }  
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("stream_value" + i))));
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregation(IntPoint.newRangeQuery("number", -1, 0), iw -> {
    public void testHybridCollectorWithDocIdStream() throws IOException {  
                buildIndex.accept(indexWriter);
                iw.addDocument(  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
        testAggregation(aggregationBuilder, query, buildIndex, verify, fieldType);
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
    }
            assertTrue(collector instanceof HybridCollector);  
    public void testRangeFieldValues() throws IOException {  
            // Should have switched to DirectCollector due to memory threshold
            }  
            assertEquals(3, card.getValue(), 0);
            .missing(new GeoPoint(42.39561, -71.13051));  
                indexSearcher.search(query, aggregator);
import org.apache.lucene.search.TermQuery;
 * Licensed to Elasticsearch under one or more contributor  
                                hybridCollectorEnabled,
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");  
 * this work for additional information regarding copyright
            (collectCount) -> assertEquals(3, (int) collectCount)
            iw.addDocument(List.of(new KeywordField(fieldName2, "100", Field.Store.NO)));  
 * the Apache License, Version 2.0 (the "License"); you may
                );
import org.apache.lucene.search.Query;  
 * compatible open source license.
            assertTrue(AggregationInspectionHelper.hasValue(card));
            assertEquals(1, card.getValue(), 0);
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number");  
        }, collector -> {
        Query query,  
            card -> { assertEquals(randomCardinality - counter.get(), card.getValue(), 0); },  
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }
        testAggregation(IntPoint.newRangeQuery("number", 0, 5), iw -> {
    public void testOrdinalsExecutionHintWithNumericDocValues() throws IOException {
                InternalCardinality topLevel = (InternalCardinality) aggregator.buildTopLevel();
            for (int i = 0; i < randomCardinality; i++) {
            assertEquals(0.0, card.getValue(), 0);
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));  
import org.opensearch.index.mapper.KeywordFieldMapper;
                        query,
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
        Query query,  
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
        AtomicInteger counter = new AtomicInteger();
                    counter.getAndIncrement();  
    private void testDynamicPruning(  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))  
                asList(  
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));  
 */  
    public void testMemoryLimitExceptionSingleton() {
                doAssertReducedMultiBucketConsumer(card, reduceBucketConsumer);
                        createIndexSettings(),
                new MultiBucketConsumerService.MultiBucketConsumer(
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);  
            assertEquals(3, card.getValue(), 0);  
                            CardinalityAggregationContext cardinalityContext = new CardinalityAggregationContext(
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            iw.addDocument(
        }, fieldType, true, 15); // Very low threshold to force switching during collectRange
            assertTrue(AggregationInspectionHelper.hasValue(card));
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, collector -> {
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
                iw.commit();
                )
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
    public void testInvalidExecutionHint() throws IOException {  
            assertEquals(3, card.getValue(), 0);  
 * SPDX-License-Identifier: Apache-2.0
                    getMockScriptService(),
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)  
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("range_switch_" + i))));
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            );
    }
import org.apache.lucene.document.NumericDocValuesField;
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        }, fieldType, true, 10); // Very low threshold to force DirectCollector  
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));  
        testAggregation(new MatchAllDocsQuery(), iw -> {
            assertTrue(AggregationInspectionHelper.hasValue(card));  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);  
                    )
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof OrdinalsCollector);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
    }  
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                    aggregator.context().bigArrays(),
            assertTrue(AggregationInspectionHelper.hasValue(card));  
        }, card -> {  
        },
/*
import org.apache.lucene.document.IntPoint;  
                    new SortedSetDocValuesField(fieldName, new BytesRef("1")),
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof OrdinalsCollector);
        }, null);  
            100,
    public void testQueryFiltering() throws IOException {  
        CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("name").field("number")
                builder,
    public void testNoMatchingField() throws IOException {  
            assertTrue(AggregationInspectionHelper.hasValue(card));
        }  
    public void testHybridCollectorUsesDirectCollectorWithHighCardinality() throws IOException {  
            assertEquals(3.0, card.getValue(), 0.1);
        testDynamicPruning(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testDynamicPruningFixedValues() throws IOException {
        }, card -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));  
        CardinalityAggregator.MemoryLimitExceededException ex1 = CardinalityAggregator.MemoryLimitExceededException.INSTANCE;
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                    reduceBucketConsumer,
    public void testDynamicPruningFieldMissingInSegment() throws IOException {
                InternalCardinality topLevel = (InternalCardinality) aggregator.buildTopLevel();
    protected CountingAggregator createCountingAggregator(
}
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("low1"))));  
            assertEquals(2.0, card.getValue(), 0.1);
import org.opensearch.search.aggregations.InternalAggregation;  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
    }
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
        }  
                );
        CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("name").field("number").missing(1234);
        Consumer<InternalCardinality> verify  
    }
            for (int i = 0; i < 500; i++) {  
                    new SortedSetDocValuesField(fieldName, new BytesRef("2"))  
            assertEquals(1, card.getValue(), 0);
            .executionHint("ordinals");
                );  
        try (Directory directory = newDirectory()) {  
            assertEquals(randomCardinality - counter.get(), card.getValue(), 0);  
            }  
            iw.addDocument(List.of(new KeywordField(fieldName2, "102", Field.Store.NO)));
                    new KeywordField(fieldName, "2", Field.Store.NO),
        // Test that collectRange works with hybrid collector
    }
                    Integer.MAX_VALUE,
                verify.accept(card);  
            indexWriter.close();
        });
    public void testHybridCollectorDisabledWithKeywordField() throws IOException {
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("low2"))));
                },
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                iw.addDocument(
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, collector -> { assertTrue(collector instanceof OrdinalsCollector); }, fieldType, false, 1024L * 1024L);  
                    new KeywordField(fieldName, "2", Field.Store.NO),  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    }
    public void testUnmappedMissingString() throws IOException {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));  
    private void testAggregation(
                String filterValue = "foo";
        logger.info("Indexing [{}] segments", randomNumSegments);  
    }  
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));  
                        null
                    new SortedSetDocValuesField(fieldName, new BytesRef("5"))  
/*  
                verifyCollector.accept(aggregator.getSelectedCollector());
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
            );
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("range_value" + i))));
                    fieldType,  
import org.apache.lucene.index.IndexWriter;
        }, fieldType, true, 20); // Low threshold to force switching during DocIdStream
                InternalCardinality card = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);  
 * this file be licensed under the Apache-2.0 license or a
                );
    }
    }  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
        AggregationBuilder aggregationBuilder,
        }, card -> {
                    PipelineAggregator.PipelineTree.EMPTY
    }
import java.util.Arrays;  
    }
    }
            iw.addDocument(  
    public void testDirectExecutionHintWithByteValues() throws IOException {
                )
    public void testNoExecutionHintWithByteValues() throws IOException {
            iw.commit();  
import org.apache.lucene.store.Directory;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
 *  
            iw.addDocument(
            );  
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))
import org.opensearch.search.aggregations.LeafBucketCollector;
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");  
 * under the License.  
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        final String fieldName = "rangeField";
        Consumer<InternalCardinality> verify,
import org.apache.lucene.document.SortedDocValuesField;  
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
import org.opensearch.search.aggregations.metrics.CardinalityAggregator.HybridCollector;  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                verifyCollector.accept(aggregator.getSelectedCollector());
                InternalCardinality card = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);  
        AggregationBuilder builder,
            iw.addDocument(singleton(new SortedDocValuesField("field", new BytesRef())));  
import java.util.HashSet;
                if (randomBoolean()) {  
            // Low cardinality data - should use OrdinalsCollector
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    }
            assertEquals(1, card.getValue(), 0);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
            );
        }, card -> {
        },  
                    iw.deleteDocuments(new Term(fieldName, String.valueOf(i)));
                    aggregator.context().bigArrays(),  
                );
import java.util.List;  
                AggregatorFactories factories = AggregatorFactories.builder()  
import org.opensearch.search.aggregations.AggregatorFactories;
            iw.addDocument(  
            assertEquals(1000.0, card.getValue(), 10.0);
import org.opensearch.index.mapper.RangeFieldMapper;
                    directory,  
                    new SortedSetDocValuesField(fieldName, new BytesRef("4"))
        }, card -> {
        int pruningThreshold,  
            fieldType,  
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.search.aggregations.metrics;
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
                iw.addDocument(
                        new MultiBucketConsumerService.MultiBucketConsumer(
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));  
            );
    ) throws IOException {
import org.opensearch.search.aggregations.metrics.CardinalityAggregator.OrdinalsCollector;
        });
        testDynamicPruning(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                );
    }
    }
 * specific language governing permissions and limitations
                fieldType
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        CardinalityAggregator.MemoryLimitExceededException ex2 = CardinalityAggregator.MemoryLimitExceededException.INSTANCE;
        // Test that the exception is indeed a singleton  
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
                asList(
            assertEquals(500.0, card.getValue(), 10.0);
                );
            assertEquals(50.0, card.getValue(), 3.0);
            assertTrue(AggregationInspectionHelper.hasValue(card));
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
        MappedFieldType fieldType
        }, card -> {
                    )  
            assertTrue(AggregationInspectionHelper.hasValue(card));  
                    Integer.MAX_VALUE,  
    public void testHybridCollectorUsesOrdinalsCollectorWithLowCardinality() throws IOException {  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
import java.util.Set;
        }, card -> {  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field")  
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));  
        assertEquals(0, ex1.getStackTrace().length);  
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
            (collectCount) -> assertEquals(randomCardinality - counter.get(), (int) collectCount)
            .executionHint("ordinals");
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
                    getMockScriptService(),
        }, fieldType, 100, (collectCount) -> assertEquals(0, (int) collectCount));
 * KIND, either express or implied.  See the License for the
                    filterValue = "bar";
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        }, fieldType);  
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(card));  
import org.opensearch.search.aggregations.AggregatorTestCase;
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                }
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
import org.opensearch.index.mapper.RangeType;
        }, null);  
        RangeType rangeType = RangeType.DOUBLE;
import org.apache.lucene.search.MatchAllDocsQuery;
    }
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
        int pruningThreshold
                (searchContext) -> {
        MappedFieldType fieldType,
import org.apache.lucene.util.BytesRef;
            assertTrue(AggregationInspectionHelper.hasValue(card));  
                aggregator.postCollection();
                        aggregationBuilder,
                    when(searchContext.cardinalityAggregationPruningThreshold()).thenReturn(pruningThreshold);  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
            createAggregatorWithCustomizableSearchContext(
                IndexWriter indexWriter = new IndexWriter(
import org.apache.lucene.document.SortedNumericDocValuesField;
                aggregator.postCollection();  
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("low3"))));
            assertFalse(AggregationInspectionHelper.hasValue(card));
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.OrdinalsCollector); }, fieldType);
        final String filterFieldName = "filterField";
    }  
                if (randomBoolean()) {  
        final String fieldName = "testField";
        testAggregation(new FieldExistsQuery("number"), iw -> {  
    public void testUnmappedMissingNumber() throws IOException {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            assertTrue(AggregationInspectionHelper.hasValue(card));
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            }
                )
            indexWriter.close();  
 *
        testDynamicPruning(aggregationBuilder, new TermQuery(new Term(filterFieldName, "foo")), iw -> {  
import static org.mockito.Mockito.when;
        }, card -> {  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);  
            assertTrue(AggregationInspectionHelper.hasValue(card));
            100,
                    );  
    ) throws IOException {
                        (searchContext) -> {  
        }, card -> {  
import org.apache.lucene.search.FieldExistsQuery;  
    ) throws IOException {
        }, card -> {
                    .build(
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
        }, card -> {  
        testDynamicPruning(aggregationBuilder, new TermQuery(new Term(filterFieldName, "foo")), iw -> {
                            );
                    new AtomicInteger(),  
            fieldType,
    public void testQueryFiltersAll() throws IOException {
            iw.addDocument(
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);  
        testDynamicPruning(aggregationBuilder, new TermQuery(new Term(filterFieldName, "foo")), iw -> {
        multiRecord.add(range1);
import org.apache.lucene.index.IndexWriterConfig;  
        Query query,  
            for (int i = 0; i < 1000; i++) {  
            assertTrue(AggregationInspectionHelper.hasValue(card));  
public class CardinalityAggregatorTests extends AggregatorTestCase {
    ) throws IOException {
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    pruningThreshold
            assertEquals(1, card.getValue(), 0);
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))  
import org.opensearch.core.common.breaker.CircuitBreaker;
                        indexSearcher,  
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),  
                    createAggregatorWithCustomizableSearchContext(  
            );  
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                logger.info("aggregator collect count {}", aggregator.getCollectCount().get());
        }, fieldType, 100, (collectCount) -> assertEquals(0, (int) collectCount));  
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    asList(
import org.opensearch.common.geo.GeoPoint;
        },
        Consumer<LeafBucketCollector> verifyCollector,  
    public void testHybridCollectorCollectRangeSwitchesToDirectCollector() throws IOException {
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number")
        }, card -> {
        }, card -> {
                        new KeywordField(filterFieldName, filterValue, Field.Store.NO),
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("high_card_" + i))));
        }, card -> {  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));  
                CountingAggregator aggregator = new CountingAggregator(
        assertSame("Exception should be singleton", ex1, ex2);  
                    asList(
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range2)))));
        }, card -> {  
                indexSearcher.search(query, aggregator);
        }, collector -> {  
    ) throws IOException {
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
    public void testDynamicPruningRandomValues() throws IOException {  
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
                );  
        });  
                    indexSearcher,
            // Intentionally not writing any docs
            assertTrue(AggregationInspectionHelper.hasValue(card));
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
            }
        final String fieldName = "testField";  
                aggregator.preCollection();  
                    reduceBucketConsumer,
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field")  
        IndexSearcher searcher,
                    new AtomicInteger(),
    }
    }  
            (collectCount) -> assertEquals(0, (int) collectCount)  
    }  
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
            assertEquals(2, card.getValue(), 0);
import org.apache.lucene.document.KeywordField;
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.apache.lucene.index.DirectoryReader;  
        });
        }, collector -> {  
            iw.addDocument(  
        );
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
            }
            buildIndex.accept(indexWriter);
        final String filterFieldName = "filterField";
            assertEquals(300.0, card.getValue(), 10.0);
        }, fieldType, true, 1024L * 1024L);
 * Modifications Copyright OpenSearch Contributors. See
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
    public void testHybridCollectorMemoryThresholdExceeded() throws IOException {  
            assertEquals(3.0, card.getValue(), 0);
import org.apache.lucene.document.SortedSetDocValuesField;
        });  
                    new SortedSetDocValuesField(fieldName, new BytesRef("2"))
    }  
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("value" + i))));
            assertEquals(0.0, card.getValue(), 0);
            for (int i = 0; i < randomCardinality; i++) {
        }, card -> {  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
            assertEquals(2.0, card.getValue(), 0.1);  
                )
            assertFalse(AggregationInspectionHelper.hasValue(card));
                    new KeywordField(fieldName, "1", Field.Store.NO),
                    reduceBucketConsumer,  
                    PipelineAggregator.PipelineTree.EMPTY  
            logger.info("expected {}, cardinality: {}", randomCardinality - counter.get(), card.getValue());
                aggregator.postCollection();
        Query query,
        }, card -> {
            for (int i = 0; i < 300; i++) {  
    }
            assertEquals(250.0, card.getValue(), 8.0);
                    aggregator.context().bigArrays(),  
        }, collector -> { assertTrue(collector instanceof HybridCollector); }, fieldType, true, 1024L * 1024L);  
                    new KeywordField(fieldName, "5", Field.Store.NO),
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);  
 * GitHub history for details.
                            when(searchContext.cardinalityAggregationContext()).thenReturn(cardinalityContext);
        }, card -> {  
            assertTrue(collector instanceof HybridCollector);
    public void testSomeMatchesNumericDocValues() throws IOException {
import static java.util.Arrays.asList;
import org.opensearch.common.CheckedConsumer;  
    }
        }, fieldType, true, 1024L * 1024L);  
        MappedFieldType fieldType  
                    new SortedSetDocValuesField(fieldName, new BytesRef("2"))  
import java.io.IOException;
            new AtomicInteger(),
            for (int i = 0; i < randomNumSegments; i++) {  
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
    public void testNoExecutionHintWithNumericDocValues() throws IOException {
            card -> { assertEquals(randomNumSegments, card.getValue(), 0); },
    }
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
                searcher,
        }, card -> {
    }
                doAssertReducedMultiBucketConsumer(card, reduceBucketConsumer);
        // Test that DocIdStream collection works with hybrid collector
                }  
        Consumer<InternalCardinality> verify,
                iw.addDocument(
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
    }
                );
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
        }, collector -> {  
    public void testDirectExecutionHintWithNumericDocValues() throws IOException {  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
                    .addAggregator(new CardinalityAggregationBuilder("test").field("value"))
                    counter.getAndIncrement();
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.OrdinalsCollector); }, fieldType);
        final String fieldName = "testField";  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
    public void testNoDocs() throws IOException {  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
                createIndexSettings(),  
                    new KeywordField(fieldName, "4", Field.Store.NO),  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
                        ),
        }, card -> {  
import org.apache.lucene.tests.index.RandomIndexWriter;  
                        },  
            for (int i = 0; i < 50; i++) {  
    public void testUnmappedMissingGeoPoint() throws IOException {
            assertEquals(100.0, card.getValue(), 5.0);
 * Unless required by applicable law or agreed to in writing,
        }, collector -> { assertTrue(collector instanceof HybridCollector); }, fieldType, true, 1024L * 1024L);  
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);  
    private void testAggregationExecutionHint(
            assertEquals(3.0, card.getValue(), 0);
        Consumer<InternalCardinality> verify,
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),  
    }
        }, card -> {  
            try (IndexReader reader = indexWriter.getReader()) {
            assertTrue(AggregationInspectionHelper.hasValue(card));
            buildIndex.accept(indexWriter);
                );
        AggregationBuilder aggregationBuilder,
import org.apache.lucene.document.Field;
    }
            // Add many documents to potentially exceed memory threshold
                if (randomBoolean()) {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));  
            assertEquals(1, card.getValue(), 0);
                )
                asList(
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    private void testAggregation(  
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
                    new KeywordField(fieldName, "3", Field.Store.NO),
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(  
    }
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));  
                    asList(
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            }  
                )
                    filterValue = "bar";
                    )
                            .getQueryShardContext(),
                                memoryThreshold  
        MappedFieldType fieldType,
                IndexSearcher searcher = newIndexSearcher(reader);
import java.util.concurrent.atomic.AtomicInteger;
        try (Directory directory = newDirectory()) {  
            assertTrue(AggregationInspectionHelper.hasValue(card));
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number")
                InternalCardinality card = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);
 */  
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
            // High cardinality data to trigger memory threshold during DocIdStream collection
            assertEquals(2, card.getValue(), 0);  
                CountingAggregator aggregator = createCountingAggregator(
        AtomicInteger counter = new AtomicInteger();
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
    private void testAggregationHybridCollector(
                aggregator.preCollection();  
        );
            assertEquals(0.0, card.getValue(), 0);  
            for (int i = 0; i < 100; i++) {  
            )  
                    new SortedSetDocValuesField(fieldName, new BytesRef("3"))
                    createAggregator(aggregationBuilder, indexSearcher, fieldType)
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            for (int i = 0; i < randomCardinality; i++) {
            ) {  
        multiRecord.add(range2);  
            assertEquals(3, card.getValue(), 0);
        }, card -> {
            fieldType,
            }
                        fieldType
                verify.accept(card);
    }
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
                ),
            iw.addDocument(singleton(new SortedDocValuesField("field", new BytesRef())));  
    public void testHybridCollectorEnabledWithKeywordField() throws IOException {
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("a"))));
    ) throws IOException {
            assertFalse(AggregationInspectionHelper.hasValue(card));  
        }, collector -> {  
        // Test that it has no stack trace for performance
            assertTrue(collector instanceof HybridCollector);
                    )
        }, fieldType, true, 1); // Very low threshold to trigger switching  
    }
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
import java.util.Collections;
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                );
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
            }
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
        Consumer<Integer> verifyCollectCount
                    counter.getAndIncrement();
import org.apache.lucene.index.Term;
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),  
                );
        }
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
        AtomicInteger counter = new AtomicInteger();
            try (
 * The OpenSearch Contributors require contributions made to  
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
/*  
 * license agreements. See the NOTICE file distributed with
            );
        int randomNumSegments = randomIntBetween(1, 50);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        Consumer<InternalCardinality> verify,
import org.apache.lucene.tests.util.TestUtil;
                    Integer.MAX_VALUE,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String filterFieldName = "filterField";
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number");
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            .executionHint("invalid");  
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
    }
                    new KeywordField(fieldName, "1", Field.Store.NO),  
                    query,  
                    new KeywordField(filterFieldName, "bar", Field.Store.NO),
 *
    }
            .executionHint("direct");
import org.apache.lucene.index.IndexReader;
            card -> { assertEquals(randomCardinality - counter.get(), card.getValue(), 0); },
            assertTrue(AggregationInspectionHelper.hasValue(card));
        Query query,  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
            assertTrue(AggregationInspectionHelper.hasValue(card));  
                asList(
            iw.addDocument(
                    new KeywordField(fieldName, "2", Field.Store.NO),
    }  
        }, card -> {  
    public void testDynamicPruningRandomDelete() throws IOException {
    public void testHybridCollectorDocIdStreamSwitchesToDirectCollector() throws IOException {  
            // High cardinality data to trigger memory threshold during collectRange  
        Consumer<LeafBucketCollector> verifyCollector,  
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                );
                )  
        AggregationBuilder aggregationBuilder,
import static java.util.Collections.singleton;  
        }, card -> {
            // High cardinality data with low memory threshold - should switch to DirectCollector
                InternalCardinality topLevel = (InternalCardinality) aggregator.buildTopLevel();  
        try (Directory directory = newDirectory()) {
            .executionHint("direct");  
 */
                )  
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("a"))));  
        long memoryThreshold  
        AggregationBuilder aggregationBuilder,
            }
 * You may obtain a copy of the License at  
                String filterValue = "foo";  
    }
import org.opensearch.search.aggregations.AggregationBuilder;  
                // disable merge so segment number is same as commit times
        }, card -> {
            assertTrue(AggregationInspectionHelper.hasValue(card));
            }
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("b"))));
                aggregator.preCollection();
        final String fieldName = "testField";
            assertTrue(AggregationInspectionHelper.hasValue(card));
        final String fieldName = "testField";
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                    PipelineAggregator.PipelineTree.EMPTY  
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
            }
import org.apache.lucene.index.NoMergePolicy;
        }, null);
            assertTrue(collector instanceof HybridCollector);
            }  
                    )
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            iw.addDocument(List.of(new KeywordField(fieldName2, "101", Field.Store.NO)));
        }, card -> {  
        });
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                doAssertReducedMultiBucketConsumer(card, reduceBucketConsumer);
            assertTrue(AggregationInspectionHelper.hasValue(card));
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
            iw.addDocument(singleton(new SortedDocValuesField("field", new BytesRef())));  
    public void testOrdinalsExecutionHintWithByteValues() throws IOException {
            assertEquals(1, card.getValue(), 0);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number")
        CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("name").field("number").missing("🍌🍌🍌");  
            assertEquals(1, card.getValue(), 0);
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))
            assertTrue(AggregationInspectionHelper.hasValue(card));
            // Should have switched to DirectCollector due to memory threshold  
            assertTrue(AggregationInspectionHelper.hasValue(card));
        return new CountingAggregator(  
import org.apache.lucene.document.BinaryDocValuesField;
        }, card -> {  
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType));
            for (int i = 0; i < 250; i++) {
                asList(
        int randomCardinality = randomIntBetween(1, 100);
            }
        testAggregation(new MatchAllDocsQuery(), iw -> {
    public void testHybridCollectorWithCollectRange() throws IOException {  
                    new SortedSetDocValuesField(fieldName, new BytesRef("1"))
                asList(
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.search.IndexSearcher;
        Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(2);
                    new KeywordField(filterFieldName, "bar", Field.Store.NO),
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");  
        Query query,
        CheckedConsumer<IndexWriter, IOException> buildIndex,  
        final String fieldName2 = "testField2";  
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(multiRecord))));
                verify.accept(card);  
        );  
import org.opensearch.index.mapper.NumberFieldMapper;  
                    asList(  
        int randomCardinality = randomIntBetween(1, 100);
                    getMockScriptService(),
                CountingAggregator aggregator = new CountingAggregator(
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("b"))));
                        new KeywordField(filterFieldName, filterValue, Field.Store.NO),  
                indexSearcher.search(query, aggregator);
    }  
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            }
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        }, card -> {
        boolean hybridCollectorEnabled,
        int randomCardinality = randomIntBetween(20, 100);  
        MappedFieldType fieldType,  
                asList(  
 * not use this file except in compliance with the License.
            assertTrue(collector instanceof HybridCollector);
                query,  
    public void testDynamicPruningDisabledWhenExceedingThreshold() throws IOException {
                    aggregationBuilder,
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
