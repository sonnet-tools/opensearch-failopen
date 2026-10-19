        );  
                    Document document = new Document();
        // searchable UTC top-level, no sub-agg: fast path applies -> NOT intra-eligible
                InternalDateHistogram.Bucket bucket2015 = (InternalDateHistogram.Bucket) histogram.getBuckets().get(0);
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
        Map<String, Integer> dataset = new HashMap<>();
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.SECOND).field(AGGREGABLE_DATE).minDocCount(1L),
            new MatchNoDocsQuery(),
        );  
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T00:00:20.000Z", bucket.getKeyAsString());
            "2017-02-01T00:00:11.074Z",
            createAggregator(
                            if (useDocCountField) {
            },
                Histogram.Bucket bucket = buckets.get(0);
            )
        testSearchCase(
                assertEquals(3, bucket.getDocCount());  
 * GitHub history for details.
            },
            false
                assertEquals("2017-02-01T00:00:15.000Z", bucket.getKeyAsString());
                Histogram.Bucket bucket = buckets.get(0);
                bucket = buckets.get(4);  
import org.opensearch.common.settings.Settings;  
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
import org.apache.lucene.document.SortedNumericDocValuesField;
                    indexSettings,
                histogram -> {},  
                    for (Map.Entry<String, Integer> date : dataset.entrySet()) {
        }  
            new MatchNoDocsQuery(),
                    List<Document> documents = new ArrayList<>();
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field("wrong_field"),
        "2015-06-24T13:47:43",  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)  
                    for (Map.Entry<String, Integer> date : dataset.entrySet()) {  
            String filterField = "type";
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());  
                Document doc = new Document();
        );
    private void testFilterRewriteCase(
                "2017-02-01T00:00:11.074Z",
                assertEquals(3, histogram.getBuckets().size()); // 2015, 2016, 2017 (only type 2 docs)
        try (Directory directory = newDirectory()) {
        Consumer<DateHistogramAggregationBuilder> configure,
                Query query = LongPoint.newExactQuery(filterField, 2);
                "2017-02-01T10:15:00.000Z",  
                Collections.emptyList(),  
        assertTrue(
                new MatchAllDocsQuery(),
            },
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());  
            // Second commit - 3 more dates with type 2, skiplist
    }  
                new MatchAllDocsQuery(),  
        throws IOException {
                aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.DAY)  
                "2017-02-01T16:06:00.000Z",  
    }
        List<String> dataset,  
                assertEquals(2, bucket.getDocCount());  
                    .hardBounds(new LongBounds("2010-01-01", "2020-01-01"))
                builder,
            histogram -> {
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
    public void testNoDocs() throws IOException {  
                Histogram.Bucket bucket = buckets.get(0);  
            Arrays.asList(
            false  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),  
                "2017-02-01T09:15:37.000Z",  
            },
 */
        IllegalArgumentException e = expectThrows(
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),  
            IndexWriterConfig config = newIndexWriterConfig();
        dataset.put("2017-02-01T09:02:00.000Z", randomIntBetween(100, 2000));
            supportsIntraSegmentSearch(  
        );
        Query query = new MatchNoDocsQuery();
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.HOUR).field(AGGREGABLE_DATE).minDocCount(1L),
                "2017-02-01T09:02:59.000Z",  
                bucket = buckets.get(3);
        Query query = new MatchAllDocsQuery();
                Histogram.Bucket bucket = buckets.get(0);
            new MatchAllDocsQuery(),
    public void testIllegalInterval() throws IOException {
                Histogram.Bucket bucket = buckets.get(0);
            true  
    private static long asLong(String dateTime, DateFieldMapper.DateFieldType fieldType) {
                        for (int i = 0; i < date.getValue(); i++) {  
import org.opensearch.search.aggregations.AggregatorFactories;  
        MappedFieldType fieldType = new DateFieldMapper.DateFieldType(AGGREGABLE_DATE);
            DATASET,
                "2017-02-01T00:00:37.210Z",
        testSearchCase(
        SortField sortField = fieldData.sortField(null, MultiValueMode.MIN, null, false);  
                "2017-02-01T14:04:00.000Z",  
        );
            histogram -> {
            histogram -> {
                assertEquals(expected, bucket.getDocCount());  
    public void testAggregateWrongFieldDeprecated() throws IOException {
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());
        );
                    .subAggregation(
                    .field(AGGREGABLE_DATE),
        boolean aggregableDateIsSearchable  
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
                    .field(AGGREGABLE_DATE),  
    }
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                "2017-02-01T09:16:04.000Z",
    public void testNewThenLegacy() throws IOException {
     * always opts in (partition-aware collection).
            Arrays.asList(
        );
                assertEquals(0, histogram.getBuckets().size());  
        testSearchCase(  
                assertEquals(3, histogram.getBuckets().size()); // 2015, 2016, 2017 (only type 2 docs)
    public void testIntervalDayDeprecated() throws IOException {
        );
            IllegalArgumentException.class,  
            new MatchNoDocsQuery(),
                doc.add(new LongPoint(filterField, 2));  
                assertFalse(AggregationInspectionHelper.hasValue(histogram));
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());  
                "2017-02-01T00:00:37.380889483Z"
            query,
            false
    private static final List<String> DATASET = Arrays.asList(
        dataset.put("2017-02-01T10:00:00.001Z", 256);
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2017-01-01T09:00:00.000Z"), asLong("2017-02-01T16:00:00.000Z")),
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);  
            },
        }  
        );
     * partition (false). It declines for non-UTC / non-searchable / nested → partition (true). With a sub-agg it  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
 * not use this file except in compliance with the License.
            )
                bucket = buckets.get(2);  
                "2017-02-01T16:48:00.000Z",  
        assertTrue(
                assertEquals(1, bucket.getDocCount());  
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());
            histogram -> {
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
        Map<String, Integer> dataset = new HashMap<>();
                assertEquals(2, bucket.getDocCount());
        );
import org.opensearch.common.time.DateFormatters;
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
        Consumer<Integer> verifyCollectCount,
                bucket = buckets.get(1);  
        int maxBucket,
        boolean useDocCountField,
import org.apache.lucene.tests.util.TestUtil;  
                assertEquals(1, bucket.getDocCount());
                false
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                    .calendarInterval(DateHistogramInterval.DAY)
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
            DATASET,  
import org.opensearch.search.MultiValueMode;
        dataset.put("2017-02-01T13:06:00.000Z", randomIntBetween(100, 2000));
            false  
                    .calendarInterval(DateHistogramInterval.DAY)
    public void testMatchNoDocsDeprecatedInterval() throws IOException {  
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
            false
                assertEquals(3, bucket.getDocCount());  
            false
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                for (String date : dataset) {
        Map<String, Integer> dataset = new HashMap<>();
            10000,
        );
                    dateType,
        testSearchCase(
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.SECOND).field(AGGREGABLE_DATE).minDocCount(1L),
        testSearchCase(
                assertEquals(expected, bucket.getDocCount());  
                new MultiBucketConsumerService.MultiBucketConsumer(  
            new MatchAllDocsQuery(),
        }, false);
                Histogram.Bucket bucket = buckets.get(0);  
            histogram -> {  
            StringTerms.Bucket bk1a = bk1.getBucketByKey("a");
            .build();
                Histogram.Bucket bucket = buckets.get(0);
            Arrays.asList(  
        // non-UTC timezone, no sub-agg: fast path declines -> intra-eligible  
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        testSearchCase(
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("24h")).field(AGGREGABLE_DATE).minDocCount(1L),
            true // force AGGREGABLE_DATE field to be searchable to test the filter rewrite optimization path
            new MatchAllDocsQuery(),
        );  
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        );  
        int maxBucket,  
            () -> testSearchCase(
                assertEquals(1, bucket.getDocCount());  
            ),
        );
    public void testFixedWithCalendar() throws IOException {
            query,  
import org.opensearch.index.fielddata.IndexNumericFieldData;
            histogram -> {  
        // with a sub-aggregation AND fast path declines (non-UTC): intra-eligible (doc-by-doc parallelizes)
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                "2017-02-01T00:00:05.015Z",  
                false
        testSearchCase(
import org.opensearch.index.mapper.DateFieldMapper;  
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
                assertEquals(2, bucket.getDocCount());
        testSearchCase(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            new MatchAllDocsQuery(),  
                MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
            () -> testSearchCase(
 *
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
import org.opensearch.search.aggregations.InternalAggregation;
                    .interval(10)
                    .calendarInterval(DateHistogramInterval.YEAR)
                assertEquals(3, bucket.getDocCount());
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
                    configure.accept(aggregationBuilder);
    }  
                assertEquals(2, bucket.getDocCount());
        SortField sortField = fieldData.sortField(null, MultiValueMode.MIN, null, false);  
            },
        testSearchCase(
        Consumer<DateHistogramAggregationBuilder> configure,
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(3, bucket.getDocCount());  
                assertEquals(3, buckets.size());
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
            histogram -> assertEquals(6, histogram.getBuckets().size()),
            .field(AGGREGABLE_DATE);
        e = expectThrows(  
    }  
            histogram -> {
            new MatchAllDocsQuery(),  
                    .field(AGGREGABLE_DATE),
            IllegalArgumentException.class,  
            DATASET,
import org.apache.lucene.index.IndexWriterConfig;
                    1000,
import org.apache.lucene.search.MatchNoDocsQuery;  
            IllegalArgumentException.class,
                expected = dataset.get("2017-02-01T10:00:00.001Z");
        int maxBucket,  
            timestamps,  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d"))
                assertEquals(3, bucket.getDocCount());  
        Settings settings = getSettingsWithIndexSort();  
                "failed to parse setting [date_histogram.fixedInterval] with value [1w] as a time value: "  
                assertNotNull("Sub-aggregation should exist for 2017 bucket", bucket2017.getAggregations());
        );
            histogram -> assertEquals(0, histogram.getBuckets().size()),
                bucket = buckets.get(2);
                assertEquals(3, buckets.size());  
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),  
            StringTerms.Bucket a = terms.getBucketByKey("a");
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(1, bucket.getDocCount());  
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
            indexWriter.addDocument(List.of(new SortedNumericDocValuesField(AGGREGABLE_DATE, dft.parse("2020-02-01T00:00:00Z"))));  
            new MatchAllDocsQuery(),
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                bucket = buckets.get(1);
                // Assert sub-aggregation values for 2016 bucket (doc 8 with category 0)
            query,  
                "2017-02-01T09:02:00.000Z",
        boolean useNanosecondResolution,
                                document.add(new NumericDocValuesField(DocCountFieldMapper.NAME, 5));
                "2017-02-01T15:59:00.000Z",
            "2017-02-01T00:00:13.688Z",
        return fieldType.parse(dateTime);
    }
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());  
                "2017-02-01T09:15:37.000Z",
                assertEquals(3, bucket.getDocCount());  
                assertEquals("2016-01-01T00:00:00.000Z", bucket2016.getKeyAsString());
                if (configure != null) {  
                bucket = buckets.get(1);  
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals("2015-01-01T00:00:00.000Z", bucket2015.getKeyAsString());  
                InternalDateHistogram histogram = searchAndReduce(  
        );  
    }
                "2017-02-01T09:02:59.000Z",  
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02"),
            histogram -> {  
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());  
        e = expectThrows(  
        );
                bucket = buckets.get(3);
                bucket = buckets.get(2);
                Histogram.Bucket bucket = buckets.get(0);
                false
                    indexSearcher,  
    public void testIntervalHour() throws IOException {
    public void testCalendarWithFixed() throws IOException {  
    }
        testSearchCase(
                InternalDateHistogram histogram = searchAndReduce(indexSearcher, query, aggregationBuilder, maxBucket, fieldType);  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
                verify.accept(histogram);
        );
            DateFieldMapper.DateFieldType dft = aggregableDateFieldType(false, searchable);
        testSearchCase(
        );  
                expected = dataset.get("2017-02-01T14:04:00.000Z") + dataset.get("2017-02-01T14:05:00.000Z");
            "2017-02-01T00:00:05.015Z",
            false
            histogram -> {  
            },
            false  
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());  
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)  
    }
                "2017-02-01T00:00:37.210328172Z",
            false  
                assertEquals(3, buckets.size());
        List<String> dates = Collections.emptyList();
        dataset.put("2017-02-01T13:06:00.000Z", randomIntBetween(100, 2000));
            () -> testSearchCase(
            "2017-02-01T00:00:21.380Z"
            new MatchAllDocsQuery(),
            timestamps,
                assertEquals(1, histogram.getBuckets().get(1).getDocCount());
                    ),
        Query query,  
                assertEquals(3, buckets.size());
                org.opensearch.search.aggregations.metrics.InternalMax maxAgg2017 = bucket2017.getAggregations().get(categoryField);  
            histogram -> {
            IllegalArgumentException.class,
        assertFalse(
        );
                InternalDateHistogram histogram = (InternalDateHistogram) topLevel.reduce(Collections.singletonList(topLevel), context);
    }
        testSearchCase(  
                    }
            new AtomicInteger(),
        });
        );  
                }
                            document.add(new SortedNumericDocValuesField(AGGREGABLE_DATE, instant));  
                "2017-02-01T14:04:00.000Z",  
                assertEquals(3, buckets.size());
                histogram -> {},
            assertThat(  
            new MatchAllDocsQuery(),  
                assertEquals(3, buckets.size());
                assertEquals(1, bucket.getDocCount());  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            )
                query,  
                false  
            StringTerms bk1 = b.getAggregations().get("k1");  
 * ownership. Elasticsearch licenses this file to you under  
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("test").field(AGGREGABLE_DATE)
    }  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
 * compatible open source license.
        boolean randomWrite  
            )
                assertEquals(0, histogram.getBuckets().size());
 * software distributed under the License is distributed on an
    public void testFixedAndThenCalendar() throws IOException {  
            },
        e = expectThrows(
                Histogram.Bucket bucket = buckets.get(0);
                "2017-02-01T00:00:37.688Z",
import java.util.Map;  
                bucket = buckets.get(2);
                    "2017-02-01T16:59:00.000Z"
            indexWriter.commit();  
        testSearchCase(
                // Assert sub-aggregation values for 2015 bucket (docs 5,6,7 with categories 1,0,1)  
                "2017-02-01T00:00:37.210Z",
    public void testSkiplistWithSingleValueDates() throws IOException {
        );  
            histogram -> assertEquals(6, histogram.getBuckets().size()),
            histogram -> {  
            DATASET,
                assertEquals(3, bucket.getDocCount());
        "2012-05-18T04:11:00",
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
    public void testMinDocCountDeprecated() throws IOException {
                assertEquals(2, buckets.size());
            false  
                assertEquals(expected, bucket.getDocCount());  
                new MatchAllDocsQuery(),
            DATASET,  
                "2017-02-01T00:00:05.015298384Z",
                bucket = buckets.get(2);
    }
import org.apache.lucene.tests.index.RandomIndexWriter;
                bucket = buckets.get(3);  
            histogram -> assertEquals(0, histogram.getBuckets().size()),
                assertEquals(expected, bucket.getDocCount());
                "2017-02-01T00:00:11.074986434Z",
                false
            assertThat(  
                new MatchAllDocsQuery(),
public class DateHistogramAggregatorTests extends DateHistogramAggregatorTestCase {
            )  
        testSearchCase(  
    private static final String SEARCHABLE_DATE = "searchable_date";  
                bucket = buckets.get(1);
                bucket = buckets.get(5);
                Document doc = new Document();
                bucket = buckets.get(2);
                "2017-02-01T09:16:04.000Z",
        );  
                assertEquals(2, bucket.getDocCount());
        testSearchCase(  
                    false,  
            10000,
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");  
            histogram -> {  
                histogram -> {},
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
            "2017-02-01T00:00:11.299Z",
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(
        );
                int expected = dataset.get("2017-02-01T09:02:00.000Z") + dataset.get("2017-02-01T09:59:59.999Z");  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
            DATASET,  
import java.util.function.Consumer;
import org.opensearch.index.mapper.NumberFieldMapper;  
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
            },
        boolean useDocCountField,
import org.apache.lucene.search.IndexSearcher;
            foo,  
            new MatchAllDocsQuery(),
        List<String> dates = Collections.emptyList();  
                assertEquals(1, bucket.getDocCount());
            Arrays.asList(
        List<String> dataset,
                assertEquals(1, bucket.getDocCount());  
        "2013-05-29T05:11:31",  
        asSubAggTestCase(builder, (StringTerms terms) -> {  
 *
        testSearchCase(
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());
    }
import org.apache.lucene.index.IndexReader;  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        Consumer<InternalDateHistogram> verify,
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
    public void testMultiRangeTraversal() throws IOException {  
            query,
        AggregationBuilder builder = new TermsAggregationBuilder("k1").field("k1")
    }
package org.opensearch.search.aggregations.bucket.histogram;
            }
            },  
                true
    }
    public void testOverlappingBounds() {  
            false,
            DATASET,
                            documents.add(document);
                doc.add(new LongPoint(filterField, 2));  
                    fieldType
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals("2017-02-01T09:15:00.000Z", bucket.getKeyAsString());  
            }
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
    );
                assertEquals(2, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());  
                assertEquals(3, buckets.size());
                    .dateHistogramInterval(DateHistogramInterval.DAY)
            StringTerms.Bucket b = terms.getBucketByKey("b");
        );
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field("wrong_field"),
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals(2, bucket.getDocCount());
                bucket = buckets.get(3);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            InternalDateHistogram adh = a.getAggregations().get("dh");
                assertFalse(AggregationInspectionHelper.hasValue(histogram));
                bucket = buckets.get(5);
                Histogram.Bucket bucket = buckets.get(0);
                expected = dataset.get("2017-02-01T10:00:00.001Z");
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),  
        boolean useDocCountField
        );
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                false
            IllegalArgumentException.class,
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("1000ms")).field(AGGREGABLE_DATE).minDocCount(1L),  
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.MINUTE).field(AGGREGABLE_DATE).minDocCount(1L),
                equalTo(List.of("2021-01-01T00:00Z"))
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
        );
        testSearchCase(
            ),  
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());  
 * specific language governing permissions and limitations
                bucket = buckets.get(2);  
                org.opensearch.search.aggregations.metrics.InternalMax maxAgg2016 = bucket2016.getAggregations().get(categoryField);
            }  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(e.getMessage(), equalTo("The supplied interval [5d] could not be parsed as a calendar interval."));
                new MatchAllDocsQuery(),  
        // 5 sec interval with minDocCount = 3
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
import org.opensearch.search.aggregations.AggregationBuilder;
        assertThat(  
import java.util.List;
                assertEquals(3, bucket.getDocCount());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
    /**  
            },  
    public void testMatchAllDocsDeprecatedInterval() throws IOException {
        testSearchCase(
                aggregator.postCollection();
                aggregation -> aggregation.fixedInterval(new DateHistogramInterval("2d"))  
            },
            10000,
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.MINUTE).field(AGGREGABLE_DATE).minDocCount(1L),
        );  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            "2017-02-01T00:00:11.074Z",  
        );
                assertEquals(3, bucket.getDocCount());
    ) throws IOException {
    }
        }  
                assertEquals("2016-01-01T00:00:00.000Z", bucket.getKeyAsString());  
                assertEquals(1, buckets.size());
            StringTerms.Bucket bk1b = bk1.getBucketByKey("b");
        }).build(null, null);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            .putList("index.sort.field", AGGREGABLE_DATE)  
            )
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
                    + "hard bounds: [2010-01-01--2020-01-01], extended bounds: [2009-01-01--2021-01-01]"
        Consumer<DateHistogramAggregationBuilder> aggregation = agg -> agg.calendarInterval(DateHistogramInterval.YEAR)  
            histogram -> {
    public void testHardBoundsNotOverlapping() throws IOException {  
                assertEquals(1, bucket.getDocCount());
            false
    private void testSearchCase(
        testSearchCase(  
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            new MatchAllDocsQuery(),  
        dataset.put("2017-02-01T14:04:00.000Z", 256);
                    categoryType
        testSearchCase(
            )
        testSearchCase(  
        );  
    private void testSearchCase(
                bucket = buckets.get(3);
        Query query,
import org.apache.lucene.index.NoMergePolicy;  
                );  
        // nested under a numeric histogram (parent != null): fast path can't apply -> intra-eligible  
        );
                assertEquals(1, bucket.getDocCount());
                assertEquals(1, bucket.getDocCount());
            false,
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
                doc.add(SortedNumericDocValuesField.indexedField(AGGREGABLE_DATE, timestamp));
        );
import java.util.concurrent.atomic.AtomicInteger;
    private void testSearchCase(
                histogram -> {},  
                aggregation -> aggregation.calendarInterval(new DateHistogramInterval("5d")).field(AGGREGABLE_DATE),  
    public void testDocCountField() throws IOException {
                bucket = buckets.get(1);
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
            IllegalArgumentException.class,
        assertThat(e.getMessage(), equalTo("Cannot use [calendar_interval] with [fixed_interval] configuration option."));
            indexDocsForSkiplist(directory, config, filterField, null);  
    }
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                }
            equalTo(
            aggregation -> aggregation.fixedInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(0L),
                assertEquals(3, bucket.getDocCount());
import org.opensearch.index.mapper.MappedFieldType;
            LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2015-01-01"), asLong("2017-12-31")),  
                "2017-02-01T16:48:00.000Z",
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2018-01-01"), asLong("2020-01-01")),
                );
            () -> testSearchCase(
            DATASET,
                assertEquals("Max category value for 2015 bucket should be 1", 1.0, maxAgg2015.getValue(), 0.0);
        testSearchCase(  
                "2017-02-01T16:06:00.000Z",  
        "2015-02-13T13:09:32",
            },
        "2015-11-13T16:14:34",
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());  
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).interval(1000).field(AGGREGABLE_DATE),
                    document.add(new SortedNumericDocValuesField(AGGREGABLE_DATE, instant));  
                );  
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)  
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());  
            new MatchAllDocsQuery(),  
                bucket = buckets.get(1);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
        dataset.put("2017-02-01T09:59:59.999Z", 256);
            true  
                bucket = buckets.get(4);
                new MatchAllDocsQuery(),  
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");  
        assertThat(e.getMessage(), equalTo("Cannot use [calendar_interval] with [interval] configuration option."));
        );
                aggregation -> aggregation.dateHistogramInterval(new DateHistogramInterval("foobar")).field(AGGREGABLE_DATE),
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
                assertEquals(1, bucket.getDocCount());  
    }
                assertEquals("2017-02-01T09:02:00.000Z", bucket.getKeyAsString());
            IllegalArgumentException.class,
        }  
        List<String> dataset,  
            histogram -> {  
            histogram -> {
                assertEquals(2, bucket.getDocCount());
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)  
                assertEquals(1, bucket.getDocCount());  
            histogram -> assertEquals(8, histogram.getBuckets().size()),  
                bucket = buckets.get(4);
 */  
            StringTerms.Bucket b = terms.getBucketByKey("b");
                expected = dataset.get("2017-02-01T13:06:00.000Z");  
                Document doc = new Document();
            aggregation -> aggregation.fixedInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(3L),  
        testFilterRewriteCase(
            }
            },  
            false
            false,  
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals(3, histogram.getBuckets().get(0).getDocCount());
                            }  
                    .calendarInterval(DateHistogramInterval.YEAR)
                InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                    .timeZone(ZoneId.of("America/New_York")),
            collectorCount -> assertEquals(0, (int) collectorCount),
                bucket = buckets.get(2);
        );  
        testSearchCase(
            },  
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(0L),  
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
        boolean useNanosecondResolution,
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.DAY)
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),  
            ),
                new MatchAllDocsQuery(),  
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
            false  
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
        testSearchCase(  
            query,  
                assertEquals("2017-02-01T00:00:15.000Z", bucket.getKeyAsString());
    }
        );
                assertEquals(3, bucket.getDocCount());
            NumberFieldMapper.NumberFieldType nft = new NumberFieldMapper.NumberFieldType("n", NumberFieldMapper.NumberType.LONG);
                "2017-02-01T00:00:37.688314602Z",  
                    .field(AGGREGABLE_DATE),  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field("wrong_field"),
                assertEquals(expected, bucket.getDocCount());
                "2017-02-01T00:00:37.688Z",  
            histogram -> {
                aggregation -> aggregation.interval(1000).fixedInterval(new DateHistogramInterval("2d")).field(AGGREGABLE_DATE),
                "2017-02-01T00:00:05.015298384Z",  
                "2017-02-01T00:00:05.015Z",  
    }
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());  
        );
        builder = new TermsAggregationBuilder("k2").field("k2").subAggregation(builder);  
            },  
            config.setIndexSort(new Sort(sortField));
                assertEquals(expected, bucket.getDocCount());
        IllegalArgumentException e = expectThrows(  
                histogram -> {},  
                assertEquals("Max category value for 2016 bucket should be 0", 0.0, maxAgg2016.getValue(), 0.0);  
                bucket = buckets.get(1);
                "2017-02-01T00:00:37.380Z"
                "2017-02-01T16:59:00.000Z"
            () -> testSearchCase(  
    public void testMinDocCount() throws IOException {  
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
                assertEquals(1, bucket.getDocCount());
    }  
            assertEquals(0, histogram.getBuckets().size());  
                    indexWriter.addDocuments(documents);
            IllegalArgumentException.class,
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");  
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals(2, bucket.getDocCount());
                aggregator.preCollection();
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                doAssertReducedMultiBucketConsumer(histogram, reduceBucketConsumer);  
                assertEquals("2017-02-01T09:16:00.000Z", bucket.getKeyAsString());
    private static long asLong(String dateTime) {  
                "2017-02-01T16:59:00.000Z"
                int expected = dataset.get("2017-02-01T09:02:00.000Z") + dataset.get("2017-02-01T09:59:59.999Z");
                indexWriter.addDocument(doc);
            Arrays.asList(
                bucket = buckets.get(2);  
            false
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            },
                assertEquals(4, buckets.size());
    }
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
            },  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),  
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE).minDocCount(1L),  
                AggregatorFactories factories = AggregatorFactories.builder()  
        IndexSearcher searcher,  
            new MatchAllDocsQuery(),
                false
                "2017-02-01T09:35:00.000Z",  
            false  
            },  
    }
                histogram -> {},
                assertEquals(3, buckets.size());
                bucket = buckets.get(1);  
                            .getQueryShardContext(),
                assertEquals(6, histogram.getBuckets().size());
            ),
            for (int i = 8; i < 10; i++) {  
                            document.clear();  
import org.apache.lucene.search.MatchAllDocsQuery;
            false
                bucket = buckets.get(5);
                assertEquals(5, buckets.size());
                assertEquals("2017-02-01T09:16:00.000Z", bucket.getKeyAsString());
        );
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
        assertThat(e.getMessage(), equalTo("Cannot use [fixed_interval] with [interval] configuration option."));
            new MatchAllDocsQuery(),
    }
                assertEquals("2017-01-01T00:00:00.000Z", histogram.getBuckets().get(2).getKeyAsString());  
                .field(AGGREGABLE_DATE),
                assertEquals(3, buckets.size());
            config.setMergePolicy(NoMergePolicy.INSTANCE);  
        e = expectThrows(  
            },  
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
            false  
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        dataset.put("2017-02-01T16:59:00.000Z", randomIntBetween(100, 2000));
        dataset.put("2017-02-01T16:48:00.000Z", randomIntBetween(100, 2000));
        IllegalArgumentException ex = expectThrows(
                Histogram.Bucket bucket = buckets.get(0);  
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());
        // 5 sec interval with minDocCount = 0
import static java.util.stream.Collectors.toList;
            supportsIntraSegmentSearch(
                Histogram.Bucket bucket = buckets.get(0);
            );  
            false
            ),  
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());
        return new CountingAggregator(  
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            query,
            },
        NumberFieldMapper.NumberFieldType categoryType = new NumberFieldMapper.NumberFieldType(
                "2017-02-01T00:00:37.380Z"
                "2017-02-01T10:15:00.000Z",
                "2017-02-01T10:15:00.000Z",
            histogram -> {
    public void testNanosIntervalSecond() throws IOException {  
    }
    public void testIntervalMonthDeprecated() throws IOException {
    }
            ),  
        dataset.put("2017-02-01T14:04:00.000Z", randomIntBetween(100, 2000));  
 * The OpenSearch Contributors require contributions made to  
            histogram -> {
                bucket = buckets.get(1);
            new MatchAllDocsQuery(),  
            config.setMergePolicy(NoMergePolicy.INSTANCE);  
            LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2015-01-01"), asLong("2017-12-31")),
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.seconds(5)).field(AGGREGABLE_DATE).minDocCount(3L),
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
        dataset.put("2017-02-01T16:06:00.000Z", randomIntBetween(100, 2000));  
                "2017-02-01T13:06:00.000Z",
                assertEquals(6, buckets.size());
            );  
                assertEquals(1, bucket.getDocCount());  
        );
                    .timeZone(ZoneId.of("America/New_York"))  
                assertEquals(3, bucket.getDocCount());
        );
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                if (configure != null) {
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        List<String> timestamps = Arrays.asList(  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                            long instant = asLong(date.getKey(), fieldType);
    public void testMatchAllDocs() throws IOException {  
            query,
                expected = dataset.get("2017-02-01T10:00:00.001Z");
                bucket = buckets.get(2);
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE),
    }
        dataset.put("2017-02-01T14:04:00.000Z", randomIntBetween(100, 2000));  
            new MatchAllDocsQuery(),
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());
                "2017-02-01T00:00:11.299954583Z",
                bucket = buckets.get(1);
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());  
                true  
                doc.add(new LongPoint(filterField, 1));  
                if (useDocCountField) {  
                bucket = buckets.get(2);  
                "2017-02-01T00:00:11.299Z",  
                // Verify second bucket (2016)  
            )
                Histogram.Bucket bucket = buckets.get(0);
                InternalDateHistogram topLevel = (InternalDateHistogram) aggregator.buildTopLevel();
                assertEquals(2, bucket.getDocCount());
            assertEquals(0, histogram.getBuckets().size());
    }
            true,
                assertEquals(1, bucket.getDocCount());
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
                "2017-02-01T15:59:00.000Z",
                        }
    }
                Histogram.Bucket bucket = buckets.get(0);
            query,
        dataset.put("2017-02-01T16:59:00.000Z", randomIntBetween(100, 2000));
                InternalDateHistogram.Bucket bucket2017 = (InternalDateHistogram.Bucket) histogram.getBuckets().get(2);  
                    .subAggregation(new AvgAggregationBuilder("avg").field("n")),
                                useDocCountField = false;
            false
            10000,
 * Licensed to Elasticsearch under one or more contributor  
                    .fixedInterval(new DateHistogramInterval("2d"))
            dataset,  
        );  
        );
            )
        Query query = new MatchNoDocsQuery();
 * the Apache License, Version 2.0 (the "License"); you may
            false,  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
                assertEquals(1, bucket.getDocCount());  
        testSearchCase(
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),  
                return factories.allFactoriesSupportIntraSegmentSearch();
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)  
            supportsIntraSegmentSearch(  
    }
        );
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
    private void testSearchCase(
                }  
                "2017-02-01T09:16:42.000Z"  
                assertEquals(1, bucket.getDocCount());
        testSearchCase(
        List<String> timestamps = Arrays.asList(
                assertEquals(expected, bucket.getDocCount());
                assertEquals(2, bucket.getDocCount());
            e.getMessage(),
                expected = dataset.get("2017-02-01T16:06:00.000Z") + dataset.get("2017-02-01T16:48:00.000Z") + dataset.get(  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            for (int i = 5; i < 8; i++) {  
    public void testIntervalMinute() throws IOException {  
        );  
                bucket = buckets.get(3);  
                long timestamp = DateFormatters.from(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER.parse(DATASET.get(i)))
            histogram -> {  
                    getMockScriptService(),  
            // Third commit - 2 more dates with type 2
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE).minDocCount(1L),
                    indexSettings,
            },  
    public void testMultiRangeTraversalNotApplicable() throws IOException {  
                assertEquals(1, bucket.getDocCount());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
                org.opensearch.search.aggregations.metrics.InternalMax maxAgg2015 = bucket2015.getAggregations().get(categoryField);
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
        );  
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("_name");
                    .toEpochMilli();
                    .addAggregator(builder)
                    indexWriter.addDocument(document);
                .order(BucketOrder.count(false)),  
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        testSearchCase(
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
        );
            IllegalArgumentException.class,
                "2017-02-01T14:05:00.000Z",
                Histogram.Bucket bucket = buckets.get(0);  
            query,  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(expected, bucket.getDocCount());
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());  
                assertEquals(1, bucket.getDocCount());
            histogram -> {
            true
                            document.add(new SortedNumericDocValuesField(AGGREGABLE_DATE, instant));
                new MatchAllDocsQuery(),
    private static Settings getSettingsWithIndexSort() {
            IllegalArgumentException.class,
            Arrays.asList("2017-01-01", "2017-02-02", "2017-02-03", "2017-03-04", "2017-03-05", "2017-03-06"),
            ),  
                assertEquals(2, bucket.getDocCount());  
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR),
                bucket = buckets.get(1);  
                bucket = buckets.get(2);
                bucket = buckets.get(1);  
                equalTo(List.of("2020-01-01T00:00Z"))  
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
                Histogram.Bucket bucket = buckets.get(0);
                    // add the doc count field to the first document
    }
                bucket = buckets.get(1);
import org.apache.lucene.search.SortField;  
     * The intra-segment gate for date_histogram (no sub-agg): partition only when the filter-rewrite O(1) fast
                indexWriter.addDocument(doc);
    }  
            query,
     */
            new MatchAllDocsQuery(),  
            config.setIndexSort(new Sort(sortField));
                true  
            supportsIntraSegmentSearch(
            ),
        testSearchCase(  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                assertEquals(1, bucket.getDocCount());
                bucket = buckets.get(2);
        testFilterRewriteCase(
    }
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
        );  
            () -> testSearchCase(
                "2017-02-01T00:00:37.688314602Z",
        Consumer<InternalDateHistogram> verify,  
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
            );
        DateFieldMapper.DateFieldType fieldType = aggregableDateFieldType(useNanosecondResolution, aggregableDateIsSearchable);  
                bucket = buckets.get(1);
                assertEquals(2, bucket.getDocCount());
                assertEquals(expected, bucket.getDocCount());
import java.util.ArrayList;
            new MatchAllDocsQuery(),
    public void testMatchNoDocs() throws IOException {
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),  
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());
            false
        );
        testSearchCase(query, dates, aggregation, histogram -> {
                bk1adh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
            IllegalArgumentException.class,  
            histogram -> {
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());  
        dataset.put("2017-02-01T09:02:00.000Z", randomIntBetween(100, 2000));
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
        testSearchCase(
        testSearchCase(  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
        IndexNumericFieldData fieldData = (IndexNumericFieldData) fieldType.fielddataBuilder("index", () -> {  
                .hardBounds(new LongBounds("2016-01-01", "2017-01-01"))  
            },  
            }
            )  
                            indexWriter.addDocument(document);
                // Verify first bucket (2015) with sub-aggregations
            Arrays.asList(
        testSearchCase(  
                assertEquals("2016-01-01T00:00:00.000Z", histogram.getBuckets().get(1).getKeyAsString());  
                assertEquals("2016-01-01T00:00:00.000Z", bucket.getKeyAsString());
import org.apache.lucene.index.DirectoryReader;
            supportsIntraSegmentSearch(
                aggregation -> aggregation.interval(1000).calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE),
            histogram -> {
                CountingAggregator aggregator = createCountingAggregator(query, aggregationBuilder, indexSearcher, fieldType);
            histogram -> {  
            Arrays.asList(
                expected = dataset.get("2017-02-01T14:04:00.000Z") + dataset.get("2017-02-01T14:05:00.000Z");
        );  
            },
            equalTo(
                "2017-02-01T00:00:05.015Z",
                false
        Query query,
import org.opensearch.search.aggregations.BucketOrder;
    private static void indexDocsForSkiplist(Directory directory, IndexWriterConfig config, String filterField, String categoryField)
                "2017-02-01T15:59:00.000Z",
                assertEquals("2017-02-01T09:02:00.000Z", bucket.getKeyAsString());
                assertEquals(1, bucket.getDocCount());
        dataset.put("2017-02-01T16:06:00.000Z", randomIntBetween(100, 2000));  
                "2017-02-01T00:00:37.380889483Z"  
                .field(AGGREGABLE_DATE),
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                histogram -> {},
                        for (int i = 0; i < date.getValue(); i++) {
        );
        boolean useNanosecondResolution  
            timestamps,
        MappedFieldType... fieldTypes
            )  
            histogram -> {  
        Map<String, Integer> dataset,
            false,  
                assertEquals(expected, bucket.getDocCount());  
            false
        );
        }).build(null, null);
                adh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
            throw new UnsupportedOperationException();
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                histogram -> {},  
            false
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);  
                verifyCollectCount.accept(aggregator.getCollectCount().get());
import org.opensearch.index.mapper.DocCountFieldMapper;
                assertEquals("Max category value for 2017 bucket should be 1", 1.0, maxAgg2017.getValue(), 0.0);
                }
            () -> testSearchCase(  
        testSearchCase(
    public void testIntervalYearDeprecated() throws IOException {
import java.util.Arrays;
    ) throws IOException {  
            },
                histogram -> {},
                "2017-02-01T00:00:11.299954583Z",
    ) throws IOException {  
            DATASET,  
    public void testSupportsIntraSegmentSearch() throws IOException {  
            true
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
        testSearchCase(
    }
                    1000,  
            false
                        document.add(new LongPoint(AGGREGABLE_DATE, instant));
    public void testIntervalYear() throws IOException {
            false  
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
        for (int i = 0; i < 1000; i++) {
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.MONTH).field(AGGREGABLE_DATE),  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                "Extended bounds have to be inside hard bounds, "  
                    .toInstant()  
                "2017-02-01T09:35:00.000Z",
                "2017-02-01T00:00:11.074Z",
        assertThat(  
        Consumer<DateHistogramAggregationBuilder> configure,
            new MatchAllDocsQuery(),  
    }
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE)
        }
                equalTo(List.of("2020-01-01T00:00Z"))
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.HOUR).field(AGGREGABLE_DATE).minDocCount(1L),  
            false
            .field(AGGREGABLE_DATE);
                assertEquals(3, bucket.getDocCount());
                expected = dataset.get("2017-02-01T14:04:00.000Z");  
                assertEquals(1, bucket2016.getDocCount());  
            histogram -> {
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                bucket = buckets.get(1);
            )  
                bucket = buckets.get(1);  
            indexWriter.commit();  
                try (IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()))) {  
        IllegalArgumentException e = expectThrows(
            )  
                            document.add(new LongPoint(AGGREGABLE_DATE, instant));  
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        testSearchCase(query, dataset, configure, verify, 10000, useNanosecondResolution);
        }  
        asSubAggTestCase(builder, (StringTerms terms) -> {
                    PipelineAggregator.PipelineTree.EMPTY
        testSearchCase(  
                        new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR)  
        testFilterRewriteCase(
            IllegalArgumentException.class,
                histogram -> {},  
                new MatchAllDocsQuery(),  
    }
        // 5 sec interval with minDocCount = 0
import org.opensearch.Version;
                assertEquals(1, bucket.getDocCount());
    public void testIntervalSecondDeprecated() throws IOException {
                verify.accept(histogram);
                bucket = buckets.get(1);  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
            ex.getMessage(),
            DATASET,
                bucket = buckets.get(1);
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
            histogram -> {  
                assertNotNull("Max sub-agg should exist", maxAgg2017);
                bucket = buckets.get(1);
        testSearchCase(
            },  
        );
                Histogram.Bucket bucket = buckets.get(0);
            new MatchAllDocsQuery(),
                    doc.add(new NumericDocValuesField(categoryField, i % 2));
 * this work for additional information regarding copyright
                false
                    .toEpochMilli();
                assertEquals(8, histogram.getBuckets().size());  
        );  
                assertEquals(1, bucket.getDocCount());
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());  
                }  
        assertTrue(
                assertEquals("2017-02-01T09:15:00.000Z", bucket.getKeyAsString());
            histogram -> assertEquals(8, histogram.getBuckets().size()),  
                }  
                bucket = buckets.get(2);  
                IndexSearcher searcher = newIndexSearcher(reader);
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                            document.add(new LongPoint(AGGREGABLE_DATE, instant));
                bucket = buckets.get(1);
        testSearchCase(  
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
            )
                "2017-02-01T14:05:00.000Z",
            ),  
 *    http://www.apache.org/licenses/LICENSE-2.0
            DATASET,
                histogram -> {},
import org.apache.lucene.document.NumericDocValuesField;  
                bucket = buckets.get(3);  
        Consumer<InternalDateHistogram> verify,
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("_name");
            histogram -> {
            histogram -> {
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());
                assertEquals(2, bucket.getDocCount());
            }  
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
                    }  
            InternalDateHistogram bk1adh = bk1a.getAggregations().get("dh");
                expected = dataset.get("2017-02-01T15:59:00.000Z");
                bdh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
        Consumer<DateHistogramAggregationBuilder> aggregation = agg -> agg.dateHistogramInterval(DateHistogramInterval.YEAR)
                false
                assertEquals(2, bucket.getDocCount());
        "2010-03-12T01:07:45",  
                bucket = buckets.get(1);
            () -> testSearchCase(  
            () -> testSearchCase(
        Consumer<InternalDateHistogram> verify,  
            )
                indexWriter.addDocument(doc);
 * Unless required by applicable law or agreed to in writing,
            StringTerms.Bucket a = terms.getBucketByKey("a");
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.MONTH).field(AGGREGABLE_DATE),
            },  
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            },
                assertEquals(1, bucket.getDocCount());  
        dataset.put("2017-02-01T15:59:00.000Z", randomIntBetween(100, 2000));
        testSearchCase(  
        );
        testSearchCase(query, dataset, configure, verify, maxBucket, useNanosecondResolution, false);
        }
        });
/*
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                "2017-02-01T09:16:42.000Z"  
                aggregation -> aggregation.fixedInterval(new DateHistogramInterval("2d"))
import org.opensearch.cluster.metadata.IndexMetadata;
                    indexSearcher,
    }
            },
    public void testCalendarAndThenFixed() throws IOException {
                assertEquals(3, buckets.size());
                bucket = buckets.get(1);
        boolean useNanosecondResolution
            },
                assertEquals("2017-01-01T00:00:00.000Z", bucket.getKeyAsString());  
                histogram -> {},  
            histogram -> {
                assertEquals("2015-01-01T00:00:00.000Z", bucket.getKeyAsString());
                assertEquals(0, bucket.getDocCount());  
            IndexWriterConfig config = newIndexWriterConfig();
        Settings settings = getSettingsWithIndexSort();  
            )
                assertEquals(2, buckets.size());
                    DEFAULT_MAX_BUCKETS,
                "2017-02-01T00:00:37.210328172Z",
            IllegalArgumentException.class,
                "2017-02-01T09:02:35.000Z",
            dataset,
                Histogram.Bucket bucket = buckets.get(0);  
 * KIND, either express or implied.  See the License for the
                histogram -> {},
                assertEquals(1, bucket.getDocCount());  
        );  
                assertNotNull("Max sub-agg should exist", maxAgg2015);  
                if (categoryField != null) {
            false,  
                // use default codec so max points in leaf is fixed to 512, to cover the node level visit and compare logic
                bucket = buckets.get(3);
                assertEquals(4, buckets.size());
            new MatchAllDocsQuery(),
import java.util.Collections;  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
                true
                    .subAggregation(new MaxAggregationBuilder(categoryField).field(categoryField));
        );
                }
                assertEquals(1, histogram.getBuckets().get(2).getDocCount());
            // First commit - 5 dates with type 1
        );
            ),
                histogram -> {},  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(expected, bucket.getDocCount());  
                    aggregationBuilder,
        // sub-agg but fast path applies (UTC): NOT intra-eligible (BKD walk would duplicate per partition)  
                assertEquals("2017-02-01T00:00:11.000Z", bucket.getKeyAsString());  
        "2013-10-31T08:24:05",
                assertEquals("2017-03-01T00:00:00.000Z", bucket.getKeyAsString());
        try (IndexWriter indexWriter = new IndexWriter(directory, config)) {  
                assertEquals(6, buckets.size());
        testSearchCase(
            );  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("1000ms")).field(AGGREGABLE_DATE).minDocCount(1L),
            false
            }
            new MatchAllDocsQuery(),
                aggregation -> aggregation.fixedInterval(new DateHistogramInterval("2d")).interval(1000).field(AGGREGABLE_DATE),
        // Create index settings with an index sort.
                    .fixedInterval(new DateHistogramInterval("2d"))  
                assertEquals("2017-02-01T09:15:00.000Z", bucket.getKeyAsString());  
            false,
            StringTerms ak1 = a.getAggregations().get("k1");  
    public void testNoDocsDeprecatedInterval() throws IOException {
                "2017-02-01T09:15:37.000Z",
                    .toInstant()  
                        // add the doc count field to the first document  
                    false,
            new MatchAllDocsQuery(),  
        IndexNumericFieldData fieldData = (IndexNumericFieldData) dateType.fielddataBuilder("index", () -> {  
                "2017-02-01T09:02:00.000Z",
        DateFieldMapper.DateFieldType fieldType = aggregableDateFieldType(false, true);
        MappedFieldType dateType = new DateFieldMapper.DateFieldType(AGGREGABLE_DATE);
            ),  
                );  
            false  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE).minDocCount(1L),  
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.SECOND).field(AGGREGABLE_DATE).minDocCount(1L),
        assertThat(e.getMessage(), equalTo("Cannot use [fixed_interval] with [calendar_interval] configuration option."));  
                bucket = buckets.get(2);
                false  
            histogram -> {  
                assertEquals(3, bucket.getDocCount());  
            DATASET,
        Consumer<DateHistogramAggregationBuilder> configure,
                long timestamp = DateFormatters.from(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER.parse(DATASET.get(i)))
                "2017-02-01T09:02:59.000Z",
            )  
        testSearchCase(
            false,
        Query query = LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2017-02-01T00:00:00.000Z"), asLong("2017-02-01T00:00:30.000Z"));
        );
        );  
    public void testMultiRangeTraversalFixedData() throws IOException {
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
                int expected = dataset.get("2017-02-01T09:02:00.000Z") + dataset.get("2017-02-01T09:59:59.999Z") + 4;
            Arrays.asList(  
                false
                    .toEpochMilli();
                false
                assertEquals(3, bucket.getDocCount());
        Query query,
        return Settings.builder()
        );  
            false
                bucket = buckets.get(2);
    public void testIntervalMonth() throws IOException {
        testSearchCase(query, dates, aggregation, histogram -> {
                assertEquals(4, buckets.size());
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                    + "unit is missing or unrecognized"
                true
import java.io.IOException;
        );
                // Verify third bucket (2017)
                "2017-02-01T09:02:35.000Z",
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),  
            true
                fieldTypes
        );
        Query query = new MatchAllDocsQuery();
                "2017-02-01T00:00:37.380Z"
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
                "2017-02-01T00:00:11.299Z",
            NumberFieldMapper.NumberType.LONG  
            false  
                bucket = buckets.get(1);
                "2017-02-01T09:16:04.000Z",
            },
                assertEquals(2, bucket.getDocCount());  
                assertEquals(3, bucket.getDocCount());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            query,
    public void testIntervalSecond() throws IOException {
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
            Arrays.asList(
                assertEquals(1, bucket.getDocCount());
            false
            timestamps,
        List<String> foo = new ArrayList<>();  
            Arrays.asList(
            }
            },
            String filterField = "type";
    public void testIntervalMinuteDeprecated() throws IOException {
            () -> testSearchCase(
                assertEquals(3, bucket.getDocCount());
                Histogram.Bucket bucket = buckets.get(0);
                assertEquals(expected, bucket.getDocCount());  
                Histogram.Bucket bucket = buckets.get(0);  
        );
                assertEquals("2017-02-01T09:02:00.000Z", bucket.getKeyAsString());
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2017-02-03"), asLong("2020-01-01")),  
    public void testAsSubAgg() throws IOException {  
                assertEquals(expected, bucket.getDocCount());
                assertEquals(6, buckets.size());
                assertEquals("2017-02-04T00:00:00.000Z", bucket.getKeyAsString());  
                new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR),
                assertEquals(2, bucket.getDocCount());  
            10000,
                assertEquals("2017-02-01T09:00:00.000Z", bucket.getKeyAsString());  
                new HistogramAggregationBuilder("outer").field("n")  
            new MatchAllDocsQuery(),  
        );  
        testSearchCase(query, dates, aggregation, histogram -> assertEquals(0, histogram.getBuckets().size()), false);
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * path can NOT apply upfront. Fast path applies for a searchable, UTC, top-level date_histogram → do not
            () -> testSearchCase(  
                "2017-02-01T09:35:00.000Z",  
                Histogram.Bucket bucket = buckets.get(0);
        dataset.put("2017-02-01T13:06:00.000Z", 512);  
                DateHistogramAggregationBuilder aggregationBuilder = new DateHistogramAggregationBuilder("test").field(AGGREGABLE_DATE)  
                assertEquals(1, bucket.getDocCount());
            )
        dataset.put("2017-02-01T16:48:00.000Z", randomIntBetween(100, 2000));
                assertEquals("2017-02-01T16:00:00.000Z", bucket.getKeyAsString());  
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());  
}
                assertEquals(3, buckets.size());
            histogram -> assertEquals(0, histogram.getBuckets().size()),
                new MatchAllDocsQuery(),
                if (categoryField != null) {
                expected = dataset.get("2017-02-01T13:06:00.000Z");
import org.opensearch.index.IndexSettings;
                    .build(
                assertEquals(1, bucket.getDocCount());  
    }  
                Query query = LongPoint.newExactQuery(filterField, 2);
        );
            histogram -> {
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE),
        "2017-12-12T22:55:46"  
import org.apache.lucene.index.IndexWriter;
            new MatchAllDocsQuery(),
        dataset.put("2017-02-01T09:59:59.999Z", randomIntBetween(100, 2000));  
        IllegalArgumentException e = expectThrows(
                assertEquals(3, bucket.getDocCount());  
    public void testIntervalDay() throws IOException {
                bucket = buckets.get(4);
                indexSearcher.search(query, aggregator);  
    private boolean supportsIntraSegmentSearch(org.opensearch.search.aggregations.AggregationBuilder builder, boolean searchable)
            indexWriter.commit();  
            histogram -> {
                assertEquals(0, buckets.size());  
                    .toInstant()  
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            false,  
                assertEquals("2015-01-01T00:00:00.000Z", histogram.getBuckets().get(0).getKeyAsString());  
                assertEquals(2, bucket.getDocCount());
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            for (int i = 0; i < 5; i++) {  
            () -> testSearchCase(
            Arrays.asList("2017-01-01", "2017-02-02", "2017-02-03", "2017-03-04", "2017-03-05", "2017-03-06"),
        }, false);
            false
        aggregation = agg -> agg.fixedInterval(new DateHistogramInterval("365d")).field(AGGREGABLE_DATE);
/*  
                .field(AGGREGABLE_DATE),  
                .hardBounds(new LongBounds("2018-01-01", "2020-01-01"))
            histogram -> {  
                assertEquals(0, bucket.getDocCount());
                assertEquals("2017-02-03T00:00:00.000Z", bucket.getKeyAsString());
        );
                bucket = buckets.get(2);  
                assertEquals(2, bucket.getDocCount());
                    .field(AGGREGABLE_DATE),  
                    .extendedBounds(new LongBounds("2009-01-01", "2021-01-01"))
                new MatchAllDocsQuery(),
            Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
     */
                .field(AGGREGABLE_DATE)
        // 5 sec interval with minDocCount = 3  
                    query,
 *  
                assertEquals(1, bucket.getDocCount());
                assertEquals("2017-02-01T09:16:00.000Z", bucket.getKeyAsString());  
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
                bucket = buckets.get(2);
                false
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());  
            "2017-02-01T00:00:11.299Z",
                        null
            } else {
                assertEquals(0, buckets.size());
                "2017-02-01T00:00:37.210Z",  
                equalTo(List.of("2020-01-01T00:00Z", "2021-01-01T00:00Z"))
        e = expectThrows(
            )
            try (IndexReader reader = indexWriter.getReader()) {
                assertEquals(1, bucket.getDocCount());
                expected = dataset.get("2017-02-01T13:06:00.000Z");  
            false
        IllegalArgumentException e = expectThrows(
                InternalDateHistogram histogram = searchAndReduce(
            histogram -> {
            },
                bucket = buckets.get(1);
                Histogram.Bucket bucket = buckets.get(0);  
        testSearchCase(  
                // Assert sub-aggregation values for 2017 bucket (doc 9 with category 1)
            Arrays.asList(  
        dataset.put("2017-02-01T10:00:00.001Z", randomIntBetween(100, 2000));
                    Integer.MAX_VALUE,
            },
                assertEquals(2, bucket.getDocCount());
        Query query,
                assertEquals(2, bucket.getDocCount());
        testSearchCase(
                    if (aggregableDateIsSearchable) {
                "2017-02-01T00:00:11.074986434Z",  
                .field(AGGREGABLE_DATE),
                    query,  
        testSearchCase(query, dataset, configure, verify, maxBucket, useNanosecondResolution, useDocCountField, randomBoolean());
            aggregation -> aggregation.dateHistogramInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE),
                    doc.add(new NumericDocValuesField(categoryField, i % 2));
    }  
                assertEquals(2, buckets.size());  
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
            if (randomWrite) {
                    aggregationBuilder,
                bucket = buckets.get(2);  
                assertEquals("2017-02-01T00:00:20.000Z", bucket.getKeyAsString());  
    }
            categoryField,
        );  
    public void testSkiplistWithSingleValueDatesAndSubAggs() throws IOException {
        assertThat(e.getMessage(), equalTo("Unable to parse interval [foobar]"));  
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, dft, nft)  
        dataset.put("2017-02-01T09:02:00.000Z", 512);  
            histogram -> {
            DATASET,
import static org.hamcrest.Matchers.equalTo;  
                }  
        IllegalArgumentException e = expectThrows(
 * license agreements. See the NOTICE file distributed with
                    if (useDocCountField) {
                assertEquals(expected, bucket.getDocCount());
            false
                Histogram.Bucket bucket = buckets.get(0);  
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2016-01-01"), asLong("2017-01-01")),  
                Histogram.Bucket bucket = buckets.get(0);
        try (Directory directory = newDirectory()) {
                assertEquals(4, buckets.size());  
                assertEquals(0, bucket.getDocCount());
        dataset.put("2017-02-01T14:05:00.000Z", randomIntBetween(100, 2000));
 * under the License.  
                            long instant = asLong(date.getKey(), fieldType);
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                "2017-02-01T16:59:00.000Z"
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY).field(AGGREGABLE_DATE).minDocCount(1L),  
            );  
                "2017-02-01T16:48:00.000Z",
                }  
            )  
            },
        assertThat(e.getMessage(), equalTo("Cannot use [calendar_interval] with [interval] configuration option."));
            histogram -> {
            false
            true  
                assertEquals(3, buckets.size());  
            indexDocsForSkiplist(directory, config, filterField, categoryField);  
            }
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                new MatchAllDocsQuery(),
        assertThat(e.getMessage(), equalTo("Cannot use [interval] with [fixed_interval] or [calendar_interval] configuration options."));
                    .calendarInterval(DateHistogramInterval.YEAR);  
                assertEquals(1, buckets.size());  
        "2010-04-27T03:43:34",
                assertEquals("2017-02-01T14:00:00.000Z", bucket.getKeyAsString());
        throws IOException {
                assertEquals(1, bucket.getDocCount());
                assertEquals(6, buckets.size());  
    public void testFilterRewriteOptimizationWithRangeQuery() throws IOException {
                if (categoryField != null) {
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());  
        testSearchCase(
            },
                assertEquals(0, buckets.size());
            },
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                    doc.add(new NumericDocValuesField(categoryField, i % 2));
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60s")).field(AGGREGABLE_DATE).minDocCount(1L),
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();  
import org.apache.lucene.search.Sort;
import org.opensearch.core.common.breaker.CircuitBreaker;
            InternalDateHistogram ak1adh = ak1a.getAggregations().get("dh");
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
                assertEquals(0, buckets.size());  
import org.apache.lucene.document.Document;
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                "2017-02-01T13:06:00.000Z",
                .hardBounds(new LongBounds("2016-01-01", "2017-02-03"))
                false  
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                    .field(AGGREGABLE_DATE),
        List<String> dataset,  
            aggregation -> aggregation.fixedInterval(new DateHistogramInterval("60m")).field(AGGREGABLE_DATE).minDocCount(1L),
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)
    /**  
                assertNotNull("Max sub-agg should exist", maxAgg2016);
                searcher,
            collectCount -> assertTrue(collectCount > 0),  
            histogram -> assertEquals(8, histogram.getBuckets().size()),
            assertFalse(AggregationInspectionHelper.hasValue(histogram));  
                assertEquals(2, bucket.getDocCount());
            StringTerms.Bucket ak1a = ak1.getBucketByKey("a");
            false  
                assertEquals("2017-02-02T00:00:00.000Z", bucket.getKeyAsString());  
                assertEquals(5, bucket.getDocCount());
                    .field(AGGREGABLE_DATE),
        testSearchCase(
        );
                try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
                bucket = buckets.get(2);  
                aggregation -> aggregation.fixedInterval(DateHistogramInterval.WEEK).field(AGGREGABLE_DATE),
    ) throws IOException {
            false,
                bucket = buckets.get(2);
            assertThat(  
                assertEquals(4, buckets.size());  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
                    document.add(new LongPoint(SEARCHABLE_DATE, instant));
                assertEquals("2015-01-01T00:00:00.000Z", bucket.getKeyAsString());  
    }  
                        document.add(new NumericDocValuesField(DocCountFieldMapper.NAME, 5));
            assertFalse(AggregationInspectionHelper.hasValue(histogram));
                Arrays.asList("2017-02-01", "2017-02-02", "2017-02-02", "2017-02-03", "2017-02-03", "2017-02-03", "2017-02-05"),
import org.apache.lucene.store.Directory;
        AggregationBuilder builder,
    ) throws IOException {
    }  
                assertEquals("2017-03-01T00:00:00.000Z", bucket.getKeyAsString());
                long timestamp = DateFormatters.from(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER.parse(DATASET.get(i)))
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
                assertEquals(3, buckets.size());
        try (Directory directory = newDirectory()) {
                assertNotNull("Sub-aggregation should exist for 2015 bucket", bucket2015.getAggregations());
        // non-searchable field, no sub-agg: fast path declines (canOptimize requires a searchable index) -> intra-eligible
    }  
                assertEquals(4, buckets.size());  
        );
        try (Directory directory = newDirectory()) {
import org.apache.lucene.document.LongPoint;
                                // add the doc count field once  
    }  
     * A date that is always "searchable" because it is indexed.
                        }
                assertEquals("2017-02-01T00:00:37.000Z", bucket.getKeyAsString());  
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");  
        IllegalArgumentException e = expectThrows(
                assertTrue(AggregationInspectionHelper.hasValue(histogram));
            )  
        testSearchCase(  
                assertEquals("2017-02-04T00:00:00.000Z", bucket.getKeyAsString());  
                assertEquals(1, bucket.getDocCount());
                "2017-02-01T09:02:35.000Z",
                assertEquals("2017-02-05T00:00:00.000Z", bucket.getKeyAsString());  
                "2017-02-01T14:04:00.000Z",
                bucket = buckets.get(1);
                Document document = new Document();
                bucket = buckets.get(4);
            false  
            DATASET,
                assertEquals("2017-01-01T00:00:00.000Z", bucket2017.getKeyAsString());
        dataset.put("2017-02-01T09:59:59.999Z", randomIntBetween(100, 2000));  
        dataset.put("2017-02-01T14:05:00.000Z", randomIntBetween(100, 2000));
        assertThat(e.getMessage(), equalTo("Cannot use [fixed_interval] with [interval] configuration option."));
        );  
            new MatchAllDocsQuery(),
                "2017-02-01T00:00:37.688Z",  
                assertEquals(3, bucket.getDocCount());
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
                bucket = buckets.get(1);  
                Histogram.Bucket bucket = buckets.get(0);  
            false
            dataset,  
            )
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
                assertEquals(1, bucket2017.getDocCount());
    }
            "2017-02-01T00:00:13.688Z",  
            .subAggregation(new DateHistogramAggregationBuilder("dh").field(AGGREGABLE_DATE).calendarInterval(DateHistogramInterval.YEAR));
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
                "2017-02-01T09:02:00.000Z",
    }
        );
        dataset.put("2017-02-01T10:00:00.001Z", randomIntBetween(100, 2000));
                equalTo(List.of("2020-01-01T00:00Z", "2021-01-01T00:00Z"))
        logger.debug("Aggregable date is searchable {}", aggregableDateIsSearchable);
                .hardBounds(new LongBounds("2017-02-03", "2020-01-01"))
                    }
                // Create date histogram with terms sub-aggregation
            false  
                assertEquals(2, bucket.getDocCount());
            histogram -> {
            throw new UnsupportedOperationException();
                assertEquals("2017-02-01T10:00:00.000Z", bucket.getKeyAsString());
                doc.add(SortedNumericDocValuesField.indexedField(AGGREGABLE_DATE, timestamp));
                "2017-02-01T14:05:00.000Z",  
            () -> testSearchCase(
            assertThat(  
                Histogram.Bucket bucket = buckets.get(0);  
            supportsIntraSegmentSearch(  
            false  
                assertEquals(1, bucket.getDocCount());  
            IllegalArgumentException.class,  
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                bucket = buckets.get(2);  
                    aggregator.context().bigArrays(),
                bucket = buckets.get(1);  
                assertEquals(3, bucket2015.getDocCount());
                doc.add(SortedNumericDocValuesField.indexedField(AGGREGABLE_DATE, timestamp));
                    document.add(new NumericDocValuesField(DocCountFieldMapper.NAME, 5));
            false,
        Consumer<InternalDateHistogram> verify,
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            histogram -> {  
            foo.add(DATASET.get(randomIntBetween(0, DATASET.size() - 1)));
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2017-01-01T09:00:00.000Z"), asLong("2017-02-01T14:04:01.000Z")),  
                aggregation -> aggregation.calendarInterval(DateHistogramInterval.DAY)  
        );  
                assertEquals(3, bucket.getDocCount());
                assertEquals(3, bucket.getDocCount());  
                bucket = buckets.get(3);
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());
            histogram -> assertEquals(0, histogram.getBuckets().size()),  
            aggregation -> aggregation.calendarInterval(DateHistogramInterval.YEAR).field(AGGREGABLE_DATE).minDocCount(1L),  
        e = expectThrows(  
                assertEquals(expected, bucket.getDocCount());
        );
    }
                ),  
        Consumer<DateHistogramAggregationBuilder> configure,
                            Document document = new Document();
            "2017-02-01T00:00:05.015Z",  
    }
            () -> testSearchCase(  
                assertEquals(1, bucket.getDocCount());
                bucket = buckets.get(2);
 * You may obtain a copy of the License at  
    protected CountingAggregator createCountingAggregator(  
                    long instant = asLong(date, fieldType);
                "2017-02-01T13:06:00.000Z",
        Query query = LongPoint.newRangeQuery(SEARCHABLE_DATE, asLong("2017-02-01T00:00:00.000Z"), asLong("2017-02-01T00:00:30.000Z"));
    public void testAggregateWrongField() throws IOException {  
                bucket = buckets.get(2);
            "2017-02-01T00:00:21.380Z"
                "2017-02-01T00:00:11.299Z",
    ) throws IOException {
                List<? extends Histogram.Bucket> buckets = histogram.getBuckets();
/*  
                assertEquals("2017-02-01T15:00:00.000Z", bucket.getKeyAsString());
            true
        dataset.put("2017-02-01T15:59:00.000Z", randomIntBetween(100, 2000));
    }
                ak1adh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
    public void testLegacyThenNew() throws IOException {
                "2017-02-01T09:16:42.000Z"
        String categoryField = "category";  
                new MatchAllDocsQuery(),
                bucket = buckets.get(1);
                "2017-02-01T16:06:00.000Z",
 * Modifications Copyright OpenSearch Contributors. See
                    }  
            )
                    reduceBucketConsumer,
                bucket = buckets.get(3);  
            collectorCount -> assertEquals(0, (int) collectorCount),
                    .calendarInterval(DateHistogramInterval.YEAR)
            assertThat(
                assertNotNull("Sub-aggregation should exist for 2016 bucket", bucket2016.getAggregations());  
        );
                expected = dataset.get("2017-02-01T15:59:00.000Z");
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                bucket = buckets.get(3);
                new MatchAllDocsQuery(),
                InternalDateHistogram.Bucket bucket2016 = (InternalDateHistogram.Bucket) histogram.getBuckets().get(1);
                    );  
        // Create index settings with an index sort.
    public void testIntervalHourDeprecated() throws IOException {  
                assertEquals(3, buckets.size());  
            },  
                assertEquals(0, bucket.getDocCount());
    }  
import java.util.HashMap;
    }
        dataset.put("2017-02-01T14:05:00.000Z", 256);
        Query query,  
                assertEquals("2017-02-01T00:00:10.000Z", bucket.getKeyAsString());  
                    configure.accept(aggregationBuilder);  
                );  
                assertEquals("2017-02-01T13:00:00.000Z", bucket.getKeyAsString());  
                bk1bdh.getBuckets().stream().map(bucket -> bucket.getKey().toString()).collect(toList()),
        dataset.put("2017-02-01T15:59:00.000Z", 768);  
            InternalDateHistogram bk1bdh = bk1b.getAggregations().get("dh");
        assertTrue(
import java.time.ZoneId;  
                assertEquals(1, bucket.getDocCount());
                bucket = buckets.get(5);
                assertEquals(2, bucket.getDocCount());  
                "2017-02-01T00:00:11.074Z",
            InternalDateHistogram bdh = b.getAggregations().get("dh");  
            LongPoint.newRangeQuery(AGGREGABLE_DATE, asLong("2016-01-01"), asLong("2017-02-02")),
            }
import org.apache.lucene.search.Query;
                bucket = buckets.get(2);
                assertEquals(1, bucket.getDocCount());  
        "2016-03-04T17:09:50",
                assertEquals("2017-02-01T00:00:00.000Z", bucket.getKeyAsString());  
                assertEquals("2017-02-01T00:00:05.000Z", bucket.getKeyAsString());
                assertEquals(1, bucket.getDocCount());
                    .calendarInterval(DateHistogramInterval.YEAR)
    }
                    document.clear();  
