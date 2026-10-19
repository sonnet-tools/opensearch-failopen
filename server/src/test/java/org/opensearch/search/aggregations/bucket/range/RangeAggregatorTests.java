     * partition (false). It declines for overlapping ranges → partition (true). With a sub-agg it always opts in.
                InternalRange agg = (InternalRange) topLevel.reduce(Collections.singletonList(topLevel), context);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            buildIndex.accept(indexWriter);
        List<Document> docs = new ArrayList<>();
    }
        // non-overlapping ranges, no sub-agg: fast path applies -> NOT intra-eligible
        Query boolQuery = builder.build();
    /**
                    indexSearcher,
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());
            new double[][] { { 1, 2 }, { 2, 3 } },
        );
                assertEquals(1, ranges.get(1).getDocCount());
        }, range -> fail("Should have thrown exception"), fieldType));
    ) throws IOException {
            .addRange(-2d, 5d)
        testRewriteOptimizationCase(
            assertEquals(2, ranges.get(1).getDocCount());
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
            assertEquals("10.0-20.0", ranges.get(1).getKeyAsString());
            true
        }, verify, fieldType);
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            int dataNumber = randomInt(200);
import org.apache.lucene.tests.index.RandomIndexWriter;
        }
        builder.add(new TermQuery(new Term(KEYWORD_FIELD_NAME, "route1")), BooleanClause.Occur.MUST);
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 3)));
            .missing(0L);
                assertEquals(2, ranges.size());
            },
    public void testNoMatchingField() throws IOException {
                    reduceBucketConsumer,
        );
    }
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 7)));
     * Expect no optimization as top level query excludes documents.
            }
            null,
        assertFalse(supportsIntraSegmentSearch(nonOverlapping));
        for (int i = 0; i < 3; i++)
        final NumberType numType = NUM_FIELD_TYPE.numberType();
    }
        );
            for (int i = 0; i < dataNumber; i++) {
                double d = lower;
import org.apache.lucene.document.IntPoint;
    public void testMatchesSortedNumericDocValues() throws IOException {
        testCase(new MatchAllDocsQuery(), iw -> {
        );
            dataSet.put(new double[] { lower, upper }, data);
                    aggregationBuilder.addRange(range[0], range[1]);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        try (Directory directory = newDirectory()) {
                List<? extends InternalRange.Bucket> rangeBuckets = range.getBuckets();
    private static final String DATE_FIELD_NAME = "date";
    protected CountingAggregator createCountingAggregator(
    public void testTopLevelRangeQuery() throws IOException {
        RangeAggregationBuilder overlapping = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
        );
            assertTrue(AggregationInspectionHelper.hasValue(range));
     * @return Map [lower, upper) TO data points
    private void testRewriteOptimizationCase(
import org.opensearch.search.aggregations.MultiBucketConsumerService;
    /**
        docList.get(0).addAll(numType.createFields(numType.typeName(), 3.0, true, true, false, false));
        int[] expected = new int[size];
 *    http://www.apache.org/licenses/LICENSE-2.0
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
public class RangeAggregatorTests extends AggregatorTestCase {
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());
                    Integer.MAX_VALUE,
        double[][] ranges = new double[size][];
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                assertTrue(AggregationInspectionHelper.hasValue(range));
    public void testMissingDateWithNumberField() throws IOException {
                    getMockScriptService(),
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 2)));
        }, range -> {
                assertTrue(AggregationInspectionHelper.hasValue(range));
    }
            .missing("1979-01-01T00:00:00");
 */
        NumberFieldType fieldType,
                assertTrue(AggregationInspectionHelper.hasValue(range));
                    fieldType
import static java.util.Collections.singleton;
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                } else {
                    indexWriter.addDocument(doc);
        double[][] ranges,
        testRewriteOptimizationCase(
    ) throws IOException {
        long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        String fieldName = numberType.typeName();
            assertEquals(1, ranges.get(0).getDocCount());
                assertEquals(1, ranges.get(0).getDocCount());
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testHalfFloatType() throws IOException {
            new NumberFieldType(NumberType.HALF_FLOAT.typeName(), NumberType.HALF_FLOAT),
    public void testTopLevelEffectiveMatchAll() throws IOException {
import org.apache.lucene.search.BooleanQuery;
        Map<double[], double[]> dataSet = buildRandomRanges(new double[][] { { 0, 100 }, { 200, 1000 }, { 1000, 3000 } });
import org.opensearch.search.aggregations.AggregationBuilder;
                assertEquals("0.0-0.5", ranges.get(0).getKeyAsString());
                assertEquals("2.0-*", ranges.get(1).getKeyAsString());
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));
        long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            .addRange(-2d, 5d)
                searcher,
import org.apache.lucene.document.SortedNumericDocValuesField;
            () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                InternalRange<? extends InternalRange.Bucket, ? extends InternalRange> agg = searchAndReduce(
            new NumberFieldType(NumberType.UNSIGNED_LONG.typeName(), NumberType.UNSIGNED_LONG),
        for (Number dataPoint : dataPoints) {
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("not_a_number");
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                assertEquals(1, ranges.get(0).getDocCount());
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD_NAME);
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        testCase(new MatchAllDocsQuery(), iw -> {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                assertEquals(1, ranges.get(1).getDocCount());
        final NumberFieldType NUM_FIELD_TYPE = new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE);
                fieldTypes
            assertFalse(AggregationInspectionHelper.hasValue(range));
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
            true
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify
        docList.get(2).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
    public void testUnmappedWithMissingDate() throws IOException {
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 2)));
            IllegalArgumentException.class,
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify
            false,
    }
 * SPDX-License-Identifier: Apache-2.0
            new Number[] { 0.1, 1.1, 2.1 },
        );
        testRewriteOptimizationCase(
        );
        }, fieldType);
import java.util.LinkedList;
        }, range -> {
        );
            docList.add(new Document());
            range -> {
import java.io.IOException;
            false
import org.apache.lucene.index.IndexReader;
    }
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        testRewriteOptimizationCase(NUM_FIELD_TYPE, new double[][] { { 0.0, 10.0 }, { 10.0, 20.0 } }, boolQuery, docList, range -> {
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());
        builder.add(new TermQuery(new Term(KEYWORD_FIELD_NAME, "route1")), BooleanClause.Occur.MUST);
    public void testDoubleType() throws IOException {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
 * the Apache License, Version 2.0 (the "License"); you may
        docList.get(1).addAll(numType.createFields(numType.typeName(), 11.0, true, true, false, false));
        }
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        }
        testCase(new MatchAllDocsQuery(), iw -> {
    ) throws IOException {
                    .addAggregator(builder)
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
import java.time.ZonedDateTime;
            indexWriter.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            DATE_FIELD_NAME,
import static org.hamcrest.Matchers.equalTo;
    }
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE),
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 3)));
        Query query = IntPoint.newRangeQuery(fieldName, 5, 20);
                assertTrue(AggregationInspectionHelper.hasValue(range));
            new double[][] { { 0.0, 10.0 }, { 10.0, 20.0 } },
        Query query,
import java.util.function.Consumer;
            assertEquals(2, ranges.size());
                CountingAggregator aggregator = createCountingAggregator(query, aggregationBuilder, indexSearcher, fieldType);
    }
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
 *
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
                verify.accept(agg);
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("not_a_number").addRange(-2d, 5d);
        assertEquals("Field [not_a_number] of type [keyword] is not supported for aggregation [range]", e.getMessage());
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
            }
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
                aggregator.preCollection();
 * KIND, either express or implied.  See the License for the
            assertEquals(1, ranges.size());
            assertEquals(1, ranges.get(0).getDocCount());
        try (Directory directory = newDirectory()) {
        assertFalse(supportsIntraSegmentSearch(withSubFastPath));
            DateFieldMapper.getDefaultDateTimeFormatter(),
            new MatchAllDocsQuery(),
 * compatible open source license.
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
    }
            DATE_FIELD_NAME,
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(NUMBER_FIELD_NAME)
            assertEquals("10.0-20.0", ranges.get(1).getKeyAsString());
    }
}
        testCase(aggregationBuilder, query, iw -> {
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            .missing("2015-11-13T16:14:34")
            .missing("bogus");
                assertEquals("*-1.0", ranges.get(0).getKeyAsString());
    public void testOverlappingRanges() throws IOException {
    }
 * Licensed to Elasticsearch under one or more contributor
        Query query,
        Map<double[], double[]> dataSet = new LinkedHashMap<>();
        IllegalArgumentException e = expectThrows(
        }, false);
            .missing("2020-02-13T10:11:12");
    }
            query,
            .addRange(0d, 12d)
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
            range -> {
                        null
    }
    }
        RangeAggregationBuilder withSubDeclines = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
import org.opensearch.index.mapper.DateFieldMapper;
            .missing("bogus");
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import java.util.List;
            if (lower > upper) {
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            i++;
            new NumberFieldType(NumberType.FLOAT.typeName(), NumberType.FLOAT),
            .addRange(10d, 100d)
        );
        testRewriteOptimizationCase(
                    assertEquals(expected[j], rangeBuckets.get(j).getDocCount());
            double[] data = new double[dataNumber];
    public void testDateFieldMillisecondResolution() throws IOException {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        final String KEYWORD_FIELD_NAME = "route";
        docList.get(0).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
            new MatchAllDocsQuery(),
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        }, fieldType);
    }
            InternalAggCardinality pc = ranges.get(0).getAggregations().get("c");
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
 * GitHub history for details.
            new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE),
import org.apache.lucene.search.MatchAllDocsQuery;
        }
                assertEquals(1, ranges.get(0).getDocCount());
    }
import org.apache.lucene.search.IndexSearcher;
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(DATE_FIELD_NAME)
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(
                assertEquals(1, ranges.get(1).getDocCount());
import org.apache.lucene.tests.util.TestUtil;
            },
    }
                RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(fieldName);
            new Number[] { 0.1, 1.1, 2.1 },
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        for (int i = 0; i < 3; i++)
            assertEquals(2, ranges.size());
    ) throws IOException {
    public void testMissingDateWithDateField() throws IOException {
    }
    }
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
                assertEquals(2, ranges.size());
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
            // Missing will apply to this document
import org.apache.lucene.util.BytesRef;
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("does_not_exist")
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
            .addRange(-2d, 5d)
        List<Document> docList = new ArrayList<>();
        }
    }
                ),
                }
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
import org.opensearch.index.mapper.KeywordFieldMapper;
        });
    }
        testRewriteOptimizationCase(
            assertEquals(1, ranges.size());
            assertTrue(AggregationInspectionHelper.hasValue(range));
            assertEquals(2, ranges.get(0).getDocCount());
            new MatchAllDocsQuery(),
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
     * The intra-segment gate for range (no sub-agg): partition only when the filter-rewrite O(1) fast path can
import java.util.LinkedHashMap;
            docs.add(doc);
    public void testRandomRanges() throws IOException {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        aggregationBuilder.addRange(0d, 5d);
    private void testRewriteOptimizationCase(
        testRewriteOptimizationCase(NUM_FIELD_TYPE, new double[][] { { 0.0, 10.0 }, { 10.0, 20.0 } }, boolQuery, docList, range -> {
            new double[][] { { 1, 2 }, { 2, 3 } },
                query,
            range -> {
            true
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("does_not_exist")
            expected[i] = entry.getValue().length;
            null,
                doc.add(fld);
        return new CountingAggregator(
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    }
            .addRange(milli1 - 1, milli1 + 1);
            assertEquals(2, ranges.get(0).getDocCount());
                assertEquals("10.0-20.0", ranges.get(1).getKeyAsString());
                indexSearcher.search(query, aggregator);
            .addRange(10d, 20d)
            assertEquals(1, ranges.get(1).getDocCount());
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.IndexWriter;
        aggregationBuilder.addRange(10d, 20d);
            true,
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                    assertEquals(0, aggregator.getCollectCount().get());
        Query query,
                );
     * Expect optimization as top level query is effective match all.
 * ownership. Elasticsearch licenses this file to you under
        String fieldName = fieldType.numberType().typeName();
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
                aggregator.postCollection();
import org.apache.lucene.document.KeywordField;
        // sub-agg but fast path applies (non-overlapping): NOT intra-eligible (BKD walk would duplicate per partition)
                MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
        long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            .addRange(milli1 - 1, milli1 + 1);
    public void testSupportsIntraSegmentSearch() throws IOException {
            try (IndexReader reader = indexWriter.getReader()) {
import org.apache.lucene.document.SortedSetDocValuesField;
            new double[][] { { 1, 2 }, { 2, 3 } },
        // overlapping ranges, no sub-agg: fast path declines -> intra-eligible
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        aggregationBuilder.field(NUMBER_FIELD_NAME);
    }
            assertEquals("0.0-10.0", ranges.get(0).getKeyAsString());
/*
            new Number[] { 0.1, 1.1, 2.1 },
            indexWriter.close();
                assertEquals(1, ranges.get(1).getDocCount());
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(
                    PipelineAggregator.PipelineTree.EMPTY
        testRewriteOptimizationCase(
            assertTrue(AggregationInspectionHelper.hasValue(range));
        double[][] ranges,
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import org.opensearch.common.CheckedConsumer;
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        builder.setMinimumNumberShouldMatch(0);
        });
        Query query,
        docList.get(2).addAll(numType.createFields(numType.typeName(), 15.0, true, true, false, false));
    }
            assertEquals(1, ranges.get(0).getDocCount());
            assertEquals(0, ranges.get(0).getDocCount());
        });
            assertTrue(AggregationInspectionHelper.hasValue(range));
import org.apache.lucene.store.Directory;
            .addRange(10d, 20d);
        }, range -> {
                    .build(
package org.opensearch.search.aggregations.bucket.range;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
            },
                assertEquals(1, ranges.get(0).getDocCount());
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                assertEquals(1, ranges.get(0).getDocCount());
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        assertTrue(supportsIntraSegmentSearch(withSubDeclines));
            assertEquals(1, ranges.size());
            .subAggregation(new AvgAggregationBuilder("avg").field(NUMBER_FIELD_NAME));
import org.opensearch.search.aggregations.AggregatorTestCase;
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        builder.setMinimumNumberShouldMatch(0);
                builder,
            }
                }
            false,
                assertEquals(2, ranges.size());
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        docList.get(2).addAll(numType.createFields(numType.typeName(), 15.0, true, true, false, false));
        docList.get(0).addAll(numType.createFields(numType.typeName(), 3.0, true, true, false, false));
 * not use this file except in compliance with the License.
    }
            assertEquals(1, ranges.get(0).getDocCount());
                assertEquals(1, ranges.get(1).getDocCount());
     */
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            Collections.emptyMap()
            assertTrue(AggregationInspectionHelper.hasValue(range));
                return factories.allFactoriesSupportIntraSegmentSearch();
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
            .addRange(0d, 5d)
        AggregationBuilder builder,
        int i = 0;
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());
            for (double dataPoint : entry.getValue()) {
                InternalRange topLevel = (InternalRange) aggregator.buildTopLevel();
        RangeAggregationBuilder nonOverlapping = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
        final NumberType numType = NUM_FIELD_TYPE.numberType();
            .subAggregation(aggCardinality("c"));
    }
            assertEquals(2, ranges.size());
            assertTrue(AggregationInspectionHelper.hasValue(range));
        NumberType numberType = fieldType.numberType();
            new MatchAllDocsQuery(),
                assertEquals(size, rangeBuckets.size());
    public void testUnmappedWithBadMissingField() {
        String fieldName = numberType.typeName();
    }
    public void testUnsignedLongType() throws IOException {
                assertEquals(2, ranges.size());
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
    public void testDateFieldNanosecondResolution() throws IOException {
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                    aggregator.context().bigArrays(),
import org.opensearch.search.aggregations.InternalAggregation;
 * license agreements. See the NOTICE file distributed with
                IndexSearcher searcher = newIndexSearcher(reader);
            range -> {
 */
            .addRange(10d, 20d)
            }
        }, range -> fail("Should have thrown exception"), fieldType));
        simpleTestCase(aggregationBuilder, new MatchAllDocsQuery(), range -> {
    private void testCase(
 *
            assertEquals(1, ranges.size());
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        testRewriteOptimizationCase(
        docList.get(1).addAll(numType.createFields(numType.typeName(), 11.0, true, true, false, false));
            new double[][] { { Double.NEGATIVE_INFINITY, 1 }, { 2, Double.POSITIVE_INFINITY } },
            docList.add(new Document());
 * under the License.
                if (optimized) {
            true,
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 3)));
                assertEquals(1, ranges.get(0).getDocCount());
            assertEquals(0, ranges.get(1).getDocCount());
                assertTrue(AggregationInspectionHelper.hasValue(range));
        );
            new double[][] { { 1, 2 }, { 2, 3 } },
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        RangeAggregationBuilder withSubFastPath = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
    public void testTopLevelFilterTermQuery() throws IOException {
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
            .addRange(-2d, 5d)
                    aggregationBuilder,
            new double[][] { { 1, 2 }, { 1, 1.5 }, { 0, 0.5 } },
import org.apache.lucene.index.IndexWriterConfig;
            assertThat(pc.cardinality().map(i -> i), equalTo(2));
                assertTrue(AggregationInspectionHelper.hasValue(range));
            assertThat(pc.cardinality(), equalTo(CardinalityUpperBound.ONE));
        }, range -> {
            ranges[i] = entry.getKey();
    public void testMatchesNumericDocValues() throws IOException {
    public void testSubAggCollectsFromSingleBucketIfOneRange() throws IOException {
                assertEquals(3, ranges.size());
        }, range -> {
import org.apache.lucene.search.TermQuery;
    private static final String NUMBER_FIELD_NAME = "number";
        }, fieldType);
            true
        long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
                assertEquals(2, ranges.size());
        }, range -> {
        NumberFieldType fieldType,
        List<Number> dataPoints = new LinkedList<>();
        IndexSearcher searcher,
        final String KEYWORD_FIELD_NAME = "route";
        NumberFieldType fieldType = new NumberFieldType(NumberType.INTEGER.typeName(), NumberType.INTEGER);
                dataPoints.add(dataPoint);
            for (Field fld : fieldList)
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                assertEquals(2, ranges.size());
                    assertTrue(aggregator.getCollectCount().get() > 0);
    }
                for (Document doc : documents) {
import org.apache.lucene.index.Term;
    private void testCase(
        // These values should work because aggs scale nanosecond up to millisecond always.
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    private boolean supportsIntraSegmentSearch(RangeAggregationBuilder builder) throws IOException {
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
                );
        docList.get(2).add(new KeywordField(KEYWORD_FIELD_NAME, "route2", Field.Store.NO));
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 2)));
/*
        RangeAggregationBuilder aggregationBuilder,
                assertEquals("0.0-10.0", ranges.get(0).getKeyAsString());
                assertEquals(1, ranges.get(0).getDocCount());
    ) throws IOException {
 *
            range -> {
        testRewriteOptimizationCase(
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
                }
        List<Document> docList = new ArrayList<>();
        Query boolQuery = builder.build();
        boolean optimized
     */
import org.apache.lucene.search.Query;
            true
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
        long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
 * this work for additional information regarding copyright
                doAssertReducedMultiBucketConsumer(agg, reduceBucketConsumer);
        // These values should work because aggs scale nanosecond up to millisecond always.
        return dataSet;
            .addRange(10d, 20d);
        int size = dataSet.size();
        Number[] dataPoints,
            }, range -> fail("Should have thrown exception"), fieldType)
                assertEquals(1, ranges.get(2).getDocCount());
            assertEquals(2, ranges.size());
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 3)));
            DateFieldMapper.Resolution.NANOSECONDS,
import org.opensearch.index.mapper.ParseContext.Document;
import org.apache.lucene.search.BooleanClause;
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
            assertEquals(2, ranges.size());
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
        final NumberFieldType NUM_FIELD_TYPE = new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE);
    public void testUnsupportedType() {
            },
                AggregatorFactories factories = AggregatorFactories.builder()
                    DEFAULT_MAX_BUCKETS,
        Query query,
            ranges,
                assertTrue(AggregationInspectionHelper.hasValue(range));
        NumberType numberType = fieldType.numberType();
                );
        testRewriteOptimizationCase(fieldType, ranges, query, docs, verify, optimized);
 * software distributed under the License is distributed on an
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                verify.accept(agg);
            )
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            double upper = randomDoubleBetween(range[0], range[1], true);
            },
                assertEquals(3, ranges.get(1).getDocCount());
            assertTrue(AggregationInspectionHelper.hasValue(range));
/*
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 2)));
            InternalAggCardinality pc = ranges.get(0).getAggregations().get("c");
            .subAggregation(new AvgAggregationBuilder("avg").field(NUMBER_FIELD_NAME));
            List<Field> fieldList = numberType.createFields(fieldName, dataPoint, true, true, false, false);
            assertThat(pc.cardinality().map(i -> i), equalTo(2));
            createAggregator(
                    );
        boolean optimized
            new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE),
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import org.opensearch.core.common.breaker.CircuitBreaker;
            new AtomicInteger(),
import java.util.Map;
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));
            fieldType,
            assertTrue(AggregationInspectionHelper.hasValue(range));
            },
    ) throws IOException {
    }
            .addRange(0d, 10d)
            true,
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        RangeAggregationBuilder aggregationBuilder,
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));
            dataPoints.toArray(new Number[0]),
                            .getQueryShardContext(),
            assertEquals(2, ranges.get(0).getDocCount());
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
     */
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
        Query query,
    /**
        });
                assertEquals(1, ranges.get(1).getDocCount());
        for (Map.Entry<double[], double[]> entry : dataSet.entrySet()) {
import org.apache.lucene.document.Field;
 */
            .addRange(0d, 5d)
        List<Document> documents,
import java.util.concurrent.atomic.AtomicInteger;
            assertEquals(0, ranges.get(1).getDocCount());
            new NumberFieldType(NumberType.UNSIGNED_LONG.typeName(), NumberType.UNSIGNED_LONG),
            assertEquals(0, ranges.get(1).getDocCount());
        }, true);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {
            }
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.search.aggregations.AggregatorFactories;
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
            .subAggregation(aggCardinality("c"));
                lower = upper;
        }
            }
        simpleTestCase(aggregationBuilder, new MatchAllDocsQuery(), range -> {
            new MatchAllDocsQuery(),
        for (double[] range : possibleRanges) {
            .addRange(0d, 12d)
        docList.get(1).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
                new MultiBucketConsumerService.MultiBucketConsumer(
                iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foo"))));
            .addRange(-2d, 5d)
        // with a sub-aggregation AND fast path declines (overlapping ranges): intra-eligible (doc-by-doc parallelizes)
        );
            new Number[] { 0.1, 4.0, 9, 11, 12, 19 },
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(DATE_FIELD_NAME)
 * this file be licensed under the Apache-2.0 license or a
        }, range -> fail("Should have thrown exception"), fieldType));
            range -> {
        }, range -> {
    /**
     * NOT apply upfront. Fast path applies for a searchable numeric field with non-overlapping ranges → do not
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
            DateFieldMapper.getDefaultDateTimeFormatter(),
    }
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
            range -> {
            .addRange(0d, 10d)
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    private Map<double[], double[]> buildRandomRanges(double[][] possibleRanges) {
     */
            },
            }
            new Number[] { 0, 1, 2 },
            new MatchAllDocsQuery(),
            new Number[] { 0, 1, 2 },
                    query,
        MappedFieldType... fieldTypes
                data[i] = randomDoubleBetween(lower, upper, true);
            double lower = randomDoubleBetween(range[0], range[1], true);
        assertTrue(supportsIntraSegmentSearch(overlapping));
            new MatchAllDocsQuery(),
        }, range -> fail("Should have thrown exception"), fieldType));
import org.opensearch.search.aggregations.CardinalityUpperBound;
            true,
        );
    public void testFloatType() throws IOException {
                for (int j = 0; j < rangeBuckets.size(); j++) {
 * Modifications Copyright OpenSearch Contributors. See
            },
            new Number[] { 0.1, 1.1, 2.1 },
    public void testBadMissingField() {
        });
            assertEquals(2, ranges.get(0).getDocCount());
        docList.get(0).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
        }, fieldType);
            DateFieldMapper.Resolution.NANOSECONDS,
                }
                for (double[] range : ranges) {
import org.apache.lucene.document.NumericDocValuesField;
        docList.get(1).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
            false
                assertEquals("1.0-1.5", ranges.get(1).getKeyAsString());
    private void simpleTestCase(
    }
            true
                upper = d;
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("does_not_exist")
import org.opensearch.index.mapper.MappedFieldType;
    public void testUnmappedWithMissingNumber() throws IOException {
            range -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
 * The OpenSearch Contributors require contributions made to
            Document doc = new Document();
        MappedFieldType fieldType
import java.time.ZoneOffset;
 * You may obtain a copy of the License at
            pc = ranges.get(1).getAggregations().get("c");
    }
            assertEquals("0.0-10.0", ranges.get(0).getKeyAsString());
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("test_range_agg");
                assertEquals("1.0-2.0", ranges.get(2).getKeyAsString());
            .addRange(milli1 - 1, milli1 + 1);
import java.util.ArrayList;
            Collections.emptyMap()
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(NUMBER_FIELD_NAME)
import org.apache.lucene.index.DirectoryReader;
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(DATE_FIELD_NAME)
        long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
    public void testSubAggCollectsFromManyBucketsIfManyRanges() throws IOException {
import java.util.Collections;
 * specific language governing permissions and limitations
