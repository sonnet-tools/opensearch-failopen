                assertEquals(3, buckets.size());
                assertEquals(3, bucket.getDocCount());
                expected = dataset.get("2017-02-01T14:04:00.000Z");
        try (Directory directory = newDirectory()) {
                            indexWriter.addDocument(document);
    public void testMatchAllDocsDeprecatedInterval() throws IOException {
                    long instant = asLong(date, fieldType);
                new MatchAllDocsQuery(),
            ),
            for (int i = 8; i < 10; i++) {
     * A date that is always "searchable" because it is indexed.
        dataset.put("2017-02-01T10:00:00.001Z", 256);
            false
                        for (int i = 0; i < date.getValue(); i++) {
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.MONTH).field(AGGREGABLE_DATE),
            },
            indexDocsForSkiplist(directory, config, filterField, null);
        testSearchCase(
    }
                new MatchAllDocsQuery(),
            false,
            false
                .field(AGGREGABLE_DATE)
            "2017-02-01T00:00:11.074Z",
            )
                assertEquals(1, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());
        }).build(null, null);
    public void testIntervalMonth() throws IOException {
                bucket = buckets.get(4);
     * partition (false). It declines for non-UTC / non-searchable / nested → partition (true). With a sub-agg it
            );
    }
     * The intra-segment gate for date_histogram (no sub-agg): partition only when the filter-rewrite O(1) fast
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
        );
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 * SPDX-License-Identifier: Apache-2.0
            if (randomWrite) {
                expected = dataset.get("2017-02-01T10:00:00.001Z");
        Query query = new MatchNoDocsQuery();
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
        // Create index settings with an index sort.
        testSearchCase(
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
            DATASET,
                expected = dataset.get("2017-02-01T15:59:00.000Z");
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.SECOND).field(AGGREGABLE_DATE).minDocCount(1L),
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
            IllegalArgumentException.class,
                aggregation -> aggregation.fixedInterval(new DateHistogramInterval("2d"))
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                bucket = buckets.get(1);
        List<String> dataset,
                "2017-02-01T00:00:11.299Z",
 * The OpenSearch Contributors require contributions made to
            false
            () -> testSearchCase(
        dataset.put("2017-02-01T14:05:00.000Z", 256);
            )
        );
            assertThat(
     */
                    false,
        testSearchCase(
    public void testSkiplistWithSingleValueDatesAndSubAggs() throws IOException {
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).interval(1000).field(AGGREGABLE_DATE),
                InternalDateHistogram histogram = (InternalDateHistogram) topLevel.reduce(Collections.singletonList(topLevel), context);
                    query,
        testSearchCase(
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
import java.util.function.Consumer;
                bucket = buckets.get(2);
                assertEquals(2, buckets.size());
import java.util.Arrays;
                assertEquals(expected, bucket.getDocCount());
                    .subAggregation(new MaxAggregationBuilder(categoryField).field(categoryField));
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(
import java.time.ZoneId;
                assertEquals(1, bucket.getDocCount());
                        // add the doc count field to the first document
        Settings settings = getSettingsWithIndexSort();
            try (IndexReader reader = indexWriter.getReader()) {
     * path can NOT apply upfront. Fast path applies for a searchable, UTC, top-level date_histogram → do not
                // Assert sub-aggregation values for 2016 bucket (doc 8 with category 0)
    }
        e = expectThrows(
    ) throws IOException {
            new MatchNoDocsQuery(),
                new MatchAllDocsQuery(),
    /**
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("_name");
            InternalDateHistogram bk1bdh = bk1b.getAggregations().get("dh");
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
 * under the License.
        });
            IllegalArgumentException.class,
        );
        }, false);
                        document.add(new LongPoint(AGGREGABLE_DATE, instant));
            query,
        dataset.put("2017-02-01T15:59:00.000Z", 768);
            new MatchAllDocsQuery(),
        );
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                        new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR)
                "2017-02-01T13:06:00.000Z",
            new MatchAllDocsQuery(),
                InternalDateHistogram.Bucket bucket2016 = (InternalDateHistogram.Bucket) histogram.getBuckets().get(1);
                    .calendarInterval(DateHistogramInterval.YEAR)
                        null
public class DateHistogramAggregatorTests extends DateHistogramAggregatorTestCase {
                false
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
                }
    public void testIntervalHour() throws IOException {
                assertFalse(AggregationInspectionHelper.hasValue(histogram));
            dataset,
                assertEquals(2, buckets.size());
    public void testIntervalMinuteDeprecated() throws IOException {
            new MatchAllDocsQuery(),
                "2017-02-01T09:02:35.000Z",
                );
            query,
            },
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
            e.getMessage(),
            new MatchNoDocsQuery(),
            ),
                    .calendarInterval(DateHistogramInterval.YEAR);
        testSearchCase(
                            }
                assertEquals(2, bucket.getDocCount());
                Document document = new Document();
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            false
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
import java.util.Map;
                InternalDateHistogram histogram = searchAndReduce(
        );
                    .toEpochMilli();
                "2017-02-01T00:00:11.299954583Z",
        "2010-04-27T03:43:34",
                assertEquals(3, buckets.size());
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
            histogram -> assertEquals(0, histogram.getBuckets().size()),
            .subAggregation(new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR));
 * specific language governing permissions and limitations
    }
                assertEquals(expected, bucket.getDocCount());
            .field(AGGREGABLE_DATE);
import org.apache.lucene.store.Directory;
        );
            StringTerms.Bucket a = terms.getBucketByKey("a");
                expected = dataset.get("2017-02-01T13:06:00.000Z");
package org.opensearch.search.aggregations.bucket.histogram;
                bucket = buckets.get(1);
        IllegalArgumentException e = expectThrows(
                histogram -> {},
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
import org.apache.lucene.search.Sort;
        );
                            document.add(new SortedNumericDocValuesField(AGGREGABLE_DATE, instant));
    }
        );
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR),
            timestamps,
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
                    aggregationBuilder,
                assertEquals("2017-02-01T09:02:00.000Z", bucket.getKeyAsString());
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE),
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
        );
            () -> testSearchCase(
                new MatchAllDocsQuery(),
        testSearchCase(
        dataset.put("2017-02-01T16:59:00.000Z", randomIntBetween(100, 2000));
                    .toEpochMilli();
            () -> testSearchCase(
                assertEquals(expected, bucket.getDocCount());
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
    ) throws IOException {
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        testSearchCase(
        );
            }
            Arrays.asList(
        IndexNumericFieldData fieldData = (IndexNumericFieldData) fieldType.fielddataBuilder("index", () -> {
                new MatchAllDocsQuery(),
                assertEquals(1, bucket.getDocCount());
                "2017-02-01T16:59:00.000Z"
            () -> testSearchCase(
        IndexNumericFieldData fieldData = (IndexNumericFieldData) dateType.fielddataBuilder("index", () -> {
        );
                "2017-02-01T15:59:00.000Z",
import org.apache.lucene.index.IndexReader;
    }
import org.apache.lucene.tests.util.TestUtil;
            String filterField = "type";
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2017-01-01T09:00:00.000Z"), asLong("2017-02-01T16:00:00.000Z")),
            throw new UnsupportedOperationException();
        e = expectThrows(
        IllegalArgumentException e = expectThrows(
                    document.add(new LongPoint(SEARCHABLE_DATE, instant));
import org.opensearch.index.mapper.DateFieldMapper;
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(5);
        }).build(null, null);
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
                equalTo(List.of("2020-01-01T00:00Z", "2021-01-01T00:00Z"))
            )
                "2017-02-01T09:16:04.000Z",
                query,
                Histogram.Bucket bucket = buckets.get(0);
        return new CountingAggregator(
                bucket = buckets.get(4);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        dataset.put("2017-02-01T14:04:00.000Z", 256);
            NumberFieldMapper.NumberType.LONG
                    indexSearcher,
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
            assertThat(
            )
            IllegalArgumentException.class,
    }
                bucket = buckets.get(1);
        );
        testSearchCase(
                assertEquals(1, bucket.getDocCount());
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
                false
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {
                    configure.accept(aggregationBuilder);
                assertEquals(0, bucket.getDocCount());
                "2017-02-01T16:59:00.000Z"
            histogram -> assertEquals(0, histogram.getBuckets().size()),
                assertEquals(expected, bucket.getDocCount());
    public void testIntervalDayDeprecated() throws IOException {
            )
                .hardBounds(new LongBounds("2016-01-01", "2017-01-01"))
        dataset.put("2017-02-01T13:06:00.000Z", randomIntBetween(100, 2000));
        );
                assertEquals(3, bucket.getDocCount());
                bucket = buckets.get(3);
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
            Arrays.asList(
                verify.accept(histogram);
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
                }
        assertThat(e.getMessage(), equalTo("Cannot use [fixed_interval] with [interval] configuration option."));
        IllegalArgumentException e = expectThrows(
                Document doc = new Document();
 */
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
            histogram -> {
        testSearchCase(
                    indexSettings,
            query,
        throws IOException {
import org.apache.lucene.document.NumericDocValuesField;
            },
                Histogram.Bucket bucket = buckets.get(0);
                "2017-02-01T00:00:05.015Z",
                assertEquals(4, buckets.size());
        testSearchCase(query, dataset, configure, verify, maxBucket, useNanosecondResolution, useDocCountField, randomBoolean());
        // Create index settings with an index sort.
            histogram -> {
            false
            .build();
            true,
                Histogram.Bucket bucket = buckets.get(0);
        Consumer<InternalDateHistogram> verify,
            histogram -> {
                assertEquals(2, bucket.getDocCount());
import org.apache.lucene.index.NoMergePolicy;
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    }
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field("wrong_field"),
import org.opensearch.search.aggregations.AggregationBuilder;
    public void testSkiplistWithSingleValueDates() throws IOException {
                histogram -> {},
            true
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(3, histogram.getBuckets().size()); // 2015, 2016, 2017 (only type 2 docs)
                // use default codec so max points in leaf is fixed to 512, to cover the node level visit and compare logic
                assertEquals(4, buckets.size());
                "2017-02-01T00:00:05.015298384Z",
            histogram -> assertEquals(6, histogram.getBuckets().size()),
/*
                org.opensearch.search.aggregations.metrics.InternalMax maxAgg2015 = bucket2015.getAggregations().get(categoryField);
    ) throws IOException {
            Arrays.asList(
                Histogram.Bucket bucket = buckets.get(0);
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
            },
            DATASET,
                assertNotNull("Sub-aggregation should exist for 2015 bucket", bucket2015.getAggregations());
                assertEquals(1, bucket.getDocCount());
            categoryField,
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            true
            new MatchAllDocsQuery(),
        Query query,
        testSearchCase(
import org.opensearch.core.common.breaker.CircuitBreaker;
            false
        testSearchCase(
    }
                assertEquals(3, buckets.size());
import java.util.HashMap;
                new MatchAllDocsQuery(),
        );
            histogram -> {
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
        );
     * always opts in (partition-aware collection).
        aggregation = agg -> agg.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE);
                Histogram.Bucket bucket = buckets.get(0);
                    .field(AGGREGABLE_DATE),
    private void testFilterRewriteCase(
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
                assertEquals(1, bucket2017.getDocCount());
    }
            }
                // Verify first bucket (2015) with sub-aggregations
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean useNanosecondResolution,
                bdh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                "2017-02-01T16:48:00.000Z",
            },
                bucket = buckets.get(2);
        throws IOException {
                "2017-02-01T09:16:42.000Z"
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
        testSearchCase(
            Arrays.asList(
            assertEquals(0, histogram.getBuckets().size());
                if (useDocCountField) {
        );
                assertEquals(0, buckets.size());
                assertEquals(1, bucket.getDocCount());
                    + "hard bounds: [2010-01-01--2020-01-01], extended bounds: [2009-01-01--2021-01-01]"
                assertEquals(0, histogram.getBuckets().size());
                bucket = buckets.get(2);
            histogram -> {
    }
                    ),
    }
                "2017-02-01T14:04:00.000Z",
            () -> testSearchCase(
        dataset.put("2017-02-01T14:04:00.000Z", randomIntBetween(100, 2000));
            foo.add(DATASET.get(randomIntBetween(0, DATASET.size() - 1)));
            "2017-02-01T00:00:21.380Z"
    }
            query,
            config.setMergePolicy(NoMergePolicy.INSTANCE);
    public void testOverlappingBounds() {
                    doc.add(new NumericDocValuesField(categoryField, i % 2));
                    // add the doc count field to the first document
        e = expectThrows(
            },
    private static void indexDocsForSkiplist(Directory directory, IndexWriterConfig config, String filterField, String categoryField)
                assertEquals("2017-02-01T09:16:00.000Z", bucket.getKeyAsString());
                assertEquals(0, bucket.getDocCount());
                );
        );
            )
        List<String> dataset,
                org.opensearch.search.aggregations.metrics.InternalMax maxAgg2016 = bucket2016.getAggregations().get(categoryField);
            false
        );
        );
    public void testCalendarWithFixed() throws IOException {
                assertEquals(4, buckets.size());
        int maxBucket,
        Consumer<DateHistogramAggregationBuilder> configure,
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        "2017-12-12T22:55:46"
            histogram -> {
            histogram -> {
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("_name");
                false
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60s")).field(AGGREGABLE_DATE).minDocCount(1L),
            LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2015-01-01"), asLong("2017-12-31")),
                aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.DAY)
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                expected = dataset.get("2017-02-01T13:06:00.000Z");
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            aggregation -> aggregation.fixedInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(0L),
            IndexWriterConfig config = newIndexWriterConfig();
            false
                assertEquals(2, bucket.getDocCount());
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.MINUTE).field(AGGREGABLE_DATE).minDocCount(1L),
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
            false
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
                false
            config.setIndexSort(new Sort(sortField));
    ) throws IOException {
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
            histogram -> {
                assertEquals(4, buckets.size());
        // with a sub-aggregation AND fast path declines (non-UTC): intra-eligible (doc-by-doc parallelizes)
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
            );
                true
        testSearchCase(
        );
                true
            IllegalArgumentException.class,
                "2017-02-01T09:35:00.000Z",
                if (categoryField != null) {
        );
                        for (int i = 0; i < date.getValue(); i++) {
            );
                assertEquals(3, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            Arrays.asList(
                "2017-02-01T00:00:37.210328172Z",
                assertEquals("2015-01-01T00:00:00.000Z", histogram.getBuckets().get(0).getKeyAsString());
                "2017-02-01T09:16:42.000Z"
                assertEquals("Max category value for 2016 bucket should be 0", 0.0, maxAgg2016.getValue(), 0.0);
                // Assert sub-aggregation values for 2017 bucket (doc 9 with category 1)
        testFilterRewriteCase(
                assertEquals(expected, bucket.getDocCount());
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                bucket = buckets.get(1);
        boolean useDocCountField
        testSearchCase(
                "2017-02-01T00:00:37.210Z",
                int expected = dataset.get("2017-02-01T09:02:00.000Z") + dataset.get("2017-02-01T09:59:59.999Z");
import org.opensearch.search.aggregations.MultiBucketConsumerService;
            new MatchNoDocsQuery(),
                "failed to parse setting [date_histogram.fixedInterval] with value [1w] as a time value: "
                if (configure != null) {
        testSearchCase(
        Query query,
        testSearchCase(query, dataset, configure, verify, maxBucket, useNanosecondResolution, false);
                bucket = buckets.get(1);
        testSearchCase(
                false
            )
                    .field(AGGREGABLE_DATE),
                false
        );
                expected = dataset.get("2017-02-01T13:06:00.000Z");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        AggregationBuilder builder = new TermsAggregationBuilder("k1").field("k1")
                "2017-02-01T10:15:00.000Z",
            Arrays.asList(
    }
            new MatchAllDocsQuery(),
            false
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
            DATASET,
                assertNotNull("Sub-aggregation should exist for 2016 bucket", bucket2016.getAggregations());
    private static final String SEARCHABLE_DATE = "searchable_date";
                "2017-02-01T16:06:00.000Z",
            query,
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
            false,
                    for (Map.Entry<String, Integer> date : dataset.entrySet()) {
import java.util.Collections;
        }
        testSearchCase(
    public void testMultiRangeTraversal() throws IOException {
                assertEquals(3, buckets.size());
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            new MatchAllDocsQuery(),
        );
            Arrays.asList(
            new MatchAllDocsQuery(),
        testSearchCase(
                Histogram.Bucket bucket = buckets.get(0);
                "2017-02-01T09:15:37.000Z",
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
            equalTo(
    public void testMinDocCountDeprecated() throws IOException {
        testSearchCase(
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        testSearchCase(
                bucket = buckets.get(1);
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.MONTH).field(AGGREGABLE_DATE),
                assertEquals("2017-02-01T00:00:15.000Z", bucket.getKeyAsString());
        IllegalArgumentException e = expectThrows(
                assertEquals("2016-01-01T00:00:00.000Z", bucket2016.getKeyAsString());
import static java.util.stream.Collectors.toList;
            ),
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02"),
        );
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
                false
            DATASET,
        testSearchCase(
        );
        Map<String, Integer> dataset = new HashMap<>();
                assertEquals(3, buckets.size());
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
            InternalDateHistogram bdh = b.getAggregations().get("dh");
            },
        );
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("1000ms")).field(AGGREGABLE_DATE).minDocCount(1L),
            histogram -> {
    }
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
                histogram -> {},
            () -> testSearchCase(
            new MatchAllDocsQuery(),
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        int maxBucket,
                new MatchAllDocsQuery(),
        );
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        dataset.put("2017-02-01T14:05:00.000Z", randomIntBetween(100, 2000));
                bucket = buckets.get(2);
                assertEquals("2016-01-01T00:00:00.000Z", histogram.getBuckets().get(1).getKeyAsString());
                assertEquals(3, bucket.getDocCount());
                AggregatorFactories factories = AggregatorFactories.builder()
        dataset.put("2017-02-01T16:06:00.000Z", randomIntBetween(100, 2000));
 * software distributed under the License is distributed on an
            throw new UnsupportedOperationException();
                assertEquals("2015-01-01T00:00:00.000Z", bucket.getKeyAsString());
    }
                    query,
        "2015-02-13T13:09:32",
            false
        );
        dataset.put("2017-02-01T10:00:00.001Z", randomIntBetween(100, 2000));
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.opensearch.search.MultiValueMode;
                    .addAggregator(builder)
            },
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                .hardBounds(new LongBounds("2018-01-01", "2020-01-01"))
                assertEquals(2, bucket.getDocCount());
        "2012-05-18T04:11:00",
    public void testAsSubAgg() throws IOException {
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-04T00:00:00.000Z", bucket.getKeyAsString());
                false
                assertEquals(3, bucket.getDocCount());
            true
            ),
        );
                assertEquals(3, bucket.getDocCount());
import org.opensearch.cluster.metadata.IndexMetadata;
                            .getQueryShardContext(),
                assertEquals(3, bucket.getDocCount());
            new MatchAllDocsQuery(),
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // Create date histogram with terms sub-aggregation
                histogram -> {},
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);
                            document.clear();
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(2);
            },
            histogram -> {
                assertEquals(1, bucket.getDocCount());
            query,
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(3, bucket.getDocCount());
                assertEquals(1, bucket.getDocCount());
        Consumer<DateHistogramAggregationBuilder> configure,
        testSearchCase(
                Histogram.Bucket bucket = buckets.get(0);
        );
                "2017-02-01T09:35:00.000Z",
            false,
                equalTo(List.of("2020-01-01T00:00Z"))
                "2017-02-01T09:02:59.000Z",
                assertEquals("2017-02-04T00:00:00.000Z", bucket.getKeyAsString());
                Histogram.Bucket bucket = buckets.get(0);
        int maxBucket,
                histogram -> {},
        );
            ex.getMessage(),
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                assertEquals(6, buckets.size());
                    if (aggregableDateIsSearchable) {
                assertEquals(3, histogram.getBuckets().size()); // 2015, 2016, 2017 (only type 2 docs)
                equalTo(List.of("2021-01-01T00:00Z"))
                Query query = LongPoint.newExactQuery(filterField, 2);
            StringTerms.Bucket b = terms.getBucketByKey("b");
            histogram -> {
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.SECOND).field(AGGREGABLE_DATE).minDocCount(1L),
            histogram -> {
import org.opensearch.search.aggregations.InternalAggregation;
        );
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE),
                assertEquals(3, bucket2015.getDocCount());
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        );
                Histogram.Bucket bucket = buckets.get(0);
                long timestamp = DateFormatters.from(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER.parse(DATASET.get(i)))
import org.opensearch.Version;
                bucket = buckets.get(2);
            )
            IllegalArgumentException.class,
                "2017-02-01T00:00:37.380889483Z"
            ),
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                Histogram.Bucket bucket = buckets.get(0);
        try (Directory directory = newDirectory()) {
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            },
            },
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-01-01T00:00:00.000Z", bucket2017.getKeyAsString());
            new MatchAllDocsQuery(),
                indexSearcher.search(query, aggregator);
            histogram -> {
    public void testIntervalSecond() throws IOException {
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
    public void testIntervalHourDeprecated() throws IOException {
    }
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE).minDocCount(1L),
        );
                assertEquals(1, bucket.getDocCount());
                assertEquals(3, bucket.getDocCount());
                assertEquals("2017-02-01T09:16:00.000Z", bucket.getKeyAsString());
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
 * Unless required by applicable law or agreed to in writing,
                "2017-02-01T00:00:37.210Z",
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.IndexWriterConfig;
                assertEquals(2, bucket.getDocCount());
        );
                    .dateHistogramInterval(DateHistogramInterval.DAY)
                for (String date : dataset) {
                histogram -> {},
                assertEquals("2017-02-01T09:02:00.000Z", bucket.getKeyAsString());
            DATASET,
        );
    }
            // Second commit - 3 more dates with type 2, skiplist
            histogram -> assertEquals(6, histogram.getBuckets().size()),
        assertTrue(
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
        // non-searchable field, no sub-agg: fast path declines (canOptimize requires a searchable index) -> intra-eligible
                assertEquals(3, buckets.size());
            )
        );
                bucket = buckets.get(2);
                        }
                "2017-02-01T00:00:11.074986434Z",
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.SECOND).field(AGGREGABLE_DATE).minDocCount(1L),
                assertEquals(expected, bucket.getDocCount());
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(2);
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());
    public void testIntervalDay() throws IOException {
            () -> testSearchCase(
                assertEquals(3, buckets.size());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(1, bucket.getDocCount());
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
                true
        assertThat(
            },
                assertEquals(2, bucket.getDocCount());
            histogram -> {
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                bucket = buckets.get(1);
                "2017-02-01T13:06:00.000Z",
                assertEquals("2017-02-01T00:00:15.000Z", bucket.getKeyAsString());
            false
        "2013-05-29T05:11:31",
            }
            new MatchAllDocsQuery(),
            false
        // nested under a numeric histogram (parent != null): fast path can't apply -> intra-eligible
        Consumer<DateHistogramAggregationBuilder> configure,
                    1000,
        boolean useNanosecondResolution,
            timestamps,
                    indexWriter.addDocuments(documents);
        Settings settings = getSettingsWithIndexSort();
                bucket = buckets.get(2);
                doAssertReducedMultiBucketConsumer(histogram, reduceBucketConsumer);
            },
                new MultiBucketConsumerService.MultiBucketConsumer(
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        dataset.put("2017-02-01T10:00:00.001Z", randomIntBetween(100, 2000));
    }
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
            new MatchAllDocsQuery(),
            }
                assertEquals(0, bucket.getDocCount());
                Histogram.Bucket bucket = buckets.get(0);
                try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                "2017-02-01T00:00:11.299Z",
                bucket = buckets.get(2);
            histogram -> {
                histogram -> {},
                doc.add(new LongPoint(filterField, 1));
            collectCount -> assertTrue(collectCount > 0),
        );
            },
            false
                equalTo(List.of("2020-01-01T00:00Z", "2021-01-01T00:00Z"))
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
        testSearchCase(
    private void testSearchCase(
                // Assert sub-aggregation values for 2015 bucket (docs 5,6,7 with categories 1,0,1)
    }
            },
                assertEquals(1, bucket.getDocCount());
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
            },
            },
            false,
        dataset.put("2017-02-01T14:05:00.000Z", randomIntBetween(100, 2000));
                assertEquals(2, bucket.getDocCount());
                bucket = buckets.get(4);
                "2017-02-01T16:48:00.000Z",
            10000,
                assertEquals("Max category value for 2015 bucket should be 1", 1.0, maxAgg2015.getValue(), 0.0);
                assertEquals(3, bucket.getDocCount());
            false
                InternalDateHistogram.Bucket bucket2015 = (InternalDateHistogram.Bucket) histogram.getBuckets().get(0);
 */
        Query query = LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2017-02-01T00:00:00.000Z"), asLong("2017-02-01T00:00:30.000Z"));
        Query query = new MatchNoDocsQuery();
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
                }
    public void testAggregateWrongFieldDeprecated() throws IOException {
                "2017-02-01T09:02:00.000Z",
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                    + "unit is missing or unrecognized"
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
                            document.add(new SortedNumericDocValuesField(AGGREGABLE_DATE, instant));
            histogram -> {
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);
        dataset.put("2017-02-01T16:06:00.000Z", randomIntBetween(100, 2000));
            new MatchAllDocsQuery(),
        );
    public void testHardBoundsNotOverlapping() throws IOException {
                    aggregator.context().bigArrays(),
            new MatchAllDocsQuery(),
            ),
 * ownership. Elasticsearch licenses this file to you under
        dataset.put("2017-02-01T09:02:00.000Z", 512);
        MappedFieldType... fieldTypes
        Query query,
    private void testSearchCase(
            dataset,
                                // add the doc count field once
    }
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                doc.add(SortedNumericDocValuesField.indexedField(AGGREGABLE_DATE, timestamp));
        Map<String, Integer> dataset,
            new MatchAllDocsQuery(),
                    document.clear();
                Histogram.Bucket bucket = buckets.get(0);
        dataset.put("2017-02-01T09:59:59.999Z", randomIntBetween(100, 2000));
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            histogram -> {
    public void testMatchNoDocsDeprecatedInterval() throws IOException {
            DATASET,
                false
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(0L),
                assertEquals("2017-02-01T09:16:00.000Z", bucket.getKeyAsString());
                    }
    public void testIllegalInterval() throws IOException {
                new MatchAllDocsQuery(),
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(3);
                    .toEpochMilli();
                Histogram.Bucket bucket = buckets.get(0);
            LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2015-01-01"), asLong("2017-12-31")),
            false
        testFilterRewriteCase(
import java.io.IOException;
            supportsIntraSegmentSearch(
        assertThat(e.getMessage(), equalTo("Cannot use [fixed_interval] with [interval] configuration option."));
        );
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("test").field(AGGREGABLE_DATE)
                "2017-02-01T00:00:37.380889483Z"
                assertEquals(0, buckets.size());
        );
                assertEquals("2017-03-01T00:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(2);
                .hardBounds(new LongBounds("2016-01-01", "2017-02-03"))
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                assertEquals(1, bucket.getDocCount());
            true
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        dataset.put("2017-02-01T15:59:00.000Z", randomIntBetween(100, 2000));
import org.opensearch.index.fielddata.IndexNumericFieldData;
        testSearchCase(
    public void testMatchAllDocs() throws IOException {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    }
        );
                assertEquals(1, bucket.getDocCount());
        IllegalArgumentException e = expectThrows(
                            if (useDocCountField) {
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());
                    .toInstant()
            DATASET,
        boolean useDocCountField,
            query,
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
                bucket = buckets.get(5);
                aggregator.preCollection();
            aggregation -> aggregation.fixedInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(3L),
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                equalTo(List.of("2020-01-01T00:00Z"))
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
                .field(AGGREGABLE_DATE),
            },
            assertEquals(0, histogram.getBuckets().size());
                expected = dataset.get("2017-02-01T16:06:00.000Z") + dataset.get("2017-02-01T16:48:00.000Z") + dataset.get(
            }
                    .interval(10)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     */
            new AtomicInteger(),
                bucket = buckets.get(1);
                int expected = dataset.get("2017-02-01T09:02:00.000Z") + dataset.get("2017-02-01T09:59:59.999Z") + 4;
                "2017-02-01T15:59:00.000Z",
                // Verify third bucket (2017)
                histogram -> {},
                Histogram.Bucket bucket = buckets.get(0);
            false
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
            collectorCount -> assertEquals(0, (int) collectorCount),
    }
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
            10000,
        }
        );
                Histogram.Bucket bucket = buckets.get(0);
            collectorCount -> assertEquals(0, (int) collectorCount),
            false
        );
            Arrays.asList("2017-01-01", "2017-02-02", "2017-02-03", "2017-03-04", "2017-03-05", "2017-03-06"),
        });
        assertTrue(
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            dataset,
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());
                assertEquals(1, bucket.getDocCount());
        Consumer<DateHistogramAggregationBuilder> aggregation = agg -> agg.calendarInterval(DateHistogramInterval.YEAR)
 *
                assertEquals(1, bucket.getDocCount());
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
    public void testFilterRewriteOptimizationWithRangeQuery() throws IOException {
        assertThat(e.getMessage(), equalTo("The supplied interval [5d] could not be parsed as a calendar interval."));
                "2017-02-01T00:00:05.015Z",
                "Extended bounds have to be inside hard bounds, "
                false
            ),
            histogram -> assertEquals(8, histogram.getBuckets().size()),
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
        );
            )
                "2017-02-01T00:00:37.380Z"
                    List<Document> documents = new ArrayList<>();
                assertEquals(3, bucket.getDocCount());
            StringTerms.Bucket bk1a = bk1.getBucketByKey("a");
            )
                bucket = buckets.get(1);
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                doc.add(SortedNumericDocValuesField.indexedField(AGGREGABLE_DATE, timestamp));
                    .field(AGGREGABLE_DATE),
                searcher,
            },
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.HOUR).field(AGGREGABLE_DATE).minDocCount(1L),
            IllegalArgumentException.class,
        // 5 sec interval with minDocCount = 3
                Histogram.Bucket bucket = buckets.get(0);
            false
                new MatchAllDocsQuery(),
                assertEquals(8, histogram.getBuckets().size());
        builder = new TermsAggregationBuilder("k2").field("k2").subAggregation(builder);
                "2017-02-01T00:00:37.210328172Z",
                assertEquals(1, bucket.getDocCount());
                bucket = buckets.get(1);
                bucket = buckets.get(1);
                    .field(AGGREGABLE_DATE),
                aggregation -> aggregation.dateHistogramInterval(new DateHistogramInterval("foobar")).field(AGGREGABLE_DATE),
                expected = dataset.get("2017-02-01T10:00:00.001Z");
            }
                "2017-02-01T00:00:11.074Z",
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
        testSearchCase(query, dates, aggregation, histogram -> {
            "2017-02-01T00:00:11.074Z",
    );
        );
        List<String> dates = Collections.emptyList();
            IllegalArgumentException.class,
    public void testMultiRangeTraversalFixedData() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            query,
                    Document document = new Document();
        // 5 sec interval with minDocCount = 0
        testSearchCase(query, dates, aggregation, histogram -> {
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2018-01-01"), asLong("2020-01-01")),
            new MatchAllDocsQuery(),
            histogram -> {
                assertEquals(0, buckets.size());
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                Document doc = new Document();
                "2017-02-01T14:04:00.000Z",
                Histogram.Bucket bucket = buckets.get(0);
            for (int i = 5; i < 8; i++) {
            false
            }
            },
        // sub-agg but fast path applies (UTC): NOT intra-eligible (BKD walk would duplicate per partition)
    private static long asLong(String dateTime, DateFieldMapper.DateFieldType fieldType) {
            indexWriter.addDocument(List.of(new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-02-01T00:00:00Z"))));
        MappedFieldType fieldType = new DateFieldMapper.DateFieldType(AGGREGABLE_DATE);
                bucket = buckets.get(3);
            )
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
import java.util.concurrent.atomic.AtomicInteger;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
                assertEquals(3, bucket.getDocCount());
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field("wrong_field"),
        testSearchCase(
            )
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        assertThat(e.getMessage(), equalTo("Unable to parse interval [foobar]"));
                assertEquals(1, bucket.getDocCount());
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                assertEquals(1, bucket.getDocCount());
                assertEquals(1, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());
    }
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
        Consumer<DateHistogramAggregationBuilder> aggregation = agg -> agg.dateHistogramInterval(DateHistogramInterval.YEAR)
import org.apache.lucene.search.Query;
        boolean useNanosecondResolution
            },
            false,
        assertFalse(
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            config.setIndexSort(new Sort(sortField));
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        IllegalArgumentException e = expectThrows(
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
                assertEquals(3, buckets.size());
import org.opensearch.common.settings.Settings;
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
    public void testNoDocsDeprecatedInterval() throws IOException {
        testSearchCase(
                ),
            ),
                        }
                "2017-02-01T10:15:00.000Z",
    }
                bucket = buckets.get(1);
                false
                    .timeZone(ZoneId.of("America/New_York")),
                bucket = buckets.get(3);
                bucket = buckets.get(3);
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
/*
                new MatchAllDocsQuery(),
        dataset.put("2017-02-01T09:59:59.999Z", randomIntBetween(100, 2000));
        testSearchCase(
            histogram -> assertEquals(8, histogram.getBuckets().size()),
            Arrays.asList(
            false,
            }
        assertThat(
            true
            )
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("24h")).field(AGGREGABLE_DATE).minDocCount(1L),
                assertEquals(0, histogram.getBuckets().size());
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field("wrong_field"),
import org.opensearch.index.IndexSettings;
        );
import org.apache.lucene.tests.index.RandomIndexWriter;
            () -> testSearchCase(
                assertEquals(1, bucket.getDocCount());
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
            histogram -> {
    private static long asLong(String dateTime) {
        testSearchCase(
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR),
                assertEquals("2016-01-01T00:00:00.000Z", bucket.getKeyAsString());
            timestamps,
                false
            timestamps,
        Query query = LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2017-02-01T00:00:00.000Z"), asLong("2017-02-01T00:00:30.000Z"));
        // non-UTC timezone, no sub-agg: fast path declines -> intra-eligible
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE).minDocCount(1L),
            histogram -> {
                assertEquals(1, bucket.getDocCount());
            histogram -> {
                assertEquals(1, bucket.getDocCount());
        testSearchCase(
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals(3, bucket.getDocCount());
            IllegalArgumentException.class,
                doc.add(new LongPoint(filterField, 2));
                    .calendarInterval(DateHistogramInterval.YEAR)
    public void testFixedWithCalendar() throws IOException {
        }, false);
                "2017-02-01T09:02:35.000Z",
                InternalDateHistogram histogram = searchAndReduce(
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
    }
                fieldTypes
                assertEquals("2017-02-01T09:15:00.000Z", bucket.getKeyAsString());
                new MatchAllDocsQuery(),
                assertEquals(1, buckets.size());
                assertEquals(2, bucket.getDocCount());
 * GitHub history for details.
        Consumer<Integer> verifyCollectCount,
import org.apache.lucene.search.MatchNoDocsQuery;
                histogram -> {},
    }
        assertThat(e.getMessage(), equalTo("Cannot use [fixed_interval] with [calendar_interval] configuration option."));
    private boolean supportsIntraSegmentSearch(org.opensearch.search.aggregations.AggregationBuilder builder, boolean searchable)
            supportsIntraSegmentSearch(
            histogram -> {
                bucket = buckets.get(1);
                true
        logger.debug("Aggregable date is searchable {}", aggregableDateIsSearchable);
import org.apache.lucene.document.Document;
            histogram -> {
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            Arrays.asList(
                bucket = buckets.get(1);
                if (categoryField != null) {
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
                verify.accept(histogram);
        testSearchCase(
                assertEquals(2, bucket.getDocCount());
    public void testSupportsIntraSegmentSearch() throws IOException {
            IndexWriterConfig config = newIndexWriterConfig();
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
        testSearchCase(
                    indexSettings,
                assertEquals(3, bucket.getDocCount());
        try (Directory directory = newDirectory()) {
            )
        dataset.put("2017-02-01T13:06:00.000Z", randomIntBetween(100, 2000));
            StringTerms.Bucket bk1b = bk1.getBucketByKey("b");
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                assertEquals(6, buckets.size());
                "2017-02-01T14:05:00.000Z",
                .field(AGGREGABLE_DATE),
            false
            new MatchAllDocsQuery(),
        SortField sortField = fieldData.sortField(null, MultiValueMode.MIN, null, false);
            true // force AGGREGABLE_DATE field to be searchable to test the filter rewrite optimization path
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE).minDocCount(1L),
                bucket = buckets.get(3);
                assertEquals(1, bucket.getDocCount());
import org.apache.lucene.index.DirectoryReader;
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.apache.lucene.search.SortField;
                .hardBounds(new LongBounds("2017-02-03", "2020-01-01"))
        List<String> dates = Collections.emptyList();
                Histogram.Bucket bucket = buckets.get(0);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        // 5 sec interval with minDocCount = 3
                bucket = buckets.get(1);
                assertEquals("2017-02-01T09:02:00.000Z", bucket.getKeyAsString());
        DateFieldMapper.DateFieldType fieldType = aggregableDateFieldType(useNanosecondResolution, aggregableDateIsSearchable);
                "2017-02-01T00:00:05.015298384Z",
                indexWriter.addDocument(doc);
                assertEquals(expected, bucket.getDocCount());
import org.opensearch.index.mapper.NumberFieldMapper;
                assertEquals("2015-01-01T00:00:00.000Z", bucket.getKeyAsString());
    }
            indexWriter.commit();
                bucket = buckets.get(2);
                bucket = buckets.get(1);
    public void testAggregateWrongField() throws IOException {
        boolean randomWrite
            DateFieldMapper.DateFieldType dft = aggregableDateFieldType(false, searchable);
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                assertEquals(6, histogram.getBuckets().size());
            false
            },
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
                assertEquals(3, buckets.size());
                assertNotNull("Max sub-agg should exist", maxAgg2017);
        testSearchCase(
        List<String> foo = new ArrayList<>();
                bucket = buckets.get(1);
            new MatchAllDocsQuery(),
            indexWriter.commit();
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
 *
            },
        assertFalse(
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, dft, nft)
        testSearchCase(
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
        try (Directory directory = newDirectory()) {
            }
                Histogram.Bucket bucket = buckets.get(0);
            histogram -> {
                assertFalse(AggregationInspectionHelper.hasValue(histogram));
 * license agreements. See the NOTICE file distributed with
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                );
                new MatchAllDocsQuery(),
    public void testMatchNoDocs() throws IOException {
            histogram -> {
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
                assertNotNull("Max sub-agg should exist", maxAgg2015);
        dataset.put("2017-02-01T09:02:00.000Z", randomIntBetween(100, 2000));
                bucket = buckets.get(4);
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
                    .calendarInterval(DateHistogramInterval.YEAR)
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                aggregation -> aggregation.interval(1000).calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
            histogram -> {
                );
            false
        Query query,
    private static Settings getSettingsWithIndexSort() {
                bucket = buckets.get(1);
                assertEquals("2017-02-01T09:15:00.000Z", bucket.getKeyAsString());
        List<String> dataset,
                assertEquals(expected, bucket.getDocCount());
                int expected = dataset.get("2017-02-01T09:02:00.000Z") + dataset.get("2017-02-01T09:59:59.999Z");
                long timestamp = DateFormatters.from(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER.parse(DATASET.get(i)))
            // First commit - 5 dates with type 1
        Query query = new MatchAllDocsQuery();
            DATASET,
    }
        asSubAggTestCase(builder, (StringTerms terms) -> {
            DATASET,
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
                assertEquals(3, bucket.getDocCount());
            indexWriter.commit();
            () -> testSearchCase(
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            .field(AGGREGABLE_DATE);
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
        testSearchCase(
        Query query,
                    PipelineAggregator.PipelineTree.EMPTY
            },
        assertTrue(
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
    }
                aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.DAY)
                IndexSearcher searcher = newIndexSearcher(reader);
        testSearchCase(query, dataset, configure, verify, 10000, useNanosecondResolution);
            histogram -> {
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T09:15:00.000Z", bucket.getKeyAsString());
        boolean aggregableDateIsSearchable
                bucket = buckets.get(3);
            },
                assertEquals(2, bucket.getDocCount());
                            document.add(new LongPoint(AGGREGABLE_DATE, instant));
                assertEquals(expected, bucket.getDocCount());
    public void testMultiRangeTraversalNotApplicable() throws IOException {
                assertEquals(expected, bucket.getDocCount());
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
            )
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());
            () -> testSearchCase(
                Histogram.Bucket bucket = buckets.get(0);
                Histogram.Bucket bucket = buckets.get(0);
                "2017-02-01T09:02:00.000Z",
            StringTerms.Bucket a = terms.getBucketByKey("a");
        testSearchCase(
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE).minDocCount(1L),
                );
                            long instant = asLong(date.getKey(), fieldType);
        for (int i = 0; i < 1000; i++) {
        Consumer<DateHistogramAggregationBuilder> configure,
        );
            false
                }
        MappedFieldType dateType = new DateFieldMapper.DateFieldType(AGGREGABLE_DATE);
                "2017-02-01T00:00:37.688314602Z",
                    dateType,
                assertEquals(6, buckets.size());
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(3L),
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                    document.add(new SortedNumericDocValuesField(AGGREGABLE_DATE, instant));
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
                "2017-02-01T16:48:00.000Z",
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                "2017-02-01T00:00:37.688Z",
            )
            false
                    false,
                assertEquals(1, bucket.getDocCount());
            new MatchAllDocsQuery(),
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                    indexSearcher,
                expected = dataset.get("2017-02-01T14:04:00.000Z") + dataset.get("2017-02-01T14:05:00.000Z");
            IllegalArgumentException.class,
                bk1bdh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2017-01-01T09:00:00.000Z"), asLong("2017-02-01T14:04:01.000Z")),
                assertEquals(2, bucket.getDocCount());
                new MatchAllDocsQuery(),
                assertEquals(1, bucket.getDocCount());
        e = expectThrows(
                    .subAggregation(
            },
                assertEquals(1, bucket.getDocCount());
            query,
            },
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
        dataset.put("2017-02-01T09:02:00.000Z", randomIntBetween(100, 2000));
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
            supportsIntraSegmentSearch(
        }
                bucket = buckets.get(3);
                InternalDateHistogram topLevel = (InternalDateHistogram) aggregator.buildTopLevel();
            },
                assertEquals(1, bucket.getDocCount());
        IllegalArgumentException e = expectThrows(
            },
                    );
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertNotNull("Sub-aggregation should exist for 2017 bucket", bucket2017.getAggregations());
                "2017-02-01T09:02:00.000Z",
                "2017-02-01T09:35:00.000Z",
                bucket = buckets.get(2);
                assertEquals("Max category value for 2017 bucket should be 1", 1.0, maxAgg2017.getValue(), 0.0);
                "2017-02-01T00:00:11.299954583Z",
                "2017-02-01T16:59:00.000Z"
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
                    doc.add(new NumericDocValuesField(categoryField, i % 2));
import org.opensearch.search.aggregations.BucketOrder;
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
        Consumer<InternalDateHistogram> verify,
                assertEquals(3, bucket.getDocCount());
            },
    public void testIntervalMinute() throws IOException {
            histogram -> {
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2016-01-01"), asLong("2017-02-02")),
                assertEquals("2017-02-01T00:00:20.000Z", bucket.getKeyAsString());
                "2017-02-01T00:00:37.380Z"
                "2017-02-01T00:00:37.210Z",
                    .extendedBounds(new LongBounds("2009-01-01", "2021-01-01"))
            false
import org.opensearch.index.mapper.MappedFieldType;
                assertEquals(expected, bucket.getDocCount());
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());
            // Third commit - 2 more dates with type 2
                    .timeZone(ZoneId.of("America/New_York"))
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
        dataset.put("2017-02-01T13:06:00.000Z", 512);
                    .fixedInterval(new DateHistogramInterval("2d"))
                aggregator.postCollection();
            false
    }
            10000,
 * the Apache License, Version 2.0 (the "License"); you may
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
            new MatchAllDocsQuery(),
                assertEquals("2017-03-01T00:00:00.000Z", bucket.getKeyAsString());
            () -> testSearchCase(
                assertEquals(2, bucket.getDocCount());
        boolean useDocCountField,
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            },
            } else {
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                    .toInstant()
    }
                Histogram.Bucket bucket = buckets.get(0);
            createAggregator(
        dataset.put("2017-02-01T09:59:59.999Z", 256);
                    .hardBounds(new LongBounds("2010-01-01", "2020-01-01"))
    }
        );
                    "2017-02-01T16:59:00.000Z"
        );
                    aggregationBuilder,
            IllegalArgumentException.class,
                "2017-02-01T00:00:11.074Z",
                assertEquals(1, bucket.getDocCount());
        dataset.put("2017-02-01T15:59:00.000Z", randomIntBetween(100, 2000));
                bucket = buckets.get(1);
    public void testIntervalMonthDeprecated() throws IOException {
                CountingAggregator aggregator = createCountingAggregator(query, aggregationBuilder, indexSearcher, fieldType);
            equalTo(
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
    }
                aggregation -> aggregation.interval(1000).fixedInterval(new DateHistogramInterval("2d")).field(AGGREGABLE_DATE),
            false
                assertEquals(2, bucket.getDocCount());
                "2017-02-01T09:02:59.000Z",
            NumberFieldMapper.NumberFieldType nft = new NumberFieldMapper.NumberFieldType("n", NumberFieldMapper.NumberType.LONG);
                assertEquals(2, bucket.getDocCount());
            ),
                bucket = buckets.get(3);
            new MatchAllDocsQuery(),
            histogram -> {
        );
        );
                adh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
                "2017-02-01T00:00:37.688Z",
        NumberFieldMapper.NumberFieldType categoryType = new NumberFieldMapper.NumberFieldType(
                bucket = buckets.get(2);
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
        );
            histogram -> {
                bucket = buckets.get(1);
            false
            IllegalArgumentException.class,
            },
                bucket = buckets.get(4);
            histogram -> {
        testSearchCase(
                }
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
        testSearchCase(
                histogram -> {},
                }
                }
                Histogram.Bucket bucket = buckets.get(0);
                }
                    doc.add(new NumericDocValuesField(categoryField, i % 2));
                assertEquals(1, bucket.getDocCount());
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            )
            () -> testSearchCase(
                assertEquals(3, bucket.getDocCount());
        dataset.put("2017-02-01T16:59:00.000Z", randomIntBetween(100, 2000));
                assertEquals(1, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());
    }
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                bucket = buckets.get(5);
                .field(AGGREGABLE_DATE),
            assertThat(
        );
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        );
            "2017-02-01T00:00:11.299Z",
                aggregation -> aggregation.fixedInterval(DateHistogramInterval.WEEK).field(AGGREGABLE_DATE),
 * not use this file except in compliance with the License.
                if (configure != null) {
                "2017-02-01T00:00:11.299Z",
                    .field(AGGREGABLE_DATE),
        testSearchCase(
            foo,
            false,
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                "2017-02-01T09:16:42.000Z"
        testSearchCase(
                assertEquals("2015-01-01T00:00:00.000Z", bucket2015.getKeyAsString());
                assertEquals(3, bucket.getDocCount());
        );
                doc.add(new LongPoint(filterField, 2));
                "2017-02-01T09:16:04.000Z",
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                .field(AGGREGABLE_DATE),
            false,
                    if (useDocCountField) {
                    configure.accept(aggregationBuilder);
        assertThat(e.getMessage(), equalTo("Cannot use [calendar_interval] with [interval] configuration option."));
        IndexSearcher searcher,
                new MatchAllDocsQuery(),
                assertEquals(2, bucket.getDocCount());
                Collections.emptyList(),
                assertEquals(2, bucket.getDocCount());
                assertEquals("2017-02-01T00:00:20.000Z", bucket.getKeyAsString());
                histogram -> {},
                assertEquals(2, bucket.getDocCount());
            supportsIntraSegmentSearch(
                assertEquals(expected, bucket.getDocCount());
            DATASET,
                bucket = buckets.get(2);
                assertEquals(2, bucket.getDocCount());
            DATASET,
                true
 */
                bucket = buckets.get(2);
            10000,
                bucket = buckets.get(1);
            );
        );
            query,
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                "2017-02-01T13:06:00.000Z",
                "2017-02-01T15:59:00.000Z",
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
    public void testNewThenLegacy() throws IOException {
        List<String> dataset,
                "2017-02-01T00:00:05.015Z",
        "2015-06-24T13:47:43",
            Arrays.asList(
                bucket = buckets.get(1);
            supportsIntraSegmentSearch(
                assertEquals(2, bucket.getDocCount());
    }
    public void testIntervalSecondDeprecated() throws IOException {
                    .fixedInterval(new DateHistogramInterval("2d"))
        );
            supportsIntraSegmentSearch(
        );
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);
            query,
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.MINUTE).field(AGGREGABLE_DATE).minDocCount(1L),
            false
            },
        testSearchCase(
                    }
                assertEquals(3, bucket.getDocCount());
            assertThat(
        testFilterRewriteCase(
        );
            ),
        DateFieldMapper.DateFieldType fieldType = aggregableDateFieldType(false, true);
                assertEquals(5, bucket.getDocCount());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            Arrays.asList("2017-01-01", "2017-02-02", "2017-02-03", "2017-03-04", "2017-03-05", "2017-03-06"),
        Consumer<InternalDateHistogram> verify,
        dataset.put("2017-02-01T14:04:00.000Z", randomIntBetween(100, 2000));
            },
                assertEquals(6, buckets.size());
        assertThat(e.getMessage(), equalTo("Cannot use [calendar_interval] with [fixed_interval] configuration option."));
                "2017-02-01T00:00:37.688Z",
    private void testSearchCase(
                assertEquals(1, bucket.getDocCount());
        );
                bucket = buckets.get(2);
        );
 * this work for additional information regarding copyright
                aggregation -> aggregation.fixedInterval(new DateHistogramInterval("2d"))
            false,
            new MatchAllDocsQuery(),
        List<String> timestamps = Arrays.asList(
            },
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
    public void testFixedAndThenCalendar() throws IOException {
                assertEquals(1, bucket2016.getDocCount());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                    document.add(new NumericDocValuesField(DocCountFieldMapper.NAME, 5));
    }
                bucket = buckets.get(2);
                assertEquals(2, bucket.getDocCount());
            IllegalArgumentException.class,
                bucket = buckets.get(2);
            histogram -> {
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
        }
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2017-02-03"), asLong("2020-01-01")),
            StringTerms.Bucket b = terms.getBucketByKey("b");
                    .field(AGGREGABLE_DATE),
                indexWriter.addDocument(doc);
import org.apache.lucene.document.SortedNumericDocValuesField;
            histogram -> {
    }
            IllegalArgumentException.class,
        );
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
        dataset.put("2017-02-01T16:48:00.000Z", randomIntBetween(100, 2000));
        Consumer<InternalDateHistogram> verify,
            )
        // 5 sec interval with minDocCount = 0
        Map<String, Integer> dataset = new HashMap<>();
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            ),
                assertEquals(expected, bucket.getDocCount());
                InternalDateHistogram.Bucket bucket2017 = (InternalDateHistogram.Bucket) histogram.getBuckets().get(2);
            InternalDateHistogram adh = a.getAggregations().get("dh");
/*
 * compatible open source license.
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(1);
                "2017-02-01T00:00:37.380Z"
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
import org.apache.lucene.document.LongPoint;
        "2015-11-13T16:14:34",
    }
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(1, bucket.getDocCount());
    }
            Arrays.asList(
                    .dateHistogramInterval(DateHistogramInterval.DAY)
                assertEquals("2017-01-01T00:00:00.000Z", histogram.getBuckets().get(2).getKeyAsString());
                false
                assertEquals("2016-01-01T00:00:00.000Z", bucket.getKeyAsString());
 * this file be licensed under the Apache-2.0 license or a
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);
    public void testLegacyThenNew() throws IOException {
            false,
    }
            false,
    }
                bucket = buckets.get(5);
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                                useDocCountField = false;
        List<String> timestamps = Arrays.asList(
                histogram -> {},
            histogram -> {
        "2013-10-31T08:24:05",
        );
            "2017-02-01T00:00:05.015Z",
                bucket = buckets.get(2);
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
            () -> testSearchCase(
                    .calendarInterval(DateHistogramInterval.DAY)
                    .build(
                assertEquals(1, bucket.getDocCount());
        );
                    DEFAULT_MAX_BUCKETS,
        }
            .putList("index.sort.field", AGGREGABLE_DATE)
            new MatchAllDocsQuery(),
        // searchable UTC top-level, no sub-agg: fast path applies -> NOT intra-eligible
            DATASET,
                assertEquals(3, bucket.getDocCount());
            StringTerms.Bucket ak1a = ak1.getBucketByKey("a");
                    fieldType
                            document.add(new LongPoint(AGGREGABLE_DATE, instant));
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
                "2017-02-01T10:15:00.000Z",
    public void testIntervalYear() throws IOException {
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
        testSearchCase(
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            },
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                histogram -> {},
        IllegalArgumentException ex = expectThrows(
                InternalDateHistogram histogram = searchAndReduce(indexSearcher, query, aggregationBuilder, maxBucket, fieldType);
                assertEquals(5, buckets.size());
        testSearchCase(
    }
                org.opensearch.search.aggregations.metrics.InternalMax maxAgg2017 = bucket2017.getAggregations().get(categoryField);
                assertEquals(3, buckets.size());
                assertNotNull("Max sub-agg should exist", maxAgg2016);
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.HOUR).field(AGGREGABLE_DATE).minDocCount(1L),
            indexDocsForSkiplist(directory, config, filterField, categoryField);
                bucket = buckets.get(1);
            StringTerms ak1 = a.getAggregations().get("k1");
        AggregationBuilder builder,
                // Verify second bucket (2016)
import org.apache.lucene.search.IndexSearcher;
        "2016-03-04T17:09:50",
    public void testIntervalYearDeprecated() throws IOException {
        );
            histogram -> {
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
                aggregation -> aggregation.calendarInterval(new DateHistogramInterval("5d")).field(AGGREGABLE_DATE),
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(2, buckets.size());
                assertEquals(1, bucket.getDocCount());
            String filterField = "type";
 *
import static org.hamcrest.Matchers.equalTo;
        Map<String, Integer> dataset = new HashMap<>();
            IllegalArgumentException.class,
                if (categoryField != null) {
                assertEquals(3, bucket.getDocCount());
                assertEquals(3, buckets.size());
        return Settings.builder()
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
            )
                bucket = buckets.get(2);
            false
        );
        );
            )
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
    public void testNoDocs() throws IOException {
                assertEquals(expected, bucket.getDocCount());
    }
                Histogram.Bucket bucket = buckets.get(0);
        );
            false
            new MatchAllDocsQuery(),
                    Integer.MAX_VALUE,
        Consumer<InternalDateHistogram> verify,
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
            "2017-02-01T00:00:13.688Z",
                                document.add(new NumericDocValuesField(DocCountFieldMapper.NAME, 5));
        dataset.put("2017-02-01T16:48:00.000Z", randomIntBetween(100, 2000));
            histogram -> {
            false
                aggregation -> aggregation.fixedInterval(new DateHistogramInterval("2d")).interval(1000).field(AGGREGABLE_DATE),
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
            10000,
            StringTerms bk1 = b.getAggregations().get("k1");
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                "2017-02-01T00:00:11.074986434Z",
                "2017-02-01T00:00:37.688314602Z",
                assertEquals(3, buckets.size());
            () -> testSearchCase(
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("test").field(AGGREGABLE_DATE)
                bucket = buckets.get(1);
                builder,
                bk1adh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
            },
import org.apache.lucene.index.IndexWriter;
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
                bucket = buckets.get(1);
                "2017-02-01T09:15:37.000Z",
                expected = dataset.get("2017-02-01T15:59:00.000Z");
                bucket = buckets.get(3);
            false
    }
    protected CountingAggregator createCountingAggregator(
import org.opensearch.common.time.DateFormatters;
                "2017-02-01T09:16:04.000Z",
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
            false
            histogram -> assertEquals(0, histogram.getBuckets().size()),
                return factories.allFactoriesSupportIntraSegmentSearch();
            DATASET,
        e = expectThrows(
    }
                            documents.add(document);
            histogram -> assertEquals(0, histogram.getBuckets().size()),
    private static final List<String> DATASET = Arrays.asList(
                bucket = buckets.get(2);
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d"))
            false
        );
                assertEquals(1, bucket.getDocCount());
                .order(BucketOrder.count(false)),
                    reduceBucketConsumer,
    }
                    indexWriter.addDocument(document);
            true
    public void testCalendarAndThenFixed() throws IOException {
                false
                Document doc = new Document();
import org.opensearch.search.aggregations.AggregatorFactories;
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        }
            config.setMergePolicy(NoMergePolicy.INSTANCE);
                    .field(AGGREGABLE_DATE),
            )
                ak1adh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
}
                    1000,
                "2017-02-01T14:04:00.000Z",
                bucket = buckets.get(2);
    }
                Histogram.Bucket bucket = buckets.get(0);
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
    public void testDocCountField() throws IOException {
                Query query = LongPoint.newExactQuery(filterField, 2);
            "2017-02-01T00:00:05.015Z",
import org.opensearch.index.mapper.DocCountFieldMapper;
    /**
            histogram -> {
            false
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
    }
            false
    }
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals(3, buckets.size());
                }
                long timestamp = DateFormatters.from(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER.parse(DATASET.get(i)))
                    .toInstant()
        e = expectThrows(
                Histogram.Bucket bucket = buckets.get(0);
                            Document document = new Document();
            DATASET,
                verifyCollectCount.accept(aggregator.getCollectCount().get());
                assertEquals(1, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());
                    getMockScriptService(),
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                expected = dataset.get("2017-02-01T10:00:00.001Z");
                assertEquals(1, buckets.size());
                    .calendarInterval(DateHistogramInterval.YEAR)
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
                "2017-02-01T00:00:11.074Z",
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
            "2017-02-01T00:00:21.380Z"
                assertEquals(3, histogram.getBuckets().get(0).getDocCount());
                expected = dataset.get("2017-02-01T14:04:00.000Z") + dataset.get("2017-02-01T14:05:00.000Z");
    }
                assertEquals(4, buckets.size());
        Consumer<DateHistogramAggregationBuilder> configure,
        String categoryField = "category";
        try (IndexWriter indexWriter = new IndexWriter(directory, config)) {
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
        return fieldType.parse(dateTime);
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
                new HistogramAggregationBuilder("outer").field("n")
                    categoryType
                Histogram.Bucket bucket = buckets.get(0);
                indexWriter.addDocument(doc);
                doc.add(SortedNumericDocValuesField.indexedField(AGGREGABLE_DATE, timestamp));
                "2017-02-01T16:06:00.000Z",
        assertThat(e.getMessage(), equalTo("Cannot use [calendar_interval] with [interval] configuration option."));
                assertEquals(1, bucket.getDocCount());
            }
    public void testMinDocCount() throws IOException {
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
            "2017-02-01T00:00:13.688Z",
import java.util.List;
                    .calendarInterval(DateHistogramInterval.DAY)
                Histogram.Bucket bucket = buckets.get(0);
                "2017-02-01T09:02:35.000Z",
        Query query,
        asSubAggTestCase(builder, (StringTerms terms) -> {
    private void testSearchCase(
            assertThat(
    ) throws IOException {
                bucket = buckets.get(1);
                assertEquals(0, bucket.getDocCount());
                assertEquals(0, buckets.size());
import java.util.ArrayList;
        );
                bucket = buckets.get(2);
                    for (Map.Entry<String, Integer> date : dataset.entrySet()) {
        }
                "2017-02-01T16:06:00.000Z",
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
            )
                false
                bucket = buckets.get(3);
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
    ) throws IOException {
            },
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
        "2010-03-12T01:07:45",
import org.apache.lucene.search.MatchAllDocsQuery;
            histogram -> assertEquals(8, histogram.getBuckets().size()),
    }
        testSearchCase(
            "2017-02-01T00:00:11.299Z",
                "2017-02-01T14:05:00.000Z",
            true
            );
                "2017-02-01T09:02:59.000Z",
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE).minDocCount(1L),
            for (int i = 0; i < 5; i++) {
                        document.add(new NumericDocValuesField(DocCountFieldMapper.NAME, 5));
                bucket = buckets.get(2);
    public void testNanosIntervalSecond() throws IOException {
 * You may obtain a copy of the License at
        Query query = new MatchAllDocsQuery();
            new MatchAllDocsQuery(),
            histogram -> {
                assertEquals(4, buckets.size());
            InternalDateHistogram ak1adh = ak1a.getAggregations().get("dh");
                histogram -> {},
        );
                bucket = buckets.get(1);
        );
        SortField sortField = fieldData.sortField(null, MultiValueMode.MIN, null, false);
                            long instant = asLong(date.getKey(), fieldType);
        boolean useNanosecondResolution
        testSearchCase(
                "2017-02-01T09:15:37.000Z",
            InternalDateHistogram bk1adh = bk1a.getAggregations().get("dh");
                "2017-02-01T14:05:00.000Z",
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
                assertEquals(expected, bucket.getDocCount());
                assertEquals(3, buckets.size());
                    }
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("1000ms")).field(AGGREGABLE_DATE).minDocCount(1L),
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2016-01-01"), asLong("2017-01-01")),
            false
