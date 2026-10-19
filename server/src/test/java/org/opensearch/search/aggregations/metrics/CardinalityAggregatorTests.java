        }, card -> {
        }, card -> {
        );
        final String fieldName = "testField";
    }
            assertEquals(1, card.getValue(), 0);
    }
                        indexSearcher,
    }
            100,
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
            assertTrue(AggregationInspectionHelper.hasValue(card));
        multiRecord.add(range2);
    public void testHybridCollectorUsesOrdinalsCollectorWithLowCardinality() throws IOException {
import org.apache.lucene.document.BinaryDocValuesField;
                        new KeywordField(filterFieldName, filterValue, Field.Store.NO),
        }, null);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field")
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
                )
            assertEquals(0.0, card.getValue(), 0);
            }
import org.opensearch.index.mapper.KeywordFieldMapper;
    }
                if (randomBoolean()) {
            }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.geo.GeoPoint;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            assertTrue(collector instanceof HybridCollector);
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
            10,
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
                    filterValue = "bar";
                    )
                searcher,
                    new SortedSetDocValuesField(fieldName, new BytesRef("2"))
            assertFalse(AggregationInspectionHelper.hasValue(card));
    }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
        }, collector -> { assertTrue(collector instanceof OrdinalsCollector); }, fieldType, false, 1024L * 1024L);
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        });
        final String filterFieldName = "filterField";
                )
    ) throws IOException {
                        null
            assertTrue(AggregationInspectionHelper.hasValue(card));
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    public void testNoMatchingField() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testHybridCollectorUsesDirectCollectorWithHighCardinality() throws IOException {
    public void testHybridCollectorCollectRangeSwitchesToDirectCollector() throws IOException {
        Query query,
            assertTrue(AggregationInspectionHelper.hasValue(card));
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(1000.0, card.getValue(), 10.0);
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
                                memoryThreshold
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
import java.io.IOException;
            assertTrue(AggregationInspectionHelper.hasValue(card));
            assertEquals(0.0, card.getValue(), 0);
                    aggregator.context().bigArrays(),
                query,
import org.opensearch.index.mapper.RangeType;
        }, null);
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
        testAggregation(new MatchAllDocsQuery(), iw -> {
        testAggregation(new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.util.BytesRef;
                        new MultiBucketConsumerService.MultiBucketConsumer(
 * compatible open source license.
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
import java.util.Arrays;
        }, card -> {
 */
    }
    public void testQueryFiltersAll() throws IOException {
    }
    }
        final String filterFieldName = "filterField";
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.document.SortedDocValuesField;
                asList(
            iw.addDocument(
                    asList(
                CountingAggregator aggregator = new CountingAggregator(
            iw.addDocument(singleton(new SortedDocValuesField("field", new BytesRef())));
            // High cardinality data with low memory threshold - should switch to DirectCollector
            assertEquals(300.0, card.getValue(), 10.0);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
import org.apache.lucene.store.Directory;
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    }
        }, fieldType, true, 20); // Low threshold to force switching during DocIdStream
                    when(searchContext.cardinalityAggregationPruningThreshold()).thenReturn(pruningThreshold);
    }
        // Test that it has no stack trace for performance
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
                iw.addDocument(
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number")
                    query,
                // disable merge so segment number is same as commit times
        }, card -> {
        CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("name").field("number").missing("🍌🍌🍌");
        }, card -> {
                );
            for (int i = 0; i < 250; i++) {
    }
            // High cardinality data to trigger memory threshold during collectRange
/*
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            assertEquals(1, card.getValue(), 0);
                String filterValue = "foo";
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
            assertTrue(AggregationInspectionHelper.hasValue(card));
            }
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.document.SortedSetDocValuesField;
            // Intentionally not writing any docs
 * license agreements. See the NOTICE file distributed with
                InternalCardinality card = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    ) throws IOException {
import org.apache.lucene.tests.index.RandomIndexWriter;
            );
                    directory,
                indexSearcher.search(query, aggregator);
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
import org.opensearch.index.mapper.MappedFieldType;
            assertEquals(1, card.getValue(), 0);
        // Test that collectRange works with hybrid collector
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
            for (int i = 0; i < randomCardinality; i++) {
            for (int i = 0; i < 50; i++) {
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.OrdinalsCollector); }, fieldType);
        }, card -> {
            (collectCount) -> assertEquals(randomCardinality - counter.get(), (int) collectCount)
                    new KeywordField(fieldName, "4", Field.Store.NO),
import org.opensearch.search.aggregations.AggregatorFactories;
        int pruningThreshold
        int randomCardinality = randomIntBetween(1, 100);
            assertTrue(collector instanceof HybridCollector);
                    PipelineAggregator.PipelineTree.EMPTY
        assertThrows(IllegalArgumentException.class, () -> testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, card -> {
                    new KeywordField(fieldName, "3", Field.Store.NO),
        Consumer<LeafBucketCollector> verifyCollector,
        AggregationBuilder aggregationBuilder,
                fieldType
    }
        AtomicInteger counter = new AtomicInteger();
                );
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range2)))));
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    private void testAggregationHybridCollector(
        Query query,
            assertEquals(250.0, card.getValue(), 8.0);
                aggregator.postCollection();
        assertEquals(0, ex1.getStackTrace().length);
    }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
                asList(
        }, card -> {
        Query query,
                    counter.getAndIncrement();
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
/*
    }
            .executionHint("ordinals");
                );
                verify.accept(card);
        }, fieldType, 100, (collectCount) -> assertEquals(0, (int) collectCount));
            }
                aggregator.postCollection();
    }
            iw.addDocument(
                }
        }, card -> {
                        },
import org.apache.lucene.document.NumericDocValuesField;
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("range_switch_" + i))));
        MappedFieldType fieldType,
                    reduceBucketConsumer,
 */
import org.opensearch.common.CheckedConsumer;
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
    }
import static java.util.Collections.singleton;
                    Integer.MAX_VALUE,
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("range_value" + i))));
        Query query,
                CountingAggregator aggregator = createCountingAggregator(
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
 * Unless required by applicable law or agreed to in writing,
        CheckedConsumer<IndexWriter, IOException> buildIndex,
        }, card -> {
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
                    new KeywordField(fieldName, "2", Field.Store.NO),
            assertTrue(AggregationInspectionHelper.hasValue(card));
        testDynamicPruning(aggregationBuilder, new TermQuery(new Term(filterFieldName, "foo")), iw -> {
    ) throws IOException {
    public void testMemoryLimitExceptionSingleton() {
        final String filterFieldName = "filterField";
            iw.addDocument(List.of(new KeywordField(fieldName2, "102", Field.Store.NO)));
            assertTrue(AggregationInspectionHelper.hasValue(card));
        }
        Consumer<InternalCardinality> verify,
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("b"))));
        testDynamicPruning(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    ) throws IOException {
        }, card -> {
        }, card -> {
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            assertEquals(1, card.getValue(), 0);
        CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("name").field("number")
                asList(
        MappedFieldType fieldType
import org.apache.lucene.document.IntPoint;
        multiRecord.add(range1);
        Consumer<InternalCardinality> verify,
 * specific language governing permissions and limitations
                );
                    reduceBucketConsumer,
            assertTrue(collector instanceof HybridCollector);
        }, card -> {
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                aggregator.postCollection();
        }, fieldType, true, 1024L * 1024L);
                    new SortedSetDocValuesField(fieldName, new BytesRef("3"))
            assertTrue(AggregationInspectionHelper.hasValue(card));
    public void testInvalidExecutionHint() throws IOException {
        }, collector -> {
    }
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.search.TermQuery;
        testAggregation(IntPoint.newRangeQuery("number", 0, 5), iw -> {
    public void testNoExecutionHintWithByteValues() throws IOException {
    }
            );
                    DEFAULT_MAX_BUCKETS,
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
        long memoryThreshold
            assertTrue(AggregationInspectionHelper.hasValue(card));
import org.apache.lucene.search.MatchAllDocsQuery;
            assertTrue(AggregationInspectionHelper.hasValue(card));
            // Should have switched to DirectCollector due to memory threshold
            assertEquals(3, card.getValue(), 0);
                );
import org.opensearch.index.mapper.RangeFieldMapper;
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("value" + i))));
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType));
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
                verify.accept(card);
                    )
import org.apache.lucene.index.IndexWriter;
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
/*
            assertEquals(3.0, card.getValue(), 0);
import org.opensearch.search.aggregations.AggregatorTestCase;
            assertEquals(2, card.getValue(), 0);
                    PipelineAggregator.PipelineTree.EMPTY
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
        assertSame("Exception should be singleton", ex1, ex2);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
    private void testAggregation(
            iw.addDocument(
    }
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))
        Consumer<InternalCardinality> verify,
            assertTrue(AggregationInspectionHelper.hasValue(card));
        });
                    filterValue = "bar";
import org.apache.lucene.search.Query;
 * The OpenSearch Contributors require contributions made to
package org.opensearch.search.aggregations.metrics;
            }
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
                verify.accept(card);
    private void testDynamicPruning(
    public void testSupportsIntraSegmentSearch() throws IOException {
            try (
        );
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                    new SortedSetDocValuesField(fieldName, new BytesRef("5"))
    protected CountingAggregator createCountingAggregator(
                        fieldType
import org.opensearch.search.aggregations.LeafBucketCollector;
        AggregationBuilder aggregationBuilder,
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("low1"))));
        }, card -> {
        });
            card -> { assertEquals(randomCardinality - counter.get(), card.getValue(), 0); },
            );
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
import org.apache.lucene.index.IndexReader;
        }, collector -> { assertTrue(collector instanceof HybridCollector); }, fieldType, true, 1024L * 1024L);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                    )
import org.apache.lucene.document.KeywordField;
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field")
        AtomicInteger counter = new AtomicInteger();
 * SPDX-License-Identifier: Apache-2.0
        Consumer<InternalCardinality> verify,
 * not use this file except in compliance with the License.
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("a"))));
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
                InternalCardinality topLevel = (InternalCardinality) aggregator.buildTopLevel();
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        }, collector -> {
        testDynamicPruning(aggregationBuilder, new TermQuery(new Term(filterFieldName, "foo")), iw -> {
            }
                    PipelineAggregator.PipelineTree.EMPTY
            assertTrue(AggregationInspectionHelper.hasValue(card));
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import org.apache.lucene.tests.util.TestUtil;
        Consumer<Integer> verifyCollectCount
                    indexSearcher,
    ) throws IOException {
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
                        query,
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        IndexSearcher searcher,
    }
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
 *
            for (int i = 0; i < 500; i++) {
import org.opensearch.search.aggregations.InternalAggregation;
            .executionHint("direct");
                asList(
                            Integer.MAX_VALUE,
        AggregationBuilder aggregationBuilder,
            (collectCount) -> assertEquals(3, (int) collectCount)
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("low3"))));
            assertTrue(AggregationInspectionHelper.hasValue(card));
            buildIndex.accept(indexWriter);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                doAssertReducedMultiBucketConsumer(card, reduceBucketConsumer);
import java.util.List;
            try (IndexReader reader = indexWriter.getReader()) {
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number");
        CardinalityAggregator.MemoryLimitExceededException ex2 = CardinalityAggregator.MemoryLimitExceededException.INSTANCE;
 *
import org.apache.lucene.index.DirectoryReader;
                )
                InternalCardinality topLevel = (InternalCardinality) aggregator.buildTopLevel();
 * the Apache License, Version 2.0 (the "License"); you may
        }, fieldType, true, 1); // Very low threshold to trigger switching
            .executionHint("direct");
                asList(
                (searchContext) -> {
            fieldType,
            for (int i = 0; i < 300; i++) {
            assertTrue(collector instanceof HybridCollector);
    public void testOrdinalsExecutionHintWithNumericDocValues() throws IOException {
import org.apache.lucene.search.IndexSearcher;
        },
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
import static org.mockito.Mockito.when;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            for (int i = 0; i < randomCardinality; i++) {
import org.apache.lucene.index.NoMergePolicy;
        }, card -> {
    public void testDynamicPruningFieldMissingInSegment() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(card));
    }
        }, card -> {
            }
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        return new CountingAggregator(
                    new SortedSetDocValuesField(fieldName, new BytesRef("2"))
            assertTrue(AggregationInspectionHelper.hasValue(card));
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
                InternalCardinality card = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);
                );
    }
            assertEquals(0.0, card.getValue(), 0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
        MappedFieldType fieldType,
                    new KeywordField(fieldName, "2", Field.Store.NO),
                indexSearcher.search(query, aggregator);
            assertEquals(2.0, card.getValue(), 0.1);
import org.apache.lucene.document.SortedNumericDocValuesField;
    ) throws IOException {
                );
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    public void testDynamicPruningDisabledWhenExceedingThreshold() throws IOException {
            assertEquals(1, card.getValue(), 0);
        Consumer<LeafBucketCollector> verifyCollector,
        Consumer<InternalCardinality> verify
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.OrdinalsCollector); }, fieldType);
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
        });
        });
        final String fieldName2 = "testField2";
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
        }, fieldType, true, 15); // Very low threshold to force switching during collectRange
                );
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof CardinalityAggregator.DirectCollector);
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            fieldType,
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
                    aggregator.context().bigArrays(),
                IndexWriter indexWriter = new IndexWriter(
                    new KeywordField(fieldName, "5", Field.Store.NO),
    public void testDynamicPruningRandomDelete() throws IOException {
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
            assertTrue(AggregationInspectionHelper.hasValue(card));
        int randomNumSegments = randomIntBetween(1, 50);
            assertTrue(AggregationInspectionHelper.hasValue(card));
                asList(
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
                )
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
            for (int i = 0; i < randomNumSegments; i++) {
            )
    public void testHybridCollectorDocIdStreamSwitchesToDirectCollector() throws IOException {
        AggregationBuilder aggregationBuilder,
    }
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number")
                    counter.getAndIncrement();
            assertTrue(AggregationInspectionHelper.hasValue(card));
            iw.addDocument(singleton(new SortedDocValuesField("field", new BytesRef())));
        }, card -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
                    asList(
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(50.0, card.getValue(), 3.0);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }, card -> {
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                    iw.deleteDocuments(new Term(fieldName, String.valueOf(i)));
        },
    public void testHybridCollectorDisabledWithKeywordField() throws IOException {
                aggregator.preCollection();
            assertFalse(AggregationInspectionHelper.hasValue(card));
                new MultiBucketConsumerService.MultiBucketConsumer(
            }
            }
import java.util.function.Consumer;
            }
    private void testAggregationExecutionHint(
import org.apache.lucene.index.Term;
                },
        }, collector -> {
 * under the License.
            );
        try (Directory directory = newDirectory()) {
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
        Query query,
import java.util.HashSet;
                buildIndex.accept(indexWriter);
            for (int i = 0; i < 1000; i++) {
                iw.addDocument(
            ) {
    public void testDirectExecutionHintWithByteValues() throws IOException {
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    }
        }, collector -> {
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        // Test that DocIdStream collection works with hybrid collector
        },
                AggregatorFactories factories = AggregatorFactories.builder()
                String filterValue = "foo";
            buildIndex.accept(indexWriter);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
    public void testHybridCollectorMemoryThresholdExceeded() throws IOException {
                IndexSearcher searcher = newIndexSearcher(reader);
        testAggregation(new FieldExistsQuery("number"), iw -> {
                    new KeywordField(filterFieldName, "foo", Field.Store.NO),
                        createIndexSettings(),
                            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                )
        boolean hybridCollectorEnabled,
        int pruningThreshold,
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
            assertEquals(3, card.getValue(), 0);
                InternalCardinality topLevel = (InternalCardinality) aggregator.buildTopLevel();
        }, fieldType, 100, (collectCount) -> assertEquals(0, (int) collectCount));
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, fieldType, true, 10); // Very low threshold to force DirectCollector
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                );
            createAggregatorWithCustomizableSearchContext(
    }
import org.apache.lucene.index.IndexWriterConfig;
                        new KeywordField(fieldName, String.valueOf(i), Field.Store.NO),
import org.apache.lucene.document.Field;
    public void testRangeFieldValues() throws IOException {
            iw.addDocument(
            .executionHint("ordinals");
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))
                    new AtomicInteger(),
                doAssertReducedMultiBucketConsumer(card, reduceBucketConsumer);
        final String fieldName = "rangeField";
                }
    }
            iw.addDocument(List.of(new KeywordField(fieldName2, "100", Field.Store.NO)));
        }, card -> {
                    new SortedSetDocValuesField(fieldName, new BytesRef("1"))
                createIndexSettings(),
            }
            assertTrue(AggregationInspectionHelper.hasValue(card));
                            .getQueryShardContext(),
            logger.info("expected {}, cardinality: {}", randomCardinality - counter.get(), card.getValue());
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                aggregator.preCollection();
            card -> { assertEquals(randomCardinality - counter.get(), card.getValue(), 0); },
        }, collector -> {
 * GitHub history for details.
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    public void testUnmappedMissingNumber() throws IOException {
        final String fieldName = "testField";
                    new KeywordField(filterFieldName, "bar", Field.Store.NO),
                ),
                    new AtomicInteger(),
        try (Directory directory = newDirectory()) {
                );
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))
                        ),
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("a"))));
        int randomCardinality = randomIntBetween(1, 100);
                )
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
    public void testDynamicPruningRandomValues() throws IOException {
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            iw.addDocument(singleton(new SortedDocValuesField("field", new BytesRef())));
        }, card -> {
    }
 * software distributed under the License is distributed on an
        final String fieldName = "testField";
    public void testSomeMatchesNumericDocValues() throws IOException {
    public void testDirectExecutionHintWithNumericDocValues() throws IOException {
            assertEquals(1, card.getValue(), 0);
        }, card -> {
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            );
        Query query,
            assertTrue(AggregationInspectionHelper.hasValue(card));
                }
            // Should have switched to DirectCollector due to memory threshold
}
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof OrdinalsCollector);
            assertEquals(2, card.getValue(), 0);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
                    pruningThreshold
            for (int i = 0; i < randomCardinality; i++) {
                    Integer.MAX_VALUE,
                logger.info("aggregator collect count {}", aggregator.getCollectCount().get());
            .executionHint("invalid");
            assertTrue(((HybridCollector) collector).getActiveCollector() instanceof OrdinalsCollector);
                    getMockScriptService(),
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    }
                    .addAggregator(new CardinalityAggregationBuilder("test").field("value"))
        try (Directory directory = newDirectory()) {
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
        });
    public void testNoDocs() throws IOException {
            assertEquals(3, card.getValue(), 0);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testHybridCollectorEnabledWithKeywordField() throws IOException {
                    aggregationBuilder,
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field(fieldName);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    public void testUnmappedMissingGeoPoint() throws IOException {
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
    }
            100,
    }
            }
        }, collector -> { assertTrue(collector instanceof CardinalityAggregator.DirectCollector); }, fieldType);
    public void testQueryFiltering() throws IOException {
                    )
                CountingAggregator aggregator = new CountingAggregator(
                doAssertReducedMultiBucketConsumer(card, reduceBucketConsumer);
import org.opensearch.search.aggregations.metrics.CardinalityAggregator.HybridCollector;
                    new SortedSetDocValuesField(fieldName, new BytesRef("2"))
        }, card -> {
        }, card -> {
                            );
        }, card -> {
                    new SortedSetDocValuesField(fieldName, new BytesRef("1")),
            iw.addDocument(List.of(new KeywordField(fieldName2, "101", Field.Store.NO)));
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                asList(
        // Test that the exception is indeed a singleton
import org.opensearch.core.common.breaker.CircuitBreaker;
            new AtomicInteger(),
        testAggregation(aggregationBuilder, query, buildIndex, verify, fieldType);
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("high_card_" + i))));
                    getMockScriptService(),
    }
            assertEquals(randomCardinality - counter.get(), card.getValue(), 0);
                    getMockScriptService(),
            fieldType,
            (collectCount) -> assertEquals(0, (int) collectCount)
        AggregationBuilder builder,
        );
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("low2"))));
            assertEquals(500.0, card.getValue(), 10.0);
                        (searchContext) -> {
            }
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
            assertEquals(2.0, card.getValue(), 0.1);
    private void testAggregation(
                    new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()).setMergePolicy(NoMergePolicy.INSTANCE)
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
            }
                iw.addDocument(
    public void testNoExecutionHintWithNumericDocValues() throws IOException {
            // Low cardinality data - should use OrdinalsCollector
    public void testDynamicPruningFixedValues() throws IOException {
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
                        new SortedSetDocValuesField(fieldName, new BytesRef(String.valueOf(i)))
                if (randomBoolean()) {
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
        MappedFieldType fieldType,
                verifyCollector.accept(aggregator.getSelectedCollector());
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            assertEquals(100.0, card.getValue(), 5.0);
        }
            assertTrue(AggregationInspectionHelper.hasValue(card));
    }
                    );
                    new SortedSetDocValuesField(fieldName, new BytesRef("4"))
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            );
                verifyCollectCount.accept(aggregator.getCollectCount().get());
 */
            );
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
import org.opensearch.search.aggregations.metrics.CardinalityAggregator.OrdinalsCollector;
import java.util.Collections;
        }, fieldType);
            assertTrue(collector instanceof HybridCollector);
            assertEquals(3.0, card.getValue(), 0.1);
                );
        }, null);
                    aggregator.context().bigArrays(),
                    asList(
        }, card -> {
        }, card -> {
            // Add many documents to potentially exceed memory threshold
    }
                    new KeywordField(fieldName, "2", Field.Store.NO),
                    asList(
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                aggregator.preCollection();
            assertTrue(AggregationInspectionHelper.hasValue(card));
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
        );
    }
                    counter.getAndIncrement();
            card -> { assertEquals(randomNumSegments, card.getValue(), 0); },
                    new KeywordField(fieldName, "1", Field.Store.NO),
                    fieldType,
    public void testOrdinalsExecutionHintWithByteValues() throws IOException {
        }, card -> {
        int randomCardinality = randomIntBetween(20, 100);
            assertTrue(AggregationInspectionHelper.hasValue(card));
            assertEquals(3.0, card.getValue(), 0);
                            when(searchContext.cardinalityAggregationContext()).thenReturn(cardinalityContext);
                indexSearcher.search(query, aggregator);
            indexWriter.close();
        }
 * KIND, either express or implied.  See the License for the
        testDynamicPruning(aggregationBuilder, new TermQuery(new Term(filterFieldName, "foo")), iw -> {
    }
            assertTrue(AggregationInspectionHelper.hasValue(card));
        testAggregation(new FieldExistsQuery("number"), iw -> {
            assertEquals(3, card.getValue(), 0);
import org.opensearch.index.mapper.NumberFieldMapper;
import java.util.concurrent.atomic.AtomicInteger;
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number")
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
        AtomicInteger counter = new AtomicInteger();
                if (randomBoolean()) {
        CardinalityAggregator.MemoryLimitExceededException ex1 = CardinalityAggregator.MemoryLimitExceededException.INSTANCE;
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
                InternalCardinality card = (InternalCardinality) topLevel.reduce(Collections.singletonList(topLevel), context);
        testDynamicPruning(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                            CardinalityAggregationContext cardinalityContext = new CardinalityAggregationContext(
            iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("b"))));
                    createAggregatorWithCustomizableSearchContext(
            iw.addDocument(singleton(new NumericDocValuesField("number", 8)));
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testHybridCollectorWithDocIdStream() throws IOException {
        }, fieldType, true, 1024L * 1024L);
                    new KeywordField(filterFieldName, "bar", Field.Store.NO),
        logger.info("Indexing [{}] segments", randomNumSegments);
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
                );
    }
            assertFalse(AggregationInspectionHelper.hasValue(card));
                                hybridCollectorEnabled,
            iw.addDocument(
        testAggregationHybridCollector(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import java.util.Set;
                )
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("docstream_" + i))));
        final String fieldName = "testField";
        MappedFieldType fieldType
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("number");
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
        testAggregationExecutionHint(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            indexWriter.close();
 * this work for additional information regarding copyright
                    new KeywordField(fieldName, "1", Field.Store.NO),
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(multiRecord))));
    }
import org.apache.lucene.search.FieldExistsQuery;
            iw.addDocument(
                    .build(
                iw.commit();
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                        aggregationBuilder,
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                        new KeywordField(filterFieldName, filterValue, Field.Store.NO),
            assertTrue(collector instanceof HybridCollector);
 * You may obtain a copy of the License at
        }, card -> {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
                    )
            }
    }
        CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("name").field("number").missing(1234);
    public void testHybridCollectorWithCollectRange() throws IOException {
import org.opensearch.search.aggregations.AggregationBuilder;
        }, collector -> {
                iw.addDocument(
    public void testUnmappedMissingString() throws IOException {
                    Integer.MAX_VALUE,
        Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(2);
                    reduceBucketConsumer,
                );
            iw.addDocument(singleton(new NumericDocValuesField("number", 9)));
            for (int i = 0; i < 100; i++) {
            iw.commit();
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType(fieldName);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        RangeType rangeType = RangeType.DOUBLE;
            .missing(new GeoPoint(42.39561, -71.13051));
            iw.addDocument(
                    createAggregator(aggregationBuilder, indexSearcher, fieldType)
                builder,
        final String fieldName = "testField";
import static java.util.Arrays.asList;
                verifyCollector.accept(aggregator.getSelectedCollector());
                )
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
    }
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                iw.addDocument(singleton(new SortedSetDocValuesField("field", new BytesRef("stream_value" + i))));
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        }, collector -> { assertTrue(collector instanceof HybridCollector); }, fieldType, true, 1024L * 1024L);
            assertEquals(1, card.getValue(), 0);
        final CardinalityAggregationBuilder aggregationBuilder = new CardinalityAggregationBuilder("_name").field("field");
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
        testAggregation(IntPoint.newRangeQuery("number", -1, 0), iw -> {
            // High cardinality data to trigger memory threshold during DocIdStream collection
public class CardinalityAggregatorTests extends AggregatorTestCase {
