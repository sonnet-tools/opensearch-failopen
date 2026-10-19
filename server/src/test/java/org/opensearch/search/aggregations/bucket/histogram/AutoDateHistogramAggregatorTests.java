            }
        }
    }
                n++;
            InternalAutoDateHistogram adh = a.getAggregations().get("dh");  
                .numberOfShards(1)
            for (long d = start; d < end; d += anHour) {  
            indexWriter.addDocument(List.of(new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-02-01T00:00:00Z"))));  
        );
        // sub-agg but fast path applies (UTC): NOT intra-eligible (BKD walk would duplicate per partition)
        final int numDocs = randomIntBetween(20, 200);  
            expectedMax.clear();
            iw.addDocuments(docs);
     */  
import java.time.ZoneOffset;
        for (int minute = 3; minute < 15; minute++) {  
            ZonedDateTime.of(2017, 2, 1, 10, 15, 0, 0, ZoneOffset.UTC),
                assertTrue(Double.isInfinite(stats.getMin()));
        expectedDocCount.put("2017-02-01T00:00:07.000Z", 2);
import org.opensearch.index.IndexSettings;
                assertEquals(expectedSize, buckets.size());
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            assertThat(maxAsMap(cdh), equalTo(expectedMax));
        Map<String, Integer> expectedDocCount = new TreeMap<>();
     * fast path can NOT apply upfront. Fast path applies for a searchable, UTC, top-level agg → do not partition
        // Add data spanning months to trigger rounding increase
                document.add(new SortedNumericDocValuesField(DATE_FIELD, instant));
        final int length = 300;
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 * software distributed under the License is distributed on an
        );
                aggregationBuilder.setNumBuckets(3).field(DATE_FIELD).timeZone(ZoneId.of("America/New_York"));  
        expectedDocCount.put("2013-01-01T00:00:00.000Z", 2);
 * Modifications Copyright OpenSearch Contributors. See
        );  
    public void testSkiplistCollectorRoundingChangeWithSubAggs() throws IOException {  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                new AutoDateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
        }
        AutoDateHistogramAggregationBuilder aggregation = new AutoDateHistogramAggregationBuilder("_name").setNumBuckets(10)  
            datesForMinuteInterval,  
/*  
        return map;
            for (int n = 0; n < 100; n++) {
        if (randomChoice == 1) {
 * not use this file except in compliance with the License.
    }
        fullDocCount.put("2017-02-01T09:07:00.000Z", 0);
            NumberFieldMapper.NumberFieldType nft = new NumberFieldMapper.NumberFieldType("n", NumberFieldMapper.NumberType.LONG);
                assertEquals(8, buckets.size());
            for (int i = 1; i < buckets.size(); i++) {
                assertEquals(3L, stats.getCount());  
     * Test that verifies skiplist and non-skiplist collectors produce identical results.
        expectedDocCount.put("2017-02-04T00:00:00.000-01:00", 1);  
                // Verify buckets were created
                final Histogram.Bucket bucket = buckets.get(randomIndex);
                        new SortedNumericDocValuesField(AGGREGABLE_DATE, d),  
        // Create dataset that triggers rounding change
        ZonedDateTime start = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
                final int randomIndex = randomInt(length - 1);  
 */  
            assertThat(bucketCountsAsMap(bk1adh), equalTo(expectedDocCount));
            }
            dataset.add(startDate.plusSeconds(randomOffset / 1000));  
                    assertThat(((InternalMax) histo.getBuckets().get(i).aggregations.get("max")).getValue(), equalTo((double) i));
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        );
                bucketWith.getDocCount()
                    .field(AGGREGABLE_DATE)
         */
            InternalAutoDateHistogram bdh = b.getAggregations().get("dh");
            ZonedDateTime.of(2017, 2, 1, 16, 48, 0, 0, ZoneOffset.UTC),
    @Override
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
import java.util.Map;
        bucketsToExpectedDocCountMap.put(6, 12);
        bucketsToExpectedDocCountMap.put(5, 100);
            aggregation -> aggregation.setNumBuckets(8).field(DATE_FIELD),
            DEFAULT_QUERY,
        }, fieldType);
        expectedDocCount.clear();  
                expectedMax.put("2020-01-01T00:00:00.000Z", (double) n);  
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2);
import java.util.HashMap;
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
    public void testWithPipelineReductions() throws IOException {  
            DEFAULT_QUERY,
            final long instant = date.toInstant().toEpochMilli();  
    }
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
        expectedDocCount.put("2017-02-01T00:00:00.000Z", 2);
            List<List<IndexableField>> docs = new ArrayList<>();
        expectedDocCount.put("2017-02-01T12:00:00.000Z", 0);
                assertFalse(AggregationInspectionHelper.hasValue(stats));
            StringTerms.Bucket ak1a = ak1.getBucketByKey("a");
            DEFAULT_QUERY,
                assertEquals(1, buckets.size());
                final Histogram.Bucket bucket = buckets.get(randomIndex);
        bucketsToExpectedDocCountMap.put(3, 24);
    @Override
import java.time.LocalDate;
                expectedDocCount.put("2023-12-01T00:00:00.000-05:00", 1);
        }
                assertThat(histo.getBuckets().size(), equalTo(10));
    protected IndexSettings createIndexSettings() {
            expectedDocCount.put("2020-02-01T00:00:00.000Z", 1);
        testSearchCase(  
            dataset,
            DEFAULT_QUERY,
                    instantFieldType,
        final Consumer<AutoDateHistogramAggregationBuilder> aggregation = agg -> agg.setNumBuckets(10).field(DATE_FIELD);
/*  
            ZonedDateTime.of(2017, 2, 5, 0, 0, 0, 0, ZoneOffset.UTC)  
            Map<String, Integer> expectedDocCount = new TreeMap<>();
            DateFieldMapper.DateFieldType dft = aggregableDateFieldType(false, searchable);
        expectedDocCount.put("2017-02-03T00:00:00.000-01:00", 0);
            supportsIntraSegmentSearch(  
        final List<ZonedDateTime> dataset = new ArrayList<>();
            ZonedDateTime.of(2017, 2, 1, 9, 16, 4, 0, ZoneOffset.UTC),
            StringTerms.Bucket a = terms.getBucketByKey("a");
            histogram -> {
                IndexSearcher searcher = newIndexSearcher(reader);
                    assertThat(histo.getBuckets().get(i).key, equalTo((double) i));
            document.add(new StringField("someField", "a", Field.Store.NO));  
                assertEquals("2013-05-29T05:11:31.000Z", stats.getMinAsString());
        testSearchCase(
            }
import org.opensearch.common.CheckedBiConsumer;
                stats = bucket.getAggregations().get("stats");  
        bucketsToExpectedDocCountMap.put(20, 10);
        for (int i = 0; i < length; i++) {
                        .interval(1)  
        bucketsToExpectedDocCountMap.put(60, 5);  
                MappedFieldType instantFieldType = new NumberFieldMapper.NumberFieldType(INSTANT_FIELD, NumberFieldMapper.NumberType.LONG);
         */
            ZonedDateTime.of(2017, 2, 5, 0, 0, 0, 0, ZoneOffset.UTC)  
            assertThat(bucketCountsAsMap(adh), equalTo(expectedDocCount));
                assertThat(bucket.getAggregations().asList().size(), equalTo(1));  
                assertEquals(expectedSize, buckets.size());
                true
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),  
import org.apache.lucene.document.Field;
                final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(aggregationBuilder.field());
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
        expectedDocCount.put("2017-02-01T12:00:00.000-01:00", 1);
     * Test that verifies FromSingle.increaseRoundingIfNeeded() works correctly with skiplist collector.  
                .subAggregation(AggregationBuilders.stats("stats").field(DATE_FIELD)),  
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-01-01T00:00:00.000Z"), either(equalTo(21)).or(equalTo(22))));
        expectedDocCount.put("2017-02-01T09:00:00.000-01:00", 1);  
        expectedDocCount.put("2017-02-01T00:00:08.000Z", 0);
        assertFalse(
import java.util.Collections;  
        final List<ZonedDateTime> dataset,
            ZonedDateTime.of(2017, 2, 1, 9, 35, 0, 0, ZoneOffset.UTC),  
                    );  
            dataset,  
        testSearchCase(
            dataset.add(date);  
            Map<String, Double> expectedMax = new TreeMap<>();
 * SPDX-License-Identifier: Apache-2.0
        bucketsToExpectedDocCountMap.put(150, 5);
            StringTerms.Bucket b = terms.getBucketByKey("b");
        // with a sub-aggregation AND fast path declines (non-UTC): intra-eligible (doc-by-doc parallelizes)
            }  
        }  
                final int randomIndex = randomInt(expectedSize - 1);
    }
        fullDocCount.put("2017-02-01T09:02:00.000Z", 2);
import static org.hamcrest.Matchers.equalTo;
            }
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
        testSearchCase(
        bucketsToExpectedDocCountMap.put(120, 1);
 * KIND, either express or implied.  See the License for the
import java.time.ZoneId;
            expectedMax.clear();
            ZonedDateTime.of(2017, 2, 1, 0, 0, 11, 210, ZoneOffset.UTC),
                final InternalAutoDateHistogram histogram = searchAndReduce(
            DEFAULT_QUERY,
                assertEquals("2011-01-01T00:00:00.000Z", bucket.getKeyAsString());
            DEFAULT_QUERY,  
            Map<String, Double> expectedMax = new TreeMap<>();
            long anHour = dft.resolution().convert(Instant.ofEpochSecond(TimeUnit.HOURS.toSeconds(1)));  
    public void testIntervalHourWithTZ() throws IOException {  
        testSearchCase(
            expectedDocCount.put("2020-10-01T00:00:00.000Z", 2208);
        );
        final int length = 72;
    /**
        }
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                    AggregationBuilders.histogram("histo")
                    new DateFieldMapper.DateFieldType(aggregationBuilder.field()),  
            /*
                assertEquals(expectedSize, buckets.size());
import org.opensearch.cluster.metadata.IndexMetadata;
        Map<String, Integer> expectedDocCount = new TreeMap<>();
                    .addAggregator(builder)
    ) throws IOException {
        final Consumer<AutoDateHistogramAggregationBuilder> configure,  
            dataset.add(date);  
    public void testUnmappedMissing() throws IOException {
        bucketsToExpectedDocCountMap.put(10, 30);
            histogram -> {
        asSubAggTestCase(builder, (StringTerms terms) -> {
            expectedDocCount.put(startDate.plusYears(2), 1);  
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        LinkedHashMap<String, Double> map = new LinkedHashMap<>(result.getBuckets().size());
            assertEquals(0, histogram.getBuckets().size());
                return factories.allFactoriesSupportIntraSegmentSearch();
import org.apache.lucene.util.BytesRef;
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-10-01T00:00:00.000Z"), either(equalTo(22)).or(equalTo(23))));
            StringTerms.Bucket c = terms.getBucketByKey("c");
            }
            ZonedDateTime.of(2017, 2, 1, 13, 6, 0, 0, ZoneOffset.UTC),  
        // Add hourly data for multiple days, then add data spanning years
                assertEquals(2L, stats.getCount());  
            try (IndexReader reader = indexWriter.getReader()) {
            DEFAULT_QUERY,
                final int randomIndex = randomInt(expectedSize - 1);  
            // Verify that aggregation completed successfully  
                assertEquals(startDate.plusMinutes(randomIndex * expectedDocCount), bucket.getKey());
            assertThat(maxAsMap(bk1bdh), equalTo(expectedMax));  
        }, fieldType);  
import java.util.concurrent.TimeUnit;
            testSearchCase(DEFAULT_QUERY, dataset, aggregation -> aggregation.setNumBuckets(6).field(DATE_FIELD), histogram -> {
                expectedMax.put("2020-10-01T00:00:00.000Z", (double) n);  
                    .timeZone(ZoneId.of("America/New_York"))
            InternalAutoDateHistogram adh = a.getAggregations().get("dh");  
            assertFalse(histogram.getBuckets().isEmpty());
        for (int year = 0; year < 5; year++) {
        final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType("date_field");
        fullDocCount.putAll(skeletonDocCount);
     *
        ZonedDateTime.of(2015, 2, 13, 13, 9, 32, 0, ZoneOffset.UTC),  
            aggregation -> aggregation.setNumBuckets(6).field(DATE_FIELD),
            }
 */
        }  
                assertEquals(startDate.plusDays(randomIndex), bucket.getKey());
                // Verify total doc count  
            List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
                    if (bucket.getDocCount() > 0) {  
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
                assertEquals("2012-05-18T04:11:00.000Z", stats.getMinAsString());
                final int randomIndex = randomInt(expectedSize - 1);
            expectedDocCount.clear();
        );
            final ZonedDateTime date = startDate.plusSeconds(i);
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
        final ZonedDateTime startDate = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            ZonedDateTime.of(2017, 2, 1, 16, 6, 0, 0, ZoneOffset.UTC),  
            DATES_WITH_TIME,  
                assertEquals("2010-01-01T00:00:00.000Z", bucket.getKeyAsString());
        final Query query,
            assertThat(bucketCountsAsMap(bdh), equalTo(expectedDocCount));
            assertEquals(0, histogram.getBuckets().size());  
        }
            expectedDocCount.put("2020-10-01T00:00:00.000Z", 2208);
                assertEquals(10, bucket.getDocCount());
            dataset.add(date);
            indexWriter.addDocument(document);
    private void testSearchCase(  
        expectedDocCount.put("2017-02-01T13:00:00.000Z", 1);
            assertTrue(AggregationInspectionHelper.hasValue(histogram));
            histogram -> {
import org.opensearch.index.mapper.MappedFieldType;  
            StringTerms.Bucket bk1a = bk1.getBucketByKey("a");  
        });  
        // Run aggregation without skiplist  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
            Ensure we produce two segments on one shard such that the documents in seg 1 will be out of range of the  
 *
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
        final List<ZonedDateTime> datesForMonthInterval = Arrays.asList(  
            }
                .build(),
                assertEquals("2016-03-04T17:09:50.000Z", stats.getMinAsString());
    // @timestamp field name by default uses skip_list
 * You may obtain a copy of the License at  
                assertEquals(startDate.plusHours(randomIndex * expectedDocCount), bucket.getKey());
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
                InternalAutoDateHistogram dh = b.getAggregations().get("dh");  
                assertEquals(5, buckets.size());  
        Map<String, Integer> skeletonDocCount = new TreeMap<>();
        expectedDocCount.put("2017-02-01T15:00:00.000Z", 4);  
            expectedDocCount.put("2020-04-01T00:00:00.000Z", 2184);  
 * the Apache License, Version 2.0 (the "License"); you may
        expectedDocCount.put("2017-02-01T00:00:05.000Z", 1);  
    }
            DEFAULT_QUERY,
            expectedMax.clear();  
            expectedDocCount.put("2021-01-01T00:00:00.000Z", 1);  
        ZonedDateTime.of(2016, 3, 4, 17, 9, 50, 0, ZoneOffset.UTC),  
            assertThat(maxAsMap(bdh), equalTo(expectedMax));
 * GitHub history for details.
        final List<ZonedDateTime> singleBucketIndexData = Arrays.asList(ZonedDateTime.of(2023, 12, 27, 0, 0, 0, 0, ZoneOffset.UTC));
                return searchAndReduce(indexSearcher, DEFAULT_QUERY, aggregationBuilder, fieldType, instantFieldType, numericFieldType);
            histogram -> {
                dataset.add(start.plusMonths(month).plusDays(day * 10));
            )
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
        ZonedDateTime start = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                        .subAggregation(new DerivativePipelineAggregationBuilder("deriv", "max"))
        try (Directory directory = newDirectory()) {
        // Add hourly data for first day (24 docs)
        bucketsToExpectedDocCountMap.put(10, 30);  
            Map<String, Double> expectedMax = new TreeMap<>();
    public void testMatchNoDocs() throws IOException {  
        final List<ZonedDateTime> datesForMinuteInterval = Arrays.asList(
                bucket = buckets.get(2);  
            aggregation -> aggregation.setNumBuckets(5).field(DATE_FIELD),
                verify.accept(histogram);
            ZonedDateTime.of(2017, 2, 1, 16, 59, 0, 0, ZoneOffset.UTC)  
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
                final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD);
        // Sort dataset to ensure consistent ordering  
    private static final List<ZonedDateTime> DATES_WITH_TIME = Arrays.asList(  
import org.apache.lucene.search.Query;
    public void testIntervalDay() throws IOException {
                assertEquals(1, bucket.getDocCount());
                assertEquals("2012-01-01T00:00:00.000Z", bucket.getKeyAsString());
            expectedMax.put("2020-04-01T00:00:00.000Z", 4367.0);
                stats = bucket.getAggregations().get("stats");  
            dataset.add(date);  
            BytesRef bBytes = new BytesRef("b");  
     * 3. owningBucketOrd is always 0 in FromSingle context
        expectedDocCount.put("2017-02-01T13:00:00.000-01:00", 2);
        final List<ZonedDateTime> dataset = new ArrayList<>(numDocs);
            InternalAutoDateHistogram cdh = c.getAggregations().get("dh");
            assertTrue(AggregationInspectionHelper.hasValue(histogram));  
                bucket = buckets.get(7);  
        final List<ZonedDateTime> multiBucketIndexData = Arrays.asList(  
            expectedDocCount.put("2021-03-01T00:00:00.000Z", 1);  
        );
                assertEquals(1L, stats.getCount());  
            ZonedDateTime.of(2017, 2, 1, 16, 6, 0, 0, ZoneOffset.UTC),
            }
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
            histogram -> {
            for (int day = 0; day < 5; day++) {  
        Map<String, Integer> expectedDocCount = new TreeMap<>();
            expectedMax.put("2020-07-01T00:00:00.000Z", 6575.0);
    }  
            ZonedDateTime.of(2017, 3, 4, 0, 0, 0, 0, ZoneOffset.UTC),
            IllegalArgumentException.class,
    private static final String DATE_FIELD = "@timestamp";
import org.apache.lucene.index.DirectoryReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Consumer<InternalAutoDateHistogram> verify
                dataset.add(start.plusDays(day).plusHours(hour));  
            expectedMax.put("2020-01-01T00:00:00.000Z", 2183.0);
    public void testMatchAllDocs() throws IOException {  
            ZonedDateTime.of(2017, 2, 1, 15, 59, 0, 0, ZoneOffset.UTC),  
            DEFAULT_QUERY,  
                .field(DATE_FIELD)
            StringTerms bk1 = b.getAggregations().get("k1");
                stats = bucket.getAggregations().get("stats");  
            ZonedDateTime.of(2017, 3, 6, 0, 0, 0, 0, ZoneOffset.UTC)  
            /*
                assertEquals("2015-02-13T13:09:32.000Z", stats.getMinAsString());
            datesForDayInterval,
    }  
        expectedDocCount.put("2017-02-01T14:00:00.000-01:00", 1);  
                long totalDocs = histogram.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
        testSearchCase(
        }  
import java.util.function.Consumer;
 *  
        );
            StringTerms.Bucket b = terms.getBucketByKey("b");
                assertTrue(Double.isInfinite(stats.getMax()));
        }
        );  
            expectedMax.put("2020-10-01T00:00:00.000Z", 8783.0);
    public void testIntervalHour() throws IOException {
            assertFalse(histogram.getBuckets().isEmpty());  
            "Bucket count mismatch between skiplist and non-skiplist",
        ZonedDateTime start = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
                assertEquals("2013-01-01T00:00:00.000Z", bucket.getKeyAsString());
        );
            }
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
    public void testSkiplistCollectorWithRoundingChange() throws IOException {
            assertEquals(0, histogram.getBuckets().size());
                indexSampleData(dataset, indexWriter, enableSkiplist);  
    }
        testCase(aggregation, DEFAULT_QUERY, iw -> {}, (Consumer<InternalAutoDateHistogram>) histogram -> {
            .interval(1)
            expectedMax.put("2020-02-01T00:00:00.000Z", 5.0);
                assertTrue(Double.isInfinite(stats.getMin()));
import static org.hamcrest.Matchers.hasEntry;  
        ZonedDateTime.of(2010, 3, 12, 1, 7, 45, 0, ZoneOffset.UTC),
                dataset.add(start.plusYears(year).plusMonths(month));
            expectedDocCount.clear();
            document.add(new LongPoint(INSTANT_FIELD, instant));
            StringTerms.Bucket a = terms.getBucketByKey("a");
        CheckedBiConsumer<RandomIndexWriter, DateFieldMapper.DateFieldType, IOException> buildIndex = (iw, dft) -> {  
    }  
            .subAggregation(
                bucket = buckets.get(5);  
            supportsIntraSegmentSearch(
import org.apache.lucene.document.SortedNumericDocValuesField;
        testSearchCase(
            expectedMax.put("2020-01-01T00:00:00.000Z", 2.0);  
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        Map<String, Integer> expectedDocCount = new TreeMap<>();
                indexWriter.flush();  
        for (int day = 0; day < 5; day++) {
             * same shard to make the reduce behavior consistent.  
    }
        });  
            assertThat(maxAsMap(bk1adh), equalTo(expectedMax));
            expectedMax.put("2020-01-01T00:00:00.000Z", 2.0);  
                MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType(NUMERIC_FIELD, NumberFieldMapper.NumberType.LONG);
                Histogram.Bucket bucket = buckets.get(0);  
        long totalDocsWithout = histogramWithoutSkiplist.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
            assertThat(bucketCountsAsMap(cdh), equalTo(expectedDocCount));  
            }
        expectedDocCount.put("2017-02-03T00:00:00.000Z", 3);
        assertFalse(  
    private static final Query DEFAULT_QUERY = new MatchAllDocsQuery();
 * compatible open source license.
            StringTerms.Bucket b = terms.getBucketByKey("b");
            DEFAULT_QUERY,
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
        testSearchCase(  
            )
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
        testSearchCase(DEFAULT_QUERY, dataset, true, aggregation -> aggregation.setNumBuckets(5).field(DATE_FIELD), histogram -> {
            assertThat(bucketCountsAsMap(bk1bdh), equalTo(expectedDocCount));  
        } else if (randomChoice == 3) {  
                // Verify sub-aggregations are present and valid
        if (enableSkiplist) {
                assertThat(bucketCountsAsMap(histogram), equalTo(expectedDocCount));
        testSearchCase(query, dataset, false, configure, verify);  
                .field(DATE_FIELD)
    private Map<String, Integer> bucketCountsAsMap(InternalAutoDateHistogram result) {
                final AutoDateHistogramAggregationBuilder aggregationBuilder = new AutoDateHistogramAggregationBuilder("_name")  
        expectedDocCount.put("2017-01-31T00:00:00.000-01:00", 1);  
            ZonedDateTime.of(2017, 2, 1, 9, 2, 35, 0, ZoneOffset.UTC),
                new AutoDateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)  
            BytesRef aBytes = new BytesRef("a");
        );
                Map<String, Double> expectedMax = new TreeMap<>();
            document.add(new SortedNumericDocValuesField(NUMERIC_FIELD, i));
        final InternalAutoDateHistogram histogramWithoutSkiplist = runAggregation(dataset, false, numBuckets);
        final Query rangeQuery = LongPoint.newRangeQuery(INSTANT_FIELD, start, end);  
import org.opensearch.search.aggregations.metrics.InternalMax;
            aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD),  
            long start = dft.parse("2020-01-01T00:00:00Z");
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
 * license agreements. See the NOTICE file distributed with
            DEFAULT_QUERY,
        /*
     * 1. preparedRounding field update is visible to skiplist collector
            expectedMax.put("2020-02-01T00:00:00.000Z", 5.0);
            }  
        final int randomChoice = randomIntBetween(1, 3);
                for (int i = 0; i < 10; i++) {  
            .field("bogus_bogus");
import java.util.Locale;
            aggregation -> aggregation.setNumBuckets(5).field(DATE_FIELD).timeZone(ZoneOffset.ofHours(-1)),
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            expectedDocCount.put("2021-01-01T00:00:00.000Z", 2);  
                        assertTrue(stats.getCount() > 0);
            IndexWriterConfig c = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);  
                final int expectedDocCount = 7;
            expectedMax.put("2020-01-01T00:00:00.000Z", 2183.0);  
import org.apache.lucene.document.Document;
                    }
            buckets.forEach(bucket -> assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount()));  
            indexWriter.deleteDocuments(new TermQuery(new Term("someField", "a")));  
                assertEquals("2013-10-31T08:24:05.000Z", stats.getMaxAsString());
            dataset.add(date);
            IndexMetadata.builder("_index")
        expectedDocCount.put("2017-02-01T15:00:00.000Z", 1);
                true  
                assertEquals(3, bucket.getDocCount());
        assertEquals("Total doc count should match input", numDocs, totalDocsWithout);
                assertEquals("2016-01-01T00:00:00.000Z", bucket.getKeyAsString());
 *
import org.apache.lucene.search.TermQuery;
            supportsIntraSegmentSearch(new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10).field(AGGREGABLE_DATE), true)
            result -> assertThat(bucketCountsAsMap(result), equalTo(fullDocCount))
        });
        assertThat(exception.getMessage(), Matchers.containsString("must be less than"));
            fullDocCount.put(String.format(Locale.ROOT, "2017-02-01T09:%02d:00.000Z", minute), 0);
import org.opensearch.search.aggregations.AggregationBuilder;  
        expectedDocCount.put("2017-02-01T15:00:00.000Z", 1);
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            datesForMinuteInterval,
public class AutoDateHistogramAggregatorTests extends DateHistogramAggregatorTestCase {  
            DATES_WITH_TIME,  
            assertEquals(54, totalDocs); // 24 + 30 = 54 docs  
        expectedDocCount.put("2017-02-01T00:00:00.000Z", 1);  
            DEFAULT_QUERY,
import java.util.TreeMap;  
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            for (long d = start; d < end; d += anHour) {  
            expectedDocCount.put("2020-07-01T00:00:00.000Z", 2208);
        };  
        for (int i = 0; i < histogramWithoutSkiplist.getBuckets().size(); i++) {
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
             * Intentionally add all documents at once to put them on the
            });
        assertEquals("Total doc count mismatch", totalDocsWithout, totalDocsWith);
    private void indexSampleData(List<ZonedDateTime> dataset, RandomIndexWriter indexWriter) throws IOException {
            expectedDocCount.clear();
             * Intentionally add all documents at once to put them on the
        testSearchCase(
            // Verify buckets were created and merged appropriately
        });
        for (int month = 0; month < 12; month++) {  
    private static final String INSTANT_FIELD = "instant";  
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2184);
     * This test creates a scenario where buckets must be merged when rounding increases.  
            }
        final List<ZonedDateTime> dataset = new ArrayList<>(length);  
            InternalAutoDateHistogram ak1adh = ak1a.getAggregations().get("dh");  
                assertEquals(startDate.plusMonths(randomIndex), bucket.getKey());  
                assertEquals(2L, stats.getCount());  
            histogram -> {  
import java.util.LinkedHashMap;
            new MatchNoDocsQuery(),
     */  
                expectedDocCount.put("2023-11-01T00:00:00.000-04:00", 1);
        result.getBuckets().stream().forEach(b -> {  
            aggregation -> aggregation.setNumBuckets(8)
                assertThat(maxAsMap(dh), equalTo(expectedMax));
        testSearchCase(
                .creationDate(System.currentTimeMillis())  
            aggregation -> aggregation.setNumBuckets(4).field(DATE_FIELD),
            if (enableSkiplist) {
                assertEquals(36, totalDocs); // 12 months * 3 days = 36 docs
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
        };  
            aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD).timeZone(ZoneOffset.ofHours(-1)),
                final Histogram.Bucket bucket = buckets.get(randomIndex);  
        }
            ZonedDateTime.of(2023, 10, 10, 0, 0, 0, 0, ZoneOffset.UTC),
            dataset,
        }
        bucketsToExpectedDocCountMap.put(12, 12);  
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();  
        testCase(aggregation, DEFAULT_QUERY, iw -> {}, (Consumer<InternalAutoDateHistogram>) histogram -> {  
         * No-op.
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
    public void testAsSubAggInManyBuckets() throws IOException {
    public void testSkiplistCollectorBucketMergingAfterRoundingChange() throws IOException {  
        ZonedDateTime.of(2015, 6, 24, 13, 47, 43, 0, ZoneOffset.UTC),
        final Document document = new Document();  
        for (int i = 0; i < length; i++) {  
            }
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            ZonedDateTime.of(2017, 2, 1, 10, 15, 0, 0, ZoneOffset.UTC),
    private Map<String, Double> maxAsMap(InternalAutoDateHistogram result) {
            ZonedDateTime.of(2017, 2, 1, 13, 6, 0, 0, ZoneOffset.UTC),
    private void testSearchCase(  
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
import org.opensearch.Version;  
import java.time.YearMonth;  
import org.opensearch.search.aggregations.AggregationBuilders;
            assertTrue(histogram.getBuckets().size() <= 5);
                final int expectedSize = length / expectedDocCount;
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),  
                new AutoDateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)  
                    indexSearcher,
                    .subAggregation(new MaxAggregationBuilder("max").field("n"))
    }
        // non-UTC timezone, no sub-agg: fast path declines -> intra-eligible
            final ZonedDateTime date = startDate.plusDays(i);
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        );  
            supportsIntraSegmentSearch(  
        final int length = 60;
                assertEquals("2015-01-01T00:00:00.000Z", bucket.getKeyAsString());
    }
        });  
            }  
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
            long totalDocs = histogram.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
                expectedMax.put("2020-07-01T00:00:00.000Z", (double) n);
                document.add(SortedNumericDocValuesField.indexedField(DATE_FIELD, instant));
        );  
                    aggregationBuilder,
        testSearchCase(
    // Bugfix: https://github.com/opensearch-project/OpenSearch/issues/16932  
                assertEquals(0, bucket.getDocCount());
        ZonedDateTime.of(2010, 4, 27, 3, 43, 34, 0, ZoneOffset.UTC),
                indexSampleData(multiBucketIndexData, indexWriter);
        bucketsToExpectedDocCountMap.put(25, 20);  
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-07-01T00:00:00.000Z"), either(equalTo(22)).or(equalTo(23))));  
        });  
    }
        expectedDocCount.put("2010-01-01T00:00:00.000Z", 2);
            histogramWithoutSkiplist.getBuckets().size(),  
            )
        );  
                InternalHistogram histo = (InternalHistogram) bucket.getAggregations().asList().get(0);
        });
            aggregation -> aggregation.setNumBuckets(1)
    public void testWithLargeNumberOfBuckets() {
            InternalAutoDateHistogram bk1bdh = bk1b.getAggregations().get("dh");  
                bucket = buckets.get(4);  
            }
            final ZonedDateTime date = startDate.plusYears(i);
                        assertTrue(AggregationInspectionHelper.hasValue(stats));
                assertFalse(AggregationInspectionHelper.hasValue(stats));
                    .setNumBuckets(4)
            datesForMonthInterval,
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
            );
            List<List<IndexableField>> docs = new ArrayList<>();
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
            }
                assertEquals(expectedDocCount, bucket.getDocCount());  
    public void testRandomHourIntervals() throws IOException {
            }
        testSearchCase(DEFAULT_QUERY, dataset, true, aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD), histogram -> {
        // Run aggregation with skiplist  
            aggregation -> aggregation.setNumBuckets(15).field(DATE_FIELD),  
            final Map<ZonedDateTime, Integer> expectedDocCount = new HashMap<>();  
            aggregation -> aggregation.setNumBuckets(4).field(DATE_FIELD),  
            histogram -> {
    }  
             * same shard to make the reduce behavior consistent.  
        expectedDocCount.put("2017-02-01T00:00:11.000Z", 3);
                    assertNotNull(stats);
                final int expectedDocCount = randomEntry.getValue();  
            int n = 0;
        Map<String, Integer> expectedDocCount = new TreeMap<>();
                expectedMax.put("2020-04-01T00:00:00.000Z", (double) n);
            expectedMax.clear();
        expectedDocCount.put("2017-03-01T00:00:00.000Z", 3);
        bucketsToExpectedDocCountMap.put(300, 1);  
        asSubAggTestCase(builder, (StringTerms terms) -> {
                    query,
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
                final InternalAutoDateHistogram histogram = searchAndReduce(  
            assertEquals("Bucket key mismatch at index " + i, bucketWithout.getKey(), bucketWith.getKey());  
            ZonedDateTime.of(2017, 2, 1, 14, 5, 0, 0, ZoneOffset.UTC),
    /**
                final int expectedDocCount = randomEntry.getValue();  
            () -> testSearchCase(
        try (Directory directory = newDirectory()) {
    }  
                    .timeZone(ZoneId.of("America/New_York")),  
            long end = dft.parse("2021-01-01T00:00:00Z");
    public void testIntervalMonth() throws IOException {
        testSearchCase(  
    }
        final List<ZonedDateTime> datesForDayInterval = Arrays.asList(
        throws IOException {  
import org.hamcrest.Matchers;
        ZonedDateTime.of(2012, 5, 18, 4, 11, 0, 0, ZoneOffset.UTC),  
            expectedDocCount.put("2024-01-01T00:00:00.000Z", 4);  
                // Force agg to update rounding when it begins collecting from the second segment.
    private boolean supportsIntraSegmentSearch(AutoDateHistogramAggregationBuilder builder, boolean searchable) throws IOException {
            )
                assertEquals(expectedDocCount, bucket.getDocCount());
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 124); // 5 * 24 hours + 4 quarters
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),  
                    .field(DATE_FIELD);
                final AutoDateHistogramAggregationBuilder aggregationBuilder = new AutoDateHistogramAggregationBuilder("_name");
        expectedDocCount.put("2017-02-01T10:00:00.000Z", 1);
        // Create a dataset that will trigger rounding changes  
                        .field(NUMERIC_FIELD)
        return new IndexSettings(
                assertEquals(length, buckets.size());
import static org.hamcrest.Matchers.hasSize;
        bucketsToExpectedDocCountMap.put(10, 50);
            Object old = map.put(b.getKeyAsString(), max.getValue());
            assertFalse(AggregationInspectionHelper.hasValue(histogram));  
            ZonedDateTime.of(2017, 2, 1, 0, 0, 7, 299, ZoneOffset.UTC),
 *    http://www.apache.org/licenses/LICENSE-2.0
        fullDocCount.put("2017-02-01T09:12:00.000Z", 3);  
                final int expectedSize = length / expectedDocCount;
            InternalAutoDateHistogram.Bucket bucketWith = histogramWithSkiplist.getBuckets().get(i);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(result.getBuckets().size());
            int n = 0;
            testSearchCase(DEFAULT_QUERY, dataset, aggregation -> aggregation.setNumBuckets(length).field(DATE_FIELD), histogram -> {  
            for (int day = 0; day < 3; day++) {
                    )
                assertEquals(20, buckets.size());  
            InternalMax max = b.getAggregations().get("max");
            expectedDocCount.put("2022-01-01T00:00:00.000Z", 4);
        Map<String, Integer> fullDocCount = new TreeMap<>();  
                    configure.accept(aggregationBuilder);
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2184);
            final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        final Settings nodeSettings = Settings.builder().put("search.max_buckets", 25000).build();  
                assertEquals(startDate.plusDays(randomIndex * expectedDocCount), bucket.getKey());  
    /**
            ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
        ZonedDateTime.of(2013, 10, 31, 8, 24, 5, 0, ZoneOffset.UTC),
        testSearchCase(  
                assertEquals("2014-01-01T00:00:00.000Z", bucket.getKeyAsString());
    }  
                }
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());  
        );  
            ZonedDateTime.of(2017, 2, 1, 9, 2, 0, 0, ZoneOffset.UTC),
            assertThat(bucketCountsAsMap(ak1adh), equalTo(expectedDocCount));
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        }
            .subAggregation(  
                final int randomIndex = randomInt(19);
     * This test validates:
                final int expectedDocCount = randomEntry.getValue();
        for (final ZonedDateTime date : dataset) {
                assertEquals(expectedSize, buckets.size());  
                }
        expectedDocCount.put("2017-02-01T09:00:00.000Z", 2);  
        expectedDocCount.put("2016-01-01T00:00:00.000Z", 1);  
 */  
                    List.of(
import org.apache.lucene.search.IndexSearcher;
    public void testRandomMinuteIntervals() throws IOException {
import org.apache.lucene.document.StringField;  
    private void indexSampleData(List<ZonedDateTime> dataset, RandomIndexWriter indexWriter, boolean enableSkiplist) throws IOException {
        // Start with hourly data, then add data that spans months to force rounding increase
                bucket = buckets.get(1);  
    }  
import org.apache.lucene.index.IndexWriterConfig;  
            long end = dft.parse("2021-01-01T00:00:00Z");
        indexSampleData(dataset, indexWriter, false);
    public void testAsSubAgg() throws IOException {  
    }  
        final List<ZonedDateTime> dataset = new ArrayList<>();
        // Create dataset with fine-grained data that will be merged into coarser buckets
            );  
    }  
            ZonedDateTime.of(2017, 2, 1, 14, 5, 0, 0, ZoneOffset.UTC),
            ZonedDateTime.of(2017, 2, 1, 9, 2, 0, 0, ZoneOffset.UTC),  
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
    }
                    .field(AGGREGABLE_DATE)  
            long anHour = dft.resolution().convert(Instant.ofEpochSecond(TimeUnit.HOURS.toSeconds(1)));  
            // Verify buckets were created (exact count depends on rounding chosen)  
                assertFalse(AggregationInspectionHelper.hasValue(histogram));
             */
            // Verify buckets are in ascending order (requirement for histogram)
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
            assertEquals(
                stats = bucket.getAggregations().get("stats");  
                InternalHistogram.Bucket b = histo.getBuckets().get(n);
        }
 * specific language governing permissions and limitations
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
        for (int i = 0; i < length; i++) {  
            datesForHourInterval,  
    }
        final int length = 120;  
            dataset,  
        bucketsToExpectedDocCountMap.put(3, 60);
            final ZonedDateTime startDate = ZonedDateTime.of(2015, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    public void testRandomYearIntervals() throws IOException {  
        expectedDocCount.put("2017-02-01T15:00:00.000-01:00", 3);
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
        final Query query,
        }  
                    fieldType,
        for (int i = 0; i < numDocs; i++) {
        );  
        } else if (randomChoice == 2) {
            }  
}
import java.time.Instant;
                    InternalStats stats = bucket.getAggregations().get("stats");
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
            expectedMax.put("2020-04-01T00:00:00.000Z", 4367.0);  
 * The OpenSearch Contributors require contributions made to  
        }
        );  
            .field("bogus_bogus")
                final int expectedSize = length / expectedDocCount;
            }  
     *  
        skeletonDocCount.put("2017-02-01T09:16:00.000Z", 2);
        testSearchCase(  
        final Consumer<AutoDateHistogramAggregationBuilder> configure,
            expectedDocCount.put(startDate, 3);
        // Verify each bucket matches
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        ZonedDateTime.of(2013, 5, 29, 5, 11, 31, 0, ZoneOffset.UTC),
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            }  
                bucket = buckets.get(6);  
        asSubAggTestCase(builder, buildIndex, (StringTerms terms) -> {
            assertThat(histo.getBuckets(), hasSize(100));  
                        new SortedNumericDocValuesField("n", n++)  
 * Licensed to Elasticsearch under one or more contributor  
            prepared rounding produced by the filter rewrite optimization considering seg 2 for optimized path.
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                    new NumberFieldMapper.NumberFieldType(NUMERIC_FIELD, NumberFieldMapper.NumberType.LONG)
        expectedDocCount.put("2017-02-01T10:00:00.000-01:00", 0);
            InternalAutoDateHistogram bk1adh = bk1a.getAggregations().get("dh");
        expectedDocCount.put("2017-02-01T00:00:00.000-01:00", 2);
                .subAggregation(  
        testSearchCase(
    public void testIntervalYear() throws IOException {  
                        .subAggregation(AggregationBuilders.max("max").field(NUMERIC_FIELD))
            ZonedDateTime.of(2017, 2, 1, 9, 15, 37, 0, ZoneOffset.UTC),
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
        // Verify both produce identical results  
                assertTrue(Double.isInfinite(stats.getMax()));
            Map<String, Integer> expectedDocCount = new TreeMap<>();
            ZonedDateTime.of(2017, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC),  
    }
            ZonedDateTime.of(2017, 3, 5, 0, 0, 0, 0, ZoneOffset.UTC),
            assertEquals(0, histogram.getBuckets().size());  
                assertEquals(0, histogram.getBuckets().size());  
                assertEquals(1, bucket.getDocCount());
        assertTrue(  
        return map;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            ZonedDateTime.of(2017, 2, 1, 14, 4, 0, 0, ZoneOffset.UTC),
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        );
             */
        testSearchCase(DEFAULT_QUERY, dates, aggregation, histogram -> {
                dataset.add(start.plusMonths(month).plusDays(day * 6));
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
import java.io.IOException;  
                "Doc count mismatch at index " + i + " for key " + bucketWithout.getKeyAsString(),  
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))  
                assertEquals(1L, stats.getCount());  
            datesForHourInterval,
        expectedDocCount.put("2017-02-02T00:00:00.000Z", 2);
                .subAggregation(AggregationBuilders.stats("stats").field(DATE_FIELD)),  
        multiBucketIndexData must overlap with DST to produce a 'LinkedListLookup' prepared rounding.  
        expectedDocCount.put("2017-01-01T00:00:00.000Z", 1);  
                // since an exception is thrown, this assertion won't be invoked.  
            final ZonedDateTime date = startDate.plusMinutes(i);
     * This ensures that when rounding changes mid-collection, sub-aggregations still produce correct results.  
                indexSampleData(singleBucketIndexData, indexWriter);
        /*  
            DEFAULT_QUERY,
            aggregation -> aggregation.setNumBuckets(8)
            );  
        testSearchCase(DEFAULT_QUERY, dates, aggregation, histogram -> {
        // Verify total doc counts match  
        );
        expectedDocCount.put("2017-02-02T00:00:00.000-01:00", 3);
            .subAggregation(
        // non-searchable field, no sub-agg: fast path declines -> intra-eligible
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                true
                Map<String, Integer> expectedDocCount = new TreeMap<>();
import org.apache.lucene.index.Term;  
        testSearchCase(
     *
                        new SortedSetDocValuesField("k1", d < useC ? bBytes : cBytes),
                assertEquals("2010-04-27T03:43:34.000Z", stats.getMaxAsString());
                aggregation -> aggregation.setNumBuckets(MultiBucketConsumerService.DEFAULT_MAX_BUCKETS + 1).field(DATE_FIELD),
 * this work for additional information regarding copyright
            ZonedDateTime.of(2017, 2, 1, 9, 2, 59, 0, ZoneOffset.UTC),  
            long randomOffset = randomLongBetween(0, yearInMillis);
        builder = new TermsAggregationBuilder("k2").field("k2").subAggregation(builder);
                    .setNumBuckets(3)
            });
                assertEquals(0, bucket.getDocCount());
                .numberOfReplicas(0)
                new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10)
            expectedMax.put("2021-03-01T00:00:00.000Z", 4.0);  
        final int numBuckets = randomIntBetween(5, 20);
        final List<ZonedDateTime> datesForHourInterval = Arrays.asList(
                .field(DATE_FIELD)
            expectedMax.put("2020-07-01T00:00:00.000Z", 6575.0);
 * ownership. Elasticsearch licenses this file to you under  
                    new NumberFieldMapper.NumberFieldType(INSTANT_FIELD, NumberFieldMapper.NumberType.LONG),
        expectedDocCount.put("2017-02-01T16:00:00.000Z", 3);  
            datesForHourInterval,  
            assertThat(bucketCountsAsMap(histogram), equalTo(expectedDocCount));
    public void testRandomSecondIntervals() throws IOException {  
            DATES_WITH_TIME,  
            nodeSettings
            StringTerms.Bucket a = terms.getBucketByKey("a");  
     */
            DEFAULT_QUERY,  
    }  
                docs.add(List.of(new SortedNumericDocValuesField(AGGREGABLE_DATE, d), new SortedNumericDocValuesField("n", n % 100)));
 * this file be licensed under the Apache-2.0 license or a
                final int randomIndex = randomInt(expectedSize - 1);
    }
            StringTerms.Bucket bk1b = bk1.getBucketByKey("b");
            Object old = map.put(b.getKeyAsString(), Math.toIntExact(b.getDocCount()));
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
        bucketsToExpectedDocCountMap.put(30, 3);
            DATES_WITH_TIME,  
            i += 1;
        );  
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
        expectedDocCount.put("2012-01-01T00:00:00.000Z", 1);  
        try (Directory directory = newDirectory()) {
import org.opensearch.index.mapper.NumberFieldMapper;
            );  
        );
        final int length = 120;
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
                assertEquals(2, bucket.getDocCount());
            for (int month = 0; month < 12; month += 3) {  
                );  
            indexWriter.addDocument(document);  
import org.apache.lucene.index.NoMergePolicy;
            Map<String, Integer> expectedDocCount = new TreeMap<>();
    }
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
        }
        bucketsToExpectedDocCountMap.put(60, 5);
                assertEquals("2017-12-12T22:55:46.000Z", stats.getMaxAsString());
            expectedDocCount.put("2020-02-01T00:00:00.000Z", 1);
     * Test that verifies bucket merging works correctly after rounding change.
    public void testIntervalSecond() throws IOException {
            DEFAULT_QUERY,
        This lookup rounding style maintains a strict max/min input range and will assert each value is in range.
        final long yearInMillis = 365L * 24 * 60 * 60 * 1000;
    }  
                final Histogram.Bucket bucket = buckets.get(randomIndex);
        // Add data spanning multiple years to force coarse rounding
            /*
        });
package org.opensearch.search.aggregations.bucket.histogram;
                InternalStats stats = bucket.getAggregations().get("stats");  
        final long start = LocalDate.of(2015, 1, 1).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        }  
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, dft, nft)  
            supportsIntraSegmentSearch(new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10).field(AGGREGABLE_DATE), false)
        bucketsToExpectedDocCountMap.put(60, 1);  
        // This forces rounding to increase from hours -> days -> months -> years  
import org.opensearch.index.mapper.DateFieldMapper;
    public void testSkiplistEquivalence() throws IOException {
    public void testRandomMonthIntervals() throws IOException {  
                new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10)
                assertEquals(YearMonth.from(startDate.plusMonths(randomIndex)).lengthOfMonth(), bucket.getDocCount());
        expectedDocCount.put("2017-01-01T00:00:00.000Z", 1);
        fullDocCount.clear();
    }
                    indexSearcher,
                final int expectedDocCount = randomEntry.getValue();
    public void testRandomDayIntervals() throws IOException {
            } else {  
                            .getQueryShardContext(),
        CheckedBiConsumer<RandomIndexWriter, DateFieldMapper.DateFieldType, IOException> buildIndex = (iw, dft) -> {
    }
        );
            }  
                assertEquals("2015-11-13T16:14:34.000Z", stats.getMaxAsString());
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-04-01T00:00:00.000Z"), either(equalTo(21)).or(equalTo(22))));
            expectedDocCount.put(startDate.plusYears(1), 1);
            assertThat(bucketCountsAsMap(bdh), equalTo(expectedDocCount));
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
        expectedDocCount.put("2017-02-01T00:00:10.000Z", 0);  
            assertEquals(expectedDocCount.size(), buckets.size());
        );
                AggregatorFactories factories = AggregatorFactories.builder()  
                final int expectedDocCount = randomEntry.getValue();
            aggregation -> aggregation.setNumBuckets(7).field(DATE_FIELD),
            histogramWithSkiplist.getBuckets().size()
import java.util.Arrays;
            ZonedDateTime.of(2017, 2, 1, 16, 48, 0, 0, ZoneOffset.UTC),
            document.clear();
        asSubAggTestCase(builder, buildIndex, (InternalHistogram histo) -> {
            assertThat(maxAsMap(adh), equalTo(expectedMax));
                DEFAULT_QUERY,  
import org.apache.lucene.document.LongPoint;  
        expectedDocCount.put("2017-02-01T14:00:00.000Z", 2);  
        bucketsToExpectedDocCountMap.put(36, 3);
     * 2. New Rounding.Prepared instance is created on rounding change  
/*
            indexWriter.commit();
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
    }
            dataset.add(date);
        Map<String, Integer> expectedDocCount = new TreeMap<>();
import org.apache.lucene.store.Directory;  
    private static final String NUMERIC_FIELD = "numeric";
        });
    }
            dataset,
        testSearchCase(  
    }  
        testSearchCase(
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
        });
            DEFAULT_QUERY,
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
                    numericFieldType  
                assertEquals(expectedDocCount, bucket.getDocCount());
        final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType("date_field");  
    }  
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
            ZonedDateTime.of(2017, 2, 1, 14, 4, 0, 0, ZoneOffset.UTC),  
        expectedDocCount.put("2015-01-01T00:00:00.000Z", 3);
            ZonedDateTime.of(2017, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC),  
        expectedDocCount.put("2017-02-01T00:00:09.000Z", 0);
        );  
            testSearchCase(DEFAULT_QUERY, dataset, aggregation -> aggregation.setNumBuckets(60).field(DATE_FIELD), histogram -> {  
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
    private InternalAutoDateHistogram runAggregation(List<ZonedDateTime> dataset, boolean enableSkiplist, int numBuckets)
        for (int i = 0; i < length; i++) {
                assertEquals("2016-03-04T17:09:50.000Z", stats.getMaxAsString());
            assertTrue(AggregationInspectionHelper.hasValue(histogram));
            ZonedDateTime.of(2017, 2, 1, 15, 59, 0, 0, ZoneOffset.UTC),
        final List<ZonedDateTime> datesForDayInterval = Arrays.asList(
        final List<ZonedDateTime> datesForSecondInterval = Arrays.asList(  
        expectedDocCount.put("2017-02-01T12:00:00.000Z", 3);
            expectedDocCount.put("2023-01-01T00:00:00.000Z", 4);
        ZonedDateTime.of(2017, 12, 12, 22, 55, 46, 0, ZoneOffset.UTC)
            result -> assertThat(bucketCountsAsMap(result), equalTo(fullDocCount))
                assertTrue(((ZonedDateTime) buckets.get(i - 1).getKey()).isBefore((ZonedDateTime) buckets.get(i).getKey()));
        );  
                bucket = buckets.get(3);  
            assertThat(maxAsMap(bdh), equalTo(expectedMax));
                for (Histogram.Bucket bucket : histogram.getBuckets()) {  
        );  
            expectedDocCount.clear();  
            ZonedDateTime.of(2023, 11, 11, 0, 0, 0, 0, ZoneOffset.UTC)
        assertTrue(
        expectedDocCount.put("2017-02-01T11:00:00.000Z", 0);
        expectedDocCount.put("2017-02-05T00:00:00.000Z", 1);  
            histogram -> {
        );
    }
                histogram -> fail()
                final int expectedSize = length / expectedDocCount;  
            assertThat(bucketCountsAsMap(adh), equalTo(expectedDocCount));  
import java.time.ZonedDateTime;  
                stats = bucket.getAggregations().get("stats");  
        );  
        expectedDocCount.put("2014-01-01T00:00:00.000Z", 0);  
                MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType(NUMERIC_FIELD, NumberFieldMapper.NumberType.LONG);  
     * Uses random number of documents (20-200) and random date distribution.
            dataset,
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),  
                    .subAggregation(new MaxAggregationBuilder("max").field("n"))  
        final int length = 140;  
        bucketsToExpectedDocCountMap.put(50, 10);
                final AutoDateHistogramAggregationBuilder aggregationBuilder = new AutoDateHistogramAggregationBuilder("_name");
            expectedDocCount.clear();  
            assertTrue(histogram.getBuckets().size() <= 10);
        final long end = LocalDate.of(2017, 12, 31).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
            }  
            datesForSecondInterval,  
                }  
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
    /**
                stats = bucket.getAggregations().get("stats");  
                assertEquals(0L, stats.getCount());  
        );  
                        null
        }  
        int i = 0;
            }  
        bucketsToExpectedDocCountMap.put(3, 60);  
        final Consumer<InternalAutoDateHistogram> verify
        expectedDocCount.put("2017-02-01T00:00:06.000Z", 0);  
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
    public void testSubAggregations() throws IOException {  
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
    public void testAsSubAggWithIncreasedRounding() throws IOException {
                );
                assertEquals(expectedDocCount, bucket.getDocCount());
                if (configure != null) {  
import org.opensearch.search.aggregations.AggregatorFactories;
        }
import org.apache.lucene.document.SortedSetDocValuesField;
            BytesRef cBytes = new BytesRef("c");
        );
        );
                final int randomIndex = randomInt(2);
        expectedDocCount.put("2011-01-01T00:00:00.000Z", 0);
        for (int i = 0; i < length; i++) {
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                assertFalse(histogram.getBuckets().isEmpty());
import org.apache.lucene.index.IndexReader;
                    .setNumBuckets(4)
        result.getBuckets().stream().forEach(b -> {  
            datesForDayInterval,
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
                final int expectedSize = length / expectedDocCount;
     */
            StringTerms ak1 = a.getAggregations().get("k1");
                final Histogram.Bucket bucket = buckets.get(randomIndex);
import org.apache.lucene.index.IndexableField;
            expectedDocCount.put("2020-07-01T00:00:00.000Z", 2208);
                assertEquals(1, bucket.getDocCount());  
                DATES_WITH_TIME,
                MappedFieldType instantFieldType = new NumberFieldMapper.NumberFieldType(INSTANT_FIELD, NumberFieldMapper.NumberType.LONG);  
                final int randomIndex = randomInt(expectedSize - 1);  
            DEFAULT_QUERY,
            expectedDocCount.put("2021-01-01T00:00:00.000Z", 4);  
        expectedDocCount.put("2017-02-01T09:00:00.000Z", 3);
                assertEquals(startDate.plusYears(randomIndex * expectedDocCount), bucket.getKey());  
            iw.addDocuments(docs);
                assertEquals(1, bucket.getDocCount());
    ) throws IOException {  
                    .subAggregation(new MaxAggregationBuilder("max").field("n"))
    }
import java.util.List;  
        Map<String, Integer> expectedDocCount = new TreeMap<>();
        AutoDateHistogramAggregationBuilder aggregation = new AutoDateHistogramAggregationBuilder("_name").setNumBuckets(10)  
        for (int i = 0; i < length; i++) {
            histogram -> {
                expectedDocCount.put("2023-10-01T00:00:00.000-04:00", 1);  
        skeletonDocCount.put("2017-02-01T09:15:00.000Z", 1);
import org.opensearch.search.aggregations.Aggregation;
                new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10)
            expectedMax.put("2020-10-01T00:00:00.000Z", 8783.0);  
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
    /**  
 * Unless required by applicable law or agreed to in writing,
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
            assertThat(maxAsMap(adh), equalTo(expectedMax));  
            assertNull(old);
    }
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),  
            dataset.add(start.plusHours(hour));
        );
        );
        }
     * 4. Bucket merging works correctly after rounding change
                assertEquals(1L, stats.getCount());  
        bucketsToExpectedDocCountMap.put(20, 10);
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2);
                        new SortedSetDocValuesField("k1", aBytes),
        List<ZonedDateTime> datesForHourInterval = Arrays.asList(
                ),  
     * The intra-segment gate for auto_date_histogram (no sub-agg): partition only when the filter-rewrite O(1)  
                    .build(
                assertEquals(expectedDocCount, bucket.getDocCount());
import org.opensearch.common.settings.Settings;  
        final IllegalArgumentException exception = expectThrows(  
                assertEquals(2, bucket.getDocCount());
                    DEFAULT_QUERY,  
        bucketsToExpectedDocCountMap.put(120, 1);  
        testSearchCase(rangeQuery, DATES_WITH_TIME, aggregation -> aggregation.setNumBuckets(4).field(DATE_FIELD), histogram -> {
        ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC),
            InternalAutoDateHistogram bdh = b.getAggregations().get("dh");  
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
                        assertThat(((InternalSimpleValue) histo.getBuckets().get(i).aggregations.get("deriv")).getValue(), equalTo(1.0));
    }
import org.apache.lucene.search.MatchNoDocsQuery;  
        expectedDocCount.put("2017-02-01T11:00:00.000-01:00", 0);  
            }
            ZonedDateTime.of(2017, 2, 1, 0, 0, 11, 380, ZoneOffset.UTC)  
            DEFAULT_QUERY,
        testSearchCase(
                    if (i > 0) {  
                assertEquals(0L, stats.getCount());  
        expectedDocCount.put("2017-02-01T08:00:00.000-01:00", 2);
        // Generate random number of documents between 20 and 200
                assertEquals(expectedDocCount, bucket.getDocCount());  
                    .field(AGGREGABLE_DATE)
import org.apache.lucene.tests.index.RandomIndexWriter;
            InternalAutoDateHistogram.Bucket bucketWithout = histogramWithoutSkiplist.getBuckets().get(i);  
        for (int hour = 0; hour < 24; hour++) {  
        long totalDocsWith = histogramWithSkiplist.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
        assertTrue(  
            expectedMax.put("2021-01-01T00:00:00.000Z", 4.0);
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertEquals("2012-05-18T04:11:00.000Z", stats.getMaxAsString());
    public void testIntervalDayWithTZ() throws IOException {
        // searchable UTC top-level, no sub-agg: fast path applies -> NOT intra-eligible
    public void testFilterRewriteWithTZRoundingRangeAssert() throws IOException {
                assertTrue(histogram.getBuckets().size() <= 8);  
            long totalDocs = histogram.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
        bucketsToExpectedDocCountMap.put(72, 1);
            ZonedDateTime.of(2017, 2, 1, 9, 35, 0, 0, ZoneOffset.UTC),
        AggregationBuilder builder = new TermsAggregationBuilder("k1").field("k1")
        // Generate random dates spanning a year  
import org.apache.lucene.search.MatchAllDocsQuery;
            long useC = dft.parse("2020-07-01T00:00Z");
        final boolean enableSkiplist,  
                assertEquals("2010-03-12T01:07:45.000Z", stats.getMinAsString());
            final ZonedDateTime date = startDate.plusMonths(i);
                    .setNumBuckets(numBuckets)
            expectedDocCount.put("2020-04-01T00:00:00.000Z", 2184);  
            });
            // Verify total doc count matches input
    }
        skeletonDocCount.put("2017-02-01T09:02:00.000Z", 2);  
                assertEquals("2010-01-01T00:00:00.000Z", bucket.getKeyAsString());
                    }  
     * Test that verifies skiplist collector handles rounding changes correctly with sub-aggregations.
    public void testSupportsIntraSegmentSearch() throws IOException {
    }
     */
                    false,
            aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD),
        final InternalAutoDateHistogram histogramWithSkiplist = runAggregation(dataset, true, numBuckets);
            // Verify total doc count is preserved after merging  
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            assertNull(old);  
            true,  
                indexSampleData(dataset, indexWriter, enableSkiplist);  
        // delete a doc to avoid approx optimization
        }  
                assertEquals("2017-12-12T22:55:46.000Z", stats.getMinAsString());
            expectedMax.clear();
        AggregationBuilder builder = new HistogramAggregationBuilder("n").field("n")
        AggregationBuilder builder = new TermsAggregationBuilder("k1").field("k1")
        final List<ZonedDateTime> dataset = new ArrayList<>();
                    aggregationBuilder,  
        // Test with random number of buckets  
    public void testNoDocs() throws IOException {  
    }
            document.add(new LongPoint(DATE_FIELD, instant));  
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());  
            ZonedDateTime.of(2017, 2, 1, 9, 16, 42, 0, ZoneOffset.UTC)  
    public void testIntervalMinute() throws IOException {  
        dataset.sort(ZonedDateTime::compareTo);
            */
     * (false); it declines for non-UTC / non-searchable → partition (true). With a sub-agg it always opts in.
import java.util.ArrayList;
                assertEquals(startDate.plusSeconds(randomIndex * expectedDocCount), bucket.getKey());
        assertEquals(
            for (int hour = 0; hour < 24; hour++) {
            final ZonedDateTime date = startDate.plusHours(i);  
            expectedMax.put("2021-01-01T00:00:00.000Z", 3.0);
            ZonedDateTime.of(2017, 2, 1, 16, 59, 0, 0, ZoneOffset.UTC)
        expectedDocCount.put("2017-02-04T00:00:00.000Z", 0);
        for (int month = 0; month < 6; month++) {
            ZonedDateTime.of(2017, 2, 1, 0, 0, 5, 15, ZoneOffset.UTC),
            assertThat(maxAsMap(ak1adh), equalTo(expectedMax));
            .missing("2017-12-12");
                docs.add(
import static org.hamcrest.Matchers.either;
            ZonedDateTime.of(2017, 2, 1, 0, 0, 11, 688, ZoneOffset.UTC),
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
                Histogram.Bucket bucket = buckets.get(0);  
            ZonedDateTime.of(2017, 2, 1, 0, 0, 7, 74, ZoneOffset.UTC),  
        });
        );  
                bucketWithout.getDocCount(),
    public void testAggregateWrongField() throws IOException {
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            Map<String, Integer> expectedDocCount = new TreeMap<>();
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),  
                assertEquals(expectedSize, buckets.size());  
                stats = bucket.getAggregations().get("stats");  
        // Add data spanning several months to trigger rounding increase (30 docs)
                assertEquals(startDate.plusMonths(randomIndex * expectedDocCount), bucket.getKey());  
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))  
        final List<ZonedDateTime> dataset,
import org.opensearch.search.aggregations.metrics.InternalStats;
    }
    );
        );  
 * under the License.  
                );
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory, c)) {
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
            assertEquals(140, totalDocs); // (5 days * 24 hours) + (5 years * 4 quarters) = 120 + 20 = 140
            long start = dft.parse("2020-01-01T00:00:00Z");  
        final List<ZonedDateTime> dates = Collections.emptyList();
