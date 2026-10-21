     * that have date histogram sub-aggregations.
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
        DirectoryReader indexReader,
        AggregationBuilder aggregationBuilder,
        private final String name;
        InternalDateHistogram result = executeAggregation(docs, dateHistogramAggregationBuilder, true);
            this(metric, timestamp, name, false);
                            BooleanClause.Occur.MUST
            SubAggToVerify subAgg = subAggToVerify.get(date);
                    if (doc.deleted) {
        secondBucket = buckets.get(1);
        InternalRange.Bucket firstBucket = buckets.get(0);
        thirdBucket = buckets.get(2);
        IndexNumericFieldData fieldData = (IndexNumericFieldData) dateFieldType.fielddataBuilder("index", () -> {
        assertEquals(2, fifthBucket.getDocCount());
        assertEquals(1, firstAvg.getValue(), 0);
            .putList("index.sort.field", dateFieldName)
        assertEquals(4.5, thirdAvg.getValue(), 0);
            }
        InternalRange.Bucket secondBucket = buckets.get(1);
        secondBucket = buckets.get(1);
        for (Map.Entry<String, Integer> entry : dataset.entrySet()) {
                doc.add(new LongPoint(longFieldName, 5));
        return executeAggregationOnReader(indexReader, aggregationBuilder, null);
        dataset.put("2017-02-01T09:02:00.000Z", 512);
        }
            query,
        assertEquals(1, thirdBucket.getDocCount());
        dataset.put("2017-02-01T09:59:59.999Z", 256);
    private final String sumAggName = "sum";
        CountingAggregator countingAggregator = new CountingAggregator(new AtomicInteger(), aggregator);
        InternalRange.Bucket secondBucket = buckets.get(1);
                docs.add(new TestDoc(docValue, instant));
        assertEquals(3, thirdStats.getMax(), 0);
                InternalRange result = executeAggregationOnReader(indexReader, rangeAggregationBuilder, indexSettings);
    public void testDateHistoWithDocsBeyondQueryUpperBound() throws IOException {
        return fieldType.parse(dateTime);
                doc.add(new NumericDocValuesField(longFieldName, 1));
        InternalDateHistogram.Bucket fourthBucket = buckets.get(3);
        }
            ParseContext.Document doc = new ParseContext.Document();
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
            }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .addRange(4, 6)
import org.apache.lucene.search.Query;
        DirectoryReader indexReader,
import org.apache.lucene.search.IndexSearcher;
        assertEquals(1, firstStats.getMax(), 0);
        firstBucket = buckets.get(0);
                for (TestDoc doc : docs) {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.lucene.document.Field;
        return new DateFieldMapper.DateFieldType(
     * 2. HistogramSkiplistLeafCollector.advanceSkipper() - skiplist advancement with upToBucket logic
        assertEquals(2, fifthStats.getCount());
                // Verify we have multiple segments (required for skiplist testing)
        private final long metric;
        int min;
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
 * this file be licensed under the Apache-2.0 license or a
        // Test for max metric aggregation now
        assertEquals(2, firstBucket.getDocCount());
    public void testAutoDateHisto() throws IOException {
                            ),
import org.opensearch.index.mapper.ParseContext;
        AggregationBuilder aggregationBuilder,
        Histogram.Bucket firstBucket = buckets.get(0);
    }
                assertEquals(5, firstBucket.getDocCount());
        InternalCardinality secondCardinality = secondBucket.getAggregations().get(cardinalityAggName);
        public TestDoc(long metric, Instant timestamp, String name, boolean deleted) {
                assertEquals(7, thirdDate.getBuckets().get(0).getDocCount());
                doc.add(new LongPoint(longFieldName, 2));
        // finalizePreviousRange() then looked up the bucket for activeIndex == ranges.size
            aggregator.context().bigArrays(),
                // Build RangeAggregationBuilder with DateHistogramAggregationBuilder sub-aggregation
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = createReduceBucketConsumer();
        InternalDateHistogram.Bucket firstBucket = buckets.get(0);
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram;
            // Second commit - documents for range bucket 2 (metric values 2-4)
        Histogram.Bucket secondBucket = buckets.get(1);
        assertEquals(2, thirdBucket.getDocCount());
        assertEquals(4, thirdMin.getValue(), 0);
    public void testRandom() throws IOException {
                List<? extends InternalRange.Bucket> buckets = result.getBuckets();
            dateFieldName
    }
            for (int i = 0; i < 5; i++) {
     * - Searchable date field type
            .subAggregation(AggregationBuilders.min(minAggName).field(longFieldName));
        for (int month = 1; month <= 12; month++) {
            DateFieldMapper.getDefaultDateTimeFormatter(),
     * Helper method to parse date strings to long values
            // First commit - documents for range bucket 1 (metric values 1-2)
}
        // Verify results
        public TestDoc(long metric, Instant timestamp) {
                }
        assertEquals("2020-03-01T00:00:00.000Z", firstBucket.getKeyAsString());
            useNanosecondResolution ? DateFieldMapper.Resolution.NANOSECONDS : DateFieldMapper.Resolution.MILLISECONDS,
        assertEquals(1, secondBucket.getDocCount());
        assertEquals(1, secondStats.getCount());
 * SPDX-License-Identifier: Apache-2.0
            // Dates: 2017 (4 docs with metric=4, 3 docs with metric=5)
        new TestDoc(6, Instant.parse("2020-03-01T04:00:00Z"), "stu")
                subAggToVerify.put(date, new SubAggToVerify());
            indexDocsForSkiplist(directory, searchableDateFieldType);
import java.time.Instant;
                long timestamp = asLong("2015-11-13T16:14:34Z", dateFieldType);
        countingAggregator.preCollection();
        Map<String, Integer> dataset = new HashMap<>();
        InternalStats fifthStats = fifthBucket.getAggregations().get(statsAggName);
    ) throws IOException {
        // Setup index with skiplist configuration
     */
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();
    private <IA extends InternalAggregation> IA executeAggregationOnReader(
        }
                        booleanQueryBuilder.add(LongPoint.newRangeQuery(longFieldName, doc.metric, doc.metric), BooleanClause.Occur.MUST);
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(
            DEFAULT_MAX_BUCKETS,
 * The OpenSearch Contributors require contributions made to
        assertEquals(2, thirdBucket.getDocCount());
    }
    public void testDateHisto() throws IOException {
        private final boolean deleted;
                assertEquals(1, thirdDate.getBuckets().size());
        private final Instant timestamp;
            try (DirectoryReader indexReader = DirectoryReader.open(directory)) {
            .build();
import org.opensearch.search.aggregations.metrics.InternalAvg;
        // Execute aggregation
import org.opensearch.common.settings.Settings;
        assertEquals(2, thirdCardinality.getValue(), 0);
        Map<String, SubAggToVerify> subAggToVerify = new HashMap<>();
    protected final DateFieldMapper.DateFieldType aggregableDateFieldType(boolean useNanosecondResolution, boolean isSearchable) {
            doc.add(new KeywordField(nameFieldName, name, Field.Store.NO));
            .addRange(2, 4)
            assertEquals(subAgg.max, stats.getMax(), 0);
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
            for (int i = 0; i < 4; i++) {
        }
                // Range bucket 2: expect 8 docs, 2 date histogram buckets (2015, 2016)
        assertEquals(6, buckets.size());
import org.apache.lucene.document.LongField;
        InternalRange.Bucket thirdBucket = buckets.get(2);
    private long asLong(String dateTime, DateFieldMapper.DateFieldType fieldType) {
        assertEquals("2020-03-01T00:00:00.000Z", firstBucket.getKeyAsString());
        InternalRange.Bucket thirdBucket = buckets.get(2);
        for (Map.Entry<String, Integer> entry : dataset.entrySet()) {
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
            .addRange(1, 2)
                assertNotNull("Sub-aggregation should be present (verifies SubAggRangeCollector.collect() was called)", thirdDate);
        assertEquals(1, fourthBucket.getDocCount());
        assertEquals(2, secondStats.getMin(), 0);
                assertEquals(8, secondBucket.getDocCount());
        assertEquals(2, secondBucket.getDocCount());
    private final String dateFieldName = "timestamp";
                // Use YEAR interval to align with our test data structure (2015, 2016, 2017)
import org.apache.lucene.document.LongPoint;
                }
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();
        // Verify results
        for (InternalDateHistogram.Bucket bucket : buckets) {
                for (TestDoc doc : docs) {
                // Create IndexSearcher with the reader
        assertEquals("Expect not using collect to do aggregation", 0, countingAggregator.getCollectCount().get());
import org.opensearch.search.aggregations.metrics.InternalMin;
                doc.add(new NumericDocValuesField(longFieldName, 2));
        Settings settings = getSettingsWithIndexSort();
    }
     * The test uses:
            }
                int docValue = randomIntBetween(0, 10_000);
import org.opensearch.search.aggregations.InternalAggregation;
    private final NumberFieldMapper.NumberType numberType = longFieldType.numberType();
        assertEquals(4, fourthStats.getMin(), 0);
        );
            // Index documents in batches with commits to create multiple segments
    }
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
        new TestDoc(4, Instant.parse("2020-03-01T04:00:00Z"), "prq", true),
        assertEquals(2, secondStats.getSum(), 0);
        try (IndexWriter indexWriter = new IndexWriter(directory, config)) {
            dateFieldType,
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(
    private final NumberFieldMapper.NumberFieldType longFieldType = new NumberFieldMapper.NumberFieldType(
            docs.add(new TestDoc(month, Instant.parse(String.format(Locale.ROOT, "2024-%02d-15T00:00:00Z", month))));
        InternalRange.Bucket secondBucket = buckets.get(1);
    }
                RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        InternalAutoDateHistogram secondAuto = secondBucket.getAggregations().get(autoDateAggName);
                assertTrue("Should have multiple segments for skiplist testing", indexReader.leaves().size() > 1);
        );
                // Verify results - this confirms skiplist collection worked correctly
                doc.add(new LongPoint(dateFieldName, timestamp));
        )
        assertEquals(2, thirdBucket.getDocCount());
    ) throws IOException {
    }
import org.apache.lucene.tests.index.RandomIndexWriter;
        }
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
    private final DateFieldMapper.DateFieldType dateFieldType = aggregableDateFieldType(false, true);
        assertEquals(5, secondSum.getValue(), 0);
                Instant instant = Instant.parse(date);
        InternalMax firstMax = firstBucket.getAggregations().get(maxAggName);
                subAgg.max = Math.max(subAgg.max, docValue);
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
import org.opensearch.index.fielddata.IndexNumericFieldData;
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = createBucketConsumer();
        assertEquals(3, thirdStats.getMin(), 0);
    private Settings getSettingsWithIndexSort() {
            }
        }
            }
        assertEquals(5, thirdMax.getValue(), 0);
    private static class SubAggToVerify {
                subAgg.min = Math.min(subAgg.min, docValue);
            Collections.emptyMap()
    ) throws IOException {
        // Test for min metric aggregation
        // Documents with values beyond the query's upper bound share the segment with
                InternalRange.Bucket thirdBucket = buckets.get(2);
            subAgg.count = docCount;
        assertEquals(6, fifthStats.getMax(), 0);
import org.apache.lucene.document.KeywordField;
        assertEquals(2, secondBucket.getDocCount());
            }
        for (InternalDateHistogram.Bucket bucket : buckets) {
                // Range bucket 3: expect 7 docs, 1 date histogram bucket (2017)
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
        assertEquals(2, secondMin.getValue(), 0);
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {
            .addRange(2, 4)
                        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
        Histogram.Bucket thirdBucket = buckets.get(2);
        assertEquals(4, fourthStats.getMax(), 0);
        List<TestDoc> docs,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    .addRange(4, 6)
    private final String minAggName = "min";
        dataset.put("2017-02-01T10:00:00.001Z", randomIntBetween(100, 2000));
        // Create sort field for index sort
            dateFieldName,
        buckets = result.getBuckets();
        assertEquals(2, secondBucket.getDocCount());
        InternalSum secondSum = secondBucket.getAggregations().get(sumAggName);
                indexWriter.addDocument(doc);
        try (Directory directory = setupIndex(docs, random)) {
            .minDocCount(1L)
                    );
            .subAggregation(AggregationBuilders.cardinality(cardinalityAggName).field(nameFieldName).executionHint("ordinals"));
        InternalRange.Bucket firstBucket = buckets.get(0);
     * - Multiple segments created via explicit commits
import java.util.concurrent.atomic.AtomicInteger;
        new TestDoc(5, Instant.parse("2020-03-01T04:00:00Z"), "stu"),
     * Helper method to create Settings with index sort on date field for skiplist testing
            List<Field> fieldList = numberType.createFields(longFieldName, metric, true, true, false, false);
        assertEquals(3, buckets.size());
import org.opensearch.search.aggregations.AggregatorTestCase;
        assertEquals(3, firstBucket.getDocCount());
                }
     */
        dataset.put("2017-02-01T13:06:00.000Z", randomIntBetween(100, 2000));
import java.io.IOException;
    private Directory setupIndex(List<TestDoc> docs, boolean random) throws IOException {
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(
        assertEquals(1, thirdStats.getCount());
            this.metric = metric;
            assertEquals(i + 1, stats.getSum(), 0);
        ).calendarInterval(DateHistogramInterval.HOUR).subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
        }
        assertEquals(3, buckets.size());
            assertEquals(subAgg.min, stats.getMin(), 0);
        dataset.put("2017-02-01T14:05:00.000Z", 256);
    }
        assertEquals(1, firstStats.getMax(), 0);
                doc.add(new NumericDocValuesField(longFieldName, 3));
        }
            assertEquals(1, stats.getCount());
import org.opensearch.index.mapper.KeywordFieldMapper;
    );
    private final String avgAggName = "avg";
        Aggregator aggregator,
                assertEquals(7, thirdBucket.getDocCount());
        return result;
            throw new UnsupportedOperationException();
    private <IA extends InternalAggregation> IA executeAggregationOnReader(
        InternalStats fifthStats = fifthBucket.getAggregations().get(statsAggName);
        assertEquals(2, secondStats.getMin(), 0);
                for (TestDoc doc : docs) {
        InternalRange.Bucket thirdBucket = buckets.get(2);
        // Verify results
            }
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
            .subAggregation(AggregationBuilders.sum(sumAggName).field(longFieldName));
        assertEquals(6, fifthStats.getMax(), 0);
    private <IA extends InternalAggregation> IA executeAggregationOnReader(
            if (!subAggToVerify.containsKey(date)) {
        AggregationBuilder aggregationBuilder
        }).build(null, null);
        InternalDateHistogram result = executeAggregation(DEFAULT_DATA, dateHistogramAggregationBuilder, false);
            assertEquals(subAgg.count, stats.getCount());
        assertEquals(2, firstBucket.getDocCount());
    ) {
        Query rangeQuery = LongPoint.newRangeQuery(dateFieldName, Long.MIN_VALUE, dateFieldType.parse("2024-12-31T23:59:59Z"));
        assertEquals(2, fifthStats.getCount());
                assertEquals(5, firstDate.getBuckets().get(0).getDocCount());
    private InternalAggregation.ReduceContext createReduceContext(
        // Verify results
            assertEquals(subAgg.max, stats.getMax(), 0);
                doc.add(fld);
     */
                long timestamp = asLong("2015-02-13T13:09:32Z", dateFieldType);
        InternalDateHistogram.Bucket fifthBucket = buckets.get(4);
                        indexWriter.deleteDocuments(booleanQueryBuilder.build());
        assertEquals(1, secondBucket.getDocCount());
        dataset.put("2017-02-01T16:48:00.000Z", randomIntBetween(100, 2000));
import org.opensearch.search.aggregations.AggregationBuilder;
        new TestDoc(1, Instant.parse("2020-03-01T00:00:01Z"), "ghi"),
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
    }
            for (int i = 0; i < 5; i++) {
            .addRange(1, 2)
        assertEquals(2, firstAuto.getBuckets().size());
import org.opensearch.search.aggregations.metrics.InternalMax;
        List<TestDoc> docs,
        List<TestDoc> docs = new ArrayList<>();
                assertNotNull("Sub-aggregation should be present (verifies SubAggRangeCollector.collect() was called)", firstDate);
            .addRange(4, 6)
        List<? extends Histogram.Bucket> buckets = result.getBuckets();
    private <IA extends InternalAggregation> IA executeAggregation(
                doc.add(new NumericDocValuesField(longFieldName, 4));
                subAggToVerify.put(date, new SubAggToVerify());
            .addRange(2, 4)
        assertEquals(1, secondStats.getCount());
    ) throws IOException {
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
            indexSearcher,
import java.util.ArrayList;
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
import org.opensearch.search.aggregations.metrics.InternalCardinality;
                InternalDateHistogram thirdDate = thirdBucket.getAggregations().get(dateAggName);
                        new DateHistogramAggregationBuilder(dateAggName).field(dateFieldName).calendarInterval(DateHistogramInterval.YEAR)
        }
        assertEquals(3, thirdStats.getMin(), 0);
                assertNotNull("Sub-aggregation should be present (verifies SubAggRangeCollector.collect() was called)", secondDate);
            return doc;
import java.util.Locale;
        indexSearcher.search(query, countingAggregator);
        assertEquals(2, secondBucket.getDocCount());
        // Regression test for https://github.com/opensearch-project/OpenSearch/issues/22342
        assertEquals("2020-03-01T02:00:00.000Z", thirdBucket.getKeyAsString());
        dataset.put("2017-02-01T15:59:00.000Z", randomIntBetween(100, 2000));
        int max;
            .calendarInterval(DateHistogramInterval.HOUR)
    public void testRangeWithMinAndMax() throws IOException {
                subAgg.min = Math.min(subAgg.min, docValue);
    private class TestDoc {
    }
                    }
     * Test that verifies skiplist-based collection works correctly with range aggregations
        // matching documents. During BKD traversal the collector's activeIndex advances
            assertEquals(1, bucket.getDocCount());
        IndexWriterConfig config = new IndexWriterConfig();
    ) throws IOException {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
            // loop value times and generate TestDoc
                long timestamp = asLong("2017-12-12T22:55:46Z", dateFieldType);
                indexWriter.addDocument(doc);
        InternalDateHistogram.Bucket secondBucket = buckets.get(1);
        assertEquals("2020-03-01T03:00:00.000Z", fourthBucket.getKeyAsString());
        assertEquals(1, fourthBucket.getDocCount());
import org.opensearch.index.mapper.NumberFieldMapper;
            String date = entry.getKey();
        DateFieldMapper.DateFieldType searchableDateFieldType = aggregableDateFieldType(false, true);
/*
    }
    private final String cardinalityAggName = "cardinality";
        // Verify results
        InternalStats fourthStats = fourthBucket.getAggregations().get(statsAggName);
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
import java.util.HashMap;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                assertEquals(5, secondDate.getBuckets().get(0).getDocCount());
        assertEquals(5, fifthStats.getMin(), 0);
        assertEquals(11, fifthStats.getSum(), 0);
    }
    }
                doc.add(new LongPoint(dateFieldName, timestamp));
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
            }
        InternalStats firstStats = firstBucket.getAggregations().get(statsAggName);
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriterConfig;
                assertEquals(1, firstDate.getBuckets().size());
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(
        config.setIndexSort(new Sort(sortField));
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);
    private MultiBucketConsumerService.MultiBucketConsumer createReduceBucketConsumer() {
        InternalStats secondStats = secondBucket.getAggregations().get(statsAggName);
import org.opensearch.Version;
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
        assertEquals(9, thirdSum.getValue(), 0);
            isSearchable,
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
                        indexWriter.addDocument(doc.toDocument());
        InternalMax thirdMax = thirdBucket.getAggregations().get(maxAggName);
        dataset.put("2017-02-01T14:04:00.000Z", 256);
        DirectoryReader indexReader,
public class FilterRewriteSubAggTests extends AggregatorTestCase {
        assertEquals("2020-03-01T04:00:00.000Z", fifthBucket.getKeyAsString());
            indexSettings != null ? indexSettings : createIndexSettings(),
import org.opensearch.index.mapper.DateFieldMapper;
        new TestDoc(3, Instant.parse("2020-03-01T02:00:00Z"), "jkl"),
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
        assertEquals(5, fifthStats.getMin(), 0);
            }
        assertEquals(12, buckets.size());
        dataset.put("2017-02-01T09:02:00.000Z", randomIntBetween(100, 2000));
    /**
        IndexSettings indexSettings
            InternalStats stats = bucket.getAggregations().get(statsAggName);
import java.util.Map;
import org.opensearch.search.aggregations.Aggregator;
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
            // Dates: 2015 (5 docs with metric=1)
            for (int i = 0; i < docCount; i++) {
                InternalDateHistogram secondDate = secondBucket.getAggregations().get(dateAggName);
        docs.add(new TestDoc(101, Instant.parse("2025-02-15T00:00:00Z")));
            reduceBucketConsumer,
        dataset.put("2017-02-01T14:05:00.000Z", randomIntBetween(100, 2000));
        SearchContext searchContext = createSearchContext(
import org.apache.lucene.search.Sort;
                doc.add(new LongPoint(dateFieldName, timestamp));
        Directory directory = newDirectory();
                long timestamp = asLong("2016-03-04T17:09:50Z", dateFieldType);
                indexWriter.addDocument(doc);
            this.name = name;
        boolean random
            String date = bucket.getKeyAsString();
        Histogram.Bucket fifthBucket = buckets.get(4);
            .subAggregation(AggregationBuilders.max(maxAggName).field(longFieldName));
                indexWriter.commit();
            .minDocCount(1L)
import org.opensearch.search.aggregations.bucket.range.InternalRange;
            InternalStats stats = bucket.getAggregations().get(statsAggName);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        // past the end of the ranges array and traversal terminates early; the final
import org.opensearch.search.MultiValueMode;
    }
            assertEquals(subAgg.min, stats.getMin(), 0);
import org.opensearch.search.aggregations.metrics.InternalStats;
        IndexSettings indexSettings,
                        booleanQueryBuilder.add(
import org.apache.lucene.index.NoMergePolicy;
            .subAggregation(new AutoDateHistogramAggregationBuilder(autoDateAggName).field(dateFieldName).setNumBuckets(3));
            for (int i = 0; i < 3; i++) {
    private final KeywordFieldMapper.KeywordFieldType nameFieldType = new KeywordFieldMapper.KeywordFieldType(nameFieldName);
        assertEquals(1, fourthStats.getCount());
import java.util.List;
        AggregationBuilder aggregationBuilder,
        InternalMin firstMin = firstBucket.getAggregations().get(minAggName);
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
        dataset.put("2017-02-01T16:59:00.000Z", randomIntBetween(100, 2000));
            }
                InternalDateHistogram firstDate = firstBucket.getAggregations().get(dateAggName);
            try (DirectoryReader indexReader = DirectoryReader.open(directory)) {
        InternalStats fourthStats = fourthBucket.getAggregations().get(statsAggName);
            getMockScriptService(),
            int docCount = entry.getValue();
                subAgg.max = Math.max(subAgg.max, docValue);
            .addRange(4, 6)
 */
    public void testRange() throws IOException {
            if (subAgg == null) continue;
        return new MultiBucketConsumerService.MultiBucketConsumer(
        InternalSum thirdSum = thirdBucket.getAggregations().get(sumAggName);
    private final String statsAggName = "stats";
                Instant instant = Instant.parse(date);
        assertEquals(2, secondBucket.getDocCount());
        rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        countingAggregator.postCollection();
    private final String longFieldName = "metric";
        return Settings.builder()
                    .addRange(2, 4)
            .addRange(2, 4)
        InternalAvg firstAvg = firstBucket.getAggregations().get(avgAggName);
        assertEquals(2, secondStats.getMax(), 0);
        assertEquals(2, firstBucket.getDocCount());
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertEquals(4, fourthStats.getMax(), 0);
            .addRange(1, 2)
 *
     * Helper method to index documents in batches with commits for skiplist structure
                indexWriter.commit();
            .minDocCount(1L)
        }
        assertEquals(2, firstBucket.getDocCount());
        InternalDateHistogram result = executeAggregation(docs, dateHistogramAggregationBuilder, false, rangeQuery);
        InternalRange.Bucket secondBucket = buckets.get(1);
        List<TestDoc> docs = new ArrayList<>();
            if (subAgg == null) continue;
                    .addRange(1, 2)
        InternalAggregation.ReduceContext context = createReduceContext(countingAggregator, reduceBucketConsumer);
        thirdBucket = buckets.get(2);
        InternalAvg thirdAvg = thirdBucket.getAggregations().get(avgAggName);
        doAssertReducedMultiBucketConsumer(result, reduceBucketConsumer);
        new TestDoc(2, Instant.parse("2020-03-01T01:00:00Z"), "jkl"),
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
            SubAggToVerify subAgg = subAggToVerify.get(date);
            this.timestamp = timestamp;
            .addRange(4, 6)
        } else {
     *
import org.opensearch.search.internal.SearchContext;
            int docCount = entry.getValue();
                assertEquals(2, secondDate.getBuckets().size());
        assertEquals(5, buckets.size());
                        );
                // Range bucket 1: expect 5 docs, 1 date histogram bucket (2015)
        new TestDoc(4, Instant.parse("2020-03-01T03:00:00Z"), "mno"),
    /**
        assertEquals("2020-03-01T01:00:00.000Z", secondBucket.getKeyAsString());
                assertEquals(3, buckets.size());
        }
        assertEquals(1, fourthStats.getCount());
                    }
    private final String maxAggName = "max";
        assertEquals(5, buckets.size());
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            // Dates: 2015-2016 (5 docs with metric=2, 3 docs with metric=3)
    public void testRangeDate() throws IOException {
        NumberFieldMapper.NumberType.LONG
        Aggregator aggregator = createAggregator(aggregationBuilder, searchContext);
            SubAggToVerify subAgg = subAggToVerify.get(date);
        // Use custom index setup instead of setupIndex() method
        buckets = result.getBuckets();
        InternalAutoDateHistogram thirdAuto = thirdBucket.getAggregations().get(autoDateAggName);
            for (int i = 0; i < 3; i++) {
                InternalRange.Bucket firstBucket = buckets.get(0);
        new TestDoc(0, Instant.parse("2020-03-01T00:00:00Z"), "abc"),
        Histogram.Bucket fourthBucket = buckets.get(3);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
import org.apache.lucene.search.SortField;
                indexWriter.addDocument(doc);
                return executeAggregationOnReader(indexReader, aggregationBuilder, null, query);
            longFieldType,
        assertEquals(2, fifthBucket.getDocCount());
        InternalStats secondStats = secondBucket.getAggregations().get(statsAggName);
        // Create searchable date field type (isSearchable=true) to enable skiplist
                doc.add(new LongPoint(longFieldName, 4));
        // and threw ArrayIndexOutOfBoundsException.
        config.setMergePolicy(NoMergePolicy.INSTANCE);
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import java.util.Collections;
    }
    private final List<TestDoc> DEFAULT_DATA = List.of(
import org.opensearch.search.aggregations.AggregationBuilders;
        )
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        );
        dataset.put("2017-02-01T16:06:00.000Z", randomIntBetween(100, 2000));
    public void testRangeWithCard() throws IOException {
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
                    if (!doc.deleted) {
        assertEquals(2, thirdBucket.getDocCount());
            // loop value times and generate TestDoc
    private final String rangeAggName = "range";
        InternalStats thirdStats = thirdBucket.getAggregations().get(statsAggName);
        return executeAggregationOnReader(indexReader, aggregationBuilder, indexSettings, matchAllQuery);
        InternalRange.Bucket firstBucket = buckets.get(0);
        InternalSum firstSum = firstBucket.getAggregations().get(sumAggName);
     *
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        InternalCardinality firstCardinality = firstBucket.getAggregations().get(cardinalityAggName);
        // Test for average metric aggregation now
            assertEquals(subAgg.count, stats.getCount());
            PipelineAggregator.PipelineTree.EMPTY
        Map<String, Integer> dataset = new HashMap<>();
    private MultiBucketConsumerService.MultiBucketConsumer createBucketConsumer() {
            indexWriter.commit();
                doc.add(new NumericDocValuesField(longFieldName, 5));
        result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
import org.apache.lucene.search.MatchAllDocsQuery;
        InternalStats thirdStats = thirdBucket.getAggregations().get(statsAggName);
        assertEquals(3, buckets.size());
     * 3. SubAggRangeCollector.collect() - sub-aggregation collection path
        // docs beyond the query upper bound, in the same segment
    private final String autoDateAggName = "auto";
     * - Index sort on date field to enable skiplist functionality
        assertEquals(3, thirdStats.getSum(), 0);
        )
        }
import org.apache.lucene.index.IndexWriter;
            .subAggregation(AggregationBuilders.avg(avgAggName).field(longFieldName));
                docs.add(new TestDoc(docValue, instant));
        InternalMin secondMin = secondBucket.getAggregations().get(minAggName);
    private <IA extends InternalAggregation> IA executeAggregation(
            true,
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
            nameFieldType
            .addRange(4, 6)
        }
                doc.add(new LongPoint(longFieldName, 1));
        int count;
        return executeAggregation(docs, aggregationBuilder, random, matchAllQuery);
            this(metric, timestamp, "abc", false);
        dataset.put("2017-02-01T14:04:00.000Z", randomIntBetween(100, 2000));
        docs.add(new TestDoc(100, Instant.parse("2025-01-15T00:00:00Z")));
        InternalMax secondMax = secondBucket.getAggregations().get(maxAggName);
        assertEquals(1, thirdStats.getCount());
        assertEquals(3, firstStats.getCount());
            .addRange(2, 4)
    }
import org.apache.lucene.tests.util.TestUtil;
        Map<String, SubAggToVerify> subAggToVerify = new HashMap<>();
        InternalMin thirdMin = thirdBucket.getAggregations().get(minAggName);
    }
            bucketConsumer,
import org.apache.lucene.search.BooleanQuery;
        assertEquals(2, firstBucket.getDocCount());
        Query query
        assertEquals(2, firstStats.getSum(), 0);
                                dateFieldType.parse(doc.timestamp.toString()),
        assertEquals(3, thirdStats.getMax(), 0);
        assertEquals(1, firstMin.getValue(), 0);
            indexWriter.commit();
        return directory;
            doc.add(new LongField(dateFieldName, dateFieldType.parse(timestamp.toString()), Field.Store.NO));
        assertEquals("2020-03-01T01:00:00.000Z", secondBucket.getKeyAsString());
        assertEquals(3, secondMax.getValue(), 0);
        assertEquals(3, firstStats.getCount());
        // Verify results
    private final String nameFieldName = "name";
        // Verify results
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
            InternalStats stats = bucket.getAggregations().get(statsAggName);
                doc.add(new LongPoint(dateFieldName, timestamp));
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
        longFieldName,
                // Execute aggregation on reader with IndexSettings (enables skiplist)
            dateFieldName
    /**
            .addRange(1, 2)
            // Third commit - documents for range bucket 3 (metric values 4-6)
            false,
        assertEquals(5, buckets.size());
                    indexWriter.addDocument(doc.toDocument());
            .addRange(2, 4)
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
        if (!random) {
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {
    }
            }
    }
        // Reduce results
            this.deleted = deleted;
        // Test for sum metric aggregation
        assertEquals(3, thirdAuto.getBuckets().size());
            .addRange(1, 2)
    }
            indexWriter.commit();
    }
    }
import org.apache.lucene.search.BooleanClause;
            Integer.MAX_VALUE,
        assertEquals(1, secondCardinality.getValue(), 0);
        return new MultiBucketConsumerService.MultiBucketConsumer(
            InternalDateHistogram.Bucket bucket = buckets.get(i);
        IA result = (IA) topLevel.reduce(Collections.singletonList(topLevel), context);
import org.apache.lucene.store.Directory;
        InternalAutoDateHistogram result = executeAggregation(DEFAULT_DATA, autoDateHistogramAggregationBuilder, true);
            String date = entry.getKey();
        assertEquals(2, thirdBucket.getDocCount());
        }
            .addRange(1, 2)
        InternalRange.Bucket firstBucket = buckets.get(0);
            .addRange(4, 6)
            .field(dateFieldName)
            .calendarInterval(DateHistogramInterval.HOUR)
 * compatible open source license.
                                dateFieldType.parse(doc.timestamp.toString())
            }
        IA topLevel = (IA) countingAggregator.buildTopLevel();
    }
                doc.add(new LongPoint(longFieldName, 3));
    private final String dateAggName = "date";
                long timestamp = asLong("2017-12-12T22:55:46Z", dateFieldType);
        InternalDateHistogram result = executeAggregation(docs, dateHistogramAggregationBuilder, false);
        assertEquals(3, buckets.size());
    private final Query matchAllQuery = new MatchAllDocsQuery();
    public void testLeafTraversal() throws IOException {
        assertEquals(2, secondBucket.getDocCount());
            .setNumBuckets(5)
                int docValue = randomIntBetween(0, 10_000);
        assertEquals(2, firstBucket.getDocCount());
            subAgg.count = docCount;
        public TestDoc(long metric, Instant timestamp, String name) {
        public ParseContext.Document toDocument() {
        assertEquals(1, firstMax.getValue(), 0);
            for (Field fld : fieldList)
            if (!subAggToVerify.containsKey(date)) {
            .calendarInterval(DateHistogramInterval.MONTH)
        List<TestDoc> docs = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
        assertEquals(3, secondAuto.getBuckets().size());
    }
import org.apache.lucene.document.SortedNumericDocValuesField;
        boolean random,
     * This test exercises the following code paths:
            dateFieldName
                assertEquals(3, secondDate.getBuckets().get(1).getDocCount());
                                dateFieldName,
        assertEquals(3, buckets.size());
        rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        assertEquals(2, thirdBucket.getDocCount());
    }
        AutoDateHistogramAggregationBuilder autoDateHistogramAggregationBuilder = new AutoDateHistogramAggregationBuilder(dateAggName)
        assertEquals(2, secondStats.getMax(), 0);
        InternalAvg secondAvg = secondBucket.getAggregations().get(avgAggName);
    private void indexDocsForSkiplist(Directory directory, DateFieldMapper.DateFieldType dateFieldType) throws IOException {
                    .subAggregation(
            for (int i = 0; i < docCount; i++) {
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
package org.opensearch.search.aggregations.bucket.filterrewrite;
        assertEquals(3, buckets.size());
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        firstBucket = buckets.get(0);
                            LongField.newRangeQuery(
        assertEquals(2.5, secondAvg.getValue(), 0);
    /**
                InternalRange.Bucket secondBucket = buckets.get(1);
import org.opensearch.search.aggregations.metrics.InternalSum;
            SubAggToVerify subAgg = subAggToVerify.get(date);
        try (Directory directory = newDirectory()) {
     */
    );
        assertEquals(4, fourthStats.getMin(), 0);
        InternalAutoDateHistogram firstAuto = firstBucket.getAggregations().get(autoDateAggName);
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();
        InternalCardinality thirdCardinality = thirdBucket.getAggregations().get(cardinalityAggName);
        assertEquals("2020-03-01T04:00:00.000Z", fifthBucket.getKeyAsString());
        dataset.put("2017-02-01T15:59:00.000Z", 768);
import org.apache.lucene.document.NumericDocValuesField;
        InternalStats firstStats = firstBucket.getAggregations().get(statsAggName);
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
        assertEquals(4, fourthStats.getSum(), 0);
        assertEquals(0, firstStats.getMin(), 0);
            String date = bucket.getKeyAsString();
        result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
                indexWriter.addDocument(doc);
                doc.add(new LongPoint(dateFieldName, timestamp));
import org.opensearch.index.IndexSettings;
        SortField sortField = fieldData.sortField(null, MultiValueMode.MIN, null, false);
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     * 1. HistogramSkiplistLeafCollector.collect() - skiplist-based document collection
        assertEquals(3, firstBucket.getDocCount());
        assertEquals(2, firstCardinality.getValue(), 0);
        assertEquals(2, firstSum.getValue(), 0);
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            }
import org.opensearch.core.common.breaker.CircuitBreaker;
    public void testRangeWithAvgAndSum() throws IOException {
        dataset.put("2017-02-01T13:06:00.000Z", 512);
        InternalRange.Bucket thirdBucket = buckets.get(2);
        assertEquals(0, firstStats.getMin(), 0);
        );
        // Verify results
        InternalDateHistogram.Bucket thirdBucket = buckets.get(2);
        dataset.put("2017-02-01T09:59:59.999Z", randomIntBetween(100, 2000));
        dataset.put("2017-02-01T10:00:00.001Z", 256);
        AggregationBuilder aggregationBuilder,
            null,
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
     * - Documents distributed across multiple date ranges (2015-2017)
            }
        Query query
        new TestDoc(1, Instant.parse("2020-03-01T00:00:00Z"), "def"),
        assertEquals("2020-03-01T03:00:00.000Z", fourthBucket.getKeyAsString());
        assertEquals("2020-03-01T02:00:00.000Z", thirdBucket.getKeyAsString());
            dateFieldName
        assertEquals(1, thirdBucket.getDocCount());
        return InternalAggregation.ReduceContext.forFinalReduction(
