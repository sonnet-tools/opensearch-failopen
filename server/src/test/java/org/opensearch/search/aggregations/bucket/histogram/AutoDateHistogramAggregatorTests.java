            aggregation -> aggregation.setNumBuckets(8).field(DATE_FIELD),
        ZonedDateTime start = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    false,
        }
                assertEquals(10, bucket.getDocCount());
                    .subAggregation(new MaxAggregationBuilder("max").field("n"))
        );
            ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
            .missing("2017-12-12");
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
            ZonedDateTime.of(2017, 2, 1, 9, 2, 0, 0, ZoneOffset.UTC),
                final int expectedDocCount = randomEntry.getValue();
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        expectedDocCount.put("2013-01-01T00:00:00.000Z", 2);
        for (int year = 0; year < 5; year++) {
        bucketsToExpectedDocCountMap.put(10, 30);
            assertEquals(expectedDocCount.size(), buckets.size());
            expectedMax.put("2020-07-01T00:00:00.000Z", 6575.0);
            dataset.add(start.plusHours(hour));
            final ZonedDateTime date = startDate.plusMinutes(i);
        AggregationBuilder builder = new TermsAggregationBuilder("k1").field("k1")
        });
            expectedDocCount.put("2022-01-01T00:00:00.000Z", 4);
                assertEquals(length, buckets.size());
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
                }
        testCase(aggregation, DEFAULT_QUERY, iw -> {}, (Consumer<InternalAutoDateHistogram>) histogram -> {
        // Create a dataset that will trigger rounding changes
            );
    private static final List<ZonedDateTime> DATES_WITH_TIME = Arrays.asList(
     * Test that verifies bucket merging works correctly after rounding change.
            assertTrue(histogram.getBuckets().size() <= 5);
        expectedDocCount.put("2017-02-01T09:00:00.000Z", 2);
            Map<String, Integer> expectedDocCount = new TreeMap<>();
                final Histogram.Bucket bucket = buckets.get(randomIndex);
import org.apache.lucene.index.Term;
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(0, bucket.getDocCount());
                assertEquals("2016-03-04T17:09:50.000Z", stats.getMinAsString());
        asSubAggTestCase(builder, buildIndex, (InternalHistogram histo) -> {
            InternalAutoDateHistogram cdh = c.getAggregations().get("dh");
            final ZonedDateTime startDate = ZonedDateTime.of(2015, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertTrue(
                    new DateFieldMapper.DateFieldType(aggregationBuilder.field()),
        // Add hourly data for first day (24 docs)
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
            ZonedDateTime.of(2017, 2, 1, 14, 4, 0, 0, ZoneOffset.UTC),
        // Add data spanning several months to trigger rounding increase (30 docs)
            )
        });
    }
             */
                assertEquals(5, buckets.size());
        Map<String, Integer> expectedDocCount = new TreeMap<>();
    /**
        final List<ZonedDateTime> dataset = new ArrayList<>();
            histogramWithoutSkiplist.getBuckets().size(),
        }
        );
            testSearchCase(DEFAULT_QUERY, dataset, aggregation -> aggregation.setNumBuckets(60).field(DATE_FIELD), histogram -> {
        }
        final ZonedDateTime startDate = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            )
                );
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        bucketsToExpectedDocCountMap.put(10, 30);
 * The OpenSearch Contributors require contributions made to
        );
import org.apache.lucene.document.Document;
     *
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        );
        });
                "Doc count mismatch at index " + i + " for key " + bucketWithout.getKeyAsString(),
                final int expectedDocCount = randomEntry.getValue();
        for (int i = 0; i < numDocs; i++) {
                indexSampleData(multiBucketIndexData, indexWriter);
                MappedFieldType instantFieldType = new NumberFieldMapper.NumberFieldType(INSTANT_FIELD, NumberFieldMapper.NumberType.LONG);
                final int randomIndex = randomInt(19);
            assertThat(bucketCountsAsMap(bdh), equalTo(expectedDocCount));
        multiBucketIndexData must overlap with DST to produce a 'LinkedListLookup' prepared rounding.
            long start = dft.parse("2020-01-01T00:00:00Z");
                assertTrue(histogram.getBuckets().size() <= 8);
import org.apache.lucene.document.SortedSetDocValuesField;
        ZonedDateTime.of(2017, 12, 12, 22, 55, 46, 0, ZoneOffset.UTC)
            final long instant = date.toInstant().toEpochMilli();
            expectedMax.put("2020-04-01T00:00:00.000Z", 4367.0);
 * SPDX-License-Identifier: Apache-2.0
            assertThat(maxAsMap(bk1bdh), equalTo(expectedMax));
            dataset,
            ZonedDateTime.of(2017, 2, 1, 14, 5, 0, 0, ZoneOffset.UTC),
            supportsIntraSegmentSearch(
        }
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-04-01T00:00:00.000Z"), either(equalTo(21)).or(equalTo(22))));
    private static final String INSTANT_FIELD = "instant";
            assertThat(histo.getBuckets(), hasSize(100));
                ),
            }
                Histogram.Bucket bucket = buckets.get(0);
            assertThat(maxAsMap(bk1adh), equalTo(expectedMax));
                final int expectedSize = length / expectedDocCount;
        // Test with random number of buckets
                final int expectedDocCount = randomEntry.getValue();
    public void testSupportsIntraSegmentSearch() throws IOException {
                assertEquals("2014-01-01T00:00:00.000Z", bucket.getKeyAsString());
                    .build(
                true
            expectedDocCount.put("2021-01-01T00:00:00.000Z", 1);
            DEFAULT_QUERY,
        testSearchCase(
            }
    // Bugfix: https://github.com/opensearch-project/OpenSearch/issues/16932
                    fieldType,
                bucket = buckets.get(3);
                new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10)
        final Consumer<InternalAutoDateHistogram> verify
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
        for (int i = 0; i < length; i++) {
            ZonedDateTime.of(2017, 2, 5, 0, 0, 0, 0, ZoneOffset.UTC)
    }
            }
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
            ZonedDateTime.of(2017, 3, 4, 0, 0, 0, 0, ZoneOffset.UTC),
                Map<String, Integer> expectedDocCount = new TreeMap<>();
                expectedDocCount.put("2023-10-01T00:00:00.000-04:00", 1);
            ZonedDateTime.of(2017, 2, 1, 13, 6, 0, 0, ZoneOffset.UTC),
        fullDocCount.put("2017-02-01T09:12:00.000Z", 3);
            assertNull(old);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                indexSampleData(dataset, indexWriter, enableSkiplist);
        for (int day = 0; day < 5; day++) {
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            assertThat(maxAsMap(bdh), equalTo(expectedMax));
    private static final Query DEFAULT_QUERY = new MatchAllDocsQuery();
    }
            expectedDocCount.put("2020-10-01T00:00:00.000Z", 2208);
                final InternalAutoDateHistogram histogram = searchAndReduce(
        testSearchCase(DEFAULT_QUERY, dataset, true, aggregation -> aggregation.setNumBuckets(5).field(DATE_FIELD), histogram -> {
                    }
                        assertTrue(stats.getCount() > 0);
        bucketsToExpectedDocCountMap.put(300, 1);
        final List<ZonedDateTime> dataset = new ArrayList<>();
        for (int i = 0; i < length; i++) {
                return factories.allFactoriesSupportIntraSegmentSearch();
        ZonedDateTime start = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            assertEquals(0, histogram.getBuckets().size());
                assertEquals(0, histogram.getBuckets().size());
    }
            assertEquals(54, totalDocs); // 24 + 30 = 54 docs
            indexWriter.addDocument(document);
        bucketsToExpectedDocCountMap.put(150, 5);
        expectedDocCount.put("2017-02-01T00:00:00.000Z", 2);
        });
        testSearchCase(DEFAULT_QUERY, dates, aggregation, histogram -> {
    }
import org.opensearch.common.settings.Settings;
 * under the License.
        result.getBuckets().stream().forEach(b -> {
                document.add(SortedNumericDocValuesField.indexedField(DATE_FIELD, instant));
                    .setNumBuckets(4)
                assertEquals("2017-12-12T22:55:46.000Z", stats.getMaxAsString());
    public void testRandomYearIntervals() throws IOException {
        expectedDocCount.put("2017-02-01T00:00:06.000Z", 0);
 */
        expectedDocCount.put("2017-02-04T00:00:00.000-01:00", 1);
            expectedMax.clear();
 * not use this file except in compliance with the License.
    ) throws IOException {
        );
import org.opensearch.search.aggregations.pipeline.DerivativePipelineAggregationBuilder;
        assertFalse(
                final int randomIndex = randomInt(expectedSize - 1);
        skeletonDocCount.put("2017-02-01T09:16:00.000Z", 2);
            ZonedDateTime.of(2017, 2, 1, 16, 48, 0, 0, ZoneOffset.UTC),
            expectedMax.clear();
        asSubAggTestCase(builder, (StringTerms terms) -> {
        expectedDocCount.put("2011-01-01T00:00:00.000Z", 0);
                bucketWithout.getDocCount(),
            DATES_WITH_TIME,
            assertThat(bucketCountsAsMap(bk1adh), equalTo(expectedDocCount));
                        assertThat(((InternalSimpleValue) histo.getBuckets().get(i).aggregations.get("deriv")).getValue(), equalTo(1.0));
            InternalAutoDateHistogram bk1adh = bk1a.getAggregations().get("dh");
            }
                assertTrue(AggregationInspectionHelper.hasValue(stats));
            for (long d = start; d < end; d += anHour) {
                InternalAutoDateHistogram dh = b.getAggregations().get("dh");
import org.apache.lucene.tests.index.RandomIndexWriter;
            dataset.add(startDate.plusSeconds(randomOffset / 1000));
        if (enableSkiplist) {
                bucket = buckets.get(6);
                for (Histogram.Bucket bucket : histogram.getBuckets()) {
    );
                assertThat(histo.getBuckets().size(), equalTo(10));
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(expectedDocCount, bucket.getDocCount());
    public void testAggregateWrongField() throws IOException {
            final ZonedDateTime date = startDate.plusMonths(i);
        );
                    indexSearcher,
import java.time.Instant;
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-10-01T00:00:00.000Z"), either(equalTo(22)).or(equalTo(23))));
        for (int i = 0; i < length; i++) {
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
                .numberOfReplicas(0)
            datesForSecondInterval,
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
        expectedDocCount.put("2017-02-01T15:00:00.000Z", 4);
        Map<String, Integer> expectedDocCount = new TreeMap<>();
                // Verify buckets were created
        ZonedDateTime.of(2015, 11, 13, 16, 14, 34, 0, ZoneOffset.UTC),
        final Consumer<AutoDateHistogramAggregationBuilder> aggregation = agg -> agg.setNumBuckets(10).field(DATE_FIELD);
        expectedDocCount.put("2017-02-01T00:00:11.000Z", 3);
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        testSearchCase(DEFAULT_QUERY, dataset, true, aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD), histogram -> {
        testSearchCase(
    private Map<String, Integer> bucketCountsAsMap(InternalAutoDateHistogram result) {
    private void indexSampleData(List<ZonedDateTime> dataset, RandomIndexWriter indexWriter, boolean enableSkiplist) throws IOException {
            }
import org.apache.lucene.index.IndexableField;
        AggregationBuilder builder = new TermsAggregationBuilder("k1").field("k1")
    }
             * same shard to make the reduce behavior consistent.
import org.apache.lucene.document.Field;
            ZonedDateTime.of(2017, 2, 1, 0, 0, 11, 380, ZoneOffset.UTC)
        final List<ZonedDateTime> datesForMinuteInterval = Arrays.asList(
import org.apache.lucene.util.BytesRef;
        asSubAggTestCase(builder, (StringTerms terms) -> {
            aggregation -> aggregation.setNumBuckets(8)
                stats = bucket.getAggregations().get("stats");
                );
            i += 1;
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
            )
    }
    public void testAsSubAggInManyBuckets() throws IOException {
import org.apache.lucene.document.LongPoint;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
            assertFalse(histogram.getBuckets().isEmpty());
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
        This lookup rounding style maintains a strict max/min input range and will assert each value is in range.
            ZonedDateTime.of(2017, 2, 1, 16, 48, 0, 0, ZoneOffset.UTC),
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        final IllegalArgumentException exception = expectThrows(
            indexWriter.commit();
            DEFAULT_QUERY,
            histogram -> {
            }
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals(1, buckets.size());
                bucket = buckets.get(7);
            Map<String, Double> expectedMax = new TreeMap<>();
        // non-UTC timezone, no sub-agg: fast path declines -> intra-eligible
            histogram -> {
        bucketsToExpectedDocCountMap.put(60, 5);
                    .setNumBuckets(numBuckets)
            histogram -> {
        }, fieldType);
import org.apache.lucene.search.Query;
import org.apache.lucene.document.SortedNumericDocValuesField;
        }
            }
        // non-searchable field, no sub-agg: fast path declines -> intra-eligible
            assertThat(bucketCountsAsMap(adh), equalTo(expectedDocCount));
        expectedDocCount.put("2017-02-01T00:00:00.000-01:00", 2);
        );
        // searchable UTC top-level, no sub-agg: fast path applies -> NOT intra-eligible
    public void testAsSubAgg() throws IOException {
     * 4. Bucket merging works correctly after rounding change
                        .field(NUMERIC_FIELD)
                if (configure != null) {
        assertThat(exception.getMessage(), Matchers.containsString("must be less than"));
        // Sort dataset to ensure consistent ordering
            expectedMax.put("2020-01-01T00:00:00.000Z", 2.0);
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
        expectedDocCount.put("2017-02-01T09:00:00.000Z", 3);
        }
            DEFAULT_QUERY,
        expectedDocCount.put("2017-02-01T00:00:07.000Z", 2);
package org.opensearch.search.aggregations.bucket.histogram;
            buckets.forEach(bucket -> assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount()));
        final Consumer<InternalAutoDateHistogram> verify
    /**
        final List<ZonedDateTime> datesForMonthInterval = Arrays.asList(
            dataset.add(date);
        testSearchCase(
 *
            dataset,
        final int numDocs = randomIntBetween(20, 200);
        );
            final Map<ZonedDateTime, Integer> expectedDocCount = new HashMap<>();
        bucketsToExpectedDocCountMap.put(3, 60);
                assertFalse(AggregationInspectionHelper.hasValue(stats));
        AggregationBuilder builder = new HistogramAggregationBuilder("n").field("n")
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
            ZonedDateTime.of(2017, 2, 1, 14, 4, 0, 0, ZoneOffset.UTC),
    }
            iw.addDocuments(docs);
                assertEquals(0L, stats.getCount());
            expectedDocCount.put("2020-04-01T00:00:00.000Z", 2184);
            BytesRef aBytes = new BytesRef("a");
            iw.addDocuments(docs);
        );
            expectedMax.put("2021-03-01T00:00:00.000Z", 4.0);
            ZonedDateTime.of(2017, 2, 1, 0, 0, 5, 15, ZoneOffset.UTC),
                .build(),
                assertEquals(startDate.plusMonths(randomIndex), bucket.getKey());
            final ZonedDateTime date = startDate.plusHours(i);
        // Create dataset that triggers rounding change
            dataset.add(date);
 * license agreements. See the NOTICE file distributed with
        );
    ) throws IOException {
                final Histogram.Bucket bucket = buckets.get(randomIndex);
        try (Directory directory = newDirectory()) {
        }
                    List.of(
        expectedDocCount.put("2017-02-01T12:00:00.000Z", 3);
                new AutoDateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
            }
                assertEquals(expectedDocCount, bucket.getDocCount());
        }
        final int numBuckets = randomIntBetween(5, 20);
                stats = bucket.getAggregations().get("stats");
        final int length = 72;
import org.apache.lucene.index.IndexWriterConfig;
                assertEquals(expectedDocCount, bucket.getDocCount());
                    .field(AGGREGABLE_DATE)
 * Licensed to Elasticsearch under one or more contributor
        bucketsToExpectedDocCountMap.put(25, 20);
            dataset,
            StringTerms.Bucket b = terms.getBucketByKey("b");
        ZonedDateTime.of(2016, 3, 4, 17, 9, 50, 0, ZoneOffset.UTC),
        final int randomChoice = randomIntBetween(1, 3);
            if (enableSkiplist) {
        }
                assertEquals(0L, stats.getCount());
        }
    /**
            expectedDocCount.put("2021-01-01T00:00:00.000Z", 4);
            expectedMax.clear();
    }
                long totalDocs = histogram.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
        // Create dataset with fine-grained data that will be merged into coarser buckets
            expectedDocCount.put("2024-01-01T00:00:00.000Z", 4);
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
                assertEquals(0, bucket.getDocCount());
            assertThat(bucketCountsAsMap(ak1adh), equalTo(expectedDocCount));
        );
                new AutoDateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
            ZonedDateTime.of(2017, 2, 1, 10, 15, 0, 0, ZoneOffset.UTC),
            assertTrue(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(YearMonth.from(startDate.plusMonths(randomIndex)).lengthOfMonth(), bucket.getDocCount());
                final int expectedSize = length / expectedDocCount;
            try (IndexReader reader = indexWriter.getReader()) {
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
                }
        });
        dataset.sort(ZonedDateTime::compareTo);
        );
                    }
    public void testUnmappedMissing() throws IOException {
import org.apache.lucene.document.StringField;
            expectedDocCount.clear();
    }
            expectedMax.put("2021-01-01T00:00:00.000Z", 4.0);
import java.util.ArrayList;
                assertEquals(expectedSize, buckets.size());
    }
        testSearchCase(
        expectedDocCount.put("2017-02-01T15:00:00.000Z", 1);
            for (long d = start; d < end; d += anHour) {
        long totalDocsWith = histogramWithSkiplist.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
    public void testSkiplistCollectorWithRoundingChange() throws IOException {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        // This forces rounding to increase from hours -> days -> months -> years
        assertFalse(
import java.util.concurrent.TimeUnit;
                InternalStats stats = bucket.getAggregations().get("stats");
        if (randomChoice == 1) {
            nodeSettings
import org.opensearch.search.aggregations.metrics.InternalStats;
            ZonedDateTime.of(2023, 10, 10, 0, 0, 0, 0, ZoneOffset.UTC),
                MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType(NUMERIC_FIELD, NumberFieldMapper.NumberType.LONG);
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        bucketsToExpectedDocCountMap.put(10, 50);
        final boolean enableSkiplist,
                        .interval(1)
                        assertTrue(AggregationInspectionHelper.hasValue(stats));
        testSearchCase(
            ZonedDateTime.of(2017, 2, 1, 15, 59, 0, 0, ZoneOffset.UTC),
        );
            InternalAutoDateHistogram.Bucket bucketWith = histogramWithSkiplist.getBuckets().get(i);
            });
import org.opensearch.Version;
                assertTrue(((ZonedDateTime) buckets.get(i - 1).getKey()).isBefore((ZonedDateTime) buckets.get(i).getKey()));
        expectedDocCount.put("2017-02-01T10:00:00.000Z", 1);
                assertEquals("2012-05-18T04:11:00.000Z", stats.getMinAsString());
            StringTerms.Bucket bk1a = bk1.getBucketByKey("a");
            assertEquals(0, histogram.getBuckets().size());
        testSearchCase(
        assertEquals("Total doc count mismatch", totalDocsWithout, totalDocsWith);
     * Test that verifies FromSingle.increaseRoundingIfNeeded() works correctly with skiplist collector.
            dataset.add(date);
            assertEquals("Bucket key mismatch at index " + i, bucketWithout.getKey(), bucketWith.getKey());
                AggregatorFactories factories = AggregatorFactories.builder()
     * Uses random number of documents (20-200) and random date distribution.
    private InternalAutoDateHistogram runAggregation(List<ZonedDateTime> dataset, boolean enableSkiplist, int numBuckets)
            }
                assertEquals("2016-01-01T00:00:00.000Z", bucket.getKeyAsString());
        expectedDocCount.put("2017-02-01T13:00:00.000-01:00", 2);
        }
            // Verify total doc count matches input
                assertEquals(startDate.plusYears(randomIndex * expectedDocCount), bucket.getKey());
            testSearchCase(DEFAULT_QUERY, dataset, aggregation -> aggregation.setNumBuckets(6).field(DATE_FIELD), histogram -> {
        final InternalAutoDateHistogram histogramWithSkiplist = runAggregation(dataset, true, numBuckets);
        bucketsToExpectedDocCountMap.put(60, 5);
    }
import org.apache.lucene.index.IndexReader;
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
                Histogram.Bucket bucket = buckets.get(0);
        );
            histogramWithSkiplist.getBuckets().size()
                final int expectedSize = length / expectedDocCount;
                indexSampleData(dataset, indexWriter, enableSkiplist);
            final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
            long end = dft.parse("2021-01-01T00:00:00Z");
                    aggregationBuilder,
     * (false); it declines for non-UTC / non-searchable → partition (true). With a sub-agg it always opts in.
                final InternalAutoDateHistogram histogram = searchAndReduce(
                DATES_WITH_TIME,
        final List<ZonedDateTime> dataset = new ArrayList<>();
    }
        testSearchCase(
                histogram -> fail()
        expectedDocCount.put("2017-01-01T00:00:00.000Z", 1);
            fullDocCount.put(String.format(Locale.ROOT, "2017-02-01T09:%02d:00.000Z", minute), 0);
    }
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                true
            ZonedDateTime.of(2017, 2, 1, 13, 6, 0, 0, ZoneOffset.UTC),
        expectedDocCount.put("2010-01-01T00:00:00.000Z", 2);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        }
                    .field(DATE_FIELD);
             * same shard to make the reduce behavior consistent.
            DEFAULT_QUERY,
        final List<ZonedDateTime> datesForHourInterval = Arrays.asList(
        // Run aggregation without skiplist
        for (int i = 0; i < length; i++) {
                    configure.accept(aggregationBuilder);
                stats = bucket.getAggregations().get("stats");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(result.getBuckets().size());
            StringTerms ak1 = a.getAggregations().get("k1");
 * You may obtain a copy of the License at
            result -> assertThat(bucketCountsAsMap(result), equalTo(fullDocCount))
        });
            ZonedDateTime.of(2017, 2, 1, 9, 35, 0, 0, ZoneOffset.UTC),
            expectedMax.put("2020-02-01T00:00:00.000Z", 5.0);
        });
            assertThat(maxAsMap(cdh), equalTo(expectedMax));
            }
                    .subAggregation(new MaxAggregationBuilder("max").field("n"))
            // Verify total doc count is preserved after merging
    }
                assertEquals(startDate.plusHours(randomIndex * expectedDocCount), bucket.getKey());
            aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD),
            dataset.add(date);
        for (int minute = 3; minute < 15; minute++) {
 * ownership. Elasticsearch licenses this file to you under
    }
            ZonedDateTime.of(2017, 2, 1, 16, 6, 0, 0, ZoneOffset.UTC),
        ZonedDateTime.of(2010, 3, 12, 1, 7, 45, 0, ZoneOffset.UTC),
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-01-01T00:00:00.000Z"), either(equalTo(21)).or(equalTo(22))));
            // Verify buckets were created and merged appropriately
                    .addAggregator(builder)
     */
            }
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        ZonedDateTime.of(2015, 6, 24, 13, 47, 43, 0, ZoneOffset.UTC),
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        );
    public void testMatchAllDocs() throws IOException {
        // delete a doc to avoid approx optimization
             * Intentionally add all documents at once to put them on the
            ZonedDateTime.of(2017, 3, 5, 0, 0, 0, 0, ZoneOffset.UTC),
        final List<ZonedDateTime> datesForSecondInterval = Arrays.asList(
            dataset,
import org.opensearch.index.IndexSettings;
            document.add(new SortedNumericDocValuesField(NUMERIC_FIELD, i));
                assertTrue(Double.isInfinite(stats.getMin()));
            DEFAULT_QUERY,
        testSearchCase(
                verify.accept(histogram);
                .subAggregation(
                        new SortedSetDocValuesField("k1", d < useC ? bBytes : cBytes),
    }
            ZonedDateTime.of(2017, 2, 1, 16, 6, 0, 0, ZoneOffset.UTC),
                assertEquals("2011-01-01T00:00:00.000Z", bucket.getKeyAsString());
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
            ZonedDateTime.of(2017, 2, 1, 9, 16, 42, 0, ZoneOffset.UTC)
                    .setNumBuckets(4)
                assertEquals(3, bucket.getDocCount());
        result.getBuckets().stream().forEach(b -> {
        expectedDocCount.put("2017-02-01T15:00:00.000-01:00", 3);
    }
        final List<ZonedDateTime> dates = Collections.emptyList();
        // Add data spanning months to trigger rounding increase
            StringTerms.Bucket a = terms.getBucketByKey("a");
     * This ensures that when rounding changes mid-collection, sub-aggregations still produce correct results.
import static org.hamcrest.Matchers.either;
     * 3. owningBucketOrd is always 0 in FromSingle context
            result -> assertThat(bucketCountsAsMap(result), equalTo(fullDocCount))
            ZonedDateTime.of(2017, 2, 1, 0, 0, 11, 210, ZoneOffset.UTC),
        expectedDocCount.put("2017-02-01T12:00:00.000Z", 0);
                        null
        expectedDocCount.put("2017-02-01T00:00:00.000Z", 1);
        );
                MappedFieldType instantFieldType = new NumberFieldMapper.NumberFieldType(INSTANT_FIELD, NumberFieldMapper.NumberType.LONG);
                assertEquals("2010-04-27T03:43:34.000Z", stats.getMaxAsString());
            document.add(new StringField("someField", "a", Field.Store.NO));
        final Consumer<AutoDateHistogramAggregationBuilder> configure,
            */
            NumberFieldMapper.NumberFieldType nft = new NumberFieldMapper.NumberFieldType("n", NumberFieldMapper.NumberType.LONG);
        Map<String, Integer> expectedDocCount = new TreeMap<>();
import org.opensearch.search.aggregations.AggregatorFactories;
        // Start with hourly data, then add data that spans months to force rounding increase
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD),
                    instantFieldType,
    }
/*
    private void testSearchCase(
            expectedDocCount.put("2020-02-01T00:00:00.000Z", 1);
            InternalAutoDateHistogram bdh = b.getAggregations().get("dh");
import org.apache.lucene.search.IndexSearcher;
            }
        expectedDocCount.put("2017-02-01T14:00:00.000Z", 2);
            histogram -> {
                assertEquals(2, bucket.getDocCount());
                expectedMax.put("2020-07-01T00:00:00.000Z", (double) n);
        final List<ZonedDateTime> dataset,
        builder = new TermsAggregationBuilder("k2").field("k2").subAggregation(builder);
        final int length = 140;
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
            for (int i = 1; i < buckets.size(); i++) {
                new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10)
            expectedMax.put("2020-04-01T00:00:00.000Z", 4367.0);
    public void testIntervalSecond() throws IOException {
import org.opensearch.common.CheckedBiConsumer;
import java.util.HashMap;
            }
                assertEquals(startDate.plusDays(randomIndex), bucket.getKey());
        final Settings nodeSettings = Settings.builder().put("search.max_buckets", 25000).build();
                assertEquals("2010-03-12T01:07:45.000Z", stats.getMinAsString());
        final List<ZonedDateTime> dataset,
                true
import java.util.TreeMap;
         */
        });
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
            assertThat(bucketCountsAsMap(bdh), equalTo(expectedDocCount));
        expectedDocCount.put("2017-02-04T00:00:00.000Z", 0);
                new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10)
                assertEquals("2016-03-04T17:09:50.000Z", stats.getMaxAsString());
            expectedMax.put("2020-10-01T00:00:00.000Z", 8783.0);
import org.opensearch.cluster.metadata.IndexMetadata;
                return searchAndReduce(indexSearcher, DEFAULT_QUERY, aggregationBuilder, fieldType, instantFieldType, numericFieldType);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    if (i > 0) {
            new MatchNoDocsQuery(),
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
                final AutoDateHistogramAggregationBuilder aggregationBuilder = new AutoDateHistogramAggregationBuilder("_name");
                assertEquals("2015-02-13T13:09:32.000Z", stats.getMinAsString());
                dataset.add(start.plusMonths(month).plusDays(day * 6));
                assertEquals(expectedSize, buckets.size());
import org.apache.lucene.index.NoMergePolicy;
            assertThat(bucketCountsAsMap(cdh), equalTo(expectedDocCount));
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2);
        );
            expectedMax.put("2021-01-01T00:00:00.000Z", 3.0);
         */
            ZonedDateTime.of(2017, 2, 3, 0, 0, 0, 0, ZoneOffset.UTC),
                    )
        expectedDocCount.put("2014-01-01T00:00:00.000Z", 0);
    }
        );
                indexSampleData(singleBucketIndexData, indexWriter);
    public void testIntervalDayWithTZ() throws IOException {
                assertEquals("2015-11-13T16:14:34.000Z", stats.getMaxAsString());
        assertEquals("Total doc count should match input", numDocs, totalDocsWithout);
                    new NumberFieldMapper.NumberFieldType(NUMERIC_FIELD, NumberFieldMapper.NumberType.LONG)
    // @timestamp field name by default uses skip_list
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
        // Run aggregation with skiplist
        expectedDocCount.put("2017-01-31T00:00:00.000-01:00", 1);
     */
            testSearchCase(DEFAULT_QUERY, dataset, aggregation -> aggregation.setNumBuckets(length).field(DATE_FIELD), histogram -> {
        for (final ZonedDateTime date : dataset) {
        try (Directory directory = newDirectory()) {
        // Add hourly data for multiple days, then add data spanning years
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    public void testRandomDayIntervals() throws IOException {
                expectedDocCount.put("2023-11-01T00:00:00.000-04:00", 1);
        fullDocCount.put("2017-02-01T09:02:00.000Z", 2);
            dataset,
import java.util.List;
import java.time.ZoneId;
import java.util.Map;
         * No-op.
    public void testSkiplistCollectorRoundingChangeWithSubAggs() throws IOException {
            long totalDocs = histogram.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
            InternalAutoDateHistogram.Bucket bucketWithout = histogramWithoutSkiplist.getBuckets().get(i);
        bucketsToExpectedDocCountMap.put(12, 12);
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
            }
                    .timeZone(ZoneId.of("America/New_York")),
            ZonedDateTime.of(2017, 2, 1, 9, 2, 0, 0, ZoneOffset.UTC),
        for (int month = 0; month < 6; month++) {
/*
    public void testIntervalHourWithTZ() throws IOException {
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
                bucket = buckets.get(1);
    public void testSkiplistCollectorBucketMergingAfterRoundingChange() throws IOException {
        }
        expectedDocCount.put("2015-01-01T00:00:00.000Z", 3);
            indexWriter.addDocument(document);
 * this file be licensed under the Apache-2.0 license or a
            assertThat(bucketCountsAsMap(bk1bdh), equalTo(expectedDocCount));
        final Document document = new Document();
                    assertThat(histo.getBuckets().get(i).key, equalTo((double) i));
 * the Apache License, Version 2.0 (the "License"); you may
            final ZonedDateTime date = startDate.plusSeconds(i);
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
                stats = bucket.getAggregations().get("stats");
                        new SortedNumericDocValuesField(AGGREGABLE_DATE, d),
        expectedDocCount.put("2017-01-01T00:00:00.000Z", 1);
                expectedMax.put("2020-01-01T00:00:00.000Z", (double) n);
    public void testIntervalMonth() throws IOException {
        );
        AutoDateHistogramAggregationBuilder aggregation = new AutoDateHistogramAggregationBuilder("_name").setNumBuckets(10)
                assertEquals(startDate.plusMinutes(randomIndex * expectedDocCount), bucket.getKey());
        testSearchCase(
                assertEquals(1L, stats.getCount());
            DEFAULT_QUERY,
                final int expectedSize = length / expectedDocCount;
            ZonedDateTime.of(2017, 2, 1, 9, 35, 0, 0, ZoneOffset.UTC),
import java.util.LinkedHashMap;
    }
            ZonedDateTime.of(2017, 2, 1, 9, 16, 4, 0, ZoneOffset.UTC),
                docs.add(
            datesForHourInterval,
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
            aggregation -> aggregation.setNumBuckets(1)
            for (int day = 0; day < 5; day++) {
                InternalHistogram.Bucket b = histo.getBuckets().get(n);
        );
        );
    }
                    aggregationBuilder,
    /**
                InternalHistogram histo = (InternalHistogram) bucket.getAggregations().asList().get(0);
        final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType("date_field");
        bucketsToExpectedDocCountMap.put(120, 1);
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            Object old = map.put(b.getKeyAsString(), Math.toIntExact(b.getDocCount()));
import java.util.Arrays;
            // Verify buckets were created (exact count depends on rounding chosen)
            DateFieldMapper.DateFieldType dft = aggregableDateFieldType(false, searchable);
    }
                assertFalse(histogram.getBuckets().isEmpty());
        fullDocCount.putAll(skeletonDocCount);
            for (int day = 0; day < 3; day++) {
            expectedDocCount.put("2021-03-01T00:00:00.000Z", 1);
        expectedDocCount.put("2017-02-02T00:00:00.000-01:00", 3);
    @Override
            StringTerms.Bucket b = terms.getBucketByKey("b");
        expectedDocCount.put("2016-01-01T00:00:00.000Z", 1);
        expectedDocCount.put("2017-02-01T00:00:10.000Z", 0);
            datesForDayInterval,
        final InternalAutoDateHistogram histogramWithoutSkiplist = runAggregation(dataset, false, numBuckets);
        expectedDocCount.put("2017-02-01T09:00:00.000-01:00", 1);
     */
    }
 *
            DEFAULT_QUERY,
     * Test that verifies skiplist and non-skiplist collectors produce identical results.
            expectedMax.put("2020-01-01T00:00:00.000Z", 2.0);
    public void testWithPipelineReductions() throws IOException {
 * compatible open source license.
                final AutoDateHistogramAggregationBuilder aggregationBuilder = new AutoDateHistogramAggregationBuilder("_name")
        bucketsToExpectedDocCountMap.put(30, 3);
            InternalAutoDateHistogram adh = a.getAggregations().get("dh");
            }
        testSearchCase(
        final int length = 300;
            final ZonedDateTime date = startDate.plusYears(i);
        ZonedDateTime.of(2013, 5, 29, 5, 11, 31, 0, ZoneOffset.UTC),
                assertEquals(36, totalDocs); // 12 months * 3 days = 36 docs
            // Verify that aggregation completed successfully
            DEFAULT_QUERY,
                            .getQueryShardContext(),
            StringTerms.Bucket a = terms.getBucketByKey("a");
                dataset.add(start.plusMonths(month).plusDays(day * 10));
        final int length = 60;
                assertEquals("2015-01-01T00:00:00.000Z", bucket.getKeyAsString());
            expectedDocCount.put("2020-04-01T00:00:00.000Z", 2184);
/*
                    .timeZone(ZoneId.of("America/New_York"))
        CheckedBiConsumer<RandomIndexWriter, DateFieldMapper.DateFieldType, IOException> buildIndex = (iw, dft) -> {
import java.io.IOException;
                assertTrue(Double.isInfinite(stats.getMax()));
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
            InternalMax max = b.getAggregations().get("max");
        ZonedDateTime.of(2013, 10, 31, 8, 24, 5, 0, ZoneOffset.UTC),
}
            aggregation -> aggregation.setNumBuckets(8)
                    );
                DEFAULT_QUERY,
            histogram -> {
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
            ZonedDateTime.of(2017, 3, 6, 0, 0, 0, 0, ZoneOffset.UTC)
 * GitHub history for details.
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory, c)) {
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                    AggregationBuilders.histogram("histo")
                    .setNumBuckets(3)
 * specific language governing permissions and limitations
        );
    }
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals("2013-01-01T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2013-05-29T05:11:31.000Z", stats.getMinAsString());
                assertEquals(2L, stats.getCount());
            });
                MappedFieldType numericFieldType = new NumberFieldMapper.NumberFieldType(NUMERIC_FIELD, NumberFieldMapper.NumberType.LONG);
            Map<String, Double> expectedMax = new TreeMap<>();
        );
            assertTrue(AggregationInspectionHelper.hasValue(histogram));
            assertEquals(0, histogram.getBuckets().size());
                n++;
        // with a sub-aggregation AND fast path declines (non-UTC): intra-eligible (doc-by-doc parallelizes)
     * The intra-segment gate for auto_date_histogram (no sub-agg): partition only when the filter-rewrite O(1)
                assertEquals(2, bucket.getDocCount());
                .numberOfShards(1)
import org.apache.lucene.store.Directory;
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        testSearchCase(
            DEFAULT_QUERY,
        );
            assertEquals(0, histogram.getBuckets().size());
    public void testIntervalHour() throws IOException {
            DEFAULT_QUERY,
        });
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
        ZonedDateTime.of(2015, 2, 13, 13, 9, 32, 0, ZoneOffset.UTC),
            expectedMax.put("2020-02-01T00:00:00.000Z", 5.0);
            ZonedDateTime.of(2023, 11, 11, 0, 0, 0, 0, ZoneOffset.UTC)
                .creationDate(System.currentTimeMillis())
                        new SortedNumericDocValuesField("n", n++)
                for (int i = 0; i < 10; i++) {
                        .subAggregation(AggregationBuilders.max("max").field(NUMERIC_FIELD))
            Map<String, Integer> expectedDocCount = new TreeMap<>();
            long anHour = dft.resolution().convert(Instant.ofEpochSecond(TimeUnit.HOURS.toSeconds(1)));
import org.opensearch.search.aggregations.Aggregation;
            }
        expectedDocCount.put("2017-02-01T10:00:00.000-01:00", 0);
                final int randomIndex = randomInt(length - 1);
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2);
    }
            for (int hour = 0; hour < 24; hour++) {
            supportsIntraSegmentSearch(
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
        Map<String, Integer> expectedDocCount = new TreeMap<>();
    @Override
        expectedDocCount.put("2017-02-02T00:00:00.000Z", 2);
        skeletonDocCount.put("2017-02-01T09:15:00.000Z", 1);
            assertThat(bucketCountsAsMap(histogram), equalTo(expectedDocCount));
        final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType("date_field");
            expectedMax.clear();
                    .field(AGGREGABLE_DATE)
            ZonedDateTime.of(2017, 2, 1, 15, 59, 0, 0, ZoneOffset.UTC),
        indexSampleData(dataset, indexWriter, false);
                    query,
        bucketsToExpectedDocCountMap.put(6, 12);
            expectedDocCount.put(startDate, 3);
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
            );
            long anHour = dft.resolution().convert(Instant.ofEpochSecond(TimeUnit.HOURS.toSeconds(1)));
                final int expectedDocCount = 7;
            expectedMax.put("2020-07-01T00:00:00.000Z", 6575.0);
                expectedDocCount.put("2023-12-01T00:00:00.000-05:00", 1);
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
                final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(aggregationBuilder.field());
            StringTerms.Bucket bk1b = bk1.getBucketByKey("b");
        ZonedDateTime.of(2010, 4, 27, 3, 43, 34, 0, ZoneOffset.UTC),
            }
     */
            /*
    }
        testCase(aggregation, DEFAULT_QUERY, iw -> {}, (Consumer<InternalAutoDateHistogram>) histogram -> {
        expectedDocCount.put("2017-02-01T11:00:00.000-01:00", 0);
            IllegalArgumentException.class,
        final List<ZonedDateTime> datesForDayInterval = Arrays.asList(
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
            }
        final Map.Entry<Integer, Integer> randomEntry = randomFrom(bucketsToExpectedDocCountMap.entrySet());
                final int randomIndex = randomInt(expectedSize - 1);
    }
        } else if (randomChoice == 2) {
                assertEquals(3L, stats.getCount());
            }
    public void testIntervalMinute() throws IOException {
            expectedMax.put("2020-10-01T00:00:00.000Z", 8783.0);
                    .subAggregation(new MaxAggregationBuilder("max").field("n"))
            ZonedDateTime.of(2017, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC),
        expectedDocCount.put("2017-02-01T11:00:00.000Z", 0);
                final AutoDateHistogramAggregationBuilder aggregationBuilder = new AutoDateHistogramAggregationBuilder("_name");
                assertThat(bucket.getAggregations().asList().size(), equalTo(1));
     *
            histogram -> {
        testSearchCase(query, dataset, false, configure, verify);
            Object old = map.put(b.getKeyAsString(), max.getValue());
        );
        return map;
        final Consumer<AutoDateHistogramAggregationBuilder> configure,
    }
import java.util.Collections;
        try (Directory directory = newDirectory()) {
            assertNull(old);
            DEFAULT_QUERY,
            int n = 0;
                assertEquals(expectedDocCount, bucket.getDocCount());
            /*
            );
    public void testRandomSecondIntervals() throws IOException {
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
                assertThat(maxAsMap(dh), equalTo(expectedMax));
        expectedDocCount.put("2017-02-05T00:00:00.000Z", 1);
            true,
        return new IndexSettings(
        expectedDocCount.put("2017-02-01T16:00:00.000Z", 3);
        /*
            ZonedDateTime.of(2017, 2, 1, 9, 2, 35, 0, ZoneOffset.UTC),
    public void testMatchNoDocs() throws IOException {
        testSearchCase(
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(startDate.plusDays(randomIndex * expectedDocCount), bucket.getKey());
    }
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        assertTrue(
            ZonedDateTime.of(2017, 2, 1, 0, 0, 11, 688, ZoneOffset.UTC),
            StringTerms.Bucket a = terms.getBucketByKey("a");
            expectedDocCount.put("2020-02-01T00:00:00.000Z", 1);
                assertEquals(2L, stats.getCount());
                bucket = buckets.get(2);
        final long yearInMillis = 365L * 24 * 60 * 60 * 1000;
            StringTerms.Bucket ak1a = ak1.getBucketByKey("a");
                    InternalStats stats = bucket.getAggregations().get("stats");
            ZonedDateTime.of(2017, 2, 2, 0, 0, 0, 0, ZoneOffset.UTC),
                // Force agg to update rounding when it begins collecting from the second segment.
        expectedDocCount.put("2017-02-01T00:00:05.000Z", 1);
        final List<ZonedDateTime> datesForDayInterval = Arrays.asList(
        final int length = 120;
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
        // Generate random dates spanning a year
 *    http://www.apache.org/licenses/LICENSE-2.0
            IndexWriterConfig c = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            document.clear();
                final int expectedSize = length / expectedDocCount;
            datesForMinuteInterval,
                indexWriter.flush();
        }
        expectedDocCount.put("2012-01-01T00:00:00.000Z", 1);
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
        bucketsToExpectedDocCountMap.put(60, 1);
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
                assertFalse(AggregationInspectionHelper.hasValue(stats));
        testSearchCase(
                // since an exception is thrown, this assertion won't be invoked.
        ZonedDateTime start = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                assertEquals("2012-01-01T00:00:00.000Z", bucket.getKeyAsString());
        testSearchCase(DEFAULT_QUERY, dates, aggregation, histogram -> {
 */
            }
    public void testRandomMinuteIntervals() throws IOException {
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            aggregation -> aggregation.setNumBuckets(10).field(DATE_FIELD).timeZone(ZoneOffset.ofHours(-1)),
        final Query query,
                        .subAggregation(new DerivativePipelineAggregationBuilder("deriv", "max"))
    protected IndexSettings createIndexSettings() {
    private Map<String, Double> maxAsMap(InternalAutoDateHistogram result) {
                assertEquals("2017-12-12T22:55:46.000Z", stats.getMinAsString());
            long start = dft.parse("2020-01-01T00:00:00Z");
 * KIND, either express or implied.  See the License for the
        }
                final int randomIndex = randomInt(expectedSize - 1);
        Map<String, Integer> skeletonDocCount = new TreeMap<>();
            DEFAULT_QUERY,
        ZonedDateTime.of(2012, 5, 18, 4, 11, 0, 0, ZoneOffset.UTC),
        // Generate random number of documents between 20 and 200
            ZonedDateTime.of(2017, 2, 5, 0, 0, 0, 0, ZoneOffset.UTC)
        asSubAggTestCase(builder, buildIndex, (StringTerms terms) -> {
            expectedDocCount.clear();
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
            prepared rounding produced by the filter rewrite optimization considering seg 2 for optimized path.
            DEFAULT_QUERY,
            IndexMetadata.builder("_index")
                docs.add(List.of(new SortedNumericDocValuesField(AGGREGABLE_DATE, d), new SortedNumericDocValuesField("n", n % 100)));
    private void testSearchCase(
            InternalAutoDateHistogram bdh = b.getAggregations().get("dh");
            Map<String, Integer> expectedDocCount = new TreeMap<>();
        skeletonDocCount.put("2017-02-01T09:02:00.000Z", 2);
            }
                    assertNotNull(stats);
            long randomOffset = randomLongBetween(0, yearInMillis);
        assertEquals(
        final int length = 120;
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            expectedDocCount.clear();
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            StringTerms.Bucket c = terms.getBucketByKey("c");
public class AutoDateHistogramAggregatorTests extends DateHistogramAggregatorTestCase {
        for (int i = 0; i < length; i++) {
                );
            document.add(new LongPoint(DATE_FIELD, instant));
            .subAggregation(
        final List<ZonedDateTime> singleBucketIndexData = Arrays.asList(ZonedDateTime.of(2023, 12, 27, 0, 0, 0, 0, ZoneOffset.UTC));
        assertTrue(
                assertEquals(1, bucket.getDocCount());
     * 2. New Rounding.Prepared instance is created on rounding change
            indexWriter.deleteDocuments(new TermQuery(new Term("someField", "a")));
            }
        expectedDocCount.put("2017-02-01T12:00:00.000-01:00", 1);
        return map;
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                final int expectedDocCount = randomEntry.getValue();
    }
import java.time.YearMonth;
        testSearchCase(
                .field(DATE_FIELD)
            DEFAULT_QUERY,
                Map<String, Double> expectedMax = new TreeMap<>();
        );
    public void testWithLargeNumberOfBuckets() {
            expectedDocCount.put(startDate.plusYears(1), 1);
            supportsIntraSegmentSearch(new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10).field(AGGREGABLE_DATE), false)
            DATES_WITH_TIME,
                assertEquals(startDate.plusSeconds(randomIndex * expectedDocCount), bucket.getKey());
                .field(DATE_FIELD)
                assertEquals("2010-01-01T00:00:00.000Z", bucket.getKeyAsString());
            expectedDocCount.put("2021-01-01T00:00:00.000Z", 2);
            datesForDayInterval,
            DEFAULT_QUERY,
        );
        expectedDocCount.put("2017-02-03T00:00:00.000-01:00", 0);
        bucketsToExpectedDocCountMap.put(5, 100);
        // Add data spanning multiple years to force coarse rounding
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
        bucketsToExpectedDocCountMap.put(3, 24);
            histogram -> {
        fullDocCount.put("2017-02-01T09:07:00.000Z", 0);
        bucketsToExpectedDocCountMap.put(50, 10);
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2184);
    public void testFilterRewriteWithTZRoundingRangeAssert() throws IOException {
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 124); // 5 * 24 hours + 4 quarters
        }
                assertTrue(AggregationInspectionHelper.hasValue(stats));
            }
    public void testIntervalDay() throws IOException {
        bucketsToExpectedDocCountMap.put(120, 1);
            Map<String, Double> expectedMax = new TreeMap<>();
                final Histogram.Bucket bucket = buckets.get(randomIndex);
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            expectedMax.put("2020-01-01T00:00:00.000Z", 2183.0);
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                // Verify sub-aggregations are present and valid
                bucketWith.getDocCount()
                assertEquals(1, bucket.getDocCount());
            .field("bogus_bogus");
                final Histogram.Bucket bucket = buckets.get(randomIndex);
                assertEquals(expectedSize, buckets.size());
                assertEquals("2013-10-31T08:24:05.000Z", stats.getMaxAsString());
        bucketsToExpectedDocCountMap.put(3, 60);
        final List<ZonedDateTime> dataset = new ArrayList<>(numDocs);
                assertEquals(8, buckets.size());
                assertEquals("2010-01-01T00:00:00.000Z", bucket.getKeyAsString());
    }
 * this work for additional information regarding copyright
        final Query query,
                IndexSearcher searcher = newIndexSearcher(reader);
            ZonedDateTime.of(2017, 2, 1, 9, 2, 59, 0, ZoneOffset.UTC),
             * Intentionally add all documents at once to put them on the
                    if (bucket.getDocCount() > 0) {
            ZonedDateTime.of(2017, 2, 1, 9, 15, 37, 0, ZoneOffset.UTC),
import org.apache.lucene.search.TermQuery;
            // Verify buckets are in ascending order (requirement for histogram)
        });
            StringTerms.Bucket b = terms.getBucketByKey("b");
                new AutoDateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
import org.apache.lucene.search.MatchAllDocsQuery;
    public void testSkiplistEquivalence() throws IOException {
                assertTrue(Double.isInfinite(stats.getMin()));
            assertTrue(AggregationInspectionHelper.hasValue(histogram));
             */
        throws IOException {
            expectedDocCount.put("2020-01-01T00:00:00.000Z", 2184);
                expectedMax.put("2020-10-01T00:00:00.000Z", (double) n);
            )
                stats = bucket.getAggregations().get("stats");
                assertFalse(AggregationInspectionHelper.hasValue(histogram));
                assertEquals(expectedSize, buckets.size());
        // sub-agg but fast path applies (UTC): NOT intra-eligible (BKD walk would duplicate per partition)
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
        }
                aggregationBuilder.setNumBuckets(3).field(DATE_FIELD).timeZone(ZoneId.of("America/New_York"));
    public void testRandomMonthIntervals() throws IOException {
            supportsIntraSegmentSearch(new AutoDateHistogramAggregationBuilder("dh").setNumBuckets(10).field(AGGREGABLE_DATE), true)
                final int randomIndex = randomInt(expectedSize - 1);
import static org.hamcrest.Matchers.hasEntry;
    }
                assertEquals(1L, stats.getCount());
            expectedDocCount.put("2020-07-01T00:00:00.000Z", 2208);
            DATES_WITH_TIME,
        expectedDocCount.put("2017-02-01T13:00:00.000Z", 1);
        );
            int n = 0;
        final long end = LocalDate.of(2017, 12, 31).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        /*
            );
            DATES_WITH_TIME,
            DEFAULT_QUERY,
    public void testNoDocs() throws IOException {
     * This test creates a scenario where buckets must be merged when rounding increases.
            assertEquals(
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        bucketsToExpectedDocCountMap.put(72, 1);
        bucketsToExpectedDocCountMap.put(36, 3);
            expectedMax.put("2020-01-01T00:00:00.000Z", 2183.0);
            aggregation -> aggregation.setNumBuckets(4).field(DATE_FIELD),
            /*
            expectedMax.clear();
                .subAggregation(AggregationBuilders.stats("stats").field(DATE_FIELD)),
            ZonedDateTime.of(2017, 2, 1, 0, 0, 7, 74, ZoneOffset.UTC),
import org.opensearch.search.aggregations.AggregationBuilders;
            DEFAULT_QUERY,
import org.apache.lucene.index.DirectoryReader;
            dataset.add(date);
            .field("bogus_bogus")
            .subAggregation(
import java.time.LocalDate;
            ZonedDateTime.of(2017, 2, 1, 16, 59, 0, 0, ZoneOffset.UTC)
        // Verify both produce identical results
    }
            InternalAutoDateHistogram bk1bdh = bk1b.getAggregations().get("dh");
        testSearchCase(
                    numericFieldType
                        new SortedSetDocValuesField("k1", aBytes),
            aggregation -> aggregation.setNumBuckets(6).field(DATE_FIELD),
                final DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD);
            aggregation -> aggregation.setNumBuckets(7).field(DATE_FIELD),
                bucket = buckets.get(5);
            assertTrue(histogram.getBuckets().size() <= 10);
            }
            Map<String, Integer> expectedDocCount = new TreeMap<>();
            indexWriter.addDocument(List.of(new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-02-01T00:00:00Z"))));
                stats = bucket.getAggregations().get("stats");
            List<List<IndexableField>> docs = new ArrayList<>();
            expectedDocCount.clear();
        );
            assertThat(bucketCountsAsMap(adh), equalTo(expectedDocCount));
            expectedDocCount.put(startDate.plusYears(2), 1);
        };
                assertEquals("2012-05-18T04:11:00.000Z", stats.getMaxAsString());
            supportsIntraSegmentSearch(
            () -> testSearchCase(
            histogram -> {
            List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        testSearchCase(rangeQuery, DATES_WITH_TIME, aggregation -> aggregation.setNumBuckets(4).field(DATE_FIELD), histogram -> {
        expectedDocCount.put("2017-03-01T00:00:00.000Z", 3);
            datesForMinuteInterval,
            aggregation -> aggregation.setNumBuckets(15).field(DATE_FIELD),
            InternalAutoDateHistogram ak1adh = ak1a.getAggregations().get("dh");
    }
    }
            aggregation -> aggregation.setNumBuckets(5).field(DATE_FIELD),
            assertEquals(140, totalDocs); // (5 days * 24 hours) + (5 years * 4 quarters) = 120 + 20 = 140
            DEFAULT_QUERY,
        AutoDateHistogramAggregationBuilder aggregation = new AutoDateHistogramAggregationBuilder("_name").setNumBuckets(10)
        );
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
import org.opensearch.index.mapper.NumberFieldMapper;
        );
                    DEFAULT_QUERY,
 */
            assertThat(maxAsMap(ak1adh), equalTo(expectedMax));
import java.time.ZoneOffset;
                assertTrue(Double.isInfinite(stats.getMax()));
        } else if (randomChoice == 3) {
        LinkedHashMap<String, Double> map = new LinkedHashMap<>(result.getBuckets().size());
        for (int i = 0; i < length; i++) {
    private static final String DATE_FIELD = "@timestamp";
            for (int month = 0; month < 12; month += 3) {
        List<ZonedDateTime> datesForHourInterval = Arrays.asList(
                // Verify total doc count
            assertFalse(histogram.getBuckets().isEmpty());
            long totalDocs = histogram.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
                .field(DATE_FIELD)
                assertEquals(1, bucket.getDocCount());
            document.add(new LongPoint(INSTANT_FIELD, instant));
import java.time.ZonedDateTime;
        fullDocCount.clear();
                    indexSearcher,
        );
    }
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            dataset,
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
            result -> assertThat(bucketCountsAsMap(result), equalTo(expectedDocCount))
                assertEquals(1L, stats.getCount());
        // Verify total doc counts match
    private void indexSampleData(List<ZonedDateTime> dataset, RandomIndexWriter indexWriter) throws IOException {
                dataset.add(start.plusDays(day).plusHours(hour));
 *
                assertEquals(startDate.plusMonths(randomIndex * expectedDocCount), bucket.getKey());
        }
        expectedDocCount.put("2017-02-03T00:00:00.000Z", 3);
    public void testSubAggregations() throws IOException {
        expectedDocCount.put("2017-02-01T00:00:09.000Z", 0);
            aggregation -> aggregation.setNumBuckets(4).field(DATE_FIELD),
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            assertThat(maxAsMap(adh), equalTo(expectedMax));
        }
            InternalAutoDateHistogram adh = a.getAggregations().get("dh");
import java.util.function.Consumer;
     * Test that verifies skiplist collector handles rounding changes correctly with sub-aggregations.
        );
        };
import org.opensearch.search.aggregations.metrics.InternalMax;
                final int expectedDocCount = randomEntry.getValue();
                document.add(new SortedNumericDocValuesField(DATE_FIELD, instant));
            "Bucket count mismatch between skiplist and non-skiplist",
        long totalDocsWithout = histogramWithoutSkiplist.getBuckets().stream().mapToLong(Histogram.Bucket::getDocCount).sum();
        );
import org.opensearch.index.mapper.MappedFieldType;
import java.util.Locale;
            .interval(1)
     * This test validates:
                assertEquals(1, bucket.getDocCount());
            for (int n = 0; n < 100; n++) {
                dataset.add(start.plusYears(year).plusMonths(month));
            List<List<IndexableField>> docs = new ArrayList<>();
                    new NumberFieldMapper.NumberFieldType(INSTANT_FIELD, NumberFieldMapper.NumberType.LONG),
            final ZonedDateTime date = startDate.plusDays(i);
    }
        bucketsToExpectedDocCountMap.put(20, 10);
        final ZonedDateTime startDate = ZonedDateTime.of(2017, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        Map<String, Integer> expectedDocCount = new TreeMap<>();
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
            ZonedDateTime.of(2017, 2, 1, 14, 5, 0, 0, ZoneOffset.UTC),
        }
            ZonedDateTime.of(2017, 2, 1, 0, 0, 7, 299, ZoneOffset.UTC),
            });
            aggregation -> aggregation.setNumBuckets(5).field(DATE_FIELD).timeZone(ZoneOffset.ofHours(-1)),
            histogram -> {
        expectedDocCount.put("2017-02-01T00:00:08.000Z", 0);
        for (int hour = 0; hour < 24; hour++) {
        for (int month = 0; month < 12; month++) {
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, dft, nft)
                final List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            expectedDocCount.put("2020-07-01T00:00:00.000Z", 2208);
     * 1. preparedRounding field update is visible to skiplist collector
 * software distributed under the License is distributed on an
            BytesRef bBytes = new BytesRef("b");
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        final Query rangeQuery = LongPoint.newRangeQuery(INSTANT_FIELD, start, end);
        expectedDocCount.put("2017-02-01T08:00:00.000-01:00", 2);
        Map<String, Integer> expectedDocCount = new TreeMap<>();
            datesForHourInterval,
import org.apache.lucene.search.MatchNoDocsQuery;
                assertThat(bucketCountsAsMap(dh), hasEntry(equalTo("2020-07-01T00:00:00.000Z"), either(equalTo(22)).or(equalTo(23))));
                expectedMax.put("2020-04-01T00:00:00.000Z", (double) n);
            assertThat(maxAsMap(adh), equalTo(expectedMax));
            StringTerms bk1 = b.getAggregations().get("k1");
    public void testAsSubAggWithIncreasedRounding() throws IOException {
        testSearchCase(
            .subAggregation(
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
                assertEquals(expectedSize, buckets.size());
        expectedDocCount.put("2017-02-01T14:00:00.000-01:00", 1);
                assertEquals(20, buckets.size());
            dataset.add(date);
        }
        for (int i = 0; i < histogramWithoutSkiplist.getBuckets().size(); i++) {
    private boolean supportsIntraSegmentSearch(AutoDateHistogramAggregationBuilder builder, boolean searchable) throws IOException {
            BytesRef cBytes = new BytesRef("c");
        Map<String, Integer> expectedDocCount = new TreeMap<>();
    private static final String NUMERIC_FIELD = "numeric";
        bucketsToExpectedDocCountMap.put(20, 10);
                final int randomIndex = randomInt(2);
     */
    public void testRandomHourIntervals() throws IOException {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                .subAggregation(AggregationBuilders.stats("stats").field(DATE_FIELD)),
import static org.hamcrest.Matchers.equalTo;
                assertThat(bucketCountsAsMap(histogram), equalTo(expectedDocCount));
import org.opensearch.search.aggregations.AggregationBuilder;
 * Unless required by applicable law or agreed to in writing,
        int i = 0;
            ZonedDateTime.of(2017, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC),
            aggregation -> aggregation.setNumBuckets(randomEntry.getKey()).field(DATE_FIELD),
            }
                assertEquals(expectedDocCount, bucket.getDocCount());
            Ensure we produce two segments on one shard such that the documents in seg 1 will be out of range of the
            datesForMonthInterval,
                stats = bucket.getAggregations().get("stats");
import org.opensearch.index.mapper.DateFieldMapper;
        final List<ZonedDateTime> dataset = new ArrayList<>(length);
import org.hamcrest.Matchers;
                }
            assertThat(maxAsMap(bdh), equalTo(expectedMax));
            } else {
            expectedDocCount.clear();
     * fast path can NOT apply upfront. Fast path applies for a searchable, UTC, top-level agg → do not partition
        expectedDocCount.put("2017-02-01T15:00:00.000Z", 1);
        testSearchCase(
        final Map<Integer, Integer> bucketsToExpectedDocCountMap = new HashMap<>();
                bucket = buckets.get(4);
                aggregation -> aggregation.setNumBuckets(MultiBucketConsumerService.DEFAULT_MAX_BUCKETS + 1).field(DATE_FIELD),
        // Verify each bucket matches
            long useC = dft.parse("2020-07-01T00:00Z");
    /**
        });
        testSearchCase(
            expectedDocCount.put("2020-10-01T00:00:00.000Z", 2208);
            ZonedDateTime.of(2017, 2, 1, 10, 15, 0, 0, ZoneOffset.UTC),
    }
                assertEquals(expectedDocCount, bucket.getDocCount());
        final long start = LocalDate.of(2015, 1, 1).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
    public void testIntervalYear() throws IOException {
        }, fieldType);
     *
import static org.hamcrest.Matchers.hasSize;
 * Modifications Copyright OpenSearch Contributors. See
            ZonedDateTime.of(2017, 2, 1, 16, 59, 0, 0, ZoneOffset.UTC)
                    .field(AGGREGABLE_DATE)
                    assertThat(((InternalMax) histo.getBuckets().get(i).aggregations.get("max")).getValue(), equalTo((double) i));
        final List<ZonedDateTime> multiBucketIndexData = Arrays.asList(
        CheckedBiConsumer<RandomIndexWriter, DateFieldMapper.DateFieldType, IOException> buildIndex = (iw, dft) -> {
                final Histogram.Bucket bucket = buckets.get(randomIndex);
            datesForHourInterval,
        );
        testSearchCase(
            long end = dft.parse("2021-01-01T00:00:00Z");
                final int randomIndex = randomInt(expectedSize - 1);
            expectedDocCount.put("2023-01-01T00:00:00.000Z", 4);
        Map<String, Integer> fullDocCount = new TreeMap<>();
        expectedDocCount.clear();
