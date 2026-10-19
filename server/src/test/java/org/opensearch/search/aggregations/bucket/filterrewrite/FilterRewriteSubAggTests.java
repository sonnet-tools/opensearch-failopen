     * - Index sort on date field to enable skiplist functionality  
import org.opensearch.search.MultiValueMode;
        int min;
        assertEquals(2, secondBucket.getDocCount());  
import org.apache.lucene.search.BooleanClause;
        assertEquals(3, thirdStats.getMax(), 0);  
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();  
        assertEquals(6, buckets.size());  
import org.opensearch.search.aggregations.bucket.range.InternalRange;  
        thirdBucket = buckets.get(2);
        // Test for average metric aggregation now  
            .addRange(1, 2)
        InternalRange.Bucket firstBucket = buckets.get(0);  
            .calendarInterval(DateHistogramInterval.HOUR)  
        assertEquals("2020-03-01T01:00:00.000Z", secondBucket.getKeyAsString());
     * 1. HistogramSkiplistLeafCollector.collect() - skiplist-based document collection
    }
        InternalDateHistogram.Bucket fifthBucket = buckets.get(4);
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
        // matching documents. During BKD traversal the collector's activeIndex advances
        assertEquals(2, secondBucket.getDocCount());
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
            if (!subAggToVerify.containsKey(date)) {
                assertNotNull("Sub-aggregation should be present (verifies SubAggRangeCollector.collect() was called)", secondDate);
                doc.add(new LongPoint(longFieldName, 5));
        List<TestDoc> docs = new ArrayList<>();
import org.apache.lucene.search.SortField;
        assertEquals(3, buckets.size());
            for (int i = 0; i < 3; i++) {
                doc.add(new LongPoint(dateFieldName, timestamp));  
    private final String longFieldName = "metric";  
        dataset.put("2017-02-01T09:02:00.000Z", 512);
        InternalDateHistogram.Bucket secondBucket = buckets.get(1);
                                dateFieldType.parse(doc.timestamp.toString()),
                        indexWriter.addDocument(doc.toDocument());
            SubAggToVerify subAgg = subAggToVerify.get(date);
                                dateFieldName,  
        assertEquals(5, buckets.size());
                assertEquals(2, secondDate.getBuckets().size());
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(
    protected final DateFieldMapper.DateFieldType aggregableDateFieldType(boolean useNanosecondResolution, boolean isSearchable) {  
        return new MultiBucketConsumerService.MultiBucketConsumer(
        // Create searchable date field type (isSearchable=true) to enable skiplist
    private final String sumAggName = "sum";
        AggregationBuilder aggregationBuilder,
            if (!subAggToVerify.containsKey(date)) {
        try (IndexWriter indexWriter = new IndexWriter(directory, config)) {  
        return executeAggregationOnReader(indexReader, aggregationBuilder, null);
    /**  
            // First commit - documents for range bucket 1 (metric values 1-2)
            indexWriter.commit();
import org.opensearch.index.mapper.KeywordFieldMapper;
    /**
        InternalAvg thirdAvg = thirdBucket.getAggregations().get(avgAggName);
            DEFAULT_MAX_BUCKETS,
                IndexSearcher indexSearcher = new IndexSearcher(indexReader);  
                doc.add(new LongPoint(longFieldName, 4));
        Map<String, Integer> dataset = new HashMap<>();
            assertEquals(subAgg.max, stats.getMax(), 0);
        // Regression test for https://github.com/opensearch-project/OpenSearch/issues/22342  
            }
            .subAggregation(AggregationBuilders.cardinality(cardinalityAggName).field(nameFieldName).executionHint("ordinals"));
        private final Instant timestamp;
                InternalRange result = executeAggregationOnReader(indexReader, rangeAggregationBuilder, indexSettings);
     * - Documents distributed across multiple date ranges (2015-2017)  
    ) {
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
        IA topLevel = (IA) countingAggregator.buildTopLevel();  
        Query query
import org.opensearch.search.aggregations.AggregatorTestCase;  
        assertEquals("2020-03-01T02:00:00.000Z", thirdBucket.getKeyAsString());
        InternalMin firstMin = firstBucket.getAggregations().get(minAggName);  
import java.util.concurrent.atomic.AtomicInteger;
    }  
                indexWriter.addDocument(doc);
public class FilterRewriteSubAggTests extends AggregatorTestCase {
        return Settings.builder()
 */  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        // Verify results  
    private final String autoDateAggName = "auto";  
        rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
     * Helper method to parse date strings to long values
        InternalDateHistogram result = executeAggregation(docs, dateHistogramAggregationBuilder, false, rangeQuery);
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(  
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
    }
        List<TestDoc> docs,
                Instant instant = Instant.parse(date);
        InternalSum thirdSum = thirdBucket.getAggregations().get(sumAggName);  
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
        Histogram.Bucket firstBucket = buckets.get(0);  
        AutoDateHistogramAggregationBuilder autoDateHistogramAggregationBuilder = new AutoDateHistogramAggregationBuilder(dateAggName)
     * - Multiple segments created via explicit commits
                doc.add(new NumericDocValuesField(longFieldName, 5));
        new TestDoc(1, Instant.parse("2020-03-01T00:00:01Z"), "ghi"),
        InternalStats thirdStats = thirdBucket.getAggregations().get(statsAggName);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                indexWriter.addDocument(doc);  
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
        }
            subAgg.count = docCount;
            assertEquals(subAgg.min, stats.getMin(), 0);
                assertEquals(1, thirdDate.getBuckets().size());
            bucketConsumer,
            }  
            dateFieldName,
            SubAggToVerify subAgg = subAggToVerify.get(date);  
                InternalRange.Bucket secondBucket = buckets.get(1);
        Map<String, Integer> dataset = new HashMap<>();
            longFieldType,
import org.apache.lucene.search.IndexSearcher;
        Histogram.Bucket fifthBucket = buckets.get(4);
        assertEquals(2, thirdBucket.getDocCount());  
                    }
        IndexSettings indexSettings
import org.apache.lucene.index.NoMergePolicy;
import org.opensearch.search.aggregations.Aggregator;
            .addRange(2, 4)
import org.apache.lucene.search.MatchAllDocsQuery;
            indexSettings != null ? indexSettings : createIndexSettings(),
        Histogram.Bucket fourthBucket = buckets.get(3);  
import org.opensearch.index.fielddata.IndexNumericFieldData;  
        assertEquals(2, secondStats.getMin(), 0);
    /**
import org.opensearch.cluster.metadata.IndexMetadata;
            .addRange(4, 6)
                    .subAggregation(
    private <IA extends InternalAggregation> IA executeAggregationOnReader(  
            if (subAgg == null) continue;
        InternalStats secondStats = secondBucket.getAggregations().get(statsAggName);
        assertEquals(3, thirdStats.getMax(), 0);  
     *
package org.opensearch.search.aggregations.bucket.filterrewrite;
        assertEquals(3, secondMax.getValue(), 0);
    }
        assertEquals(1, firstStats.getMax(), 0);  
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
import org.opensearch.search.internal.SearchContext;  
        // past the end of the ranges array and traversal terminates early; the final  
    private Directory setupIndex(List<TestDoc> docs, boolean random) throws IOException {  
        InternalRange.Bucket firstBucket = buckets.get(0);  
            return doc;
    }
        for (int i = 0; i < 12; i++) {  
                doc.add(new LongPoint(dateFieldName, timestamp));
        InternalAvg secondAvg = secondBucket.getAggregations().get(avgAggName);
    private final String nameFieldName = "name";
                RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        dataset.put("2017-02-01T16:48:00.000Z", randomIntBetween(100, 2000));
        // and threw ArrayIndexOutOfBoundsException.
     * 2. HistogramSkiplistLeafCollector.advanceSkipper() - skiplist advancement with upToBucket logic
            // loop value times and generate TestDoc  
            assertEquals(1, stats.getCount());
            docs.add(new TestDoc(month, Instant.parse(String.format(Locale.ROOT, "2024-%02d-15T00:00:00Z", month))));
import org.opensearch.search.aggregations.metrics.InternalAvg;
        result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
            .addRange(1, 2)
                subAgg.max = Math.max(subAgg.max, docValue);
        assertEquals("2020-03-01T00:00:00.000Z", firstBucket.getKeyAsString());
        new TestDoc(1, Instant.parse("2020-03-01T00:00:00Z"), "def"),
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
    private <IA extends InternalAggregation> IA executeAggregation(
    }
            assertEquals(i + 1, stats.getSum(), 0);
        // Verify results
        for (Map.Entry<String, Integer> entry : dataset.entrySet()) {  
 * SPDX-License-Identifier: Apache-2.0
     * Test that verifies skiplist-based collection works correctly with range aggregations  
    private Settings getSettingsWithIndexSort() {
                long timestamp = asLong("2017-12-12T22:55:46Z", dateFieldType);
        }
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();  
    public void testRangeWithCard() throws IOException {  
import org.apache.lucene.tests.util.TestUtil;
                assertNotNull("Sub-aggregation should be present (verifies SubAggRangeCollector.collect() was called)", thirdDate);
import org.apache.lucene.tests.index.RandomIndexWriter;
            // Dates: 2015 (5 docs with metric=1)
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    /**
        List<TestDoc> docs,  
                // Range bucket 3: expect 7 docs, 1 date histogram bucket (2017)  
    }  
        countingAggregator.preCollection();
        );
        assertEquals(2, firstBucket.getDocCount());  
        assertEquals(3, buckets.size());
import org.opensearch.search.aggregations.InternalAggregation;
        InternalAggregation.ReduceContext context = createReduceContext(countingAggregator, reduceBucketConsumer);
        InternalCardinality thirdCardinality = thirdBucket.getAggregations().get(cardinalityAggName);
    private final String minAggName = "min";
        InternalRange.Bucket firstBucket = buckets.get(0);
            .subAggregation(new AutoDateHistogramAggregationBuilder(autoDateAggName).field(dateFieldName).setNumBuckets(3));
                doc.add(new LongPoint(longFieldName, 2));
 * compatible open source license.
        assertEquals(11, fifthStats.getSum(), 0);
        rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        firstBucket = buckets.get(0);
        }  
    ) throws IOException {
                long timestamp = asLong("2017-12-12T22:55:46Z", dateFieldType);
        doAssertReducedMultiBucketConsumer(result, reduceBucketConsumer);
        IndexWriterConfig config = new IndexWriterConfig();
            subAgg.count = docCount;
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                assertEquals(8, secondBucket.getDocCount());
            String date = entry.getKey();
            this.metric = metric;
import java.util.Map;  
        boolean random  
                // Range bucket 1: expect 5 docs, 1 date histogram bucket (2015)
        assertEquals(4, fourthStats.getMin(), 0);
        )
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
    private final String dateAggName = "date";
    }  
                doc.add(new NumericDocValuesField(longFieldName, 4));
        assertEquals(2, firstBucket.getDocCount());
        }).build(null, null);
            .subAggregation(AggregationBuilders.min(minAggName).field(longFieldName));
import java.io.IOException;
        InternalAutoDateHistogram result = executeAggregation(DEFAULT_DATA, autoDateHistogramAggregationBuilder, true);  
    }
                // Build RangeAggregationBuilder with DateHistogramAggregationBuilder sub-aggregation
        assertEquals(2, firstBucket.getDocCount());
        InternalDateHistogram.Bucket thirdBucket = buckets.get(2);
        indexSearcher.search(query, countingAggregator);
            nameFieldType
    private <IA extends InternalAggregation> IA executeAggregationOnReader(  
        Histogram.Bucket secondBucket = buckets.get(1);
                docs.add(new TestDoc(docValue, instant));
                assertEquals(3, buckets.size());
                    indexWriter.addDocument(doc.toDocument());
            indexSearcher,
import java.util.List;
        );
import org.apache.lucene.search.BooleanQuery;  
        private final boolean deleted;  
                            BooleanClause.Occur.MUST
        dataset.put("2017-02-01T10:00:00.001Z", 256);
            this.name = name;
    }  
            }
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));  
        assertEquals(4, fourthStats.getMin(), 0);  
        InternalStats firstStats = firstBucket.getAggregations().get(statsAggName);
        InternalMax firstMax = firstBucket.getAggregations().get(maxAggName);
        dataset.put("2017-02-01T13:06:00.000Z", 512);
        assertEquals(1, thirdStats.getCount());
    }  
        new TestDoc(6, Instant.parse("2020-03-01T04:00:00Z"), "stu")
    }  
        Aggregator aggregator,  
        IndexMetadata indexMetadata = IndexMetadata.builder("index").settings(settings).build();
            }
            for (int i = 0; i < 3; i++) {
        Aggregator aggregator = createAggregator(aggregationBuilder, searchContext);  
        dataset.put("2017-02-01T10:00:00.001Z", randomIntBetween(100, 2000));
        private final String name;
import java.util.ArrayList;
                assertEquals(5, firstDate.getBuckets().get(0).getDocCount());
import org.opensearch.index.IndexSettings;
            .addRange(2, 4)  
        assertEquals("2020-03-01T03:00:00.000Z", fourthBucket.getKeyAsString());
 * this file be licensed under the Apache-2.0 license or a
        List<TestDoc> docs = new ArrayList<>();  
                doc.add(new LongPoint(dateFieldName, timestamp));
        InternalRange.Bucket secondBucket = buckets.get(1);
    private <IA extends InternalAggregation> IA executeAggregationOnReader(
        try (Directory directory = setupIndex(docs, random)) {
import org.opensearch.Version;  
                // Range bucket 2: expect 8 docs, 2 date histogram buckets (2015, 2016)  
            }
        assertEquals(1, secondStats.getCount());  
        InternalDateHistogram.Bucket fourthBucket = buckets.get(3);
        InternalStats fourthStats = fourthBucket.getAggregations().get(statsAggName);
        return new DateFieldMapper.DateFieldType(
                    .addRange(1, 2)
    private InternalAggregation.ReduceContext createReduceContext(
    }
                Instant instant = Instant.parse(date);
        assertEquals(2, secondStats.getMax(), 0);
        dataset.put("2017-02-01T13:06:00.000Z", randomIntBetween(100, 2000));
            dateFieldName
                long timestamp = asLong("2016-03-04T17:09:50Z", dateFieldType);  
     * that have date histogram sub-aggregations.
        InternalRange.Bucket secondBucket = buckets.get(1);  
    ) throws IOException {
                            LongField.newRangeQuery(
    }
import org.opensearch.search.aggregations.AggregationBuilders;
    public void testRangeWithMinAndMax() throws IOException {
            null,
        List<? extends InternalDateHistogram.Bucket> buckets = result.getBuckets();
        assertEquals(3, firstStats.getCount());
        firstBucket = buckets.get(0);
            .field(dateFieldName)
        // docs beyond the query upper bound, in the same segment
            indexWriter.commit();  
        assertEquals(6, fifthStats.getMax(), 0);  
    private class TestDoc {
        int max;
            .addRange(4, 6)
        // Test for min metric aggregation  
        // Verify results  
    }
                    .addRange(2, 4)  
        ).calendarInterval(DateHistogramInterval.HOUR).subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
        )  
 * The OpenSearch Contributors require contributions made to  
            query,  
import org.apache.lucene.index.IndexWriterConfig;  
        new TestDoc(0, Instant.parse("2020-03-01T00:00:00Z"), "abc"),  
        AggregationBuilder aggregationBuilder,  
            .setNumBuckets(5)  
        InternalStats secondStats = secondBucket.getAggregations().get(statsAggName);
        InternalCardinality secondCardinality = secondBucket.getAggregations().get(cardinalityAggName);
                subAgg.min = Math.min(subAgg.min, docValue);  
                int docValue = randomIntBetween(0, 10_000);
     * Helper method to index documents in batches with commits for skiplist structure
            // Second commit - documents for range bucket 2 (metric values 2-4)
        assertEquals(3, firstBucket.getDocCount());
        assertEquals(2, secondBucket.getDocCount());
import org.opensearch.index.mapper.DateFieldMapper;
import org.apache.lucene.document.LongField;  
import org.opensearch.search.aggregations.metrics.InternalMax;
    }
            .addRange(1, 2)
            for (int i = 0; i < 4; i++) {
            assertEquals(subAgg.count, stats.getCount());  
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
            .addRange(1, 2)
        buckets = result.getBuckets();
        InternalRange.Bucket thirdBucket = buckets.get(2);
import org.opensearch.search.aggregations.metrics.InternalMin;
                indexWriter.addDocument(doc);  
    private final Query matchAllQuery = new MatchAllDocsQuery();  
                subAggToVerify.put(date, new SubAggToVerify());
        assertEquals(2.5, secondAvg.getValue(), 0);  
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
            .subAggregation(AggregationBuilders.max(maxAggName).field(longFieldName));  
            .addRange(4, 6)  
            .subAggregation(AggregationBuilders.sum(sumAggName).field(longFieldName));
        return result;  
    private final KeywordFieldMapper.KeywordFieldType nameFieldType = new KeywordFieldMapper.KeywordFieldType(nameFieldName);  
                }
        new TestDoc(4, Instant.parse("2020-03-01T03:00:00Z"), "mno"),
        assertEquals(3, firstStats.getCount());
        assertEquals(2, secondStats.getMax(), 0);  
        InternalMax thirdMax = thirdBucket.getAggregations().get(maxAggName);
        assertEquals(2, thirdBucket.getDocCount());  
            this.deleted = deleted;
import org.apache.lucene.index.IndexWriter;
        InternalStats fifthStats = fifthBucket.getAggregations().get(statsAggName);
            .addRange(1, 2)  
        assertEquals(3, buckets.size());
            .minDocCount(1L)
        assertEquals(1, firstStats.getMax(), 0);
        new TestDoc(3, Instant.parse("2020-03-01T02:00:00Z"), "jkl"),
        assertEquals(1, fourthBucket.getDocCount());  
        InternalMax secondMax = secondBucket.getAggregations().get(maxAggName);  
        }  
        assertEquals("2020-03-01T00:00:00.000Z", firstBucket.getKeyAsString());
                assertEquals(1, firstDate.getBuckets().size());  
            indexWriter.commit();
        assertEquals(0, firstStats.getMin(), 0);
            // Third commit - documents for range bucket 3 (metric values 4-6)  
            .addRange(4, 6)  
        assertEquals(1, thirdBucket.getDocCount());  
        assertEquals(1, firstAvg.getValue(), 0);
            }  
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogram;
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
        assertEquals(1, thirdStats.getCount());
        countingAggregator.postCollection();  
     */
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = createBucketConsumer();
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();  
        private final long metric;  
        for (InternalDateHistogram.Bucket bucket : buckets) {
        }
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();  
    public void testAutoDateHisto() throws IOException {  
            // Index documents in batches with commits to create multiple segments
        for (InternalDateHistogram.Bucket bucket : buckets) {
    private static class SubAggToVerify {  
}  
        assertEquals(2, fifthStats.getCount());
        assertEquals(3, thirdStats.getMin(), 0);
        return new MultiBucketConsumerService.MultiBucketConsumer(
        assertEquals(2, secondStats.getMin(), 0);
    private final List<TestDoc> DEFAULT_DATA = List.of(
            .addRange(4, 6)
        // Create sort field for index sort
            .calendarInterval(DateHistogramInterval.MONTH)
        assertEquals(1, secondStats.getCount());
        assertEquals(2, secondStats.getSum(), 0);
        assertEquals(6, fifthStats.getMax(), 0);
import org.apache.lucene.document.NumericDocValuesField;
        InternalStats thirdStats = thirdBucket.getAggregations().get(statsAggName);
            ParseContext.Document doc = new ParseContext.Document();  
     */  
        List<? extends Histogram.Bucket> buckets = result.getBuckets();  
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(  
        assertEquals("Expect not using collect to do aggregation", 0, countingAggregator.getCollectCount().get());
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
            }
        secondBucket = buckets.get(1);  
            InternalStats stats = bucket.getAggregations().get(statsAggName);
            try (DirectoryReader indexReader = DirectoryReader.open(directory)) {  
        DirectoryReader indexReader,
        dataset.put("2017-02-01T14:04:00.000Z", 256);  
        SearchContext searchContext = createSearchContext(  
        assertEquals(3, buckets.size());
        assertEquals(3, secondAuto.getBuckets().size());
        return directory;  
        assertEquals(5, secondSum.getValue(), 0);
    }
                InternalDateHistogram thirdDate = thirdBucket.getAggregations().get(dateAggName);  
        assertEquals(2, firstAuto.getBuckets().size());  
        // Verify results
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {  
            .calendarInterval(DateHistogramInterval.HOUR)  
     * - Searchable date field type
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();
        public TestDoc(long metric, Instant timestamp) {
        new TestDoc(2, Instant.parse("2020-03-01T01:00:00Z"), "jkl"),  
        for (Map.Entry<String, Integer> entry : dataset.entrySet()) {  
            .addRange(1, 2)
            int docCount = entry.getValue();
    public void testRandom() throws IOException {  
        assertEquals(0, firstStats.getMin(), 0);  
        }
     */  
        new TestDoc(4, Instant.parse("2020-03-01T04:00:00Z"), "prq", true),  
            if (subAgg == null) continue;
                return executeAggregationOnReader(indexReader, aggregationBuilder, null, query);
                                dateFieldType.parse(doc.timestamp.toString())
            InternalStats stats = bucket.getAggregations().get(statsAggName);  
        InternalRange.Bucket thirdBucket = buckets.get(2);
        InternalRange.Bucket secondBucket = buckets.get(1);
        DirectoryReader indexReader,
        }  
        // Documents with values beyond the query's upper bound share the segment with
        // Test for sum metric aggregation
            this(metric, timestamp, name, false);
            for (int i = 0; i < 5; i++) {  
            assertEquals(subAgg.min, stats.getMin(), 0);
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
        dataset.put("2017-02-01T16:06:00.000Z", randomIntBetween(100, 2000));  
import java.time.Instant;  
        public ParseContext.Document toDocument() {
            }  
/*  
    private final String rangeAggName = "range";
        Settings settings = getSettingsWithIndexSort();
    public void testDateHistoWithDocsBeyondQueryUpperBound() throws IOException {
        boolean random,
            // Dates: 2015-2016 (5 docs with metric=2, 3 docs with metric=3)  
            String date = entry.getKey();
        InternalDateHistogram result = executeAggregation(docs, dateHistogramAggregationBuilder, true);
            Integer.MAX_VALUE,  
        assertEquals(5, fifthStats.getMin(), 0);
        DirectoryReader indexReader,
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;  
        assertEquals(1, firstMin.getValue(), 0);
        assertEquals("2020-03-01T02:00:00.000Z", thirdBucket.getKeyAsString());
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)  
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
        assertEquals(3, thirdAuto.getBuckets().size());
        assertEquals(1, thirdBucket.getDocCount());  
                    .addRange(4, 6)
        }  
        assertEquals(2, fifthBucket.getDocCount());
                for (TestDoc doc : docs) {
    private void indexDocsForSkiplist(Directory directory, DateFieldMapper.DateFieldType dateFieldType) throws IOException {
        assertEquals(1, firstMax.getValue(), 0);
        assertEquals(1, fourthStats.getCount());
        assertEquals(4, fourthStats.getMax(), 0);
                InternalDateHistogram secondDate = secondBucket.getAggregations().get(dateAggName);  
            useNanosecondResolution ? DateFieldMapper.Resolution.NANOSECONDS : DateFieldMapper.Resolution.MILLISECONDS,
                    if (!doc.deleted) {  
        buckets = result.getBuckets();
            dateFieldName
        IndexSettings indexSettings,  
import org.opensearch.common.settings.Settings;
        assertEquals(2, firstStats.getSum(), 0);
        assertEquals(3, thirdStats.getSum(), 0);
            for (Field fld : fieldList)  
                        new DateHistogramAggregationBuilder(dateAggName).field(dateFieldName).calendarInterval(DateHistogramInterval.YEAR)  
        assertEquals(3, thirdStats.getMin(), 0);
            SubAggToVerify subAgg = subAggToVerify.get(date);
                doc.add(new NumericDocValuesField(longFieldName, 1));
    public void testDateHisto() throws IOException {
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
        InternalRange.Bucket firstBucket = buckets.get(0);
            }  
        Histogram.Bucket thirdBucket = buckets.get(2);
        InternalMin secondMin = secondBucket.getAggregations().get(minAggName);
        public TestDoc(long metric, Instant timestamp, String name, boolean deleted) {
        }
        InternalSum firstSum = firstBucket.getAggregations().get(sumAggName);
        assertEquals(2, secondBucket.getDocCount());  
        InternalRange.Bucket secondBucket = buckets.get(1);  
                indexWriter.addDocument(doc);
        DateFieldMapper.DateFieldType searchableDateFieldType = aggregableDateFieldType(false, true);  
        Query query  
            String date = bucket.getKeyAsString();
     * 3. SubAggRangeCollector.collect() - sub-aggregation collection path  
        assertEquals(2, thirdBucket.getDocCount());
import org.opensearch.index.mapper.ParseContext;
        }  
     *
import org.apache.lucene.document.LongPoint;
     * Helper method to create Settings with index sort on date field for skiplist testing
            for (int i = 0; i < docCount; i++) {  
            assertEquals(1, bucket.getDocCount());
                InternalRange.Bucket thirdBucket = buckets.get(2);
                indexWriter.addDocument(doc);
        List<TestDoc> docs = new ArrayList<>();
        InternalRange.Bucket thirdBucket = buckets.get(2);
                }  
import org.apache.lucene.search.Query;  
            .addRange(2, 4)  
        dataset.put("2017-02-01T14:05:00.000Z", randomIntBetween(100, 2000));
        InternalStats firstStats = firstBucket.getAggregations().get(statsAggName);  
        assertEquals(4, fourthStats.getMax(), 0);  
                // Use YEAR interval to align with our test data structure (2015, 2016, 2017)  
    ) throws IOException {  
        assertEquals(1, secondBucket.getDocCount());  
        assertEquals(4, thirdMin.getValue(), 0);
        InternalDateHistogram result = executeAggregation(DEFAULT_DATA, dateHistogramAggregationBuilder, false);
        if (!random) {
        assertEquals("2020-03-01T04:00:00.000Z", fifthBucket.getKeyAsString());
            List<Field> fieldList = numberType.createFields(longFieldName, metric, true, true, false, false);
        IndexNumericFieldData fieldData = (IndexNumericFieldData) dateFieldType.fielddataBuilder("index", () -> {  
                        booleanQueryBuilder.add(
                // Verify results - this confirms skiplist collection worked correctly  
            for (int i = 0; i < 5; i++) {
                long timestamp = asLong("2015-11-13T16:14:34Z", dateFieldType);  
    private MultiBucketConsumerService.MultiBucketConsumer createBucketConsumer() {  
    private final String avgAggName = "avg";  
        docs.add(new TestDoc(101, Instant.parse("2025-02-15T00:00:00Z")));  
        assertEquals(5, buckets.size());  
import java.util.HashMap;  
     * This test exercises the following code paths:  
            doc.add(new KeywordField(nameFieldName, name, Field.Store.NO));  
            assertEquals(subAgg.count, stats.getCount());  
        // Setup index with skiplist configuration  
import org.apache.lucene.store.Directory;  
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = new DateHistogramAggregationBuilder(dateAggName).field(  
        )
        Map<String, SubAggToVerify> subAggToVerify = new HashMap<>();
        InternalSum secondSum = secondBucket.getAggregations().get(sumAggName);
    );
            .build();
            reduceBucketConsumer,  
                List<? extends InternalRange.Bucket> buckets = result.getBuckets();
        // Reduce results
            for (int i = 0; i < docCount; i++) {  
                assertEquals(3, secondDate.getBuckets().get(1).getDocCount());
                assertEquals(5, firstBucket.getDocCount());  
        } else {  
import org.apache.lucene.search.Sort;
        dataset.put("2017-02-01T15:59:00.000Z", randomIntBetween(100, 2000));
        assertEquals(3, buckets.size());
        InternalCardinality firstCardinality = firstBucket.getAggregations().get(cardinalityAggName);  
                subAgg.max = Math.max(subAgg.max, docValue);
        assertEquals(2, fifthStats.getCount());  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
    private MultiBucketConsumerService.MultiBucketConsumer createReduceBucketConsumer() {
import org.opensearch.core.common.breaker.CircuitBreaker;  
        assertEquals(1, fourthBucket.getDocCount());
        config.setMergePolicy(NoMergePolicy.INSTANCE);  
        assertEquals(5, fifthStats.getMin(), 0);
    }
            dateFieldName
import org.opensearch.search.aggregations.metrics.InternalStats;  
                subAggToVerify.put(date, new SubAggToVerify());
        );
                doc.add(new LongPoint(longFieldName, 3));
            .putList("index.sort.field", dateFieldName)  
     * The test uses:
        // Verify results  
            SubAggToVerify subAgg = subAggToVerify.get(date);  
        InternalAvg firstAvg = firstBucket.getAggregations().get(avgAggName);  
            isSearchable,  
            true,
            try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {
    }  
            dateFieldType,  
    }
    public void testRange() throws IOException {
                            ),  
                // Create IndexSearcher with the reader
        List<? extends InternalRange.Bucket> buckets = result.getBuckets();
        assertEquals(12, buckets.size());
import org.apache.lucene.index.DirectoryReader;
        secondBucket = buckets.get(1);
        assertEquals(1, fourthStats.getCount());
        Directory directory = newDirectory();
                doc.add(new NumericDocValuesField(longFieldName, 2));  
        InternalStats fourthStats = fourthBucket.getAggregations().get(statsAggName);  
        return executeAggregationOnReader(indexReader, aggregationBuilder, indexSettings, matchAllQuery);  
        InternalStats fifthStats = fifthBucket.getAggregations().get(statsAggName);
import org.apache.lucene.document.Field;
        assertEquals(2, thirdBucket.getDocCount());
            .addRange(2, 4)
        assertEquals(2, firstBucket.getDocCount());
            DateFieldMapper.getDefaultDateTimeFormatter(),  
    );  
            }  
        InternalAutoDateHistogram thirdAuto = thirdBucket.getAggregations().get(autoDateAggName);  
                assertEquals(7, thirdDate.getBuckets().get(0).getDocCount());  
                assertEquals(5, secondDate.getBuckets().get(0).getDocCount());  
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);  
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
        dataset.put("2017-02-01T09:02:00.000Z", randomIntBetween(100, 2000));
                assertEquals(7, thirdBucket.getDocCount());
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)
            indexDocsForSkiplist(directory, searchableDateFieldType);
            PipelineAggregator.PipelineTree.EMPTY
    ) throws IOException {
        assertEquals("2020-03-01T01:00:00.000Z", secondBucket.getKeyAsString());  
        // Execute aggregation  
                doc.add(fld);
            dateFieldName
            InternalDateHistogram.Bucket bucket = buckets.get(i);
        public TestDoc(long metric, Instant timestamp, String name) {  
                indexWriter.commit();
        assertEquals(2, secondBucket.getDocCount());
            aggregator.context().bigArrays(),
                    );
        // Verify results
        }  
import org.opensearch.search.aggregations.metrics.InternalSum;
        assertEquals(2, firstSum.getValue(), 0);  
        assertEquals("2020-03-01T03:00:00.000Z", fourthBucket.getKeyAsString());
        assertEquals(2, secondBucket.getDocCount());
    private final NumberFieldMapper.NumberFieldType longFieldType = new NumberFieldMapper.NumberFieldType(
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
        dataset.put("2017-02-01T14:05:00.000Z", 256);
            }
        );
import java.util.Collections;
        assertEquals("2020-03-01T04:00:00.000Z", fifthBucket.getKeyAsString());  
            }  
    }
    }
    private final String maxAggName = "max";  
            try (DirectoryReader indexReader = DirectoryReader.open(directory)) {
            .addRange(4, 6)
        );
                    }
                for (TestDoc doc : docs) {
    public void testRangeWithAvgAndSum() throws IOException {
        Map<String, SubAggToVerify> subAggToVerify = new HashMap<>();
                // Verify we have multiple segments (required for skiplist testing)
                InternalDateHistogram firstDate = firstBucket.getAggregations().get(dateAggName);
        dataset.put("2017-02-01T14:04:00.000Z", randomIntBetween(100, 2000));  
                doc.add(new LongPoint(dateFieldName, timestamp));  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.index.mapper.NumberFieldMapper;  
        longFieldName,
            .addRange(2, 4)  
        Query rangeQuery = LongPoint.newRangeQuery(dateFieldName, Long.MIN_VALUE, dateFieldType.parse("2024-12-31T23:59:59Z"));
        return InternalAggregation.ReduceContext.forFinalReduction(  
    private final NumberFieldMapper.NumberType numberType = longFieldType.numberType();
        InternalAutoDateHistogram secondAuto = secondBucket.getAggregations().get(autoDateAggName);
        CountingAggregator countingAggregator = new CountingAggregator(new AtomicInteger(), aggregator);
            this(metric, timestamp, "abc", false);  
            // Dates: 2017 (4 docs with metric=4, 3 docs with metric=5)
        return executeAggregation(docs, aggregationBuilder, random, matchAllQuery);
        return fieldType.parse(dateTime);
        SortField sortField = fieldData.sortField(null, MultiValueMode.MIN, null, false);  
        assertEquals(5, thirdMax.getValue(), 0);  
        // Use custom index setup instead of setupIndex() method
        InternalDateHistogram result = executeAggregation(docs, dateHistogramAggregationBuilder, false);
        try (Directory directory = newDirectory()) {  
        RangeAggregationBuilder rangeAggregationBuilder = new RangeAggregationBuilder(rangeAggName).field(longFieldName)  
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
 *
    private <IA extends InternalAggregation> IA executeAggregation(  
            .addRange(2, 4)
        // Verify results
            }  
        InternalRange.Bucket thirdBucket = buckets.get(2);
        assertEquals(1, secondCardinality.getValue(), 0);  
                doc.add(new NumericDocValuesField(longFieldName, 3));  
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));  
        int count;  
        }
            .subAggregation(AggregationBuilders.avg(avgAggName).field(longFieldName));
        IA result = (IA) topLevel.reduce(Collections.singletonList(topLevel), context);
     */
        InternalAutoDateHistogram firstAuto = firstBucket.getAggregations().get(autoDateAggName);
        config.setIndexSort(new Sort(sortField));
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = createReduceBucketConsumer();
    ) throws IOException {
import org.opensearch.search.aggregations.metrics.InternalCardinality;  
            int docCount = entry.getValue();
        assertEquals(5, buckets.size());
                int docValue = randomIntBetween(0, 10_000);
                doc.add(SortedNumericDocValuesField.indexedField(dateFieldName, timestamp));
            .minDocCount(1L)
                doc.add(new LongPoint(longFieldName, 1));  
                doc.add(new LongPoint(dateFieldName, timestamp));
        AggregationBuilder aggregationBuilder
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
import org.opensearch.search.aggregations.AggregationBuilder;  
        assertEquals(1, secondBucket.getDocCount());
    }
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);  
        for (int month = 1; month <= 12; month++) {
                        booleanQueryBuilder.add(LongPoint.newRangeQuery(longFieldName, doc.metric, doc.metric), BooleanClause.Occur.MUST);  
                long timestamp = asLong("2015-02-13T13:09:32Z", dateFieldType);
        dataset.put("2017-02-01T16:59:00.000Z", randomIntBetween(100, 2000));
        InternalDateHistogram.Bucket firstBucket = buckets.get(0);
            .minDocCount(1L)
        InternalRange result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);  
                docs.add(new TestDoc(docValue, instant));
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        assertEquals(3, firstBucket.getDocCount());  
                indexWriter.commit();
        assertEquals(2, firstBucket.getDocCount());
                for (TestDoc doc : docs) {  
            Collections.emptyMap()  
        assertEquals(2, thirdCardinality.getValue(), 0);
                subAgg.min = Math.min(subAgg.min, docValue);  
    private final String dateFieldName = "timestamp";
        assertEquals(2, fifthBucket.getDocCount());  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                    if (doc.deleted) {
        }  
        assertEquals(3, buckets.size());  
    public void testRangeDate() throws IOException {
        // Verify results  
    private final DateFieldMapper.DateFieldType dateFieldType = aggregableDateFieldType(false, true);
        dataset.put("2017-02-01T09:59:59.999Z", randomIntBetween(100, 2000));  
        thirdBucket = buckets.get(2);  
    private final String cardinalityAggName = "cardinality";
        new TestDoc(5, Instant.parse("2020-03-01T04:00:00Z"), "stu"),
        NumberFieldMapper.NumberType.LONG  
        AggregationBuilder aggregationBuilder,
        // Test for max metric aggregation now
            throw new UnsupportedOperationException();
            .subAggregation(AggregationBuilders.stats(statsAggName).field(longFieldName));
        assertEquals(2, thirdBucket.getDocCount());
                }  
            getMockScriptService(),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(9, thirdSum.getValue(), 0);
            assertEquals(subAgg.max, stats.getMax(), 0);
        dataset.put("2017-02-01T15:59:00.000Z", 768);
        assertEquals(4.5, thirdAvg.getValue(), 0);
        assertEquals(2, firstCardinality.getValue(), 0);
            this.timestamp = timestamp;  
            // loop value times and generate TestDoc  
        assertEquals(2, firstBucket.getDocCount());
            doc.add(new LongField(dateFieldName, dateFieldType.parse(timestamp.toString()), Field.Store.NO));
        assertEquals(2, secondMin.getValue(), 0);  
        }  
import java.util.Locale;
        assertEquals(4, fourthStats.getSum(), 0);
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer
        InternalMin thirdMin = thirdBucket.getAggregations().get(minAggName);
    private final String statsAggName = "stats";
import org.apache.lucene.document.KeywordField;
            InternalStats stats = bucket.getAggregations().get(statsAggName);
        docs.add(new TestDoc(100, Instant.parse("2025-01-15T00:00:00Z")));
                InternalRange.Bucket firstBucket = buckets.get(0);
        dataset.put("2017-02-01T09:59:59.999Z", 256);  
                assertTrue("Should have multiple segments for skiplist testing", indexReader.leaves().size() > 1);  
                // Execute aggregation on reader with IndexSettings (enables skiplist)  
            false,
    public void testLeafTraversal() throws IOException {  
        AggregationBuilder aggregationBuilder,
                assertNotNull("Sub-aggregation should be present (verifies SubAggRangeCollector.collect() was called)", firstDate);
            }
        // finalizePreviousRange() then looked up the bucket for activeIndex == ranges.size
            String date = bucket.getKeyAsString();
        result = executeAggregation(DEFAULT_DATA, rangeAggregationBuilder, true);
                        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
    }
                        indexWriter.deleteDocuments(booleanQueryBuilder.build());  
        assertEquals(2, thirdBucket.getDocCount());  
    }
                        );
import org.apache.lucene.document.SortedNumericDocValuesField;  
    private long asLong(String dateTime, DateFieldMapper.DateFieldType fieldType) {  
