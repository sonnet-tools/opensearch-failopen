    }
import org.apache.lucene.document.IntPoint;
            new MatchAllDocsQuery(),
        int size = dataSet.size();
            null,
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("test_range_agg");
    private static final String DATE_FIELD_NAME = "date";  
        });  
    public void testUnmappedWithBadMissingField() {
            assertTrue(AggregationInspectionHelper.hasValue(range));
import org.opensearch.core.common.breaker.CircuitBreaker;
import org.opensearch.search.aggregations.AggregatorTestCase;  
            .addRange(-2d, 5d)  
            double upper = randomDoubleBetween(range[0], range[1], true);
        List<Number> dataPoints = new LinkedList<>();
                InternalRange agg = (InternalRange) topLevel.reduce(Collections.singletonList(topLevel), context);  
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            Document doc = new Document();
        List<Document> documents,
                    reduceBucketConsumer,
            expected[i] = entry.getValue().length;  
     * NOT apply upfront. Fast path applies for a searchable numeric field with non-overlapping ranges → do not
            new Number[] { 0, 1, 2 },  
 *
            .subAggregation(new AvgAggregationBuilder("avg").field(NUMBER_FIELD_NAME));
                }  
/*
                assertEquals(3, ranges.size());
    }  
import org.opensearch.common.CheckedConsumer;
import java.time.ZonedDateTime;
                assertEquals(1, ranges.get(0).getDocCount());  
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
import org.opensearch.search.aggregations.AggregatorFactories;
        assertFalse(supportsIntraSegmentSearch(withSubFastPath));
        for (Number dataPoint : dataPoints) {
        });
        final String KEYWORD_FIELD_NAME = "route";
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("does_not_exist")  
                assertEquals(1, ranges.get(2).getDocCount());
            }, range -> fail("Should have thrown exception"), fieldType)
        docList.get(1).addAll(numType.createFields(numType.typeName(), 11.0, true, true, false, false));
                assertEquals(2, ranges.size());
        docList.get(0).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));  
    ) throws IOException {
    }  
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                lower = upper;
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
        );  
            assertEquals(0, ranges.get(1).getDocCount());
            range -> {  
            assertEquals(1, ranges.get(0).getDocCount());
            assertThat(pc.cardinality().map(i -> i), equalTo(2));  
        testRewriteOptimizationCase(fieldType, ranges, query, docs, verify, optimized);  
        }, range -> {
            assertEquals(2, ranges.size());  
                );
        final NumberFieldType NUM_FIELD_TYPE = new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE);  
            }
            new AtomicInteger(),  
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
        }
            new Number[] { 0.1, 1.1, 2.1 },
        NumberFieldType fieldType,
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
    protected CountingAggregator createCountingAggregator(
            List<Field> fieldList = numberType.createFields(fieldName, dataPoint, true, true, false, false);  
                assertEquals(2, ranges.size());
            for (double dataPoint : entry.getValue()) {
            .missing("2020-02-13T10:11:12");
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
                assertEquals(1, ranges.get(1).getDocCount());
                searcher,
import java.util.LinkedHashMap;
        Query query,
        );
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);  
 * this file be licensed under the Apache-2.0 license or a
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));
                assertEquals(1, ranges.get(1).getDocCount());  
        }
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));  
        builder.add(new TermQuery(new Term(KEYWORD_FIELD_NAME, "route1")), BooleanClause.Occur.MUST);
import org.apache.lucene.search.BooleanQuery;
                    fieldType  
    }  
                assertEquals(1, ranges.get(0).getDocCount());
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
    private void testRewriteOptimizationCase(  
            query,
                for (double[] range : ranges) {
    }  
    public void testFloatType() throws IOException {
            .addRange(-2d, 5d)
            new MatchAllDocsQuery(),  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        testRewriteOptimizationCase(
            .addRange(10d, 20d)  
        // These values should work because aggs scale nanosecond up to millisecond always.  
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
    }  
            true,
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
}
        }
    }
            new double[][] { { 1, 2 }, { 2, 3 } },
        // These values should work because aggs scale nanosecond up to millisecond always.
        long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
            assertEquals(2, ranges.get(1).getDocCount());  
            fieldType,
            DATE_FIELD_NAME,
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
    ) throws IOException {
        IndexSearcher searcher,
            assertThat(pc.cardinality().map(i -> i), equalTo(2));
            },  
    public void testTopLevelEffectiveMatchAll() throws IOException {  
        int[] expected = new int[size];  
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);  
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());  
import org.opensearch.index.mapper.MappedFieldType;  
            new NumberFieldType(NumberType.FLOAT.typeName(), NumberType.FLOAT),  
 */  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(AggregationInspectionHelper.hasValue(range));  
            true
            true  
 * KIND, either express or implied.  See the License for the
                indexSearcher.search(query, aggregator);
        RangeAggregationBuilder overlapping = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)  
        long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals("0.0-10.0", ranges.get(0).getKeyAsString());  
            assertTrue(AggregationInspectionHelper.hasValue(range));  
        // non-overlapping ranges, no sub-agg: fast path applies -> NOT intra-eligible
                dataPoints.add(dataPoint);
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
    public void testDateFieldMillisecondResolution() throws IOException {
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(  
                assertEquals(2, ranges.size());  
            assertEquals(2, ranges.size());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                    aggregationBuilder,
import org.apache.lucene.document.SortedNumericDocValuesField;
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 2)));
 */  
        RangeAggregationBuilder aggregationBuilder,  
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();  
        aggregationBuilder.field(NUMBER_FIELD_NAME);  
            new MatchAllDocsQuery(),
    public void testHalfFloatType() throws IOException {  
import static org.hamcrest.Matchers.equalTo;
            .missing("1979-01-01T00:00:00");  
    private void testCase(
        }, range -> {  
            DateFieldMapper.Resolution.NANOSECONDS,  
            assertEquals(2, ranges.size());
            new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE),
            DATE_FIELD_NAME,
            true
 * You may obtain a copy of the License at  
     */
            new double[][] { { 1, 2 }, { 2, 3 } },
    }
            .addRange(-2d, 5d)  
                new MultiBucketConsumerService.MultiBucketConsumer(
    }
        );
    ) throws IOException {
            new MatchAllDocsQuery(),
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
            Collections.emptyMap()
            assertTrue(AggregationInspectionHelper.hasValue(range));
            .subAggregation(new AvgAggregationBuilder("avg").field(NUMBER_FIELD_NAME));  
        );  
    }  
        NumberType numberType = fieldType.numberType();
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
    public void testDateFieldNanosecondResolution() throws IOException {
                query,
            },
        String fieldName = numberType.typeName();
            }  
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
            indexWriter.close();  
            ranges[i] = entry.getKey();
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(
     */  
        assertEquals("Field [not_a_number] of type [keyword] is not supported for aggregation [range]", e.getMessage());
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(DATE_FIELD_NAME)
/*  
    public void testSupportsIntraSegmentSearch() throws IOException {
        docList.get(0).addAll(numType.createFields(numType.typeName(), 3.0, true, true, false, false));  
            for (Field fld : fieldList)
            }  
                data[i] = randomDoubleBetween(lower, upper, true);
        final NumberFieldType NUM_FIELD_TYPE = new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE);
                if (optimized) {
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
                }  
        builder.add(new TermQuery(new Term(KEYWORD_FIELD_NAME, "route1")), BooleanClause.Occur.MUST);
    }
 * compatible open source license.
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
    }  
            if (lower > upper) {
                aggregator.preCollection();  
                assertTrue(AggregationInspectionHelper.hasValue(range));  
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli1)));  
        }
                InternalRange<? extends InternalRange.Bucket, ? extends InternalRange> agg = searchAndReduce(
        aggregationBuilder.addRange(10d, 20d);
            DateFieldMapper.getDefaultDateTimeFormatter(),
            assertEquals(0, ranges.get(1).getDocCount());
        try (Directory directory = newDirectory()) {  
            assertTrue(AggregationInspectionHelper.hasValue(range));
            true
import java.util.ArrayList;
    }  
    public void testTopLevelFilterTermQuery() throws IOException {
            assertThat(pc.cardinality(), equalTo(CardinalityUpperBound.ONE));
        );
                verify.accept(agg);
 */
                );
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,  
                assertEquals("1.0-2.0", ranges.get(0).getKeyAsString());
            assertEquals("10.0-20.0", ranges.get(1).getKeyAsString());
    }
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        );
                RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(fieldName);  
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 3)));
            assertEquals(1, ranges.get(1).getDocCount());
            range -> {  
            true,
        simpleTestCase(aggregationBuilder, new MatchAllDocsQuery(), range -> {
                    .build(
                List<? extends InternalRange.Bucket> rangeBuckets = range.getBuckets();
                    aggregator.context().bigArrays(),  
    public void testDoubleType() throws IOException {
                assertEquals(1, ranges.get(0).getDocCount());
    public void testSubAggCollectsFromManyBucketsIfManyRanges() throws IOException {  
        Query query,  
            docList.add(new Document());  
        }
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
import org.apache.lucene.index.IndexReader;
 * not use this file except in compliance with the License.
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
        testRewriteOptimizationCase(
            }
        }, fieldType);
 * ownership. Elasticsearch licenses this file to you under  
                IndexSearcher searcher = newIndexSearcher(reader);  
                assertTrue(AggregationInspectionHelper.hasValue(range));
        Query query = IntPoint.newRangeQuery(fieldName, 5, 20);
    private static final String NUMBER_FIELD_NAME = "number";
                assertTrue(AggregationInspectionHelper.hasValue(range));
            .addRange(10d, 20d);
        return new CountingAggregator(
import java.time.ZoneOffset;  
    }
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);  
    public void testUnmappedWithMissingDate() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
import static java.util.Collections.singleton;
    }
            assertEquals(0, ranges.get(1).getDocCount());  
            assertFalse(AggregationInspectionHelper.hasValue(range));  
        docList.get(2).add(new KeywordField(KEYWORD_FIELD_NAME, "route2", Field.Store.NO));
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
import org.apache.lucene.search.MatchAllDocsQuery;  
        try (Directory directory = newDirectory()) {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    private Map<double[], double[]> buildRandomRanges(double[][] possibleRanges) {  
        testRewriteOptimizationCase(  
        }, verify, fieldType);
        }, range -> fail("Should have thrown exception"), fieldType));
        Map<double[], double[]> dataSet = new LinkedHashMap<>();
                for (Document doc : documents) {
        String fieldName = numberType.typeName();  
import java.util.List;  
    }  
import org.apache.lucene.search.IndexSearcher;
    public void testMissingDateWithDateField() throws IOException {  
        }, range -> {
 * Licensed to Elasticsearch under one or more contributor  
    }
        long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();  
 * license agreements. See the NOTICE file distributed with
            }  
        testRewriteOptimizationCase(
            try (IndexReader reader = indexWriter.getReader()) {
        Query query,
            false  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
import java.util.function.Consumer;  
            },  
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 3)));  
            assertEquals("0.0-10.0", ranges.get(0).getKeyAsString());
import org.apache.lucene.document.KeywordField;  
        for (int i = 0; i < 3; i++)
    /**  
            .addRange(0d, 10d)
            InternalAggCardinality pc = ranges.get(0).getAggregations().get("c");
        for (double[] range : possibleRanges) {
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(NUMBER_FIELD_NAME)
        assertFalse(supportsIntraSegmentSearch(nonOverlapping));  
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 3)));
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                assertEquals(1, ranges.get(1).getDocCount());
        }, fieldType);
        }
    }
        Number[] dataPoints,
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("does_not_exist")
    public void testOverlappingRanges() throws IOException {  
package org.opensearch.search.aggregations.bucket.range;
        NumberType numberType = fieldType.numberType();  
                InternalRange topLevel = (InternalRange) aggregator.buildTopLevel();
        assertTrue(supportsIntraSegmentSearch(overlapping));  
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        docList.get(2).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
        NumberFieldType fieldType,
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
import org.apache.lucene.document.SortedSetDocValuesField;  
    public void testNoMatchingField() throws IOException {
import org.opensearch.search.aggregations.AggregationBuilder;
                assertEquals(2, ranges.size());
        RangeAggregationBuilder withSubDeclines = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
                            .getQueryShardContext(),  
            range -> {  
                for (int j = 0; j < rangeBuckets.size(); j++) {  
        MappedFieldType... fieldTypes  
        }, range -> fail("Should have thrown exception"), fieldType));
    ) throws IOException {
            for (int i = 0; i < dataNumber; i++) {
            new MatchAllDocsQuery(),
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());
            .missing("2015-11-13T16:14:34")
            new double[][] { { 1, 2 }, { 2, 3 } },
public class RangeAggregatorTests extends AggregatorTestCase {  
        }, range -> {
import org.apache.lucene.store.Directory;  
        );  
        }, range -> {  
    }  
            new MatchAllDocsQuery(),
        RangeAggregationBuilder aggregationBuilder,
            assertEquals(2, ranges.get(0).getDocCount());
    public void testMissingDateWithNumberField() throws IOException {  
    }
    public void testMatchesNumericDocValues() throws IOException {  
        }, true);
        long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();  
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();  
    public void testUnsupportedType() {
    /**
        List<Document> docs = new ArrayList<>();
    }
            .addRange(milli1 - 1, milli1 + 1);
import org.apache.lucene.index.Term;
        );
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                assertEquals("1.0-1.5", ranges.get(1).getKeyAsString());
                    query,
                    );
            pc = ranges.get(1).getAggregations().get("c");
                upper = d;
     * Expect optimization as top level query is effective match all.
    }
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());  
    }
            new NumberFieldType(NumberType.UNSIGNED_LONG.typeName(), NumberType.UNSIGNED_LONG),
                doc.add(fld);
            range -> {
            new Number[] { 0.1, 1.1, 2.1 },
            false,  
        AggregationBuilder builder,
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("does_not_exist")
        final String KEYWORD_FIELD_NAME = "route";
        double[][] ranges,
                assertEquals("2.0-3.0", ranges.get(1).getKeyAsString());  
            dataSet.put(new double[] { lower, upper }, data);
import org.apache.lucene.search.BooleanClause;  
        );  
                assertTrue(AggregationInspectionHelper.hasValue(range));
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
        docList.get(1).addAll(numType.createFields(numType.typeName(), 11.0, true, true, false, false));  
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
                    PipelineAggregator.PipelineTree.EMPTY  
            },
 * The OpenSearch Contributors require contributions made to  
                iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foo"))));
    ) throws IOException {  
                assertEquals(1, ranges.get(1).getDocCount());
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
            new double[][] { { Double.NEGATIVE_INFINITY, 1 }, { 2, Double.POSITIVE_INFINITY } },  
            .subAggregation(aggCardinality("c"));  
                    assertTrue(aggregator.getCollectCount().get() > 0);
            IllegalArgumentException.class,
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
    }
import java.util.Collections;  
        NumberFieldType fieldType = new NumberFieldType(NumberType.INTEGER.typeName(), NumberType.INTEGER);  
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
            range -> {
        }, range -> fail("Should have thrown exception"), fieldType));  
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
/*  
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 2)));  
                builder,  
            new NumberFieldType(NumberType.UNSIGNED_LONG.typeName(), NumberType.UNSIGNED_LONG),  
            new double[][] { { 1, 2 }, { 2, 3 } },  
        }, range -> fail("Should have thrown exception"), fieldType));
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field("not_a_number").addRange(-2d, 5d);  
                }  
        testRewriteOptimizationCase(
        builder.setMinimumNumberShouldMatch(0);  
        assertTrue(supportsIntraSegmentSearch(withSubDeclines));
                assertEquals("10.0-20.0", ranges.get(1).getKeyAsString());
            .addRange(0d, 5d)
            false,
        });
        );
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
 * this work for additional information regarding copyright
                assertEquals(2, ranges.size());  
                assertEquals(3, ranges.get(1).getDocCount());  
import java.util.Map;
                    aggregationBuilder.addRange(range[0], range[1]);
        Map<double[], double[]> dataSet = buildRandomRanges(new double[][] { { 0, 100 }, { 200, 1000 }, { 1000, 3000 } });
        MappedFieldType fieldType
        BooleanQuery.Builder builder = new BooleanQuery.Builder();  
    /**  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        testRewriteOptimizationCase(NUM_FIELD_TYPE, new double[][] { { 0.0, 10.0 }, { 10.0, 20.0 } }, boolQuery, docList, range -> {
            ranges,  
            // Missing will apply to this document
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 3)));
import java.util.LinkedList;
            .addRange(0d, 5d)
            .addRange(10d, 20d);
        final NumberType numType = NUM_FIELD_TYPE.numberType();
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
 * software distributed under the License is distributed on an
        simpleTestCase(aggregationBuilder, new MatchAllDocsQuery(), range -> {  
                assertEquals(1, ranges.get(1).getDocCount());  
                    assertEquals(0, aggregator.getCollectCount().get());  
        for (Map.Entry<double[], double[]> entry : dataSet.entrySet()) {
import org.apache.lucene.util.BytesRef;  
        // with a sub-aggregation AND fast path declines (overlapping ranges): intra-eligible (doc-by-doc parallelizes)  
    public void testMatchesSortedNumericDocValues() throws IOException {
        MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);  
            new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE),
            new double[][] { { 0.0, 10.0 }, { 10.0, 20.0 } },  
            createAggregator(
        // overlapping ranges, no sub-agg: fast path declines -> intra-eligible
        final NumberType numType = NUM_FIELD_TYPE.numberType();  
            new Number[] { 0.1, 4.0, 9, 11, 12, 19 },
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                assertEquals(1, ranges.get(0).getDocCount());
            range -> {  
    public void testSubAggCollectsFromSingleBucketIfOneRange() throws IOException {  
        Query query,
            true,  
                assertEquals(1, ranges.get(1).getDocCount());  
            assertEquals(1, ranges.get(0).getDocCount());
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
        testRewriteOptimizationCase(
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 2)));
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(DATE_FIELD_NAME)
            docs.add(doc);  
        testCase(aggregationBuilder, query, iw -> {
        docList.get(2).addAll(numType.createFields(numType.typeName(), 15.0, true, true, false, false));
    public void testRandomRanges() throws IOException {
                assertEquals(2, ranges.size());
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(DATE_FIELD_NAME)  
                assertEquals(size, rangeBuckets.size());
    private void testCase(
        docList.get(0).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
        List<Document> docList = new ArrayList<>();
            .subAggregation(aggCardinality("c"));
import java.util.concurrent.atomic.AtomicInteger;
            range -> {
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        boolean optimized  
    }  
            InternalAggCardinality pc = ranges.get(0).getAggregations().get("c");
    }
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();  
        long milli2 = ZonedDateTime.of(2016, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            .missing("bogus");
                    .addAggregator(builder)  
        testCase(new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("bogus_field_name", 7)));
     * The intra-segment gate for range (no sub-agg): partition only when the filter-rewrite O(1) fast path can  
            .addRange(0d, 10d)
        double[][] ranges = new double[size][];
     * @return Map [lower, upper) TO data points
            docList.add(new Document());
                assertEquals("2.0-*", ranges.get(1).getKeyAsString());
            assertTrue(AggregationInspectionHelper.hasValue(range));
            assertTrue(AggregationInspectionHelper.hasValue(range));
                }
            true  
        }, fieldType);
            new Number[] { 0.1, 1.1, 2.1 },
                );
            iw.addDocument(singleton(new SortedNumericDocValuesField(DATE_FIELD_NAME, milli2)));
            new MatchAllDocsQuery(),
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
            .missing(0L);
        );
            assertEquals(1, ranges.size());
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 2)));  
            new Number[] { 0, 1, 2 },
            .addRange(10d, 20d)
        // sub-agg but fast path applies (non-overlapping): NOT intra-eligible (BKD walk would duplicate per partition)
 *
                assertTrue(AggregationInspectionHelper.hasValue(range));
            assertEquals(0, ranges.get(0).getDocCount());
                } else {
    public void testUnmappedWithMissingNumber() throws IOException {
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/57651")
     * Expect no optimization as top level query excludes documents.
            assertEquals(2, ranges.get(0).getDocCount());  
        Query query,  
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();
            new Number[] { 0.1, 1.1, 2.1 },  
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify  
                CountingAggregator aggregator = createCountingAggregator(query, aggregationBuilder, indexSearcher, fieldType);
        DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD_NAME);  
import org.opensearch.index.mapper.KeywordFieldMapper;
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("range").field(NUMBER_FIELD_NAME)
            assertEquals(2, ranges.get(0).getDocCount());
        IllegalArgumentException e = expectThrows(
        testCase(new MatchAllDocsQuery(), iw -> {  
            assertEquals(2, ranges.get(0).getDocCount());
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
    }
            double[] data = new double[dataNumber];  
    public void testBadMissingField() {
import org.apache.lucene.document.NumericDocValuesField;
            () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
            false
                    assertEquals(expected[j], rangeBuckets.get(j).getDocCount());
import org.apache.lucene.tests.index.RandomIndexWriter;
        int i = 0;  
        });  
import org.opensearch.search.aggregations.InternalAggregation;
            .addRange(milli1 - 1, milli1 + 1);  
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,  
        for (int i = 0; i < 3; i++)  
            .addRange(-2d, 5d)
        docList.get(1).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));
        Query query,  
            )
                assertEquals("0.0-0.5", ranges.get(0).getKeyAsString());  
     * partition (false). It declines for overlapping ranges → partition (true). With a sub-agg it always opts in.
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    /**
            int dataNumber = randomInt(200);
            .addRange(0d, 12d)
        }, range -> {
            dataPoints.toArray(new Number[0]),
        RangeAggregationBuilder withSubFastPath = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)  
        return dataSet;
 *  
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {  
    }
                    Integer.MAX_VALUE,
                AggregatorFactories factories = AggregatorFactories.builder()
        double[][] ranges,  
            }
    private void simpleTestCase(  
            double lower = randomDoubleBetween(range[0], range[1], true);  
                assertTrue(AggregationInspectionHelper.hasValue(range));
                assertEquals("0.0-10.0", ranges.get(0).getKeyAsString());  
                assertEquals("*-1.0", ranges.get(0).getKeyAsString());  
        }, false);  
            true,
        testCase(new MatchAllDocsQuery(), iw -> {
 * Unless required by applicable law or agreed to in writing,
            new NumberFieldType(NumberType.HALF_FLOAT.typeName(), NumberType.HALF_FLOAT),
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            new NumberFieldType(NumberType.DOUBLE.typeName(), NumberType.DOUBLE),
        String fieldName = fieldType.numberType().typeName();
                assertEquals("1.0-2.0", ranges.get(2).getKeyAsString());
            .addRange(milli1 - 1, milli1 + 1);  
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        RangeAggregationBuilder nonOverlapping = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)  
        RangeAggregationBuilder aggregationBuilder = new RangeAggregationBuilder("test").field(NUMBER_FIELD_NAME)
        builder.setMinimumNumberShouldMatch(0);
                doAssertReducedMultiBucketConsumer(agg, reduceBucketConsumer);
        docList.get(1).add(new KeywordField(KEYWORD_FIELD_NAME, "route1", Field.Store.NO));  
            assertEquals(1, ranges.get(0).getDocCount());  
        aggregationBuilder.addRange(0d, 5d);
        }, fieldType);  
import org.opensearch.index.mapper.ParseContext.Document;  
import java.io.IOException;
                return factories.allFactoriesSupportIntraSegmentSearch();  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
            }  
 * under the License.  
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify
import org.apache.lucene.search.TermQuery;
    ) throws IOException {
            List<? extends InternalRange.Bucket> ranges = range.getBuckets();  
            assertEquals("10.0-20.0", ranges.get(1).getKeyAsString());  
            assertEquals(1, ranges.size());
 * SPDX-License-Identifier: Apache-2.0
        );
    }  
                        null
            .missing("bogus");
import org.apache.lucene.tests.util.TestUtil;
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));
    }
        docList.get(2).addAll(numType.createFields(numType.typeName(), 15.0, true, true, false, false));
import org.apache.lucene.index.DirectoryReader;
            true
        }, range -> {
            },
        Query boolQuery = builder.build();  
            assertTrue(AggregationInspectionHelper.hasValue(range));
            },  
                List<? extends InternalRange.Bucket> ranges = range.getBuckets();
        docList.get(0).addAll(numType.createFields(numType.typeName(), 3.0, true, true, false, false));
            .addRange(0d, 12d)
            assertEquals(2, ranges.size());  
            assertEquals(1, ranges.get(0).getDocCount());
            assertEquals(1, ranges.size());
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
            },
                assertEquals(1, ranges.get(0).getDocCount());
                assertEquals(1, ranges.get(0).getDocCount());
            i++;
            iw.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));  
                fieldTypes  
                assertEquals(1, ranges.get(0).getDocCount());
            DateFieldMapper.Resolution.NANOSECONDS,
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
            null,
            assertEquals(1, ranges.size());  
            Collections.emptyMap()  
                double d = lower;  
                assertTrue(AggregationInspectionHelper.hasValue(range));  
        Consumer<InternalRange<? extends InternalRange.Bucket, ? extends InternalRange>> verify,
        Query boolQuery = builder.build();
            DateFieldMapper.getDefaultDateTimeFormatter(),  
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 7)));
                ),
import org.apache.lucene.document.Field;
                MappedFieldType fieldType = new NumberFieldType(NUMBER_FIELD_NAME, NumberType.INTEGER);
                    indexSearcher,  
    private void testRewriteOptimizationCase(
     */
            buildIndex.accept(indexWriter);
            .addRange(-2d, 5d)  
                    DEFAULT_MAX_BUCKETS,  
        boolean optimized
            assertEquals(2, ranges.size());
        testRewriteOptimizationCase(
                verify.accept(agg);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        testRewriteOptimizationCase(
        });  
                    getMockScriptService(),
        List<Document> docList = new ArrayList<>();
            indexWriter.addDocument(singleton(new SortedNumericDocValuesField(NUMBER_FIELD_NAME, 7)));
 * specific language governing permissions and limitations
            .addRange(10d, 100d)  
            new double[][] { { 1, 2 }, { 1, 1.5 }, { 0, 0.5 } },  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.IndexWriter;  
                aggregator.postCollection();
import org.apache.lucene.search.Query;
                    indexWriter.addDocument(doc);
    private boolean supportsIntraSegmentSearch(RangeAggregationBuilder builder) throws IOException {
    public void testTopLevelRangeQuery() throws IOException {
            range -> {  
        testRewriteOptimizationCase(NUM_FIELD_TYPE, new double[][] { { 0.0, 10.0 }, { 10.0, 20.0 } }, boolQuery, docList, range -> {  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("not_a_number");
            iw.addDocument(singleton(new NumericDocValuesField(NUMBER_FIELD_NAME, 1)));  
    public void testUnsignedLongType() throws IOException {
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        long milli1 = ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
     */  
 * GitHub history for details.
    }
            },
import org.opensearch.index.mapper.DateFieldMapper;
